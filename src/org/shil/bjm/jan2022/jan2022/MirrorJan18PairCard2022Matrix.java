package org.shil.bjm.jan2022.jan2022;

import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerAction;
import org.shil.bjm.meta.StartValue;
import org.shil.bjm.strategy.PlayerStrategy;
import org.shil.bjm.strategy.PlayerStrategyMatrix;

/**
 * Jan 17 Pair 2022 Matrix
 */
public class MirrorJan18PairCard2022Matrix extends PlayerStrategyMatrix {

	public static PlayerStrategyMatrix SELF = new MirrorJan18PairCard2022Matrix();

	public MirrorJan18PairCard2022Matrix(){
		super();

		for(StartValue startValue : StartValue.values()){
			if(startValue== StartValue.One){
				for(Card dealerCard : Card.values()){
					PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Split,PlayerAction.Split);	//ok
					strategyMatrix.put(playerStrategy, playerStrategy);
				}
			}else if(startValue.getValue() == 6){
				for(Card dealerCard : Card.values()){
					if(dealerCard.getValue() == 2){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);	// all no
						strategyMatrix.put(playerStrategy, playerStrategy);
					}else if(dealerCard.getValue() >= 3 && dealerCard.getValue() <= 6){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Stand,PlayerAction.Stand);	// all no
						strategyMatrix.put(playerStrategy, playerStrategy);
					}
					else{
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy, playerStrategy);
					}
				}
			}else if(startValue.getValue() == 7){
				for(Card dealerCard : Card.values()){
					PlayerStrategy playerStrategy;
					if(dealerCard.getValue() >= 6 && dealerCard.getValue() <= 6){
						playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Split, PlayerAction.Hit);	//ok
					}else{
						playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit, PlayerAction.Hit);
					}
					strategyMatrix.put(playerStrategy, playerStrategy);
				}
			}else if(startValue.getValue() == 8){
				for(Card dealerCard : Card.values()){
					PlayerStrategy playerStrategy;
					if(dealerCard.getValue() >= 4 && dealerCard.getValue() <= 7){
						playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Split, PlayerAction.Hit);	//ok
					}else{
						playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit, PlayerAction.Hit);
					}
					strategyMatrix.put(playerStrategy, playerStrategy);
				}
			}else if(startValue.getValue() == 9){
				for(Card dealerCard : Card.values()){
					PlayerStrategy playerStrategy;
					if(dealerCard.getValue() >= 2 && dealerCard.getValue() <= 8){
						playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Split, PlayerAction.Hit);	//ok
					}else{
						playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit, PlayerAction.Hit);
					}
					strategyMatrix.put(playerStrategy, playerStrategy);
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
		PlayerStrategy playerStrategy22vs6 = new PlayerStrategy(StartValue.getOne(2), Card.Six6, PlayerAction.Hit,PlayerAction.Hit);  //ok
		strategyMatrix.put(playerStrategy22vs6,playerStrategy22vs6);
		PlayerStrategy playerStrategy22vs7 = new PlayerStrategy(StartValue.getOne(2), Card.Seven7, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy22vs7,playerStrategy22vs7);

		PlayerStrategy playerStrategy33vs2 = new PlayerStrategy(StartValue.getOne(3), Card.Two2, PlayerAction.Hit,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy33vs2,playerStrategy33vs2);
		PlayerStrategy playerStrategy33vs3 = new PlayerStrategy(StartValue.getOne(3), Card.Three3, PlayerAction.Hit,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy33vs3,playerStrategy33vs3);
		PlayerStrategy playerStrategy33vs4 = new PlayerStrategy(StartValue.getOne(3), Card.Four4, PlayerAction.Hit,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy33vs4,playerStrategy33vs4);
		PlayerStrategy playerStrategy33vs5 = new PlayerStrategy(StartValue.getOne(3), Card.Five5, PlayerAction.Hit,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy33vs5,playerStrategy33vs5);
		PlayerStrategy playerStrategy33vs6 = new PlayerStrategy(StartValue.getOne(3), Card.Six6, PlayerAction.Split,PlayerAction.Hit);	// ok
		strategyMatrix.put(playerStrategy33vs6,playerStrategy33vs6);
		PlayerStrategy playerStrategy33vs7 = new PlayerStrategy(StartValue.getOne(3), Card.Seven7, PlayerAction.Hit,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy33vs7,playerStrategy33vs7);

		PlayerStrategy playerStrategy44vs5 = new PlayerStrategy(StartValue.getOne(4), Card.Five5, PlayerAction.Hit,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy44vs5,playerStrategy44vs5);
		PlayerStrategy playerStrategy44vs6 = new PlayerStrategy(StartValue.getOne(4), Card.Six6, PlayerAction.Hit,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy44vs6,playerStrategy44vs6);


	}
}
