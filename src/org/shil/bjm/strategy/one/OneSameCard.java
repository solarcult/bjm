package org.shil.bjm.strategy.one;

import java.util.TreeMap;

import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerAction;
import org.shil.bjm.meta.StartValue;
import org.shil.bjm.strategy.PlayerStrategy;
import org.shil.bjm.strategy.PlayerStrategyMatrix;

public class OneSameCard extends PlayerStrategyMatrix {
	
	public OneSameCard(){
		strategyMatrix = new TreeMap<PlayerStrategy,PlayerStrategy>();
		
		PlayerStrategy playerStrategy77vs6 = new PlayerStrategy(StartValue.getOne(14), Card.Six6, PlayerAction.Hit,PlayerAction.Hit, 2);
		strategyMatrix.put(playerStrategy77vs6,playerStrategy77vs6);
		
		PlayerStrategy playerStrategy88vs4 = new PlayerStrategy(StartValue.getOne(16), Card.Four4, PlayerAction.Hit,PlayerAction.Hit, 2);
		strategyMatrix.put(playerStrategy88vs4,playerStrategy88vs4);
		PlayerStrategy playerStrategy88vs5 = new PlayerStrategy(StartValue.getOne(16), Card.Five5, PlayerAction.Hit,PlayerAction.Hit, 2);
		strategyMatrix.put(playerStrategy88vs5,playerStrategy88vs5);
		PlayerStrategy playerStrategy88vs6 = new PlayerStrategy(StartValue.getOne(16), Card.Six6, PlayerAction.Hit,PlayerAction.Hit, 2);
		strategyMatrix.put(playerStrategy88vs6,playerStrategy88vs6);
		PlayerStrategy playerStrategy88vs7 = new PlayerStrategy(StartValue.getOne(16), Card.Seven7, PlayerAction.Hit,PlayerAction.Hit, 2);
		strategyMatrix.put(playerStrategy88vs7,playerStrategy88vs7);
		
	}
}
