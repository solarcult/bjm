package org.shil.bjm.simulation;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.shil.bjm.HelloWorld;
import org.shil.bjm.core.GenerateCardsUtil;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.DealerCardsPathValue;
import org.shil.bjm.meta.PlayerCardsPathValue;
import org.shil.bjm.meta.ProfitUtil;
import org.shil.bjm.strategy8102.EvolutionOneWayTest;
import org.shil.bjm.strategy8102.Strategy8012;
import org.shil.bjm.strategy8102.strategy.StrategyMatrix8012;
import org.shil.bjm.strategy8102.strategy.practise.Finally2046;
import org.shil.bjm.strategy8102.strategy.practise.Finally2047;
import org.shil.bjm.strategy8102.strategy.practise.Finally2049;
import org.shil.bjm.strategy8102.strategy.practise.Finally2051;
import org.shil.bjm.strategy8102.strategy.practise.Myth2019April13;
import org.shil.bjm.strategy8102.strategy.practise.Pareto2Mar26;
import org.shil.bjm.strategy8102.strategy.practise.Standard2017;


public class RealMatch {
	
	public static DescriptiveStatistics m0 = new DescriptiveStatistics();
	public static DescriptiveStatistics m1 = new DescriptiveStatistics();
	public static DescriptiveStatistics m2 = new DescriptiveStatistics();
	public static DescriptiveStatistics m3 = new DescriptiveStatistics();
	public static DescriptiveStatistics m4 = new DescriptiveStatistics();
	
	public static void summary() {
		int looptime = 1000;
		for(int i=0;i<looptime;i++) {
			
//			String result = testSelectedStrategy(new Finally2046(),new Finally2047(), new Finally2049(),new BestInMyth2019(), new Standard2017());
			String result = testSameStartCard(new Finally2046(),new Finally2047(), new Finally2049(),new Myth2019April13(), new Standard2017());
			System.out.println(result);
			System.out.println();
			
			if(i% 20==0) {
				System.out.println("-------"+i+"--------");
				System.out.println(m0);
				System.out.println(m1);
				System.out.println(m2);
				System.out.println(m3);
				System.out.println(m4);
				System.out.println();
			}
		}
		
		System.out.println("-------finally----------");
		System.out.println(m0);
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
		System.out.println(m4);

	}
	public static PlayerCardsPathValue getOnePlayerCards(Casion6Deck casion6Deck,StrategyMatrix8012 strategyMatrix8012,Card dealerCard) {
		Card p1 = casion6Deck.fetchOne();
		Card p2 = casion6Deck.fetchOne();		
		PlayerCardsPathValue pr = Strategy8012.generateOneMatch(casion6Deck,strategyMatrix8012, new PlayerCardsPathValue(p1,p2), dealerCard);
		return pr;
	}
	
