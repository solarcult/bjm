package org.shil.bjm.strategy8102;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.shil.bjm.meta.FileUtil;

public class EvolutionTest {
	
	static int write2disk = 50;
	static int generation = 25000;
	static int popluation = Runtime.getRuntime().availableProcessors()/2 ;

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
				
				evos = evoluationOnceMultiCPU(evos);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			if(i % write2disk == 0) {
				FileUtil.writeToDisk(i,evos);
			}
		}

		FileUtil.writeToDisk(generation,evos);
	}
	
	public static List<StrategyMatrix8012> evoluationOnceMultiCPU(List<StrategyMatrix8012> origins) {
		
		List<CompletableFuture<StrategyMatrix8012>> guess = new ArrayList<>();
		List<StrategyMatrix8012> competions = new ArrayList<>();
		for(StrategyMatrix8012 sm : origins) {
			//put the best from past generation in competions list 
			if(!competions.contains(sm)) {
				competions.add(sm);
			}
			for(int i=0; i < popluation/2; i++) {
				CompletableFuture<StrategyMatrix8012> completableFuture = CompletableFuture.supplyAsync(()->{
					StrategyMatrix8012 evo = sm.evolve();
					if(origins.contains(evo)) {
						return null;
					}
//					evo.getROI();
					evo.getWdlRateWithDS();
					
					competions.add(evo);
					return evo;
				});
				if(completableFuture!=null) {
					guess.add(completableFuture);
				}
			}
		}
		System.out.println("start guess: " + guess.size());
		
		CompletableFuture<Void> all = CompletableFuture.allOf(guess.toArray(new CompletableFuture[guess.size()]));
		all.join();

//		Collections.sort(competions,new Matrix8102ROIComparator());
		Collections.sort(competions,new Matrix8102WinRateDSComparator());
//		Collections.sort(competions,new Matrix8102WinRateDSProbComparator());
		
		List<StrategyMatrix8012> result = new ArrayList<>();
		int length = (popluation > competions.size()) ? competions.size() : popluation;
		for(int i = 0; i < length; i++) {
			result.add(competions.get(i));
		}
		System.out.println(result.get(0).getCalcResult());
		System.out.println(result.get(result.size()-1).getCalcResult());
		return result;
	}
}
