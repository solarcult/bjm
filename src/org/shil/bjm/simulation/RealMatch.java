package org.shil.bjm.simulation;

import org.apache.commons.math3.stat.Frequency;
import org.shil.bjm.HelloWorld;
import org.shil.bjm.core.GenerateCardsUtil;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.DealerCardsPathValue;
import org.shil.bjm.meta.PlayerCardsPathValue;
import org.shil.bjm.meta.ProfitUtil;
import org.shil.bjm.strategy8102.EvolutionOneWayTest;
import org.shil.bjm.strategy8102.Strategy8012;
import org.shil.bjm.strategy8102.strategy.Finally2047;
import org.shil.bjm.strategy8102.strategy.Standard2017;
import org.shil.bjm.strategy8102.strategy.StrategyMatrix8012;
import org.shil.bjm.strategy8102.strategy.test.Finally2046;
import org.shil.bjm.strategy8102.strategy.test.Finally2049;
import org.shil.bjm.strategy8102.strategy.test.Finally2050;
import org.shil.bjm.strategy8102.strategy.test.Standard2018;
import org.shil.bjm.strategy8102.test.TestAnything2048;
import org.shil.bjm.strategy8102.test.TestMatrix;

public class RealMatch {
	
	@Deprecated
	public static double oneMatch() {
		Casion6Deck casion6Deck = new Casion6Deck();
		Card p1 = casion6Deck.fetchOne();
		Card dealer1 = casion6Deck.fetchOne();
		Card p2 = casion6Deck.fetchOne();
		
		PlayerCardsPathValue pr = Strategy8012.generateOneMatch(casion6Deck,new Finally2047(), new PlayerCardsPathValue(p1,p2), dealer1);
		
		DealerCardsPathValue dealerCardsPathValue = new DealerCardsPathValue(dealer1);
		
		DealerCardsPathValue dr = GenerateCardsUtil.generateDealerOneMatch(casion6Deck, dealerCardsPathValue);
		
//		System.out.println(pr.getValue());
//		if(pr.getValue()==11) {
//			System.out.println(pr.getValue()+" : " + pr.getCards());
//			System.out.println(dr.getValue()+" : " + dr.getCards());
//		}
//		System.out.println(dr.getValue());
		double result = ProfitUtil.calcPureReturn(pr, dr,ProfitUtil.BaseMoney);
//		System.out.println(result);
		
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static PlayerCardsPathValue getOnePlayerCards(Casion6Deck casion6Deck,StrategyMatrix8012 strategyMatrix8012,Card dealerCard) {
		Card p1 = casion6Deck.fetchOne();
		Card p2 = casion6Deck.fetchOne();		
		PlayerCardsPathValue pr = Strategy8012.generateOneMatch(casion6Deck,strategyMatrix8012, new PlayerCardsPathValue(p1,p2), dealerCard);
		return pr;
	}
	
	public static double oneMatch(Casion6Deck casion6Deck,double baseMoney) {
		
		Card dealerCard = casion6Deck.fetchOne();
		
		PlayerCardsPathValue p1 = getOnePlayerCards(casion6Deck, new Finally2046(), dealerCard);
		PlayerCardsPathValue p2 = getOnePlayerCards(casion6Deck, new Finally2047(), dealerCard);
		PlayerCardsPathValue p3 = getOnePlayerCards(casion6Deck, new Standard2017(), dealerCard);
		PlayerCardsPathValue p4 = getOnePlayerCards(casion6Deck, new Finally2050(), dealerCard);
		PlayerCardsPathValue p5 = getOnePlayerCards(casion6Deck, new Finally2049(), dealerCard);
		PlayerCardsPathValue p6 = getOnePlayerCards(casion6Deck, new TestMatrix(), dealerCard);
		PlayerCardsPathValue p7 = getOnePlayerCards(casion6Deck, new TestAnything2048(), dealerCard);
		
		DealerCardsPathValue dealerCardsPathValue = new DealerCardsPathValue(dealerCard);
		DealerCardsPathValue dr = GenerateCardsUtil.generateDealerOneMatch(casion6Deck, dealerCardsPathValue);
		
		PlayerCardsPathValue test = p2;
		
		if(EvolutionOneWayTest.debug)System.out.println("bet:" + baseMoney);
		if(EvolutionOneWayTest.debug)System.out.println(test.getValue()+" : " + test.getCards()+" ds: "+test.getDsTimes());	
		if(EvolutionOneWayTest.debug)System.out.println(dr.getValue()+" : " + dr.getCards());
		double result = ProfitUtil.calcPureReturn(test, dr,baseMoney);
		if(EvolutionOneWayTest.debug)System.out.println("roi:" +result);
		if(EvolutionOneWayTest.debug)System.out.println("---");
		
		try {
			if(EvolutionOneWayTest.debug) Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public static void main(String[] args) {
		Frequency frequency = new Frequency();
		EvolutionOneWayTest.debug = false;
		Casion6Deck casion6Deck = new Casion6Deck();
		double baseMoney = 0d;
		double result = 0 ;
		double w = 0;
		double d = 0;
		double l = 0;
		for(int i=1;i<=1000;i++) {
			baseMoney = ProfitUtil.BaseMoney;
			casion6Deck.reset();
			int count = casion6Deck.getCount();
			if(EvolutionOneWayTest.debug)System.out.println("count: "+count);
			if(count>=5) {
				baseMoney += (count/5)*100;
//				baseMoney += (count/5)*(count/5)*100;
			}
			double roi = oneMatch(casion6Deck,baseMoney);
			
			/*
			 * below code is not good,cause can't show the true w d l to me,
			 * should not use this anymore,
			 * it makes me crazy.
			if(roi>0)w++;
			else if(roi==0)d++;
			else if(roi<0) l++;
			*/
			if(roi>0)w+=roi;
			else if (roi==0) d+=baseMoney;
			else if(roi<0) l+=Math.abs(roi);
			
			result += roi;
			if(EvolutionOneWayTest.debug) System.out.println("\t\ti: "+i+"\t\t t:"+result);
			if(i%100 ==0) {
				System.out.println(i+ " : "+ result);
				HelloWorld.printDoubleWDL(new double[] {w/(w+d+l),d/(w+d+l),l/(w+d+l)});
			}
			frequency.incrementValue(count,(long)roi);
			
			if(result < -30000) break;
		}
		System.out.println(result);
		System.out.println(frequency);
	}

}
