package org.shil.bjm.strategy8102.test;

import java.util.Collection;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.anaylze.DealerVSPlayerResult9102;
import org.shil.bjm.anaylze.RivalAnalyze9102;
import org.shil.bjm.core.DealerCards;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerCardsPathValue;
import org.shil.bjm.meta.ProfitUtil;
import org.shil.bjm.simulation.Casion6Deck;
import org.shil.bjm.strategy8102.Strategy8012;
import org.shil.bjm.strategy8102.strategy.BestInMyth2019;
import org.shil.bjm.strategy8102.strategy.StrategyMatrix8012;
import org.shil.bjm.strategy8102.strategy.test.MirBestInMyth2019;

public class TestBestInMyth2019 {
	
	public static void test8vs6() {
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
		
		Card dealerCard = Card.Six6;
		PlayerCardsPathValue nine = new PlayerCardsPathValue(Card.Five5,Card.Three3);
		Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, nine, dealerCard); 
		HelloWorld.print(origin);
		PlayerCardsPathValue ninet = new PlayerCardsPathValue(Card.Five5,Card.Three3);
		Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, ninet, dealerCard); 
		HelloWorld.print(advanced);
		
		System.out.println(o.diffWith(t));
		double onet = ProfitUtil.moneyCalcOneHandInReturnProb(origin,dealerCard) ;
		double anet =  ProfitUtil.moneyCalcOneHandInReturnProb(advanced,dealerCard);
		
		System.out.println("net money diff:  " + (anet - onet)+" , up % -> "+ 100 * ((anet - onet)/Math.abs(onet))  +" .  o: "+onet +" -> a: " +anet);
		
		DealerVSPlayerResult9102 result = new DealerVSPlayerResult9102(dealerCard, nine.getValue(), RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), origin),RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), advanced));
		
		System.out.println(result);
		
		/**
MatrixKey [startValue=Eight, dealerCard=Six6, situation=Start_Hand_WithoutA_WithoutPair] : Hit -> Double
MatrixKey [startValue=Eight, dealerCard=Six6, situation=Splited_Pair_And_Can_NOT_Split] : Hit -> Double

net money diff:  -0.00365773254643797 , up % -> -23.129611590863142 .  o: 0.015814068178658387 -> a: 0.012156335632220417

		 @@@   dealerCard=Six6, 	playerStartValue=8	@@@ 
[ProbMatrix: total: o: 4.5662969234567407E-4  -> a: 4.566296923457654E-4
org->adv	$w:52.55878911057161->49.520757329415545  	$d:6.426471909439435->5.395463427934745  	$l:41.01473897998895->45.08377924264971
	 improve value x$w(high is good):-3.0380317811560644  	x$d:-1.0310084815046903  	 x$l(negative is good):4.069040262660764
	 	 $w-$l: 11.544050130582667 -> 4.43697808676583  _ @double@	 lift : -7.107072043816837 : bad	 :| stand

[TimeMatrix: total:  o: 115033.0 -> a: 40417.0
org->adv	$w:68.53598532594994->61.74629487591855  	$d:5.012474681178444->3.8696588069376743  	$l:26.45153999287161->34.38404631714377
	 improve value x$w(high is good):-6.789690450031387  	x$d:-1.1428158742407701  	 x$l(negative is good):7.932506324272161
	 	 $w-$l: 42.084445333078335 -> 27.362248558774777  _ @double@	 lift : -14.722196774303558 : bad	 :| stand

[Prob_ROI diff: -0.0710707204382055 (up%-> -6.3715384509528254) . o: 1.1154405013058863 -> a: 1.0443697808676808	 returnMoney: o:0.15280297588238304 a: 0.28613415103967493	 totalSpendMoney: o: 0.13698890770371983 a: 0.2739778154074409

[Time_ROI diff: -0.14722196774303553 (up%-> -10.361582325068284) . o: 1.4208444533307834 -> a: 1.2736224855877478	 returnMoney: o:4.90332E7 a: 3.08856E7	 totalSpendMoney: o: 3.45099E7 a: 2.42502E7

[[Per_Prob_ROI diff: 0.05018909641398684 (up%-> 166.48100594728814) . o: 0.030147040575834762 -> a: 0.0803361369898216	 per returnMoney: o:0.004129810158983325 a: 0.022010319310744226	 per totalSpendMoney: o: 0.003702402910911347 a: 0.021075216569803143

	 [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
		 */
		
		//net money diff:  -0.00365773254643797 , up % -> -23.129611590863142   use : Hit
	}
	
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
		double onet = ProfitUtil.moneyCalcOneHandInReturnProb(origin,dealerCard) ;
		double anet =  ProfitUtil.moneyCalcOneHandInReturnProb(advanced,dealerCard);
		
		System.out.println("net money diff:  " + (anet - onet)+" , up % -> "+ 100 * ((anet - onet)/Math.abs(onet))  +" .  o: "+onet +" -> a: " +anet);
		
		DealerVSPlayerResult9102 result = new DealerVSPlayerResult9102(dealerCard, 9, RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), origin),RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), advanced));
		
		System.out.println(result);
		
		/**
MatrixKey [startValue=Nine, dealerCard=Two2, situation=Start_Hand_WithoutA_WithoutPair] : Hit -> Double
MatrixKey [startValue=Nine, dealerCard=Two2, situation=Splited_Pair_And_Can_NOT_Split] : Hit -> Double

net money diff:  -0.0017152799665249817 , up % -> -16.359058793442376 .  o: 0.010485199596033981 -> a: 0.008769919629509

		 @@@   dealerCard=Two2, 	playerStartValue=9	@@@ 
[ProbMatrix: total: o: 4.566296923454443E-4  -> a: 4.5662969234585687E-4
org->adv	$w:49.764111498007246->48.046379769693935  	$d:8.12582708129371->7.108200223169909  	$l:42.110061420699054->44.84542000713616
	 improve value x$w(high is good):-1.7177317283133107  	x$d:-1.0176268581238013  	 x$l(negative is good):2.7353585864371084
	 	 $w-$l: 7.654050077308194 -> 3.2009597625577757  _  _ 	 lift : -4.453090314750419 : bad	 :| stand

[TimeMatrix: total:  o: 1307761.0 -> a: 346957.0
org->adv	$w:57.72744408190793->65.6816262533974  	$d:4.292221590948193->4.517562695089017  	$l:37.98033432714387->29.800811051513588
	 improve value x$w(high is good):7.954182171489464  	x$d:0.2253411041408242  	 x$l(negative is good):-8.179523275630284
	 	 $w-$l: 19.747109754764057 -> 35.880815201883806  _ @double@	 lift : 16.133705447119752 : good	 :) hit 

[Prob_ROI diff: -0.044530903149366585 (up%-> -4.136481917524167) . o: 1.0765405007746276 -> a: 1.032009597625261	 returnMoney: o:0.1474741072997798 a: 0.2827477350370528	 totalSpendMoney: o: 0.13698890770357866 a: 0.27397781540760724

[Time_ROI diff: 0.1613370544711974 (up%-> 13.473148103666752) . o: 1.1974710975476406 -> a: 1.358808152018838	 returnMoney: o:4.698018E8 a: 2.828688E8	 totalSpendMoney: o: 3.923283E8 a: 2.081742E8

[[Per_Prob_ROI diff: 0.05741513936195862 (up%-> 261.3317220031782) . o: 0.021970214301523013 -> a: 0.07938535366348164	 per returnMoney: o:0.00300967565917918 a: 0.021749825772080986	 per totalSpendMoney: o: 0.002795691993950585 a: 0.021075216569815942

	 [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
		 */
		
		//net money diff:  -0.0017152799665249817 , up % -> -16.359058793442376 use: Hit
	}
	
	public static void test9vs3() {
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
		
		Card dealerCard = Card.Three3;
		PlayerCardsPathValue nine = new PlayerCardsPathValue(Card.Five5,Card.Four4);
		Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, nine, dealerCard); 
		HelloWorld.print(origin);
		PlayerCardsPathValue ninet = new PlayerCardsPathValue(Card.Five5,Card.Four4);
		Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, ninet, dealerCard); 
		HelloWorld.print(advanced);
		
		System.out.println(t.diffWith(o));
		double onet = ProfitUtil.moneyCalcOneHandInReturnProb(origin,dealerCard) ;
		double anet =  ProfitUtil.moneyCalcOneHandInReturnProb(advanced,dealerCard);
		System.out.println("net money diff:  " + (anet - onet)+" , up % -> "+ 100 * ((anet - onet)/Math.abs(onet))  +" .  o: "+onet +" -> a: " +anet);
		
		DealerVSPlayerResult9102 result = new DealerVSPlayerResult9102(dealerCard, 9, RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), origin),RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), advanced));
		
		System.out.println(result);
		
		/**
MatrixKey [startValue=Nine, dealerCard=Three3, situation=Start_Hand_WithoutA_WithoutPair] : Hit -> Double
MatrixKey [startValue=Nine, dealerCard=Three3, situation=Splited_Pair_And_Can_NOT_Split] : Hit -> Double

net money diff:  0.003060163176367793 , up % -> 21.86960019907914 .  o: 0.013992771465921205 -> a: 0.017052934642289

		 @@@   dealerCard=Three3, 	playerStartValue=9	@@@ 
[ProbMatrix: total: o: 4.5662969234577073E-4  -> a: 4.566296923458373E-4
org->adv	$w:51.383619371550935->49.68027154993807  	$d:7.447290082982219->6.863659621408491  	$l:41.169090545466844->43.45606882865344
	 improve value x$w(high is good):-1.7033478216128657  	x$d:-0.583630461573728  	 x$l(negative is good):2.286978283186599
	 	 $w-$l: 10.214528826084091 -> 6.224202721284628  _ @double@	 lift : -3.990326104799463 : bad	 :| stand

[TimeMatrix: total:  o: 388825.0 -> a: 202189.0
org->adv	$w:69.33221886452773->65.66084208339721  	$d:5.052658651064103->4.519533703613946  	$l:25.615122484408154->29.81962421298884
	 improve value x$w(high is good):-3.671376781130519  	x$d:-0.5331249474501574  	 x$l(negative is good):4.204501728580684
	 	 $w-$l: 43.717096380119585 -> 35.84121787040838  _ @double@	 lift : -7.875878509711204 : bad	 :| stand

[Prob_ROI diff: -0.039903261047993244 (up%-> -3.6205082463279092) . o: 1.1021452882607026 -> a: 1.0622420272127093	 returnMoney: o:0.1509816791696807 a: 0.2910307500498025	 totalSpendMoney: o: 0.13698890770376124 a: 0.27397781540752847

[Time_ROI diff: -0.0787587850971121 (up%-> -5.4801263788966175) . o: 1.4371709638011958 -> a: 1.3584121787040837	 returnMoney: o:1.676424E8 a: 1.647936E8	 totalSpendMoney: o: 1.166475E8 a: 1.213134E8

[[Per_Prob_ROI diff: 0.037625113639780314 (up%-> 85.34517644936943) . o: 0.04408581153042809 -> a: 0.0817109251702084	 per returnMoney: o:0.006039267166787227 a: 0.02238698077306173	 per totalSpendMoney: o: 0.00547955630815045 a: 0.02107521656980988

	 [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
	 */
		
	// net money diff:  0.003060163176367793 , up % -> 21.86960019907914  use : Double
	}
	
	public static void test9vs456() {
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
		
		for(Card dealerCard : Card.values()) {
			if(dealerCard.getValue()>=4 && dealerCard.getValue()<=6) {
				PlayerCardsPathValue nine = new PlayerCardsPathValue(Card.Five5,Card.Four4);
				Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, nine, dealerCard); 
				HelloWorld.print(origin);
				PlayerCardsPathValue ninet = new PlayerCardsPathValue(Card.Five5,Card.Four4);
				Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, ninet, dealerCard); 
				HelloWorld.print(advanced);
				
				System.out.println(t.diffWith(o));
				double onet = ProfitUtil.moneyCalcOneHandInReturnProb(origin,dealerCard) ;
				double anet =  ProfitUtil.moneyCalcOneHandInReturnProb(advanced,dealerCard);
				System.out.println("net money diff:  " + (anet - onet)+" , up % -> "+ 100 * ((anet - onet)/Math.abs(onet))  +" .  o: "+onet +" -> a: " +anet);
				
				DealerVSPlayerResult9102 result = new DealerVSPlayerResult9102(dealerCard, 9, RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), origin),RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), advanced));
				
				System.out.println(result);
				System.out.println();
			}
		}
		
		/**
MatrixKey [startValue=Nine, dealerCard=Four4, situation=Splited_Pair_And_Can_NOT_Split] : Hit -> Double
MatrixKey [startValue=Nine, dealerCard=Four4, situation=Start_Hand_WithoutA_WithoutPair] : Hit -> Double
MatrixKey [startValue=Nine, dealerCard=Five5, situation=Start_Hand_WithoutA_WithoutPair] : Hit -> Double
MatrixKey [startValue=Nine, dealerCard=Five5, situation=Splited_Pair_And_Can_NOT_Split] : Hit -> Double
MatrixKey [startValue=Nine, dealerCard=Six6, situation=Start_Hand_WithoutA_WithoutPair] : Hit -> Double
MatrixKey [startValue=Nine, dealerCard=Six6, situation=Splited_Pair_And_Can_NOT_Split] : Hit -> Double

net money diff:  0.007605638259243021 , up % -> 41.90351384659688 .  o: 0.01815035914908291 -> a: 0.02575599740832593

		 @@@   dealerCard=Four4, 	playerStartValue=9	@@@ 
[ProbMatrix: total: o: 4.5662969234579664E-4  -> a: 4.5662969234581084E-4
org->adv	$w:53.028092902641646->51.3862736103733  	$d:7.1933242852358354->6.628212972205231  	$l:39.77858281212252->41.98551341742147
	 improve value x$w(high is good):-1.6418192922683446  	x$d:-0.565111313030604  	 x$l(negative is good):2.2069306052989504
	 	 $w-$l: 13.249510090519124 -> 9.400760192951829  _ @double@	 lift : -3.848749897567294 : bad	 :| stand

[TimeMatrix: total:  o: 226825.0 -> a: 117949.0
org->adv	$w:69.31555163672435->65.64277781074871  	$d:5.0549983467430835->4.520597885526795  	$l:25.62945001653257->29.83662430372449
	 improve value x$w(high is good):-3.6727738259756393  	x$d:-0.534400461216288  	 x$l(negative is good):4.207174287191922
	 	 $w-$l: 43.68610162019178 -> 35.80615350702422  _ @double@	 lift : -7.879948113167562 : bad	 :| stand

[Prob_ROI diff: -0.03848749897560633 (up%-> -3.3984693571606504) . o: 1.132495100905127 -> a: 1.0940076019295206	 returnMoney: o:0.1551392668528222 a: 0.2997338128158049	 totalSpendMoney: o: 0.13698890770373298 a: 0.2739778154074607

[Time_ROI diff: -0.07879948113167545 (up%-> -5.484140793238836) . o: 1.4368610162019178 -> a: 1.3580615350702423	 returnMoney: o:9.77748E7 a: 9.61092E7	 totalSpendMoney: o: 6.80475E7 a: 7.07694E7

[[Per_Prob_ROI diff: 0.03885462688145036 (up%-> 85.77217431315263) . o: 0.045299804036205066 -> a: 0.08415443091765543	 per returnMoney: o:0.006205570674112888 a: 0.0230564471396773	 per totalSpendMoney: o: 0.0054795563081493194 a: 0.02107521656980467

	 [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
	 
	 
------

net money diff:  0.01232854568795471 , up % -> 54.887583732119396 .  o: 0.022461447288560872 -> a: 0.03478999297651558

		 @@@   dealerCard=Five5, 	playerStartValue=9	@@@ 
[ProbMatrix: total: o: 4.566296923457703E-4  -> a: 4.5662969234578515E-4
org->adv	$w:54.72717688115332->53.15018188882732  	$d:6.942190793803782->6.397742061603603  	$l:38.3306323250429->40.45207604956907
	 improve value x$w(high is good):-1.576994992326  	x$d:-0.5444487322001788  	 x$l(negative is good):2.1214437245261735
	 	 $w-$l: 16.39654455611042 -> 12.69810583925825  _ @double@	 lift : -3.6984387168521704 : bad	 :| stand

[TimeMatrix: total:  o: 136825.0 -> a: 71149.0
org->adv	$w:69.3038552896035->65.62987533204965  	$d:5.057555271331993->4.522902640936626  	$l:25.638589439064496->29.847222027013732
	 improve value x$w(high is good):-3.673979957553854  	x$d:-0.5346526303953674  	 x$l(negative is good):4.208632587949236
	 	 $w-$l: 43.665265850539015 -> 35.782653305035915  _ @double@	 lift : -7.882612545503099 : bad	 :| stand

[Prob_ROI diff: -0.036984387168536026 (up%-> -3.1774471750495707) . o: 1.1639654455611537 -> a: 1.1269810583926176	 returnMoney: o:0.1594503549923053 a: 0.3087678083839735	 totalSpendMoney: o: 0.13698890770372782 a: 0.2739778154074396

[Time_ROI diff: -0.07882612545503087 (up%-> -5.486790769387292) . o: 1.43665265850539 -> a: 1.3578265330503592	 returnMoney: o:5.8971E7 a: 5.79648E7	 totalSpendMoney: o: 4.10475E7 a: 4.26894E7

[[Per_Prob_ROI diff: 0.040132232823139824 (up%-> 86.1972169710585) . o: 0.04655861782244615 -> a: 0.08669085064558597	 per returnMoney: o:0.006378014199692212 a: 0.023751369875690268	 per totalSpendMoney: o: 0.005479556308149113 a: 0.021075216569803046

	 [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
	 
	 
------

net money diff:  0.016722673878126836 , up % -> 61.553929467985235 .  o: 0.027167516391986724 -> a: 0.04389019027011356

		 @@@   dealerCard=Six6, 	playerStartValue=9	@@@ 
[ProbMatrix: total: o: 4.566296923457552E-4  -> a: 4.5662969234576336E-4
org->adv	$w:56.561101187199625->54.916220757349855  	$d:6.709707265137189->6.18717314090504  	$l:36.729191547663184->38.896606101745114
	 improve value x$w(high is good):-1.6448804298497706  	x$d:-0.5225341242321493  	 x$l(negative is good):2.1674145540819296
	 	 $w-$l: 19.831909639536445 -> 16.01961465560474  _ @double@	 lift : -3.812294983931702 : bad	 :| stand

[TimeMatrix: total:  o: 77725.0 -> a: 40417.0
org->adv	$w:69.29044708909618->65.61595368285622  	$d:5.057574782888389->4.520375089689982  	$l:25.65197812801544->29.863671227453793
	 improve value x$w(high is good):-3.674493406239961  	x$d:-0.5371996931984064  	 x$l(negative is good):4.211693099438353
	 	 $w-$l: 43.63846896108073 -> 35.75228245540243  _ @double@	 lift : -7.886186505678305 : bad	 :| stand

[Prob_ROI diff: -0.03812294983936715 (up%-> -3.1813687985146624) . o: 1.198319096395433 -> a: 1.160196146556066	 returnMoney: o:0.1641564240957253 a: 0.31786800567756207	 totalSpendMoney: o: 0.13698890770372515 a: 0.2739778154074409

[Time_ROI diff: -0.07886186505678294 (up%-> -5.490302537139323) . o: 1.4363846896108072 -> a: 1.3575228245540243	 returnMoney: o:3.34929E7 a: 3.29202E7	 totalSpendMoney: o: 2.33175E7 a: 2.42502E7

[[Per_Prob_ROI diff: 0.04131309357157237 (up%-> 86.18967538747182) . o: 0.04793276385581732 -> a: 0.08924585742738969	 per returnMoney: o:0.006566256963829013 a: 0.024451385052120158	 per totalSpendMoney: o: 0.005479556308149006 a: 0.021075216569803143

	 [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
	 
		 */
		// use : Double
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
		double onet = ProfitUtil.moneyCalcOneHandInReturnProb(origin,dealerCard) ;
		double anet =  ProfitUtil.moneyCalcOneHandInReturnProb(advanced,dealerCard);
		System.out.println("net money diff:  " + (anet - onet)+" , up % -> "+ 100 * ((anet - onet)/Math.abs(onet))  +" .  o: "+onet +" -> a: " +anet);
		
		DealerVSPlayerResult9102 result = new DealerVSPlayerResult9102(dealerCard, 9, RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), origin),RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), advanced));
		
		System.out.println(result);
		
		/**

MatrixKey [startValue=Nine, dealerCard=Seven7, situation=Splited_Pair_And_Can_NOT_Split] : Hit -> Double
MatrixKey [startValue=Nine, dealerCard=Seven7, situation=Start_Hand_WithoutA_WithoutPair] : Hit -> Double

net money diff:  -0.008462686829091945 , up % -> -35.77679585124392 .  o: 0.02365412169462824 -> a: 0.015191434865536296

		 @@@   dealerCard=Seven7, 	playerStartValue=9	@@@ 
[ProbMatrix: total: o: 4.5662969234561634E-4  -> a: 4.566296923457645E-4
org->adv	$w:53.52324197571202->49.29032247171432  	$d:10.22069635617906->6.964123286417827  	$l:36.25606166810893->43.74555424186785
	 improve value x$w(high is good):-4.2329195039976995  	x$d:-3.2565730697612327  	 x$l(negative is good):7.489492573758923
	 	 $w-$l: 17.2671803076031 -> 5.544768229846469  _ @double@	 lift : -11.722412077756628 : bad	 :| stand

[TimeMatrix: total:  o: 1477249.0 -> a: 24973.0
org->adv	$w:31.583368815954522->65.55079485844712  	$d:3.5686603950992692->4.536899851839987  	$l:64.84797078894621->29.912305289712886
	 improve value x$w(high is good):33.9674260424926  	x$d:0.9682394567407178  	 x$l(negative is good):-34.93566549923332
	 	 $w-$l: -33.264601972991684 -> 35.63848956873424  _ @double@	 lift : 68.90309154172593 : good	 :) hit 

[Prob_ROI diff: -0.11722412077792721 (up%-> -9.996328083475557) . o: 1.1726718030764187 -> a: 1.0554476822984915	 returnMoney: o:0.1606430293983391 a: 0.2891692502729834	 totalSpendMoney: o: 0.13698890770367622 a: 0.2739778154074371

[Time_ROI diff: 0.6890309154172592 (up%-> 103.2481914827875) . o: 0.6673539802700831 -> a: 1.3563848956873423	 returnMoney: o:2.957544E8 a: 2.03238E7	 totalSpendMoney: o: 4.431747E8 a: 1.49838E7

[[Per_Prob_ROI diff: 0.07966335243048378 (up%-> 5224.0633618313295) . o: 0.0015249308232463182 -> a: 0.08118828325373009	 per returnMoney: o:2.0889860780018088E-4 a: 0.022243788482537184	 per totalSpendMoney: o: 1.7813902172129548E-4 a: 0.021075216569802855

	 [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
	 
		 */
	
		//net money diff:  -0.008462686829091945 , up % -> -35.77679585124392   没有大幅度提高，还变成负的了 use : Hit
	}
	
	
	public static void test11vs10() {
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
		
		Card dealerCard = Card.JJJ;
		PlayerCardsPathValue nine = new PlayerCardsPathValue(Card.Six6,Card.Five5);
		Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, nine, dealerCard); 
