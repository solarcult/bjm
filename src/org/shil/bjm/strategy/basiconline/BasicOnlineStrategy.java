package org.shil.bjm.strategy.basiconline;

import java.util.Collection;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.anaylze.PlayersVSDealersResultChanceProb;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerCardsPathValue;
import org.shil.bjm.meta.ProfitUtil;
import org.shil.bjm.strategy.PlayerStrategyMatrix;
import org.shil.bjm.strategy.Strategy;

public class BasicOnlineStrategy extends Strategy{
	
	
	public BasicOnlineStrategy(PlayerStrategyMatrix nmSM, PlayerStrategyMatrix scSM, PlayerStrategyMatrix waSM) {
		super(nmSM, scSM, waSM);
	}

	public static BasicOnlineStrategy SELF = new BasicOnlineStrategy(BasicNMatrix.SELF,BasicPairCardMatrix.SELF,BasicWithAMatrix.SELF);
	
	public static void main(String[] args){
//		testNM();
//		testSCnoSplit2();
//		testSCSplit7();
//		testSCSplitA();
	}
	
	
	
	public static void testNM(){
		PlayerCardsPathValue playerCardsPathValue = new PlayerCardsPathValue(Card.Two2,Card.Seven7);
		Collection<PlayerCardsPathValue> cs = BasicOnlineStrategy.SELF.generatePlayerCardsPaths(playerCardsPathValue, Card.Seven7);
		HelloWorld.print(cs);
		System.out.println(ProfitUtil.moneyCalcOneHandInReturn(cs, Card.Seven7));
		System.out.println(PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatus(cs, Card.Seven7));
	}
	
	public static void testSCnoSplit2(){
		PlayerCardsPathValue playerCardsPathValue = new PlayerCardsPathValue(Card.Two2,Card.Two2);
		Collection<PlayerCardsPathValue> cs = BasicOnlineStrategy.SELF.generatePlayerCardsPaths(playerCardsPathValue, Card.Seven7);
		HelloWorld.print(cs);
	}
	
	public static void testSCSplit7(){
		PlayerCardsPathValue playerCardsPathValue = new PlayerCardsPathValue(Card.Seven7,Card.Seven7);
		Collection<PlayerCardsPathValue> cs = BasicOnlineStrategy.SELF.generatePlayerCardsPaths(playerCardsPathValue, Card.Six6);
		HelloWorld.print(cs);
	}
	
	public static void testSCSplitA(){
		PlayerCardsPathValue playerCardsPathValue = new PlayerCardsPathValue(Card.One1,Card.One1);
		Collection<PlayerCardsPathValue> cs = BasicOnlineStrategy.SELF.generatePlayerCardsPaths(playerCardsPathValue, Card.Ten);
		HelloWorld.print(cs);
	}
}
