package org.shil.bjm.strategy8102;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.meta.FileUtil;
import org.shil.bjm.strategy8102.comparator.Matrix8102ROIComparator;
import org.shil.bjm.strategy8102.comparator.Matrix8102WinRateDSComparator;
import org.shil.bjm.strategy8102.comparator.Matrix8102WinRateDSProbComparator;
import org.shil.bjm.strategy8102.comparator.Matrix8102WinRateDSbyRawComparator;

public class EvolutionTest {
	
	static int write2disk = 30;
	static int generation = 25000;
	static int popluation = Runtime.getRuntime().availableProcessors()/2 ;
	static int producePopluation = popluation/2;
	public static boolean debug = false;
	
	static int CalcType = 4;

	public static void main(String[] args) {
		
		List<StrategyMatrix8012> evos = new ArrayList<>();
		
		StrategyMatrix8012 origin = new Standard2017();
//		StrategyMatrix8012 origin = new Seven8012();
//		for(int i = 1; i <= popluation; i++) 
//		{
//			StrategyMatrix8012 origin = new RandomGenMatrix();
//			evos.add(origin);
//		}
		evos.add(origin);

		for(int i = 1; i <= generation; i++) {
			try {
				System.out.println(Calendar.getInstance().getTime() +" this is generation : "+i +" evos size: " + evos.size());
				
				evos = evoluationOnceMultiCPU(evos,CalcType);
				
				if(i % 10 == 0) {
					HelloWorld.printStrategyMatrix8012(evos.get(0), evos.get(evos.size()-1));
				}
				if(debug) System.out.println(Calendar.getInstance().getTime() + " for done");
			}catch(Exception e) {
				e.printStackTrace();
			}

			if(i % write2disk == 0) {
				FileUtil.writeToDisk(i,evos);
			}
		}

		FileUtil.writeToDisk(generation,evos);
	}
	
	public static List<StrategyMatrix8012> evoluationOnceMultiCPU(List<StrategyMatrix8012> origins,int type) {
		
		List<CompletableFuture<Void>> guess = new ArrayList<>();
		List<StrategyMatrix8012> competions = new ArrayList<>();
		//calc the best cpu runing job
		int total = origins.size() + origins.size() *  producePopluation;
		if(total/Runtime.getRuntime().availableProcessors() > 0) {
			if(total % Runtime.getRuntime().availableProcessors() < Runtime.getRuntime().availableProcessors()/2 ) {
				total = (total/Runtime.getRuntime().availableProcessors()) * Runtime.getRuntime().availableProcessors() -1;
			}
		}
		
		for(StrategyMatrix8012 sm : origins) {
			if(total <= 0) break;
			//put the best from past generation in competions list 
			if(!competions.contains(sm)) {
				if(total-- <= 0) break;
				CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
					competions.add(sm);
					switch(type) {
						case 1:
							sm.getROI();
							break;
						case 2:
							sm.getWdlRateWithDS();
							break;
						case 3:
							sm.getWdlRateWithDSWithProb();
							break;
						case 4:
							sm.getWdlRateWithDSbyRaw();
							break;
						default :
							throw new RuntimeException("wow who am i?");
					}
				});
				guess.add(completableFuture);
			}
			for(int i=0; i < producePopluation; i++) {
				if(total-- <= 0) break;
				CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
					StrategyMatrix8012 evo = sm.evolve();
					if(competions.contains(evo)) {
						return ;
					}
					
					switch(type) {
						case 1:
							evo.getROI();
							break;
						case 2:
							evo.getWdlRateWithDS();
							break;
						case 3:
							evo.getWdlRateWithDSWithProb();
							break;
						case 4:
							sm.getWdlRateWithDSbyRaw();
							break;
						default :
							throw new RuntimeException("wow who am i?");
					}
					competions.add(evo);
				});
				guess.add(completableFuture);
			}
		}
		System.out.println("start guess: " + guess.size());
		
		CompletableFuture<Void> all = CompletableFuture.allOf(guess.toArray(new CompletableFuture[guess.size()]));
		all.join();
		if(debug) System.out.println(Calendar.getInstance().getTime() + " before sort");
		
		switch(type) {
			case 1:
				Collections.sort(competions,new Matrix8102ROIComparator());
				break;
			case 2:
				Collections.sort(competions,new Matrix8102WinRateDSComparator());
				break;
			case 3:
				Collections.sort(competions,new Matrix8102WinRateDSProbComparator());
				break;
			case 4:
				Collections.sort(competions,new Matrix8102WinRateDSbyRawComparator());
				break;
			default :
				throw new RuntimeException("wow who am i?");
		}
		
		if(debug) System.out.println(Calendar.getInstance().getTime() + " after sort");
		List<StrategyMatrix8012> result = new ArrayList<>();
		int pop = (popluation > competions.size()) ? competions.size() : popluation;
		int length = pop;
		int multi = pop / Runtime.getRuntime().availableProcessors();
		if(multi>0) {
			//save cpu resource don't have few cpu fulltime calc and most of cpu is idle.
			length = Runtime.getRuntime().availableProcessors() * multi -2;
		}
		
		for(int i = 0; i < length; i++) {
			result.add(competions.get(i));
		}
		if(debug) System.out.println(Calendar.getInstance().getTime() + " finsih return");
		return result;
	}
}