//		HelloWorld.print(origin);
		PlayerCardsPathValue ninet = new PlayerCardsPathValue(Card.Six6,Card.Five5);
		Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, ninet, dealerCard); 
//		HelloWorld.print(advanced);
		System.out.println(t.diffWith(o));
		
		double onet = ProfitUtil.moneyCalcOneHandInReturnProb(origin,dealerCard) ;
		double anet =  ProfitUtil.moneyCalcOneHandInReturnProb(advanced,dealerCard);
		System.out.println("net money diff:  " + (anet - onet)+" , up % -> "+ 100 * ((anet - onet)/Math.abs(onet))  +" .  o: "+onet +" -> a: " +anet);

		DealerVSPlayerResult9102 result = new DealerVSPlayerResult9102(dealerCard, nine.getValue() , RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), origin),RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), advanced));
		
		System.out.println(result);
		
		/**
MatrixKey [startValue=Eleven, dealerCard=Ten, situation=Start_Hand_WithoutA_WithoutPair] : Hit -> Double

net money diff:  8.027411114830546E-4 , up % -> 9.472461099389399 .  o: 0.008474472505722929 -> a: 0.009277213617205984

		 @@@   dealerCard=JJJ, 	playerStartValue=11	@@@ 
[ProbMatrix: total: o: 4.566296923457684E-4  -> a: 4.5662969234574487E-4
org->adv	$w:47.72311169673528->47.36210689326551  	$d:10.740023834696718->8.66190475865462  	$l:41.536864468568->43.97598834807987
	 improve value x$w(high is good):-0.3610048034697684  	x$d:-2.078119076042098  	 x$l(negative is good):2.4391238795118753
	 	 $w-$l: 6.186247228167286 -> 3.3861185451856346  _  _ 	 lift : -2.8001286829816507 : bad	 :| stand

[TimeMatrix: total:  o: 74305.0 -> a: 5005.0
org->adv	$w:37.06210887558038->71.96803196803197  	$d:3.639055245272862->5.174825174825175  	$l:59.29883587914676->22.857142857142858
	 improve value x$w(high is good):34.90592309245159  	x$d:1.535769929552313  	 x$l(negative is good):-36.4416930220039
	 	 $w-$l: -22.23672700356638 -> 49.11088911088911  _ @double@	 lift : 71.34761611445549 : good	 :) hit 

[Prob_ROI diff: -0.028001286829884453 (up%-> -2.636997498340324) . o: 1.0618624722817496 -> a: 1.0338611854518651	 returnMoney: o:0.14546338020944938 a: 0.28325502902465516	 totalSpendMoney: o: 0.1369889077037208 a: 0.27397781540744676

[Time_ROI diff: 0.7134761611445548 (up%-> 91.74975970690897) . o: 0.7776327299643362 -> a: 1.491108891108891	 returnMoney: o:1.73346E7 a: 4477800.0	 totalSpendMoney: o: 2.22915E7 a: 3003000.0

[[Per_Prob_ROI diff: 0.07402590540157322 (up%-> 1345.4661140631013) . o: 0.005501878094724091 -> a: 0.07952778349629731	 per returnMoney: o:7.536962705152817E-4 a: 0.021788848386511937	 per totalSpendMoney: o: 7.097870865477761E-4 a: 0.021075216569803597

	 [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

		 */
		
		//Double
	}
	
	public static void test12vs2() {
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
		
		Card dealerCard = Card.Two2;
		PlayerCardsPathValue nine = new PlayerCardsPathValue(Card.Four4,Card.Eight8);
		Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, nine, dealerCard); 
