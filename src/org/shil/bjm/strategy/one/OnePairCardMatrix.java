package org.shil.bjm.strategy.one;

import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerAction;
import org.shil.bjm.meta.StartValue;
import org.shil.bjm.strategy.PlayerStrategy;
import org.shil.bjm.strategy.PlayerStrategyMatrix;

public class OnePairCardMatrix extends PlayerStrategyMatrix {
	
	public static PlayerStrategyMatrix SELF = new OnePairCardMatrix();
	
	public OnePairCardMatrix(){
		super();
		
		for(StartValue startValue : StartValue.values()){
			if(startValue== StartValue.One){
				for(Card dealerCard : Card.values()){
					if(dealerCard == Card.One1){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy, playerStrategy);
					}else{
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Split,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy, playerStrategy);
					}
				}
			}
		}

		PlayerStrategy playerStrategy22vs5 = new PlayerStrategy(StartValue.getOne(2), Card.Five5, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy22vs5,playerStrategy22vs5);
		PlayerStrategy playerStrategy22vs6 = new PlayerStrategy(StartValue.getOne(2), Card.Six6, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy22vs6,playerStrategy22vs6);
		
		PlayerStrategy playerStrategy33vs5 = new PlayerStrategy(StartValue.getOne(3), Card.Five5, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy33vs5,playerStrategy33vs5);
		PlayerStrategy playerStrategy33vs6 = new PlayerStrategy(StartValue.getOne(3), Card.Six6, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy33vs6,playerStrategy33vs6);

		PlayerStrategy playerStrategy77vs6 = new PlayerStrategy(StartValue.getOne(7), Card.Six6, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy77vs6,playerStrategy77vs6);
		
		PlayerStrategy playerStrategy88vs3 = new PlayerStrategy(StartValue.getOne(8), Card.Three3, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy88vs3,playerStrategy88vs3);
		PlayerStrategy playerStrategy88vs4 = new PlayerStrategy(StartValue.getOne(8), Card.Four4, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy88vs4,playerStrategy88vs4);
		PlayerStrategy playerStrategy88vs5 = new PlayerStrategy(StartValue.getOne(8), Card.Five5, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy88vs5,playerStrategy88vs5);
		PlayerStrategy playerStrategy88vs6 = new PlayerStrategy(StartValue.getOne(8), Card.Six6, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy88vs6,playerStrategy88vs6);
		PlayerStrategy playerStrategy88vs7 = new PlayerStrategy(StartValue.getOne(8), Card.Seven7, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy88vs7,playerStrategy88vs7);
		
		PlayerStrategy playerStrategy99vs2 = new PlayerStrategy(StartValue.getOne(9), Card.Two2, PlayerAction.Split,PlayerAction.Stand);
		strategyMatrix.put(playerStrategy99vs2,playerStrategy99vs2);
		PlayerStrategy playerStrategy99vs3 = new PlayerStrategy(StartValue.getOne(9), Card.Three3, PlayerAction.Split,PlayerAction.Stand);
		strategyMatrix.put(playerStrategy99vs3,playerStrategy99vs3);
		PlayerStrategy playerStrategy99vs4 = new PlayerStrategy(StartValue.getOne(9), Card.Four4, PlayerAction.Split,PlayerAction.Stand);
		strategyMatrix.put(playerStrategy99vs4,playerStrategy99vs4);
		PlayerStrategy playerStrategy99vs5 = new PlayerStrategy(StartValue.getOne(9), Card.Five5, PlayerAction.Split,PlayerAction.Stand);
		strategyMatrix.put(playerStrategy99vs5,playerStrategy99vs5);
		PlayerStrategy playerStrategy99vs6 = new PlayerStrategy(StartValue.getOne(9), Card.Six6, PlayerAction.Split,PlayerAction.Stand);
		strategyMatrix.put(playerStrategy99vs6,playerStrategy99vs6);
		
		PlayerStrategy playerStrategy99vs8 = new PlayerStrategy(StartValue.getOne(9), Card.Eight8, PlayerAction.Split,PlayerAction.Stand);
		strategyMatrix.put(playerStrategy99vs8,playerStrategy99vs8);
	}
}
