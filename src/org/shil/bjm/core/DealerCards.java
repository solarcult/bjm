package org.shil.bjm.core;

import java.util.Collection;
import java.util.Map;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.anaylze.AnalyzeStatus;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.DealerCardsPathValue;

/**
 * 预先计算庄家爱的所有牌组合
 * @author vanis
 *
 */
public class DealerCards {
	
	public static Collection<DealerCardsPathValue> StartOne = GenerateCardsUtil.generateDealerCards(new DealerCardsPathValue(Card.One1));
	public static Collection<DealerCardsPathValue> StartTwo = GenerateCardsUtil.generateDealerCards(new DealerCardsPathValue(Card.Two2));
	public static Collection<DealerCardsPathValue> StartThree = GenerateCardsUtil.generateDealerCards(new DealerCardsPathValue(Card.Three3));
	public static Collection<DealerCardsPathValue> StartFour = GenerateCardsUtil.generateDealerCards(new DealerCardsPathValue(Card.Four4));
	public static Collection<DealerCardsPathValue> StartFive = GenerateCardsUtil.generateDealerCards(new DealerCardsPathValue(Card.Five5));
	public static Collection<DealerCardsPathValue> StartSix = GenerateCardsUtil.generateDealerCards(new DealerCardsPathValue(Card.Six6));
	public static Collection<DealerCardsPathValue> StartSeven = GenerateCardsUtil.generateDealerCards(new DealerCardsPathValue(Card.Seven7));
	public static Collection<DealerCardsPathValue> StartEight = GenerateCardsUtil.generateDealerCards(new DealerCardsPathValue(Card.Eight8));
	public static Collection<DealerCardsPathValue> StartNine = GenerateCardsUtil.generateDealerCards(new DealerCardsPathValue(Card.Nine9));
	public static Collection<DealerCardsPathValue> StartTen = GenerateCardsUtil.generateDealerCards(new DealerCardsPathValue(Card.Ten));
	public static Collection<DealerCardsPathValue> StartJ = GenerateCardsUtil.generateDealerCards(new DealerCardsPathValue(Card.JJJ));
	public static Collection<DealerCardsPathValue> StartQ = GenerateCardsUtil.generateDealerCards(new DealerCardsPathValue(Card.QQQ));
	public static Collection<DealerCardsPathValue> StartK = GenerateCardsUtil.generateDealerCards(new DealerCardsPathValue(Card.KKK));
	
	public static Collection<DealerCardsPathValue> fetchDealerCards(Card card){
		switch(card){
			case One1:
				return StartOne;
			case Two2:
				return StartTwo;
			case Three3:
				return StartThree;
			case Four4:
				return StartFour;
			case Five5:
				return StartFive;
			case Six6:
				return StartSix;
			case Seven7:
				return StartSeven;
			case Eight8:
				return StartEight;
			case Nine9: 
				return StartNine;
			case Ten:
				return StartTen;
			case JJJ:
				return StartJ;
			case QQQ:
				return StartQ;
			case KKK:
				return StartK;
			default:
				return null;
		}
	}

	
	public static Map<Integer,AnalyzeStatus> analyzeDealerCardValuePrecent(Card card){
		return DealerCardsAnalyzeStatus.fetchDealerAnalyzeStatusMap(card);
	}
	