	public static String testSameStartCard(StrategyMatrix8012 ... strategyMatrix8012s) {

		double w0 = 0;
		double d0 = 0;
		double l0 = 0;
		double w1 = 0;
		double d1 = 0;
		double l1 = 0;
		double w2 = 0;
		double d2 = 0;
		double l2= 0;
		double w3 = 0;
		double d3 = 0;
		double l3 = 0;
		double w4 = 0;
		double d4 = 0;
		double l4 = 0;
		StrategyMatrix8012 s0 = strategyMatrix8012s[0];
		StrategyMatrix8012 s1 = strategyMatrix8012s[1];
		StrategyMatrix8012 s2 = strategyMatrix8012s[2];
		StrategyMatrix8012 s3 = strategyMatrix8012s[3];
		StrategyMatrix8012 s4 = strategyMatrix8012s[4];
		double g0 = 0;
		double g1 = 0;
		double g2 = 0;
		double g3 = 0;
		double g4 = 0;
		
		for(int i=0;i<testLoopTimes;i++) {
			Casion6Deck casion6Deck = new Casion6Deck();
			Card dealerCard = casion6Deck.fetchOne();
			
			Card p1 = casion6Deck.fetchOne();
			Card p2 = casion6Deck.fetchOne();		
			PlayerCardsPathValue p0s = Strategy8012.generateOneMatch(casion6Deck,s0, new PlayerCardsPathValue(p1,p2), dealerCard);
			PlayerCardsPathValue p1s = Strategy8012.generateOneMatch(casion6Deck,s1, new PlayerCardsPathValue(p1,p2),dealerCard);
			PlayerCardsPathValue p2s = Strategy8012.generateOneMatch(casion6Deck,s2, new PlayerCardsPathValue(p1,p2),dealerCard);
			PlayerCardsPathValue p3s = Strategy8012.generateOneMatch(casion6Deck,s3, new PlayerCardsPathValue(p1,p2),dealerCard);
			PlayerCardsPathValue p4s = Strategy8012.generateOneMatch(casion6Deck,s4, new PlayerCardsPathValue(p1,p2),dealerCard);
			
			DealerCardsPathValue dcs = GenerateCardsUtil.generateDealerOneMatch(casion6Deck, new DealerCardsPathValue(dealerCard));
			
			double m0 = ProfitUtil.calcPureReturnAfterPareto(p0s, dcs,ProfitUtil.BaseMoney);
			double m1 = ProfitUtil.calcPureReturnAfterPareto(p1s, dcs,ProfitUtil.BaseMoney);
			double m2 = ProfitUtil.calcPureReturnAfterPareto(p2s, dcs,ProfitUtil.BaseMoney);
			double m3 = ProfitUtil.calcPureReturnAfterPareto(p3s, dcs,ProfitUtil.BaseMoney);
			double m4 = ProfitUtil.calcPureReturnAfterPareto(p4s, dcs,ProfitUtil.BaseMoney);
			
			//用胜负次数衡量结果
			if(m0 > 0) w0+=Math.pow(2, p0s.getSplitTimes());
			else if(m0 == 0) d0+=Math.pow(2, p0s.getSplitTimes());
			else if(m0 < 0) l0+=Math.pow(2, p0s.getSplitTimes());
			g0 += m0;
			
			if(m1 > 0) w1+=Math.pow(2, p1s.getSplitTimes());
			else if(m1 == 0) d1+=Math.pow(2, p1s.getSplitTimes());
			else if(m1 < 0) l1+=Math.pow(2, p1s.getSplitTimes());
			g1 += m1;
			
			if(m2 > 0) w2+=Math.pow(2, p2s.getSplitTimes());
			else if(m2 == 0) d2+=Math.pow(2, p2s.getSplitTimes());
			else if(m2 < 0) l2+=Math.pow(2, p2s.getSplitTimes());
			g2 += m2;
			
			if(m3 > 0) w3+=Math.pow(2, p3s.getSplitTimes());
			else if(m3 == 0) d3+=Math.pow(2, p3s.getSplitTimes());
			else if(m3 < 0) l3+=Math.pow(2, p3s.getSplitTimes());
			g3 += m3;
			
			if(m4 > 0) w4+=Math.pow(2, p4s.getSplitTimes());
			else if(m4 == 0) d4+=Math.pow(2, p4s.getSplitTimes());
			else if(m4 < 0) l4+=Math.pow(2, p4s.getSplitTimes());
			g4 += m4;
		}
		
		m0.addValue(g0);
		m1.addValue(g1);
		m2.addValue(g2);
		m3.addValue(g3);
		m4.addValue(g4);
		
		
		double[] r0 = new double[] {w0/(w0+d0+l0),d0/(w0+d0+l0),l0/(w0+d0+l0)};
		double[] r1 = new double[] {w1/(w1+d1+l1),d1/(w1+d1+l1),l1/(w1+d1+l1)};
		double[] r2 = new double[] {w2/(w2+d2+l2),d2/(w2+d2+l2),l2/(w2+d2+l2)};
		double[] r3 = new double[] {w3/(w3+d3+l3),d3/(w3+d3+l3),l3/(w3+d3+l3)};
		double[] r4 = new double[] {w4/(w4+d4+l4),d4/(w4+d4+l4),l4/(w4+d4+l4)};
		
		StringBuilder sb = new StringBuilder();
		sb.append("S[0] : tMoney: " + g0 + "\t " + testLoopTimes + " : " + HelloWorld.builderDoubleWDL(r0));
		sb.append("\nS[1] : tMoney: " + g1 + "\t " + testLoopTimes + " : " + HelloWorld.builderDoubleWDL(r1));
		sb.append("\nS[2] : tMoney: " + g2 + "\t " + testLoopTimes + " : " + HelloWorld.builderDoubleWDL(r2));
		sb.append("\nS[3] : tMoney: " + g3 + "\t " + testLoopTimes + " : " + HelloWorld.builderDoubleWDL(r3));
		sb.append("\nS[4] : tMoney: " + g4 + "\t " + testLoopTimes + " : " + HelloWorld.builderDoubleWDL(r4));

		return sb.toString();
	
	}

