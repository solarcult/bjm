package org.shil.bjm.strategy.one;

import java.util.Collection;
import java.util.HashSet;

import org.shil.bjm.meta.BlackJackInfo;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerAction;
import org.shil.bjm.meta.PlayerCardsPathValue;
import org.shil.bjm.meta.StartValue;
import org.shil.bjm.strategy.PlayerStrategyMatrix;

public abstract class FourStrategy {

	private PlayerStrategyMatrix nmSM;
	private PlayerStrategyMatrix scSM;
	private PlayerStrategyMatrix waSM;
	
	public FourStrategy(PlayerStrategyMatrix nmSM,PlayerStrategyMatrix scSM,PlayerStrategyMatrix waSM){
		this.nmSM = nmSM;
		this.scSM = scSM;
		this.waSM = waSM;
	}
	
	public Collection<PlayerCardsPathValue> generatePlayerCardsPaths(PlayerCardsPathValue playerCardsPathValue,Card dealerCard){
		
		Collection<PlayerCardsPathValue> playerCardsPathValues = new HashSet<PlayerCardsPathValue>();
		
		if(!playerCardsPathValue.outOfCards()) return playerCardsPathValues;
		
		if(playerCardsPathValue.getAction() == PlayerAction.Init){
			//the first time reset action
			PlayerAction playerAction = null;
			//detect player cards type
			if(playerCardsPathValue.isStartWithA()){
				//with A
				int startWithoutAValue = 0;
				if(playerCardsPathValue.getCards().get(0).equals(Card.One1)){
					startWithoutAValue = playerCardsPathValue.getCards().get(1).getValue();
				}else if(playerCardsPathValue.getCards().get(1).equals(Card.One1)){
					startWithoutAValue = playerCardsPathValue.getCards().get(0).getValue();
				}else{
					throw new RuntimeException("this could not happend with A , no A in first two cards");
				}
				playerAction = waSM.getPlayerAction(StartValue.getOne(startWithoutAValue),dealerCard).getStartAction();
				
			}else if(playerCardsPathValue.isStartWithPairs()){
				//pairs
				playerAction = scSM.getPlayerAction(StartValue.getOne(playerCardsPathValue.getCards().get(0).getValue()),dealerCard).getStartAction();
				
			}else{
				//normal cards
				playerAction = nmSM.getPlayerAction(playerCardsPathValue.getStartValue(),dealerCard).getStartAction();
				
			}
			
			//init first action
			playerCardsPathValue.setAction(playerAction);
		}
		
		if(playerCardsPathValue.getValue() > BlackJackInfo.BlackJack){
			//burst, bye~
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
				if(aNewPath.isValid()) playerCardsPathValues.addAll(generatePlayerCardsPaths(aNewPath,dealerCard));
			}
		}else if(playerCardsPathValue.getAction() == PlayerAction.Hit){
//			System.out.println(playerCardsPathValue);
			// hit me hardly
			for (Card card : Card.values()) {
				PlayerCardsPathValue aNewPath = new PlayerCardsPathValue(playerCardsPathValue);
				aNewPath.addCard(card);
				if(aNewPath.isValid()){
					if(aNewPath.getValue() <= BlackJackInfo.BlackJack){
						aNewPath.setAction(playerStrategyMatrix.getPlayerAction(StartValue.getOne(aNewPath.getValue()),dealerCard).getThreeCardAction());
					}
					playerCardsPathValues.addAll(generatePlayerCardsPaths(aNewPath,dealerCard));
				}
			}
		}else{
			//wtf
			throw new RuntimeException("help, please help me, where am i?");
		}
		
		return playerCardsPathValues;
	}
}
