package org.shil.bjm.strategy8102;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.shil.bjm.meta.PlayerAction;

public class Seven8012 extends StrategyMatrix8012 {
		
	protected int changePrecent = 6;
	
	protected int totalPrecent = 100;
	
	public Seven8012() {
		super();
	}
	
	public Seven8012(Map<MatrixKey,PlayerAction> notChangesMatrix,Map<MatrixKey,PlayerAction> changesMatrix) {
		super(notChangesMatrix,changesMatrix);
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
		
		return new Seven8012(this.getNotChangesMatrix(),changesMatrix);
	}
	
	
	public static void main(String[] args) {
		StrategyMatrix8012 one = new Seven8012();
		StrategyMatrix8012 two = one.evolve();
		System.out.println(one.getChangesMatrix().size());
		System.out.println(two.getChangesMatrix().size());
		System.out.println(two.getNotChangesMatrix().size());
		System.out.println(one.getOne().size());
		System.out.println(two.getOne().size());
		
		System.out.println(one.getROI());
		
//		int count = 0 ;
//		for(Entry<MatrixKey,PlayerAction> e: one.getOne().entrySet()) {
//			if(e.getValue() != two.getOne().get(e.getKey())) {
//				count++;
//			}
//		}
		
//		System.out.println(count);
//		System.out.println(Math.pow(4, two.getChangesMatrix().size()));
		
//		HelloWorld.print(one.getChangeMatrxByList());
	}
}