//		HelloWorld.print(origin);
		PlayerCardsPathValue ninet = new PlayerCardsPathValue(Card.Four4,Card.Eight8);
		Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, ninet, dealerCard); 
//		HelloWorld.print(advanced);
		System.out.println(o.diffWith(t));

		DealerVSPlayerResult9102 result = new DealerVSPlayerResult9102(dealerCard, nine.getValue() , RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), origin),RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), advanced));
		
		System.out.println(result);
		
		/**
MatrixKey [startValue=Twelve, dealerCard=Two2, situation=Start_Hand_WithoutA_WithoutPair] : Hit -> Stand


		 @@@   dealerCard=Two2, 	playerStartValue=12	@@@ 

net money diff:  -0.004998696828384289 , up % -> -14.225884906436864 .  o: -0.03513803788840229 -> a: -0.04013673471678658

[ProbMatrix: total: o: 4.566296923456397E-4  -> a: 4.5662969234576184E-4
org->adv	$w:34.692296929521795->35.35037055569647  	$d:4.96512651078174->0.0  	$l:60.34257655969646->64.64962944430353
	 improve value x$w(high is good):0.6580736261746765  	x$d:-4.96512651078174  	 x$l(negative is good):4.307052884607067
	 	 $w-$l: -25.650279630174662 -> -29.29925888860705  _  _ 	 lift : -3.648979258432389 : bad	 :| stand

[TimeMatrix: total:  o: 346957.0 -> a: 26689.0
org->adv	$w:46.568594955570866->57.960208325527375  	$d:3.233830128805587->0.0  	$l:50.197574915623555->42.03979167447263
	 improve value x$w(high is good):11.39161336995651  	x$d:-3.233830128805587  	 x$l(negative is good):-8.157783241150923
	 	 $w-$l: -3.6289799600526917 -> 15.920416651054742  _ @double@	 lift : 19.549396611107433 : good	 :) hit 

[Prob_ROI diff: -0.0364897925839065 (up%-> -4.907858752180949) . o: 0.7434972036978694 -> a: 0.7070074111139629	 returnMoney: o:0.10185086981540988 a: 0.0968521729869446	 totalSpendMoney: o: 0.13698890770381217 a: 0.13698890770373118

[Time_ROI diff: 0.1954939661110744 (up%-> 20.28555534952718) . o: 0.9637102003994731 -> a: 1.1592041665105475	 returnMoney: o:1.003098E8 a: 9281400.0	 totalSpendMoney: o: 1.040871E8 a: 8006700.0

[[Per_Prob_ROI diff: 0.6498153185218192 (up%-> 1136.1978362216478) . o: 0.0571920925921438 -> a: 0.7070074111139629	 per returnMoney: o:0.007834682293493067 a: 0.0968521729869446	 per totalSpendMoney: o: 0.010537608284908628 a: 0.13698890770373118

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
		 */
	}
	
	public static void test12vs3() {
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
		
		Card dealerCard = Card.Three3;
		PlayerCardsPathValue nine = new PlayerCardsPathValue(Card.Four4,Card.Eight8);
		Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, nine, dealerCard); 
