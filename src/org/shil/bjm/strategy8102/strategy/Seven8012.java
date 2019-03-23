package org.shil.bjm.strategy8102.strategy;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.FileUtil;
import org.shil.bjm.meta.PlayerAction;

/**
 * 进化打牌方案类，带有evolve()进化函数,LOL
 * @author vanis
 *
 */
public class Seven8012 extends StrategyMatrix8012 {
	
	/*
	 * 每一个打牌因子的变异率
	 */
	protected int changePrecent = 1;
	/*
	 * 变异基数
	 */
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
				//每一个打牌的决定方案都有变异率哦
				if(sr.nextInt(totalPrecent) < changePrecent) {
					//change action by random include
					MatrixKey key = e.getKey();
					if(key.getSituation() == Situation.Start_Hand_WithoutA_WithoutPair) {
						if(key.getDealerCard() == Card.One1) {
							changesMatrix.put(e.getKey(), PlayerAction.randomStartWithoutPairActionVSDealerA());
						}else {
							changesMatrix.put(e.getKey(), PlayerAction.randomStartWithoutPairAction());
						}
					}else if(key.getSituation() == Situation.Start_With_A) {
						if(key.getDealerCard() == Card.One1) {
							changesMatrix.put(e.getKey(), PlayerAction.randomStartWithoutPairActionVSDealerA());
						}else {
							changesMatrix.put(e.getKey(), PlayerAction.randomStartWithoutPairAction());
						}
					}else if(key.getSituation() == Situation.Three_More_Cards) {
						changesMatrix.put(e.getKey(), PlayerAction.randomThreeCardsAction());
					}else if(key.getSituation() == Situation.Start_With_Pair) {
						if(key.getDealerCard() == Card.One1) {
							changesMatrix.put(e.getKey(), PlayerAction.randomStartWithPairActionVSDealerA());
						}else {
							changesMatrix.put(e.getKey(), PlayerAction.randomStartWithPairAction());
						}
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
		
//		System.out.println(one.getROI());
		
//		int count = 0 ;
//		for(Entry<MatrixKey,PlayerAction> e: one.getOne().entrySet()) {
//			if(e.getValue() != two.getOne().get(e.getKey())) {
//				count++;
//			}
//		}
		
//		System.out.println(count);
//		System.out.println(Math.pow(4, two.getChangesMatrix().size()));
		
//		HelloWorld.print(one.getChangeMatrxByList());
		List<StrategyMatrix8012> oks = new ArrayList<>();
		oks.add(one);
		System.out.println(oks.contains(two));
		oks.add(two);
		System.out.println(oks.contains(one));
		oks.add(two.evolve());
		oks.add(new Standard2017());
		
		System.out.println(FileUtil.analyzeEvos(oks).toString());
	}
}
