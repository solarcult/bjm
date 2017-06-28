package org.shil.bjm.strategy.one;

import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerAction;
import org.shil.bjm.meta.StartValue;
import org.shil.bjm.strategy.PlayerStrategy;
import org.shil.bjm.strategy.PlayerStrategyMatrix;

public class OneSameCardMatrix extends PlayerStrategyMatrix {
	
	public static PlayerStrategyMatrix SELF = new OneSameCardMatrix();
	
	public OneSameCardMatrix(){
		super();
		
		for(StartValue startValue : StartValue.values()){
			if(startValue== StartValue.One){
				for(Card dealerCard : Card.values()){
					if(dealerCard == Card.One1){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy, playerStrategy);
					}else{
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Split,PlayerAction.Split);
						strategyMatrix.put(playerStrategy, playerStrategy);
					}
				}
			}
		}
		
		PlayerStrategy playerStrategy77vs6 = new PlayerStrategy(StartValue.getOne(7), Card.Six6, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy77vs6,playerStrategy77vs6);
		
		PlayerStrategy playerStrategy88vs4 = new PlayerStrategy(StartValue.getOne(8), Card.Four4, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy88vs4,playerStrategy88vs4);
		PlayerStrategy playerStrategy88vs5 = new PlayerStrategy(StartValue.getOne(8), Card.Five5, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy88vs5,playerStrategy88vs5);
		PlayerStrategy playerStrategy88vs6 = new PlayerStrategy(StartValue.getOne(8), Card.Six6, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy88vs6,playerStrategy88vs6);
		PlayerStrategy playerStrategy88vs7 = new PlayerStrategy(StartValue.getOne(8), Card.Seven7, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy88vs7,playerStrategy88vs7);
		
	}
}
