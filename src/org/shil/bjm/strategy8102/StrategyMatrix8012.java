package org.shil.bjm.strategy8102;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.core.PlayerCards;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerAction;
import org.shil.bjm.meta.PlayerCardsPathValue;
import org.shil.bjm.meta.ProfitUtil;
import org.shil.bjm.meta.StartValue;

public abstract class StrategyMatrix8012 implements Comparable<StrategyMatrix8012>{
	
	protected Map<MatrixKey,PlayerAction> notChangesMatrix;
	protected Map<MatrixKey,PlayerAction> changesMatrix;
	protected Map<MatrixKey,PlayerAction> one;
	
	protected Double roi;
	
	protected StrategyMatrix8012() {
		notChangesMatrix = new HashMap<>();
		changesMatrix = new HashMap<>();
		
//		普通牌
		
		/*
		 * Situation.Start_Hand_WithoutA_WithoutPair [3~8] 
		 * VS
		 * DealerCard  (One ~ K)
		 */
		for(int start = 5; start <= 8 ; start++) {
			for(Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
			}
		}
		
		/*
		 * Situation.Start_Hand_WithoutA_WithoutPair [9~16] 
		 * VS
		 * DealerCard  (One ~ K)
		 */
		for(int start = 9; start <= 16; start++) {
			for(Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
			}
		}
		
		/*
		 * Situation.Start_Hand_WithoutA_WithoutPair [17~21] 
		 * VS
		 * DealerCard  (One ~ K)
		 */
		for(int start = 17; start <= 21 ; start++) {
			for(Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Stand);
			}
		}
		
//		AX牌
		
		/*
		 * Situation.Start_With_A [2~7]
		 */
		for(int start = 2; start <= 7; start++) {
			for(Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_A);
				changesMatrix.put(start_With_A, PlayerAction.Hit);
			}
		}
		
		/*
		 * Situation.Start_With_A [8,9,10]
		 * VS
		 * DealerCard (One ~ K)
		 */
		for(int start = 8; start <= 10; start++) {
			for(Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_A);
				notChangesMatrix.put(start_With_A, PlayerAction.Stand);
			}
		}
		
		//对牌
		
		/*
		 * Situation.Start_With_Pair [2~9]
		 * VS
		 * DealerCard (One ~ K)
		 */
		for(int start = 2; start <= 9; start++) {
			for(Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
				changesMatrix.put(start_With_Pair, PlayerAction.Split);
			}
		}
		
		/*
		 * Situation.Start_With_Pair 10
		 * VS
		 * DealerCard (One ~ K)
		 */
		for(Card dealerCard : Card.values()) {
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			MatrixKey start_With_Pair = new MatrixKey(StartValue.Ten, dealerCard, Situation.Start_With_Pair);
			notChangesMatrix.put(start_With_Pair, PlayerAction.Stand);
		}
		
		/*
		 * Situation.Start_With_Pair 11 or 1
		 * VS
		 * DealerCard (One ~ K)
		 */
		for(Card dealerCard : Card.values()) {
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			MatrixKey start_With_A = new MatrixKey(StartValue.One, dealerCard, Situation.Start_With_Pair);
			changesMatrix.put(start_With_A, PlayerAction.Split);
		}
		
		
