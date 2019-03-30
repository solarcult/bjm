package org.shil.bjm.strategy8102.test;

import java.util.Collection;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.anaylze.DealerVSPlayerResult9102;
import org.shil.bjm.anaylze.RivalAnalyze9102;
import org.shil.bjm.core.DealerCards;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerCardsPathValue;
import org.shil.bjm.meta.ProfitUtil;
import org.shil.bjm.meta.StartValue;
import org.shil.bjm.simulation.Casion6Deck;
import org.shil.bjm.strategy8102.Strategy8012;
import org.shil.bjm.strategy8102.strategy.BestInMyth2019;
import org.shil.bjm.strategy8102.strategy.MatrixKey;
import org.shil.bjm.strategy8102.strategy.Situation;
import org.shil.bjm.strategy8102.strategy.StrategyMatrix8012;
import org.shil.bjm.strategy8102.strategy.test.MirBestInMyth2019;

public class TestBestInMyth2019 {
	
	public static void test9vs2() {
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
		
		Card dealerCard = Card.Two2;
		PlayerCardsPathValue nine = new PlayerCardsPathValue(Card.Five5,Card.Four4);
		Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, nine, dealerCard); 
		HelloWorld.print(origin);
		PlayerCardsPathValue ninet = new PlayerCardsPathValue(Card.Five5,Card.Four4);
		Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, ninet, dealerCard); 
		HelloWorld.print(advanced);
		
		System.out.println(o.diffWith(t));
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(origin,dealerCard) +" -> " + ProfitUtil.moneyCalcOneHandInReturnProb(advanced,dealerCard));
		
		DealerVSPlayerResult9102 result = new DealerVSPlayerResult9102(dealerCard, 9, RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), origin),RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), advanced));
		
		System.out.println(result);
		
		/**
MatrixKey [startValue=Nine, dealerCard=Two2, situation=Splited_Pair_And_Can_NOT_Split] : Hit -> Double
MatrixKey [startValue=Nine, dealerCard=Two2, situation=Start_Hand_WithoutA_WithoutPair] : Hit -> Double

0.010362352082320525 -> 0.010990793496551209

		 @@@   dealerCard=Two2, 	playerStartValue=9	@@@ 
[ProbMatrix: total: o: 3.8787131356503394E-4  -> a: 3.8787131356505687E-4
org->adv	$w:50.330510203633935->48.72497115889837  	$d:8.244297516416104->7.272755267781325  	$l:41.425192279949954->44.00227357332031
	 improve value x$w(high is good):-1.6055390447355649  	x$d:-0.9715422486347789  	 x$l(negative is good):2.5770812933703553
	 	 $w-$l: 8.905317923683981 -> 4.722697585578062  _ @double@	 lift : -4.182620338105919 : bad	 :| stand
[TimeMatrix: total:  o: 1307761.0 -> a: 346957.0
org->adv	$w:57.72744408190793->65.6816262533974  	$d:4.292221590948193->4.517562695089017  	$l:37.98033432714387->29.800811051513588
	 improve value x$w(high is good):7.954182171489464  	x$d:0.2253411041408242  	 x$l(negative is good):-8.179523275630284
	 	 $w-$l: 19.747109754764057 -> 35.880815201883806  _ @double@	 lift : 16.133705447119752 : good	 :) hit 
[Prob_ROI diff: -0.04182620338030074 (up%-> -3.8406024772470326) . o: 1.0890531792366602 -> a: 1.0472269758563595	 returnMoney: o:0.12672374615198892 a: 0.24371358163573556	 totalSpendMoney: o: 0.11636139406967454 a: 0.23272278813906716
[Time_ROI diff: 0.1613370544711974 (up%-> 13.473148103666752) . o: 1.1974710975476406 -> a: 1.358808152018838	 returnMoney: o:4.698018E8 a: 2.828688E8	 totalSpendMoney: o: 3.923283E8 a: 2.081742E8
	 [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0
		 */
		
	// Hit -> Double 后，prob_ROI降低3%，选择Hit
	}
	
	public static void test9vs7() {
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 a = new MirBestInMyth2019();
		
		Card dealerCard = Card.Seven7;
		PlayerCardsPathValue nine = new PlayerCardsPathValue(Card.Five5,Card.Four4);
		Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, nine, dealerCard); 
		HelloWorld.print(origin);
		PlayerCardsPathValue ninet = new PlayerCardsPathValue(Card.Five5,Card.Four4);
		Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),a, ninet, dealerCard); 
		HelloWorld.print(advanced);
		
		System.out.println(o.diffWith(a));
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(origin,dealerCard) +" -> " + ProfitUtil.moneyCalcOneHandInReturnProb(advanced,dealerCard));
		
		DealerVSPlayerResult9102 result = new DealerVSPlayerResult9102(dealerCard, 9, RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), origin),RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), advanced));
		
		System.out.println(result);
		
		/**

MatrixKey [startValue=Nine, dealerCard=Seven7, situation=Start_Hand_WithoutA_WithoutPair] : Double -> Hit
MatrixKey [startValue=Nine, dealerCard=Seven7, situation=Splited_Pair_And_Can_NOT_Split] : Double -> Hit

0.020954369234906286 -> 0.023708861757466834

		 @@@   dealerCard=Seven7, 	playerStartValue=9	@@@ 
[ProbMatrix: total: o: 4.231323420710192E-4  -> a: 4.2313234207070705E-4
org->adv	$w:50.571558979686->54.28090539776909  	$d:7.110552406241929->10.115451926754787  	$l:42.31788861407206->35.603642675476124
	 improve value x$w(high is good):3.7093464180830864  	x$d:3.0048995205128577  	 x$l(negative is good):-6.714245938595937
	 	 $w-$l: 8.25367036561394 -> 18.677262722292966  _ @double@	 lift : 10.423592356679023 : good	 :) hit 
[TimeMatrix: total:  o: 24973.0 -> a: 1477249.0
org->adv	$w:65.55079485844712->31.583368815954522  	$d:4.536899851839987->3.5686603950992692  	$l:29.912305289712886->64.84797078894621
	 improve value x$w(high is good):-33.9674260424926  	x$d:-0.9682394567407178  	 x$l(negative is good):34.93566549923332
	 	 $w-$l: 35.63848956873424 -> -33.264601972991684  _  _ 	 lift : -68.90309154172593 : bad	 :| stand
[Prob_ROI diff: 0.1042359235669601 (up%-> 9.628858145400862) . o: 1.0825367036562632 -> a: 1.1867726272232233	 returnMoney: o:0.27483377447752416 a: 0.15064856437878113	 totalSpendMoney: o: 0.2538794052425883 a: 0.12693970262127155
[Time_ROI diff: -0.6890309154172592 (up%-> -50.799070205518305) . o: 1.3563848956873423 -> a: 0.6673539802700831	 returnMoney: o:2.03238E7 a: 2.957544E8	 totalSpendMoney: o: 1.49838E7 a: 4.431747E8
	 [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0
	 
		 */
		
	//Double -> Hit 后, prob_roi提升了9% 的收益率,选择 Hit
	}
	
	public static void test9vs6() {
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
		
		Card dealerCard = Card.Six6;
		PlayerCardsPathValue nine = new PlayerCardsPathValue(Card.Five5,Card.Four4);
		Collection<PlayerCardsPathValue> niceO = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, nine, dealerCard); 
		HelloWorld.print(niceO);
		PlayerCardsPathValue ninet = new PlayerCardsPathValue(Card.Five5,Card.Four4);
		Collection<PlayerCardsPathValue> niceT = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, ninet, dealerCard); 
		HelloWorld.print(niceT);
		
		System.out.println(o.diffWith(t));
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(niceO,dealerCard) +" o->a " + ProfitUtil.moneyCalcOneHandInReturnProb(niceT,dealerCard));
		
		DealerVSPlayerResult9102 result = new DealerVSPlayerResult9102(dealerCard, 9, RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), niceO),RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), niceT));
		
		System.out.println(result);
	}
	
	public static void test16vs7() {
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
		
		Card dealerCard = Card.Seven7;
		PlayerCardsPathValue nine = new PlayerCardsPathValue(Card.Six6,Card.Ten);
		Collection<PlayerCardsPathValue> niceO = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, nine, dealerCard); 
		HelloWorld.print(niceO);
		PlayerCardsPathValue ninet = new PlayerCardsPathValue(Card.Six6,Card.Ten);
		Collection<PlayerCardsPathValue> niceT = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, ninet, dealerCard); 
		HelloWorld.print(niceT);
		System.out.println(RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), niceT));
		System.out.println(o.diffWith(t));
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(niceO,dealerCard) +" o->a " + ProfitUtil.moneyCalcOneHandInReturnProb(niceT,dealerCard));
		System.out.println(RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), niceO));

		DealerVSPlayerResult9102 result = new DealerVSPlayerResult9102(dealerCard, nine.getValue() , RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), niceO),RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), niceT));
		
		System.out.println(result);
	}	

	public static void main(String[] args) {
//		test9vs2();
		test9vs6();
//		test9vs7();

//		test16vs7();
		
		
//		System.out.println(new BestInMath2019().fetchPlayAction(new MatrixKey(StartValue.getOne(9), Card.Eight8, Situation.Splited_Pair_And_Can_NOT_Split), 0));
//		HelloWorld.print(Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(), new BestInMath2019(), new PlayerCardsPathValue(Card.Nine9,Card.Nine9), Card.Eight8)); 
	}

}
