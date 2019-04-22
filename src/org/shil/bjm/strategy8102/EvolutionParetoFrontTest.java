package org.shil.bjm.strategy8102;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.shil.bjm.meta.FileUtil;
import org.shil.bjm.simulation.RealMatch;
import org.shil.bjm.strategy8102.comparator.ParetoComparator;
import org.shil.bjm.strategy8102.strategy.StrategyMatrix8012;
import org.shil.bjm.strategy8102.strategy.practise.Myth2019April13;

public class EvolutionParetoFrontTest {

	static int write2disk = 250;
	static int print2screen = 50;
	static int generation = 25000;
	static int popluation = Runtime.getRuntime().availableProcessors()/2 ;
	static int producePopluation = popluation/2;
	
	public static void main(String[] args) {
		
		List<StrategyMatrix8012> evos = new ArrayList<>();
		
		StrategyMatrix8012 origin = new Myth2019April13();
		evos.add(origin);
		
		//Very important to check below value and understand what its meaning : [0,1,2,3,4,5,6]
		StrategyMatrix8012.paretoFrontType = 4;
		
		String testStrategy = "nice to meet you and good luck. StrategyMatrix8012.paretoFrontValue: "+StrategyMatrix8012.paretoFrontType;
		System.out.println(testStrategy);
		for(int i = 1; i <= generation; i++) {
			try {
				System.out.println(Calendar.getInstance().getTime() +" this is generation : "+i +" evos size: " + evos.size());
				//繁殖
				evos = reproduction(evos);
				//找到帕累托前沿
				evos = findParetoFront(evos);
				//衡量并剪枝
				evos = cutTheList(evos);
				
				//打印出来瞧瞧
				if(i % print2screen == 0) {
					testStrategy = "StrategyMatrix8012.paretoFrontValue : "+ StrategyMatrix8012.paretoFrontType+"\n";
					testStrategy = testStrategy + testSelectedStrategy(evos);
					System.out.println(testStrategy);
				}
				
				if(EvolutionOneWayTest.debug) System.out.println(Calendar.getInstance().getTime() + " for done");
				
			}catch(Exception e) {
				e.printStackTrace();
			}

			if(i % write2disk == 0) {
				FileUtil.writeToDisk(i,evos,testStrategy);
			}
		}

		FileUtil.writeToDisk(generation,evos,testStrategy);
	}
	
	public static String testSelectedStrategy(List<StrategyMatrix8012> evos) {
		if(evos.size()==1) {
			return RealMatch.testSelectedStrategy(evos.get(0));
		}else if(evos.size()==2) {
			return RealMatch.testSelectedStrategy(evos.get(0),evos.get(1));
		}else if(evos.size()==3) {
			return RealMatch.testSelectedStrategy(evos.get(0),evos.get(1),evos.get(2));
		}else if(evos.size()==4) {
			return RealMatch.testSelectedStrategy(evos.get(0),evos.get(1),evos.get(2),evos.get(3));
		}else if(evos.size()>=5) {
			int middle = Math.floorDiv(evos.size(), 2);
			return RealMatch.testSelectedStrategy(evos.get(0),evos.get(Math.floorDiv(middle,2)),evos.get(middle),evos.get(Math.floorDiv(middle,2)+middle),evos.get(evos.size()-1));
		}
		
		return "WTF of testSelectedStrategy, evos.length: " + evos.size();
	}

