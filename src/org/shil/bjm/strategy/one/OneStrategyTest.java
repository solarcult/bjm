package org.shil.bjm.strategy.one;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.shil.bjm.anaylze.DealerVSPlayerChance;
import org.shil.bjm.anaylze.PlayersVSDealersResultChanceProb;
import org.shil.bjm.core.DealerCards;
import org.shil.bjm.core.GenerateCardsUtil;
import org.shil.bjm.core.PlayerCards;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.DealerCardsPathValue;
import org.shil.bjm.meta.PlayerCardsPathValue;
import org.shil.bjm.meta.ProbUtil;
import org.shil.bjm.strategy.ProfitUtil;

/**
 * 运行看最终ROI的类
 * @author vanis
 *
 */
public class OneStrategyTest{
	
//	private static boolean useMorePercificRate = true;
	private static boolean useMorePercificRate = false;

	public static void main(String[] args){
//		testROI();
//		winRateWithProb();
		pureWinRate();
	}
	
	public static void pureWinRate() {
		Collection<PlayerCardsPathValue> playerCards = PlayerCards.generateTwoStartCards();
		double win = 0;
		double total = 0;
		double giveup = 0;
		for(PlayerCardsPathValue pcpv : playerCards){
//			System.out.println("Player: " +pcpv.getCards());
			for(Card dealerCard : Card.values()){
				PlayerCardsPathValue oneCalc = new PlayerCardsPathValue(pcpv);
				Collection<PlayerCardsPathValue> oneSet = OneStrategy.SELF.generatePlayerCardsPaths(oneCalc, dealerCard);
//				System.out.println(dealerCard+" : " + oneSet.size());
				for(PlayerCardsPathValue one : oneSet){
					Collection<DealerCardsPathValue> dealers = DealerCards.fetchDealerCards(dealerCard);
					for(DealerCardsPathValue dv : dealers) {
						double result = ProfitUtil.win(one, dv);
						if(result>0) {
							win+=result;
							total += result;
						}else if(result<0){
							total += Math.abs(result);
							if(result==-0.5) giveup++;
						}
					}
				}
			}
		}
		
		System.out.println("win: "+win+" total: "+total +" rate: "+win/total);
		System.out.println(giveup);
	}
	
	public static void winRateWithProb() {
		Collection<PlayerCardsPathValue> playerCards = PlayerCards.generateTwoStartCards();
		double bigWinTimes = 0;
		double bigTotalTimes = 0;
		double detailWinTimes = 0;
		double detailTotalTimes = 0;
		double roi = 0;
		for(PlayerCardsPathValue pcpv : playerCards){
			System.out.println("Player: " +pcpv.getCards());
			for(Card dealerCard : Card.values()){
				double onePlayCardVsDealerCardROI = 0;
				PlayerCardsPathValue oneCalc = new PlayerCardsPathValue(pcpv);
				Collection<PlayerCardsPathValue> oneSet = OneStrategy.SELF.generatePlayerCardsPaths(oneCalc, dealerCard);
//				System.out.println(dealerCard+" : " + oneSet.size());
				for(PlayerCardsPathValue one : oneSet){
					double eroi = 0;
					if(OneStrategyTest.useMorePercificRate){
						eroi = ProfitUtil.oldFashionWayMoneyCalcOneHandInReturn(one, dealerCard);
					}else{
						eroi = ProfitUtil.moneyCalcOneHandInReturn(one, dealerCard);
					}
					onePlayCardVsDealerCardROI += eroi;
					if(eroi>0) detailWinTimes++;
					detailTotalTimes++;
					System.out.println(eroi +" \t "+dealerCard+" : "+one.getCards());
					roi+=eroi;
				}
				if(onePlayCardVsDealerCardROI>0) bigWinTimes++;
				bigTotalTimes++;
			}
		}
		System.out.println("detailwin: "+detailWinTimes +" detailtotal: "+detailTotalTimes +"\t detailresult: "+detailWinTimes/detailTotalTimes);
		System.out.println("bigwin: "+bigWinTimes +" bigtotal: "+bigTotalTimes +"\t bigresult: "+bigWinTimes/bigTotalTimes);
		System.out.println(roi);
	}
	
	public static void testROI(){
		double roi = 0;
		Collection<PlayerCardsPathValue> playerCards = PlayerCards.generateTwoStartCards();
//		Collection<PlayerCardsPathValue> playerCards = PlayerCards.generatePairs();
//		Collection<PlayerCardsPathValue> playerCards = PlayerCards.sortedOneValueStartCardsWithA();
//		Collection<PlayerCardsPathValue> playerCards = PlayerCards.generateTwoStartCardsWithoutPairWithoutA();
		for(PlayerCardsPathValue pcpv : playerCards){
			double xoi = 0;
//			System.out.println("Player: " +pcpv.getCards());
			for(Card dealerCard : Card.values()){
				PlayerCardsPathValue oneCalc = new PlayerCardsPathValue(pcpv);
				Collection<PlayerCardsPathValue> oneSet = OneStrategy.SELF.generatePlayerCardsPaths(oneCalc, dealerCard);
//				System.out.println(dealerCard+" : " + oneSet.size());
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
//			System.out.println(" xoi: " + xoi);
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
