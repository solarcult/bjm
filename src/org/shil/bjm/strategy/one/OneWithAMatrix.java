package org.shil.bjm.strategy.one;

import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerAction;
import org.shil.bjm.meta.PlayerCardsPathValue;
import org.shil.bjm.meta.StartValue;
import org.shil.bjm.strategy.PlayerStrategy;
import org.shil.bjm.strategy.PlayerStrategyMatrix;

public class OneWithAMatrix extends PlayerStrategyMatrix {
	
	public static PlayerStrategyMatrix SELF = new OneWithAMatrix();

	public OneWithAMatrix(){
		super();
		
		for(StartValue startValue : StartValue.values()){
			if(startValue== StartValue.One){
				//should not happened because pairs AA handle this;
				continue;
			}
			//startvalue 2~5 hit
			else if(startValue.getValue() >=2 && startValue.getValue()<=5){
				for(Card dealerCard : Card.values()){
					if(dealerCard.getValue() >=5 && dealerCard.getValue() <=6){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Double,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy, playerStrategy);
					}else{
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy, playerStrategy);
					}
				}
			}else if(startValue.getValue() == 6){
				for(Card dealerCard : Card.values()){
					if(dealerCard.getValue() >=4 && dealerCard.getValue() <=6){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Double,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy, playerStrategy);
					}else{
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy, playerStrategy);
					}
				}
			}else{
				// A+7~T stand
				for(Card dealerCard : Card.values()){
					PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Stand,PlayerAction.Stand);
					strategyMatrix.put(playerStrategy, playerStrategy);
				}
			}
		}
	}
	
	
	public static Card findFirstTwoCardsWithOutA(PlayerCardsPathValue playerCardsPathValue){
		Card withoutA = null;
		if(!playerCardsPathValue.isStartWithA()) return null;
		if(playerCardsPathValue.getCards().get(0).equals(Card.One1)){
			withoutA = playerCardsPathValue.getCards().get(1);
		}else if(playerCardsPathValue.getCards().get(1).equals(Card.One1)){
			withoutA = playerCardsPathValue.getCards().get(0);
		}else{
			throw new RuntimeException("this could not happend with A , no A in first two cards");
		}
		
		return withoutA;
	}
}
