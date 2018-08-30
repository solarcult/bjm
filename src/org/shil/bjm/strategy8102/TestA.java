package org.shil.bjm.strategy8102;

import java.util.Collection;

import org.shil.bjm.core.PlayerCards;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerCardsPathValue;
import org.shil.bjm.meta.ProfitUtil;

public class TestA {
	private static boolean useMorePercificRate = false;
	
	public static void main(String[] args) {
		testROI();
	}
	
	public static void testROI(){
		double roi = 0;
		Collection<PlayerCardsPathValue> playerCards = PlayerCards.generateTwoStartCards();
//		Collection<PlayerCardsPathValue> playerCards = PlayerCards.generatePairs();
//		Collection<PlayerCardsPathValue> playerCards = PlayerCards.sortedOneValueStartCardsWithA();
//		Collection<PlayerCardsPathValue> playerCards = PlayerCards.generateTwoStartCardsWithoutPairWithoutA();
		for(PlayerCardsPathValue pcpv : playerCards){
			double xoi = 0;
			System.out.println("Player: " +pcpv.getCards());
			for(Card dealerCard : Card.values()){
				PlayerCardsPathValue oneCalc = new PlayerCardsPathValue(pcpv);
				Collection<PlayerCardsPathValue> oneSet = Strategy8012.SELF.generatePlayerCardsPaths(oneCalc, dealerCard);
//				System.out.println(dealerCard+" : " + oneSet.size());
				for(PlayerCardsPathValue one : oneSet){
					double oroi = 0;
					if(useMorePercificRate){
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
}
