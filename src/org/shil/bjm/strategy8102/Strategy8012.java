package org.shil.bjm.strategy8102;

import java.util.Collection;
import java.util.HashSet;

import org.shil.bjm.meta.BlackJackInfo;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerAction;
import org.shil.bjm.meta.PlayerCardsPathValue;
import org.shil.bjm.meta.StartValue;
import org.shil.bjm.simulation.Casion6Deck;

public class Strategy8012 {
	
	public static PlayerCardsPathValue generateOneMatch(Casion6Deck casion6Deck, StrategyMatrix8012 strategyMatrix8012, PlayerCardsPathValue playerCardsPathValue,Card dealerCard) {
		if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) dealerCard = Card.Ten;
		
		if(playerCardsPathValue.getAction() == PlayerAction.Init){
			PlayerAction playerAction = null;
			
			if(playerCardsPathValue.isStartHand()) {
				//start hand begin
				if(playerCardsPathValue.isStartWithPairs()) {
					//pair begin
					if(playerCardsPathValue.isStartWithA()) {
						//AA only can split 1 time
						if(playerCardsPathValue.getSplitTimes()==0){
							MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.findPairCardFromFirstTwoCards().getValue()), dealerCard, Situation.Start_With_Pair);
							playerAction = strategyMatrix8012.one.get(matrixKey);	
						}else if(playerCardsPathValue.getSplitTimes()==1){
							playerAction = PlayerAction.Stand;					
						}else {
							throw new RuntimeException("AA should not split twice! dealerCard: " +dealerCard + " playerCards: " + playerCardsPathValue);
						}
					}else {
						//Not A can split twice
						if(playerCardsPathValue.getSplitTimes() == 0) {
							MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.findPairCardFromFirstTwoCards().getValue()), dealerCard, Situation.Start_With_Pair);
							playerAction = strategyMatrix8012.one.get(matrixKey);
						}else if(playerCardsPathValue.getSplitTimes() == 1) {
							MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.findPairCardFromFirstTwoCards().getValue()), dealerCard, Situation.Splited_Pair_And_Can_Split);
							playerAction = strategyMatrix8012.one.get(matrixKey);
						}else if(playerCardsPathValue.getSplitTimes() == 2) {
							MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.getValue()), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
							playerAction = strategyMatrix8012.one.get(matrixKey);
						}else {
							throw new RuntimeException("Pair should not split triple times! dealerCard: " +dealerCard + " playerCards: " + playerCardsPathValue);
						}
					}
				//pair finished 
				}else if(playerCardsPathValue.isStartWithA()) {
					//Ax card begin
					if(playerCardsPathValue.getSplitTimes()==0) {
						MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.findFirstTwoCardsWithOutA().getValue()), dealerCard, Situation.Start_With_A);
						playerAction = strategyMatrix8012.one.get(matrixKey);
					}else if(playerCardsPathValue.getSplitTimes() > 0){
						//说明是Split来的, Pair8+A这种两张牌的
						MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.getValue()), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
						playerAction = strategyMatrix8012.one.get(matrixKey);
					}
				// Ax card finished
				}else {
					//normal cards begin
					if(playerCardsPathValue.getSplitTimes()==0) {
						//正常牌型 4+7
						MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.getValue()), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
						playerAction = strategyMatrix8012.one.get(matrixKey);
					}else if(playerCardsPathValue.getSplitTimes() > 0) {
						//说明是Split来的, Pair8+3这种两张牌的
						MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.getValue()), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
						playerAction = strategyMatrix8012.one.get(matrixKey);
					}
				// normal cards finished
				}
			}//start hand finished
			
			if(playerAction == null){
				throw new RuntimeException("playaction is null, should not happend: dealerCard: " +dealerCard + " playerCards: " + playerCardsPathValue);
			}
			
			if(playerAction != null){
				//init first action
				playerCardsPathValue.setAction(playerAction);
			}
			
			//此处不能用else{,因为如果是Pair被split以后，要在下面的这段代码再发一张牌，继续旅程
			//only handle split cards here
			if(playerCardsPathValue.getCards().size()==1){
			 	Card oneMoreCard = casion6Deck.fetchOne();
			 	playerCardsPathValue.addCard(oneMoreCard);

				if(playerCardsPathValue.getCards().get(0) == Card.One1) { 
					playerCardsPathValue.setAction(PlayerAction.Stand);
				}else {
					//others can get 
					return generateOneMatch(casion6Deck,strategyMatrix8012,playerCardsPathValue,dealerCard);
				}
			}
		}//Init
		
		//story continued
		if(playerCardsPathValue.getValue() > BlackJackInfo.BlackJack){
			//burst, bye~
			playerCardsPathValue.setAction(PlayerAction.Stand);
		}else if(playerCardsPathValue.getAction() == PlayerAction.Giveup || playerCardsPathValue.getAction() == PlayerAction.Stand){
			// we finish and pray
		}else if(playerCardsPathValue.getAction() == PlayerAction.DoubleDone){
			// good luck
		}else if(playerCardsPathValue.getAction() == PlayerAction.Double){
			//let double me up
			Card oneMoreCard = casion6Deck.fetchOne();
			playerCardsPathValue.addCard(oneMoreCard);
			playerCardsPathValue.setAction(PlayerAction.DoubleDone);
		}else if(playerCardsPathValue.getAction() == PlayerAction.Hit){
			// hit me hardly
			Card oneMoreCard = casion6Deck.fetchOne();
		 	playerCardsPathValue.addCard(oneMoreCard);
			
			if(!playerCardsPathValue.outOfCards()){
				if(playerCardsPathValue.getValue() <= BlackJackInfo.BlackJack){
					MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.getValue()), dealerCard, Situation.Three_More_Cards);
					playerCardsPathValue.setAction(strategyMatrix8012.one.get(matrixKey));
				}
				generateOneMatch(casion6Deck, strategyMatrix8012, playerCardsPathValue, dealerCard);
			}
		}else if(playerCardsPathValue.getAction() == PlayerAction.SplitAbandon){			
			//after split the origin pairs one left card playerCardsPathValue will abandon here and be ignored
		}else{
			throw new RuntimeException("wtf of this action, should not happend dealerCard: " +dealerCard +" playercards: " + playerCardsPathValue);
		}
		
		return playerCardsPathValue;
	}
	
	public static Collection<PlayerCardsPathValue> generatePlayerCardsPaths(StrategyMatrix8012 strategyMatrix8012, PlayerCardsPathValue playerCardsPathValue,Card dealerCard){
		Collection<PlayerCardsPathValue> playerCardsPathValues = new HashSet<PlayerCardsPathValue>();
		if(playerCardsPathValue.outOfCards()) throw new RuntimeException("out of card here dealerCard: " +dealerCard + " playerCards: " + playerCardsPathValue);
		if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) dealerCard = Card.Ten;
		
		if(playerCardsPathValue.getAction() == PlayerAction.Init){
			PlayerAction playerAction = null;
			
			if(playerCardsPathValue.isStartHand()) {
				//start hand begin
				if(playerCardsPathValue.isStartWithPairs()) {
					//pair begin
					if(playerCardsPathValue.isStartWithA()) {
						//AA only can split 1 time
						if(playerCardsPathValue.getSplitTimes()==0){
							MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.findPairCardFromFirstTwoCards().getValue()), dealerCard, Situation.Start_With_Pair);
							playerAction = strategyMatrix8012.one.get(matrixKey);	
						}else if(playerCardsPathValue.getSplitTimes()==1){
							playerAction = PlayerAction.Stand;					
						}else {
							throw new RuntimeException("AA should not split twice! dealerCard: " +dealerCard + " playerCards: " + playerCardsPathValue);
						}
					}else {
						//Not A can split twice
						if(playerCardsPathValue.getSplitTimes() == 0) {
							MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.findPairCardFromFirstTwoCards().getValue()), dealerCard, Situation.Start_With_Pair);
							playerAction = strategyMatrix8012.one.get(matrixKey);
						}else if(playerCardsPathValue.getSplitTimes() == 1) {
							MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.findPairCardFromFirstTwoCards().getValue()), dealerCard, Situation.Splited_Pair_And_Can_Split);
							playerAction = strategyMatrix8012.one.get(matrixKey);
						}else if(playerCardsPathValue.getSplitTimes() == 2) {
							MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.getValue()), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
							playerAction = strategyMatrix8012.one.get(matrixKey);
						}else {
							throw new RuntimeException("Pair should not split triple times! dealerCard: " +dealerCard + " playerCards: " + playerCardsPathValue);
						}
					}
				//pair finished 
				}else if(playerCardsPathValue.isStartWithA()) {
					//Ax card begin
					if(playerCardsPathValue.getSplitTimes()==0) {
						MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.findFirstTwoCardsWithOutA().getValue()), dealerCard, Situation.Start_With_A);
						playerAction = strategyMatrix8012.one.get(matrixKey);
					}else if(playerCardsPathValue.getSplitTimes() > 0){
						//说明是Split来的, Pair8+A这种两张牌的
						MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.getValue()), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
						playerAction = strategyMatrix8012.one.get(matrixKey);
					}
				// Ax card finished
				}else {
					//normal cards begin
					if(playerCardsPathValue.getSplitTimes()==0) {
						//正常牌型 4+7
						MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.getValue()), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
						playerAction = strategyMatrix8012.one.get(matrixKey);
					}else if(playerCardsPathValue.getSplitTimes() > 0) {
						//说明是Split来的, Pair8+3这种两张牌的
						MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.getValue()), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
						playerAction = strategyMatrix8012.one.get(matrixKey);
					}
				// normal cards finished
				}
			}//start hand finished
			
			if(playerAction == null){
				throw new RuntimeException("playaction is null, should not happend: dealerCard: " +dealerCard + " playerCards: " + playerCardsPathValue);
			}
			
			if(playerAction != null){
				//init first action
				playerCardsPathValue.setAction(playerAction);
			}
			
			//此处不能用else{,因为如果是Pair被split以后，要在下面的这段代码再发一张牌，继续旅程
			//only handle split cards here
			if(playerCardsPathValue.getCards().size()==1){
				for (Card card : Card.values()) {
					PlayerCardsPathValue aNewPath = new PlayerCardsPathValue(playerCardsPathValue);
					aNewPath.addCard(card);
					//A only get one card then stop
					if(playerCardsPathValue.getCards().get(0) == Card.One1) aNewPath.setAction(PlayerAction.Stand);
					//others can get 
					playerCardsPathValues.addAll(generatePlayerCardsPaths(strategyMatrix8012,aNewPath,dealerCard));
				}
				playerCardsPathValue.setAction(PlayerAction.SplitAbandon);
			}
		}//Init
		
		//story continued
		if(playerCardsPathValue.getValue() > BlackJackInfo.BlackJack){
			//burst, bye~
			playerCardsPathValue.setAction(PlayerAction.Stand);
			playerCardsPathValues.add(playerCardsPathValue);
		}else if(playerCardsPathValue.getAction() == PlayerAction.Giveup || playerCardsPathValue.getAction() == PlayerAction.Stand){
			// we finish and pray
			playerCardsPathValues.add(playerCardsPathValue);
		}else if(playerCardsPathValue.getAction() == PlayerAction.DoubleDone){
			// good luck
			playerCardsPathValues.add(playerCardsPathValue);
		}else if(playerCardsPathValue.getAction() == PlayerAction.Double){
			//let double me up
			for (Card card : Card.values()) {
				PlayerCardsPathValue aNewPath = new PlayerCardsPathValue(playerCardsPathValue);
				aNewPath.addCard(card);
				aNewPath.setAction(PlayerAction.DoubleDone);
				if(!aNewPath.outOfCards()) playerCardsPathValues.addAll(generatePlayerCardsPaths(strategyMatrix8012,aNewPath,dealerCard));
			}
		}else if(playerCardsPathValue.getAction() == PlayerAction.Hit){
			// hit me hardly
			for (Card card : Card.values()) {
				PlayerCardsPathValue aNewPath = new PlayerCardsPathValue(playerCardsPathValue);
				aNewPath.addCard(card);
				if(!aNewPath.outOfCards()){
					if(aNewPath.getValue() <= BlackJackInfo.BlackJack){
						MatrixKey matrixKey = new MatrixKey(StartValue.getOne(aNewPath.getValue()), dealerCard, Situation.Three_More_Cards);
						aNewPath.setAction(strategyMatrix8012.one.get(matrixKey));
					}
					playerCardsPathValues.addAll(generatePlayerCardsPaths(strategyMatrix8012,aNewPath,dealerCard));
				}
			}
		}else if(playerCardsPathValue.getAction() == PlayerAction.SplitAbandon){			
			//after split the origin pairs one left card playerCardsPathValue will abandon here and be ignored
		}else{
			throw new RuntimeException("wtf of this action, should not happend dealerCard: " +dealerCard +" playercards: " + playerCardsPathValue);
		}
		
		return playerCardsPathValues;
	}
	
	public static void main(String[] args) {
//		SELF.generatePlayerCardsPaths(new PlayerCardsPathValue(Card.QQQ,Card.Four4), Card.);
	}
}