//		HelloWorld.print(origin);
		PlayerCardsPathValue ninet = new PlayerCardsPathValue(Card.Four4,Card.Eight8);
		Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, ninet, dealerCard); 
//		HelloWorld.print(advanced);
		System.out.println(o.diffWith(t));

		DealerVSPlayerResult9102 result = new DealerVSPlayerResult9102(dealerCard, nine.getValue() , RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), origin),RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), advanced));
		
		System.out.println(result);
		
		/**
MatrixKey [startValue=Twelve, dealerCard=Three3, situation=Start_Hand_WithoutA_WithoutPair] : Stand -> Hit


		 @@@   dealerCard=Three3, 	playerStartValue=12	@@@ 

net money diff:  0.0020665194477642312 , up % -> 5.995467864917605 .  o: -0.03446802642136472 -> a: -0.03240150697360049

[ProbMatrix: total: o: 4.5662969234575924E-4  -> a: 4.5662969234573224E-4
org->adv	$w:37.4194097174952->35.77068718137588  	$d:0.0->4.805975567466577  	$l:62.58059028250481->59.423337251157534
	 improve value x$w(high is good):-1.6487225361193225  	x$d:4.805975567466577  	 x$l(negative is good):-3.157253031347274
	 	 $w-$l: -25.161180565009612 -> -23.65265006978166  _  _ 	 lift : 1.50853049522795 : good	 :| stand

[TimeMatrix: total:  o: 15553.0 -> a: 202189.0
org->adv	$w:57.937375425962834->46.55495600650876  	$d:0.0->3.2355865056951663  	$l:42.06262457403716->50.20945748779607
	 improve value x$w(high is good):-11.382419419454074  	x$d:3.2355865056951663  	 x$l(negative is good):8.146832913758914
	 	 $w-$l: 15.874750851925674 -> -3.654501481287309  _  _ 	 lift : -19.52925233321298 : bad	 :| stand

[Prob_ROI diff: 0.015085304952149547 (up%-> 2.015705895154172) . o: 0.7483881943499372 -> a: 0.7634734993020867	 returnMoney: o:0.10252088128236299 a: 0.10458740073016258	 totalSpendMoney: o: 0.1369889077037277 a: 0.13698890770376307

[Time_ROI diff: -0.19529252333212976 (up%-> -16.8537599344391) . o: 1.1587475085192567 -> a: 0.9634549851871269	 returnMoney: o:5406600.0 a: 5.844E7	 totalSpendMoney: o: 4665900.0 a: 6.06567E7

[[Per_Prob_ROI diff: -0.689659463634392 (up%-> -92.15263800806505) . o: 0.7483881943499372 -> a: 0.05872873071554514	 per returnMoney: o:0.10252088128236299 a: 0.008045184671550968	 per totalSpendMoney: o: 0.1369889077037277 a: 0.010537608284904852

	 Decide: $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

		 */
	}
	
	
	public static void test13vs2() {
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
		
		Card dealerCard = Card.Two2;
		PlayerCardsPathValue nine = new PlayerCardsPathValue(Card.Five5,Card.Eight8);
		Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, nine, dealerCard); 
