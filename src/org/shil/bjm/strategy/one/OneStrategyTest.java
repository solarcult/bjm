package org.shil.bjm.strategy.one;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.shil.bjm.anaylze.DealerVSPlayerChance;
import org.shil.bjm.anaylze.PlayersVSDealersResultChanceProb;
import org.shil.bjm.core.GenerateCardsUtil;
import org.shil.bjm.core.PlayerCards;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerCardsPathValue;
import org.shil.bjm.strategy.ProfitUtil;

public class OneStrategyTest{
	
//	private static boolean useMorePercificRate = true;
	private static boolean useMorePercificRate = false;

	public static void main(String[] args){
		testROI();
	}
	
	public static void testROI(){
		double roi = 0;
		Collection<PlayerCardsPathValue> playerCards = PlayerCards.generateTwoStartCards();
//		Collection<PlayerCardsPathValue> playerCards = PlayerCards.generatePairs();
//		Collection<PlayerCardsPathValue> playerCards = PlayerCards.sortedOneValueStartCardsWithA();
		for(PlayerCardsPathValue pcpv : playerCards){
			double xoi = 0;
			System.out.println("Player: " +pcpv.getCards());
			for(Card dealerCard : Card.values()){
				PlayerCardsPathValue oneCalc = new PlayerCardsPathValue(pcpv);
				Collection<PlayerCardsPathValue> oneSet = OneStrategy.SELF.generatePlayerCardsPaths(oneCalc, dealerCard);
				System.out.println(dealerCard+" : " + oneSet.size());
				for(PlayerCardsPathValue one : oneSet){
					double oroi = 0;
					if(OneStrategyTest.useMorePercificRate){
						oroi = ProfitUtil.oldFashionWayMoneyCalcOneHandInReturn(one, dealerCard);
					}else{
						oroi = ProfitUtil.moneyCalcOneHandInReturn(one, dealerCard);
					}
					roi+=oroi;
					xoi+=oroi;
//					if(pcpv.isStartWithPairs() && pcpv.getCards().get(0) == Card.One1){
//						System.out.println(one);
//					}
				}
			}
			System.out.println(" xoi: " + xoi);
		}
		System.out.println("\nFinally: " + roi);
	}
	
	public static void testNM(){
		List<DealerVSPlayerChance> diff = new ArrayList<DealerVSPlayerChance>();
		for (PlayerCardsPathValue playerCardsPathValue : PlayerCards.sortedOneValueStartCardsWithoutA()) {
			for (Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue; 
				Collection<PlayerCardsPathValue> playerOneMoreCards = GenerateCardsUtil.hitPlayerOneMoreCard(playerCardsPathValue);
				if(playerOneMoreCards.size()!=13) throw new RuntimeException("wtf 13");
				double[] playerOneMore = PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatus(playerOneMoreCards, dealerCard);
				double[] playerNow = PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatus(playerCardsPathValue,dealerCard);
				DealerVSPlayerChance dealerVSPlayerChance = new DealerVSPlayerChance(dealerCard, playerCardsPathValue.getValue(), playerNow,playerOneMore);
				diff.add(dealerVSPlayerChance);
			}
		}
	}
}
