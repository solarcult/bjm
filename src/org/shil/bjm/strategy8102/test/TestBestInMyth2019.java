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

		DealerVSPlayerResult9102 result = new DealerVSPlayerResult9102(dealerCard, nine.getValue(), RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), origin),RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), advanced));
		
		System.out.println(result);
		
		/**
MatrixKey [startValue=Eight, dealerCard=Six6, situation=Start_Hand_WithoutA_WithoutPair] : Hit -> Double
MatrixKey [startValue=Eight, dealerCard=Six6, situation=Splited_Pair_And_Can_NOT_Split] : Hit -> Double

		 @@@   dealerCard=Six6, 	playerStartValue=8	@@@ 

net money diff:  -0.003657732546429149 , up % -> -23.129611590800305 .  o: 0.01581406817866321 -> a: 0.012156335632234061 (anet/onet: 0.768703884091997

[ProbMatrix: total: o: 4.5662969234567407E-4  -> a: 4.566296923457654E-4
org->adv	$w:52.55878911057161->49.520757329415545  	$d:6.426471909439435->5.395463427934745  	$l:41.01473897998895->45.08377924264971
	 improve value x$w(high is good):-3.0380317811560644  	x$d:-1.0310084815046903  	 x$l(negative is good):4.069040262660764
	 	 $w-$l: 11.544050130582667 -> 4.43697808676583  _ @double@	 lift : -7.107072043816837 : bad	 :| stand

[TimeMatrix: total:  o: 115033.0 -> a: 40417.0
org->adv	$w:68.53598532594994->61.74629487591855  	$d:5.012474681178444->3.8696588069376743  	$l:26.45153999287161->34.38404631714377
	 improve value x$w(high is good):-6.789690450031387  	x$d:-1.1428158742407701  	 x$l(negative is good):7.932506324272161
	 	 $w-$l: 42.084445333078335 -> 27.362248558774777  _ @double@	 lift : -14.722196774303558 : bad	 :| stand

[Prob_ROI diff: -0.0710707204382055 (up%-> -6.3715384509528254) . o: 1.1154405013058863 -> a: 1.0443697808676808	 returnMoney: o:0.15280297588238304 a: 0.28613415103967493 (probReturnRate: 1.8725692309809518	 totalSpendMoney: o: 0.13698890770371983 a: 0.2739778154074409 (probTotalSpendRate: 2.000000000000009

[Time_ROI diff: -0.14722196774303553 (up%-> -10.361582325068284) . o: 1.4208444533307834 -> a: 1.2736224855877478	 returnMoney: o:4.90332E7 a: 3.08856E7 (timeReturnRate: 0.6298915836616823	 totalSpendMoney: o: 3.45099E7 a: 2.42502E7 (timeTotalSpendRate: 0.7027027027027027

[[Per_Prob_ROI diff: 0.05018909641398684 (up%-> 166.48100594728814) . o: 0.030147040575834762 -> a: 0.0803361369898216	 per returnMoney: o:0.004129810158983325 a: 0.022010319310744226	 per totalSpendMoney: o: 0.003702402910911347 a: 0.021075216569803143

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.07472845298463465

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.003657732546429149     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9362846154904718 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

	*/	
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
	
	public static void test11vsEveryone() {
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
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
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
		
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
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
		
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
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
		
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
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
		
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
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
		
		System.out.println(o.diffWith(t));
		
		for(Card playerCard : Card.values()) {
			if(playerCard.getValue() == 2) {
				for(Card dealerCard : Card.values()) {
					if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
					if(dealerCard != Card.Seven7 && dealerCard != Card.Four4) continue;
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
MatrixKey [startValue=Two, dealerCard=One1, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Two, dealerCard=One1, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Two, dealerCard=Two2, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Two, dealerCard=Two2, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Two, dealerCard=Three3, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Two, dealerCard=Three3, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Two, dealerCard=Four4, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Two, dealerCard=Four4, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Two, dealerCard=Five5, situation=Start_With_Pair] : Hit -> Split
MatrixKey [startValue=Two, dealerCard=Five5, situation=Splited_Pair_And_Can_Split] : Hit -> Split
MatrixKey [startValue=Two, dealerCard=Six6, situation=Splited_Pair_And_Can_Split] : Hit -> Split
MatrixKey [startValue=Two, dealerCard=Six6, situation=Start_With_Pair] : Hit -> Split
MatrixKey [startValue=Two, dealerCard=Seven7, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Two, dealerCard=Seven7, situation=Splited_Pair_And_Can_Split] : Split -> Hit
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

net money diff:  0.673802404712914 , up % -> 97.37752791821707 .  o: -0.6919485625870578 -> a: -0.01814615787414385 (anet/onet: 0.026224720817829263

[ProbMatrix: total: o: 0.03240646916527196  -> a: 4.376034551639181E-4
org->adv	$w:42.02860847897018->41.20997730662286  	$d:5.475731456269924->3.757669853927196  	$l:52.495660064759896->55.03235283944995
	 improve value x$w(high is good):-0.8186311723473167  	x$d:-1.7180616023427278  	 x$l(negative is good):2.536692774690053
	 	 $w-$l: -10.467051585789722 -> -13.822375532827092  _ #Surrender#	 lift : -3.3553239470373697 : bad	 :| stand

[TimeMatrix: total:  o: 1.86502732E8 -> a: 1.3477945E7
org->adv	$w:56.9896488165117->57.10990065622021  	$d:4.134120673363649->4.131431015633318  	$l:38.87623051012464->38.75866832814647
	 improve value x$w(high is good):0.12025183970850861  	x$d:-0.002689657730330808  	 x$l(negative is good):-0.11756218197817248
	 	 $w-$l: 18.113418306387064 -> 18.351232328073745  _ @double@	 lift : 0.23781402168668309 : good	 :) hit 

[Prob_ROI diff: -0.0768158153721682 (up%-> -8.184153546739402) . o: 0.9385920600520979 -> a: 0.8617762446799297	 returnMoney: o:10.576114869830644 a: 0.11313487867507079 (probReturnRate: 0.010697205927461945	 totalSpendMoney: o: 11.268063432417701 a: 0.13128103654921464 (probTotalSpendRate: 0.011650718629389777

[Time_ROI diff: -0.004045434722914187 (up%-> -0.3406516184707327) . o: 1.1875577580036518 -> a: 1.1835123232807376	 returnMoney: o:6.79281432E10 a: 4.7853942E9 (timeReturnRate: 0.07044788764371819	 totalSpendMoney: o: 5.71998648E10 a: 4.0433835E9 (timeTotalSpendRate: 0.07068868980963046

[[Per_Prob_ROI diff: 0.0012721553318522493 (up%-> 292.89909739702216) . o: 4.3433228137533455E-4 -> a: 0.0017064876132275838	 per returnMoney: o:0.004894083697283963 a: 2.2402946272291244E-4	 per totalSpendMoney: o: 0.0052142820140757525 a: 2.599624486123062E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.5969865893407458

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.673802404712914     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.918158464532606 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Three3, 	playerStartValue=2	@@@ 

net money diff:  0.34952685426376584 , up % -> 96.22553616318876 .  o: -0.3632371075293399 -> a: -0.013710253265574068 (anet/onet: 0.037744638368112336

[ProbMatrix: total: o: 0.032406469165605425  -> a: 4.3760345516432583E-4
org->adv	$w:43.39414104574539->42.96023150706212  	$d:5.22542734506559->3.6360992842894997  	$l:51.380431609189->53.40366920864839
	 improve value x$w(high is good):-0.43390953868327387  	x$d:-1.5893280607760905  	 x$l(negative is good):2.023237599459385
	 	 $w-$l: -7.98629056344361 -> -10.443437701586266  _ #Surrender#	 lift : -2.457147138142657 : bad	 :| stand

[TimeMatrix: total:  o: 1.05324916E8 -> a: 7854265.0
org->adv	$w:57.041678533121264->57.09385919624561  	$d:4.1340379516656816->4.133805009125615  	$l:38.82428351521306->38.77233579462877
	 improve value x$w(high is good):0.05218066312434644  	x$d:-2.3294254006689386E-4  	 x$l(negative is good):-0.05194772058428754
	 	 $w-$l: 18.217395017908206 -> 18.321523401616837  _ @double@	 lift : 0.10412838370862931 : good	 :) hit 

[Prob_ROI diff: -0.07426800016986068 (up%-> -7.657808349441461) . o: 0.9698336231576961 -> a: 0.8955656229878354	 returnMoney: o:11.677887666194012 a: 0.11757078328407744 (probReturnRate: 0.010067812488420298	 totalSpendMoney: o: 12.041124773723352 a: 0.1312810365496515 (probTotalSpendRate: 0.010902722047705917

[Time_ROI diff: -0.007440444662057288 (up%-> -0.6249031349111019) . o: 1.1906556786782256 -> a: 1.1832152340161683	 returnMoney: o:3.89216952E10 a: 2.7879858E9 (timeReturnRate: 0.0716306364785468	 totalSpendMoney: o: 3.26892954E10 a: 2.3562795E9 (timeTotalSpendRate: 0.07208107336568656

[[Per_Prob_ROI diff: 0.0013091399141442932 (up%-> 281.9858185307263) . o: 4.6425735909894495E-4 -> a: 0.001773397273243238	 per returnMoney: o:0.005590180788029685 a: 2.328134322456979E-4	 per totalSpendMoney: o: 0.005764061643716301 a: 2.599624486131713E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.27525885409390516

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.34952685426376584     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9234219165055854 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Four4, 	playerStartValue=2	@@@ 

net money diff:  -0.004074579883760851 , up % -> -83.45077074431687 .  o: -0.004882615040482818 -> a: -0.00895719492424367 (anet/onet: 1.8345077074431686

[ProbMatrix: total: o: 0.03240646916577242  -> a: 4.376034551641727E-4
org->adv	$w:45.829359705366265->45.105345123086764  	$d:3.3779852119231526->2.966393695203666  	$l:50.79265508271058->51.928261181709566
	 improve value x$w(high is good):-0.7240145822795014  	x$d:-0.4115915167194868  	 x$l(negative is good):1.1356060989989842
	 	 $w-$l: -4.963295377344318 -> -6.822916058622802  _ #Surrender#	 lift : -1.8596206812784843 : bad	 :| stand

[TimeMatrix: total:  o: 3.0739324E7 -> a: 2295469.0
org->adv	$w:68.44654098444065->68.51902595940089  	$d:4.764515966584041->4.762338328245774  	$l:26.788943048975312->26.718635712353333
	 improve value x$w(high is good):0.07248497496024697  	x$d:-0.002177638338266341  	 x$l(negative is good):-0.07030733662197974
	 	 $w-$l: 41.65759793546534 -> 41.80039024704756  _ @double@	 lift : 0.14279231158221828 : good	 :) hit 

[Prob_ROI diff: -0.06782366565365072 (up%-> -6.78511789626766) . o: 0.9995945050705601 -> a: 0.9317708394169094	 returnMoney: o:12.036242158645967 a: 0.1223238416251574 (probReturnRate: 0.010162959502878462	 totalSpendMoney: o: 12.04112477368645 a: 0.13128103654940107 (probTotalSpendRate: 0.01090272204771853

[Time_ROI diff: 1.854992774774633E-4 (up%-> 0.013083429941359883) . o: 1.4178184031929981 -> a: 1.4180039024704756	 returnMoney: o:1.39778772E10 a: 9.764952E8 (timeReturnRate: 0.06986004999385743	 totalSpendMoney: o: 9.8587218E9 a: 6.886407E8 (timeTotalSpendRate: 0.06985091109884042

[[Per_Prob_ROI diff: 0.0027263389277297073 (up%-> 285.0179912980249) . o: 9.565497656177608E-4 -> a: 0.003682888693347468	 per returnMoney: o:0.011517935080043987 a: 4.834934451587249E-4	 per totalSpendMoney: o: 0.011522607438934402 a: 5.188973776656169E-4

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.07189824553741157

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.004074579883760851     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9321488210373235 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Five5, 	playerStartValue=2	@@@ 

net money diff:  0.44164610906894997 , up % -> 11681.149837054325 .  o: -0.003780844482175749 -> a: 0.4378652645867742 (anet/onet: -115.81149837054325

[ProbMatrix: total: o: 4.3760345516444406E-4  -> a: 0.03240646916592484
org->adv	$w:47.13342805856603->47.82670181654003  	$d:2.8531814894368823->3.2490545829779083  	$l:50.01339045199708->48.92424360048205
	 improve value x$w(high is good):0.6932737579739978  	x$d:0.39587309354102596  	 x$l(negative is good):-1.0891468515150322
	 	 $w-$l: -2.879962393431051 -> -1.0975417839420187  _ #Surrender#	 lift : 1.7824206094890327 : good	 :) hit 

[TimeMatrix: total:  o: 1384669.0 -> a: 1.8542524E7
org->adv	$w:68.50741946270192->68.43491209718806  	$d:4.764171076264436->4.766362982730938  	$l:26.728409461033646->26.798724920080996
	 improve value x$w(high is good):-0.07250736551385728  	x$d:0.00219190646650258  	 x$l(negative is good):0.07031545904735026
	 	 $w-$l: 41.77901000166827 -> 41.63618717710706  _ @double@	 lift : -0.14282282456120066 : bad	 :| stand

[Prob_ROI diff: 0.06516377369621096 (up%-> 6.709611662230766) . o: 0.9712003760668579 -> a: 1.036364149763069	 returnMoney: o:0.12750019206722274 a: 12.47899003829083 (probReturnRate: 97.87428423410886	 totalSpendMoney: o: 0.1312810365493985 a: 12.041124773704055 (probTotalSpendRate: 91.72021405523573

[Time_ROI diff: -1.8550063956879193E-4 (up%-> -0.013083787195763972) . o: 1.4177901000166826 -> a: 1.4176045993771138	 returnMoney: o:5.88951E8 a: 8.4304404E9 (timeReturnRate: 14.314332431730314	 totalSpendMoney: o: 4.154007E8 a: 5.9469618E9 (timeTotalSpendRate: 14.316205533596838

[[Per_Prob_ROI diff: -0.0028470006358144754 (up%-> -74.16504138703887) . o: 0.003838736664295881 -> a: 9.917360284814056E-4	 per returnMoney: o:5.039533283289436E-4 a: 0.011941617261522324	 per totalSpendMoney: o: 5.188973776656066E-4 a: 0.01152260743895125

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.5068098827651609

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.44164610906894997     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.0670961166223079 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Six6, 	playerStartValue=2	@@@ 

net money diff:  0.6981392530261005 , up % -> 51515.805186116406 .  o: -0.0013551942952339802 -> a: 0.6967840587308665 (anet/onet: -514.158051861164

[ProbMatrix: total: o: 4.3760345516461916E-4  -> a: 0.03240646916600347
org->adv	$w:48.0440610824553->48.80396073692577  	$d:2.879592951525948->3.280753678412845  	$l:49.07634596601875->47.91528558466137
	 improve value x$w(high is good):0.7598996544704661  	x$d:0.40116072688689686  	 x$l(negative is good):-1.1610603813573803
	 	 $w-$l: -1.0322848835634502 -> 0.8886751522643954  _ #Surrender#	 lift : 1.9209600358278456 : good	 :) hit 

[TimeMatrix: total:  o: 786577.0 -> a: 1.0533292E7
org->adv	$w:68.49348506249228->68.42096468986144  	$d:4.76583983513375->4.767930102004198  	$l:26.740675102373956->26.81110520813436
	 improve value x$w(high is good):-0.07252037263084787  	x$d:0.0020902668704474436  	 x$l(negative is good):0.07043010576040487
	 	 $w-$l: 41.752809960118334 -> 41.60985948172708  _ @double@	 lift : -0.14295047839125163 : bad	 :| stand

[Prob_ROI diff: 0.06818987303984037 (up%-> 6.8901128978866835) . o: 0.9896771511647563 -> a: 1.0578670242045967	 returnMoney: o:0.12992584225420617 a: 12.737908832441232 (probReturnRate: 98.03984035384508	 totalSpendMoney: o: 0.13128103654944015 a: 12.041124773710365 (probTotalSpendRate: 91.72021405525469

[Time_ROI diff: -1.8716159661225085E-4 (up%-> -0.013203378237433748) . o: 1.4175280996011834 -> a: 1.4173409380045712	 returnMoney: o:3.344985E8 a: 4.788117E9 (timeReturnRate: 14.31431531083099	 totalSpendMoney: o: 2.359731E8 a: 3.3782394E9 (timeTotalSpendRate: 14.316205533596838

[[Per_Prob_ROI diff: -0.002899454454085547 (up%-> -74.12134108788007) . o: 0.0039117673959081275 -> a: 0.0010123129418225804	 per returnMoney: o:5.135408784751232E-4 a: 0.012189386442527494	 per totalSpendMoney: o: 5.188973776657713E-4 a: 0.011522607438957288

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.7663291260659408

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.6981392530261005     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.068901128978867 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Seven7, 	playerStartValue=2	@@@ 

net money diff:  -0.006031478954502345 , up % -> -106.08955958986441 .  o: -0.005685270989737035 -> a: -0.01171674994423938 (anet/onet: 2.060895595898644

[ProbMatrix: total: o: 0.032406469164574375  -> a: 4.3760345516271785E-4
org->adv	$w:43.567228554101014->40.931101249908515  	$d:9.332146582038558->9.212860393028087  	$l:47.10062486386043->49.8560383570634
	 improve value x$w(high is good):-2.636127304192499  	x$d:-0.11928618901047017  	 x$l(negative is good):2.7554134932029655
	 	 $w-$l: -3.533396309759418 -> -8.924937107154884  _ #Surrender#	 lift : -5.391540797395466 : bad	 :| stand

[TimeMatrix: total:  o: 2.99591476E8 -> a: 1.7429233E7
org->adv	$w:31.427474925888742->31.435577228211937  	$d:3.5517232139141366->3.553214303807861  	$l:65.02080186019712->65.01120846798021
	 improve value x$w(high is good):0.008102302323194976  	x$d:0.0014910898937245953  	 x$l(negative is good):-0.009593392216913799
	 	 $w-$l: -33.59332693430838 -> -33.57563123976827  _ #Surrender#	 lift : 0.017695694540104112 : good	 :| stand

[Prob_ROI diff: -0.08874482376086812 (up%-> -8.878962232515159) . o: 0.999495452699197 -> a: 0.9107506289383289	 returnMoney: o:11.262378160703571 a: 0.11956428660382931 (probReturnRate: 0.010616255723059473	 totalSpendMoney: o: 11.268063431693308 a: 0.1312810365480687 (probTotalSpendRate: 0.011650718630037072

[Time_ROI diff: -6.316669063078928E-4 (up%-> -0.095005312202424) . o: 0.6648753545086252 -> a: 0.6642436876023173	 returnMoney: o:5.98170708E10 a: 3.4731774E9 (timeReturnRate: 0.05806331459480293	 totalSpendMoney: o: 8.99673456E10 a: 5.2287699E9 (timeTotalSpendRate: 0.05811853028594855

[[Per_Prob_ROI diff: 7.996620406030416E-5 (up%-> 391.72017305564054) . o: 2.0414114350180696E-5 -> a: 1.0038031841048485E-4	 per returnMoney: o:2.300275353996767E-4 a: 1.3178032249953633E-5	 per totalSpendMoney: o: 2.3014365375897773E-4 a: 1.4469418775274847E-5

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.09477630271537046

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.006031478954502345     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9112103776748485 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

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


MatrixKey [startValue=Two, dealerCard=Four4, situation=Start_With_Pair] : Hit -> Split
MatrixKey [startValue=Two, dealerCard=Four4, situation=Splited_Pair_And_Can_Split] : Hit -> Split
MatrixKey [startValue=Two, dealerCard=Seven7, situation=Start_With_Pair] : Hit -> Split
MatrixKey [startValue=Two, dealerCard=Seven7, situation=Splited_Pair_And_Can_Split] : Hit -> Split


		 @@@   dealerCard=Four4, 	playerStartValue=2	@@@ 

net money diff:  0.004074579883760851 , up % -> 45.48946314356223 .  o: -0.00895719492424367 -> a: -0.004882615040482818 (anet/onet: 0.5451053685643776

[ProbMatrix: total: o: 4.376034551641727E-4  -> a: 0.03240646916577242
org->adv	$w:45.105345123086764->45.829359705366265  	$d:2.966393695203666->3.3779852119231526  	$l:51.928261181709566->50.79265508271058
	 improve value x$w(high is good):0.7240145822795014  	x$d:0.4115915167194868  	 x$l(negative is good):-1.1356060989989842
	 	 $w-$l: -6.822916058622802 -> -4.963295377344318  _ #Surrender#	 lift : 1.8596206812784843 : good	 :) hit 

[TimeMatrix: total:  o: 2295469.0 -> a: 3.0739324E7
org->adv	$w:68.51902595940089->68.44654098444065  	$d:4.762338328245774->4.764515966584041  	$l:26.718635712353333->26.788943048975312
	 improve value x$w(high is good):-0.07248497496024697  	x$d:0.002177638338266341  	 x$l(negative is good):0.07030733662197974
	 	 $w-$l: 41.80039024704756 -> 41.65759793546534  _ @double@	 lift : -0.14279231158221828 : bad	 :| stand

[Prob_ROI diff: 0.06782366565365072 (up%-> 7.279007110384987) . o: 0.9317708394169094 -> a: 0.9995945050705601	 returnMoney: o:0.1223238416251574 a: 12.036242158645967 (probReturnRate: 98.39653495783087	 totalSpendMoney: o: 0.13128103654940107 a: 12.04112477368645 (probTotalSpendRate: 91.72021405509983

[Time_ROI diff: -1.854992774774633E-4 (up%-> -0.013081718403897383) . o: 1.4180039024704756 -> a: 1.4178184031929981	 returnMoney: o:9.764952E8 a: 1.39778772E10 (timeReturnRate: 14.31433272790281	 totalSpendMoney: o: 6.886407E8 a: 9.8587218E9 (timeTotalSpendRate: 14.316205533596838

[[Per_Prob_ROI diff: -0.0027263389277297073 (up%-> -74.02718775222259) . o: 0.003682888693347468 -> a: 9.565497656177608E-4	 per returnMoney: o:4.834934451587249E-4 a: 0.011517935080043987	 per totalSpendMoney: o: 5.188973776656169E-4 a: 0.011522607438934402

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.07189824553741157

 按net净收益值(代表少输多赢) :  $Change$  Value: 0.004074579883760851     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.0727900711038498 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

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



		 */
	}
	
	public static void test33vsAll() {
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
		
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
MatrixKey [startValue=Three, dealerCard=One1, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Three, dealerCard=One1, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Three, dealerCard=Two2, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Three, dealerCard=Two2, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Three, dealerCard=Three3, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Three, dealerCard=Three3, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Three, dealerCard=Four4, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Three, dealerCard=Four4, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Three, dealerCard=Five5, situation=Splited_Pair_And_Can_Split] : Hit -> Split
MatrixKey [startValue=Three, dealerCard=Five5, situation=Start_With_Pair] : Hit -> Split
MatrixKey [startValue=Three, dealerCard=Six6, situation=Splited_Pair_And_Can_Split] : Hit -> Split
MatrixKey [startValue=Three, dealerCard=Six6, situation=Start_With_Pair] : Hit -> Split
MatrixKey [startValue=Three, dealerCard=Seven7, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Three, dealerCard=Seven7, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Three, dealerCard=Eight8, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Three, dealerCard=Eight8, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Three, dealerCard=Nine9, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Three, dealerCard=Nine9, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Three, dealerCard=Ten, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Three, dealerCard=Ten, situation=Start_With_Pair] : Split -> Hit


		 @@@   dealerCard=One1, 	playerStartValue=3	@@@ 

net money diff:  4.122302192588374 , up % -> 98.41276768559362 .  o: -4.18878798913388 -> a: -0.06648579654550618 (anet/onet: 0.015872323144063807

[ProbMatrix: total: o: 0.032406469158699804  -> a: 4.37603455162977E-4
org->adv	$w:23.02483065829329->19.797255352467474  	$d:10.86441480274277->9.761620007805401  	$l:66.11075453896393->70.44112463972712
	 improve value x$w(high is good):-3.227575305825816  	x$d:-1.1027947949373686  	 x$l(negative is good):4.33037010076319
	 	 $w-$l: -43.08592388067065 -> -50.643869287259655  _ #Surrender#	 lift : -7.5579454065890115 : bad	 :| stand

[TimeMatrix: total:  o: 1.2376039E9 -> a: 4.4175781E7
org->adv	$w:31.5649538596315->31.607051836842455  	$d:3.5065227250819104->3.5101835551022855  	$l:64.92852341528659->64.88276460805525
	 improve value x$w(high is good):0.042097977210953985  	x$d:0.0036608300203750943  	 x$l(negative is good):-0.04575880723133707
	 	 $w-$l: -33.36356955565509 -> -33.2757127712128  _ #Surrender#	 lift : 0.08785678444228617 : good	 :| stand

[Prob_ROI diff: -0.07557945409247707 (up%-> -13.279571459306029) . o: 0.5691407612367843 -> a: 0.4935613071443072	 returnMoney: o:5.533152756892186 a: 0.0647952400013024 (probReturnRate: 0.011710365292299655	 totalSpendMoney: o: 9.721940746026066 a: 0.1312810365468086 (probTotalSpendRate: 0.013503583284075346

[Time_ROI diff: 8.785678444227507E-4 (up%-> 0.1318449740726336) . o: 0.6663643044434492 -> a: 0.6672428722878719	 returnMoney: o:2.474085186E11 a: 8.8427925E9 (timeReturnRate: 0.03574166544482111	 totalSpendMoney: o: 3.7128117E11 a: 1.32527343E10 (timeTotalSpendRate: 0.03569460390355913

[[Per_Prob_ROI diff: 1.3842379690515714E-4 (up%-> 680.9301504836952) . o: 2.0328633826366554E-5 -> a: 1.587524307315237E-4	 per returnMoney: o:1.9763377350759674E-4 a: 2.084118366075986E-5	 per totalSpendMoney: o: 3.472493747910871E-4 a: 4.222612947790562E-5

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=true]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 4.046722738495897
 按net净收益值(代表少输多赢) :  $Change$  Value: 4.122302192588374
 probRunR/probTalSR= 0.8672042854069396 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Two2, 	playerStartValue=3	@@@ 

net money diff:  0.8849680625749596 , up % -> 97.77426444962839 .  o: -0.9051134954135911 -> a: -0.02014543283863146 (anet/onet: 0.02225735550371616

[ProbMatrix: total: o: 0.03240646916541569  -> a: 4.3760345516288704E-4
org->adv	$w:41.67821417160104->40.36435509521707  	$d:3.9702844049577886->3.9260172787550958  	$l:54.35150142344117->55.70962762602784
	 improve value x$w(high is good):-1.3138590763839701  	x$d:-0.0442671262026928  	 x$l(negative is good):1.3581262025866678
	 	 $w-$l: -12.673287251840131 -> -15.345272530810766  _ #Surrender#	 lift : -2.6719852789706344 : bad	 :| stand

[TimeMatrix: total:  o: 1.16684308E8 -> a: 5150977.0
org->adv	$w:57.48595775191983->57.11671785760255  	$d:4.164083485844557->4.097552755525796  	$l:38.34995876223562->38.78572938687165
	 improve value x$w(high is good):-0.3692398943172748  	x$d:-0.06653073031876122  	 x$l(negative is good):0.435770624636028
	 	 $w-$l: 19.135998989684204 -> 18.330988470730897  _ @double@	 lift : -0.8050105189533086 : bad	 :| stand

[Prob_ROI diff: -0.07312716617912929 (up%-> -7.951418776975951) . o: 0.9196744408793508 -> a: 0.8465472747002215	 returnMoney: o:10.362949936975452 a: 0.11113560371041795 (probReturnRate: 0.01072432120065362	 totalSpendMoney: o: 11.268063432389043 a: 0.1312810365490494 (probTotalSpendRate: 0.011650718629404746

[Time_ROI diff: -0.01783252424957138 (up%-> -1.4846303083293722) . o: 1.2011424089568803 -> a: 1.183309884707309	 returnMoney: o:4.35466224E10 a: 1.8285606E9 (timeReturnRate: 0.04199087091539848	 totalSpendMoney: o: 3.62543376E10 a: 1.5452931E9 (timeTotalSpendRate: 0.042623674911660775

[[Per_Prob_ROI diff: 0.003726043937554887 (up%-> 564.3713660293912) . o: 6.602113717726854E-4 -> a: 0.004386255309327573	 per returnMoney: o:0.007439303615919205 a: 5.758321435772951E-4	 per totalSpendMoney: o: 0.008089062047659041 a: 6.802126246064737E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.8118408963958303
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.8849680625749596
 probRunR/probTalSR= 0.9204858122302404 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Three3, 	playerStartValue=3	@@@ 

net money diff:  0.5088648720863501 , up % -> 97.02442034937275 .  o: -0.5244709221183612 -> a: -0.015606050032011057 (anet/onet: 0.029755796506272515

[ProbMatrix: total: o: 0.032406469165709995  -> a: 4.3760345516344085E-4
org->adv	$w:43.28784674784457->42.158977239547184  	$d:3.766388092187953->3.7945327140988097  	$l:52.94576515996747->54.046490046354
	 improve value x$w(high is good):-1.1288695082973845  	x$d:0.02814462191085676  	 x$l(negative is good):1.10072488638653
	 	 $w-$l: -9.657918412122907 -> -11.887512806806816  _ #Surrender#	 lift : -2.229594394683909 : bad	 :| stand

[TimeMatrix: total:  o: 6.4638268E7 -> a: 3001729.0
org->adv	$w:57.60645690568318->57.10065765430523  	$d:4.164034840785028->4.099903755468932  	$l:38.22950825353179->38.79943859022583
	 improve value x$w(high is good):-0.505799251377951  	x$d:-0.06413108531609613  	 x$l(negative is good):0.5699303366940427
	 	 $w-$l: 19.376948652151388 -> 18.301219064079397  _ @double@	 lift : -1.0757295880719886 : bad	 :| stand

[Prob_ROI diff: -0.07531848929558027 (up%-> -7.874850968541133) . o: 0.9564433612326952 -> a: 0.881124871937115	 returnMoney: o:11.516653851541845 a: 0.11567498651716053 (probReturnRate: 0.010044148934950755	 totalSpendMoney: o: 12.041124773660206 a: 0.1312810365491716 (probTotalSpendRate: 0.010902722047723235

[Time_ROI diff: -0.023675208035815798 (up%-> -1.962000105560124) . o: 1.2066873986766098 -> a: 1.183012190640794	 returnMoney: o:2.47169412E10 a: 1.0653246E9 (timeReturnRate: 0.04310098856407038	 totalSpendMoney: o: 2.0483301E10 a: 9.005187E8 (timeTotalSpendRate: 0.04396355353075171

[[Per_Prob_ROI diff: 0.0038413840476912166 (up%-> 530.5560718681719) . o: 7.240297965425399E-4 -> a: 0.004565413844233757	 per returnMoney: o:0.008718133120016536 a: 5.993522617469458E-4	 per totalSpendMoney: o: 0.009115158799137173 a: 6.802126246071066E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.4335463827907699
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.5088648720863501
 probRunR/probTalSR= 0.9212514903145888 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Four4, 	playerStartValue=3	@@@ 

net money diff:  0.09798633287938827 , up % -> 90.10224682688616 .  o: -0.10875015477433081 -> a: -0.010763821894942543 (anet/onet: 0.09897753173113844

[ProbMatrix: total: o: 0.03240646916594721  -> a: 4.376034551639779E-4
org->adv	$w:45.41130005421672->44.30320794392362  	$d:3.1330252056809194->3.1945157790099232  	$l:51.455674740102374->52.502276277066464
	 improve value x$w(high is good):-1.1080921102931  	x$d:0.06149057332900387  	 x$l(negative is good):1.04660153696409
	 	 $w-$l: -6.044374685885656 -> -8.199068333142845  _ #Surrender#	 lift : -2.1546936472571887 : bad	 :| stand

[TimeMatrix: total:  o: 1.9851724E7 -> a: 880081.0
org->adv	$w:68.38299786960567->68.45949406929589  	$d:4.758982141802899->4.690931857408579  	$l:26.85801998859142->26.849574073295525
	 improve value x$w(high is good):0.0764961996902116  	x$d:-0.06805028439432004  	 x$l(negative is good):-0.008445915295894224
	 	 $w-$l: 41.52497788101426 -> 41.609919996000365  _ @double@	 lift : 0.08494211498610849 : good	 :| stand

[Prob_ROI diff: -0.072959122174444 (up%-> -7.362406239649062) . o: 0.9909684388445492 -> a: 0.9180093166701052	 returnMoney: o:11.93237461895292 a: 0.12051721465446158 (probReturnRate: 0.010100019359351719	 totalSpendMoney: o: 12.041124773727251 a: 0.13128103654940412 (probTotalSpendRate: 0.010902722047681841

[Time_ROI diff: -0.0011367019178103455 (up%-> -0.08020555479184759) . o: 1.417235901877814 -> a: 1.4160991999600037	 returnMoney: o:9.3430452E9 a: 3.738846E8 (timeReturnRate: 0.04001742386946817	 totalSpendMoney: o: 6.5924418E9 a: 2.640243E8 (timeTotalSpendRate: 0.040049545829892653

[[Per_Prob_ROI diff: 0.008042251107857565 (up%-> 565.6536376388103) . o: 0.0014217624660610463 -> a: 0.00946401357391861	 per returnMoney: o:0.017119619252443215 a: 0.0012424455119016658	 per totalSpendMoney: o: 0.01727564529946521 a: 0.0013534127479320013

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.025027210704944264
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.09798633287938827
 probRunR/probTalSR= 0.9263759376035093 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Five5, 	playerStartValue=3	@@@ 

net money diff:  0.3438567351532813 , up % -> 6212.921138432762 .  o: -0.005534542085625455 -> a: 0.3383221930676559 (anet/onet: -61.12921138432762

[ProbMatrix: total: o: 4.376034551642393E-4  -> a: 0.03240646916600612
org->adv	$w:46.36607217113361->47.42605060988293  	$d:3.05205859274655->3.014240968157023  	$l:50.581869236119836->49.55970842196006
	 improve value x$w(high is good):1.0599784387493187  	x$d:-0.037817624589526755  	 x$l(negative is good):-1.0221608141597756
	 	 $w-$l: -4.215797064986226 -> -2.133657812077139  _ #Surrender#	 lift : 2.0821392529090876 : good	 :) hit 

[TimeMatrix: total:  o: 530881.0 -> a: 1.1974924E7
org->adv	$w:68.447919590266->68.37133997677147  	$d:4.692577055875045->4.760848586596458  	$l:26.859503353858962->26.86781143663208
	 improve value x$w(high is good):-0.07657961349453046  	x$d:0.06827153072141279  	 x$l(negative is good):0.008308082773119452
	 	 $w-$l: 41.588416236407035 -> 41.50352854013938  _ @double@	 lift : -0.0848876962676548 : bad	 :| stand

[Prob_ROI diff: 0.07025519573604111 (up%-> 7.334737209605072) . o: 0.9578420293509589 -> a: 1.028097225087	 returnMoney: o:0.12574649446377803 a: 12.379446966780314 (probReturnRate: 98.44765072434112	 totalSpendMoney: o: 0.13128103654940348 a: 12.041124773712658 (probTotalSpendRate: 91.72021405529777

[Time_ROI diff: 0.0011377376531751526 (up%-> 0.08035527788343202) . o: 1.4158841623640703 -> a: 1.4170219000172455	 returnMoney: o:2.254998E8 a: 5.6350452E9 (timeReturnRate: 24.989136132271515	 totalSpendMoney: o: 1.592643E8 a: 3.9766818E9 (timeTotalSpendRate: 24.969072164948454

[[Per_Prob_ROI diff: -0.008399628209619715 (up%-> -85.06245407556429) . o: 0.009874660096401637 -> a: 0.0014750318867819221	 per returnMoney: o:0.0012963556130286395 a: 0.01776104299394593	 per totalSpendMoney: o: 0.0013534127479319948 a: 0.017275645299444274

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.4141119308893224
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.3438567351532813
 probRunR/probTalSR= 1.0733473720960507 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Six6, 	playerStartValue=3	@@@ 

net money diff:  0.592693762114458 , up % -> 19646.95721632126 .  o: -0.003016720378573895 -> a: 0.5896770417358841 (anet/onet: -195.46957216321263

[ProbMatrix: total: o: 4.3760345516444667E-4  -> a: 0.03240646916606409
org->adv	$w:47.19629961775042->48.36967006274423  	$d:3.309490527119699->3.0352553987446234  	$l:49.49420985512988->48.59507453851115
	 improve value x$w(high is good):1.1733704449938074  	x$d:-0.27423512837507547  	 x$l(negative is good):-0.8991353166187324
	 	 $w-$l: -2.2979102373794635 -> -0.22540447576692157  _ #Surrender#	 lift : 2.072505761612542 : good	 :) hit 

[TimeMatrix: total:  o: 301573.0 -> a: 6802492.0
org->adv	$w:68.43384520497524->68.35741960446259  	$d:4.694717365281375->4.762313575671975  	$l:26.871437429743377->26.88026681986543
	 improve value x$w(high is good):-0.0764256005126498  	x$d:0.06759621039060004  	 x$l(negative is good):0.008829390122052416
	 	 $w-$l: 41.56240777523186 -> 41.47715278459717  _ @double@	 lift : -0.08525499063469222 : bad	 :| stand

[Prob_ROI diff: 0.07195102591207181 (up%-> 7.364328243834635) . o: 0.9770208976264566 -> a: 1.0489719235385284	 returnMoney: o:0.12826431617084091 a: 12.630801815443409 (probReturnRate: 98.47479168422717	 totalSpendMoney: o: 0.1312810365494148 a: 12.041124773707525 (probTotalSpendRate: 91.72021405525076

[Time_ROI diff: 0.001133536260327972 (up%-> 0.08007325377848641) . o: 1.4156240777523186 -> a: 1.4167576140126465	 returnMoney: o:1.280742E8 a: 3.2004546E9 (timeReturnRate: 24.989065713469223	 totalSpendMoney: o: 9.04719E7 a: 2.2589994E9 (timeTotalSpendRate: 24.969072164948454

[[Per_Prob_ROI diff: -0.008567399148965418 (up%-> -85.05833595458829) . o: 0.010072380387901614 -> a: 0.0015049812389361958	 per returnMoney: o:0.0013223125378437207 a: 0.01812166688011967	 per totalSpendMoney: o: 0.0013534127479321114 a: 0.01727564529943691

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.6646447880265298
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.592693762114458
 probRunR/probTalSR= 1.0736432824383462 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Seven7, 	playerStartValue=3	@@@ 

net money diff:  0.2748017400920024 , up % -> 92.5616308372999 .  o: -0.29688515382257563 -> a: -0.02208341373057318 (anet/onet: 0.07438369162700086

[ProbMatrix: total: o: 0.03240646916516243  -> a: 4.37603455163064E-4
org->adv	$w:42.17246599543624->36.63968963763087  	$d:9.109256074828089->9.899140402054236  	$l:48.71827792973568->53.46116996031489
	 improve value x$w(high is good):-5.532776357805368  	x$d:0.7898843272261473  	 x$l(negative is good):4.742892030579213
	 	 $w-$l: -6.545811934299434 -> -16.821480322684017  _ #Surrender#	 lift : -10.275668388384585 : bad	 :| stand

[TimeMatrix: total:  o: 1.58743756E8 -> a: 5972389.0
org->adv	$w:31.476160863927145->31.458868469552133  	$d:3.5532244808419424->3.555110023811242  	$l:64.9706146552309->64.98602150663663
	 improve value x$w(high is good):-0.017292394375012066  	x$d:0.0018855429692994363  	 x$l(negative is good):0.015406851405728617
	 	 $w-$l: -33.49445379130376 -> -33.527153037084496  _ #Surrender#	 lift : -0.0326992457807318 : bad	 :| stand

[Prob_ROI diff: -0.14186731631188487 (up%-> -14.570631144614891) . o: 0.9736525130849745 -> a: 0.8317851967730896	 returnMoney: o:10.971178277808452 a: 0.10919762281877346 (probReturnRate: 0.009953135392909342	 totalSpendMoney: o: 11.268063431631028 a: 0.13128103654934664 (probTotalSpendRate: 0.011650718630214881

[Time_ROI diff: -0.001849864771978793 (up%-> -0.27751648628675357) . o: 0.6665783344011339 -> a: 0.6647284696291551	 returnMoney: o:3.18044718E10 a: 1.1910051E9 (timeReturnRate: 0.03744772456809045	 totalSpendMoney: o: 4.77130296E10 a: 1.7917167E9 (timeTotalSpendRate: 0.03755193738525461

[[Per_Prob_ROI diff: 2.3081194303936183E-4 (up%-> 628.4165773520116) . o: 3.67291302231308E-5 -> a: 2.6754107326249264E-4	 per returnMoney: o:4.1386616914287417E-4 a: 3.512306941742472E-5	 per totalSpendMoney: o: 4.2506557892153714E-4 a: 4.222612947872198E-5

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.13293442378011758
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.2748017400920024
 probRunR/probTalSR= 0.8542936885538511 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Eight8, 	playerStartValue=3	@@@ 

net money diff:  1.076096951725412 , up % -> 97.09494135918848 .  o: -1.1082935286448645 -> a: -0.03219657691945252 (anet/onet: 0.029050586408115184

[ProbMatrix: total: o: 0.032406469165670984  -> a: 4.3760345516388695E-4
org->adv	$w:38.351425187353996->33.41211573558469  	$d:9.284466845065209->8.650842640264798  	$l:52.364107967580786->57.93704162415051
	 improve value x$w(high is good):-4.939309451769304  	x$d:-0.6336242048004106  	 x$l(negative is good):5.572933656569724
	 	 $w-$l: -14.012682780226793 -> -24.524925888565818  _ #Surrender#	 lift : -10.512243108339025 : bad	 :| stand

[TimeMatrix: total:  o: 9.5279308E7 -> a: 3584677.0
org->adv	$w:31.46681753817943->31.449500192067514  	$d:3.5548809821330773->3.5568895049679514  	$l:64.97830147968749->64.99361030296453
	 improve value x$w(high is good):-0.017317346111916265  	x$d:0.0020085228348740713  	 x$l(negative is good):0.015308823277038641
	 	 $w-$l: -33.511483941508054 -> -33.544110110897016  _ #Surrender#	 lift : -0.03262616938896623 : bad	 :| stand

[Prob_ROI diff: -0.14689220442472162 (up%-> -16.29161578332455) . o: 0.9016429455393531 -> a: 0.7547507411146315	 returnMoney: o:10.159769903330904 a: 0.09908445962998494 (probReturnRate: 0.00975262831469243	 totalSpendMoney: o: 11.268063431975769 a: 0.13128103654943746 (probTotalSpendRate: 0.011650718629866493

[Time_ROI diff: -0.001848969536411893 (up%-> -0.2774531370367828) . o: 0.6664078684274417 -> a: 0.6645588988910298	 returnMoney: o:1.90844238E10 a: 7.146687E8 (timeReturnRate: 0.03744774835696114	 totalSpendMoney: o: 2.86377528E10 a: 1.0754031E9 (timeTotalSpendRate: 0.03755193738525461

[[Per_Prob_ROI diff: 2.0875047405294965E-4 (up%-> 613.7425401093117) . o: 3.4012710609202644E-5 -> a: 2.427631846621523E-4	 per returnMoney: o:3.8325738063793065E-4 a: 3.187020251848985E-5	 per totalSpendMoney: o: 4.250655789345418E-4 a: 4.222612947875119E-5

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.9292047473006904
 按net净收益值(代表少输多赢) :  $Change$  Value: 1.076096951725412
 probRunR/probTalSR= 0.8370838421667545 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Nine9, 	playerStartValue=3	@@@ 

net money diff:  1.9726970168215 , up % -> 97.93812672015146 .  o: -2.0142278425013043 -> a: -0.04153082567980447 (anet/onet: 0.02061873279848557

[ProbMatrix: total: o: 0.03240646916583224  -> a: 4.3760345516437874E-4
org->adv	$w:34.19444574779021->29.843731133855716  	$d:9.309966143760134->8.677484588654524  	$l:56.495588108449645->61.478784277489765
	 improve value x$w(high is good):-4.350714613934496  	x$d:-0.6324815551056098  	 x$l(negative is good):4.98319616904012
	 	 $w-$l: -22.301142360659433 -> -31.635053143634046  _ #Surrender#	 lift : -9.333910782974614 : bad	 :| stand

[TimeMatrix: total:  o: 6.3547084E7 -> a: 2390821.0
org->adv	$w:31.43861644383242->31.421340200709295  	$d:3.5570821786252225->3.558986640990689  	$l:65.00430137754236->65.01967315830002
	 improve value x$w(high is good):-0.017276243123124146  	x$d:0.001904462365466486  	 x$l(negative is good):0.015371780757661213
	 	 $w-$l: -33.565684933709946 -> -33.59833295759072  _ #Surrender#	 lift : -0.03264802388077692 : bad	 :| stand

[Prob_ROI diff: -0.13759507317630693 (up%-> -16.75445816475617) . o: 0.8212445417408064 -> a: 0.6836494685644995	 returnMoney: o:9.253835589613283 a: 0.08975021086959052 (probReturnRate: 0.009698703851009436	 totalSpendMoney: o: 11.268063432114587 a: 0.131281036549395 (probTotalSpendRate: 0.01165071862971919

[Time_ROI diff: -0.0018487549683330329 (up%-> -0.2776469385301804) . o: 0.6658654253924259 -> a: 0.6640166704240928	 returnMoney: o:1.27181058E10 a: 4.762635E8 (timeReturnRate: 0.03744767558074568	 totalSpendMoney: o: 1.91001144E10 a: 7.172463E8 (timeTotalSpendRate: 0.03755193738525461

[[Per_Prob_ROI diff: 1.889138469998998E-4 (up%-> 609.7960979448306) . o: 3.0979838611068184E-5 -> a: 2.1989368561096799E-4	 per returnMoney: o:3.4908278658618894E-4 a: 2.886787097767466E-5	 per totalSpendMoney: o: 4.2506557893977847E-4 a: 4.222612947873753E-5

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.835101943645193
 按net净收益值(代表少输多赢) :  $Change$  Value: 1.9726970168215
 probRunR/probTalSR= 0.8324554183524383 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Ten, 	playerStartValue=3	@@@ 

net money diff:  2.9780162821533627 , up % -> 98.27535564399011 .  o: -3.0302777971533894 -> a: -0.05226151500002693 (anet/onet: 0.017246443560098957

[ProbMatrix: total: o: 0.032406469166007736  -> a: 4.37603455164481E-4
org->adv	$w:29.485561440566617->25.721250637638455  	$d:9.575631009347472->8.74861514661239  	$l:60.938807550085905->65.53013421574916
	 improve value x$w(high is good):-3.7643108029281613  	x$d:-0.827015862735081  	 x$l(negative is good):4.591326665663253
	 	 $w-$l: -31.453246109519288 -> -39.8088835781107  _ #Surrender#	 lift : -8.355637468591414 : bad	 :| stand

[TimeMatrix: total:  o: 3.267418E7 -> a: 1196965.0
org->adv	$w:31.367654827144857->31.38078389927859  	$d:3.5624704277199917->3.5654342441090594  	$l:65.06987474513515->65.05378185661235
	 improve value x$w(high is good):0.013129072133732933  	x$d:0.0029638163890677305  	 x$l(negative is good):-0.016092888522805993
	 	 $w-$l: -33.70221991799029 -> -33.672997957333756  _ #Surrender#	 lift : 0.029221960656533597 : good	 :| stand

[Prob_ROI diff: -0.10935351482722633 (up%-> -15.374517819978859) . o: 0.7112646790465439 -> a: 0.6019111642193176	 returnMoney: o:7.464724293851153 a: 0.07901952154936068 (probReturnRate: 0.010585725398384866	 totalSpendMoney: o: 10.495002091004542 a: 0.1312810365493876 (probTotalSpendRate: 0.012508909994587898

[Time_ROI diff: -4.681955400281934E-4 (up%-> -0.07053918680067227) . o: 0.6637382159666906 -> a: 0.6632700204266624	 returnMoney: o:6.5121102E9 a: 2.381733E8 (timeReturnRate: 0.03657390503004694	 totalSpendMoney: o: 9.811263E9 a: 3.590895E8 (timeTotalSpendRate: 0.0365997221764415

[[Per_Prob_ROI diff: 1.675042361100582E-4 (up%-> 641.8135303480592) . o: 2.609858287331831E-5 -> a: 1.936028189833765E-4	 per returnMoney: o:2.73904681827731E-4 a: 2.5416378755021126E-5	 per totalSpendMoney: o: 3.85095295600651E-4 a: 4.222612947873516E-5

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 2.868662767326136
 按net净收益值(代表少输多赢) :  $Change$  Value: 2.9780162821533627
 probRunR/probTalSR= 0.8462548218002114 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

		 */
	}
	
	public static void test44vsAll() {
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
		
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
MatrixKey [startValue=Four, dealerCard=One1, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Four, dealerCard=One1, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Four, dealerCard=Two2, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Four, dealerCard=Two2, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Four, dealerCard=Three3, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Four, dealerCard=Three3, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Four, dealerCard=Four4, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Four, dealerCard=Four4, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Four, dealerCard=Five5, situation=Start_With_Pair] : Hit -> Split
MatrixKey [startValue=Four, dealerCard=Five5, situation=Splited_Pair_And_Can_Split] : Hit -> Split
MatrixKey [startValue=Four, dealerCard=Six6, situation=Start_With_Pair] : Hit -> Split
MatrixKey [startValue=Four, dealerCard=Six6, situation=Splited_Pair_And_Can_Split] : Hit -> Split
MatrixKey [startValue=Four, dealerCard=Seven7, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Four, dealerCard=Seven7, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Four, dealerCard=Eight8, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Four, dealerCard=Eight8, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Four, dealerCard=Nine9, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Four, dealerCard=Nine9, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Four, dealerCard=Ten, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Four, dealerCard=Ten, situation=Splited_Pair_And_Can_Split] : Split -> Hit


		 @@@   dealerCard=One1, 	playerStartValue=4	@@@ 

net money diff:  4.357050494446583 , up % -> 98.74019682431631 .  o: -4.412641086992032 -> a: -0.055590592545448445 (anet/onet: 0.012598031756836792

[ProbMatrix: total: o: 0.03240646916176022  -> a: 4.3760345516289105E-4
org->adv	$w:22.0879177808398->23.08589762982195  	$d:10.435684897512782->11.483480775401345  	$l:67.47639732164743->65.43062159477671
	 improve value x$w(high is good):0.9979798489821512  	x$d:1.0477958778885625  	 x$l(negative is good):-2.0457757268707155
	 	 $w-$l: -45.388479540807616 -> -42.34472396495475  _ #Surrender#	 lift : 3.043755575852863 : good	 :) hit 

[TimeMatrix: total:  o: 7.40743588E8 -> a: 1.6382977E7
org->adv	$w:31.57897979671746->31.691737100039873  	$d:3.507713657050245->3.5213502405576227  	$l:64.91330654623229->64.78691265940249
	 improve value x$w(high is good):0.11275730332241451  	x$d:0.013636583507377509  	 x$l(negative is good):-0.12639388682980268
	 	 $w-$l: -33.33432674951484 -> -33.09517555936262  _ #Surrender#	 lift : 0.23915119015221475 : good	 :) hit 

[Prob_ROI diff: 0.030437555740380318 (up%-> 5.5734679209548625) . o: 0.5461152046097301 -> a: 0.5765527603501104	 returnMoney: o:5.309299660544687 a: 0.07569044400449175 (probReturnRate: 0.014256201164717567	 totalSpendMoney: o: 9.721940747536719 a: 0.1312810365499402 (probTotalSpendRate: 0.013503583282299197

[Time_ROI diff: 0.002391511901522203 (up%-> 0.3587321307828837) . o: 0.6666567325048516 -> a: 0.6690482444063738	 returnMoney: o:1.4814651E11 a: 3.2883006E9 (timeReturnRate: 0.02219627448530512	 totalSpendMoney: o: 2.222230764E11 a: 4.9148931E9 (timeTotalSpendRate: 0.022116933936929335

[[Per_Prob_ROI diff: 4.6790810224006874E-4 (up%-> 1455.9496447361548) . o: 3.213765695343553E-5 -> a: 5.000457591935042E-4	 per returnMoney: o:3.1244039666596167E-4 a: 6.564652558932502E-5	 per totalSpendMoney: o: 5.721144440379403E-4 a: 1.1386039596699063E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 4.387488050186964
 按net净收益值(代表少输多赢) :  $Change$  Value: 4.357050494446583
 probRunR/probTalSR= 1.0557346792095486 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Two2, 	playerStartValue=4	@@@ 

net money diff:  1.0518251304459 , up % -> 99.74929399657293 .  o: -1.0544687468986371 -> a: -0.00264361645273703 (anet/onet: 0.002507060034270653

[ProbMatrix: total: o: 0.03240646916555644  -> a: 4.3760345516358906E-4
org->adv	$w:41.10359660548314->45.05313047217716  	$d:3.572829308843507->7.88003127069062  	$l:55.32357408567336->47.066838257132225
	 improve value x$w(high is good):3.9495338666940185  	x$d:4.307201961847113  	 x$l(negative is good):-8.256735828541132
	 	 $w-$l: -14.219977480190217 -> -2.0137077849550655  _ #Surrender#	 lift : 12.20626969523515 : good	 :) hit 

[TimeMatrix: total:  o: 7.312786E7 -> a: 1948297.0
org->adv	$w:57.70542717918998->57.266782220575195  	$d:4.157436030536105->4.262902421961334  	$l:38.137136790273914->38.47031535746347
	 improve value x$w(high is good):-0.4386449586147876  	x$d:0.10546639142522896  	 x$l(negative is good):0.33317856718955596
	 	 $w-$l: 19.568290388916072 -> 18.79646686311173  _ @double@	 lift : -0.7718235258043438 : bad	 :| stand

[Prob_ROI diff: 0.07344322130864112 (up%-> 8.102562338414568) . o: 0.9064197008450512 -> a: 0.9798629221536923	 returnMoney: o:10.213594685476847 a: 0.1286374200965535 (probReturnRate: 0.01259472536926383	 totalSpendMoney: o: 11.268063432375484 a: 0.13128103654929052 (probTotalSpendRate: 0.011650718629440162

[Time_ROI diff: -0.022780534609235126 (up%-> -1.8815300319395791) . o: 1.2107452032403525 -> a: 1.1879646686311174	 returnMoney: o:2.80740372E10 a: 6.943524E8 (timeReturnRate: 0.02473290161487711	 totalSpendMoney: o: 2.31874032E10 a: 5.844891E8 (timeTotalSpendRate: 0.02520718232044199

[[Per_Prob_ROI diff: 0.012403185041418614 (up%-> 1216.4818892993228) . o: 0.0010195947141114186 -> a: 0.013422779755530032	 per returnMoney: o:0.011488857913922214 a: 0.001762156439678815	 per totalSpendMoney: o: 0.012674986988048914 a: 0.0017983703636889113

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.1252683517545412
 按net净收益值(代表少输多赢) :  $Change$  Value: 1.0518251304459
 probRunR/probTalSR= 1.0810256233841458 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Three3, 	playerStartValue=4	@@@ 

net money diff:  0.6686463108249203 , up % -> 100.1994152958846 .  o: -0.6673155814836207 -> a: 0.0013307293412995747 (anet/onet: -0.00199415295884596

[ProbMatrix: total: o: 0.03240646916585252  -> a: 4.376034551639522E-4
org->adv	$w:42.74250388428663->46.69084971492393  	$d:3.377712768197163->7.631949895291239  	$l:53.87978334751622->45.677200389784836
	 improve value x$w(high is good):3.948345830637301  	x$d:4.2542371270940755  	 x$l(negative is good):-8.20258295773138
	 	 $w-$l: -11.137279463229593 -> 1.0136493251390932  _ #Surrender#	 lift : 12.150928788368686 : good	 :) hit 

[TimeMatrix: total:  o: 3.9255772E7 -> a: 1135369.0
org->adv	$w:57.932983715108186->57.25072641581723  	$d:4.15524117064874->4.265221262866962  	$l:37.91177511424307->38.4840523213158
	 improve value x$w(high is good):-0.6822572992909528  	x$d:0.10998009221822258  	 x$l(negative is good):0.5722772070727302
	 	 $w-$l: 20.021208600865116 -> 18.76667409450143  _ @double@	 lift : -1.254534506363686 : bad	 :| stand

[Prob_ROI diff: 0.06555619814248259 (up%-> 6.940246211125458) . o: 0.944580295111054 -> a: 1.0101364932535366	 returnMoney: o:11.373809192111551 a: 0.1326117658906298 (probReturnRate: 0.011659397801626949	 totalSpendMoney: o: 12.041124773595172 a: 0.13128103654933024 (probTotalSpendRate: 0.010902722047795297

[Time_ROI diff: -0.032560597449743156 (up%-> -2.668404192007164) . o: 1.2202273383947575 -> a: 1.1876667409450143	 returnMoney: o:1.57025592E10 a: 4.04532E8 (timeReturnRate: 0.02576217002894662	 totalSpendMoney: o: 1.28685522E10 a: 3.406107E8 (timeTotalSpendRate: 0.026468455402465556

[[Per_Prob_ROI diff: 0.012681329176992882 (up%-> 1096.8517966368424) . o: 0.0011561570319596744 -> a: 0.013837486208952556	 per returnMoney: o:0.0139214310796959 a: 0.0018165995327483536	 per totalSpendMoney: o: 0.014738218817129953 a: 0.0017983703636894554

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.7342025089674029
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.6686463108249203
 probRunR/probTalSR= 1.0694024621112546 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Four4, 	playerStartValue=4	@@@ 

net money diff:  0.25132335366293057 , up % -> 102.27953275091804 .  o: -0.24572203930084413 -> a: 0.005601314362086468 (anet/onet: -0.022795327509180514

[ProbMatrix: total: o: 0.03240646916601212  -> a: 4.3760345516437944E-4
org->adv	$w:44.868097339706466->48.668323851198636  	$d:2.800842489522054->6.930011450440861  	$l:52.33106017077148->44.40166469836051
	 improve value x$w(high is good):3.80022651149217  	x$d:4.129168960918808  	 x$l(negative is good):-7.929395472410967
	 	 $w-$l: -7.462962831065018 -> 4.266659152838126  _ @double@	 lift : 11.729621983903144 : good	 :) hit 

[TimeMatrix: total:  o: 1.2448156E7 -> a: 335701.0
org->adv	$w:68.26604679440071->68.56309632679081  	$d:4.703379359963034->5.007432209019336  	$l:27.03057384563625->26.42947146418986
	 improve value x$w(high is good):0.2970495323901048  	x$d:0.30405284905630214  	 x$l(negative is good):-0.6011023814463918
	 	 $w-$l: 41.23547294876446 -> 42.133624862600946  _ @double@	 lift : 0.8981519138364868 : good	 :) hit 

[Prob_ROI diff: 0.0630734923735009 (up%-> 6.438744048708616) . o: 0.9795930991565228 -> a: 1.0426665915300237	 returnMoney: o:11.795402734399712 a: 0.13688235091137166 (probReturnRate: 0.011604720414689414	 totalSpendMoney: o: 12.041124773700556 a: 0.1312810365492852 (probTotalSpendRate: 0.010902722047696135

[Time_ROI diff: 0.005564438433903751 (up%-> 0.3930321534759697) . o: 1.4157718101921057 -> a: 1.4213362486260095	 returnMoney: o:6.1888644E9 a: 1.431432E8 (timeReturnRate: 0.023129154356653865	 totalSpendMoney: o: 4.3713714E9 a: 1.007103E8 (timeTotalSpendRate: 0.02303860523038605

[[Per_Prob_ROI diff: 0.02597884534236679 (up%-> 1180.1416513966308) . o: 0.0022013328070933096 -> a: 0.0281801781494601	 per returnMoney: o:0.026506522998651038 a: 0.0036995229976046393	 per totalSpendMoney: o: 0.027058707356630463 a: 0.0035481361229536537

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.3143968460364315
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.25132335366293057
 probRunR/probTalSR= 1.0643874404870863 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Five5, 	playerStartValue=4	@@@ 

net money diff:  0.19720260493658412 , up % -> 1962.1261577383739 .  o: 0.010050454918958313 -> a: 0.20725305985554243 (anet/onet: 20.621261577383738

[ProbMatrix: total: o: 4.376034551644781E-4  -> a: 0.03240646916605258
org->adv	$w:50.457337075624466->46.90879957851145  	$d:6.741004980329239->2.6912325459232957  	$l:42.8016579440463->50.39996787556527
	 improve value x$w(high is good):-3.548537497113017  	x$d:-4.049772434405943  	 x$l(negative is good):7.598309931518969
	 	 $w-$l: 7.655679131578169 -> -3.491168297053815  _ #Surrender#	 lift : -11.146847428631984 : bad	 :| stand

[TimeMatrix: total:  o: 202501.0 -> a: 7508956.0
org->adv	$w:68.5522540629429->68.25433522316551  	$d:5.0083703290354125->4.705208020928609  	$l:26.439375608021688->27.04045675590588
	 improve value x$w(high is good):-0.2979188397773811  	x$d:-0.30316230810680356  	 x$l(negative is good):0.6010811478841909
	 	 $w-$l: 42.11287845492121 -> 41.213878467259626  _ @double@	 lift : -0.8989999876615806 : bad	 :| stand

[Prob_ROI diff: -0.05934468997651465 (up%-> -5.5124532635131835) . o: 1.07655679131678 -> a: 1.0172121013402653	 returnMoney: o:0.1413314914682973 a: 12.248377833546137 (probReturnRate: 86.66418012218901	 totalSpendMoney: o: 0.13128103654933898 a: 12.041124773690594 (probTotalSpendRate: 91.72021405517478

[Time_ROI diff: -0.0055719663958366805 (up%-> -0.39208032772372076) . o: 1.4211287845492122 -> a: 1.4155568181533755	 returnMoney: o:8.6334E7 a: 3.7326696E9 (timeReturnRate: 43.23522134964209	 totalSpendMoney: o: 6.07503E7 a: 2.6368914E9 (timeTotalSpendRate: 43.4054054054054

[[Per_Prob_ROI diff: -0.026810259604395825 (up%-> -92.1437320691011) . o: 0.029096129495048105 -> a: 0.0022858698906522814	 per returnMoney: o:0.0038197700396837104 a: 0.0275244445697666	 per totalSpendMoney: o: 0.0035481361229551074 a: 0.027058707356608078

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.13785791496006947
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.19720260493658412
 probRunR/probTalSR= 0.944875467364868 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Six6, 	playerStartValue=4	@@@ 

net money diff:  0.4297709450560363 , up % -> 2797.3172133085695 .  o: 0.015363682853390737 -> a: 0.44513462790942704 (anet/onet: 28.973172133085697

[ProbMatrix: total: o: 4.3760345516457086E-4  -> a: 0.032406469166085805
org->adv	$w:52.62732579514143->47.7732492685654  	$d:6.448244164616362->2.731575281960226  	$l:40.92443004024221->49.495175449474374
	 improve value x$w(high is good):-4.85407652657603  	x$d:-3.716668882656136  	 x$l(negative is good):8.570745409232167
	 	 $w-$l: 11.70289575489923 -> -1.7219261809089725  _ #Surrender#	 lift : -13.4248219358082 : bad	 :| stand

[TimeMatrix: total:  o: 115033.0 -> a: 4265548.0
org->adv	$w:68.53598532594994->68.240469923208  	$d:5.012474681178444->4.706687159539642  	$l:26.45153999287161->27.052842917252367
	 improve value x$w(high is good):-0.2955154027419411  	x$d:-0.30578752163880285  	 x$l(negative is good):0.6013029243807573
	 	 $w-$l: 42.084445333078335 -> 41.187627005955626  _ @double@	 lift : -0.8968183271227115 : bad	 :| stand

[Prob_ROI diff: -0.08006109646713466 (up%-> -7.167325065839838) . o: 1.1170289575494985 -> a: 1.0369678610823638	 returnMoney: o:0.14664471940276388 a: 12.486259401606087 (probReturnRate: 85.14632816277701	 totalSpendMoney: o: 0.13128103654937315 a: 12.04112477369666 (probTotalSpendRate: 91.7202140551971

[Time_ROI diff: -0.005551127843015813 (up%-> -0.39069215704806415) . o: 1.4208444533307834 -> a: 1.4152933254877675	 returnMoney: o:4.90332E7 a: 2.1199908E9 (timeReturnRate: 43.235823890751576	 totalSpendMoney: o: 3.45099E7 a: 1.4979162E9 (timeTotalSpendRate: 43.4054054054054

[[Per_Prob_ROI diff: -0.02785970696929725 (up%-> -92.28132815154174) . o: 0.030189971825662115 -> a: 0.0023302648563648626	 per returnMoney: o:0.003963370794669294 a: 0.028059009891249636	 per totalSpendMoney: o: 0.003548136122956031 a: 0.02705870735662171

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.34970984858890164
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.4297709450560363
 probRunR/probTalSR= 0.9283267493416016 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Seven7, 	playerStartValue=4	@@@ 

net money diff:  0.7243637791585236 , up % -> 101.52332280235244 .  o: -0.7134949479231771 -> a: 0.010868831235346377 (anet/onet: -0.015233228023524333

[ProbMatrix: total: o: 0.032406469165538375  -> a: 4.3760345516426517E-4
org->adv	$w:40.213819729584586->48.253457855782806  	$d:8.726194218075282->11.772140823232693  	$l:51.05998605234012->39.97440132098451
	 improve value x$w(high is good):8.03963812619822  	x$d:3.045946605157411  	 x$l(negative is good):-11.08558473135561
	 	 $w-$l: -10.846166322755534 -> 8.279056534798295  _ @double@	 lift : 19.12522285755383 : good	 :) hit 

[TimeMatrix: total:  o: 9.1570228E7 -> a: 2214913.0
org->adv	$w:31.535011576033206->31.543044805823072  	$d:3.5558718932096576->3.5661897329601655  	$l:64.90911653075713->64.89076546121676
	 improve value x$w(high is good):0.008033229789866425  	x$d:0.010317839750507929  	 x$l(negative is good):-0.018351069540372578
	 	 $w-$l: -33.37410495472393 -> -33.34772065539369  _ #Surrender#	 lift : 0.026384299330245442 : good	 :| stand

[Prob_ROI diff: 0.14611066930669736 (up%-> 15.598783525115147) . o: 0.9366798960409242 -> a: 1.0827905653476215	 returnMoney: o:10.554568483942207 a: 0.14214986778474392 (probReturnRate: 0.013468089008187469	 totalSpendMoney: o: 11.268063431865384 a: 0.13128103654939755 (probTotalSpendRate: 0.011650718629977084

[Time_ROI diff: -0.0023685988862941487 (up%-> -0.35410814273376756) . o: 0.6688913923323573 -> a: 0.6665227934460631	 returnMoney: o:1.84352964E10 a: 4.42887E8 (timeReturnRate: 0.02402386109723736	 totalSpendMoney: o: 2.75609712E10 a: 6.644739E8 (timeTotalSpendRate: 0.024109233857477416

[[Per_Prob_ROI diff: 8.786956950954009E-4 (up%-> 1454.5178998758975) . o: 6.041147346281356E-5 -> a: 9.391071685582145E-4	 per returnMoney: o:6.807203149914355E-4 a: 1.232869625192922E-4	 per totalSpendMoney: o: 7.267374028936075E-4 a: 1.1386039596651999E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.8704744484652209
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.7243637791585236
 probRunR/probTalSR= 1.1559878352511515 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Eight8, 	playerStartValue=4	@@@ 

net money diff:  1.4657380255534376 , up % -> 99.46186031998047 .  o: -1.4736684200737713 -> a: -0.007930394520333714 (anet/onet: 0.005381396800195204

[ProbMatrix: total: o: 0.03240646916586674  -> a: 4.376034551643808E-4
org->adv	$w:36.81222586076046->38.36043516128193  	$d:8.588687380660616->17.238352784787118  	$l:54.59908675857893->44.401212053930955
	 improve value x$w(high is good):1.5482093005214637  	x$d:8.649665404126502  	 x$l(negative is good):-10.197874704647973
	 	 $w-$l: -17.786860897818467 -> -6.04077689264903  _ #Surrender#	 lift : 11.746084005169438 : good	 :) hit 

[TimeMatrix: total:  o: 5.4961204E7 -> a: 1329409.0
org->adv	$w:31.52567036195204->31.53326026828463  	$d:3.5575239581723865->3.5685782178396566  	$l:64.91680567987557->64.89816151387572
	 improve value x$w(high is good):0.007589906332587049  	x$d:0.011054259667270028  	 x$l(negative is good):-0.018644165999845086
	 	 $w-$l: -33.39113531792353 -> -33.36490124559109  _ #Surrender#	 lift : 0.02623407233243724 : good	 :| stand

[Prob_ROI diff: 0.07037498970393508 (up%-> 8.096363757472755) . o: 0.8692172413693813 -> a: 0.9395922310733164	 returnMoney: o:9.794395012018091 a: 0.1233506420291003 (probReturnRate: 0.012594003190370046	 totalSpendMoney: o: 11.268063432091862 a: 0.13128103654943402 (probTotalSpendRate: 0.01165071862974615

[Time_ROI diff: -0.0023698164330261395 (up%-> -0.35438054550299863) . o: 0.6687208039771153 -> a: 0.6663509875440892	 returnMoney: o:1.10621946E10 a: 2.657559E8 (timeReturnRate: 0.024023795423016695	 totalSpendMoney: o: 1.65423216E10 a: 3.988227E8 (timeTotalSpendRate: 0.024109233857477416

[[Per_Prob_ROI diff: 7.58850420547711E-4 (up%-> 1353.6288985772899) . o: 5.6060447685867864E-5 -> a: 8.149108682335789E-4	 per returnMoney: o:6.316926805558265E-4 a: 1.0698234347710348E-4	 per totalSpendMoney: o: 7.267374029082143E-4 a: 1.1386039596655162E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.5361130152573728
 按net净收益值(代表少输多赢) :  $Change$  Value: 1.4657380255534376
 probRunR/probTalSR= 1.0809636375747278 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Nine9, 	playerStartValue=4	@@@ 

net money diff:  2.2913650411150592 , up % -> 98.807907526738 .  o: -2.3190097821826683 -> a: -0.02764474106760889 (anet/onet: 0.011920924732619914

[ProbMatrix: total: o: 0.032406469165969225  -> a: 4.3760345516451974E-4
org->adv	$w:32.841639457633434->33.70129935686582  	$d:8.86538524531047->11.539720912746317  	$l:58.292975297056095->54.75897973038787
	 improve value x$w(high is good):0.8596598992323834  	x$d:2.6743356674358463  	 x$l(negative is good):-3.5339955666682243
	 	 $w-$l: -25.451335839422658 -> -21.057680373522054  _ #Surrender#	 lift : 4.393655465900603 : good	 :) hit 

[TimeMatrix: total:  o: 3.6656692E7 -> a: 886657.0
org->adv	$w:31.497430264574884->31.50530588491378  	$d:3.559753837034722->3.569813355108007  	$l:64.94281589839039->64.92488075997821
	 improve value x$w(high is good):0.007875620338896994  	x$d:0.010059518073284757  	 x$l(negative is good):-0.017935138412184415
	 	 $w-$l: -33.44538563381551 -> -33.41957487506443  _ #Surrender#	 lift : 0.02581075875108252 : good	 :| stand

[Prob_ROI diff: -0.004773047292270571 (up%-> -0.6009909176720027) . o: 0.7941962435571303 -> a: 0.7894231962648597	 returnMoney: o:8.949053650014283 a: 0.1036362954817916 (probReturnRate: 0.011580698868826894	 totalSpendMoney: o: 11.268063432196952 a: 0.1312810365494005 (probTotalSpendRate: 0.011650718629634517

[Time_ROI diff: -0.0023733013807691883 (up%-> -0.3551902292178541) . o: 0.6681775526301249 -> a: 0.6658042512493557	 returnMoney: o:7.3720008E9 a: 1.77102E8 (timeReturnRate: 0.024023600214476373	 totalSpendMoney: o: 1.10329968E10 a: 2.659971E8 (timeTotalSpendRate: 0.024109233857477416

[[Per_Prob_ROI diff: 6.334469164754943E-4 (up%-> 1236.67097642801) . o: 5.122194411848631E-5 -> a: 6.846688605939807E-4	 per returnMoney: o:5.771721154475513E-4 a: 8.988403771187476E-5	 per totalSpendMoney: o: 7.26737402914992E-4 a: 1.1386039596652253E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 2.286591993822789
 按net净收益值(代表少输多赢) :  $Change$  Value: 2.2913650411150592
 probRunR/probTalSR= 0.99399009082328 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Ten, 	playerStartValue=4	@@@ 

net money diff:  3.259849589633172 , up % -> 98.80422416554366 .  o: -3.2993018437869486 -> a: -0.0394522541537763 (anet/onet: 0.01195775834456325

[ProbMatrix: total: o: 0.0324064691660637  -> a: 4.376034551645484E-4
org->adv	$w:28.305944529504572->29.967470310016303  	$d:9.161913538356838->10.013305378962434  	$l:62.53214193213857->60.019224311021254
	 improve value x$w(high is good):1.661525780511731  	x$d:0.8513918406055954  	 x$l(negative is good):-2.5129176211173174
	 	 $w-$l: -34.226197402634 -> -30.051754001004955  _ #Surrender#	 lift : 4.174443401629047 : good	 :) hit 

[TimeMatrix: total:  o: 1.92115E7 -> a: 443905.0
org->adv	$w:31.402493298284885->31.464389903245067  	$d:3.5643755042552643->3.576891451999865  	$l:65.03313119745985->64.95871864475508
	 improve value x$w(high is good):0.061896604960182344  	x$d:0.01251594774460063  	 x$l(negative is good):-0.07441255270477143
	 	 $w-$l: -33.63063789917498 -> -33.49432874151001  _ #Surrender#	 lift : 0.13630915766496554 : good	 :) hit 

[Prob_ROI diff: 0.013851320060710548 (up%-> 2.02022913692884) . o: 0.6856311399293734 -> a: 0.699482459990084	 returnMoney: o:7.195700247214439 a: 0.09182878239561952 (probReturnRate: 0.012761618639015402	 totalSpendMoney: o: 10.495002091001387 a: 0.13128103654939582 (probTotalSpendRate: 0.012508909994592442

[Time_ROI diff: 7.17555674486503E-5 (up%-> 0.010790554987963014) . o: 0.6649849570174513 -> a: 0.6650567125849	 returnMoney: o:3.8385984E9 a: 8.85666E7 (timeReturnRate: 0.02307264026369625	 totalSpendMoney: o: 5.772459E9 a: 1.331715E8 (timeTotalSpendRate: 0.023070150866381207

[[Per_Prob_ROI diff: 5.644677360378922E-4 (up%-> 1337.7508267527812) . o: 4.2195282166864017E-5 -> a: 6.066630182047563E-4	 per returnMoney: o:4.428395745716314E-4 a: 7.964334986610539E-5	 per totalSpendMoney: o: 6.45886029355738E-4 a: 1.138603959665185E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 3.2737009096938827
 按net净收益值(代表少输多赢) :  $Change$  Value: 3.259849589633172
 probRunR/probTalSR= 1.0202022913692883 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 */
	}
	
	public static void test55vsAll() {
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
		
		System.out.println(t.diffWith(o));
		
		for(Card playerCard : Card.values()) {
			if(playerCard.getValue() == 5) {
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
MatrixKey [startValue=Five, dealerCard=One1, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Five, dealerCard=One1, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Five, dealerCard=Two2, situation=Splited_Pair_And_Can_Split] : Split -> Double
MatrixKey [startValue=Five, dealerCard=Two2, situation=Start_With_Pair] : Split -> Double
MatrixKey [startValue=Five, dealerCard=Three3, situation=Start_With_Pair] : Split -> Double
MatrixKey [startValue=Five, dealerCard=Three3, situation=Splited_Pair_And_Can_Split] : Split -> Double
MatrixKey [startValue=Five, dealerCard=Four4, situation=Splited_Pair_And_Can_Split] : Split -> Double
MatrixKey [startValue=Five, dealerCard=Four4, situation=Start_With_Pair] : Split -> Double
MatrixKey [startValue=Five, dealerCard=Five5, situation=Splited_Pair_And_Can_Split] : Split -> Double
MatrixKey [startValue=Five, dealerCard=Five5, situation=Start_With_Pair] : Split -> Double
MatrixKey [startValue=Five, dealerCard=Six6, situation=Splited_Pair_And_Can_Split] : Split -> Double
MatrixKey [startValue=Five, dealerCard=Six6, situation=Start_With_Pair] : Split -> Double
MatrixKey [startValue=Five, dealerCard=Seven7, situation=Start_With_Pair] : Split -> Double
MatrixKey [startValue=Five, dealerCard=Seven7, situation=Splited_Pair_And_Can_Split] : Split -> Double
MatrixKey [startValue=Five, dealerCard=Eight8, situation=Start_With_Pair] : Split -> Double
MatrixKey [startValue=Five, dealerCard=Eight8, situation=Splited_Pair_And_Can_Split] : Split -> Double
MatrixKey [startValue=Five, dealerCard=Nine9, situation=Splited_Pair_And_Can_Split] : Split -> Double
MatrixKey [startValue=Five, dealerCard=Nine9, situation=Start_With_Pair] : Split -> Double
MatrixKey [startValue=Five, dealerCard=Ten, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Five, dealerCard=Ten, situation=Start_With_Pair] : Split -> Hit


		 @@@   dealerCard=One1, 	playerStartValue=5	@@@ 

net money diff:  4.653577625609455 , up % -> 99.39120066370366 .  o: -4.682082110422558 -> a: -0.02850448481310279 (anet/onet: 0.006087993362963526

[ProbMatrix: total: o: 0.03240646916367095  -> a: 4.376034551636016E-4
org->adv	$w:20.934277696442255->32.70384438872668  	$d:9.971491454247396->12.879742856072124  	$l:69.09423084931035->54.41641275520119
	 improve value x$w(high is good):11.769566692284425  	x$d:2.908251401824728  	 x$l(negative is good):-14.677818094109156
	 	 $w-$l: -48.15995315286809 -> -21.71256836647451  _ #Surrender#	 lift : 26.44738478639358 : good	 :) hit 

[TimeMatrix: total:  o: 4.55654212E8 -> a: 5470465.0
org->adv	$w:31.590329730124388->31.80998324639679  	$d:3.509202280785676->3.5296451032956067  	$l:64.90046798908993->64.6603716503076
	 improve value x$w(high is good):0.21965351627240182  	x$d:0.02044282250993046  	 x$l(negative is good):-0.24009633878233672
	 	 $w-$l: -33.31013825896555 -> -32.85038840391081  _ #Surrender#	 lift : 0.4597498550547363 : good	 :) hit 

[Prob_ROI diff: 0.264473847881905 (up%-> 51.017285665491386) . o: 0.5184004684529852 -> a: 0.7828743163348901	 returnMoney: o:5.039858638528278 a: 0.10277655173652765 (probReturnRate: 0.02039274493749295	 totalSpendMoney: o: 9.721940748950836 a: 0.13128103654963044 (probTotalSpendRate: 0.013503583280303155

[Time_ROI diff: 0.004597498550547252 (up%-> 0.6893849275621453) . o: 0.6668986174103445 -> a: 0.6714961159608918	 returnMoney: o:9.11625492E10 a: 1.1020188E9 (timeReturnRate: 0.012088503554044977	 totalSpendMoney: o: 1.366962636E11 a: 1.6411395E9 (timeTotalSpendRate: 0.012005737807159786

[[Per_Prob_ROI diff: 0.0019843534775603883 (up%-> 4042.5806595149465) . o: 4.9086305127638024E-5 -> a: 0.002033439782688026	 per returnMoney: o:4.772141500358184E-4 a: 2.6695208243253935E-4	 per totalSpendMoney: o: 9.205511550942937E-4 a: 3.4098970532371543E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 4.91805147349136
 按net净收益值(代表少输多赢) :  $Change$  Value: 4.653577625609455
 probRunR/probTalSR= 1.510172856654914 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Two2, 	playerStartValue=5	@@@ 

net money diff:  1.332568394005095 , up % -> 103.71829192506534 .  o: -1.2847959306617316 -> a: 0.047772463343363325 (anet/onet: -0.03718291925065346

[ProbMatrix: total: o: 0.032406469165971084  -> a: 4.376034551648256E-4
org->adv	$w:40.38510136803743->55.15457999287062  	$d:3.2533875310674825->7.885571179974714  	$l:56.361511100895086->36.95984882715466
	 improve value x$w(high is good):14.76947862483319  	x$d:4.632183648907231  	 x$l(negative is good):-19.401662273740428
	 	 $w-$l: -15.976409732857661 -> 18.19473116571596  _ @double@	 lift : 34.17114089857362 : good	 :) hit 

[TimeMatrix: total:  o: 4.5584812E7 -> a: 346957.0
org->adv	$w:57.87777736145978->70.19918894848641  	$d:4.176891197884068->5.179316168862424  	$l:37.945331440656155->24.621494882651167
	 improve value x$w(high is good):12.321411587026631  	x$d:1.002424970978356  	 x$l(negative is good):-13.323836558004988
	 	 $w-$l: 19.932445920803627 -> 45.57769406583525  _ @double@	 lift : 25.645248145031623 : good	 :) hit 

[Prob_ROI diff: 0.2993853053386093 (up%-> 33.92229703922714) . o: 0.8825620063181614 -> a: 1.1819473116567707	 returnMoney: o:9.65541081488676 a: 0.31033453644220826 (probReturnRate: 0.03214099766358288	 totalSpendMoney: o: 10.940206745548492 a: 0.26256207309884494 (probTotalSpendRate: 0.023999735947008494

[Time_ROI diff: 0.23665674055064345 (up%-> 19.412092468793055) . o: 1.219120200107709 -> a: 1.4557769406583525	 returnMoney: o:1.79409564E10 a: 3.030552E8 (timeReturnRate: 0.016891808510275406	 totalSpendMoney: o: 1.47163146E10 a: 2.081742E8 (timeTotalSpendRate: 0.014145810663764961

[[Per_Prob_ROI diff: 0.089356967325247 (up%-> 5720.469063627947) . o: 0.0015620566483507284 -> a: 0.09091902397359773	 per returnMoney: o:0.017089222681215505 a: 0.023871887418631405	 per totalSpendMoney: o: 0.019363197779731844 a: 0.020197082546064997

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.6319536993437043
 按net净收益值(代表少输多赢) :  $Change$  Value: 1.332568394005095
 probRunR/probTalSR= 1.3392229703922711 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Three3, 	playerStartValue=5	@@@ 

net money diff:  0.9536828966692954 , up % -> 106.05545204809457 .  o: -0.8992304292256605 -> a: 0.054452467443634855 (anet/onet: -0.0605545204809457

[ProbMatrix: total: o: 0.0324064691660597  -> a: 4.376034551647308E-4
org->adv	$w:42.05331243816076->56.543931171348106  	$d:3.0691600156732823->7.651030674495936  	$l:54.87752754616595->35.80503815415595
	 improve value x$w(high is good):14.490618733187347  	x$d:4.581870658822654  	 x$l(negative is good):-19.07248939201
	 	 $w-$l: -12.824215108005188 -> 20.73889301719215  _ @double@	 lift : 33.56310812519734 : good	 :) hit 

[TimeMatrix: total:  o: 2.3205076E7 -> a: 202189.0
org->adv	$w:58.29881358716516->70.18037578701116  	$d:4.174345302726007->5.1822799459911275  	$l:37.52684111010884->24.63734426699771
	 improve value x$w(high is good):11.881562199846002  	x$d:1.0079346432651208  	 x$l(negative is good):-12.889496843111129
	 	 $w-$l: 20.771972477056316 -> 45.54303152001346  _ @double@	 lift : 24.771059042957138 : good	 :) hit 

[Prob_ROI diff: 0.28415917247822176 (up%-> 30.778814277839064) . o: 0.9232297576934863 -> a: 1.207388930171708	 returnMoney: o:10.814037657585677 a: 0.31701454054247796 (probReturnRate: 0.029315094933121774	 totalSpendMoney: o: 11.713268086811338 a: 0.2625620730988431 (probTotalSpendRate: 0.022415782781790617

[Time_ROI diff: 0.22006070615932138 (up%-> 17.813349506807498) . o: 1.235369609040813 -> a: 1.4554303152001344	 returnMoney: o:9.7989888E9 a: 1.765632E8 (timeReturnRate: 0.018018512277511736	 totalSpendMoney: o: 7.93203E9 a: 1.213134E8 (timeTotalSpendRate: 0.015294117647058824

[[Per_Prob_ROI diff: 0.09100339455837678 (up%-> 4859.535033767281) . o: 0.0018726769932930758 -> a: 0.09287607155166985	 per returnMoney: o:0.021935167662445593 a: 0.02438573388788292	 per totalSpendMoney: o: 0.023759164476290746 a: 0.020197082546064855

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.2378420691475172
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.9536828966692954
 probRunR/probTalSR= 1.3077881427783904 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Four4, 	playerStartValue=5	@@@ 

net money diff:  0.540793074373148 , up % -> 112.82398610261 .  o: -0.47932455947914576 -> a: 0.06146851489400229 (anet/onet: -0.12823986102610008

[ProbMatrix: total: o: 0.03240646916606296  -> a: 4.376034551646689E-4
org->adv	$w:44.19377776924805->58.014486582575294  	$d:2.535348680666999->7.382067953066125  	$l:53.270873550084964->34.603445464358565
	 improve value x$w(high is good):13.820708813327244  	x$d:4.846719272399126  	 x$l(negative is good):-18.6674280857264
	 	 $w-$l: -9.077095780836913 -> 23.41104111821673  _ @double@	 lift : 32.48813689905364 : good	 :) hit 

[TimeMatrix: total:  o: 7657612.0 -> a: 117949.0
org->adv	$w:68.02669030501937->70.16337569627551  	$d:4.690339494871247->5.185291948214906  	$l:27.28297020010938->24.651332355509584
	 improve value x$w(high is good):2.1366853912561368  	x$d:0.4949524533436591  	 x$l(negative is good):-2.631637844599794
	 	 $w-$l: 40.74372010490998 -> 45.51204334076593  _ @double@	 lift : 4.768323235855942 : good	 :) hit 

[Prob_ROI diff: 0.27503191625892354 (up%-> 28.676684725470036) . o: 0.9590784949232499 -> a: 1.2341104111821735	 returnMoney: o:11.23394352731656 a: 0.3240305879927952 (probReturnRate: 0.02884388613890389	 totalSpendMoney: o: 11.713268086795706 a: 0.2625620730987929 (probTotalSpendRate: 0.022415782781816246

[Time_ROI diff: 0.042551322449185136 (up%-> 3.012335617356993) . o: 1.4125691109584742 -> a: 1.4551204334076593	 returnMoney: o:4.0448052E9 a: 1.02978E8 (timeReturnRate: 0.025459322490981765	 totalSpendMoney: o: 2.8634388E9 a: 7.07694E7 (timeTotalSpendRate: 0.024714828897338403

[[Per_Prob_ROI diff: 0.09146919285294634 (up%-> 2641.803205304246) . o: 0.0034623772379900716 -> a: 0.09493157009093642	 per returnMoney: o:0.04055575280619697 a: 0.02492542984559963	 per totalSpendMoney: o: 0.04228616637832385 a: 0.020197082546060993

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.8158249906320716
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.540793074373148
 probRunR/probTalSR= 1.2867668472547005 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Five5, 	playerStartValue=5	@@@ 

net money diff:  0.09826487684066276 , up % -> 333.2508245455272 .  o: -0.029486761803116934 -> a: 0.06877811503754583 (anet/onet: -2.3325082454552724

[ProbMatrix: total: o: 0.032406469166095464  -> a: 4.376034551646534E-4
org->adv	$w:46.25803323898587->59.54792395042783  	$d:2.44028627779838->7.099144477826533  	$l:51.30168048321575->33.352931571745636
	 improve value x$w(high is good):13.289890711441963  	x$d:4.658858200028153  	 x$l(negative is good):-17.948748911470112
	 	 $w-$l: -5.043647244229882 -> 26.19499237868219  _ @double@	 lift : 31.238639622912075 : good	 :) hit 

[TimeMatrix: total:  o: 4619212.0 -> a: 71149.0
org->adv	$w:68.0148908515132->70.15277797298627  	$d:4.692228890988333->5.186299174970835  	$l:27.292880257498464->24.660922852042898
	 improve value x$w(high is good):2.137887121473071  	x$d:0.4940702839825022  	 x$l(negative is good):-2.631957405455566
	 	 $w-$l: 40.72201059401473 -> 45.49185512094337  _ @double@	 lift : 4.769844526928635 : good	 :) hit 

[Prob_ROI diff: 0.26446730506631866 (up%-> 26.513475032331907) . o: 0.9974826187205317 -> a: 1.2619499237868503	 returnMoney: o:11.683781325001991 a: 0.3313401881363373 (probReturnRate: 0.02835898575295193	 totalSpendMoney: o: 11.713268086805108 a: 0.2625620730987915 (probTotalSpendRate: 0.022415782781798132

[Time_ROI diff: 0.042565200957002114 (up%-> 3.013778453486472) . o: 1.4123533502524317 -> a: 1.4549185512094338	 returnMoney: o:2.439528E9 a: 6.21096E7 (timeReturnRate: 0.025459679085462435	 totalSpendMoney: o: 1.7272788E9 a: 4.26894E7 (timeTotalSpendRate: 0.024714828897338403

[[Per_Prob_ROI diff: 0.09347205077633731 (up%-> 2595.7101987658416) . o: 0.0036010202841896453 -> a: 0.09707307106052696	 per returnMoney: o:0.04217971597473643 a: 0.025487706779718254	 per totalSpendMoney: o: 0.04228616637835779 a: 0.020197082546060882

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.3627321819069814
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.09826487684066276
 probRunR/probTalSR= 1.2651347503233188 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Six6, 	playerStartValue=5	@@@ 

net money diff:  -0.11903622909621864 , up % -> -60.96051729902213 .  o: 0.1952677476674367 -> a: 0.07623151857121807 (anet/onet: 0.3903948270097787

[ProbMatrix: total: o: 0.0324064691661135  -> a: 4.376034551646558E-4
org->adv	$w:47.11413900231145->61.10339389825331  	$d:2.457565322534111->6.826925135264099  	$l:50.428295675154445->32.06968096648259
	 improve value x$w(high is good):13.989254895941862  	x$d:4.3693598127299875  	 x$l(negative is good):-18.35861470867185
	 	 $w-$l: -3.314156672842994 -> 29.033712931770715  _ @double@	 lift : 32.34786960461371 : good	 :) hit 

[TimeMatrix: total:  o: 2623996.0 -> a: 40417.0
org->adv	$w:68.00109451386359->70.13632877254621  	$d:4.693376056975697->5.190885023628671  	$l:27.305529429160714->24.672786203825122
	 improve value x$w(high is good):2.1352342586826154  	x$d:0.4975089666529744  	 x$l(negative is good):-2.6327432253355916
	 	 $w-$l: 40.69556508470288 -> 45.46354256872108  _ @double@	 lift : 4.767977484018204 : good	 :) hit 

[Prob_ROI diff: 0.2736664831564657 (up%-> 26.917909373086665) . o: 1.0166706461612716 -> a: 1.2903371293177373	 returnMoney: o:11.908535834484141 a: 0.33879359167001316 (probReturnRate: 0.028449642876242742	 totalSpendMoney: o: 11.713268086816704 a: 0.2625620730987951 (probTotalSpendRate: 0.022415782781776247

[Time_ROI diff: 0.04254713057440829 (up%-> 3.013064460746732) . o: 1.4120882951128026 -> a: 1.454635425687211	 returnMoney: o:1.3855416E9 a: 3.52752E7 (timeReturnRate: 0.02545950262337847	 totalSpendMoney: o: 9.812004E8 a: 2.42502E7 (timeTotalSpendRate: 0.024714828897338403

[[Per_Prob_ROI diff: 0.09558641111383415 (up%-> 2604.3277612573083) . o: 0.0036702911413764323 -> a: 0.09925670225521058	 per returnMoney: o:0.04299110409561062 a: 0.026061045513077936	 per totalSpendMoney: o: 0.04228616637839965 a: 0.02019708254606116

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.15463025406024705
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.11903622909621864
 probRunR/probTalSR= 1.2691790937308667 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Seven7, 	playerStartValue=5	@@@ 

net money diff:  1.1948171139052994 , up % -> 104.6091724051058 .  o: -1.142172417996285 -> a: 0.05264469590901433 (anet/onet: -0.046091724051057895

[ProbMatrix: total: o: 0.032406469165869256  -> a: 4.376034551646755E-4
org->adv	$w:38.497483949669736->56.25444575813202  	$d:8.42139867299897->7.541489442300053  	$l:53.08111737733129->36.20406479956792
	 improve value x$w(high is good):17.756961808462286  	x$d:-0.8799092306989174  	 x$l(negative is good):-16.877052577763372
	 	 $w-$l: -14.583633427661551 -> 20.0503809585641  _ @double@	 lift : 34.63401438622565 : good	 :) hit 

[TimeMatrix: total:  o: 5.4456508E7 -> a: 24973.0
org->adv	$w:31.589565015810418->70.08769471028711  	$d:3.5588877641585097->5.193609097825651  	$l:64.85154722003108->24.718696191887236
	 improve value x$w(high is good):38.49812969447669  	x$d:1.6347213336671413  	 x$l(negative is good):-40.13285102814385
	 	 $w-$l: -33.261982204220665 -> 45.36899851839987  _ @double@	 lift : 78.63098072262054 : good	 :) hit 

[Prob_ROI diff: 0.30490516548350144 (up%-> 34.04484447262351) . o: 0.8955986441021485 -> a: 1.20050380958565	 returnMoney: o:9.798034327151843 a: 0.31520676900780936 (probReturnRate: 0.03217040872517904	 totalSpendMoney: o: 10.940206745148128 a: 0.26256207309879503 (probTotalSpendRate: 0.02399973594788222

[Time_ROI diff: 0.7826130962924612 (up%-> 116.62048108751826) . o: 0.6710768888915374 -> a: 1.4536899851839986	 returnMoney: o:1.10136276E10 a: 2.17818E7 (timeReturnRate: 0.0019777135010448327	 totalSpendMoney: o: 1.64118714E10 a: 1.49838E7 (timeTotalSpendRate: 9.129854624622516E-4

[[Per_Prob_ROI diff: 0.09225162437727033 (up%-> 97288.73508030223) . o: 9.482251393352553E-5 -> a: 0.09234644689120386	 per returnMoney: o:0.0010373779065274583 a: 0.02424667453906226	 per totalSpendMoney: o: 0.0011583066961512046 a: 0.020197082546061156

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.4997222793888008
 按net净收益值(代表少输多赢) :  $Change$  Value: 1.1948171139052994
 probRunR/probTalSR= 1.3404484447262353 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Eight8, 	playerStartValue=5	@@@ 

net money diff:  1.9257884185685918 , up % -> 102.03885227745977 .  o: -1.887308976518149 -> a: 0.0384794420504429 (anet/onet: -0.02038852277459767

[ProbMatrix: total: o: 0.032406469166033354  -> a: 4.3760345516467733E-4
org->adv	$w:34.89852245632507->53.59621222030901  	$d:8.651601619574052->7.462945086405402  	$l:56.44987592410088->38.94084269328559
	 improve value x$w(high is good):18.697689763983945  	x$d:-1.1886565331686496  	 x$l(negative is good):-17.50903323081529
	 	 $w-$l: -21.551353467775808 -> 14.655369527023426  _ @double@	 lift : 36.206722994799236 : good	 :) hit 

[TimeMatrix: total:  o: 3.2685244E7 -> a: 14989.0
org->adv	$w:31.580220114006185->70.0647141236907  	$d:3.5604996554408466->5.21048769097338  	$l:64.85928023055297->24.724798185335914
	 improve value x$w(high is good):38.484494009684525  	x$d:1.6499880355325338  	 x$l(negative is good):-40.134482045217055
	 	 $w-$l: -33.27906011654677 -> 45.33991593835479  _ @double@	 lift : 78.61897605490157 : good	 :) hit 

[Prob_ROI diff: 0.31906496680810703 (up%-> 38.55822512544452) . o: 0.8274887284621316 -> a: 1.1465536952702386	 returnMoney: o:9.052897768777688 a: 0.3010415151492376 (probReturnRate: 0.03325360816372987	 totalSpendMoney: o: 10.940206745295837 a: 0.2625620730987947 (probTotalSpendRate: 0.023999735947558155

[Time_ROI diff: 0.7824934155543923 (up%-> 116.6323917706169) . o: 0.6709057438291557 -> a: 1.453399159383548	 returnMoney: o:6.608784E9 a: 1.3071E7 (timeReturnRate: 0.0019778222438500033	 totalSpendMoney: o: 9.8505402E9 a: 8993400.0 (timeTotalSpendRate: 9.129854624622516E-4

[[Per_Prob_ROI diff: 0.08810882679771467 (up%-> 100567.87971614026) . o: 8.761129999599064E-5 -> a: 0.08819643809771066	 per returnMoney: o:9.58485735180274E-4 a: 0.023157039626864433	 per totalSpendMoney: o: 0.0011583066961668436 a: 0.020197082546061132

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 2.244853385376699
 按net净收益值(代表少输多赢) :  $Change$  Value: 1.9257884185685918
 probRunR/probTalSR= 1.3855822512544453 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Nine9, 	playerStartValue=5	@@@ 

net money diff:  2.7386079969451553 , up % -> 100.73957472364583 .  o: -2.7185026385686566 -> a: 0.020105358376498794 (anet/onet: -0.00739574723645832

[ProbMatrix: total: o: 0.03240646916608264  -> a: 4.3760345516467706E-4
org->adv	$w:31.038007165249482->49.44728044144826  	$d:8.62362782336907->8.762812529497918  	$l:60.338365011381434->41.789907029053815
	 improve value x$w(high is good):18.409273276198775  	x$d:0.13918470612884803  	 x$l(negative is good):-18.54845798232762
	 	 $w-$l: -29.300357846131952 -> 7.657373412394447  _ @double@	 lift : 36.9577312585264 : good	 :) hit 

[TimeMatrix: total:  o: 2.1799612E7 -> a: 9997.0
org->adv	$w:31.55191018996118->70.05101530459137  	$d:3.5627881817346108->5.171551465439632  	$l:64.88530162830422->24.777433229968988
	 improve value x$w(high is good):38.4991051146302  	x$d:1.608763283705021  	 x$l(negative is good):-40.10786839833523
	 	 $w-$l: -33.333391438343035 -> 45.27358207462239  _ @double@	 lift : 78.60697351296541 : good	 :) hit 

[Prob_ROI diff: 0.3250610526762181 (up%-> 43.254233854046966) . o: 0.7515126814477253 -> a: 1.0765737341239434	 returnMoney: o:8.221704106818073 a: 0.28266743147529755 (probReturnRate: 0.03438063785838362	 totalSpendMoney: o: 10.94020674538673 a: 0.26256207309879875 (probTotalSpendRate: 0.02399973594735913

[Time_ROI diff: 0.782374532571865 (up%-> 116.709384383242) . o: 0.6703612881743588 -> a: 1.4527358207462238	 returnMoney: o:4.4041896E9 a: 8713800.0 (timeReturnRate: 0.0019785251752104404	 totalSpendMoney: o: 6.5698746E9 a: 5998200.0 (timeTotalSpendRate: 9.129854624622516E-4

[[Per_Prob_ROI diff: 0.08273379691282992 (up%-> 103979.71067319025) . o: 7.956725055031501E-5 -> a: 0.08281336416338024	 per returnMoney: o:8.704821711824324E-4 a: 0.021743648575022888	 per totalSpendMoney: o: 0.001158306696176467 a: 0.020197082546061444

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 3.0636690496213737
 按net净收益值(代表少输多赢) :  $Change$  Value: 2.7386079969451553
 probRunR/probTalSR= 1.4325423385404696 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Ten, 	playerStartValue=5	@@@ 

net money diff:  3.6248594137320618 , up % -> 99.84430829057096 .  o: -3.6305118196450907 -> a: -0.005652405913028735 (anet/onet: 0.0015569170942903857

[ProbMatrix: total: o: 0.032406469166120784  -> a: 4.3760345516457883E-4
org->adv	$w:26.901705155950033->39.520367832248226  	$d:8.557796562625402->16.653687489386797  	$l:64.54049828142456->43.82594467836498
	 improve value x$w(high is good):12.618662676298193  	x$d:8.095890926761395  	 x$l(negative is good):-20.714553603059578
	 	 $w-$l: -37.63879312547453 -> -4.305576846116754  _ #Surrender#	 lift : 33.33321627935778 : good	 :) hit 

[TimeMatrix: total:  o: 1.148686E7 -> a: 148225.0
org->adv	$w:31.44805455973173->31.580367684263788  	$d:3.566892954210289->3.5898127846179797  	$l:64.98505248605798->64.82981953111823
	 improve value x$w(high is good):0.13231312453205746  	x$d:0.022919830407690522  	 x$l(negative is good):-0.15523295493974842
	 	 $w-$l: -33.53699792632625 -> -33.24945184685445  _ #Surrender#	 lift : 0.287546079471801 : good	 :) hit 

[Prob_ROI diff: 0.30287192056119594 (up%-> 46.30557133790746) . o: 0.654072310977521 -> a: 0.956944231538717	 returnMoney: o:6.864490271410923 a: 0.12562863063638358 (probReturnRate: 0.01830123223564012	 totalSpendMoney: o: 10.495002091056014 a: 0.1312810365494123 (probTotalSpendRate: 0.012508909994528904

[Time_ROI diff: 7.204379997381993E-4 (up%-> 0.10804651464920417) . o: 0.6667850435317173 -> a: 0.6675054815314555	 returnMoney: o:2.303787E9 a: 2.96823E7 (timeReturnRate: 0.012884133819663015	 totalSpendMoney: o: 3.455067E9 a: 4.44675E7 (timeTotalSpendRate: 0.012870227986895768

[[Per_Prob_ROI diff: 0.002418942936594018 (up%-> 3630.6020618811353) . o: 6.662649597407773E-5 -> a: 0.0024855694325680955	 per returnMoney: o:6.992452145676808E-4 a: 3.263081315230742E-4	 per totalSpendMoney: o: 0.0010690640818025888 a: 3.409897053231489E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 3.927731334293258
 按net净收益值(代表少输多赢) :  $Change$  Value: 3.6248594137320618
 probRunR/probTalSR= 1.4630557133790745 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)
 
		 */
	}
	
	public static void test66vsAll() {
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
		
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
MatrixKey [startValue=Six, dealerCard=One1, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Six, dealerCard=One1, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Six, dealerCard=Two2, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Six, dealerCard=Two2, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Six, dealerCard=Three3, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Six, dealerCard=Three3, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Six, dealerCard=Four4, situation=Splited_Pair_And_Can_Split] : Split -> Stand
MatrixKey [startValue=Six, dealerCard=Four4, situation=Start_With_Pair] : Split -> Stand
MatrixKey [startValue=Six, dealerCard=Five5, situation=Start_With_Pair] : Hit -> Split
MatrixKey [startValue=Six, dealerCard=Five5, situation=Splited_Pair_And_Can_Split] : Hit -> Split
MatrixKey [startValue=Six, dealerCard=Six6, situation=Splited_Pair_And_Can_Split] : Hit -> Split
MatrixKey [startValue=Six, dealerCard=Six6, situation=Start_With_Pair] : Hit -> Split
MatrixKey [startValue=Six, dealerCard=Seven7, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Six, dealerCard=Seven7, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Six, dealerCard=Eight8, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Six, dealerCard=Eight8, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Six, dealerCard=Nine9, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Six, dealerCard=Nine9, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Six, dealerCard=Ten, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Six, dealerCard=Ten, situation=Start_With_Pair] : Split -> Hit


		 @@@   dealerCard=One1, 	playerStartValue=6	@@@ 

net money diff:  4.834972670894469 , up % -> 98.60422812443504 .  o: -4.903413132338408 -> a: -0.06844046144393903 (anet/onet: 0.013957718755649738

[ProbMatrix: total: o: 0.032406469165197765  -> a: 4.376034551644617E-4
org->adv	$w:19.880939026578933->19.380994124279503  	$d:9.80155523113255->9.105226055580633  	$l:70.31750574228853->71.51377982013986
	 improve value x$w(high is good):-0.4999449022994291  	x$d:-0.6963291755519165  	 x$l(negative is good):1.1962740778513279
	 	 $w-$l: -50.436566715709596 -> -52.13278569586036  _ #Surrender#	 lift : -1.6962189801507654 : bad	 :| stand

[TimeMatrix: total:  o: 2.59570012E8 -> a: 2742337.0
org->adv	$w:31.61818708087127->31.0800605468985  	$d:3.5113339671918653->3.4557386637747296  	$l:64.87047895193687->65.46420078932677
	 improve value x$w(high is good):-0.5381265339727683  	x$d:-0.0555953034171357  	 x$l(negative is good):0.5937218373898929
	 	 $w-$l: -33.2522918710656 -> -34.38414024242826  _ #Surrender#	 lift : -1.1318483713626593 : bad	 :| stand

[Prob_ROI diff: -0.016962189788473192 (up%-> -3.422319372359501) . o: 0.49563433282904557 -> a: 0.4786721430405724	 returnMoney: o:4.818527617201943 a: 0.06284057510589838 (probReturnRate: 0.0130414475329684	 totalSpendMoney: o: 9.721940749540352 a: 0.13128103654983742 (probTotalSpendRate: 0.01350358327950562

[Time_ROI diff: -0.011318483713626648 (up%-> -1.6957112132993535) . o: 0.667477081289344 -> a: 0.6561585975757174	 returnMoney: o:5.19771102E10 a: 5.398224E8 (timeReturnRate: 0.010385771696865134	 totalSpendMoney: o: 7.78710036E10 a: 8.227011E8 (timeTotalSpendRate: 0.010564922268447558

[[Per_Prob_ROI diff: 0.002397903584446019 (up%-> 2914.9250040493985) . o: 8.226295980565072E-5 -> a: 0.00248016654425167	 per returnMoney: o:7.997556211123558E-4 a: 3.2559883474558745E-4	 per totalSpendMoney: o: 0.0016136001244050377 a: 6.802126246105566E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=true]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 4.818010481105996
 按net净收益值(代表少输多赢) :  $Change$  Value: 4.834972670894469
 probRunR/probTalSR= 0.9657768062764049 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Two2, 	playerStartValue=6	@@@ 

net money diff:  1.0842580503123893 , up % -> 96.9916838428353 .  o: -1.1178876449545037 -> a: -0.033629594642114305 (anet/onet: 0.030083161571647015

[ProbMatrix: total: o: 0.0324064691659784  -> a: 4.376034551647138E-4
org->adv	$w:40.63774743225059->34.732539471798866  	$d:3.8511074579222933->4.918430262303315  	$l:55.51114510982711->60.34903026589782
	 improve value x$w(high is good):-5.905207960451726  	x$d:1.0673228043810217  	 x$l(negative is good):4.837885156070705
	 	 $w-$l: -14.873397677576516 -> -25.61649079409895  _ #Surrender#	 lift : -10.743093116522434 : bad	 :| stand

[TimeMatrix: total:  o: 2.6368732E7 -> a: 346957.0
org->adv	$w:59.0700379525265->46.568594955570866  	$d:4.206891707951675->3.233830128805587  	$l:36.723070339521826->50.197574915623555
	 improve value x$w(high is good):-12.501442996955632  	x$d:-0.9730615791460879  	 x$l(negative is good):13.47450457610173
	 	 $w-$l: 22.346967613004676 -> -3.6289799600526917  _ #Surrender#	 lift : -25.97594757305737 : bad	 :| stand

[Prob_ROI diff: -0.15695641025609908 (up%-> -17.424277410783066) . o: 0.9007915023148456 -> a: 0.7438350920587465	 returnMoney: o:10.150175787496659 a: 0.09765144190730492 (probReturnRate: 0.009620665095041543	 totalSpendMoney: o: 11.268063432451163 a: 0.13128103654941922 (probTotalSpendRate: 0.011650718629373337

[Time_ROI diff: -0.2941001072440992 (up%-> -23.381912634749913) . o: 1.2578103076435723 -> a: 0.9637102003994731	 returnMoney: o:1.15211208E10 a: 1.003098E8 (timeReturnRate: 0.008706600836960237	 totalSpendMoney: o: 9.1596648E9 a: 1.040871E8 (timeTotalSpendRate: 0.011363636363636364

[[Per_Prob_ROI diff: 0.0544464178435502 (up%-> 1964.393064730423) . o: 0.0027716661609687556 -> a: 0.05721808400451896	 per returnMoney: o:0.031231310115374337 a: 0.007511649377484993	 per totalSpendMoney: o: 0.03467096440754204 a: 0.010098541273032249

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.9273016400562903
 按net净收益值(代表少输多赢) :  $Change$  Value: 1.0842580503123893
 probRunR/probTalSR= 0.8257572258921692 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Three3, 	playerStartValue=6	@@@ 

net money diff:  0.6885653682080607 , up % -> 95.69078506404374 .  o: -0.7195733296024471 -> a: -0.03100796139438647 (anet/onet: 0.04309214935956267

[ProbMatrix: total: o: 0.032406469166055954  -> a: 4.3760345516469576E-4
org->adv	$w:42.339563522893826->35.80987075630178  	$d:3.6449852085698473->4.7607303290472105  	$l:54.01545126853633->59.42939891465101
	 improve value x$w(high is good):-6.529692766592049  	x$d:1.1157451204773632  	 x$l(negative is good):5.4139476461146785
	 	 $w-$l: -11.675887745642505 -> -23.619528158349233  _ #Surrender#	 lift : -11.94364041270673 : bad	 :| stand

[TimeMatrix: total:  o: 1.2006916E7 -> a: 202189.0
org->adv	$w:60.23211955509641->46.55495600650876  	$d:4.2081413745211504->3.2355865056951663  	$l:35.559739070382435->50.20945748779607
	 improve value x$w(high is good):-13.67716354858765  	x$d:-0.9725548688259842  	 x$l(negative is good):14.649718417413638
	 	 $w-$l: 24.672380484713972 -> -3.654501481287309  _ #Surrender#	 lift : -28.32688196600128 : bad	 :| stand

[Prob_ROI diff: -0.1764356376028885 (up%-> -18.7649505228514) . o: 0.9402403560192201 -> a: 0.7638047184163316	 returnMoney: o:11.32155144406385 a: 0.100273075155035 (probReturnRate: 0.008856831649836338	 totalSpendMoney: o: 12.041124773666297 a: 0.13128103654942147 (probTotalSpendRate: 0.010902722047738473

[Time_ROI diff: -0.3273228195334469 (up%-> -25.35857204364506) . o: 1.2907778047205738 -> a: 0.9634549851871269	 returnMoney: o:6.058776E9 a: 5.844E7 (timeReturnRate: 0.009645512558972308	 totalSpendMoney: o: 4.6938954E9 a: 6.06567E7 (timeTotalSpendRate: 0.012922465208747515

[[Per_Prob_ROI diff: 0.05503784406539435 (up%-> 1480.9590398245075) . o: 0.0037163650435542294 -> a: 0.05875420910894858	 per returnMoney: o:0.044749215193928264 a: 0.007713313473464231	 per totalSpendMoney: o: 0.047593378552040703 a: 0.01009854127303242

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.5121297306051722
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.6885653682080607
 probRunR/probTalSR= 0.812350494771486 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Four4, 	playerStartValue=6	@@@ 

net money diff:  0.2602948979913565 , up % -> 90.48933361564383 .  o: -0.28765257471888006 -> a: -0.02735767672752354 (anet/onet: 0.0951066638435617

[ProbMatrix: total: o: 0.032406469166144286  -> a: 4.3760345516467505E-4
org->adv	$w:44.41098005324091->39.58049180346542  	$d:3.2827981036209373->0.0  	$l:52.30622184313817->60.41950819653458
	 improve value x$w(high is good):-4.830488249775492  	x$d:-3.2827981036209373  	 x$l(negative is good):8.113286353396411
	 	 $w-$l: -7.895241789897256 -> -20.83901639306916  _ #Surrender#	 lift : -12.943774603171903 : bad	 :| stand

[TimeMatrix: total:  o: 4609084.0 -> a: 9073.0
org->adv	$w:67.81573084803834->57.91910062823763  	$d:4.5757465040776->0.0  	$l:27.608522647884048->42.08089937176237
	 improve value x$w(high is good):-9.896630219800713  	x$d:-4.5757465040776  	 x$l(negative is good):14.472376723878323
	 	 $w-$l: 40.2072082001543 -> 15.838201256475259  _ @double@	 lift : -24.36900694367904 : bad	 :| stand

[Prob_ROI diff: -0.18450098579120444 (up%-> -18.90164330311795) . o: 0.9761108218604981 -> a: 0.7916098360692937	 returnMoney: o:11.753472198980779 a: 0.10392335982188142 (probReturnRate: 0.00884192841591894	 totalSpendMoney: o: 12.041124773699659 a: 0.13128103654940496 (probTotalSpendRate: 0.010902722047706894

[Time_ROI diff: -0.2543288445353249 (up%-> -18.002894453391182) . o: 1.4127108571000775 -> a: 1.1583820125647526	 returnMoney: o:2.8531812E9 a: 3153000.0 (timeReturnRate: 0.001105082284994728	 totalSpendMoney: o: 2.0196498E9 a: 2721900.0 (timeTotalSpendRate: 0.0013477088948787063

[[Per_Prob_ROI diff: 0.7858340323896458 (up%-> 13605.622281773067) . o: 0.005775803679647918 -> a: 0.7916098360692937	 per returnMoney: o:0.0695471727750342 a: 0.10392335982188142	 per totalSpendMoney: o: 0.07124925901597431 a: 0.13128103654940496

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.07579391220015208
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.2602948979913565
 probRunR/probTalSR= 0.8109835669688206 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Five5, 	playerStartValue=6	@@@ 

net money diff:  0.1905934512820901 , up % -> 749.8695341550798 .  o: -0.025416881550847703 -> a: 0.1651765697312424 (anet/onet: -6.498695341550798

[ProbMatrix: total: o: 4.3760345516467207E-4  -> a: 0.032406469166145466
org->adv	$w:38.107831564400016->46.469073339761316  	$d:4.423671980891322->3.1367986235505616  	$l:57.468496454708664->50.39412803668814
	 improve value x$w(high is good):8.3612417753613  	x$d:-1.28687335734076  	 x$l(negative is good):-7.074368418020526
	 	 $w-$l: -19.360664890308648 -> -3.925054696926822  _ #Surrender#	 lift : 15.435610193381827 : good	 :) hit 

[TimeMatrix: total:  o: 71149.0 -> a: 2780284.0
org->adv	$w:46.53473696046325->67.80400851136072  	$d:3.2382746068110584->4.577230239788453  	$l:50.22698843272568->27.618761248850838
	 improve value x$w(high is good):21.26927155089747  	x$d:1.3389556329773948  	 x$l(negative is good):-22.608227183874845
	 	 $w-$l: -3.692251472262431 -> 40.185247262509876  _ @double@	 lift : 43.87749873477231 : good	 :) hit 

[Prob_ROI diff: 0.20732435159575102 (up%-> 25.710077013125776) . o: 0.8063933510969479 -> a: 1.013717702692699	 returnMoney: o:0.10586415499854851 a: 12.20630134342643 (probReturnRate: 115.30155172535774	 totalSpendMoney: o: 0.1312810365493962 a: 12.041124773695188 (probTotalSpendRate: 91.72021405516978

[Time_ROI diff: 0.44941698032514343 (up%-> 46.664675189214606) . o: 0.9630774852773757 -> a: 1.4124944656025191	 returnMoney: o:2.05566E7 a: 1.7208276E9 (timeReturnRate: 83.71168383876712	 totalSpendMoney: o: 2.13447E7 a: 1.2182898E9 (timeTotalSpendRate: 57.07692307692308

[[Per_Prob_ROI diff: -0.056031928174956364 (up%-> -90.3299940759134) . o: 0.06203025777668831 -> a: 0.0059983296017319465	 per returnMoney: o:0.008143396538349886 a: 0.07222663516820373	 per totalSpendMoney: o: 0.010098541273030478 a: 0.07124925901594786

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.3979178028778411
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.1905934512820901
 probRunR/probTalSR= 1.2571007701312578 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Six6, 	playerStartValue=6	@@@ 

net money diff:  0.44358876136103503 , up % -> 1945.237608312475 .  o: -0.0228038343216002 -> a: 0.4207849270394348 (anet/onet: -18.45237608312475

[ProbMatrix: total: o: 4.3760345516467364E-4  -> a: 0.0324064691661446
org->adv	$w:39.11497339361959->47.314925863092974  	$d:4.399810776396415->3.397837877864038  	$l:56.48521582998399->49.287236259042984
	 improve value x$w(high is good):8.19995246947338  	x$d:-1.0019728985323773  	 x$l(negative is good):-7.197979570941008
	 	 $w-$l: -17.370242436364396 -> -1.972310395950011  _ #Surrender#	 lift : 15.397932040414386 : good	 :) hit 

[TimeMatrix: total:  o: 40417.0 -> a: 1579372.0
org->adv	$w:46.524977113590815->67.78972908219217  	$d:3.2387361753717494->4.5792884766856705  	$l:50.23628671103744->27.630982441122164
	 improve value x$w(high is good):21.264751968601352  	x$d:1.3405523013139211  	 x$l(negative is good):-22.605304269915273
	 	 $w-$l: -3.7113095974466215 -> 40.158746641069996  _ @double@	 lift : 43.87005623851662 : good	 :) hit 

[Prob_ROI diff: 0.20864807395597695 (up%-> 25.250960441858545) . o: 0.8262975756363738 -> a: 1.0349456495923508	 returnMoney: o:0.10847720222779751 a: 12.461909700737763 (probReturnRate: 114.88044902345732	 totalSpendMoney: o: 0.1312810365493977 a: 12.041124773698328 (probTotalSpendRate: 91.72021405519266

[Time_ROI diff: 0.44934122420664846 (up%-> 46.666043782306225) . o: 0.9628869040255338 -> a: 1.4122281282321822	 returnMoney: o:1.16751E7 a: 9.773514E8 (timeReturnRate: 83.71246498959324	 totalSpendMoney: o: 1.21251E7 a: 6.920634E8 (timeTotalSpendRate: 57.07692307692308

[[Per_Prob_ROI diff: -0.05743741321704443 (up%-> -90.36531073524165) . o: 0.06356135197202875 -> a: 0.006123938754984324	 per returnMoney: o:0.008344400171369039 a: 0.07373911065525304	 per totalSpendMoney: o: 0.010098541273030594 a: 0.07124925901596645

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.6522368353170119
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.44358876136103503
 probRunR/probTalSR= 1.2525096044185853 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Seven7, 	playerStartValue=6	@@@ 

net money diff:  1.2976170658439696 , up % -> 97.83646168429868 .  o: -1.326312341539042 -> a: -0.028695275695072492 (anet/onet: 0.02163538315701317

[ProbMatrix: total: o: 0.03240646916605486  -> a: 4.3760345516454695E-4
org->adv	$w:36.623741333337726->35.274437136656935  	$d:9.605620472021975->7.5932272447408575  	$l:53.770638194640284->57.132335618602205
	 improve value x$w(high is good):-1.3493041966807908  	x$d:-2.012393227281118  	 x$l(negative is good):3.361697423961921
	 	 $w-$l: -17.146896861302558 -> -21.857898481945266  _ #Surrender#	 lift : -4.711001620642707 : bad	 :| stand

[TimeMatrix: total:  o: 2.6517484E7 -> a: 370753.0
org->adv	$w:31.842402544675807->30.933802288855382  	$d:3.5686115620923915->3.49990424892044  	$l:64.5889858932318->65.56629346222418
	 improve value x$w(high is good):-0.9086002558204243  	x$d:-0.06870731317195133  	 x$l(negative is good):0.9773075689923871
	 	 $w-$l: -32.746583348555994 -> -34.6324911733688  _ #Surrender#	 lift : -1.8859078248128047 : bad	 :| stand

[Prob_ROI diff: -0.10087354683383043 (up%-> -11.433091756064327) . o: 0.8822945620140344 -> a: 0.781421015180204	 returnMoney: o:9.941751090646509 a: 0.10258576085439206 (probReturnRate: 0.010318681278482997	 totalSpendMoney: o: 11.268063432185551 a: 0.13128103654946455 (probTotalSpendRate: 0.011650718629651991

[Time_ROI diff: -0.027807141768486532 (up%-> -4.080391320998438) . o: 0.6814822300347986 -> a: 0.653675088266312	 returnMoney: o:5.4826254E9 a: 7.27056E7 (timeReturnRate: 0.013261092030836176	 totalSpendMoney: o: 8.045148E9 a: 1.112259E8 (timeTotalSpendRate: 0.013825214899713468

[[Per_Prob_ROI diff: 0.0038543470388022914 (up%-> 1982.010687578944) . o: 1.944665113542064E-4 -> a: 0.004048813550156498	 per returnMoney: o:0.0021912609853750294 a: 5.315324396600625E-4	 per totalSpendMoney: o: 0.0024835934388771326 a: 6.802126246086246E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.1967435190101392
 按net净收益值(代表少输多赢) :  $Change$  Value: 1.2976170658439696
 probRunR/probTalSR= 0.8856690824393566 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Eight8, 	playerStartValue=6	@@@ 

net money diff:  2.1239456037681106 , up % -> 98.32104391957914 .  o: -2.160214659137848 -> a: -0.036269055369737596 (anet/onet: 0.016789560804208573

[ProbMatrix: total: o: 0.032406469166107586  -> a: 4.3760345516462794E-4
org->adv	$w:33.40374626843834->32.36933386467774  	$d:8.336731851987368->7.6342992101321645  	$l:58.25952187957428->59.996366925190095
	 improve value x$w(high is good):-1.034412403760598  	x$d:-0.7024326418552036  	 x$l(negative is good):1.7368450456158158
	 	 $w-$l: -24.855775611135943 -> -27.627033060512353  _ #Surrender#	 lift : -2.7712574493764075 : bad	 :| stand

[TimeMatrix: total:  o: 1.5916012E7 -> a: 222529.0
org->adv	$w:31.832936542143848->30.924508715717952  	$d:3.5704295774594796->3.5015660880154944  	$l:64.59663388039667->65.57392519626656
	 improve value x$w(high is good):-0.9084278264258963  	x$d:-0.06886348944398524  	 x$l(negative is good):0.9772913158698913
	 	 $w-$l: -32.763697338252825 -> -34.64941648054861  _ #Surrender#	 lift : -1.885719142295783 : bad	 :| stand

[Prob_ROI diff: -0.08455906876147345 (up%-> -10.461492876218436) . o: 0.8082887381560728 -> a: 0.7237296693945994	 returnMoney: o:9.107848773131911 a: 0.09501198117971735 (probReturnRate: 0.010431879530103971	 totalSpendMoney: o: 11.26806343226976 a: 0.13128103654945494 (probTotalSpendRate: 0.01165071862956407

[Time_ROI diff: -0.027804288886927986 (up%-> -4.08100333521601) . o: 0.681310124081442 -> a: 0.653505835194514	 returnMoney: o:3.2898858E9 a: 4.36272E7 (timeReturnRate: 0.01326100741855538	 totalSpendMoney: o: 4.828764E9 a: 6.67587E7 (timeTotalSpendRate: 0.013825214899713468

[[Per_Prob_ROI diff: 0.003571739769584996 (up%-> 2004.8508125419532) . o: 1.7815489049064864E-4 -> a: 0.0037498946600756445	 per returnMoney: o:0.0020074606068177015 a: 4.922900579259966E-4	 per totalSpendMoney: o: 0.002483593438895693 a: 6.802126246085748E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 2.039386535006637
 按net净收益值(代表少输多赢) :  $Change$  Value: 2.1239456037681106
 probRunR/probTalSR= 0.8953850712378156 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Nine9, 	playerStartValue=6	@@@ 

net money diff:  2.9035156810778795 , up % -> 98.47275682083415 .  o: -2.9485471665637117 -> a: -0.045031485485832454 (anet/onet: 0.015272431791658578

[ProbMatrix: total: o: 0.032406469166140796  -> a: 4.3760345516463255E-4
org->adv	$w:29.831105948909347->28.882581742440642  	$d:8.410041178765875->7.933244549200934  	$l:61.75885287232477->63.18417370835843
	 improve value x$w(high is good):-0.9485242064687043  	x$d:-0.47679662956494084  	 x$l(negative is good):1.4253208360336558
	 	 $w-$l: -31.92774692341543 -> -34.30159196591778  _ #Surrender#	 lift : -2.373845042502354 : bad	 :| stand

[TimeMatrix: total:  o: 1.0615276E7 -> a: 148417.0
org->adv	$w:31.80458049324389->30.89673015894406  	$d:3.572530756619046->3.5036417661049613  	$l:64.62288875013707->65.59962807495097
	 improve value x$w(high is good):-0.9078503342998303  	x$d:-0.06888899051408481  	 x$l(negative is good):0.9767393248139058
	 	 $w-$l: -32.818308256893175 -> -34.70289791600692  _ #Surrender#	 lift : -1.8845896591137445 : bad	 :| stand

[Prob_ROI diff: -0.08134299029808811 (up%-> -11.017202745622441) . o: 0.7383270706387682 -> a: 0.6569840803406801	 returnMoney: o:8.319516265757672 a: 0.08624955106360026 (probReturnRate: 0.010367135336773739	 totalSpendMoney: o: 11.268063432321384 a: 0.1312810365494327 (probTotalSpendRate: 0.01165071862950872

[Time_ROI diff: -0.027790471218001822 (up%-> -4.082262516640243) . o: 0.6807614920579326 -> a: 0.6529710208399307	 returnMoney: o:2.1924414E9 a: 2.90736E7 (timeReturnRate: 0.013260833334017503	 totalSpendMoney: o: 3.220572E9 a: 4.45251E7 (timeTotalSpendRate: 0.013825214899713468

[[Per_Prob_ROI diff: 0.0032413279504641553 (up%-> 1991.7873116223361) . o: 1.627346419746018E-4 -> a: 0.003404062592438757	 per returnMoney: o:0.001833704268405923 a: 4.468888656145091E-4	 per totalSpendMoney: o: 0.0024835934389070714 a: 6.802126246084596E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 2.8221726907797913
 按net净收益值(代表少输多赢) :  $Change$  Value: 2.9035156810778795
 probRunR/probTalSR= 0.8898279725437754 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Ten, 	playerStartValue=6	@@@ 

net money diff:  3.78282740166407 , up % -> 98.55381979823099 .  o: -3.8383366666138805 -> a: -0.055509264949810136 (anet/onet: 0.014461802017690003

[ProbMatrix: total: o: 0.032406469166140005  -> a: 4.3760345516463206E-4
org->adv	$w:25.825531932791375->24.80618102382986  	$d:8.577241898194968->8.104863220513488  	$l:65.59722616901365->67.08895575565664
	 improve value x$w(high is good):-1.0193509089615134  	x$d:-0.4723786776814798  	 x$l(negative is good):1.4917295866429896
	 	 $w-$l: -39.77169423622228 -> -42.28277473182678  _ #Surrender#	 lift : -2.511080495604495 : bad	 :| stand

[TimeMatrix: total:  o: 6173860.0 -> a: 74305.0
org->adv	$w:31.551865445604534->30.856604535361008  	$d:3.571963083063108->3.5098580176300382  	$l:64.87617147133236->65.63353744700895
	 improve value x$w(high is good):-0.6952609102435261  	x$d:-0.06210506543306993  	 x$l(negative is good):0.757365975676592
	 	 $w-$l: -33.32430602572782 -> -34.77693291164794  _ #Surrender#	 lift : -1.4526268859201164 : bad	 :| stand

[Prob_ROI diff: -0.05709779002029136 (up%-> -9.002126251629257) . o: 0.6342700427019392 -> a: 0.5771722526816478	 returnMoney: o:6.656665424466484 a: 0.07577177159961133 (probReturnRate: 0.011382842124093125	 totalSpendMoney: o: 10.495002091080364 a: 0.13128103654942147 (probTotalSpendRate: 0.012508909994500753

[Time_ROI diff: -0.01851655384161155 (up%-> -2.760585979196487) . o: 0.6707472247251322 -> a: 0.6522306708835206	 returnMoney: o:1.2483726E9 a: 1.45392E7 (timeReturnRate: 0.011646522841017177	 totalSpendMoney: o: 1.861167E9 a: 2.22915E7 (timeTotalSpendRate: 0.011977162715650986

[[Per_Prob_ROI diff: 0.002870425651612838 (up%-> 2389.9470013738132) . o: 1.201041550278241E-4 -> a: 0.0029905298066406623	 per returnMoney: o:0.0012604933581644544 a: 3.925998528477271E-4	 per totalSpendMoney: o: 0.0019873134048627845 a: 6.802126246084014E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 3.725729611643779
 按net净收益值(代表少输多赢) :  $Change$  Value: 3.78282740166407
 probRunR/probTalSR= 0.9099787374837075 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

		 */
	}
	
	public static void test77vsAll() {
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
		
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
MatrixKey [startValue=Seven, dealerCard=Four4, situation=Splited_Pair_And_Can_Split] : Stand -> Split
MatrixKey [startValue=Seven, dealerCard=Four4, situation=Start_With_Pair] : Stand -> Split
MatrixKey [startValue=Seven, dealerCard=Five5, situation=Start_With_Pair] : Stand -> Split
MatrixKey [startValue=Seven, dealerCard=Five5, situation=Splited_Pair_And_Can_Split] : Stand -> Split
MatrixKey [startValue=Seven, dealerCard=Six6, situation=Start_With_Pair] : Stand -> Split
MatrixKey [startValue=Seven, dealerCard=Six6, situation=Splited_Pair_And_Can_Split] : Stand -> Split
MatrixKey [startValue=Seven, dealerCard=Seven7, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Seven, dealerCard=Seven7, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Seven, dealerCard=Eight8, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Seven, dealerCard=Eight8, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Seven, dealerCard=Nine9, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Seven, dealerCard=Nine9, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Seven, dealerCard=Ten, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Seven, dealerCard=Ten, situation=Start_With_Pair] : Split -> Giveup


		 @@@   dealerCard=One1, 	playerStartValue=7	@@@ 

net money diff:  4.765635415818406 , up % -> 98.3930692686094 .  o: -4.843466568573443 -> a: -0.07783115275503695 (anet/onet: 0.01606930731390611

[ProbMatrix: total: o: 0.03240646916556775  -> a: 4.3760345516440915E-4
org->adv	$w:19.371103657399345->16.50004826544945  	$d:11.437837047431247->7.71399683650005  	$l:69.1910592951694->75.78595489805049
	 improve value x$w(high is good):-2.871055391949895  	x$d:-3.723840210931196  	 x$l(negative is good):6.594895602881095
	 	 $w-$l: -49.81995563777005 -> -59.28590663260104  _ #Surrender#	 lift : -9.465950994830985 : bad	 :| stand

[TimeMatrix: total:  o: 1.62380452E8 -> a: 696241.0
org->adv	$w:31.681535164097212->30.604345334445977  	$d:3.520689793374882->3.4028447046353203  	$l:64.7977750425279->65.9928099609187
	 improve value x$w(high is good):-1.0771898296512354  	x$d:-0.1178450887395619  	 x$l(negative is good):1.1950349183908031
	 	 $w-$l: -33.11623987843069 -> -35.38846462647273  _ #Surrender#	 lift : -2.27222474804204 : bad	 :| stand

[Prob_ROI diff: -0.09465950994506755 (up%-> -18.86397494239223) . o: 0.5018004436188216 -> a: 0.40714093367375404	 returnMoney: o:4.878474180943502 a: 0.053449883794393235 (probReturnRate: 0.010956270713327006	 totalSpendMoney: o: 9.721940749516945 a: 0.13128103654943019 (probTotalSpendRate: 0.013503583279496243

[Time_ROI diff: -0.0227222474804204 (up%-> -3.3972742320587193) . o: 0.6688376012156931 -> a: 0.6461153537352727	 returnMoney: o:3.25818456E10 a: 1.349556E8 (timeReturnRate: 0.004142048969748969	 totalSpendMoney: o: 4.87141356E10 a: 2.088723E8 (timeTotalSpendRate: 0.004287714385719286

[[Per_Prob_ROI diff: 0.008176702194091301 (up%-> 6180.590674357271) . o: 1.322964523118433E-4 -> a: 0.008308998646403144	 per returnMoney: o:0.0012861782707470344 a: 0.0010908139549876171	 per totalSpendMoney: o: 0.0025631270101547443 a: 0.0026792048275393917

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=true]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 4.670975905873338
 按net净收益值(代表少输多赢) :  $Change$  Value: 4.765635415818406     $$$非常重要的指标!
 probRunR/probTalSR= 0.8113602505760777 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Two2, 	playerStartValue=7	@@@ 

net money diff:  0.6433306992166721 , up % -> 94.35836771729569 .  o: -0.6817950699869417 -> a: -0.03846437077026971 (anet/onet: 0.056416322827043036

[ProbMatrix: total: o: 0.03240646916610977  -> a: 4.3760345516467684E-4
org->adv	$w:40.93195528999128->35.3503705556954  	$d:7.776712556525983->0.0  	$l:51.29133215348273->64.6496294443046
	 improve value x$w(high is good):-5.58158473429588  	x$d:-7.776712556525983  	 x$l(negative is good):13.358297290821866
	 	 $w-$l: -10.359376863491448 -> -29.29925888860919  _ #Surrender#	 lift : -18.939882025117743 : bad	 :| stand

[TimeMatrix: total:  o: 1.547962E7 -> a: 26689.0
org->adv	$w:59.950179655572946->57.960208325527375  	$d:4.437860877721804->0.0  	$l:35.61195946670526->42.03979167447263
	 improve value x$w(high is good):-1.9899713300455701  	x$d:-4.437860877721804  	 x$l(negative is good):6.4278322077673735
	 	 $w-$l: 24.338220188867687 -> 15.920416651054742  _ @double@	 lift : -8.417803537812945 : bad	 :| stand

[Prob_ROI diff: -0.23248573479555013 (up%-> -24.74586811067275) . o: 0.9394931459093988 -> a: 0.7070074111138487	 returnMoney: o:10.586268362397796 a: 0.09281666577914238 (probReturnRate: 0.008767647163454238	 totalSpendMoney: o: 11.268063432384738 a: 0.1312810365494121 (probTotalSpendRate: 0.011650718629441384

[Time_ROI diff: -0.13333473161879095 (up%-> -10.315722939693591) . o: 1.2925388981293384 -> a: 1.1592041665105475	 returnMoney: o:7.6168428E9 a: 9281400.0 (timeReturnRate: 0.0012185363731019893	 totalSpendMoney: o: 5.8929312E9 a: 8006700.0 (timeTotalSpendRate: 0.001358695652173913

[[Per_Prob_ROI diff: 0.7021395709796031 (up%-> 14424.047454640162) . o: 0.0048678401342455895 -> a: 0.7070074111138487	 per returnMoney: o:0.05485113141138754 a: 0.09281666577914238	 per totalSpendMoney: o: 0.05838374835432506 a: 0.1312810365494121

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.4108449644211219
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.6433306992166721     $$$非常重要的指标!
 probRunR/probTalSR= 0.7525413188932724 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Three3, 	playerStartValue=7	@@@ 

net money diff:  0.27070281236065247 , up % -> 89.12476519605336 .  o: -0.30373467101447105 -> a: -0.03303185865381858 (anet/onet: 0.10875234803946639

[ProbMatrix: total: o: 0.032406469166165436  -> a: 4.37603455164674E-4
org->adv	$w:42.60052166145818->37.41940971749486  	$d:7.427758584716539->0.0  	$l:49.9717197538253->62.58059028250514
	 improve value x$w(high is good):-5.181111943963323  	x$d:-7.427758584716539  	 x$l(negative is good):12.608870528679844
	 	 $w-$l: -7.3711980923671145 -> -25.161180565010287  _ #Surrender#	 lift : -17.789982472643175 : bad	 :| stand

[TimeMatrix: total:  o: 5661292.0 -> a: 15553.0
org->adv	$w:62.955240605854634->57.937375425962834  	$d:4.5750687298941655->0.0  	$l:32.469690664251196->42.06262457403716
	 improve value x$w(high is good):-5.0178651798918  	x$d:-4.5750687298941655  	 x$l(negative is good):9.592933909785962
	 	 $w-$l: 30.485549941603434 -> 15.874750851925674  _ @double@	 lift : -14.610799089677762 : bad	 :| stand

[Prob_ROI diff: -0.22638702999809435 (up%-> -23.224536728406157) . o: 0.974775224347955 -> a: 0.7483881943498607	 returnMoney: o:11.737390102670012 a: 0.09824917789558982 (probReturnRate: 0.00837061536135194	 totalSpendMoney: o: 12.041124773684484 a: 0.1312810365494084 (probTotalSpendRate: 0.010902722047720921

[Time_ROI diff: -0.1974717155515493 (up%-> -14.560456897139485) . o: 1.356219224070806 -> a: 1.1587475085192567	 returnMoney: o:3.784134E9 a: 5406600.0 (timeReturnRate: 0.0014287549013856276	 totalSpendMoney: o: 2.7902082E9 a: 4665900.0 (timeTotalSpendRate: 0.0016722408026755853

[[Per_Prob_ROI diff: 0.7403322007602082 (up%-> 9189.831055862856) . o: 0.00805599358965252 -> a: 0.7483881943498607	 per returnMoney: o:0.09700322398900836 a: 0.09824917789558982	 per totalSpendMoney: o: 0.09951342788168994 a: 0.1312810365494084

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.04431578236255812
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.27070281236065247     $$$非常重要的指标!
 probRunR/probTalSR= 0.7677546327159384 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Four4, 	playerStartValue=7	@@@ 

net money diff:  0.14086960267247173 , up % -> 514.9180029996775 .  o: -0.02735767672752354 -> a: 0.11351192594494819 (anet/onet: -4.149180029996775

[ProbMatrix: total: o: 4.3760345516467505E-4  -> a: 0.03240646916616056
org->adv	$w:39.58049180346542->44.71711174005393  	$d:0.0->6.823328766452659  	$l:60.41950819653458->48.45955949349341
	 improve value x$w(high is good):5.1366199365885095  	x$d:6.823328766452659  	 x$l(negative is good):-11.95994870304117
	 	 $w-$l: -20.83901639306916 -> -3.7424477534394764  _ #Surrender#	 lift : 17.096568639629684 : good	 :) hit 

[TimeMatrix: total:  o: 9073.0 -> a: 2649316.0
org->adv	$w:57.91910062823763->67.21583986206251  	$d:0.0->4.840645660993252  	$l:42.08089937176237->27.943514476944237
	 improve value x$w(high is good):9.29673923382488  	x$d:4.840645660993252  	 x$l(negative is good):-14.137384894818133
	 	 $w-$l: 15.838201256475259 -> 39.27232538511827  _ @double@	 lift : 23.434124128643013 : good	 :) hit 

[Prob_ROI diff: 0.2178171840869051 (up%-> 27.51572481318163) . o: 0.7916098360692937 -> a: 1.0094270201561988	 returnMoney: o:0.10392335982188142 a: 12.154636699642046 (probReturnRate: 116.9576957526622	 totalSpendMoney: o: 0.13128103654940496 a: 12.041124773697097 (probTotalSpendRate: 91.72021405517822

[Time_ROI diff: 0.2535077753364241 (up%-> 21.88464363108826) . o: 1.1583820125647526 -> a: 1.4118897879011767	 returnMoney: o:3153000.0 a: 2.02143E9 (timeReturnRate: 641.1132254995242	 totalSpendMoney: o: 2721900.0 a: 1.4317194E9 (timeTotalSpendRate: 526.0

[[Per_Prob_ROI diff: -0.781203371943972 (up%-> -98.68540489883318) . o: 0.7916098360692937 -> a: 0.01040646412532164	 per returnMoney: o:0.10392335982188142 a: 0.12530553298600047	 per totalSpendMoney: o: 0.13128103654940496 a: 0.1241353069453309

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.3586867867593768
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.14086960267247173     $$$非常重要的指标!
 probRunR/probTalSR= 1.2751572481318163 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Five5, 	playerStartValue=7	@@@ 

net money diff:  0.5618425412707765 , up % -> 2622.55192487151 .  o: -0.021423504943502827 -> a: 0.5404190363272736 (anet/onet: -25.2255192487151

[ProbMatrix: total: o: 4.376034551646746E-4  -> a: 0.032406469166156776
org->adv	$w:41.84059422952501->46.744049503732136  	$d:0.0->6.471699800461297  	$l:58.15940577047499->46.78425069580656
	 improve value x$w(high is good):4.903455274207126  	x$d:6.471699800461297  	 x$l(negative is good):-11.375155074668427
	 	 $w-$l: -16.31881154094998 -> -0.040201192074429404  _ #Surrender#	 lift : 16.27861034887555 : good	 :) hit 

[TimeMatrix: total:  o: 5473.0 -> a: 1598116.0
org->adv	$w:57.90243011145624->67.20363227700618  	$d:0.0->4.8432028713810515  	$l:42.09756988854376->27.953164851612772
	 improve value x$w(high is good):9.301202165549938  	x$d:4.8432028713810515  	 x$l(negative is good):-14.144405036930987
	 	 $w-$l: 15.804860222912476 -> 39.2504674253934  _ @double@	 lift : 23.44560720248093 : good	 :) hit 

[Prob_ROI diff: 0.20806922464838462 (up%-> 24.864515965879846) . o: 0.8368118845904988 -> a: 1.0448811092388834	 returnMoney: o:0.1098575316058996 a: 12.58154381002325 (probReturnRate: 114.5260013228587	 totalSpendMoney: o: 0.13128103654940243 a: 12.041124773695977 (probTotalSpendRate: 91.72021405517144

[Time_ROI diff: 0.25362668724933113 (up%-> 21.901212674591186) . o: 1.1580486022291248 -> a: 1.4116752894784559	 returnMoney: o:1901400.0 a: 1.2191784E9 (timeReturnRate: 641.2003786683497	 totalSpendMoney: o: 1641900.0 a: 8.636394E8 (timeTotalSpendRate: 526.0

[[Per_Prob_ROI diff: -0.8260399143921598 (up%-> -98.71273694880537) . o: 0.8368118845904988 -> a: 0.010771970198339002	 per returnMoney: o:0.1098575316058996 a: 0.12970663721673453	 per totalSpendMoney: o: 0.13128103654940243 a: 0.12413530694531935

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.7699117659191611
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.5618425412707765     $$$非常重要的指标!
 probRunR/probTalSR= 1.2486451596587984 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Six6, 	playerStartValue=7	@@@ 

net money diff:  0.9478210788751946 , up % -> 4678.548989540627 .  o: -0.020258868315671058 -> a: 0.9275622105595236 (anet/onet: -45.78548989540628

[ProbMatrix: total: o: 4.376034551646736E-4  -> a: 0.03240646916615001
org->adv	$w:42.28416043620767->47.79788558761865  	$d:0.0->7.67464222220213  	$l:57.715839563792315->44.52747219017923
	 improve value x$w(high is good):5.513725151410981  	x$d:7.67464222220213  	 x$l(negative is good):-13.188367373613083
	 	 $w-$l: -15.43167912758464 -> 3.27041339743942  _ #Surrender#	 lift : 18.70209252502406 : good	 :) hit 

[TimeMatrix: total:  o: 3109.0 -> a: 907828.0
org->adv	$w:57.896429720167255->67.19026071017858  	$d:0.0->4.841886348515358  	$l:42.103570279832745->27.967852941306067
	 improve value x$w(high is good):9.293830990011323  	x$d:4.841886348515358  	 x$l(negative is good):-14.135717338526678
	 	 $w-$l: 15.792859440334512 -> 39.22240776887252  _ @double@	 lift : 23.429548328538008 : good	 :) hit 

[Prob_ROI diff: 0.23134964559736637 (up%-> 27.35653767400611) . o: 0.845683208724152 -> a: 1.0770328543215184	 returnMoney: o:0.11102216823373112 a: 12.96868698425778 (probReturnRate: 116.81168896787578	 totalSpendMoney: o: 0.13128103654940218 a: 12.041124773698256 (probTotalSpendRate: 91.72021405518898

[Time_ROI diff: 0.2534711563509351 (up%-> 21.890050697084924) . o: 1.157928594403345 -> a: 1.4113997507542801	 returnMoney: o:1080000.0 a: 6.92433E8 (timeReturnRate: 641.1416666666667	 totalSpendMoney: o: 932700.0 a: 4.906002E8 (timeTotalSpendRate: 526.0

[[Per_Prob_ROI diff: -0.8345797772363013 (up%-> -98.68704600336075) . o: 0.845683208724152 -> a: 0.011103431487850703	 per returnMoney: o:0.11102216823373112 a: 0.1336978039614204	 per totalSpendMoney: o: 0.13128103654940218 a: 0.12413530694534285

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.179170724472561
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.9478210788751946     $$$非常重要的指标!
 probRunR/probTalSR= 1.273565376740061 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Seven7, 	playerStartValue=7	@@@ 

net money diff:  0.3073870654519115 , up % -> 87.68863479992089 .  o: -0.3505437918531591 -> a: -0.043156726401247555 (anet/onet: 0.12311365200079104

[ProbMatrix: total: o: 0.03240646916604106  -> a: 4.3760345516460984E-4
org->adv	$w:37.85989474633073->30.27205592112242  	$d:17.230171455296425->6.58234637625147  	$l:44.90993379837286->63.14559770262612
	 improve value x$w(high is good):-7.587838825208312  	x$d:-10.647825079044955  	 x$l(negative is good):18.235663904253258
	 	 $w-$l: -7.050039052042129 -> -32.873541781503704  _ #Surrender#	 lift : -25.823502729461573 : bad	 :| stand

[TimeMatrix: total:  o: 1.3377844E7 -> a: 94129.0
org->adv	$w:32.31106596847743->30.460325723209635  	$d:3.5965287082133717->3.4463342859267603  	$l:64.0924053233092->66.0933399908636
	 improve value x$w(high is good):-1.8507402452677937  	x$d:-0.1501944222866114  	 x$l(negative is good):2.0009346675544037
	 	 $w-$l: -31.78133935483177 -> -35.63301426765396  _ #Surrender#	 lift : -3.8516749128221948 : bad	 :| stand

[Prob_ROI diff: -0.29762592025491796 (up%-> -30.71822042897585) . o: 0.968890502439958 -> a: 0.67126458218504	 returnMoney: o:10.917519640434735 a: 0.08812431014815099 (probReturnRate: 0.008071825199358366	 totalSpendMoney: o: 11.268063432287894 a: 0.13128103654939854 (probTotalSpendRate: 0.011650718629540315

[Time_ROI diff: -0.05584949998692923 (up%-> -7.983982059005092) . o: 0.6995193573103896 -> a: 0.6436698573234604	 returnMoney: o:2.870307E9 a: 1.81764E7 (timeReturnRate: 0.00633256303245611	 totalSpendMoney: o: 4.103256E9 a: 2.82387E7 (timeTotalSpendRate: 0.006882022471910112

[[Per_Prob_ROI diff: 0.013278934236282786 (up%-> 3159.071467575727) . o: 4.2034295116701004E-4 -> a: 0.013699277187449796	 per returnMoney: o:0.004736451037064961 a: 0.0017984553091459385	 per totalSpendMoney: o: 0.004888530773226852 a: 0.002679204827538746

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.00976114519699356
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.3073870654519115     $$$非常重要的指标!
 probRunR/probTalSR= 0.6928177957102415 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Eight8, 	playerStartValue=7	@@@ 

net money diff:  1.7904576374013628 , up % -> 97.28862544002406 .  o: -1.8403565980127183 -> a: -0.0498989606113555 (anet/onet: 0.02711374559975939

[ProbMatrix: total: o: 0.032406469166096095  -> a: 4.3760345516467023E-4
org->adv	$w:33.47508303474355->27.6231265497384  	$d:11.526486861464313->6.744479208163505  	$l:54.99843010379214->65.63239424209809
	 improve value x$w(high is good):-5.851956485005147  	x$d:-4.782007653300808  	 x$l(negative is good):10.633964138305949
	 	 $w-$l: -21.523347069048594 -> -38.009267692359685  _ #Surrender#	 lift : -16.485920623311095 : bad	 :| stand

[TimeMatrix: total:  o: 8029492.0 -> a: 56497.0
org->adv	$w:32.301719710288026->30.451174398640635  	$d:3.5975874937044585->3.4479706887091353  	$l:64.10069279600752->66.10085491265023
	 improve value x$w(high is good):-1.850545311647391  	x$d:-0.14961680499532326  	 x$l(negative is good):2.000162116642713
	 	 $w-$l: -31.798973085719496 -> -35.649680514009596  _ #Surrender#	 lift : -3.850707428290101 : bad	 :| stand

[Prob_ROI diff: -0.21676766468311215 (up%-> -25.90822814765414) . o: 0.8366749877595909 -> a: 0.6199073230764788	 returnMoney: o:9.427706834327786 a: 0.08138207593804299 (probReturnRate: 0.008632223866117459	 totalSpendMoney: o: 11.268063432340504 a: 0.1312810365493985 (probTotalSpendRate: 0.011650718629485912

[Time_ROI diff: -0.055838044895691996 (up%-> -7.984377542958304) . o: 0.699341239755596 -> a: 0.643503194859904	 returnMoney: o:1.7223432E9 a: 1.09068E7 (timeReturnRate: 0.006332535815161577	 totalSpendMoney: o: 2.462808E9 a: 1.69491E7 (timeTotalSpendRate: 0.006882022471910112

[[Per_Prob_ROI diff: 0.012288187217593196 (up%-> 3385.337431013412) . o: 3.6298264111045165E-4 -> a: 0.012651169858703648	 per returnMoney: o:0.004090111424871057 a: 0.0016608586926131223	 per totalSpendMoney: o: 0.004888530773249676 a: 0.0026792048275387447

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.5736899727182507
 按net净收益值(代表少输多赢) :  $Change$  Value: 1.7904576374013628     $$$非常重要的指标!
 probRunR/probTalSR= 0.7409177185234587 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Nine9, 	playerStartValue=7	@@@ 

net money diff:  2.646408164826776 , up % -> 97.86676953014765 .  o: -2.704092694110594 -> a: -0.05768452928381826 (anet/onet: 0.021332304698523413

[ProbMatrix: total: o: 0.03240646916611178  -> a: 4.3760345516466454E-4
org->adv	$w:30.358944524864185->24.587116075539324  	$d:9.893371401348773->6.88604068039515  	$l:59.747684073787035->68.52684324406553
	 improve value x$w(high is good):-5.771828449324861  	x$d:-3.0073307209536226  	 x$l(negative is good):8.779159170278497
	 	 $w-$l: -29.38873954892285 -> -43.9397271685262  _ #Surrender#	 lift : -14.550987619603351 : bad	 :| stand

[TimeMatrix: total:  o: 5355316.0 -> a: 37681.0
org->adv	$w:32.27290415728969->30.423821023858178  	$d:3.6003104205242047->3.4500145962155995  	$l:64.1267854221861->66.12616437992622
	 improve value x$w(high is good):-1.8490831334315097  	x$d:-0.15029582430860522  	 x$l(negative is good):1.9993789577401202
	 	 $w-$l: -31.853881264896415 -> -35.70234335606804  _ #Surrender#	 lift : -3.848462091171628 : bad	 :| stand

[Prob_ROI diff: -0.19941879531781082 (up%-> -26.238572082100546) . o: 0.7600215236325705 -> a: 0.5606027283147597	 returnMoney: o:8.563970738254794 a: 0.07359650726558534 (probReturnRate: 0.008593736423786892	 totalSpendMoney: o: 11.268063432365388 a: 0.1312810365494036 (probTotalSpendRate: 0.011650718629460637

[Time_ROI diff: -0.05581071019310835 (up%-> -7.986795418209308) . o: 0.6987872766324279 -> a: 0.6429765664393196	 returnMoney: o:1.1478168E9 a: 7268400.0 (timeReturnRate: 0.0063323694164434605	 totalSpendMoney: o: 1.642584E9 a: 1.13043E7 (timeTotalSpendRate: 0.006882022471910112

[[Per_Prob_ROI diff: 0.011111144664283723 (up%-> 3369.797782668536) . o: 3.297273421399438E-4 -> a: 0.011440872006423667	 per returnMoney: o:0.0037153886066181316 a: 0.0015019695360323538	 per totalSpendMoney: o: 0.004888530773260472 a: 0.0026792048275388488

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 2.446989369508965
 按net净收益值(代表少输多赢) :  $Change$  Value: 2.646408164826776     $$$非常重要的指标!
 probRunR/probTalSR= 0.7376142791789946 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Ten, 	playerStartValue=7	@@@ 

net money diff:  3.4621732566181542 , up % -> 98.13934287739737 .  o: -3.527813774892855 -> a: -0.06564051827470081 (anet/onet: 0.018606571226026356

[ProbMatrix: total: o: 0.03240646916612822  -> a: 4.376034551646723E-4
org->adv	$w:26.75645988894637->0.0  	$d:9.924759171030573->0.0  	$l:63.31878094002305->100.0
	 improve value x$w(high is good):-26.75645988894637  	x$d:-9.924759171030573  	 x$l(negative is good):36.68121905997695
	 	 $w-$l: -36.56232105107669 -> -100.0  _ #Surrender#	 lift : -63.43767894892331 : bad	 :| stand

[TimeMatrix: total:  o: 3540460.0 -> a: 385.0
org->adv	$w:31.748812301226394->0.0  	$d:3.5872739700490897->0.0  	$l:64.66391372872452->100.0
	 improve value x$w(high is good):-31.748812301226394  	x$d:-3.5872739700490897  	 x$l(negative is good):35.33608627127548
	 	 $w-$l: -32.91510142749813 -> -100.0  _ #Surrender#	 lift : -67.08489857250187 : bad	 :| stand

[Prob_ROI diff: -0.16385773492271016 (up%-> -24.682658091162764) . o: 0.6638577349227102 -> a: 0.5	 returnMoney: o:6.967188316205978 a: 0.06564051827470081 (probReturnRate: 0.009421378509608842	 totalSpendMoney: o: 10.495002091098833 a: 0.13128103654940163 (probTotalSpendRate: 0.01250890999447685

[Time_ROI diff: -0.17774787214079857 (up%-> -26.226253072451165) . o: 0.6777478721407986 -> a: 0.5	 returnMoney: o:7.259676E8 a: 57750.0 (timeReturnRate: 7.954900466632395E-5	 totalSpendMoney: o: 1.071147E9 a: 115500.0 (timeTotalSpendRate: 1.0782833728703904E-4

[[Per_Prob_ROI diff: 0.4997822703394809 (up%-> 229542.57548004473) . o: 2.1772966051909157E-4 -> a: 0.5	 per returnMoney: o:0.002285073242442105 a: 0.06564051827470081	 per totalSpendMoney: o: 0.0034421128537549467 a: 0.13128103654940163

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=true]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 3.298315521695444
 按net净收益值(代表少输多赢) :  $Change$  Value: 3.4621732566181542     $$$非常重要的指标!
 probRunR/probTalSR= 0.7531734190883723 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

		 */
	}
	
	public static void test88vsAll() {
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
		
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
MatrixKey [startValue=Eight, dealerCard=Two2, situation=Splited_Pair_And_Can_Split] : Stand -> Split
MatrixKey [startValue=Eight, dealerCard=Two2, situation=Start_With_Pair] : Stand -> Split
MatrixKey [startValue=Eight, dealerCard=Three3, situation=Start_With_Pair] : Stand -> Split
MatrixKey [startValue=Eight, dealerCard=Three3, situation=Splited_Pair_And_Can_Split] : Stand -> Split
MatrixKey [startValue=Eight, dealerCard=Four4, situation=Splited_Pair_And_Can_Split] : Stand -> Split
MatrixKey [startValue=Eight, dealerCard=Four4, situation=Start_With_Pair] : Stand -> Split
MatrixKey [startValue=Eight, dealerCard=Five5, situation=Start_With_Pair] : Stand -> Split
MatrixKey [startValue=Eight, dealerCard=Five5, situation=Splited_Pair_And_Can_Split] : Stand -> Split
MatrixKey [startValue=Eight, dealerCard=Six6, situation=Start_With_Pair] : Stand -> Split
MatrixKey [startValue=Eight, dealerCard=Six6, situation=Splited_Pair_And_Can_Split] : Stand -> Split
MatrixKey [startValue=Eight, dealerCard=Seven7, situation=Start_With_Pair] : Hit -> Split
MatrixKey [startValue=Eight, dealerCard=Seven7, situation=Splited_Pair_And_Can_Split] : Hit -> Split
MatrixKey [startValue=Eight, dealerCard=Eight8, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Eight, dealerCard=Eight8, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Eight, dealerCard=Nine9, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Eight, dealerCard=Nine9, situation=Start_With_Pair] : Split -> Giveup
MatrixKey [startValue=Eight, dealerCard=Ten, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Eight, dealerCard=Ten, situation=Start_With_Pair] : Split -> Giveup


		 @@@   dealerCard=One1, 	playerStartValue=8	@@@ 

net money diff:  3.9656353834898006 , up % -> 97.9248937119159 .  o: -4.04967034751782 -> a: -0.08403496402801902 (anet/onet: 0.02075106288084088

[ProbMatrix: total: o: 0.03240646916591752  -> a: 4.376034551645542E-4
org->adv	$w:23.35856201361099->14.57027312064735  	$d:11.627917857307947->6.84795123190131  	$l:65.01352012908107->78.58177564745135
	 improve value x$w(high is good):-8.788288892963639  	x$d:-4.7799666254066375  	 x$l(negative is good):13.568255518370279
	 	 $w-$l: -41.65495811547008 -> -64.011502526804  _ #Surrender#	 lift : -22.356544411333918 : bad	 :| stand

[TimeMatrix: total:  o: 9.7928428E7 -> a: 184717.0
org->adv	$w:31.70250011569674->28.838710026689473  	$d:3.522537909012488->3.2065267409063596  	$l:64.77496197529076->67.95476323240418
	 improve value x$w(high is good):-2.863790089007267  	x$d:-0.3160111681061286  	 x$l(negative is good):3.179801257113411
	 	 $w-$l: -33.07246185959403 -> -39.11605320571469  _ #Surrender#	 lift : -6.043591346120669 : bad	 :| stand

[Prob_ROI diff: -0.22356544409707252 (up%-> -38.31781362771994) . o: 0.5834504188290649 -> a: 0.3598849747319924	 returnMoney: o:5.6722704023301525 a: 0.04724607252136475 (probReturnRate: 0.008329305405108367	 totalSpendMoney: o: 9.721940749847972 a: 0.13128103654938378 (probTotalSpendRate: 0.01350358327903168

[Time_ROI diff: -0.06043591346120658 (up%-> -9.030051775461883) . o: 0.6692753814040597 -> a: 0.6088394679428532	 returnMoney: o:1.96623258E10 a: 3.37389E7 (timeReturnRate: 0.001715916028611427	 totalSpendMoney: o: 2.93785284E10 a: 5.54151E7 (timeTotalSpendRate: 0.0018862449216482879

[[Per_Prob_ROI diff: 0.027429011091136258 (up%-> 10779.788719356784) . o: 2.5444850363238764E-4 -> a: 0.027683459594768645	 per returnMoney: o:0.002473733276201549 a: 0.0036343132708742116	 per totalSpendMoney: o: 0.00423983460525424 a: 0.010098541273029522

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=true]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 3.7420699393927284
 按net净收益值(代表少输多赢) :  $Change$  Value: 3.9656353834898006     $$$非常重要的指标!
 probRunR/probTalSR= 0.6168218637228006 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Two2, 	playerStartValue=8	@@@ 

net money diff:  0.22243949363422894 , up % -> 578.3000974142004 .  o: -0.03846437077026971 -> a: 0.18397512286395923 (anet/onet: -4.783000974142004

[ProbMatrix: total: o: 4.3760345516467684E-4  -> a: 0.03240646916621595
org->adv	$w:35.3503705556954->45.27004092890542  	$d:0.0->8.042785442415386  	$l:64.6496294443046->46.6871736286792
	 improve value x$w(high is good):9.919670373210025  	x$d:8.042785442415386  	 x$l(negative is good):-17.962455815625397
	 	 $w-$l: -29.29925888860919 -> -1.417132699773771  _ #Surrender#	 lift : 27.88212618883542 : good	 :) hit 

[TimeMatrix: total:  o: 26689.0 -> a: 7793188.0
org->adv	$w:57.960208325527375->63.005999598623816  	$d:0.0->4.666690961388331  	$l:42.03979167447263->32.32730943998784
	 improve value x$w(high is good):5.045791273096441  	x$d:4.666690961388331  	 x$l(negative is good):-9.712482234484789
	 	 $w-$l: 15.920416651054742 -> 30.678690158635973  _ @double@	 lift : 14.758273507581233 : good	 :) hit 

[Prob_ROI diff: 0.30931971767517297 (up%-> 43.75056227315325) . o: 0.7070074111138487 -> a: 1.0163271287890216	 returnMoney: o:0.09281666577914238 a: 11.452038555282252 (probReturnRate: 123.38342967988554	 totalSpendMoney: o: 0.1312810365494121 a: 11.268063432418293 (probTotalSpendRate: 85.83161535426461

[Time_ROI diff: 0.20626174239788453 (up%-> 17.793392083706575) . o: 1.1592041665105475 -> a: 1.365465908908432	 returnMoney: o:9281400.0 a: 4.8979284E9 (timeReturnRate: 527.7143965350054	 totalSpendMoney: o: 8006700.0 a: 3.5870016E9 (timeTotalSpendRate: 448.0

[[Per_Prob_ROI diff: -0.6965298118479825 (up%-> -98.51803544048296) . o: 0.7070074111138487 -> a: 0.010477599265866203	 per returnMoney: o:0.09281666577914238 a: 0.11806225314723971	 per totalSpendMoney: o: 0.1312810365494121 a: 0.11616560239606488

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.5317592113094018
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.22243949363422894     $$$非常重要的指标!
 probRunR/probTalSR= 1.4375056227315328 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Three3, 	playerStartValue=8	@@@ 

net money diff:  0.5481711284454205 , up % -> 1659.5225058038031 .  o: -0.03303185865381858 -> a: 0.515139269791602 (anet/onet: -15.595225058038032

[ProbMatrix: total: o: 4.37603455164674E-4  -> a: 0.03240646916618333
org->adv	$w:37.41940971749486->46.90311684866204  	$d:0.0->7.789570722845644  	$l:62.58059028250514->45.30731242849232
	 improve value x$w(high is good):9.48370713116718  	x$d:7.789570722845644  	 x$l(negative is good):-17.273277854012825
	 	 $w-$l: -25.161180565010287 -> 1.595804420169722  _ #Surrender#	 lift : 26.75698498518001 : good	 :) hit 

[TimeMatrix: total:  o: 15553.0 -> a: 4541476.0
org->adv	$w:57.937375425962834->62.98842050469935  	$d:0.0->4.669230884408505  	$l:42.06262457403716->32.34234861089214
	 improve value x$w(high is good):5.051045078736514  	x$d:4.669230884408505  	 x$l(negative is good):-9.72027596314502
	 	 $w-$l: 15.874750851925674 -> 30.646071893807207  _ @double@	 lift : 14.771321041881535 : good	 :) hit 

[Prob_ROI diff: 0.29732855838956884 (up%-> 39.72918875983391) . o: 0.7483881943498607 -> a: 1.0457167527394295	 returnMoney: o:0.09824917789558982 a: 11.783202702199524 (probReturnRate: 119.931819833868	 totalSpendMoney: o: 0.1312810365494084 a: 11.268063432407923 (probTotalSpendRate: 85.83161535418803

[Time_ROI diff: 0.20639104995820756 (up%-> 17.811563644434592) . o: 1.1587475085192567 -> a: 1.3651385584774642	 returnMoney: o:5406600.0 a: 2.8535808E9 (timeReturnRate: 527.795805127067	 totalSpendMoney: o: 4665900.0 a: 2.0903232E9 (timeTotalSpendRate: 448.0

[[Per_Prob_ROI diff: -0.7376076092700727 (up%-> -98.55949289938314) . o: 0.7483881943498607 -> a: 0.010780585079787934	 per returnMoney: o:0.09824917789558982 a: 0.12147631651752087	 per totalSpendMoney: o: 0.1312810365494084 a: 0.11616560239595797

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.8454996868349893
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.5481711284454205     $$$非常重要的指标!
 probRunR/probTalSR= 1.3972918875983393 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Four4, 	playerStartValue=8	@@@ 

net money diff:  0.9031669673015154 , up % -> 3301.329189232186 .  o: -0.02735767672752354 -> a: 0.8758092905739918 (anet/onet: -32.01329189232186

[ProbMatrix: total: o: 4.3760345516467505E-4  -> a: 0.03240646916616127
org->adv	$w:39.58049180346542->48.89491117376683  	$d:0.0->7.103469967841819  	$l:60.41950819653458->44.001618858391346
	 improve value x$w(high is good):9.314419370301408  	x$d:7.103469967841819  	 x$l(negative is good):-16.417889338143233
	 	 $w-$l: -20.83901639306916 -> 4.893292315375486  _ @double@	 lift : 25.732308708444645 : good	 :) hit 

[TimeMatrix: total:  o: 9073.0 -> a: 1996060.0
org->adv	$w:57.91910062823763->68.65985992405038  	$d:0.0->5.0529543200104206  	$l:42.08089937176237->26.287185755939202
	 improve value x$w(high is good):10.740759295812751  	x$d:5.0529543200104206  	 x$l(negative is good):-15.793713615823169
	 	 $w-$l: 15.838201256475259 -> 42.37267416811118  _ @double@	 lift : 26.53447291163592 : good	 :) hit 

[Prob_ROI diff: 0.28611508053487456 (up%-> 36.14344687220756) . o: 0.7916098360692937 -> a: 1.0777249166041682	 returnMoney: o:0.10392335982188142 a: 12.143872722976864 (probReturnRate: 116.85411964923723	 totalSpendMoney: o: 0.13128103654940496 a: 11.268063432402872 (probTotalSpendRate: 85.83161535415182

[Time_ROI diff: 0.28648480058907544 (up%-> 24.731461424782886) . o: 1.1583820125647526 -> a: 1.444866813153828	 returnMoney: o:3153000.0 a: 1.4787264E9 (timeReturnRate: 468.9902949571836	 totalSpendMoney: o: 2721900.0 a: 1.0234344E9 (timeTotalSpendRate: 376.0

[[Per_Prob_ROI diff: -0.7768464810473188 (up%-> -98.13502127572318) . o: 0.7916098360692937 -> a: 0.01476335502197491	 per returnMoney: o:0.10392335982188142 a: 0.16635442086269678	 per totalSpendMoney: o: 0.13128103654940496 a: 0.15435703332058728

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.18928204783639
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.9031669673015154     $$$非常重要的指标!
 probRunR/probTalSR= 1.3614344687220756 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Five5, 	playerStartValue=8	@@@ 

net money diff:  1.2656015903096753 , up % -> 5907.537509138991 .  o: -0.021423504943502827 -> a: 1.2441780853661726 (anet/onet: -58.0753750913899

[ProbMatrix: total: o: 4.376034551646746E-4  -> a: 0.03240646916615214
org->adv	$w:41.84059422952501->50.672199342318  	$d:0.0->6.909613248465122  	$l:58.15940577047499->42.41818740921687
	 improve value x$w(high is good):8.831605112792992  	x$d:6.909613248465122  	 x$l(negative is good):-15.74121836125812
	 	 $w-$l: -16.31881154094998 -> 8.254011933101129  _ @double@	 lift : 24.57282347405111 : good	 :) hit 

[TimeMatrix: total:  o: 5473.0 -> a: 1204060.0
org->adv	$w:57.90243011145624->68.64907064432005  	$d:0.0->5.05390096839028  	$l:42.09756988854376->26.29702838728967
	 improve value x$w(high is good):10.746640532863807  	x$d:5.05390096839028  	 x$l(negative is good):-15.800541501254088
	 	 $w-$l: 15.804860222912476 -> 42.352042257030384  _ @double@	 lift : 26.547182034117906 : good	 :) hit 

[Prob_ROI diff: 0.2736044343120174 (up%-> 32.696050253386176) . o: 0.8368118845904988 -> a: 1.1104163189025162	 returnMoney: o:0.1098575316058996 a: 12.512241517770818 (probReturnRate: 113.89516344365853	 totalSpendMoney: o: 0.13128103654940243 a: 11.268063432404645 (probTotalSpendRate: 85.83161535416697

[Time_ROI diff: 0.2866159210981569 (up%-> 24.74990432581592) . o: 1.1580486022291248 -> a: 1.4446645233272817	 returnMoney: o:1901400.0 a: 8.9187E8 (timeReturnRate: 469.05964026506786	 totalSpendMoney: o: 1641900.0 a: 6.173544E8 (timeTotalSpendRate: 376.0

[[Per_Prob_ROI diff: -0.8216007021397794 (up%-> -98.18224588693992) . o: 0.8368118845904988 -> a: 0.015211182450719401	 per returnMoney: o:0.1098575316058996 a: 0.17140056873658654	 per totalSpendMoney: o: 0.13128103654940243 a: 0.15435703332061157

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.5392060246216928
 按net净收益值(代表少输多赢) :  $Change$  Value: 1.2656015903096753     $$$非常重要的指标!
 probRunR/probTalSR= 1.3269605025338618 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Six6, 	playerStartValue=8	@@@ 

net money diff:  1.705022958008656 , up % -> 8416.180664394522 .  o: -0.020258868315671058 -> a: 1.684764089692985 (anet/onet: -83.16180664394523

[ProbMatrix: total: o: 4.376034551646736E-4  -> a: 0.032406469166145604
org->adv	$w:42.28416043620767->52.884405811433155  	$d:0.0->6.610702933616495  	$l:57.715839563792315->40.50489125495036
	 improve value x$w(high is good):10.600245375225484  	x$d:6.610702933616495  	 x$l(negative is good):-17.210948308841957
	 	 $w-$l: -15.43167912758464 -> 12.379514556482796  _ @double@	 lift : 27.811193684067437 : good	 :) hit 

[TimeMatrix: total:  o: 3109.0 -> a: 683980.0
org->adv	$w:57.896429720167255->68.63270855872979  	$d:0.0->5.058042632825521  	$l:42.103570279832745->26.30924880844469
	 improve value x$w(high is good):10.736278838562534  	x$d:5.058042632825521  	 x$l(negative is good):-15.794321471388056
	 	 $w-$l: 15.792859440334512 -> 42.32345975028509  _ @double@	 lift : 26.53060030995058 : good	 :) hit 

[Prob_ROI diff: 0.3038335294269069 (up%-> 35.927582136257406) . o: 0.845683208724152 -> a: 1.149516738151059	 returnMoney: o:0.11102216823373112 a: 12.952827522101762 (probReturnRate: 116.66883945945483	 totalSpendMoney: o: 0.13128103654940218 a: 11.268063432408777 (probTotalSpendRate: 85.8316153541986

[Time_ROI diff: 0.28646414322180647 (up%-> 24.739361702127677) . o: 1.157928594403345 -> a: 1.4443927376251515	 returnMoney: o:1080000.0 a: 5.065416E8 (timeReturnRate: 469.02	 totalSpendMoney: o: 932700.0 a: 3.506952E8 (timeTotalSpendRate: 376.0

[[Per_Prob_ROI diff: -0.8299364040919458 (up%-> -98.1379783269006) . o: 0.845683208724152 -> a: 0.015746804632206284	 per returnMoney: o:0.11102216823373112 a: 0.1774359934534488	 per totalSpendMoney: o: 0.13128103654940218 a: 0.1543570333206682

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=true, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 2.0088564874355628
 按net净收益值(代表少输多赢) :  $Change$  Value: 1.705022958008656     $$$非常重要的指标!
 probRunR/probTalSR= 1.359275821362574 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Seven7, 	playerStartValue=8	@@@ 

net money diff:  1.2501528322772102 , up % -> 2317.7627447035393 .  o: -0.05393791211520724 -> a: 1.196214920162003 (anet/onet: -22.177627447035395

[ProbMatrix: total: o: 4.3760345516464464E-4  -> a: 0.03240646916609904
org->adv	$w:26.600058528193816->48.664053809397664  	$d:5.714046380375477->11.581442052229129  	$l:67.68589509143071->39.75450413837321
	 improve value x$w(high is good):22.063995281203848  	x$d:5.867395671853652  	 x$l(negative is good):-27.9313909530575
	 	 $w-$l: -41.085836563236896 -> 8.909549671024457  _ @double@	 lift : 49.99538623426136 : good	 :) hit 

[TimeMatrix: total:  o: 24973.0 -> a: 4664188.0
org->adv	$w:28.70299923917831->33.82526604845259  	$d:3.247507307892524->3.6579571835440596  	$l:68.04949345292917->62.516776768003346
	 improve value x$w(high is good):5.122266809274279  	x$d:0.41044987565153557  	 x$l(negative is good):-5.532716684925823
	 	 $w-$l: -39.34649421375085 -> -28.691510719550756  _ #Surrender#	 lift : 10.6549834942001 : good	 :) hit 

[Prob_ROI diff: 0.5170181265655135 (up%-> 87.75786608944422) . o: 0.5891416343676364 -> a: 1.10615976093315	 returnMoney: o:0.07734312443418831 a: 12.46427835255117 (probReturnRate: 161.15560941887077	 totalSpendMoney: o: 0.13128103654939555 a: 11.268063432389168 (probTotalSpendRate: 85.83161535405358

[Time_ROI diff: 0.1524434314756531 (up%-> 25.133490554178945) . o: 0.6065350578624915 -> a: 0.7589784893381446	 returnMoney: o:4544100.0 a: 1.1302398E9 (timeReturnRate: 248.72687660922955	 totalSpendMoney: o: 7491900.0 a: 1.4891592E9 (timeTotalSpendRate: 198.76923076923077

[[Per_Prob_ROI diff: -0.043944475754784176 (up%-> -96.96788539234439) . o: 0.045318587259048956 -> a: 0.0013741115042647826	 per returnMoney: o:0.005949471110322178 a: 0.015483575593231267	 per totalSpendMoney: o: 0.010098541273030427 a: 0.013997594325949277

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.7671709588427236
 按net净收益值(代表少输多赢) :  $Change$  Value: 1.2501528322772102     $$$非常重要的指标!
 probRunR/probTalSR= 1.8775786608944423 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Eight8, 	playerStartValue=8	@@@ 

net money diff:  0.24202764373753177 , up % -> 80.2004320472435 .  o: -0.3017784786931834 -> a: -0.05975083495565166 (anet/onet: 0.19799567952756503

[ProbMatrix: total: o: 0.032406469166122984  -> a: 4.376034551646556E-4
org->adv	$w:38.6009393498078->24.31551805109732  	$d:17.167639093177556->5.855280790061905  	$l:44.23142155701464->69.82920115884077
	 improve value x$w(high is good):-14.285421298710482  	x$d:-11.312358303115651  	 x$l(negative is good):25.597779601826133
	 	 $w-$l: -5.630482207206838 -> -45.513683107743454  _ #Surrender#	 lift : -39.883200900536615 : bad	 :| stand

[TimeMatrix: total:  o: 2799484.0 -> a: 14989.0
org->adv	$w:33.81416003806416->28.694375875642137  	$d:3.6616747943549597->3.249049302822069  	$l:62.52416516758088->68.0565748215358
	 improve value x$w(high is good):-5.119784162422022  	x$d:-0.41262549153289063  	 x$l(negative is good):5.532409653954922
	 	 $w-$l: -28.710005129516723 -> -39.36219894589366  _ #Surrender#	 lift : -10.652193816376936 : bad	 :| stand

[Prob_ROI diff: -0.4283550792259466 (up%-> -44.014287652421324) . o: 0.9732182481485234 -> a: 0.5448631689225768	 returnMoney: o:10.966284953704934 a: 0.07153020159374475 (probReturnRate: 0.00652273781829629	 totalSpendMoney: o: 11.268063432398117 a: 0.1312810365493964 (probTotalSpendRate: 0.011650718629426158

[Time_ROI diff: -0.15241114898087282 (up%-> -20.0860999486204) . o: 0.7587891595219363 -> a: 0.6063780105410634	 returnMoney: o:6.7821E8 a: 2726700.0 (timeReturnRate: 0.004020436148095723	 totalSpendMoney: o: 8.938056E8 a: 4496700.0 (timeTotalSpendRate: 0.005030959752321981

[[Per_Prob_ROI diff: 0.040703584687696456 (up%-> 3366.807572292372) . o: 0.0012089667678863644 -> a: 0.04191255145558282	 per returnMoney: o:0.013622714228204887 a: 0.005502323199518827	 per totalSpendMoney: o: 0.013997594325960394 a: 0.010098541273030493

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.18632743548841485
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.24202764373753177     $$$非常重要的指标!
 probRunR/probTalSR= 0.5598571234757868 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Nine9, 	playerStartValue=8	@@@ 

net money diff:  1.8045861316842489 , up % -> 96.49023725139723 .  o: -1.8702266499589495 -> a: -0.06564051827470073 (anet/onet: 0.0350976274860277

[ProbMatrix: total: o: 0.03240646916613499  -> a: 4.3760345516467223E-4
org->adv	$w:33.96572842756517->0.0  	$d:11.305428941084106->0.0  	$l:54.728842631350716->100.0
	 improve value x$w(high is good):-33.96572842756517  	x$d:-11.305428941084106  	 x$l(negative is good):45.271157368649284
	 	 $w-$l: -20.76311420378555 -> -100.0  _ #Surrender#	 lift : -79.23688579621445 : bad	 :| stand

[TimeMatrix: total:  o: 1867132.0 -> a: 769.0
org->adv	$w:33.78550632735126->0.0  	$d:3.6613372809206846->0.0  	$l:62.55315639172806->100.0
	 improve value x$w(high is good):-33.78550632735126  	x$d:-3.6613372809206846  	 x$l(negative is good):37.44684360827194
	 	 $w-$l: -28.767650064376802 -> -100.0  _ #Surrender#	 lift : -71.23234993562319 : bad	 :| stand

[Prob_ROI diff: -0.3340241283537001 (up%-> -40.0496960457293) . o: 0.8340241283537001 -> a: 0.5	 returnMoney: o:9.397836782444436 a: 0.06564051827470073 (probReturnRate: 0.006984641231194826	 totalSpendMoney: o: 11.268063432403386 a: 0.13128103654940146 (probTotalSpendRate: 0.01165071862942116

[Time_ROI diff: -0.2582009122860697 (up%-> -34.054418571927314) . o: 0.7582009122860697 -> a: 0.5	 returnMoney: o:4.519854E8 a: 115350.0 (timeReturnRate: 2.552073584677735E-4	 totalSpendMoney: o: 5.961288E8 a: 230700.0 (timeTotalSpendRate: 3.869969040247678E-4

[[Per_Prob_ROI diff: 0.4989639451821693 (up%-> 48159.994683187906) . o: 0.0010360548178306834 -> a: 0.5	 per returnMoney: o:0.011674331406763275 a: 0.06564051827470073	 per totalSpendMoney: o: 0.01399759432596694 a: 0.13128103654940146

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=true]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.4705620033305487
 按net净收益值(代表少输多赢) :  $Change$  Value: 1.8045861316842489     $$$非常重要的指标!
 probRunR/probTalSR= 0.5995030395427069 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

--------------------------------


		 @@@   dealerCard=Ten, 	playerStartValue=8	@@@ 

net money diff:  2.7697453266851575 , up % -> 97.68495288246633 .  o: -2.835385844959858 -> a: -0.06564051827470081 (anet/onet: 0.023150471175336675

[ProbMatrix: total: o: 0.032406469166140525  -> a: 4.376034551646723E-4
org->adv	$w:30.31865638609946->0.0  	$d:9.938021296608676->0.0  	$l:59.74332231729187->100.0
	 improve value x$w(high is good):-30.31865638609946  	x$d:-9.938021296608676  	 x$l(negative is good):40.25667768270813
	 	 $w-$l: -29.42466593119241 -> -100.0  _ #Surrender#	 lift : -70.57533406880758 : bad	 :| stand

[TimeMatrix: total:  o: 1794100.0 -> a: 385.0
org->adv	$w:32.06554818571986->0.0  	$d:3.602028872415138->0.0  	$l:64.33242294186499->100.0
	 improve value x$w(high is good):-32.06554818571986  	x$d:-3.602028872415138  	 x$l(negative is good):35.66757705813501
	 	 $w-$l: -32.266874756145135 -> -100.0  _ #Surrender#	 lift : -67.73312524385486 : bad	 :| stand

[Prob_ROI diff: -0.2298346565019892 (up%-> -31.4913322427794) . o: 0.7298346565019892 -> a: 0.5	 returnMoney: o:7.659616246160444 a: 0.06564051827470081 (probReturnRate: 0.008569687588148377	 totalSpendMoney: o: 10.495002091120302 a: 0.13128103654940163 (probTotalSpendRate: 0.012508909994451261

[Time_ROI diff: -0.19072818275013292 (up%-> -27.61262498234096) . o: 0.6907281827501329 -> a: 0.5	 returnMoney: o:3.779934E8 a: 57750.0 (timeReturnRate: 1.527804453728557E-4	 totalSpendMoney: o: 5.47239E8 a: 115500.0 (timeTotalSpendRate: 2.1105951878429716E-4

[[Per_Prob_ROI diff: 0.49952883495383993 (up%-> 106019.92635593472) . o: 4.711650461600963E-4 -> a: 0.5	 per returnMoney: o:0.004944878144713004 a: 0.06564051827470081	 per totalSpendMoney: o: 0.0067753402783216924 a: 0.13128103654940163

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=true]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 2.539910670183168
 按net净收益值(代表少输多赢) :  $Change$  Value: 2.7697453266851575     $$$非常重要的指标!
 probRunR/probTalSR= 0.685086677572206 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

		 */
	}
	
	public static void test99vsAll() {
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
		
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
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
		
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

//		test22vsAll();
		test33vsAll();
//		test44vsAll();
//		test44vs56();
//		test55vsAll();
//		test66vsAll();
//		test77vsAll();
//		test88vsAll();
//		test99vsAll();
//		test99vs7();
	}

}
