package org.shil.bjm.strategy8102;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.meta.FileUtil;
import org.shil.bjm.strategy8102.strategy.StrategyMatrix8012;
import org.shil.bjm.strategy8102.strategy.test.Finally2049;

public class EvolutionParetoFrontTest {

	static int write2disk = 10;
	static int print2screen = 5;
	static int generation = 25000;
	static int popluation = Runtime.getRuntime().availableProcessors()/2 ;
	static int producePopluation = popluation/2;
	
	public static void main(String[] args) {
		
		List<StrategyMatrix8012> evos = new ArrayList<>();
		
		StrategyMatrix8012 origin = new Finally2049();
		evos.add(origin);
		

		for(int i = 1; i <= generation; i++) {
			try {
				System.out.println(Calendar.getInstance().getTime() +" this is generation : "+i +" evos size: " + evos.size());
				
				evos = null;
				
				if(i % print2screen == 0) {
					HelloWorld.printStrategyMatrix8012(evos.get(0),evos.get(evos.size()-1));
				}
				if(EvolutionOneWayTest.debug) System.out.println(Calendar.getInstance().getTime() + " for done");
			}catch(Exception e) {
				e.printStackTrace();
			}

			if(i % write2disk == 0) {
				FileUtil.writeToDisk(i,evos);
			}
		}

		FileUtil.writeToDisk(generation,evos);
	}

	public static List<StrategyMatrix8012> reproduction(List<StrategyMatrix8012> origins){
		//calc the best cpu runing job,可以正好把CPU用光，不多不少，如果没算错的话
		int total = origins.size() + origins.size() *  producePopluation;
		if(total/Runtime.getRuntime().availableProcessors() > 0) {
			//如果最后一波的计算CPU利用率没有超过CPU的一半，就不要算这些数据了，将总数据减少到正好用光CPU
			if(total % Runtime.getRuntime().availableProcessors() < Runtime.getRuntime().availableProcessors()/2 ) {
				total = (total/Runtime.getRuntime().availableProcessors()) * Runtime.getRuntime().availableProcessors();
			}
		}
		List<CompletableFuture<Void>> lotOfCpuS = new ArrayList<>(total);
		List<StrategyMatrix8012> reproductions = new ArrayList<>(total);
		
		for(StrategyMatrix8012 sm : origins) {
			if(total <= 0) break;
			//put the best from past generation in competions list，把原始的个体放入，此处应该不用重新计算
			if(!reproductions.contains(sm)) {
				if(total-- <= 0) break;
				CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
					reproductions.add(sm);
					sm.getEverythingInOneLoop();
				});
				lotOfCpuS.add(completableFuture);
			}
			//开始繁殖
			for(int i=0; i < producePopluation; i++) {
				if(total-- <= 0) break;
				CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
					StrategyMatrix8012 evo = sm.evolve();
					if(reproductions.contains(evo)) {
						return ;
					}
					sm.getEverythingInOneLoop();
					reproductions.add(evo);
				});
				lotOfCpuS.add(completableFuture);
			}
		}
		System.out.println("start guess: " + lotOfCpuS.size());
		
		CompletableFuture<Void> all = CompletableFuture.allOf(lotOfCpuS.toArray(new CompletableFuture[lotOfCpuS.size()]));
		all.join();
		
		return reproductions;
	}
	
	public static List<StrategyMatrix8012> findParetoFront(List<StrategyMatrix8012> reproductions){
		List<StrategyMatrix8012> paretoFronts = new ArrayList<>();
		for(StrategyMatrix8012 one : reproductions) {
			boolean beDominationed = false;
			for(StrategyMatrix8012 front : paretoFronts) {
				if(front.getProbRate()[0] > one.getProbRate()[0]
					&& front.getTimeRates()[0] > one.getTimeRates()[0]
					&& front.getROI() > one.getROI()) {
					//Front里面某个点每一点都优于它,则忽略
					beDominationed = true;
					break;
				}
			}
			//Front里面的点domination这个点,忽略这个个体
			if(beDominationed) continue;
			
			for(StrategyMatrix8012 two : reproductions) {
				if(one.equals(two)) continue; //自己忽略掉自己
				if(paretoFronts.contains(two)) {
					//之前已经计算过了
					continue;
				}
				if(two.getProbRate()[0] > one.getProbRate()[0]
						&& two.getTimeRates()[0] > one.getTimeRates()[0]
						&& two.getROI() > one.getROI()) {
						//two这个点每一点都优于one,放弃one
						beDominationed = true;
						break;
					}
			}
			//有个点domination这个点,忽略这个个体
			if(beDominationed) continue;
			
			//到此,则说明没有任何点domination这个点,这个点的某个值不比所有值差，就是好于等于
			paretoFronts.add(one);
		}
		
		return paretoFronts;
	}
	
}