//		HelloWorld.print(origin);
		PlayerCardsPathValue ninet = new PlayerCardsPathValue(Card.Five5,Card.Eight8);
		Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, ninet, dealerCard); 
//		HelloWorld.print(advanced);
		System.out.println(o.diffWith(t));

		DealerVSPlayerResult9102 result = new DealerVSPlayerResult9102(dealerCard, nine.getValue() , RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), origin),RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), advanced));
		
		System.out.println(result);
		/**
MatrixKey [startValue=Thirteen, dealerCard=Two2, situation=Start_Hand_WithoutA_WithoutPair] : Stand -> Hit


		 @@@   dealerCard=Two2, 	playerStartValue=13	@@@ 

net money diff:  -0.0027894809141025545 , up % -> -6.949944816851024 .  o: -0.04013673471678658 -> a: -0.042926215630889136

[ProbMatrix: total: o: 4.5662969234576184E-4  -> a: 4.5662969234563905E-4
org->adv	$w:35.35037055569647->31.870437504729832  	$d:0.0->4.923583777530266  	$l:64.64962944430353->63.205978717739896
	 improve value x$w(high is good):-3.4799330509666397  	x$d:4.923583777530266  	 x$l(negative is good):-1.4436507265636322
	 	 $w-$l: -29.29925888860705 -> -31.335541213010064  _  _ 	 lift : -2.036282324403016 : bad	 :| stand

[TimeMatrix: total:  o: 26689.0 -> a: 346957.0
org->adv	$w:57.960208325527375->42.11011739206876  	$d:0.0->3.233830128805587  	$l:42.03979167447263->54.65605247912566
	 improve value x$w(high is good):-15.850090933458617  	x$d:3.233830128805587  	 x$l(negative is good):12.616260804653031
	 	 $w-$l: 15.920416651054742 -> -12.545935087056904  _  _ 	 lift : -28.466351738111644 : bad	 :| stand

[Prob_ROI diff: -0.020362823244931216 (up%-> -2.8801428280429895) . o: 0.7070074111139629 -> a: 0.6866445878690317	 returnMoney: o:0.0968521729869446 a: 0.09406269207289081	 totalSpendMoney: o: 0.13698890770373118 a: 0.13698890770377994

[Time_ROI diff: -0.2846635173811165 (up%-> -24.556805919531378) . o: 1.1592041665105475 -> a: 0.874540649129431	 returnMoney: o:9281400.0 a: 9.10284E7	 totalSpendMoney: o: 8006700.0 a: 1.040871E8

[[Per_Prob_ROI diff: -0.654188596662499 (up%-> -92.52924175600332) . o: 0.7070074111139629 -> a: 0.05281881445146398	 per returnMoney: o:0.0968521729869446 a: 0.007235591697914678	 per totalSpendMoney: o: 0.13698890770373118 a: 0.01053760828490615

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
		 */
	}
	
	public static void test14vs10() {
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
		
		Card dealerCard = Card.Ten;
		PlayerCardsPathValue nine = new PlayerCardsPathValue(Card.Six6,Card.Eight8);
		Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, nine, dealerCard); 
//		HelloWorld.print(origin);
		PlayerCardsPathValue ninet = new PlayerCardsPathValue(Card.Six6,Card.Eight8);
		Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, ninet, dealerCard); 
