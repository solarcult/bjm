package org.shil.bjm.strategy8102;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class EvolutionTest {
	
	static int generation = 100;
	static int popluation = Runtime.getRuntime().availableProcessors()/2 ;

	public static void main(String[] args) {
		
		List<StrategyMatrix8012> evos = new ArrayList<>();
		
		StrategyMatrix8012 origin = new Seven8012();
		evos.add(origin);
		
//		System.out.println("s");
//		long start = System.currentTimeMillis();
//		
//		origin.evolve().getROI();
//		System.out.println("e :");
//		System.out.println(System.currentTimeMillis() - start);
		
		for(int i = 0; i < generation; i++) {
			System.out.println(Calendar.getInstance().getTime() +" start generation: "+i +" evos size: " + evos.size());
			
			evos = evoluationOnceMultiCPU(evos);
			
//			for(StrategyMatrix8012 e : evos) {
//				HelloWorld.print(e.getChangeMatrxByList());
//			}
		}

		writeToDisk(evos);
	}
	
	public static void writeToDisk(List<StrategyMatrix8012> evos){
		
		String fileName="blackjack.txt";
		try {
			BufferedWriter out=new BufferedWriter(new FileWriter(fileName,true));

			for(StrategyMatrix8012 e : evos) {
				out.write(e.toString());
				out.newLine();
			}
			
			out.flush();
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<StrategyMatrix8012> evoluationOnceMultiCPU(List<StrategyMatrix8012> origins) {
		
		List<CompletableFuture<StrategyMatrix8012>> guess = new ArrayList<>();
		List<StrategyMatrix8012> matrixs = new ArrayList<>();
		for(StrategyMatrix8012 sm : origins) {
			for(int i=0;i<popluation;i++) {
				CompletableFuture<StrategyMatrix8012> completableFuture = CompletableFuture.supplyAsync(()->{
					StrategyMatrix8012 evo = sm.evolve();
					evo.getROI();
					matrixs.add(evo);
					return evo;
				});
				
				guess.add(completableFuture);
			}
		}
		System.out.println("guess: " + guess.size());
		
		CompletableFuture<Void> all = CompletableFuture.allOf(guess.toArray(new CompletableFuture[guess.size()]));
		all.join();
//		System.out.println("join done"+guess.size());
		Collections.sort(matrixs);
		System.out.println("matrixs: " + matrixs.size());
		System.out.println(matrixs.get(0).getROI());
		System.out.println(matrixs.get(matrixs.size()-1).getROI());
		List<StrategyMatrix8012> result = new ArrayList<>();
		for(int i = 0; i <popluation; i++) {
			result.add(matrixs.get(i));
		}
		System.out.println("result: " + result.size());
		return result;
	}
}