//		对牌一次
		
		/*
		 * Situation.Splited_Pair_And_Can_Split [2~9]
		 * VS
		 * DealerCard (One ~ K)
		 */
		for(int start = 2; start <= 9; start++) {
			for(Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				MatrixKey splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
				changesMatrix.put(splited_Pair_And_Can_Split, PlayerAction.Split);
			}
		}
		
		//对牌两次, 同时给了分牌后的普通牌场景
		
		/*
		 * Situation.Splited_Pair_And_Can_NOT_Split [4~8]
		 * VS
		 * DealerCard (One ~ K)
		 */
		for(int start = 4; start <= 8; start++) {
			for(Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				MatrixKey splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				notChangesMatrix.put(splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
			}
		}
		
		
		/*
		 * Situation.Splited_Pair_And_Can_NOT_Split [9~16] 
		 * VS
		 * DealerCard  (One ~ K)
		 */
		for(int start = 9; start <= 16; start++) {
			for(Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				MatrixKey splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
			}
		}
		
		/*
		 * Situation.Splited_Pair_And_Can_NOT_Split [17~21] 
		 * VS
		 * DealerCard  (One ~ K)
		 */
		for(int start = 17; start <= 21 ; start++) {
			for(Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				MatrixKey splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				notChangesMatrix.put(splited_Pair_And_Can_NOT_Split, PlayerAction.Stand);
			}
		}
		
		
//		两张牌以上不能投降时
		
		/*
		 * Situation.Three_More_Cards [6~11] 
		 * VS
		 * DealerCard  (One ~ K)
		 */
		for(int start = 6; start <= 11 ; start++) {
			for(Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				MatrixKey three_More_Cards = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Three_More_Cards);
				notChangesMatrix.put(three_More_Cards, PlayerAction.Hit);
			}
		}
		
		/*
		 * Situation.Three_More_Cards [12~16] 
		 * VS
		 * DealerCard  (One ~ K)
		 */
		for(int start = 12; start <= 16; start++) {
			for(Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				MatrixKey three_More_Cards = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(three_More_Cards, PlayerAction.Hit);
			}
		}
		
		/*
		 * Situation.Three_More_Cards [17~21] 
		 * VS
		 * DealerCard  (One ~ K)
		 */
		for(int start = 17; start <= 21 ; start++) {
			for(Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				MatrixKey three_More_Cards = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Three_More_Cards);
				notChangesMatrix.put(three_More_Cards, PlayerAction.Stand);
			}
		}
		
		//should be hashmap , try to use treemap , the key is collision , then size is not right
		one = new HashMap<>();
		one.putAll(changesMatrix);
		one.putAll(notChangesMatrix);
	}
	
	protected StrategyMatrix8012(Map<MatrixKey,PlayerAction> notChangesMatrix,Map<MatrixKey,PlayerAction> changesMatrix){
		this.notChangesMatrix = notChangesMatrix;
		this.changesMatrix = changesMatrix;
		this.one = new HashMap<>();
		one.putAll(changesMatrix);
		one.putAll(notChangesMatrix);
		this.roi = null;
	}

	public Map<MatrixKey, PlayerAction> getNotChangesMatrix() {
		return notChangesMatrix;
	}

	public Map<MatrixKey, PlayerAction> getChangesMatrix() {
		return changesMatrix;
	}

	public Map<MatrixKey, PlayerAction> getOne() {
		return one;
	}
	
	public List<Result> getChangeMatrxByList(){
		List<Result> changeResults = new LinkedList<>();
		for(Entry<MatrixKey, PlayerAction> e : changesMatrix.entrySet()) {
			changeResults.add(new Result(e.getKey(), e.getValue()));
		}
		Collections.sort(changeResults);
		return changeResults;
	}
	
	public abstract StrategyMatrix8012 evolve();
	
	public double getROI() {
		if(this.roi==null) {
			double roi = 0;
			Collection<PlayerCardsPathValue> playerCards = PlayerCards.generateTwoStartCards();
	//		Collection<PlayerCardsPathValue> playerCards = PlayerCards.generatePairs();
	//		Collection<PlayerCardsPathValue> playerCards = PlayerCards.sortedOneValueStartCardsWithA();
	//		Collection<PlayerCardsPathValue> playerCards = PlayerCards.generateTwoStartCardsWithoutPairWithoutA();
			for(PlayerCardsPathValue pcpv : playerCards){
				double xoi = 0;
	//			System.out.println("Player: " +pcpv.getCards());
				for(Card dealerCard : Card.values()){
					PlayerCardsPathValue oneCalc = new PlayerCardsPathValue(pcpv);
					Collection<PlayerCardsPathValue> oneSet = Strategy8012.generatePlayerCardsPaths(this, oneCalc, dealerCard);
	//				System.out.println(dealerCard+" : " + oneSet.size());
					for(PlayerCardsPathValue one : oneSet){
						double oroi = 0;
	//					oroi = ProfitUtil.oldFashionWayMoneyCalcOneHandInReturn(one, dealerCard);
						oroi = ProfitUtil.moneyCalcOneHandInReturn(one, dealerCard);
						roi+=oroi;
						xoi+=oroi;
	//					if(pcpv.isStartWithPairs() && pcpv.getCards().get(0) == Card.One1){
	//						System.out.println(one);
	//					}
					}
				}
//			System.out.println(" xoi: " + xoi);
			}
//			System.out.println("\nFinally: " + roi);
			this.roi = roi;
		}
		return roi;
	}

	@Override
	public int compareTo(StrategyMatrix8012 o) {
		if(this.getROI() > o.getROI()) {
			return -1;
		}else if(this.getROI() < o.getROI()) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("StrategyMatrix8012 [roi=");
		sb.append(roi);
		sb.append("\nchangeMatrix = ");
		for(Result r: getChangeMatrxByList()) {
			sb.append("\n");
			sb.append(r);
		}
		sb.append("\n");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((one == null) ? 0 : one.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StrategyMatrix8012 other = (StrategyMatrix8012) obj;
		if (one == null) {
			if (other.one != null)
				return false;
		} else if (!one.equals(other.one))
			return false;
		return true;
	}
	
	
}