//		HelloWorld.print(advanced);
		System.out.println(o.diffWith(t));

		DealerVSPlayerResult9102 result = new DealerVSPlayerResult9102(dealerCard, nine.getValue() , RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), origin),RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), advanced));
		
		System.out.println(result);
		/**
MatrixKey [startValue=Fourteen, dealerCard=Ten, situation=Start_Hand_WithoutA_WithoutPair] : Stand -> Hit


		 @@@   dealerCard=Ten, 	playerStartValue=14	@@@ 

net money diff:  0.01008719906575374 , up % -> 12.804818925306897 .  o: -0.0787765850075227 -> a: -0.06868938594176896

[ProbMatrix: total: o: 4.566296923457447E-4  -> a: 4.5662969234573284E-4
org->adv	$w:21.24709353187226->21.446969000092288  	$d:0.0->6.9637642815737895  	$l:78.75290646812773->71.58926671833392
	 improve value x$w(high is good):0.19987546822002855  	x$d:6.9637642815737895  	 x$l(negative is good):-7.163639749793816
	 	 $w-$l: -57.505812936255474 -> -50.142297718241636  _ #Surrender#	 lift : 7.363515218013839 : good	 :) hit 

[TimeMatrix: total:  o: 385.0 -> a: 18865.0
org->adv	$w:57.66233766233766->30.38430956798304  	$d:0.0->3.45613570103366  	$l:42.33766233766234->66.1595547309833
	 improve value x$w(high is good):-27.278028094354624  	x$d:3.45613570103366  	 x$l(negative is good):23.821892393320965
	 	 $w-$l: 15.324675324675324 -> -35.77524516300027  _  _ 	 lift : -51.0999204876756 : bad	 :| stand

[Prob_ROI diff: 0.0736351521801385 (up%-> 17.328288236148627) . o: 0.4249418706374462 -> a: 0.4985770228175847	 returnMoney: o:0.05821232269620068 a: 0.06829952176195617	 totalSpendMoney: o: 0.13698890770372338 a: 0.13698890770372513

[Time_ROI diff: -0.5109992048767559 (up%-> -44.30961573818717) . o: 1.1532467532467532 -> a: 0.6422475483699973	 returnMoney: o:133200.0 a: 3634800.0	 totalSpendMoney: o: 115500.0 a: 5659500.0

[[Per_Prob_ROI diff: -0.41476682935545467 (up%-> -97.60554513803778) . o: 0.4249418706374462 -> a: 0.010175041281991525	 per returnMoney: o:0.05821232269620068 a: 0.00139386779106033	 per totalSpendMoney: o: 0.13698890770372338 a: 0.002795691993953574

	 Decide: $Change$  [isDouble()=false, isHit()=true, isSurrender()=true]	deckStatus=0	 ! DeckSet.resetValue= 0

		 */
	}
	
	public static void test15vs9() {
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
		
		Card dealerCard = Card.Nine9;
		PlayerCardsPathValue nine = new PlayerCardsPathValue(Card.Seven7,Card.Eight8);
		Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, nine, dealerCard); 
//		HelloWorld.print(origin);
		PlayerCardsPathValue ninet = new PlayerCardsPathValue(Card.Seven7,Card.Eight8);
		Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, ninet, dealerCard); 
//		HelloWorld.print(advanced);
		System.out.println(t.diffWith(o));

		DealerVSPlayerResult9102 result = new DealerVSPlayerResult9102(dealerCard, nine.getValue() , RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), origin),RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), advanced));
		
		System.out.println(result);
		
		/**
MatrixKey [startValue=Fifteen, dealerCard=Nine9, situation=Start_Hand_WithoutA_WithoutPair] : Stand -> Hit


		 @@@   dealerCard=Nine9, 	playerStartValue=15	@@@ 

net money diff:  0.010068057789132098 , up % -> 13.572155681878915 .  o: -0.07418171457150784 -> a: -0.06411365678237574

[ProbMatrix: total: o: 4.5662969234574503E-4  -> a: 4.566296923457359E-4
org->adv	$w:22.924189332195212->23.385153559597963  	$d:0.0->6.4276138971253856  	$l:77.07581066780477->70.18723254327665
	 improve value x$w(high is good):0.46096422740275145  	x$d:6.4276138971253856  	 x$l(negative is good):-6.888578124528124
	 	 $w-$l: -54.15162133560957 -> -46.80207898367868  _  _ 	 lift : 7.349542351930882 : good	 :) hit 

[TimeMatrix: total:  o: 769.0 -> a: 19225.0
org->adv	$w:57.737321196358906->29.815344603381018  	$d:0.0->3.3810143042912877  	$l:42.26267880364109->66.80364109232771
	 improve value x$w(high is good):-27.921976592977888  	x$d:3.3810143042912877  	 x$l(negative is good):24.54096228868662
	 	 $w-$l: 15.474642392717813 -> -36.98829648894669  _  _ 	 lift : -52.4629388816645 : bad	 :| stand

[Prob_ROI diff: 0.07349542351929944 (up%-> 16.030103061502945) . o: 0.45848378664390627 -> a: 0.5319792101632057	 returnMoney: o:0.06280719313221579 a: 0.07287525092134636	 totalSpendMoney: o: 0.13698890770372363 a: 0.1369889077037221

[Time_ROI diff: -0.5246293888166449 (up%-> -45.43243243243243) . o: 1.154746423927178 -> a: 0.6301170351105332	 returnMoney: o:266400.0 a: 3634200.0	 totalSpendMoney: o: 230700.0 a: 5767500.0

[[Per_Prob_ROI diff: -0.43720461823737805 (up%-> -95.35879587753989) . o: 0.45848378664390627 -> a: 0.02127916840652823	 per returnMoney: o:0.06280719313221579 a: 0.0029150100368538546	 per totalSpendMoney: o: 0.13698890770372363 a: 0.005479556308148884

	 Decide: $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
		 */
	}

	public static void test15vs10() {
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
		
		Card dealerCard = Card.JJJ;
		PlayerCardsPathValue nine = new PlayerCardsPathValue(Card.Six6,Card.Nine9);
		Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, nine, dealerCard); 
//		HelloWorld.print(origin);
		PlayerCardsPathValue ninet = new PlayerCardsPathValue(Card.Six6,Card.Nine9);
		Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, ninet, dealerCard); 
//		HelloWorld.print(advanced);
		System.out.println(t.diffWith(o));
	
		DealerVSPlayerResult9102 result = new DealerVSPlayerResult9102(dealerCard, nine.getValue() , RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), origin),RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), advanced));
		
		System.out.println(result);
		/**
MatrixKey [startValue=Fifteen, dealerCard=Ten, situation=Start_Hand_WithoutA_WithoutPair] : Stand -> Hit


		 @@@   dealerCard=JJJ, 	playerStartValue=15	@@@ 

net money diff:  0.005000544089670683 , up % -> 6.347754334861238 .  o: -0.0787765850075229 -> a: -0.07377604091785221

[ProbMatrix: total: o: 4.566296923457449E-4  -> a: 4.566296923457472E-4
org->adv	$w:21.247093531872242->19.806445664497677  	$d:0.0->6.531623468206573  	$l:78.75290646812776->73.66193086729575
	 improve value x$w(high is good):-1.4406478673745653  	x$d:6.531623468206573  	 x$l(negative is good):-5.09097560083201
	 	 $w-$l: -57.505812936255516 -> -53.85548520279808  _ #Surrender#	 lift : 3.650327733457437 : good	 :) hit 

[TimeMatrix: total:  o: 385.0 -> a: 9625.0
org->adv	$w:57.66233766233766->29.77662337662338  	$d:0.0->3.387012987012987  	$l:42.33766233766234->66.83636363636364
	 improve value x$w(high is good):-27.885714285714283  	x$d:3.387012987012987  	 x$l(negative is good):24.498701298701306
	 	 $w-$l: 15.324675324675324 -> -37.05974025974026  _  _ 	 lift : -52.38441558441558 : bad	 :| stand

[Prob_ROI diff: 0.036503277334582085 (up%-> 8.590181353469442) . o: 0.4249418706374456 -> a: 0.4614451479720277	 returnMoney: o:0.05821232269620068 a: 0.063212866785871	 totalSpendMoney: o: 0.13698890770372357 a: 0.1369889077037232

[Time_ROI diff: -0.5238441558441558 (up%-> -45.42342342342342) . o: 1.1532467532467532 -> a: 0.6294025974025974	 returnMoney: o:133200.0 a: 1817400.0	 totalSpendMoney: o: 115500.0 a: 2887500.0

[[Per_Prob_ROI diff: -0.40648406471856446 (up%-> -95.65639274586121) . o: 0.4249418706374456 -> a: 0.018457805918881107	 per returnMoney: o:0.05821232269620068 a: 0.00252851467143484	 per totalSpendMoney: o: 0.13698890770372357 a: 0.005479556308148928

	 Decide: $Change$  [isDouble()=false, isHit()=true, isSurrender()=true]	deckStatus=0	 ! DeckSet.resetValue= 0
		 */
	}
	
	public static void test16vs7() {
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
		
		Card dealerCard = Card.Seven7;
		PlayerCardsPathValue nine = new PlayerCardsPathValue(Card.Six6,Card.Ten);
		Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, nine, dealerCard); 
