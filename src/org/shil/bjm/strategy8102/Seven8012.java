package org.shil.bjm.strategy8102;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.meta.PlayerAction;

public class Seven8012 extends StrategyMatrix8012 {
	
	private int evolveSpecies = 1024;
	
	private int changePrecent = 2;
	
	private int totalPrecent = 100;
	
	public Seven8012() {
		super();
	}
	
	public Seven8012(StrategyMatrix8012 strategyMatrix8012,Map<MatrixKey,PlayerAction> changesMatrix) {
		super(strategyMatrix8012,changesMatrix);
	}
	
	
	public StrategyMatrix8012 evolve() {
		Map<MatrixKey,PlayerAction> changesMatrix = new HashMap<>();
		try {
			SecureRandom sr = SecureRandom.getInstanceStrong();
			for(Entry<MatrixKey,PlayerAction> e : getChangesMatrix().entrySet()) {
				if(sr.nextInt(totalPrecent) < changePrecent) {
					//change action by random include
					MatrixKey key = e.getKey();
					if(key.getSituation() == Situation.Start_Hand_WithoutA_WithoutPair) {
						changesMatrix.put(e.getKey(), PlayerAction.randomStartWithoutPairAction());
					}else if(key.getSituation() == Situation.Start_With_A) {
						changesMatrix.put(e.getKey(), PlayerAction.randomStartWithoutPairAction());
					}else if(key.getSituation() == Situation.Three_More_Cards) {
						changesMatrix.put(e.getKey(), PlayerAction.randomThreeCardsAction());
					}else if(key.getSituation() == Situation.Start_With_Pair) {
						changesMatrix.put(e.getKey(), PlayerAction.randomStartWithPairAction());
					}else if(key.getSituation() == Situation.Splited_Pair_And_Can_Split) {
						changesMatrix.put(e.getKey(), PlayerAction.randomSplitedPairAndCanSplitAction());
					}else if(key.getSituation() == Situation.Splited_Pair_And_Can_NOT_Split) {
						changesMatrix.put(e.getKey(), PlayerAction.randomSplitedPairAndCanNotSplittAction());
					}
				}else {
					//no change
					changesMatrix.put(e.getKey(),e.getValue());
				}
			}
		}catch(Exception e) {
			throw new RuntimeException("This random has problem! "+e.getMessage());
		}
		
		return new Seven8012(this,changesMatrix);
	}
	
	public List<StrategyMatrix8012> evolveSpecies(){
		List<StrategyMatrix8012> evolves = new ArrayList<>(evolveSpecies);
		for(int i=0;i<this.evolveSpecies;i++) {
			evolves.add(this.evolve());
		}
		return evolves;
	}
	
	public static void main(String[] args) {
		StrategyMatrix8012 one = new Seven8012();
		StrategyMatrix8012 two = one.evolve();
		System.out.println(one.getChangesMatrix().size());
		System.out.println(two.getChangesMatrix().size());
		System.out.println(one.getOne().size());
		System.out.println(two.getOne().size());
		
		int count = 0 ;
		for(Entry<MatrixKey,PlayerAction> e: one.getOne().entrySet()) {
			if(e.getValue() != two.getOne().get(e.getKey())) {
				count++;
			}
		}
		
		System.out.println(count);
		
//		HelloWorld.print(one.getChangeMatrxByList());
	}
}