	static int testLoopTimes = 1000;
	public static String testSelectedStrategy(StrategyMatrix8012 ... strategyMatrix8012s) {
		Casion6Deck casion6Deck = new Casion6Deck();
		if(strategyMatrix8012s.length ==1){
			double w0 = 0;
			double d0 = 0;
			double l0 = 0;
			StrategyMatrix8012 s0 = strategyMatrix8012s[0];
			double g0 = 0;
			
			for(int i=0;i<testLoopTimes;i++) {
				if(EvolutionOneWayTest.debug) System.out.println("testLoopTimes : " + i);
				
				casion6Deck.resetButKeepLastTurnUsed();
				//去掉运气的成分
	//			double baseMoney = ProfitUtil.BaseMoney;
	//			int count = casion6Deck.getCount();
	//			if(count>=5) {
	//				baseMoney += (count/5)*100;
	//			}
				
				Card dealerCard = casion6Deck.fetchOne();
				
				PlayerCardsPathValue p0 = getOnePlayerCards(casion6Deck, s0, dealerCard);

				DealerCardsPathValue dcs = GenerateCardsUtil.generateDealerOneMatch(casion6Deck, new DealerCardsPathValue(dealerCard));
				
				double m0 = ProfitUtil.calcPureReturnAfterPareto(p0, dcs,ProfitUtil.BaseMoney);
				
				//用胜负次数衡量结果
				if(m0 > 0) w0+=Math.pow(2, p0.getSplitTimes());
				else if(m0 == 0) d0+=Math.pow(2, p0.getSplitTimes());
				else if(m0 < 0) l0+=Math.pow(2, p0.getSplitTimes());
				g0 += m0;
				
			}
			
			double[] r0 = new double[] {w0/(w0+d0+l0),d0/(w0+d0+l0),l0/(w0+d0+l0)};
			
			StringBuilder sb = new StringBuilder();
			if(EvolutionOneWayTest.debug) {
				sb.append("S[0] : tMoney: "+g0 + "\t "+testLoopTimes+" : "+HelloWorld.builderDoubleWDL(r0));
			}
			else {
				sb.append("S[0] : tMoney: "+g0 + "\t "+testLoopTimes+" : "+HelloWorld.builderDoubleWDL(r0)+"\t "+s0.getSimpleDesc());
			}

			return sb.toString();
		}else if(strategyMatrix8012s.length == 2){
			double w0 = 0;
			double d0 = 0;
			double l0 = 0;
			double w1 = 0;
			double d1 = 0;
			double l1 = 0;

			StrategyMatrix8012 s0 = strategyMatrix8012s[0];
			StrategyMatrix8012 s1 = strategyMatrix8012s[1];

			double g0 = 0;
			double g1 = 0;

			for(int i=0;i<testLoopTimes;i++) {
				if(EvolutionOneWayTest.debug) System.out.println("testLoopTimes : " + i);

				casion6Deck.resetButKeepLastTurnUsed();
				//去掉运气的成分
	//			double baseMoney = ProfitUtil.BaseMoney;
	//			int count = casion6Deck.getCount();
	//			if(count>=5) {
	//				baseMoney += (count/5)*100;
	//			}
				
				Card dealerCard = casion6Deck.fetchOne();
				
				PlayerCardsPathValue p0 = getOnePlayerCards(casion6Deck, s0, dealerCard);
				PlayerCardsPathValue p1 = getOnePlayerCards(casion6Deck, s1, dealerCard);
				
				DealerCardsPathValue dcs = GenerateCardsUtil.generateDealerOneMatch(casion6Deck, new DealerCardsPathValue(dealerCard));
				
				double m0 = ProfitUtil.calcPureReturnAfterPareto(p0, dcs,ProfitUtil.BaseMoney);
				double m1 = ProfitUtil.calcPureReturnAfterPareto(p1, dcs,ProfitUtil.BaseMoney);

				
				//用胜负次数衡量结果
				if(m0 > 0) w0+=Math.pow(2, p0.getSplitTimes());
				else if(m0 == 0) d0+=Math.pow(2, p0.getSplitTimes());
				else if(m0 < 0) l0+=Math.pow(2, p0.getSplitTimes());
				g0 += m0;
				
				if(m1 > 0) w1+=Math.pow(2, p1.getSplitTimes());
				else if(m1 == 0) d1+=Math.pow(2, p1.getSplitTimes());
				else if(m1 < 0) l1+=Math.pow(2, p1.getSplitTimes());
				g1 += m1;
			}
			
			
			double[] r0 = new double[] {w0/(w0+d0+l0),d0/(w0+d0+l0),l0/(w0+d0+l0)};
			double[] r1 = new double[] {w1/(w1+d1+l1),d1/(w1+d1+l1),l1/(w1+d1+l1)};
			
			StringBuilder sb = new StringBuilder();
			if(EvolutionOneWayTest.debug) {
				sb.append("S[0] : tMoney: "+g0 + "\t "+testLoopTimes+" : "+HelloWorld.builderDoubleWDL(r0));
				sb.append("\nS[1] : tMoney: "+g1 + "\t "+testLoopTimes+" : "+HelloWorld.builderDoubleWDL(r1));
			}else {
				sb.append("S[0] : tMoney: "+g0 + "\t "+testLoopTimes+" : "+HelloWorld.builderDoubleWDL(r0)+"\t "+s0.getSimpleDesc());
				sb.append("\nS[1] : tMoney: "+g1 + "\t "+testLoopTimes+" : "+HelloWorld.builderDoubleWDL(r1)+"\t "+s1.getSimpleDesc());
			}
			return sb.toString();
		}else if(strategyMatrix8012s.length == 3){
			double w0 = 0;
			double d0 = 0;
			double l0 = 0;
			double w1 = 0;
			double d1 = 0;
			double l1 = 0;
			double w2 = 0;
			double d2 = 0;
			double l2= 0;

			StrategyMatrix8012 s0 = strategyMatrix8012s[0];
			StrategyMatrix8012 s1 = strategyMatrix8012s[1];
			StrategyMatrix8012 s2 = strategyMatrix8012s[2];

			double g0 = 0;
			double g1 = 0;
			double g2 = 0;
			
			for(int i=0;i<testLoopTimes;i++) {
				if(EvolutionOneWayTest.debug) System.out.println("testLoopTimes : " + i);

				casion6Deck.resetButKeepLastTurnUsed();
				//去掉运气的成分
	//			double baseMoney = ProfitUtil.BaseMoney;
	//			int count = casion6Deck.getCount();
	//			if(count>=5) {
	//				baseMoney += (count/5)*100;
	//			}
				
				Card dealerCard = casion6Deck.fetchOne();
				
				PlayerCardsPathValue p0 = getOnePlayerCards(casion6Deck, s0, dealerCard);
				PlayerCardsPathValue p1 = getOnePlayerCards(casion6Deck, s1, dealerCard);
				PlayerCardsPathValue p2 = getOnePlayerCards(casion6Deck, s2, dealerCard);
				
				DealerCardsPathValue dcs = GenerateCardsUtil.generateDealerOneMatch(casion6Deck, new DealerCardsPathValue(dealerCard));
				
				double m0 = ProfitUtil.calcPureReturnAfterPareto(p0, dcs,ProfitUtil.BaseMoney);
				double m1 = ProfitUtil.calcPureReturnAfterPareto(p1, dcs,ProfitUtil.BaseMoney);
				double m2 = ProfitUtil.calcPureReturnAfterPareto(p2, dcs,ProfitUtil.BaseMoney);
				
				//用胜负次数衡量结果
				if(m0 > 0) w0+=Math.pow(2, p0.getSplitTimes());
				else if(m0 == 0) d0+=Math.pow(2, p0.getSplitTimes());
				else if(m0 < 0) l0+=Math.pow(2, p0.getSplitTimes());
				g0 += m0;
				
				if(m1 > 0) w1+=Math.pow(2, p1.getSplitTimes());
				else if(m1 == 0) d1+=Math.pow(2, p1.getSplitTimes());
				else if(m1 < 0) l1+=Math.pow(2, p1.getSplitTimes());
				g1 += m1;
				
				if(m2 > 0) w2+=Math.pow(2, p2.getSplitTimes());
				else if(m2 == 0) d2+=Math.pow(2, p2.getSplitTimes());
				else if(m2 < 0) l2+=Math.pow(2, p2.getSplitTimes());
				g2 += m2;

			}
			
			double[] r0 = new double[] {w0/(w0+d0+l0),d0/(w0+d0+l0),l0/(w0+d0+l0)};
			double[] r1 = new double[] {w1/(w1+d1+l1),d1/(w1+d1+l1),l1/(w1+d1+l1)};
			double[] r2 = new double[] {w2/(w2+d2+l2),d2/(w2+d2+l2),l2/(w2+d2+l2)};

			StringBuilder sb = new StringBuilder();
			if(EvolutionOneWayTest.debug) {
				sb.append("S[0] : tMoney: "+g0 + "\t "+testLoopTimes+" : "+HelloWorld.builderDoubleWDL(r0));
				sb.append("\nS[1] : tMoney: "+g1 + "\t "+testLoopTimes+" : "+HelloWorld.builderDoubleWDL(r1));
				sb.append("\nS[2] : tMoney: "+g2 + "\t "+testLoopTimes+" : "+HelloWorld.builderDoubleWDL(r2));
			}else {
				sb.append("S[0] : tMoney: "+g0 + "\t "+testLoopTimes+" : "+HelloWorld.builderDoubleWDL(r0)+"\t "+s0.getSimpleDesc());
				sb.append("\nS[1] : tMoney: "+g1 + "\t "+testLoopTimes+" : "+HelloWorld.builderDoubleWDL(r1)+"\t "+s1.getSimpleDesc());
				sb.append("\nS[2] : tMoney: "+g2 + "\t "+testLoopTimes+" : "+HelloWorld.builderDoubleWDL(r2)+"\t "+s2.getSimpleDesc());
			}

			return sb.toString();
		}else if(strategyMatrix8012s.length == 4){
			double w0 = 0;
			double d0 = 0;
			double l0 = 0;
			double w1 = 0;
			double d1 = 0;
			double l1 = 0;
			double w2 = 0;
			double d2 = 0;
			double l2= 0;
			double w3 = 0;
			double d3 = 0;
			double l3 = 0;

			StrategyMatrix8012 s0 = strategyMatrix8012s[0];
			StrategyMatrix8012 s1 = strategyMatrix8012s[1];
			StrategyMatrix8012 s2 = strategyMatrix8012s[2];
			StrategyMatrix8012 s3 = strategyMatrix8012s[3];

			double g0 = 0;
			double g1 = 0;
			double g2 = 0;
			double g3 = 0;
			
			for(int i=0;i<testLoopTimes;i++) {
				if(EvolutionOneWayTest.debug) System.out.println("testLoopTimes : " + i);

				casion6Deck.resetButKeepLastTurnUsed();
				//去掉运气的成分
	//			double baseMoney = ProfitUtil.BaseMoney;
	//			int count = casion6Deck.getCount();
	//			if(count>=5) {
	//				baseMoney += (count/5)*100;
	//			}
				
				Card dealerCard = casion6Deck.fetchOne();
				
				PlayerCardsPathValue p0 = getOnePlayerCards(casion6Deck, s0, dealerCard);
				PlayerCardsPathValue p1 = getOnePlayerCards(casion6Deck, s1, dealerCard);
				PlayerCardsPathValue p2 = getOnePlayerCards(casion6Deck, s2, dealerCard);
				PlayerCardsPathValue p3 = getOnePlayerCards(casion6Deck, s3, dealerCard);
				
				DealerCardsPathValue dcs = GenerateCardsUtil.generateDealerOneMatch(casion6Deck, new DealerCardsPathValue(dealerCard));
				
				double m0 = ProfitUtil.calcPureReturnAfterPareto(p0, dcs,ProfitUtil.BaseMoney);
				double m1 = ProfitUtil.calcPureReturnAfterPareto(p1, dcs,ProfitUtil.BaseMoney);
				double m2 = ProfitUtil.calcPureReturnAfterPareto(p2, dcs,ProfitUtil.BaseMoney);
				double m3 = ProfitUtil.calcPureReturnAfterPareto(p3, dcs,ProfitUtil.BaseMoney);
				
				//用胜负次数衡量结果
				if(m0 > 0) w0+=Math.pow(2, p0.getSplitTimes());
				else if(m0 == 0) d0+=Math.pow(2, p0.getSplitTimes());
				else if(m0 < 0) l0+=Math.pow(2, p0.getSplitTimes());
				g0 += m0;
				
				if(m1 > 0) w1+=Math.pow(2, p1.getSplitTimes());
				else if(m1 == 0) d1+=Math.pow(2, p1.getSplitTimes());
				else if(m1 < 0) l1+=Math.pow(2, p1.getSplitTimes());
				g1 += m1;
				
				if(m2 > 0) w2+=Math.pow(2, p2.getSplitTimes());
				else if(m2 == 0) d2+=Math.pow(2, p2.getSplitTimes());
				else if(m2 < 0) l2+=Math.pow(2, p2.getSplitTimes());
				g2 += m2;
				
				if(m3 > 0) w3+=Math.pow(2, p3.getSplitTimes());
				else if(m3 == 0) d3+=Math.pow(2, p3.getSplitTimes());
				else if(m3 < 0) l3+=Math.pow(2, p3.getSplitTimes());
				g3 += m3;
				
			}
			
			
			double[] r0 = new double[] {w0/(w0+d0+l0),d0/(w0+d0+l0),l0/(w0+d0+l0)};
			double[] r1 = new double[] {w1/(w1+d1+l1),d1/(w1+d1+l1),l1/(w1+d1+l1)};
			double[] r2 = new double[] {w2/(w2+d2+l2),d2/(w2+d2+l2),l2/(w2+d2+l2)};
			double[] r3 = new double[] {w3/(w3+d3+l3),d3/(w3+d3+l3),l3/(w3+d3+l3)};
			
			StringBuilder sb = new StringBuilder();
			if(EvolutionOneWayTest.debug) {
				sb.append("S[0] : tMoney: "+g0 + "\t "+testLoopTimes+" : "+HelloWorld.builderDoubleWDL(r0));
				sb.append("\nS[1] : tMoney: "+g1 + "\t "+testLoopTimes+" : "+HelloWorld.builderDoubleWDL(r1));
				sb.append("\nS[2] : tMoney: "+g2 + "\t "+testLoopTimes+" : "+HelloWorld.builderDoubleWDL(r2));
				sb.append("\nS[3] : tMoney: "+g3 + "\t "+testLoopTimes+" : "+HelloWorld.builderDoubleWDL(r3));
			}else {
				sb.append("S[0] : tMoney: "+g0 + "\t "+testLoopTimes+" : "+HelloWorld.builderDoubleWDL(r0)+"\t "+s0.getSimpleDesc());
				sb.append("\nS[1] : tMoney: "+g1 + "\t "+testLoopTimes+" : "+HelloWorld.builderDoubleWDL(r1)+"\t "+s1.getSimpleDesc());
				sb.append("\nS[2] : tMoney: "+g2 + "\t "+testLoopTimes+" : "+HelloWorld.builderDoubleWDL(r2)+"\t "+s2.getSimpleDesc());
				sb.append("\nS[3] : tMoney: "+g3 + "\t "+testLoopTimes+" : "+HelloWorld.builderDoubleWDL(r3)+"\t "+s3.getSimpleDesc());
			}
			return sb.toString();
		}else if(strategyMatrix8012s.length >= 5){
			double w0 = 0;
			double d0 = 0;
			double l0 = 0;
			double w1 = 0;
			double d1 = 0;
			double l1 = 0;
			double w2 = 0;
			double d2 = 0;
			double l2= 0;
			double w3 = 0;
			double d3 = 0;
			double l3 = 0;
			double w4 = 0;
			double d4 = 0;
			double l4 = 0;
			StrategyMatrix8012 s0 = strategyMatrix8012s[0];
			StrategyMatrix8012 s1 = strategyMatrix8012s[1];
			StrategyMatrix8012 s2 = strategyMatrix8012s[2];
			StrategyMatrix8012 s3 = strategyMatrix8012s[3];
			StrategyMatrix8012 s4 = strategyMatrix8012s[4];
			double g0 = 0;
			double g1 = 0;
			double g2 = 0;
			double g3 = 0;
			double g4 = 0;
			
			for(int i=0;i<testLoopTimes;i++) {
//				if(EvolutionOneWayTest.debug) System.out.println("testLoopTimes : " + i);

				casion6Deck.resetButKeepLastTurnUsed();
				//去掉运气的成分
	//			double baseMoney = ProfitUtil.BaseMoney;
	//			int count = casion6Deck.getCount();
	//			if(count>=5) {
	//				baseMoney += (count/5)*100;
	//			}
				
				Card dealerCard = casion6Deck.fetchOne();
				
				PlayerCardsPathValue p0 = getOnePlayerCards(casion6Deck, s0, dealerCard);
				PlayerCardsPathValue p1 = getOnePlayerCards(casion6Deck, s1, dealerCard);
				PlayerCardsPathValue p2 = getOnePlayerCards(casion6Deck, s2, dealerCard);
				PlayerCardsPathValue p3 = getOnePlayerCards(casion6Deck, s3, dealerCard);
				PlayerCardsPathValue p4 = getOnePlayerCards(casion6Deck, s4, dealerCard);
				
				DealerCardsPathValue dcs = GenerateCardsUtil.generateDealerOneMatch(casion6Deck, new DealerCardsPathValue(dealerCard));
				
				double m0 = ProfitUtil.calcPureReturnAfterPareto(p0, dcs,ProfitUtil.BaseMoney);
				double m1 = ProfitUtil.calcPureReturnAfterPareto(p1, dcs,ProfitUtil.BaseMoney);
				double m2 = ProfitUtil.calcPureReturnAfterPareto(p2, dcs,ProfitUtil.BaseMoney);
				double m3 = ProfitUtil.calcPureReturnAfterPareto(p3, dcs,ProfitUtil.BaseMoney);
				double m4 = ProfitUtil.calcPureReturnAfterPareto(p4, dcs,ProfitUtil.BaseMoney);
				
				//用胜负次数衡量结果
				if(m0 > 0) w0+=Math.pow(2, p0.getSplitTimes());
				else if(m0 == 0) d0+=Math.pow(2, p0.getSplitTimes());
				else if(m0 < 0) l0+=Math.pow(2, p0.getSplitTimes());
				g0 += m0;
				
				if(m1 > 0) w1+=Math.pow(2, p1.getSplitTimes());
				else if(m1 == 0) d1+=Math.pow(2, p1.getSplitTimes());
				else if(m1 < 0) l1+=Math.pow(2, p1.getSplitTimes());
				g1 += m1;
				
				if(m2 > 0) w2+=Math.pow(2, p2.getSplitTimes());
				else if(m2 == 0) d2+=Math.pow(2, p2.getSplitTimes());
				else if(m2 < 0) l2+=Math.pow(2, p2.getSplitTimes());
				g2 += m2;
				
				if(m3 > 0) w3+=Math.pow(2, p3.getSplitTimes());
				else if(m3 == 0) d3+=Math.pow(2, p3.getSplitTimes());
				else if(m3 < 0) l3+=Math.pow(2, p3.getSplitTimes());
				g3 += m3;
				
				if(m4 > 0) w4+=Math.pow(2, p4.getSplitTimes());
				else if(m4 == 0) d4+=Math.pow(2, p4.getSplitTimes());
				else if(m4 < 0) l4+=Math.pow(2, p4.getSplitTimes());
				g4 += m4;
			}
			
			m0.addValue(g0);
			m1.addValue(g1);
			m2.addValue(g2);
			m3.addValue(g3);
			m4.addValue(g4);
			
			
			double[] r0 = new double[] {w0/(w0+d0+l0),d0/(w0+d0+l0),l0/(w0+d0+l0)};
			double[] r1 = new double[] {w1/(w1+d1+l1),d1/(w1+d1+l1),l1/(w1+d1+l1)};
			double[] r2 = new double[] {w2/(w2+d2+l2),d2/(w2+d2+l2),l2/(w2+d2+l2)};
			double[] r3 = new double[] {w3/(w3+d3+l3),d3/(w3+d3+l3),l3/(w3+d3+l3)};
			double[] r4 = new double[] {w4/(w4+d4+l4),d4/(w4+d4+l4),l4/(w4+d4+l4)};
			
			StringBuilder sb = new StringBuilder();
			if(EvolutionOneWayTest.debug) {
				sb.append("S[0] : tMoney: "+g0 + "\t "+testLoopTimes+" : "+HelloWorld.builderDoubleWDL(r0));
				sb.append("\nS[1] : tMoney: "+g1 + "\t "+testLoopTimes+" : "+HelloWorld.builderDoubleWDL(r1));
				sb.append("\nS[2] : tMoney: "+g2 + "\t "+testLoopTimes+" : "+HelloWorld.builderDoubleWDL(r2));
				sb.append("\nS[3] : tMoney: "+g3 + "\t "+testLoopTimes+" : "+HelloWorld.builderDoubleWDL(r3));
				sb.append("\nS[4] : tMoney: "+g4 + "\t "+testLoopTimes+" : "+HelloWorld.builderDoubleWDL(r4));
			}else {
				sb.append("S[0] : tMoney: "+g0 + "\t "+testLoopTimes+" : "+HelloWorld.builderDoubleWDL(r0)+"\t "+s0.getSimpleDesc());
				sb.append("\nS[1] : tMoney: "+g1 + "\t "+testLoopTimes+" : "+HelloWorld.builderDoubleWDL(r1)+"\t "+s1.getSimpleDesc());
				sb.append("\nS[2] : tMoney: "+g2 + "\t "+testLoopTimes+" : "+HelloWorld.builderDoubleWDL(r2)+"\t "+s2.getSimpleDesc());
				sb.append("\nS[3] : tMoney: "+g3 + "\t "+testLoopTimes+" : "+HelloWorld.builderDoubleWDL(r3)+"\t "+s3.getSimpleDesc());
				sb.append("\nS[4] : tMoney: "+g4 + "\t "+testLoopTimes+" : "+HelloWorld.builderDoubleWDL(r4)+"\t "+s4.getSimpleDesc());
			}
			return sb.toString();
		}
		
		return "testTopStrategy input length : " + strategyMatrix8012s.length;
	}
	
