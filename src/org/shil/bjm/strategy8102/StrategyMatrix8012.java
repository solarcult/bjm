package org.shil.bjm.strategy8102;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerAction;
import org.shil.bjm.meta.StartValue;

public abstract class StrategyMatrix8012 {
	
	Map<MatrixKey,PlayerAction> notChangesMatrix;
	Map<MatrixKey,PlayerAction> changesMatrix;
	Map<MatrixKey,PlayerAction> one;
	
	protected StrategyMatrix8012() {
		notChangesMatrix = new HashMap<>();
		changesMatrix = new HashMap<>();
		
//		普通牌
		
		/*
		 * Situation.Start_Hand_WithoutA_WithoutPair [3~8] 
		 * VS
		 * DealerCard  (One ~ K)
		 */
		for(int start = 4; start <= 8 ; start++) {
			for(Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
			}
		}
		
		/*
		 * Situation.Start_Hand_WithoutA_WithoutPair [9~17] 
		 * VS
		 * DealerCard  (One ~ K)
		 */
		for(int start = 9; start <= 17; start++) {
			for(Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
			}
		}
		
		/*
		 * Situation.Start_Hand_WithoutA_WithoutPair [18~21] 
		 * VS
		 * DealerCard  (One ~ K)
		 */
		for(int start = 18; start <= 21 ; start++) {
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
		
		/*
		 * Situation.Start_With_A 11 or 1
		 * VS
		 * DealerCard (One ~ K)
		 */
		for(Card dealerCard : Card.values()) {
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			MatrixKey start_With_A = new MatrixKey(StartValue.One, dealerCard, Situation.Start_With_A);
			changesMatrix.put(start_With_A, PlayerAction.Hit);
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
		
		//对牌两次
		
		/*
		 * Situation.Splited_Pair_And_Can_NOT_Split [2~9]
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
		 * Situation.Splited_Pair_And_Can_NOT_Split [9~17] 
		 * VS
		 * DealerCard  (One ~ K)
		 */
		for(int start = 9; start <= 17; start++) {
			for(Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				MatrixKey splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
			}
		}
		
		/*
		 * Situation.Splited_Pair_And_Can_NOT_Split [18~21] 
		 * VS
		 * DealerCard  (One ~ K)
		 */
		for(int start = 18; start <= 21 ; start++) {
			for(Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				MatrixKey splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				notChangesMatrix.put(splited_Pair_And_Can_NOT_Split, PlayerAction.Stand);
			}
		}
		
		/*
		 * Situation.Splited_Pair_And_Can_NOT_Split 11 or 1
		 * VS
		 * DealerCard (One ~ K)
		 这种情况应该在上层直接设置 Stand
		for(Card dealerCard : Card.values()) {
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.One, dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
			changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
		}
		*/
		
//		两张牌以上不能投降时
		
		/*
		 * Situation.Three_More_Cards [3~8] 
		 * VS
		 * DealerCard  (One ~ K)
		 */
		for(int start = 3; start <= 8 ; start++) {
			for(Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				MatrixKey three_More_Cards = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Three_More_Cards);
				notChangesMatrix.put(three_More_Cards, PlayerAction.Hit);
			}
		}
		
		/*
		 * Situation.Three_More_Cards [9~17] 
		 * VS
		 * DealerCard  (One ~ K)
		 */
		for(int start = 9; start <= 17; start++) {
			for(Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				MatrixKey three_More_Cards = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(three_More_Cards, PlayerAction.Hit);
			}
		}
		
		/*
		 * Situation.Three_More_Cards [18~21] 
		 * VS
		 * DealerCard  (One ~ K)
		 */
		for(int start = 18; start <= 21 ; start++) {
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
	
	protected StrategyMatrix8012(StrategyMatrix8012 strategyMatrix8012,Map<MatrixKey,PlayerAction> changesMatrix){
		this.notChangesMatrix = strategyMatrix8012.notChangesMatrix;
		this.changesMatrix = changesMatrix;
		this.one = new HashMap<>();
		one.putAll(changesMatrix);
		one.putAll(notChangesMatrix);
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
}