	static int proccesed = 0;
	static int totalprocessed = 0;
	public static List<StrategyMatrix8012> reproduction(List<StrategyMatrix8012> origins){
		//calc the best cpu runing job,可以正好把CPU用光，不多不少，如果没算错的话
		int total = origins.size() + origins.size() *  producePopluation;
		int multi = total/Runtime.getRuntime().availableProcessors();
		if( multi > 0) {
			//如果最后一波的计算CPU利用率没有超过CPU的一半，就不要算这些数据了，将总数据减少到正好用光CPU
			if(total % Runtime.getRuntime().availableProcessors() < Runtime.getRuntime().availableProcessors()/2 ) {
				total = multi * Runtime.getRuntime().availableProcessors();
			}else {
				//本着把CPU用完的态度.凑个整
				total = (multi+1) * Runtime.getRuntime().availableProcessors();
			}
		}else {
			total = Runtime.getRuntime().availableProcessors();
		}
		totalprocessed = total;
		proccesed = 0;
		List<CompletableFuture<Void>> lotOfCpuS = new ArrayList<>(total);
		List<StrategyMatrix8012> reproductions = new ArrayList<>(total);
		
		for(StrategyMatrix8012 sm : origins) {
			if(total <= 0) break;
			//put the best from past generation in competions list，把原始的个体放入，应该很稀少有重复（只有当其他变异变异出和orgins一样时），同时origins应该不用重新计算相关数据
			if(!reproductions.contains(sm)) {
				if(total-- <= 0) break;
				reproductions.add(sm);
				CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
					sm.getEverythingInOneLoop();
				});
				lotOfCpuS.add(completableFuture);
			}
			//开始繁殖
			for(int i=0; i < producePopluation; i++) {
				if(total-- <= 0) break;
				StrategyMatrix8012 evo = sm.evolve();
				if(reproductions.contains(evo)) {
					//此处可能造成最终没有达到total期望的个体数,没关系
					continue;
				}
				reproductions.add(evo);
				CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
					evo.getEverythingInOneLoop();
					proccesed++;
					if((proccesed) % (Runtime.getRuntime().availableProcessors()/4) == 0) {
						System.out.println(Calendar.getInstance().getTime() + " . has been progrossing : " + proccesed + "/" + reproductions.size());
					}
				});
				lotOfCpuS.add(completableFuture);
			}
			
		}
		
		//补偿机制
		int less = totalprocessed - reproductions.size();
		System.out.println("  first time: " + reproductions.size()+" should patch : "+less);
		int addEveryPF = less / origins.size();
		for(StrategyMatrix8012 o : origins) {
			for(int ad = 0; ad < addEveryPF; ad++) {
				StrategyMatrix8012 evo = o.evolve();
				if(reproductions.contains(evo)) {
					//此处可能造成最终没有达到total期望的个体数,没关系
					continue;
				}
				reproductions.add(evo);
				CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
					evo.getEverythingInOneLoop();
					proccesed++;
					if((proccesed) % (Runtime.getRuntime().availableProcessors()/4) == 0) {
						System.out.println(Calendar.getInstance().getTime() + " . has been progrossing : " + proccesed + "/" + reproductions.size());
					}
				});
				lotOfCpuS.add(completableFuture);
			}
		}
		
		System.out.println("  start guess: " + lotOfCpuS.size());
		
		CompletableFuture<Void> all = CompletableFuture.allOf(lotOfCpuS.toArray(new CompletableFuture[lotOfCpuS.size()]));
		all.join();
		
		return reproductions;
	}
	
	/**
	 * 找到帕累托前沿
	 * 对于不同玩法得到相同值的，作为被占领。
	 * 由于上个方法已经对List做了去重，这个方法就不做了.
	 * @param reproductions
	 * @return
	 */
	public static List<StrategyMatrix8012> findParetoFront(List<StrategyMatrix8012> reproductions){
		List<StrategyMatrix8012> paretoFronts = new ArrayList<>();
		for(StrategyMatrix8012 one : reproductions) {
			boolean beDominationed = false;
			for(StrategyMatrix8012 front : paretoFronts) {
				//多维度用>=,但维度用>,因为会有正好变异了某个特性,但没有影响到效果,造成结果相等的情况.其实多维度,也会有这种情况.
//				if(front.getParetoFrontValue() >= one.getParetoFrontValue()) {
				if(front.getParetoFrontValue() > one.getParetoFrontValue()) {
					//Front里面某个点每一点都优于它,则忽略
					beDominationed = true;
					break;
				}
			}
			//Front里面的点domination这个点,忽略这个个体
			if(beDominationed) continue;
			
			//开始遍历所有个体
			for(StrategyMatrix8012 two : reproductions) {
				if(one.equals(two)) continue; //自己忽略掉自己
				if(paretoFronts.contains(two)) {
					//之前已经计算过了，其实也没有多少计算量
					continue;
				}
				//多维度用>=,但维度用>,因为会有正好变异了某个特性,但没有影响到效果,造成结果相等的情况.其实多维度,也会有这种情况.
//				if(two.getParetoFrontValue() >= one.getParetoFrontValue()) {
				if(two.getParetoFrontValue() > one.getParetoFrontValue()) {
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
		
		System.out.println("ParetoFront size is: " + paretoFronts.size());
		
		return paretoFronts;
	}
	
	public static List<StrategyMatrix8012> cutTheList(List<StrategyMatrix8012> competions) {
		Collections.sort(competions,new ParetoComparator());
		List<StrategyMatrix8012> result = new ArrayList<>();
		int length = (popluation > competions.size()) ? competions.size() : popluation;
		for(int i = 0; i < length; i++) {
			result.add(competions.get(i));
		}
		return result;
	}
	
}
