package org.shil.bjm.strategy8102;

import java.util.HashMap;
import java.util.Map;

import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerAction;
import org.shil.bjm.meta.StartValue;

public abstract class StrategyMatrix8012 {
	
	Map<MatrixKey,PlayerAction> notChangesMatrix;
	Map<MatrixKey,PlayerAction> changesMatrix;
	Map<MatrixKey,PlayerAction> one;
	
	StrategyMatrix8012() {
		notChangesMatrix = new HashMap<>();
		
		/*
		 * Situation.Start_Hand_WithoutA_WithoutPair (3~8) 
		 * VS
		 * DealerCard  (One ~ K)
		 */
		for(int start = 3; start <= 8 ; start++) {
			for(Card dealerCard : Card.values()) {
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
			}
		}
		/*
		 * Situation.Start_With_A 8,9,10
		 * VS
		 * DealerCard (One ~ K)
		 */
		for(int start = 8; start <= 10; start++) {
			for(Card dealerCard : Card.values()) {
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_A);
				notChangesMatrix.put(start_With_A, PlayerAction.Stand);
			}
		}
		
		
		/*
		 * Situation.Three_More_Cards (3~8) 
		 * VS
		 * DealerCard  (One ~ K)
		 */
		for(int start = 3; start <= 8 ; start++) {
			for(Card dealerCard : Card.values()) {
				MatrixKey three_More_Cards = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Three_More_Cards);
				notChangesMatrix.put(three_More_Cards, PlayerAction.Hit);
			}
		}
		
		changesMatrix = new HashMap<>();
		/**
		 * Situation.Start_With_A (1~7)
		 */
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