//		HelloWorld.print(origin);
		PlayerCardsPathValue ninet = new PlayerCardsPathValue(Card.Six6,Card.Ten);
		Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, ninet, dealerCard); 
//		HelloWorld.print(advanced);
		System.out.println(o.diffWith(t));
		
		double onet = ProfitUtil.moneyCalcOneHandInReturnProb(origin,dealerCard) ;
		double anet =  ProfitUtil.moneyCalcOneHandInReturnProb(advanced,dealerCard);
		System.out.println("net money diff:  " + (anet - onet)+" , up % -> "+ 100 * ((anet - onet)/Math.abs(onet))  +" .  o: "+onet +" -> a: " +anet);

		DealerVSPlayerResult9102 result = new DealerVSPlayerResult9102(dealerCard, nine.getValue() , RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), origin),RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), advanced));
		
		System.out.println(result);
		
		/**
MatrixKey [startValue=Sixteen, dealerCard=Seven7, situation=Start_Hand_WithoutA_WithoutPair] : Hit -> Stand

net money diff:  -0.008941304723162388 , up % -> -15.886321927690597 .  o: -0.05628303872891609 -> a: -0.06522434345207848

		 @@@   dealerCard=Seven7, 	playerStartValue=16	@@@ 
[ProbMatrix: total: o: 4.56629692345737E-4  -> a: 4.566296923457433E-4
org->adv	$w:26.600058528194957->26.19356758682081  	$d:5.714046380375196->0.0  	$l:67.68589509142986->73.8064324131792
	 improve value x$w(high is good):-0.4064909413741482  	x$d:-5.714046380375196  	 x$l(negative is good):6.120537321749339
	 	 $w-$l: -41.0858365632349 -> -47.61286482635838  _  _ 	 lift : -6.52702826312348 : bad	 :| stand

[TimeMatrix: total:  o: 24973.0 -> a: 1921.0
org->adv	$w:28.70299923917831->57.78240499739719  	$d:3.247507307892524->0.0  	$l:68.04949345292917->42.217595002602806
	 improve value x$w(high is good):29.079405758218876  	x$d:-3.247507307892524  	 x$l(negative is good):-25.831898450326364
	 	 $w-$l: -39.34649421375085 -> 15.564809994794377  _ @double@	 lift : 54.91130420854523 : good	 :) hit 

[Prob_ROI diff: -0.0652702826312318 (up%-> -11.078877951188876) . o: 0.589141634367654 -> a: 0.5238713517364222	 returnMoney: o:0.0807058689748081 a: 0.0717645642516458	 totalSpendMoney: o: 0.13698890770371794 a: 0.13698890770372388

[Time_ROI diff: 0.5491130420854522 (up%-> 90.53277876807286) . o: 0.6065350578624915 -> a: 1.1556480999479437	 returnMoney: o:4544100.0 a: 666000.0	 totalSpendMoney: o: 7491900.0 a: 576300.0

[[Per_Prob_ROI diff: 0.4785527644773719 (up%-> 1055.9745866345445) . o: 0.04531858725905031 -> a: 0.5238713517364222	 per returnMoney: o:0.006208143767292931 a: 0.0717645642516458	 per totalSpendMoney: o: 0.01053760828490138 a: 0.13698890770372388

	 [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
		 */
	}
	
	public static void test16vs8() {
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
		
		Card dealerCard = Card.Eight8;
		PlayerCardsPathValue nine = new PlayerCardsPathValue(Card.Six6,Card.Ten);
		Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, nine, dealerCard); 
//		HelloWorld.print(origin);
		PlayerCardsPathValue ninet = new PlayerCardsPathValue(Card.Six6,Card.Ten);
		Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, ninet, dealerCard); 
//		HelloWorld.print(advanced);
		System.out.println(o.diffWith(t));
		
		double onet = ProfitUtil.moneyCalcOneHandInReturnProb(origin,dealerCard) ;
		double anet =  ProfitUtil.moneyCalcOneHandInReturnProb(advanced,dealerCard);
		System.out.println("net money diff:  " + (anet - onet)+" , up % -> "+ 100 * ((anet - onet)/Math.abs(onet))  +" .  o: "+onet +" -> a: " +anet);

		DealerVSPlayerResult9102 result = new DealerVSPlayerResult9102(dealerCard, nine.getValue() , RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), origin),RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), advanced));
		
		System.out.println(result);
		
		/**
MatrixKey [startValue=Sixteen, dealerCard=Eight8, situation=Start_Hand_WithoutA_WithoutPair] : Hit -> Stand

net money diff:  -0.007873762547940533 , up % -> -12.628591908452954 .  o: -0.062348697345032 -> a: -0.07022245989297253

		 @@@   dealerCard=Eight8, 	playerStartValue=16	@@@ 
[ProbMatrix: total: o: 4.566296923457352E-4  -> a: 4.5662969234574357E-4
org->adv	$w:24.315518051098227->24.369289795036504  	$d:5.855280790061805->0.0  	$l:69.82920115883996->75.63071020496349
	 improve value x$w(high is good):0.05377174393827744  	x$d:-5.855280790061805  	 x$l(negative is good):5.8015090461235275
	 	 $w-$l: -45.513683107741734 -> -51.261420409926984  _ #Surrender#	 lift : -5.747737302185252 : bad	 :| stand

[TimeMatrix: total:  o: 14989.0 -> a: 1153.0
org->adv	$w:28.694375875642137->57.7623590633131  	$d:3.249049302822069->0.0  	$l:68.0565748215358->42.2376409366869
	 improve value x$w(high is good):29.06798318767096  	x$d:-3.249049302822069  	 x$l(negative is good):-25.818933884848903
	 	 $w-$l: -39.36219894589366 -> 15.52471812662619  _ @double@	 lift : 54.88691707251985 : good	 :) hit 

[Prob_ROI diff: -0.05747737302184275 (up%-> -10.54895546261638) . o: 0.5448631689225756 -> a: 0.48738579590073283	 returnMoney: o:0.07464021035869135 a: 0.06676644781075126	 totalSpendMoney: o: 0.13698890770372046 a: 0.1369889077037234

[Time_ROI diff: 0.5488691707251985 (up%-> 90.51600836175598) . o: 0.6063780105410634 -> a: 1.155247181266262	 returnMoney: o:2726700.0 a: 399600.0	 totalSpendMoney: o: 4496700.0 a: 345900.0

[[Per_Prob_ROI diff: 0.44547324444515013 (up%-> 1062.8635789859873) . o: 0.04191255145558273 -> a: 0.48738579590073283	 per returnMoney: o:0.005741554642976258 a: 0.06676644781075126	 per totalSpendMoney: o: 0.010537608284901575 a: 0.1369889077037234

	 [isDouble()=false, isHit()=false, isSurrender()=true]	deckStatus=0	 ! DeckSet.resetValue= 0
		 */
		
		//use Hit
	}
	
	public static void test16vs9() {
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
		
		Card dealerCard = Card.Nine9;
		PlayerCardsPathValue nine = new PlayerCardsPathValue(Card.Six6,Card.Ten);
		Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, nine, dealerCard); 
