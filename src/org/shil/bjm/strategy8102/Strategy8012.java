package org.shil.bjm.strategy8102;

import java.util.Collection;
import java.util.HashSet;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.meta.BlackJackInfo;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.FileUtil;
import org.shil.bjm.meta.PlayerAction;
import org.shil.bjm.meta.PlayerCardsPathValue;
import org.shil.bjm.meta.StartValue;
import org.shil.bjm.simulation.Casion6Deck;
import org.shil.bjm.strategy8102.strategy.MatrixKey;
import org.shil.bjm.strategy8102.strategy.Seven8012;
import org.shil.bjm.strategy8102.strategy.Situation;
import org.shil.bjm.strategy8102.strategy.StrategyMatrix8012;
import org.shil.bjm.strategy8102.strategy.practise.Myth2019April13;

public class Strategy8012 {
	
	public static PlayerCardsPathValue generateOneMatch(Casion6Deck casion6Deck, StrategyMatrix8012 strategyMatrix8012, PlayerCardsPathValue playerCardsPathValue,Card dealerCard) {
		if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) dealerCard = Card.Ten;
		int count = casion6Deck.getCount();
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
							playerAction = strategyMatrix8012.fetchPlayAction(matrixKey, count);	
						}else if(playerCardsPathValue.getSplitTimes()==1){
							playerAction = PlayerAction.Stand;					
						}else {
							throw new RuntimeException("AA should not split twice! dealerCard: " +dealerCard + " playerCards: " + playerCardsPathValue);
						}
					}else {
						//Not A can split twice
						if(playerCardsPathValue.getSplitTimes() == 0) {
							MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.findPairCardFromFirstTwoCards().getValue()), dealerCard, Situation.Start_With_Pair);
							playerAction = strategyMatrix8012.fetchPlayAction(matrixKey, count);
						}else if(playerCardsPathValue.getSplitTimes() == 1) {
							MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.findPairCardFromFirstTwoCards().getValue()), dealerCard, Situation.Splited_Pair_And_Can_Split);
							playerAction = strategyMatrix8012.fetchPlayAction(matrixKey, count);
						}else if(playerCardsPathValue.getSplitTimes() == 2) {
							MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.getValue()), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
							playerAction = strategyMatrix8012.fetchPlayAction(matrixKey, count);
						}else {
							throw new RuntimeException("Pair should not split triple times! dealerCard: " +dealerCard + " playerCards: " + playerCardsPathValue);
						}
					}
				//pair finished 
				}else if(playerCardsPathValue.isStartWithA()) {
					//Ax card begin
					if(playerCardsPathValue.getSplitTimes()==0) {
						MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.findFirstTwoCardsWithOutA().getValue()), dealerCard, Situation.Start_With_A);
						playerAction = strategyMatrix8012.fetchPlayAction(matrixKey, count);
					}else if(playerCardsPathValue.getSplitTimes() > 0){
						//说明是Split来的, Pair4+A这种两张牌的
						MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.findFirstTwoCardsWithOutA().getValue()), dealerCard, Situation.Splited_With_A);
						playerAction = strategyMatrix8012.fetchPlayAction(matrixKey, count);
					}
				// Ax card finished
				}else {
					//normal cards begin
					if(playerCardsPathValue.getSplitTimes()==0) {
						//正常牌型 4+7
						MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.getValue()), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
						playerAction = strategyMatrix8012.fetchPlayAction(matrixKey, count);
					}else if(playerCardsPathValue.getSplitTimes() > 0) {
						//说明是Split来的, Pair8+3这种两张牌的
						MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.getValue()), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
						playerAction = strategyMatrix8012.fetchPlayAction(matrixKey, count);
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
					//Axx牌
					if(playerCardsPathValue.isStartWithA()) {
						int restValue = playerCardsPathValue.getRestValueWithoutA();
						//只关注<=7 A7以下的情况
						if(restValue<=7) {
							MatrixKey matrixKey = new MatrixKey(StartValue.getOne(restValue), dealerCard, Situation.A_Three_More_Cards);
							playerCardsPathValue.setAction(strategyMatrix8012.fetchPlayAction(matrixKey, count));
						}else {
							//A8 A9 A10 A11 A12 ... 之类的都当作正常的处理即可
							MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.getValue()), dealerCard, Situation.Three_More_Cards);
							playerCardsPathValue.setAction(strategyMatrix8012.fetchPlayAction(matrixKey, count));
						}
					}else {
						//非Axx牌
						MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.getValue()), dealerCard, Situation.Three_More_Cards);
						playerCardsPathValue.setAction(strategyMatrix8012.fetchPlayAction(matrixKey, count));
					}
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
	
	public static Collection<PlayerCardsPathValue> generatePlayerCardsPaths(Casion6Deck casion6Deck,StrategyMatrix8012 strategyMatrix8012, PlayerCardsPathValue playerCardsPathValue,Card dealerCard){
		Collection<PlayerCardsPathValue> playerCardsPathValues = new HashSet<PlayerCardsPathValue>();
		if(playerCardsPathValue.outOfCards()) throw new RuntimeException("out of card here dealerCard: " +dealerCard + " playerCards: " + playerCardsPathValue);
		if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) dealerCard = Card.Ten;
		int count = casion6Deck.getCount();
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
							playerAction = strategyMatrix8012.fetchPlayAction(matrixKey, count);	
						}else if(playerCardsPathValue.getSplitTimes()==1){
							playerAction = PlayerAction.Stand;					
						}else {
							throw new RuntimeException("AA should not split twice! dealerCard: " +dealerCard + " playerCards: " + playerCardsPathValue);
						}
					}else {
						//Not A can split twice
						if(playerCardsPathValue.getSplitTimes() == 0) {
							MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.findPairCardFromFirstTwoCards().getValue()), dealerCard, Situation.Start_With_Pair);
							playerAction = strategyMatrix8012.fetchPlayAction(matrixKey, count);
						}else if(playerCardsPathValue.getSplitTimes() == 1) {
							MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.findPairCardFromFirstTwoCards().getValue()), dealerCard, Situation.Splited_Pair_And_Can_Split);
							playerAction = strategyMatrix8012.fetchPlayAction(matrixKey, count);
						}else if(playerCardsPathValue.getSplitTimes() == 2) {
							MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.getValue()), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
							playerAction = strategyMatrix8012.fetchPlayAction(matrixKey, count);
						}else {
							throw new RuntimeException("Pair should not split triple times! dealerCard: " +dealerCard + " playerCards: " + playerCardsPathValue);
						}
					}
				//pair finished 
				}else if(playerCardsPathValue.isStartWithA()) {
					//Ax card begin
					if(playerCardsPathValue.getSplitTimes()==0) {
						MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.findFirstTwoCardsWithOutA().getValue()), dealerCard, Situation.Start_With_A);
						playerAction = strategyMatrix8012.fetchPlayAction(matrixKey, count);
					}
					else if(playerCardsPathValue.getSplitTimes() > 0){
						//说明是Split来的, Pair4+A这种两张牌的
						MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.findFirstTwoCardsWithOutA().getValue()), dealerCard, Situation.Splited_With_A);
						playerAction = strategyMatrix8012.fetchPlayAction(matrixKey, count);
					}
				// Ax card finished
				}else {
					//normal cards begin
					if(playerCardsPathValue.getSplitTimes()==0) {
						//正常牌型 4+7
						MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.getValue()), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
						playerAction = strategyMatrix8012.fetchPlayAction(matrixKey, count);
					}else if(playerCardsPathValue.getSplitTimes() > 0) {
						//说明是Split来的, Pair8+3这种两张牌的
						MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.getValue()), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
						playerAction = strategyMatrix8012.fetchPlayAction(matrixKey, count);
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
					playerCardsPathValues.addAll(generatePlayerCardsPaths(casion6Deck,strategyMatrix8012,aNewPath,dealerCard));
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
				if(!aNewPath.outOfCards()) playerCardsPathValues.addAll(generatePlayerCardsPaths(casion6Deck,strategyMatrix8012,aNewPath,dealerCard));
			}
		}else if(playerCardsPathValue.getAction() == PlayerAction.Hit){
			// hit me hardly
			for (Card card : Card.values()) {
				PlayerCardsPathValue aNewPath = new PlayerCardsPathValue(playerCardsPathValue);
				aNewPath.addCard(card);
				if(!aNewPath.outOfCards()){
					if(aNewPath.getValue() <= BlackJackInfo.BlackJack){
						//Axx牌
						if(aNewPath.isStartWithA()) {
							int restValue = aNewPath.getRestValueWithoutA();
							//只关注<=7 A7以下的情况
							if(restValue<=7) {
								MatrixKey matrixKey = new MatrixKey(StartValue.getOne(restValue), dealerCard, Situation.A_Three_More_Cards);
								aNewPath.setAction(strategyMatrix8012.fetchPlayAction(matrixKey, count));
							}else {
								//A8 A9 A10 A11 A12 ... 之类的都当作正常的处理即可
								MatrixKey matrixKey = new MatrixKey(StartValue.getOne(aNewPath.getValue()), dealerCard, Situation.Three_More_Cards);
								aNewPath.setAction(strategyMatrix8012.fetchPlayAction(matrixKey, count));
							}
						}else {
							//非Axx牌
							MatrixKey matrixKey = new MatrixKey(StartValue.getOne(aNewPath.getValue()), dealerCard, Situation.Three_More_Cards);
							aNewPath.setAction(strategyMatrix8012.fetchPlayAction(matrixKey, count));
						}
					}
					playerCardsPathValues.addAll(generatePlayerCardsPaths(casion6Deck,strategyMatrix8012,aNewPath,dealerCard));
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
//		Card dealerCard = Card.Six6;
		StrategyMatrix8012 strategyMatrix8012 = new Seven8012();
		
//		PlayerCardsPathValue playerCardsPathValue = new PlayerCardsPathValue(Card.One1,Card.Two2,Card.One1);
//		playerCardsPathValue.setAction(PlayerAction.Hit);
//		System.out.println(strategyMatrix8012.fetchPlayAction( new MatrixKey(StartValue.getOne(playerCardsPathValue.getRestValueWithoutA()), dealerCard, Situation.A_Three_More_Cards), 0))
//		PlayerCardsPathValue playerCardsPathValue2 = new PlayerCardsPathValue(Card.One1,Card.Two2,Card.One1,Card.One1);//,Card.Four4);
//		playerCardsPathValue2.setAction(PlayerAction.Hit);
//		
//		System.out.println(playerCardsPathValue2.getRestValueWithoutA());
//		System.out.println(strategyMatrix8012.fetchPlayAction( new MatrixKey(StartValue.getOne(playerCardsPathValue2.getRestValueWithoutA()), dealerCard, Situation.A_Three_More_Cards), 0));
//		
//		Collection<PlayerCardsPathValue> result = generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(), strategyMatrix8012, playerCardsPathValue2, dealerCard);
//		HelloWorld.print(result);
		Card dealerCard = Card.Two2;
		PlayerCardsPathValue playerCardsPathValue = new PlayerCardsPathValue(Card.Eight8,Card.Eight8);
		playerCardsPathValue.setAction(PlayerAction.Split);
		playerCardsPathValue.addCard(Card.One1);
		playerCardsPathValue.setAction(PlayerAction.Init);
		System.out.println(playerCardsPathValue);
		Collection<PlayerCardsPathValue> result = generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(), strategyMatrix8012, new PlayerCardsPathValue(playerCardsPathValue), dealerCard);
//		HelloWorld.print(result);
//		FileUtil.writePlayerCardsPathValues(playerCardsPathValue, dealerCard, result);
		
		
//		MatrixKey matrixKey = new MatrixKey(StartValue.getOne(8), Card.Two2, Situation.Splited_With_A);
//		System.out.println(strategyMatrix8012.fetchPlayAction(matrixKey, 0));
		
		int count = 0;
		PlayerAction playerAction = null;
		if(playerCardsPathValue.getSplitTimes()==0) {
			MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.findFirstTwoCardsWithOutA().getValue()), dealerCard, Situation.Start_With_A);
			playerAction = strategyMatrix8012.fetchPlayAction(matrixKey, count);
		}
		else if(playerCardsPathValue.getSplitTimes() > 0){
			//说明是Split来的, Pair4+A这种两张牌的
			MatrixKey matrixKey = new MatrixKey(StartValue.getOne(playerCardsPathValue.findFirstTwoCardsWithOutA().getValue()), dealerCard, Situation.Splited_With_A);
			playerAction = strategyMatrix8012.fetchPlayAction(matrixKey, count);
		}
		
		System.out.println(playerAction);
	}
}