	public static void main(String[] args) {
		EvolutionOneWayTest.debug = true;
		summary();
		/*
		
		String result = testSelectedStrategy(new Finally2046(),new Finally2047(), new Finally2049(),new BestInMyth2019(), new Standard2017());
		System.out.println(result);
		
		int max = 5;
		int middle = Math.floorDiv(max, 2);
		System.out.println(middle);
		System.out.println(Math.floorDiv(middle,2));
		System.out.println(Math.floorDiv(middle,2)+middle);
		*/
		
		/**
-------finally----------
DescriptiveStatistics:
n: 1000
min: -27900.0
max: 20000.0
mean: -5177.299999999999
std dev: 7124.906947393048
median: -5300.0
skewness: 0.04017135377569612
kurtosis: -0.09137296622584179

DescriptiveStatistics:
n: 1000
min: -24300.0
max: 19500.0
mean: -5400.700000000001
std dev: 6916.622671447321
median: -5600.0
skewness: 0.05798730994382364
kurtosis: -0.17187911099820719

DescriptiveStatistics:
n: 1000
min: -29000.0
max: 13300.0
mean: -5211.900000000001
std dev: 7136.862279264863
median: -5300.0
skewness: -0.08929428112932794
kurtosis: 0.08817632874237091

DescriptiveStatistics:
n: 1000
min: -25300.0
max: 16000.0
mean: -5194.4000000000015
std dev: 7172.265334608759
median: -5600.0
skewness: 0.0646481667278315
kurtosis: -0.25818068700475516

DescriptiveStatistics:
n: 1000
min: -27100.0
max: 15900.0
mean: -6055.299999999999
std dev: 7032.142129744815
median: -6000.0
skewness: -0.05337906392393866
kurtosis: -0.09853169829499997
		 */
	}

}
