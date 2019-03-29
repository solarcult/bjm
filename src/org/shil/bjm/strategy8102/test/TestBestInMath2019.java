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
import org.shil.bjm.strategy8102.strategy.BestInMath2019;
import org.shil.bjm.strategy8102.strategy.MatrixKey;
import org.shil.bjm.strategy8102.strategy.Situation;
import org.shil.bjm.strategy8102.strategy.StrategyMatrix8012;
import org.shil.bjm.strategy8102.strategy.test.MirBestInMath2019;

public class TestBestInMath2019 {
	
	public static void test9vs2() {
		StrategyMatrix8012 o = new BestInMath2019();
		StrategyMatrix8012 t = new MirBestInMath2019();
		
		Card dealerCard = Card.Two2;
		PlayerCardsPathValue nine = new PlayerCardsPathValue(Card.Five5,Card.Four4);
		Collection<PlayerCardsPathValue> niceO = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, nine, dealerCard); 
		HelloWorld.print(niceO);
		PlayerCardsPathValue ninet = new PlayerCardsPathValue(Card.Five5,Card.Four4);
		Collection<PlayerCardsPathValue> niceT = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, ninet, dealerCard); 
		HelloWorld.print(niceT);
		
		System.out.println(o.diffWith(t));
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(niceO,dealerCard) +" -> " + ProfitUtil.moneyCalcOneHandInReturnProb(niceT,dealerCard));
		
		DealerVSPlayerResult9102 result = new DealerVSPlayerResult9102(dealerCard, 9, RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), niceO),RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), niceT));
		
		System.out.println(result);
		
		/**
MatrixKey [startValue=Nine, dealerCard=Two2, situation=Start_Hand_WithoutA_WithoutPair] : Double -> Hit

0.01099079349655103 -> 0.010362352082320444

		 @@@ dealerCard=Two2, 	playerStartValue=9	@@@ 
ProbMatrix: total: a: 3.878713135651022E-4 o: 3.8787131356506814E-4
org->adv	$w:48.72497115890197->50.330510203639  	$d:7.272755267780999->8.244297516415735  	$l:44.00227357331703->41.425192279945264
	 improve value x$w(high is good):1.6055390447370286  	x$d:0.9715422486347354  	 x$l(negative is good):-2.577081293371762
	 	 $w-$l: 4.72269758558494 -> 8.905317923693733  _ @double@	 lift : 4.182620338108794 : good	 :) hit 
TimeMatrix: total: a: 1307761.0 o: 346957.0
org->adv	$w:48.72497115890197->57.72744408190793  	$d:7.272755267780999->4.292221590948193  	$l:44.00227357331703->37.98033432714387
	 improve value x$w(high is good):9.00247292300596  	x$d:-2.980533676832806  	 x$l(negative is good):-6.0219392461731545
	 	 $w-$l: 4.72269758558494 -> 19.747109754764057  _ @double@	 lift : 15.024412169179119 : good	 :) hit 
RoI diff: -0.1694573356485125 a: 1.206327114504378 o: 1.3757844501528904	 returnMoney: a:4.529622E8 o: 2.734644E8	 totalSpendMoney: a: 3.754887E8 o: 1.987698E8	deckStatus=0
	 [isDouble()=false, isHit()=true, isSurrender()=false]
		 */
		
	// Double -> Hit 后，胜率变高，ROI降低，通盘考虑，选择Hit
	}
	
	public static void test9vs7() {
		StrategyMatrix8012 o = new BestInMath2019();
		StrategyMatrix8012 t = new MirBestInMath2019();
		
		Card dealerCard = Card.Seven7;
		PlayerCardsPathValue nine = new PlayerCardsPathValue(Card.Five5,Card.Four4);
		Collection<PlayerCardsPathValue> niceO = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, nine, dealerCard); 
		HelloWorld.print(niceO);
		PlayerCardsPathValue ninet = new PlayerCardsPathValue(Card.Five5,Card.Four4);
		Collection<PlayerCardsPathValue> niceT = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, ninet, dealerCard); 
		HelloWorld.print(niceT);
		
		System.out.println(o.diffWith(t));
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(niceO,dealerCard) +" -> " + ProfitUtil.moneyCalcOneHandInReturnProb(niceT,dealerCard));
		
		DealerVSPlayerResult9102 result = new DealerVSPlayerResult9102(dealerCard, 9, RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), niceO),RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), niceT));
		
		System.out.println(result);
		
		/**
MatrixKey [startValue=Nine, dealerCard=Seven7, situation=Start_Hand_WithoutA_WithoutPair] : Double -> Hit

0.020954369234906248 -> 0.02370886175746679

		 @@@ dealerCard=Seven7, 	playerStartValue=9	@@@ 
ProbMatrix: total: a: 4.2313234207071155E-4 o: 4.231323420710235E-4
org->adv	$w:50.571558979686515->54.28090539778086  	$d:7.110552406241863->10.115451926755512  	$l:42.31788861407162->35.603642675463625
	 improve value x$w(high is good):3.7093464180943485  	x$d:3.004899520513649  	 x$l(negative is good):-6.714245938607995
	 	 $w-$l: 8.253670365614896 -> 18.677262722317238  _ @double@	 lift : 10.423592356702343 : good	 :) hit 
TimeMatrix: total: a: 1477249.0 o: 24973.0
org->adv	$w:50.571558979686515->31.583368815954522  	$d:7.110552406241863->3.5686603950992692  	$l:42.31788861407162->64.84797078894621
	 improve value x$w(high is good):-18.988190163731993  	x$d:-3.5418920111425933  	 x$l(negative is good):22.530082174874593
	 	 $w-$l: 8.253670365614896 -> -33.264601972991684  _  _ 	 lift : -41.51827233860658 : bad	 :| stand
RoI diff: -0.7182784876674753 a: 0.6550436599835314 o: 1.3733221476510067	 returnMoney: a:2.79939E8 o: 1.9644E7	 totalSpendMoney: a: 4.273593E8 o: 1.4304E7	deckStatus=0
	 [isDouble()=false, isHit()=false, isSurrender()=false]
		 */
		
	//Double -> Hit 后，roi降低严重，变为亏损，time胜率降低严重，选择Double
	}
	
	public static void test9vs8() {
		StrategyMatrix8012 o = new BestInMath2019();
		StrategyMatrix8012 t = new MirBestInMath2019();
		
		Card dealerCard = Card.Eight8;
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
		StrategyMatrix8012 o = new BestInMath2019();
		StrategyMatrix8012 t = new MirBestInMath2019();
		
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
//		test9vs7();
//		test9vs8();
		test16vs7();
		
		
//		System.out.println(new BestInMath2019().fetchPlayAction(new MatrixKey(StartValue.getOne(9), Card.Eight8, Situation.Splited_Pair_And_Can_NOT_Split), 0));
//		HelloWorld.print(Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(), new BestInMath2019(), new PlayerCardsPathValue(Card.Nine9,Card.Nine9), Card.Eight8)); 
	}

}
