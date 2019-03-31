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

/*
 * Prob_ROI diff: -0.028001286829884453 (up%-> -2.636997498340324) . o: 1.0618624722817496 -> a: 1.0338611854518651	来判断 o a的数据判断是否投降，当o或者a都小于0.5时，投降
 * 选择哪一个行为change or not change 根据net money diff:  -0.00365773254643797 , up % -> -23.129611590863142 ，上一条的up和这一条的up相加，判断是否大于0来决定。绝对ROI的提升比率来定义.
 */
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
	
	public static void testA2345vsAll() {
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
		
		System.out.println(o.diffWith(t));
		
		for(Card playerCard : Card.values()) {
			if(playerCard.getValue() >= 2 && playerCard.getValue() <= 5) {
				for(Card dealerCard : Card.values()) {
					if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
					PlayerCardsPathValue nine = new PlayerCardsPathValue(Card.One1,playerCard);
					Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, nine, dealerCard); 
//					HelloWorld.print(origin);
					PlayerCardsPathValue ninet = new PlayerCardsPathValue(Card.One1,playerCard);
					Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, ninet, dealerCard); 
//					HelloWorld.print(advanced);
					
					DealerVSPlayerResult9102 result = new DealerVSPlayerResult9102(dealerCard, playerCard.getValue(), RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), origin),RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), advanced));
					
					System.out.println(result);
					System.out.println();
				}
			}
		}
		/**
MatrixKey [startValue=Two, dealerCard=One1, situation=Start_With_A] : Hit -> Double


		 @@@   dealerCard=One1, 	playerStartValue=2	@@@ 

net money diff:  -0.09236591876196641 , up % -> -208.82846729968628 .  o: -0.04423052084628558 -> a: -0.136596439608252

[ProbMatrix: total: o: 4.566296923438159E-4  -> a: 4.5662969234560875E-4
org->adv	$w:27.4186083387825->21.647648448753348  	$d:12.875117412343531->6.847951231901512  	$l:59.70627424887396->71.50440031934514
	 improve value x$w(high is good):-5.770959890029154  	x$d:-6.027166180442019  	 x$l(negative is good):11.798126070471177
	 	 $w-$l: -32.287665910091455 -> -49.85675187059179  _ #Surrender#	 lift : -17.569085960500335 : bad	 :| stand

[TimeMatrix: total:  o: 5.1848641E7 -> a: 184717.0
org->adv	$w:31.233374082070924->64.72495763790013  	$d:3.472785332984909->3.2065267409063596  	$l:65.29384058494416->32.0685156211935
	 improve value x$w(high is good):33.49158355582921  	x$d:-0.2662585920785494  	 x$l(negative is good):-33.225324963750666
	 	 $w-$l: -34.06046650287324 -> 32.65644201670664  _ @double@	 lift : 66.71690851957987 : good	 :) hit 

[Prob_ROI diff: -0.17569085964249953 (up%-> -25.94665536112395) . o: 0.6771233409364136 -> a: 0.501432481293914	 returnMoney: o:0.09275838685166897 a: 0.13738137579928947	 totalSpendMoney: o: 0.13698890769795455 a: 0.27397781540754146

[Time_ROI diff: 0.6671690851957988 (up%-> 101.17892102237423) . o: 0.6593953349712676 -> a: 1.3265644201670663	 returnMoney: o:1.02566256E10 a: 1.470234E8	 totalSpendMoney: o: 1.55545923E10 a: 1.108302E8

[[Per_Prob_ROI diff: 0.03838616524673397 (up%-> 20686.204199019907) . o: 1.85564083567118E-4 -> a: 0.03857172933030109	 per returnMoney: o:2.5420221115831452E-5 a: 0.010567798138406883	 per totalSpendMoney: o: 3.7541492929009193E-5 a: 0.02107521656981088

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0


	 ----------
MatrixKey [startValue=Two, dealerCard=Two2, situation=Start_With_A] : Hit -> Double

	 
		 @@@   dealerCard=Two2, 	playerStartValue=2	@@@ 

net money diff:  -0.005113118351336932 , up % -> -117.45483568905016 .  o: -0.004353263381061123 -> a: -0.009466381732398055

[ProbMatrix: total: o: 4.5662969234549003E-4  -> a: 4.56629692345824E-4
org->adv	$w:45.71563211825035->45.76985190214849  	$d:5.390913957283854->5.005132602138644  	$l:48.8934539244658->49.22501549571287
	 improve value x$w(high is good):0.05421978389814086  	x$d:-0.38578135514520984  	 x$l(negative is good):0.33156157124706453
	 	 $w-$l: -3.177821806215453 -> -3.455163593564375  _  _ 	 lift : -0.27734178734892256 : bad	 :| stand

[TimeMatrix: total:  o: 667225.0 -> a: 346957.0
org->adv	$w:55.386563752856986->64.40250520957929  	$d:3.36318333395781->3.233830128805587  	$l:41.25025291318521->32.363664661615125
	 improve value x$w(high is good):9.015941456722302  	x$d:-0.12935320515222326  	 x$l(negative is good):-8.886588251570082
	 	 $w-$l: 14.13631083967178 -> 32.038840547964156  _ @double@	 lift : 17.90252970829238 : good	 :) hit 

[Prob_ROI diff: -0.0027734178737734982 (up%-> -0.2864444826082867) . o: 0.9682217819381607 -> a: 0.9654483640643872	 returnMoney: o:0.1326356443226314 a: 0.2645114336752056	 totalSpendMoney: o: 0.13698890770369251 a: 0.27397781540760363

[Time_ROI diff: 0.1790252970829238 (up%-> 15.685218469554544) . o: 1.1413631083967177 -> a: 1.3203884054796415	 returnMoney: o:2.284638E8 a: 2.748708E8	 totalSpendMoney: o: 2.001675E8 a: 2.081742E8

[[Per_Prob_ROI diff: 0.0355363874966572 (up%-> 91.75683753344559) . o: 0.038728871277526423 -> a: 0.07426525877418362	 per returnMoney: o:0.005305425772905255 a: 0.020347033359631197	 per totalSpendMoney: o: 0.005479556308147701 a: 0.021075216569815664

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0


	 
	 ------------
	 
MatrixKey [startValue=Two, dealerCard=Three3, situation=Start_With_A] : Hit -> Double


		 @@@   dealerCard=Three3, 	playerStartValue=2	@@@ 

net money diff:  -2.549805343291245E-4 , up % -> -99.99999999756167 .  o: -2.5498053433534174E-4 -> a: -5.099610686644662E-4

[ProbMatrix: total: o: 4.5662969234580835E-4  -> a: 4.5662969234582846E-4
org->adv	$w:47.484459413112226->47.48445941311347  	$d:4.844948925096413->4.844948925096121  	$l:47.67059166179137->47.670591661790404
	 improve value x$w(high is good):1.2434497875801753E-12  	x$d:-2.922107000813412E-13  	 x$l(negative is good):-9.663381206337363E-13
	 	 $w-$l: -0.1861322486791439 -> -0.186132248676929  _  _ 	 lift : 2.2148949341271873E-12 : good	 :| stand

[TimeMatrix: total:  o: 202189.0 -> a: 202189.0
org->adv	$w:64.38184075295887->64.38184075295887  	$d:3.2355865056951663->3.2355865056951663  	$l:32.38257274134597->32.38257274134597
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 31.999268011612898 -> 31.999268011612898  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: 2.2648549702353193E-14 (up%-> 2.2690784569913683E-12) . o: 0.9981386775133156 -> a: 0.9981386775133383	 returnMoney: o:0.136733927169425 a: 0.27346785433885085	 totalSpendMoney: o: 0.13698890770376035 a: 0.2739778154075153

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.319992680116129 -> a: 1.319992680116129	 returnMoney: o:8.00664E7 a: 1.601328E8	 totalSpendMoney: o: 6.06567E7 a: 1.213134E8

[[Per_Prob_ROI diff: 1.7486012637846216E-15 (up%-> 2.2774206572008958E-12) . o: 0.07677989827025504 -> a: 0.07677989827025679	 per returnMoney: o:0.010517994397648077 a: 0.02103598879529622	 per totalSpendMoney: o: 0.010537608284904642 a: 0.02107521656980887

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

	 
	 -----------------------

MatrixKey [startValue=Two, dealerCard=Four4, situation=Start_With_A] : Hit -> Double


		 @@@   dealerCard=Four4, 	playerStartValue=2	@@@ 

net money diff:  0.004446620605799284 , up % -> 100.00000000025342 .  o: 0.004446620605788015 -> a: 0.0088932412115873

[ProbMatrix: total: o: 4.5662969234580873E-4  -> a: 4.566296923458165E-4
org->adv	$w:49.28416596967569->49.28416596967558  	$d:4.677639344247115->4.677639344247018  	$l:46.03819468607719->46.038194686077404
	 improve value x$w(high is good):-1.1368683772161603E-13  	x$d:-9.769962616701378E-14  	 x$l(negative is good):2.1316282072803006E-13
	 	 $w-$l: 3.2459712835984975 -> 3.24597128359817  _  _ 	 lift : -3.275157922644212E-13 : bad	 :| stand

[TimeMatrix: total:  o: 117949.0 -> a: 117949.0
org->adv	$w:64.36425912894556->64.36425912894556  	$d:3.2369922593663363->3.2369922593663363  	$l:32.398748611688106->32.398748611688106
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 31.96551051725745 -> 31.96551051725745  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: 4.1300296516055823E-14 (up%-> 4.000184801652778E-12) . o: 1.032459712836056 -> a: 1.0324597128360973	 returnMoney: o:0.1414355283095168 a: 0.28287105661904277	 totalSpendMoney: o: 0.1369889077037288 a: 0.27397781540745547

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.3196551051725747 -> a: 1.3196551051725747	 returnMoney: o:4.66956E7 a: 9.33912E7	 totalSpendMoney: o: 3.53847E7 a: 7.07694E7

[[Per_Prob_ROI diff: 3.191891195797325E-15 (up%-> 4.019002875316467E-12) . o: 0.07941997791046584 -> a: 0.07941997791046904	 per returnMoney: o:0.010879656023808986 a: 0.021759312047618676	 per totalSpendMoney: o: 0.010537608284902215 a: 0.021075216569804267

	 Decide: $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0


	 
	 ------------------
MatrixKey [startValue=Two, dealerCard=Five5, situation=Start_With_A] : Double -> Hit

	 
		 @@@   dealerCard=Five5, 	playerStartValue=2	@@@ 

net money diff:  -0.009301161425345178 , up % -> -50.00000000002148 .  o: 0.018602322850682362 -> a: 0.009301161425337184

[ProbMatrix: total: o: 4.5662969234579003E-4  -> a: 4.5662969234578374E-4
org->adv	$w:51.14352749256983->51.14352749257065  	$d:4.502663672552427->4.502663672552482  	$l:44.35380883487774->44.353808834876865
	 improve value x$w(high is good):8.171241461241152E-13  	x$d:5.5067062021407764E-14  	 x$l(negative is good):-8.739675649849232E-13
	 	 $w-$l: 6.78971865769209 -> 6.789718657693788  _ @double@	 lift : 1.6986412276764895E-12 : good	 :| stand

[TimeMatrix: total:  o: 71149.0 -> a: 71149.0
org->adv	$w:64.35086930244978->64.35086930244978  	$d:3.2382746068110584->3.2382746068110584  	$l:32.41085609073915->32.41085609073915
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 31.94001321171063 -> 31.94001321171063  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: -2.9531932455029164E-14 (up%-> -2.765428435080841E-12) . o: 1.0678971865770182 -> a: 1.0678971865769886	 returnMoney: o:0.29258013825811624 a: 0.14629006912905457	 totalSpendMoney: o: 0.2739778154074339 a: 0.13698890770371738

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.3194001321171063 -> a: 1.3194001321171063	 returnMoney: o:5.63244E7 a: 2.81622E7	 totalSpendMoney: o: 4.26894E7 a: 2.13447E7

[[Per_Prob_ROI diff: -2.2620794126737565E-15 (up%-> -2.7537325441429995E-12) . o: 0.08214593742900139 -> a: 0.08214593742899913	 per returnMoney: o:0.022506164481393556 a: 0.011253082240696505	 per totalSpendMoney: o: 0.021075216569802605 a: 0.010537608284901337

	 Decide: !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0


	 --------------------------------
MatrixKey [startValue=Two, dealerCard=Six6, situation=Start_With_A] : Double -> Hit

	 
	 
		 @@@   dealerCard=Six6, 	playerStartValue=2	@@@ 

net money diff:  -0.012467338844491277 , up % -> -50.00000000002104 .  o: 0.024934677688972062 -> a: 0.012467338844480785

[ProbMatrix: total: o: 4.5662969234577127E-4  -> a: 4.5662969234576807E-4
org->adv	$w:52.31633056799142->52.31633056799143  	$d:4.468323063002996->4.468323063003022  	$l:43.21534636900558->43.21534636900554
	 improve value x$w(high is good):7.105427357601002E-15  	x$d:2.5757174171303632E-14  	 x$l(negative is good):-4.263256414560601E-14
	 	 $w-$l: 9.10098419898584 -> 9.100984198985895  _ @double@	 lift : 5.551115123125783E-14 : good	 :| stand

[TimeMatrix: total:  o: 40417.0 -> a: 40417.0
org->adv	$w:64.33926318133459->64.33926318133459  	$d:3.2387361753717494->3.2387361753717494  	$l:32.422000643293664->32.422000643293664
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 31.91726253804092 -> 31.91726253804092  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: -3.8413716652030416E-14 (up%-> -3.520932183523384E-12) . o: 1.0910098419899117 -> a: 1.0910098419898733	 returnMoney: o:0.29891249309640905 a: 0.14945624654819964	 totalSpendMoney: o: 0.273977815407437 a: 0.13698890770371885

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.3191726253804092 -> a: 1.3191726253804092	 returnMoney: o:3.19902E7 a: 1.59951E7	 totalSpendMoney: o: 2.42502E7 a: 1.21251E7

[[Per_Prob_ROI diff: -2.9837243786801082E-15 (up%-> -3.555276536469601E-12) . o: 0.083923833999224 -> a: 0.08392383399922101	 per returnMoney: o:0.022993268699723773 a: 0.01149663434986151	 per totalSpendMoney: o: 0.021075216569802845 a: 0.01053760828490145

	 Decide: !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

	 --------------------------
MatrixKey [startValue=Two, dealerCard=Seven7, situation=Start_With_A] : Hit -> Double

	 

		 @@@   dealerCard=Seven7, 	playerStartValue=2	@@@ 

net money diff:  -0.03937686139655788 , up % -> -266.4153985291219 .  o: 0.014780249795603911 -> a: -0.02459661160095397

[ProbMatrix: total: o: 4.5662969234496414E-4  -> a: 4.56629692345766E-4
org->adv	$w:50.03990044240136->42.65418059753724  	$d:10.709576184385526->5.714046380374858  	$l:39.250523373213106->51.6317730220879
	 improve value x$w(high is good):-7.38571984486412  	x$d:-4.995529804010668  	 x$l(negative is good):12.381249648874793
	 	 $w-$l: 10.789377069188255 -> -8.977592424550663  _  _ 	 lift : -19.766969493738916 : bad	 :| stand

[TimeMatrix: total:  o: 7009729.0 -> a: 24973.0
org->adv	$w:31.086394352763136->64.26140231449966  	$d:3.5171687807046466->3.247507307892524  	$l:65.39643686653221->32.49109037760782
	 improve value x$w(high is good):33.175007961736526  	x$d:-0.2696614728121225  	 x$l(negative is good):-32.905346488924394
	 	 $w-$l: -34.310042513769076 -> 31.770311936891844  _ @double@	 lift : 66.08035445066092 : good	 :) hit 

[Prob_ROI diff: -0.19766969494138498 (up%-> -17.841935767651993) . o: 1.107893770695927 -> a: 0.9102240757545421	 returnMoney: o:0.15176915749870504 a: 0.24938120380648152	 totalSpendMoney: o: 0.13698890770310113 a: 0.2739778154074355

[Time_ROI diff: 0.6608035445066092 (up%-> 100.59430235513827) . o: 0.6568995748623092 -> a: 1.3177031193689184	 returnMoney: o:1.3814064E9 a: 1.97442E7	 totalSpendMoney: o: 2.1029187E9 a: 1.49838E7

[[Per_Prob_ROI diff: 0.06971362087419689 (up%-> 22961.136644910606) . o: 3.0361572230636535E-4 -> a: 0.07001723659650325	 per returnMoney: o:4.1591986160237064E-5 a: 0.019183169523575502	 per totalSpendMoney: o: 3.7541492930419605E-5 a: 0.02107521656980273

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

	 
	 --------------------
MatrixKey [startValue=Two, dealerCard=Eight8, situation=Start_With_A] : Hit -> Double
	 
	 

		 @@@   dealerCard=Eight8, 	playerStartValue=2	@@@ 

net money diff:  -0.046276317912723575 , up % -> -1352.4500043302178 .  o: 0.003421665700362897 -> a: -0.04285465221236068

[ProbMatrix: total: o: 4.5662969234540774E-4  -> a: 4.5662969234575333E-4
org->adv	$w:45.751107018592194->39.25153437708825  	$d:10.99555440072089->5.855280790061584  	$l:43.253338580686915->54.89318483285016
	 improve value x$w(high is good):-6.499572641503946  	x$d:-5.140273610659306  	 x$l(negative is good):11.639846252163245
	 	 $w-$l: 2.4977684379052842 -> -15.641650455761912  _  _ 	 lift : -18.139418893667198 : bad	 :| stand

[TimeMatrix: total:  o: 4207297.0 -> a: 14989.0
org->adv	$w:31.07705493574616->64.24044299152712  	$d:3.518838817416503->3.249049302822069  	$l:65.40410624683733->32.51050770565081
	 improve value x$w(high is good):33.163388055780956  	x$d:-0.269789514594434  	 x$l(negative is good):-32.89359854118652
	 	 $w-$l: -34.327051311091175 -> 31.729935285876316  _ @double@	 lift : 66.05698659696749 : good	 :) hit 

[Prob_ROI diff: -0.18139418893894543 (up%-> -17.697379338403056) . o: 1.0249776843813405 -> a: 0.8435834954423951	 returnMoney: o:0.14041057340387467 a: 0.23112316319508058	 totalSpendMoney: o: 0.13698890770351177 a: 0.27397781540744126

[Time_ROI diff: 0.6605698659696749 (up%-> 100.58477335908557) . o: 0.6567294868890882 -> a: 1.317299352858763	 returnMoney: o:8.289168E8 a: 1.1847E7	 totalSpendMoney: o: 1.2621891E9 a: 8993400.0

[[Per_Prob_ROI diff: 0.06461014535009259 (up%-> 23001.712522628248) . o: 2.808927608608771E-4 -> a: 0.06489103811095347	 per returnMoney: o:3.8479192492155294E-5 a: 0.017778704861160045	 per totalSpendMoney: o: 3.754149293053214E-5 a: 0.021075216569803174

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

	 
	 -------------------------
MatrixKey [startValue=Two, dealerCard=Nine9, situation=Start_With_A] : Hit -> Double
	 
	 

		 @@@   dealerCard=Nine9, 	playerStartValue=2	@@@ 

net money diff:  -0.051975336040728654 , up % -> -534.1657900199674 .  o: -0.009730188082390262 -> a: -0.061705524123118916

[ProbMatrix: total: o: 4.566296923455723E-4  -> a: 4.5662969234574905E-4
org->adv	$w:40.84141237462624->35.75537633503675  	$d:11.214273091895858->5.967159535571918  	$l:47.9443145334779->58.27746412939133
	 improve value x$w(high is good):-5.086036039589487  	x$d:-5.24711355632394  	 x$l(negative is good):10.333149595913433
	 	 $w-$l: -7.102902158851659 -> -22.522087794354583  _  _ 	 lift : -15.419185635502924 : bad	 :| stand

[TimeMatrix: total:  o: 2806081.0 -> a: 9997.0
org->adv	$w:31.049139351287437->64.19925977793338  	$d:3.5209247345318966->3.2509752925877766  	$l:65.42993591418067->32.54976492947884
	 improve value x$w(high is good):33.15012042664594  	x$d:-0.26994944194411996  	 x$l(negative is good):-32.880170984701834
	 	 $w-$l: -34.38079656289324 -> 31.64949484845454  _ @double@	 lift : 66.03029141134778 : good	 :) hit 

[Prob_ROI diff: -0.15419185635701038 (up%-> -16.598134919171013) . o: 0.9289709784134677 -> a: 0.7747791220564573	 returnMoney: o:0.12725871962115018 a: 0.21227229128432723	 totalSpendMoney: o: 0.13698890770354044 a: 0.27397781540744615

[Time_ROI diff: 0.6603029141134777 (up%-> 100.62647510592691) . o: 0.6561920343710677 -> a: 1.3164949484845454	 returnMoney: o:5.523984E8 a: 7896600.0	 totalSpendMoney: o: 8.418243E8 a: 5998200.0

[[Per_Prob_ROI diff: 0.05934381165892948 (up%-> 23310.261975380385) . o: 2.5458234541339206E-4 -> a: 0.059598394004342865	 per returnMoney: o:3.4874957418786015E-5 a: 0.016328637791102094	 per totalSpendMoney: o: 3.754149293053999E-5 a: 0.02107521656980355

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

	 ---------------------------
	 
MatrixKey [startValue=Two, dealerCard=Ten, situation=Start_With_A] : Hit -> Double
	
	 

		 @@@   dealerCard=Ten, 	playerStartValue=2	@@@ 

net money diff:  -0.058572784299781674 , up % -> -232.88023436205862 .  o: -0.02515146227855415 -> a: -0.08372424657833583

[ProbMatrix: total: o: 4.5662969234546683E-4  -> a: 4.566296923457457E-4
org->adv	$w:35.085582133552315->31.67211610342513  	$d:11.468617595299499->6.096999210435667  	$l:53.445800271148194->62.23088468613921
	 improve value x$w(high is good):-3.4134660301271857  	x$d:-5.371618384863831  	 x$l(negative is good):8.785084414991019
	 	 $w-$l: -18.36021813759588 -> -30.55876858271408  _  _ 	 lift : -12.198550445118201 : bad	 :| stand

[TimeMatrix: total:  o: 1404865.0 -> a: 5005.0
org->adv	$w:31.00881579368836->64.11588411588411  	$d:3.527171649945012->3.2567432567432566  	$l:65.46401255636663->32.62737262737262
	 improve value x$w(high is good):33.10706832219576  	x$d:-0.2704283932017555  	 x$l(negative is good):-32.836639928994
	 	 $w-$l: -34.45519676267826 -> 31.488511488511488  _ @double@	 lift : 65.94370825118976 : good	 :) hit 

[Prob_ROI diff: -0.12198550445223943 (up%-> -14.941919450210607) . o: 0.8163978186251034 -> a: 0.694412314172864	 returnMoney: o:0.1118374454250939 a: 0.1902535688291107	 totalSpendMoney: o: 0.13698890770364805 a: 0.27397781540744653

[Time_ROI diff: 0.6594370825118975 (up%-> 100.60859899513875) . o: 0.6554480323732174 -> a: 1.3148851148851148	 returnMoney: o:2.762448E8 a: 3948600.0	 totalSpendMoney: o: 4.214595E8 a: 3003000.0

[[Per_Prob_ROI diff: 0.0531925999277917 (up%-> 23775.148917398576) . o: 2.237319316593871E-4 -> a: 0.053416331859451084	 per returnMoney: o:3.064879293644667E-5 a: 0.014634889909931593	 per totalSpendMoney: o: 3.754149293056948E-5 a: 0.02107521656980358

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0


	 ---------------------
	 
MatrixKey [startValue=Three, dealerCard=One1, situation=Start_With_A] : Hit -> Double

	 
		 @@@   dealerCard=One1, 	playerStartValue=3	@@@ 

net money diff:  -0.0890765342023777 , up % -> -186.9988075367593 .  o: -0.047634814026751196 -> a: -0.1367113482291289

[ProbMatrix: total: o: 4.5662969234554814E-4  -> a: 4.56629692345604E-4
org->adv	$w:26.42138768528781->21.647648448753074  	$d:12.384471982266449->6.806010383257564  	$l:61.19414033244575->71.54634116798935
	 improve value x$w(high is good):-4.7737392365347375  	x$d:-5.578461599008885  	 x$l(negative is good):10.352200835543606
	 	 $w-$l: -34.77275264715794 -> -49.89869271923628  _ #Surrender#	 lift : -15.125940072078347 : bad	 :| stand

[TimeMatrix: total:  o: 2.5249393E7 -> a: 184717.0
org->adv	$w:31.224354581514095->64.72495763790013  	$d:3.47178247017661->3.2065267409063596  	$l:65.30386294830929->32.0685156211935
	 improve value x$w(high is good):33.50060305638604  	x$d:-0.2652557292702502  	 x$l(negative is good):-33.23534732711579
	 	 $w-$l: -34.07950836679519 -> 32.65644201670664  _ @double@	 lift : 66.73595038350183 : good	 :) hit 

[Prob_ROI diff: -0.15125940073907118 (up%-> -23.189603558870136) . o: 0.6522724735465075 -> a: 0.5010130728074363	 returnMoney: o:0.08935409367515952 a: 0.13726646717838925	 totalSpendMoney: o: 0.13698890770191072 a: 0.27397781540751814

[Time_ROI diff: 0.6673595038350183 (up%-> 101.23703378129278) . o: 0.659204916332048 -> a: 1.3265644201670663	 returnMoney: o:4.9933572E9 a: 1.470234E8	 totalSpendMoney: o: 7.5748179E9 a: 1.108302E8

[[Per_Prob_ROI diff: 0.0381724032822263 (up%-> 10399.39034429906) . o: 3.6706385680726364E-4 -> a: 0.03853946713903356	 per returnMoney: o:5.0283676800877616E-5 a: 0.01055895901372225	 per totalSpendMoney: o: 7.708998745183496E-5 a: 0.02107521656980909

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

	 
	 ------------------------
MatrixKey [startValue=Three, dealerCard=Two2, situation=Start_With_A] : Hit -> Double


		 @@@   dealerCard=Two2, 	playerStartValue=3	@@@ 

net money diff:  -0.005183153285407971 , up % -> -117.6209913683032 .  o: -0.00440665669036755 -> a: -0.00958980997577552

[ProbMatrix: total: o: 4.566296923455474E-4  -> a: 4.566296923458001E-4
org->adv	$w:45.718739387477505->45.769851902148076  	$d:5.345723044474793->4.960082150430789  	$l:48.9355375680477->49.27006594742114
	 improve value x$w(high is good):0.051112514670570874  	x$d:-0.3856408940440046  	 x$l(negative is good):0.33452837937343816
	 	 $w-$l: -3.216798180570196 -> -3.5002140452730646  _  _ 	 lift : -0.2834158647028684 : bad	 :| stand

[TimeMatrix: total:  o: 667225.0 -> a: 346957.0
org->adv	$w:55.386563752856986->64.40250520957929  	$d:3.36318333395781->3.233830128805587  	$l:41.25025291318521->32.363664661615125
	 improve value x$w(high is good):9.015941456722302  	x$d:-0.12935320515222326  	 x$l(negative is good):-8.886588251570082
	 	 $w-$l: 14.13631083967178 -> 32.038840547964156  _ @double@	 lift : 17.90252970829238 : good	 :) hit 

[Prob_ROI diff: -0.002834158648484908 (up%-> -0.2928358015854683) . o: 0.967832018195944 -> a: 0.9649978595474591	 returnMoney: o:0.1325822510132521 a: 0.2643880054317779	 totalSpendMoney: o: 0.13698890770361966 a: 0.2739778154075534

[Time_ROI diff: 0.1790252970829238 (up%-> 15.685218469554544) . o: 1.1413631083967177 -> a: 1.3203884054796415	 returnMoney: o:2.284638E8 a: 2.748708E8	 totalSpendMoney: o: 2.001675E8 a: 2.081742E8

[[Per_Prob_ROI diff: 0.03551732385273602 (up%-> 91.74454653541257) . o: 0.03871328072783776 -> a: 0.07423060458057378	 per returnMoney: o:0.005303290040530084 a: 0.02033753887936753	 per totalSpendMoney: o: 0.005479556308144787 a: 0.0210752165698118

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

	 
	 -----------------------------
MatrixKey [startValue=Three, dealerCard=Three3, situation=Start_With_A] : Hit -> Double
	 
	 

		 @@@   dealerCard=Three3, 	playerStartValue=3	@@@ 

net money diff:  -3.143257878208128E-4 , up % -> -99.99999997437477 .  o: -3.1432578790135945E-4 -> a: -6.286515757221722E-4

[ProbMatrix: total: o: 4.5662969234581697E-4  -> a: 4.566296923458152E-4
org->adv	$w:47.484459413113235->47.48445941311356  	$d:4.801627714240824->4.801627714240922  	$l:47.71391287264595->47.71391287264551
	 improve value x$w(high is good):3.268496584496461E-13  	x$d:9.85878045867139E-14  	 x$l(negative is good):-4.405364961712621E-13
	 	 $w-$l: -0.22945345953271357 -> -0.2294534595319475  _  _ 	 lift : 7.66053886991358E-13 : good	 :| stand

[TimeMatrix: total:  o: 202189.0 -> a: 202189.0
org->adv	$w:64.38184075295887->64.38184075295887  	$d:3.2355865056951663->3.2355865056951663  	$l:32.38257274134597->32.38257274134597
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 31.999268011612898 -> 31.999268011612898  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: 2.937650123158164E-13 (up%-> 2.9444061649663526E-11) . o: 0.9977054654046801 -> a: 0.9977054654049738	 returnMoney: o:0.1366745819158588 a: 0.27334916383175994	 totalSpendMoney: o: 0.13698890770376015 a: 0.2739778154074821

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.319992680116129 -> a: 1.319992680116129	 returnMoney: o:8.00664E7 a: 1.601328E8	 totalSpendMoney: o: 6.06567E7 a: 1.213134E8

[[Per_Prob_ROI diff: 2.260691633892975E-14 (up%-> 2.945658038335811E-11) . o: 0.07674657426189846 -> a: 0.07674657426192107	 per returnMoney: o:0.010513429378142983 a: 0.021026858756289228	 per totalSpendMoney: o: 0.010537608284904628 a: 0.021075216569806317

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

	 
	 --------------------
MatrixKey [startValue=Three, dealerCard=Four4, situation=Start_With_A] : Hit -> Double
	 
	 

		 @@@   dealerCard=Four4, 	playerStartValue=3	@@@ 

net money diff:  0.004388928070784559 , up % -> 100.00000000086766 .  o: 0.004388928070746478 -> a: 0.008777856141531037

[ProbMatrix: total: o: 4.5662969234580835E-4  -> a: 4.5662969234581014E-4
org->adv	$w:49.284165969675506->49.28416596967552  	$d:4.635524594950163->4.635524594950188  	$l:46.08030943537433->46.080309435374296
	 improve value x$w(high is good):1.4210854715202004E-14  	x$d:2.4868995751603507E-14  	 x$l(negative is good):-3.552713678800501E-14
	 	 $w-$l: 3.2038565343011696 -> 3.2038565343012246  _  _ 	 lift : 5.551115123125783E-14 : good	 :| stand

[TimeMatrix: total:  o: 117949.0 -> a: 117949.0
org->adv	$w:64.36425912894556->64.36425912894556  	$d:3.2369922593663363->3.2369922593663363  	$l:32.398748611688106->32.398748611688106
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 31.96551051725745 -> 31.96551051725745  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: 1.4099832412739488E-13 (up%-> 1.3662117760155552E-11) . o: 1.0320385653431048 -> a: 1.0320385653432458	 returnMoney: o:0.14137783577447546 a: 0.2827556715489719	 totalSpendMoney: o: 0.13698890770372898 a: 0.2739778154074409

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.3196551051725747 -> a: 1.3196551051725747	 returnMoney: o:4.66956E7 a: 9.33912E7	 totalSpendMoney: o: 3.53847E7 a: 7.07694E7

[[Per_Prob_ROI diff: 1.0852430065710905E-14 (up%-> 1.3670185939935172E-11) . o: 0.0793875819494696 -> a: 0.07938758194948045	 per returnMoney: o:0.010875218136498112 a: 0.021750436272997838	 per totalSpendMoney: o: 0.010537608284902229 a: 0.021075216569803143

	 Decide: $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0


	 ----------------------------
MatrixKey [startValue=Three, dealerCard=Five5, situation=Start_With_A] : Double -> Hit
 	 
	 
		 @@@   dealerCard=Five5, 	playerStartValue=3	@@@ 

net money diff:  -0.009247318837343366 , up % -> -50.000000000083745 .  o: 0.018494637674655756 -> a: 0.00924731883731239

[ProbMatrix: total: o: 4.5662969234578423E-4  -> a: 4.566296923457834E-4
org->adv	$w:51.143527492569675->51.14352749256965  	$d:4.4633593311059085->4.46335933110591  	$l:44.39311317632442->44.39311317632443
	 improve value x$w(high is good):-2.1316282072803006E-14  	x$d:1.7763568394002505E-15  	 x$l(negative is good):7.105427357601002E-15
	 	 $w-$l: 6.750414316245257 -> 6.750414316245223  _ @double@	 lift : -3.3306690738754696E-14 : bad	 :| stand

[TimeMatrix: total:  o: 71149.0 -> a: 71149.0
org->adv	$w:64.35086930244978->64.35086930244978  	$d:3.2382746068110584->3.2382746068110584  	$l:32.41085609073915->32.41085609073915
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 31.94001321171063 -> 31.94001321171063  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: -1.163513729807164E-13 (up%-> -1.0899383737847224E-11) . o: 1.0675041431626608 -> a: 1.0675041431625445	 returnMoney: o:0.2924724530820784 a: 0.14623622654103072	 totalSpendMoney: o: 0.27397781540742266 a: 0.13698890770371833

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.3194001321171063 -> a: 1.3194001321171063	 returnMoney: o:5.63244E7 a: 2.81622E7	 totalSpendMoney: o: 4.26894E7 a: 2.13447E7

[[Per_Prob_ROI diff: -8.965050923848139E-15 (up%-> -1.0917584044661377E-11) . o: 0.08211570332020468 -> a: 0.08211570332019572	 per returnMoney: o:0.022497881006313725 a: 0.011248940503156208	 per totalSpendMoney: o: 0.021075216569801745 a: 0.01053760828490141

	 Decide: !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

	 
	 ------------------------
MatrixKey [startValue=Three, dealerCard=Six6, situation=Start_With_A] : Double -> Hit
	 
	 

		 @@@   dealerCard=Six6, 	playerStartValue=3	@@@ 

net money diff:  -0.012394113142484703 , up % -> -50.00000000003807 .  o: 0.024788226284950532 -> a: 0.012394113142465829

[ProbMatrix: total: o: 4.5662969234576927E-4  -> a: 4.566296923457676E-4
org->adv	$w:52.31633056799129->52.31633056799121  	$d:4.414869317553665->4.41486931755367  	$l:43.26880011445504->43.26880011445512
	 improve value x$w(high is good):-7.815970093361102E-14  	x$d:5.329070518200751E-15  	 x$l(negative is good):7.815970093361102E-14
	 	 $w-$l: 9.047530453536245 -> 9.04753045353609  _ @double@	 lift : -1.5543122344752192E-13 : bad	 :| stand

[TimeMatrix: total:  o: 40417.0 -> a: 40417.0
org->adv	$w:64.33926318133459->64.33926318133459  	$d:3.2387361753717494->3.2387361753717494  	$l:32.422000643293664->32.422000643293664
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 31.91726253804092 -> 31.91726253804092  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: -7.172040739078511E-14 (up%-> -6.576985933793069E-12) . o: 1.0904753045354718 -> a: 1.0904753045354	 returnMoney: o:0.298766041692381 a: 0.14938302084618527	 totalSpendMoney: o: 0.2739778154074305 a: 0.13698890770371944

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.3191726253804092 -> a: 1.3191726253804092	 returnMoney: o:3.19902E7 a: 1.59951E7	 totalSpendMoney: o: 2.42502E7 a: 1.21251E7

[[Per_Prob_ROI diff: -5.509481759702339E-15 (up%-> -6.568077477613396E-12) . o: 0.08388271573349783 -> a: 0.08388271573349232	 per returnMoney: o:0.022982003207106232 a: 0.011491001603552712	 per totalSpendMoney: o: 0.021075216569802345 a: 0.010537608284901495

	 Decide: !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

	 
	 ---------------------
	 
MatrixKey [startValue=Three, dealerCard=Seven7, situation=Start_With_A] : Hit -> Double
 
	 

		 @@@   dealerCard=Seven7, 	playerStartValue=3	@@@ 

net money diff:  -0.033951618226214925 , up % -> -376.04101675491785 .  o: 0.009028700783548477 -> a: -0.024922917442666448

[ProbMatrix: total: o: 4.566296923455011E-4  -> a: 4.5662969234576287E-4
org->adv	$w:48.19251647157821->42.65418059753736  	$d:10.205793230252409->5.594947014161844  	$l:41.60169029816937->51.75087238830079
	 improve value x$w(high is good):-5.538335874040847  	x$d:-4.610846216090565  	 x$l(negative is good):10.149182090131418
	 	 $w-$l: 6.590826173408837 -> -9.096691790763433  _  _ 	 lift : -15.68751796417227 : bad	 :| stand

[TimeMatrix: total:  o: 3413617.0 -> a: 24973.0
org->adv	$w:31.07741729666802->64.26140231449966  	$d:3.5161531009483484->3.247507307892524  	$l:65.40642960238362->32.49109037760782
	 improve value x$w(high is good):33.183985017831645  	x$d:-0.26864579305582437  	 x$l(negative is good):-32.915339224775806
	 	 $w-$l: -34.32901230571561 -> 31.770311936891844  _ @double@	 lift : 66.09932424260745 : good	 :) hit 

[Prob_ROI diff: -0.15687517964123765 (up%-> -14.717512310682967) . o: 1.0659082617336562 -> a: 0.9090330820924185	 returnMoney: o:0.14601760848732973 a: 0.2490548979647662	 totalSpendMoney: o: 0.13698890770378125 a: 0.27397781540743266

[Time_ROI diff: 0.6609932424260745 (up%-> 100.65224624048153) . o: 0.6567098769428439 -> a: 1.3177031193689184	 returnMoney: o:6.725268E8 a: 1.97442E7	 totalSpendMoney: o: 1.0240851E9 a: 1.49838E7

[[Per_Prob_ROI diff: 0.06932578587401801 (up%-> 11557.460047993567) . o: 5.998358253987935E-4 -> a: 0.06992562169941681	 per returnMoney: o:8.217085452297677E-5 a: 0.019158069074212785	 per totalSpendMoney: o: 7.708998745288758E-5 a: 0.02107521656980251

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0


	 -----------------------------------------
	 
MatrixKey [startValue=Three, dealerCard=Eight8, situation=Start_With_A] : Hit -> Double
		
	 
	 
		 @@@   dealerCard=Eight8, 	playerStartValue=3	@@@ 

net money diff:  -0.04117470042867827 , up % -> -2295.250392723092 .  o: -0.001793908871956601 -> a: -0.04296860930063487

[ProbMatrix: total: o: 4.5662969234589194E-4  -> a: 4.5662969234575056E-4
org->adv	$w:44.065852582940856->39.25153437708824  	$d:10.558766273058207->5.813687244209912  	$l:45.37538114400094->54.93477837870186
	 improve value x$w(high is good):-4.814318205852615  	x$d:-4.745079028848296  	 x$l(negative is good):9.559397234700917
	 	 $w-$l: -1.3095285610600804 -> -15.68324400161361  _  _ 	 lift : -14.37371544055353 : bad	 :| stand

[TimeMatrix: total:  o: 2048881.0 -> a: 14989.0
org->adv	$w:31.068080576665995->64.24044299152712  	$d:3.517822655390918->3.249049302822069  	$l:65.4140967679431->32.51050770565081
	 improve value x$w(high is good):33.17236241486113  	x$d:-0.26877335256884916  	 x$l(negative is good):-32.90358906229228
	 	 $w-$l: -34.34601619127709 -> 31.729935285876316  _ @double@	 lift : 66.07595147715341 : good	 :) hit 

[Prob_ROI diff: -0.14373715440486456 (up%-> -14.564440954554609) . o: 0.986904714388745 -> a: 0.8431675599838805	 returnMoney: o:0.13519499883195799 a: 0.23100920610680556	 totalSpendMoney: o: 0.1369889077039146 a: 0.27397781540744043

[Time_ROI diff: 0.660759514771534 (up%-> 100.64271449187284) . o: 0.656539838087229 -> a: 1.317299352858763	 returnMoney: o:4.035516E8 a: 1.1847E7	 totalSpendMoney: o: 6.146643E8 a: 8993400.0

[[Per_Prob_ROI diff: 0.06430366619645479 (up%-> 11578.383724904344) . o: 5.553768792283315E-4 -> a: 0.06485904307568312	 per returnMoney: o:7.608047204949802E-5 a: 0.017769938931292736	 per totalSpendMoney: o: 7.708998745296263E-5 a: 0.021075216569803108

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0


	 -----------------------
	 
MatrixKey [startValue=Three, dealerCard=Nine9, situation=Start_With_A] : Hit -> Double

	 
		 @@@   dealerCard=Nine9, 	playerStartValue=3	@@@ 

net money diff:  -0.04735619613226846 , up % -> -327.5962733032755 .  o: -0.014455657768862346 -> a: -0.06181185390113081

[ProbMatrix: total: o: 4.5662969234580537E-4  -> a: 4.56629692345747E-4
org->adv	$w:39.33590959491823->35.75537633503663  	$d:10.775751411877609->5.92834990499862  	$l:49.888338993204165->58.31627375996475
	 improve value x$w(high is good):-3.580533259881598  	x$d:-4.847401506878989  	 x$l(negative is good):8.427934766760586
	 	 $w-$l: -10.552429398285934 -> -22.56089742492813  _  _ 	 lift : -12.008468026642195 : bad	 :| stand

[TimeMatrix: total:  o: 1366513.0 -> a: 9997.0
org->adv	$w:31.04017305360432->64.19925977793338  	$d:3.519907970140057->3.2509752925877766  	$l:65.43991897625561->32.54976492947884
	 improve value x$w(high is good):33.15908672432906  	x$d:-0.26893267755228045  	 x$l(negative is good):-32.89015404677677
	 	 $w-$l: -34.3997459226513 -> 31.64949484845454  _ @double@	 lift : 66.04924077110583 : good	 :) hit 

[Prob_ROI diff: -0.1200846802668778 (up%-> -13.425147207353499) . o: 0.8944757060176035 -> a: 0.7743910257507257	 returnMoney: o:0.12253324993492987 a: 0.21216596150631473	 totalSpendMoney: o: 0.1369889077037922 a: 0.27397781540744554

[Time_ROI diff: 0.6604924077110584 (up%-> 100.68442828472547) . o: 0.656002540773487 -> a: 1.3164949484845454	 returnMoney: o:2.689308E8 a: 7896600.0	 totalSpendMoney: o: 4.099539E8 a: 5998200.0

[[Per_Prob_ROI diff: 0.05906517763650104 (up%-> 11734.116416348676) . o: 5.033628058624669E-4 -> a: 0.05956854044236351	 per returnMoney: o:6.895512095381534E-5 a: 0.016320458577408825	 per totalSpendMoney: o: 7.708998745289376E-5 a: 0.021075216569803504

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0


	 ---------------
	 
MatrixKey [startValue=Three, dealerCard=Ten, situation=Start_With_A] : Hit -> Double
	 
	 
		 @@@   dealerCard=Ten, 	playerStartValue=3	@@@ 

net money diff:  -0.05451519335315473 , up % -> -186.00812959956167 .  o: -0.029307962759754128 -> a: -0.08382315611290886

[ProbMatrix: total: o: 4.5662969234573994E-4  -> a: 4.566296923457459E-4
org->adv	$w:33.791189221781146->31.672116103425207  	$d:11.023215796790172->6.060897917187931  	$l:55.185594981428686->62.26698597938686
	 improve value x$w(high is good):-2.1190731183559386  	x$d:-4.962317879602241  	 x$l(negative is good):7.081390997958174
	 	 $w-$l: -21.39440575964754 -> -30.59486987596165  _  _ 	 lift : -9.20046411631411 : bad	 :| stand

[TimeMatrix: total:  o: 684145.0 -> a: 5005.0
org->adv	$w:30.99986114054769->64.11588411588411  	$d:3.526153081583582->3.2567432567432566  	$l:65.47398577786872->32.62737262737262
	 improve value x$w(high is good):33.11602297533642  	x$d:-0.2694098248403254  	 x$l(negative is good):-32.8466131504961
	 	 $w-$l: -34.47412463732103 -> 31.488511488511488  _ @double@	 lift : 65.96263612583253 : good	 :) hit 

[Prob_ROI diff: -0.09200464116378826 (up%-> -11.704592027176718) . o: 0.7860559424041782 -> a: 0.6940513012403899	 returnMoney: o:0.1076809449439693 a: 0.1901546592945375	 totalSpendMoney: o: 0.13698890770372343 a: 0.27397781540744637

[Time_ROI diff: 0.6596263612583252 (up%-> 100.66654701022478) . o: 0.6552587536267896 -> a: 1.3148851148851148	 returnMoney: o:1.344876E8 a: 3948600.0	 totalSpendMoney: o: 2.052435E8 a: 3003000.0

[[Per_Prob_ROI diff: 0.052946211638150664 (up%-> 11969.303074438998) . o: 4.423499957254801E-4 -> a: 0.05338856163387615	 per returnMoney: o:6.059704273718025E-5 a: 0.014627281484195193	 per totalSpendMoney: o: 7.708998745285506E-5 a: 0.021075216569803566

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

	 
	 -----------------------
MatrixKey [startValue=Four, dealerCard=One1, situation=Start_With_A] : Hit -> Double
 
	 

		 @@@   dealerCard=One1, 	playerStartValue=4	@@@ 

net money diff:  -0.08569219196224498 , up % -> -166.4549091151065 .  o: -0.051480723769454784 -> a: -0.13717291573169976

[ProbMatrix: total: o: 4.5662969234617535E-4  -> a: 4.5662969234562295E-4
org->adv	$w:25.264918243689056->21.563507098126326  	$d:11.889950170214163->6.805824151403211  	$l:62.84513158609677->71.63066875047046
	 improve value x$w(high is good):-3.70141114556273  	x$d:-5.084126018810952  	 x$l(negative is good):8.785537164373693
	 	 $w-$l: -37.58021334240772 -> -50.06716165234414  _ #Surrender#	 lift : -12.486948309936425 : bad	 :| stand

[TimeMatrix: total:  o: 1.2290785E7 -> a: 184717.0
org->adv	$w:31.20581801731948->64.72495763790013  	$d:3.469721421373818->3.2065267409063596  	$l:65.32446056130671->32.0685156211935
	 improve value x$w(high is good):33.51913962058065  	x$d:-0.2631946804674583  	 x$l(negative is good):-33.25594494011321
	 	 $w-$l: -34.11864254398723 -> 32.65644201670664  _ @double@	 lift : 66.77508456069387 : good	 :) hit 

[Prob_ROI diff: -0.12486948310706208 (up%-> -20.004791716212576) . o: 0.6241978665834523 -> a: 0.49932838347639025	 returnMoney: o:0.08550818393424997 a: 0.13680489967583936	 totalSpendMoney: o: 0.13698890770370475 a: 0.2739778154075391

[Time_ROI diff: 0.6677508456069385 (up%-> 101.35657056744435) . o: 0.6588135745601278 -> a: 1.3265644201670663	 returnMoney: o:2.4292008E9 a: 1.470234E8	 totalSpendMoney: o: 3.6872355E9 a: 1.108302E8

[[Per_Prob_ROI diff: 0.0376882596212977 (up%-> 5222.758089652009) . o: 7.216160307323148E-4 -> a: 0.038409875652030016	 per returnMoney: o:9.885339183150286E-5 a: 0.010523453821218413	 per totalSpendMoney: o: 1.5836867942624827E-4 a: 0.021075216569810703

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=true]	deckStatus=0	 ! DeckSet.resetValue= 0


	 --------------------------
MatrixKey [startValue=Four, dealerCard=Two2, situation=Start_With_A] : Hit -> Double
		 
	 
	 
		 @@@   dealerCard=Two2, 	playerStartValue=4	@@@ 

net money diff:  -0.005429814830619578 , up % -> -117.1258746179134 .  o: -0.00463587985859884 -> a: -0.010065694689218418

[ProbMatrix: total: o: 4.5662969234560967E-4  -> a: 4.5662969234580553E-4
org->adv	$w:45.633595383274226->45.68145028051858  	$d:5.348681323931475->4.963190778060364  	$l:49.017723292794294->49.35535894142106
	 improve value x$w(high is good):0.04785489724435621  	x$d:-0.38549054587111176  	 x$l(negative is good):0.3376356486267653
	 	 $w-$l: -3.3841279095200685 -> -3.6739086609024807  _  _ 	 lift : -0.28978075138241244 : bad	 :| stand

[TimeMatrix: total:  o: 667225.0 -> a: 346957.0
org->adv	$w:55.386563752856986->64.40250520957929  	$d:3.36318333395781->3.233830128805587  	$l:41.25025291318521->32.363664661615125
	 improve value x$w(high is good):9.015941456722302  	x$d:-0.12935320515222326  	 x$l(negative is good):-8.886588251570082
	 	 $w-$l: 14.13631083967178 -> 32.038840547964156  _ @double@	 lift : 17.90252970829238 : good	 :) hit 

[Prob_ROI diff: -0.0028978075135046577 (up%-> -0.2999307930266282) . o: 0.9661587209044545 -> a: 0.9632609133909499	 returnMoney: o:0.13235302784521952 a: 0.2639121207183888	 totalSpendMoney: o: 0.13698890770381836 a: 0.27397781540760724

[Time_ROI diff: 0.1790252970829238 (up%-> 15.685218469554544) . o: 1.1413631083967177 -> a: 1.3203884054796415	 returnMoney: o:2.284638E8 a: 2.748708E8	 totalSpendMoney: o: 2.001675E8 a: 2.081742E8

[[Per_Prob_ROI diff: 0.035450644501587206 (up%-> 91.73090232110268) . o: 0.03864634883617818 -> a: 0.07409699333776538	 per returnMoney: o:0.005294121113808781 a: 0.020300932362952988	 per totalSpendMoney: o: 0.005479556308152734 a: 0.021075216569815942

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

	 
	 -----------------------------
MatrixKey [startValue=Four, dealerCard=Three3, situation=Start_With_A] : Hit -> Double


		 @@@   dealerCard=Three3, 	playerStartValue=4	@@@ 

net money diff:  -5.44378513767263E-4 , up % -> -100.00000001699867 .  o: -5.443785136747259E-4 -> a: -0.0010887570274419889

[ProbMatrix: total: o: 4.5662969234581225E-4  -> a: 4.5662969234580873E-4
org->adv	$w:47.39902890423387->47.39902890423131  	$d:4.804553437334316->4.804553437334366  	$l:47.79641765843182->47.79641765843432
	 improve value x$w(high is good):-2.5650592760939617E-12  	x$d:5.062616992290714E-14  	 x$l(negative is good):2.5011104298755527E-12
	 	 $w-$l: -0.3973887541979526 -> -0.3973887542030097  _  _ 	 lift : -5.057065877167588E-12 : bad	 :| stand

[TimeMatrix: total:  o: 202189.0 -> a: 202189.0
org->adv	$w:64.38184075295887->64.38184075295887  	$d:3.2355865056951663->3.2355865056951663  	$l:32.38257274134597->32.38257274134597
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 31.999268011612898 -> 31.999268011612898  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: -3.3706371027619753E-13 (up%-> -3.384085076286677E-11) . o: 0.9960261124583019 -> a: 0.9960261124579648	 returnMoney: o:0.13644452919006614 a: 0.2728890583800865	 totalSpendMoney: o: 0.13698890770374086 a: 0.27397781540752847

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.319992680116129 -> a: 1.319992680116129	 returnMoney: o:8.00664E7 a: 1.601328E8	 totalSpendMoney: o: 6.06567E7 a: 1.213134E8

[[Per_Prob_ROI diff: -2.5923707624997405E-14 (up%-> -3.383527750022467E-11) . o: 0.07661739326602322 -> a: 0.0766173932659973	 per returnMoney: o:0.010495733014620472 a: 0.020991466029237422	 per totalSpendMoney: o: 0.010537608284903143 a: 0.02107521656980988

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

	 ---------------------
MatrixKey [startValue=Four, dealerCard=Four4, situation=Start_With_A] : Hit -> Double


		 @@@   dealerCard=Four4, 	playerStartValue=4	@@@ 

net money diff:  0.004168000172964953 , up % -> 99.99999999914097 .  o: 0.004168000173000758 -> a: 0.00833600034596571

[ProbMatrix: total: o: 4.566296923458162E-4  -> a: 4.566296923458023E-4
org->adv	$w:49.20203137641791->49.20203137641621  	$d:4.638519484548457->4.638519484548589  	$l:46.15944913903364->46.159449139035196
	 improve value x$w(high is good):-1.6981971384666394E-12  	x$d:1.3233858453531866E-13  	 x$l(negative is good):1.5560885913146194E-12
	 	 $w-$l: 3.0425822373842726 -> 3.0425822373810085  _  _ 	 lift : -3.2640556923979602E-12 : bad	 :| stand

[TimeMatrix: total:  o: 117949.0 -> a: 117949.0
org->adv	$w:64.36425912894556->64.36425912894556  	$d:3.2369922593663363->3.2369922593663363  	$l:32.398748611688106->32.398748611688106
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 31.96551051725745 -> 31.96551051725745  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: -1.3278267374516872E-13 (up%-> -1.2886194315205663E-11) . o: 1.0304258223739933 -> a: 1.0304258223738605	 returnMoney: o:0.14115690787672097 a: 0.2823138157534264	 totalSpendMoney: o: 0.13698890770372021 a: 0.2739778154074607

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.3196551051725747 -> a: 1.3196551051725747	 returnMoney: o:4.66956E7 a: 9.33912E7	 totalSpendMoney: o: 3.53847E7 a: 7.07694E7

[[Per_Prob_ROI diff: -1.0241807402167069E-14 (up%-> -1.2921211147583938E-11) . o: 0.07926352479799949 -> a: 0.07926352479798925	 per returnMoney: o:0.01085822368282469 a: 0.021716447365648185	 per totalSpendMoney: o: 0.010537608284901554 a: 0.02107521656980467

	 Decide: $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

	 
	 ----------------------
MatrixKey [startValue=Four, dealerCard=Five5, situation=Start_With_A] : Double -> Hit
 	 	 
	 

		 @@@   dealerCard=Five5, 	playerStartValue=4	@@@ 

net money diff:  -0.009033309869125983 , up % -> -49.99999999991873 .  o: 0.01806661973828133 -> a: 0.009033309869155348

[ProbMatrix: total: o: 4.5662969234577875E-4  -> a: 4.566296923457897E-4
org->adv	$w:51.06472730529181->51.064727305293324  	$d:4.464736131248492->4.464736131248405  	$l:44.4705365634597->44.47053656345826
	 improve value x$w(high is good):1.5134560271690134E-12  	x$d:-8.704148513061227E-14  	 x$l(negative is good):-1.4424017535930034E-12
	 	 $w-$l: 6.594190741832112 -> 6.59419074183506  _ @double@	 lift : 2.9476421303797906E-12 : good	 :| stand

[TimeMatrix: total:  o: 71149.0 -> a: 71149.0
org->adv	$w:64.35086930244978->64.35086930244978  	$d:3.2382746068110584->3.2382746068110584  	$l:32.41085609073915->32.41085609073915
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 31.94001321171063 -> 31.94001321171063  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: 1.1191048088221578E-13 (up%-> 1.0498741076167622E-11) . o: 1.0659419074183578 -> a: 1.0659419074184697	 returnMoney: o:0.2920444351457209 a: 0.14602221757286568	 totalSpendMoney: o: 0.2739778154074396 a: 0.13698890770371033

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.3194001321171063 -> a: 1.3194001321171063	 returnMoney: o:5.63244E7 a: 2.81622E7	 totalSpendMoney: o: 4.26894E7 a: 2.13447E7

[[Per_Prob_ROI diff: 8.590350653037149E-15 (up%-> 1.0476608313482247E-11) . o: 0.0819955313398737 -> a: 0.08199553133988229	 per returnMoney: o:0.02246495654967084 a: 0.011232478274835821	 per totalSpendMoney: o: 0.021075216569803046 a: 0.010537608284900794

	 Decide: !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

	 
	 ----------------------
MatrixKey [startValue=Four, dealerCard=Six6, situation=Start_With_A] : Double -> Hit
 
	 

		 @@@   dealerCard=Six6, 	playerStartValue=4	@@@ 

net money diff:  -0.012180001274872593 , up % -> -49.9999999999673 .  o: 0.024360002549761117 -> a: 0.012180001274888524

[ProbMatrix: total: o: 4.566296923457657E-4  -> a: 4.566296923457729E-4
org->adv	$w:52.22862067923821->52.22862067923882  	$d:4.433990405502166->4.433990405502127  	$l:43.33738891525962->43.33738891525906
	 improve value x$w(high is good):6.110667527536862E-13  	x$d:-3.907985046680551E-14  	 x$l(negative is good):-5.613287612504791E-13
	 	 $w-$l: 8.891231763978592 -> 8.891231763979762  _ @double@	 lift : 1.1712852909795402E-12 : good	 :| stand

[TimeMatrix: total:  o: 40417.0 -> a: 40417.0
org->adv	$w:64.33926318133459->64.33926318133459  	$d:3.2387361753717494->3.2387361753717494  	$l:32.422000643293664->32.422000643293664
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 31.91726253804092 -> 31.91726253804092  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: 6.17284001691587E-14 (up%-> 5.668812738105011E-12) . o: 1.0889123176397864 -> a: 1.088912317639848	 returnMoney: o:0.298337817957202 a: 0.14916890897860322	 totalSpendMoney: o: 0.2739778154074409 a: 0.1369889077037147

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.3191726253804092 -> a: 1.3191726253804092	 returnMoney: o:3.19902E7 a: 1.59951E7	 totalSpendMoney: o: 2.42502E7 a: 1.21251E7

[[Per_Prob_ROI diff: 4.746203430272544E-15 (up%-> 5.666263811514136E-12) . o: 0.08376248597229126 -> a: 0.083762485972296	 per returnMoney: o:0.02294906291978477 a: 0.011474531459892554	 per totalSpendMoney: o: 0.021075216569803143 a: 0.01053760828490113

	 Decide: !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

	 
	 --------------------------
MatrixKey [startValue=Four, dealerCard=Seven7, situation=Start_With_A] : Hit -> Double


		 @@@   dealerCard=Seven7, 	playerStartValue=4	@@@ 

net money diff:  -0.028412049278927598 , up % -> -997.017270144805 .  o: 0.0028497048275604175 -> a: -0.02556234445136718

[ProbMatrix: total: o: 4.566296923456611E-4  -> a: 4.566296923457578E-4
org->adv	$w:46.08457386625464->42.49058738529081  	$d:9.911097212468409->5.688747020945628  	$l:44.00432892127696->51.82066559376357
	 improve value x$w(high is good):-3.593986480963828  	x$d:-4.222350191522781  	 x$l(negative is good):7.816336672486614
	 	 $w-$l: 2.080244944977677 -> -9.330078208472765  _  _ 	 lift : -11.410323153450442 : bad	 :| stand

[TimeMatrix: total:  o: 1661665.0 -> a: 24973.0
org->adv	$w:31.05896796285653->64.26140231449966  	$d:3.514065711199309->3.247507307892524  	$l:65.42696632594416->32.49109037760782
	 improve value x$w(high is good):33.202434351643134  	x$d:-0.26655840330678515  	 x$l(negative is good):-32.935875948336346
	 	 $w-$l: -34.36799836308763 -> 31.770311936891844  _ @double@	 lift : 66.13831029997948 : good	 :) hit 

[Prob_ROI diff: -0.11410323153350987 (up%-> -11.17779758415735) . o: 1.0208024494488255 -> a: 0.9066992179153156	 returnMoney: o:0.13983861253147073 a: 0.24841547095606992	 totalSpendMoney: o: 0.1369889077039103 a: 0.2739778154074371

[Time_ROI diff: 0.6613831029997946 (up%-> 100.77143565705657) . o: 0.6563200163691237 -> a: 1.3177031193689184	 returnMoney: o:3.271752E8 a: 1.97442E7	 totalSpendMoney: o: 4.984995E8 a: 1.49838E7

[[Per_Prob_ROI diff: 0.06856597524712434 (up%-> 5810.092699207989) . o: 0.0011801184386691626 -> a: 0.0697460936857935	 per returnMoney: o:1.6166313587453264E-4 a: 0.019108882381236147	 per totalSpendMoney: o: 1.583686794264859E-4 a: 0.021075216569802855

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0


	 --------------------------------------
MatrixKey [startValue=Four, dealerCard=Eight8, situation=Start_With_A] : Hit -> Double
	
	 
		 @@@   dealerCard=Eight8, 	playerStartValue=4	@@@ 

net money diff:  -0.036137647289553376 , up % -> -469.6286812426746 .  o: -0.007694940435479858 -> a: -0.043832587725033234

[ProbMatrix: total: o: 4.566296923459029E-4  -> a: 4.5662969234574845E-4
org->adv	$w:42.113458735322396->39.093826342892754  	$d:10.15588288566589->5.813757187545292  	$l:47.73065837901172->55.092416469561954
	 improve value x$w(high is good):-3.019632392429642  	x$d:-4.342125698120597  	 x$l(negative is good):7.361758090550232
	 	 $w-$l: -5.617199643689324 -> -15.9985901266692  _  _ 	 lift : -10.381390482979874 : bad	 :| stand

[TimeMatrix: total:  o: 997345.0 -> a: 14989.0
org->adv	$w:31.04963678566594->64.24044299152712  	$d:3.515734274498794->3.249049302822069  	$l:65.43462893983526->32.51050770565081
	 improve value x$w(high is good):33.19080620586118  	x$d:-0.266684971676725  	 x$l(negative is good):-32.924121234184454
	 	 $w-$l: -34.38499215416932 -> 31.729935285876316  _ @double@	 lift : 66.11492744004563 : good	 :) hit 

[Prob_ROI diff: -0.10381390482946595 (up%-> -10.999239738340636) . o: 0.9438280035627945 -> a: 0.8400140987333286	 returnMoney: o:0.12929396726841513 a: 0.23014522768240808	 totalSpendMoney: o: 0.136988907703895 a: 0.2739778154074413

[Time_ROI diff: 0.6611492744004563 (up%-> 100.76189824649502) . o: 0.6561500784583068 -> a: 1.317299352858763	 returnMoney: o:1.963224E8 a: 1.1847E7	 totalSpendMoney: o: 2.992035E8 a: 8993400.0

[[Per_Prob_ROI diff: 0.06352533849337598 (up%-> 5821.973663564257) . o: 0.001091130639956988 -> a: 0.06461646913333297	 per returnMoney: o:1.494727945299597E-4 a: 0.017703479052492928	 per totalSpendMoney: o: 1.583686794264682E-4 a: 0.021075216569803178

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

	 
	 -----------------------------------------
MatrixKey [startValue=Four, dealerCard=Nine9, situation=Start_With_A] : Hit -> Double


		 @@@   dealerCard=Nine9, 	playerStartValue=4	@@@ 

net money diff:  -0.04270755933741316 , up % -> -216.470781963148 .  o: -0.01972901790722209 -> a: -0.06243657724463525

[ProbMatrix: total: o: 4.5662969234588484E-4  -> a: 4.566296923457463E-4
org->adv	$w:37.670495345823305->35.67871235725172  	$d:10.257100250221809->5.85365817854534  	$l:52.072404403954884->58.46762946420294
	 improve value x$w(high is good):-1.991782988571586  	x$d:-4.403442071676469  	 x$l(negative is good):6.395225060248059
	 	 $w-$l: -14.40190905813158 -> -22.788917106951224  _  _ 	 lift : -8.387008048819645 : bad	 :| stand

[TimeMatrix: total:  o: 665185.0 -> a: 9997.0
org->adv	$w:31.02174583010741->64.19925977793338  	$d:3.5178183512857326->3.2509752925877766  	$l:65.46043581860685->32.54976492947884
	 improve value x$w(high is good):33.17751394782597  	x$d:-0.266843058697956  	 x$l(negative is good):-32.91067088912801
	 	 $w-$l: -34.43868998849944 -> 31.64949484845454  _ @double@	 lift : 66.08818483695399 : good	 :) hit 

[Prob_ROI diff: -0.08387008048823907 (up%-> -9.798125117672516) . o: 0.8559809094187388 -> a: 0.7721108289304998	 returnMoney: o:0.11725988979658131 a: 0.21154123816281	 totalSpendMoney: o: 0.1369889077038034 a: 0.27397781540744526

[Time_ROI diff: 0.6608818483695398 (up%-> 100.80363681775273) . o: 0.6556131001150056 -> a: 1.3164949484845454	 returnMoney: o:1.308312E8 a: 7896600.0	 totalSpendMoney: o: 1.995555E8 a: 5998200.0

[[Per_Prob_ROI diff: 0.05840356738127511 (up%-> 5901.893982554866) . o: 9.895733056864034E-4 -> a: 0.05939314068696151	 per returnMoney: o:1.3556056623882233E-4 a: 0.01627240293560077	 per totalSpendMoney: o: 1.583686794263623E-4 a: 0.021075216569803483

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

	 
	 ----------------------------
MatrixKey [startValue=Four, dealerCard=Ten, situation=Start_With_A] : Hit -> Double 


		 @@@   dealerCard=Ten, 	playerStartValue=4	@@@ 

net money diff:  -0.05037191884365426 , up % -> -148.82473835785214 .  o: -0.0338464689402201 -> a: -0.08421838778387436

[ProbMatrix: total: o: 4.5662969234576623E-4  -> a: 4.566296923457453E-4
org->adv	$w:32.354862132282925->31.59999263080724  	$d:10.582823498909372->6.060888047185358  	$l:57.0623143688077->62.339119322007406
	 improve value x$w(high is good):-0.7548695014756852  	x$d:-4.521935451724014  	 x$l(negative is good):5.276804953199708
	 	 $w-$l: -24.707452236524773 -> -30.73912669120017  _  _ 	 lift : -6.031674454675395 : bad	 :| stand

[TimeMatrix: total:  o: 333025.0 -> a: 5005.0
org->adv	$w:30.98145784850987->64.11588411588411  	$d:3.524059755273628->3.2567432567432566  	$l:65.4944823962165->32.62737262737262
	 improve value x$w(high is good):33.134426267374245  	x$d:-0.2673164985303713  	 x$l(negative is good):-32.867109768843875
	 	 $w-$l: -34.513024547706635 -> 31.488511488511488  _ @double@	 lift : 66.00153603621813 : good	 :) hit 

[Prob_ROI diff: -0.06031674454687308 (up%-> -8.010984664291383) . o: 0.7529254776348825 -> a: 0.6926087330880094	 returnMoney: o:0.10314243876351735 a: 0.18975942762357173	 totalSpendMoney: o: 0.13698890770373745 a: 0.2739778154074461

[Time_ROI diff: 0.6600153603621811 (up%-> 100.78574492159834) . o: 0.6548697545229337 -> a: 1.3148851148851148	 returnMoney: o:6.54264E7 a: 3948600.0	 totalSpendMoney: o: 9.99075E7 a: 3003000.0

[[Per_Prob_ROI diff: 0.052407160774733175 (up%-> 6020.807558875997) . o: 8.704340781906154E-4 -> a: 0.05327759485292379	 per returnMoney: o:1.1923981359944202E-4 a: 0.014596879047967056	 per totalSpendMoney: o: 1.5836867942628608E-4 a: 0.021075216569803545

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

	 
	 ----------------------------
MatrixKey [startValue=Five, dealerCard=One1, situation=Start_With_A] : Hit -> Double



		 @@@   dealerCard=One1, 	playerStartValue=5	@@@ 

net money diff:  -0.08267061917642311 , up % -> -149.53773488428678 .  o: -0.05528411891513145 -> a: -0.13795473809155456

[ProbMatrix: total: o: 4.566296923452228E-4  -> a: 4.5662969234559216E-4
org->adv	$w:24.169431581995802->21.479151084945386  	$d:11.304497862433628->6.689176445732642  	$l:64.52607055557057->71.83167246932197
	 improve value x$w(high is good):-2.6902804970504164  	x$d:-4.615321416700986  	 x$l(negative is good):7.305601913751403
	 	 $w-$l: -40.35663897357477 -> -50.35252138437658  _ #Surrender#	 lift : -9.995882410801816 : bad	 :| stand

[TimeMatrix: total:  o: 5981989.0 -> a: 184717.0
org->adv	$w:31.16772698846487->64.72495763790013  	$d:3.4654861451600794->3.2065267409063596  	$l:65.36678686637505->32.0685156211935
	 improve value x$w(high is good):33.55723064943526  	x$d:-0.25895940425371977  	 x$l(negative is good):-33.29827124518155
	 	 $w-$l: -34.19905987791017 -> 32.65644201670664  _ @double@	 lift : 66.85550189461682 : good	 :) hit 

[Prob_ROI diff: -0.09995882411196294 (up%-> -16.7594217346388) . o: 0.5964336102681007 -> a: 0.49647478615613777	 returnMoney: o:0.08170478878815442 a: 0.136023077315983	 totalSpendMoney: o: 0.13698890770328587 a: 0.2739778154075376

[Time_ROI diff: 0.6685550189461681 (up%-> 101.60265456780755) . o: 0.6580094012208982 -> a: 1.3265644201670663	 returnMoney: o:1.1808615E9 a: 1.470234E8	 totalSpendMoney: o: 1.7945967E9 a: 1.108302E8

[[Per_Prob_ROI diff: 0.036773661253105924 (up%-> 2595.714111516698) . o: 0.001416706912750833 -> a: 0.038190368165856754	 per returnMoney: o:1.9407313251343093E-4 a: 0.010463313639691	 per totalSpendMoney: o: 3.253893294614866E-4 a: 0.02107521656981058

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=true]	deckStatus=0	 ! DeckSet.resetValue= 0


	 ---------------------
MatrixKey [startValue=Five, dealerCard=Two2, situation=Start_With_A] : Hit -> Double

	 
		 @@@   dealerCard=Two2, 	playerStartValue=5	@@@ 

net money diff:  -0.0057152007365388335 , up % -> -116.33517524526506 .  o: -0.004912702219676629 -> a: -0.010627902956215463

[ProbMatrix: total: o: 4.5662969234553643E-4  -> a: 4.5662969234584717E-4
org->adv	$w:45.55501454898972->45.59950236509007  	$d:5.303766513645666->4.921884495737701  	$l:49.14121893736462->49.47861313917223
	 improve value x$w(high is good):0.04448781610035013  	x$d:-0.38188201790796494  	 x$l(negative is good):0.33739420180761215
	 	 $w-$l: -3.586204388374897 -> -3.879110774082167  _  _ 	 lift : -0.29290638570727 : bad	 :| stand

[TimeMatrix: total:  o: 667225.0 -> a: 346957.0
org->adv	$w:55.386563752856986->64.40250520957929  	$d:3.36318333395781->3.233830128805587  	$l:41.25025291318521->32.363664661615125
	 improve value x$w(high is good):9.015941456722302  	x$d:-0.12935320515222326  	 x$l(negative is good):-8.886588251570082
	 	 $w-$l: 14.13631083967178 -> 32.038840547964156  _ @double@	 lift : 17.90252970829238 : good	 :) hit 

[Prob_ROI diff: -0.0029290638574670513 (up%-> -0.30380132209153277) . o: 0.9641379561161189 -> a: 0.9612088922586518	 returnMoney: o:0.13207620548406773 a: 0.26334991245138534	 totalSpendMoney: o: 0.13698890770374436 a: 0.2739778154076008

[Time_ROI diff: 0.1790252970829238 (up%-> 15.685218469554544) . o: 1.1413631083967177 -> a: 1.3203884054796415	 returnMoney: o:2.284638E8 a: 2.748708E8	 totalSpendMoney: o: 2.001675E8 a: 2.081742E8

[[Per_Prob_ROI diff: 0.035373627313713074 (up%-> 91.72345899597781) . o: 0.038565518244644756 -> a: 0.07393914555835783	 per returnMoney: o:0.00528304821936271 a: 0.020257685573183488	 per totalSpendMoney: o: 0.005479556308149775 a: 0.021075216569815446

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0


	 -----------------------------------
MatrixKey [startValue=Five, dealerCard=Three3, situation=Start_With_A] : Hit -> Double
	
	 
		 @@@   dealerCard=Three3, 	playerStartValue=5	@@@ 

net money diff:  -8.166260653727497E-4 , up % -> -99.99999999842974 .  o: -8.166260653855728E-4 -> a: -0.0016332521307583225

[ProbMatrix: total: o: 4.5662969234581475E-4  -> a: 4.5662969234583453E-4
org->adv	$w:47.31966005884169->47.319660058842786  	$d:4.764554196634669->4.764554196634361  	$l:47.915785744523646->47.91578574452286
	 improve value x$w(high is good):1.0942358130705543E-12  	x$d:-3.0819791163594346E-13  	 x$l(negative is good):-7.887024366937112E-13
	 	 $w-$l: -0.5961256856819586 -> -0.5961256856800712  _  _ 	 lift : 1.887379141862766E-12 : good	 :| stand

[TimeMatrix: total:  o: 202189.0 -> a: 202189.0
org->adv	$w:64.38184075295887->64.38184075295887  	$d:3.2355865056951663->3.2355865056951663  	$l:32.38257274134597->32.38257274134597
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 31.999268011612898 -> 31.999268011612898  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: 4.674038933671909E-14 (up%-> 4.702069175788289E-12) . o: 0.9940387431429738 -> a: 0.9940387431430205	 returnMoney: o:0.13617228163837478 a: 0.272344563276762	 totalSpendMoney: o: 0.13698890770376035 a: 0.2739778154075203

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.319992680116129 -> a: 1.319992680116129	 returnMoney: o:8.00664E7 a: 1.601328E8	 totalSpendMoney: o: 6.06567E7 a: 1.213134E8

[[Per_Prob_ROI diff: 3.594347042223944E-15 (up%-> 4.700673074489064E-12) . o: 0.07646451870330567 -> a: 0.07646451870330927	 per returnMoney: o:0.010474790895259599 a: 0.02094958179052015	 per totalSpendMoney: o: 0.010537608284904642 a: 0.021075216569809256

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

	 
	 ------------------------------
MatrixKey [startValue=Five, dealerCard=Four4, situation=Start_With_A] : Hit -> Double


		 @@@   dealerCard=Four4, 	playerStartValue=5	@@@ 

net money diff:  0.0039043741931175657 , up % -> 100.00000000059146 .  o: 0.003904374193094473 -> a: 0.007808748386212039

[ProbMatrix: total: o: 4.566296923458101E-4  -> a: 4.566296923458126E-4
org->adv	$w:49.12535000826282->49.1253500082629  	$d:4.599438917019362->4.599438917019302  	$l:46.27521107471783->46.275211074717795
	 improve value x$w(high is good):7.815970093361102E-14  	x$d:-5.950795411990839E-14  	 x$l(negative is good):-3.552713678800501E-14
	 	 $w-$l: 2.850138933544988 -> 2.8501389335451046  _  _ 	 lift : 1.1657341758564144E-13 : good	 :| stand

[TimeMatrix: total:  o: 117949.0 -> a: 117949.0
org->adv	$w:64.36425912894556->64.36425912894556  	$d:3.2369922593663363->3.2369922593663363  	$l:32.398748611688106->32.398748611688106
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 31.96551051725745 -> 31.96551051725745  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: 8.415490526658687E-14 (up%-> 8.182284062928366E-12) . o: 1.0285013893353951 -> a: 1.0285013893354793	 returnMoney: o:0.14089328189682326 a: 0.28178656379367	 totalSpendMoney: o: 0.1369889077037288 a: 0.27397781540745797

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.3196551051725747 -> a: 1.3196551051725747	 returnMoney: o:4.66956E7 a: 9.33912E7	 totalSpendMoney: o: 3.53847E7 a: 7.07694E7

[[Per_Prob_ROI diff: 6.480926906249351E-15 (up%-> 8.191729311681748E-12) . o: 0.07911549148733808 -> a: 0.07911549148734456	 per returnMoney: o:0.010837944761294098 a: 0.02167588952259	 per totalSpendMoney: o: 0.010537608284902215 a: 0.021075216569804458

	 Decide: $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

	 
	 -----------------------
MatrixKey [startValue=Five, dealerCard=Five5, situation=Start_With_A] : Double -> Hit



		 @@@   dealerCard=Five5, 	playerStartValue=5	@@@ 

net money diff:  -0.008781007296368437 , up % -> -50.00000000005011 .  o: 0.017562014592719277 -> a: 0.00878100729635084

[ProbMatrix: total: o: 4.566296923457844E-4  -> a: 4.5662969234578406E-4
org->adv	$w:50.99073753058166->50.99073753058211  	$d:4.428538306737524->4.428538306737541  	$l:44.580724162680816->44.58072416268035
	 improve value x$w(high is good):4.476419235288631E-13  	x$d:1.687538997430238E-14  	 x$l(negative is good):-4.689582056016661E-13
	 	 $w-$l: 6.410013367900847 -> 6.410013367901763  _ @double@	 lift : 9.159339953157541E-13 : good	 :| stand

[TimeMatrix: total:  o: 71149.0 -> a: 71149.0
org->adv	$w:64.35086930244978->64.35086930244978  	$d:3.2382746068110584->3.2382746068110584  	$l:32.41085609073915->32.41085609073915
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 31.94001321171063 -> 31.94001321171063  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: -6.372680161348399E-14 (up%-> -5.988797444574251E-12) . o: 1.064100133679081 -> a: 1.0641001336790172	 returnMoney: o:0.29153983000015593 a: 0.14576991500006822	 totalSpendMoney: o: 0.27397781540743665 a: 0.13698890770371738

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.3194001321171063 -> a: 1.3194001321171063	 returnMoney: o:5.63244E7 a: 2.81622E7	 totalSpendMoney: o: 4.26894E7 a: 2.13447E7

[[Per_Prob_ROI diff: -4.898859096158503E-15 (up%-> -5.9848849026897295E-12) . o: 0.08185385643685238 -> a: 0.08185385643684748	 per returnMoney: o:0.022426140769242764 a: 0.011213070384620633	 per totalSpendMoney: o: 0.02107521656980282 a: 0.010537608284901337

	 Decide: !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

	 -----------------------------
MatrixKey [startValue=Five, dealerCard=Six6, situation=Start_With_A] : Double -> Hit


		 @@@   dealerCard=Six6, 	playerStartValue=5	@@@ 

net money diff:  -0.011927006945786606 , up % -> -50.00000000002467 .  o: 0.023854013891561443 -> a: 0.011927006945774837

[ProbMatrix: total: o: 4.5662969234576867E-4  -> a: 4.5662969234576824E-4
org->adv	$w:52.16152965962293->52.16152965962293  	$d:4.383490098296907->4.383490098296929  	$l:43.45498024208017->43.45498024208013
	 improve value x$w(high is good):0.0  	x$d:2.220446049250313E-14  	 x$l(negative is good):-3.552713678800501E-14
	 	 $w-$l: 8.706549417542764 -> 8.706549417542798  _ @double@	 lift : 3.3306690738754696E-14 : good	 :| stand

[TimeMatrix: total:  o: 40417.0 -> a: 40417.0
org->adv	$w:64.33926318133459->64.33926318133459  	$d:3.2387361753717494->3.2387361753717494  	$l:32.422000643293664->32.422000643293664
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 31.91726253804092 -> 31.91726253804092  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: -4.263256414560601E-14 (up%-> -3.9218027224700815E-12) . o: 1.0870654941754594 -> a: 1.0870654941754168	 returnMoney: o:0.2978318292990003 a: 0.1489159146494937	 totalSpendMoney: o: 0.2739778154074389 a: 0.13698890770371885

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.3191726253804092 -> a: 1.3191726253804092	 returnMoney: o:3.19902E7 a: 1.59951E7	 totalSpendMoney: o: 2.42502E7 a: 1.21251E7

[[Per_Prob_ROI diff: -3.2751579226442118E-15 (up%-> -3.916696208508532E-12) . o: 0.08362042262888149 -> a: 0.08362042262887821	 per returnMoney: o:0.02291014071530772 a: 0.011455070357653361	 per totalSpendMoney: o: 0.02107521656980299 a: 0.01053760828490145

	 Decide: !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

	 ---------------------------
MatrixKey [startValue=Five, dealerCard=Seven7, situation=Start_With_A] : Hit -> Double


		 @@@   dealerCard=Seven7, 	playerStartValue=5	@@@ 

net money diff:  -0.02315672306104588 , up % -> -770.4634432048401 .  o: -0.003005557663413927 -> a: -0.026162280724459808

[ProbMatrix: total: o: 4.5662969234564485E-4  -> a: 4.5662969234576607E-4
org->adv	$w:44.19647249387482->42.43990687222487  	$d:9.413039661849146->5.571135473625629  	$l:46.39048784427604->51.9889576541495
	 improve value x$w(high is good):-1.7565656216499548  	x$d:-3.8419041882235163  	 x$l(negative is good):5.598469809873464
	 	 $w-$l: -2.1940153504012185 -> -9.549050781924635  _  _ 	 lift : -7.355035431523415 : bad	 :| stand

[TimeMatrix: total:  o: 808741.0 -> a: 24973.0
org->adv	$w:31.021056184860175->64.26140231449966  	$d:3.5097763066296874->3.247507307892524  	$l:65.46916750851014->32.49109037760782
	 improve value x$w(high is good):33.24034612963949  	x$d:-0.26226899873716336  	 x$l(negative is good):-32.97807713090232
	 	 $w-$l: -34.44811132364997 -> 31.770311936891844  _ @double@	 lift : 66.21842326054181 : good	 :) hit 

[Prob_ROI diff: -0.07355035431487988 (up%-> -7.520025955304071) . o: 0.978059846495648 -> a: 0.9045094921807681	 returnMoney: o:0.1339833500403428 a: 0.24781553468297607	 totalSpendMoney: o: 0.13698890770375674 a: 0.2739778154074359

[Time_ROI diff: 0.662184232605418 (up%-> 101.01680454621628) . o: 0.6555188867635003 -> a: 1.3177031193689184	 returnMoney: o:1.590435E8 a: 1.97442E7	 totalSpendMoney: o: 2.426223E8 a: 1.49838E7

[[Per_Prob_ROI diff: 0.06725447071143065 (up%-> 2894.9283902166912) . o: 0.0023231825332438194 -> a: 0.06957765324467446	 per returnMoney: o:3.1825023762551736E-4 a: 0.019062733437152004	 per totalSpendMoney: o: 3.253893294626051E-4 a: 0.02107521656980276

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

	 --------------------------------
MatrixKey [startValue=Five, dealerCard=Eight8, situation=Start_With_A] : Hit -> Double


		 @@@   dealerCard=Eight8, 	playerStartValue=5	@@@ 

net money diff:  -0.031209889146553413 , up % -> -239.4466937340516 .  o: -0.013034170010807325 -> a: -0.04424405915736074

[ProbMatrix: total: o: 4.5662969234575257E-4  -> a: 4.566296923457528E-4
org->adv	$w:40.367502311468016->39.029974069594445  	$d:9.750232299328845->5.791277518784602  	$l:49.88226538920315->55.17874841162096
	 improve value x$w(high is good):-1.3375282418735708  	x$d:-3.958954780544243  	 x$l(negative is good):5.29648302241781
	 	 $w-$l: -9.514763077735127 -> -16.148774342026517  _  _ 	 lift : -6.63401126429139 : bad	 :| stand

[TimeMatrix: total:  o: 485413.0 -> a: 14989.0
org->adv	$w:31.011736397665494->64.24044299152712  	$d:3.511442833216251->3.249049302822069  	$l:65.47682076911826->32.51050770565081
	 improve value x$w(high is good):33.228706593861624  	x$d:-0.2623935303941818  	 x$l(negative is good):-32.96631306346745
	 	 $w-$l: -34.46508437145276 -> 31.729935285876316  _ @double@	 lift : 66.19501965732908 : good	 :) hit 

[Prob_ROI diff: -0.06634011264278394 (up%-> -7.331595174999154) . o: 0.9048523692225219 -> a: 0.8385122565797379	 returnMoney: o:0.12395473769295208 a: 0.2297337562500802	 totalSpendMoney: o: 0.1369889077037594 a: 0.27397781540744093

[Time_ROI diff: 0.6619501965732907 (up%-> 101.00725547969468) . o: 0.6553491562854724 -> a: 1.317299352858763	 returnMoney: o:9.54345E7 a: 1.1847E7	 totalSpendMoney: o: 1.456239E8 a: 8993400.0

[[Per_Prob_ROI diff: 0.06235164977529268 (up%-> 2901.0306485634887) . o: 0.002149293038533306 -> a: 0.06450094281382598	 per returnMoney: o:2.944293056839717E-4 a: 0.01767182740385232	 per totalSpendMoney: o: 3.253893294626114E-4 a: 0.02107521656980315

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

	 
	 -----------------------------------
MatrixKey [startValue=Five, dealerCard=Nine9, situation=Start_With_A] : Hit -> Double


		 @@@   dealerCard=Nine9, 	playerStartValue=5	@@@ 

net money diff:  -0.03834790181992967 , up % -> -154.8000400833959 .  o: -0.02477253998078449 -> a: -0.06312044180071416

[ProbMatrix: total: o: 4.566296923457448E-4  -> a: 4.5662969234574807E-4
org->adv	$w:35.983318539116624->35.52638248642091  	$d:9.949752798845402->5.908712106298909  	$l:54.06692866203796->58.564905407280186
	 improve value x$w(high is good):-0.4569360526957169  	x$d:-4.041040692546494  	 x$l(negative is good):4.497976745242227
	 	 $w-$l: -18.083610122921336 -> -23.038522920859283  _  _ 	 lift : -4.954912797937949 : bad	 :| stand

[TimeMatrix: total:  o: 323749.0 -> a: 9997.0
org->adv	$w:30.983879486886444->64.19925977793338  	$d:3.513524366098428->3.2509752925877766  	$l:65.50259614701513->32.54976492947884
	 improve value x$w(high is good):33.215380291046934  	x$d:-0.26254907351065127  	 x$l(negative is good):-32.952831217536286
	 	 $w-$l: -34.51871666012868 -> 31.64949484845454  _ @double@	 lift : 66.16821150858321 : good	 :) hit 

[Prob_ROI diff: -0.04954912797943212 (up%-> -6.04874409794926) . o: 0.8191638987708381 -> a: 0.7696147707914059	 returnMoney: o:0.11221636772294799 a: 0.2108573736067312	 totalSpendMoney: o: 0.13698890770373248 a: 0.27397781540744537

[Time_ROI diff: 0.6616821150858322 (up%-> 101.04904506093213) . o: 0.6548128333987132 -> a: 1.3164949484845454	 returnMoney: o:6.35985E7 a: 7896600.0	 totalSpendMoney: o: 9.71247E7 a: 5998200.0

[[Per_Prob_ROI diff: 0.057255378735457885 (up%-> 2942.5752872894896) . o: 0.0019457574792656487 -> a: 0.05920113621472353	 per returnMoney: o:2.665471917409691E-4 a: 0.016219797969748553	 per totalSpendMoney: o: 3.2538932946254745E-4 a: 0.02107521656980349

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

	 
	 ----------------------------
MatrixKey [startValue=Five, dealerCard=Ten, situation=Start_With_A] : Hit -> Double	


		 @@@   dealerCard=Ten, 	playerStartValue=5	@@@ 

net money diff:  -0.046636179682978646 , up % -> -121.19577623270379 .  o: -0.03848003712062881 -> a: -0.08511621680360745

[ProbMatrix: total: o: 4.566296923456946E-4  -> a: 4.566296923457445E-4
org->adv	$w:30.88244598405326->31.454199564677225  	$d:10.145215378787498->6.024772822167575  	$l:58.97233863715924->62.52102761315519
	 improve value x$w(high is good):0.571753580623966  	x$d:-4.120442556619922  	 x$l(negative is good):3.548688975995951
	 	 $w-$l: -28.08989265310598 -> -31.066828048477962  _  _ 	 lift : -2.9769353953719824 : bad	 :| stand

[TimeMatrix: total:  o: 162085.0 -> a: 5005.0
org->adv	$w:30.94364068235802->64.11588411588411  	$d:3.5197581515871303->3.2567432567432566  	$l:65.53660116605485->32.62737262737262
	 improve value x$w(high is good):33.17224343352609  	x$d:-0.26301489484387375  	 x$l(negative is good):-32.90922853868223
	 	 $w-$l: -34.592960483696835 -> 31.488511488511488  _ @double@	 lift : 66.08147197220833 : good	 :) hit 

[Prob_ROI diff: -0.029769353953789657 (up%-> -4.139801072772636) . o: 0.719101073469011 -> a: 0.6893317195152213	 returnMoney: o:0.09850887058309518 a: 0.18886159860383891	 totalSpendMoney: o: 0.136988907703724 a: 0.27397781540744637

[Time_ROI diff: 0.660814719722083 (up%-> 101.03113129854627) . o: 0.6540703951630318 -> a: 1.3148851148851148	 returnMoney: o:3.18045E7 a: 3948600.0	 totalSpendMoney: o: 4.86255E7 a: 3003000.0

[[Per_Prob_ROI diff: 0.05131743832647745 (up%-> 3004.395672950979) . o: 0.0017080785593088146 -> a: 0.053025516885786265	 per returnMoney: o:2.3398781611186505E-4 a: 0.014527815277218378	 per totalSpendMoney: o: 3.253893294625273E-4 a: 0.021075216569803566

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0


		 */
	}
	
	public static void testA6vsAll() {
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
		
		System.out.println(o.diffWith(t));
		
		for(Card playerCard : Card.values()) {
			if(playerCard.getValue() == 6) {
				for(Card dealerCard : Card.values()) {
					if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
					PlayerCardsPathValue nine = new PlayerCardsPathValue(Card.One1,playerCard);
					Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, nine, dealerCard); 
//					HelloWorld.print(origin);
					PlayerCardsPathValue ninet = new PlayerCardsPathValue(Card.One1,playerCard);
					Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, ninet, dealerCard); 
//					HelloWorld.print(advanced);
					
					DealerVSPlayerResult9102 result = new DealerVSPlayerResult9102(dealerCard, playerCard.getValue(), RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), origin),RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), advanced));
					
					System.out.println(result);
					System.out.println();
				}
			}
		}
		/**
MatrixKey [startValue=Six, dealerCard=One1, situation=Start_With_A] : Hit -> Double



		 @@@   dealerCard=One1, 	playerStartValue=6	@@@ 

net money diff:  -0.07398139980341534 , up % -> -135.28137137385053 .  o: -0.05468705635675994 -> a: -0.12866845616017528

[ProbMatrix: total: o: 4.5662969234565374E-4  -> a: 4.5662969234560636E-4
org->adv	$w:23.61453960503324->21.605707600106193  	$d:12.850129191837917->9.825491832296644  	$l:63.53533120312884->68.56880056759717
	 improve value x$w(high is good):-2.008832004927047  	x$d:-3.0246373595412734  	 x$l(negative is good):5.033469364468324
	 	 $w-$l: -39.9207915980956 -> -46.96309296749097  _  _ 	 lift : -7.04230136939537 : bad	 :| stand

[TimeMatrix: total:  o: 5470465.0 -> a: 184717.0
org->adv	$w:31.615191761577854->64.72495763790013  	$d:3.5296451032956067->5.129468321811203  	$l:64.85516313512653->30.145574040288658
	 improve value x$w(high is good):33.10976587632228  	x$d:1.599823218515596  	 x$l(negative is good):-34.709589094837874
	 	 $w-$l: -33.239971373548684 -> 34.57938359761148  _ @double@	 lift : 67.81935497116017 : good	 :) hit 

[Prob_ROI diff: -0.07042301369582415 (up%-> -11.721694670895456) . o: 0.6007920840207683 -> a: 0.5303690703249442	 returnMoney: o:0.08230185134717691 a: 0.14530935924734648	 totalSpendMoney: o: 0.13698890770393685 a: 0.27397781540752175

[Time_ROI diff: 0.6781935497116016 (up%-> 101.58676736140453) . o: 0.6676002862645132 -> a: 1.3457938359761148	 returnMoney: o:1.0956252E9 a: 1.491546E8	 totalSpendMoney: o: 1.6411395E9 a: 1.108302E8

[[Per_Prob_ROI diff: 0.03923712187469201 (up%-> 2514.395965515788) . o: 0.0015604989195344636 -> a: 0.040797620794226476	 per returnMoney: o:2.1377104246019977E-4 a: 0.011177643019026653	 per totalSpendMoney: o: 3.558153446855502E-4 a: 0.021075216569809367

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0


	 ----------------
MatrixKey [startValue=Six, dealerCard=Two2, situation=Start_With_A] : Hit -> Double

	 
		 @@@   dealerCard=Two2, 	playerStartValue=6	@@@ 

net money diff:  -8.738378988208118E-4 , up % -> -1224.9025295333845 .  o: -7.133938233874759E-5 -> a: -9.451772811595593E-4

[ProbMatrix: total: o: 4.566296923455988E-4  -> a: 4.5662969234584635E-4
org->adv	$w:45.68031363434503->45.72480145043926  	$d:8.587295973111479->8.205413955203317  	$l:45.73239039254349->46.06978459435743
	 improve value x$w(high is good):0.04448781609422525  	x$d:-0.38188201790816123  	 x$l(negative is good):0.337394201813936
	 	 $w-$l: -0.05207675819846047 -> -0.3449831439181761  _  _ 	 lift : -0.2929063857197156 : bad	 :| stand

[TimeMatrix: total:  o: 667225.0 -> a: 346957.0
org->adv	$w:55.386563752856986->64.40250520957929  	$d:4.365843605979991->5.162022959617475  	$l:40.247592641163024->30.43547183080324
	 improve value x$w(high is good):9.015941456722302  	x$d:0.7961793536374833  	 x$l(negative is good):-9.812120810359783
	 	 $w-$l: 15.13897111169396 -> 33.967033378776044  _ @double@	 lift : 18.828062267082085 : good	 :) hit 

[Prob_ROI diff: -0.0029290638560948157 (up%-> -0.293059001237181) . o: 0.999479232417175 -> a: 0.9965501685610801	 returnMoney: o:0.1369175683214515 a: 0.27303263812639506	 totalSpendMoney: o: 0.13698890770379024 a: 0.2739778154075546

[Time_ROI diff: 0.1882806226708209 (up%-> 16.35246701033777) . o: 1.1513897111169396 -> a: 1.3396703337877605	 returnMoney: o:2.304708E8 a: 2.788848E8	 totalSpendMoney: o: 2.001675E8 a: 2.081742E8

[[Per_Prob_ROI diff: 0.036678535977242244 (up%-> 91.7441173053131) . o: 0.039979169296687 -> a: 0.07665770527392925	 per returnMoney: o:0.00547670273285806 a: 0.02100251062510731	 per totalSpendMoney: o: 0.005479556308151609 a: 0.021075216569811893

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

	 
	 -------------------
MatrixKey [startValue=Six, dealerCard=Three3, situation=Start_With_A] : Hit -> Double


		 @@@   dealerCard=Three3, 	playerStartValue=6	@@@ 

net money diff:  0.003841502147125253 , up % -> 100.00000000003324 .  o: 0.0038415021471239763 -> a: 0.007683004294249229

[ProbMatrix: total: o: 4.566296923458218E-4  -> a: 4.566296923458316E-4
org->adv	$w:47.44113820225696->47.44113820225735  	$d:7.92196680865791->7.921966808657843  	$l:44.636894989085135->44.63689498908481
	 improve value x$w(high is good):3.907985046680551E-13  	x$d:-6.661338147750939E-14  	 x$l(negative is good):-3.268496584496461E-13
	 	 $w-$l: 2.8042432131718256 -> 2.8042432131725414  _  _ 	 lift : 7.16093850883226E-13 : good	 :| stand

[TimeMatrix: total:  o: 202189.0 -> a: 202189.0
org->adv	$w:64.38184075295887->64.38184075295887  	$d:5.164474823061591->5.164474823061591  	$l:30.453684423979542->30.453684423979542
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 33.92815632897932 -> 33.92815632897932  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: 6.8833827526759706E-15 (up%-> 6.695621248240375E-13) . o: 1.0280424321320356 -> a: 1.0280424321320425	 returnMoney: o:0.14083040985086911 a: 0.2816608197017185	 totalSpendMoney: o: 0.13698890770374514 a: 0.2739778154074693

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.3392815632897932 -> a: 1.3392815632897932	 returnMoney: o:8.12364E7 a: 1.624728E8	 totalSpendMoney: o: 6.06567E7 a: 1.213134E8

[[Per_Prob_ROI diff: 5.273559366969494E-16 (up%-> 6.668622775465212E-13) . o: 0.07908018708707966 -> a: 0.07908018708708019	 per returnMoney: o:0.010833108450066855 a: 0.021666216900132193	 per totalSpendMoney: o: 0.010537608284903473 a: 0.02107521656980533

	 Decide: $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

	 
	 ----------------------
MatrixKey [startValue=Six, dealerCard=Four4, situation=Start_With_A] : Double -> Hit

	 

		 @@@   dealerCard=Four4, 	playerStartValue=6	@@@ 

net money diff:  -0.008430275311777008 , up % -> -49.99999999999984 .  o: 0.01686055062355407 -> a: 0.008430275311777063

[ProbMatrix: total: o: 4.5662969234580884E-4  -> a: 4.5662969234580944E-4
org->adv	$w:49.24205122037777->49.24205122037829  	$d:7.669881449664127->7.669881449664031  	$l:43.08806732995811->43.088067329957674
	 improve value x$w(high is good):5.258016244624741E-13  	x$d:-9.681144774731365E-14  	 x$l(negative is good):-4.334310688136611E-13
	 	 $w-$l: 6.153983890419662 -> 6.153983890420623  _ @double@	 lift : 9.603429163007604E-13 : good	 :| stand

[TimeMatrix: total:  o: 117949.0 -> a: 117949.0
org->adv	$w:64.36425912894556->64.36425912894556  	$d:5.164944170785678->5.164944170785678  	$l:30.47079670026876->30.47079670026876
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 33.8934624286768 -> 33.8934624286768  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: -2.886579864025407E-15 (up%-> -2.7192383726310177E-13) . o: 1.061539838904405 -> a: 1.0615398389044022	 returnMoney: o:0.29083836603098423 a: 0.14541918301549886	 totalSpendMoney: o: 0.27397781540743016 a: 0.1369889077037218

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.338934624286768 -> a: 1.338934624286768	 returnMoney: o:9.47556E7 a: 4.73778E7	 totalSpendMoney: o: 7.07694E7 a: 3.53847E7

[[Per_Prob_ROI diff: -2.220446049250313E-16 (up%-> -2.7192383726310177E-13) . o: 0.08165691068495423 -> a: 0.08165691068495401	 per returnMoney: o:0.022372182002383403 a: 0.01118609100119222	 per totalSpendMoney: o: 0.02107521656980232 a: 0.010537608284901677

	 Decide: !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

	 
	 -----------------------------
MatrixKey [startValue=Six, dealerCard=Five5, situation=Start_With_A] : Double -> Hit
	 
	 

		 @@@   dealerCard=Five5, 	playerStartValue=6	@@@ 

net money diff:  -0.013016037659516283 , up % -> -50.00000000003039 .  o: 0.026032075319016745 -> a: 0.013016037659500462

[ProbMatrix: total: o: 4.566296923457831E-4  -> a: 4.566296923457832E-4
org->adv	$w:51.104223151122305->51.10422315112295  	$d:7.293080410875831->7.293080410875801  	$l:41.60269643800184->41.60269643800126
	 improve value x$w(high is good):6.465938895416912E-13  	x$d:-3.019806626980426E-14  	 x$l(negative is good):-5.826450433232822E-13
	 	 $w-$l: 9.501526713120462 -> 9.501526713121693  _ @double@	 lift : 1.2323475573339238E-12 : good	 :| stand

[TimeMatrix: total:  o: 71149.0 -> a: 71149.0
org->adv	$w:64.35086930244978->64.35086930244978  	$d:5.169433161393695->5.169433161393695  	$l:30.479697536156518->30.479697536156518
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 33.871171766293266 -> 33.871171766293266  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: -6.106226635438361E-14 (up%-> -5.5763849315404554E-12) . o: 1.0950152671314135 -> a: 1.0950152671313524	 returnMoney: o:0.30000989072643297 a: 0.15000494536321327	 totalSpendMoney: o: 0.2739778154074162 a: 0.1369889077037128

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.3387117176629326 -> a: 1.3387117176629326	 returnMoney: o:5.71488E7 a: 2.85744E7	 totalSpendMoney: o: 4.26894E7 a: 2.13447E7

[[Per_Prob_ROI diff: -4.676814491233472E-15 (up%-> -5.552305087517896E-12) . o: 0.08423194362549333 -> a: 0.08423194362548865	 per returnMoney: o:0.023077683902033304 a: 0.011538841951016406	 per totalSpendMoney: o: 0.02107521656980125 a: 0.010537608284900985

	 Decide: !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

	 
	 ----------------------------------
MatrixKey [startValue=Six, dealerCard=Six6, situation=Start_With_A] : Double -> Hit


		 @@@   dealerCard=Six6, 	playerStartValue=6	@@@ 

net money diff:  -0.01754621086921787 , up % -> -50.00000000002436 .  o: 0.035092421738418644 -> a: 0.017546210869200773

[ProbMatrix: total: o: 4.566296923457675E-4  -> a: 4.566296923457679E-4
org->adv	$w:52.26287682254167->52.26287682254171  	$d:8.2827365920538->8.282736592053796  	$l:39.454386585404535->39.454386585404485
	 improve value x$w(high is good):4.263256414560601E-14  	x$d:-3.552713678800501E-15  	 x$l(negative is good):-4.973799150320701E-14
	 	 $w-$l: 12.808490237137137 -> 12.808490237137226  _ @double@	 lift : 8.881784197001252E-14 : good	 :| stand

[TimeMatrix: total:  o: 40417.0 -> a: 40417.0
org->adv	$w:64.33926318133459->64.33926318133459  	$d:5.1611945468490985->5.1611945468490985  	$l:30.499542271816317->30.499542271816317
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 33.83972090951827 -> 33.83972090951827  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: -6.59472476627343E-14 (up%-> -5.845947191040079E-12) . o: 1.1280849023715065 -> a: 1.1280849023714405	 returnMoney: o:0.3090702371458434 a: 0.15453511857291702	 totalSpendMoney: o: 0.2739778154074248 a: 0.13698890770371625

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.3383972090951828 -> a: 1.3383972090951828	 returnMoney: o:3.24564E7 a: 1.62282E7	 totalSpendMoney: o: 2.42502E7 a: 1.21251E7

[[Per_Prob_ROI diff: -5.065392549852277E-15 (up%-> -5.837335736844524E-12) . o: 0.08677576172088511 -> a: 0.08677576172088004	 per returnMoney: o:0.02377463362660334 a: 0.011887316813301308	 per totalSpendMoney: o: 0.021075216569801904 a: 0.010537608284901249

	 Decide: !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0


	 ----------------------
MatrixKey [startValue=Six, dealerCard=Seven7, situation=Start_With_A] : Hit -> Double
 
	 
	 
		 @@@   dealerCard=Seven7, 	playerStartValue=6	@@@ 

net money diff:  -0.009075919405499094 , up % -> -126.07521308095792 .  o: 0.007198813457226588 -> a: -0.001877105948272506

[ProbMatrix: total: o: 4.56629692345698E-4  -> a: 4.5662969234576227E-4
org->adv	$w:44.243717217897455->42.53508123132377  	$d:16.76759940448502->14.24470690168334  	$l:38.98868337761753->43.22021186699289
	 improve value x$w(high is good):-1.7086359865736824  	x$d:-2.522892502801678  	 x$l(negative is good):4.231528489375364
	 	 $w-$l: 5.255033840279927 -> -0.6851306356691178  _  _ 	 lift : -5.940164475949045 : bad	 :| stand

[TimeMatrix: total:  o: 739585.0 -> a: 24973.0
org->adv	$w:31.46440233374122->64.26140231449966  	$d:3.5751130701677294->5.205622071837585  	$l:64.96048459609105->30.532975613662757
	 improve value x$w(high is good):32.79699998075844  	x$d:1.6305090016698554  	 x$l(negative is good):-34.42750898242829
	 	 $w-$l: -33.49608226234983 -> 33.728426700836906  _ @double@	 lift : 67.22450896318674 : good	 :) hit 

[Prob_ROI diff: -0.059401644759137895 (up%-> -5.643591816168431) . o: 1.0525503384025225 -> a: 0.9931486936433847	 returnMoney: o:0.1441877211610263 a: 0.2721007094591569	 totalSpendMoney: o: 0.1369889077037997 a: 0.2739778154074294

[Time_ROI diff: 0.6722450896318675 (up%-> 101.08353199337704) . o: 0.6650391773765016 -> a: 1.337284267008369	 returnMoney: o:1.475559E8 a: 2.00376E7	 totalSpendMoney: o: 2.218755E8 a: 1.49838E7

[[Per_Prob_ROI diff: 0.07366215637431973 (up%-> 2694.4013192903967) . o: 0.0027338969828636945 -> a: 0.07639605335718343	 per returnMoney: o:3.7451356145721116E-4 a: 0.020930823804550528	 per totalSpendMoney: o: 3.5581534468519406E-4 a: 0.02107521656980226

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

	 
	 -----------------------------
MatrixKey [startValue=Six, dealerCard=Eight8, situation=Start_With_A] : Hit -> Double
	 
	 

		 @@@   dealerCard=Eight8, 	playerStartValue=6	@@@ 

net money diff:  -0.02497131208647918 , up % -> -244.23082548349635 .  o: -0.0102244718851702 -> a: -0.03519578397164938

[ProbMatrix: total: o: 4.566296923457529E-4  -> a: 4.5662969234575333E-4
org->adv	$w:40.60498827885437->39.20994083123637  	$d:11.326300972703095->8.73390160303858  	$l:48.068710748442534->52.056157565725044
	 improve value x$w(high is good):-1.3950474476179977  	x$d:-2.5923993696645145  	 x$l(negative is good):3.9874468172825104
	 	 $w-$l: -7.463722469588163 -> -12.846216734488674  _  _ 	 lift : -5.382494264900512 : bad	 :| stand

[TimeMatrix: total:  o: 443905.0 -> a: 14989.0
org->adv	$w:31.45492841936901->64.24044299152712  	$d:3.5755398114461427->5.17045833611315  	$l:64.96953176918485->30.589098672359732
	 improve value x$w(high is good):32.78551457215811  	x$d:1.594918524667007  	 x$l(negative is good):-34.38043309682512
	 	 $w-$l: -33.51460334981584 -> 33.65134431916739  _ @double@	 lift : 67.16594766898322 : good	 :) hit 

[Prob_ROI diff: -0.05382494264870086 (up%-> -5.816631496877267) . o: 0.9253627753038416 -> a: 0.8715378326551407	 returnMoney: o:0.1267644358186348 a: 0.23878203143578955	 totalSpendMoney: o: 0.136988907703805 a: 0.27397781540743893

[Time_ROI diff: 0.6716594766898323 (up%-> 101.02360977460933) . o: 0.6648539665018416 -> a: 1.3365134431916739	 returnMoney: o:8.85396E7 a: 1.20198E7	 totalSpendMoney: o: 1.331715E8 a: 8993400.0

[[Per_Prob_ROI diff: 0.06463783206658927 (up%-> 2689.276682592482) . o: 0.0024035396761138738 -> a: 0.06704137174270314	 per returnMoney: o:3.292582748535969E-4 a: 0.01836784857198381	 per totalSpendMoney: o: 3.5581534468520783E-4 a: 0.021075216569802994

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0


	 ---------------------------
MatrixKey [startValue=Six, dealerCard=Nine9, situation=Start_With_A] : Hit -> Double
		 
	 
		 @@@   dealerCard=Nine9, 	playerStartValue=6	@@@ 

net money diff:  -0.03297754561159019 , up % -> -154.1827678798642 .  o: -0.02138860656418204 -> a: -0.05436615217577223

[ProbMatrix: total: o: 4.5662969234576075E-4  -> a: 4.5662969234574997E-4
org->adv	$w:36.51281042919979->35.716566704463496  	$d:11.360993413734416->8.723598589639062  	$l:52.126196157065806->55.55983470589744
	 improve value x$w(high is good):-0.7962437247362928  	x$d:-2.637394824095354  	 x$l(negative is good):3.433638548831631
	 	 $w-$l: -15.613385727866019 -> -19.843268001433938  _  _ 	 lift : -4.22988227356792 : bad	 :| stand

[TimeMatrix: total:  o: 296065.0 -> a: 9997.0
org->adv	$w:31.426882610237616->64.19925977793338  	$d:3.577592758346985->5.171551465439632  	$l:64.9955246314154->30.62918875662699
	 improve value x$w(high is good):32.772377167695765  	x$d:1.5939587070926469  	 x$l(negative is good):-34.36633587478842
	 	 $w-$l: -33.56864202117779 -> 33.57007102130639  _ @double@	 lift : 67.13871304248417 : good	 :) hit 

[Prob_ROI diff: -0.04229882273565855 (up%-> -5.0125038313839845) . o: 0.8438661427213227 -> a: 0.8015673199856641	 returnMoney: o:0.11560030113958611 a: 0.2196116632316723	 totalSpendMoney: o: 0.13698890770376815 a: 0.27397781540744454

[Time_ROI diff: 0.6713871304248419 (up%-> 101.06479091378422) . o: 0.6643135797882221 -> a: 1.335700710213064	 returnMoney: o:5.9004E7 a: 8011800.0	 totalSpendMoney: o: 8.88195E7 a: 5998200.0

[[Per_Prob_ROI diff: 0.05946716450331737 (up%-> 2713.091232685935) . o: 0.0021918601109644745 -> a: 0.06165902461428185	 per returnMoney: o:3.002605224404834E-4 a: 0.016893204863974793	 per totalSpendMoney: o: 3.558153446851121E-4 a: 0.021075216569803427

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

	 
	 -----------------------
MatrixKey [startValue=Six, dealerCard=Ten, situation=Start_With_A] : Hit -> Double	 
	 

		 @@@   dealerCard=Ten, 	playerStartValue=6	@@@ 

net money diff:  -0.042382205672185924 , up % -> -122.78623375894165 .  o: -0.034517066266070345 -> a: -0.07689927193825627

[ProbMatrix: total: o: 4.5662969234571934E-4  -> a: 4.566296923457459E-4
org->adv	$w:31.722103468652342->31.63601481017747  	$d:11.35881409216347->8.660270144903201  	$l:56.9190824391842->59.703715044919335
	 improve value x$w(high is good):-0.08608865847487124  	x$d:-2.6985439472602692  	 x$l(negative is good):2.7846326057351334
	 	 $w-$l: -25.19697897053186 -> -28.067700234741867  _  _ 	 lift : -2.8707212642100077 : bad	 :| stand

[TimeMatrix: total:  o: 148225.0 -> a: 5005.0
org->adv	$w:31.38606847697757->64.11588411588411  	$d:3.5837409343902853->5.174825174825175  	$l:65.03019058863214->30.70929070929071
	 improve value x$w(high is good):32.729815638906544  	x$d:1.5910842404348897  	 x$l(negative is good):-34.320899879341425
	 	 $w-$l: -33.644122111654575 -> 33.4065934065934  _ @double@	 lift : 67.05071551824797 : good	 :) hit 

[Prob_ROI diff: -0.028707212642113178 (up%-> -3.8377076549894467) . o: 0.7480302102946953 -> a: 0.7193229976525821	 returnMoney: o:0.10247184143766802 a: 0.1970785434691902	 totalSpendMoney: o: 0.13698890770373837 a: 0.2739778154074465

[Time_ROI diff: 0.6705071551824798 (up%-> 101.04713802607169) . o: 0.6635587788834542 -> a: 1.334065934065934	 returnMoney: o:2.95068E7 a: 4006200.0	 totalSpendMoney: o: 4.44675E7 a: 3003000.0

[[Per_Prob_ROI diff: 0.053389602669812804 (up%-> 2747.8832732945434) . o: 0.0019429356111550528 -> a: 0.055332538280967854	 per returnMoney: o:2.6616062711082604E-4 a: 0.015159887959168478	 per totalSpendMoney: o: 3.5581534468503474E-4 a: 0.021075216569803577

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0


		 */
	}
	
	public static void testA7vsAll() {
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
		
		System.out.println(o.diffWith(t));
		
		for(Card playerCard : Card.values()) {
			if(playerCard.getValue() == 7) {
				for(Card dealerCard : Card.values()) {
					if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
					PlayerCardsPathValue nine = new PlayerCardsPathValue(Card.One1,playerCard);
					Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, nine, dealerCard); 
//					HelloWorld.print(origin);
					PlayerCardsPathValue ninet = new PlayerCardsPathValue(Card.One1,playerCard);
					Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, ninet, dealerCard); 
//					HelloWorld.print(advanced);
					
					DealerVSPlayerResult9102 result = new DealerVSPlayerResult9102(dealerCard, playerCard.getValue(), RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), origin),RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), advanced));
					
					System.out.println(result);
					System.out.println();
					System.out.println("--------------------------------");
					System.out.println();
				}
			}
		}
		/**
MatrixKey [startValue=Seven, dealerCard=One1, situation=Start_With_A] : Hit -> Stand

		 @@@   dealerCard=One1, 	playerStartValue=7	@@@ 

net money diff:  -0.005384678958866407 , up % -> -11.598806362140325 .  o: -0.04642442326171202 -> a: -0.051809102220578426

[ProbMatrix: total: o: 4.5662969234578374E-4  -> a: 4.5662969234575235E-4
org->adv	$w:26.613468588434735->24.548959667640265  	$d:12.883878625524378->13.082155614562312  	$l:60.502652786040876->62.36888471779742
	 improve value x$w(high is good):-2.06450892079447  	x$d:0.19827698903793411  	 x$l(negative is good):1.8662319317565448
	 	 $w-$l: -33.88918419760614 -> -37.81992505015716  _  _ 	 lift : -3.930740852551018 : bad	 :| stand

[TimeMatrix: total:  o: 5470465.0 -> a: 14209.0
org->adv	$w:31.6801222565175->66.64789921880498  	$d:3.5296451032956067->8.332746850587656  	$l:64.7902326401869->25.019353930607362
	 improve value x$w(high is good):34.96777696228748  	x$d:4.8031017472920485  	 x$l(negative is good):-39.770878709579534
	 	 $w-$l: -33.110110383669394 -> 41.62854528819762  _ @double@	 lift : 74.73865567186702 : good	 :) hit 

[Prob_ROI diff: -0.03930740852785786 (up%-> -5.945684991274089) . o: 0.6611081580262925 -> a: 0.6218007494984347	 returnMoney: o:0.09056448444210284 a: 0.08517980548315059	 totalSpendMoney: o: 0.13698890770381486 a: 0.136988907703729

[Time_ROI diff: 0.7473865567186702 (up%-> 111.73386008043316) . o: 0.668898896163306 -> a: 1.4162854528819762	 returnMoney: o:1.0977564E9 a: 6037200.0	 totalSpendMoney: o: 1.6411395E9 a: 4262700.0

[[Per_Prob_ROI diff: 0.6200835854516131 (up%-> 36110.911278359476) . o: 0.001717164046821539 -> a: 0.6218007494984347	 per returnMoney: o:2.3523242712234505E-4 a: 0.08517980548315059	 per totalSpendMoney: o: 3.558153446852334E-4 a: 0.136988907703729

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

--------------------------------
MatrixKey [startValue=Seven, dealerCard=Two2, situation=Start_With_A] : Stand -> Hit


		 @@@   dealerCard=Two2, 	playerStartValue=7	@@@ 

net money diff:  -0.00800900508297317 , up % -> -48.434419131879295 .  o: 0.016535771929391596 -> a: 0.008526766846418427

[ProbMatrix: total: o: 4.5662969234576325E-4  -> a: 4.566296923454396E-4
org->adv	$w:49.316010585211195->48.87722790624818  	$d:13.438862674531759->8.469965558019442  	$l:37.24512674025704->42.65280653573238
	 improve value x$w(high is good):-0.43878267896301537  	x$d:-4.968897116512316  	 x$l(negative is good):5.407679795475339
	 	 $w-$l: 12.07088384495415 -> 6.224421370515803  _ @double@	 lift : -5.846462474438346 : bad	 :| stand

[TimeMatrix: total:  o: 26689.0 -> a: 667225.0
org->adv	$w:66.31571059237888->56.389224024879155  	$d:8.370489714863801->4.367642099741467  	$l:25.313799692757318->39.24313387537937
	 improve value x$w(high is good):-9.926486567499722  	x$d:-4.0028476151223344  	 x$l(negative is good):13.929334182622053
	 	 $w-$l: 41.00191089962157 -> 17.146090149499788  _ @double@	 lift : -23.85582075012178 : bad	 :| stand

[Prob_ROI diff: -0.058464624743858495 (up%-> -5.216754141489689) . o: 1.1207088384495616 -> a: 1.062244213705703	 returnMoney: o:0.15352467963312277 a: 0.1455156745500941	 totalSpendMoney: o: 0.13698890770373118 a: 0.13698890770367567

[Time_ROI diff: -0.2385582075012178 (up%-> -16.918792517006807) . o: 1.4100191089962157 -> a: 1.171460901494998	 returnMoney: o:1.12896E7 a: 2.344884E8	 totalSpendMoney: o: 8006700.0 a: 2.001675E8

[[Per_Prob_ROI diff: -1.0782190699013334 (up%-> -96.20867016565958) . o: 1.1207088384495616 -> a: 0.04248976854822813	 per returnMoney: o:0.15352467963312277 a: 0.005820626982003764	 per totalSpendMoney: o: 0.13698890770373118 a: 0.005479556308147027

	 Decide: !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

--------------------------------
MatrixKey [startValue=Seven, dealerCard=Three3, situation=Start_With_A] : Stand -> Hit


		 @@@   dealerCard=Three3, 	playerStartValue=7	@@@ 

net money diff:  -0.00805373882703303 , up % -> -39.85341817321738 .  o: 0.02020840167844215 -> a: 0.01215466285140912

[ProbMatrix: total: o: 4.566296923457612E-4  -> a: 4.566296923458244E-4
org->adv	$w:50.84898508266378->50.51815608582126  	$d:13.053882387688171->7.8364228951189805  	$l:36.09713252964805->41.64542101905976
	 improve value x$w(high is good):-0.33082899684252  	x$d:-5.217459492569191  	 x$l(negative is good):5.548288489411711
	 	 $w-$l: 14.751852553015727 -> 8.872735066761505  _ @double@	 lift : -5.879117486254221 : bad	 :| stand

[TimeMatrix: total:  o: 15553.0 -> a: 202189.0
org->adv	$w:66.295891467884->66.3107290703253  	$d:8.371375297370284->5.167442343549847  	$l:25.332733234745707->28.521828586124865
	 improve value x$w(high is good):0.014837602441289732  	x$d:-3.203932953820437  	 x$l(negative is good):3.1890953513791587
	 	 $w-$l: 40.963158233138294 -> 37.788900484200425  _ @double@	 lift : -3.17425774893787 : bad	 :| stand

[Prob_ROI diff: -0.05879117486251362 (up%-> -5.1233312190190015) . o: 1.1475185255301679 -> a: 1.0887273506676542	 returnMoney: o:0.15719730938216986 a: 0.14914357055515426	 totalSpendMoney: o: 0.1369889077037277 a: 0.13698890770374514

[Time_ROI diff: -0.0317425774893787 (up%-> -2.2518350104556966) . o: 1.409631582331383 -> a: 1.3778890048420043	 returnMoney: o:6577200.0 a: 8.35782E7	 totalSpendMoney: o: 4665900.0 a: 6.06567E7

[[Per_Prob_ROI diff: -1.0637702677865022 (up%-> -92.70179470915531) . o: 1.1475185255301679 -> a: 0.0837482577436657	 per returnMoney: o:0.15719730938216986 a: 0.011472582350396481	 per totalSpendMoney: o: 0.1369889077037277 a: 0.010537608284903473

	 Decide: !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

--------------------------------
MatrixKey [startValue=Seven, dealerCard=Four4, situation=Start_With_A] : Stand -> Hit


		 @@@   dealerCard=Four4, 	playerStartValue=7	@@@ 

net money diff:  -0.0077943193865129545 , up % -> -32.18494651277962 .  o: 0.02421728239758944 -> a: 0.016422963011076486

[ProbMatrix: total: o: 4.56629692345755E-4  -> a: 4.566296923458144E-4
org->adv	$w:52.636064085514974->52.23429332579642  	$d:12.40615162806455->7.519948249775742  	$l:34.957784286420484->40.24575842442784
	 improve value x$w(high is good):-0.40177075971855203  	x$d:-4.8862033782888075  	 x$l(negative is good):5.287974138007357
	 	 $w-$l: 17.678279799094494 -> 11.988534901368581  _ @double@	 lift : -5.689744897725912 : bad	 :| stand

[TimeMatrix: total:  o: 9073.0 -> a: 117949.0
org->adv	$w:66.27355891105478->66.2922110403649  	$d:8.376501708365481->5.170031115142986  	$l:25.349939380579745->28.537757844492113
	 improve value x$w(high is good):0.018652129310126497  	x$d:-3.2064705932224955  	 x$l(negative is good):3.187818463912368
	 	 $w-$l: 40.92361953047503 -> 37.75445319587279  _ @double@	 lift : -3.1691663346022416 : bad	 :| stand

[Prob_ROI diff: -0.056897448977182075 (up%-> -4.835000059001483) . o: 1.176782797990957 -> a: 1.119885349013775	 returnMoney: o:0.1612061901013143 a: 0.15341187071479828	 totalSpendMoney: o: 0.13698890770372485 a: 0.1369889077037218

[Time_ROI diff: -0.03169166334602247 (up%-> -2.2488539147384787) . o: 1.4092361953047503 -> a: 1.3775445319587278	 returnMoney: o:3835800.0 a: 4.8744E7	 totalSpendMoney: o: 2721900.0 a: 3.53847E7

[[Per_Prob_ROI diff: -1.0906377711437436 (up%-> -92.67961538915395) . o: 1.176782797990957 -> a: 0.08614502684721347	 per returnMoney: o:0.1612061901013143 a: 0.011800913131907561	 per totalSpendMoney: o: 0.13698890770372485 a: 0.010537608284901677

	 Decide: !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

--------------------------------
MatrixKey [startValue=Seven, dealerCard=Five5, situation=Start_With_A] : Stand -> Hit


		 @@@   dealerCard=Five5, 	playerStartValue=7	@@@ 

net money diff:  -0.007117773166400221 , up % -> -25.60352775618923 .  o: 0.02779997051257757 -> a: 0.02068219734617735

[ProbMatrix: total: o: 4.5662969234575154E-4  -> a: 4.566296923457832E-4
org->adv	$w:54.024940077968395->53.894639889446935  	$d:12.243712207542554->7.308437031064492  	$l:33.73134771448903->38.79692307948858
	 improve value x$w(high is good):-0.13030018852145986  	x$d:-4.935275176478062  	 x$l(negative is good):5.065575364999546
	 	 $w-$l: 20.293592363479362 -> 15.097716809958362  _ @double@	 lift : -5.195875553521001 : bad	 :| stand

[TimeMatrix: total:  o: 5473.0 -> a: 71149.0
org->adv	$w:66.270783847981->66.28202785703242  	$d:8.368353736524758->5.169433161393695  	$l:25.360862415494246->28.548538981573877
	 improve value x$w(high is good):0.011244009051424086  	x$d:-3.198920575131064  	 x$l(negative is good):3.187676566079631
	 	 $w-$l: 40.909921432486755 -> 37.73348887545854  _ @double@	 lift : -3.176432557028208 : bad	 :| stand

[Prob_ROI diff: -0.05195875553510132 (up%-> -4.319328612126108) . o: 1.2029359236347985 -> a: 1.1509771680996972	 returnMoney: o:0.1647888782163024 a: 0.15767110504989015	 totalSpendMoney: o: 0.13698890770372482 a: 0.1369889077037128

[Time_ROI diff: -0.03176432557028197 (up%-> -2.2542291733163022) . o: 1.4090992143248675 -> a: 1.3773348887545855	 returnMoney: o:2313600.0 a: 2.93988E7	 totalSpendMoney: o: 1641900.0 a: 2.13447E7

[[Per_Prob_ROI diff: -1.1143992183963602 (up%-> -92.63994835477894) . o: 1.2029359236347985 -> a: 0.08853670523843825	 per returnMoney: o:0.1647888782163024 a: 0.012128546542299242	 per totalSpendMoney: o: 0.13698890770372482 a: 0.010537608284900985

	 Decide: !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

--------------------------------
MatrixKey [startValue=Seven, dealerCard=Six6, situation=Start_With_A] : Stand -> Hit


		 @@@   dealerCard=Six6, 	playerStartValue=7	@@@ 

net money diff:  -0.012704397943175905 , up % -> -32.736836834005615 .  o: 0.03880765269898992 -> a: 0.026103254755814015

[ProbMatrix: total: o: 4.566296923457472E-4  -> a: 4.5662969234576227E-4
org->adv	$w:58.85482152551164->56.07729035159218  	$d:10.619404424062507->6.9004327233488425  	$l:30.525774050425845->37.022276925058975
	 improve value x$w(high is good):-2.7775311739194564  	x$d:-3.7189717007136647  	 x$l(negative is good):6.49650287463313
	 	 $w-$l: 28.32904747508579 -> 19.055013426533208  _ @double@	 lift : -9.274034048552583 : bad	 :| stand

[TimeMatrix: total:  o: 3109.0 -> a: 40417.0
org->adv	$w:66.22708266323578->66.26172155281193  	$d:8.394982309424252->5.176039785238885  	$l:25.37793502733998->28.56223866194918
	 improve value x$w(high is good):0.034638889576157794  	x$d:-3.2189425241853673  	 x$l(negative is good):3.1843036346092006
	 	 $w-$l: 40.84914763589579 -> 37.699482890862754  _ @double@	 lift : -3.1496647450330317 : bad	 :| stand

[Prob_ROI diff: -0.09274034048545898 (up%-> -7.226761384904973) . o: 1.2832904747508618 -> a: 1.1905501342654028	 returnMoney: o:0.17579656040271377 a: 0.16309216245953026	 totalSpendMoney: o: 0.13698890770372385 a: 0.13698890770371625

[Time_ROI diff: -0.031496647450330206 (up%-> -2.236197235055415) . o: 1.4084914763589578 -> a: 1.3769948289086276	 returnMoney: o:1313700.0 a: 1.66962E7	 totalSpendMoney: o: 932700.0 a: 1.21251E7

[[Per_Prob_ROI diff: -1.1917096951919846 (up%-> -92.86359702960806) . o: 1.2832904747508618 -> a: 0.09158077955887715	 per returnMoney: o:0.17579656040271377 a: 0.012545550958425404	 per totalSpendMoney: o: 0.13698890770372385 a: 0.010537608284901249

	 Decide: !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

--------------------------------
MatrixKey [startValue=Seven, dealerCard=Seven7, situation=Start_With_A] : Stand -> Hit


		 @@@   dealerCard=Seven7, 	playerStartValue=7	@@@ 

net money diff:  -0.031467661160133 , up % -> -57.396058640030034 .  o: 0.05482547391884213 -> a: 0.02335781275870913

[ProbMatrix: total: o: 4.566296923457458E-4  -> a: 4.566296923456107E-4
org->adv	$w:63.114371112874124->52.811698729437275  	$d:13.793092270091028->11.42748144101315  	$l:23.09253661703485->35.76081982954957
	 improve value x$w(high is good):-10.30267238343685  	x$d:-2.3656108290778786  	 x$l(negative is good):12.66828321251472
	 	 $w-$l: 40.02183449583928 -> 17.050878899887707  _ @double@	 lift : -22.97095559595157 : bad	 :| stand

[TimeMatrix: total:  o: 1921.0 -> a: 739585.0
org->adv	$w:66.26756897449245->31.530520494601706  	$d:8.328995314940135->3.5738961715015853  	$l:25.40343571056741->64.89558333389671
	 improve value x$w(high is good):-34.737048479890746  	x$d:-4.7550991434385494  	 x$l(negative is good):39.4921476233293
	 	 $w-$l: 40.86413326392504 -> -33.36506283929501  _  _ 	 lift : -74.22919610322005 : bad	 :| stand

[Prob_ROI diff: -0.22970955596065123 (up%-> -16.405266849112547) . o: 1.400218344958391 -> a: 1.1705087889977397	 returnMoney: o:0.191814381622566 a: 0.16034672046257403	 totalSpendMoney: o: 0.13698890770372388 a: 0.1369889077038649

[Time_ROI diff: -0.7422919610322005 (up%-> -52.69559708584099) . o: 1.4086413326392504 -> a: 0.6663493716070499	 returnMoney: o:811800.0 a: 1.478466E8	 totalSpendMoney: o: 576300.0 a: 2.218755E8

[[Per_Prob_ROI diff: -1.3971780623895655 (up%-> -99.78287082298469) . o: 1.400218344958391 -> a: 0.0030402825688252977	 per returnMoney: o:0.191814381622566 a: 4.1648498821447803E-4	 per totalSpendMoney: o: 0.13698890770372388 a: 3.5581534468536336E-4

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

--------------------------------
MatrixKey [startValue=Seven, dealerCard=Eight8, situation=Start_With_A] : Stand -> Hit


		 @@@   dealerCard=Eight8, 	playerStartValue=7	@@@ 

net money diff:  -0.009192054802727195 , up % -> -63.7714130230815 .  o: 0.014414067945146852 -> a: 0.005222013142419657

[ProbMatrix: total: o: 4.566296923457454E-4  -> a: 4.566296923457241E-4
org->adv	$w:37.263289009055406->43.518828704894005  	$d:35.995491386458006->16.774339656271657  	$l:26.741219604486588->39.706831638834345
	 improve value x$w(high is good):6.2555396958386  	x$d:-19.22115173018635  	 x$l(negative is good):12.965612034347757
	 	 $w-$l: 10.522069404568818 -> 3.8119970660596634  _  _ 	 lift : -6.710072338509154 : bad	 :| stand

[TimeMatrix: total:  o: 1153.0 -> a: 443905.0
org->adv	$w:66.08846487424111->31.519807165947668  	$d:8.586296617519515->3.5775672722767258  	$l:25.32523850823938->64.90262556177561
	 improve value x$w(high is good):-34.56865770829344  	x$d:-5.00872934524279  	 x$l(negative is good):39.57738705353623
	 	 $w-$l: 40.76322636600174 -> -33.38281839582794  _  _ 	 lift : -74.14604476182967 : bad	 :| stand

[Prob_ROI diff: -0.06710072338565887 (up%-> -6.071251085612126) . o: 1.1052206940456908 -> a: 1.038119970660032	 returnMoney: o:0.15140297564887026 a: 0.1422109208462457	 totalSpendMoney: o: 0.1369889077037234 a: 0.13698890770382605

[Time_ROI diff: -0.7414604476182968 (up%-> -52.67430043770155) . o: 1.4076322636600174 -> a: 0.6661718160417206	 returnMoney: o:486900.0 a: 8.87151E7	 totalSpendMoney: o: 345900.0 a: 1.331715E8

[[Per_Prob_ROI diff: -1.102524278537483 (up%-> -99.75602922359899) . o: 1.1052206940456908 -> a: 0.0026964155082078744	 per returnMoney: o:0.15140297564887026 a: 3.6937901518505376E-4	 per totalSpendMoney: o: 0.1369889077037234 a: 3.558153446852625E-4

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

--------------------------------
MatrixKey [startValue=Seven, dealerCard=Nine9, situation=Start_With_A] : Hit -> Stand


		 @@@   dealerCard=Nine9, 	playerStartValue=7	@@@ 

net money diff:  -0.011205543896956521 , up % -> -80.3927537546814 .  o: -0.01393849989409525 -> a: -0.02514404379105177

[ProbMatrix: total: o: 4.566296923457661E-4  -> a: 4.5662969234574514E-4
org->adv	$w:39.29852752596944->34.955174809922354  	$d:11.228033615659363->11.734847635517617  	$l:49.473438858371196->53.30997755456003
	 improve value x$w(high is good):-4.343352716047086  	x$d:0.506814019858254  	 x$l(negative is good):3.836538696188832
	 	 $w-$l: -10.174911332401754 -> -18.35480274463767  _  _ 	 lift : -8.179891412235918 : bad	 :| stand

[TimeMatrix: total:  o: 296065.0 -> a: 769.0
org->adv	$w:31.491733234255992->66.05981794538361  	$d:3.577592758346985->8.322496749024708  	$l:64.93067400739703->25.617685305591674
	 improve value x$w(high is good):34.568084711127625  	x$d:4.744903990677724  	 x$l(negative is good):-39.31298870180535
	 	 $w-$l: -33.438940773141034 -> 40.442132639791936  _ @double@	 lift : 73.88107341293298 : good	 :) hit 

[Prob_ROI diff: -0.08179891412227491 (up%-> -9.10646628192963) . o: 0.8982508866759016 -> a: 0.8164519725536267	 returnMoney: o:0.12305040780967373 a: 0.11184486391267186	 totalSpendMoney: o: 0.13698890770376898 a: 0.13698890770372363

[Time_ROI diff: 0.7388107341293296 (up%-> 110.99744245524296) . o: 0.6656105922685897 -> a: 1.4044213263979193	 returnMoney: o:5.91192E7 a: 324000.0	 totalSpendMoney: o: 8.88195E7 a: 230700.0

[[Per_Prob_ROI diff: 0.8141188533674555 (up%-> 34894.01048145708) . o: 0.0023331191861711733 -> a: 0.8164519725536267	 per returnMoney: o:3.196114488562954E-4 a: 0.11184486391267186	 per totalSpendMoney: o: 3.558153446851142E-4 a: 0.13698890770372363

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0

--------------------------------
MatrixKey [startValue=Seven, dealerCard=Ten, situation=Start_With_A] : Hit -> Stand

		 @@@   dealerCard=Ten, 	playerStartValue=7	@@@ 

net money diff:  -0.005406111786402573 , up % -> -19.72231895278629 .  o: -0.027411136587661866 -> a: -0.03281724837406444

[ProbMatrix: total: o: 4.566296923457398E-4  -> a: 4.566296923457448E-4
org->adv	$w:34.317539895689336->32.438494438672834  	$d:11.35517120985165->11.166875604703382  	$l:54.327288894459016->56.394629956623774
	 improve value x$w(high is good):-1.8790454570165025  	x$d:-0.1882956051482676  	 x$l(negative is good):2.0673410621647577
	 	 $w-$l: -20.009748998769677 -> -23.956135517950944  _  _ 	 lift : -3.9463865191812664 : bad	 :| stand

[TimeMatrix: total:  o: 148225.0 -> a: 385.0
org->adv	$w:31.450834879406308->65.97402597402598  	$d:3.5837409343902853->8.311688311688311  	$l:64.9654241862034->25.71428571428571
	 improve value x$w(high is good):34.52319109461967  	x$d:4.727947377298026  	 x$l(negative is good):-39.2511384719177
	 	 $w-$l: -33.51458930679709 -> 40.25974025974026  _ @double@	 lift : 73.77432956653736 : good	 :) hit 

[Prob_ROI diff: -0.03946386519189293 (up%-> -4.9335843678352616) . o: 0.7999025100123854 -> a: 0.7604386448204925	 returnMoney: o:0.10957777111607062 a: 0.10417165932965894	 totalSpendMoney: o: 0.13698890770373248 a: 0.13698890770372338

[Time_ROI diff: 0.7377432956653736 (up%-> 110.96318545277428) . o: 0.6648541069320291 -> a: 1.4025974025974026	 returnMoney: o:2.95644E7 a: 162000.0	 totalSpendMoney: o: 4.44675E7 a: 115500.0

[[Per_Prob_ROI diff: 0.7583609759633175 (up%-> 36500.570018383434) . o: 0.0020776688571750267 -> a: 0.7604386448204925	 per returnMoney: o:2.846175873144691E-4 a: 0.10417165932965894	 per totalSpendMoney: o: 3.5581534468501945E-4 a: 0.13698890770372338

	 Decide: !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0


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
		
//		testA2345vsAll();
//		testA6vsAll();
//		testA7vsAll();

	}

}
