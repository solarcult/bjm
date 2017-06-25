package org.shil.bjm.strategy;

import java.util.Map;
import java.util.TreeMap;

import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.StartValue;

public abstract class PlayerStrategyMatrix {

	protected Map<PlayerStrategy,PlayerStrategy> strategyMatrix;
	
	protected PlayerStrategyMatrix(){
		strategyMatrix = new TreeMap<PlayerStrategy,PlayerStrategy>();
	}
	
	public PlayerStrategy getPlayerAction(StartValue startValue,Card dealerCard){
		return strategyMatrix.get(PlayerStrategy.builderOne(startValue, dealerCard));
	}
	
	public PlayerStrategy getPlayerAction(PlayerStrategy playerStrategy){
		return strategyMatrix.get(playerStrategy);
	}
	
	public Map<PlayerStrategy,PlayerStrategy> getStrategyMatrix(){
		return strategyMatrix;
	}
	
	public void printStrategyMatrix(){
		for(PlayerStrategy playerStrategy : strategyMatrix.keySet()){
			System.out.println(playerStrategy);
		}
	}
}