	public static void main(String[] args){

		System.out.println(StartSeven.size());
		HelloWorld.printMap(analyzeDealerCardValuePrecent(Card.Seven7));
		System.out.println("---");
		/**
		 * 根据概率来告诉我们的是,当庄家是7时,有73%的概率不爆牌,太诡异了.到底按照TIME来思考还是概率,现实中,会坍塌到一个具体实现上.Time是现实,而Prob则是概率云. 两者兼顾?最后看ROI?只有ROI才是投入产出比,概率云坍塌到现实就是Time的落地,收益看ROI?
1921
17 : AnalyzeStatus [value=17, precent=0.3761331925528958, tillPct=0.3761331925528958, prob=0.029891379540627403, tillProb=0.029891379540627403, totalProb=0.07947019867549648]
18 : AnalyzeStatus [value=18, precent=0.13683227968413889, tillPct=0.5129654722370347, prob=0.010874088451719619, tillProb=0.040765467992347024, totalProb=0.07947019867549648]
19 : AnalyzeStatus [value=19, precent=0.07499285078149504, tillPct=0.5879583230185297, prob=0.005959696750847272, tillProb=0.0467251647431943, totalProb=0.07947019867549648]
20 : AnalyzeStatus [value=20, precent=0.07588217541722264, tillPct=0.6638404984357523, prob=0.006030371556335559, tillProb=0.05275553629952986, totalProb=0.07947019867549648]
21 : AnalyzeStatus [value=21, precent=0.07172018412895473, tillPct=0.7355606825647071, prob=0.005699617281771222, tillProb=0.05845515358130108, totalProb=0.07947019867549648]
22 : AnalyzeStatus [value=22, precent=0.06349919867537028, tillPct=0.7990598812400773, prob=0.005046293934466499, tillProb=0.06350144751576758, totalProb=0.07947019867549648]
23 : AnalyzeStatus [value=23, precent=0.0584039735202208, tillPct=0.8574638547602981, prob=0.004641375379090383, tillProb=0.06814282289485797, totalProb=0.07947019867549648]
24 : AnalyzeStatus [value=24, precent=0.05395963203027362, tillPct=0.9114234867905717, prob=0.004288182677902528, tillProb=0.0724310055727605, totalProb=0.07947019867549648]
25 : AnalyzeStatus [value=25, precent=0.047776529150098744, tillPct=0.9592000159406705, prob=0.0037968102635839965, tillProb=0.0762278158363445, totalProb=0.07947019867549648]
26 : AnalyzeStatus [value=26, precent=0.04079998405933234, tillPct=1.0000000000000029, prob=0.003242382839152231, tillProb=0.07947019867549673, totalProb=0.07947019867549648]
---
		 */
		System.out.println("One:" + StartOne.size());
//		HelloWorld.print(DealerCards.StartOne);
		HelloWorld.printMap(analyzeDealerCardValuePrecent(Card.One1));
		System.out.println("2:" +StartTwo.size());
		HelloWorld.printMap(analyzeDealerCardValuePrecent(Card.Two2));
		System.out.println("3:" +StartThree.size());
		HelloWorld.printMap(analyzeDealerCardValuePrecent(Card.Three3));
		System.out.println("4:" +StartFour.size());
		HelloWorld.printMap(analyzeDealerCardValuePrecent(Card.Four4));
		System.out.println("5:" +StartFive.size());
		HelloWorld.printMap(analyzeDealerCardValuePrecent(Card.Five5));
		System.out.println("6:" +StartSix.size());
		HelloWorld.printMap(analyzeDealerCardValuePrecent(Card.Six6));
		System.out.println("7:" +StartSeven.size());
		HelloWorld.printMap(analyzeDealerCardValuePrecent(Card.Seven7));
		System.out.println("8:" +StartEight.size());
		HelloWorld.printMap(analyzeDealerCardValuePrecent(Card.Eight8));
		System.out.println("9:" +StartNine.size());
		HelloWorld.printMap(analyzeDealerCardValuePrecent(Card.Nine9));
		System.out.println("T:" +StartTen.size());
		HelloWorld.printMap(analyzeDealerCardValuePrecent(Card.Ten));
		System.out.println("J:" +StartJ.size());
		HelloWorld.printMap(analyzeDealerCardValuePrecent(Card.JJJ));
		System.out.println("Q:" +StartQ.size());
		HelloWorld.printMap(analyzeDealerCardValuePrecent(Card.QQQ));
		System.out.println("K:" +StartK.size());
		HelloWorld.printMap(analyzeDealerCardValuePrecent(Card.KKK));
	}
	
}