//		HelloWorld.print(origin);
		PlayerCardsPathValue ninet = new PlayerCardsPathValue(Card.Six6,Card.Ten);
		Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, ninet, dealerCard); 
//		HelloWorld.print(advanced);
		System.out.println(t.diffWith(o));
		
		double onet = ProfitUtil.moneyCalcOneHandInReturnProb(origin,dealerCard) ;
		double anet =  ProfitUtil.moneyCalcOneHandInReturnProb(advanced,dealerCard);
		System.out.println("net money diff:  " + (anet - onet)+" , up % -> "+ 100 * ((anet - onet)/Math.abs(onet))  +" .  o: "+onet +" -> a: " +anet);

		DealerVSPlayerResult9102 result = new DealerVSPlayerResult9102(dealerCard, nine.getValue() , RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), origin),RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), advanced));
		
		System.out.println(result);
		/**
MatrixKey [startValue=Sixteen, dealerCard=Nine9, situation=Start_Hand_WithoutA_WithoutPair] : Hit -> Stand

net money diff:  -0.0048342212353632424 , up % -> -6.971010778905251 .  o: -0.06934749333614462 -> a: -0.07418171457150786

		 @@@   dealerCard=Nine9, 	playerStartValue=16	@@@ 
[ProbMatrix: total: o: 4.566296923457391E-4  -> a: 4.5662969234574503E-4
org->adv	$w:21.705066744336403->22.924189332195212  	$d:5.967159535572039->0.0  	$l:72.32777372009154->77.07581066780477
	 improve value x$w(high is good):1.2191225878588092  	x$d:-5.967159535572039  	 x$l(negative is good):4.748036947713231
	 	 $w-$l: -50.62270697575515 -> -54.15162133560957  _ #Surrender#	 lift : -3.528914359854418 : bad	 :| stand

[TimeMatrix: total:  o: 9997.0 -> a: 769.0
org->adv	$w:28.668600580174054->57.737321196358906  	$d:3.2509752925877766->0.0  	$l:68.08042412723817->42.26267880364109
	 improve value x$w(high is good):29.06872061618485  	x$d:-3.2509752925877766  	 x$l(negative is good):-25.817745323597087
	 	 $w-$l: -39.41182354706412 -> 15.474642392717813  _ @double@	 lift : 54.88646593978193 : good	 :) hit 

[Prob_ROI diff: -0.035289143598534634 (up%-> -7.1468364175427315) . o: 0.4937729302424409 -> a: 0.45848378664390627	 returnMoney: o:0.06764141436757844 a: 0.06280719313221579	 totalSpendMoney: o: 0.13698890770372268 a: 0.13698890770372363

[Time_ROI diff: 0.5488646593978193 (up%-> 90.58940069341257) . o: 0.6058817645293588 -> a: 1.154746423927178	 returnMoney: o:1817100.0 a: 266400.0	 totalSpendMoney: o: 2999100.0 a: 230700.0

[[Per_Prob_ROI diff: 0.4205012535483339 (up%-> 1107.0911265719444) . o: 0.03798253309557238 -> a: 0.45848378664390627	 per returnMoney: o:0.005203185720582957 a: 0.06280719313221579	 per totalSpendMoney: o: 0.010537608284901745 a: 0.13698890770372363

	 [isDouble()=false, isHit()=false, isSurrender()=true]	deckStatus=0	 ! DeckSet.resetValue= 0
		 */
		// use Hit
	}
	
	public static void test16vs10() {
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
		
		Card dealerCard = Card.JJJ;
		PlayerCardsPathValue nine = new PlayerCardsPathValue(Card.Six6,Card.Ten);
		Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, nine, dealerCard); 
//		HelloWorld.print(origin);
		PlayerCardsPathValue ninet = new PlayerCardsPathValue(Card.Six6,Card.Ten);
		Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, ninet, dealerCard); 
//		HelloWorld.print(advanced);
		System.out.println(t.diffWith(o));
		
		double onet = ProfitUtil.moneyCalcOneHandInReturnProb(origin,dealerCard) ;
		double anet =  ProfitUtil.moneyCalcOneHandInReturnProb(advanced,dealerCard);
		System.out.println("net money diff:  " + (anet - onet)+" , up % -> "+ 100 * ((anet - onet)/Math.abs(onet))  +" .  o: "+onet +" -> a: " +anet);

		DealerVSPlayerResult9102 result = new DealerVSPlayerResult9102(dealerCard, nine.getValue() , RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), origin),RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), advanced));
		
		System.out.println(result);
		/**
MatrixKey [startValue=Sixteen, dealerCard=Ten, situation=Start_Hand_WithoutA_WithoutPair] : Hit -> Stand

net money diff:  -0.0012359413561666699 , up % -> -1.5939271302980131 .  o: -0.07754064365135617 -> a: -0.07877658500752284

		 @@@   dealerCard=JJJ, 	playerStartValue=16	@@@ 

net money diff:  -0.0012359413561667115 , up % -> -1.5939271302980667 .  o: -0.07754064365135618 -> a: -0.0787765850075229

[ProbMatrix: total: o: 4.566296923457446E-4  -> a: 4.566296923457449E-4
org->adv	$w:18.64970393872917->21.247093531872242  	$d:6.096999210435695->0.0  	$l:75.25329685083514->78.75290646812776
	 improve value x$w(high is good):2.5973895931430704  	x$d:-6.096999210435695  	 x$l(negative is good):3.49960961729262
	 	 $w-$l: -56.603592912105974 -> -57.505812936255516  _ #Surrender#	 lift : -0.902220024149547 : bad	 :| stand

[TimeMatrix: total:  o: 5005.0 -> a: 385.0
org->adv	$w:28.63136863136863->57.66233766233766  	$d:3.2567432567432566->0.0  	$l:68.1118881118881->42.33766233766234
	 improve value x$w(high is good):29.030969030969032  	x$d:-3.2567432567432566  	 x$l(negative is good):-25.77422577422577
	 	 $w-$l: -39.480519480519476 -> 15.324675324675324  _ @double@	 lift : 54.8051948051948 : good	 :) hit 

[Prob_ROI diff: -0.009022200241494083 (up%-> -2.0790200956546356) . o: 0.4339640708789397 -> a: 0.4249418706374456	 returnMoney: o:0.05944826405236709 a: 0.05821232269620068	 totalSpendMoney: o: 0.13698890770372327 a: 0.13698890770372357

[Time_ROI diff: 0.548051948051948 (up%-> 90.55793991416309) . o: 0.6051948051948052 -> a: 1.1532467532467532	 returnMoney: o:908700.0 a: 133200.0	 totalSpendMoney: o: 1501500.0 a: 115500.0

[[Per_Prob_ROI diff: 0.39156001903137333 (up%-> 1172.97273875649) . o: 0.03338185160607228 -> a: 0.4249418706374456	 per returnMoney: o:0.004572943388643622 a: 0.05821232269620068	 per totalSpendMoney: o: 0.01053760828490179 a: 0.13698890770372357

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=true]	deckStatus=0	 ! DeckSet.resetValue= 0
		 */
		
	}

	public static void main(String[] args) {
//		test8vs6();
		
//		test9vs2();
//		test9vs3();
//		test9vs456();
//		test9vs7();
		
//		test11vs10();

//		test12vs2();
//		test12vs3();
		
//		test13vs2();
		
//		test14vs10();
		
//		test15vs9();
//		test15vs10();
		
//		test16vs7();
//		test16vs8();
//		test16vs9();
//		test16vs10();

	}

}
