package org.shil.bjm.strategy.one;

import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerAction;
import org.shil.bjm.meta.StartValue;
import org.shil.bjm.strategy.PlayerStrategy;
import org.shil.bjm.strategy.PlayerStrategyMatrix;

public class Combat2017JulyVer extends PlayerStrategyMatrix{

	
	public static PlayerStrategyMatrix SELF = new Combat2017JulyVer();
	
	public Combat2017JulyVer(){
		super();
	
		//普通牌用户策略,没有考虑到Ax的情况 和 split的情况
		for(StartValue startValue : StartValue.values()){
			if(startValue== StartValue.One) continue;
			//startvalue 2~9 hit
			else if(startValue.getValue() >=2 && startValue.getValue()<=8){
				for(Card dealerCard : Card.values()){
					PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
					strategyMatrix.put(playerStrategy,playerStrategy);
				}
			}
			else if(startValue == StartValue.Nine){
				for(Card dealerCard : Card.values()){
					if(dealerCard == Card.Three3 || dealerCard == Card.Four4 || dealerCard == Card.Five5 || dealerCard == Card.Six6 || dealerCard == Card.Seven7){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Double,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy,playerStrategy); 
					}else{
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy,playerStrategy);
					}
				}
			}
			else if(startValue == StartValue.Ten) {
				for(Card dealerCard : Card.values()){
					if(dealerCard.getValue() >=2 && dealerCard.getValue() <=9){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Double,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy,playerStrategy);
					}else{
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy,playerStrategy);
					}
				}
			}
			else if(startValue == StartValue.Eleven){
				for(Card dealerCard : Card.values()){
					if(dealerCard.getValue() >=2 && dealerCard.getValue() <=9){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Double,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy,playerStrategy);
					}else{
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy,playerStrategy);
					}
				}
			}
			else if(startValue == StartValue.Twelve){// && startValue.getValue()<=16){
				for(Card dealerCard : Card.values()){
					if(dealerCard.getValue() == 2 ){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy,playerStrategy);
					}else if(dealerCard.getValue() == 3 ){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Stand,PlayerAction.Stand);
						strategyMatrix.put(playerStrategy,playerStrategy);
					}else if(dealerCard.getValue() >3 && dealerCard.getValue() <=6){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Stand,PlayerAction.Stand);
						strategyMatrix.put(playerStrategy,playerStrategy);
					}else{
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy,playerStrategy);
					}
				}
			}else if(startValue==StartValue.Thirteen){
				for(Card dealerCard : Card.values()){
					if(dealerCard.getValue() >=2 && dealerCard.getValue() <=6){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Stand,PlayerAction.Stand);
						strategyMatrix.put(playerStrategy,playerStrategy);
					}else if(dealerCard.getValue() == 7 || dealerCard.getValue() == 8){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy,playerStrategy);
					}else{
						//9,T,A
						//same result if the cards give to dealer
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy,playerStrategy);
					}
				}
			}else if(startValue==StartValue.Fourteen){
				//very hard choose
				for(Card dealerCard : Card.values()){
					if(dealerCard.getValue() >=2 && dealerCard.getValue() <=6){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Stand,PlayerAction.Stand);
						strategyMatrix.put(playerStrategy,playerStrategy);
					}else if(dealerCard.getValue() == 7){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy,playerStrategy);
					}else if(dealerCard.getValue() == 8){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy,playerStrategy);
					}else if(dealerCard.getValue() == 9){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy,playerStrategy);
					}else if(dealerCard.getValue() == 10){
						//T,J,Q,K
						//same result if the cards give to dealer
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Giveup,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy,playerStrategy);
					}
					else{
						//A
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy,playerStrategy);
					}
				}
			}else if(startValue == StartValue.Fifteen){
				//very hard choose
				for(Card dealerCard : Card.values()){
					if(dealerCard.getValue() >=2 && dealerCard.getValue() <=6){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Stand,PlayerAction.Stand);
						strategyMatrix.put(playerStrategy,playerStrategy);
					}else if(dealerCard.getValue() == 7 ){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy,playerStrategy);
					}else if(dealerCard.getValue() == 8 ){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy,playerStrategy);
					}else if(dealerCard.getValue() == 9 ){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Giveup,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy,playerStrategy);
					}else if(dealerCard.getValue() == 10 ){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Giveup,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy,playerStrategy);
					}
					else{
						//A
						//same result if the cards give to dealer
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy,playerStrategy);
					}
				}
			}else if(startValue == StartValue.Sixteen){
				//very hard choose
				for(Card dealerCard : Card.values()){
					if(dealerCard.getValue() >=2 && dealerCard.getValue() <=6){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Stand,PlayerAction.Stand);
						strategyMatrix.put(playerStrategy,playerStrategy);
					}else if(dealerCard.getValue() == 7 ){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy,playerStrategy);
					}else if(dealerCard.getValue() ==8 ){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy,playerStrategy);
					}else if(dealerCard.getValue() ==9 ){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Giveup,PlayerAction.Stand);
						strategyMatrix.put(playerStrategy,playerStrategy);
					}else if(dealerCard.getValue() ==10 ){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Giveup,PlayerAction.Stand);
						strategyMatrix.put(playerStrategy,playerStrategy);
					}
					else{
						//A
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy,playerStrategy);
					}
				}
			}else{
				// start >= 17 just wait , watch and pray
				for(Card dealerCard : Card.values()){
					PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Stand,PlayerAction.Stand);
					strategyMatrix.put(playerStrategy,playerStrategy);
				}
			}
		}
	
	}
}
