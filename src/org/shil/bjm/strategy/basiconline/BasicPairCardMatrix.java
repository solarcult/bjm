package org.shil.bjm.strategy.basiconline;

import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerAction;
import org.shil.bjm.meta.StartValue;
import org.shil.bjm.strategy.PlayerStrategy;
import org.shil.bjm.strategy.PlayerStrategyMatrix;

public class BasicPairCardMatrix extends PlayerStrategyMatrix {
	
	public static PlayerStrategyMatrix SELF = new BasicPairCardMatrix();
	
	public BasicPairCardMatrix(){
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
			}else if(startValue.getValue() == 6){
				for(Card dealerCard : Card.values()){
					if(dealerCard.getValue() >= 2 && dealerCard.getValue() <= 6){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Split,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy, playerStrategy);
					}else{
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy, playerStrategy);
					}
				}
			}else if(startValue.getValue() == 7){
				for(Card dealerCard : Card.values()){
					if(dealerCard.getValue() >= 2 && dealerCard.getValue() <= 7){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Split,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy, playerStrategy);
					}else{
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy, playerStrategy);
					}
				}
			}else if(startValue.getValue() == 8){
				for(Card dealerCard : Card.values()){
					PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Split,PlayerAction.Hit);
					strategyMatrix.put(playerStrategy, playerStrategy);
				}
			}else if(startValue.getValue() == 9){
				for(Card dealerCard : Card.values()){
					if(dealerCard.getValue() != 7){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Split,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy, playerStrategy);
					}else{
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy, playerStrategy);
					}
				}
			}
			
		}

		PlayerStrategy playerStrategy22vs2 = new PlayerStrategy(StartValue.getOne(2), Card.Two2, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy22vs2,playerStrategy22vs2);
		PlayerStrategy playerStrategy22vs3 = new PlayerStrategy(StartValue.getOne(2), Card.Three3, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy22vs3,playerStrategy22vs3);
		PlayerStrategy playerStrategy22vs4 = new PlayerStrategy(StartValue.getOne(2), Card.Four4, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy22vs4,playerStrategy22vs4);
		PlayerStrategy playerStrategy22vs5 = new PlayerStrategy(StartValue.getOne(2), Card.Five5, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy22vs5,playerStrategy22vs5);
		PlayerStrategy playerStrategy22vs6 = new PlayerStrategy(StartValue.getOne(2), Card.Six6, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy22vs6,playerStrategy22vs6);
		PlayerStrategy playerStrategy22vs7 = new PlayerStrategy(StartValue.getOne(2), Card.Seven7, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy22vs7,playerStrategy22vs7);
		
		PlayerStrategy playerStrategy33vs2 = new PlayerStrategy(StartValue.getOne(3), Card.Two2, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy33vs2,playerStrategy33vs2);
		PlayerStrategy playerStrategy33vs3 = new PlayerStrategy(StartValue.getOne(3), Card.Three3, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy33vs3,playerStrategy33vs3);
		PlayerStrategy playerStrategy33vs4 = new PlayerStrategy(StartValue.getOne(3), Card.Four4, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy33vs4,playerStrategy33vs4);
		PlayerStrategy playerStrategy33vs5 = new PlayerStrategy(StartValue.getOne(3), Card.Five5, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy33vs5,playerStrategy33vs5);
		PlayerStrategy playerStrategy33vs6 = new PlayerStrategy(StartValue.getOne(3), Card.Six6, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy33vs6,playerStrategy33vs6);
		PlayerStrategy playerStrategy33vs7 = new PlayerStrategy(StartValue.getOne(3), Card.Seven7, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy33vs7,playerStrategy33vs7);

		PlayerStrategy playerStrategy44vs6 = new PlayerStrategy(StartValue.getOne(4), Card.Six6, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy44vs6,playerStrategy44vs6);
		PlayerStrategy playerStrategy44vs5 = new PlayerStrategy(StartValue.getOne(4), Card.Five5, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy44vs5,playerStrategy44vs5);
	
	}
}
