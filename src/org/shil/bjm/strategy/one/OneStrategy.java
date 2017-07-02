package org.shil.bjm.strategy.one;

import java.util.Collection;
import java.util.HashSet;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.anaylze.PlayersVSDealersResultChanceProb;
import org.shil.bjm.meta.BlackJackInfo;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerAction;
import org.shil.bjm.meta.PlayerCardsPathValue;
import org.shil.bjm.meta.StartValue;
import org.shil.bjm.strategy.PlayerStrategy;
import org.shil.bjm.strategy.PlayerStrategyMatrix;
import org.shil.bjm.strategy.ProfitUtil;

public class OneStrategy {
	
	
//	public static OneStrategy SELF = new OneStrategy(OneBestNMatrix.SELF,OnePairCardMatrix.SELF,OneWithAMatrix.SELF);
	
	public static OneStrategy SELF = new OneStrategy(Combat2017JulyVer.SELF,OnePairCardMatrix.SELF,OneWithAMatrix.SELF);
	
//	public static OneStrategy SELF = new OneStrategy(Combat20170618Ver.SELF,OnePairCardMatrix.SELF,OneWithAMatrix.SELF);
	
	private PlayerStrategyMatrix nmSM;
	private PlayerStrategyMatrix scSM;
	private PlayerStrategyMatrix waSM;
	
	public OneStrategy(PlayerStrategyMatrix nmSM,PlayerStrategyMatrix scSM,PlayerStrategyMatrix waSM){
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
						//AA only can split 1 time
						if(playerCardsPathValue.getSplitTimes()>=1){
							playerAction = PlayerAction.Stand;
						}else{
							playerAction = scSM.getPlayerAction(StartValue.getOne(playerCardsPathValue.getCards().get(0).getValue()),dealerCard).getStartAction();
						}
					}else{
						if(playerCardsPathValue.getSplitTimes() >= 2){
							//only can split 2 times
							playerAction = nmSM.getPlayerAction(StartValue.getOne(playerCardsPathValue.getValue()),dealerCard).getStartAction();
						}else{
							//pairs
							PlayerStrategy pairStrategy = scSM.getPlayerAction(StartValue.getOne(playerCardsPathValue.getCards().get(0).getValue()),dealerCard);
							if(pairStrategy == null){
								playerAction = nmSM.getPlayerAction(StartValue.getOne(playerCardsPathValue.getValue()),dealerCard).getStartAction();
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
						//normal cards
						playerAction = nmSM.getPlayerAction(playerCardsPathValue.getStartValue(),dealerCard).getStartAction();
				}
				if(playerAction == null){
					throw new RuntimeException("playaction is null, should not happend " + playerCardsPathValue);
				}
			}
			
			if(playerAction != null){
				//init first action
				playerCardsPathValue.setAction(playerAction);
			}
			
			//only handle split cards here
			if(playerCardsPathValue.getCards().size()<2){
//				if(playerAction!=PlayerAction.Split) throw new RuntimeException(" split with less 2 must be same time" + playerCardsPathValue);
				for (Card card : Card.values()) {
					PlayerCardsPathValue aNewPath = new PlayerCardsPathValue(playerCardsPathValue);
					aNewPath.addCard(card);
					if(playerCardsPathValue.getCards().get(0) == Card.One1) aNewPath.setAction(PlayerAction.Stand);
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
	

	
	public static void main(String[] args){
//		testNM();
//		testSCnoSplit2();
//		testSCSplit7();
//		testSCSplitA();
	}
	
	
	
	public static void testNM(){
		PlayerCardsPathValue playerCardsPathValue = new PlayerCardsPathValue(Card.Two2,Card.Seven7);
		Collection<PlayerCardsPathValue> cs = OneStrategy.SELF.generatePlayerCardsPaths(playerCardsPathValue, Card.Seven7);
		HelloWorld.print(cs);
		System.out.println(ProfitUtil.moneyCalcOneHandInReturn(cs, Card.Seven7));
		System.out.println(PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatus(cs, Card.Seven7));
	}
	
	public static void testSCnoSplit2(){
		PlayerCardsPathValue playerCardsPathValue = new PlayerCardsPathValue(Card.Two2,Card.Two2);
		Collection<PlayerCardsPathValue> cs = OneStrategy.SELF.generatePlayerCardsPaths(playerCardsPathValue, Card.Seven7);
		HelloWorld.print(cs);
	}
	
	public static void testSCSplit7(){
		PlayerCardsPathValue playerCardsPathValue = new PlayerCardsPathValue(Card.Seven7,Card.Seven7);
		Collection<PlayerCardsPathValue> cs = OneStrategy.SELF.generatePlayerCardsPaths(playerCardsPathValue, Card.Six6);
		HelloWorld.print(cs);
	}
	
	public static void testSCSplitA(){
		PlayerCardsPathValue playerCardsPathValue = new PlayerCardsPathValue(Card.One1,Card.One1);
		Collection<PlayerCardsPathValue> cs = OneStrategy.SELF.generatePlayerCardsPaths(playerCardsPathValue, Card.Ten);
		HelloWorld.print(cs);
	}
}
