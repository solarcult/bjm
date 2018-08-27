package org.shil.bjm.strategy;

import java.util.Collection;
import java.util.HashSet;

import org.shil.bjm.meta.BlackJackInfo;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerAction;
import org.shil.bjm.meta.PlayerCardsPathValue;
import org.shil.bjm.meta.StartValue;
import org.shil.bjm.strategy.one.OneWithAMatrix;

/**
 * 核心类，策略类，希望没有bug
 * @author vanis
 *
 */
public class StrategyAATest {

	/**
	 * normal 一般的组合的牌，没有对，没有A的策略
	 */
	private PlayerStrategyMatrix nmSM;

	
	public StrategyAATest(PlayerStrategyMatrix nmSM){
		this.nmSM = nmSM;
	}
	
	public Collection<PlayerCardsPathValue> generatePlayerCardsPaths(PlayerCardsPathValue playerCardsPathValue,Card dealerCard){
		
		Collection<PlayerCardsPathValue> playerCardsPathValues = new HashSet<PlayerCardsPathValue>();
		
		if(playerCardsPathValue.outOfCards()) return playerCardsPathValues;
		
		if(playerCardsPathValue.getAction() == PlayerAction.Init){
			//the first time reset action
			PlayerAction playerAction = null;
			if(playerCardsPathValue.getCards().size()>=2){
				//detect player cards type
					PlayerStrategy playerStrategy = nmSM.getPlayerAction(playerCardsPathValue.getStartValue(),dealerCard);
					if(playerCardsPathValue.getSplitTimes()>0 || playerCardsPathValue.getBetMutiV()>1){
						playerAction = playerStrategy.getThreeCardAction();
					}else{
						//normal cards
						playerAction = playerStrategy.getStartAction();
					}
					
				if(playerAction == null){
					throw new RuntimeException("playaction is null, should not happend " + playerCardsPathValue);
				}
				
				if(playerAction != null){
					//init first action
					playerCardsPathValue.setAction(playerAction);
				}
			}
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
				if(!aNewPath.outOfCards()) playerCardsPathValues.addAll(generatePlayerCardsPaths(aNewPath,dealerCard));
			}
		}else if(playerCardsPathValue.getAction() == PlayerAction.Hit){
//			System.out.println(playerCardsPathValue);
			// hit me hardly
			for (Card card : Card.values()) {
				PlayerCardsPathValue aNewPath = new PlayerCardsPathValue(playerCardsPathValue);
				aNewPath.addCard(card);
				if(!aNewPath.outOfCards()){
					if(aNewPath.getValue() <= BlackJackInfo.BlackJack){
							aNewPath.setAction(this.nmSM.getPlayerAction(StartValue.getOne(aNewPath.getValue()),dealerCard).getThreeCardAction());
					}
					playerCardsPathValues.addAll(generatePlayerCardsPaths(aNewPath,dealerCard));
				}
			}
		}else if(playerCardsPathValue.getAction() == PlayerAction.SplitAbandon){			
			//after split the origin pairs one left card playerCardsPathValue will abandon here and be ignored
		}else{
			throw new RuntimeException("wtf of this action, should not happend " + playerCardsPathValue);
		}
		
		return playerCardsPathValues;
	}
}
