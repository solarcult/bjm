package org.shil.bjm.strategy8102;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.shil.bjm.HelloWorld;

public class EvolutionTest {
	
	public static List<StrategyMatrix8012> evoluationOnce(List<StrategyMatrix8012> origins){
		List<StrategyMatrix8012> evos = new ArrayList<>();
		for(StrategyMatrix8012 e : origins) {
			evos.add(e);
			for(int i = 0; i<100; i++) {
				evos.add(e.evolve());
			}
		}
		
		Collections.sort(evos);
		
		evos.subList(0, 100);
		return evos;
	}

	public static void main(String[] args) {
		
		List<StrategyMatrix8012> evos = new ArrayList<>();
		
		StrategyMatrix8012 origin = new Seven8012();
		evos.add(origin);
		
		for(int i = 0; i<100; i++) {
			evos = evoluationOnce(evos);
		}
		
		for(StrategyMatrix8012 e : evos) {
			System.out.println(e);
//			HelloWorld.print(e.getChangeMatrxByList());
		}
	}
	
	

}
