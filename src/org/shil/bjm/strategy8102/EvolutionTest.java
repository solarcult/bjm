package org.shil.bjm.strategy8102;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class EvolutionTest {
	
	static int generation = 1000;
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
			System.out.println(Calendar.getInstance().getTime() +" this is generation : "+i +" evos size: " + evos.size());
			
			evos = evoluationOnceMultiCPU(evos);
			
//			for(StrategyMatrix8012 e : evos) {
//				HelloWorld.print(e.getChangeMatrxByList());
//			}
		}

		writeToDisk(evos);
	}
	
	public static void writeToDisk(List<StrategyMatrix8012> evos){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMMMM-dd_HH.mm.ss");
		String fileName=sdf.format(Calendar.getInstance().getTime())+"_blackjack.txt";
		try {
			BufferedWriter out=new BufferedWriter(new FileWriter(fileName,true));
			out.write(Calendar.getInstance().getTime().toString());
			out.newLine();
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
			int length = popluation/2;
			for(int i=0; i < length; i++) {
				CompletableFuture<StrategyMatrix8012> completableFuture = CompletableFuture.supplyAsync(()->{
					StrategyMatrix8012 evo = sm.evolve();
					evo.getROI();
					matrixs.add(evo);
					return evo;
				});
				
				guess.add(completableFuture);
			}
		}
		System.out.println("start guess: " + guess.size());
		
		CompletableFuture<Void> all = CompletableFuture.allOf(guess.toArray(new CompletableFuture[guess.size()]));
		all.join();

		System.out.println(Calendar.getInstance().getTime() +" guess done. ");
		Collections.sort(matrixs);
		
		List<StrategyMatrix8012> result = new ArrayList<>();
		int length = (popluation > matrixs.size()) ? matrixs.size() : popluation;
		for(int i = 0; i < length; i++) {
			result.add(matrixs.get(i));
		}
		System.out.println(result.get(0).getROI());
		System.out.println(result.get(result.size()-1).getROI());
		System.out.println(Calendar.getInstance().getTime() + " result: " + result.size());
		return result;
	}
}
