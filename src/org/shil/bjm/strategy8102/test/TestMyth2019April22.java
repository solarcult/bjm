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
import org.shil.bjm.strategy8102.strategy.Myth2019April22;
import org.shil.bjm.strategy8102.strategy.StrategyMatrix8012;
import org.shil.bjm.strategy8102.strategy.practise.MirMyth2019April22;

/*
 * Prob_ROI diff: -0.028001286829884453 (up%-> -2.636997498340324) . o: 1.0618624722817496 -> a: 1.0338611854518651	来判断 o a的数据判断是否投降，当o或者a都小于0.5时，投降
 * 选择哪一个行为change or not change 根据net money diff:  -0.00365773254643797 , up % -> -23.129611590863142 ，上一条的up和这一条的up相加，判断是否大于0来决定。绝对ROI的提升比率来定义.
 */
public class TestMyth2019April22 {
	
	public static void test8vs6() {
		StrategyMatrix8012 o = new Myth2019April22();
		StrategyMatrix8012 t = new MirMyth2019April22();
		
		Card dealerCard = Card.Six6;
		PlayerCardsPathValue nine = new PlayerCardsPathValue(Card.Five5,Card.Three3);
		Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, nine, dealerCard); 
		HelloWorld.print(origin);
		PlayerCardsPathValue ninet = new PlayerCardsPathValue(Card.Five5,Card.Three3);
		Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, ninet, dealerCard); 
		HelloWorld.print(advanced);
		
		System.out.println(o.diffWith(t));

		DealerVSPlayerResult9102 result = new DealerVSPlayerResult9102(dealerCard, nine.getValue(), RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), origin),RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), advanced));
		
		System.out.println(result);
		
		/**

		 */	
	}
	
	public static void test9vs2() {
		StrategyMatrix8012 o = new Myth2019April22();
		StrategyMatrix8012 t = new MirMyth2019April22();
		
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

		 @@@   dealerCard=Two2, 	playerStartValue=9	@@@ 

net money diff:  -0.0017152799667555785 , up % -> -16.35905879538083 .  o: 0.010485199596201145 -> a: 0.008769919629445566 (anet/onet: 0.8364094120461917

[ProbMatrix: total: o: 4.566296923454443E-4  -> a: 4.5662969234585687E-4
org->adv	$w:49.764111498007246->48.046379769693935  	$d:8.12582708129371->7.108200223169909  	$l:42.110061420699054->44.84542000713616
	 improve value x$w(high is good):-1.7177317283133107  	x$d:-1.0176268581238013  	 x$l(negative is good):2.7353585864371084
	 	 $w-$l: 7.654050077308194 -> 3.2009597625577757  _ #Surrender#	 lift : -4.453090314750419 : bad	 :| stand

[TimeMatrix: total:  o: 1307761.0 -> a: 346957.0
org->adv	$w:57.72744408190793->65.6816262533974  	$d:4.292221590948193->4.517562695089017  	$l:37.98033432714387->29.800811051513588
	 improve value x$w(high is good):7.954182171489464  	x$d:0.2253411041408242  	 x$l(negative is good):-8.179523275630284
	 	 $w-$l: 19.747109754764057 -> 35.880815201883806  _ @double@	 lift : 16.133705447119752 : good	 :) hit 

[Prob_ROI diff: -0.044530903149366585 (up%-> -4.136481917524167) . o: 1.0765405007746276 -> a: 1.032009597625261	 returnMoney: o:0.1474741072997798 a: 0.2827477350370528 (probReturnRate: 1.9172703616526654	 totalSpendMoney: o: 0.13698890770357866 a: 0.27397781540760724 (probTotalSpendRate: 2.0000000000032845

[Time_ROI diff: 0.1613370544711974 (up%-> 13.473148103666752) . o: 1.1974710975476406 -> a: 1.358808152018838	 returnMoney: o:4.698018E8 a: 2.828688E8 (timeReturnRate: 0.6021024185092522	 totalSpendMoney: o: 3.923283E8 a: 2.081742E8 (timeTotalSpendRate: 0.5306122448979592

[[Per_Prob_ROI diff: 0.05741513936195862 (up%-> 261.3317220031782) . o: 0.021970214301523013 -> a: 0.07938535366348164	 per returnMoney: o:0.00300967565917918 a: 0.021749825772080986	 per totalSpendMoney: o: 0.002795691993950585 a: 0.021075216569815942

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.046246183116122164

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.0017152799667555785     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9586351808247584 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

		 */
		
	}
	
	public static void test9vs3() {
		StrategyMatrix8012 o = new Myth2019April22();
		StrategyMatrix8012 t = new MirMyth2019April22();
		
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

		 @@@   dealerCard=Three3, 	playerStartValue=9	@@@ 

net money diff:  0.0028587865114573785 , up % -> 20.14059938722719 .  o: 0.014194148130816653 -> a: 0.01705293464227403 (anet/onet: 1.2014059938722719

[ProbMatrix: total: o: 4.566296923455886E-4  -> a: 4.566296923458373E-4
org->adv	$w:51.25611927038949->49.68027154993807  	$d:7.849292453715162->6.863659621408491  	$l:40.89458827589535->43.45606882865344
	 improve value x$w(high is good):-1.5758477204514207  	x$d:-0.9856328323066705  	 x$l(negative is good):2.5614805527580913
	 	 $w-$l: 10.361530994494133 -> 6.224202721284628  _ @double@	 lift : -4.137328273209507 : bad	 :| stand

[TimeMatrix: total:  o: 762097.0 -> a: 202189.0
org->adv	$w:57.71141993735706->65.66084208339721  	$d:4.294728886217896->4.519533703613946  	$l:37.993851176425046->29.81962421298884
	 improve value x$w(high is good):7.949422146040156  	x$d:0.22480481739605018  	 x$l(negative is good):-8.174226963436208
	 	 $w-$l: 19.717568760932007 -> 35.84121787040838  _ @double@	 lift : 16.123649109476375 : good	 :) hit 

[Prob_ROI diff: -0.041373282732840355 (up%-> -3.7488862613623612) . o: 1.1036153099455497 -> a: 1.0622420272127093	 returnMoney: o:0.15118305583447308 a: 0.2910307500498025 (probReturnRate: 1.9250222747742678	 totalSpendMoney: o: 0.13698890770365643 a: 0.27397781540752847 (probTotalSpendRate: 2.000000000001574

[Time_ROI diff: 0.16123649109476368 (up%-> 13.468072628232385) . o: 1.19717568760932 -> a: 1.3584121787040837	 returnMoney: o:2.737092E8 a: 1.647936E8 (timeReturnRate: 0.6020754874151106	 totalSpendMoney: o: 2.286291E8 a: 1.213134E8 (timeTotalSpendRate: 0.5306122448979592

[[Per_Prob_ROI diff: 0.05918816374274821 (up%-> 262.7926594764034) . o: 0.022522761427460198 -> a: 0.0817109251702084	 per returnMoney: o:0.003085368486417818 a: 0.02238698077306173	 per totalSpendMoney: o: 0.002795691993952172 a: 0.02107521656980988

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.03851449622138298

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.0028587865114573785     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9625111373863765 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

	 */
		
	}
	
	public static void test9vs456() {
		StrategyMatrix8012 o = new Myth2019April22();
		StrategyMatrix8012 t = new MirMyth2019April22();
		
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
		StrategyMatrix8012 o = new Myth2019April22();
		StrategyMatrix8012 a = new MirMyth2019April22();
		
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
	
	public static void test11vsEveryone() {
		StrategyMatrix8012 o = new Myth2019April22();
		StrategyMatrix8012 t = new MirMyth2019April22();
		System.out.println(t.diffWith(o));
		
		for(Card dealerCard : Card.values()) {
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			PlayerCardsPathValue nine = new PlayerCardsPathValue(Card.Six6,Card.Five5);
			Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, nine, dealerCard); 
			PlayerCardsPathValue ninet = new PlayerCardsPathValue(Card.Six6,Card.Five5);
			Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, ninet, dealerCard); 

	
			DealerVSPlayerResult9102 result = new DealerVSPlayerResult9102(dealerCard, nine.getValue() , RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), origin),RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), advanced));
			
			System.out.println(result);
			System.out.println();
			System.out.println("-----------------------------");
		}
		
		/**
MatrixKey [startValue=Eleven, dealerCard=One1, situation=Splited_Pair_And_Can_NOT_Split] : Double -> Hit
MatrixKey [startValue=Eleven, dealerCard=One1, situation=Start_Hand_WithoutA_WithoutPair] : Double -> Hit
MatrixKey [startValue=Eleven, dealerCard=Two2, situation=Start_Hand_WithoutA_WithoutPair] : Hit -> Double
MatrixKey [startValue=Eleven, dealerCard=Two2, situation=Splited_Pair_And_Can_NOT_Split] : Hit -> Double
MatrixKey [startValue=Eleven, dealerCard=Three3, situation=Splited_Pair_And_Can_NOT_Split] : Hit -> Double
MatrixKey [startValue=Eleven, dealerCard=Three3, situation=Start_Hand_WithoutA_WithoutPair] : Hit -> Double
MatrixKey [startValue=Eleven, dealerCard=Four4, situation=Splited_Pair_And_Can_NOT_Split] : Hit -> Double
MatrixKey [startValue=Eleven, dealerCard=Four4, situation=Start_Hand_WithoutA_WithoutPair] : Hit -> Double
MatrixKey [startValue=Eleven, dealerCard=Five5, situation=Splited_Pair_And_Can_NOT_Split] : Hit -> Double
MatrixKey [startValue=Eleven, dealerCard=Five5, situation=Start_Hand_WithoutA_WithoutPair] : Hit -> Double
MatrixKey [startValue=Eleven, dealerCard=Six6, situation=Splited_Pair_And_Can_NOT_Split] : Hit -> Double
MatrixKey [startValue=Eleven, dealerCard=Six6, situation=Start_Hand_WithoutA_WithoutPair] : Hit -> Double
MatrixKey [startValue=Eleven, dealerCard=Seven7, situation=Start_Hand_WithoutA_WithoutPair] : Hit -> Double
MatrixKey [startValue=Eleven, dealerCard=Seven7, situation=Splited_Pair_And_Can_NOT_Split] : Hit -> Double
MatrixKey [startValue=Eleven, dealerCard=Eight8, situation=Splited_Pair_And_Can_NOT_Split] : Hit -> Double
MatrixKey [startValue=Eleven, dealerCard=Eight8, situation=Start_Hand_WithoutA_WithoutPair] : Hit -> Double
MatrixKey [startValue=Eleven, dealerCard=Nine9, situation=Start_Hand_WithoutA_WithoutPair] : Hit -> Double
MatrixKey [startValue=Eleven, dealerCard=Nine9, situation=Splited_Pair_And_Can_NOT_Split] : Hit -> Double
MatrixKey [startValue=Eleven, dealerCard=Ten, situation=Splited_Pair_And_Can_NOT_Split] : Double -> Hit
MatrixKey [startValue=Eleven, dealerCard=Ten, situation=Start_Hand_WithoutA_WithoutPair] : Double -> Hit


		 @@@   dealerCard=One1, 	playerStartValue=11	@@@ 

net money diff:  0.03314091841600088 , up % -> 70.23274010761294 .  o: -0.04718727813441603 -> a: -0.014046359718415155 (anet/onet: 0.29767259892387066

[ProbMatrix: total: o: 4.566296923457266E-4  -> a: 4.5662969234528446E-4
org->adv	$w:33.77945864264582->35.757660095404766  	$d:15.218053885059083->18.231032302729968  	$l:51.00248747229509->46.01130760186526
	 improve value x$w(high is good):1.9782014527589453  	x$d:3.012978417670885  	 x$l(negative is good):-4.991179870429825
	 	 $w-$l: -17.223028829649266 -> -10.253647506460496  _ #Surrender#	 lift : 6.969381323188772 : good	 :) hit 

[TimeMatrix: total:  o: 184717.0 -> a: 5470465.0
org->adv	$w:72.41672396151951->31.87491374133643  	$d:5.134340640006063->3.529809623130758  	$l:22.448935398474422->64.59527663553281
	 improve value x$w(high is good):-40.54181022018308  	x$d:-1.6045310168753053  	 x$l(negative is good):42.146341237058394
	 	 $w-$l: 49.96778856304509 -> -32.720362894196384  _ #Surrender#	 lift : -82.68815145724147 : bad	 :| stand

[Prob_ROI diff: 0.06969381323495216 (up%-> 8.419468875166501) . o: 0.8277697117037436 -> a: 0.8974635249386957	 returnMoney: o:0.22679053727310589 a: 0.12294254798508404 (probReturnRate: 0.5420973443747966	 totalSpendMoney: o: 0.2739778154075219 a: 0.1369889077034992 (probTotalSpendRate: 0.4999999999990446

[Time_ROI diff: -0.8268815145724147 (up%-> -55.137274643801334) . o: 1.499677885630451 -> a: 0.6727963710580362	 returnMoney: o:1.662096E8 a: 1.1041527E9 (timeReturnRate: 6.6431343315909555	 totalSpendMoney: o: 1.108302E8 a: 1.6411395E9 (timeTotalSpendRate: 14.807692307692308

[[Per_Prob_ROI diff: -0.06134351911723041 (up%-> -96.33908286915022) . o: 0.06367459320798027 -> a: 0.0023310740907498593	 per returnMoney: o:0.017445425944085068 a: 3.1933129346775076E-4	 per totalSpendMoney: o: 0.021075216569809378 a: 3.558153446844135E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.10283473165095304

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.03314091841600088     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.084194688751665 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

-----------------------------

		 @@@   dealerCard=Two2, 	playerStartValue=11	@@@ 

net money diff:  0.03217519304334088 , up % -> 97.56654126191403 .  o: 0.03297769156023239 -> a: 0.06515288460357327 (anet/onet: 1.9756654126191404

[ProbMatrix: total: o: 4.5662969234546867E-4  -> a: 4.5662969234574026E-4
org->adv	$w:57.990530754602624->58.03501857069702  	$d:8.092195306199326->7.71031328829066  	$l:33.917273939198054->34.25466814101233
	 improve value x$w(high is good):0.04448781609439578  	x$d:-0.3818820179086657  	 x$l(negative is good):0.33739420181427704
	 	 $w-$l: 24.073256815404566 -> 23.780350429684688  _ @double@	 lift : -0.2929063857198766 : bad	 :| stand

[TimeMatrix: total:  o: 667225.0 -> a: 346957.0
org->adv	$w:59.41249203791824->72.14467498854324  	$d:4.382030049833265->5.193150736258383  	$l:36.20547791224849->22.662174275198367
	 improve value x$w(high is good):12.732182950625003  	x$d:0.8111206864251184  	 x$l(negative is good):-13.543303637050123
	 	 $w-$l: 23.20701412566975 -> 49.482500713344876  _ @double@	 lift : 26.27548658767513 : good	 :) hit 

[Prob_ROI diff: -0.00292906385770042 (up%-> -0.23607535845186675) . o: 1.2407325681547678 -> a: 1.2378035042970674	 returnMoney: o:0.1699665992639499 a: 0.3391307000111351 (probReturnRate: 1.9952784928318859	 totalSpendMoney: o: 0.13698890770371752 a: 0.27397781540756183 (probTotalSpendRate: 2.0000000000009255

[Time_ROI diff: 0.26275486587675134 (up%-> 21.326291180853094) . o: 1.2320701412566974 -> a: 1.4948250071334488	 returnMoney: o:2.466204E8 a: 3.11184E8 (timeReturnRate: 1.261793428280872	 totalSpendMoney: o: 2.001675E8 a: 2.081742E8 (timeTotalSpendRate: 1.04

[[Per_Prob_ROI diff: 0.04558635145050679 (up%-> 91.85370123374643) . o: 0.04962930272619071 -> a: 0.0952156541766975	 per returnMoney: o:0.006798663970557997 a: 0.02608697692393347	 per totalSpendMoney: o: 0.005479556308148701 a: 0.021075216569812448

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.029246129185640457

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.03217519304334088     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9976392464154813 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

-----------------------------

		 @@@   dealerCard=Three3, 	playerStartValue=11	@@@ 

net money diff:  0.035678173947230746 , up % -> 99.03887269447122 .  o: 0.03602441443098378 -> a: 0.07170258837821453 (anet/onet: 1.9903887269447122

[ProbMatrix: total: o: 4.5662969234564334E-4  -> a: 4.566296923457639E-4
org->adv	$w:59.22836494013149->59.350012920743936  	$d:7.840592315195439->7.47092098189501  	$l:32.931042744673064->33.17906609736105
	 improve value x$w(high is good):0.12164798061244397  	x$d:-0.36967133330042845  	 x$l(negative is good):0.24802335268798714
	 	 $w-$l: 26.297322195458428 -> 26.170946823382877  _ @double@	 lift : -0.12637537207554894 : bad	 :| stand

[TimeMatrix: total:  o: 388825.0 -> a: 202189.0
org->adv	$w:59.397158104545746->72.12706922730713  	$d:4.385006108146338->5.1971175484324075  	$l:36.21783578730792->22.67581322426047
	 improve value x$w(high is good):12.729911122761386  	x$d:0.8121114402860696  	 x$l(negative is good):-13.54202256304745
	 	 $w-$l: 23.179322317237826 -> 49.45125600304666  _ @double@	 lift : 26.271933685808836 : good	 :) hit 

[Prob_ROI diff: -0.0012637537212676353 (up%-> -0.10006179856379964) . o: 1.262973221955293 -> a: 1.2617094682340253	 returnMoney: o:0.17301332213470486 a: 0.345680403785706 (probReturnRate: 1.9979987640290837	 totalSpendMoney: o: 0.13698890770372107 a: 0.2739778154074915 (probTotalSpendRate: 2.00000000000036

[Time_ROI diff: 0.26271933685808824 (up%-> 21.328201187978372) . o: 1.2317932231723783 -> a: 1.4945125600304665	 returnMoney: o:1.436856E8 a: 1.813044E8 (timeReturnRate: 1.261813292354975	 totalSpendMoney: o: 1.166475E8 a: 1.213134E8 (timeTotalSpendRate: 1.04

[[Per_Prob_ROI diff: 0.046535645601328696 (up%-> 92.1152657719927) . o: 0.050518928878211716 -> a: 0.09705457447954041	 per returnMoney: o:0.006920532885388194 a: 0.026590800291208156	 per totalSpendMoney: o: 0.005479556308148843 a: 0.02107521656980704

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.03441442022596311

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.035678173947230746     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.998999382014362 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

-----------------------------

		 @@@   dealerCard=Four4, 	playerStartValue=11	@@@ 

net money diff:  0.03927680726027094 , up % -> 100.0000000000937 .  o: 0.03927680726023414 -> a: 0.07855361452050508 (anet/onet: 2.000000000000937

[ProbMatrix: total: o: 4.5662969234574373E-4  -> a: 4.5662969234575674E-4
org->adv	$w:60.71891519139423->60.71891519139424  	$d:7.233693405970254->7.233693405970093  	$l:32.04739140263552->32.04739140263566
	 improve value x$w(high is good):7.105427357601002E-15  	x$d:-1.6076029396572267E-13  	 x$l(negative is good):1.4210854715202004E-13
	 	 $w-$l: 28.671523788758712 -> 28.67152378875858  _ @double@	 lift : -1.3322676295501878E-13 : bad	 :| stand

[TimeMatrix: total:  o: 117949.0 -> a: 117949.0
org->adv	$w:72.11167538512407->72.11167538512407  	$d:5.200552781286827->5.200552781286827  	$l:22.687771833589093->22.687771833589093
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 49.423903551534984 -> 49.423903551534984  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: 1.4876988529977098E-13 (up%-> 1.1561989857523498E-11) . o: 1.2867152378875768 -> a: 1.2867152378877256	 returnMoney: o:0.17626571496396373 a: 0.3525314299279504 (probReturnRate: 2.00000000000013	 totalSpendMoney: o: 0.1369889077037296 a: 0.2739778154074453 (probTotalSpendRate: 1.9999999999998987

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.4942390355153499 -> a: 1.4942390355153499	 returnMoney: o:5.28732E7 a: 1.057464E8 (timeReturnRate: 2.0	 totalSpendMoney: o: 3.53847E7 a: 7.07694E7 (timeTotalSpendRate: 2.0

[[Per_Prob_ROI diff: 1.1421419365831298E-14 (up%-> 1.1539340437093645E-11) . o: 0.09897809522212131 -> a: 0.09897809522213273	 per returnMoney: o:0.013558901151074134 a: 0.02711780230215003	 per totalSpendMoney: o: 0.010537608284902276 a: 0.021075216569803486

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.03927680726041971

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.03927680726027094     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.0000000000001157 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

-----------------------------

		 @@@   dealerCard=Five5, 	playerStartValue=11	@@@ 

net money diff:  0.042821749785717816 , up % -> 100.00000000005484 .  o: 0.042821749785694335 -> a: 0.08564349957141215 (anet/onet: 2.0000000000005485

[ProbMatrix: total: o: 4.5662969234572714E-4  -> a: 4.5662969234573755E-4
org->adv	$w:62.144404755701984->62.14440475570208  	$d:6.970473085628755->6.970473085628612  	$l:30.885122158669258->30.885122158669297
	 improve value x$w(high is good):9.237055564881302E-14  	x$d:-1.4299672557172016E-13  	 x$l(negative is good):3.907985046680551E-14
	 	 $w-$l: 31.25928259703273 -> 31.25928259703278  _ @double@	 lift : 4.9960036108132044E-14 : good	 :| stand

[TimeMatrix: total:  o: 71149.0 -> a: 71149.0
org->adv	$w:72.10080254114605->72.10080254114605  	$d:5.2031651885479775->5.2031651885479775  	$l:22.696032270305977->22.696032270305977
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 49.40477027084007 -> 49.40477027084007  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: 9.50350909079134E-14 (up%-> 7.240256767185871E-12) . o: 1.3125928259703343 -> a: 1.3125928259704294	 returnMoney: o:0.17981065748941177 a: 0.3596213149788389 (probReturnRate: 2.0000000000000857	 totalSpendMoney: o: 0.13698890770371744 a: 0.2739778154074268 (probTotalSpendRate: 1.999999999999941

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.4940477027084007 -> a: 1.4940477027084007	 returnMoney: o:3.189E7 a: 6.378E7 (timeReturnRate: 2.0	 totalSpendMoney: o: 2.13447E7 a: 4.26894E7 (timeTotalSpendRate: 2.0

[[Per_Prob_ROI diff: 7.299716386910404E-15 (up%-> 7.229683962327247E-12) . o: 0.10096867892079495 -> a: 0.10096867892080225	 per returnMoney: o:0.013831589037647059 a: 0.0276631780752953	 per totalSpendMoney: o: 0.01053760828490134 a: 0.02107521656980206

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.04282174978581285

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.042821749785717816     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.0000000000000724 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

-----------------------------

		 @@@   dealerCard=Six6, 	playerStartValue=11	@@@ 

net money diff:  0.04602575930374503 , up % -> 100.00000000003149 .  o: 0.04602575930373054 -> a: 0.09205151860747557 (anet/onet: 2.000000000000315

[ProbMatrix: total: o: 4.5662969234574156E-4  -> a: 4.56629692345743E-4
org->adv	$w:63.461995970514906->63.46199597051486  	$d:6.6741731040382755->6.674173104038264  	$l:29.863830925446827->29.863830925446873
	 improve value x$w(high is good):-4.263256414560601E-14  	x$d:-1.1546319456101628E-14  	 x$l(negative is good):4.618527782440651E-14
	 	 $w-$l: 33.59816504506808 -> 33.598165045067994  _ @double@	 lift : -8.881784197001252E-14 : bad	 :| stand

[TimeMatrix: total:  o: 40417.0 -> a: 40417.0
org->adv	$w:72.08847762080313->72.08847762080313  	$d:5.205730262018458->5.205730262018458  	$l:22.705792117178415->22.705792117178415
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 49.382685503624714 -> 49.382685503624714  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: 5.928590951498336E-14 (up%-> 4.4376290269394164E-12) . o: 1.3359816504506732 -> a: 1.3359816504507325	 returnMoney: o:0.18301466700744978 a: 0.36602933401490895 (probReturnRate: 2.000000000000051	 totalSpendMoney: o: 0.13698890770371924 a: 0.2739778154074334 (probTotalSpendRate: 1.9999999999999627

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.493826855036247 -> a: 1.493826855036247	 returnMoney: o:1.81128E7 a: 3.62256E7 (timeReturnRate: 2.0	 totalSpendMoney: o: 1.21251E7 a: 2.42502E7 (timeTotalSpendRate: 2.0

[[Per_Prob_ROI diff: 4.538036613155327E-15 (up%-> 4.415814839306988E-12) . o: 0.10276781926543642 -> a: 0.10276781926544096	 per returnMoney: o:0.014078051308265368 a: 0.028156102616531457	 per totalSpendMoney: o: 0.01053760828490148 a: 0.021075216569802567

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.046025759303804314

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.04602575930374503     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.0000000000000442 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

-----------------------------

		 @@@   dealerCard=Seven7, 	playerStartValue=11	@@@ 

net money diff:  0.024170440467895682 , up % -> 60.21414980428771 .  o: 0.0401407983778832 -> a: 0.06431123884577888 (anet/onet: 1.602141498042877

[ProbMatrix: total: o: 4.566296923456104E-4  -> a: 4.566296923457565E-4
org->adv	$w:59.735692519546625->58.08188882005745  	$d:9.83084026572913->7.309377932766119  	$l:30.433467214724253->34.608733247176424
	 improve value x$w(high is good):-1.653803699489174  	x$d:-2.5214623329630106  	 x$l(negative is good):4.175266032452171
	 	 $w-$l: 29.30222530482237 -> 23.473155572881023  _ @double@	 lift : -5.82906973194135 : bad	 :| stand

[TimeMatrix: total:  o: 739585.0 -> a: 24973.0
org->adv	$w:31.726846812739577->72.03379650022023  	$d:3.575518703056444->5.2176350458495175  	$l:64.69763448420397->22.748568453930247
	 improve value x$w(high is good):40.30694968748065  	x$d:1.6421163427930736  	 x$l(negative is good):-41.94906603027373
	 	 $w-$l: -32.9707876714644 -> 49.285228046289994  _ @double@	 lift : 82.2560157177544 : good	 :) hit 

[Prob_ROI diff: -0.05829069731862546 (up%-> -4.5080969937866335) . o: 1.293022253047476 -> a: 1.2347315557288505	 returnMoney: o:0.1771297060816934 a: 0.3382890542532131 (probReturnRate: 1.9098380601229696	 totalSpendMoney: o: 0.1369889077038102 a: 0.2739778154074342 (probTotalSpendRate: 1.9999999999986409

[Time_ROI diff: 0.8225601571775439 (up%-> 122.7166676442302) . o: 0.6702921232853559 -> a: 1.4928522804628999	 returnMoney: o:1.487214E8 a: 2.23686E7 (timeReturnRate: 0.15040606126623338	 totalSpendMoney: o: 2.218755E8 a: 1.49838E7 (timeTotalSpendRate: 0.06753246753246753

[[Per_Prob_ROI diff: 0.09162085108211594 (up%-> 2728.029435184011) . o: 0.0033584993585648727 -> a: 0.09497935044068082	 per returnMoney: o:4.600771586537491E-4 a: 0.026022234942554852	 per totalSpendMoney: o: 3.558153446852213E-4 a: 0.021075216569802633

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.03412025685072978

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.024170440467895682     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9549190300621337 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

-----------------------------

		 @@@   dealerCard=Eight8, 	playerStartValue=11	@@@ 

net money diff:  0.01720866503169488 , up % -> 54.36298317188558 .  o: 0.031655115351717 -> a: 0.04886378038341188 (anet/onet: 1.5436298317188557

[ProbMatrix: total: o: 4.566296923457123E-4  -> a: 4.566296923457502E-4
org->adv	$w:56.5490368696284->55.20387651665285  	$d:10.009720813175187->7.4271874748299895  	$l:33.441242317196405->37.36893600851716
	 improve value x$w(high is good):-1.3451603529755545  	x$d:-2.582533338345198  	 x$l(negative is good):3.927693691320755
	 	 $w-$l: 23.107794552431994 -> 17.834940508135688  _ @double@	 lift : -5.272854044296304 : bad	 :| stand

[TimeMatrix: total:  o: 443905.0 -> a: 14989.0
org->adv	$w:31.717822507067954->72.02615251184201  	$d:3.576891451999865->5.21048769097338  	$l:64.70528604093218->22.763359797184602
	 improve value x$w(high is good):40.308330004774064  	x$d:1.6335962389735155  	 x$l(negative is good):-41.941926243747574
	 	 $w-$l: -32.98746353386423 -> 49.26279271465741  _ @double@	 lift : 82.25025624852165 : good	 :) hit 

[Prob_ROI diff: -0.052728540442190885 (up%-> -4.283119572885041) . o: 1.2310779455235659 -> a: 1.178349405081375	 returnMoney: o:0.16864402305554088 a: 0.3228415957908529 (probReturnRate: 1.9143376085408548	 totalSpendMoney: o: 0.13698890770382388 a: 0.27397781540744104 (probTotalSpendRate: 1.999999999998491

[Time_ROI diff: 0.8225025624852164 (up%-> 122.73861069277108) . o: 0.6701253646613577 -> a: 1.492627927146574	 returnMoney: o:8.92416E7 a: 1.34238E7 (timeReturnRate: 0.1504208799483649	 totalSpendMoney: o: 1.331715E8 a: 8993400.0 (timeTotalSpendRate: 0.06753246753246753

[[Per_Prob_ROI diff: 0.08744465687602858 (up%-> 2734.6922280337894) . o: 0.003197605053307963 -> a: 0.09064226192933654	 per returnMoney: o:4.380364235208854E-4 a: 0.024833968906988687	 per totalSpendMoney: o: 3.5581534468525684E-4 a: 0.021075216569803157

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.035519875410496005

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.01720866503169488     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9571688042711496 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

-----------------------------

		 @@@   dealerCard=Nine9, 	playerStartValue=11	@@@ 

net money diff:  0.010543040114744717 , up % -> 48.22224976712395 .  o: 0.021863434753997213 -> a: 0.03240647486874193 (anet/onet: 1.4822224976712395

[ProbMatrix: total: o: 4.566296923457048E-4  -> a: 4.566296923457471E-4
org->adv	$w:52.995612293287856->52.242933435374226  	$d:9.968779125046364->7.342271411376896  	$l:37.03560858166577->40.414795153248875
	 improve value x$w(high is good):-0.7526788579136294  	x$d:-2.6265077136694677  	 x$l(negative is good):3.379186571583105
	 	 $w-$l: 15.960003711622084 -> 11.82813828212535  _ @double@	 lift : -4.131865429496734 : bad	 :| stand

[TimeMatrix: total:  o: 296065.0 -> a: 9997.0
org->adv	$w:31.689324979311976->71.97159147744323  	$d:3.579619340347559->5.231569470841253  	$l:64.73105568034046->22.796839051715516
	 improve value x$w(high is good):40.28226649813125  	x$d:1.6519501304936934  	 x$l(negative is good):-41.934216628624945
	 	 $w-$l: -33.041730701028484 -> 49.17475242572772  _ @double@	 lift : 82.2164831267562 : good	 :) hit 

[Prob_ROI diff: -0.04131865429469128 (up%-> -3.5631815257142443) . o: 1.1596000371159565 -> a: 1.1182813828212652	 returnMoney: o:0.15885234245777471 a: 0.3063842902761869 (probReturnRate: 1.9287363694849406	 totalSpendMoney: o: 0.1369889077037775 a: 0.273977815407445 (probTotalSpendRate: 1.9999999999991969

[Time_ROI diff: 0.822164831267562 (up%-> 122.78764667535853) . o: 0.6695826929897151 -> a: 1.491747524257277	 returnMoney: o:5.9472E7 a: 8947800.0 (timeReturnRate: 0.150453995157385	 totalSpendMoney: o: 8.88195E7 a: 5998200.0 (timeTotalSpendRate: 0.06753246753246753

[[Per_Prob_ROI diff: 0.08300969668405188 (up%-> 2756.0134702000014) . o: 0.003011948148353133 -> a: 0.08602164483240501	 per returnMoney: o:4.1260348690331096E-4 a: 0.023568022328937455	 per totalSpendMoney: o: 3.558153446851364E-4 a: 0.02107521656980346

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.030775614179946564

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.010543040114744717     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9643681847428576 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

-----------------------------

		 @@@   dealerCard=Ten, 	playerStartValue=11	@@@ 

net money diff:  -8.218735776321096E-4 , up % -> -8.859056302288101 .  o: 0.00927721361720929 -> a: 0.00845534003957718 (anet/onet: 0.911409436977119

[ProbMatrix: total: o: 4.5662969234574487E-4  -> a: 4.5662969234574644E-4
org->adv	$w:47.36210689326546->47.411373626604174  	$d:8.661904758654629->11.349533540395356  	$l:43.975988348079895->41.23909283300048
	 improve value x$w(high is good):0.04926673333871179  	x$d:2.6876287817407274  	 x$l(negative is good):-2.736895515079418
	 	 $w-$l: 3.386118545185568 -> 6.172280793603696  _ @double@	 lift : 2.786162248418128 : good	 :) hit 

[TimeMatrix: total:  o: 5005.0 -> a: 148225.0
org->adv	$w:71.96803196803197->31.651205936920224  	$d:5.174825174825175->3.5837409343902853  	$l:22.857142857142858->64.76505312868949
	 improve value x$w(high is good):-40.316826031111745  	x$d:-1.5910842404348897  	 x$l(negative is good):41.907910271546626
	 	 $w-$l: 49.11088911088911 -> -33.11384719176927  _ #Surrender#	 lift : -82.22473630265837 : bad	 :| stand

[Prob_ROI diff: 0.02786162248425561 (up%-> 2.6949094207534414) . o: 1.0338611854518684 -> a: 1.061722807936124	 returnMoney: o:0.28325502902465544 a: 0.14544424774331435 (probReturnRate: 0.51347454710382	 totalSpendMoney: o: 0.27397781540744615 a: 0.13698890770373717 (probTotalSpendRate: 0.5000000000000515

[Time_ROI diff: -0.8222473630265837 (up%-> -55.14334787549312) . o: 1.491108891108891 -> a: 0.6688615280823073	 returnMoney: o:4477800.0 a: 2.97426E7 (timeReturnRate: 6.642235026128903	 totalSpendMoney: o: 3003000.0 a: 4.44675E7 (timeTotalSpendRate: 14.807692307692308

[[Per_Prob_ROI diff: -0.07677006191724271 (up%-> -96.53237968189664) . o: 0.07952778349629758 -> a: 0.0027577215790548673	 per returnMoney: o:0.021788848386511957 a: 3.7777726686575154E-4	 per totalSpendMoney: o: 0.02107521656980355 a: 3.558153446850316E-4

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.0270397489066235

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -8.218735776321096E-4     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.026949094207534 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

-----------------------------

		 */
	}
	
	public static void test11vs10() {
		StrategyMatrix8012 o = new Myth2019April22();
		StrategyMatrix8012 t = new MirMyth2019April22();
		
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
		StrategyMatrix8012 o = new Myth2019April22();
		StrategyMatrix8012 t = new MirMyth2019April22();
		
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

net money diff:  -0.004998696828384289 , up % -> -14.225884906436864 .  o: -0.03513803788840229 -> a: -0.04013673471678658 (anet/onet: 1.1422588490643686

[ProbMatrix: total: o: 4.566296923456397E-4  -> a: 4.5662969234576184E-4
org->adv	$w:34.692296929521795->35.35037055569647  	$d:4.96512651078174->0.0  	$l:60.34257655969646->64.64962944430353
	 improve value x$w(high is good):0.6580736261746765  	x$d:-4.96512651078174  	 x$l(negative is good):4.307052884607067
	 	 $w-$l: -25.650279630174662 -> -29.29925888860705  _ #Surrender#	 lift : -3.648979258432389 : bad	 :| stand

[TimeMatrix: total:  o: 346957.0 -> a: 26689.0
org->adv	$w:46.568594955570866->57.960208325527375  	$d:3.233830128805587->0.0  	$l:50.197574915623555->42.03979167447263
	 improve value x$w(high is good):11.39161336995651  	x$d:-3.233830128805587  	 x$l(negative is good):-8.157783241150923
	 	 $w-$l: -3.6289799600526917 -> 15.920416651054742  _ @double@	 lift : 19.549396611107433 : good	 :) hit 

[Prob_ROI diff: -0.0364897925839065 (up%-> -4.907858752180949) . o: 0.7434972036978694 -> a: 0.7070074111139629	 returnMoney: o:0.10185086981540988 a: 0.0968521729869446 (probReturnRate: 0.9509214124776283	 totalSpendMoney: o: 0.13698890770381217 a: 0.13698890770373118 (probTotalSpendRate: 0.9999999999994088

[Time_ROI diff: 0.1954939661110744 (up%-> 20.28555534952718) . o: 0.9637102003994731 -> a: 1.1592041665105475	 returnMoney: o:1.003098E8 a: 9281400.0 (timeReturnRate: 0.09252735026886705	 totalSpendMoney: o: 1.040871E8 a: 8006700.0 (timeTotalSpendRate: 0.07692307692307693

[[Per_Prob_ROI diff: 0.6498153185218192 (up%-> 1136.1978362216478) . o: 0.0571920925921438 -> a: 0.7070074111139629	 per returnMoney: o:0.007834682293493067 a: 0.0968521729869446	 per totalSpendMoney: o: 0.010537608284908628 a: 0.13698890770373118

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.04148848941229079

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.004998696828384289     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9509214124781905 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

		 */
	}
	
	public static void test12vs3() {
		StrategyMatrix8012 o = new Myth2019April22();
		StrategyMatrix8012 t = new MirMyth2019April22();
		
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
MatrixKey [startValue=Twelve, dealerCard=Three3, situation=Start_Hand_WithoutA_WithoutPair] : Hit -> Stand


		 @@@   dealerCard=Three3, 	playerStartValue=12	@@@ 

net money diff:  -0.0020665194477642312 , up % -> -6.37784980015884 .  o: -0.03240150697360049 -> a: -0.03446802642136472 (anet/onet: 1.0637784980015883

[ProbMatrix: total: o: 4.5662969234573224E-4  -> a: 4.5662969234575924E-4
org->adv	$w:35.77068718137588->37.4194097174952  	$d:4.805975567466577->0.0  	$l:59.423337251157534->62.58059028250481
	 improve value x$w(high is good):1.6487225361193225  	x$d:-4.805975567466577  	 x$l(negative is good):3.157253031347274
	 	 $w-$l: -23.65265006978166 -> -25.161180565009612  _ #Surrender#	 lift : -1.50853049522795 : bad	 :| stand

[TimeMatrix: total:  o: 202189.0 -> a: 15553.0
org->adv	$w:46.55495600650876->57.937375425962834  	$d:3.2355865056951663->0.0  	$l:50.20945748779607->42.06262457403716
	 improve value x$w(high is good):11.382419419454074  	x$d:-3.2355865056951663  	 x$l(negative is good):-8.146832913758914
	 	 $w-$l: -3.654501481287309 -> 15.874750851925674  _ @double@	 lift : 19.52925233321298 : good	 :) hit 

[Prob_ROI diff: -0.015085304952149547 (up%-> -1.9758780057119811) . o: 0.7634734993020867 -> a: 0.7483881943499372	 returnMoney: o:0.10458740073016258 a: 0.10252088128236299 (probReturnRate: 0.9802412199426273	 totalSpendMoney: o: 0.13698890770376307 a: 0.1369889077037277 (probTotalSpendRate: 0.9999999999997419

[Time_ROI diff: 0.19529252333212976 (up%-> 20.270020533880896) . o: 0.9634549851871269 -> a: 1.1587475085192567	 returnMoney: o:5.844E7 a: 5406600.0 (timeReturnRate: 0.09251540041067761	 totalSpendMoney: o: 6.06567E7 a: 4665900.0 (timeTotalSpendRate: 0.07692307692307693

[[Per_Prob_ROI diff: 0.689659463634392 (up%-> 1174.313585925744) . o: 0.05872873071554514 -> a: 0.7483881943499372	 per returnMoney: o:0.008045184671550968 a: 0.10252088128236299	 per totalSpendMoney: o: 0.010537608284904852 a: 0.1369889077037277

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.01715182439991378

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.0020665194477642312     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9802412199428803 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

		 */
	}
	
	
	public static void test13vs2() {
		StrategyMatrix8012 o = new Myth2019April22();
		StrategyMatrix8012 t = new MirMyth2019April22();
		
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

net money diff:  -0.0027894809141025545 , up % -> -6.949944816851024 .  o: -0.04013673471678658 -> a: -0.042926215630889136 (anet/onet: 1.0694994481685103

[ProbMatrix: total: o: 4.5662969234576184E-4  -> a: 4.5662969234563905E-4
org->adv	$w:35.35037055569647->31.870437504729832  	$d:0.0->4.923583777530266  	$l:64.64962944430353->63.205978717739896
	 improve value x$w(high is good):-3.4799330509666397  	x$d:4.923583777530266  	 x$l(negative is good):-1.4436507265636322
	 	 $w-$l: -29.29925888860705 -> -31.335541213010064  _ #Surrender#	 lift : -2.036282324403016 : bad	 :| stand

[TimeMatrix: total:  o: 26689.0 -> a: 346957.0
org->adv	$w:57.960208325527375->42.11011739206876  	$d:0.0->3.233830128805587  	$l:42.03979167447263->54.65605247912566
	 improve value x$w(high is good):-15.850090933458617  	x$d:3.233830128805587  	 x$l(negative is good):12.616260804653031
	 	 $w-$l: 15.920416651054742 -> -12.545935087056904  _ #Surrender#	 lift : -28.466351738111644 : bad	 :| stand

[Prob_ROI diff: -0.020362823244931216 (up%-> -2.8801428280429895) . o: 0.7070074111139629 -> a: 0.6866445878690317	 returnMoney: o:0.0968521729869446 a: 0.09406269207289081 (probReturnRate: 0.9711985717199159	 totalSpendMoney: o: 0.13698890770373118 a: 0.13698890770377994 (probTotalSpendRate: 1.000000000000356

[Time_ROI diff: -0.2846635173811165 (up%-> -24.556805919531378) . o: 1.1592041665105475 -> a: 0.874540649129431	 returnMoney: o:9281400.0 a: 9.10284E7 (timeReturnRate: 9.807615230460922	 totalSpendMoney: o: 8006700.0 a: 1.040871E8 (timeTotalSpendRate: 13.0

[[Per_Prob_ROI diff: -0.654188596662499 (up%-> -92.52924175600332) . o: 0.7070074111139629 -> a: 0.05281881445146398	 per returnMoney: o:0.0968521729869446 a: 0.007235591697914678	 per totalSpendMoney: o: 0.13698890770373118 a: 0.01053760828490615

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.02315230415903377

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.0027894809141025545     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9711985717195701 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

		 */
	}
	
	public static void test14vs10() {
		StrategyMatrix8012 o = new Myth2019April22();
		StrategyMatrix8012 t = new MirMyth2019April22();
		
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
MatrixKey [startValue=Fourteen, dealerCard=Ten, situation=Start_Hand_WithoutA_WithoutPair] : Giveup -> Hit


		 @@@   dealerCard=Ten, 	playerStartValue=14	@@@ 

net money diff:  -1.9493208990990774E-4 , up % -> -0.28459543648819013 .  o: -0.06849445385186169 -> a: -0.0686893859417716 (anet/onet: 1.002845954364882

[ProbMatrix: total: o: 4.5662969234574433E-4  -> a: 4.566296923457333E-4
org->adv	$w:0.0->21.446969000092206  	$d:0.0->6.963764281573781  	$l:100.0->71.58926671833402
	 improve value x$w(high is good):21.446969000092206  	x$d:6.963764281573781  	 x$l(negative is good):-28.410733281665983
	 	 $w-$l: -100.0 -> -50.1422977182418  _ #Surrender#	 lift : 49.8577022817582 : good	 :) hit 

[TimeMatrix: total:  o: 385.0 -> a: 18865.0
org->adv	$w:0.0->30.38430956798304  	$d:0.0->3.45613570103366  	$l:100.0->66.1595547309833
	 improve value x$w(high is good):30.38430956798304  	x$d:3.45613570103366  	 x$l(negative is good):-33.8404452690167
	 	 $w-$l: -100.0 -> -35.77524516300027  _ #Surrender#	 lift : 64.22475483699974 : good	 :) hit 

[Prob_ROI diff: -0.0014229771824261217 (up%-> -0.28459543648522434) . o: 0.5 -> a: 0.4985770228175739	 returnMoney: o:0.06849445385186169 a: 0.06829952176195583 (probReturnRate: 0.9971540456351773	 totalSpendMoney: o: 0.13698890770372338 a: 0.13698890770372743 (probTotalSpendRate: 1.0000000000000295

[Time_ROI diff: 0.1422475483699973 (up%-> 28.44950967399946) . o: 0.5 -> a: 0.6422475483699973	 returnMoney: o:57750.0 a: 3634800.0 (timeReturnRate: 62.94025974025974	 totalSpendMoney: o: 115500.0 a: 5659500.0 (timeTotalSpendRate: 49.0

[[Per_Prob_ROI diff: -0.4898249587180087 (up%-> -97.96499174360174) . o: 0.5 -> a: 0.010175041281991303	 per returnMoney: o:0.06849445385186169 a: 0.0013938677910603232	 per totalSpendMoney: o: 0.13698890770372338 a: 0.002795691993953621

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=true]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.0016179092723360294

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -1.9493208990990774E-4     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9971540456351479 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

		 */
	}
	
	public static void test15vs9() {
		StrategyMatrix8012 o = new Myth2019April22();
		StrategyMatrix8012 t = new MirMyth2019April22();
		
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
MatrixKey [startValue=Fifteen, dealerCard=Nine9, situation=Start_Hand_WithoutA_WithoutPair] : Giveup -> Hit


		 @@@   dealerCard=Nine9, 	playerStartValue=15	@@@ 

net money diff:  0.004380797069490822 , up % -> 6.395842032649105 .  o: -0.06849445385186181 -> a: -0.06411365678237099 (anet/onet: 0.936041579673509

[ProbMatrix: total: o: 4.5662969234574433E-4  -> a: 4.566296923457363E-4
org->adv	$w:0.0->23.3851535595977  	$d:0.0->6.427613897125377  	$l:100.0->70.18723254327692
	 improve value x$w(high is good):23.3851535595977  	x$d:6.427613897125377  	 x$l(negative is good):-29.81276745672308
	 	 $w-$l: -100.0 -> -46.802078983679216  _ #Surrender#	 lift : 53.197921016320784 : good	 :) hit 

[TimeMatrix: total:  o: 769.0 -> a: 19225.0
org->adv	$w:0.0->29.815344603381018  	$d:0.0->3.3810143042912877  	$l:100.0->66.80364109232771
	 improve value x$w(high is good):29.815344603381018  	x$d:3.3810143042912877  	 x$l(negative is good):-33.19635890767229
	 	 $w-$l: -100.0 -> -36.98829648894669  _ #Surrender#	 lift : 63.01170351105332 : good	 :) hit 

[Prob_ROI diff: 0.03197921016322414 (up%-> 6.395842032644827) . o: 0.5 -> a: 0.5319792101632241	 returnMoney: o:0.06849445385186181 a: 0.07287525092134639 (probReturnRate: 1.0639584203263999	 totalSpendMoney: o: 0.13698890770372363 a: 0.13698890770371738 (probTotalSpendRate: 0.9999999999999544

[Time_ROI diff: 0.13011703511053319 (up%-> 26.02340702210664) . o: 0.5 -> a: 0.6301170351105332	 returnMoney: o:115350.0 a: 3634200.0 (timeReturnRate: 31.50585175552666	 totalSpendMoney: o: 230700.0 a: 5767500.0 (timeTotalSpendRate: 25.0

[[Per_Prob_ROI diff: -0.478720831593471 (up%-> -95.7441663186942) . o: 0.5 -> a: 0.02127916840652897	 per returnMoney: o:0.06849445385186181 a: 0.0029150100368538555	 per totalSpendMoney: o: 0.13698890770372363 a: 0.005479556308148695

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.03636000723271496
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.004380797069490822
 probRunR/probTalSR= 1.0639584203264485 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

------------------------------

MatrixKey [startValue=Fifteen, dealerCard=Nine9, situation=Start_Hand_WithoutA_WithoutPair] : Stand -> Hit


		 @@@   dealerCard=Nine9, 	playerStartValue=15	@@@ 

net money diff:  0.010068057789132098 , up % -> 13.572155681878915 .  o: -0.07418171457150784 -> a: -0.06411365678237574 (anet/onet: 0.8642784431812108

[ProbMatrix: total: o: 4.5662969234574503E-4  -> a: 4.566296923457359E-4
org->adv	$w:22.924189332195212->23.385153559597963  	$d:0.0->6.4276138971253856  	$l:77.07581066780477->70.18723254327665
	 improve value x$w(high is good):0.46096422740275145  	x$d:6.4276138971253856  	 x$l(negative is good):-6.888578124528124
	 	 $w-$l: -54.15162133560957 -> -46.80207898367868  _ #Surrender#	 lift : 7.349542351930882 : good	 :) hit 

[TimeMatrix: total:  o: 769.0 -> a: 19225.0
org->adv	$w:57.737321196358906->29.815344603381018  	$d:0.0->3.3810143042912877  	$l:42.26267880364109->66.80364109232771
	 improve value x$w(high is good):-27.921976592977888  	x$d:3.3810143042912877  	 x$l(negative is good):24.54096228868662
	 	 $w-$l: 15.474642392717813 -> -36.98829648894669  _ #Surrender#	 lift : -52.4629388816645 : bad	 :| stand

[Prob_ROI diff: 0.07349542351929944 (up%-> 16.030103061502945) . o: 0.45848378664390627 -> a: 0.5319792101632057	 returnMoney: o:0.06280719313221579 a: 0.07287525092134636 (probReturnRate: 1.1603010306150163	 totalSpendMoney: o: 0.13698890770372363 a: 0.1369889077037221 (probTotalSpendRate: 0.9999999999999889

[Time_ROI diff: -0.5246293888166449 (up%-> -45.43243243243243) . o: 1.154746423927178 -> a: 0.6301170351105332	 returnMoney: o:266400.0 a: 3634200.0 (timeReturnRate: 13.641891891891891	 totalSpendMoney: o: 230700.0 a: 5767500.0 (timeTotalSpendRate: 25.0

[[Per_Prob_ROI diff: -0.43720461823737805 (up%-> -95.35879587753989) . o: 0.45848378664390627 -> a: 0.02127916840652823	 per returnMoney: o:0.06280719313221579 a: 0.0029150100368538546	 per totalSpendMoney: o: 0.13698890770372363 a: 0.005479556308148884

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.08356348130843154
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.010068057789132098
 probRunR/probTalSR= 1.1603010306150292 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)
		 */
	}

	public static void test15vs10() {
		StrategyMatrix8012 o = new Myth2019April22();
		StrategyMatrix8012 t = new MirMyth2019April22();
		
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
MatrixKey [startValue=Fifteen, dealerCard=Ten, situation=Start_Hand_WithoutA_WithoutPair] : Stand -> Giveup


		 @@@   dealerCard=JJJ, 	playerStartValue=15	@@@ 

net money diff:  0.010282131155661109 , up % -> 13.052268202130367 .  o: -0.0787765850075229 -> a: -0.06849445385186179 (anet/onet: 0.8694773179786963

[ProbMatrix: total: o: 4.566296923457449E-4  -> a: 4.5662969234574487E-4
org->adv	$w:21.247093531872242->0.0  	$d:0.0->0.0  	$l:78.75290646812776->100.0
	 improve value x$w(high is good):-21.247093531872242  	x$d:0.0  	 x$l(negative is good):21.24709353187224
	 	 $w-$l: -57.505812936255516 -> -100.0  _ #Surrender#	 lift : -42.494187063744484 : bad	 :| stand

[TimeMatrix: total:  o: 385.0 -> a: 385.0
org->adv	$w:57.66233766233766->0.0  	$d:0.0->0.0  	$l:42.33766233766234->100.0
	 improve value x$w(high is good):-57.66233766233766  	x$d:0.0  	 x$l(negative is good):57.66233766233766
	 	 $w-$l: 15.324675324675324 -> -100.0  _ #Surrender#	 lift : -115.32467532467533 : bad	 :| stand

[Prob_ROI diff: 0.0750581293625544 (up%-> 17.663152197725637) . o: 0.4249418706374456 -> a: 0.5	 returnMoney: o:0.05821232269620068 a: 0.06849445385186179 (probReturnRate: 1.1766315219772563	 totalSpendMoney: o: 0.13698890770372357 a: 0.13698890770372357 (probTotalSpendRate: 1.0

[Time_ROI diff: -0.6532467532467532 (up%-> -56.64414414414415) . o: 1.1532467532467532 -> a: 0.5	 returnMoney: o:133200.0 a: 57750.0 (timeReturnRate: 0.43355855855855857	 totalSpendMoney: o: 115500.0 a: 115500.0 (timeTotalSpendRate: 1.0

[[Per_Prob_ROI diff: 0.0750581293625544 (up%-> 17.663152197725637) . o: 0.4249418706374456 -> a: 0.5	 per returnMoney: o:0.05821232269620068 a: 0.06849445385186179	 per totalSpendMoney: o: 0.13698890770372357 a: 0.13698890770372357

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=true]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.08534026051821551
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.010282131155661109
 probRunR/probTalSR= 1.1766315219772563 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

 
 ----------------------------
 
 MatrixKey [startValue=Fifteen, dealerCard=Ten, situation=Start_Hand_WithoutA_WithoutPair] : Stand -> Hit


		 @@@   dealerCard=JJJ, 	playerStartValue=15	@@@ 

net money diff:  0.005000544089670683 , up % -> 6.347754334861238 .  o: -0.0787765850075229 -> a: -0.07377604091785221 (anet/onet: 0.9365224566513876

[ProbMatrix: total: o: 4.566296923457449E-4  -> a: 4.566296923457472E-4
org->adv	$w:21.247093531872242->19.806445664497677  	$d:0.0->6.531623468206573  	$l:78.75290646812776->73.66193086729575
	 improve value x$w(high is good):-1.4406478673745653  	x$d:6.531623468206573  	 x$l(negative is good):-5.09097560083201
	 	 $w-$l: -57.505812936255516 -> -53.85548520279808  _ #Surrender#	 lift : 3.650327733457437 : good	 :) hit 

[TimeMatrix: total:  o: 385.0 -> a: 9625.0
org->adv	$w:57.66233766233766->29.77662337662338  	$d:0.0->3.387012987012987  	$l:42.33766233766234->66.83636363636364
	 improve value x$w(high is good):-27.885714285714283  	x$d:3.387012987012987  	 x$l(negative is good):24.498701298701306
	 	 $w-$l: 15.324675324675324 -> -37.05974025974026  _ #Surrender#	 lift : -52.38441558441558 : bad	 :| stand

[Prob_ROI diff: 0.036503277334582085 (up%-> 8.590181353469442) . o: 0.4249418706374456 -> a: 0.4614451479720277	 returnMoney: o:0.05821232269620068 a: 0.063212866785871 (probReturnRate: 1.0859018135346916	 totalSpendMoney: o: 0.13698890770372357 a: 0.1369889077037232 (probTotalSpendRate: 0.9999999999999973

[Time_ROI diff: -0.5238441558441558 (up%-> -45.42342342342342) . o: 1.1532467532467532 -> a: 0.6294025974025974	 returnMoney: o:133200.0 a: 1817400.0 (timeReturnRate: 13.644144144144144	 totalSpendMoney: o: 115500.0 a: 2887500.0 (timeTotalSpendRate: 25.0

[[Per_Prob_ROI diff: -0.40648406471856446 (up%-> -95.65639274586121) . o: 0.4249418706374456 -> a: 0.018457805918881107	 per returnMoney: o:0.05821232269620068 a: 0.00252851467143484	 per totalSpendMoney: o: 0.13698890770372357 a: 0.005479556308148928

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=true]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.04150382142425277
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.005000544089670683
 probRunR/probTalSR= 1.0859018135346945 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)
 
 
 ----------------------
 
 MatrixKey [startValue=Fifteen, dealerCard=Ten, situation=Start_Hand_WithoutA_WithoutPair] : Hit -> Giveup


		 @@@   dealerCard=JJJ, 	playerStartValue=15	@@@ 

net money diff:  0.005281587065990426 , up % -> 7.15894618399399 .  o: -0.07377604091785221 -> a: -0.06849445385186179 (anet/onet: 0.9284105381600601

[ProbMatrix: total: o: 4.566296923457472E-4  -> a: 4.5662969234574487E-4
org->adv	$w:19.806445664497677->0.0  	$d:6.531623468206573->0.0  	$l:73.66193086729575->100.0
	 improve value x$w(high is good):-19.806445664497677  	x$d:-6.531623468206573  	 x$l(negative is good):26.33806913270425
	 	 $w-$l: -53.85548520279808 -> -100.0  _ #Surrender#	 lift : -46.14451479720192 : bad	 :| stand

[TimeMatrix: total:  o: 9625.0 -> a: 385.0
org->adv	$w:29.77662337662338->0.0  	$d:3.387012987012987->0.0  	$l:66.83636363636364->100.0
	 improve value x$w(high is good):-29.77662337662338  	x$d:-3.387012987012987  	 x$l(negative is good):33.16363636363636
	 	 $w-$l: -37.05974025974026 -> -100.0  _ #Surrender#	 lift : -62.94025974025974 : bad	 :| stand

[Prob_ROI diff: 0.03855485202797232 (up%-> 8.355240530193955) . o: 0.4614451479720277 -> a: 0.5	 returnMoney: o:0.063212866785871 a: 0.06849445385186179 (probReturnRate: 1.0835524053019423	 totalSpendMoney: o: 0.1369889077037232 a: 0.13698890770372357 (probTotalSpendRate: 1.0000000000000027

[Time_ROI diff: -0.1294025974025974 (up%-> -20.559590623968308) . o: 0.6294025974025974 -> a: 0.5	 returnMoney: o:1817400.0 a: 57750.0 (timeReturnRate: 0.03177616375041268	 totalSpendMoney: o: 2887500.0 a: 115500.0 (timeTotalSpendRate: 0.04

[[Per_Prob_ROI diff: 0.48154219408111887 (up%-> 2608.8810132548488) . o: 0.018457805918881107 -> a: 0.5	 per returnMoney: o:0.00252851467143484 a: 0.06849445385186179	 per totalSpendMoney: o: 0.005479556308148928 a: 0.13698890770372357

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=true]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.043836439093962745
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.005281587065990426
 probRunR/probTalSR= 1.0835524053019394 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)
		 */
	}
	
	public static void test16vs7() {
		StrategyMatrix8012 o = new Myth2019April22();
		StrategyMatrix8012 t = new MirMyth2019April22();
		
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
		StrategyMatrix8012 o = new Myth2019April22();
		StrategyMatrix8012 t = new MirMyth2019April22();
		
		Card dealerCard = Card.Eight8;
		PlayerCardsPathValue nine = new PlayerCardsPathValue(Card.Six6,Card.Ten);
		Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, nine, dealerCard); 
//		HelloWorld.print(origin);
		PlayerCardsPathValue ninet = new PlayerCardsPathValue(Card.Six6,Card.Ten);
		Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, ninet, dealerCard); 
//		HelloWorld.print(advanced);
		System.out.println(o.diffWith(t));
		
		DealerVSPlayerResult9102 result = new DealerVSPlayerResult9102(dealerCard, nine.getValue() , RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), origin),RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), advanced));
		
		System.out.println(result);
		
		/**
MatrixKey [startValue=Sixteen, dealerCard=Eight8, situation=Start_Hand_WithoutA_WithoutPair] : Hit -> Stand

		 @@@   dealerCard=Eight8, 	playerStartValue=16	@@@ 

net money diff:  -0.00787376254794303 , up % -> -12.628591908457546 .  o: -0.06234869734502911 -> a: -0.07022245989297214 (anet/onet: 1.1262859190845755

[ProbMatrix: total: o: 4.566296923457352E-4  -> a: 4.5662969234574357E-4
org->adv	$w:24.315518051098227->24.369289795036504  	$d:5.855280790061805->0.0  	$l:69.82920115883996->75.63071020496349
	 improve value x$w(high is good):0.05377174393827744  	x$d:-5.855280790061805  	 x$l(negative is good):5.8015090461235275
	 	 $w-$l: -45.513683107741734 -> -51.261420409926984  _ #Surrender#	 lift : -5.747737302185252 : bad	 :| stand

[TimeMatrix: total:  o: 14989.0 -> a: 1153.0
org->adv	$w:28.694375875642137->57.7623590633131  	$d:3.249049302822069->0.0  	$l:68.0565748215358->42.2376409366869
	 improve value x$w(high is good):29.06798318767096  	x$d:-3.249049302822069  	 x$l(negative is good):-25.818933884848903
	 	 $w-$l: -39.36219894589366 -> 15.52471812662619  _ @double@	 lift : 54.88691707251985 : good	 :) hit 

[Prob_ROI diff: -0.05747737302184275 (up%-> -10.54895546261638) . o: 0.5448631689225756 -> a: 0.48738579590073283	 returnMoney: o:0.07464021035869135 a: 0.06676644781075126 (probReturnRate: 0.8945104453738555	 totalSpendMoney: o: 0.13698890770372046 a: 0.1369889077037234 (probTotalSpendRate: 1.0000000000000215

[Time_ROI diff: 0.5488691707251985 (up%-> 90.51600836175598) . o: 0.6063780105410634 -> a: 1.155247181266262	 returnMoney: o:2726700.0 a: 399600.0 (timeReturnRate: 0.1465507756628892	 totalSpendMoney: o: 4496700.0 a: 345900.0 (timeTotalSpendRate: 0.07692307692307693

[[Per_Prob_ROI diff: 0.44547324444515013 (up%-> 1062.8635789859873) . o: 0.04191255145558273 -> a: 0.48738579590073283	 per returnMoney: o:0.005741554642976258 a: 0.06676644781075126	 per totalSpendMoney: o: 0.010537608284901575 a: 0.1369889077037234

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=true]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.06535113556978579
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.00787376254794303
 probRunR/probTalSR= 0.8945104453738362 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)
 
 
 -----------------------
 
 
MatrixKey [startValue=Sixteen, dealerCard=Eight8, situation=Start_Hand_WithoutA_WithoutPair] : Hit -> Giveup


		 @@@   dealerCard=Eight8, 	playerStartValue=16	@@@ 

net money diff:  -0.006145756506832592 , up % -> -9.857072831566667 .  o: -0.06234869734502911 -> a: -0.0684944538518617 (anet/onet: 1.0985707283156667

[ProbMatrix: total: o: 4.566296923457352E-4  -> a: 4.5662969234574303E-4
org->adv	$w:24.315518051098227->0.0  	$d:5.855280790061805->0.0  	$l:69.82920115883996->100.0
	 improve value x$w(high is good):-24.315518051098227  	x$d:-5.855280790061805  	 x$l(negative is good):30.170798841160035
	 	 $w-$l: -45.513683107741734 -> -100.0  _ #Surrender#	 lift : -54.486316892258266 : bad	 :| stand

[TimeMatrix: total:  o: 14989.0 -> a: 1153.0
org->adv	$w:28.694375875642137->0.0  	$d:3.249049302822069->0.0  	$l:68.0565748215358->100.0
	 improve value x$w(high is good):-28.694375875642137  	x$d:-3.249049302822069  	 x$l(negative is good):31.943425178464196
	 	 $w-$l: -39.36219894589366 -> -100.0  _ #Surrender#	 lift : -60.63780105410635 : bad	 :| stand

[Prob_ROI diff: -0.04486316892257558 (up%-> -8.233841353470266) . o: 0.5448631689225756 -> a: 0.5	 returnMoney: o:0.07464021035869135 a: 0.0684944538518617 (probReturnRate: 0.9176615864653171	 totalSpendMoney: o: 0.13698890770372046 a: 0.1369889077037234 (probTotalSpendRate: 1.0000000000000215

[Time_ROI diff: -0.10637801054106344 (up%-> -17.543184068654416) . o: 0.6063780105410634 -> a: 0.5	 returnMoney: o:2726700.0 a: 172950.0 (timeReturnRate: 0.06342831994718891	 totalSpendMoney: o: 4496700.0 a: 345900.0 (timeTotalSpendRate: 0.07692307692307693

[[Per_Prob_ROI diff: 0.4580874485444173 (up%-> 1092.9600624048867) . o: 0.04191255145558273 -> a: 0.5	 per returnMoney: o:0.005741554642976258 a: 0.0684944538518617	 per totalSpendMoney: o: 0.010537608284901575 a: 0.1369889077037234

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=true]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.05100892542940817
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.006145756506832592
 probRunR/probTalSR= 0.9176615864652974 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

		 */
		
	}
	
	public static void test16vs9() {
		StrategyMatrix8012 o = new Myth2019April22();
		StrategyMatrix8012 t = new MirMyth2019April22();
		
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

net money diff:  -0.004834221235363589 , up % -> -6.971010778905789 .  o: -0.06934749333614425 -> a: -0.07418171457150784 (anet/onet: 1.0697101077890578

[ProbMatrix: total: o: 4.566296923457391E-4  -> a: 4.5662969234574503E-4
org->adv	$w:21.705066744336403->22.924189332195212  	$d:5.967159535572039->0.0  	$l:72.32777372009154->77.07581066780477
	 improve value x$w(high is good):1.2191225878588092  	x$d:-5.967159535572039  	 x$l(negative is good):4.748036947713231
	 	 $w-$l: -50.62270697575515 -> -54.15162133560957  _ #Surrender#	 lift : -3.528914359854418 : bad	 :| stand

[TimeMatrix: total:  o: 9997.0 -> a: 769.0
org->adv	$w:28.668600580174054->57.737321196358906  	$d:3.2509752925877766->0.0  	$l:68.08042412723817->42.26267880364109
	 improve value x$w(high is good):29.06872061618485  	x$d:-3.2509752925877766  	 x$l(negative is good):-25.817745323597087
	 	 $w-$l: -39.41182354706412 -> 15.474642392717813  _ @double@	 lift : 54.88646593978193 : good	 :) hit 

[Prob_ROI diff: -0.035289143598534634 (up%-> -7.1468364175427315) . o: 0.4937729302424409 -> a: 0.45848378664390627	 returnMoney: o:0.06764141436757844 a: 0.06280719313221579 (probReturnRate: 0.9285316358245791	 totalSpendMoney: o: 0.13698890770372268 a: 0.13698890770372363 (probTotalSpendRate: 1.0000000000000069

[Time_ROI diff: 0.5488646593978193 (up%-> 90.58940069341257) . o: 0.6058817645293588 -> a: 1.154746423927178	 returnMoney: o:1817100.0 a: 266400.0 (timeReturnRate: 0.14660723130262507	 totalSpendMoney: o: 2999100.0 a: 230700.0 (timeTotalSpendRate: 0.07692307692307693

[[Per_Prob_ROI diff: 0.4205012535483339 (up%-> 1107.0911265719444) . o: 0.03798253309557238 -> a: 0.45848378664390627	 per returnMoney: o:0.005203185720582957 a: 0.06280719313221579	 per totalSpendMoney: o: 0.010537608284901745 a: 0.13698890770372363

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=true]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.04012336483389822
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.004834221235363589
 probRunR/probTalSR= 0.9285316358245727 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)
 
 -------------------------------
 
 
 MatrixKey [startValue=Sixteen, dealerCard=Nine9, situation=Start_Hand_WithoutA_WithoutPair] : Hit -> Giveup

net money diff:  8.530394842828914E-4 , up % -> 1.2300941868915087 .  o: -0.06934749333614462 -> a: -0.06849445385186173

		 @@@   dealerCard=Nine9, 	playerStartValue=16	@@@ 

net money diff:  8.530394842824335E-4 , up % -> 1.230094186890855 .  o: -0.06934749333614425 -> a: -0.06849445385186181 (anet/onet: 0.9876990581310915

[ProbMatrix: total: o: 4.566296923457391E-4  -> a: 4.5662969234574433E-4
org->adv	$w:21.705066744336403->0.0  	$d:5.967159535572039->0.0  	$l:72.32777372009154->100.0
	 improve value x$w(high is good):-21.705066744336403  	x$d:-5.967159535572039  	 x$l(negative is good):27.672226279908458
	 	 $w-$l: -50.62270697575515 -> -100.0  _ #Surrender#	 lift : -49.37729302424485 : bad	 :| stand

[TimeMatrix: total:  o: 9997.0 -> a: 769.0
org->adv	$w:28.668600580174054->0.0  	$d:3.2509752925877766->0.0  	$l:68.08042412723817->100.0
	 improve value x$w(high is good):-28.668600580174054  	x$d:-3.2509752925877766  	 x$l(negative is good):31.919575872761826
	 	 $w-$l: -39.41182354706412 -> -100.0  _ #Surrender#	 lift : -60.58817645293588 : bad	 :| stand

[Prob_ROI diff: 0.0062270697575591005 (up%-> 1.2611201173992324) . o: 0.4937729302424409 -> a: 0.5	 returnMoney: o:0.06764141436757844 a: 0.06849445385186181 (probReturnRate: 1.0126112011739994	 totalSpendMoney: o: 0.13698890770372268 a: 0.13698890770372363 (probTotalSpendRate: 1.0000000000000069

[Time_ROI diff: -0.10588176452935882 (up%-> -17.475648010566292) . o: 0.6058817645293588 -> a: 0.5	 returnMoney: o:1817100.0 a: 115350.0 (timeReturnRate: 0.06348027076110285	 totalSpendMoney: o: 2999100.0 a: 230700.0 (timeTotalSpendRate: 0.07692307692307693

[[Per_Prob_ROI diff: 0.46201746690442763 (up%-> 1216.3945615261898) . o: 0.03798253309557238 -> a: 0.5	 per returnMoney: o:0.005203185720582957 a: 0.06849445385186181	 per totalSpendMoney: o: 0.010537608284901745 a: 0.13698890770372363

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=true]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.007080109241841534
 按net净收益值(代表少输多赢) :  $Change$  Value: 8.530394842824335E-4
 probRunR/probTalSR= 1.0126112011739925 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

 
		 */
	}
	
	public static void test16vs10() {
		StrategyMatrix8012 o = new Myth2019April22();
		StrategyMatrix8012 t = new MirMyth2019April22();
		
		Card dealerCard = Card.JJJ;
		PlayerCardsPathValue nine = new PlayerCardsPathValue(Card.Six6,Card.Ten);
		Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, nine, dealerCard); 
//		HelloWorld.print(origin);
		PlayerCardsPathValue ninet = new PlayerCardsPathValue(Card.Six6,Card.Ten);
		Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, ninet, dealerCard); 
//		HelloWorld.print(advanced);
		System.out.println(o.diffWith(t));
		
		DealerVSPlayerResult9102 result = new DealerVSPlayerResult9102(dealerCard, nine.getValue() , RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), origin),RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), advanced));
		
		System.out.println(result);
		/**
 
 MatrixKey [startValue=Sixteen, dealerCard=Ten, situation=Start_Hand_WithoutA_WithoutPair] : Stand -> Hit

		 @@@   dealerCard=JJJ, 	playerStartValue=16	@@@ 

net money diff:  0.0012359413561667115 , up % -> 1.5689196936484149 .  o: -0.0787765850075229 -> a: -0.07754064365135618 (anet/onet: 0.9843108030635158

[ProbMatrix: total: o: 4.566296923457449E-4  -> a: 4.566296923457446E-4
org->adv	$w:21.247093531872242->18.64970393872917  	$d:0.0->6.096999210435695  	$l:78.75290646812776->75.25329685083514
	 improve value x$w(high is good):-2.5973895931430704  	x$d:6.096999210435695  	 x$l(negative is good):-3.49960961729262
	 	 $w-$l: -57.505812936255516 -> -56.603592912105974  _ #Surrender#	 lift : 0.902220024149547 : good	 :) hit 

[TimeMatrix: total:  o: 385.0 -> a: 5005.0
org->adv	$w:57.66233766233766->28.63136863136863  	$d:0.0->3.2567432567432566  	$l:42.33766233766234->68.1118881118881
	 improve value x$w(high is good):-29.030969030969032  	x$d:3.2567432567432566  	 x$l(negative is good):25.77422577422577
	 	 $w-$l: 15.324675324675324 -> -39.480519480519476  _ #Surrender#	 lift : -54.8051948051948 : bad	 :| stand

[Prob_ROI diff: 0.009022200241494083 (up%-> 2.1231610403465506) . o: 0.4249418706374456 -> a: 0.4339640708789397	 returnMoney: o:0.05821232269620068 a: 0.05944826405236709 (probReturnRate: 1.0212316104034633	 totalSpendMoney: o: 0.13698890770372357 a: 0.13698890770372327 (probTotalSpendRate: 0.9999999999999978

[Time_ROI diff: -0.548051948051948 (up%-> -47.52252252252252) . o: 1.1532467532467532 -> a: 0.6051948051948052	 returnMoney: o:133200.0 a: 908700.0 (timeReturnRate: 6.822072072072072	 totalSpendMoney: o: 115500.0 a: 1501500.0 (timeTotalSpendRate: 13.0

[[Per_Prob_ROI diff: -0.39156001903137333 (up%-> -92.14437222766564) . o: 0.4249418706374456 -> a: 0.03338185160607228	 per returnMoney: o:0.05821232269620068 a: 0.004572943388643622	 per totalSpendMoney: o: 0.13698890770372357 a: 0.01053760828490179

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=true]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.010258141597660794
 按net净收益值(代表少输多赢) :  $Change$ 
 probRunR/probTalSR= 1.0212316104034656 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)
 
		 */
		
	}
	
	public static void testA2345vsAll() {
		StrategyMatrix8012 o = new Myth2019April22();
		StrategyMatrix8012 t = new MirMyth2019April22();
		
		System.out.println(t.diffWith(o));
		
		for(Card playerCard : Card.values()) {
			if(playerCard.getValue() >= 2 && playerCard.getValue() <= 5) {
				for(Card dealerCard : Card.values()) {
					if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
					PlayerCardsPathValue nine = new PlayerCardsPathValue(Card.One1,playerCard);
					Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, nine, dealerCard); 
//					HelloWorld.print(origin);
					PlayerCardsPathValue ninet = new PlayerCardsPathValue(Card.One1,playerCard);
					Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, ninet, dealerCard); 
//					HelloWorld.print(advanced);
					
					DealerVSPlayerResult9102 result = new DealerVSPlayerResult9102(dealerCard, playerCard.getValue(), RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), origin),RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), advanced));
					
					System.out.println(result);
					System.out.println();
				}
			}
		}
		/**
MatrixKey [startValue=Two, dealerCard=One1, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Two, dealerCard=Two2, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Two, dealerCard=Three3, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Two, dealerCard=Four4, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Two, dealerCard=Five5, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Two, dealerCard=Six6, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Two, dealerCard=Seven7, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Two, dealerCard=Eight8, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Two, dealerCard=Nine9, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Two, dealerCard=Ten, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Three, dealerCard=One1, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Three, dealerCard=Two2, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Three, dealerCard=Three3, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Three, dealerCard=Four4, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Three, dealerCard=Five5, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Three, dealerCard=Six6, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Three, dealerCard=Seven7, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Three, dealerCard=Eight8, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Three, dealerCard=Nine9, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Three, dealerCard=Ten, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Four, dealerCard=One1, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Four, dealerCard=Two2, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Four, dealerCard=Three3, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Four, dealerCard=Four4, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Four, dealerCard=Five5, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Four, dealerCard=Six6, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Four, dealerCard=Seven7, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Four, dealerCard=Eight8, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Four, dealerCard=Nine9, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Four, dealerCard=Ten, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Five, dealerCard=One1, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Five, dealerCard=Two2, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Five, dealerCard=Three3, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Five, dealerCard=Four4, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Five, dealerCard=Five5, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Five, dealerCard=Six6, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Five, dealerCard=Seven7, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Five, dealerCard=Eight8, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Five, dealerCard=Nine9, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Five, dealerCard=Ten, situation=Start_With_A] : Hit -> Double


		 @@@   dealerCard=One1, 	playerStartValue=2	@@@ 

net money diff:  -0.09595963582751015 , up % -> -236.13972286132517 .  o: -0.040636803780727385 -> a: -0.13659643960823753 (anet/onet: 3.3613972286132516

[ProbMatrix: total: o: 4.5662969228852545E-4  -> a: 4.566296923456564E-4
org->adv	$w:28.752672270079387->21.647648448751518  	$d:12.830353074841435->6.847951231900836  	$l:58.41697465507918->71.50440031934764
	 improve value x$w(high is good):-7.105023821327869  	x$d:-5.9824018429405985  	 x$l(negative is good):13.087425664268459
	 	 $w-$l: -29.66430238499979 -> -49.85675187059611  _ #Surrender#	 lift : -20.192449485596324 : bad	 :| stand

[TimeMatrix: total:  o: 1.82798785E8 -> a: 184717.0
org->adv	$w:31.47781097122719->64.72495763790013  	$d:3.5045572102681097->3.2065267409063596  	$l:65.01763181850471->32.0685156211935
	 improve value x$w(high is good):33.24714666667295  	x$d:-0.29803046936175015  	 x$l(negative is good):-32.94911619731121
	 	 $w-$l: -33.53982084727752 -> 32.65644201670664  _ @double@	 lift : 66.19626286398416 : good	 :) hit 

[Prob_ROI diff: -0.2019244950061485 (up%-> -28.70867878048718) . o: 0.703356976300119 -> a: 0.5014324812939704	 returnMoney: o:0.09635210387631009 a: 0.13738137579930593 (probReturnRate: 1.4258264248766823	 totalSpendMoney: o: 0.13698890765703747 a: 0.27397781540754346 (probTotalSpendRate: 2.000000000682307

[Time_ROI diff: 0.6619626286398415 (up%-> 99.60289561041978) . o: 0.6646017915272249 -> a: 1.3265644201670663	 returnMoney: o:3.644652E10 a: 1.470234E8 (timeReturnRate: 0.004033948920226129	 totalSpendMoney: o: 5.48396355E10 a: 1.108302E8 (timeTotalSpendRate: 0.0020209871745044696

[[Per_Prob_ROI diff: 0.03851705719845155 (up%-> 70450.98826838711) . o: 5.467213185387633E-5 -> a: 0.03857172933030542	 per returnMoney: o:7.489475621944041E-6 a: 0.010567798138408148	 per totalSpendMoney: o: 1.0648185593240378E-5 a: 0.021075216569811036

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.29788413083365867

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.09595963582751015     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.7129132121951283 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Two2, 	playerStartValue=2	@@@ 

net money diff:  -0.015702027565924204 , up % -> -251.8107664406802 .  o: 0.006235645833524428 -> a: -0.009466381732399776 (anet/onet: -1.5181076644068021

[ProbMatrix: total: o: 4.5662969234453853E-4  -> a: 4.566296923457761E-4
org->adv	$w:49.19313027009314->45.76985190215065  	$d:6.16567431146966->5.005132602139198  	$l:44.6411954184372->49.22501549571015
	 improve value x$w(high is good):-3.423278367942494  	x$d:-1.1605417093304622  	 x$l(negative is good):4.583820077272954
	 	 $w-$l: 4.551934851655948 -> -3.455163593559507  _ #Surrender#	 lift : -8.007098445215455 : bad	 :| stand

[TimeMatrix: total:  o: 1.0275265E7 -> a: 346957.0
org->adv	$w:55.28629188638931->64.40250520957929  	$d:3.841458103513632->3.233830128805587  	$l:40.87225001009706->32.363664661615125
	 improve value x$w(high is good):9.116213323189982  	x$d:-0.6076279747080453  	 x$l(negative is good):-8.508585348481937
	 	 $w-$l: 14.414041876292243 -> 32.038840547964156  _ @double@	 lift : 17.624798671671915 : good	 :) hit 

[Prob_ROI diff: -0.0800709844587636 (up%-> -7.658489015231352) . o: 1.0455193485231469 -> a: 0.9654483640643833	 returnMoney: o:0.14322455353622515 a: 0.26451143367522273 (probReturnRate: 1.8468302197103448	 totalSpendMoney: o: 0.13698890770270072 a: 0.2739778154076225 (probTotalSpendRate: 2.0000000000162133

[Time_ROI diff: 0.17624798671671904 (up%-> 15.404401752302697) . o: 1.1441404187629225 -> a: 1.3203884054796415	 returnMoney: o:3.5269038E9 a: 2.748708E8 (timeReturnRate: 0.07793544014441221	 totalSpendMoney: o: 3.0825795E9 a: 2.081742E8 (timeTotalSpendRate: 0.06753246753246753

[[Per_Prob_ROI diff: 0.07154962410269465 (up%-> 2634.7293637796874) . o: 0.002715634671488693 -> a: 0.07426525877418334	 per returnMoney: o:3.7201182736681856E-4 a: 0.02034703335963252	 per totalSpendMoney: o: 3.558153446823395E-4 a: 0.021075216569817114

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.0957730120246878

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.015702027565924204     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9234151098476866 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Three3, 	playerStartValue=2	@@@ 

net money diff:  -0.010573948469004835 , up % -> -105.06718707389173 .  o: 0.010063987400336871 -> a: -5.099610686679634E-4 (anet/onet: -0.050671870738917414

[ProbMatrix: total: o: 4.566296923452084E-4  -> a: 4.566296923458118E-4
org->adv	$w:50.68581873249828->47.48445941311518  	$d:5.974933559420112->4.844948925096264  	$l:43.3392477080816->47.67059166178856
	 improve value x$w(high is good):-3.2013593193830943  	x$d:-1.129984634323848  	 x$l(negative is good):4.331343953706963
	 	 $w-$l: 7.346571024416676 -> -0.18613224867338185  _ #Surrender#	 lift : -7.532703273090058 : bad	 :| stand

[TimeMatrix: total:  o: 5987905.0 -> a: 202189.0
org->adv	$w:55.26959763055693->64.38184075295887  	$d:3.84348115075306->3.2355865056951663  	$l:40.886921218690006->32.38257274134597
	 improve value x$w(high is good):9.112243122401935  	x$d:-0.6078946450578937  	 x$l(negative is good):-8.504348477344038
	 	 $w-$l: 14.382676411866925 -> 31.999268011612898  _ @double@	 lift : 17.616591599745973 : good	 :) hit 

[Prob_ROI diff: -0.07532703273335473 (up%-> -7.017181081270377) . o: 1.0734657102466802 -> a: 0.9981386775133255	 returnMoney: o:0.14705289510359612 a: 0.2734678543388571 (probReturnRate: 1.8596563783814248	 totalSpendMoney: o: 0.13698890770325925 a: 0.2739778154075251 (probTotalSpendRate: 2.000000000007348

[Time_ROI diff: 0.1761659159974598 (up%-> 15.401450772416357) . o: 1.1438267641186692 -> a: 1.319992680116129	 returnMoney: o:2.0547378E9 a: 1.601328E8 (timeReturnRate: 0.07793344727487858	 totalSpendMoney: o: 1.7963715E9 a: 1.213134E8 (timeTotalSpendRate: 0.06753246753246753

[[Per_Prob_ROI diff: 0.07399167564623846 (up%-> 2653.721944900838) . o: 0.002788222624017352 -> a: 0.07677989827025582	 per returnMoney: o:3.819555716976523E-4 a: 0.021035988795296702	 per totalSpendMoney: o: 3.5581534468379024E-4 a: 0.02107521656980962

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.08590098120235956

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.010573948469004835     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9298281891872963 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Four4, 	playerStartValue=2	@@@ 

net money diff:  -0.00528980305626231 , up % -> -37.296668870018316 .  o: 0.0141830442678344 -> a: 0.00889324121157209 (anet/onet: 0.6270333112998168

[ProbMatrix: total: o: 4.5662969234542975E-4  -> a: 4.566296923458104E-4
org->adv	$w:52.53725451645508->49.28416596967663  	$d:5.2789162957544224->4.677639344247068  	$l:42.1838291877905->46.03819468607629
	 improve value x$w(high is good):-3.25308854677845  	x$d:-0.6012769515073542  	 x$l(negative is good):3.8543654982857873
	 	 $w-$l: 10.353425328664578 -> 3.2459712836003405  _ #Surrender#	 lift : -7.107454045064237 : bad	 :| stand

[TimeMatrix: total:  o: 1751089.0 -> a: 117949.0
org->adv	$w:64.86517818340472->64.36425912894556  	$d:4.181169546493639->3.2369922593663363  	$l:30.953652270101635->32.398748611688106
	 improve value x$w(high is good):-0.5009190544591604  	x$d:-0.9441772871273031  	 x$l(negative is good):1.4450963415864706
	 	 $w-$l: 33.911525913303095 -> 31.96551051725745  _ @double@	 lift : -1.9460153960456417 : bad	 :| stand

[Prob_ROI diff: -0.07107454045186667 (up%-> -6.440628393736285) . o: 1.1035342532879078 -> a: 1.032459712836041	 returnMoney: o:0.15117195197158942 a: 0.2828710566190346 (probReturnRate: 1.8711874321249495	 totalSpendMoney: o: 0.13698890770375502 a: 0.2739778154074625 (probTotalSpendRate: 1.9999999999996532

[Time_ROI diff: -0.019460153960456195 (up%-> -1.4532097836787459) . o: 1.3391152591330309 -> a: 1.3196551051725747	 returnMoney: o:7.03473E8 a: 9.33912E7 (timeReturnRate: 0.1327573339701737	 totalSpendMoney: o: 5.253267E8 a: 7.07694E7 (timeTotalSpendRate: 0.13471502590673576

[[Per_Prob_ROI diff: 0.07370218385197813 (up%-> 1288.9968246160688) . o: 0.005717794058486569 -> a: 0.0794199779104647	 per returnMoney: o:7.832743625470955E-4 a: 0.021759312047618048	 per totalSpendMoney: o: 7.097870865479535E-4 a: 0.02107521656980481

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.07636434350812898

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.00528980305626231     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.935593716062637 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Five5, 	playerStartValue=2	@@@ 

net money diff:  -7.529072901771294E-5 , up % -> -0.4031067925057418 .  o: 0.018677613579691915 -> a: 0.018602322850674202 (anet/onet: 0.9959689320749426

[ProbMatrix: total: o: 4.566296923455357E-4  -> a: 4.566296923457833E-4
org->adv	$w:54.26243795484454->51.143527492570726  	$d:5.109522592078602->4.502663672552508  	$l:40.628039453076866->44.35380883487676
	 improve value x$w(high is good):-3.118910462273817  	x$d:-0.6068589195260943  	 x$l(negative is good):3.7257693817998927
	 	 $w-$l: 13.63439850176768 -> 6.789718657693966  _ @double@	 lift : -6.844679844073714 : bad	 :| stand

[TimeMatrix: total:  o: 1056289.0 -> a: 71149.0
org->adv	$w:64.85204333283788->64.35086930244978  	$d:4.183703512959048->3.2382746068110584  	$l:30.964253154203064->32.41085609073915
	 improve value x$w(high is good):-0.5011740303880998  	x$d:-0.9454289061479897  	 x$l(negative is good):1.4466029365360882
	 	 $w-$l: 33.887790178634816 -> 31.94001321171063  _ @double@	 lift : -1.9477769669241862 : bad	 :| stand

[Prob_ROI diff: -0.06844679844175583 (up%-> -6.023422427023877) . o: 1.1363439850187433 -> a: 1.0678971865769875	 returnMoney: o:0.15566652128342587 a: 0.29258013825811113 (probReturnRate: 1.87953155145931	 totalSpendMoney: o: 0.13698890770373395 a: 0.27397781540743693 (probTotalSpendRate: 1.999999999999774

[Time_ROI diff: -0.019477769669241862 (up%-> -1.4547831167617578) . o: 1.3388779017863481 -> a: 1.3194001321171063	 returnMoney: o:4.242726E8 a: 5.63244E7 (timeReturnRate: 0.13275521445410332	 totalSpendMoney: o: 3.168867E8 a: 4.26894E7 (timeTotalSpendRate: 0.13471502590673576

[[Per_Prob_ROI diff: 0.07625814476050813 (up%-> 1295.1907285834145) . o: 0.005887792668490898 -> a: 0.08214593742899903	 per returnMoney: o:8.065622864426211E-4 a: 0.022506164481393164	 per totalSpendMoney: o: 7.097870865478443E-4 a: 0.02107521656980284

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.06852208917077354

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -7.529072901771294E-5     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9397657757297613 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Six6, 	playerStartValue=2	@@@ 

net money diff:  0.002884373217659497 , up % -> 13.08087705280088 .  o: 0.02205030447130374 -> a: 0.024934677688963236 (anet/onet: 1.1308087705280088

[ProbMatrix: total: o: 4.566296923456127E-4  -> a: 4.5662969234576964E-4
org->adv	$w:55.67771173950037->52.31633056799178  	$d:4.7409925307703->4.4683230630030035  	$l:39.58129572972933->43.21534636900522
	 improve value x$w(high is good):-3.36138117150859  	x$d:-0.2726694677672965  	 x$l(negative is good):3.634050639275891
	 	 $w-$l: 16.09641600977104 -> 9.100984198986561  _ @double@	 lift : -6.99543181078448 : bad	 :| stand

[TimeMatrix: total:  o: 600037.0 -> a: 40417.0
org->adv	$w:64.84000153323879->64.33926318133459  	$d:4.1810755003441455->3.2387361753717494  	$l:30.978922966417073->32.422000643293664
	 improve value x$w(high is good):-0.5007383519042037  	x$d:-0.9423393249723961  	 x$l(negative is good):1.443077676876591
	 	 $w-$l: 33.86107856682172 -> 31.91726253804092  _ @double@	 lift : -1.9438160287807982 : bad	 :| stand

[Prob_ROI diff: -0.06995431810830577 (up%-> -6.025536404361495) . o: 1.1609641600981844 -> a: 1.0910098419898786	 returnMoney: o:0.1590392121750656 a: 0.2989124930964031 (probReturnRate: 1.879489271912195	 totalSpendMoney: o: 0.13698890770376185 a: 0.2739778154074399 (probTotalSpendRate: 1.999999999999388

[Time_ROI diff: -0.019438160287807982 (up%-> -1.4521144230960834) . o: 1.3386107856682172 -> a: 1.3191726253804092	 returnMoney: o:2.409648E8 a: 3.19902E7 (timeReturnRate: 0.13275880958546643	 totalSpendMoney: o: 1.800111E8 a: 2.42502E7 (timeTotalSpendRate: 0.13471502590673576

[[Per_Prob_ROI diff: 0.07790847565674379 (up%-> 1295.1593441506332) . o: 0.006015358342477639 -> a: 0.08392383399922143	 per returnMoney: o:8.240373687827232E-4 a: 0.022993268699723315	 per totalSpendMoney: o: 7.097870865479889E-4 a: 0.021075216569803067

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.06706994489064627

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.002884373217659497     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.939744635956385 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Seven7, 	playerStartValue=2	@@@ 

net money diff:  -0.04138245656695483 , up % -> -246.53186450114882 .  o: 0.016785844966001134 -> a: -0.024596611600953694 (anet/onet: -1.4653186450114883

[ProbMatrix: total: o: 4.566296923443994E-4  -> a: 4.566296923457636E-4
org->adv	$w:51.73326845410487->42.65418059753767  	$d:8.786896779533674->5.71404638037491  	$l:39.47983476636145->51.63177302208742
	 improve value x$w(high is good):-9.079087856567206  	x$d:-3.0728503991587637  	 x$l(negative is good):12.151938255725973
	 	 $w-$l: 12.253433687743426 -> -8.977592424549757  _ #Surrender#	 lift : -21.231026112293183 : bad	 :| stand

[TimeMatrix: total:  o: 1.2911041E7 -> a: 24973.0
org->adv	$w:31.227845996306574->64.26140231449966  	$d:3.537809228550974->3.247507307892524  	$l:65.23434477514245->32.49109037760782
	 improve value x$w(high is good):33.03355631819309  	x$d:-0.29030192065844984  	 x$l(negative is good):-32.74325439753463
	 	 $w-$l: -34.006498778835876 -> 31.770311936891844  _ @double@	 lift : 65.77681071572772 : good	 :) hit 

[Prob_ROI diff: -0.2123102611314528 (up%-> -18.91347588710909) . o: 1.1225343368859961 -> a: 0.9102240757545433	 returnMoney: o:0.1537747526679982 a: 0.2493812038064823 (probReturnRate: 1.6217304822781913	 totalSpendMoney: o: 0.13698890770199706 a: 0.273977815407436 (probTotalSpendRate: 2.0000000000251252

[Time_ROI diff: 0.6577681071572772 (up%-> 99.67164872081842) . o: 0.6599350122116412 -> a: 1.3177031193689184	 returnMoney: o:2.5561344E9 a: 1.97442E7 (timeReturnRate: 0.007724241730012319	 totalSpendMoney: o: 3.8733123E9 a: 1.49838E7 (timeTotalSpendRate: 0.0038684719535783366

[[Per_Prob_ROI diff: 0.06985021765038132 (up%-> 41821.732966364594) . o: 1.6701894612200507E-4 -> a: 0.07001723659650333	 per returnMoney: o:2.2879742994792175E-5 a: 0.01918316952357556	 per totalSpendMoney: o: 2.038222105371181E-5 a: 0.021075216569802768

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.2536927176984076

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.04138245656695483     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.810865241128909 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Eight8, 	playerStartValue=2	@@@ 

net money diff:  -0.0502347218945732 , up % -> -680.6808615324178 .  o: 0.0073800696822119705 -> a: -0.04285465221236123 (anet/onet: -5.806808615324178

[ProbMatrix: total: o: 4.566296923453456E-4  -> a: 4.566296923457506E-4
org->adv	$w:47.27236695676928->39.25153437708829  	$d:10.842614452941415->5.855280790061618  	$l:41.885018590289306->54.89318483285008
	 improve value x$w(high is good):-8.020832579680992  	x$d:-4.987333662879797  	 x$l(negative is good):13.008166242560776
	 	 $w-$l: 5.387348366479977 -> -15.641650455761791  _ #Surrender#	 lift : -21.028998822241768 : bad	 :| stand

[TimeMatrix: total:  o: 7749313.0 -> a: 14989.0
org->adv	$w:31.218457687797613->64.24044299152712  	$d:3.5391008209372883->3.249049302822069  	$l:65.2424414912651->32.51050770565081
	 improve value x$w(high is good):33.02198530372951  	x$d:-0.29005151811521923  	 x$l(negative is good):-32.73193378561429
	 	 $w-$l: -34.02398380346749 -> 31.729935285876316  _ @double@	 lift : 65.75391908934381 : good	 :) hit 

[Prob_ROI diff: -0.21028998822845013 (up%-> -19.954006954987584) . o: 1.0538734836708439 -> a: 0.8435834954423937	 returnMoney: o:0.144368977384983 a: 0.2311231631950813 (probReturnRate: 1.6009198609113533	 totalSpendMoney: o: 0.13698890770277103 a: 0.27397781540744254 (probTotalSpendRate: 2.0000000000138733

[Time_ROI diff: 0.6575391908934379 (up%-> 99.66336690210709) . o: 0.6597601619653252 -> a: 1.317299352858763	 returnMoney: o:1.5338064E9 a: 1.1847E7 (timeReturnRate: 0.007723921350178223	 totalSpendMoney: o: 2.3247939E9 a: 8993400.0 (timeTotalSpendRate: 0.0038684719535783366

[[Per_Prob_ROI diff: 0.06473423503348412 (up%-> 41283.778404271434) . o: 1.5680307746925213E-4 -> a: 0.06489103811095337	 per returnMoney: o:2.148028230694584E-5 a: 0.0177787048611601	 per totalSpendMoney: o: 2.0382221053826965E-5 a: 0.02107521656980327

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.26052471012302336

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.0502347218945732     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.8004599304501241 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Nine9, 	playerStartValue=2	@@@ 

net money diff:  -0.05645864351769783 , up % -> -1076.0420860228794 .  o: -0.005246880605420612 -> a: -0.061705524123118444 (anet/onet: 11.760420860228793

[ProbMatrix: total: o: 4.566296923445846E-4  -> a: 4.566296923457445E-4
org->adv	$w:42.54188573948372->35.75537633503666  	$d:11.086078551110107->5.967159535571965  	$l:46.372035709406184->58.277464129391376
	 improve value x$w(high is good):-6.7865094044470595  	x$d:-5.118919015538142  	 x$l(negative is good):11.905428419985192
	 	 $w-$l: -3.8301499699224695 -> -22.522087794354718  _ #Surrender#	 lift : -18.691937824432248 : bad	 :| stand

[TimeMatrix: total:  o: 9893185.0 -> a: 9997.0
org->adv	$w:31.29135864739212->64.19925977793338  	$d:3.5526678213335745->3.2509752925877766  	$l:65.1559735312743->32.54976492947884
	 improve value x$w(high is good):32.90790113054126  	x$d:-0.3016925287457979  	 x$l(negative is good):-32.60620860179546
	 	 $w-$l: -33.86461488388218 -> 31.64949484845454  _ @double@	 lift : 65.51410973233672 : good	 :) hit 

[Prob_ROI diff: -0.18691937825684102 (up%-> -19.43638034123447) . o: 0.9616985003133001 -> a: 0.774779122056459	 returnMoney: o:0.13174202709634666 a: 0.2122722912843278 (probReturnRate: 1.6112723931983155	 totalSpendMoney: o: 0.13698890770176728 a: 0.27397781540744626 (probTotalSpendRate: 2.000000000028555

[Time_ROI diff: 0.6551410973233672 (up%-> 99.0606006411087) . o: 0.6613538511611782 -> a: 1.3164949484845454	 returnMoney: o:1.9628688E9 a: 7896600.0 (timeReturnRate: 0.004022989208448369	 totalSpendMoney: o: 2.9679555E9 a: 5998200.0 (timeTotalSpendRate: 0.0020209871745044696

[[Per_Prob_ROI diff: 0.059523640914540175 (up%-> 79626.99745461681) . o: 7.475308980282161E-5 -> a: 0.059598394004343	 per returnMoney: o:1.024034411942065E-5 a: 0.01632863779110214	 per totalSpendMoney: o: 1.0648185596717239E-5 a: 0.02107521656980356

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.24337802177453885

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.05645864351769783     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.8056361965876553 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Ten, 	playerStartValue=2	@@@ 

net money diff:  -0.0617780039442206 , up % -> -281.496951319538 .  o: -0.021946242634114363 -> a: -0.08372424657833497 (anet/onet: 3.81496951319538

[ProbMatrix: total: o: 4.566296923450586E-4  -> a: 4.5662969234574476E-4
org->adv	$w:36.243991129215146->31.672116103424987  	$d:11.491565427022174->6.0969992104356825  	$l:52.26444344376267->62.23088468613933
	 improve value x$w(high is good):-4.57187502579016  	x$d:-5.394566216586491  	 x$l(negative is good):9.96644124237666
	 	 $w-$l: -16.02045231454753 -> -30.558768582714347  _ #Surrender#	 lift : -14.538316268166817 : bad	 :| stand

[TimeMatrix: total:  o: 4953025.0 -> a: 5005.0
org->adv	$w:31.250720519278623->64.11588411588411  	$d:3.5588756366059124->3.2567432567432566  	$l:65.19040384411547->32.62737262737262
	 improve value x$w(high is good):32.86516359660549  	x$d:-0.30213237986265584  	 x$l(negative is good):-32.56303121674284
	 	 $w-$l: -33.93968332483684 -> 31.488511488511488  _ @double@	 lift : 65.42819481334833 : good	 :) hit 

[Prob_ROI diff: -0.1453831626865586 (up%-> -17.311734427321092) . o: 0.8397954768594261 -> a: 0.6944123141728675	 returnMoney: o:0.11504266506893036 a: 0.19025356882911185 (probReturnRate: 1.6537653114617712	 totalSpendMoney: o: 0.13698890770304473 a: 0.2739778154074468 (probTotalSpendRate: 2.0000000000099085

[Time_ROI diff: 0.6542819481334833 (up%-> 99.04311409083437) . o: 0.6606031667516316 -> a: 1.3148851148851148	 returnMoney: o:9.815952E8 a: 3948600.0 (timeReturnRate: 0.0040226358075100615	 totalSpendMoney: o: 1.4859075E9 a: 3003000.0 (timeTotalSpendRate: 0.0020209871745044696

[[Per_Prob_ROI diff: 0.05335105432529981 (up%-> 81729.57973788568) . o: 6.527753415152944E-5 -> a: 0.05341633185945134	 per returnMoney: o:8.942298100966216E-6 a: 0.01463488990993168	 per totalSpendMoney: o: 1.0648185596816534E-5 a: 0.0210752165698036

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.20716116663077921

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.0617780039442206     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.826882655726789 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=One1, 	playerStartValue=3	@@@ 

net money diff:  -0.09231831611978573 , up % -> -207.95677099172022 .  o: -0.044393032109284566 -> a: -0.1367113482290703 (anet/onet: 3.0795677099172023

[ProbMatrix: total: o: 4.5662969232542687E-4  -> a: 4.566296923456419E-4
org->adv	$w:27.6258593045692->21.647648448754275  	$d:12.341984514945175->6.806010383256973  	$l:60.03215618048562->71.54634116798874
	 improve value x$w(high is good):-5.978210855814925  	x$d:-5.535974131688201  	 x$l(negative is good):11.514184987503121
	 	 $w-$l: -32.40629687591642 -> -49.898692719234475  _ #Surrender#	 lift : -17.492395843318054 : bad	 :| stand

[TimeMatrix: total:  o: 9.0724465E7 -> a: 184717.0
org->adv	$w:31.47711920924527->64.72495763790013  	$d:3.504514465861->3.2065267409063596  	$l:65.01836632489373->32.0685156211935
	 improve value x$w(high is good):33.24783842865486  	x$d:-0.2979877249546403  	 x$l(negative is good):-32.949850703700235
	 	 $w-$l: -33.54124711564846 -> 32.65644201670664  _ @double@	 lift : 66.1976891323551 : good	 :) hit 

[Prob_ROI diff: -0.17492395846711728 (up%-> -25.878735795438153) . o: 0.6759370312747367 -> a: 0.5010130728076194	 returnMoney: o:0.09259587558328318 a: 0.1372664671784309 (probReturnRate: 1.4824252842122523	 totalSpendMoney: o: 0.13698890769256775 a: 0.2739778154075012 (probTotalSpendRate: 2.0000000001632667

[Time_ROI diff: 0.661976891323551 (up%-> 99.6071792793784) . o: 0.6645875288435154 -> a: 1.3265644201670663	 returnMoney: o:1.80883044E10 a: 1.470234E8 (timeReturnRate: 0.008128091873553388	 totalSpendMoney: o: 2.72173395E10 a: 1.108302E8 (timeTotalSpendRate: 0.0040720438527799534

[[Per_Prob_ROI diff: 0.038433603860852705 (up%-> 36304.94399585596) . o: 1.0586327819494702E-4 -> a: 0.03853946713904765	 per returnMoney: o:1.4502094844680217E-5 a: 0.010558959013725455	 per totalSpendMoney: o: 2.1454801518021572E-5 a: 0.021075216569807785

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.267242274586903

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.09231831611978573     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.7412126420456184 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Two2, 	playerStartValue=3	@@@ 

net money diff:  -0.0125054445440482 , up % -> -428.909873680479 .  o: 0.002915634568339237 -> a: -0.009589809975708963 (anet/onet: -3.2890987368047897

[ProbMatrix: total: o: 4.5662969234588544E-4  -> a: 4.5662969234574975E-4
org->adv	$w:48.207718830195674->45.76985190214771  	$d:5.712935079076491->4.960082150431331  	$l:46.079346090727825->49.27006594742096
	 improve value x$w(high is good):-2.437866928047967  	x$d:-0.7528529286451597  	 x$l(negative is good):3.1907198566931356
	 	 $w-$l: 2.1283727394678484 -> -3.5002140452732533  _ #Surrender#	 lift : -5.628586784741102 : bad	 :| stand

[TimeMatrix: total:  o: 5150977.0 -> a: 346957.0
org->adv	$w:55.293219131050286->64.40250520957929  	$d:3.8315061395148917->3.233830128805587  	$l:40.87527472943482->32.363664661615125
	 improve value x$w(high is good):9.109286078529003  	x$d:-0.5976760107093049  	 x$l(negative is good):-8.511610067819696
	 	 $w-$l: 14.417944401615463 -> 32.038840547964156  _ @double@	 lift : 17.6208961463487 : good	 :) hit 

[Prob_ROI diff: -0.0562858678519903 (up%-> -5.5112860747621015) . o: 1.021283727399687 -> a: 0.9649978595476968	 returnMoney: o:0.13990454227170093 a: 0.2643880054318036 (probReturnRate: 1.8897742785102012	 totalSpendMoney: o: 0.1369889077033617 a: 0.27397781540751254 (probTotalSpendRate: 2.0000000000057607

[Time_ROI diff: 0.17620896146348697 (up%-> 15.400465581253625) . o: 1.1441794440161546 -> a: 1.3203884054796415	 returnMoney: o:1.7680926E9 a: 2.748708E8 (timeReturnRate: 0.1554617671042795	 totalSpendMoney: o: 1.5452931E9 a: 2.081742E8 (timeTotalSpendRate: 0.13471502590673576

[[Per_Prob_ROI diff: 0.06893897905002375 (up%-> 1302.7939836593014) . o: 0.005291625530568327 -> a: 0.07423060458059207	 per returnMoney: o:7.248940014077769E-4 a: 0.020337538879369507	 per totalSpendMoney: o: 7.097870865459155E-4 a: 0.021075216569808656

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.0687913123960385

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.0125054445440482     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.944887139252379 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Three3, 	playerStartValue=3	@@@ 

net money diff:  -0.007504496893596779 , up % -> -109.14289875134568 .  o: 0.006875845317883544 -> a: -6.286515757132349E-4 (anet/onet: -0.0914289875134568

[ProbMatrix: total: o: 4.5662969234583475E-4  -> a: 4.566296923457921E-4
org->adv	$w:49.741525009082125->47.48445941311352  	$d:5.536221565757449->4.801627714241132  	$l:44.72225342516043->47.71391287264535
	 improve value x$w(high is good):-2.257065595968605  	x$d:-0.7345938515163173  	 x$l(negative is good):2.9916594474849205
	 	 $w-$l: 5.019271583921691 -> -0.22945345953183094  _ #Surrender#	 lift : -5.248725043453523 : bad	 :| stand

[TimeMatrix: total:  o: 3001729.0 -> a: 202189.0
org->adv	$w:55.27650897199581->64.38184075295887  	$d:3.833523945699295->3.2355865056951663  	$l:40.88996708230489->32.38257274134597
	 improve value x$w(high is good):9.105331780963056  	x$d:-0.5979374400041286  	 x$l(negative is good):-8.507394340958925
	 	 $w-$l: 14.386541889690912 -> 31.999268011612898  _ @double@	 lift : 17.612726121921984 : good	 :) hit 

[Prob_ROI diff: -0.0524872504370717 (up%-> -4.997868452647356) . o: 1.0501927158420779 -> a: 0.9977054654050062	 returnMoney: o:0.14386475302148585 a: 0.27334916383173796 (probReturnRate: 1.9000426309487628	 totalSpendMoney: o: 0.1369889077036023 a: 0.2739778154074512 (probTotalSpendRate: 2.0000000000018

[Time_ROI diff: 0.17612726121921995 (up%-> 15.397550997657481) . o: 1.143865418896909 -> a: 1.319992680116129	 returnMoney: o:1.0300722E9 a: 1.601328E8 (timeReturnRate: 0.15545784072223287	 totalSpendMoney: o: 9.005187E8 a: 1.213134E8 (timeTotalSpendRate: 0.13471502590673576

[[Per_Prob_ROI diff: 0.07130516122647237 (up%-> 1310.4162606645432) . o: 0.00544141303545118 -> a: 0.07674657426192355	 per returnMoney: o:7.454132280906002E-4 a: 0.021026858756287535	 per totalSpendMoney: o: 7.097870865471623E-4 a: 0.021075216569803937

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.05999174733066848

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.007504496893596779     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9500213154735264 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Four4, 	playerStartValue=3	@@@ 

net money diff:  -0.002338706268250862 , up % -> -21.03803479928756 .  o: 0.011116562409764913 -> a: 0.008777856141514051 (anet/onet: 0.7896196520071245

[ProbMatrix: total: o: 4.566296923453428E-4  -> a: 4.566296923458049E-4
org->adv	$w:51.61224369231364->49.28416596967598  	$d:4.890448777707865->4.635524594950216  	$l:43.49730752997849->46.0803094353738
	 improve value x$w(high is good):-2.3280777226376586  	x$d:-0.25492418275764894  	 x$l(negative is good):2.5830019053953066
	 	 $w-$l: 8.114936162335152 -> 3.2038565343021794  _ #Surrender#	 lift : -4.911079628032971 : bad	 :| stand

[TimeMatrix: total:  o: 880081.0 -> a: 117949.0
org->adv	$w:64.82937365992449->64.36425912894556  	$d:4.159617126150889->3.2369922593663363  	$l:31.011009213924627->32.398748611688106
	 improve value x$w(high is good):-0.46511453097892286  	x$d:-0.9226248667845525  	 x$l(negative is good):1.3877393977634789
	 	 $w-$l: 33.818364445999855 -> 31.96551051725745  _ @double@	 lift : -1.852853928742404 : bad	 :| stand

[Prob_ROI diff: -0.0491107962811157 (up%-> -4.542461756378642) . o: 1.081149361624301 -> a: 1.0320385653431854	 returnMoney: o:0.14810547011345712 a: 0.282755671548942 (probReturnRate: 1.9091507648727304	 totalSpendMoney: o: 0.1369889077036922 a: 0.27397781540742794 (probTotalSpendRate: 2.0000000000003175

[Time_ROI diff: -0.01852853928742393 (up%-> -1.3846036277704477) . o: 1.3381836444599986 -> a: 1.3196551051725747	 returnMoney: o:3.53313E8 a: 9.33912E7 (timeReturnRate: 0.2643299284204091	 totalSpendMoney: o: 2.640243E8 a: 7.07694E7 (timeTotalSpendRate: 0.26804123711340205

[[Per_Prob_ROI diff: 0.06824171224200877 (up%-> 612.2600930485594) . o: 0.01114586970746702 -> a: 0.07938758194947579	 per returnMoney: o:0.0015268605166335785 a: 0.021750436272995537	 per totalSpendMoney: o: 0.0014122567804504352 a: 0.02107521656980215

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.05144950254936656

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.002338706268250862     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9545753824362136 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Five5, 	playerStartValue=3	@@@ 

net money diff:  0.0027612211201722137 , up % -> 17.550041407811808 .  o: 0.0157334165544655 -> a: 0.018494637674637715 (anet/onet: 1.175500414078118

[ProbMatrix: total: o: 4.5662969234552895E-4  -> a: 4.566296923457807E-4
org->adv	$w:53.37564689438514->51.14352749257023  	$d:4.733881776281488->4.463359331105933  	$l:41.89047132933338->44.39311317632384
	 improve value x$w(high is good):-2.232119401814913  	x$d:-0.2705224451755548  	 x$l(negative is good):2.502641846990457
	 	 $w-$l: 11.485175565051764 -> 6.750414316246389  _ @double@	 lift : -4.734761248805375 : bad	 :| stand

[TimeMatrix: total:  o: 530881.0 -> a: 71149.0
org->adv	$w:64.81622058427406->64.35086930244978  	$d:4.1621380309334866->3.2382746068110584  	$l:31.02164138479245->32.41085609073915
	 improve value x$w(high is good):-0.4653512818242831  	x$d:-0.9238634241224282  	 x$l(negative is good):1.3892147059467028
	 	 $w-$l: 33.79457919948162 -> 31.94001321171063  _ @double@	 lift : -1.8545659877709841 : bad	 :| stand

[Prob_ROI diff: -0.04734761248824815 (up%-> -4.246987301070069) . o: 1.114851755650846 -> a: 1.0675041431625978	 returnMoney: o:0.15272232425819915 a: 0.29247245308204983 (probReturnRate: 1.915060253978213	 totalSpendMoney: o: 0.13698890770373365 a: 0.2739778154074121 (probTotalSpendRate: 1.9999999999995972

[Time_ROI diff: -0.01854565987770984 (up%-> -1.3861293924366778) . o: 1.3379457919948161 -> a: 1.3194001321171063	 returnMoney: o:2.13087E8 a: 5.63244E7 (timeReturnRate: 0.26432583874192234	 totalSpendMoney: o: 1.592643E8 a: 4.26894E7 (timeTotalSpendRate: 0.26804123711340205

[[Per_Prob_ROI diff: 0.07062238625163439 (up%-> 614.4647870612463) . o: 0.011493317068565422 -> a: 0.08211570332019981	 per returnMoney: o:0.0015744569511154552 a: 0.022497881006311525	 per totalSpendMoney: o: 0.0014122567804508623 a: 0.021075216569800933

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.044586391368075934

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.0027612211201722137     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9575301269892993 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Six6, 	playerStartValue=3	@@@ 

net money diff:  0.005842210269450587 , up % -> 30.836088519482896 .  o: 0.018946016015485734 -> a: 0.02478822628493632 (anet/onet: 1.308360885194829

[ProbMatrix: total: o: 4.5662969234565743E-4  -> a: 4.566296923457679E-4
org->adv	$w:54.72099903751966->52.316330567991464  	$d:4.3883304771435565->4.414869317553656  	$l:40.89067048533677->43.268800114454876
	 improve value x$w(high is good):-2.404668469528197  	x$d:0.02653884041009924  	 x$l(negative is good):2.3781296291181064
	 	 $w-$l: 13.830328552182886 -> 9.04753045353659  _ @double@	 lift : -4.782798098646296 : bad	 :| stand

[TimeMatrix: total:  o: 301573.0 -> a: 40417.0
org->adv	$w:64.80420992595491->64.33926318133459  	$d:4.159523564775361->3.2387361753717494  	$l:31.036266509269726->32.422000643293664
	 improve value x$w(high is good):-0.4649467446203204  	x$d:-0.9207873894036114  	 x$l(negative is good):1.385734134023938
	 	 $w-$l: 33.767943416685185 -> 31.91726253804092  _ @double@	 lift : -1.8506808786442674 : bad	 :| stand

[Prob_ROI diff: -0.04782798098649055 (up%-> -4.201690498025876) . o: 1.1383032855219124 -> a: 1.0904753045354219	 returnMoney: o:0.1559349237192292 a: 0.2987660416923608 (probReturnRate: 1.915966190039046	 totalSpendMoney: o: 0.13698890770374347 a: 0.2739778154074245 (probTotalSpendRate: 1.9999999999995441

[Time_ROI diff: -0.01850680878644262 (up%-> -1.383501032739524) . o: 1.3376794341668519 -> a: 1.3191726253804092	 returnMoney: o:1.210224E8 a: 3.19902E7 (timeReturnRate: 0.2643328838297704	 totalSpendMoney: o: 9.04719E7 a: 2.42502E7 (timeTotalSpendRate: 0.26804123711340205

[[Per_Prob_ROI diff: 0.07214763031574231 (up%-> 614.8027708993453) . o: 0.011735085417751675 -> a: 0.08388271573349398	 per returnMoney: o:0.0016075765331879299 a: 0.022982003207104678	 per totalSpendMoney: o: 0.0014122567804509636 a: 0.021075216569801884

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.04198577071703996

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.005842210269450587     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9579830950197413 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Seven7, 	playerStartValue=3	@@@ 

net money diff:  -0.03576124610821202 , up % -> -329.9516670119578 .  o: 0.010838328665548458 -> a: -0.02492291744266356 (anet/onet: -2.299516670119578

[ProbMatrix: total: o: 4.5662969234545636E-4  -> a: 4.5662969234576005E-4
org->adv	$w:49.72021986946225->42.65418059753724  	$d:8.471389654353416->5.594947014161869  	$l:41.80839047618433->51.750872388300884
	 improve value x$w(high is good):-7.066039271925007  	x$d:-2.876442640191547  	 x$l(negative is good):9.942481912116556
	 	 $w-$l: 7.911829393277925 -> -9.09669179076364  _ #Surrender#	 lift : -17.008521184041562 : bad	 :| stand

[TimeMatrix: total:  o: 6364273.0 -> a: 24973.0
org->adv	$w:31.22505901302474->64.26140231449966  	$d:3.5375603780667486->3.247507307892524  	$l:65.23738060890851->32.49109037760782
	 improve value x$w(high is good):33.03634330147492  	x$d:-0.29005307017422455  	 x$l(negative is good):-32.74629023130069
	 	 $w-$l: -34.01232159588377 -> 31.770311936891844  _ @double@	 lift : 65.78263353277562 : good	 :) hit 

[Prob_ROI diff: -0.1700852118427889 (up%-> -15.761498326799716) . o: 1.0791182939352173 -> a: 0.9090330820924284	 returnMoney: o:0.1478272363690306 a: 0.24905489796476704 (probReturnRate: 1.684770033466873	 totalSpendMoney: o: 0.13698890770348215 a: 0.2739778154074306 (probTotalSpendRate: 2.000000000003404

[Time_ROI diff: 0.6578263353277561 (up%-> 99.68926794168317) . o: 0.6598767840411622 -> a: 1.3177031193689184	 returnMoney: o:1.2598908E9 a: 1.97442E7 (timeReturnRate: 0.01567135818437598	 totalSpendMoney: o: 1.9092819E9 a: 1.49838E7 (timeTotalSpendRate: 0.00784787201931784

[[Per_Prob_ROI diff: 0.0695998993046288 (up%-> 21367.858157177892) . o: 3.257223947887767E-4 -> a: 0.06992562169941757	 per returnMoney: o:4.462035507667691E-5 a: 0.01915806907421285	 per totalSpendMoney: o: 4.134890060473352E-5 a: 0.021075216569802355

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.20584645795100093

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.03576124610821202     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.8423850167320027 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Eight8, 	playerStartValue=3	@@@ 

net money diff:  -0.04474405153477129 , up % -> -2520.1637470630926 .  o: 0.0017754422341371423 -> a: -0.04296860930063415 (anet/onet: -24.201637470630924

[ProbMatrix: total: o: 4.5662969234582277E-4  -> a: 4.5662969234574834E-4
org->adv	$w:45.43687330208631->39.2515343770881  	$d:10.42230156767513->5.813687244209935  	$l:44.14082513023856->54.934778378701964
	 improve value x$w(high is good):-6.185338924998213  	x$d:-4.608614323465194  	 x$l(negative is good):10.793953248463403
	 	 $w-$l: 1.2960481718477523 -> -15.683244001613867  _ #Surrender#	 lift : -16.97929217346162 : bad	 :| stand

[TimeMatrix: total:  o: 3819889.0 -> a: 14989.0
org->adv	$w:31.215671450139->64.24044299152712  	$d:3.538846285847573->3.249049302822069  	$l:65.24548226401343->32.51050770565081
	 improve value x$w(high is good):33.02477154138812  	x$d:-0.28979698302550405  	 x$l(negative is good):-32.73497455836262
	 	 $w-$l: -34.029810813874434 -> 31.729935285876316  _ @double@	 lift : 65.75974609975074 : good	 :) hit 

[Prob_ROI diff: -0.16979292173612193 (up%-> -16.762047957469562) . o: 1.012960481720005 -> a: 0.8431675599838832	 returnMoney: o:0.13876434993782705 a: 0.2310092061068064 (probReturnRate: 1.6647590408509778	 totalSpendMoney: o: 0.1369889077036899 a: 0.27397781540744054 (probTotalSpendRate: 2.000000000000443

[Time_ROI diff: 0.6575974609975075 (up%-> 99.68100275446977) . o: 0.6597018918612556 -> a: 1.317299352858763	 returnMoney: o:7.559964E8 a: 1.1847E7 (timeReturnRate: 0.015670709543061316	 totalSpendMoney: o: 1.1459667E9 a: 8993400.0 (timeTotalSpendRate: 0.00784787201931784

[[Per_Prob_ROI diff: 0.06455328983640775 (up%-> 21112.871932069495) . o: 3.0575323927558255E-4 -> a: 0.06485904307568333	 per returnMoney: o:4.1884802275227E-5 a: 0.0177699389312928	 per totalSpendMoney: o: 4.134890060479623E-5 a: 0.02107521656980312

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.21453697327089322

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.04474405153477129     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.8323795204253045 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Nine9, 	playerStartValue=3	@@@ 

net money diff:  -0.051410845569248825 , up % -> -494.2871299474736 .  o: -0.010401008331880318 -> a: -0.06181185390112914 (anet/onet: 5.942871299474736

[ProbMatrix: total: o: 4.566296923460385E-4  -> a: 4.5662969234574276E-4
org->adv	$w:40.8717341360839->35.75537633503647  	$d:10.663940103669493->5.928349904998679  	$l:48.46432576024661->58.316273759964844
	 improve value x$w(high is good):-5.116357801047428  	x$d:-4.735590198670813  	 x$l(negative is good):9.851947999718234
	 	 $w-$l: -7.592591624162703 -> -22.56089742492837  _ #Surrender#	 lift : -14.96830580076567 : bad	 :| stand

[TimeMatrix: total:  o: 4910065.0 -> a: 9997.0
org->adv	$w:31.290665194859947->64.19925977793338  	$d:3.5526209938157645->3.2509752925877766  	$l:65.15671381132428->32.54976492947884
	 improve value x$w(high is good):32.90859458307343  	x$d:-0.30164570122798784  	 x$l(negative is good):-32.60694888184544
	 	 $w-$l: -33.86604861646434 -> 31.64949484845454  _ @double@	 lift : 65.51554346491888 : good	 :) hit 

[Prob_ROI diff: -0.14968305801088622 (up%-> -16.198166428558753) . o: 0.9240740837616176 -> a: 0.7743910257507314	 returnMoney: o:0.1265878993715786 a: 0.2121659615063159 (probReturnRate: 1.67603667143205	 totalSpendMoney: o: 0.13698890770345892 a: 0.27397781540744504 (probTotalSpendRate: 2.0000000000038485

[Time_ROI diff: 0.6551554346491888 (up%-> 99.06491611996627) . o: 0.6613395138353566 -> a: 1.3164949484845454	 returnMoney: o:9.74166E8 a: 7896600.0 (timeReturnRate: 0.008106010679904657	 totalSpendMoney: o: 1.4730195E9 a: 5998200.0 (timeTotalSpendRate: 0.0040720438527799534

[[Per_Prob_ROI diff: 0.059423814665737235 (up%-> 41059.592873357884) . o: 1.4472577662672163E-4 -> a: 0.059568540442363954	 per returnMoney: o:1.982582605662938E-5 a: 0.016320458577408915	 per totalSpendMoney: o: 2.1454801519727317E-5 a: 0.021075216569803466

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.20109390358013504

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.051410845569248825     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.8380183357144124 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Ten, 	playerStartValue=3	@@@ 

net money diff:  -0.05740086203506256 , up % -> -217.24405105003157 .  o: -0.02642229407784477 -> a: -0.08382315611290733 (anet/onet: 3.1724405105003157

[ProbMatrix: total: o: 4.5662969234590094E-4  -> a: 4.566296923457439E-4
org->adv	$w:34.835794428924146->31.67211610342493  	$d:11.040503441437023->6.060897917187964  	$l:54.12370212963883->62.2669859793871
	 improve value x$w(high is good):-3.163678325499216  	x$d:-4.97960552424906  	 x$l(negative is good):8.143283849748272
	 	 $w-$l: -19.287907700714683 -> -30.59486987596217  _ #Surrender#	 lift : -11.306962175247486 : bad	 :| stand

[TimeMatrix: total:  o: 2458225.0 -> a: 5005.0
org->adv	$w:31.250027967334155->64.11588411588411  	$d:3.558828016149864->3.2567432567432566  	$l:65.19114401651598->32.62737262737262
	 improve value x$w(high is good):32.86585614854996  	x$d:-0.3020847594066076  	 x$l(negative is good):-32.563771389143355
	 	 $w-$l: -33.94111604918182 -> 31.488511488511488  _ @double@	 lift : 65.4296275376933 : good	 :) hit 

[Prob_ROI diff: -0.11306962175427737 (up%-> -14.009006399531) . o: 0.8071209229946726 -> a: 0.6940513012403953	 returnMoney: o:0.11056661362578857 a: 0.1901546592945388 (probReturnRate: 1.7198198720105065	 totalSpendMoney: o: 0.13698890770363334 a: 0.27397781540744615 (probTotalSpendRate: 2.00000000000131

[Time_ROI diff: 0.6542962753769331 (up%-> 99.04743105621743) . o: 0.6605888395081817 -> a: 1.3148851148851148	 returnMoney: o:4.871628E8 a: 3948600.0 (timeReturnRate: 0.008105298680441117	 totalSpendMoney: o: 7.374675E8 a: 3003000.0 (timeTotalSpendRate: 0.0040720438527799534

[[Per_Prob_ROI diff: 0.05326215271876384 (up%-> 42134.807241461116) . o: 1.26408915112713E-4 -> a: 0.053388561633876556	 per returnMoney: o:1.7316619205291867E-5 a: 0.014627281484195294	 per totalSpendMoney: o: 2.1454801519754635E-5 a: 0.02107521656980355

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.17047048378933993

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.05740086203506256     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.85990993600469 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=One1, 	playerStartValue=4	@@@ 

net money diff:  -0.08879548415970426 , up % -> -183.54733038612622 .  o: -0.0483774315719582 -> a: -0.13717291573166246 (anet/onet: 2.8354733038612623

[ProbMatrix: total: o: 4.5662969233988676E-4  -> a: 4.566296923456461E-4
org->adv	$w:26.41979520474289->21.563507098128127  	$d:11.845556449206933->6.805824151402717  	$l:61.73464834605017->71.63066875046916
	 improve value x$w(high is good):-4.8562881066147625  	x$d:-5.039732297804216  	 x$l(negative is good):9.896020404418984
	 	 $w-$l: -35.31485314130728 -> -50.06716165234104  _ #Surrender#	 lift : -14.752308511033762 : bad	 :| stand

[TimeMatrix: total:  o: 4.5028321E7 -> a: 184717.0
org->adv	$w:31.473933927050048->64.72495763790013  	$d:3.504194615650892->3.2065267409063596  	$l:65.02187145729906->32.0685156211935
	 improve value x$w(high is good):33.251023710850085  	x$d:-0.2976678747445325  	 x$l(negative is good):-32.95335583610556
	 	 $w-$l: -33.547937530249015 -> 32.65644201670664  _ @double@	 lift : 66.20437954695566 : good	 :) hit 

[Prob_ROI diff: -0.1475230851262817 (up%-> -22.80633070910958) . o: 0.6468514686027781 -> a: 0.4993283834764964	 returnMoney: o:0.08861147612802373 a: 0.13680489967586024 (probReturnRate: 1.5438733858604028	 totalSpendMoney: o: 0.13698890769998193 a: 0.2739778154075227 (probTotalSpendRate: 2.0000000000551785

[Time_ROI diff: 0.6620437954695565 (up%-> 99.62727579312067) . o: 0.6645206246975098 -> a: 1.3265644201670663	 returnMoney: o:8.9766744E9 a: 1.470234E8 (timeReturnRate: 0.016378381731212175	 totalSpendMoney: o: 1.35084963E10 a: 1.108302E8 (timeTotalSpendRate: 0.008204480908804039

[[Per_Prob_ROI diff: 0.03820575717030806 (up%-> 18717.44138329475) . o: 2.0411848173012878E-4 -> a: 0.03840987565203819	 per returnMoney: o:2.7961967853589057E-5 a: 0.010523453821220018	 per totalSpendMoney: o: 4.3227802997785396E-5 a: 0.021075216569809437

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=true]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.23631856928598596

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.08879548415970426     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.7719366929089042 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Two2, 	playerStartValue=4	@@@ 

net money diff:  -0.009731201522265753 , up % -> -2909.237762726838 .  o: -3.3449316679928787E-4 -> a: -0.010065694689065041 (anet/onet: 30.09237762726838

[ProbMatrix: total: o: 4.566296923452166E-4  -> a: 4.56629692345768E-4
org->adv	$w:47.23217488865802->45.68145028052316  	$d:5.29147485664138->4.963190778060729  	$l:47.4763502547006->49.355358941416114
	 improve value x$w(high is good):-1.550724608134864  	x$d:-0.32828407858065134  	 x$l(negative is good):1.8790086867155154
	 	 $w-$l: -0.24417536604257606 -> -3.6739086608929608  _ #Surrender#	 lift : -3.4297332948503847 : bad	 :| stand

[TimeMatrix: total:  o: 2588833.0 -> a: 346957.0
org->adv	$w:55.306966498032125->64.40250520957929  	$d:3.811756107867908->3.233830128805587  	$l:40.88127739409997->32.363664661615125
	 improve value x$w(high is good):9.095538711547164  	x$d:-0.577925979062321  	 x$l(negative is good):-8.517612732484842
	 	 $w-$l: 14.42568910393216 -> 32.038840547964156  _ @double@	 lift : 17.613151444032 : good	 :) hit 

[Prob_ROI diff: -0.034297332948243 (up%-> -3.4381283573252177) . o: 0.9975582463397471 -> a: 0.9632609133915041	 returnMoney: o:0.13665441453679122 a: 0.26391212071850023 (probReturnRate: 1.931237432856204	 totalSpendMoney: o: 0.1369889077035905 a: 0.2739778154075653 (probTotalSpendRate: 2.000000000002805

[Time_ROI diff: 0.17613151444031994 (up%-> 15.392654902898661) . o: 1.1442568910393216 -> a: 1.3203884054796415	 returnMoney: o:8.88687E8 a: 2.748708E8 (timeReturnRate: 0.3092998997397284	 totalSpendMoney: o: 7.766499E8 a: 2.081742E8 (timeTotalSpendRate: 0.26804123711340205

[[Per_Prob_ROI diff: 0.0638128877054395 (up%-> 620.5001191799581) . o: 0.010284105632368527 -> a: 0.07409699333780802	 per returnMoney: o:0.0014088083972865074 a: 0.020300932362961557	 per totalSpendMoney: o: 0.0014122567804493867 a: 0.02107521656981271

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.04402853447050875

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.009731201522265753     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9656187164267478 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Three3, 	playerStartValue=4	@@@ 

net money diff:  -0.00484196617642943 , up % -> -129.00869586745117 .  o: 0.0037532091490981856 -> a: -0.0010887570273312441 (anet/onet: -0.29008695867451156

[ProbMatrix: total: o: 4.5662969234545284E-4  -> a: 4.566296923458062E-4
org->adv	$w:48.80588604916405->47.39902890423392  	$d:5.128018452611661->4.8045534373343735  	$l:46.066095498224286->47.7964176584317
	 improve value x$w(high is good):-1.4068571449301288  	x$d:-0.32346501527728755  	 x$l(negative is good):1.7303221602074146
	 	 $w-$l: 2.739790550939769 -> -0.3973887541977805  _ #Surrender#	 lift : -3.1371793051375496 : bad	 :| stand

[TimeMatrix: total:  o: 1508641.0 -> a: 202189.0
org->adv	$w:55.29022477845955->64.38184075295887  	$d:3.813763512989505->3.2355865056951663  	$l:40.89601170855094->32.38257274134597
	 improve value x$w(high is good):9.091615974499312  	x$d:-0.5781770072943386  	 x$l(negative is good):-8.51343896720497
	 	 $w-$l: 14.394213069908613 -> 31.999268011612898  _ @double@	 lift : 17.605054941704285 : good	 :) hit 

[Prob_ROI diff: -0.031371793051001906 (up%-> -3.053519272598496) . o: 1.0273979055093703 -> a: 0.9960261124583684	 returnMoney: o:0.14074211685281202 a: 0.2728890583801487 (probReturnRate: 1.9389296145484003	 totalSpendMoney: o: 0.13698890770371383 a: 0.27397781540747995 (probTotalSpendRate: 2.000000000000382

[Time_ROI diff: 0.1760505494170428 (up%-> 15.389812534437796) . o: 1.1439421306990862 -> a: 1.319992680116129	 returnMoney: o:5.177394E8 a: 1.601328E8 (timeReturnRate: 0.30929228102014256	 totalSpendMoney: o: 4.525923E8 a: 1.213134E8 (timeTotalSpendRate: 0.26804123711340205

[[Per_Prob_ROI diff: 0.06602566228139564 (up%-> 623.3698946583035) . o: 0.010591730984632683 -> a: 0.07661739326602833	 per returnMoney: o:0.0014509496582764125 a: 0.02099146602924221	 per totalSpendMoney: o: 0.001412256780450658 a: 0.02107521656980615

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.036213759227431336

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.00484196617642943     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9694648072740151 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Four4, 	playerStartValue=4	@@@ 

net money diff:  2.2342669824365613E-4 , up % -> 2.7540791362224306 .  o: 0.00811257364776069 -> a: 0.008336000346004346 (anet/onet: 1.0275407913622243

[ProbMatrix: total: o: 4.566296923456406E-4  -> a: 4.5662969234581334E-4
org->adv	$w:50.697059010809355->49.20203137641773  	$d:4.527948066595198->4.63851948454847  	$l:44.774992922595445->46.1594491390338
	 improve value x$w(high is good):-1.4950276343916258  	x$d:0.11057141795327219  	 x$l(negative is good):1.384456216438359
	 	 $w-$l: 5.9220660882139065 -> 3.0425822373839226  _ #Surrender#	 lift : -2.879483850829984 : bad	 :| stand

[TimeMatrix: total:  o: 444577.0 -> a: 117949.0
org->adv	$w:64.75886066980523->64.36425912894556  	$d:4.117172053435063->3.2369922593663363  	$l:31.123967276759707->32.398748611688106
	 improve value x$w(high is good):-0.3946015408596679  	x$d:-0.8801797940687264  	 x$l(negative is good):1.2747813349283987
	 	 $w-$l: 33.63489339304552 -> 31.96551051725745  _ @double@	 lift : -1.6693828757880724 : bad	 :| stand

[Prob_ROI diff: -0.028794838508311438 (up%-> -2.718492904427088) . o: 1.059220660882315 -> a: 1.0304258223740035	 returnMoney: o:0.14510148135148007 a: 0.28231381575344594 (probReturnRate: 1.9456301419114785	 totalSpendMoney: o: 0.13698890770371938 a: 0.2739778154074416 (probTotalSpendRate: 2.000000000000021

[Time_ROI diff: -0.016693828757880613 (up%-> -1.2492118139220496) . o: 1.3363489339304553 -> a: 1.3196551051725747	 returnMoney: o:1.78233E8 a: 9.33912E7 (timeReturnRate: 0.5239837740485769	 totalSpendMoney: o: 1.333731E8 a: 7.07694E7 (timeTotalSpendRate: 0.5306122448979592

[[Per_Prob_ROI diff: 0.05764677661672854 (up%-> 266.6764498217749) . o: 0.02161674818127173 -> a: 0.07926352479800026	 per returnMoney: o:0.002961254721458777 a: 0.021716447365649687	 per totalSpendMoney: o: 0.0027956919939534568 a: 0.0210752165698032

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.02857141181006778

 按net净收益值(代表少输多赢) :  $Change$  Value: 2.2342669824365613E-4     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9728150709557292 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Five5, 	playerStartValue=4	@@@ 

net money diff:  0.005218820663247137 , up % -> 40.62034775570916 .  o: 0.012847799075067334 -> a: 0.01806661973831447 (anet/onet: 1.4062034775570917

[ProbMatrix: total: o: 4.5662969234569624E-4  -> a: 4.566296923457859E-4
org->adv	$w:52.498029317768825->51.06472730529307  	$d:4.38265624759832->4.464736131248428  	$l:43.11931443463287->44.47053656345851
	 improve value x$w(high is good):-1.4333020124757567  	x$d:0.08207988365010799  	 x$l(negative is good):1.3512221288256399
	 	 $w-$l: 9.378714883135958 -> 6.59419074183456  _ @double@	 lift : -2.7845241413013975 : bad	 :| stand

[TimeMatrix: total:  o: 268177.0 -> a: 71149.0
org->adv	$w:64.74567170189837->64.35086930244978  	$d:4.119667234699471->3.2382746068110584  	$l:31.13466106340216->32.41085609073915
	 improve value x$w(high is good):-0.39480239944859363  	x$d:-0.8813926278884128  	 x$l(negative is good):1.2761950273369926
	 	 $w-$l: 33.61101063849622 -> 31.94001321171063  _ @double@	 lift : -1.6709974267855865 : bad	 :| stand

[Prob_ROI diff: -0.027845241412959743 (up%-> -2.5457641774917947) . o: 1.0937871488314432 -> a: 1.0659419074184835	 returnMoney: o:0.1498367067788056 a: 0.29204443514573514 (probReturnRate: 1.9490847164497667	 totalSpendMoney: o: 0.13698890770373826 a: 0.27397781540742067 (probTotalSpendRate: 1.9999999999995923

[Time_ROI diff: -0.01670997426785581 (up%-> -1.2506435052023555) . o: 1.336110106384962 -> a: 1.3194001321171063	 returnMoney: o:1.074942E8 a: 5.63244E7 (timeReturnRate: 0.5239761773193344	 totalSpendMoney: o: 8.04531E7 a: 4.26894E7 (timeTotalSpendRate: 0.5306122448979592

[[Per_Prob_ROI diff: 0.05967334462903756 (up%-> 267.3275042540694) . o: 0.02232218671084578 -> a: 0.08199553133988334	 per returnMoney: o:0.003057891975077665 a: 0.022464956549671934	 per totalSpendMoney: o: 0.002795691993953842 a: 0.02107521656980159

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.022626420749712606

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.005218820663247137     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.974542358225082 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Six6, 	playerStartValue=4	@@@ 

net money diff:  0.008447690018715981 , up % -> 53.0890152026984 .  o: 0.015912312531061235 -> a: 0.024360002549777215 (anet/onet: 1.530890152026984

[ProbMatrix: total: o: 4.566296923457384E-4  -> a: 4.566296923457716E-4
org->adv	$w:53.77414017628611->52.22862067923878  	$d:4.067486790763824->4.433990405502125  	$l:42.15837303295007->43.3373889152591
	 improve value x$w(high is good):-1.54551949704733  	x$d:0.36650361473830095  	 x$l(negative is good):1.1790158823090309
	 	 $w-$l: 11.615767143336047 -> 8.891231763979679  _ @double@	 lift : -2.724535379356369 : bad	 :| stand

[TimeMatrix: total:  o: 152341.0 -> a: 40417.0
org->adv	$w:64.73372237283462->64.33926318133459  	$d:4.117079446767449->3.2387361753717494  	$l:31.149198180397924->32.422000643293664
	 improve value x$w(high is good):-0.39445919150003306  	x$d:-0.8783432713956998  	 x$l(negative is good):1.27280246289574
	 	 $w-$l: 33.584524192436696 -> 31.91726253804092  _ @double@	 lift : -1.6672616543957797 : bad	 :| stand

[Prob_ROI diff: -0.027245353793481364 (up%-> -2.440995075408464) . o: 1.11615767143333 -> a: 1.0889123176398485	 returnMoney: o:0.15290122023479646 a: 0.29833781795720715 (probReturnRate: 1.9511800984915422	 totalSpendMoney: o: 0.13698890770373523 a: 0.27397781540742994 (probTotalSpendRate: 1.9999999999997042

[Time_ROI diff: -0.016672616543957908 (up%-> -1.2480949155412628) . o: 1.3358452419243672 -> a: 1.3191726253804092	 returnMoney: o:6.10512E7 a: 3.19902E7 (timeReturnRate: 0.5239897004481484	 totalSpendMoney: o: 4.57023E7 a: 2.42502E7 (timeTotalSpendRate: 0.5306122448979592

[[Per_Prob_ROI diff: 0.06098375798386074 (up%-> 267.7224031773066) . o: 0.022778727988435304 -> a: 0.08376248597229605	 per returnMoney: o:0.0031204330660162542 a: 0.022949062919785164	 per totalSpendMoney: o: 0.0027956919939537803 a: 0.021075216569802303

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.018797663774765383

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.008447690018715981     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9755900492459153 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Seven7, 	playerStartValue=4	@@@ 

net money diff:  -0.03015077929258389 , up % -> -657.103791072317 .  o: 0.0045884348412267295 -> a: -0.02556234445135716 (anet/onet: -5.57103791072317

[ProbMatrix: total: o: 4.5662969234547225E-4  -> a: 4.566296923457651E-4
org->adv	$w:47.552353515676245->42.490587385292066  	$d:8.244786674498854->5.688747020945587  	$l:44.20285980982489->51.82066559376235
	 improve value x$w(high is good):-5.0617661303841786  	x$d:-2.5560396535532677  	 x$l(negative is good):7.617805783937456
	 	 $w-$l: 3.3494937058513474 -> -9.330078208470283  _ #Surrender#	 lift : -12.679571914321631 : bad	 :| stand

[TimeMatrix: total:  o: 3136993.0 -> a: 24973.0
org->adv	$w:31.217411068497764->64.26140231449966  	$d:3.536762753375605->3.247507307892524  	$l:65.24582617812663->32.49109037760782
	 improve value x$w(high is good):33.043991246001895  	x$d:-0.2892554454830809  	 x$l(negative is good):-32.754735800518816
	 	 $w-$l: -34.02841510962887 -> 31.770311936891844  _ @double@	 lift : 65.79872704652071 : good	 :) hit 

[Prob_ROI diff: -0.1267957191429625 (up%-> -12.26863476504949) . o: 1.0334949370583129 -> a: 0.9066992179153504	 returnMoney: o:0.1415773425450538 a: 0.24841547095607472 (probReturnRate: 1.7546273046975867	 totalSpendMoney: o: 0.13698890770382707 a: 0.2739778154074319 (probTotalSpendRate: 1.9999999999983775

[Time_ROI diff: 0.6579872704652071 (up%-> 99.73798136858821) . o: 0.6597158489037113 -> a: 1.3177031193689184	 returnMoney: o:6.208572E8 a: 1.97442E7 (timeReturnRate: 0.03180151571085912	 totalSpendMoney: o: 9.410979E8 a: 1.49838E7 (timeTotalSpendRate: 0.015921616656460504

[[Per_Prob_ROI diff: 0.06911321252409483 (up%-> 10920.40918682109) . o: 6.328811617013551E-4 -> a: 0.06974609368579618	 per returnMoney: o:8.66976990477978E-5 a: 0.019108882381236515	 per totalSpendMoney: o: 8.388787979413783E-5 a: 0.021075216569802453

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.1569464984355464

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.03015077929258389     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.8773136523495051 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Eight8, 	playerStartValue=4	@@@ 

net money diff:  -0.03956869121017101 , up % -> -927.9937041686516 .  o: -0.0042638965148603936 -> a: -0.0438325877250314 (anet/onet: 10.279937041686516

[ProbMatrix: total: o: 4.5662969234581215E-4  -> a: 4.5662969234575056E-4
org->adv	$w:43.43183291729284->39.09382634289316  	$d:10.023748930359154->5.813757187545266  	$l:46.54441815234801->55.09241646956158
	 improve value x$w(high is good):-4.338006574399678  	x$d:-4.209991742813888  	 x$l(negative is good):8.547998317213569
	 	 $w-$l: -3.1125852350551764 -> -15.998590126668422  _ #Surrender#	 lift : -12.886004891613245 : bad	 :| stand

[TimeMatrix: total:  o: 1882849.0 -> a: 14989.0
org->adv	$w:31.208025709974617->64.24044299152712  	$d:3.538042615207061->3.249049302822069  	$l:65.25393167481832->32.51050770565081
	 improve value x$w(high is good):33.0324172815525  	x$d:-0.28899331238499215  	 x$l(negative is good):-32.74342396916751
	 	 $w-$l: -34.045905964843705 -> 31.729935285876316  _ @double@	 lift : 65.77584125072002 : good	 :) hit 

[Prob_ROI diff: -0.1288600489160565 (up%-> -13.299978044484611) . o: 0.9688741476493917 -> a: 0.8400140987333352	 returnMoney: o:0.13272501118896565 a: 0.23014522768240986 (probReturnRate: 1.7340004391089734	 totalSpendMoney: o: 0.13698890770382605 a: 0.27397781540744126 (probTotalSpendRate: 1.999999999998461

[Time_ROI diff: 0.6577584125072001 (up%-> 99.72973204007431) . o: 0.659540940351563 -> a: 1.317299352858763	 returnMoney: o:3.725448E8 a: 1.1847E7 (timeReturnRate: 0.0318002022843964	 totalSpendMoney: o: 5.648547E8 a: 8993400.0 (timeTotalSpendRate: 0.015921616656460504

[[Per_Prob_ROI diff: 0.06402315979613238 (up%-> 10790.856604104354) . o: 5.933093372010973E-4 -> a: 0.06461646913333348	 per returnMoney: o:8.127679803365931E-5 a: 0.017703479052493067	 per totalSpendMoney: o: 8.388787979413719E-5 a: 0.021075216569803174

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.16842874012622752

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.03956869121017101     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.8670002195551538 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Nine9, 	playerStartValue=4	@@@ 

net money diff:  -0.04659635310048839 , up % -> -294.16473325416115 .  o: -0.01584022414414603 -> a: -0.06243657724463442 (anet/onet: 3.9416473325416113

[ProbMatrix: total: o: 4.566296923456785E-4  -> a: 4.566296923457446E-4
org->adv	$w:39.144395969368425->35.67871235725188  	$d:10.14806443904528->5.8536581785453565  	$l:50.707539591586304->58.46762946420275
	 improve value x$w(high is good):-3.4656836121165426  	x$d:-4.294406260499923  	 x$l(negative is good):7.760089872616447
	 	 $w-$l: -11.563143622217881 -> -22.78891710695087  _ #Surrender#	 lift : -11.225773484732986 : bad	 :| stand

[TimeMatrix: total:  o: 2436961.0 -> a: 9997.0
org->adv	$w:31.287492906123653->64.19925977793338  	$d:3.5522932045280986->3.2509752925877766  	$l:65.16021388934826->32.54976492947884
	 improve value x$w(high is good):32.911766871809725  	x$d:-0.301317911940322  	 x$l(negative is good):-32.610448959869416
	 	 $w-$l: -33.872720983224596 -> 31.64949484845454  _ @double@	 lift : 65.52221583167915 : good	 :) hit 

[Prob_ROI diff: -0.11225773484831947 (up%-> -12.693546497023009) . o: 0.8843685637788229 -> a: 0.7721108289305034	 returnMoney: o:0.12114868355952742 a: 0.21154123816281162 (probReturnRate: 1.7461290700601717	 totalSpendMoney: o: 0.13698890770367345 a: 0.27397781540744603 (probTotalSpendRate: 2.000000000000724

[Time_ROI diff: 0.6552221583167914 (up%-> 99.08500214420927) . o: 0.661272790167754 -> a: 1.3164949484845454	 returnMoney: o:4.834488E8 a: 7896600.0 (timeReturnRate: 0.016333890993213758	 totalSpendMoney: o: 7.310883E8 a: 5998200.0 (timeTotalSpendRate: 0.008204480908804039

[[Per_Prob_ROI diff: 0.05911407203319758 (up%-> 21182.62701161031) . o: 2.790686537642231E-4 -> a: 0.059393140686961804	 per returnMoney: o:3.8229310053495556E-5 a: 0.016272402935600894	 per totalSpendMoney: o: 4.3227802998950284E-5 a: 0.021075216569803542

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.15885408794880784

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.04659635310048839     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.8730645350297699 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Ten, 	playerStartValue=4	@@@ 

net money diff:  -0.053141243950711195 , up % -> -170.9978376262606 .  o: -0.031077143833162804 -> a: -0.084218387783874 (anet/onet: 2.709978376262606

[ProbMatrix: total: o: 4.5662969234568096E-4  -> a: 4.566296923457447E-4
org->adv	$w:33.352145942823334->31.599992630807233  	$d:10.609824743059226->6.060888047185362  	$l:56.038029314117445->62.3391193220074
	 improve value x$w(high is good):-1.7521533120161017  	x$d:-4.548936695873865  	 x$l(negative is good):6.301090007889954
	 	 $w-$l: -22.685883371294107 -> -30.739126691200163  _ #Surrender#	 lift : -8.053243319906056 : bad	 :| stand

[TimeMatrix: total:  o: 1220065.0 -> a: 5005.0
org->adv	$w:31.246859798453364->64.11588411588411  	$d:3.5584989324339276->3.2567432567432566  	$l:65.19464126911271->32.62737262737262
	 improve value x$w(high is good):32.86902431743075  	x$d:-0.30175567569067097  	 x$l(negative is good):-32.567268641740085
	 	 $w-$l: -33.94778147065934 -> 31.488511488511488  _ @double@	 lift : 65.43629295917084 : good	 :) hit 

[Prob_ROI diff: -0.08053243319983583 (up%-> -10.416265064050787) . o: 0.7731411662878472 -> a: 0.6926087330880114	 returnMoney: o:0.10591176387053582 a: 0.1897594276235727 (probReturnRate: 1.7916746987193075	 totalSpendMoney: o: 0.13698890770369862 a: 0.2739778154074467 (probTotalSpendRate: 2.000000000000361

[Time_ROI diff: 0.6543629295917084 (up%-> 99.06751721004464) . o: 0.6605221852934064 -> a: 1.3148851148851148	 returnMoney: o:2.41764E8 a: 3948600.0 (timeReturnRate: 0.016332456445128308	 totalSpendMoney: o: 3.660195E8 a: 3003000.0 (timeTotalSpendRate: 0.008204480908804039

[[Per_Prob_ROI diff: 0.05303362477836167 (up%-> 21737.758154770996) . o: 2.4397007456227433E-4 -> a: 0.053277594852923944	 per returnMoney: o:3.342119402667587E-5 a: 0.01459687904796713	 per totalSpendMoney: o: 4.3227802998958225E-5 a: 0.021075216569803594

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.133673677150547

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.053141243950711195     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.895837349359492 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=One1, 	playerStartValue=5	@@@ 

net money diff:  -0.08552525971209769 , up % -> -163.12437650647323 .  o: -0.05242947837946453 -> a: -0.13795473809156222 (anet/onet: 2.631243765064732

[ProbMatrix: total: o: 4.5662969234496305E-4  -> a: 4.56629692345614E-4
org->adv	$w:25.226209083014233->21.479151084948576  	$d:11.274790802460476->6.689176445732276  	$l:63.499000114525295->71.83167246931916
	 improve value x$w(high is good):-3.7470579980656566  	x$d:-4.5856143567282  	 x$l(negative is good):8.332672354793864
	 	 $w-$l: -38.27279103151106 -> -50.352521384370576  _ #Surrender#	 lift : -12.079730352859514 : bad	 :| stand

[TimeMatrix: total:  o: 2.2350757E7 -> a: 184717.0
org->adv	$w:31.46569934969093->64.72495763790013  	$d:3.503313109260684->3.2065267409063596  	$l:65.03098754104839->32.0685156211935
	 improve value x$w(high is good):33.2592582882092  	x$d:-0.29678636835432437  	 x$l(negative is good):-32.96247191985489
	 	 $w-$l: -33.56528819135746 -> 32.65644201670664  _ @double@	 lift : 66.2217302080641 : good	 :) hit 

[Prob_ROI diff: -0.12079730354193535 (up%-> -19.56953919640636) . o: 0.617272089698044 -> a: 0.4964747861561087	 returnMoney: o:0.08455942932287659 a: 0.13602307731597474 (probReturnRate: 1.6086092160886336	 totalSpendMoney: o: 0.13698890770234112 a: 0.27397781540753696 (probTotalSpendRate: 2.000000000020839

[Time_ROI diff: 0.6622173020806409 (up%-> 99.6794121705654) . o: 0.6643471180864254 -> a: 1.3265644201670663	 returnMoney: o:4.4545983E9 a: 1.470234E8 (timeReturnRate: 0.03300486151579594	 totalSpendMoney: o: 6.7052271E9 a: 1.108302E8 (timeTotalSpendRate: 0.01652892561983471

[[Per_Prob_ROI diff: 0.03779795107132302 (up%-> 9632.085757234832) . o: 3.924170945314965E-4 -> a: 0.03819036816585452	 per returnMoney: o:5.3756789143596056E-5 a: 0.010463313639690365	 per totalSpendMoney: o: 8.708767177516918E-5 a: 0.021075216569810536

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=true]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.20632256325403303

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.08552525971209769     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.8043046080359364 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Two2, 	playerStartValue=5	@@@ 

net money diff:  -0.007263903887542195 , up % -> -215.93061529928116 .  o: -0.0033639990686241406 -> a: -0.010627902956166335 (anet/onet: 3.1593061529928117

[ProbMatrix: total: o: 4.5662969234450373E-4  -> a: 4.56629692345792E-4
org->adv	$w:46.32093479643082->45.59950236508297  	$d:4.902457809106037->4.921884495738351  	$l:48.77660739446314->49.478613139178684
	 improve value x$w(high is good):-0.72143243134785  	x$d:0.01942668663231384  	 x$l(negative is good):0.7020057447155423
	 	 $w-$l: -2.4556725980323213 -> -3.8791107740957176  _ #Surrender#	 lift : -1.4234381760633963 : bad	 :| stand

[TimeMatrix: total:  o: 1307761.0 -> a: 346957.0
org->adv	$w:55.33404039423105->64.40250520957929  	$d:3.7728606373794595->3.233830128805587  	$l:40.89309896838949->32.363664661615125
	 improve value x$w(high is good):9.068464815348236  	x$d:-0.5390305085738727  	 x$l(negative is good):-8.529434306774363
	 	 $w-$l: 14.440941425841569 -> 32.038840547964156  _ @double@	 lift : 17.59789912212259 : good	 :) hit 

[Prob_ROI diff: -0.014234381762314063 (up%-> -1.459273147031357) . o: 0.975443274021145 -> a: 0.9612088922588309	 returnMoney: o:0.13362490863514592 a: 0.26334991245143347 (probReturnRate: 1.970814537059802	 totalSpendMoney: o: 0.13698890770377006 a: 0.2739778154075998 (probTotalSpendRate: 2.0000000000004357

[Time_ROI diff: 0.17597899122122573 (up%-> 15.3772757396671) . o: 1.1444094142584158 -> a: 1.3203884054796415	 returnMoney: o:4.489842E8 a: 2.748708E8 (timeReturnRate: 0.6122059529043561	 totalSpendMoney: o: 3.923283E8 a: 2.081742E8 (timeTotalSpendRate: 0.5306122448979592

[[Per_Prob_ROI diff: 0.05403213996610334 (up%-> 271.4227396765741) . o: 0.019907005592268268 -> a: 0.07393914555837161	 per returnMoney: o:0.002727038951737672 a: 0.02025768557318719	 per totalSpendMoney: o: 0.002795691993954491 a: 0.02107521656981537

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.021498285649856258

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.007263903887542195     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9854072685296864 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Three3, 	playerStartValue=5	@@@ 

net money diff:  -0.0024762351520457027 , up % -> -293.7467409742861 .  o: 8.429830213035339E-4 -> a: -0.0016332521307421688 (anet/onet: -1.937467409742861

[ProbMatrix: total: o: 4.566296923451476E-4  -> a: 4.5662969234581074E-4
org->adv	$w:47.93227661881795->47.3196600588397  	$d:4.750812659731793->4.76455419663465  	$l:47.31691072145026->47.91578574452566
	 improve value x$w(high is good):-0.6126165599782496  	x$d:0.013741536902857732  	 x$l(negative is good):0.5988750230753936
	 	 $w-$l: 0.6153658973676868 -> -0.5961256856859554  _ #Surrender#	 lift : -1.2114915830536421 : bad	 :| stand

[TimeMatrix: total:  o: 762097.0 -> a: 202189.0
org->adv	$w:55.317236519760606->64.38184075295887  	$d:3.7748475587753267->3.2355865056951663  	$l:40.90791592146407->32.38257274134597
	 improve value x$w(high is good):9.06460423319826  	x$d:-0.5392610530801605  	 x$l(negative is good):-8.5253431801181
	 	 $w-$l: 14.409320598296539 -> 31.999268011612898  _ @double@	 lift : 17.58994741331636 : good	 :) hit 

[Prob_ROI diff: -0.012114915831459183 (up%-> -1.2040820726932084) . o: 1.0061536589745388 -> a: 0.9940387431430796	 returnMoney: o:0.13783189072506527 a: 0.2723445632767808 (probReturnRate: 1.975918358546132	 totalSpendMoney: o: 0.13698890770376174 a: 0.273977815407523 (probTotalSpendRate: 1.9999999999999964

[Time_ROI diff: 0.17589947413316365 (up%-> 15.37457553399567) . o: 1.1440932059829654 -> a: 1.319992680116129	 returnMoney: o:2.61573E8 a: 1.601328E8 (timeReturnRate: 0.612191625282426	 totalSpendMoney: o: 2.286291E8 a: 1.213134E8 (timeTotalSpendRate: 0.5306122448979592

[[Per_Prob_ROI diff: 0.055930770560976284 (up%-> 272.38461372600244) . o: 0.02053374814233753 -> a: 0.07646451870331382	 per returnMoney: o:0.0028128957290829647 a: 0.0209495817905216	 per totalSpendMoney: o: 0.002795691993954321 a: 0.02107521656980946

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.014591150983504886

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.0024762351520457027     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9879591792730678 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Four4, 	playerStartValue=5	@@@ 

net money diff:  0.002491607373428406 , up % -> 46.8599077481889 .  o: 0.005317141012776971 -> a: 0.0078087483862053775 (anet/onet: 1.4685990774818891

[ProbMatrix: total: o: 4.5662969234553145E-4  -> a: 4.5662969234580434E-4
org->adv	$w:49.84136045276907->49.12535000826196  	$d:4.198718184588329->4.599438917019405  	$l:45.95992136264261->46.27521107471864
	 improve value x$w(high is good):-0.7160104445071056  	x$d:0.4007207324310764  	 x$l(negative is good):0.31528971207603007
	 	 $w-$l: 3.8814390901264595 -> 2.8501389335433167  _ #Surrender#	 lift : -1.0313001565831426 : bad	 :| stand

[TimeMatrix: total:  o: 226825.0 -> a: 117949.0
org->adv	$w:64.62206546897387->64.36425912894556  	$d:4.034828612366362->3.2369922593663363  	$l:31.34310591865976->32.398748611688106
	 improve value x$w(high is good):-0.25780634002830993  	x$d:-0.7978363530000259  	 x$l(negative is good):1.0556426930283465
	 	 $w-$l: 33.27895955031412 -> 31.96551051725745  _ @double@	 lift : -1.3134490330566684 : bad	 :| stand

[Prob_ROI diff: -0.010313001566014224 (up%-> -0.9927665284906902) . o: 1.038814390901469 -> a: 1.0285013893354549	 returnMoney: o:0.14230604871648417 a: 0.28178656379366473 (probReturnRate: 1.980144669430511	 totalSpendMoney: o: 0.1369889077037072 a: 0.27397781540745936 (probTotalSpendRate: 2.000000000000328

[Time_ROI diff: -0.013134490330566573 (up%-> -0.9854886603919033) . o: 1.3327895955031412 -> a: 1.3196551051725747	 returnMoney: o:9.0693E7 a: 9.33912E7 (timeReturnRate: 1.0297509179319242	 totalSpendMoney: o: 6.80475E7 a: 7.07694E7 (timeTotalSpendRate: 1.04

[[Per_Prob_ROI diff: 0.037562915851283914 (up%-> 90.39852590674867) . o: 0.04155257563605876 -> a: 0.07911549148734268	 per returnMoney: o:0.005692241948659367 a: 0.021675889522589593	 per totalSpendMoney: o: 0.005479556308148288 a: 0.021075216569804565

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.007821394192585818

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.002491607373428406     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.990072334715093 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Five5, 	playerStartValue=5	@@@ 

net money diff:  0.007398636618991511 , up % -> 72.7970231759283 .  o: 0.010163377973727378 -> a: 0.01756201459271889 (anet/onet: 1.7279702317592829

[ProbMatrix: total: o: 4.5662969234562794E-4  -> a: 4.566296923457803E-4
org->adv	$w:51.67733774204402->50.990737530581306  	$d:4.0644492786975635->4.428538306737567  	$l:44.258212979258424->44.58072416268112
	 improve value x$w(high is good):-0.6866002114627108  	x$d:0.364089028040004  	 x$l(negative is good):0.3225111834226979
	 	 $w-$l: 7.419124762785589 -> 6.410013367900186  _ @double@	 lift : -1.0091113948854036 : bad	 :| stand

[TimeMatrix: total:  o: 136825.0 -> a: 71149.0
org->adv	$w:64.60880687008952->64.35086930244978  	$d:4.037273890005482->3.2382746068110584  	$l:31.353919239904986->32.41085609073915
	 improve value x$w(high is good):-0.2579375676397433  	x$d:-0.7989992831944233  	 x$l(negative is good):1.056936850834166
	 	 $w-$l: 33.25488763018454 -> 31.94001321171063  _ @double@	 lift : -1.3148744184739103 : bad	 :| stand

[Prob_ROI diff: -0.010091113948861308 (up%-> -0.9394150223384139) . o: 1.074191247627941 -> a: 1.0641001336790796	 returnMoney: o:0.14715228567744115 a: 0.29153983000015576 (probReturnRate: 1.981211699553299	 totalSpendMoney: o: 0.13698890770371377 a: 0.2739778154074369 (probTotalSpendRate: 2.000000000000068

[Time_ROI diff: -0.013148744184739103 (up%-> -0.9867363530582187) . o: 1.3325488763018454 -> a: 1.3194001321171063	 returnMoney: o:5.46978E7 a: 5.63244E7 (timeReturnRate: 1.0297379419281945	 totalSpendMoney: o: 4.10475E7 a: 4.26894E7 (timeTotalSpendRate: 1.04

[[Per_Prob_ROI diff: 0.03888620653173463 (up%-> 90.50112495704148) . o: 0.04296764990511764 -> a: 0.08185385643685227	 per returnMoney: o:0.005886091427097646 a: 0.02242614076924275	 per totalSpendMoney: o: 0.005479556308148551 a: 0.021075216569802838

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.002692477329869797

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.007398636618991511     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9906058497766158 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Six6, 	playerStartValue=5	@@@ 

net money diff:  0.01074605898671488 , up % -> 81.98120198552044 .  o: 0.013107954904848618 -> a: 0.023854013891563497 (anet/onet: 1.8198120198552044

[ProbMatrix: total: o: 4.5662969234568454E-4  -> a: 4.56629692345767E-4
org->adv	$w:52.90030325424936->52.161529659622694  	$d:3.7680185171088483->4.383490098296944  	$l:43.3316782286418->43.45498024208036
	 improve value x$w(high is good):-0.7387735946266645  	x$d:0.6154715811880958  	 x$l(negative is good):0.12330201343856118
	 	 $w-$l: 9.568625025607563 -> 8.706549417542336  _ @double@	 lift : -0.862075608065227 : bad	 :| stand

[TimeMatrix: total:  o: 77725.0 -> a: 40417.0
org->adv	$w:64.59697651978128->64.33926318133459  	$d:4.0347378578321->3.2387361753717494  	$l:31.368285622386622->32.422000643293664
	 improve value x$w(high is good):-0.25771333844669186  	x$d:-0.7960016824603509  	 x$l(negative is good):1.0537150209070418
	 	 $w-$l: 33.22869089739466 -> 31.91726253804092  _ @double@	 lift : -1.311428359353739 : bad	 :| stand

[Prob_ROI diff: -0.008620756080638392 (up%-> -0.7867905687986303) . o: 1.0956862502561049 -> a: 1.0870654941754665	 returnMoney: o:0.15009686260856878 a: 0.29783182929900326 (probReturnRate: 1.9842641886240235	 totalSpendMoney: o: 0.13698890770372016 a: 0.27397781540743976 (probTotalSpendRate: 1.999999999999996

[Time_ROI diff: -0.01311428359353739 (up%-> -0.9843438005134557) . o: 1.3322869089739466 -> a: 1.3191726253804092	 returnMoney: o:3.10656E7 a: 3.19902E7 (timeReturnRate: 1.0297628244746602	 totalSpendMoney: o: 2.33175E7 a: 2.42502E7 (timeTotalSpendRate: 1.04

[[Per_Prob_ROI diff: 0.039792972618637845 (up%-> 90.7946335215411) . o: 0.0438274500102442 -> a: 0.08362042262888204	 per returnMoney: o:0.006003874504342751 a: 0.022910140715307944	 per totalSpendMoney: o: 0.005479556308148806 a: 0.02107521656980306

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.002125302906076487

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.01074605898671488     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9921320943120138 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Seven7, 	playerStartValue=5	@@@ 

net money diff:  -0.024759862415924788 , up % -> -1765.5119207515486 .  o: -0.001402418308531439 -> a: -0.026162280724456227 (anet/onet: 18.655119207515487

[ProbMatrix: total: o: 4.5662969234547664E-4  -> a: 4.566296923457575E-4
org->adv	$w:45.52965623277814->42.439906872223695  	$d:7.916941647303549->5.571135473625739  	$l:46.55340211991831->51.98895765415057
	 improve value x$w(high is good):-3.0897493605544426  	x$d:-2.3458061736778104  	 x$l(negative is good):5.4355555342322575
	 	 $w-$l: -1.0237458871401706 -> -9.549050781926876  _ #Surrender#	 lift : -8.525304894786705 : bad	 :| stand

[TimeMatrix: total:  o: 1546405.0 -> a: 24973.0
org->adv	$w:31.199847387974046->64.26140231449966  	$d:3.5348437181721475->3.247507307892524  	$l:65.26530889385381->32.49109037760782
	 improve value x$w(high is good):33.061554926525616  	x$d:-0.2873364102796234  	 x$l(negative is good):-32.774218516245995
	 	 $w-$l: -34.06546150587977 -> 31.770311936891844  _ @double@	 lift : 65.83577344277161 : good	 :) hit 

[Prob_ROI diff: -0.08525304894726704 (up%-> -8.613485094121948) . o: 0.9897625411280481 -> a: 0.904509492180781	 returnMoney: o:0.1355864893952854 a: 0.24781553468297887 (probReturnRate: 1.8277302981162362	 totalSpendMoney: o: 0.13698890770381683 a: 0.2739778154074351 (probTotalSpendRate: 1.9999999999985505

[Time_ROI diff: 0.6583577344277161 (up%-> 99.8502074123755) . o: 0.6593453849412023 -> a: 1.3177031193689184	 returnMoney: o:3.058845E8 a: 1.97442E7 (timeReturnRate: 0.06454789307728898	 totalSpendMoney: o: 4.639215E8 a: 1.49838E7 (timeTotalSpendRate: 0.03229813664596273

[[Per_Prob_ROI diff: 0.06834813456004436 (up%-> 5558.934192248604) . o: 0.0012295186846311157 -> a: 0.06957765324467548	 per returnMoney: o:1.6843042160905017E-4 a: 0.019062733437152223	 per totalSpendMoney: o: 1.7017255615380973E-4 a: 0.0210752165698027

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.11001291136319183

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.024759862415924788     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9138651490587805 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Eight8, 	playerStartValue=5	@@@ 

net money diff:  -0.03434029057220975 , up % -> -346.7396302424389 .  o: -0.009903768585148215 -> a: -0.04424405915735796 (anet/onet: 4.4673963024243895

[ProbMatrix: total: o: 4.5662969234564843E-4  -> a: 4.566296923457479E-4
org->adv	$w:41.57149482261442->39.029974069593926  	$d:9.627396839981905->5.7912775187846695  	$l:48.80110833740368->55.178748411621406
	 improve value x$w(high is good):-2.5415207530204924  	x$d:-3.836119321197236  	 x$l(negative is good):6.377640074217723
	 	 $w-$l: -7.229613514789262 -> -16.148774342027476  _ #Surrender#	 lift : -8.919160827238215 : bad	 :| stand

[TimeMatrix: total:  o: 928165.0 -> a: 14989.0
org->adv	$w:31.19046721218749->64.24044299152712  	$d:3.5361169619625823->3.249049302822069  	$l:65.27341582584994->32.51050770565081
	 improve value x$w(high is good):33.04997577933963  	x$d:-0.28706765914051324  	 x$l(negative is good):-32.76290812019913
	 	 $w-$l: -34.082948613662445 -> 31.729935285876316  _ @double@	 lift : 65.81288389953876 : good	 :) hit 

[Prob_ROI diff: -0.08919160827211947 (up%-> -9.614232693356433) . o: 0.927703864851868 -> a: 0.8385122565797485	 returnMoney: o:0.12708513911864217 a: 0.22973375625008363 (probReturnRate: 1.807715346131953	 totalSpendMoney: o: 0.13698890770379038 a: 0.2739778154074416 (probTotalSpendRate: 1.9999999999989841

[Time_ROI diff: 0.6581288389953875 (up%-> 99.84197186523367) . o: 0.6591705138633756 -> a: 1.317299352858763	 returnMoney: o:1.835457E8 a: 1.1847E7 (timeReturnRate: 0.06454523314901957	 totalSpendMoney: o: 2.784495E8 a: 8993400.0 (timeTotalSpendRate: 0.03229813664596273

[[Per_Prob_ROI diff: 0.06334851565252014 (up%-> 5496.964821680622) . o: 0.0011524271613066682 -> a: 0.06450094281382682	 per returnMoney: o:1.5786973803558034E-4 a: 0.017671827403852588	 per totalSpendMoney: o: 1.7017255615377688E-4 a: 0.0210752165698032

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.12353189884432922

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.03434029057220975     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9038576730664356 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Nine9, 	playerStartValue=5	@@@ 

net money diff:  -0.041923968365482164 , up % -> -197.78746919195027 .  o: -0.021196473435228333 -> a: -0.0631204418007105 (anet/onet: 2.977874691919503

[ProbMatrix: total: o: 4.566296923457263E-4  -> a: 4.5662969234574373E-4
org->adv	$w:37.33582257860278->35.526382486420864  	$d:9.855223630438912->5.908712106298985  	$l:52.8089537909583->58.56490540728016
	 improve value x$w(high is good):-1.8094400921819158  	x$d:-3.946511524139927  	 x$l(negative is good):5.755951616321859
	 	 $w-$l: -15.473131212355524 -> -23.03852292085929  _ #Surrender#	 lift : -7.565391708503766 : bad	 :| stand

[TimeMatrix: total:  o: 1209637.0 -> a: 9997.0
org->adv	$w:31.279301145715614->64.19925977793338  	$d:3.5513959973115905->3.2509752925877766  	$l:65.1693028569728->32.54976492947884
	 improve value x$w(high is good):32.919958632217764  	x$d:-0.3004207047238139  	 x$l(negative is good):-32.619537927493965
	 	 $w-$l: -33.890001711257185 -> 31.64949484845454  _ @double@	 lift : 65.53949655971172 : good	 :) hit 

[Prob_ROI diff: -0.07565391708603952 (up%-> -8.950280327550399) . o: 0.8452686878774582 -> a: 0.7696147707914187	 returnMoney: o:0.11579243426847856 a: 0.2108573736067341 (probReturnRate: 1.8209943934491968	 totalSpendMoney: o: 0.1369889077037069 a: 0.2739778154074446 (probTotalSpendRate: 2.0000000000002247

[Time_ROI diff: 0.6553949655971172 (up%-> 99.13704168234982) . o: 0.6610999828874282 -> a: 1.3164949484845454	 returnMoney: o:2.399073E8 a: 7896600.0 (timeReturnRate: 0.032915213501214846	 totalSpendMoney: o: 3.628911E8 a: 5998200.0 (timeTotalSpendRate: 0.01652892561983471

[[Per_Prob_ROI diff: 0.05866377531969752 (up%-> 10917.0160803664) . o: 5.373608950269919E-4 -> a: 0.05920113621472451	 per returnMoney: o:7.361248205243393E-5 a: 0.016219797969748775	 per totalSpendMoney: o: 8.708767177603744E-5 a: 0.02107521656980343

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.11757788545152169

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.041923968365482164     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9104971967244961 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Ten, 	playerStartValue=5	@@@ 

net money diff:  -0.049193301996484404 , up % -> -136.9412873666234 .  o: -0.03592291480711919 -> a: -0.0851162168036036 (anet/onet: 2.369412873666234

[ProbMatrix: total: o: 4.5662969234568063E-4  -> a: 4.566296923457448E-4
org->adv	$w:31.80542976721265->31.4541995646773  	$d:10.165911585696898->6.024772822167566  	$l:58.02865864709046->62.521027613155134
	 improve value x$w(high is good):-0.3512302025353513  	x$d:-4.141138763529333  	 x$l(negative is good):4.492368966064674
	 	 $w-$l: -26.22322887987781 -> -31.066828048477834  _ #Surrender#	 lift : -4.843599168600027 : bad	 :| stand

[TimeMatrix: total:  o: 605605.0 -> a: 5005.0
org->adv	$w:31.2386786766952->64.11588411588411  	$d:3.55759942536802->3.2567432567432566  	$l:65.20372189793677->32.62737262737262
	 improve value x$w(high is good):32.87720543918891  	x$d:-0.3008561686247635  	 x$l(negative is good):-32.57634927056415
	 	 $w-$l: -33.96504322124157 -> 31.488511488511488  _ @double@	 lift : 65.45355470975306 : good	 :) hit 

[Prob_ROI diff: -0.048435991686500035 (up%-> -6.565208933798912) . o: 0.7377677112017346 -> a: 0.6893317195152345	 returnMoney: o:0.10106599289659456 a: 0.18886159860384194 (probReturnRate: 1.8686958213241447	 totalSpendMoney: o: 0.13698890770371375 a: 0.27397781540744554 (probTotalSpendRate: 2.000000000000132

[Time_ROI diff: 0.6545355470975305 (up%-> 99.11955410078741) . o: 0.6603495677875844 -> a: 1.3148851148851148	 returnMoney: o:1.199733E8 a: 3948600.0 (timeReturnRate: 0.03291232299186569	 totalSpendMoney: o: 1.816815E8 a: 3003000.0 (timeTotalSpendRate: 0.01652892561983471

[[Per_Prob_ROI diff: 0.05255649736181922 (up%-> 11205.60971901033) . o: 4.690195239680449E-4 -> a: 0.053025516885787265	 per returnMoney: o:6.425047228009825E-5 a: 0.01452781527721861	 per totalSpendMoney: o: 8.708767177604179E-5 a: 0.021075216569803504

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.09762929368298444

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.049193301996484404     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9343479106620107 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.



		 */
	}
	
	public static void testA6vsAll() {
		StrategyMatrix8012 o = new Myth2019April22();
		StrategyMatrix8012 t = new MirMyth2019April22();
		
		System.out.println(t.diffWith(o));
		
		for(Card playerCard : Card.values()) {
			if(playerCard.getValue() == 6) {
				for(Card dealerCard : Card.values()) {
					if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
					PlayerCardsPathValue nine = new PlayerCardsPathValue(Card.One1,playerCard);
					Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, nine, dealerCard); 
//					HelloWorld.print(origin);
					PlayerCardsPathValue ninet = new PlayerCardsPathValue(Card.One1,playerCard);
					Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, ninet, dealerCard); 
//					HelloWorld.print(advanced);
					
					DealerVSPlayerResult9102 result = new DealerVSPlayerResult9102(dealerCard, playerCard.getValue(), RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), origin),RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), advanced));
					
					System.out.println(result);
					System.out.println();
					System.out.println("--------------------------");
				}
			}
		}
		/**

MatrixKey [startValue=Six, dealerCard=One1, situation=Start_With_A] : Stand -> Hit
MatrixKey [startValue=Six, dealerCard=One1, situation=A_Three_More_Cards] : Stand -> Hit
MatrixKey [startValue=Six, dealerCard=Two2, situation=Start_With_A] : Stand -> Hit
MatrixKey [startValue=Six, dealerCard=Two2, situation=A_Three_More_Cards] : Stand -> Hit
MatrixKey [startValue=Six, dealerCard=Three3, situation=A_Three_More_Cards] : Stand -> Hit
MatrixKey [startValue=Six, dealerCard=Three3, situation=Start_With_A] : Stand -> Hit
MatrixKey [startValue=Six, dealerCard=Four4, situation=A_Three_More_Cards] : Stand -> Hit
MatrixKey [startValue=Six, dealerCard=Four4, situation=Start_With_A] : Stand -> Hit
MatrixKey [startValue=Six, dealerCard=Five5, situation=Start_With_A] : Stand -> Hit
MatrixKey [startValue=Six, dealerCard=Five5, situation=A_Three_More_Cards] : Stand -> Hit
MatrixKey [startValue=Six, dealerCard=Six6, situation=Start_With_A] : Stand -> Hit
MatrixKey [startValue=Six, dealerCard=Six6, situation=A_Three_More_Cards] : Stand -> Hit
MatrixKey [startValue=Six, dealerCard=Seven7, situation=Start_With_A] : Stand -> Hit
MatrixKey [startValue=Six, dealerCard=Seven7, situation=A_Three_More_Cards] : Stand -> Hit
MatrixKey [startValue=Six, dealerCard=Eight8, situation=A_Three_More_Cards] : Stand -> Hit
MatrixKey [startValue=Six, dealerCard=Eight8, situation=Start_With_A] : Stand -> Hit
MatrixKey [startValue=Six, dealerCard=Nine9, situation=A_Three_More_Cards] : Stand -> Hit
MatrixKey [startValue=Six, dealerCard=Nine9, situation=Start_With_A] : Stand -> Hit
MatrixKey [startValue=Six, dealerCard=Ten, situation=Start_With_A] : Stand -> Hit
MatrixKey [startValue=Six, dealerCard=Ten, situation=A_Three_More_Cards] : Stand -> Hit


		 @@@   dealerCard=One1, 	playerStartValue=6	@@@ 

net money diff:  0.03324343208349155 , up % -> 37.97468236552686 .  o: -0.08754104053723355 -> a: -0.054297608453742 (anet/onet: 0.6202531763447314

[ProbMatrix: total: o: 4.566296923457464E-4  -> a: 4.5662969234479294E-4
org->adv	$w:11.547296587963425->23.764342225000227  	$d:13.00166307967755->12.834815511901567  	$l:75.45104033235901->63.4008422630982
	 improve value x$w(high is good):12.217045637036803  	x$d:-0.1668475677759833  	 x$l(negative is good):-12.050198069260816
	 	 $w-$l: -63.90374374439559 -> -39.63650003809798  _ #Surrender#	 lift : 24.267243706297613 : good	 :) hit 

[TimeMatrix: total:  o: 14209.0 -> a: 1.0926721E7
org->adv	$w:58.315152368217326->31.60214303998427  	$d:8.332746850587656->3.5233991972523135  	$l:33.35210078119501->64.87445776276341
	 improve value x$w(high is good):-26.713009328233056  	x$d:-4.809347653335342  	 x$l(negative is good):31.5223569815684
	 	 $w-$l: 24.96305158702231 -> -33.27231472277914  _ #Surrender#	 lift : -58.235366309801464 : bad	 :| stand

[Prob_ROI diff: 0.24267243706599373 (up%-> 67.22925373412218) . o: 0.3609625625560461 -> a: 0.6036349996220398	 returnMoney: o:0.049447867166489586 a: 0.08269129924992923 (probReturnRate: 1.6722925373405881	 totalSpendMoney: o: 0.13698890770372313 a: 0.13698890770367123 (probTotalSpendRate: 0.9999999999996211

[Time_ROI diff: -0.5823536630980144 (up%-> -46.602068027481906) . o: 1.249630515870223 -> a: 0.6672768527722086	 returnMoney: o:5326800.0 a: 2.1873444E9 (timeReturnRate: 410.6300968686641	 totalSpendMoney: o: 4262700.0 a: 3.2780163E9 (timeTotalSpendRate: 769.0

[[Per_Prob_ROI diff: -0.3601776015682411 (up%-> -99.782536731165) . o: 0.3609625625560461 -> a: 7.849609878049932E-4	 per returnMoney: o:0.049447867166489586 a: 1.0753094830940081E-4	 per totalSpendMoney: o: 0.13698890770372313 a: 1.7813902172128898E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.2759158691494853

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.03324343208349155     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.6722925373412219 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------

		 @@@   dealerCard=Two2, 	playerStartValue=6	@@@ 

net money diff:  0.020934017604355218 , up % -> 99.66037529279748 .  o: -0.021005356986517523 -> a: -7.13393821623054E-5 (anet/onet: 0.0033962470720252562

[ProbMatrix: total: o: 4.5662969234576206E-4  -> a: 4.5662969234561016E-4
org->adv	$w:35.35037055569638->45.680313634340244  	$d:13.965640029513235->8.58729597311136  	$l:50.683989414790375->45.7323903925484
	 improve value x$w(high is good):10.329943078643865  	x$d:-5.378344056401875  	 x$l(negative is good):-4.951599022241972
	 	 $w-$l: -15.333618859093995 -> -0.05207675820815827  _ #Surrender#	 lift : 15.281542100885837 : good	 :) hit 

[TimeMatrix: total:  o: 26689.0 -> a: 667225.0
org->adv	$w:57.960208325527375->55.386563752856986  	$d:8.355502266851513->4.365843605979991  	$l:33.684289407621115->40.247592641163024
	 improve value x$w(high is good):-2.573644572670389  	x$d:-3.9896586608715214  	 x$l(negative is good):6.563303233541909
	 	 $w-$l: 24.27591891790626 -> 15.13897111169396  _ @double@	 lift : -9.136947806212298 : bad	 :| stand

[Prob_ROI diff: 0.1528154210093392 (up%-> 18.04912634154101) . o: 0.8466638114091234 -> a: 0.9994792324184626	 returnMoney: o:0.11598355071721374 a: 0.13691756832152455 (probReturnRate: 1.1804912634150273	 totalSpendMoney: o: 0.13698890770373126 a: 0.13698890770368685 (probTotalSpendRate: 0.9999999999996758

[Time_ROI diff: -0.09136947806212303 (up%-> -7.352146647370964) . o: 1.2427591891790626 -> a: 1.1513897111169396	 returnMoney: o:9950400.0 a: 2.304708E8 (timeReturnRate: 23.16196333815726	 totalSpendMoney: o: 8006700.0 a: 2.001675E8 (timeTotalSpendRate: 25.0

[[Per_Prob_ROI diff: -0.8066846421123849 (up%-> -95.27803494633835) . o: 0.8466638114091234 -> a: 0.039979169296738504	 per returnMoney: o:0.11598355071721374 a: 0.005476702732860982	 per totalSpendMoney: o: 0.13698890770373126 a: 0.005479556308147474

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.1737494386136944

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.020934017604355218     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.18049126341541 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------

		 @@@   dealerCard=Three3, 	playerStartValue=6	@@@ 

net money diff:  0.02008562020831081 , up % -> 124.98054217953012 .  o: -0.01607099781937138 -> a: 0.004014622388939432 (anet/onet: -0.2498054217953011

[ProbMatrix: total: o: 4.566296923457587E-4  -> a: 4.5662969234573137E-4
org->adv	$w:37.41940971749524->47.31949022164736  	$d:13.429575365167034->8.291638141957865  	$l:49.151014917337726->44.388871636394775
	 improve value x$w(high is good):9.900080504152115  	x$d:-5.137937223209169  	 x$l(negative is good):-4.762143280942951
	 	 $w-$l: -11.731605199842482 -> 2.9306185852525815  _ #Surrender#	 lift : 14.662223785095064 : good	 :) hit 

[TimeMatrix: total:  o: 15553.0 -> a: 388825.0
org->adv	$w:57.937375425962834->55.36963929788465  	$d:8.358516041921172->4.368031890953514  	$l:33.70410853211599->40.26232881116184
	 improve value x$w(high is good):-2.567736128078181  	x$d:-3.9904841509676583  	 x$l(negative is good):6.558220279045848
	 	 $w-$l: 24.233266893846846 -> 15.107310486722819  _ @double@	 lift : -9.125956407124026 : bad	 :| stand

[Prob_ROI diff: 0.14662223785119788 (up%-> 16.610955504872095) . o: 0.8826839480016226 -> a: 1.0293061858528205	 returnMoney: o:0.12091790988435583 a: 0.1410035300926365 (probReturnRate: 1.1661095550484644	 totalSpendMoney: o: 0.1369889077037272 a: 0.13698890770369707 (probTotalSpendRate: 0.99999999999978

[Time_ROI diff: -0.09125956407124014 (up%-> -7.345823413725277) . o: 1.2423326689384684 -> a: 1.1510731048672282	 returnMoney: o:5796600.0 a: 1.342698E8 (timeReturnRate: 23.16354414656868	 totalSpendMoney: o: 4665900.0 a: 1.166475E8 (timeTotalSpendRate: 25.0

[[Per_Prob_ROI diff: -0.8415117005675098 (up%-> -95.33556177980512) . o: 0.8826839480016226 -> a: 0.04117224743411283	 per returnMoney: o:0.12091790988435583 a: 0.00564014120370546	 per totalSpendMoney: o: 0.1369889077037272 a: 0.005479556308147882

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.1667078580595087

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.02008562020831081     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.166109555048721 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------

		 @@@   dealerCard=Four4, 	playerStartValue=6	@@@ 

net money diff:  0.01909273038116996 , up % -> 179.06504887361302 .  o: -0.010662455069412186 -> a: 0.008430275311757773 (anet/onet: -0.7906504887361302

[ProbMatrix: total: o: 4.5662969234575186E-4  -> a: 4.566296923458108E-4
org->adv	$w:39.58049180346572->49.242051220378094  	$d:13.05557228204846->7.669881449664061  	$l:47.363935914485836->43.08806732995785
	 improve value x$w(high is good):9.661559416912375  	x$d:-5.3856908323844  	 x$l(negative is good):-4.275868584527984
	 	 $w-$l: -7.783444111020116 -> 6.153983890420239  _ @double@	 lift : 13.937428001440356 : good	 :) hit 

[TimeMatrix: total:  o: 9073.0 -> a: 117949.0
org->adv	$w:57.91910062823763->64.36425912894556  	$d:8.35445828281715->5.164944170785678  	$l:33.72644108894522->30.47079670026876
	 improve value x$w(high is good):6.445158500707933  	x$d:-3.189514112031472  	 x$l(negative is good):-3.255644388676462
	 	 $w-$l: 24.192659539292404 -> 33.8934624286768  _ @double@	 lift : 9.700802889384391 : good	 :) hit 

[Prob_ROI diff: 0.1393742800144283 (up%-> 15.113802361282856) . o: 0.9221655588898295 -> a: 1.0615398389042578	 returnMoney: o:0.12632645263431316 a: 0.14541918301548745 (probReturnRate: 1.151138023612865	 totalSpendMoney: o: 0.13698890770372535 a: 0.13698890770372968 (probTotalSpendRate: 1.0000000000000315

[Time_ROI diff: 0.09700802889384375 (up%-> 7.811091996395493) . o: 1.2419265953929242 -> a: 1.338934624286768	 returnMoney: o:3380400.0 a: 4.73778E7 (timeReturnRate: 14.015441959531417	 totalSpendMoney: o: 2721900.0 a: 3.53847E7 (timeTotalSpendRate: 13.0

[[Per_Prob_ROI diff: -0.8405086482048867 (up%-> -91.14509212605518) . o: 0.9221655588898295 -> a: 0.08165691068494291	 per returnMoney: o:0.12632645263431316 a: 0.011186091001191343	 per totalSpendMoney: o: 0.13698890770372535 a: 0.010537608284902283

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.15846701039559827

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.01909273038116996     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.1511380236128288 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------

		 @@@   dealerCard=Five5, 	playerStartValue=6	@@@ 

net money diff:  0.018679797051040725 , up % -> 329.81268729240827 .  o: -0.005663759391548034 -> a: 0.01301603765949269 (anet/onet: -2.2981268729240827

[ProbMatrix: total: o: 4.5662969234575105E-4  -> a: 4.56629692345784E-4
org->adv	$w:41.84059422952532->51.10422315112264  	$d:12.184345848442591->7.293080410875808  	$l:45.97505992203209->41.60269643800156
	 improve value x$w(high is good):9.263628921597316  	x$d:-4.8912654375667834  	 x$l(negative is good):-4.372363484030529
	 	 $w-$l: -4.134465692506762 -> 9.501526713121084  _ @double@	 lift : 13.635992405627844 : good	 :) hit 

[TimeMatrix: total:  o: 5473.0 -> a: 71149.0
org->adv	$w:57.90243011145624->64.35086930244978  	$d:8.368353736524758->5.169433161393695  	$l:33.729216152019006->30.479697536156518
	 improve value x$w(high is good):6.44843919099354  	x$d:-3.198920575131064  	 x$l(negative is good):-3.2495186158624882
	 	 $w-$l: 24.173213959437234 -> 33.871171766293266  _ @double@	 lift : 9.697957806856033 : good	 :) hit 

[Prob_ROI diff: 0.13635992405634323 (up%-> 14.224082204451081) . o: 0.9586553430749486 -> a: 1.0950152671312918	 returnMoney: o:0.13132514831217676 a: 0.15000494536321113 (probReturnRate: 1.1422408220444578	 totalSpendMoney: o: 0.1369889077037248 a: 0.13698890770371844 (probTotalSpendRate: 0.9999999999999536

[Time_ROI diff: 0.09697957806856028 (up%-> 7.810023996015751) . o: 1.2417321395943723 -> a: 1.3387117176629326	 returnMoney: o:2038800.0 a: 2.85744E7 (timeReturnRate: 14.015303119482049	 totalSpendMoney: o: 1641900.0 a: 2.13447E7 (timeTotalSpendRate: 13.0

[[Per_Prob_ROI diff: -0.8744233994494646 (up%-> -91.21353213811913) . o: 0.9586553430749486 -> a: 0.08423194362548399	 per returnMoney: o:0.13132514831217676 a: 0.01153884195101624	 per totalSpendMoney: o: 0.1369889077037248 a: 0.010537608284901419

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.15503972110738395

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.018679797051040725     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.1422408220445108 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------

		 @@@   dealerCard=Six6, 	playerStartValue=6	@@@ 

net money diff:  0.015985931920893065 , up % -> 1024.5560217472396 .  o: 0.0015602789483030177 -> a: 0.017546210869196083 (anet/onet: 11.245560217472395

[ProbMatrix: total: o: 4.566296923457474E-4  -> a: 4.566296923457676E-4
org->adv	$w:42.28416043620779->52.26287682254187  	$d:16.570661089303698->8.282736592053803  	$l:41.14517847448851->39.45438658540432
	 improve value x$w(high is good):9.978716386334078  	x$d:-8.287924497249895  	 x$l(negative is good):-1.6907918890841884
	 	 $w-$l: 1.138981961719282 -> 12.808490237137548  _ @double@	 lift : 11.669508275418266 : good	 :) hit 

[TimeMatrix: total:  o: 3109.0 -> a: 40417.0
org->adv	$w:57.896429720167255->64.33926318133459  	$d:8.330652943068511->5.1611945468490985  	$l:33.77291733676424->30.499542271816317
	 improve value x$w(high is good):6.442833461167332  	x$d:-3.1694583962194125  	 x$l(negative is good):-3.2733750649479205
	 	 $w-$l: 24.123512383403018 -> 33.83972090951827  _ @double@	 lift : 9.716208526115249 : good	 :) hit 

[Prob_ROI diff: 0.11669508275420037 (up%-> 11.538091494570107) . o: 1.0113898196172024 -> a: 1.1280849023714028	 returnMoney: o:0.13854918665202673 a: 0.15453511857291596 (probReturnRate: 1.11538091494567	 totalSpendMoney: o: 0.1369889077037237 a: 0.13698890770371988 (probTotalSpendRate: 0.999999999999972

[Time_ROI diff: 0.09716208526115255 (up%-> 7.827854964418847) . o: 1.2412351238340302 -> a: 1.3383972090951828	 returnMoney: o:1157700.0 a: 1.62282E7 (timeReturnRate: 14.017621145374449	 totalSpendMoney: o: 932700.0 a: 1.21251E7 (timeTotalSpendRate: 13.0

[[Per_Prob_ROI diff: -0.9246140578963253 (up%-> -91.42014680811) . o: 1.0113898196172024 -> a: 0.08677576172087714	 per returnMoney: o:0.13854918665202673 a: 0.011887316813301229	 per totalSpendMoney: o: 0.1369889077037237 a: 0.01053760828490153

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.13268101467509344

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.015985931920893065     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.1153809149457012 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------

		 @@@   dealerCard=Seven7, 	playerStartValue=6	@@@ 

net money diff:  0.02184575144351053 , up % -> 149.1489310867867 .  o: -0.014646937986299707 -> a: 0.007198813457210823 (anet/onet: -0.49148931086786674

[ProbMatrix: total: o: 4.5662969234574503E-4  -> a: 4.5662969234569624E-4
org->adv	$w:26.19356758682068->44.24371721790106  	$d:36.92080352605313->16.76759940448404  	$l:36.885628887126195->38.9886833776149
	 improve value x$w(high is good):18.050149631080377  	x$d:-20.153204121569086  	 x$l(negative is good):2.1030544904887023
	 	 $w-$l: -10.692061300305516 -> 5.255033840286161  _ @double@	 lift : 15.947095140591678 : good	 :) hit 

[TimeMatrix: total:  o: 1921.0 -> a: 739585.0
org->adv	$w:57.78240499739719->31.46440233374122  	$d:8.485163977095263->3.5751130701677294  	$l:33.732431025507545->64.96048459609105
	 improve value x$w(high is good):-26.318002663655967  	x$d:-4.910050906927534  	 x$l(negative is good):31.228053570583505
	 	 $w-$l: 24.04997397188964 -> -33.49608226234983  _ #Surrender#	 lift : -57.54605623423947 : bad	 :| stand

[Prob_ROI diff: 0.1594709514054481 (up%-> 17.856301883943466) . o: 0.8930793869969552 -> a: 1.0525503384024033	 returnMoney: o:0.12234196971742439 a: 0.1441877211610213 (probReturnRate: 1.1785630188401777	 totalSpendMoney: o: 0.1369889077037241 a: 0.13698890770381048 (probTotalSpendRate: 1.0000000000006306

[Time_ROI diff: -0.5754605623423947 (up%-> -46.38941419470165) . o: 1.2404997397188964 -> a: 0.6650391773765016	 returnMoney: o:714900.0 a: 1.475559E8 (timeReturnRate: 206.40075535039867	 totalSpendMoney: o: 576300.0 a: 2.218755E8 (timeTotalSpendRate: 385.0

[[Per_Prob_ROI diff: -0.8903454900140918 (up%-> -99.69387973536637) . o: 0.8930793869969552 -> a: 0.002733896982863385	 per returnMoney: o:0.12234196971742439 a: 3.7451356145719815E-4	 per totalSpendMoney: o: 0.1369889077037241 a: 3.5581534468522204E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.18131670284895862

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.02184575144351053     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.1785630188394345 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------

		 @@@   dealerCard=Eight8, 	playerStartValue=6	@@@ 

net money diff:  0.04233463932520953 , up % -> 80.54671844767391 .  o: -0.0525591112103613 -> a: -0.01022447188515177 (anet/onet: 0.1945328155232609

[ProbMatrix: total: o: 4.5662969234574503E-4  -> a: 4.5662969234588544E-4
org->adv	$w:24.369289795036387->40.604988278851636  	$d:12.893999214018809->11.326300972699272  	$l:62.73671099094481->48.06871074844909
	 improve value x$w(high is good):16.23569848381525  	x$d:-1.5676982413195368  	 x$l(negative is good):-14.668000242495715
	 	 $w-$l: -38.36742119590843 -> -7.463722469597456  _ #Surrender#	 lift : 30.903698726310967 : good	 :) hit 

[TimeMatrix: total:  o: 1153.0 -> a: 443905.0
org->adv	$w:57.7623590633131->31.45492841936901  	$d:8.326105810928015->3.5755398114461427  	$l:33.91153512575889->64.96953176918485
	 improve value x$w(high is good):-26.307430643944087  	x$d:-4.750565999481871  	 x$l(negative is good):31.057996643425966
	 	 $w-$l: 23.850823937554207 -> -33.51460334981584  _ #Surrender#	 lift : -57.36542728737004 : bad	 :| stand

[Prob_ROI diff: 0.3090369872630463 (up%-> 50.14182324665732) . o: 0.6163257880409208 -> a: 0.925362775303967	 returnMoney: o:0.08442979649336257 a: 0.12676443581863653 (probReturnRate: 1.5014182324672793	 totalSpendMoney: o: 0.13698890770372388 a: 0.1369889077037883 (probTotalSpendRate: 1.0000000000004703

[Time_ROI diff: -0.5736542728737004 (up%-> -46.318163629088) . o: 1.238508239375542 -> a: 0.6648539665018416	 returnMoney: o:428400.0 a: 8.85396E7 (timeReturnRate: 206.6750700280112	 totalSpendMoney: o: 345900.0 a: 1.331715E8 (timeTotalSpendRate: 385.0

[[Per_Prob_ROI diff: -0.6139222483648066 (up%-> -99.61002123832037) . o: 0.6163257880409208 -> a: 0.0024035396761142003	 per returnMoney: o:0.08442979649336257 a: 3.292582748536014E-4	 per totalSpendMoney: o: 0.13698890770372388 a: 3.558153446851644E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.3513716265882558

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.04233463932520953     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.5014182324665732 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------

		 @@@   dealerCard=Nine9, 	playerStartValue=6	@@@ 

net money diff:  0.03712670719905528 , up % -> 64.34371194690226 .  o: -0.057700598979575496 -> a: -0.020573891780520215 (anet/onet: 0.3565628805309774

[ProbMatrix: total: o: 4.5662969234574503E-4  -> a: 4.56629692345717E-4
org->adv	$w:22.924189332195162->36.83210583982689  	$d:12.0309854777271->11.317133069050271  	$l:65.04482519007773->51.85076109112284
	 improve value x$w(high is good):13.907916507631725  	x$d:-0.7138524086768285  	 x$l(negative is good):-13.19406409895489
	 	 $w-$l: -42.120635857882576 -> -15.018655251295959  _ #Surrender#	 lift : 27.10198060658662 : good	 :) hit 

[TimeMatrix: total:  o: 769.0 -> a: 591361.0
org->adv	$w:57.737321196358906->31.414313760968344  	$d:8.322496749024708->3.571422532091227  	$l:33.940182054616386->65.01426370694044
	 improve value x$w(high is good):-26.32300743539056  	x$d:-4.751074216933481  	 x$l(negative is good):31.074081652324054
	 	 $w-$l: 23.79713914174252 -> -33.59994994597209  _ #Surrender#	 lift : -57.39708908771461 : bad	 :| stand

[Prob_ROI diff: 0.27101980606600073 (up%-> 46.82494531220732) . o: 0.5787936414211797 -> a: 0.8498134474871805	 returnMoney: o:0.07928830872414805 a: 0.11641501592321096 (probReturnRate: 1.468249453122155	 totalSpendMoney: o: 0.13698890770372354 a: 0.13698890770373118 (probTotalSpendRate: 1.0000000000000557

[Time_ROI diff: -0.5739708908771461 (up%-> -46.36382511392073) . o: 1.2379713914174253 -> a: 0.6640005005402791	 returnMoney: o:285600.0 a: 1.177992E8 (timeReturnRate: 412.4621848739496	 totalSpendMoney: o: 230700.0 a: 1.774083E8 (timeTotalSpendRate: 769.0

[[Per_Prob_ROI diff: -0.5776885524127439 (up%-> -99.80907029218179) . o: 0.5787936414211797 -> a: 0.0011050890084358656	 per returnMoney: o:0.07928830872414805 a: 1.5138493618102857E-4	 per totalSpendMoney: o: 0.13698890770372354 a: 1.7813902172136693E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.30814651326505604

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.03712670719905528     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.4682494531220731 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------

		 @@@   dealerCard=Ten, 	playerStartValue=6	@@@ 

net money diff:  0.02931991946020579 , up % -> 46.21268639065267 .  o: -0.06344560714855188 -> a: -0.03412568768834609 (anet/onet: 0.5378731360934733

[ProbMatrix: total: o: 4.5662969234574455E-4  -> a: 4.566296923456336E-4
org->adv	$w:21.247093531872245->31.858174275997797  	$d:11.19140090680055->11.372373403402026  	$l:67.56150556132721->56.76945232060018
	 improve value x$w(high is good):10.611080744125552  	x$d:0.18097249660147519  	 x$l(negative is good):-10.792053240727029
	 	 $w-$l: -46.31441202945496 -> -24.91127804460238  _ #Surrender#	 lift : 21.40313398485258 : good	 :) hit 

[TimeMatrix: total:  o: 385.0 -> a: 296065.0
org->adv	$w:57.66233766233766->31.373515950889164  	$d:8.311688311688311->3.577592758346985  	$l:34.02597402597402->65.04889129076386
	 improve value x$w(high is good):-26.2888217114485  	x$d:-4.7340955533413265  	 x$l(negative is good):31.02291726478984
	 	 $w-$l: 23.636363636363633 -> -33.67537533987469  _ #Surrender#	 lift : -57.311738976238324 : bad	 :| stand

[Prob_ROI diff: 0.21403133984848277 (up%-> 39.867559980140584) . o: 0.5368558797054528 -> a: 0.7508872195539356	 returnMoney: o:0.07354330055517147 a: 0.10286322001538636 (probReturnRate: 1.3986755998014988	 totalSpendMoney: o: 0.13698890770372335 a: 0.13698890770373245 (probTotalSpendRate: 1.0000000000000664

[Time_ROI diff: -0.5731173897623832 (up%-> -46.35508299548688) . o: 1.2363636363636363 -> a: 0.6632462466012531	 returnMoney: o:142800.0 a: 5.89092E7 (timeReturnRate: 412.52941176470586	 totalSpendMoney: o: 115500.0 a: 8.88195E7 (timeTotalSpendRate: 769.0

[[Per_Prob_ROI diff: -0.5358794333861369 (up%-> -99.818117607308) . o: 0.5368558797054528 -> a: 9.76446319315911E-4	 per returnMoney: o:0.07354330055517147 a: 1.337623147144166E-4	 per totalSpendMoney: o: 0.13698890770372335 a: 1.781390217213686E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.24335125930868856

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.02931991946020579     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.398675599801406 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------






MatrixKey [startValue=Six, dealerCard=One1, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Six, dealerCard=Two2, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Six, dealerCard=Three3, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Six, dealerCard=Four4, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Six, dealerCard=Five5, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Six, dealerCard=Six6, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Six, dealerCard=Seven7, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Six, dealerCard=Eight8, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Six, dealerCard=Nine9, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Six, dealerCard=Ten, situation=Start_With_A] : Hit -> Double


		 @@@   dealerCard=One1, 	playerStartValue=6	@@@ 

net money diff:  -0.0743708477063965 , up % -> -136.9689196712146 .  o: -0.054297608453742 -> a: -0.1286684561601385 (anet/onet: 2.369689196712146

[ProbMatrix: total: o: 4.5662969234479294E-4  -> a: 4.566296923456427E-4
org->adv	$w:23.764342225000227->21.60570760010745  	$d:12.834815511901567->9.825491832295835  	$l:63.4008422630982->68.56880056759671
	 improve value x$w(high is good):-2.158634624892777  	x$d:-3.009323679605732  	 x$l(negative is good):5.167958304498512
	 	 $w-$l: -39.63650003809798 -> -46.96309296748926  _ #Surrender#	 lift : -7.326592929391285 : bad	 :| stand

[TimeMatrix: total:  o: 1.0926721E7 -> a: 184717.0
org->adv	$w:31.60214303998427->64.72495763790013  	$d:3.5233991972523135->5.129468321811203  	$l:64.87445776276341->30.145574040288658
	 improve value x$w(high is good):33.12281459791586  	x$d:1.6060691245588892  	 x$l(negative is good):-34.728883722474755
	 	 $w-$l: -33.27231472277914 -> 34.57938359761148  _ @double@	 lift : 67.85169832039062 : good	 :) hit 

[Prob_ROI diff: -0.07326592929696552 (up%-> -12.137455472734395) . o: 0.6036349996220398 -> a: 0.5303690703250743	 returnMoney: o:0.08269129924992923 a: 0.14530935924738086 (probReturnRate: 1.7572508905464468	 totalSpendMoney: o: 0.13698890770367123 a: 0.27397781540751937 (probTotalSpendRate: 2.0000000000012914

[Time_ROI diff: 0.6785169832039062 (up%-> 101.68447779733411) . o: 0.6672768527722086 -> a: 1.3457938359761148	 returnMoney: o:2.1873444E9 a: 1.491546E8 (timeReturnRate: 0.06818981043863051	 totalSpendMoney: o: 3.2780163E9 a: 1.108302E8 (timeTotalSpendRate: 0.033810143042912875

[[Per_Prob_ROI diff: 0.04001265980643148 (up%-> 5097.407441651326) . o: 7.849609878049932E-4 -> a: 0.040797620794236475	 per returnMoney: o:1.0753094830940081E-4 a: 0.011177643019029296	 per totalSpendMoney: o: 1.7813902172128898E-4 a: 0.021075216569809183

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.14763677700336203

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.0743708477063965     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.8786254452726561 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------

		 @@@   dealerCard=Two2, 	playerStartValue=6	@@@ 

net money diff:  -8.738378990206797E-4 , up % -> -1224.902532843075 .  o: -7.13393821623054E-5 -> a: -9.45177281182985E-4 (anet/onet: 13.24902532843075

[ProbMatrix: total: o: 4.5662969234561016E-4  -> a: 4.5662969234580683E-4
org->adv	$w:45.680313634340244->45.72480145043918  	$d:8.58729597311136->8.205413955203761  	$l:45.7323903925484->46.06978459435706
	 improve value x$w(high is good):0.04448781609893615  	x$d:-0.3818820179075981  	 x$l(negative is good):0.33739420180865665
	 	 $w-$l: -0.05207675820815827 -> -0.3449831439178819  _ #Surrender#	 lift : -0.2929063857097236 : bad	 :| stand

[TimeMatrix: total:  o: 667225.0 -> a: 346957.0
org->adv	$w:55.386563752856986->64.40250520957929  	$d:4.365843605979991->5.162022959617475  	$l:40.247592641163024->30.43547183080324
	 improve value x$w(high is good):9.015941456722302  	x$d:0.7961793536374833  	 x$l(negative is good):-9.812120810359783
	 	 $w-$l: 15.13897111169396 -> 33.967033378776044  _ @double@	 lift : 18.828062267082085 : good	 :) hit 

[Prob_ROI diff: -0.0029290638574679395 (up%-> -0.29305900137418733) . o: 0.9994792324184626 -> a: 0.9965501685609947	 returnMoney: o:0.13691756832152455 a: 0.27303263812637557 (probReturnRate: 1.9941388199738619	 totalSpendMoney: o: 0.13698890770368685 a: 0.27397781540755856 (probTotalSpendRate: 2.0000000000013496

[Time_ROI diff: 0.1882806226708209 (up%-> 16.35246701033777) . o: 1.1513897111169396 -> a: 1.3396703337877605	 returnMoney: o:2.304708E8 a: 2.788848E8 (timeReturnRate: 1.2100656569075128	 totalSpendMoney: o: 2.001675E8 a: 2.081742E8 (timeTotalSpendRate: 1.04

[[Per_Prob_ROI diff: 0.036678535977184165 (up%-> 91.74411730504966) . o: 0.039979169296738504 -> a: 0.07665770527392267	 per returnMoney: o:0.005476702732860982 a: 0.021002510625105813	 per totalSpendMoney: o: 0.005479556308147474 a: 0.021075216569812198

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.003802901756488619

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -8.738378990206797E-4     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9970694099862581 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------

		 @@@   dealerCard=Three3, 	playerStartValue=6	@@@ 

net money diff:  0.0036683819052627242 , up % -> 91.3755155495913 .  o: 0.004014622388939432 -> a: 0.007683004294202156 (anet/onet: 1.9137551554959131

[ProbMatrix: total: o: 4.5662969234573137E-4  -> a: 4.56629692345819E-4
org->adv	$w:47.31949022164736->47.44113820225735  	$d:8.291638141957865->7.921966808657903  	$l:44.388871636394775->44.63689498908474
	 improve value x$w(high is good):0.1216479806099926  	x$d:-0.36967133329996216  	 x$l(negative is good):0.24802335268996245
	 	 $w-$l: 2.9306185852525815 -> 2.804243213172608  _ #Surrender#	 lift : -0.12637537207997318 : bad	 :| stand

[TimeMatrix: total:  o: 388825.0 -> a: 202189.0
org->adv	$w:55.36963929788465->64.38184075295887  	$d:4.368031890953514->5.164474823061591  	$l:40.26232881116184->30.453684423979542
	 improve value x$w(high is good):9.012201455074212  	x$d:0.7964429321080768  	 x$l(negative is good):-9.808644387182294
	 	 $w-$l: 15.107310486722819 -> 33.92815632897932  _ @double@	 lift : 18.8208458422565 : good	 :) hit 

[Prob_ROI diff: -0.0012637537209518879 (up%-> -0.12277723949602211) . o: 1.0293061858528205 -> a: 1.0280424321318686	 returnMoney: o:0.1410035300926365 a: 0.28166081970169143 (probReturnRate: 1.9975444552107733	 totalSpendMoney: o: 0.13698890770369707 a: 0.2739778154074893 (probTotalSpendRate: 2.0000000000006946

[Time_ROI diff: 0.18820845842256495 (up%-> 16.35069550550172) . o: 1.1510731048672282 -> a: 1.3392815632897932	 returnMoney: o:1.342698E8 a: 1.624728E8 (timeReturnRate: 1.2100472332572179	 totalSpendMoney: o: 1.166475E8 a: 1.213134E8 (timeTotalSpendRate: 1.04

[[Per_Prob_ROI diff: 0.03790793965295399 (up%-> 92.07158223173838) . o: 0.04117224743411283 -> a: 0.07908018708706682	 per returnMoney: o:0.00564014120370546 a: 0.02166621690013011	 per totalSpendMoney: o: 0.005479556308147882 a: 0.02107521656980687

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.0024046281843108364

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.0036683819052627242     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9987722276050398 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------

		 @@@   dealerCard=Four4, 	playerStartValue=6	@@@ 

net money diff:  0.008430275311778035 , up % -> 100.00000000024033 .  o: 0.008430275311757773 -> a: 0.016860550623535808 (anet/onet: 2.0000000000024034

[ProbMatrix: total: o: 4.566296923458108E-4  -> a: 4.566296923458089E-4
org->adv	$w:49.242051220378094->49.2420512203783  	$d:7.669881449664061->7.669881449664049  	$l:43.08806732995785->43.08806732995766
	 improve value x$w(high is good):2.0605739337042905E-13  	x$d:-1.1546319456101628E-14  	 x$l(negative is good):-1.9184653865522705E-13
	 	 $w-$l: 6.153983890420239 -> 6.153983890420644  _ @double@	 lift : 4.0523140398818214E-13 : good	 :| stand

[TimeMatrix: total:  o: 117949.0 -> a: 117949.0
org->adv	$w:64.36425912894556->64.36425912894556  	$d:5.164944170785678->5.164944170785678  	$l:30.47079670026876->30.47079670026876
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 33.8934624286768 -> 33.8934624286768  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: 7.704947790898586E-14 (up%-> 7.258274733100723E-12) . o: 1.0615398389042578 -> a: 1.061539838904335	 returnMoney: o:0.14541918301548745 a: 0.29083836603098095 (probReturnRate: 2.0000000000000417	 totalSpendMoney: o: 0.13698890770372968 a: 0.27397781540744515 (probTotalSpendRate: 1.9999999999998963

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.338934624286768 -> a: 1.338934624286768	 returnMoney: o:4.73778E7 a: 9.47556E7 (timeReturnRate: 2.0	 totalSpendMoney: o: 3.53847E7 a: 7.07694E7 (timeTotalSpendRate: 2.0

[[Per_Prob_ROI diff: 5.925815393936773E-15 (up%-> 7.256967406960035E-12) . o: 0.08165691068494291 -> a: 0.08165691068494883	 per returnMoney: o:0.011186091001191343 a: 0.02237218200238315	 per totalSpendMoney: o: 0.010537608284902283 a: 0.021075216569803473

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.008430275311855084

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.008430275311778035     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.0000000000000728 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------

		 @@@   dealerCard=Five5, 	playerStartValue=6	@@@ 

net money diff:  0.013016037659509122 , up % -> 100.00000000012624 .  o: 0.01301603765949269 -> a: 0.026032075319001813 (anet/onet: 2.0000000000012625

[ProbMatrix: total: o: 4.56629692345784E-4  -> a: 4.566296923457836E-4
org->adv	$w:51.10422315112264->51.10422315112281  	$d:7.293080410875808->7.293080410875834  	$l:41.60269643800156->41.60269643800136
	 improve value x$w(high is good):1.7053025658242404E-13  	x$d:2.5757174171303632E-14  	 x$l(negative is good):-1.9895196601282805E-13
	 	 $w-$l: 9.501526713121084 -> 9.50152671312145  _ @double@	 lift : 3.6637359812630166E-13 : good	 :| stand7

[TimeMatrix: total:  o: 71149.0 -> a: 71149.0
org->adv	$w:64.35086930244978->64.35086930244978  	$d:5.169433161393695->5.169433161393695  	$l:30.479697536156518->30.479697536156518
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 33.871171766293266 -> 33.871171766293266  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: 6.394884621840902E-14 (up%-> 5.839995855577563E-12) . o: 1.0950152671312918 -> a: 1.0950152671313558	 returnMoney: o:0.15000494536321113 a: 0.30000989072642753 (probReturnRate: 2.000000000000035	 totalSpendMoney: o: 0.13698890770371844 a: 0.2739778154074257 (probTotalSpendRate: 1.9999999999999185

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.3387117176629326 -> a: 1.3387117176629326	 returnMoney: o:2.85744E7 a: 5.71488E7 (timeReturnRate: 2.0	 totalSpendMoney: o: 2.13447E7 a: 4.26894E7 (timeTotalSpendRate: 2.0

[[Per_Prob_ROI diff: 4.912736883966318E-15 (up%-> 5.832391694307279E-12) . o: 0.08423194362548399 -> a: 0.0842319436254889	 per returnMoney: o:0.01153884195101624 a: 0.023077683902032887	 per totalSpendMoney: o: 0.010537608284901419 a: 0.021075216569801977

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.013016037659573071

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.013016037659509122     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.0000000000000584 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------

		 @@@   dealerCard=Six6, 	playerStartValue=6	@@@ 

net money diff:  0.017546210869208184 , up % -> 100.00000000006897 .  o: 0.017546210869196083 -> a: 0.03509242173840427 (anet/onet: 2.0000000000006897

[ProbMatrix: total: o: 4.566296923457676E-4  -> a: 4.5662969234576867E-4
org->adv	$w:52.26287682254187->52.26287682254186  	$d:8.282736592053803->8.282736592053755  	$l:39.45438658540432->39.454386585404386
	 improve value x$w(high is good):-7.105427357601002E-15  	x$d:-4.796163466380676E-14  	 x$l(negative is good):6.394884621840902E-14
	 	 $w-$l: 12.808490237137548 -> 12.808490237137471  _ @double@	 lift : -7.771561172376096E-14 : bad	 :| stand

[TimeMatrix: total:  o: 40417.0 -> a: 40417.0
org->adv	$w:64.33926318133459->64.33926318133459  	$d:5.1611945468490985->5.1611945468490985  	$l:30.499542271816317->30.499542271816317
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 33.83972090951827 -> 33.83972090951827  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: 4.75175454539567E-14 (up%-> 4.212231309369333E-12) . o: 1.1280849023714028 -> a: 1.1280849023714503	 returnMoney: o:0.15453511857291596 a: 0.30907023714583726 (probReturnRate: 2.0000000000000346	 totalSpendMoney: o: 0.13698890770371988 a: 0.273977815407433 (probTotalSpendRate: 1.9999999999999505

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.3383972090951828 -> a: 1.3383972090951828	 returnMoney: o:1.62282E7 a: 3.24564E7 (timeReturnRate: 2.0	 totalSpendMoney: o: 1.21251E7 a: 2.42502E7 (timeTotalSpendRate: 2.0

[[Per_Prob_ROI diff: 3.635980405647388E-15 (up%-> 4.19008757000933E-12) . o: 0.08677576172087714 -> a: 0.08677576172088078	 per returnMoney: o:0.011887316813301229 a: 0.023774633626602867	 per totalSpendMoney: o: 0.01053760828490153 a: 0.02107521656980254

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.0175462108692557

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.017546210869208184     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.0000000000000422 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------

		 @@@   dealerCard=Seven7, 	playerStartValue=6	@@@ 

net money diff:  -0.00907591940549371 , up % -> -126.0752130811592 .  o: 0.007198813457210823 -> a: -0.0018771059482828867 (anet/onet: -0.26075213081159215

[ProbMatrix: total: o: 4.5662969234569624E-4  -> a: 4.566296923457628E-4
org->adv	$w:44.24371721790106->42.535081231324  	$d:16.76759940448404->14.24470690168334  	$l:38.9886833776149->43.220211866992656
	 improve value x$w(high is good):-1.7086359865770575  	x$d:-2.522892502800701  	 x$l(negative is good):4.231528489377759
	 	 $w-$l: 5.255033840286161 -> -0.6851306356686571  _ #Surrender#	 lift : -5.940164475954818 : bad	 :| stand

[TimeMatrix: total:  o: 739585.0 -> a: 24973.0
org->adv	$w:31.46440233374122->64.26140231449966  	$d:3.5751130701677294->5.205622071837585  	$l:64.96048459609105->30.532975613662757
	 improve value x$w(high is good):32.79699998075844  	x$d:1.6305090016698554  	 x$l(negative is good):-34.42750898242829
	 	 $w-$l: -33.49608226234983 -> 33.728426700836906  _ @double@	 lift : 67.22450896318674 : good	 :) hit 

[Prob_ROI diff: -0.059401644759056405 (up%-> -5.6435918161613285) . o: 1.0525503384024033 -> a: 0.9931486936433469	 returnMoney: o:0.1441877211610213 a: 0.272100709459151 (probReturnRate: 1.887128163675485	 totalSpendMoney: o: 0.13698890770381048 a: 0.2739778154074339 (probTotalSpendRate: 1.9999999999986344

[Time_ROI diff: 0.6722450896318675 (up%-> 101.08353199337704) . o: 0.6650391773765016 -> a: 1.337284267008369	 returnMoney: o:1.475559E8 a: 2.00376E7 (timeReturnRate: 0.13579667095656628	 totalSpendMoney: o: 2.218755E8 a: 1.49838E7 (timeTotalSpendRate: 0.06753246753246753

[[Per_Prob_ROI diff: 0.07366215637431714 (up%-> 2694.401319290607) . o: 0.002733896982863385 -> a: 0.07639605335718053	 per returnMoney: o:3.7451356145719815E-4 a: 0.020930823804550077	 per totalSpendMoney: o: 3.5581534468522204E-4 a: 0.021075216569802605

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.06847756416455011

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.00907591940549371     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9435640818383868 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------

		 @@@   dealerCard=Eight8, 	playerStartValue=6	@@@ 

net money diff:  -0.024971312086498415 , up % -> -244.2308254841247 .  o: -0.01022447188515177 -> a: -0.035195783971650185 (anet/onet: 3.442308254841247

[ProbMatrix: total: o: 4.5662969234588544E-4  -> a: 4.5662969234575224E-4
org->adv	$w:40.604988278851636->39.20994083123638  	$d:11.326300972699272->8.733901603038603  	$l:48.06871074844909->52.056157565725016
	 improve value x$w(high is good):-1.395047447615255  	x$d:-2.5923993696606686  	 x$l(negative is good):3.9874468172759236
	 	 $w-$l: -7.463722469597456 -> -12.84621673448863  _ #Surrender#	 lift : -5.382494264891174 : bad	 :| stand

[TimeMatrix: total:  o: 443905.0 -> a: 14989.0
org->adv	$w:31.45492841936901->64.24044299152712  	$d:3.5755398114461427->5.17045833611315  	$l:64.96953176918485->30.589098672359732
	 improve value x$w(high is good):32.78551457215811  	x$d:1.594918524667007  	 x$l(negative is good):-34.38043309682512
	 	 $w-$l: -33.51460334981584 -> 33.65134431916739  _ @double@	 lift : 67.16594766898322 : good	 :) hit 

[Prob_ROI diff: -0.0538249426488282 (up%-> -5.816631496890239) . o: 0.925362775303967 -> a: 0.8715378326551388	 returnMoney: o:0.12676443581863653 a: 0.23878203143579102 (probReturnRate: 1.8836673700612645	 totalSpendMoney: o: 0.1369889077037883 a: 0.2739778154074412 (probTotalSpendRate: 1.9999999999990117

[Time_ROI diff: 0.6716594766898323 (up%-> 101.02360977460933) . o: 0.6648539665018416 -> a: 1.3365134431916739	 returnMoney: o:8.85396E7 a: 1.20198E7 (timeReturnRate: 0.13575620400363228	 totalSpendMoney: o: 1.331715E8 a: 8993400.0 (timeTotalSpendRate: 0.06753246753246753

[[Per_Prob_ROI diff: 0.06463783206658878 (up%-> 2689.276682592096) . o: 0.0024035396761142003 -> a: 0.06704137174270298	 per returnMoney: o:3.292582748536014E-4 a: 0.018367848571983925	 per totalSpendMoney: o: 3.558153446851644E-4 a: 0.02107521656980317

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.07879625473532662

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.024971312086498415     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9418336850310977 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------

		 @@@   dealerCard=Nine9, 	playerStartValue=6	@@@ 

net money diff:  -0.03379226039525046 , up % -> -164.2482654995088 .  o: -0.020573891780520215 -> a: -0.05436615217577068 (anet/onet: 2.642482654995088

[ProbMatrix: total: o: 4.56629692345717E-4  -> a: 4.566296923457463E-4
org->adv	$w:36.83210583982689->35.71656670446332  	$d:11.317133069050271->8.723598589639128  	$l:51.85076109112284->55.55983470589756
	 improve value x$w(high is good):-1.1155391353635693  	x$d:-2.5935344794111437  	 x$l(negative is good):3.7090736147747165
	 	 $w-$l: -15.018655251295959 -> -19.843268001434243  _ #Surrender#	 lift : -4.824612750138285 : bad	 :| stand

[TimeMatrix: total:  o: 591361.0 -> a: 9997.0
org->adv	$w:31.414313760968344->64.19925977793338  	$d:3.571422532091227->5.171551465439632  	$l:65.01426370694044->30.62918875662699
	 improve value x$w(high is good):32.78494601696504  	x$d:1.6001289333484046  	 x$l(negative is good):-34.38507495031345
	 	 $w-$l: -33.59994994597209 -> 33.57007102130639  _ @double@	 lift : 67.17002096727849 : good	 :) hit 

[Prob_ROI diff: -0.04824612750151036 (up%-> -5.677261008774301) . o: 0.8498134474871805 -> a: 0.8015673199856701	 returnMoney: o:0.11641501592321096 a: 0.2196116632316743 (probReturnRate: 1.8864547798243945	 totalSpendMoney: o: 0.13698890770373118 a: 0.273977815407445 (probTotalSpendRate: 1.9999999999998732

[Time_ROI diff: 0.6717002096727849 (up%-> 101.15959387473966) . o: 0.6640005005402791 -> a: 1.335700710213064	 returnMoney: o:1.177992E8 a: 8011800.0 (timeReturnRate: 0.06801234643359208	 totalSpendMoney: o: 1.774083E8 a: 5998200.0 (timeTotalSpendRate: 0.033810143042912875

[[Per_Prob_ROI diff: 0.060553935605846446 (up%-> 5479.55279109635) . o: 0.0011050890084358656 -> a: 0.06165902461428231	 per returnMoney: o:1.5138493618102857E-4 a: 0.016893204863974946	 per totalSpendMoney: o: 1.7813902172136693E-4 a: 0.02107521656980346

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.08203838789676082

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.03379226039525046     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9432273899122571 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------

		 @@@   dealerCard=Ten, 	playerStartValue=6	@@@ 

net money diff:  -0.04277358424990743 , up % -> -125.341310746727 .  o: -0.03412568768834609 -> a: -0.07689927193825352 (anet/onet: 2.25341310746727

[ProbMatrix: total: o: 4.566296923456336E-4  -> a: 4.566296923457462E-4
org->adv	$w:31.858174275997797->31.636014810177425  	$d:11.372373403402026->8.660270144903189  	$l:56.76945232060018->59.70371504491938
	 improve value x$w(high is good):-0.22215946582037205  	x$d:-2.7121032584988374  	 x$l(negative is good):2.934262724319197
	 	 $w-$l: -24.91127804460238 -> -28.067700234741956  _ #Surrender#	 lift : -3.156422190139574 : bad	 :| stand

[TimeMatrix: total:  o: 296065.0 -> a: 5005.0
org->adv	$w:31.373515950889164->64.11588411588411  	$d:3.577592758346985->5.174825174825175  	$l:65.04889129076386->30.70929070929071
	 improve value x$w(high is good):32.74236816499495  	x$d:1.5972324164781901  	 x$l(negative is good):-34.33960058147315
	 	 $w-$l: -33.67537533987469 -> 33.4065934065934  _ @double@	 lift : 67.0819687464681 : good	 :) hit 

[Prob_ROI diff: -0.03156422190134389 (up%-> -4.203590243564754) . o: 0.7508872195539356 -> a: 0.7193229976525917	 returnMoney: o:0.10286322001538636 a: 0.1970785434691924 (probReturnRate: 1.915928195128572	 totalSpendMoney: o: 0.13698890770373245 a: 0.2739778154074459 (probTotalSpendRate: 1.9999999999998614

[Time_ROI diff: 0.6708196874646809 (up%-> 101.14187466604406) . o: 0.6632462466012531 -> a: 1.334065934065934	 returnMoney: o:5.89092E7 a: 4006200.0 (timeReturnRate: 0.06800635554378603	 totalSpendMoney: o: 8.88195E7 a: 3003000.0 (timeTotalSpendRate: 0.033810143042912875

[[Per_Prob_ROI diff: 0.054356091961652676 (up%-> 5566.726084822977) . o: 9.76446319315911E-4 -> a: 0.05533253828096859	 per returnMoney: o:1.337623147144166E-4 a: 0.015159887959168646	 per totalSpendMoney: o: 1.781390217213686E-4 a: 0.02107521656980353

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.07433780615125132

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.04277358424990743     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9579640975643524 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------







		 */
	}
	
	public static void testA7vsAll() {
		StrategyMatrix8012 o = new Myth2019April22();
		StrategyMatrix8012 t = new MirMyth2019April22();
		
		System.out.println(t.diffWith(o));
		
		for(Card playerCard : Card.values()) {
			if(playerCard.getValue() == 7) {
				for(Card dealerCard : Card.values()) {
					if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
					PlayerCardsPathValue nine = new PlayerCardsPathValue(Card.One1,playerCard);
					Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, nine, dealerCard); 
//					HelloWorld.print(origin);
					PlayerCardsPathValue ninet = new PlayerCardsPathValue(Card.One1,playerCard);
					Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, ninet, dealerCard); 
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

MatrixKey [startValue=Seven, dealerCard=One1, situation=A_Three_More_Cards] : Hit -> Stand
MatrixKey [startValue=Seven, dealerCard=One1, situation=Start_With_A] : Hit -> Stand
MatrixKey [startValue=Seven, dealerCard=Two2, situation=Start_With_A] : Hit -> Stand
MatrixKey [startValue=Seven, dealerCard=Two2, situation=A_Three_More_Cards] : Hit -> Stand
MatrixKey [startValue=Seven, dealerCard=Three3, situation=Start_With_A] : Hit -> Stand
MatrixKey [startValue=Seven, dealerCard=Three3, situation=A_Three_More_Cards] : Hit -> Stand
MatrixKey [startValue=Seven, dealerCard=Four4, situation=Start_With_A] : Hit -> Stand
MatrixKey [startValue=Seven, dealerCard=Four4, situation=A_Three_More_Cards] : Hit -> Stand
MatrixKey [startValue=Seven, dealerCard=Five5, situation=A_Three_More_Cards] : Hit -> Stand
MatrixKey [startValue=Seven, dealerCard=Five5, situation=Start_With_A] : Hit -> Stand
MatrixKey [startValue=Seven, dealerCard=Six6, situation=Start_With_A] : Hit -> Stand
MatrixKey [startValue=Seven, dealerCard=Six6, situation=A_Three_More_Cards] : Hit -> Stand
MatrixKey [startValue=Seven, dealerCard=Seven7, situation=A_Three_More_Cards] : Hit -> Stand
MatrixKey [startValue=Seven, dealerCard=Seven7, situation=Start_With_A] : Hit -> Stand
MatrixKey [startValue=Seven, dealerCard=Eight8, situation=A_Three_More_Cards] : Hit -> Stand
MatrixKey [startValue=Seven, dealerCard=Eight8, situation=Start_With_A] : Hit -> Stand
MatrixKey [startValue=Seven, dealerCard=Nine9, situation=Start_With_A] : Hit -> Stand
MatrixKey [startValue=Seven, dealerCard=Nine9, situation=A_Three_More_Cards] : Hit -> Stand
MatrixKey [startValue=Seven, dealerCard=Ten, situation=A_Three_More_Cards] : Hit -> Stand
MatrixKey [startValue=Seven, dealerCard=Ten, situation=Start_With_A] : Hit -> Stand


		 @@@   dealerCard=One1, 	playerStartValue=7	@@@ 

net money diff:  -0.005384678958771358 , up % -> -11.598806361913525 .  o: -0.046424423261800324 -> a: -0.05180910222057168 (anet/onet: 1.1159880636191353

[ProbMatrix: total: o: 4.566296923457113E-4  -> a: 4.5662969234574053E-4
org->adv	$w:26.613468588429424->24.548959667640098  	$d:12.883878625530034->13.082155614562646  	$l:60.502652786040535->62.36888471779726
	 improve value x$w(high is good):-2.0645089207893257  	x$d:0.19827698903261215  	 x$l(negative is good):1.8662319317567224
	 	 $w-$l: -33.88918419761111 -> -37.81992505015715  _ #Surrender#	 lift : -3.930740852546044 : bad	 :| stand

[TimeMatrix: total:  o: 5470465.0 -> a: 14209.0
org->adv	$w:31.6801222565175->66.64789921880498  	$d:3.5296451032956067->8.332746850587656  	$l:64.7902326401869->25.019353930607362
	 improve value x$w(high is good):34.96777696228748  	x$d:4.8031017472920485  	 x$l(negative is good):-39.770878709579534
	 	 $w-$l: -33.110110383669394 -> 41.62854528819762  _ @double@	 lift : 74.73865567186702 : good	 :) hit 

[Prob_ROI diff: -0.03930740852736836 (up%-> -5.9456849912041525) . o: 0.661108158025836 -> a: 0.6218007494984676	 returnMoney: o:0.09056448444209053 a: 0.08517980548315145 (probReturnRate: 0.9405431500868069	 totalSpendMoney: o: 0.13698890770389086 a: 0.13698890770372313 (probTotalSpendRate: 0.9999999999987756

[Time_ROI diff: 0.7473865567186702 (up%-> 111.73386008043316) . o: 0.668898896163306 -> a: 1.4162854528819762	 returnMoney: o:1.0977564E9 a: 6037200.0 (timeReturnRate: 0.005499580781309952	 totalSpendMoney: o: 1.6411395E9 a: 4262700.0 (timeTotalSpendRate: 0.0025974025974025974

[[Per_Prob_ROI diff: 0.6200835854516473 (up%-> 36110.91127838641) . o: 0.001717164046820353 -> a: 0.6218007494984676	 per returnMoney: o:2.3523242712231306E-4 a: 0.08517980548315145	 per totalSpendMoney: o: 3.558153446854308E-4 a: 0.13698890770372313

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.04469208748613972

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.005384678958771358     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9405431500879584 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Two2, 	playerStartValue=7	@@@ 

net money diff:  0.008009005083087106 , up % -> 93.92780672262808 .  o: 0.008526766846305656 -> a: 0.016535771929392762 (anet/onet: 1.9392780672262808

[ProbMatrix: total: o: 4.566296923455018E-4  -> a: 4.5662969234576726E-4
org->adv	$w:48.87722790625181->49.31601058521199  	$d:8.469965558018306->13.438862674531624  	$l:42.65280653572988->37.245126740256396
	 improve value x$w(high is good):0.4387826789601803  	x$d:4.968897116513318  	 x$l(negative is good):-5.407679795473484
	 	 $w-$l: 6.224421370521932 -> 12.070883844955594  _ @double@	 lift : 5.846462474433661 : good	 :) hit 

[TimeMatrix: total:  o: 667225.0 -> a: 26689.0
org->adv	$w:56.389224024879155->66.31571059237888  	$d:4.367642099741467->8.370489714863801  	$l:39.24313387537937->25.313799692757318
	 improve value x$w(high is good):9.926486567499722  	x$d:4.0028476151223344  	 x$l(negative is good):-13.929334182622053
	 	 $w-$l: 17.146090149499788 -> 41.00191089962157  _ @double@	 lift : 23.85582075012178 : good	 :) hit 

[Prob_ROI diff: 0.05846462474472136 (up%-> 5.503877920954825) . o: 1.0622442137048487 -> a: 1.12070883844957	 returnMoney: o:0.1455156745500501 a: 0.15352467963312402 (probReturnRate: 1.0550387792094469	 totalSpendMoney: o: 0.13698890770374444 a: 0.13698890770373126 (probTotalSpendRate: 0.9999999999999037

[Time_ROI diff: 0.2385582075012178 (up%-> 20.364163003372454) . o: 1.171460901494998 -> a: 1.4100191089962157	 returnMoney: o:2.344884E8 a: 1.12896E7 (timeReturnRate: 0.048145665201348976	 totalSpendMoney: o: 2.001675E8 a: 8006700.0 (timeTotalSpendRate: 0.04

[[Per_Prob_ROI diff: 1.078219069901376 (up%-> 2537.5969480238705) . o: 0.042489768548193946 -> a: 1.12070883844957	 per returnMoney: o:0.005820626982002004 a: 0.15352467963312402	 per totalSpendMoney: o: 0.005479556308149777 a: 0.13698890770373126

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.06647362982780847

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.008009005083087106     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.0550387792095484 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Three3, 	playerStartValue=7	@@@ 

net money diff:  0.007884787684409866 , up % -> 63.981131575749984 .  o: 0.012323613994033117 -> a: 0.020208401678442983 (anet/onet: 1.6398113157574998

[ProbMatrix: total: o: 4.5662969234565694E-4  -> a: 4.566296923457585E-4
org->adv	$w:50.3932374801209->50.84898508266357  	$d:8.209592094138133->13.053882387688237  	$l:41.39717042574096->36.0971325296482
	 improve value x$w(high is good):0.4557476025426652  	x$d:4.844290293550104  	 x$l(negative is good):-5.3000378960927605
	 	 $w-$l: 8.996067054379942 -> 14.751852553015372  _ @double@	 lift : 5.755785498635429 : good	 :) hit 

[TimeMatrix: total:  o: 388825.0 -> a: 15553.0
org->adv	$w:56.37266122291519->66.295891467884  	$d:4.369575001607407->8.371375297370284  	$l:39.2577637754774->25.332733234745707
	 improve value x$w(high is good):9.923230244968813  	x$d:4.001800295762877  	 x$l(negative is good):-13.925030540731694
	 	 $w-$l: 17.114897447437787 -> 40.963158233138294  _ @double@	 lift : 23.84826078570051 : good	 :) hit 

[Prob_ROI diff: 0.05755785498680588 (up%-> 5.280727694340757) . o: 1.0899606705433684 -> a: 1.1475185255301743	 returnMoney: o:0.14931252169778478 a: 0.1571973093821702 (probReturnRate: 1.0528072769432197	 totalSpendMoney: o: 0.13698890770375166 a: 0.1369889077037272 (probTotalSpendRate: 0.9999999999998215

[Time_ROI diff: 0.23848260785700504 (up%-> 20.363131681350627) . o: 1.171148974474378 -> a: 1.409631582331383	 returnMoney: o:1.366116E8 a: 6577200.0 (timeReturnRate: 0.04814525267254025	 totalSpendMoney: o: 1.166475E8 a: 4665900.0 (timeTotalSpendRate: 0.04

[[Per_Prob_ROI diff: 1.1039200987084397 (up%-> 2532.018192358519) . o: 0.04359842682173474 -> a: 1.1475185255301743	 per returnMoney: o:0.005972500867911391 a: 0.1571973093821702	 per totalSpendMoney: o: 0.005479556308150066 a: 0.1369889077037272

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.06544264267121574

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.007884787684409866     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.0528072769434076 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Four4, 	playerStartValue=7	@@@ 

net money diff:  0.007794319386529608 , up % -> 47.45988516981283 .  o: 0.01642296301105936 -> a: 0.02421728239758897 (anet/onet: 1.4745988516981283

[ProbMatrix: total: o: 4.566296923458142E-4  -> a: 4.566296923457549E-4
org->adv	$w:52.2342933257957->52.63606408551497  	$d:7.519948249775843->12.406151628064562  	$l:40.24575842442845->34.95778428642048
	 improve value x$w(high is good):0.4017707597192697  	x$d:4.886203378288719  	 x$l(negative is good):-5.287974138007975
	 	 $w-$l: 11.988534901367249 -> 17.678279799094486  _ @double@	 lift : 5.689744897727239 : good	 :) hit 

[TimeMatrix: total:  o: 117949.0 -> a: 9073.0
org->adv	$w:66.2922110403649->66.27355891105478  	$d:5.170031115142986->8.376501708365481  	$l:28.537757844492113->25.349939380579745
	 improve value x$w(high is good):-0.018652129310126497  	x$d:3.2064705932224955  	 x$l(negative is good):-3.187818463912368
	 	 $w-$l: 37.75445319587279 -> 40.92361953047503  _ @double@	 lift : 3.1691663346022416 : good	 :) hit 

[Prob_ROI diff: 0.05689744897730997 (up%-> 5.080649463574402) . o: 1.119885349013643 -> a: 1.1767827979909529	 returnMoney: o:0.15341187071478904 a: 0.16120619010131432 (probReturnRate: 1.0508064946357107	 totalSpendMoney: o: 0.13698890770372968 a: 0.13698890770372535 (probTotalSpendRate: 0.9999999999999684

[Time_ROI diff: 0.03169166334602247 (up%-> 2.300590841949781) . o: 1.3775445319587278 -> a: 1.4092361953047503	 returnMoney: o:4.8744E7 a: 3835800.0 (timeReturnRate: 0.07869276218611522	 totalSpendMoney: o: 3.53847E7 a: 2721900.0 (timeTotalSpendRate: 0.07692307692307693

[[Per_Prob_ROI diff: 1.0906377711437496 (up%-> 1266.0484430264669) . o: 0.08614502684720332 -> a: 1.1767827979909529	 per returnMoney: o:0.01180091313190685 a: 0.16120619010131432	 per totalSpendMoney: o: 0.010537608284902283 a: 0.13698890770372535

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.06469176836383958

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.007794319386529608     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.050806494635744 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Five5, 	playerStartValue=7	@@@ 

net money diff:  0.007117773166410851 , up % -> 34.41497558154877 .  o: 0.020682197346166276 -> a: 0.027799970512577127 (anet/onet: 1.3441497558154878

[ProbMatrix: total: o: 4.566296923457834E-4  -> a: 4.566296923457527E-4
org->adv	$w:53.89463988944636->54.02494007796833  	$d:7.308437031064441->12.243712207542522  	$l:38.79692307948921->33.73134771448915
	 improve value x$w(high is good):0.13030018852197145  	x$d:4.935275176478081  	 x$l(negative is good):-5.065575365000065
	 	 $w-$l: 15.097716809957152 -> 20.293592363479185  _ @double@	 lift : 5.195875553522034 : good	 :) hit 

[TimeMatrix: total:  o: 71149.0 -> a: 5473.0
org->adv	$w:66.28202785703242->66.270783847981  	$d:5.169433161393695->8.368353736524758  	$l:28.548538981573877->25.360862415494246
	 improve value x$w(high is good):-0.011244009051424086  	x$d:3.198920575131064  	 x$l(negative is good):-3.187676566079631
	 	 $w-$l: 37.73348887545854 -> 40.909921432486755  _ @double@	 lift : 3.176432557028208 : good	 :) hit 

[Prob_ROI diff: 0.05195875553518525 (up%-> 4.5143167888356) . o: 1.1509771680996101 -> a: 1.2029359236347954	 returnMoney: o:0.1576711050498847 a: 0.16478887821630192 (probReturnRate: 1.0451431678884044	 totalSpendMoney: o: 0.13698890770371844 a: 0.1369889077037248 (probTotalSpendRate: 1.0000000000000464

[Time_ROI diff: 0.03176432557028197 (up%-> 2.306216580268574) . o: 1.3773348887545855 -> a: 1.4090992143248675	 returnMoney: o:2.93988E7 a: 2313600.0 (timeReturnRate: 0.07869708967712968	 totalSpendMoney: o: 2.13447E7 a: 1641900.0 (timeTotalSpendRate: 0.07692307692307693

[[Per_Prob_ROI diff: 1.1143992183963638 (up%-> 1258.6861182548628) . o: 0.08853670523843155 -> a: 1.2029359236347954	 per returnMoney: o:0.012128546542298824 a: 0.16478887821630192	 per totalSpendMoney: o: 0.010537608284901419 a: 0.1369889077037248

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.059076528701596104

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.007117773166410851     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.045143167888356 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Six6, 	playerStartValue=7	@@@ 

net money diff:  0.012704397943180151 , up % -> 48.66978490623751 .  o: 0.026103254755810434 -> a: 0.038807652698990586 (anet/onet: 1.486697849062375

[ProbMatrix: total: o: 4.566296923457612E-4  -> a: 4.5662969234574867E-4
org->adv	$w:56.07729035159219->58.854821525511824  	$d:6.900432723348839->10.619404424062473  	$l:37.022276925058975->30.525774050425696
	 improve value x$w(high is good):2.777531173919634  	x$d:3.7189717007136345  	 x$l(negative is good):-6.496502874633279
	 	 $w-$l: 19.05501342653321 -> 28.329047475086128  _ @double@	 lift : 9.274034048552915 : good	 :) hit 

[TimeMatrix: total:  o: 40417.0 -> a: 3109.0
org->adv	$w:66.26172155281193->66.22708266323578  	$d:5.176039785238885->8.394982309424252  	$l:28.56223866194918->25.37793502733998
	 improve value x$w(high is good):-0.034638889576157794  	x$d:3.2189425241853673  	 x$l(negative is good):-3.1843036346092006
	 	 $w-$l: 37.699482890862754 -> 40.84914763589579  _ @double@	 lift : 3.1496647450330317 : good	 :) hit 

[Prob_ROI diff: 0.09274034048549518 (up%-> 7.789704760540852) . o: 1.1905501342653717 -> a: 1.2832904747508669	 returnMoney: o:0.16309216245953032 a: 0.1757965604027143 (probReturnRate: 1.0778970476054388	 totalSpendMoney: o: 0.13698890770371988 a: 0.1369889077037237 (probTotalSpendRate: 1.000000000000028

[Time_ROI diff: 0.031496647450330206 (up%-> 2.2873468214324144) . o: 1.3769948289086276 -> a: 1.4084914763589578	 returnMoney: o:1.66962E7 a: 1313700.0 (timeReturnRate: 0.07868257447802494	 totalSpendMoney: o: 1.21251E7 a: 932700.0 (timeTotalSpendRate: 0.07692307692307693

[[Per_Prob_ROI diff: 1.191709695191992 (up%-> 1301.2661618870309) . o: 0.09158077955887475 -> a: 1.2832904747508669	 per returnMoney: o:0.01254555095842541 a: 0.1757965604027143	 per totalSpendMoney: o: 0.01053760828490153 a: 0.1369889077037237

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.10544473842867533

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.012704397943180151     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.0778970476054086 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Seven7, 	playerStartValue=7	@@@ 

net money diff:  0.031467661160096805 , up % -> 134.72006769261796 .  o: 0.023357812758745433 -> a: 0.05482547391884224 (anet/onet: 2.3472006769261795

[ProbMatrix: total: o: 4.5662969234561813E-4  -> a: 4.566296923457463E-4
org->adv	$w:52.811698729431214->63.11437111287417  	$d:11.427481441013612->13.793092270091003  	$l:35.76081982955518->23.09253661703482
	 improve value x$w(high is good):10.302672383442953  	x$d:2.365610829077392  	 x$l(negative is good):-12.668283212520361
	 	 $w-$l: 17.050878899876025 -> 40.02183449583935  _ @double@	 lift : 22.97095559596332 : good	 :) hit 

[TimeMatrix: total:  o: 739585.0 -> a: 1921.0
org->adv	$w:31.530520494601706->66.26756897449245  	$d:3.5738961715015853->8.328995314940135  	$l:64.89558333389671->25.40343571056741
	 improve value x$w(high is good):34.737048479890746  	x$d:4.7550991434385494  	 x$l(negative is good):-39.4921476233293
	 	 $w-$l: -33.36506283929501 -> 40.86413326392504  _ @double@	 lift : 74.22919610322005 : good	 :) hit 

[Prob_ROI diff: 0.22970955596031062 (up%-> 19.624761310586567) . o: 1.1705087889980803 -> a: 1.400218344958391	 returnMoney: o:0.16034672046254958 a: 0.19181438162256634 (probReturnRate: 1.1962476131051667	 totalSpendMoney: o: 0.13698890770380415 a: 0.1369889077037241 (probTotalSpendRate: 0.9999999999994157

[Time_ROI diff: 0.7422919610322005 (up%-> 111.39681264229276) . o: 0.6663493716070499 -> a: 1.4086413326392504	 returnMoney: o:1.478466E8 a: 811800.0 (timeReturnRate: 0.005490826302397215	 totalSpendMoney: o: 2.218755E8 a: 576300.0 (timeTotalSpendRate: 0.0025974025974025974

[[Per_Prob_ROI diff: 1.3971780623895647 (up%-> 45955.53310457582) . o: 0.003040282568826183 -> a: 1.400218344958391	 per returnMoney: o:4.164849882144145E-4 a: 0.19181438162256634	 per totalSpendMoney: o: 3.5581534468520556E-4 a: 0.1369889077037241

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.2611772171204074

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.031467661160096805     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.1962476131058657 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Eight8, 	playerStartValue=7	@@@ 

net money diff:  0.009192054802708488 , up % -> 176.0251181293697 .  o: 0.0052220131424384475 -> a: 0.014414067945146936 (anet/onet: 2.760251181293697

[ProbMatrix: total: o: 4.5662969234571224E-4  -> a: 4.566296923457447E-4
org->adv	$w:43.51882870489121->37.26328900905532  	$d:16.774339656272456->35.995491386458035  	$l:39.706831638836334->26.741219604486655
	 improve value x$w(high is good):-6.255539695835893  	x$d:19.22115173018558  	 x$l(negative is good):-12.965612034349679
	 	 $w-$l: 3.8119970660548788 -> 10.522069404568663  _ @double@	 lift : 6.710072338513784 : good	 :) hit 

[TimeMatrix: total:  o: 443905.0 -> a: 1153.0
org->adv	$w:31.519807165947668->66.08846487424111  	$d:3.5775672722767258->8.586296617519515  	$l:64.90262556177561->25.32523850823938
	 improve value x$w(high is good):34.56865770829344  	x$d:5.00872934524279  	 x$l(negative is good):-39.57738705353623
	 	 $w-$l: -33.38281839582794 -> 40.76322636600174  _ @double@	 lift : 74.14604476182967 : good	 :) hit 

[Prob_ROI diff: 0.06710072338551454 (up%-> 6.463677155044311) . o: 1.0381199706601765 -> a: 1.105220694045691	 returnMoney: o:0.14221092084623796 a: 0.1514029756488708 (probReturnRate: 1.0646367715498555	 totalSpendMoney: o: 0.1369889077037995 a: 0.13698890770372388 (probTotalSpendRate: 0.9999999999994479

[Time_ROI diff: 0.7414604476182968 (up%-> 111.30168370435248) . o: 0.6661718160417206 -> a: 1.4076322636600174	 returnMoney: o:8.87151E7 a: 486900.0 (timeReturnRate: 0.005488355420892272	 totalSpendMoney: o: 1.331715E8 a: 345900.0 (timeTotalSpendRate: 0.0025974025974025974

[[Per_Prob_ROI diff: 1.1025242785374827 (up%-> 40888.515704692065) . o: 0.0026964155082082504 -> a: 1.105220694045691	 per returnMoney: o:3.6937901518503365E-4 a: 0.1514029756488708	 per totalSpendMoney: o: 3.558153446851935E-4 a: 0.13698890770372388

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.07629277818822303

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.009192054802708488     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.0646367715504432 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Nine9, 	playerStartValue=7	@@@ 

net money diff:  -0.011205543896955647 , up % -> -80.39275375467281 .  o: -0.013938499894095652 -> a: -0.0251440437910513 (anet/onet: 1.803927537546728

[ProbMatrix: total: o: 4.5662969234574997E-4  -> a: 4.566296923457458E-4
org->adv	$w:39.29852752596998->34.955174809922404  	$d:11.228033615660083->11.734847635517601  	$l:49.47343885836994->53.309977554559985
	 improve value x$w(high is good):-4.343352716047576  	x$d:0.5068140198575186  	 x$l(negative is good):3.836538696190047
	 	 $w-$l: -10.174911332399962 -> -18.35480274463758  _ #Surrender#	 lift : -8.179891412237621 : bad	 :| stand

[TimeMatrix: total:  o: 296065.0 -> a: 769.0
org->adv	$w:31.491733234255992->66.05981794538361  	$d:3.577592758346985->8.322496749024708  	$l:64.93067400739703->25.617685305591674
	 improve value x$w(high is good):34.568084711127625  	x$d:4.744903990677724  	 x$l(negative is good):-39.31298870180535
	 	 $w-$l: -33.438940773141034 -> 40.442132639791936  _ @double@	 lift : 73.88107341293298 : good	 :) hit 

[Prob_ROI diff: -0.08179891412226536 (up%-> -9.10646628192863) . o: 0.8982508866758954 -> a: 0.81645197255363	 returnMoney: o:0.12305040780966897 a: 0.11184486391267225 (probReturnRate: 0.9089353371804411	 totalSpendMoney: o: 0.13698890770376462 a: 0.13698890770372354 (probTotalSpendRate: 0.9999999999997001

[Time_ROI diff: 0.7388107341293296 (up%-> 110.99744245524296) . o: 0.6656105922685897 -> a: 1.4044213263979193	 returnMoney: o:5.91192E7 a: 324000.0 (timeReturnRate: 0.005480453050785532	 totalSpendMoney: o: 8.88195E7 a: 230700.0 (timeTotalSpendRate: 0.0025974025974025974

[[Per_Prob_ROI diff: 0.8141188533674588 (up%-> 34894.01048145747) . o: 0.002333119186171157 -> a: 0.81645197255363	 per returnMoney: o:3.1961144885628306E-4 a: 0.11184486391267225	 per totalSpendMoney: o: 3.5581534468510294E-4 a: 0.13698890770372354

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.09300445801922101

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.011205543896955647     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9089353371807136 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Ten, 	playerStartValue=7	@@@ 

net money diff:  -0.005406111786384449 , up % -> -19.72231895270722 .  o: -0.027411136587679866 -> a: -0.032817248374064314 (anet/onet: 1.1972231895270722

[ProbMatrix: total: o: 4.566296923457134E-4  -> a: 4.5662969234574503E-4
org->adv	$w:34.31753989568937->32.438494438672855  	$d:11.355171209852436->11.166875604703376  	$l:54.32728889445819->56.394629956623774
	 improve value x$w(high is good):-1.8790454570165167  	x$d:-0.18829560514905985  	 x$l(negative is good):2.067341062165582
	 	 $w-$l: -20.009748998768824 -> -23.956135517950923  _ #Surrender#	 lift : -3.946386519182099 : bad	 :| stand

[TimeMatrix: total:  o: 148225.0 -> a: 385.0
org->adv	$w:31.450834879406308->65.97402597402598  	$d:3.5837409343902853->8.311688311688311  	$l:64.9654241862034->25.71428571428571
	 improve value x$w(high is good):34.52319109461967  	x$d:4.727947377298026  	 x$l(negative is good):-39.2511384719177
	 	 $w-$l: -33.51458930679709 -> 40.25974025974026  _ @double@	 lift : 73.77432956653736 : good	 :) hit 

[Prob_ROI diff: -0.03946386519177292 (up%-> -4.933584367820992) . o: 0.7999025100122663 -> a: 0.7604386448204934	 returnMoney: o:0.109577771116061 a: 0.10417165932965904 (probReturnRate: 0.9506641563216686	 totalSpendMoney: o: 0.13698890770374086 a: 0.13698890770372335 (probTotalSpendRate: 0.9999999999998721

[Time_ROI diff: 0.7377432956653736 (up%-> 110.96318545277428) . o: 0.6648541069320291 -> a: 1.4025974025974026	 returnMoney: o:2.95644E7 a: 162000.0 (timeReturnRate: 0.005479563258513617	 totalSpendMoney: o: 4.44675E7 a: 115500.0 (timeTotalSpendRate: 0.0025974025974025974

[[Per_Prob_ROI diff: 0.7583609759633186 (up%-> 36500.57001838891) . o: 0.002077668857174718 -> a: 0.7604386448204934	 per returnMoney: o:2.846175873144442E-4 a: 0.10417165932965904	 per totalSpendMoney: o: 3.558153446850412E-4 a: 0.13698890770372335

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.044869976978157367

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.005406111786384449     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9506641563217901 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


MatrixKey [startValue=Seven, dealerCard=Three3, situation=Start_With_A] : Stand -> Double
MatrixKey [startValue=Seven, dealerCard=Four4, situation=Start_With_A] : Stand -> Double
MatrixKey [startValue=Seven, dealerCard=Five5, situation=Start_With_A] : Stand -> Double
MatrixKey [startValue=Seven, dealerCard=Six6, situation=Start_With_A] : Stand -> Double


		 @@@   dealerCard=Three3, 	playerStartValue=7	@@@ 

net money diff:  0.004100924024306868 , up % -> 20.29316365322186 .  o: 0.020208401678442983 -> a: 0.02430932570274985 (anet/onet: 1.2029316365322187

[ProbMatrix: total: o: 4.566296923457585E-4  -> a: 4.566296923458331E-4
org->adv	$w:50.84898508266357->50.5181560858196  	$d:13.053882387688237->7.8364228951189965  	$l:36.0971325296482->41.6454210190614
	 improve value x$w(high is good):-0.3308289968439695  	x$d:-5.21745949256924  	 x$l(negative is good):5.548288489413203
	 	 $w-$l: 14.751852553015372 -> 8.872735066758198  _ @double@	 lift : -5.879117486257174 : bad	 :| stand

[TimeMatrix: total:  o: 15553.0 -> a: 202189.0
org->adv	$w:66.295891467884->66.3107290703253  	$d:8.371375297370284->5.167442343549847  	$l:25.332733234745707->28.521828586124865
	 improve value x$w(high is good):0.014837602441289732  	x$d:-3.203932953820437  	 x$l(negative is good):3.1890953513791587
	 	 $w-$l: 40.963158233138294 -> 37.788900484200425  _ @double@	 lift : -3.17425774893787 : bad	 :| stand

[Prob_ROI diff: -0.05879117486277896 (up%-> -5.123331219042096) . o: 1.1475185255301743 -> a: 1.0887273506673953	 returnMoney: o:0.1571973093821702 a: 0.2982871411102689 (probReturnRate: 1.8975333756196056	 totalSpendMoney: o: 0.1369889077037272 a: 0.27397781540751903 (probTotalSpendRate: 2.0000000000004716

[Time_ROI diff: -0.0317425774893787 (up%-> -2.2518350104556966) . o: 1.409631582331383 -> a: 1.3778890048420043	 returnMoney: o:6577200.0 a: 1.671564E8 (timeReturnRate: 25.41452289728152	 totalSpendMoney: o: 4665900.0 a: 1.213134E8 (timeTotalSpendRate: 26.0

[[Per_Prob_ROI diff: -1.0637702677865286 (up%-> -92.7017947091571) . o: 1.1475185255301743 -> a: 0.08374825774364579	 per returnMoney: o:0.1571973093821702 a: 0.022945164700789913	 per totalSpendMoney: o: 0.1369889077037272 a: 0.021075216569809156

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.05469025083847209

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.004100924024306868     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9487666878095791 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Four4, 	playerStartValue=7	@@@ 

net money diff:  0.008628643624528476 , up % -> 35.6301069742967 .  o: 0.02421728239758897 -> a: 0.032845926022117444 (anet/onet: 1.3563010697429672

[ProbMatrix: total: o: 4.566296923457549E-4  -> a: 4.56629692345817E-4
org->adv	$w:52.63606408551497->52.23429332579646  	$d:12.406151628064562->7.5199482497758  	$l:34.95778428642048->40.24575842442775
	 improve value x$w(high is good):-0.4017707597185094  	x$d:-4.886203378288761  	 x$l(negative is good):5.287974138007272
	 	 $w-$l: 17.678279799094486 -> 11.988534901368709  _ @double@	 lift : -5.689744897725779 : bad	 :| stand

[TimeMatrix: total:  o: 9073.0 -> a: 117949.0
org->adv	$w:66.27355891105478->66.2922110403649  	$d:8.376501708365481->5.170031115142986  	$l:25.349939380579745->28.537757844492113
	 improve value x$w(high is good):0.018652129310126497  	x$d:-3.2064705932224955  	 x$l(negative is good):3.187818463912368
	 	 $w-$l: 40.92361953047503 -> 37.75445319587279  _ @double@	 lift : -3.1691663346022416 : bad	 :| stand

[Prob_ROI diff: -0.05689744897731441 (up%-> -4.835000059012746) . o: 1.1767827979909529 -> a: 1.1198853490136385	 returnMoney: o:0.16120619010131432 a: 0.30682374142957664 (probReturnRate: 1.903299998819804	 totalSpendMoney: o: 0.13698890770372535 a: 0.2739778154074592 (probTotalSpendRate: 2.000000000000062

[Time_ROI diff: -0.03169166334602247 (up%-> -2.2488539147384787) . o: 1.4092361953047503 -> a: 1.3775445319587278	 returnMoney: o:3835800.0 a: 9.7488E7 (timeReturnRate: 25.415297982167996	 totalSpendMoney: o: 2721900.0 a: 7.07694E7 (timeTotalSpendRate: 26.0

[[Per_Prob_ROI diff: -1.0906377711437498 (up%-> -92.67961538915482) . o: 1.1767827979909529 -> a: 0.08614502684720296	 per returnMoney: o:0.16120619010131432 a: 0.02360182626381359	 per totalSpendMoney: o: 0.13698890770372535 a: 0.02107521656980455

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.04826880535278594

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.008628643624528476     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9516499994098725 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Five5, 	playerStartValue=7	@@@ 

net money diff:  0.013564424179749207 , up % -> 48.79294448752187 .  o: 0.027799970512577127 -> a: 0.041364394692326334 (anet/onet: 1.4879294448752187

[ProbMatrix: total: o: 4.566296923457527E-4  -> a: 4.566296923457857E-4
org->adv	$w:54.02494007796833->53.89463988944732  	$d:12.243712207542522->7.308437031064441  	$l:33.73134771448915->38.79692307948825
	 improve value x$w(high is good):-0.13030018852101222  	x$d:-4.935275176478081  	 x$l(negative is good):5.0655753649991055
	 	 $w-$l: 20.293592363479185 -> 15.09771680995906  _ @double@	 lift : -5.195875553520124 : bad	 :| stand

[TimeMatrix: total:  o: 5473.0 -> a: 71149.0
org->adv	$w:66.270783847981->66.28202785703242  	$d:8.368353736524758->5.169433161393695  	$l:25.360862415494246->28.548538981573877
	 improve value x$w(high is good):0.011244009051424086  	x$d:-3.198920575131064  	 x$l(negative is good):3.187676566079631
	 	 $w-$l: 40.909921432486755 -> 37.73348887545854  _ @double@	 lift : -3.176432557028208 : bad	 :| stand

[Prob_ROI diff: -0.05195875553520679 (up%-> -4.319328612134887) . o: 1.2029359236347954 -> a: 1.1509771680995886	 returnMoney: o:0.16478887821630192 a: 0.3153422100997612 (probReturnRate: 1.9136134277571994	 totalSpendMoney: o: 0.1369889077037248 a: 0.2739778154074349 (probTotalSpendRate: 1.9999999999998925

[Time_ROI diff: -0.03176432557028197 (up%-> -2.2542291733163022) . o: 1.4090992143248675 -> a: 1.3773348887545855	 returnMoney: o:2313600.0 a: 5.87976E7 (timeReturnRate: 25.41390041493776	 totalSpendMoney: o: 1641900.0 a: 4.26894E7 (timeTotalSpendRate: 26.0

[[Per_Prob_ROI diff: -1.1143992183963656 (up%-> -92.6399483547796) . o: 1.2029359236347954 -> a: 0.0885367052384299	 per returnMoney: o:0.16478887821630192 a: 0.024257093084597017	 per totalSpendMoney: o: 0.1369889077037248 a: 0.02107521656980268

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.038394331355457584

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.013564424179749207     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9568067138786511 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Six6, 	playerStartValue=7	@@@ 

net money diff:  0.01339885681261968 , up % -> 34.526326331940695 .  o: 0.038807652698990586 -> a: 0.052206509511610266 (anet/onet: 1.345263263319407

[ProbMatrix: total: o: 4.5662969234574867E-4  -> a: 4.5662969234576216E-4
org->adv	$w:58.854821525511824->56.077290351592346  	$d:10.619404424062473->6.900432723348835  	$l:30.525774050425696->37.02227692505882
	 improve value x$w(high is good):-2.7775311739194777  	x$d:-3.718971700713638  	 x$l(negative is good):6.496502874633123
	 	 $w-$l: 28.329047475086128 -> 19.055013426533527  _ @double@	 lift : -9.274034048552599 : bad	 :| stand

[TimeMatrix: total:  o: 3109.0 -> a: 40417.0
org->adv	$w:66.22708266323578->66.26172155281193  	$d:8.394982309424252->5.176039785238885  	$l:25.37793502733998->28.56223866194918
	 improve value x$w(high is good):0.034638889576157794  	x$d:-3.2189425241853673  	 x$l(negative is good):3.1843036346092006
	 	 $w-$l: 40.84914763589579 -> 37.699482890862754  _ @double@	 lift : -3.1496647450330317 : bad	 :| stand

[Prob_ROI diff: -0.09274034048553292 (up%-> -7.226761384910707) . o: 1.2832904747508669 -> a: 1.190550134265334	 returnMoney: o:0.1757965604027143 a: 0.32618432491904875 (probReturnRate: 1.8554647723017252	 totalSpendMoney: o: 0.1369889077037237 a: 0.2739778154074385 (probTotalSpendRate: 1.9999999999999347

[Time_ROI diff: -0.031496647450330206 (up%-> -2.236197235055415) . o: 1.4084914763589578 -> a: 1.3769948289086276	 returnMoney: o:1313700.0 a: 3.33924E7 (timeReturnRate: 25.41858871888559	 totalSpendMoney: o: 932700.0 a: 2.42502E7 (timeTotalSpendRate: 26.0

[[Per_Prob_ROI diff: -1.191709695191995 (up%-> -92.86359702960851) . o: 1.2832904747508669 -> a: 0.09158077955887184	 per returnMoney: o:0.1757965604027143 a: 0.025091101916849903	 per totalSpendMoney: o: 0.1369889077037237 a: 0.02107521656980296

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.07934148367291324

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.01339885681261968     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9277323861508929 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 */
	}
	
	public static void test22vsAll() {
		StrategyMatrix8012 o = new Myth2019April22();
		StrategyMatrix8012 t = new MirMyth2019April22();
		
		System.out.println(t.diffWith(o));
		
		for(Card playerCard : Card.values()) {
			if(playerCard.getValue() == 2) {
				for(Card dealerCard : Card.values()) {
					if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
//					if(dealerCard != Card.Seven7 && dealerCard != Card.Four4) continue;
					PlayerCardsPathValue nine = new PlayerCardsPathValue(playerCard,playerCard);
					Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, nine, dealerCard); 
//					HelloWorld.print(origin);
					PlayerCardsPathValue ninet = new PlayerCardsPathValue(playerCard,playerCard);
					Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, ninet, dealerCard); 
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
MatrixKey [startValue=Two, dealerCard=One1, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Two, dealerCard=One1, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Two, dealerCard=Two2, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Two, dealerCard=Two2, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Two, dealerCard=Three3, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Two, dealerCard=Three3, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Two, dealerCard=Four4, situation=Start_With_Pair] : Hit -> Split
MatrixKey [startValue=Two, dealerCard=Four4, situation=Splited_Pair_And_Can_Split] : Hit -> Split
MatrixKey [startValue=Two, dealerCard=Five5, situation=Start_With_Pair] : Hit -> Split
MatrixKey [startValue=Two, dealerCard=Five5, situation=Splited_Pair_And_Can_Split] : Hit -> Split
MatrixKey [startValue=Two, dealerCard=Six6, situation=Splited_Pair_And_Can_Split] : Hit -> Split
MatrixKey [startValue=Two, dealerCard=Six6, situation=Start_With_Pair] : Hit -> Split
MatrixKey [startValue=Two, dealerCard=Seven7, situation=Start_With_Pair] : Hit -> Split
MatrixKey [startValue=Two, dealerCard=Seven7, situation=Splited_Pair_And_Can_Split] : Hit -> Split
MatrixKey [startValue=Two, dealerCard=Eight8, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Two, dealerCard=Eight8, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Two, dealerCard=Nine9, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Two, dealerCard=Nine9, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Two, dealerCard=Ten, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Two, dealerCard=Ten, situation=Splited_Pair_And_Can_Split] : Split -> Hit


		 @@@   dealerCard=One1, 	playerStartValue=2	@@@ 

net money diff:  3.9456182404908557 , up % -> 98.52208887664156 .  o: -4.004805709541057 -> a: -0.05918746905020149 (anet/onet: 0.014779111233584476

[ProbMatrix: total: o: 0.03240646915031081  -> a: 4.376034551566526E-4
org->adv	$w:23.8030241040318->22.21052550101096  	$d:11.200471825068622->10.494395570160284  	$l:64.99650407089959->67.29507892882876
	 improve value x$w(high is good):-1.5924986030208395  	x$d:-0.7060762549083375  	 x$l(negative is good):2.298574857929168
	 	 $w-$l: -41.1934799668678 -> -45.084553427817795  _ #Surrender#	 lift : -3.891073460950001 : bad	 :| stand

[TimeMatrix: total:  o: 2.803208356E9 -> a: 1.28918257E8
org->adv	$w:31.553124836647->31.583756209176794  	$d:3.507987117315799->3.5082913043107613  	$l:64.9388880460372->64.90795248651244
	 improve value x$w(high is good):0.03063137252979331  	x$d:3.0418699496248536E-4  	 x$l(negative is good):-0.03093555952476379
	 	 $w-$l: -33.3857632093902 -> -33.32419627733565  _ #Surrender#	 lift : 0.06156693205455199 : good	 :| stand

[Prob_ROI diff: -0.038910734763397126 (up%-> -6.616738199689694) . o: 0.5880652005427981 -> a: 0.549154465779401	 returnMoney: o:5.717135031610474 a: 0.07209356748600833 (probReturnRate: 0.012610086535895603	 totalSpendMoney: o: 9.721940741151531 a: 0.13128103653620982 (probTotalSpendRate: 0.013503583289755788

[Time_ROI diff: 6.156693205455754E-4 (up%-> 0.09242308404445498) . o: 0.6661423679060979 -> a: 0.6667580372266435	 returnMoney: o:5.602007556E11 a: 2.57871852E10 (timeReturnRate: 0.0460320428743099	 totalSpendMoney: o: 8.409625068E11 a: 3.86754771E10 (timeTotalSpendRate: 0.0459895379250218

[[Per_Prob_ROI diff: 5.115272900385365E-5 (up%-> 545.716487993615) . o: 9.373498900852733E-6 -> a: 6.052622790470638E-5	 per returnMoney: o:9.11286008513393E-5 a: 7.94594593695672E-6	 per totalSpendMoney: o: 1.549634305298553E-4 a: 1.4469418773967797E-5

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 3.9067075057274585

 按net净收益值(代表少输多赢) :  $Change$  Value: 3.9456182404908557     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9338326180031031 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Two2, 	playerStartValue=2	@@@ 

net money diff:  0.41209593141498135 , up % -> 95.78233782191646 .  o: -0.4302420892891252 -> a: -0.01814615787414385 (anet/onet: 0.04217662178083541

[ProbMatrix: total: o: 0.03240646916473071  -> a: 4.376034551639181E-4
org->adv	$w:43.12942167422212->41.20997730662286  	$d:5.966021011130659->3.757669853927196  	$l:50.90455731464723->55.03235283944995
	 improve value x$w(high is good):-1.9194443675992616  	x$d:-2.2083511572034626  	 x$l(negative is good):4.127795524802721
	 	 $w-$l: -7.775135640425102 -> -13.822375532827092  _ #Surrender#	 lift : -6.04723989240199 : bad	 :| stand

[TimeMatrix: total:  o: 2.47994188E8 -> a: 1.3477945E7
org->adv	$w:56.56556596398945->57.10990065622021  	$d:4.0640339522795585->4.131431015633318  	$l:39.37040008373099->38.75866832814647
	 improve value x$w(high is good):0.5443346922307626  	x$d:0.06739706335375928  	 x$l(negative is good):-0.6117317555845219
	 	 $w-$l: 17.195165880258457 -> 18.351232328073745  _ @double@	 lift : 1.1560664478152904 : good	 :) hit 

[Prob_ROI diff: -0.10004132123357912 (up%-> -10.401278244337586) . o: 0.9618175659135089 -> a: 0.8617762446799297	 returnMoney: o:10.837821343087603 a: 0.11313487867507079 (probReturnRate: 0.01043889496732003	 totalSpendMoney: o: 11.268063432376728 a: 0.13128103654921464 (probTotalSpendRate: 0.011650718629432143

[Time_ROI diff: 0.006551933195918069 (up%-> 0.5566825571288676) . o: 1.1769603900848196 -> a: 1.1835123232807376	 returnMoney: o:8.90338776E10 a: 4.7853942E9 (timeReturnRate: 0.05374801512632311	 totalSpendMoney: o: 7.56473016E10 a: 4.0433835E9 (timeTotalSpendRate: 0.053450465707027946

[[Per_Prob_ROI diff: 0.001378110158152982 (up%-> 419.6725861828421) . o: 3.2837745507460184E-4 -> a: 0.0017064876132275838	 per returnMoney: o:0.003700177993543053 a: 2.2402946272291244E-4	 per totalSpendMoney: o: 0.003847068430309569 a: 2.599624486123062E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.31205461018140224

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.41209593141498135     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.895987217556624 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Three3, 	playerStartValue=2	@@@ 

net money diff:  0.09821748240209283 , up % -> 87.75079904566083 .  o: -0.1119277356676669 -> a: -0.013710253265574068 (anet/onet: 0.12249200954339162

[ProbMatrix: total: o: 0.032406469165215133  -> a: 4.3760345516432583E-4
org->adv	$w:44.4490649735081->42.96023150706212  	$d:5.700550722965392->3.6360992842894997  	$l:49.85038430352651->53.40366920864839
	 improve value x$w(high is good):-1.488833466445982  	x$d:-2.0644514386758925  	 x$l(negative is good):3.5532849051218776
	 	 $w-$l: -5.401319330018406 -> -10.443437701586266  _ #Surrender#	 lift : -5.042118371567861 : bad	 :| stand

[TimeMatrix: total:  o: 1.41159028E8 -> a: 7854265.0
org->adv	$w:56.59006096301542->57.09385919624561  	$d:4.06281913474213->4.133805009125615  	$l:39.347119902242454->38.77233579462877
	 improve value x$w(high is good):0.5037982332301922  	x$d:0.07098587438348503  	 x$l(negative is good):-0.5747841076136808
	 	 $w-$l: 17.242941060772964 -> 18.321523401616837  _ @double@	 lift : 1.07858234084387 : good	 :) hit 

[Prob_ROI diff: -0.09513892183068251 (up%-> -9.603157906993403) . o: 0.9907045448185179 -> a: 0.8955656229878354	 returnMoney: o:11.929197037936065 a: 0.11757078328407744 (probReturnRate: 0.009855716433402042	 totalSpendMoney: o: 12.041124773603732 a: 0.1312810365496515 (probTotalSpendRate: 0.010902722047814227

[Time_ROI diff: 0.004158195897730144 (up%-> 0.3526713096395974) . o: 1.1790570381184382 -> a: 1.1832152340161683	 returnMoney: o:5.12176824E10 a: 2.7879858E9 (timeReturnRate: 0.05443404834733404	 totalSpendMoney: o: 4.3439529E10 a: 2.3562795E9 (timeTotalSpendRate: 0.054242749731471536

[[Per_Prob_ROI diff: 0.0014266333443603127 (up%-> 411.4134215043956) . o: 3.467639288829254E-4 -> a: 0.001773397273243238	 per returnMoney: o:0.004175427734664356 a: 2.328134322456979E-4	 per totalSpendMoney: o: 0.004214604400981355 a: 2.599624486131713E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.003078560571410316

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.09821748240209283     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.903968420930066 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Four4, 	playerStartValue=2	@@@ 

net money diff:  0.24520817968587777 , up % -> 2737.5554708784316 .  o: -0.00895719492424367 -> a: 0.2362509847616341 (anet/onet: -26.375554708784314

[ProbMatrix: total: o: 4.376034551641727E-4  -> a: 0.03240646916567735
org->adv	$w:45.105345123086764->46.859754335008475  	$d:2.966393695203666->3.797499073185938  	$l:51.928261181709566->49.34274659180559
	 improve value x$w(high is good):1.7544092119217112  	x$d:0.8311053779822721  	 x$l(negative is good):-2.5855145899039726
	 	 $w-$l: -6.822916058622802 -> -2.482992256797117  _ #Surrender#	 lift : 4.339923801825685 : good	 :) hit 

[TimeMatrix: total:  o: 2295469.0 -> a: 4.119142E7
org->adv	$w:68.51902595940089->67.54696973301722  	$d:4.762338328245774->4.622020799477173  	$l:26.718635712353333->27.831009467505613
	 improve value x$w(high is good):-0.9720562263836712  	x$d:-0.14031752876860093  	 x$l(negative is good):1.11237375515228
	 	 $w-$l: 41.80039024704756 -> 39.715960265511605  _ @double@	 lift : -2.0844299815359566 : bad	 :| stand

[Prob_ROI diff: 0.08784950246989187 (up%-> 9.42823049977256) . o: 0.9317708394169094 -> a: 1.0196203418868013	 returnMoney: o:0.1223238416251574 a: 12.27737575846205 (probReturnRate: 100.36780725121584	 totalSpendMoney: o: 0.13128103654940107 a: 12.041124773700416 (probTotalSpendRate: 91.7202140552062

[Time_ROI diff: -0.018949978221271424 (up%-> -1.3363840669448357) . o: 1.4180039024704756 -> a: 1.3990539242492042	 returnMoney: o:9.764952E8 a: 1.81797972E10 (timeReturnRate: 18.617395354324323	 totalSpendMoney: o: 6.886407E8 a: 1.29943506E10 (timeTotalSpendRate: 18.869565217391305

[[Per_Prob_ROI diff: -0.002969368510081687 (up%-> -80.62607255672326) . o: 0.003682888693347468 -> a: 7.135201832657812E-4	 per returnMoney: o:4.834934451587249E-4 a: 0.008591585555256858	 per totalSpendMoney: o: 5.188973776656169E-4 a: 0.008426259463751166

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.33305768215576964

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.24520817968587777     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.0942823049977257 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Five5, 	playerStartValue=2	@@@ 

net money diff:  0.6732008052535311 , up % -> 17805.56720667142 .  o: -0.003780844482175749 -> a: 0.6694199607713553 (anet/onet: -177.0556720667142

[ProbMatrix: total: o: 4.3760345516444406E-4  -> a: 0.03240646916587431
org->adv	$w:47.13342805856603->48.81456852581769  	$d:2.8531814894368823->3.6550955666692713  	$l:50.01339045199708->47.53033590751303
	 improve value x$w(high is good):1.6811404672516588  	x$d:0.8019140772323889  	 x$l(negative is good):-2.4830545444840553
	 	 $w-$l: -2.879962393431051 -> 1.2842326183046648  _ #Surrender#	 lift : 4.164195011735716 : good	 :) hit 

[TimeMatrix: total:  o: 1384669.0 -> a: 2.484742E7
org->adv	$w:68.50741946270192->67.53496338855301  	$d:4.764171076264436->4.624045474338986  	$l:26.728409461033646->27.840991137107995
	 improve value x$w(high is good):-0.9724560741489086  	x$d:-0.1401256019254502  	 x$l(negative is good):1.112581676074349
	 	 $w-$l: 41.77901000166827 -> 39.69397225144502  _ @double@	 lift : -2.085037750223245 : bad	 :| stand

[Prob_ROI diff: 0.08439409482783078 (up%-> 8.68966867265927) . o: 0.9712003760668579 -> a: 1.0555944708946887	 returnMoney: o:0.12750019206722274 a: 12.710544734481722 (probReturnRate: 99.69039676254182	 totalSpendMoney: o: 0.1312810365493985 a: 12.041124773710367 (probTotalSpendRate: 91.7202140552838

[Time_ROI diff: -0.01895554249696696 (up%-> -1.3369780545613852) . o: 1.4177901000166826 -> a: 1.3988345575197156	 returnMoney: o:5.88951E8 a: 1.09646676E10 (timeReturnRate: 18.617283271443636	 totalSpendMoney: o: 4.154007E8 a: 7.8384306E9 (timeTotalSpendRate: 18.869565217391305

[[Per_Prob_ROI diff: -0.00310004214302598 (up%-> -80.75683262828356) . o: 0.003838736664295881 -> a: 7.386945212699012E-4	 per returnMoney: o:5.039533283289436E-4 a: 0.008894712900267126	 per totalSpendMoney: o: 5.188973776656066E-4 a: 0.00842625946375813

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.7575949000813619

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.6732008052535311     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.0868966867265926 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Six6, 	playerStartValue=2	@@@ 

net money diff:  0.9418458845825036 , up % -> 69498.95582462513 .  o: -0.0013551942952339802 -> a: 0.9404906902872696 (anet/onet: -693.9895582462512

[ProbMatrix: total: o: 4.3760345516461916E-4  -> a: 0.03240646916599428
org->adv	$w:48.0440610824553->49.86893981273353  	$d:2.879592951525948->3.6575648831289707  	$l:49.07634596601875->46.473495304137494
	 improve value x$w(high is good):1.824878730278229  	x$d:0.7779719316030227  	 x$l(negative is good):-2.6028506618812557
	 	 $w-$l: -1.0322848835634502 -> 3.3954445085960403  _ #Surrender#	 lift : 4.427729392159491 : good	 :) hit 

[TimeMatrix: total:  o: 786577.0 -> a: 1.411486E7
org->adv	$w:68.49348506249228->67.52149153445376  	$d:4.76583983513375->4.624544628852146  	$l:26.740675102373956->27.853963836694096
	 improve value x$w(high is good):-0.9719935280385243  	x$d:-0.14129520628160464  	 x$l(negative is good):1.1132887343201396
	 	 $w-$l: 41.752809960118334 -> 39.66752769775967  _ @double@	 lift : -2.0852822623586675 : bad	 :| stand

[Prob_ROI diff: 0.08842939684979056 (up%-> 8.93517615777201) . o: 0.9896771511647563 -> a: 1.0781065480145469	 returnMoney: o:0.12992584225420617 a: 12.981615464001617 (probReturnRate: 99.9155767534103	 totalSpendMoney: o: 0.13128103654944015 a: 12.041124773714348 (probTotalSpendRate: 91.72021405528503

[Time_ROI diff: -0.018958221995416302 (up%-> -1.3374141931119483) . o: 1.4175280996011834 -> a: 1.3985698776057671	 returnMoney: o:3.344985E8 a: 6.2274258E9 (timeReturnRate: 18.6172009739954	 totalSpendMoney: o: 2.359731E8 a: 4.4527098E9 (timeTotalSpendRate: 18.869565217391305

[[Per_Prob_ROI diff: -0.003157319146772685 (up%-> -80.7133662925708) . o: 0.0039117673959081275 -> a: 7.544482491354422E-4	 per returnMoney: o:5.135408784751232E-4 a: 0.009084405503150187	 per totalSpendMoney: o: 5.188973776657713E-4 a: 0.008426259463760915

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.030275281432294

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.9418458845825036     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.0893517615777202 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Seven7, 	playerStartValue=2	@@@ 

net money diff:  0.006031478954502345 , up % -> 51.47740613400872 .  o: -0.01171674994423938 -> a: -0.005685270989737035 (anet/onet: 0.48522593865991287

[ProbMatrix: total: o: 4.3760345516271785E-4  -> a: 0.032406469164574375
org->adv	$w:40.931101249908515->43.567228554101014  	$d:9.212860393028087->9.332146582038558  	$l:49.8560383570634->47.10062486386043
	 improve value x$w(high is good):2.636127304192499  	x$d:0.11928618901047017  	 x$l(negative is good):-2.7554134932029655
	 	 $w-$l: -8.924937107154884 -> -3.533396309759418  _ #Surrender#	 lift : 5.391540797395466 : good	 :) hit 

[TimeMatrix: total:  o: 1.7429233E7 -> a: 2.99591476E8
org->adv	$w:31.435577228211937->31.427474925888742  	$d:3.553214303807861->3.5517232139141366  	$l:65.01120846798021->65.02080186019712
	 improve value x$w(high is good):-0.008102302323194976  	x$d:-0.0014910898937245953  	 x$l(negative is good):0.009593392216913799
	 	 $w-$l: -33.57563123976827 -> -33.59332693430838  _ #Surrender#	 lift : -0.017695694540104112 : bad	 :| stand

[Prob_ROI diff: 0.08874482376086812 (up%-> 9.744140815397387) . o: 0.9107506289383289 -> a: 0.999495452699197	 returnMoney: o:0.11956428660382931 a: 11.262378160703571 (probReturnRate: 94.19516881341781	 totalSpendMoney: o: 0.1312810365480687 a: 11.268063431693308 (probTotalSpendRate: 85.83161534962055

[Time_ROI diff: 6.316669063078928E-4 (up%-> 0.09509565812932072) . o: 0.6642436876023173 -> a: 0.6648753545086252	 returnMoney: o:3.4731774E9 a: 5.98170708E10 (timeReturnRate: 17.22257861058292	 totalSpendMoney: o: 5.2287699E9 a: 8.99673456E10 (timeTotalSpendRate: 17.20621624600463

[[Per_Prob_ROI diff: -7.996620406030416E-5 (up%-> -79.66323012973388) . o: 1.0038031841048485E-4 -> a: 2.0414114350180696E-5	 per returnMoney: o:1.3178032249953633E-5 a: 2.300275353996767E-4	 per totalSpendMoney: o: 1.4469418775274847E-5 a: 2.3014365375897773E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.09477630271537046

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.006031478954502345     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.0974414081539738 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Eight8, 	playerStartValue=2	@@@ 

net money diff:  0.8126565028998175 , up % -> 97.44599742199608 .  o: -0.8339557543657303 -> a: -0.0212992514659128 (anet/onet: 0.02554002578003921

[ProbMatrix: total: o: 0.03240646916536934  -> a: 4.376034551635536E-4
org->adv	$w:39.625553609144355->37.21973533275032  	$d:9.575764300032459->9.336364728001028  	$l:50.79868209082319->53.44389993924865
	 improve value x$w(high is good):-2.4058182763940366  	x$d:-0.2393995720314308  	 x$l(negative is good):2.6452178484254603
	 	 $w-$l: -11.173128481678834 -> -16.22416460649833  _ #Surrender#	 lift : -5.051036124819497 : bad	 :| stand

[TimeMatrix: total:  o: 1.79817268E8 -> a: 1.0461169E7
org->adv	$w:31.418119421100315->31.42623926637644  	$d:3.553296116143862->3.5548990748548275  	$l:65.02858446275582->65.01886165876873
	 improve value x$w(high is good):0.00811984527612708  	x$d:0.0016029587109653853  	 x$l(negative is good):-0.009722803987088469
	 	 $w-$l: -33.61046504165551 -> -33.59262239239228  _ #Surrender#	 lift : 0.01784264926322776 : good	 :| stand

[Prob_ROI diff: -0.08823107987806889 (up%-> -9.528303094573799) . o: 0.9259894338197002 -> a: 0.8377583539416313	 returnMoney: o:10.43410767774072 a: 0.10998178508280482 (probReturnRate: 0.010540602845936798	 totalSpendMoney: o: 11.26806343210645 a: 0.13128103654871762 (probTotalSpendRate: 0.011650718629667491

[Time_ROI diff: -6.301112124404984E-4 (up%-> -0.09479577665941884) . o: 0.6647038872885177 -> a: 0.6640737760760772	 returnMoney: o:3.58934388E10 a: 2.0840964E9 (timeReturnRate: 0.05806343637378094	 totalSpendMoney: o: 5.39991408E10 a: 3.1383507E9 (timeTotalSpendRate: 0.05811853028594855

[[Per_Prob_ROI diff: 7.342252292349578E-5 (up%-> 388.2161084742172) . o: 1.8912796589524318E-5 -> a: 9.23353195130201E-5	 per returnMoney: o:2.1311059164928655E-4 a: 1.212187645572631E-5	 per totalSpendMoney: o: 2.301436537674159E-4 a: 1.446941877534637E-5

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.7244254230217486

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.8126565028998175     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.904716969054262 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Nine9, 	playerStartValue=2	@@@ 

net money diff:  1.7315837820262858 , up % -> 98.18456411474078 .  o: -1.763600824262678 -> a: -0.03201704223639222 (anet/onet: 0.018154358852592298

[ProbMatrix: total: o: 0.0324064691655058  -> a: 4.376034551638934E-4
org->adv	$w:35.329268390031984->33.10321628732395  	$d:9.636580307323515->9.40539752768526  	$l:55.034151302644496->57.49138618499079
	 improve value x$w(high is good):-2.2260521027080316  	x$d:-0.23118277963825484  	 x$l(negative is good):2.4572348823462917
	 	 $w-$l: -19.704882912612508 -> -24.388169897666835  _ #Surrender#	 lift : -4.683286985054325 : bad	 :| stand

[TimeMatrix: total:  o: 1.4827858E8 -> a: 6977137.0
org->adv	$w:31.3922105269689->31.398064850955343  	$d:3.557331072363925->3.5570750581506423  	$l:65.05045840066718->65.04486009089402
	 improve value x$w(high is good):0.005854323986444143  	x$d:-2.5601421328280694E-4  	 x$l(negative is good):-0.0055983097731626685
	 	 $w-$l: -33.65824787369828 -> -33.646795239938676  _ #Surrender#	 lift : 0.011452633759601039 : good	 :| stand

[Prob_ROI diff: -0.08736848488722326 (up%-> -10.358014653715388) . o: 0.8434867859149481 -> a: 0.7561183010277248	 returnMoney: o:9.504462607776402 a: 0.09926399431252882 (probReturnRate: 0.01044393548682201	 totalSpendMoney: o: 11.26806343203908 a: 0.13128103654892104 (probTotalSpendRate: 0.011650718629755202

[Time_ROI diff: -5.393195685956531E-4 (up%-> -0.0812140976495726) . o: 0.6640713671692089 -> a: 0.6635320476006132	 returnMoney: o:2.95641672E10 a: 1.3888662E9 (timeReturnRate: 0.046978025479439176	 totalSpendMoney: o: 4.45195632E10 a: 2.0931411E9 (timeTotalSpendRate: 0.04701620926954647

[[Per_Prob_ROI diff: 6.956574970110973E-5 (up%-> 505.1451516008581) . o: 1.377143767106317E-5 -> a: 8.33371873721729E-5	 per returnMoney: o:1.5517743322791233E-4 a: 1.0940592341290513E-5	 per totalSpendMoney: o: 1.8397138617837157E-4 a: 1.4469418775368791E-5

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.6442152971390624

 按net净收益值(代表少输多赢) :  $Change$  Value: 1.7315837820262858     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.8964198534628461 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Ten, 	playerStartValue=2	@@@ 

net money diff:  2.7742980676133726 , up % -> 98.4330782671446 .  o: -2.8184611478714565 -> a: -0.04416308025808381 (anet/onet: 0.015669217328554065

[ProbMatrix: total: o: 0.03240646916582846  -> a: 4.376034551643099E-4
org->adv	$w:30.463770969012334->28.461717408376035  	$d:10.081732646061806->9.4364588745138  	$l:59.45449638492587->62.10182371711016
	 improve value x$w(high is good):-2.0020535606362984  	x$d:-0.6452737715480055  	 x$l(negative is good):2.6473273321842896
	 	 $w-$l: -28.990725415913538 -> -33.640106308734126  _ #Surrender#	 lift : -4.649380892820587 : bad	 :| stand

[TimeMatrix: total:  o: 7.595434E7 -> a: 3493105.0
org->adv	$w:31.326510111206286->31.357545793785185  	$d:3.5628141854698496->3.5634199372764344  	$l:65.11067570332386->65.07903426893839
	 improve value x$w(high is good):0.031035682578899326  	x$d:6.057518065847312E-4  	 x$l(negative is good):-0.031641434385477396
	 	 $w-$l: -33.784165592117574 -> -33.7214884751532  _ #Surrender#	 lift : 0.06267711696437694 : good	 :| stand

[Prob_ROI diff: -0.04649380892581778 (up%-> -6.547568496954729) . o: 0.710092745840567 -> a: 0.6635989369147492	 returnMoney: o:6.903479601915572 a: 0.08711795629111403 (probReturnRate: 0.012619426914354987	 totalSpendMoney: o: 9.721940749787029 a: 0.13128103654919784 (probTotalSpendRate: 0.013503583279097203

[Time_ROI diff: 6.26771169643825E-4 (up%-> 0.09465578365787583) . o: 0.6621583440788242 -> a: 0.6627851152484681	 returnMoney: o:1.508814E10 a: 6.945534E8 (timeReturnRate: 0.04603306968254536	 totalSpendMoney: o: 2.2786302E10 a: 1.0479315E9 (timeTotalSpendRate: 0.0459895379250218

[[Per_Prob_ROI diff: 6.182140486016434E-5 (up%-> 546.1947751798249) . o: 1.1318563938992413E-5 -> a: 7.313996879915676E-5	 per returnMoney: o:1.1003840798756033E-4 a: 9.601890917129289E-6	 per totalSpendMoney: o: 1.549634306675013E-4 a: 1.44694187753993E-5

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 2.727804258687555

 按net净收益值(代表少输多赢) :  $Change$  Value: 2.7742980676133726     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9345243150304526 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 */
	}
	
	public static void test33vsAll() {
		StrategyMatrix8012 o = new Myth2019April22();
		StrategyMatrix8012 t = new MirMyth2019April22();
		
		System.out.println(t.diffWith(o));
		
		for(Card playerCard : Card.values()) {
			if(playerCard.getValue() == 3) {
				for(Card dealerCard : Card.values()) {
					if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
					PlayerCardsPathValue nine = new PlayerCardsPathValue(playerCard,playerCard);
					Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, nine, dealerCard); 
//					HelloWorld.print(origin);
					PlayerCardsPathValue ninet = new PlayerCardsPathValue(playerCard,playerCard);
					Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, ninet, dealerCard); 
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
MatrixKey [startValue=Three, dealerCard=One1, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Three, dealerCard=One1, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Three, dealerCard=Two2, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Three, dealerCard=Two2, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Three, dealerCard=Three3, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Three, dealerCard=Three3, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Three, dealerCard=Four4, situation=Start_With_Pair] : Hit -> Split
MatrixKey [startValue=Three, dealerCard=Four4, situation=Splited_Pair_And_Can_Split] : Hit -> Split
MatrixKey [startValue=Three, dealerCard=Five5, situation=Splited_Pair_And_Can_Split] : Hit -> Split
MatrixKey [startValue=Three, dealerCard=Five5, situation=Start_With_Pair] : Hit -> Split
MatrixKey [startValue=Three, dealerCard=Six6, situation=Start_With_Pair] : Hit -> Split
MatrixKey [startValue=Three, dealerCard=Six6, situation=Splited_Pair_And_Can_Split] : Hit -> Split
MatrixKey [startValue=Three, dealerCard=Seven7, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Three, dealerCard=Seven7, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Three, dealerCard=Eight8, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Three, dealerCard=Eight8, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Three, dealerCard=Nine9, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Three, dealerCard=Nine9, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Three, dealerCard=Ten, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Three, dealerCard=Ten, situation=Start_With_Pair] : Split -> Hit


		 @@@   dealerCard=One1, 	playerStartValue=3	@@@ 

net money diff:  4.105513902963695 , up % -> 98.40638060084264 .  o: -4.171999699507839 -> a: -0.0664857965441435 (anet/onet: 0.015936193991573554

[ProbMatrix: total: o: 0.03240646915468019  -> a: 4.3760345516285863E-4
org->adv	$w:23.113362310520387->19.797255352499622  	$d:10.860036049115392->9.761620007794015  	$l:66.02660164036422->70.44112463970637
	 improve value x$w(high is good):-3.3161069580207645  	x$d:-1.0984160413213768  	 x$l(negative is good):4.414522999342154
	 	 $w-$l: -42.91323932984384 -> -50.643869287206755  _ #Surrender#	 lift : -7.7306299573629165 : bad	 :| stand

[TimeMatrix: total:  o: 1.630454332E9 -> a: 4.4175781E7
org->adv	$w:31.567276549761104->31.607051836842455  	$d:3.509080191765837->3.5101835551022855  	$l:64.92364325847306->64.88276460805525
	 improve value x$w(high is good):0.03977528708135125  	x$d:0.0011033633364485596  	 x$l(negative is good):-0.04087865041780958
	 	 $w-$l: -33.35636670871196 -> -33.2757127712128  _ #Surrender#	 lift : 0.08065393749915883 : good	 :| stand

[Prob_ROI diff: -0.07730629956206542 (up%-> -13.541896343956635) . o: 0.5708676067112641 -> a: 0.4935613071491987	 returnMoney: o:5.549941045945897 a: 0.06479524000124237 (probReturnRate: 0.011674942033586787	 totalSpendMoney: o: 9.721940745453736 a: 0.13128103654538587 (probTotalSpendRate: 0.01350358328472396

[Time_ROI diff: 8.065393749915328E-4 (up%-> 0.12102271967470407) . o: 0.6664363329128804 -> a: 0.6672428722878719	 returnMoney: o:3.259782018E11 a: 8.8427925E9 (timeReturnRate: 0.027126944228698425	 totalSpendMoney: o: 4.891362996E11 a: 1.32527343E10 (timeTotalSpendRate: 0.0270941541464775

[[Per_Prob_ROI diff: 1.4341188826913918E-4 (up%-> 934.8553912358773) . o: 1.5340542463957863E-5 -> a: 1.5875243073309704E-4	 per returnMoney: o:1.4913984483771523E-4 a: 2.084118366074055E-5	 per totalSpendMoney: o: 2.612511956964968E-4 a: 4.222612947744801E-5

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=true]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 4.02820760340163

 按net净收益值(代表少输多赢) :  $Change$  Value: 4.105513902963695     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.8645810365604337 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Two2, 	playerStartValue=3	@@@ 

net money diff:  0.6422844268301137 , up % -> 96.95885797651354 .  o: -0.6624298596686184 -> a: -0.020145432838504798 (anet/onet: 0.030411420234864688

[ProbMatrix: total: o: 0.03240646916479982  -> a: 4.3760345516316964E-4
org->adv	$w:42.70004337957023->40.36435509521567  	$d:4.4228727955307034->3.9260172787523584  	$l:52.87708382489906->55.70962762603197
	 improve value x$w(high is good):-2.3356882843545606  	x$d:-0.49685551677834505  	 x$l(negative is good):2.832543801132907
	 	 $w-$l: -10.177040445328833 -> -15.345272530816295  _ #Surrender#	 lift : -5.168232085487462 : bad	 :| stand

[TimeMatrix: total:  o: 1.47430036E8 -> a: 5150977.0
org->adv	$w:57.025777298189084->57.11671785760255  	$d:4.098887963372674->4.097552755525796  	$l:38.87533473843824->38.78572938687165
	 improve value x$w(high is good):0.09094055941346824  	x$d:-0.001335207846877573  	 x$l(negative is good):-0.08960535156658977
	 	 $w-$l: 18.150442559750847 -> 18.330988470730897  _ @double@	 lift : 0.18054591098005113 : good	 :) hit 

[Prob_ROI diff: -0.09466446379788673 (up%-> -10.057722393992927) . o: 0.9412117384988276 -> a: 0.8465472747009408	 returnMoney: o:10.60563357261042 a: 0.11113560371033461 (probReturnRate: 0.010478921692839536	 totalSpendMoney: o: 11.268063432279039 a: 0.1312810365488394 (probTotalSpendRate: 0.011650718629499849

[Time_ROI diff: -0.006263601019521614 (up%-> -0.526541747498226) . o: 1.1895734857268305 -> a: 1.183309884707309	 returnMoney: o:5.40994896E10 a: 1.8285606E9 (timeReturnRate: 0.033799960286501486	 totalSpendMoney: o: 4.5478056E10 a: 1.5452931E9 (timeTotalSpendRate: 0.03397887323943662

[[Per_Prob_ROI diff: 0.003856591978718566 (up%-> 728.1213850045315) . o: 5.296633306127336E-4 -> a: 0.0043862553093313	 per returnMoney: o:0.005968280007096466 a: 5.758321435768633E-4	 per totalSpendMoney: o: 0.006341059894360742 a: 6.802126246053856E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.5476199630322269

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.6422844268301137     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.8994227760600707 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Three3, 	playerStartValue=3	@@@ 

net money diff:  0.2758238695150472 , up % -> 94.64500760383153 .  o: -0.2914299195469461 -> a: -0.015606050031898827 (anet/onet: 0.05354992396168461

[ProbMatrix: total: o: 0.03240646916535719  -> a: 4.376034551638225E-4
org->adv	$w:44.26707793258639->42.158977239563654  	$d:4.204988288469213->3.794532714095751  	$l:51.52793377894438->54.04649004634059
	 improve value x$w(high is good):-2.1081006930227346  	x$d:-0.4104555743734619  	 x$l(negative is good):2.5185562673962067
	 	 $w-$l: -7.260855846357988 -> -11.887512806776934  _ #Surrender#	 lift : -4.626656960418946 : bad	 :| stand

[TimeMatrix: total:  o: 8.2555324E7 -> a: 3001729.0
org->adv	$w:57.097778454603365->57.10065765430523  	$d:4.096637062438275->4.099903755468932  	$l:38.80558448295836->38.79943859022583
	 improve value x$w(high is good):0.0028791997018657867  	x$d:0.003266693030656853  	 x$l(negative is good):-0.0061458927325261925
	 	 $w-$l: 18.292193971645005 -> 18.301219064079397  _ @double@	 lift : 0.009025092434394866 : good	 :| stand

[Prob_ROI diff: -0.09467224626923076 (up%-> -9.702042002663358) . o: 0.9757971182070928 -> a: 0.881124871937862	 returnMoney: o:11.749694853964606 a: 0.11567498651715366 (probReturnRate: 0.009844935375332098	 totalSpendMoney: o: 12.041124773511552 a: 0.1312810365490525 (probTotalSpendRate: 0.010902722047847944

[Time_ROI diff: -0.010600467284471726 (up%-> -0.8880994361183661) . o: 1.1936126579252657 -> a: 1.183012190640794	 returnMoney: o:3.08649348E10 a: 1.0653246E9 (timeReturnRate: 0.034515692545704	 totalSpendMoney: o: 2.58584178E10 a: 9.005187E8 (timeTotalSpendRate: 0.03482497293395886

[[Per_Prob_ROI diff: 0.003993098818896223 (up%-> 697.7099398210307) . o: 5.723150253414035E-4 -> a: 0.004565413844237627	 per returnMoney: o:0.006891316629891264 a: 5.993522617469101E-4	 per totalSpendMoney: o: 0.007062243268921731 a: 6.802126246064896E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.1811516232458165

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.2758238695150472     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9029795799733664 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Four4, 	playerStartValue=3	@@@ 

net money diff:  0.1255741494912332 , up % -> 1166.6316176206062 .  o: -0.010763821894982317 -> a: 0.11481032759625087 (anet/onet: -10.666316176206061

[ProbMatrix: total: o: 4.3760345516409116E-4  -> a: 0.032406469165894194
org->adv	$w:44.30320794392996->46.36755763340937  	$d:3.194515779009413->3.52005586927779  	$l:52.50227627706062->50.112386497312855
	 improve value x$w(high is good):2.064349689479407  	x$d:0.32554009026837694  	 x$l(negative is good):-2.3898897797477687
	 	 $w-$l: -8.19906833313066 -> -3.7448288639034875  _ #Surrender#	 lift : 4.454239469227172 : good	 :) hit 

[TimeMatrix: total:  o: 880081.0 -> a: 2.5077772E7
org->adv	$w:68.45949406929589->67.65744580499417  	$d:4.690931857408579->4.643107848655774  	$l:26.849574073295525->27.699446346350065
	 improve value x$w(high is good):-0.8020482643017175  	x$d:-0.047824008752805014  	 x$l(negative is good):0.8498722730545403
	 	 $w-$l: 41.609919996000365 -> 39.9579994586441  _ @double@	 lift : -1.6519205373562662 : bad	 :| stand

[Prob_ROI diff: 0.09152553408158004 (up%-> 9.970000567488666) . o: 0.9180093166698217 -> a: 1.0095348507514017	 returnMoney: o:0.120517214654453 a: 12.155935101297935 (probReturnRate: 100.86471991699639	 totalSpendMoney: o: 0.13128103654943532 a: 12.041124773701684 (probTotalSpendRate: 91.72021405519193

[Time_ROI diff: -0.013691613786422474 (up%-> -0.9668541431849675) . o: 1.4160991999600037 -> a: 1.4024075861735812	 returnMoney: o:3.738846E8 a: 1.14440052E10 (timeReturnRate: 30.6083887916218	 totalSpendMoney: o: 2.640243E8 a: 8.1602562E9 (timeTotalSpendRate: 30.90721649484536

[[Per_Prob_ROI diff: -0.008328428814915237 (up%-> -88.00102356012779) . o: 0.009464013573915688 -> a: 0.001135584759000452	 per returnMoney: o:0.0012424455119015773 a: 0.013673717774238398	 per totalSpendMoney: o: 0.0013534127479323229 a: 0.013544572298877035

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.21709968357281323

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.1255741494912332     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.0997000056748867 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Five5, 	playerStartValue=3	@@@ 

net money diff:  0.5585422997029377 , up % -> 10091.933371461513 .  o: -0.0055345420856861005 -> a: 0.5530077576172516 (anet/onet: -99.91933371461515

[ProbMatrix: total: o: 4.3760345516432177E-4  -> a: 0.03240646916598246
org->adv	$w:46.36607217113765->48.342836564424935  	$d:3.0520585927461457->3.38892736938838  	$l:50.5818692361162->48.268236066186674
	 improve value x$w(high is good):1.976764393287283  	x$d:0.33686877664223447  	 x$l(negative is good):-2.313633169929524
	 	 $w-$l: -4.215797064978544 -> 0.07460049823825865  _ #Surrender#	 lift : 4.2903975632168025 : good	 :) hit 

[TimeMatrix: total:  o: 530881.0 -> a: 1.5127372E7
org->adv	$w:68.447919590266->67.64548396112689  	$d:4.692577055875045->4.645116151040644  	$l:26.859503353858962->27.709399887832465
	 improve value x$w(high is good):-0.8024356291391115  	x$d:-0.04746090483440124  	 x$l(negative is good):0.849896533973503
	 	 $w-$l: 41.588416236407035 -> 39.93608407329442  _ @double@	 lift : -1.652332163112613 : bad	 :| stand

[Prob_ROI diff: 0.08808455707810936 (up%-> 9.196146585657502) . o: 0.9578420293505089 -> a: 1.0459265864286182	 returnMoney: o:0.1257464944637549 a: 12.594132531320362 (probReturnRate: 100.15493938839374	 totalSpendMoney: o: 0.131281036549441 a: 12.04112477370311 (probTotalSpendRate: 91.72021405519882

[Time_ROI diff: -0.013694969178821292 (up%-> -0.967237966413517) . o: 1.4158841623640703 -> a: 1.402189193185249	 returnMoney: o:2.254998E8 a: 6.9021588E9 (timeReturnRate: 30.608270162545598	 totalSpendMoney: o: 1.592643E8 a: 4.9224162E9 (timeTotalSpendRate: 30.90721649484536

[[Per_Prob_ROI diff: -0.00869813975170789 (up%-> -88.08545982136246) . o: 0.009874660096396998 -> a: 0.0011765203446891092	 per returnMoney: o:0.0012963556130284012 a: 0.014166628269201757	 per totalSpendMoney: o: 0.0013534127479323816 a: 0.01354457229887864

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.6466268567810471

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.5585422997029377     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.091961465856575 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Six6, 	playerStartValue=3	@@@ 

net money diff:  0.8525338816546861 , up % -> 28260.28848089312 .  o: -0.0030167203786015395 -> a: 0.8495171612760846 (anet/onet: -281.60288480893115

[ProbMatrix: total: o: 4.3760345516449676E-4  -> a: 0.03240646916604597
org->adv	$w:47.19629961775256->49.17169181742068  	$d:3.309490527119511->3.3811130199043338  	$l:49.49420985512793->47.44719516267498
	 improve value x$w(high is good):1.9753921996681214  	x$d:0.0716224927848228  	 x$l(negative is good):-2.0470146924529473
	 	 $w-$l: -2.297910237375367 -> 1.7244966547457052  _ #Surrender#	 lift : 4.022406892121072 : good	 :) hit 

[TimeMatrix: total:  o: 301573.0 -> a: 7026340.0
org->adv	$w:68.43384520497524->68.24651240902091  	$d:4.694717365281375->4.722373241260742  	$l:26.871437429743377->27.031114349718344
	 improve value x$w(high is good):-0.18733279595433316  	x$d:0.027655875979367472  	 x$l(negative is good):0.15967691997496658
	 	 $w-$l: 41.56240777523186 -> 41.215398059302565  _ @double@	 lift : -0.3470097159292973 : bad	 :| stand

[Prob_ROI diff: 0.08927415643749836 (up%-> 9.13738453848808) . o: 0.9770208976262493 -> a: 1.0662950540637477	 returnMoney: o:0.12826431617083187 a: 13.663703276264552 (probReturnRate: 106.52770532114502	 totalSpendMoney: o: 0.1312810365494334 a: 12.814186114988468 (probTotalSpendRate: 97.60881275616171

[Time_ROI diff: -0.004181504217499965 (up%-> -0.29538238881463647) . o: 1.4156240777523186 -> a: 1.4114425735348186	 returnMoney: o:1.280742E8 a: 3.3859158E9 (timeReturnRate: 26.4371419068009	 totalSpendMoney: o: 9.04719E7 a: 2.3989044E9 (timeTotalSpendRate: 26.515463917525775

[[Per_Prob_ROI diff: -0.008593469078518413 (up%-> -85.31716185820619) . o: 0.010072380387899477 -> a: 0.0014789113093810645	 per returnMoney: o:0.0013223125378436275 a: 0.018951044765970253	 per totalSpendMoney: o: 0.0013534127479323031 a: 0.017772796275989555

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.9418080380921845

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.8525338816546861     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.091373845384881 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Seven7, 	playerStartValue=3	@@@ 

net money diff:  0.26547060722682325 , up % -> 92.32025563167387 .  o: -0.2875540209571774 -> a: -0.022083413730354162 (anet/onet: 0.07679744368326126

[ProbMatrix: total: o: 0.032406469165022045  -> a: 4.376034551632108E-4
org->adv	$w:42.28543442674998->36.6396896376249  	$d:8.979299357179977->9.89914040204588  	$l:48.73526621607005->53.46116996032922
	 improve value x$w(high is good):-5.645744789125082  	x$d:0.9198410448659029  	 x$l(negative is good):4.7259037442591705
	 	 $w-$l: -6.44983178932007 -> -16.82148032270433  _ #Surrender#	 lift : -10.37164853338426 : bad	 :| stand

[TimeMatrix: total:  o: 1.76447692E8 -> a: 5972389.0
org->adv	$w:31.468104439699896->31.458868469552133  	$d:3.5541377327848527->3.555110023811242  	$l:64.97775782751525->64.98602150663663
	 improve value x$w(high is good):-0.00923597014776334  	x$d:9.722910263891826E-4  	 x$l(negative is good):0.00826367912138437
	 	 $w-$l: -33.509653387815355 -> -33.527153037084496  _ #Surrender#	 lift : -0.017499649269142603 : bad	 :| stand

[Prob_ROI diff: -0.14269542070679342 (up%-> -14.643228212750143) . o: 0.974480617481231 -> a: 0.8317851967744376	 returnMoney: o:10.980509410659458 a: 0.10919762281874257 (probReturnRate: 0.00994467731276089	 totalSpendMoney: o: 11.268063431616635 a: 0.13128103654909673 (probTotalSpendRate: 0.011650718630207583

[Time_ROI diff: -0.0015455877022106934 (up%-> -0.23197476852111748) . o: 0.6662740573313658 -> a: 0.6647284696291551	 returnMoney: o:3.53286558E10 a: 1.1910051E9 (timeReturnRate: 0.033712154426209444	 totalSpendMoney: o: 5.30242104E10 a: 1.7917167E9 (timeTotalSpendRate: 0.03379053995304756

[[Per_Prob_ROI diff: 2.34598285071816E-4 (up%-> 712.1385224312119) . o: 3.294278819111021E-5 -> a: 2.675410732629262E-4	 per returnMoney: o:3.7120142695174125E-4 a: 3.5123069417414785E-5	 per totalSpendMoney: o: 3.809223295905019E-4 a: 4.22261294786416E-5

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.12277518652002983

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.26547060722682325     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.8535677178724987 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Eight8, 	playerStartValue=3	@@@ 

net money diff:  1.0574297727680606 , up % -> 97.04517269351012 .  o: -1.0896263496873306 -> a: -0.032196576919270026 (anet/onet: 0.029548273064898684

[ProbMatrix: total: o: 0.03240646916551816  -> a: 4.3760345516383154E-4
org->adv	$w:38.452546182951885->33.412115735593844  	$d:9.27423568209428->8.650842640265392  	$l:52.27321813495385->57.93704162414076
	 improve value x$w(high is good):-5.040430447358041  	x$d:-0.6233930418288889  	 x$l(negative is good):5.66382348918691
	 	 $w-$l: -13.820671952001963 -> -24.524925888546917  _ #Surrender#	 lift : -10.704253936544955 : bad	 :| stand

[TimeMatrix: total:  o: 1.05905356E8 -> a: 3584677.0
org->adv	$w:31.458750773662477->31.449500192067514  	$d:3.5557125175047806->3.5568895049679514  	$l:64.98553670883275->64.99361030296453
	 improve value x$w(high is good):-0.00925058159496217  	x$d:0.0011769874631708532  	 x$l(negative is good):0.008073594131772666
	 	 $w-$l: -33.526785935170274 -> -33.544110110897016  _ #Surrender#	 lift : -0.01732417572674616 : bad	 :| stand

[Prob_ROI diff: -0.1485488492473821 (up%-> -16.445136345925018) . o: 0.9032995903630279 -> a: 0.7547507411156458	 returnMoney: o:10.178437082287282 a: 0.09908445962996629 (probReturnRate: 0.009734742065890945	 totalSpendMoney: o: 11.268063431974612 a: 0.1312810365492363 (probTotalSpendRate: 0.011650718629849838

[Time_ROI diff: -0.0015436867056222159 (up%-> -0.23174909375850572) . o: 0.666102585596652 -> a: 0.6645588988910298	 returnMoney: o:2.11990926E10 a: 7.146687E8 (timeReturnRate: 0.03371223068293027	 totalSpendMoney: o: 3.18255672E10 a: 1.0754031E9 (timeTotalSpendRate: 0.03379053995304756

[[Per_Prob_ROI diff: 2.1222670549128663E-4 (up%-> 694.9940243651307) . o: 3.0536479171191915E-5 -> a: 2.4276318466247854E-4	 per returnMoney: o:3.44086984290162E-4 a: 3.187020251848385E-5	 per totalSpendMoney: o: 3.809223296026034E-4 a: 4.222612947868649E-5

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.9088809235206785

 按net净收益值(代表少输多赢) :  $Change$  Value: 1.0574297727680606     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.8355486365407498 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Nine9, 	playerStartValue=3	@@@ 

net money diff:  1.9515880181878853 , up % -> 97.91628954753719 .  o: -1.9931188438675598 -> a: -0.041530825679674394 (anet/onet: 0.02083710452462817

[ProbMatrix: total: o: 0.03240646916561823  -> a: 4.376034551641743E-4
org->adv	$w:34.30736503216193->29.84373113386829  	$d:9.301254989845068->8.677484588658368  	$l:56.391379977993->61.478784277473345
	 improve value x$w(high is good):-4.463633898293644  	x$d:-0.6237704011867002  	 x$l(negative is good):5.0874042994803474
	 	 $w-$l: -22.084014945831065 -> -31.635053143605052  _ #Surrender#	 lift : -9.551038197773988 : bad	 :| stand

[TimeMatrix: total:  o: 8.4808396E7 -> a: 2390821.0
org->adv	$w:31.425742328625105->31.421340200709295  	$d:3.5591263864959783->3.558986640990689  	$l:65.01513128487892->65.01967315830002
	 improve value x$w(high is good):-0.004402127915810183  	x$d:-1.3974550528939034E-4  	 x$l(negative is good):0.004541873421104015
	 	 $w-$l: -33.589388956253806 -> -33.59833295759072  _ #Surrender#	 lift : -0.008944001336913532 : bad	 :| stand

[Prob_ROI diff: -0.139468420690552 (up%-> -16.94391805974089) . o: 0.8231178892556847 -> a: 0.6836494685651328	 returnMoney: o:9.274944588214792 a: 0.08975021086957222 (probReturnRate: 0.009676630411745352	 totalSpendMoney: o: 11.268063432082352 a: 0.1312810365492466 (probTotalSpendRate: 0.011650718629739354

[Time_ROI diff: -0.0012309571057452784 (up%-> -0.18503742889185526) . o: 0.6652476275298381 -> a: 0.6640166704240928	 returnMoney: o:1.6949517E10 a: 4.762635E8 (timeReturnRate: 0.028098942288443972	 totalSpendMoney: o: 2.5478508E10 a: 7.172463E8 (timeTotalSpendRate: 0.028151032234697573

[[Per_Prob_ROI diff: 1.968532968286473E-4 (up%-> 854.383572632923) . o: 2.3040388782524413E-5 -> a: 2.198936856111717E-4	 per returnMoney: o:2.596205623013238E-4 a: 2.8867870977668775E-5	 per totalSpendMoney: o: 3.1541115275248013E-4 a: 4.2226129478689806E-5

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.8121195974973334

 按net净收益值(代表少输多赢) :  $Change$  Value: 1.9515880181878853     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.8305608194025912 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Ten, 	playerStartValue=3	@@@ 

net money diff:  2.9689241551786902 , up % -> 98.2701654017552 .  o: -3.021185670178655 -> a: -0.05226151499996477 (anet/onet: 0.017298345982448123

[ProbMatrix: total: o: 0.03240646916590456  -> a: 4.3760345516445604E-4
org->adv	$w:29.567690666600434->25.721250637635006  	$d:9.788666365042836->8.748615146612597  	$l:60.64364296835672->65.5301342157524
	 improve value x$w(high is good):-3.8464400289654286  	x$d:-1.0400512184302393  	 x$l(negative is good):4.886491247395675
	 	 $w-$l: -31.075952301756292 -> -39.808883578117396  _ #Surrender#	 lift : -8.7329312763611 : bad	 :| stand

[TimeMatrix: total:  o: 4.417798E7 -> a: 1196965.0
org->adv	$w:31.340667907405457->31.38078389927859  	$d:3.5639610502788943->3.5654342441090594  	$l:65.09537104231565->65.05378185661235
	 improve value x$w(high is good):0.04011599187313308  	x$d:0.001473193830165087  	 x$l(negative is good):-0.04158918570330172
	 	 $w-$l: -33.754703134910194 -> -33.672997957333756  _ #Surrender#	 lift : 0.08170517757644102 : good	 :| stand

[Prob_ROI diff: -0.08732931276559652 (up%-> -12.670369150051412) . o: 0.6892404769851727 -> a: 0.6019111642195761	 returnMoney: o:6.700755079596869 a: 0.07901952154935198 (probReturnRate: 0.011792629429175607	 totalSpendMoney: o: 9.721940749775523 a: 0.13128103654931675 (probTotalSpendRate: 0.013503583279125413

[Time_ROI diff: 8.170517757644102E-4 (up%-> 0.12333732573172049) . o: 0.662452968650898 -> a: 0.6632700204266624	 returnMoney: o:8.7797502E9 a: 2.381733E8 (timeReturnRate: 0.027127571351631394	 totalSpendMoney: o: 1.3253394E10 a: 3.590895E8 (timeTotalSpendRate: 0.0270941541464775

[[Per_Prob_ROI diff: 1.7508132173827193E-4 (up%-> 945.2870867864706) . o: 1.8521497245187775E-5 -> a: 1.936028189834597E-4	 per returnMoney: o:1.800648988148461E-4 a: 2.5416378755018328E-5	 per totalSpendMoney: o: 2.612511958126333E-4 a: 4.2226129478712364E-5

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 2.8815948424130937

 按net净收益值(代表少输多赢) :  $Change$  Value: 2.9689241551786902     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.8732963084994859 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 */
	}
	
	public static void test44vsAll() {
		StrategyMatrix8012 o = new Myth2019April22();
		StrategyMatrix8012 t = new MirMyth2019April22();
		
		System.out.println(t.diffWith(o));
		
		for(Card playerCard : Card.values()) {
			if(playerCard.getValue() == 4) {
				for(Card dealerCard : Card.values()) {
					if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
					PlayerCardsPathValue nine = new PlayerCardsPathValue(playerCard,playerCard);
					Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, nine, dealerCard); 
//					HelloWorld.print(origin);
					PlayerCardsPathValue ninet = new PlayerCardsPathValue(playerCard,playerCard);
					Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, ninet, dealerCard); 
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
MatrixKey [startValue=Four, dealerCard=One1, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Four, dealerCard=One1, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Four, dealerCard=Two2, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Four, dealerCard=Two2, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Four, dealerCard=Three3, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Four, dealerCard=Three3, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Four, dealerCard=Four4, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Four, dealerCard=Four4, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Four, dealerCard=Five5, situation=Splited_Pair_And_Can_Split] : Hit -> Split
MatrixKey [startValue=Four, dealerCard=Five5, situation=Start_With_Pair] : Hit -> Split
MatrixKey [startValue=Four, dealerCard=Six6, situation=Splited_Pair_And_Can_Split] : Hit -> Split
MatrixKey [startValue=Four, dealerCard=Six6, situation=Start_With_Pair] : Hit -> Split
MatrixKey [startValue=Four, dealerCard=Seven7, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Four, dealerCard=Seven7, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Four, dealerCard=Eight8, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Four, dealerCard=Eight8, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Four, dealerCard=Nine9, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Four, dealerCard=Nine9, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Four, dealerCard=Ten, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Four, dealerCard=Ten, situation=Start_With_Pair] : Split -> Hit


		 @@@   dealerCard=One1, 	playerStartValue=4	@@@ 

net money diff:  4.3398281799976965 , up % -> 98.7352606106204 .  o: -4.395418772542223 -> a: -0.05559059254452653 (anet/onet: 0.012647393893795933

[ProbMatrix: total: o: 0.03240646915947292  -> a: 4.3760345516459E-4
org->adv	$w:22.178686539732357->23.085897629735484  	$d:10.431296309048887->11.483480775358789  	$l:67.39001715121876->65.43062159490573
	 improve value x$w(high is good):0.9072110900031269  	x$d:1.0521844663099014  	 x$l(negative is good):-1.9593955563130265
	 	 $w-$l: -45.21133061148639 -> -42.34472396517024  _ #Surrender#	 lift : 2.86660664631615 : good	 :) hit 

[TimeMatrix: total:  o: 9.37168804E8 -> a: 1.6382977E7
org->adv	$w:31.57806050915028->31.691737100039873  	$d:3.5096887411971514->3.5213502405576227  	$l:64.91225074965257->64.78691265940249
	 improve value x$w(high is good):0.11367659088959314  	x$d:0.011661499360471339  	 x$l(negative is good):-0.12533809025008225
	 	 $w-$l: -33.33419024050229 -> -33.09517555936262  _ #Surrender#	 lift : 0.2390146811396654 : good	 :) hit 

[Prob_ROI diff: 0.0286660664392957 (up%-> 5.232115829357868) . o: 0.5478866939154491 -> a: 0.5765527603547448	 returnMoney: o:5.326521974143574 a: 0.07569044400467329 (probReturnRate: 0.014210106401906506	 totalSpendMoney: o: 9.721940746685798 a: 0.13128103654919981 (probTotalSpendRate: 0.013503583283404954

[Time_ROI diff: 0.0023901468113965985 (up%-> 0.3585266300700833) . o: 0.6666580975949772 -> a: 0.6690482444063738	 returnMoney: o:1.874313516E11 a: 3.2883006E9 (timeReturnRate: 0.017544026503194678	 totalSpendMoney: o: 2.811506412E11 a: 4.9148931E9 (timeTotalSpendRate: 0.01748135120383286

[[Per_Prob_ROI diff: 4.7468180873618167E-4 (up%-> 1871.4821630788895) . o: 2.5363950461342024E-5 -> a: 5.000457591975237E-4	 per returnMoney: o:2.4658682348704106E-4 a: 6.564652558948247E-5	 per totalSpendMoney: o: 4.500690128552288E-4 a: 1.1386039596634849E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 4.368494246436993

 按net净收益值(代表少输多赢) :  $Change$  Value: 4.3398281799976965     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.0523211582935785 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Two2, 	playerStartValue=4	@@@ 

net money diff:  0.8293238355290815 , up % -> 99.68224520725396 .  o: -0.831967451981841 -> a: -0.0026436164527594286 (anet/onet: 0.003177547927460424

[ProbMatrix: total: o: 0.032406469165447475  -> a: 4.3760345516457937E-4
org->adv	$w:42.039272638652136->45.05313047223181  	$d:3.9901282519439754->7.880031270672067  	$l:53.97059910940389->47.06683825709613
	 improve value x$w(high is good):3.013857833579671  	x$d:3.8899030187280914  	 x$l(negative is good):-6.903760852307762
	 	 $w-$l: -11.931326470751758 -> -2.0137077848643212  _ #Surrender#	 lift : 9.917618685887437 : good	 :) hit 

[TimeMatrix: total:  o: 8.8500724E7 -> a: 1948297.0
org->adv	$w:57.28400594779315->57.266782220575195  	$d:4.104287327638134->4.262902421961334  	$l:38.61170672456872->38.47031535746347
	 improve value x$w(high is good):-0.017223727217952955  	x$d:0.1586150943232001  	 x$l(negative is good):-0.1413913671052498
	 	 $w-$l: 18.67229922322443 -> 18.79646686311173  _ @double@	 lift : 0.12416763988729596 : good	 :) hit 

[Prob_ROI diff: 0.053697033664161786 (up%-> 5.797777086321618) . o: 0.9261658884893366 -> a: 0.9798629221534984	 returnMoney: o:10.436095980483037 a: 0.12863742009637924 (probReturnRate: 0.012326201324417604	 totalSpendMoney: o: 11.268063432464878 a: 0.13128103654913867 (probTotalSpendRate: 0.011650718629334257

[Time_ROI diff: -0.011724384989240555 (up%-> -0.9772853185464457) . o: 1.199689053620358 -> a: 1.1879646686311174	 returnMoney: o:3.33504708E10 a: 6.943524E8 (timeReturnRate: 0.02081986800618119	 totalSpendMoney: o: 2.77992624E10 a: 5.844891E8 (timeTotalSpendRate: 0.021025345622119815

[[Per_Prob_ROI diff: 0.012566012051096906 (up%-> 1466.6766716481325) . o: 8.567677044304686E-4 -> a: 0.013422779755527374	 per returnMoney: o:0.00965411284040984 a: 0.001762156439676428	 per totalSpendMoney: o: 0.01042374045556418 a: 0.0017983703636868312

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.8830208691932433

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.8293238355290815     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.0579777708632163 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Three3, 	playerStartValue=4	@@@ 

net money diff:  0.45501097381626254 , up % -> 100.29331877627273 .  o: -0.45368024447497746 -> a: 0.0013307293412850585 (anet/onet: -0.0029331877627271343

[ProbMatrix: total: o: 0.032406469165752814  -> a: 4.376034551644989E-4
org->adv	$w:43.63901287366116->46.690849714956364  	$d:3.7821504476719117->7.631949895281179  	$l:52.57883667866693->45.67720038976247
	 improve value x$w(high is good):3.0518368412952057  	x$d:3.849799447609267  	 x$l(negative is good):-6.901636288904463
	 	 $w-$l: -8.93982380500577 -> 1.0136493251938938  _ #Surrender#	 lift : 9.953473130199663 : good	 :) hit 

[TimeMatrix: total:  o: 4.82143E7 -> a: 1135369.0
org->adv	$w:57.436818537238956->57.25072641581723  	$d:4.099173896541068->4.265221262866962  	$l:38.46400756621998->38.4840523213158
	 improve value x$w(high is good):-0.18609212142172282  	x$d:0.16604736632589479  	 x$l(negative is good):0.02004475509581738
	 	 $w-$l: 18.972810971018973 -> 18.76667409450143  _ @double@	 lift : -0.2061368765175431 : bad	 :| stand

[Prob_ROI diff: 0.047814056853480724 (up%-> 4.96861083613025) . o: 0.9623224363999535 -> a: 1.0101364932534342	 returnMoney: o:11.58744452916665 a: 0.1326117658905087 (probReturnRate: 0.011444435876841769	 totalSpendMoney: o: 12.041124773641627 a: 0.13128103654922363 (probTotalSpendRate: 0.01090272204774438

[Time_ROI diff: -0.019354505098325037 (up%-> -1.6034933238971414) . o: 1.2070212460433394 -> a: 1.1876667409450143	 returnMoney: o:1.8776556E10 a: 4.04532E8 (timeReturnRate: 0.021544526056855154	 totalSpendMoney: o: 1.55561106E10 a: 3.406107E8 (timeTotalSpendRate: 0.021895620875824834

[[Per_Prob_ROI diff: 0.012883747421637028 (up%-> 1350.8675114199375) . o: 9.537387873141263E-4 -> a: 0.013837486208951155	 per returnMoney: o:0.01148408773951105 a: 0.0018165995327466943	 per totalSpendMoney: o: 0.011933721282102704 a: 0.001798370363687995

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.5028250306697433

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.45501097381626254     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.0496861083613025 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Four4, 	playerStartValue=4	@@@ 

net money diff:  0.04643505801956213 , up % -> 113.71736671705233 .  o: -0.04083374365773018 -> a: 0.005601314361831949 (anet/onet: -0.13717366717052337

[ProbMatrix: total: o: 0.032406469166011156  -> a: 4.3760345516428864E-4
org->adv	$w:45.74362298044872->48.668323851198124  	$d:3.157274691820839->6.930011450442139  	$l:51.09910232773044->44.40166469835974
	 improve value x$w(high is good):2.9247008707494047  	x$d:3.7727367586213  	 x$l(negative is good):-6.697437629370704
	 	 $w-$l: -5.355479347281716 -> 4.266659152838387  _ @double@	 lift : 9.622138500120103 : good	 :) hit 

[TimeMatrix: total:  o: 1.506118E7 -> a: 335701.0
org->adv	$w:67.68229315365728->68.56309632679081  	$d:4.616557268421199->5.007432209019336  	$l:27.70114957792152->26.42947146418986
	 improve value x$w(high is good):0.8808031731335291  	x$d:0.39087494059813643  	 x$l(negative is good):-1.2716781137316602
	 	 $w-$l: 39.981143575735764 -> 42.133624862600946  _ @double@	 lift : 2.1524812868651875 : good	 :) hit 

[Prob_ROI diff: 0.04605778167224117 (up%-> 4.6214503842190435) . o: 0.9966088098557884 -> a: 1.0426665915280295	 returnMoney: o:12.000291030023591 a: 0.13688235091128798 (probReturnRate: 0.011406585937692787	 totalSpendMoney: o: 12.041124773681322 a: 0.13128103654945603 (probTotalSpendRate: 0.010902722047727739

[Time_ROI diff: 0.01707763106070459 (up%-> 1.2161314765732885) . o: 1.404258617565305 -> a: 1.4213362486260095	 returnMoney: o:7.2393444E9 a: 1.431432E8 (timeReturnRate: 0.019772950710840613	 totalSpendMoney: o: 5.1552786E9 a: 1.007103E8 (timeTotalSpendRate: 0.019535374868004225

[[Per_Prob_ROI diff: 0.02633801768756556 (up%-> 1429.7352610233108) . o: 0.0018421604618406439 -> a: 0.028180178149406203	 per returnMoney: o:0.022181683974165603 a: 0.0036995229976023777	 per totalSpendMoney: o: 0.02225716224340355 a: 0.003548136122958271

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.0924928396918033

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.04643505801956213     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.0462145038421904 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Five5, 	playerStartValue=4	@@@ 

net money diff:  0.42217527028367774 , up % -> 4200.558817430224 .  o: 0.010050454918804158 -> a: 0.4322257252024819 (anet/onet: 43.00558817430225

[ProbMatrix: total: o: 4.3760345516442476E-4  -> a: 0.03240646916608586
org->adv	$w:50.45733707562648->47.63577228875844  	$d:6.741004980330017->3.0431358637443093  	$l:42.80165794404351->49.32109184749725
	 improve value x$w(high is good):-2.821564786868038  	x$d:-3.697869116585708  	 x$l(negative is good):6.519433903453738
	 	 $w-$l: 7.65567913158296 -> -1.6853195587388126  _ #Surrender#	 lift : -9.340998690321772 : bad	 :| stand

[TimeMatrix: total:  o: 202501.0 -> a: 7903012.0
org->adv	$w:68.5522540629429->68.08649664203978  	$d:5.0083703290354125->4.645519961250217  	$l:26.439375608021688->27.267983396710015
	 improve value x$w(high is good):-0.4657574209031168  	x$d:-0.3628503677851951  	 x$l(negative is good):0.828607788688327
	 	 $w-$l: 42.11287845492121 -> 40.818513245329754  _ @double@	 lift : -1.2943652095914526 : bad	 :| stand

[Prob_ROI diff: -0.04282653944279957 (up%-> -3.9781031329026044) . o: 1.076556791315548 -> a: 1.0337302518727485	 returnMoney: o:0.14133149146824203 a: 13.246411840180388 (probReturnRate: 93.72583351783936	 totalSpendMoney: o: 0.13128103654943787 a: 12.814186114977906 (probTotalSpendRate: 97.60881275607794

[Time_ROI diff: -0.013234491296811868 (up%-> -0.9312661484799847) . o: 1.4211287845492122 -> a: 1.4078942932524003	 returnMoney: o:8.6334E7 a: 4.0592076E9 (timeReturnRate: 47.01748557926194	 totalSpendMoney: o: 6.07503E7 a: 2.8831764E9 (timeTotalSpendRate: 47.45945945945946

[[Per_Prob_ROI diff: -0.026892013819379956 (up%-> -92.42471176101792) . o: 0.029096129495014812 -> a: 0.002204115675634858	 per returnMoney: o:0.0038197700396822173 a: 0.028243948486525346	 per totalSpendMoney: o: 0.0035481361229577806 a: 0.027322358454110674

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.37934873084087817

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.42217527028367774     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9602189686709739 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Six6, 	playerStartValue=4	@@@ 

net money diff:  0.6831510828539762 , up % -> 4446.532054692316 .  o: 0.015363682853316296 -> a: 0.6985147657072925 (anet/onet: 45.46532054692317

[ProbMatrix: total: o: 4.376034551645422E-4  -> a: 0.03240646916610389
org->adv	$w:52.62732579514312->48.55662691794621  	$d:6.448244164616741->3.0814973886879473  	$l:40.92443004024013->48.361875693365846
	 improve value x$w(high is good):-4.070698877196911  	x$d:-3.366746775928794  	 x$l(negative is good):7.437445653125714
	 	 $w-$l: 11.702895754902986 -> 0.19475122458036398  _ #Surrender#	 lift : -11.508144530322623 : bad	 :| stand

[TimeMatrix: total:  o: 115033.0 -> a: 4489396.0
org->adv	$w:68.53598532594994->68.0727206956125  	$d:5.012474681178444->4.646950280171319  	$l:26.45153999287161->27.280329024216176
	 improve value x$w(high is good):-0.46326463033743437  	x$d:-0.365524401007125  	 x$l(negative is good):0.8287890313445665
	 	 $w-$l: 42.084445333078335 -> 40.79239167139633  _ @double@	 lift : -1.2920536616820022 : bad	 :| stand

[Prob_ROI diff: -0.06251790554453773 (up%-> -5.596802582604607) . o: 1.1170289575488925 -> a: 1.0545110520043548	 returnMoney: o:0.14664471940273302 a: 13.512700880689787 (probReturnRate: 92.14584020294392	 totalSpendMoney: o: 0.13128103654941672 a: 12.814186114982494 (probTotalSpendRate: 97.60881275612861

[Time_ROI diff: -0.013210946083472175 (up%-> -0.9297953799589185) . o: 1.4208444533307834 -> a: 1.4076335072473112	 returnMoney: o:4.90332E7 a: 2.305452E9 (timeReturnRate: 47.018183598051934	 totalSpendMoney: o: 3.45099E7 a: 1.6378212E9 (timeTotalSpendRate: 47.45945945945946

[[Per_Prob_ROI diff: -0.027941547407726017 (up%-> -92.5524129969219) . o: 0.03018997182564575 -> a: 0.002248424417919733	 per returnMoney: o:0.00396337079466846 a: 0.028811728956694642	 per totalSpendMoney: o: 0.0035481361229572086 a: 0.027322358454120458

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.6206331773094385

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.6831510828539762     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9440319741739539 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Seven7, 	playerStartValue=4	@@@ 

net money diff:  0.714899931830311 , up % -> 101.54379987279147 .  o: -0.7040311005949142 -> a: 0.010868831235396725 (anet/onet: -0.015437998727914775

[ProbMatrix: total: o: 0.032406469165498275  -> a: 4.376034551641228E-4
org->adv	$w:40.32901579590884->48.253457855802054  	$d:8.593147331088497->11.77214082323655  	$l:51.07783687300267->39.9744013209614
	 improve value x$w(high is good):7.924442059893217  	x$d:3.1789934921480523  	 x$l(negative is good):-11.103435552041269
	 	 $w-$l: -10.748821077093835 -> 8.279056534840656  _ @double@	 lift : 19.02787761193449 : good	 :) hit 

[TimeMatrix: total:  o: 1.00422196E8 -> a: 2214913.0
org->adv	$w:31.52274622634223->31.543044805823072  	$d:3.556440848993185->3.5661897329601655  	$l:64.92081292466459->64.89076546121676
	 improve value x$w(high is good):0.020298579480844126  	x$d:0.009748883966980593  	 x$l(negative is good):-0.03004746344782916
	 	 $w-$l: -33.39806669832235 -> -33.34772065539369  _ #Surrender#	 lift : 0.05034604292866729 : good	 :| stand

[Prob_ROI diff: 0.14527078698198437 (up%-> 15.495223709857735) . o: 0.9375197783660661 -> a: 1.0827905653480505	 returnMoney: o:10.564032331058245 a: 0.1421498677847221 (probReturnRate: 0.01345602354574414	 totalSpendMoney: o: 11.26806343165316 a: 0.13128103654932538 (probTotalSpendRate: 0.011650718630190111

[Time_ROI diff: -0.0018983415384018487 (up%-> -0.2840038172111312) . o: 0.668421134984465 -> a: 0.6665227934460631	 returnMoney: o:2.01973884E10 a: 4.42887E8 (timeReturnRate: 0.021927934009527687	 totalSpendMoney: o: 3.02165616E10 a: 6.644739E8 (timeTotalSpendRate: 0.02199038754958804

[[Per_Prob_ROI diff: 8.840916308339187E-4 (up%-> 1606.9853488635604) . o: 5.501553772466793E-5 -> a: 9.391071685585866E-4	 per returnMoney: o:6.199185688080655E-4 a: 1.2328696251927328E-4	 per totalSpendMoney: o: 6.612325234231066E-4 a: 1.138603959664574E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.8601707188122953

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.714899931830311     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.1549522370985772 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Eight8, 	playerStartValue=4	@@@ 

net money diff:  1.446704284673251 , up % -> 99.45481881920499 .  o: -1.454634679193532 -> a: -0.007930394520281034 (anet/onet: 0.005451811807950121

[ProbMatrix: total: o: 0.03240646916583761  -> a: 4.3760345516425503E-4
org->adv	$w:36.9153895594637->38.36043516129445  	$d:8.578141270380174->17.23835278479196  	$l:54.50646917015614->44.40121205391359
	 improve value x$w(high is good):1.4450456018307491  	x$d:8.660211514411786  	 x$l(negative is good):-10.105257116242548
	 	 $w-$l: -17.59107961069244 -> -6.040776892619143  _ #Surrender#	 lift : 11.550302718073297 : good	 :) hit 

[TimeMatrix: total:  o: 6.0274228E7 -> a: 1329409.0
org->adv	$w:31.51339574187495->31.53326026828463  	$d:3.558021514601564->3.5685782178396566  	$l:64.92858274352349->64.89816151387572
	 improve value x$w(high is good):0.01986452640967684  	x$d:0.010556703238092435  	 x$l(negative is good):-0.030421229647771497
	 	 $w-$l: -33.41518700164854 -> -33.36490124559109  _ #Surrender#	 lift : 0.05028575605744989 : good	 :| stand

[Prob_ROI diff: 0.06868581383328387 (up%-> 7.886704297222204) . o: 0.8709064172404165 -> a: 0.9395922310737004	 returnMoney: o:9.813428752763112 a: 0.12335064202911532 (probReturnRate: 0.01256957635672284	 totalSpendMoney: o: 11.268063431956644 a: 0.13128103654939635 (probTotalSpendRate: 0.01165071862988262

[Time_ROI diff: -0.001898687382817399 (up%-> -0.2841284409191936) . o: 0.6682496749269066 -> a: 0.6663509875440892	 returnMoney: o:1.2119529E10 a: 2.657559E8 (timeReturnRate: 0.021927906604291305	 totalSpendMoney: o: 1.81362288E10 a: 3.988227E8 (timeTotalSpendRate: 0.02199038754958804

[[Per_Prob_ROI diff: 7.638043359153615E-4 (up%-> 1494.5336755671844) . o: 5.1106532318550345E-5 -> a: 8.149108682339118E-4	 per returnMoney: o:5.758716479527675E-4 a: 1.069823434771165E-4	 per totalSpendMoney: o: 6.612325234409157E-4 a: 1.1386039596651896E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.515390098506535

 按net净收益值(代表少输多赢) :  $Change$  Value: 1.446704284673251     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.078867042972222 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Nine9, 	playerStartValue=4	@@@ 

net money diff:  2.2697401836430657 , up % -> 98.79668658176325 .  o: -2.2973849247106575 -> a: -0.02764474106759182 (anet/onet: 0.012033134182367598

[ProbMatrix: total: o: 0.03240646916589808  -> a: 4.376034551644288E-4
org->adv	$w:32.957215324314696->33.70129935686453  	$d:8.856667055909794->11.539720912748805  	$l:58.18611761977552->54.758979730386656
	 improve value x$w(high is good):0.7440840325498357  	x$d:2.6830538568390114  	 x$l(negative is good):-3.4271378893888667
	 	 $w-$l: -25.22890229546083 -> -21.057680373522125  _ #Surrender#	 lift : 4.171221921938706 : good	 :) hit 

[TimeMatrix: total:  o: 4.7287348E7 -> a: 886657.0
org->adv	$w:31.47266368162579->31.50530588491378  	$d:3.5609863340189856->3.569813355108007  	$l:64.96634998435522->64.92488075997821
	 improve value x$w(high is good):0.03264220328799183  	x$d:0.008827021089021336  	 x$l(negative is good):-0.041469224377010505
	 	 $w-$l: -33.49368630272943 -> -33.41957487506443  _ #Surrender#	 lift : 0.07411142766500234 : good	 :| stand

[Prob_ROI diff: -0.006692175417099766 (up%-> -0.8406037183982732) . o: 0.7961153716820762 -> a: 0.7894231962649765	 returnMoney: o:8.9706785073607 a: 0.10363629548180042 (probReturnRate: 0.011552782255741731	 totalSpendMoney: o: 11.268063432071358 a: 0.13128103654939224 (probTotalSpendRate: 0.011650718629763645

[Time_ROI diff: -0.001301447550863144 (up%-> -0.19508865734527242) . o: 0.6671056988002189 -> a: 0.6658042512493557	 returnMoney: o:9.4877064E9 a: 1.77102E8 (timeReturnRate: 0.018666471382377516	 totalSpendMoney: o: 1.42221936E10 a: 2.659971E8 (timeTotalSpendRate: 0.018702958733454452

[[Per_Prob_ROI diff: 6.450867310419477E-4 (up%-> 1629.7423568186086) . o: 3.958212955213425E-5 -> a: 6.846688605940819E-4	 per returnMoney: o:4.46013946569915E-4 a: 8.988403771188241E-5	 per totalSpendMoney: o: 5.602378278760682E-4 a: 1.1386039596651539E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 2.263048008225966

 按net净收益值(代表少输多赢) :  $Change$  Value: 2.2697401836430657     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9915939628160172 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Ten, 	playerStartValue=4	@@@ 

net money diff:  3.251430520991281 , up % -> 98.80116501104933 .  o: -3.2908827751450707 -> a: -0.03945225415379004 (anet/onet: 0.01198834988950674

[ProbMatrix: total: o: 0.032406469166020184  -> a: 4.376034551645699E-4
org->adv	$w:28.387666564787516->29.96747031001214  	$d:9.374606888327946->10.01330537896208  	$l:62.23772654688453->60.01922431102577
	 improve value x$w(high is good):1.5798037452246234  	x$d:0.638698490634134  	 x$l(negative is good):-2.2185022358587574
	 	 $w-$l: -33.850059982097015 -> -30.051754001013638  _ #Surrender#	 lift : 3.7983059810833772 : good	 :) hit 

[TimeMatrix: total:  o: 2.539306E7 -> a: 443905.0
org->adv	$w:31.35149525106466->31.464389903245067  	$d:3.564627500584806->3.576891451999865  	$l:65.08387724835053->64.95871864475508
	 improve value x$w(high is good):0.11289465218040817  	x$d:0.012263951415059093  	 x$l(negative is good):-0.12515860359545172
	 	 $w-$l: -33.73238199728587 -> -33.49432874151001  _ #Surrender#	 lift : 0.23805325577586078 : good	 :) hit 

[Prob_ROI diff: 0.03798305980443839 (up%-> 5.7419643606302815) . o: 0.6614994001855679 -> a: 0.6994824599900062	 returnMoney: o:6.431057974588167 a: 0.09182878239561752 (probReturnRate: 0.014278954218492809	 totalSpendMoney: o: 9.721940749733237 a: 0.13128103654940756 (probTotalSpendRate: 0.01350358327919349

[Time_ROI diff: 0.002380532557758719 (up%-> 0.3592301382646981) . o: 0.6626761800271412 -> a: 0.6650567125849	 returnMoney: o:5.0482128E9 a: 8.85666E7 (timeReturnRate: 0.017544149485932924	 totalSpendMoney: o: 7.617918E9 a: 1.331715E8 (timeTotalSpendRate: 0.01748135120383286

[[Per_Prob_ROI diff: 5.760394637310272E-4 (up%-> 1881.0339741144624) . o: 3.062355447366177E-5 -> a: 6.06663018204689E-4	 per returnMoney: o:2.9772038213916793E-4 a: 7.964334986610367E-5	 per totalSpendMoney: o: 4.5006901299630747E-4 a: 1.1386039596652867E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 3.289413580795719

 按net净收益值(代表少输多赢) :  $Change$  Value: 3.251430520991281     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.0574196436063026 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 */
	}
	
	public static void test55vsAll() {
		StrategyMatrix8012 o = new Myth2019April22();
		StrategyMatrix8012 t = new MirMyth2019April22();
		
		System.out.println(t.diffWith(o));
		
		for(Card playerCard : Card.values()) {
			if(playerCard.getValue() == 5) {
				for(Card dealerCard : Card.values()) {
					if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
//					if(dealerCard != Card.Five5 && dealerCard != Card.Six6) continue;
					PlayerCardsPathValue nine = new PlayerCardsPathValue(playerCard,playerCard);
					Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, nine, dealerCard); 
//					HelloWorld.print(origin);
					PlayerCardsPathValue ninet = new PlayerCardsPathValue(playerCard,playerCard);
					Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, ninet, dealerCard); 
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
MatrixKey [startValue=Five, dealerCard=One1, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Five, dealerCard=One1, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Five, dealerCard=Two2, situation=Start_With_Pair] : Split -> Double
MatrixKey [startValue=Five, dealerCard=Two2, situation=Splited_Pair_And_Can_Split] : Split -> Double
MatrixKey [startValue=Five, dealerCard=Three3, situation=Start_With_Pair] : Split -> Double
MatrixKey [startValue=Five, dealerCard=Three3, situation=Splited_Pair_And_Can_Split] : Split -> Double
MatrixKey [startValue=Five, dealerCard=Four4, situation=Start_With_Pair] : Split -> Double
MatrixKey [startValue=Five, dealerCard=Four4, situation=Splited_Pair_And_Can_Split] : Split -> Double
MatrixKey [startValue=Five, dealerCard=Five5, situation=Splited_Pair_And_Can_Split] : Split -> Double
MatrixKey [startValue=Five, dealerCard=Five5, situation=Start_With_Pair] : Split -> Double
MatrixKey [startValue=Five, dealerCard=Six6, situation=Splited_Pair_And_Can_Split] : Split -> Double
MatrixKey [startValue=Five, dealerCard=Six6, situation=Start_With_Pair] : Split -> Double
MatrixKey [startValue=Five, dealerCard=Seven7, situation=Splited_Pair_And_Can_Split] : Split -> Double
MatrixKey [startValue=Five, dealerCard=Seven7, situation=Start_With_Pair] : Split -> Double
MatrixKey [startValue=Five, dealerCard=Eight8, situation=Start_With_Pair] : Split -> Double
MatrixKey [startValue=Five, dealerCard=Eight8, situation=Splited_Pair_And_Can_Split] : Split -> Double
MatrixKey [startValue=Five, dealerCard=Nine9, situation=Splited_Pair_And_Can_Split] : Split -> Double
MatrixKey [startValue=Five, dealerCard=Nine9, situation=Start_With_Pair] : Split -> Double
MatrixKey [startValue=Five, dealerCard=Ten, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Five, dealerCard=Ten, situation=Start_With_Pair] : Split -> Hit


		 @@@   dealerCard=One1, 	playerStartValue=5	@@@ 

net money diff:  4.6374370145327815 , up % -> 99.38909468073633 .  o: -4.665941499346017 -> a: -0.02850448481323592 (anet/onet: 0.006109053192636714

[ProbMatrix: total: o: 0.03240646916232452  -> a: 4.376034551642487E-4
org->adv	$w:21.018499254172205->32.70384438867883  	$d:9.969070858628816->12.879742856045143  	$l:69.01242988719898->54.41641275527601
	 improve value x$w(high is good):11.685345134506626  	x$d:2.910671997416326  	 x$l(negative is good):-14.596017131922963
	 	 $w-$l: -47.99393063302677 -> -21.71256836659718  _ #Surrender#	 lift : 26.281362266429593 : good	 :) hit 

[TimeMatrix: total:  o: 5.5386682E8 -> a: 5470465.0
org->adv	$w:31.587539401620052->31.80998324639679  	$d:3.5106092832930487->3.5296451032956067  	$l:64.9018513150869->64.6603716503076
	 improve value x$w(high is good):0.22244384477673762  	x$d:0.01903582000255799  	 x$l(negative is good):-0.24147966477930538
	 	 $w-$l: -33.314311913466845 -> -32.85038840391081  _ #Surrender#	 lift : 0.4639235095560357 : good	 :) hit 

[Prob_ROI diff: 0.262813622690079 (up%-> 50.535182893427724) . o: 0.5200606936445041 -> a: 0.7828743163345832	 returnMoney: o:5.055999249324206 a: 0.10277655173682207 (probReturnRate: 0.02032764378882362	 totalSpendMoney: o: 9.721940748670223 a: 0.131281036550058 (probTotalSpendRate: 0.013503583280736899

[Time_ROI diff: 0.004639235095560301 (up%-> 0.695686770081806) . o: 0.6668568808653315 -> a: 0.6714961159608918	 returnMoney: o:1.1080497E11 a: 1.1020188E9 (timeReturnRate: 0.00994557193598807	 totalSpendMoney: o: 1.66160046E11 a: 1.6411395E9 (timeTotalSpendRate: 0.009876859928168292

[[Per_Prob_ROI diff: 0.001993015321463405 (up%-> 4930.221111490774) . o: 4.0424461223824654E-5 -> a: 0.0020334397826872294	 per returnMoney: o:3.930042168149402E-4 a: 2.669520824333041E-4	 per totalSpendMoney: o: 7.556891370905731E-4 a: 3.409897053248259E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 4.90025063722286

 按net净收益值(代表少输多赢) :  $Change$  Value: 4.6374370145327815     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.5053518289342773 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Two2, 	playerStartValue=5	@@@ 

net money diff:  1.1287761943266912 , up % -> 104.41926905283596 .  o: -1.0810037309833422 -> a: 0.04777246334334895 (anet/onet: -0.04419269052835961

[ProbMatrix: total: o: 0.032406469165745425  -> a: 4.3760345516479263E-4
org->adv	$w:41.239878449356716->55.1545799928706  	$d:3.6400423958350276->7.885571179975176  	$l:55.12007915480825->36.95984882715423
	 improve value x$w(high is good):13.914701543513885  	x$d:4.245528784140149  	 x$l(negative is good):-18.16023032765402
	 	 $w-$l: -13.88020070545154 -> 18.19473116571637  _ @double@	 lift : 32.07493187116791 : good	 :) hit 

[TimeMatrix: total:  o: 5.3271244E7 -> a: 346957.0
org->adv	$w:57.502850881424884->70.19918894848641  	$d:4.12993546762302->5.179316168862424  	$l:38.367213650952095->24.621494882651167
	 improve value x$w(high is good):12.696338067061525  	x$d:1.0493807012394036  	 x$l(negative is good):-13.745718768300929
	 	 $w-$l: 19.135637230472785 -> 45.57769406583525  _ @double@	 lift : 26.442056835362465 : good	 :) hit 

[Prob_ROI diff: 0.2807574855532723 (up%-> 31.154089562595548) . o: 0.9011898261034642 -> a: 1.1819473116567365	 returnMoney: o:9.85920301448056 a: 0.31033453644216413 (probReturnRate: 0.03147663517896577	 totalSpendMoney: o: 10.940206745463902 a: 0.2625620730988152 (probTotalSpendRate: 0.02399973594719134

[Time_ROI diff: 0.24681924047449533 (up%-> 20.415870665860293) . o: 1.2089577001838572 -> a: 1.4557769406583525	 returnMoney: o:2.05791732E10 a: 3.030552E8 (timeReturnRate: 0.014726305913981034	 totalSpendMoney: o: 1.70222442E10 a: 2.081742E8 (timeTotalSpendRate: 0.012229539040451553

[[Per_Prob_ROI diff: 0.08955565056042798 (up%-> 6568.681015451973) . o: 0.0013633734131671168 -> a: 0.0909190239735951	 per returnMoney: o:0.014915587011317035 a: 0.02387188741862801	 per totalSpendMoney: o: 0.01655099356348548 a: 0.020197082546062707

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.4095336798799636

 按net净收益值(代表少输多赢) :  $Change$  Value: 1.1287761943266912     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.3115408956259553 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Three3, 	playerStartValue=5	@@@ 

net money diff:  0.7580287788973348 , up % -> 107.73938328468213 .  o: -0.7035763114537037 -> a: 0.054452467443631025 (anet/onet: -0.0773938328468213

[ProbMatrix: total: o: 0.03240646916596422  -> a: 4.37603455164715E-4
org->adv	$w:42.872217862302776->56.54393117134825  	$d:3.44384978634618->7.651030674496095  	$l:53.68393235135105->35.80503815415565
	 improve value x$w(high is good):13.671713309045472  	x$d:4.2071808881499155  	 x$l(negative is good):-17.878894197195393
	 	 $w-$l: -10.811714489048274 -> 20.738893017192595  _ @double@	 lift : 31.55060750624087 : good	 :) hit 

[TimeMatrix: total:  o: 2.768434E7 -> a: 202189.0
org->adv	$w:57.80756918893497->70.18037578701116  	$d:4.122431670756825->5.1822799459911275  	$l:38.069999140308205->24.63734426699771
	 improve value x$w(high is good):12.372806598076188  	x$d:1.0598482752343026  	 x$l(negative is good):-13.432654873310494
	 	 $w-$l: 19.73757004862677 -> 45.54303152001346  _ @double@	 lift : 25.805461471386685 : good	 :) hit 

[Prob_ROI diff: 0.26745554063781274 (up%-> 28.454733454084813) . o: 0.9399333895338886 -> a: 1.2073889301717013	 returnMoney: o:11.009691775325551 a: 0.3170145405424639 (probReturnRate: 0.028794134024073527	 totalSpendMoney: o: 11.713268086779255 a: 0.2625620730988329 (probTotalSpendRate: 0.02241578278185114

[Time_ROI diff: 0.23332807532223776 (up%-> 19.09235313614597) . o: 1.2221022398778967 -> a: 1.4554303152001344	 returnMoney: o:1.13359872E10 a: 1.765632E8 (timeReturnRate: 0.01557545865965692	 totalSpendMoney: o: 9.2758092E9 a: 1.213134E8 (timeTotalSpendRate: 0.013078470824949699

[[Per_Prob_ROI diff: 0.09128025934532999 (up%-> 5719.9875388043065) . o: 0.0015958122063393695 -> a: 0.09287607155166935	 per returnMoney: o:0.018692176189007727 a: 0.02438573388788184	 per totalSpendMoney: o: 0.019886703033581078 a: 0.020197082546064067

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.0254843195351475

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.7580287788973348     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.2845473345408485 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Four4, 	playerStartValue=5	@@@ 

net money diff:  0.34277869780263376 , up % -> 121.85079624862976 .  o: -0.28131018290862286 -> a: 0.061468514894010895 (anet/onet: -0.21850796248629764

[ProbMatrix: total: o: 0.03240646916607219  -> a: 4.3760345516466166E-4
org->adv	$w:44.935779106319515->58.01448658257564  	$d:2.898265080582246->7.382067953066216  	$l:52.16595581309823->34.60344546435813
	 improve value x$w(high is good):13.078707476256128  	x$d:4.48380287248397  	 x$l(negative is good):-17.562510348740098
	 	 $w-$l: -7.230176706778718 -> 23.411041118217508  _ @double@	 lift : 30.641217824996225 : good	 :) hit 

[TimeMatrix: total:  o: 8310868.0 -> a: 117949.0
org->adv	$w:67.78103081410991->70.16337569627551  	$d:4.597305600329593->5.185291948214906  	$l:27.621663585560498->24.651332355509584
	 improve value x$w(high is good):2.3823448821655973  	x$d:0.5879863478853133  	 x$l(negative is good):-2.9703312300509133
	 	 $w-$l: 40.159367228549414 -> 45.51204334076593  _ @double@	 lift : 5.352676112216514 : good	 :) hit 

[Prob_ROI diff: 0.25663986505648895 (up%-> 26.255508779645403) . o: 0.97747054612573 -> a: 1.234110411182219	 returnMoney: o:12.205019245160479 a: 0.3240305879927896 (probReturnRate: 0.026548961659464312	 totalSpendMoney: o: 12.486329428069102 a: 0.2625620730987787 (probTotalSpendRate: 0.021027962990351888

[Time_ROI diff: 0.05334122453923351 (up%-> 3.80525151191911) . o: 1.4017792088684258 -> a: 1.4551204334076593	 returnMoney: o:4.5862344E9 a: 1.02978E8 (timeReturnRate: 0.022453714969300303	 totalSpendMoney: o: 3.2717238E9 a: 7.07694E7 (timeTotalSpendRate: 0.021630615640599003

[[Per_Prob_ROI diff: 0.09168415963869496 (up%-> 2823.300626359482) . o: 0.00324741045224495 -> a: 0.09493157009093992	 per returnMoney: o:0.04054823669488531 a: 0.0249254298455992	 per totalSpendMoney: o: 0.04148282202016313 a: 0.0201970825460599

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.5994185628591227

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.34277869780263376     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.262555087796454 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Five5, 	playerStartValue=5	@@@ 

net money diff:  -0.12010907792318992 , up % -> -63.587729819328345 .  o: 0.18888719296074186 -> a: 0.06877811503755193 (anet/onet: 0.3641227018067165

[ProbMatrix: total: o: 0.03240646916609348  -> a: 4.3760345516464226E-4
org->adv	$w:46.969278268225466->59.547923950427325  	$d:2.789707749026788->7.099144477826699  	$l:50.24101398274775->33.35293157174598
	 improve value x$w(high is good):12.57864568220186  	x$d:4.309436728799911  	 x$l(negative is good):-16.888082411001776
	 	 $w-$l: -3.2717357145222836 -> 26.194992378681352  _ @double@	 lift : 29.46672809320364 : good	 :) hit 

[TimeMatrix: total:  o: 5013268.0 -> a: 71149.0
org->adv	$w:67.76912784235752->70.15277797298627  	$d:4.599155680486262->5.186299174970835  	$l:27.63171647715622->24.660922852042898
	 improve value x$w(high is good):2.3836501306287516  	x$d:0.5871434944845735  	 x$l(negative is good):-2.9707936251133233
	 	 $w-$l: 40.1374113652013 -> 45.49185512094337  _ @double@	 lift : 5.354443755742066 : good	 :) hit 

[Prob_ROI diff: 0.24682240420246826 (up%-> 24.314423502528516) . o: 1.0151275195844172 -> a: 1.2619499237868854	 returnMoney: o:12.675216621039224 a: 0.3313401881363314 (probReturnRate: 0.026140790965761444	 totalSpendMoney: o: 12.486329428078482 a: 0.2625620730987795 (probTotalSpendRate: 0.02102796299033615

[Time_ROI diff: 0.05335960490123748 (up%-> 3.8071609504395365) . o: 1.4015589463081963 -> a: 1.4549185512094338	 returnMoney: o:2.766066E9 a: 6.21096E7 (timeReturnRate: 0.022454127992607553	 totalSpendMoney: o: 1.9735638E9 a: 4.26894E7 (timeTotalSpendRate: 0.021630615640599003

[[Per_Prob_ROI diff: 0.09370055438416947 (up%-> 2778.357036481622) . o: 0.00337251667636019 -> a: 0.09707307106052966	 per returnMoney: o:0.04211035422272168 a: 0.025487706779717803	 per totalSpendMoney: o: 0.04148282202019429 a: 0.02019708254605996

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.12671332627927834

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.12010907792318992     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.2431442350252853 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Six6, 	playerStartValue=5	@@@ 

net money diff:  -0.3661616502110047 , up % -> -82.7683780061382 .  o: 0.4423931687822247 -> a: 0.07623151857121996 (anet/onet: 0.17231621993861795

[ProbMatrix: total: o: 0.032406469166112124  -> a: 4.3760345516465174E-4
org->adv	$w:47.88325540870279->61.10339389825326  	$d:2.8038418694227336->6.826925135264157  	$l:49.31290272187449->32.069680966482586
	 improve value x$w(high is good):13.220138489550472  	x$d:4.023083265841423  	 x$l(negative is good):-17.2432217553919
	 	 $w-$l: -1.4296473131717002 -> 29.033712931770665  _ @double@	 lift : 30.46336024494237 : good	 :) hit 

[TimeMatrix: total:  o: 2847844.0 -> a: 40417.0
org->adv	$w:67.75546694271175->70.13632877254621  	$d:4.600251980094415->5.190885023628671  	$l:27.64428107719383->24.672786203825122
	 improve value x$w(high is good):2.3808618298344584  	x$d:0.5906330435342566  	 x$l(negative is good):-2.9714948733687088
	 	 $w-$l: 40.11118586551792 -> 45.46354256872108  _ @double@	 lift : 5.352356703203165 : good	 :) hit 

[Prob_ROI diff: 0.25490692772570034 (up%-> 24.618455916561235) . o: 1.0354302015920516 -> a: 1.290337129317752	 returnMoney: o:12.928722596878714 a: 0.3387935916700083 (probReturnRate: 0.02620472278922596	 totalSpendMoney: o: 12.48632942809649 a: 0.2625620730987883 (probTotalSpendRate: 0.021027962990306532

[Time_ROI diff: 0.05333738537806609 (up%-> 3.8062841625254227) . o: 1.4012980403091448 -> a: 1.454635425687211	 returnMoney: o:1.5710028E9 a: 3.52752E7 (timeReturnRate: 0.022453938337983866	 totalSpendMoney: o: 1.1211054E9 a: 2.42502E7 (timeTotalSpendRate: 0.021630615640599003

[[Per_Prob_ROI diff: 0.09581673480806203 (up%-> 2785.3965562219187) . o: 0.003439967447149673 -> a: 0.0992567022552117	 per returnMoney: o:0.042952566767038916 a: 0.02606104551307756	 per totalSpendMoney: o: 0.04148282202025412 a: 0.02019708254606064

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.11125472248530438

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.3661616502110047     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.2461845591656124 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Seven7, 	playerStartValue=5	@@@ 

net money diff:  1.1857631191377802 , up % -> 104.64600123251076 .  o: -1.1331184232287654 -> a: 0.05264469590901477 (anet/onet: -0.04646001232510746

[ProbMatrix: total: o: 0.032406469165852235  -> a: 4.376034551646694E-4
org->adv	$w:38.60375146641363->56.25444575813206  	$d:8.301993138947159->7.541489442300149  	$l:53.09425539463921->36.20406479956779
	 improve value x$w(high is good):17.65069429171843  	x$d:-0.7605036966470102  	 x$l(negative is good):-16.890190595071424
	 	 $w-$l: -14.490503928225584 -> 20.05038095856426  _ @double@	 lift : 34.54088488678985 : good	 :) hit 

[TimeMatrix: total:  o: 5.8882492E7 -> a: 24973.0
org->adv	$w:31.57500535133601->70.08769471028711  	$d:3.55914623993835->5.193609097825651  	$l:64.86584840872564->24.718696191887236
	 improve value x$w(high is good):38.5126893589511  	x$d:1.6344628578873008  	 x$l(negative is good):-40.14715221683841
	 	 $w-$l: -33.29084305738962 -> 45.36899851839987  _ @double@	 lift : 78.65984157578949 : good	 :) hit 

[Prob_ROI diff: 0.30407757648286715 (up%-> 33.92109303075253) . o: 0.8964262331027877 -> a: 1.2005038095856548	 returnMoney: o:9.807088321914373 a: 0.3152067690078058 (probReturnRate: 0.03214070870591247	 totalSpendMoney: o: 10.940206745143138 a: 0.26256207309879104 (probTotalSpendRate: 0.023999735947892797

[Time_ROI diff: 0.7831771808452744 (up%-> 116.80271812522098) . o: 0.6705128043387242 -> a: 1.4536899851839986	 returnMoney: o:1.18946736E10 a: 2.17818E7 (timeReturnRate: 0.0018312230106087147	 totalSpendMoney: o: 1.77396666E10 a: 1.49838E7 (timeTotalSpendRate: 8.44649470469755E-4

[[Per_Prob_ROI diff: 0.09225867383401214 (up%-> 105110.47100946736) . o: 8.77730571920873E-5 -> a: 0.09234644689120422	 per returnMoney: o:9.60255392334708E-4 a: 0.024246674539061985	 per totalSpendMoney: o: 0.0010712040287029411 a: 0.020197082546060847

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.4898406956206474

 按net净收益值(代表少输多赢) :  $Change$  Value: 1.1857631191377802     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.3392109303075255 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Eight8, 	playerStartValue=5	@@@ 

net money diff:  1.9080841395103363 , up % -> 102.05815925167083 .  o: -1.8696046974598932 -> a: 0.038479442050443124 (anet/onet: -0.02058159251670825

[ProbMatrix: total: o: 0.03240646916601093  -> a: 4.376034551646737E-4
org->adv	$w:34.994486111982475->53.596212220308956  	$d:8.641780736568796->7.462945086405427  	$l:56.36373315144873->38.94084269328563
	 improve value x$w(high is good):18.60172610832648  	x$d:-1.1788356501633688  	 x$l(negative is good):-17.422890458163096
	 	 $w-$l: -21.36924703946625 -> 14.655369527023327  _ @double@	 lift : 36.02461656648958 : good	 :) hit 

[TimeMatrix: total:  o: 3.5341756E7 -> a: 14989.0
org->adv	$w:31.565652821551932->70.0647141236907  	$d:3.560700266279921->5.21048769097338  	$l:64.87364691216814->24.724798185335914
	 improve value x$w(high is good):38.49906130213877  	x$d:1.6497874246934594  	 x$l(negative is good):-40.14884872683223
	 	 $w-$l: -33.30799409061622 -> 45.33991593835479  _ @double@	 lift : 78.647910028971 : good	 :) hit 

[Prob_ROI diff: 0.31744669034673256 (up%-> 38.28778293533047) . o: 0.8291070049235083 -> a: 1.1465536952702409	 returnMoney: o:9.070602047837413 a: 0.30104151514923544 (probReturnRate: 0.033188702752206936	 totalSpendMoney: o: 10.940206745297306 a: 0.2625620730987923 (probTotalSpendRate: 0.023999735947554713

[Time_ROI diff: 0.7830582008379793 (up%-> 116.81491200194179) . o: 0.6703409585455687 -> a: 1.453399159383548	 returnMoney: o:7.1374512E9 a: 1.3071E7 (timeReturnRate: 0.0018313260061238667	 totalSpendMoney: o: 1.06474938E10 a: 8993400.0 (timeTotalSpendRate: 8.44649470469755E-4

[[Per_Prob_ROI diff: 0.0881152565638889 (up%-> 108541.00977834848) . o: 8.118153382194343E-5 -> a: 0.08819643809771084	 per returnMoney: o:8.88142763912407E-4 a: 0.023157039626864266	 per totalSpendMoney: o: 0.0010712040287180365 a: 0.020197082546060948

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 2.225530829857069

 按net净收益值(代表少输多赢) :  $Change$  Value: 1.9080841395103363     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.3828778293533046 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Nine9, 	playerStartValue=5	@@@ 

net money diff:  2.718388744442373 , up % -> 100.74511663527737 .  o: -2.698283386065871 -> a: 0.020105358376502125 (anet/onet: -0.007451166352773634

[ProbMatrix: total: o: 0.03240646916606656  -> a: 4.376034551646757E-4
org->adv	$w:31.14577850497756->49.447280441448235  	$d:8.61606061921967->8.762812529497936  	$l:60.23816087580276->41.789907029053836
	 improve value x$w(high is good):18.301501936470675  	x$d:0.14675191027826529  	 x$l(negative is good):-18.448253846748926
	 	 $w-$l: -29.0923823708252 -> 7.6573734123943975  _ @double@	 lift : 36.7497557832196 : good	 :) hit 

[TimeMatrix: total:  o: 2.711494E7 -> a: 9997.0
org->adv	$w:31.519634563085887->70.05101530459137  	$d:3.5632680728779045->5.171551465439632  	$l:64.91709736403621->24.777433229968988
	 improve value x$w(high is good):38.53138074150549  	x$d:1.6082833925617273  	 x$l(negative is good):-40.13966413406722
	 	 $w-$l: -33.39746280095033 -> 45.27358207462239  _ @double@	 lift : 78.67104487557272 : good	 :) hit 

[Prob_ROI diff: 0.3232128926762513 (up%-> 42.90279968031589) . o: 0.7533608414477057 -> a: 1.076573734123957	 returnMoney: o:8.24192335930283 a: 0.2826674314752976 (probReturnRate: 0.034296294584715475	 totalSpendMoney: o: 10.9402067453687 a: 0.2625620730987955 (probTotalSpendRate: 0.023999735947398387

[Time_ROI diff: 0.783734600459256 (up%-> 117.14995080622923) . o: 0.6690012202869677 -> a: 1.4527358207462238	 returnMoney: o:5.4620424E9 a: 8713800.0 (timeReturnRate: 0.0015953373045950723	 totalSpendMoney: o: 8.164473E9 a: 5998200.0 (timeTotalSpendRate: 7.34670810963549E-4

[[Per_Prob_ROI diff: 0.08274924288995823 (up%-> 129051.15334184858) . o: 6.412127342307478E-5 -> a: 0.08281336416338131	 per returnMoney: o:7.014999880247536E-4 a: 0.02174364857502289	 per totalSpendMoney: o: 9.311606728546004E-4 a: 0.02019708254606119

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 3.041601637118624

 按net净收益值(代表少输多赢) :  $Change$  Value: 2.718388744442373     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.4290279968031587 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Ten, 	playerStartValue=5	@@@ 

net money diff:  3.6186918318577357 , up % -> 99.84404334847348 .  o: -3.6243442377707575 -> a: -0.005652405913021824 (anet/onet: 0.0015595665152652487

[ProbMatrix: total: o: 0.032406469166097907  -> a: 4.3760345516459477E-4
org->adv	$w:26.975015363067968->39.52036783224595  	$d:8.769920659286228->16.65368748938565  	$l:64.2550639776458->43.8259446783684
	 improve value x$w(high is good):12.545352469177985  	x$d:7.883766830099422  	 x$l(negative is good):-20.429119299277403
	 	 $w-$l: -37.28004861457783 -> -4.30557684612245  _ #Surrender#	 lift : 32.97447176845538 : good	 :) hit 

[TimeMatrix: total:  o: 1.50073E7 -> a: 148225.0
org->adv	$w:31.361004311235195->31.580367684263788  	$d:3.565478133974799->3.5898127846179797  	$l:65.07351755479->64.82981953111823
	 improve value x$w(high is good):0.21936337302859243  	x$d:0.024334650643180744  	 x$l(negative is good):-0.24369802367176874
	 	 $w-$l: -33.71251324355481 -> -33.24945184685445  _ #Surrender#	 lift : 0.4630613967003594 : good	 :) hit 

[Prob_ROI diff: 0.32974471768115676 (up%-> 52.57413476822532) . o: 0.6271995138576154 -> a: 0.9569442315387722	 returnMoney: o:6.097596512023498 a: 0.1256286306363985 (probReturnRate: 0.02060297535080891	 totalSpendMoney: o: 9.721940749794255 a: 0.13128103654942033 (probTotalSpendRate: 0.01350358327911005

[Time_ROI diff: 0.004630613967003483 (up%-> 0.6985653241036844) . o: 0.662874867564452 -> a: 0.6675054815314555	 returnMoney: o:2.9843886E9 a: 2.96823E7 (timeReturnRate: 0.00994585624673677	 totalSpendMoney: o: 4.50219E9 a: 4.44675E7 (timeTotalSpendRate: 0.009876859928168292

[[Per_Prob_ROI diff: 0.0024368170412850986 (up%-> 4998.353879982388) . o: 4.87523912831415E-5 -> a: 0.00248556943256824	 per returnMoney: o:4.7396785946548755E-4 a: 3.26308131523113E-4	 per totalSpendMoney: o: 7.556891371779444E-4 a: 3.409897053231697E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 3.9484365495388927

 按net净收益值(代表少输多赢) :  $Change$  Value: 3.6186918318577357     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.5257413476822532 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


 
		 */
	}
	
	public static void test66vsAll() {
		StrategyMatrix8012 o = new Myth2019April22();
		StrategyMatrix8012 t = new MirMyth2019April22();
		
		System.out.println(t.diffWith(o));
		
		for(Card playerCard : Card.values()) {
			if(playerCard.getValue() == 6) {
				for(Card dealerCard : Card.values()) {
					if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
					PlayerCardsPathValue nine = new PlayerCardsPathValue(playerCard,playerCard);
					Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, nine, dealerCard); 
//					HelloWorld.print(origin);
					PlayerCardsPathValue ninet = new PlayerCardsPathValue(playerCard,playerCard);
					Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, ninet, dealerCard); 
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
MatrixKey [startValue=Six, dealerCard=One1, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Six, dealerCard=One1, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Six, dealerCard=Two2, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Six, dealerCard=Two2, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Six, dealerCard=Three3, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Six, dealerCard=Three3, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Six, dealerCard=Four4, situation=Splited_Pair_And_Can_Split] : Split -> Stand
MatrixKey [startValue=Six, dealerCard=Four4, situation=Start_With_Pair] : Split -> Stand
MatrixKey [startValue=Six, dealerCard=Five5, situation=Splited_Pair_And_Can_Split] : Stand -> Split
MatrixKey [startValue=Six, dealerCard=Five5, situation=Start_With_Pair] : Stand -> Split
MatrixKey [startValue=Six, dealerCard=Six6, situation=Start_With_Pair] : Stand -> Split
MatrixKey [startValue=Six, dealerCard=Six6, situation=Splited_Pair_And_Can_Split] : Stand -> Split
MatrixKey [startValue=Six, dealerCard=Seven7, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Six, dealerCard=Seven7, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Six, dealerCard=Eight8, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Six, dealerCard=Eight8, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Six, dealerCard=Nine9, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Six, dealerCard=Nine9, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Six, dealerCard=Ten, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Six, dealerCard=Ten, situation=Splited_Pair_And_Can_Split] : Split -> Hit


		 @@@   dealerCard=One1, 	playerStartValue=6	@@@ 

net money diff:  4.647494030939495 , up % -> 98.54874020081428 .  o: -4.715934492383389 -> a: -0.0684404614438936 (anet/onet: 0.014512597991857269

[ProbMatrix: total: o: 0.032406469164167784  -> a: 4.3760345516408725E-4
org->adv	$w:20.851500283926615->19.380994124302685  	$d:9.788840271780549->9.105226055589556  	$l:69.35965944429282->71.51377982010777
	 improve value x$w(high is good):-1.4705061596239304  	x$d:-0.6836142161909926  	 x$l(negative is good):2.154120375814955
	 	 $w-$l: -48.508159160366205 -> -52.13278569580508  _ #Surrender#	 lift : -3.6246265354388796 : bad	 :| stand

[TimeMatrix: total:  o: 3.25045084E8 -> a: 2742337.0
org->adv	$w:31.607948883792382->31.0800605468985  	$d:3.512502899443943->3.4557386637747296  	$l:64.87954821676368->65.46420078932677
	 improve value x$w(high is good):-0.5278883368938807  	x$d:-0.05676423566921329  	 x$l(negative is good):0.5846525725630869
	 	 $w-$l: -33.271599332971306 -> -34.38414024242826  _ #Surrender#	 lift : -1.1125409094569605 : bad	 :| stand

[Prob_ROI diff: -0.036246265330870386 (up%-> -7.039224999838769) . o: 0.5149184083716687 -> a: 0.4786721430407983	 returnMoney: o:5.00600625690963 a: 0.06284057510591357 (probReturnRate: 0.012553035669737075	 totalSpendMoney: o: 9.721940749293019 a: 0.13128103654980716 (probTotalSpendRate: 0.013503583279846047

[Time_ROI diff: -0.011125409094569605 (up%-> -1.6672674578377544) . o: 0.667284006670287 -> a: 0.6561585975757174	 returnMoney: o:6.50692158E10 a: 5.398224E8 (timeReturnRate: 0.008296125800243623	 totalSpendMoney: o: 9.75135252E10 a: 8.227011E8 (timeTotalSpendRate: 0.008436789648539954

[[Per_Prob_ROI diff: 0.0024120646518614028 (up%-> 3541.8467345918093) . o: 6.81018923914388E-5 -> a: 0.0024801665442528414	 per returnMoney: o:6.62082562744297E-4 a: 3.2559883474566617E-4	 per totalSpendMoney: o: 0.0012858009190970796 a: 6.802126246103998E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=true]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 4.611247765608625

 按net净收益值(代表少输多赢) :  $Change$  Value: 4.647494030939495     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9296077500016122 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Two2, 	playerStartValue=6	@@@ 

net money diff:  0.9650280575676871 , up % -> 96.63252020673167 .  o: -0.9986576522097792 -> a: -0.03362959464209217 (anet/onet: 0.03367479793268324

[ProbMatrix: total: o: 0.032406469165955694  -> a: 4.376034551646902E-4
org->adv	$w:41.46308867784638->34.732539471800564  	$d:3.4268261124219186->4.91843026230367  	$l:55.11008520973171->60.34903026589576
	 improve value x$w(high is good):-6.730549206045815  	x$d:1.4916041498817516  	 x$l(negative is good):5.238945056164056
	 	 $w-$l: -13.64699653188533 -> -25.616490794095203  _ #Surrender#	 lift : -11.969494262209873 : bad	 :| stand

[TimeMatrix: total:  o: 3.0211948E7 -> a: 346957.0
org->adv	$w:58.587827570734596->46.568594955570866  	$d:4.205965136706842->3.233830128805587  	$l:37.20620729255856->50.197574915623555
	 improve value x$w(high is good):-12.01923261516373  	x$d:-0.9721350079012554  	 x$l(negative is good):12.991367623064995
	 	 $w-$l: 21.38162027817604 -> -3.6289799600526917  _ #Surrender#	 lift : -25.01060023822873 : bad	 :| stand

[Prob_ROI diff: -0.16753764220065082 (up%-> -18.38299917286468) . o: 0.9113727342595692 -> a: 0.7438350920589184	 returnMoney: o:10.269405780262815 a: 0.09765144190732869 (probReturnRate: 0.009508967120084876	 totalSpendMoney: o: 11.268063432472594 a: 0.13128103654942086 (probTotalSpendRate: 0.011650718629351322

[Time_ROI diff: -0.2817765181383478 (up%-> -22.623807540007203) . o: 1.245486718537821 -> a: 0.9637102003994731	 returnMoney: o:1.28442432E10 a: 1.003098E8 (timeReturnRate: 0.007809708866303621	 totalSpendMoney: o: 1.03126296E10 a: 1.040871E8 (timeTotalSpendRate: 0.010093167701863354

[[Per_Prob_ROI diff: 0.054774725467643254 (up%-> 2241.780100655498) . o: 0.0024433585368889253 -> a: 0.05721808400453218	 per returnMoney: o:0.027531918981937843 a: 0.007511649377486823	 per totalSpendMoney: o: 0.030209285341749582 a: 0.010098541273032374

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.7974904153670362

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.9650280575676871     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.8161700082713531 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Three3, 	playerStartValue=6	@@@ 

net money diff:  0.5521895877187599 , up % -> 94.68311184751389 .  o: -0.5831975491131463 -> a: -0.031007961394386274 (anet/onet: 0.05316888152486116

[ProbMatrix: total: o: 0.03240646916613674  -> a: 4.3760345516468573E-4
org->adv	$w:43.14075052027959->35.809870756302956  	$d:3.2104247754429194->4.76073032904737  	$l:53.6488247042775->59.42939891464968
	 improve value x$w(high is good):-7.3308797639766325  	x$d:1.550305553604451  	 x$l(negative is good):5.78057421037218
	 	 $w-$l: -10.508074183997905 -> -23.619528158346725  _ #Surrender#	 lift : -13.11145397434882 : bad	 :| stand

[TimeMatrix: total:  o: 1.3126732E7 -> a: 202189.0
org->adv	$w:60.63193794159887->46.55495600650876  	$d:4.267017868575362->3.2355865056951663  	$l:35.10104418982577->50.20945748779607
	 improve value x$w(high is good):-14.07698193509011  	x$d:-1.0314313628801957  	 x$l(negative is good):15.108413297970301
	 	 $w-$l: 25.5308937517731 -> -3.654501481287309  _ #Surrender#	 lift : -29.185395233060408 : bad	 :| stand

[Prob_ROI diff: -0.19068341341805894 (up%-> -19.977557295719546) . o: 0.9544881318343929 -> a: 0.7638047184163339	 returnMoney: o:12.2309885658366 a: 0.10027307515503564 (probReturnRate: 0.008198280508177136	 totalSpendMoney: o: 12.814186114949747 a: 0.13128103654942191 (probTotalSpendRate: 0.010244976572976579

[Time_ROI diff: -0.33411975478560174 (up%-> -25.74955757790291) . o: 1.2975747399727287 -> a: 0.9634549851871269	 returnMoney: o:6.9988332E9 a: 5.844E7 (timeReturnRate: 0.008349963248159708	 totalSpendMoney: o: 5.3937804E9 a: 6.06567E7 (timeTotalSpendRate: 0.01124567474048443

[[Per_Prob_ROI diff: 0.0553084035788607 (up%-> 1605.0935868527451) . o: 0.003445805530088061 -> a: 0.05875420910894876	 per returnMoney: o:0.044155193378471486 a: 0.00771331347346428	 per totalSpendMoney: o: 0.04626059969295938 a: 0.010098541273032455

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.36150617430070103

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.5521895877187599     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.8002244270428044 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Four4, 	playerStartValue=6	@@@ 

net money diff:  0.10273061277497944 , up % -> 78.96991586856335 .  o: -0.13008828950250262 -> a: -0.027357676727523178 (anet/onet: 0.21030084131436655

[ProbMatrix: total: o: 0.03240646916613806  -> a: 4.376034551646753E-4
org->adv	$w:45.18337333750138->39.58049180346544  	$d:2.857824380238582->0.0  	$l:51.95880228226004->60.41950819653456
	 improve value x$w(high is good):-5.602881534035937  	x$d:-2.857824380238582  	 x$l(negative is good):8.46070591427452
	 	 $w-$l: -6.775428944758666 -> -20.83901639306911  _ #Surrender#	 lift : -14.063587448310443 : bad	 :| stand

[TimeMatrix: total:  o: 5262340.0 -> a: 9073.0
org->adv	$w:67.45394634326173->57.91910062823763  	$d:4.615893309820346->0.0  	$l:27.93016034691791->42.08089937176237
	 improve value x$w(high is good):-9.534845715024105  	x$d:-4.615893309820346  	 x$l(negative is good):14.150739024844462
	 	 $w-$l: 39.52378599634383 -> 15.838201256475259  _ @double@	 lift : -23.68558473986857 : bad	 :| stand

[Prob_ROI diff: -0.19823826756089313 (up%-> -20.027140208065266) . o: 0.989848103630189 -> a: 0.7916098360692959	 returnMoney: o:12.684097825453426 a: 0.10392335982188142 (probReturnRate: 0.008193200750418085	 totalSpendMoney: o: 12.814186114955929 a: 0.1312810365494046 (probTotalSpendRate: 0.010244976572970285

[Time_ROI diff: -0.24257504773192418 (up%-> -17.31495237124218) . o: 1.4009570602966768 -> a: 1.1583820125647526	 returnMoney: o:3.4014324E9 a: 3153000.0 (timeReturnRate: 9.269624173627557E-4	 totalSpendMoney: o: 2.4279348E9 a: 2721900.0 (timeTotalSpendRate: 0.0011210762331838565

[[Per_Prob_ROI diff: 0.7864810894183623 (up%-> 15334.7619398434) . o: 0.005128746650933623 -> a: 0.7916098360692959	 per returnMoney: o:0.06572071412152035 a: 0.10392335982188142	 per totalSpendMoney: o: 0.0663947467096162 a: 0.1312810365494046

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.09550765478591369

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.10273061277497944     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.7997285979193471 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Five5, 	playerStartValue=6	@@@ 

net money diff:  0.3676150922378003 , up % -> 1715.9428077117398 .  o: -0.021423504943502508 -> a: 0.3461915872942978 (anet/onet: -16.159428077117397

[ProbMatrix: total: o: 4.376034551646753E-4  -> a: 0.03240646916614443
org->adv	$w:41.840594229525045->47.209654074013336  	$d:0.0->2.7509790160877547  	$l:58.15940577047495->50.03936690989891
	 improve value x$w(high is good):5.369059844488291  	x$d:2.7509790160877547  	 x$l(negative is good):-8.120038860576038
	 	 $w-$l: -16.318811540949902 -> -2.829712835885573  _ #Surrender#	 lift : 13.489098705064329 : good	 :) hit 

[TimeMatrix: total:  o: 5473.0 -> a: 3174340.0
org->adv	$w:57.90243011145624->67.44205094602343  	$d:0.0->4.617652803417403  	$l:42.09756988854376->27.94029625055917
	 improve value x$w(high is good):9.539620834567188  	x$d:4.617652803417403  	 x$l(negative is good):-14.157273637984588
	 	 $w-$l: 15.804860222912476 -> 39.50175469546425  _ @double@	 lift : 23.696894472551776 : good	 :) hit 

[Prob_ROI diff: 0.19020439129222244 (up%-> 22.729647462559655) . o: 0.836811884590501 -> a: 1.0270162758827235	 returnMoney: o:0.10985753160589978 a: 13.160377702253276 (probReturnRate: 119.79495178777995	 totalSpendMoney: o: 0.1312810365494023 a: 12.814186114958979 (probTotalSpendRate: 97.60881275596023

[Time_ROI diff: 0.24269077960374585 (up%-> 20.956873410717908) . o: 1.1580486022291248 -> a: 1.4007393818328706	 returnMoney: o:1901400.0 a: 2.0514876E9 (timeReturnRate: 1078.9353108236037	 totalSpendMoney: o: 1641900.0 a: 1.4645748E9 (timeTotalSpendRate: 892.0

[[Per_Prob_ROI diff: -0.8314905567361864 (up%-> -99.36409509086758) . o: 0.836811884590501 -> a: 0.005321327854314629	 per returnMoney: o:0.10985753160589978 a: 0.06818848550390298	 per totalSpendMoney: o: 0.1312810365494023 a: 0.06639474670963201

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.5578194835300228

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.3676150922378003     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.2272964746255965 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Six6, 	playerStartValue=6	@@@ 

net money diff:  0.6326228286436631 , up % -> 3122.6957932012797 .  o: -0.02025886831567157 -> a: 0.6123639603279916 (anet/onet: -30.226957932012798

[ProbMatrix: total: o: 4.3760345516467446E-4  -> a: 0.032406469166143245
org->adv	$w:42.28416043620764->48.1126742585459  	$d:0.0->2.742348893764375  	$l:57.71583956379235->49.14497684768971
	 improve value x$w(high is good):5.828513822338259  	x$d:2.742348893764375  	 x$l(negative is good):-8.570862716102639
	 	 $w-$l: -15.431679127584708 -> -1.0323025891438076  _ #Surrender#	 lift : 14.399376538440901 : good	 :) hit 

[TimeMatrix: total:  o: 3109.0 -> a: 1803220.0
org->adv	$w:57.896429720167255->67.42804538547709  	$d:0.0->4.618737591641619  	$l:42.103570279832745->27.953217022881287
	 improve value x$w(high is good):9.531615665309836  	x$d:4.618737591641619  	 x$l(negative is good):-14.150353256951458
	 	 $w-$l: 15.792859440334512 -> 39.4748283625958  _ @double@	 lift : 23.681968922261287 : good	 :) hit 

[Prob_ROI diff: 0.20210476273449263 (up%-> 23.8984008018086) . o: 0.8456832087241487 -> a: 1.0477879714586413	 returnMoney: o:0.11102216823373108 a: 13.426550075299817 (probReturnRate: 120.93575804638738	 totalSpendMoney: o: 0.13128103654940265 a: 12.814186114971825 (probTotalSpendRate: 97.60881275605782

[Time_ROI diff: 0.24253757714836288 (up%-> 20.945814648729453) . o: 1.157928594403345 -> a: 1.400466171551708	 returnMoney: o:1080000.0 a: 1.1651436E9 (timeReturnRate: 1078.8366666666666	 totalSpendMoney: o: 932700.0 a: 8.319684E8 (timeTotalSpendRate: 892.0

[[Per_Prob_ROI diff: -0.8402542555041558 (up%-> -99.3580393740839) . o: 0.8456832087241487 -> a: 0.00542895321999296	 per returnMoney: o:0.11102216823373108 a: 0.06956761697046537	 per totalSpendMoney: o: 0.13128103654940265 a: 0.06639474670969858

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.8347275913781558

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.6326228286436631     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.2389840080180858 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Seven7, 	playerStartValue=6	@@@ 

net money diff:  1.174129560996344 , up % -> 97.61434293508674 .  o: -1.2028248366914038 -> a: -0.028695275695059752 (anet/onet: 0.023856570649132512

[ProbMatrix: total: o: 0.032406469166021  -> a: 4.3760345516456127E-4
org->adv	$w:38.05807094492415->35.27443713665629  	$d:8.007155215748009->7.593227244740924  	$l:53.934773839327846->57.132335618602795
	 improve value x$w(high is good):-2.783633808267858  	x$d:-0.41392797100708467  	 x$l(negative is good):3.197561779274949
	 	 $w-$l: -15.8767028944037 -> -21.857898481946503  _ #Surrender#	 lift : -5.981195587542803 : bad	 :| stand

[TimeMatrix: total:  o: 3.0943468E7 -> a: 370753.0
org->adv	$w:31.778532386867557->30.933802288855382  	$d:3.5677125783057027->3.49990424892044  	$l:64.65375503482673->65.56629346222418
	 improve value x$w(high is good):-0.8447300980121746  	x$d:-0.06780832938526249  	 x$l(negative is good):0.9125384273974504
	 	 $w-$l: -32.87522264795918 -> -34.6324911733688  _ #Surrender#	 lift : -1.757268525409622 : bad	 :| stand

[Prob_ROI diff: -0.11183261762628116 (up%-> -12.519693569552803) . o: 0.8932536328065718 -> a: 0.7814210151802906	 returnMoney: o:10.065238595498682 a: 0.10258576085439852 (probReturnRate: 0.01019208435856417	 totalSpendMoney: o: 11.268063432190086 a: 0.13128103654945827 (probTotalSpendRate: 0.011650718629646745

[Time_ROI diff: -0.02526548186324984 (up%-> -3.7213097839223894) . o: 0.6789405701295619 -> a: 0.653675088266312	 returnMoney: o:6.3636714E9 a: 7.27056E7 (timeReturnRate: 0.011425102810933953	 totalSpendMoney: o: 9.3729432E9 a: 1.112259E8 (timeTotalSpendRate: 0.011866699458927692

[[Per_Prob_ROI diff: 0.0038804339775261134 (up%-> 2304.5752622462305) . o: 1.6837957263083348E-4 -> a: 0.004048813550156947	 per returnMoney: o:0.0018973117050892897 a: 5.31532439660096E-4	 per totalSpendMoney: o: 0.0021240458873119862 a: 6.802126246085921E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.0622969433700629

 按net净收益值(代表少输多赢) :  $Change$  Value: 1.174129560996344     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.8748030643044719 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Eight8, 	playerStartValue=6	@@@ 

net money diff:  1.8851327823701332 , up % -> 98.11236490684378 .  o: -1.9214018377398592 -> a: -0.036269055369725994 (anet/onet: 0.018876350931562137

[ProbMatrix: total: o: 0.032406469166080726  -> a: 4.376034551645588E-4
org->adv	$w:34.69386574754567->32.36933386467455  	$d:8.2129244599787->7.634299210133626  	$l:57.09320979247564->59.99636692519182
	 improve value x$w(high is good):-2.3245318828711206  	x$d:-0.5786252498450741  	 x$l(negative is good):2.9031571327161814
	 	 $w-$l: -22.39934404492997 -> -27.627033060517274  _ #Surrender#	 lift : -5.2276890155873055 : bad	 :| stand

[TimeMatrix: total:  o: 1.8572524E7 -> a: 222529.0
org->adv	$w:31.769069190595744->30.924508715717952  	$d:3.569390999306287->3.5015660880154944  	$l:64.66153981009796->65.57392519626656
	 improve value x$w(high is good):-0.8445604748777917  	x$d:-0.06782491129079249  	 x$l(negative is good):0.9123853861685944
	 	 $w-$l: -32.89247061950222 -> -34.64941648054861  _ #Surrender#	 lift : -1.7569458610463828 : bad	 :| stand

[Prob_ROI diff: -0.10575284556566644 (up%-> -12.749255548891554) . o: 0.8294825149603405 -> a: 0.7237296693946741	 returnMoney: o:9.346661594540844 a: 0.09501198117972243 (probReturnRate: 0.010165338738188253	 totalSpendMoney: o: 11.268063432280703 a: 0.13128103654944842 (probTotalSpendRate: 0.011650718629552175

[Time_ROI diff: -0.025261438868442898 (up%-> -3.7216642336383257) . o: 0.6787672740629569 -> a: 0.653505835194514	 returnMoney: o:3.818553E9 a: 4.36272E7 (timeReturnRate: 0.011425060749451429	 totalSpendMoney: o: 5.6257176E9 a: 6.67587E7 (timeTotalSpendRate: 0.011866699458927692

[[Per_Prob_ROI diff: 0.003593536033316307 (up%-> 2298.2652814151834) . o: 1.5635862675972487E-4 -> a: 0.0037498946600760317	 per returnMoney: o:0.001761858924512883 a: 4.92290057926023E-4	 per totalSpendMoney: o: 0.0021240458873290676 a: 6.80212624608541E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.7793799368044667

 按net净收益值(代表少输多赢) :  $Change$  Value: 1.8851327823701332     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.8725074445110845 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Nine9, 	playerStartValue=6	@@@ 

net money diff:  2.694032188000553 , up % -> 98.35595331639351 .  o: -2.739063673486376 -> a: -0.045031485485823086 (anet/onet: 0.016440466836064982

[ProbMatrix: total: o: 0.03240646916610376  -> a: 4.3760345516458024E-4
org->adv	$w:30.93642760046012->28.882581742438507  	$d:8.35414761621218->7.933244549202055  	$l:60.709424783327705->63.18417370835944
	 improve value x$w(high is good):-2.0538458580216137  	x$d:-0.4209030670101246  	 x$l(negative is good):2.474748925031733
	 	 $w-$l: -29.772997182867584 -> -34.30159196592093  _ #Surrender#	 lift : -4.528594783053347 : bad	 :| stand

[TimeMatrix: total:  o: 1.4158828E7 -> a: 148417.0
org->adv	$w:31.69832983351447->30.89673015894406  	$d:3.570705145934395->3.5036417661049613  	$l:64.73096502055114->65.59962807495097
	 improve value x$w(high is good):-0.8015996745704115  	x$d:-0.06706337982943378  	 x$l(negative is good):0.8686630543998319
	 	 $w-$l: -33.03263518703666 -> -34.70289791600692  _ #Surrender#	 lift : -1.6702627289702565 : bad	 :| stand

[Prob_ROI diff: -0.09993389496717187 (up%-> -13.202737710981047) . o: 0.7569179753079117 -> a: 0.6569840803407399	 returnMoney: o:8.52899975883012 a: 0.08624955106360521 (probReturnRate: 0.010112504807414326	 totalSpendMoney: o: 11.268063432316495 a: 0.1312810365494283 (probTotalSpendRate: 0.011650718629513383

[Time_ROI diff: -0.023445443522040477 (up%-> -3.4661254947653224) . o: 0.6764164643619712 -> a: 0.6529710208399307	 returnMoney: o:2.897523E9 a: 2.90736E7 (timeReturnRate: 0.010033949687370902	 totalSpendMoney: o: 4.2836376E9 a: 4.45251E7 (timeTotalSpendRate: 0.010394226626454114

[[Per_Prob_ROI diff: 0.003279426008327769 (up%-> 2631.1905382446225) . o: 1.246365841112978E-4 -> a: 0.003404062592439067	 per returnMoney: o:0.001404412935753354 a: 4.468888656145348E-4	 per totalSpendMoney: o: 0.0018554360995087264 a: 6.802126246084368E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 2.594098293033381

 按net净收益值(代表少输多赢) :  $Change$  Value: 2.694032188000553     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.8679726228901896 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Ten, 	playerStartValue=6	@@@ 

net money diff:  3.6249446988442258 , up % -> 98.49178211449278 .  o: -3.680453963794027 -> a: -0.05550926494980096 (anet/onet: 0.015082178855072207

[ProbMatrix: total: o: 0.032406469166121846  -> a: 4.3760345516461754E-4
org->adv	$w:26.668506391214763->24.806181023828593  	$d:8.805793283336003->8.10486322051373  	$l:64.52570032544924->67.0889557556577
	 improve value x$w(high is good):-1.8623253673861697  	x$d:-0.7009300628222732  	 x$l(negative is good):2.563255430208457
	 	 $w-$l: -37.857193934234466 -> -42.28277473182909  _ #Surrender#	 lift : -4.425580797594625 : bad	 :| stand

[TimeMatrix: total:  o: 8807260.0 -> a: 74305.0
org->adv	$w:31.381269543535673->30.856604535361008  	$d:3.567579474206507->3.5098580176300382  	$l:65.05115098225782->65.63353744700895
	 improve value x$w(high is good):-0.5246650081746651  	x$d:-0.057721456576468544  	 x$l(negative is good):0.5823864647511243
	 	 $w-$l: -33.66988143872215 -> -34.77693291164794  _ #Surrender#	 lift : -1.1070514729257908 : bad	 :| stand

[Prob_ROI diff: -0.04425580797891593 (up%-> -7.121630125918389) . o: 0.6214280606606033 -> a: 0.5771722526816874	 returnMoney: o:6.041486786004737 a: 0.07577177159961107 (probReturnRate: 0.012541908024219861	 totalSpendMoney: o: 9.721940749798764 a: 0.13128103654941203 (probTotalSpendRate: 0.013503583279102935

[Time_ROI diff: -0.011070514729257908 (up%-> -1.669002704861837) . o: 0.6633011856127785 -> a: 0.6522306708835206	 returnMoney: o:1.7525598E9 a: 1.45392E7 (timeReturnRate: 0.008295979401102318	 totalSpendMoney: o: 2.642178E9 a: 2.22915E7 (timeTotalSpendRate: 0.008436789648539954

[[Per_Prob_ROI diff: 0.0029083411992264245 (up%-> 3538.6184177094883) . o: 8.218860741444296E-5 -> a: 0.0029905298066408674	 per returnMoney: o:7.990327715916858E-4 a: 3.9259985284772575E-4	 per totalSpendMoney: o: 0.0012858009191639682 a: 6.802126246083525E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 3.58068889086531

 按net净收益值(代表少输多赢) :  $Change$  Value: 3.6249446988442258     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9287836987408161 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 */
	}
	
	public static void test77vsAll() {
		StrategyMatrix8012 o = new Myth2019April22();
		StrategyMatrix8012 t = new MirMyth2019April22();
		
		System.out.println(t.diffWith(o));
		
		for(Card playerCard : Card.values()) {
			if(playerCard.getValue() == 7) {
				for(Card dealerCard : Card.values()) {
					if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
					PlayerCardsPathValue nine = new PlayerCardsPathValue(playerCard,playerCard);
					Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, nine, dealerCard); 
//					HelloWorld.print(origin);
					PlayerCardsPathValue ninet = new PlayerCardsPathValue(playerCard,playerCard);
					Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, ninet, dealerCard); 
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
MatrixKey [startValue=Seven, dealerCard=One1, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Seven, dealerCard=One1, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Seven, dealerCard=Two2, situation=Start_With_Pair] : Split -> Stand
MatrixKey [startValue=Seven, dealerCard=Two2, situation=Splited_Pair_And_Can_Split] : Split -> Stand
MatrixKey [startValue=Seven, dealerCard=Three3, situation=Splited_Pair_And_Can_Split] : Split -> Stand
MatrixKey [startValue=Seven, dealerCard=Three3, situation=Start_With_Pair] : Split -> Stand
MatrixKey [startValue=Seven, dealerCard=Four4, situation=Start_With_Pair] : Stand -> Split
MatrixKey [startValue=Seven, dealerCard=Four4, situation=Splited_Pair_And_Can_Split] : Stand -> Split
MatrixKey [startValue=Seven, dealerCard=Five5, situation=Start_With_Pair] : Stand -> Split
MatrixKey [startValue=Seven, dealerCard=Five5, situation=Splited_Pair_And_Can_Split] : Stand -> Split
MatrixKey [startValue=Seven, dealerCard=Six6, situation=Start_With_Pair] : Stand -> Split
MatrixKey [startValue=Seven, dealerCard=Six6, situation=Splited_Pair_And_Can_Split] : Stand -> Split
MatrixKey [startValue=Seven, dealerCard=Seven7, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Seven, dealerCard=Seven7, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Seven, dealerCard=Eight8, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Seven, dealerCard=Eight8, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Seven, dealerCard=Nine9, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Seven, dealerCard=Nine9, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Seven, dealerCard=Ten, situation=Start_With_Pair] : Split -> Giveup
MatrixKey [startValue=Seven, dealerCard=Ten, situation=Splited_Pair_And_Can_Split] : Split -> Hit


		 @@@   dealerCard=One1, 	playerStartValue=7	@@@ 

net money diff:  4.734652950660059 , up % -> 98.38272395123714 .  o: -4.812484103415112 -> a: -0.07783115275505256 (anet/onet: 0.016172760487628578

[ProbMatrix: total: o: 0.03240646916498267  -> a: 4.3760345516402377E-4
org->adv	$w:19.537560352075054->16.500048265467406  	$d:11.423609669595674->7.713996836506933  	$l:69.03882997832928->75.78595489802566
	 improve value x$w(high is good):-3.0375120866076486  	x$d:-3.709612833088741  	 x$l(negative is good):6.74712491969639
	 	 $w-$l: -49.50126962625422 -> -59.28590663255826  _ #Surrender#	 lift : -9.784637006304042 : bad	 :| stand

[TimeMatrix: total:  o: 1.95117988E8 -> a: 696241.0
org->adv	$w:31.666019434353743->30.604345334445977  	$d:3.5200936983831546->3.4028447046353203  	$l:64.81388686726311->65.9928099609187
	 improve value x$w(high is good):-1.0616740999077656  	x$d:-0.11724899374783426  	 x$l(negative is good):1.178923093655598
	 	 $w-$l: -33.147867432909365 -> -35.38846462647273  _ #Surrender#	 lift : -2.240597193563371 : bad	 :| stand

[Prob_ROI diff: -0.09784637005153685 (up%-> -19.376005956922658) . o: 0.5049873037254011 -> a: 0.4071409336738643	 returnMoney: o:4.909456646050994 a: 0.05344988379442837 (probReturnRate: 0.01088712817892418	 totalSpendMoney: o: 9.721940749466105 a: 0.13128103654948092 (probTotalSpendRate: 0.013503583279572077

[Time_ROI diff: -0.02240597193563365 (up%-> -3.3515717562409457) . o: 0.6685213256709064 -> a: 0.6461153537352727	 returnMoney: o:3.91321608E10 a: 1.349556E8 (timeReturnRate: 0.003448713212892655	 totalSpendMoney: o: 5.85353964E10 a: 2.088723E8 (timeTotalSpendRate: 0.003568307602679872

[[Per_Prob_ROI diff: 0.008198280097024687 (up%-> 7404.612996540322) . o: 1.1071854938070623E-4 -> a: 0.008308998646405394	 per returnMoney: o:0.001076399176946063 a: 0.001090813954988334	 per totalSpendMoney: o: 0.0021315371079732746 a: 0.002679204827540427

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=true]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 4.636806580608522

 按net净收益值(代表少输多赢) :  $Change$  Value: 4.734652950660059     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.8062399404307735 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Two2, 	playerStartValue=7	@@@ 

net money diff:  0.6433306991955103 , up % -> 94.35836771712034 .  o: -0.6817950699657818 -> a: -0.03846437077027147 (anet/onet: 0.05641632282879654

[ProbMatrix: total: o: 0.03240646916610549  -> a: 4.376034551646746E-4
org->adv	$w:40.931955289985474->35.35037055569538  	$d:7.776712556526388->0.0  	$l:51.29133215348814->64.64962944430462
	 improve value x$w(high is good):-5.581584734290097  	x$d:-7.776712556526388  	 x$l(negative is good):13.35829729081648
	 	 $w-$l: -10.359376863502673 -> -29.29925888860925  _ #Surrender#	 lift : -18.939882025106574 : bad	 :| stand

[TimeMatrix: total:  o: 1.547962E7 -> a: 26689.0
org->adv	$w:59.950179655572946->57.960208325527375  	$d:4.437860877721804->0.0  	$l:35.61195946670526->42.03979167447263
	 improve value x$w(high is good):-1.9899713300455701  	x$d:-4.437860877721804  	 x$l(negative is good):6.4278322077673735
	 	 $w-$l: 24.338220188867687 -> 15.920416651054742  _ @double@	 lift : -8.417803537812945 : bad	 :| stand

[Prob_ROI diff: -0.2324857347973911 (up%-> -24.745868110820467) . o: 0.9394931459112302 -> a: 0.7070074111138391	 returnMoney: o:10.586268362410308 a: 0.09281666577914237 (probReturnRate: 0.008767647163443875	 totalSpendMoney: o: 11.26806343237609 a: 0.13128103654941384 (probTotalSpendRate: 0.01165071862945048

[Time_ROI diff: -0.13333473161879095 (up%-> -10.315722939693591) . o: 1.2925388981293384 -> a: 1.1592041665105475	 returnMoney: o:7.6168428E9 a: 9281400.0 (timeReturnRate: 0.0012185363731019893	 totalSpendMoney: o: 5.8929312E9 a: 8006700.0 (timeTotalSpendRate: 0.001358695652173913

[[Per_Prob_ROI diff: 0.702139570979584 (up%-> 14424.047454611647) . o: 0.004867840134255079 -> a: 0.7070074111138391	 per returnMoney: o:0.054851131411452377 a: 0.09281666577914237	 per totalSpendMoney: o: 0.05838374835428026 a: 0.13128103654941384

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.4108449643981192

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.6433306991955103     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.7525413188917953 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Three3, 	playerStartValue=7	@@@ 

net money diff:  0.2707028123455297 , up % -> 89.12476519551169 .  o: -0.3037346709993489 -> a: -0.03303185865381923 (anet/onet: 0.10875234804488303

[ProbMatrix: total: o: 0.03240646916616487  -> a: 4.3760345516467516E-4
org->adv	$w:42.60052166147779->37.41940971749468  	$d:7.427758584715898->0.0  	$l:49.97171975380632->62.58059028250532
	 improve value x$w(high is good):-5.181111943983112  	x$d:-7.427758584715898  	 x$l(negative is good):12.608870528699
	 	 $w-$l: -7.371198092328529 -> -25.16118056501064  _ #Surrender#	 lift : -17.78998247268211 : bad	 :| stand

[TimeMatrix: total:  o: 5661292.0 -> a: 15553.0
org->adv	$w:62.955240605854634->57.937375425962834  	$d:4.5750687298941655->0.0  	$l:32.469690664251196->42.06262457403716
	 improve value x$w(high is good):-5.0178651798918  	x$d:-4.5750687298941655  	 x$l(negative is good):9.592933909785962
	 	 $w-$l: 30.485549941603434 -> 15.874750851925674  _ @double@	 lift : -14.610799089677762 : bad	 :| stand

[Prob_ROI diff: -0.22638702999933025 (up%-> -23.224536728503608) . o: 0.9747752243491864 -> a: 0.7483881943498562	 returnMoney: o:11.737390102673405 a: 0.09824917789558939 (probReturnRate: 0.008370615361349483	 totalSpendMoney: o: 12.041124773672754 a: 0.13128103654940862 (probTotalSpendRate: 0.01090272204773156

[Time_ROI diff: -0.1974717155515493 (up%-> -14.560456897139485) . o: 1.356219224070806 -> a: 1.1587475085192567	 returnMoney: o:3.784134E9 a: 5406600.0 (timeReturnRate: 0.0014287549013856276	 totalSpendMoney: o: 2.7902082E9 a: 4665900.0 (timeTotalSpendRate: 0.0016722408026755853

[[Per_Prob_ROI diff: 0.7403322007601935 (up%-> 9189.831055851064) . o: 0.008055993589662698 -> a: 0.7483881943498562	 per returnMoney: o:0.09700322398903641 a: 0.09824917789558939	 per totalSpendMoney: o: 0.09951342788159301 a: 0.13128103654940862

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.04431578234619943

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.2707028123455297     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.7677546327149639 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Four4, 	playerStartValue=7	@@@ 

net money diff:  0.19229379301231028 , up % -> 702.8878765090941 .  o: -0.027357676727523178 -> a: 0.1649361162847871 (anet/onet: -6.028878765090941

[ProbMatrix: total: o: 4.376034551646753E-4  -> a: 0.03240646916615922
org->adv	$w:39.58049180346544->44.69057746390758  	$d:0.0->6.438008735656635  	$l:60.41950819653456->48.87141380043577
	 improve value x$w(high is good):5.110085660442138  	x$d:6.438008735656635  	 x$l(negative is good):-11.54809439609879
	 	 $w-$l: -20.83901639306911 -> -4.180836336528188  _ #Surrender#	 lift : 16.65818005654092 : good	 :) hit 

[TimeMatrix: total:  o: 9073.0 -> a: 3302572.0
org->adv	$w:57.91910062823763->67.03345150385822  	$d:0.0->4.852944916870851  	$l:42.08089937176237->28.113603579270947
	 improve value x$w(high is good):9.114350875620588  	x$d:4.852944916870851  	 x$l(negative is good):-13.967295792491424
	 	 $w-$l: 15.838201256475259 -> 38.919847924587266  _ @double@	 lift : 23.081646668112004 : good	 :) hit 

[Prob_ROI diff: 0.2212615328030606 (up%-> 27.950831675074312) . o: 0.7916098360692959 -> a: 1.0128713688723565	 returnMoney: o:0.10392335982188142 a: 12.979122231253186 (probReturnRate: 124.89128770950674	 totalSpendMoney: o: 0.1312810365494046 a: 12.814186114968399 (probTotalSpendRate: 97.60881275603026

[Time_ROI diff: 0.24560549963902267 (up%-> 21.20246144838109) . o: 1.1583820125647526 -> a: 1.4039875122037753	 returnMoney: o:3153000.0 a: 2.5833432E9 (timeReturnRate: 819.3286393910562	 totalSpendMoney: o: 2721900.0 a: 1.8400044E9 (timeTotalSpendRate: 676.0

[[Per_Prob_ROI diff: -0.7832389983100202 (up%-> -98.94255511012335) . o: 0.7916098360692959 -> a: 0.008370837759275674	 per returnMoney: o:0.10392335982188142 a: 0.10726547298556352	 per totalSpendMoney: o: 0.1312810365494046 a: 0.1059023645865157

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.4135553258153709

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.19229379301231028     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.279508316750743 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Five5, 	playerStartValue=7	@@@ 

net money diff:  0.641003155447601 , up % -> 2992.0554882967904 .  o: -0.021423504943502508 -> a: 0.6195796505040985 (anet/onet: -28.920554882967902

[ProbMatrix: total: o: 4.376034551646753E-4  -> a: 0.03240646916615718
org->adv	$w:41.840594229525045->46.738845222048596  	$d:0.0->6.082387232229701  	$l:58.15940577047495->47.1787675457217
	 improve value x$w(high is good):4.8982509925235505  	x$d:6.082387232229701  	 x$l(negative is good):-10.98063822475325
	 	 $w-$l: -16.318811540949902 -> -0.4399223236730976  _ #Surrender#	 lift : 15.878889217276804 : good	 :) hit 

[TimeMatrix: total:  o: 5473.0 -> a: 1992172.0
org->adv	$w:57.90243011145624->67.0215222380397  	$d:0.0->4.8550024797055675  	$l:42.09756988854376->28.123475282254745
	 improve value x$w(high is good):9.119092126583453  	x$d:4.8550024797055675  	 x$l(negative is good):-13.974094606289015
	 	 $w-$l: 15.804860222912476 -> 38.89804695578494  _ @double@	 lift : 23.093186732872468 : good	 :) hit 

[Prob_ROI diff: 0.21153918858302356 (up%-> 25.279180718918866) . o: 0.836811884590501 -> a: 1.0483510731735246	 returnMoney: o:0.10985753160589978 a: 13.433765765474508 (probReturnRate: 122.28352093023963	 totalSpendMoney: o: 0.1312810365494023 a: 12.81418611497041 (probTotalSpendRate: 97.6088127560473

[Time_ROI diff: 0.24572484396234562 (up%-> 21.218871426410818) . o: 1.1580486022291248 -> a: 1.4037734461914704	 returnMoney: o:1901400.0 a: 1.5580824E9 (timeReturnRate: 819.439570842537	 totalSpendMoney: o: 1641900.0 a: 1.1099244E9 (timeTotalSpendRate: 676.0

[[Per_Prob_ROI diff: -0.8281478261345215 (up%-> -98.96463487009159) . o: 0.836811884590501 -> a: 0.008664058455979543	 per returnMoney: o:0.10985753160589978 a: 0.11102285756590502	 per totalSpendMoney: o: 0.1312810365494023 a: 0.10590236458653231

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.8525423440306246

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.641003155447601     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.2527918071891888 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Six6, 	playerStartValue=7	@@@ 

net money diff:  1.026302740715582 , up % -> 5065.9430957536215 .  o: -0.02025886831567157 -> a: 1.0060438723999106 (anet/onet: -49.65943095753622

[ProbMatrix: total: o: 4.3760345516467446E-4  -> a: 0.03240646916615007
org->adv	$w:42.28416043620764->47.58292495023585  	$d:0.0->7.381872132302793  	$l:57.71583956379235->45.03520291746136
	 improve value x$w(high is good):5.298764514028207  	x$d:7.381872132302793  	 x$l(negative is good):-12.680636646330989
	 	 $w-$l: -15.431679127584708 -> 2.5477220327744856  _ #Surrender#	 lift : 17.979401160359192 : good	 :) hit 

[TimeMatrix: total:  o: 3109.0 -> a: 1131676.0
org->adv	$w:57.896429720167255->67.00716459481335  	$d:0.0->4.8549231405455275  	$l:42.103570279832745->28.13791226464112
	 improve value x$w(high is good):9.110734874646091  	x$d:4.8549231405455275  	 x$l(negative is good):-13.965658015191625
	 	 $w-$l: 15.792859440334512 -> 38.86925233017223  _ @double@	 lift : 23.07639288983772 : good	 :) hit 

[Prob_ROI diff: 0.23282695675752885 (up%-> 27.53122615604327) . o: 0.8456832087241487 -> a: 1.0785101654816776	 returnMoney: o:0.11102216823373108 a: 13.820229987377571 (probReturnRate: 124.48171574421357	 totalSpendMoney: o: 0.13128103654940265 a: 12.81418611497766 (probTotalSpendRate: 97.60881275610225

[Time_ROI diff: 0.24555737208828732 (up%-> 21.206607495069036) . o: 1.157928594403345 -> a: 1.4034859664916324	 returnMoney: o:1080000.0 a: 8.849052E8 (timeReturnRate: 819.3566666666667	 totalSpendMoney: o: 932700.0 a: 6.305052E8 (timeTotalSpendRate: 676.0

[[Per_Prob_ROI diff: -0.8367699015714075 (up%-> -98.94602292433021) . o: 0.8456832087241487 -> a: 0.008913307152741136	 per returnMoney: o:0.11102216823373108 a: 0.11421677675518654	 per totalSpendMoney: o: 0.13128103654940265 a: 0.10590236458659223

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.259129697473111

 按net净收益值(代表少输多赢) :  $Change$  Value: 1.026302740715582     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.2753122615604326 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Seven7, 	playerStartValue=7	@@@ 

net money diff:  0.3073870655007246 , up % -> 87.68863480163138 .  o: -0.3505437919019876 -> a: -0.043156726401263015 (anet/onet: 0.12311365198368619

[ProbMatrix: total: o: 0.032406469166093646  -> a: 4.376034551646032E-4
org->adv	$w:37.859894746311184->30.272055921124092  	$d:17.230171455268202->6.582346376251541  	$l:44.90993379842062->63.145597702624364
	 improve value x$w(high is good):-7.587838825187092  	x$d:-10.64782507901666  	 x$l(negative is good):18.235663904203747
	 	 $w-$l: -7.0500390521094305 -> -32.87354178150028  _ #Surrender#	 lift : -25.823502729390846 : bad	 :| stand

[TimeMatrix: total:  o: 1.3377844E7 -> a: 94129.0
org->adv	$w:32.31106596847743->30.460325723209635  	$d:3.5965287082133717->3.4463342859267603  	$l:64.0924053233092->66.0933399908636
	 improve value x$w(high is good):-1.8507402452677937  	x$d:-0.1501944222866114  	 x$l(negative is good):2.0009346675544037
	 	 $w-$l: -31.78133935483177 -> -35.63301426765396  _ #Surrender#	 lift : -3.8516749128221948 : bad	 :| stand

[Prob_ROI diff: -0.2976259202507726 (up%-> -30.71822042868195) . o: 0.9688905024357333 -> a: 0.6712645821849607	 returnMoney: o:10.917519640425246 a: 0.08812431014815085 (probReturnRate: 0.00807182519936537	 totalSpendMoney: o: 11.268063432327233 a: 0.13128103654941387 (probTotalSpendRate: 0.011650718629500999

[Time_ROI diff: -0.05584949998692923 (up%-> -7.983982059005092) . o: 0.6995193573103896 -> a: 0.6436698573234604	 returnMoney: o:2.870307E9 a: 1.81764E7 (timeReturnRate: 0.00633256303245611	 totalSpendMoney: o: 4.103256E9 a: 2.82387E7 (timeTotalSpendRate: 0.006882022471910112

[[Per_Prob_ROI diff: 0.013278934236283 (up%-> 3159.071467589553) . o: 4.2034295116517715E-4 -> a: 0.013699277187448176	 per returnMoney: o:0.004736451037060844 a: 0.0017984553091459356	 per totalSpendMoney: o: 0.004888530773243919 a: 0.0026792048275390587

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.009761145249951975

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.3073870655007246     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.6928177957131805 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Eight8, 	playerStartValue=7	@@@ 

net money diff:  1.790457637424328 , up % -> 97.28862544005707 .  o: -1.840356598035699 -> a: -0.049898960611371085 (anet/onet: 0.027113745599429286

[ProbMatrix: total: o: 0.03240646916612569  -> a: 4.3760345516462014E-4
org->adv	$w:33.47508303470552->27.62312654974194  	$d:11.52648686145379->6.744479208164285  	$l:54.99843010384069->65.63239424209377
	 improve value x$w(high is good):-5.85195648496358  	x$d:-4.782007653289505  	 x$l(negative is good):10.633964138253077
	 	 $w-$l: -21.52334706913517 -> -38.009267692351834  _ #Surrender#	 lift : -16.485920623216664 : bad	 :| stand

[TimeMatrix: total:  o: 8029492.0 -> a: 56497.0
org->adv	$w:32.301719710288026->30.451174398640635  	$d:3.5975874937044585->3.4479706887091353  	$l:64.10069279600752->66.10085491265023
	 improve value x$w(high is good):-1.850545311647391  	x$d:-0.14961680499532326  	 x$l(negative is good):2.000162116642713
	 	 $w-$l: -31.798973085719496 -> -35.649680514009596  _ #Surrender#	 lift : -3.850707428290101 : bad	 :| stand

[Prob_ROI diff: -0.2167676646814477 (up%-> -25.908228147508858) . o: 0.8366749877578582 -> a: 0.6199073230764105	 returnMoney: o:9.427706834325965 a: 0.0813820759380448 (probReturnRate: 0.008632223866119318	 totalSpendMoney: o: 11.268063432361664 a: 0.1312810365494159 (probTotalSpendRate: 0.011650718629465578

[Time_ROI diff: -0.055838044895691996 (up%-> -7.984377542958304) . o: 0.699341239755596 -> a: 0.643503194859904	 returnMoney: o:1.7223432E9 a: 1.09068E7 (timeReturnRate: 0.006332535815161577	 totalSpendMoney: o: 2.462808E9 a: 1.69491E7 (timeTotalSpendRate: 0.006882022471910112

[[Per_Prob_ROI diff: 0.012288187217592556 (up%-> 3385.337431020247) . o: 3.6298264110969986E-4 -> a: 0.012651169858702255	 per returnMoney: o:0.004090111424870267 a: 0.0016608586926131594	 per totalSpendMoney: o: 0.0048885307732588566 a: 0.0026792048275391

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.5736899727428804

 按net净收益值(代表少输多赢) :  $Change$  Value: 1.790457637424328     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.7409177185249114 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Nine9, 	playerStartValue=7	@@@ 

net money diff:  2.5823658028815237 , up % -> 97.81502160845122 .  o: -2.640050332165348 -> a: -0.05768452928382434 (anet/onet: 0.021849783915487683

[ProbMatrix: total: o: 0.03240646916611195  -> a: 4.376034551646366E-4
org->adv	$w:30.70770980233925->24.58711607554087  	$d:9.854581354978729->6.8860406803955945  	$l:59.437708842682035->68.52684324406354
	 improve value x$w(high is good):-6.120593726798379  	x$d:-2.968540674583134  	 x$l(negative is good):9.089134401381507
	 	 $w-$l: -28.729999040342786 -> -43.939727168522666  _ #Surrender#	 lift : -15.209728128179883 : bad	 :| stand

[TimeMatrix: total:  o: 7127092.0 -> a: 37681.0
org->adv	$w:32.05632816301515->30.423821023858178  	$d:3.5915910724879097->3.4500145962155995  	$l:64.35208076449693->66.12616437992622
	 improve value x$w(high is good):-1.6325071391569743  	x$d:-0.14157647627231018  	 x$l(negative is good):1.7740836154292907
	 	 $w-$l: -32.29575260148178 -> -35.70234335606804  _ #Surrender#	 lift : -3.406590754586264 : bad	 :| stand

[Prob_ROI diff: -0.2051023240207589 (up%-> -26.78607427170176) . o: 0.7657050523354964 -> a: 0.5606027283147375	 returnMoney: o:8.628013100195739 a: 0.07359650726558645 (probReturnRate: 0.00852994848419004	 totalSpendMoney: o: 11.268063432361087 a: 0.13128103654941078 (probTotalSpendRate: 0.011650718629465722

[Time_ROI diff: -0.047229221952546085 (up%-> -6.842773959138634) . o: 0.6902057883918656 -> a: 0.6429765664393196	 returnMoney: o:1.500588E9 a: 7268400.0 (timeReturnRate: 0.004843701269102512	 totalSpendMoney: o: 2.1741168E9 a: 1.13043E7 (timeTotalSpendRate: 0.005199490662139219

[[Per_Prob_ROI diff: 0.011191700170323147 (up%-> 4491.559056388989) . o: 2.491718361000639E-4 -> a: 0.01144087200642321	 per returnMoney: o:0.0028076840547334 a: 0.0015019695360323764	 per totalSpendMoney: o: 0.003666795780137028 a: 0.002679204827538996

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 2.377263478860765

 按net净收益值(代表少输多赢) :  $Change$  Value: 2.5823658028815237     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.7321392572829823 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Ten, 	playerStartValue=7	@@@ 

net money diff:  3.4361323472229373 , up % -> 98.12550611373327 .  o: -3.501772865497638 -> a: -0.06564051827470083 (anet/onet: 0.01874493886266739

[ProbMatrix: total: o: 0.032406469166131144  -> a: 4.37603455164672E-4
org->adv	$w:26.91260538610406->0.0  	$d:10.15551122933482->0.0  	$l:62.93188338456112->100.0
	 improve value x$w(high is good):-26.91260538610406  	x$d:-10.15551122933482  	 x$l(negative is good):37.06811661543888
	 	 $w-$l: -36.019277998457056 -> -100.0  _ #Surrender#	 lift : -63.980722001542944 : bad	 :| stand

[TimeMatrix: total:  o: 5286820.0 -> a: 385.0
org->adv	$w:31.43886116796108->0.0  	$d:3.575003499267991->0.0  	$l:64.98613533277093->100.0
	 improve value x$w(high is good):-31.43886116796108  	x$d:-3.575003499267991  	 x$l(negative is good):35.01386466722907
	 	 $w-$l: -33.547274164809856 -> -100.0  _ #Surrender#	 lift : -66.45272583519015 : bad	 :| stand

[Prob_ROI diff: -0.13980722001758306 (up%-> -21.851460196673134) . o: 0.6398072200175831 -> a: 0.5	 returnMoney: o:6.220167884310228 a: 0.06564051827470083 (probReturnRate: 0.010552853153734434	 totalSpendMoney: o: 9.721940749807866 a: 0.13128103654940165 (probTotalSpendRate: 0.013503583279089225

[Time_ROI diff: -0.16452725835190152 (up%-> -24.75854169773963) . o: 0.6645272583519015 -> a: 0.5	 returnMoney: o:1.0539708E9 a: 57750.0 (timeReturnRate: 5.479278932585229E-5	 totalSpendMoney: o: 1.586046E9 a: 115500.0 (timeTotalSpendRate: 7.282260413632391E-5

[[Per_Prob_ROI diff: 0.49985972216180274 (up%-> 356335.49004297383) . o: 1.4027783819723372E-4 -> a: 0.5	 per returnMoney: o:0.001363772831464641 a: 0.06564051827470083	 per totalSpendMoney: o: 0.0021315371080482056 a: 0.13128103654940165

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=true]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 3.296325127205354

 按net净收益值(代表少输多赢) :  $Change$  Value: 3.4361323472229373     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.7814853980332687 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 */
	}
	
	public static void test88vsAll() {
		StrategyMatrix8012 o = new Myth2019April22();
		StrategyMatrix8012 t = new MirMyth2019April22();
		
		System.out.println(t.diffWith(o));
		
		for(Card playerCard : Card.values()) {
			if(playerCard.getValue() == 8) {
				for(Card dealerCard : Card.values()) {
					if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
					PlayerCardsPathValue nine = new PlayerCardsPathValue(playerCard,playerCard);
					Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, nine, dealerCard); 
//					HelloWorld.print(origin);
					PlayerCardsPathValue ninet = new PlayerCardsPathValue(playerCard,playerCard);
					Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, ninet, dealerCard); 
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
MatrixKey [startValue=Eight, dealerCard=One1, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Eight, dealerCard=One1, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Eight, dealerCard=Two2, situation=Splited_Pair_And_Can_Split] : Split -> Stand
MatrixKey [startValue=Eight, dealerCard=Two2, situation=Start_With_Pair] : Split -> Stand
MatrixKey [startValue=Eight, dealerCard=Three3, situation=Splited_Pair_And_Can_Split] : Stand -> Split
MatrixKey [startValue=Eight, dealerCard=Three3, situation=Start_With_Pair] : Stand -> Split
MatrixKey [startValue=Eight, dealerCard=Four4, situation=Splited_Pair_And_Can_Split] : Stand -> Split
MatrixKey [startValue=Eight, dealerCard=Four4, situation=Start_With_Pair] : Stand -> Split
MatrixKey [startValue=Eight, dealerCard=Five5, situation=Start_With_Pair] : Stand -> Split
MatrixKey [startValue=Eight, dealerCard=Five5, situation=Splited_Pair_And_Can_Split] : Stand -> Split
MatrixKey [startValue=Eight, dealerCard=Six6, situation=Splited_Pair_And_Can_Split] : Stand -> Split
MatrixKey [startValue=Eight, dealerCard=Six6, situation=Start_With_Pair] : Stand -> Split
MatrixKey [startValue=Eight, dealerCard=Seven7, situation=Splited_Pair_And_Can_Split] : Hit -> Split
MatrixKey [startValue=Eight, dealerCard=Seven7, situation=Start_With_Pair] : Hit -> Split
MatrixKey [startValue=Eight, dealerCard=Eight8, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Eight, dealerCard=Eight8, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Eight, dealerCard=Nine9, situation=Start_With_Pair] : Split -> Giveup
MatrixKey [startValue=Eight, dealerCard=Nine9, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Eight, dealerCard=Ten, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Eight, dealerCard=Ten, situation=Start_With_Pair] : Split -> Giveup


		 @@@   dealerCard=One1, 	playerStartValue=8	@@@ 

net money diff:  3.9656353834885167 , up % -> 97.92489371191479 .  o: -4.049670347516555 -> a: -0.08403496402803828 (anet/onet: 0.020751062880852118

[ProbMatrix: total: o: 0.032406469165588925  -> a: 4.376034551643463E-4
org->adv	$w:23.358562013934584->14.570273120653471  	$d:11.627917857430608->6.8479512319045535  	$l:65.01352012863481->78.58177564744197
	 improve value x$w(high is good):-8.788288893281113  	x$d:-4.779966625526055  	 x$l(negative is good):13.568255518807163
	 	 $w-$l: -41.654958114700236 -> -64.0115025267885  _ #Surrender#	 lift : -22.356544412088276 : bad	 :| stand

[TimeMatrix: total:  o: 9.7928428E7 -> a: 184717.0
org->adv	$w:31.70250011569674->28.838710026689473  	$d:3.522537909012488->3.2065267409063596  	$l:64.77496197529076->67.95476323240418
	 improve value x$w(high is good):-2.863790089007267  	x$d:-0.3160111681061286  	 x$l(negative is good):3.179801257113411
	 	 $w-$l: -33.07246185959403 -> -39.11605320571469  _ #Surrender#	 lift : -6.043591346120669 : bad	 :| stand

[Prob_ROI diff: -0.22356544409698892 (up%-> -38.31781362771442) . o: 0.5834504188289308 -> a: 0.35988497473194186	 returnMoney: o:5.6722704023252515 a: 0.04724607252136522 (probReturnRate: 0.008329305405115646	 totalSpendMoney: o: 9.721940749841806 a: 0.1312810365494035 (probTotalSpendRate: 0.013503583279042273

[Time_ROI diff: -0.06043591346120658 (up%-> -9.030051775461883) . o: 0.6692753814040597 -> a: 0.6088394679428532	 returnMoney: o:1.96623258E10 a: 3.37389E7 (timeReturnRate: 0.001715916028611427	 totalSpendMoney: o: 2.93785284E10 a: 5.54151E7 (timeTotalSpendRate: 0.0018862449216482879

[[Per_Prob_ROI diff: 0.02742901109113243 (up%-> 10779.788719357755) . o: 2.544485036323292E-4 -> a: 0.02768345959476476	 per returnMoney: o:0.002473733276199412 a: 0.0036343132708742476	 per totalSpendMoney: o: 0.004239834605251551 a: 0.01009854127303104

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=true]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 3.742069939391528

 按net净收益值(代表少输多赢) :  $Change$  Value: 3.9656353834885167     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.6168218637228557 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Two2, 	playerStartValue=8	@@@ 

net money diff:  -0.22243949364155285 , up % -> -120.90737604626207 .  o: 0.18397512287128137 -> a: -0.03846437077027147 (anet/onet: -0.20907376046262058

[ProbMatrix: total: o: 0.03240646916620267  -> a: 4.376034551646746E-4
org->adv	$w:45.27004092888042->35.35037055569538  	$d:8.0427854424196->0.0  	$l:46.68717362869998->64.64962944430462
	 improve value x$w(high is good):-9.919670373185042  	x$d:-8.0427854424196  	 x$l(negative is good):17.962455815604642
	 	 $w-$l: -1.4171326998195621 -> -29.29925888860925  _ #Surrender#	 lift : -27.882126188789684 : bad	 :| stand

[TimeMatrix: total:  o: 7793188.0 -> a: 26689.0
org->adv	$w:63.005999598623816->57.960208325527375  	$d:4.666690961388331->0.0  	$l:32.32730943998784->42.03979167447263
	 improve value x$w(high is good):-5.045791273096441  	x$d:-4.666690961388331  	 x$l(negative is good):9.712482234484789
	 	 $w-$l: 30.678690158635973 -> 15.920416651054742  _ @double@	 lift : -14.758273507581233 : bad	 :| stand

[Prob_ROI diff: -0.30931971767586086 (up%-> -30.435054709620545) . o: 1.0163271287897 -> a: 0.7070074111138391	 returnMoney: o:11.452038555269858 a: 0.09281666577914237 (probReturnRate: 0.008104816040497098	 totalSpendMoney: o: 11.268063432398577 a: 0.13128103654941384 (probTotalSpendRate: 0.01165071862942723

[Time_ROI diff: -0.20626174239788453 (up%-> -15.105594438661042) . o: 1.365465908908432 -> a: 1.1592041665105475	 returnMoney: o:4.8979284E9 a: 9281400.0 (timeReturnRate: 0.001894964409851316	 totalSpendMoney: o: 3.5870016E9 a: 8006700.0 (timeTotalSpendRate: 0.002232142857142857

[[Per_Prob_ROI diff: 0.6965298118479659 (up%-> 6647.799693166807) . o: 0.010477599265873196 -> a: 0.7070074111138391	 per returnMoney: o:0.11806225314711194 a: 0.09281666577914237	 per totalSpendMoney: o: 0.11616560239586161 a: 0.13128103654941384

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.5317592113174137

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.22243949364155285     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.6956494529037944 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Three3, 	playerStartValue=8	@@@ 

net money diff:  0.5481711284521358 , up % -> 1659.5225058241003 .  o: -0.03303185865381923 -> a: 0.5151392697983166 (anet/onet: -15.595225058241002

[ProbMatrix: total: o: 4.3760345516467516E-4  -> a: 0.03240646916617661
org->adv	$w:37.41940971749468->46.90311684864895  	$d:0.0->7.789570722847976  	$l:62.58059028250532->45.30731242850309
	 improve value x$w(high is good):9.483707131154269  	x$d:7.789570722847976  	 x$l(negative is good):-17.27327785400223
	 	 $w-$l: -25.16118056501064 -> 1.5958044201458577  _ #Surrender#	 lift : 26.756984985156496 : good	 :) hit 

[TimeMatrix: total:  o: 15553.0 -> a: 4541476.0
org->adv	$w:57.937375425962834->62.98842050469935  	$d:0.0->4.669230884408505  	$l:42.06262457403716->32.34234861089214
	 improve value x$w(high is good):5.051045078736514  	x$d:4.669230884408505  	 x$l(negative is good):-9.72027596314502
	 	 $w-$l: 15.874750851925674 -> 30.646071893807207  _ @double@	 lift : 14.771321041881535 : good	 :) hit 

[Prob_ROI diff: 0.2973285583902211 (up%-> 39.729188759921314) . o: 0.7483881943498562 -> a: 1.0457167527400772	 returnMoney: o:0.09824917789558939 a: 11.78320270219347 (probReturnRate: 119.93181983380691	 totalSpendMoney: o: 0.13128103654940862 a: 11.268063432395154 (probTotalSpendRate: 85.83161535409063

[Time_ROI diff: 0.20639104995820756 (up%-> 17.811563644434592) . o: 1.1587475085192567 -> a: 1.3651385584774642	 returnMoney: o:5406600.0 a: 2.8535808E9 (timeReturnRate: 527.795805127067	 totalSpendMoney: o: 4665900.0 a: 2.0903232E9 (timeTotalSpendRate: 448.0

[[Per_Prob_ROI diff: -0.7376076092700615 (up%-> -98.55949289938225) . o: 0.7483881943498562 -> a: 0.01078058507979461	 per returnMoney: o:0.09824917789558939 a: 0.12147631651745847	 per totalSpendMoney: o: 0.13128103654940862 a: 0.11616560239582634

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.8454996868423569

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.5481711284521358     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.3972918875992133 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Four4, 	playerStartValue=8	@@@ 

net money diff:  0.9031669673024636 , up % -> 3301.329189235696 .  o: -0.027357676727523178 -> a: 0.8758092905749404 (anet/onet: -32.01329189235696

[ProbMatrix: total: o: 4.376034551646753E-4  -> a: 0.032406469166159926
org->adv	$w:39.58049180346544->48.89491117376786  	$d:0.0->7.1034699678426625  	$l:60.41950819653456->44.001618858389485
	 improve value x$w(high is good):9.314419370302417  	x$d:7.1034699678426625  	 x$l(negative is good):-16.417889338145073
	 	 $w-$l: -20.83901639306911 -> 4.893292315378373  _ @double@	 lift : 25.732308708447484 : good	 :) hit 

[TimeMatrix: total:  o: 9073.0 -> a: 1996060.0
org->adv	$w:57.91910062823763->68.65985992405038  	$d:0.0->5.0529543200104206  	$l:42.08089937176237->26.287185755939202
	 improve value x$w(high is good):10.740759295812751  	x$d:5.0529543200104206  	 x$l(negative is good):-15.793713615823169
	 	 $w-$l: 15.838201256475259 -> 42.37267416811118  _ @double@	 lift : 26.53447291163592 : good	 :) hit 

[Prob_ROI diff: 0.2861150805349558 (up%-> 36.14344687221773) . o: 0.7916098360692959 -> a: 1.0777249166042517	 returnMoney: o:0.10392335982188142 a: 12.143872722977916 (probReturnRate: 116.85411964924735	 totalSpendMoney: o: 0.1312810365494046 a: 11.268063432402975 (probTotalSpendRate: 85.83161535415285

[Time_ROI diff: 0.28648480058907544 (up%-> 24.731461424782886) . o: 1.1583820125647526 -> a: 1.444866813153828	 returnMoney: o:3153000.0 a: 1.4787264E9 (timeReturnRate: 468.9902949571836	 totalSpendMoney: o: 2721900.0 a: 1.0234344E9 (timeTotalSpendRate: 376.0

[[Per_Prob_ROI diff: -0.7768464810473199 (up%-> -98.13502127572305) . o: 0.7916098360692959 -> a: 0.014763355021976053	 per returnMoney: o:0.10392335982188142 a: 0.16635442086271118	 per totalSpendMoney: o: 0.1312810365494046 a: 0.1543570333205887

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.1892820478374193

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.9031669673024636     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.3614344687221773 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Five5, 	playerStartValue=8	@@@ 

net money diff:  1.2656015903108262 , up % -> 5907.53750914445 .  o: -0.021423504943502508 -> a: 1.2441780853673237 (anet/onet: -58.0753750914445

[ProbMatrix: total: o: 4.376034551646753E-4  -> a: 0.03240646916615135
org->adv	$w:41.840594229525045->50.672199342323346  	$d:0.0->6.909613248465712  	$l:58.15940577047495->42.41818740921094
	 improve value x$w(high is good):8.8316051127983  	x$d:6.909613248465712  	 x$l(negative is good):-15.74121836126401
	 	 $w-$l: -16.318811540949902 -> 8.254011933112409  _ @double@	 lift : 24.57282347406231 : good	 :) hit 

[TimeMatrix: total:  o: 5473.0 -> a: 1204060.0
org->adv	$w:57.90243011145624->68.64907064432005  	$d:0.0->5.05390096839028  	$l:42.09756988854376->26.29702838728967
	 improve value x$w(high is good):10.746640532863807  	x$d:5.05390096839028  	 x$l(negative is good):-15.800541501254088
	 	 $w-$l: 15.804860222912476 -> 42.352042257030384  _ @double@	 lift : 26.547182034117906 : good	 :) hit 

[Prob_ROI diff: 0.27360443431211223 (up%-> 32.696050253397416) . o: 0.836811884590501 -> a: 1.1104163189026133	 returnMoney: o:0.10985753160589978 a: 12.512241517772496 (probReturnRate: 113.89516344367362	 totalSpendMoney: o: 0.1312810365494023 a: 11.268063432405173 (probTotalSpendRate: 85.83161535417108

[Time_ROI diff: 0.2866159210981569 (up%-> 24.74990432581592) . o: 1.1580486022291248 -> a: 1.4446645233272817	 returnMoney: o:1901400.0 a: 8.9187E8 (timeReturnRate: 469.05964026506786	 totalSpendMoney: o: 1641900.0 a: 6.173544E8 (timeTotalSpendRate: 376.0

[[Per_Prob_ROI diff: -0.8216007021397803 (up%-> -98.18224588693977) . o: 0.836811884590501 -> a: 0.015211182450720727	 per returnMoney: o:0.10985753160589978 a: 0.17140056873660953	 per totalSpendMoney: o: 0.1312810365494023 a: 0.1543570333206188

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.5392060246229384

 按net净收益值(代表少输多赢) :  $Change$  Value: 1.2656015903108262     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.3269605025339741 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Six6, 	playerStartValue=8	@@@ 

net money diff:  1.7050229580098466 , up % -> 8416.180664400186 .  o: -0.02025886831567157 -> a: 1.6847640896941751 (anet/onet: -83.16180664400187

[ProbMatrix: total: o: 4.3760345516467446E-4  -> a: 0.03240646916614639
org->adv	$w:42.28416043620764->52.88440581143856  	$d:0.0->6.610702933616677  	$l:57.71583956379235->40.504891254944766
	 improve value x$w(high is good):10.60024537523092  	x$d:6.610702933616677  	 x$l(negative is good):-17.210948308847584
	 	 $w-$l: -15.431679127584708 -> 12.379514556493799  _ @double@	 lift : 27.811193684078507 : good	 :) hit 

[TimeMatrix: total:  o: 3109.0 -> a: 683980.0
org->adv	$w:57.896429720167255->68.63270855872979  	$d:0.0->5.058042632825521  	$l:42.103570279832745->26.30924880844469
	 improve value x$w(high is good):10.736278838562534  	x$d:5.058042632825521  	 x$l(negative is good):-15.794321471388056
	 	 $w-$l: 15.792859440334512 -> 42.32345975028509  _ @double@	 lift : 26.53060030995058 : good	 :) hit 

[Prob_ROI diff: 0.3038335294270039 (up%-> 35.927582136269024) . o: 0.8456832087241487 -> a: 1.1495167381511526	 returnMoney: o:0.11102216823373108 a: 12.952827522103842 (probReturnRate: 116.6688394594736	 totalSpendMoney: o: 0.13128103654940265 a: 11.268063432409667 (probTotalSpendRate: 85.83161535420508

[Time_ROI diff: 0.28646414322180647 (up%-> 24.739361702127677) . o: 1.157928594403345 -> a: 1.4443927376251515	 returnMoney: o:1080000.0 a: 5.065416E8 (timeReturnRate: 469.02	 totalSpendMoney: o: 932700.0 a: 3.506952E8 (timeTotalSpendRate: 376.0

[[Per_Prob_ROI diff: -0.8299364040919411 (up%-> -98.13797832690042) . o: 0.8456832087241487 -> a: 0.01574680463220757	 per returnMoney: o:0.11102216823373108 a: 0.1774359934534773	 per totalSpendMoney: o: 0.13128103654940265 a: 0.15435703332068038

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 2.0088564874368506

 按net净收益值(代表少输多赢) :  $Change$  Value: 1.7050229580098466     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.35927582136269 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Seven7, 	playerStartValue=8	@@@ 

net money diff:  1.2501528322899003 , up % -> 2317.762744727001 .  o: -0.053937912115208764 -> a: 1.1962149201746914 (anet/onet: -22.17762744727001

[ProbMatrix: total: o: 4.376034551646524E-4  -> a: 0.03240646916610261
org->adv	$w:26.600058528193426->48.664053809402716  	$d:5.714046380375415->11.581442052227986  	$l:67.68589509143116->39.754504138369285
	 improve value x$w(high is good):22.06399528120929  	x$d:5.867395671852571  	 x$l(negative is good):-27.93139095306188
	 	 $w-$l: -41.085836563237734 -> 8.909549671033435  _ @double@	 lift : 49.995386234271166 : good	 :) hit 

[TimeMatrix: total:  o: 24973.0 -> a: 4664188.0
org->adv	$w:28.70299923917831->33.82526604845259  	$d:3.247507307892524->3.6579571835440596  	$l:68.04949345292917->62.516776768003346
	 improve value x$w(high is good):5.122266809274279  	x$d:0.41044987565153557  	 x$l(negative is good):-5.532716684925823
	 	 $w-$l: -39.34649421375085 -> -28.691510719550756  _ #Surrender#	 lift : 10.6549834942001 : good	 :) hit 

[Prob_ROI diff: 0.5170181265667423 (up%-> 87.75786608965349) . o: 0.5891416343676318 -> a: 1.106159760934374	 returnMoney: o:0.077343124434189 a: 12.464278352553455 (probReturnRate: 161.15560941889885	 totalSpendMoney: o: 0.13128103654939777 a: 11.268063432378764 (probTotalSpendRate: 85.83161535397288

[Time_ROI diff: 0.1524434314756531 (up%-> 25.133490554178945) . o: 0.6065350578624915 -> a: 0.7589784893381446	 returnMoney: o:4544100.0 a: 1.1302398E9 (timeReturnRate: 248.72687660922955	 totalSpendMoney: o: 7491900.0 a: 1.4891592E9 (timeTotalSpendRate: 198.76923076923077

[[Per_Prob_ROI diff: -0.043944475754782296 (up%-> -96.96788539234102) . o: 0.045318587259048596 -> a: 0.0013741115042663029	 per returnMoney: o:0.005949471110322231 a: 0.015483575593234105	 per totalSpendMoney: o: 0.010098541273030597 a: 0.013997594325936353

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.7671709588566424

 按net净收益值(代表少输多赢) :  $Change$  Value: 1.2501528322899003     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.8775786608965348 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Eight8, 	playerStartValue=8	@@@ 

net money diff:  0.24202764373027072 , up % -> 80.20043204676682 .  o: -0.30177847868592345 -> a: -0.059750834955652726 (anet/onet: 0.19799567953233183

[ProbMatrix: total: o: 0.03240646916611991  -> a: 4.376034551646572E-4
org->adv	$w:38.600939349817594->24.315518051097364  	$d:17.167639093179073->5.855280790061864  	$l:44.23142155700334->69.82920115884077
	 improve value x$w(high is good):-14.28542129872023  	x$d:-11.312358303117207  	 x$l(negative is good):25.597779601837438
	 	 $w-$l: -5.630482207185744 -> -45.51368310774341  _ #Surrender#	 lift : -39.88320090055766 : bad	 :| stand

[TimeMatrix: total:  o: 2799484.0 -> a: 14989.0
org->adv	$w:33.81416003806416->28.694375875642137  	$d:3.6616747943549597->3.249049302822069  	$l:62.52416516758088->68.0565748215358
	 improve value x$w(high is good):-5.119784162422022  	x$d:-0.41262549153289063  	 x$l(negative is good):5.532409653954922
	 	 $w-$l: -28.710005129516723 -> -39.36219894589366  _ #Surrender#	 lift : -10.652193816376936 : bad	 :| stand

[Prob_ROI diff: -0.42835507922657756 (up%-> -44.01428765245778) . o: 0.9732182481491507 -> a: 0.5448631689225731	 returnMoney: o:10.966284953705005 a: 0.07153020159374499 (probReturnRate: 0.006522737818296269	 totalSpendMoney: o: 11.268063432390928 a: 0.1312810365493977 (probTotalSpendRate: 0.011650718629433707

[Time_ROI diff: -0.15241114898087282 (up%-> -20.0860999486204) . o: 0.7587891595219363 -> a: 0.6063780105410634	 returnMoney: o:6.7821E8 a: 2726700.0 (timeReturnRate: 0.004020436148095723	 totalSpendMoney: o: 8.938056E8 a: 4496700.0 (timeTotalSpendRate: 0.005030959752321981

[[Per_Prob_ROI diff: 0.04070358468769541 (up%-> 3366.807572290115) . o: 0.0012089667678871437 -> a: 0.04191255145558255	 per returnMoney: o:0.013622714228204975 a: 0.005502323199518845	 per totalSpendMoney: o: 0.013997594325951464 a: 0.010098541273030594

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.18632743549630681

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.24202764373027072     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.5598571234754223 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Nine9, 	playerStartValue=8	@@@ 

net money diff:  1.804586131675127 , up % -> 96.49023725138011 .  o: -1.870226649949828 -> a: -0.06564051827470078 (anet/onet: 0.03509762748619891

[ProbMatrix: total: o: 0.03240646916612824  -> a: 4.3760345516467256E-4
org->adv	$w:33.96572842757434->0.0  	$d:11.305428941086678->0.0  	$l:54.72884263133899->100.0
	 improve value x$w(high is good):-33.96572842757434  	x$d:-11.305428941086678  	 x$l(negative is good):45.27115736866101
	 	 $w-$l: -20.763114203764655 -> -100.0  _ #Surrender#	 lift : -79.23688579623534 : bad	 :| stand

[TimeMatrix: total:  o: 1867132.0 -> a: 769.0
org->adv	$w:33.78550632735126->0.0  	$d:3.6613372809206846->0.0  	$l:62.55315639172806->100.0
	 improve value x$w(high is good):-33.78550632735126  	x$d:-3.6613372809206846  	 x$l(negative is good):37.44684360827194
	 	 $w-$l: -28.767650064376802 -> -100.0  _ #Surrender#	 lift : -71.23234993562319 : bad	 :| stand

[Prob_ROI diff: -0.3340241283544223 (up%-> -40.04969604578121) . o: 0.8340241283544223 -> a: 0.5	 returnMoney: o:9.39783678244763 a: 0.06564051827470078 (probReturnRate: 0.006984641231192458	 totalSpendMoney: o: 11.268063432397458 a: 0.13128103654940157 (probTotalSpendRate: 0.011650718629427298

[Time_ROI diff: -0.2582009122860697 (up%-> -34.054418571927314) . o: 0.7582009122860697 -> a: 0.5	 returnMoney: o:4.519854E8 a: 115350.0 (timeReturnRate: 2.552073584677735E-4	 totalSpendMoney: o: 5.961288E8 a: 230700.0 (timeTotalSpendRate: 3.869969040247678E-4

[[Per_Prob_ROI diff: 0.4989639451821684 (up%-> 48159.99468314613) . o: 0.0010360548178315805 -> a: 0.5	 per returnMoney: o:0.011674331406767243 a: 0.06564051827470078	 per totalSpendMoney: o: 0.013997594325959576 a: 0.13128103654940157

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=true]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.4705620033207047

 按net净收益值(代表少输多赢) :  $Change$  Value: 1.804586131675127     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.5995030395421879 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Ten, 	playerStartValue=8	@@@ 

net money diff:  2.7726956132242755 , up % -> 97.68735924028721 .  o: -2.838336131498976 -> a: -0.06564051827470083 (anet/onet: 0.023126407597128

[ProbMatrix: total: o: 0.032406469166133337  -> a: 4.37603455164672E-4
org->adv	$w:30.3255061707297->0.0  	$d:10.153827920905313->0.0  	$l:59.520665908365004->100.0
	 improve value x$w(high is good):-30.3255061707297  	x$d:-10.153827920905313  	 x$l(negative is good):40.479334091634996
	 	 $w-$l: -29.1951597376353 -> -100.0  _ #Surrender#	 lift : -70.80484026236469 : bad	 :| stand

[TimeMatrix: total:  o: 2653420.0 -> a: 385.0
org->adv	$w:31.475077447219064->0.0  	$d:3.57809920781482->0.0  	$l:64.94682334496612->100.0
	 improve value x$w(high is good):-31.475077447219064  	x$d:-3.57809920781482  	 x$l(negative is good):35.05317665503388
	 	 $w-$l: -33.471745897747056 -> -100.0  _ #Surrender#	 lift : -66.52825410225293 : bad	 :| stand

[Prob_ROI diff: -0.20804840262477298 (up%-> -29.383358800546194) . o: 0.708048402624773 -> a: 0.5	 returnMoney: o:6.883604618326896 a: 0.06564051827470083 (probReturnRate: 0.009535776953246216	 totalSpendMoney: o: 9.721940749825873 a: 0.13128103654940165 (probTotalSpendRate: 0.013503583279064214

[Time_ROI diff: -0.16528254102252937 (up%-> -24.84396190053215) . o: 0.6652825410225294 -> a: 0.5	 returnMoney: o:5.295822E8 a: 57750.0 (timeReturnRate: 1.0904822707409728E-4	 totalSpendMoney: o: 7.96026E8 a: 115500.0 (timeTotalSpendRate: 1.4509576320371445E-4

[[Per_Prob_ROI diff: 0.4996912130821523 (up%-> 161823.9582703476) . o: 3.087869178476986E-4 -> a: 0.5	 per returnMoney: o:0.003002008119636675 a: 0.06564051827470083	 per totalSpendMoney: o: 0.004239834605244602 a: 0.13128103654940165

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=true]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 2.564647210599502

 按net净收益值(代表少输多赢) :  $Change$  Value: 2.7726956132242755     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.7061664119945381 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 */
	}
	
	public static void test99vsAll() {
		StrategyMatrix8012 o = new Myth2019April22();
		StrategyMatrix8012 t = new MirMyth2019April22();
		
		System.out.println(t.diffWith(o));
		
		for(Card playerCard : Card.values()) {
			if(playerCard.getValue() == 9) {
				for(Card dealerCard : Card.values()) {
					if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
					PlayerCardsPathValue nine = new PlayerCardsPathValue(playerCard,playerCard);
					Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, nine, dealerCard); 
//					HelloWorld.print(origin);
					PlayerCardsPathValue ninet = new PlayerCardsPathValue(playerCard,playerCard);
					Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, ninet, dealerCard); 
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
MatrixKey [startValue=Nine, dealerCard=One1, situation=Splited_Pair_And_Can_Split] : Split -> Stand
MatrixKey [startValue=Nine, dealerCard=One1, situation=Start_With_Pair] : Split -> Stand
MatrixKey [startValue=Nine, dealerCard=Two2, situation=Splited_Pair_And_Can_Split] : Stand -> Split
MatrixKey [startValue=Nine, dealerCard=Two2, situation=Start_With_Pair] : Stand -> Split
MatrixKey [startValue=Nine, dealerCard=Three3, situation=Start_With_Pair] : Stand -> Split
MatrixKey [startValue=Nine, dealerCard=Three3, situation=Splited_Pair_And_Can_Split] : Stand -> Split
MatrixKey [startValue=Nine, dealerCard=Four4, situation=Splited_Pair_And_Can_Split] : Stand -> Split
MatrixKey [startValue=Nine, dealerCard=Four4, situation=Start_With_Pair] : Stand -> Split
MatrixKey [startValue=Nine, dealerCard=Five5, situation=Start_With_Pair] : Stand -> Split
MatrixKey [startValue=Nine, dealerCard=Five5, situation=Splited_Pair_And_Can_Split] : Stand -> Split
MatrixKey [startValue=Nine, dealerCard=Six6, situation=Splited_Pair_And_Can_Split] : Stand -> Split
MatrixKey [startValue=Nine, dealerCard=Six6, situation=Start_With_Pair] : Stand -> Split
MatrixKey [startValue=Nine, dealerCard=Seven7, situation=Start_With_Pair] : Split -> Stand
MatrixKey [startValue=Nine, dealerCard=Seven7, situation=Splited_Pair_And_Can_Split] : Split -> Stand
MatrixKey [startValue=Nine, dealerCard=Eight8, situation=Splited_Pair_And_Can_Split] : Stand -> Split
MatrixKey [startValue=Nine, dealerCard=Eight8, situation=Start_With_Pair] : Stand -> Split
MatrixKey [startValue=Nine, dealerCard=Nine9, situation=Start_With_Pair] : Split -> Stand
MatrixKey [startValue=Nine, dealerCard=Nine9, situation=Splited_Pair_And_Can_Split] : Split -> Stand
MatrixKey [startValue=Nine, dealerCard=Ten, situation=Splited_Pair_And_Can_Split] : Split -> Stand
MatrixKey [startValue=Nine, dealerCard=Ten, situation=Start_With_Pair] : Split -> Stand


		 @@@   dealerCard=One1, 	playerStartValue=9	@@@ 

net money diff:  3.195519855707107 , up % -> 98.47002203661172 .  o: -3.245170245335168 -> a: -0.049650389628061106 (anet/onet: 0.015299779633882692

[ProbMatrix: total: o: 0.03240646916587313  -> a: 4.3760345516467175E-4
org->adv	$w:27.59370926174709->24.548959667640275  	$d:11.432721131405609->13.082155614562495  	$l:60.9735696068473->62.36888471779722
	 improve value x$w(high is good):-3.044749594106815  	x$d:1.6494344831568863  	 x$l(negative is good):1.395315110949923
	 	 $w-$l: -33.37986034510021 -> -37.81992505015695  _ #Surrender#	 lift : -4.44006470505674 : bad	 :| stand

[TimeMatrix: total:  o: 6.5531908E7 -> a: 14209.0
org->adv	$w:31.717031648155274->66.64789921880498  	$d:3.52136855224786->8.332746850587656  	$l:64.76159979959687->25.019353930607362
	 improve value x$w(high is good):34.93086757064971  	x$d:4.811378298339795  	 x$l(negative is good):-39.7422458689895
	 	 $w-$l: -33.04456815144158 -> 41.62854528819762  _ @double@	 lift : 74.67311343963921 : good	 :) hit 

[Prob_ROI diff: -0.044400647031592966 (up%-> -6.664748417349587) . o: 0.6662013965299841 -> a: 0.6218007494983911	 returnMoney: o:6.476770504565759 a: 0.0816306469213487 (probReturnRate: 0.012603603426090779	 totalSpendMoney: o: 9.721940749900927 a: 0.1312810365494098 (probTotalSpendRate: 0.013503583278960804

[Time_ROI diff: 0.746731134396392 (up%-> 111.52659519624466) . o: 0.6695543184855841 -> a: 1.4162854528819762	 returnMoney: o:1.31631516E10 a: 6037200.0 (timeReturnRate: 4.586439618305391E-4	 totalSpendMoney: o: 1.96595724E10 a: 4262700.0 (timeTotalSpendRate: 2.168256721595837E-4

[[Per_Prob_ROI diff: 0.6213673068201023 (up%-> 143356.2816825337) . o: 4.3344267828886407E-4 -> a: 0.6218007494983911	 per returnMoney: o:0.004213904036802706 a: 0.0816306469213487	 per totalSpendMoney: o: 0.006325270494405288 a: 0.1312810365494098

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 3.151119208675514
 按net净收益值(代表少输多赢) :  $Change$  Value: 3.195519855707107     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.933352515826504 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Two2, 	playerStartValue=9	@@@ 

net money diff:  0.8550606156272773 , up % -> 5395.799893368171 .  o: 0.015846781432317547 -> a: 0.8709073970595949 (anet/onet: 54.95799893368171

[ProbMatrix: total: o: 4.3760345516467185E-4  -> a: 0.03240646916618171
org->adv	$w:49.31601058521037->49.626851908925765  	$d:13.438862674532265->7.851121236544391  	$l:37.24512674025737->42.52202685452984
	 improve value x$w(high is good):0.31084132371539397  	x$d:-5.587741437987874  	 x$l(negative is good):5.276900114272472
	 	 $w-$l: 12.070883844953006 -> 7.104825054395924  _ @double@	 lift : -4.966058790557081 : bad	 :| stand

[TimeMatrix: total:  o: 26689.0 -> a: 5871580.0
org->adv	$w:66.31571059237888->61.61203628324914  	$d:8.370489714863801->4.513333719373661  	$l:25.313799692757318->33.8746299973772
	 improve value x$w(high is good):-4.703674309129738  	x$d:-3.8571559954901398  	 x$l(negative is good):8.56083030461988
	 	 $w-$l: 41.00191089962157 -> 27.73740628587194  _ @double@	 lift : -13.264504613749628 : bad	 :| stand

[Prob_ROI diff: -0.037725777607824806 (up%-> -3.366242534503479) . o: 1.1207088384494364 -> a: 1.0829830608416116	 returnMoney: o:0.14712781798172964 a: 11.365909488171683 (probReturnRate: 77.25194082320384	 totalSpendMoney: o: 0.1312810365494121 a: 10.495002091112088 (probTotalSpendRate: 79.94301665314728

[Time_ROI diff: -0.0757283560253188 (up%-> -5.3707326051225905) . o: 1.4100191089962157 -> a: 1.334290752970897	 returnMoney: o:1.12896E7 a: 3.1836132E9 (timeReturnRate: 281.9952168367347	 totalSpendMoney: o: 8006700.0 a: 2.3859966E9 (timeTotalSpendRate: 298.0

[[Per_Prob_ROI diff: -1.1058734540543458 (up%-> -98.67624989773292) . o: 1.1207088384494364 -> a: 0.014835384395090571	 per returnMoney: o:0.14712781798172964 a: 0.15569739024892718	 per totalSpendMoney: o: 0.1312810365494121 a: 0.1437671519330423

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.8173348380194525
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.8550606156272773     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9663375746549652 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Three3, 	playerStartValue=9	@@@ 

net money diff:  1.1360531735111181 , up % -> 5866.10860479809 .  o: 0.01936638494183182 -> a: 1.1554195584529499 (anet/onet: 59.6610860479809

[ProbMatrix: total: o: 4.376034551646747E-4  -> a: 0.03240646916616634
org->adv	$w:50.848985082662935->51.12932979564198  	$d:13.053882387688573->7.581313300926598  	$l:36.0971325296485->41.28935690343144
	 improve value x$w(high is good):0.2803447129790442  	x$d:-5.4725690867619745  	 x$l(negative is good):5.192224373782942
	 	 $w-$l: 14.751852553014439 -> 9.839972892210536  _ @double@	 lift : -4.911879660803903 : bad	 :| stand

[TimeMatrix: total:  o: 15553.0 -> a: 3421660.0
org->adv	$w:66.295891467884->61.595015284978636  	$d:8.371375297370284->4.51605361140499  	$l:25.332733234745707->33.88893110361637
	 improve value x$w(high is good):-4.700876182905368  	x$d:-3.8553216859652935  	 x$l(negative is good):8.556197868870665
	 	 $w-$l: 40.963158233138294 -> 27.706084181362268  _ @double@	 lift : -13.25707405177603 : bad	 :| stand

[Prob_ROI diff: -0.03742616457371084 (up%-> -3.2614867421353146) . o: 1.1475185255300995 -> a: 1.1100923609563886	 returnMoney: o:0.15064742149124022 a: 11.650421649566718 (probReturnRate: 77.33568576375642	 totalSpendMoney: o: 0.1312810365494084 a: 10.495002091113768 (probTotalSpendRate: 79.94301665316233

[Time_ROI diff: -0.07565384783013007 (up%-> -5.366923441443227) . o: 1.409631582331383 -> a: 1.333977734501253	 returnMoney: o:6577200.0 a: 1.8548136E9 (timeReturnRate: 282.00656814449917	 totalSpendMoney: o: 4665900.0 a: 1.3904382E9 (timeTotalSpendRate: 298.0

[[Per_Prob_ROI diff: -1.132311780859464 (up%-> -98.67481488687858) . o: 1.1475185255300995 -> a: 0.015206744670635458	 per returnMoney: o:0.15064742149124022 a: 0.1595948171173523	 per totalSpendMoney: o: 0.1312810365494084 a: 0.14376715193306533

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.0986270089374073
 按net净收益值(代表少输多赢) :  $Change$  Value: 1.1360531735111181     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9673851325786469 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Four4, 	playerStartValue=9	@@@ 

net money diff:  1.4417014871497411 , up % -> 6212.027162280279 .  o: 0.02320822896435193 -> a: 1.464909716114093 (anet/onet: 63.1202716228028

[ProbMatrix: total: o: 4.3760345516467576E-4  -> a: 0.03240646916615379
org->adv	$w:52.63606408551471->52.93003279358507  	$d:12.406151628064727->6.963120094039697  	$l:34.957784286420555->40.106847112375235
	 improve value x$w(high is good):0.29396870807035924  	x$d:-5.44303153402503  	 x$l(negative is good):5.14906282595468
	 	 $w-$l: 17.678279799094156 -> 12.82318568120983  _ @double@	 lift : -4.855094117884323 : bad	 :| stand

[TimeMatrix: total:  o: 9073.0 -> a: 1342804.0
org->adv	$w:66.27355891105478->69.35665964653069  	$d:8.376501708365481->5.010113166180619  	$l:25.349939380579745->25.63322718728869
	 improve value x$w(high is good):3.0831007354759095  	x$d:-3.366388542184862  	 x$l(negative is good):0.2832878067089446
	 	 $w-$l: 40.92361953047503 -> 43.723432459242005  _ @double@	 lift : 2.799812928766976 : good	 :) hit 

[Prob_ROI diff: -0.03720114727808599 (up%-> -3.1612585892314393) . o: 1.1767827979909191 -> a: 1.1395816507128331	 returnMoney: o:0.15448926551375688 a: 11.959911807240745 (probReturnRate: 77.41581117282058	 totalSpendMoney: o: 0.13128103654940496 a: 10.495002091126652 (probTotalSpendRate: 79.94301665326257

[Time_ROI diff: 0.047672321553105634 (up%-> 3.382848220329481) . o: 1.4092361953047503 -> a: 1.456908516857856	 returnMoney: o:3835800.0 a: 8.962164E8 (timeReturnRate: 233.64523697794462	 totalSpendMoney: o: 2721900.0 a: 6.151494E8 (timeTotalSpendRate: 226.0

[[Per_Prob_ROI diff: -1.1535260296090246 (up%-> -98.02369915488228) . o: 1.1767827979909191 -> a: 0.023256768381894555	 per returnMoney: o:0.15448926551375688 a: 0.24407983280083154	 per totalSpendMoney: o: 0.13128103654940496 a: 0.21418371614544188

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.404500339871655
 按net净收益值(代表少输多赢) :  $Change$  Value: 1.4417014871497411     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9683874141076855 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Five5, 	playerStartValue=9	@@@ 

net money diff:  1.7671556388407446 , up % -> 6633.059167704058 .  o: 0.026641638407884444 -> a: 1.793797277248629 (anet/onet: 67.33059167704059

[ProbMatrix: total: o: 4.376034551646743E-4  -> a: 0.03240646916614898
org->adv	$w:54.024940077968076->54.64411553233135  	$d:12.24371220754265->6.7109330015833395  	$l:33.73134771448927->38.64495146608532
	 improve value x$w(high is good):0.6191754543632726  	x$d:-5.532779205959311  	 x$l(negative is good):4.91360375159605
	 	 $w-$l: 20.29359236347881 -> 15.99916406624603  _ @double@	 lift : -4.294428297232777 : bad	 :| stand

[TimeMatrix: total:  o: 5473.0 -> a: 810004.0
org->adv	$w:66.270783847981->69.34484274151733  	$d:8.368353736524758->5.01281475153209  	$l:25.360862415494246->25.642342506950584
	 improve value x$w(high is good):3.074058893536332  	x$d:-3.355538984992668  	 x$l(negative is good):0.2814800914563378
	 	 $w-$l: 40.909921432486755 -> 43.702500234566735  _ @double@	 lift : 2.792578802079987 : good	 :) hit 

[Prob_ROI diff: -0.032016731654316954 (up%-> -2.661549216817423) . o: 1.2029359236347812 -> a: 1.1709191919804642	 returnMoney: o:0.15792267495728687 a: 12.288799368375162 (probReturnRate: 77.81529391962805	 totalSpendMoney: o: 0.13128103654940243 a: 10.495002091126533 (probTotalSpendRate: 79.9430166532632

[Time_ROI diff: 0.04760618903094671 (up%-> 3.3784838247714126) . o: 1.4090992143248675 -> a: 1.4567054033558142	 returnMoney: o:2313600.0 a: 5.405388E8 (timeReturnRate: 233.6353734439834	 totalSpendMoney: o: 1641900.0 a: 3.710694E8 (timeTotalSpendRate: 226.0

[[Per_Prob_ROI diff: -1.1790396135943635 (up%-> -98.01350100442484) . o: 1.2029359236347812 -> a: 0.02389631004041764	 per returnMoney: o:0.15792267495728687 a: 0.2507918238443911	 per totalSpendMoney: o: 0.13128103654940243 a: 0.21418371614543946

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.7351389071864276
 按net净收益值(代表少输多赢) :  $Change$  Value: 1.7671556388407446     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9733845078318257 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Six6, 	playerStartValue=9	@@@ 

net money diff:  2.0918403100382066 , up % -> 5624.637763242969 .  o: 0.03719066716986455 -> a: 2.129030977208071 (anet/onet: 57.24637763242969

[ProbMatrix: total: o: 4.376034551646735E-4  -> a: 0.032406469166145174
org->adv	$w:58.85482152551174->56.36681217741412  	$d:10.619404424062525->6.527581216054348  	$l:30.525774050425746->37.105606606531545
	 improve value x$w(high is good):-2.48800934809762  	x$d:-4.091823208008177  	 x$l(negative is good):6.579832556105799
	 	 $w-$l: 28.32904747508599 -> 19.261205570882574  _ @double@	 lift : -9.067841904203416 : bad	 :| stand

[TimeMatrix: total:  o: 3109.0 -> a: 460132.0
org->adv	$w:66.22708266323578->69.33184390566186  	$d:8.394982309424252->5.012474681178444  	$l:25.37793502733998->25.655681413159705
	 improve value x$w(high is good):3.104761242426079  	x$d:-3.3825076282458078  	 x$l(negative is good):0.2777463858197251
	 	 $w-$l: 40.84914763589579 -> 43.676162492502144  _ @double@	 lift : 2.827014856606358 : good	 :) hit 

[Prob_ROI diff: -0.08042905950558854 (up%-> -6.26740875024444) . o: 1.2832904747508556 -> a: 1.202861415245267	 returnMoney: o:0.16847170371926673 a: 12.62403306833513 (probReturnRate: 74.93266103233111	 totalSpendMoney: o: 0.13128103654940218 a: 10.49500209112706 (probTotalSpendRate: 79.94301665326736

[Time_ROI diff: 0.04796522798498226 (up%-> 3.4054326057389783) . o: 1.4084914763589578 -> a: 1.45645670434394	 returnMoney: o:1313700.0 a: 3.070068E8 (timeReturnRate: 233.69627768897007	 totalSpendMoney: o: 932700.0 a: 2.107902E8 (timeTotalSpendRate: 226.0

[[Per_Prob_ROI diff: -1.258742282602993 (up%-> -98.08708997449479) . o: 1.2832904747508556 -> a: 0.024548192147862594	 per returnMoney: o:0.16847170371926673 a: 0.25763332792520677	 per totalSpendMoney: o: 0.13128103654940218 a: 0.21418371614545018

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 2.011411250532618
 按net净收益值(代表少输多赢) :  $Change$  Value: 2.0918403100382066     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9373259124975556 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Seven7, 	playerStartValue=9	@@@ 

net money diff:  -1.6818776332363863 , up % -> -96.97068079372487 .  o: 1.7344187124086101 -> a: 0.05254107917222384 (anet/onet: 0.0302931920627513

[ProbMatrix: total: o: 0.032406469166116246  -> a: 4.376034551646725E-4
org->adv	$w:53.049754413466154->63.11437111287409  	$d:9.919990486014141->13.793092270091043  	$l:37.0302551005197->23.092536617034863
	 improve value x$w(high is good):10.064616699407935  	x$d:3.8731017840769013  	 x$l(negative is good):-13.93771848348484
	 	 $w-$l: 16.01949931294645 -> 40.02183449583923  _ @double@	 lift : 24.002335182892775 : good	 :) hit 

[TimeMatrix: total:  o: 4571980.0 -> a: 1921.0
org->adv	$w:32.74065065901426->66.26756897449245  	$d:3.6120455470058923->8.328995314940135  	$l:63.647303793979844->25.40343571056741
	 improve value x$w(high is good):33.52691831547819  	x$d:4.716949767934243  	 x$l(negative is good):-38.24386808341244
	 	 $w-$l: -30.906653134965588 -> 40.86413326392504  _ @double@	 lift : 71.77078639889064 : good	 :) hit 

[Prob_ROI diff: 0.2349569474520803 (up%-> 20.163454136118634) . o: 1.165261397506312 -> a: 1.4002183449583923	 returnMoney: o:12.229420803519242 a: 0.18382211572162577 (probReturnRate: 0.015031138324124685	 totalSpendMoney: o: 10.495002091110631 a: 0.13128103654940193 (probTotalSpendRate: 0.012508909994462816

[Time_ROI diff: 0.6922604810265877 (up%-> 96.63302410557498) . o: 0.7163808516126627 -> a: 1.4086413326392504	 returnMoney: o:1.014786E9 a: 811800.0 (timeReturnRate: 7.999716196321195E-4	 totalSpendMoney: o: 1.4165454E9 a: 576300.0 (timeTotalSpendRate: 4.068348250610252E-4

[[Per_Prob_ROI diff: 1.3987489106614108 (up%-> 95189.61912994208) . o: 0.001469434296981478 -> a: 1.4002183449583923	 per returnMoney: o:0.015421716019570292 a: 0.18382211572162577	 per totalSpendMoney: o: 0.013234554969874694 a: 0.13128103654940193

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -1.446920685784306
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -1.6818776332363863     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.2016345413611862 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Eight8, 	playerStartValue=9	@@@ 

net money diff:  1.0301658213959812 , up % -> 7457.684005711485 .  o: 0.013813481780764997 -> a: 1.0439793031767461 (anet/onet: 75.57684005711485

[ProbMatrix: total: o: 4.3760345516467196E-4  -> a: 0.032406469166128805
org->adv	$w:37.26328900905532->49.37570992741854  	$d:35.99549138645804->10.62534033423842  	$l:26.74121960448663->39.99894973834303
	 improve value x$w(high is good):12.11242091836322  	x$d:-25.370151052219622  	 x$l(negative is good):13.257730133856398
	 	 $w-$l: 10.52206940456869 -> 9.376760189075512  _ @double@	 lift : -1.1453092154931788 : bad	 :| stand

[TimeMatrix: total:  o: 1153.0 -> a: 2744140.0
org->adv	$w:66.08846487424111->32.73200346921075  	$d:8.586296617519515->3.6124979046258576  	$l:25.32523850823938->63.655498626163386
	 improve value x$w(high is good):-33.35646140503036  	x$d:-4.973798712893657  	 x$l(negative is good):38.330260117924006
	 	 $w-$l: 40.76322636600174 -> -30.923495156952637  _ #Surrender#	 lift : -71.68672152295437 : bad	 :| stand

[Prob_ROI diff: -0.005746745006596887 (up%-> -0.519963572665365) . o: 1.1052206940456852 -> a: 1.0994739490390883	 returnMoney: o:0.14509451833016662 a: 11.538981394292213 (probReturnRate: 79.52734208769307	 totalSpendMoney: o: 0.13128103654940163 a: 10.495002091115467 (probTotalSpendRate: 79.9430166531794

[Time_ROI diff: -0.691421607198683 (up%-> -49.11947708564889) . o: 1.4076322636600174 -> a: 0.7162106564613344	 returnMoney: o:486900.0 a: 6.089382E8 (timeReturnRate: 1250.6432532347505	 totalSpendMoney: o: 345900.0 a: 8.502222E8 (timeTotalSpendRate: 2458.0

[[Per_Prob_ROI diff: -1.1038342199611466 (up%-> -99.87455228697688) . o: 1.1052206940456852 -> a: 0.001386474084538573	 per returnMoney: o:0.14509451833016662 a: 0.014551048416509726	 per totalSpendMoney: o: 0.13128103654940163 a: 0.013234554969880791

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.0244190763893843
 按net净收益值(代表少输多赢) :  $Change$  Value: 1.0301658213959812     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9948003642733465 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Nine9, 	playerStartValue=9	@@@ 

net money diff:  0.39261589395544866 , up % -> 94.21750280047526 .  o: -0.416712269255207 -> a: -0.02409637529975832 (anet/onet: 0.05782497199524735

[ProbMatrix: total: o: 0.0324064691661383  -> a: 4.3760345516467207E-4
org->adv	$w:38.9220124343768->34.955174809922354  	$d:16.986896951425063->11.734847635517626  	$l:44.091090614198144->53.30997755456003
	 improve value x$w(high is good):-3.966837624454449  	x$d:-5.252049315907437  	 x$l(negative is good):9.218886940361884
	 	 $w-$l: -5.169078179821341 -> -18.35480274463767  _ #Surrender#	 lift : -13.185724564816331 : bad	 :| stand

[TimeMatrix: total:  o: 1830220.0 -> a: 769.0
org->adv	$w:32.70120531957907->66.05981794538361  	$d:3.6181442668094546->8.322496749024708  	$l:63.68065041361148->25.617685305591674
	 improve value x$w(high is good):33.35861262580455  	x$d:4.704352482215254  	 x$l(negative is good):-38.06296510801981
	 	 $w-$l: -30.979445094032414 -> 40.442132639791936  _ @double@	 lift : 71.42157773382436 : good	 :) hit 

[Prob_ROI diff: -0.1438422450523138 (up%-> -14.978976486073186) . o: 0.9602942176059371 -> a: 0.8164519725536233	 returnMoney: o:10.078289821863828 a: 0.10718466124964314 (probReturnRate: 0.010635203307719616	 totalSpendMoney: o: 10.495002091119035 a: 0.13128103654940146 (probTotalSpendRate: 0.012508909994452755

[Time_ROI diff: 0.6887803525760737 (up%-> 96.24663452368806) . o: 0.7156409738218455 -> a: 1.4044213263979193	 returnMoney: o:4.058118E8 a: 324000.0 (timeReturnRate: 7.983996522525959E-4	 totalSpendMoney: o: 5.670606E8 a: 230700.0 (timeTotalSpendRate: 4.068348250610252E-4

[[Per_Prob_ROI diff: 0.8152410088492023 (up%-> 67321.67164654397) . o: 0.001210963704421106 -> a: 0.8164519725536233	 per returnMoney: o:0.012709066610168763 a: 0.10718466124964314	 per totalSpendMoney: o: 0.013234554969885291 a: 0.13128103654940146

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.24877364890313486
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.39261589395544866     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.850210235139268 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Ten, 	playerStartValue=9	@@@ 

net money diff:  2.0208428857003518 , up % -> 98.4675742266947 .  o: -2.052292748725497 -> a: -0.03144986302514555 (anet/onet: 0.01532425773305312

[ProbMatrix: total: o: 0.0324064691661385  -> a: 4.376034551646722E-4
org->adv	$w:33.74931136878756->32.43849443867282  	$d:11.16260697024685->11.166875604703378  	$l:55.08808166096559->56.39462995662381
	 improve value x$w(high is good):-1.3108169301147399  	x$d:0.00426863445652792  	 x$l(negative is good):1.3065482956582173
	 	 $w-$l: -21.338770292178033 -> -23.956135517950994  _ #Surrender#	 lift : -2.6173652257729607 : bad	 :| stand

[TimeMatrix: total:  o: 916300.0 -> a: 385.0
org->adv	$w:32.66070064389392->65.97402597402598  	$d:3.619993451926225->8.311688311688311  	$l:63.719305904179855->25.71428571428571
	 improve value x$w(high is good):33.31332533013206  	x$d:4.691694859762086  	 x$l(negative is good):-38.00502018989414
	 	 $w-$l: -31.058605260285937 -> 40.25974025974026  _ @double@	 lift : 71.3183455200262 : good	 :) hit 

[Prob_ROI diff: -0.04401182303967044 (up%-> -5.471042009179509) . o: 0.8044504678601596 -> a: 0.7604386448204892	 returnMoney: o:8.442709342396217 a: 0.09983117352425608 (probReturnRate: 0.011824542273762785	 totalSpendMoney: o: 10.495002091121714 a: 0.13128103654940163 (probTotalSpendRate: 0.012508909994449577

[Time_ROI diff: 0.6877431762704342 (up%-> 96.20747152942847) . o: 0.7148542263269684 -> a: 1.4025974025974026	 returnMoney: o:2.029464E8 a: 162000.0 (timeReturnRate: 7.982403235534111E-4	 totalSpendMoney: o: 2.83899E8 a: 115500.0 (timeTotalSpendRate: 4.068348250610252E-4

[[Per_Prob_ROI diff: 0.7594242053906529 (up%-> 74861.46368672066) . o: 0.0010144394298362668 -> a: 0.7604386448204892	 per returnMoney: o:0.01064654393744794 a: 0.09983117352425608	 per totalSpendMoney: o: 0.013234554969888668 a: 0.13128103654940163

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.976831062660681
 按net净收益值(代表少输多赢) :  $Change$  Value: 2.0208428857003518     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9452895799082048 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

		 */
	}
	
	public static void test99vs7() {
		StrategyMatrix8012 o = new Myth2019April22();
		StrategyMatrix8012 t = new MirMyth2019April22();
		
		System.out.println(o.diffWith(t));
		
		for(Card playerCard : Card.values()) {
			if(playerCard.getValue() == 9) {
				for(Card dealerCard : Card.values()) {
					if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
					if(dealerCard != Card.Seven7) continue;
					PlayerCardsPathValue nine = new PlayerCardsPathValue(playerCard,playerCard);
					Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, nine, dealerCard); 
//					HelloWorld.print(origin);
					PlayerCardsPathValue ninet = new PlayerCardsPathValue(playerCard,playerCard);
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
MatrixKey [startValue=Nine, dealerCard=Seven7, situation=Start_With_Pair] : Stand -> Split
MatrixKey [startValue=Nine, dealerCard=Seven7, situation=Splited_Pair_And_Can_Split] : Stand -> Split

		 @@@   dealerCard=Seven7, 	playerStartValue=9	@@@ 

net money diff:  1.6818776332363863 , up % -> 3201.071732317065 .  o: 0.05254107917222384 -> a: 1.7344187124086101 (anet/onet: 33.01071732317065

[ProbMatrix: total: o: 4.376034551646725E-4  -> a: 0.032406469166116246
org->adv	$w:63.11437111287409->53.049754413466154  	$d:13.793092270091043->9.919990486014141  	$l:23.092536617034863->37.0302551005197
	 improve value x$w(high is good):-10.064616699407935  	x$d:-3.8731017840769013  	 x$l(negative is good):13.93771848348484
	 	 $w-$l: 40.02183449583923 -> 16.01949931294645  _ @double@	 lift : -24.002335182892775 : bad	 :| stand

[TimeMatrix: total:  o: 1921.0 -> a: 4571980.0
org->adv	$w:66.26756897449245->32.74065065901426  	$d:8.328995314940135->3.6120455470058923  	$l:25.40343571056741->63.647303793979844
	 improve value x$w(high is good):-33.52691831547819  	x$d:-4.716949767934243  	 x$l(negative is good):38.24386808341244
	 	 $w-$l: 40.86413326392504 -> -30.906653134965588  _ #Surrender#	 lift : -71.77078639889064 : bad	 :| stand

[Prob_ROI diff: -0.2349569474520803 (up%-> -16.780022079989394) . o: 1.4002183449583923 -> a: 1.165261397506312	 returnMoney: o:0.18382211572162577 a: 12.229420803519242 (probReturnRate: 66.5285608073355	 totalSpendMoney: o: 0.13128103654940193 a: 10.495002091110631 (probTotalSpendRate: 79.94301665314238

[Time_ROI diff: -0.6922604810265877 (up%-> -49.143842721806166) . o: 1.4086413326392504 -> a: 0.7163808516126627	 returnMoney: o:811800.0 a: 1.014786E9 (timeReturnRate: 1250.0443458980044	 totalSpendMoney: o: 576300.0 a: 1.4165454E9 (timeTotalSpendRate: 2458.0

[[Per_Prob_ROI diff: -1.3987489106614108 (up%-> -99.89505677437579) . o: 1.4002183449583923 -> a: 0.001469434296981478	 per returnMoney: o:0.18382211572162577 a: 0.015421716019570292	 per totalSpendMoney: o: 0.13128103654940193 a: 0.013234554969874694

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.446920685784306

 按net净收益值(代表少输多赢) :  $Change$  Value: 1.6818776332363863     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.8321997792001061 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

		 */
		
	}
	
	public static void testTTvsAll() {
		StrategyMatrix8012 o = new Myth2019April22();
		StrategyMatrix8012 t = new MirMyth2019April22();
		
		System.out.println(t.diffWith(o));
		
		for(Card playerCard : Card.values()) {
			if(playerCard == Card.Ten) {
				for(Card dealerCard : Card.values()) {
					if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
					PlayerCardsPathValue nine = new PlayerCardsPathValue(playerCard,playerCard);
					Collection<PlayerCardsPathValue> origin = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),t, nine, dealerCard); 
//					HelloWorld.print(origin);
					PlayerCardsPathValue ninet = new PlayerCardsPathValue(playerCard,playerCard);
					Collection<PlayerCardsPathValue> advanced = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(),o, ninet, dealerCard); 
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
MatrixKey [startValue=Ten, dealerCard=One1, situation=Splited_Pair_And_Can_Split] : Split -> Stand
MatrixKey [startValue=Ten, dealerCard=One1, situation=Start_With_Pair] : Split -> Stand
MatrixKey [startValue=Ten, dealerCard=Two2, situation=Splited_Pair_And_Can_Split] : Split -> Stand
MatrixKey [startValue=Ten, dealerCard=Two2, situation=Start_With_Pair] : Split -> Stand
MatrixKey [startValue=Ten, dealerCard=Three3, situation=Start_With_Pair] : Split -> Stand
MatrixKey [startValue=Ten, dealerCard=Three3, situation=Splited_Pair_And_Can_Split] : Split -> Stand
MatrixKey [startValue=Ten, dealerCard=Four4, situation=Start_With_Pair] : Split -> Stand
MatrixKey [startValue=Ten, dealerCard=Four4, situation=Splited_Pair_And_Can_Split] : Split -> Stand
MatrixKey [startValue=Ten, dealerCard=Five5, situation=Splited_Pair_And_Can_Split] : Split -> Stand
MatrixKey [startValue=Ten, dealerCard=Five5, situation=Start_With_Pair] : Split -> Stand
MatrixKey [startValue=Ten, dealerCard=Six6, situation=Splited_Pair_And_Can_Split] : Split -> Stand
MatrixKey [startValue=Ten, dealerCard=Six6, situation=Start_With_Pair] : Split -> Stand
MatrixKey [startValue=Ten, dealerCard=Seven7, situation=Start_With_Pair] : Split -> Stand
MatrixKey [startValue=Ten, dealerCard=Seven7, situation=Splited_Pair_And_Can_Split] : Split -> Stand
MatrixKey [startValue=Ten, dealerCard=Eight8, situation=Start_With_Pair] : Split -> Stand
MatrixKey [startValue=Ten, dealerCard=Eight8, situation=Splited_Pair_And_Can_Split] : Split -> Stand
MatrixKey [startValue=Ten, dealerCard=Nine9, situation=Start_With_Pair] : Split -> Stand
MatrixKey [startValue=Ten, dealerCard=Nine9, situation=Splited_Pair_And_Can_Split] : Split -> Stand
MatrixKey [startValue=Ten, dealerCard=Ten, situation=Start_With_Pair] : Split -> Stand
MatrixKey [startValue=Ten, dealerCard=Ten, situation=Splited_Pair_And_Can_Split] : Split -> Stand


		 @@@   dealerCard=One1, 	playerStartValue=10	@@@ 

net money diff:  6.676494617394006 , up % -> 100.28537724979907 .  o: -6.6574956394327 -> a: 0.018998977961306174 (anet/onet: -0.002853772497990719

[ProbMatrix: total: o: 0.09527259381047734  -> a: 4.376034551646734E-4
org->adv	$w:31.90417662938306->50.69051023665497  	$d:12.898849467988653->13.090969130580724  	$l:55.19697390262829->36.21852063276431
	 improve value x$w(high is good):18.786333607271914  	x$d:0.1921196625920718  	 x$l(negative is good):-18.978453269863977
	 	 $w-$l: -23.29279727324523 -> 14.47198960389066  _ @double@	 lift : 37.76478687713589 : good	 :) hit 

[TimeMatrix: total:  o: 9.8354698E7 -> a: 14209.0
org->adv	$w:31.75045893588123->83.31339291998029  	$d:3.5240939888809377->8.332746850587656  	$l:64.72544707523782->8.35386022943205
	 improve value x$w(high is good):51.56293398409906  	x$d:4.808652861706718  	 x$l(negative is good):-56.37158684580577
	 	 $w-$l: -32.9749881393566 -> 74.95953269054823  _ @double@	 lift : 107.93452082990483 : good	 :) hit 

[Prob_ROI diff: 0.3776478687524646 (up%-> 49.23238696220355) . o: 0.7670720272864092 -> a: 1.1447198960388738	 returnMoney: o:21.924282503713652 a: 0.15028001451071596 (probReturnRate: 0.006854500916290453	 totalSpendMoney: o: 28.58177814314635 a: 0.13128103654940979 (probTotalSpendRate: 0.004593172471352688

[Time_ROI diff: 1.0793452082990485 (up%-> 161.03618311074587) . o: 0.670250118606434 -> a: 1.7495953269054825	 returnMoney: o:1.97766744E10 a: 7458000.0 (timeReturnRate: 3.771109261929296E-4	 totalSpendMoney: o: 2.95064094E10 a: 4262700.0 (timeTotalSpendRate: 1.444669170759896E-4

[[Per_Prob_ROI diff: 1.1443205873312807 (up%-> 286575.4153543931) . o: 3.9930870759313336E-4 -> a: 1.1447198960388738	 per returnMoney: o:0.011412952891053436 a: 0.15028001451071596	 per totalSpendMoney: o: 0.01487859351543277 a: 0.13128103654940979

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 7.05414248614647

 按net净收益值(代表少输多赢) :  $Change$  Value: 6.676494617394006     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.4923238696220358 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Two2, 	playerStartValue=10	@@@ 

net money diff:  -4.532466218659166 , up % -> -98.18236142058724 .  o: 4.616375235917662 -> a: 0.08390901725849578 (anet/onet: 0.0181763857941275

[ProbMatrix: total: o: 0.0952725938097628  -> a: 4.3760345516469527E-4
org->adv	$w:54.06042160073705->75.75683872407993  	$d:8.030619498524045->12.40188832124764  	$l:37.908958900738895->11.841272954672425
	 improve value x$w(high is good):21.696417123342876  	x$d:4.371268822723595  	 x$l(negative is good):-26.06768594606647
	 	 $w-$l: 16.151462699998152 -> 63.9155657694075  _ @double@	 lift : 47.764103069409344 : good	 :) hit 

[TimeMatrix: total:  o: 1.1796538E7 -> a: 26689.0
org->adv	$w:57.95417265641834->83.07917119412492  	$d:4.301431487780567->8.430439506912961  	$l:37.74439585580108->8.49038929896212
	 improve value x$w(high is good):25.12499853770658  	x$d:4.129008019132394  	 x$l(negative is good):-29.25400655683896
	 	 $w-$l: 20.209776800617263 -> 74.58878189516281  _ @double@	 lift : 54.37900509454554 : good	 :) hit 

[Prob_ROI diff: 0.4776410306882255 (up%-> 41.12225705839818) . o: 1.1615146270058136 -> a: 1.6391556576940391	 returnMoney: o:33.19815337884399 a: 0.21519005380790962 (probReturnRate: 0.00648198866220802	 totalSpendMoney: o: 28.58177814292633 a: 0.13128103654941384 (probTotalSpendRate: 0.004593172471388188

[Time_ROI diff: 0.5437900509454554 (up%-> 45.23675739348541) . o: 1.2020977680061726 -> a: 1.745887818951628	 returnMoney: o:4.2541776E9 a: 1.39788E7 (timeReturnRate: 0.003285899488540394	 totalSpendMoney: o: 3.5389614E9 a: 8006700.0 (timeTotalSpendRate: 0.0022624434389140274

[[Per_Prob_ROI diff: 1.6295563632559746 (up%-> 16975.793104066182) . o: 0.009599294438064574 -> a: 1.6391556576940391	 per returnMoney: o:0.27436490395738833 a: 0.21519005380790962	 per totalSpendMoney: o: 0.23621304250352337 a: 0.13128103654941384

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -4.054825187970941

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -4.532466218659166     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.4112225705839818 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Three3, 	playerStartValue=10	@@@ 

net money diff:  -5.2325159445099665 , up % -> -98.39698878443205 .  o: 5.31776023753466 -> a: 0.08524429302469377 (anet/onet: 0.01603011215567956

[ProbMatrix: total: o: 0.09527259380988268  -> a: 4.376034551646863E-4
org->adv	$w:55.408403985124586->76.42546867657364  	$d:7.788613326109315->12.081740865472332  	$l:36.80298268876611->11.492790457954014
	 improve value x$w(high is good):21.017064691449058  	x$d:4.293127539363017  	 x$l(negative is good):-25.310192230812092
	 	 $w-$l: 18.605421296358482 -> 64.93267821861963  _ @double@	 lift : 46.32725692226115 : good	 :) hit 

[TimeMatrix: total:  o: 6874426.0 -> a: 15553.0
org->adv	$w:57.938190039430204->83.06436057352279  	$d:4.3038356947911->8.43567157461583  	$l:37.7579742657787->8.499967851861378
	 improve value x$w(high is good):25.126170534092587  	x$d:4.13183587982473  	 x$l(negative is good):-29.25800641391732
	 	 $w-$l: 20.180215773651504 -> 74.5643927216614  _ @double@	 lift : 54.3841769480099 : good	 :) hit 

[Prob_ROI diff: 0.46327256922126825 (up%-> 39.059982600894294) . o: 1.1860542129649116 -> a: 1.64932678218618	 returnMoney: o:33.89953838054046 a: 0.2165253295741024 (probReturnRate: 0.006387264839523467	 totalSpendMoney: o: 28.581778143005803 a: 0.13128103654940862 (probTotalSpendRate: 0.004593172471375234

[Time_ROI diff: 0.5438417694800992 (up%-> 45.25218780638368) . o: 1.201802157736515 -> a: 1.7456439272166142	 returnMoney: o:2.47851E9 a: 8145000.0 (timeReturnRate: 0.003286248592904608	 totalSpendMoney: o: 2.0623278E9 a: 4665900.0 (timeTotalSpendRate: 0.0022624434389140274

[[Per_Prob_ROI diff: 1.6395246812525857 (up%-> 16726.25789470821) . o: 0.009802100933594312 -> a: 1.64932678218618	 per returnMoney: o:0.2801614742193427 a: 0.2165253295741024	 per totalSpendMoney: o: 0.23621304250418018 a: 0.13128103654940862

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -4.769243375288698

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -5.2325159445099665     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.390599826008943 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Four4, 	playerStartValue=10	@@@ 

net money diff:  -5.961577987098808 , up % -> -98.56779030731794 .  o: 6.048200906717703 -> a: 0.08662291961889479 (anet/onet: 0.014322096926820535

[ProbMatrix: total: o: 0.09527259381006113  -> a: 4.376034551646813E-4
org->adv	$w:57.01200840908028->77.1693722201423  	$d:7.137021086693338->11.644067621301362  	$l:35.85097050422638->11.186560158556336
	 improve value x$w(high is good):20.157363811062012  	x$d:4.507046534608024  	 x$l(negative is good):-24.664410345670046
	 	 $w-$l: 21.161037904853902 -> 65.98281206158596  _ @double@	 lift : 44.82177415673206 : good	 :) hit 

[TimeMatrix: total:  o: 2050498.0 -> a: 9073.0
org->adv	$w:69.70726135797256->83.04860575333407  	$d:5.069987876115949->8.44263198501047  	$l:25.2227507659115->8.50876226165546
	 improve value x$w(high is good):13.341344395361517  	x$d:3.372644108894521  	 x$l(negative is good):-16.713988504256037
	 	 $w-$l: 44.48451059206105 -> 74.53984349167861  _ @double@	 lift : 30.055332899617564 : good	 :) hit 

[Prob_ROI diff: 0.44821774156762006 (up%-> 36.99355414235659) . o: 1.2116103790482333 -> a: 1.6598281206158534	 returnMoney: o:34.629979049741166 a: 0.21790395616829938 (probReturnRate: 0.0062923502164211696	 totalSpendMoney: o: 28.581778143023463 a: 0.1312810365494046 (probTotalSpendRate: 0.004593172471372256

[Time_ROI diff: 0.3005533289961757 (up%-> 20.80176814556689) . o: 1.4448451059206104 -> a: 1.7453984349167861	 returnMoney: o:8.887956E8 a: 4750800.0 (timeReturnRate: 0.0053452109798923396	 totalSpendMoney: o: 6.151494E8 a: 2721900.0 (timeTotalSpendRate: 0.004424778761061947

[[Per_Prob_ROI diff: 1.6399656553855544 (up%-> 8256.606802683753) . o: 0.019862465230298904 -> a: 1.6598281206158534	 per returnMoney: o:0.5677045745859207 a: 0.21790395616829938	 per totalSpendMoney: o: 0.46855374004956496 a: 0.1312810365494046

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -5.513360245531189

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -5.961577987098808     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.3699355414235659 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Five5, 	playerStartValue=10	@@@ 

net money diff:  -6.779099897268871 , up % -> -98.71475491894495 .  o: 6.867362333863074 -> a: 0.0882624365942033 (anet/onet: 0.012852450810550625

[ProbMatrix: total: o: 0.09527259381008923  -> a: 4.3760345516467603E-4
org->adv	$w:58.58136316178542->78.02619008976855  	$d:6.864338401082354->11.179292356038284  	$l:34.554298437132225->10.794517554193154
	 improve value x$w(high is good):19.44482692798313  	x$d:4.3149539549559295  	 x$l(negative is good):-23.75978088293907
	 	 $w-$l: 24.02706472465319 -> 67.2316725355754  _ @double@	 lift : 43.20460781092221 : good	 :) hit 

[TimeMatrix: total:  o: 1236898.0 -> a: 5473.0
org->adv	$w:69.6964503136071->83.04403435044765  	$d:5.0710729583199265->8.441439795359035  	$l:25.23247672807297->8.514525854193312
	 improve value x$w(high is good):13.347584036840544  	x$d:3.370366837039108  	 x$l(negative is good):-16.71795087387966
	 	 $w-$l: 44.463973585534134 -> 74.52950849625434  _ @double@	 lift : 30.065534910720203 : good	 :) hit 

[Prob_ROI diff: 0.43204607810997664 (up%-> 34.834822469547674) . o: 1.240270647245778 -> a: 1.6723167253557547	 returnMoney: o:35.44914047690148 a: 0.2195434731436056 (probReturnRate: 0.006193195947491568	 totalSpendMoney: o: 28.58177814303841 a: 0.1312810365494023 (probTotalSpendRate: 0.004593172471369773

[Time_ROI diff: 0.30065534910720215 (up%-> 20.811787302056338) . o: 1.4446397358553413 -> a: 1.7452950849625435	 returnMoney: o:5.360616E8 a: 2865600.0 (timeReturnRate: 0.005345654305400723	 totalSpendMoney: o: 3.710694E8 a: 1641900.0 (timeTotalSpendRate: 0.004424778761061947

[[Per_Prob_ROI diff: 1.651984419663201 (up%-> 8124.924170642407) . o: 0.020332305692553742 -> a: 1.6723167253557547	 per returnMoney: o:0.581133450441008 a: 0.2195434731436056	 per totalSpendMoney: o: 0.46855374004981 a: 0.1312810365494023

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -6.347053819158894

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -6.779099897268871     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.3483482246954768 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Six6, 	playerStartValue=10	@@@ 

net money diff:  -7.578382322095427 , up % -> -98.79532044253546 .  o: 7.670790770402341 -> a: 0.09240844830691444 (anet/onet: 0.012046795574645497

[ProbMatrix: total: o: 0.0952725938100787  -> a: 4.3760345516467413E-4
org->adv	$w:60.104799262859096->80.11734977484785  	$d:6.628447490953302->10.155092255566558  	$l:33.2667532461876->9.727557969585595
	 improve value x$w(high is good):20.012550511988756  	x$d:3.5266447646132555  	 x$l(negative is good):-23.539195276602
	 	 $w-$l: 26.838046016671502 -> 70.38979180526225  _ @double@	 lift : 43.55174578859074 : good	 :) hit 

[TimeMatrix: total:  o: 702634.0 -> a: 3109.0
org->adv	$w:69.68037413504044->83.01704728208426  	$d:5.075188504968447->8.459311675779993  	$l:25.244437359991117->8.523641042135734
	 improve value x$w(high is good):13.336673147043825  	x$d:3.384123170811546  	 x$l(negative is good):-16.72079631785538
	 	 $w-$l: 44.43593677504932 -> 74.49340623994854  _ @double@	 lift : 30.057469464899217 : good	 :) hit 

[Prob_ROI diff: 0.4355174578861529 (up%-> 34.336500093118275) . o: 1.268380460166467 -> a: 1.70389791805262	 returnMoney: o:36.25256891343263 a: 0.2236894848563171 (probReturnRate: 0.006170307141280507	 totalSpendMoney: o: 28.58177814303029 a: 0.13128103654940265 (probTotalSpendRate: 0.00459317247137109

[Time_ROI diff: 0.3005746946489922 (up%-> 20.81024302955296) . o: 1.4443593677504931 -> a: 1.7449340623994853	 returnMoney: o:3.044568E8 a: 1627500.0 (timeReturnRate: 0.005345585974758981	 totalSpendMoney: o: 2.107902E8 a: 932700.0 (timeTotalSpendRate: 0.004424778761061947

[[Per_Prob_ROI diff: 1.683104795754809 (up%-> 8094.5265056802145) . o: 0.020793122297810936 -> a: 1.70389791805262	 per returnMoney: o:0.5943044084169284 a: 0.2236894848563171	 per totalSpendMoney: o: 0.4685537400496769 a: 0.13128103654940265

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -7.142864864209274

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -7.578382322095427     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.3433650009311826 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Seven7, 	playerStartValue=10	@@@ 

net money diff:  -6.643455395336583 , up % -> -98.4941434260503 .  o: 6.745025809909713 -> a: 0.10157041457312913 (anet/onet: 0.015058565739496958

[ProbMatrix: total: o: 0.09527259381011183  -> a: 4.376034551646723E-4
org->adv	$w:56.71761208120763->84.75026480605469  	$d:10.163817773363249->7.868157627732495  	$l:33.11857014542911->7.381577566212813
	 improve value x$w(high is good):28.032652724847054  	x$d:-2.2956601456307535  	 x$l(negative is good):-25.7369925792163
	 	 $w-$l: 23.599041935778526 -> 77.36868723984188  _ @double@	 lift : 53.76964530406334 : good	 :) hit 

[TimeMatrix: total:  o: 1.3297162E7 -> a: 1921.0
org->adv	$w:31.601765850487496->83.02967204580948  	$d:3.569092412350846->8.433107756376886  	$l:64.82914173716165->8.537220197813639
	 improve value x$w(high is good):51.42790619532198  	x$d:4.86401534402604  	 x$l(negative is good):-56.29192153934801
	 	 $w-$l: -33.22737588667416 -> 74.49245184799584  _ @double@	 lift : 107.71982773466999 : good	 :) hit 

[Prob_ROI diff: 0.5376964530427368 (up%-> 43.5032864836474) . o: 1.235990419355681 -> a: 1.7736868723984178	 returnMoney: o:35.326803952961015 a: 0.232851451122531 (probReturnRate: 0.0065913534502747995	 totalSpendMoney: o: 28.581778143051302 a: 0.13128103654940187 (probTotalSpendRate: 0.004593172471367687

[Time_ROI diff: 1.0771982773467 (up%-> 161.32334046337456) . o: 0.6677262411332584 -> a: 1.7449245184799584	 returnMoney: o:2.6636592E9 a: 1005600.0 (timeReturnRate: 3.775257735674293E-4	 totalSpendMoney: o: 3.9891486E9 a: 576300.0 (timeTotalSpendRate: 1.444669170759896E-4

[[Per_Prob_ROI diff: 1.77304346249766 (up%-> 275569.8133350867) . o: 6.434099007577725E-4 -> a: 1.7736868723984178	 per returnMoney: o:0.018389799038501308 a: 0.232851451122531	 per totalSpendMoney: o: 0.01487859351538329 a: 0.13128103654940187

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -6.105758942293846

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -6.643455395336583     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.4350328648364743 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Eight8, 	playerStartValue=10	@@@ 

net money diff:  -4.8331333238906895 , up % -> -97.89443281329986 .  o: 4.937087007908037 -> a: 0.10395368401734734 (anet/onet: 0.021055671867001392

[ProbMatrix: total: o: 0.09527259381005804  -> a: 4.3760345516467207E-4
org->adv	$w:53.54338865448034->86.1310971755722  	$d:10.18677013529546->6.92188794259143  	$l:36.26984121022419->6.947014881836383
	 improve value x$w(high is good):32.587708521091855  	x$d:-3.2648821927040297  	 x$l(negative is good):-29.322826328387812
	 	 $w-$l: 17.27354744425615 -> 79.18408229373581  _ @double@	 lift : 61.91053484947966 : good	 :) hit 

[TimeMatrix: total:  o: 7981066.0 -> a: 1153.0
org->adv	$w:31.59224594809766->83.00086730268865  	$d:3.571202142671167->8.49956634865568  	$l:64.83655190923118->8.49956634865568
	 improve value x$w(high is good):51.40862135459099  	x$d:4.928364205984513  	 x$l(negative is good):-56.3369855605755
	 	 $w-$l: -33.24430596113352 -> 74.50130095403296  _ @double@	 lift : 107.74560691516648 : good	 :) hit 

[Prob_ROI diff: 0.6191053484962252 (up%-> 52.79155973270611) . o: 1.1727354744411331 -> a: 1.7918408229373584	 returnMoney: o:33.51886515094118 a: 0.23523472056674863 (probReturnRate: 0.0070179798602204	 totalSpendMoney: o: 28.581778143033144 a: 0.1312810365494013 (probTotalSpendRate: 0.0045931724713705845

[Time_ROI diff: 1.0774560691516646 (up%-> 161.40287127032914) . o: 0.6675569403886649 -> a: 1.7450130095403296	 returnMoney: o:1.5983448E9 a: 603600.0 (timeReturnRate: 3.7764066927236224E-4	 totalSpendMoney: o: 2.3943198E9 a: 345900.0 (timeTotalSpendRate: 1.444669170759896E-4

[[Per_Prob_ROI diff: 1.7912303411703405 (up%-> 293412.5862465285) . o: 6.104817670177683E-4 -> a: 1.7918408229373584	 per returnMoney: o:0.017448654425268703 a: 0.23523472056674863	 per totalSpendMoney: o: 0.014878593515373838 a: 0.1312810365494013

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -4.2140279753944645

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -4.8331333238906895     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.527915597327061 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Nine9, 	playerStartValue=10	@@@ 

net money diff:  -2.4444263785259177 , up % -> -96.08891548519789 .  o: 2.543921290174694 -> a: 0.09949491164877633 (anet/onet: 0.03911084514802103

[ProbMatrix: total: o: 0.09527259381006535  -> a: 4.3760345516467267E-4
org->adv	$w:48.76953403953514->81.87544312368968  	$d:11.36143236378416->12.036839279403868  	$l:39.869033596680694->6.087717596906455
	 improve value x$w(high is good):33.10590908415454  	x$d:0.6754069156197069  	 x$l(negative is good):-33.781315999774236
	 	 $w-$l: 8.900500442854442 -> 75.7877255267832  _ @double@	 lift : 66.88722508392877 : good	 :) hit 

[TimeMatrix: total:  o: 5323018.0 -> a: 769.0
org->adv	$w:31.564988132672106->83.09492847854357  	$d:3.572108905136146->8.322496749024708  	$l:64.86290296219175->8.58257477243173
	 improve value x$w(high is good):51.52994034587146  	x$d:4.7503878438885625  	 x$l(negative is good):-56.28032818976003
	 	 $w-$l: -33.29791482951964 -> 74.51235370611184  _ @double@	 lift : 107.81026853563147 : good	 :) hit 

[Prob_ROI diff: 0.6688722508400451 (up%-> 61.42049376453523) . o: 1.0890050044277864 -> a: 1.7578772552678315	 returnMoney: o:31.125699433208112 a: 0.2307759481981779 (probReturnRate: 0.007414321682743048	 totalSpendMoney: o: 28.581778143033418 a: 0.13128103654940157 (probTotalSpendRate: 0.00459317247137055

[Time_ROI diff: 1.078102685356315 (up%-> 161.6295326601633) . o: 0.6670208517048035 -> a: 1.7451235370611184	 returnMoney: o:1.0651692E9 a: 402600.0 (timeReturnRate: 3.779681199944572E-4	 totalSpendMoney: o: 1.5969054E9 a: 230700.0 (timeTotalSpendRate: 1.444669170759896E-4

[[Per_Prob_ROI diff: 1.7573103604190923 (up%-> 309988.76852167223) . o: 5.66894848739087E-4 -> a: 1.7578772552678315	 per returnMoney: o:0.016202862797089074 a: 0.2307759481981779	 per totalSpendMoney: o: 0.014878593515373982 a: 0.13128103654940157

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -1.7755541276858726

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -2.4444263785259177     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.6142049376453524 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Ten, 	playerStartValue=10	@@@ 

net money diff:  1.891517355894015 , up % -> 103.12057001757944 .  o: -1.834277443939225 -> a: 0.05723991195479003 (anet/onet: -0.031205700175794427

[ProbMatrix: total: o: 0.0952725938100721  -> a: 4.376034551646725E-4
org->adv	$w:38.868024540267875->54.79983065097892  	$d:15.8463045619314->34.0013898927062  	$l:45.28567089780072->11.198779456314883
	 improve value x$w(high is good):15.931806110711044  	x$d:18.155085330774803  	 x$l(negative is good):-34.08689144148584
	 	 $w-$l: -6.417646357532847 -> 43.60105119466404  _ @double@	 lift : 50.018697552196876 : good	 :) hit 

[TimeMatrix: total:  o: 2664970.0 -> a: 385.0
org->adv	$w:31.521405494245712->82.5974025974026  	$d:3.583454973226716->9.090909090909092  	$l:64.89513953252757->8.311688311688311
	 improve value x$w(high is good):51.075997103156894  	x$d:5.507454117682376  	 x$l(negative is good):-56.58345122083925
	 	 $w-$l: -33.37373403828185 -> 74.28571428571429  _ @double@	 lift : 107.65944832399614 : good	 :) hit 

[Prob_ROI diff: 0.5001869755228115 (up%-> 53.44885612027188) . o: 0.9358235364238273 -> a: 1.4360105119466389	 returnMoney: o:26.747500699103405 a: 0.18852094850419168 (probReturnRate: 0.007048170616947064	 totalSpendMoney: o: 28.58177814304263 a: 0.13128103654940165 (probTotalSpendRate: 0.004593172471369073

[Time_ROI diff: 1.0765944832399614 (up%-> 161.5870959748137) . o: 0.6662626596171815 -> a: 1.7428571428571429	 returnMoney: o:5.32671E8 a: 201300.0 (timeReturnRate: 3.7790681302342344E-4	 totalSpendMoney: o: 7.99491E8 a: 115500.0 (timeTotalSpendRate: 1.444669170759896E-4

[[Per_Prob_ROI diff: 1.4355233575809836 (up%-> 294675.2526070423) . o: 4.8715436565529793E-4 -> a: 1.4360105119466389	 per returnMoney: o:0.013923738000574391 a: 0.18852094850419168	 per totalSpendMoney: o: 0.014878593515378777 a: 0.13128103654940165

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 2.3917043314168267

 按net净收益值(代表少输多赢) :  $Change$  Value: 1.891517355894015     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.5344885612027188 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 */
	}

	public static void main(String[] args) {
//		test8vs6();
//		test9vs2();
//		test9vs3();
//		test9vs456();
//		test9vs7();
//		test11vs10();
//		test11vsEveryone();
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

		test22vsAll();
//		test33vsAll();
//		test44vsAll();
//		test44vs56();
//		test55vsAll();
//		test66vsAll();
//		test77vsAll();
//		test88vsAll();
//		test99vsAll();
//		test99vs7();
//		testTTvsAll();
	}

}
