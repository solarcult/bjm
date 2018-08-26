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
public abstract class Strategy {

	/**
	 * normal 一般的组合的牌，没有对，没有A的策略
	 */
	private PlayerStrategyMatrix nmSM;
	/**
	 * 带对的组合牌
	 */
	private PlayerStrategyMatrix scSM;
	/**
	 * 带A的组合牌
	 */
	private PlayerStrategyMatrix waSM;
	
	public Strategy(PlayerStrategyMatrix nmSM,PlayerStrategyMatrix scSM,PlayerStrategyMatrix waSM){
		this.nmSM = nmSM;
		this.scSM = scSM;
		this.waSM = waSM;
	}
	
	public Collection<PlayerCardsPathValue> generatePlayerCardsPaths(PlayerCardsPathValue playerCardsPathValue,Card dealerCard){
		
		Collection<PlayerCardsPathValue> playerCardsPathValues = new HashSet<PlayerCardsPathValue>();
		
		if(playerCardsPathValue.outOfCards()) return playerCardsPathValues;
		
		if(playerCardsPathValue.getAction() == PlayerAction.Init){
			//the first time reset action
			PlayerAction playerAction = null;
			if(playerCardsPathValue.getCards().size()>=2){
				//detect player cards type
				if(playerCardsPathValue.isStartWithPairs()){
					if(playerCardsPathValue.getCards().get(0) == Card.One1){
						//TODO AA 是否一定要分牌,待验证!!!
						//AA only can split 1 time
						if(playerCardsPathValue.getSplitTimes()>=1){
							playerAction = PlayerAction.Stand;
						}else{
							playerAction = scSM.getPlayerAction(StartValue.getOne(playerCardsPathValue.getCards().get(0).getValue()),dealerCard).getStartAction();
						}
					}else{
						if(playerCardsPathValue.getSplitTimes() >= 2){
							//only can split 2 times
							PlayerStrategy playerStrategy = nmSM.getPlayerAction(StartValue.getOne(playerCardsPathValue.getValue()),dealerCard);
							playerAction = playerStrategy.getStartAction();
							//split can not surrender
							if(playerAction == PlayerAction.Giveup) playerAction = playerStrategy.getThreeCardAction(); 
						}else{
							//pairs
							PlayerStrategy pairStrategy = scSM.getPlayerAction(StartValue.getOne(playerCardsPathValue.getCards().get(0).getValue()),dealerCard);
							if(pairStrategy == null){
								PlayerStrategy playerStrategy = nmSM.getPlayerAction(StartValue.getOne(playerCardsPathValue.getValue()),dealerCard);
								if(playerCardsPathValue.getSplitTimes()>0 && playerStrategy.getStartAction() == PlayerAction.Giveup){
									//split cards can not surrender
									playerAction = playerStrategy.getThreeCardAction();
								}else{
									playerAction = playerStrategy.getStartAction();
								}
							}else{
								playerAction = pairStrategy.getStartAction();
							}
						}
					}
					
				}else if(playerCardsPathValue.isStartWithA()){
					//with A
					Card withoutAcard = OneWithAMatrix.findFirstTwoCardsWithOutA(playerCardsPathValue);
					if(withoutAcard!=null){
						PlayerStrategy playerStrategy = waSM.getPlayerAction(StartValue.getOne(withoutAcard.getValue()),dealerCard); 
						playerAction = playerStrategy.getStartAction();
					}
				}else{
					PlayerStrategy playerStrategy = nmSM.getPlayerAction(playerCardsPathValue.getStartValue(),dealerCard);
					if(playerCardsPathValue.getSplitTimes()>0 || playerCardsPathValue.getBetMutiV()>1){
						playerAction = playerStrategy.getThreeCardAction();
					}else{
						//normal cards
						playerAction = playerStrategy.getStartAction();
					}
				}
				if(playerAction == null){
					throw new RuntimeException("playaction is null, should not happend " + playerCardsPathValue);
				}
				
				if(playerAction != null){
					//init first action
					playerCardsPathValue.setAction(playerAction);
				}
			}
			

			//此处不能用else{,因为如果是Pair被split以后，要在下面的这段代码再发一张牌，继续旅程
			//only handle split cards here
			if(playerCardsPathValue.getCards().size()<2){
				for (Card card : Card.values()) {
					PlayerCardsPathValue aNewPath = new PlayerCardsPathValue(playerCardsPathValue);
					aNewPath.addCard(card);
					//A only get one card then stop
					if(playerCardsPathValue.getCards().get(0) == Card.One1) aNewPath.setAction(PlayerAction.Stand);
					//others can get 
					playerCardsPathValues.addAll(generatePlayerCardsPaths(aNewPath,dealerCard));
				}
				playerCardsPathValue.setAction(PlayerAction.SplitAbandon);
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
