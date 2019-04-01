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
		
		double onet = ProfitUtil.moneyCalcOneHandInReturnProb(origin,dealerCard) ;
		double anet =  ProfitUtil.moneyCalcOneHandInReturnProb(advanced,dealerCard);
		System.out.println("net money diff:  " + (anet - onet)+" , up % -> "+ 100 * ((anet - onet)/Math.abs(onet))  +" .  o: "+onet +" -> a: " +anet);

		DealerVSPlayerResult9102 result = new DealerVSPlayerResult9102(dealerCard, nine.getValue() , RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), origin),RivalAnalyze9102.anaylze(DealerCards.fetchDealerCards(dealerCard), advanced));
		
		System.out.println(result);
		/**
 
 MatrixKey [startValue=Sixteen, dealerCard=Ten, situation=Start_Hand_WithoutA_WithoutPair] : Stand -> Hit

net money diff:  0.0012359413561666699 , up % -> 1.5689196936483634 .  o: -0.07877658500752284 -> a: -0.07754064365135617

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
MatrixKey [startValue=Two, dealerCard=Four4, situation=Start_With_A] : Double -> Hit
MatrixKey [startValue=Two, dealerCard=Five5, situation=Start_With_A] : Double -> Hit
MatrixKey [startValue=Two, dealerCard=Six6, situation=Start_With_A] : Double -> Hit
MatrixKey [startValue=Two, dealerCard=Seven7, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Two, dealerCard=Eight8, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Two, dealerCard=Nine9, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Two, dealerCard=Ten, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Three, dealerCard=One1, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Three, dealerCard=Two2, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Three, dealerCard=Three3, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Three, dealerCard=Four4, situation=Start_With_A] : Double -> Hit
MatrixKey [startValue=Three, dealerCard=Five5, situation=Start_With_A] : Double -> Hit
MatrixKey [startValue=Three, dealerCard=Six6, situation=Start_With_A] : Double -> Hit
MatrixKey [startValue=Three, dealerCard=Seven7, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Three, dealerCard=Eight8, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Three, dealerCard=Nine9, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Three, dealerCard=Ten, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Four, dealerCard=One1, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Four, dealerCard=Two2, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Four, dealerCard=Three3, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Four, dealerCard=Four4, situation=Start_With_A] : Double -> Hit
MatrixKey [startValue=Four, dealerCard=Five5, situation=Start_With_A] : Double -> Hit
MatrixKey [startValue=Four, dealerCard=Six6, situation=Start_With_A] : Double -> Hit
MatrixKey [startValue=Four, dealerCard=Seven7, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Four, dealerCard=Eight8, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Four, dealerCard=Nine9, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Four, dealerCard=Ten, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Five, dealerCard=One1, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Five, dealerCard=Two2, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Five, dealerCard=Three3, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Five, dealerCard=Four4, situation=Start_With_A] : Double -> Hit
MatrixKey [startValue=Five, dealerCard=Five5, situation=Start_With_A] : Double -> Hit
MatrixKey [startValue=Five, dealerCard=Six6, situation=Start_With_A] : Double -> Hit
MatrixKey [startValue=Five, dealerCard=Seven7, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Five, dealerCard=Eight8, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Five, dealerCard=Nine9, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Five, dealerCard=Ten, situation=Start_With_A] : Hit -> Double


		 @@@   dealerCard=One1, 	playerStartValue=2	@@@ 

net money diff:  -0.09236591876196641 , up % -> -208.82846729968628 .  o: -0.04423052084628558 -> a: -0.136596439608252 (anet/onet: 3.088284672996863

[ProbMatrix: total: o: 4.566296923438159E-4  -> a: 4.5662969234560875E-4
org->adv	$w:27.4186083387825->21.647648448753348  	$d:12.875117412343531->6.847951231901512  	$l:59.70627424887396->71.50440031934514
	 improve value x$w(high is good):-5.770959890029154  	x$d:-6.027166180442019  	 x$l(negative is good):11.798126070471177
	 	 $w-$l: -32.287665910091455 -> -49.85675187059179  _ #Surrender#	 lift : -17.569085960500335 : bad	 :| stand

[TimeMatrix: total:  o: 5.1848641E7 -> a: 184717.0
org->adv	$w:31.233374082070924->64.72495763790013  	$d:3.472785332984909->3.2065267409063596  	$l:65.29384058494416->32.0685156211935
	 improve value x$w(high is good):33.49158355582921  	x$d:-0.2662585920785494  	 x$l(negative is good):-33.225324963750666
	 	 $w-$l: -34.06046650287324 -> 32.65644201670664  _ @double@	 lift : 66.71690851957987 : good	 :) hit 

[Prob_ROI diff: -0.17569085964249953 (up%-> -25.94665536112395) . o: 0.6771233409364136 -> a: 0.501432481293914	 returnMoney: o:0.09275838685166897 a: 0.13738137579928947 (probReturnRate: 1.4810668928404032	 totalSpendMoney: o: 0.13698890769795455 a: 0.27397781540754146 (probTotalSpendRate: 2.0000000000849147

[Time_ROI diff: 0.6671690851957988 (up%-> 101.17892102237423) . o: 0.6593953349712676 -> a: 1.3265644201670663	 returnMoney: o:1.02566256E10 a: 1.470234E8 (timeReturnRate: 0.014334480533246725	 totalSpendMoney: o: 1.55545923E10 a: 1.108302E8 (timeTotalSpendRate: 0.00712523979172376

[[Per_Prob_ROI diff: 0.03838616524673397 (up%-> 20686.204199019907) . o: 1.85564083567118E-4 -> a: 0.03857172933030109	 per returnMoney: o:2.5420221115831452E-5 a: 0.010567798138406883	 per totalSpendMoney: o: 3.7541492929009193E-5 a: 0.02107521656981088

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.2680567784044659
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.09236591876196641
 probRunR/probTalSR= 0.7405334463887605 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Two2, 	playerStartValue=2	@@@ 

net money diff:  -0.005113118351336932 , up % -> -117.45483568905016 .  o: -0.004353263381061123 -> a: -0.009466381732398055 (anet/onet: 2.1745483568905017

[ProbMatrix: total: o: 4.5662969234549003E-4  -> a: 4.56629692345824E-4
org->adv	$w:45.71563211825035->45.76985190214849  	$d:5.390913957283854->5.005132602138644  	$l:48.8934539244658->49.22501549571287
	 improve value x$w(high is good):0.05421978389814086  	x$d:-0.38578135514520984  	 x$l(negative is good):0.33156157124706453
	 	 $w-$l: -3.177821806215453 -> -3.455163593564375  _ #Surrender#	 lift : -0.27734178734892256 : bad	 :| stand

[TimeMatrix: total:  o: 667225.0 -> a: 346957.0
org->adv	$w:55.386563752856986->64.40250520957929  	$d:3.36318333395781->3.233830128805587  	$l:41.25025291318521->32.363664661615125
	 improve value x$w(high is good):9.015941456722302  	x$d:-0.12935320515222326  	 x$l(negative is good):-8.886588251570082
	 	 $w-$l: 14.13631083967178 -> 32.038840547964156  _ @double@	 lift : 17.90252970829238 : good	 :) hit 

[Prob_ROI diff: -0.0027734178737734982 (up%-> -0.2864444826082867) . o: 0.9682217819381607 -> a: 0.9654483640643872	 returnMoney: o:0.1326356443226314 a: 0.2645114336752056 (probReturnRate: 1.9942711103494255	 totalSpendMoney: o: 0.13698890770369251 a: 0.27397781540760363 (probTotalSpendRate: 2.0000000000015956

[Time_ROI diff: 0.1790252970829238 (up%-> 15.685218469554544) . o: 1.1413631083967177 -> a: 1.3203884054796415	 returnMoney: o:2.284638E8 a: 2.748708E8 (timeReturnRate: 1.2031262720833673	 totalSpendMoney: o: 2.001675E8 a: 2.081742E8 (timeTotalSpendRate: 1.04

[[Per_Prob_ROI diff: 0.0355363874966572 (up%-> 91.75683753344559) . o: 0.038728871277526423 -> a: 0.07426525877418362	 per returnMoney: o:0.005305425772905255 a: 0.020347033359631197	 per totalSpendMoney: o: 0.005479556308147701 a: 0.021075216569815664

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.00788653622511043
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.005113118351336932
 probRunR/probTalSR= 0.9971355551739173 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Three3, 	playerStartValue=2	@@@ 

net money diff:  -4.0739557621879974E-4 , up % -> -397.2053041471188 .  o: -1.0256549244566648E-4 -> a: -5.099610686644662E-4 (anet/onet: 4.972053041471188

[ProbMatrix: total: o: 4.566296923457011E-4  -> a: 4.5662969234582846E-4
org->adv	$w:47.35337623689279->47.48445941311347  	$d:5.2183761412132466->4.844948925096121  	$l:47.42824762189396->47.670591661790404
	 improve value x$w(high is good):0.13108317622067744  	x$d:-0.3734272161171255  	 x$l(negative is good):0.24234403989644449
	 	 $w-$l: -0.07487138500116841 -> -0.186132248676929  _ #Surrender#	 lift : -0.1112608636757606 : bad	 :| stand

[TimeMatrix: total:  o: 388825.0 -> a: 202189.0
org->adv	$w:55.36963929788465->64.38184075295887  	$d:3.365009965922973->3.2355865056951663  	$l:41.265350736192374->32.38257274134597
	 improve value x$w(high is good):9.012201455074212  	x$d:-0.1294234602278066  	 x$l(negative is good):-8.882777994846407
	 	 $w-$l: 14.104288561692279 -> 31.999268011612898  _ @double@	 lift : 17.894979449920616 : good	 :) hit 

[Prob_ROI diff: -0.0011126086370155663 (up%-> -0.11134422866763827) . o: 0.9992512861503539 -> a: 0.9981386775133383	 returnMoney: o:0.1368863422112699 a: 0.27346785433885085 (probReturnRate: 1.9977731154272609	 totalSpendMoney: o: 0.13698890770371558 a: 0.2739778154075153 (probTotalSpendRate: 2.000000000000614

[Time_ROI diff: 0.17894979449920623 (up%-> 15.683003395832419) . o: 1.1410428856169228 -> a: 1.319992680116129	 returnMoney: o:1.330998E8 a: 1.601328E8 (timeReturnRate: 1.203103235316657	 totalSpendMoney: o: 1.166475E8 a: 1.213134E8 (timeTotalSpendRate: 1.04

[[Per_Prob_ROI diff: 0.03680984682424263 (up%-> 92.09356879102376) . o: 0.039970051446014156 -> a: 0.07677989827025679	 per returnMoney: o:0.005475453688450796 a: 0.02103598879529622	 per totalSpendMoney: o: 0.005479556308148623 a: 0.02107521656980887

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.001520004213234366
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -4.0739557621879974E-4
 probRunR/probTalSR= 0.9988865577133237 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Four4, 	playerStartValue=2	@@@ 

net money diff:  -0.004446620605799284 , up % -> -50.00000000006336 .  o: 0.0088932412115873 -> a: 0.004446620605788015 (anet/onet: 0.49999999999936645

[ProbMatrix: total: o: 4.566296923458165E-4  -> a: 4.5662969234580873E-4
org->adv	$w:49.28416596967558->49.28416596967569  	$d:4.677639344247018->4.677639344247115  	$l:46.038194686077404->46.03819468607719
	 improve value x$w(high is good):1.1368683772161603E-13  	x$d:9.769962616701378E-14  	 x$l(negative is good):-2.1316282072803006E-13
	 	 $w-$l: 3.24597128359817 -> 3.2459712835984975  _ #Surrender#	 lift : 3.275157922644212E-13 : good	 :| stand

[TimeMatrix: total:  o: 117949.0 -> a: 117949.0
org->adv	$w:64.36425912894556->64.36425912894556  	$d:3.2369922593663363->3.2369922593663363  	$l:32.398748611688106->32.398748611688106
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 31.96551051725745 -> 31.96551051725745  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: -4.1300296516055823E-14 (up%-> -4.000184801652618E-12) . o: 1.0324597128360973 -> a: 1.032459712836056	 returnMoney: o:0.28287105661904277 a: 0.1414355283095168 (probReturnRate: 0.4999999999999838	 totalSpendMoney: o: 0.27397781540745547 a: 0.1369889077037288 (probTotalSpendRate: 0.5000000000000039

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.3196551051725747 -> a: 1.3196551051725747	 returnMoney: o:9.33912E7 a: 4.66956E7 (timeReturnRate: 0.5	 totalSpendMoney: o: 7.07694E7 a: 3.53847E7 (timeTotalSpendRate: 0.5

[[Per_Prob_ROI diff: -3.191891195797325E-15 (up%-> -4.019002875316305E-12) . o: 0.07941997791046904 -> a: 0.07941997791046584	 per returnMoney: o:0.021759312047618676 a: 0.010879656023808986	 per totalSpendMoney: o: 0.021075216569804267 a: 0.010537608284902215

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.004446620605840584
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.004446620605799284
 probRunR/probTalSR= 0.9999999999999598 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Five5, 	playerStartValue=2	@@@ 

net money diff:  -0.009301161425345178 , up % -> -50.00000000002148 .  o: 0.018602322850682362 -> a: 0.009301161425337184 (anet/onet: 0.49999999999978517

[ProbMatrix: total: o: 4.5662969234579003E-4  -> a: 4.5662969234578374E-4
org->adv	$w:51.14352749256983->51.14352749257065  	$d:4.502663672552427->4.502663672552482  	$l:44.35380883487774->44.353808834876865
	 improve value x$w(high is good):8.171241461241152E-13  	x$d:5.5067062021407764E-14  	 x$l(negative is good):-8.739675649849232E-13
	 	 $w-$l: 6.78971865769209 -> 6.789718657693788  _ @double@	 lift : 1.6986412276764895E-12 : good	 :| stand

[TimeMatrix: total:  o: 71149.0 -> a: 71149.0
org->adv	$w:64.35086930244978->64.35086930244978  	$d:3.2382746068110584->3.2382746068110584  	$l:32.41085609073915->32.41085609073915
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 31.94001321171063 -> 31.94001321171063  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: -2.9531932455029164E-14 (up%-> -2.765428435080841E-12) . o: 1.0678971865770182 -> a: 1.0678971865769886	 returnMoney: o:0.29258013825811624 a: 0.14629006912905457 (probReturnRate: 0.49999999999998784	 totalSpendMoney: o: 0.2739778154074339 a: 0.13698890770371738 (probTotalSpendRate: 0.5000000000000017

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.3194001321171063 -> a: 1.3194001321171063	 returnMoney: o:5.63244E7 a: 2.81622E7 (timeReturnRate: 0.5	 totalSpendMoney: o: 4.26894E7 a: 2.13447E7 (timeTotalSpendRate: 0.5

[[Per_Prob_ROI diff: -2.2620794126737565E-15 (up%-> -2.7537325441429995E-12) . o: 0.08214593742900139 -> a: 0.08214593742899913	 per returnMoney: o:0.022506164481393556 a: 0.011253082240696505	 per totalSpendMoney: o: 0.021075216569802605 a: 0.010537608284901337

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.00930116142537471
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.009301161425345178
 probRunR/probTalSR= 0.9999999999999724 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Six6, 	playerStartValue=2	@@@ 

net money diff:  -0.012467338844491277 , up % -> -50.00000000002104 .  o: 0.024934677688972062 -> a: 0.012467338844480785 (anet/onet: 0.4999999999997896

[ProbMatrix: total: o: 4.5662969234577127E-4  -> a: 4.5662969234576807E-4
org->adv	$w:52.31633056799142->52.31633056799143  	$d:4.468323063002996->4.468323063003022  	$l:43.21534636900558->43.21534636900554
	 improve value x$w(high is good):7.105427357601002E-15  	x$d:2.5757174171303632E-14  	 x$l(negative is good):-4.263256414560601E-14
	 	 $w-$l: 9.10098419898584 -> 9.100984198985895  _ @double@	 lift : 5.551115123125783E-14 : good	 :| stand

[TimeMatrix: total:  o: 40417.0 -> a: 40417.0
org->adv	$w:64.33926318133459->64.33926318133459  	$d:3.2387361753717494->3.2387361753717494  	$l:32.422000643293664->32.422000643293664
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 31.91726253804092 -> 31.91726253804092  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: -3.8413716652030416E-14 (up%-> -3.520932183523384E-12) . o: 1.0910098419899117 -> a: 1.0910098419898733	 returnMoney: o:0.29891249309640905 a: 0.14945624654819964 (probReturnRate: 0.4999999999999837	 totalSpendMoney: o: 0.273977815407437 a: 0.13698890770371885 (probTotalSpendRate: 0.5000000000000013

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.3191726253804092 -> a: 1.3191726253804092	 returnMoney: o:3.19902E7 a: 1.59951E7 (timeReturnRate: 0.5	 totalSpendMoney: o: 2.42502E7 a: 1.21251E7 (timeTotalSpendRate: 0.5

[[Per_Prob_ROI diff: -2.9837243786801082E-15 (up%-> -3.555276536469601E-12) . o: 0.083923833999224 -> a: 0.08392383399922101	 per returnMoney: o:0.022993268699723773 a: 0.01149663434986151	 per totalSpendMoney: o: 0.021075216569802845 a: 0.01053760828490145

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.01246733884452969
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.012467338844491277
 probRunR/probTalSR= 0.9999999999999647 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Seven7, 	playerStartValue=2	@@@ 

net money diff:  -0.03937686139655788 , up % -> -266.4153985291219 .  o: 0.014780249795603911 -> a: -0.02459661160095397 (anet/onet: -1.6641539852912188

[ProbMatrix: total: o: 4.5662969234496414E-4  -> a: 4.56629692345766E-4
org->adv	$w:50.03990044240136->42.65418059753724  	$d:10.709576184385526->5.714046380374858  	$l:39.250523373213106->51.6317730220879
	 improve value x$w(high is good):-7.38571984486412  	x$d:-4.995529804010668  	 x$l(negative is good):12.381249648874793
	 	 $w-$l: 10.789377069188255 -> -8.977592424550663  _ #Surrender#	 lift : -19.766969493738916 : bad	 :| stand

[TimeMatrix: total:  o: 7009729.0 -> a: 24973.0
org->adv	$w:31.086394352763136->64.26140231449966  	$d:3.5171687807046466->3.247507307892524  	$l:65.39643686653221->32.49109037760782
	 improve value x$w(high is good):33.175007961736526  	x$d:-0.2696614728121225  	 x$l(negative is good):-32.905346488924394
	 	 $w-$l: -34.310042513769076 -> 31.770311936891844  _ @double@	 lift : 66.08035445066092 : good	 :) hit 

[Prob_ROI diff: -0.19766969494138498 (up%-> -17.841935767651993) . o: 1.107893770695927 -> a: 0.9102240757545421	 returnMoney: o:0.15176915749870504 a: 0.24938120380648152 (probReturnRate: 1.6431612846543564	 totalSpendMoney: o: 0.13698890770310113 a: 0.2739778154074355 (probTotalSpendRate: 2.0000000000090026

[Time_ROI diff: 0.6608035445066092 (up%-> 100.59430235513827) . o: 0.6568995748623092 -> a: 1.3177031193689184	 returnMoney: o:1.3814064E9 a: 1.97442E7 (timeReturnRate: 0.014292825051338984	 totalSpendMoney: o: 2.1029187E9 a: 1.49838E7 (timeTotalSpendRate: 0.00712523979172376

[[Per_Prob_ROI diff: 0.06971362087419689 (up%-> 22961.136644910606) . o: 3.0361572230636535E-4 -> a: 0.07001723659650325	 per returnMoney: o:4.1591986160237064E-5 a: 0.019183169523575502	 per totalSpendMoney: o: 3.7541492930419605E-5 a: 0.02107521656980273

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.23704655633794286
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.03937686139655788
 probRunR/probTalSR= 0.82158064232348 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Eight8, 	playerStartValue=2	@@@ 

net money diff:  -0.046276317912723575 , up % -> -1352.4500043302178 .  o: 0.003421665700362897 -> a: -0.04285465221236068 (anet/onet: -12.524500043302178

[ProbMatrix: total: o: 4.5662969234540774E-4  -> a: 4.5662969234575333E-4
org->adv	$w:45.751107018592194->39.25153437708825  	$d:10.99555440072089->5.855280790061584  	$l:43.253338580686915->54.89318483285016
	 improve value x$w(high is good):-6.499572641503946  	x$d:-5.140273610659306  	 x$l(negative is good):11.639846252163245
	 	 $w-$l: 2.4977684379052842 -> -15.641650455761912  _ #Surrender#	 lift : -18.139418893667198 : bad	 :| stand

[TimeMatrix: total:  o: 4207297.0 -> a: 14989.0
org->adv	$w:31.07705493574616->64.24044299152712  	$d:3.518838817416503->3.249049302822069  	$l:65.40410624683733->32.51050770565081
	 improve value x$w(high is good):33.163388055780956  	x$d:-0.269789514594434  	 x$l(negative is good):-32.89359854118652
	 	 $w-$l: -34.327051311091175 -> 31.729935285876316  _ @double@	 lift : 66.05698659696749 : good	 :) hit 

[Prob_ROI diff: -0.18139418893894543 (up%-> -17.697379338403056) . o: 1.0249776843813405 -> a: 0.8435834954423951	 returnMoney: o:0.14041057340387467 a: 0.23112316319508058 (probReturnRate: 1.6460524132344485	 totalSpendMoney: o: 0.13698890770351177 a: 0.27397781540744126 (probTotalSpendRate: 2.000000000003049

[Time_ROI diff: 0.6605698659696749 (up%-> 100.58477335908557) . o: 0.6567294868890882 -> a: 1.317299352858763	 returnMoney: o:8.289168E8 a: 1.1847E7 (timeReturnRate: 0.014292146087520484	 totalSpendMoney: o: 1.2621891E9 a: 8993400.0 (timeTotalSpendRate: 0.00712523979172376

[[Per_Prob_ROI diff: 0.06461014535009259 (up%-> 23001.712522628248) . o: 2.808927608608771E-4 -> a: 0.06489103811095347	 per returnMoney: o:3.8479192492155294E-5 a: 0.017778704861160045	 per totalSpendMoney: o: 3.754149293053214E-5 a: 0.021075216569803174

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.227670506851669
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.046276317912723575
 probRunR/probTalSR= 0.8230262066159695 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Nine9, 	playerStartValue=2	@@@ 

net money diff:  -0.051975336040728654 , up % -> -534.1657900199674 .  o: -0.009730188082390262 -> a: -0.061705524123118916 (anet/onet: 6.341657900199674

[ProbMatrix: total: o: 4.566296923455723E-4  -> a: 4.5662969234574905E-4
org->adv	$w:40.84141237462624->35.75537633503675  	$d:11.214273091895858->5.967159535571918  	$l:47.9443145334779->58.27746412939133
	 improve value x$w(high is good):-5.086036039589487  	x$d:-5.24711355632394  	 x$l(negative is good):10.333149595913433
	 	 $w-$l: -7.102902158851659 -> -22.522087794354583  _ #Surrender#	 lift : -15.419185635502924 : bad	 :| stand

[TimeMatrix: total:  o: 2806081.0 -> a: 9997.0
org->adv	$w:31.049139351287437->64.19925977793338  	$d:3.5209247345318966->3.2509752925877766  	$l:65.42993591418067->32.54976492947884
	 improve value x$w(high is good):33.15012042664594  	x$d:-0.26994944194411996  	 x$l(negative is good):-32.880170984701834
	 	 $w-$l: -34.38079656289324 -> 31.64949484845454  _ @double@	 lift : 66.03029141134778 : good	 :) hit 

[Prob_ROI diff: -0.15419185635701038 (up%-> -16.598134919171013) . o: 0.9289709784134677 -> a: 0.7747791220564573	 returnMoney: o:0.12725871962115018 a: 0.21227229128432723 (probReturnRate: 1.6680373016188035	 totalSpendMoney: o: 0.13698890770354044 a: 0.27397781540744615 (probTotalSpendRate: 2.0000000000026663

[Time_ROI diff: 0.6603029141134777 (up%-> 100.62647510592691) . o: 0.6561920343710677 -> a: 1.3164949484845454	 returnMoney: o:5.523984E8 a: 7896600.0 (timeReturnRate: 0.014295117436980266	 totalSpendMoney: o: 8.418243E8 a: 5998200.0 (timeTotalSpendRate: 0.00712523979172376

[[Per_Prob_ROI diff: 0.05934381165892948 (up%-> 23310.261975380385) . o: 2.5458234541339206E-4 -> a: 0.059598394004342865	 per returnMoney: o:3.4874957418786015E-5 a: 0.016328637791102094	 per totalSpendMoney: o: 3.754149293053999E-5 a: 0.02107521656980355

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.20616719239773904
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.051975336040728654
 probRunR/probTalSR= 0.8340186508082899 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Ten, 	playerStartValue=2	@@@ 

net money diff:  -0.058572784299781674 , up % -> -232.88023436205862 .  o: -0.02515146227855415 -> a: -0.08372424657833583 (anet/onet: 3.3288023436205862

[ProbMatrix: total: o: 4.5662969234546683E-4  -> a: 4.566296923457457E-4
org->adv	$w:35.085582133552315->31.67211610342513  	$d:11.468617595299499->6.096999210435667  	$l:53.445800271148194->62.23088468613921
	 improve value x$w(high is good):-3.4134660301271857  	x$d:-5.371618384863831  	 x$l(negative is good):8.785084414991019
	 	 $w-$l: -18.36021813759588 -> -30.55876858271408  _ #Surrender#	 lift : -12.198550445118201 : bad	 :| stand

[TimeMatrix: total:  o: 1404865.0 -> a: 5005.0
org->adv	$w:31.00881579368836->64.11588411588411  	$d:3.527171649945012->3.2567432567432566  	$l:65.46401255636663->32.62737262737262
	 improve value x$w(high is good):33.10706832219576  	x$d:-0.2704283932017555  	 x$l(negative is good):-32.836639928994
	 	 $w-$l: -34.45519676267826 -> 31.488511488511488  _ @double@	 lift : 65.94370825118976 : good	 :) hit 

[Prob_ROI diff: -0.12198550445223943 (up%-> -14.941919450210607) . o: 0.8163978186251034 -> a: 0.694412314172864	 returnMoney: o:0.1118374454250939 a: 0.1902535688291107 (probReturnRate: 1.701161610996722	 totalSpendMoney: o: 0.13698890770364805 a: 0.27397781540744653 (probTotalSpendRate: 2.0000000000010982

[Time_ROI diff: 0.6594370825118975 (up%-> 100.60859899513875) . o: 0.6554480323732174 -> a: 1.3148851148851148	 returnMoney: o:2.762448E8 a: 3948600.0 (timeReturnRate: 0.014293843721221177	 totalSpendMoney: o: 4.214595E8 a: 3003000.0 (timeTotalSpendRate: 0.00712523979172376

[[Per_Prob_ROI diff: 0.0531925999277917 (up%-> 23775.148917398576) . o: 2.237319316593871E-4 -> a: 0.053416331859451084	 per returnMoney: o:3.064879293644667E-5 a: 0.014634889909931593	 per totalSpendMoney: o: 3.754149293056948E-5 a: 0.02107521656980358

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.18055828875202112
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.058572784299781674
 probRunR/probTalSR= 0.8505808054978939 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=One1, 	playerStartValue=3	@@@ 

net money diff:  -0.0890765342023777 , up % -> -186.9988075367593 .  o: -0.047634814026751196 -> a: -0.1367113482291289 (anet/onet: 2.8699880753675933

[ProbMatrix: total: o: 4.5662969234554814E-4  -> a: 4.56629692345604E-4
org->adv	$w:26.42138768528781->21.647648448753074  	$d:12.384471982266449->6.806010383257564  	$l:61.19414033244575->71.54634116798935
	 improve value x$w(high is good):-4.7737392365347375  	x$d:-5.578461599008885  	 x$l(negative is good):10.352200835543606
	 	 $w-$l: -34.77275264715794 -> -49.89869271923628  _ #Surrender#	 lift : -15.125940072078347 : bad	 :| stand

[TimeMatrix: total:  o: 2.5249393E7 -> a: 184717.0
org->adv	$w:31.224354581514095->64.72495763790013  	$d:3.47178247017661->3.2065267409063596  	$l:65.30386294830929->32.0685156211935
	 improve value x$w(high is good):33.50060305638604  	x$d:-0.2652557292702502  	 x$l(negative is good):-33.23534732711579
	 	 $w-$l: -34.07950836679519 -> 32.65644201670664  _ @double@	 lift : 66.73595038350183 : good	 :) hit 

[Prob_ROI diff: -0.15125940073907118 (up%-> -23.189603558870136) . o: 0.6522724735465075 -> a: 0.5010130728074363	 returnMoney: o:0.08935409367515952 a: 0.13726646717838925 (probReturnRate: 1.536207928843325	 totalSpendMoney: o: 0.13698890770191072 a: 0.27397781540751814 (probTotalSpendRate: 2.0000000000269855

[Time_ROI diff: 0.6673595038350183 (up%-> 101.23703378129278) . o: 0.659204916332048 -> a: 1.3265644201670663	 returnMoney: o:4.9933572E9 a: 1.470234E8 (timeReturnRate: 0.029443797852074353	 totalSpendMoney: o: 7.5748179E9 a: 1.108302E8 (timeTotalSpendRate: 0.014631401238041642

[[Per_Prob_ROI diff: 0.0381724032822263 (up%-> 10399.39034429906) . o: 3.6706385680726364E-4 -> a: 0.03853946713903356	 per returnMoney: o:5.0283676800877616E-5 a: 0.01055895901372225	 per totalSpendMoney: o: 7.708998745183496E-5 a: 0.02107521656980909

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.2403359349414489
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.0890765342023777
 probRunR/probTalSR= 0.7681039644112987 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Two2, 	playerStartValue=3	@@@ 

net money diff:  -0.005183153285407971 , up % -> -117.6209913683032 .  o: -0.00440665669036755 -> a: -0.00958980997577552 (anet/onet: 2.176209913683032

[ProbMatrix: total: o: 4.566296923455474E-4  -> a: 4.566296923458001E-4
org->adv	$w:45.718739387477505->45.769851902148076  	$d:5.345723044474793->4.960082150430789  	$l:48.9355375680477->49.27006594742114
	 improve value x$w(high is good):0.051112514670570874  	x$d:-0.3856408940440046  	 x$l(negative is good):0.33452837937343816
	 	 $w-$l: -3.216798180570196 -> -3.5002140452730646  _ #Surrender#	 lift : -0.2834158647028684 : bad	 :| stand

[TimeMatrix: total:  o: 667225.0 -> a: 346957.0
org->adv	$w:55.386563752856986->64.40250520957929  	$d:3.36318333395781->3.233830128805587  	$l:41.25025291318521->32.363664661615125
	 improve value x$w(high is good):9.015941456722302  	x$d:-0.12935320515222326  	 x$l(negative is good):-8.886588251570082
	 	 $w-$l: 14.13631083967178 -> 32.038840547964156  _ @double@	 lift : 17.90252970829238 : good	 :) hit 

[Prob_ROI diff: -0.002834158648484908 (up%-> -0.2928358015854683) . o: 0.967832018195944 -> a: 0.9649978595474591	 returnMoney: o:0.1325822510132521 a: 0.2643880054317779 (probReturnRate: 1.9941432839705766	 totalSpendMoney: o: 0.13698890770361966 a: 0.2739778154075534 (probTotalSpendRate: 2.000000000002293

[Time_ROI diff: 0.1790252970829238 (up%-> 15.685218469554544) . o: 1.1413631083967177 -> a: 1.3203884054796415	 returnMoney: o:2.284638E8 a: 2.748708E8 (timeReturnRate: 1.2031262720833673	 totalSpendMoney: o: 2.001675E8 a: 2.081742E8 (timeTotalSpendRate: 1.04

[[Per_Prob_ROI diff: 0.03551732385273602 (up%-> 91.74454653541257) . o: 0.03871328072783776 -> a: 0.07423060458057378	 per returnMoney: o:0.005303290040530084 a: 0.02033753887936753	 per totalSpendMoney: o: 0.005479556308144787 a: 0.0210752165698118

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.008017311933892879
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.005183153285407971
 probRunR/probTalSR= 0.9970716419841452 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Three3, 	playerStartValue=3	@@@ 

net money diff:  -4.748321528242616E-4 , up % -> -308.69453537048173 .  o: -1.5381942289791062E-4 -> a: -6.286515757221722E-4 (anet/onet: 4.0869453537048175

[ProbMatrix: total: o: 4.5662969234564095E-4  -> a: 4.566296923458152E-4
org->adv	$w:47.35640329379054->47.48445941311356  	$d:5.174907369968317->4.801627714240922  	$l:47.46868933624114->47.71391287264551
	 improve value x$w(high is good):0.12805611932301986  	x$d:-0.3732796557273943  	 x$l(negative is good):0.24522353640436734
	 	 $w-$l: -0.11228604245059337 -> -0.2294534595319475  _ #Surrender#	 lift : -0.11716741708135414 : bad	 :| stand

[TimeMatrix: total:  o: 388825.0 -> a: 202189.0
org->adv	$w:55.36963929788465->64.38184075295887  	$d:3.365009965922973->3.2355865056951663  	$l:41.265350736192374->32.38257274134597
	 improve value x$w(high is good):9.012201455074212  	x$d:-0.1294234602278066  	 x$l(negative is good):-8.882777994846407
	 	 $w-$l: 14.104288561692279 -> 31.999268011612898  _ @double@	 lift : 17.894979449920616 : good	 :) hit 

[Prob_ROI diff: -0.0011716741716796264 (up%-> -0.1172991277161682) . o: 0.9988771395766535 -> a: 0.9977054654049738	 returnMoney: o:0.1368350882807622 a: 0.27334916383175994 (probReturnRate: 1.9976540174468569	 totalSpendMoney: o: 0.13698890770366012 a: 0.2739778154074821 (probTotalSpendRate: 2.0000000000011817

[Time_ROI diff: 0.17894979449920623 (up%-> 15.683003395832419) . o: 1.1410428856169228 -> a: 1.319992680116129	 returnMoney: o:1.330998E8 a: 1.601328E8 (timeReturnRate: 1.203103235316657	 totalSpendMoney: o: 1.166475E8 a: 1.213134E8 (timeTotalSpendRate: 1.04

[[Per_Prob_ROI diff: 0.036791488678854935 (up%-> 92.08211706208432) . o: 0.03995508558306613 -> a: 0.07674657426192107	 per returnMoney: o:0.005473403531230488 a: 0.021026858756289228	 per totalSpendMoney: o: 0.005479556308146405 a: 0.021075216569806317

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.001646506324503888
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -4.748321528242616E-4
 probRunR/probTalSR= 0.9988270087228382 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Four4, 	playerStartValue=3	@@@ 

net money diff:  -0.004388928070784559 , up % -> -50.000000000216914 .  o: 0.008777856141531037 -> a: 0.004388928070746478 (anet/onet: 0.49999999999783085

[ProbMatrix: total: o: 4.5662969234581014E-4  -> a: 4.5662969234580835E-4
org->adv	$w:49.28416596967552->49.284165969675506  	$d:4.635524594950188->4.635524594950163  	$l:46.080309435374296->46.08030943537433
	 improve value x$w(high is good):-1.4210854715202004E-14  	x$d:-2.4868995751603507E-14  	 x$l(negative is good):3.552713678800501E-14
	 	 $w-$l: 3.2038565343012246 -> 3.2038565343011696  _ #Surrender#	 lift : -5.551115123125783E-14 : bad	 :| stand

[TimeMatrix: total:  o: 117949.0 -> a: 117949.0
org->adv	$w:64.36425912894556->64.36425912894556  	$d:3.2369922593663363->3.2369922593663363  	$l:32.398748611688106->32.398748611688106
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 31.96551051725745 -> 31.96551051725745  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: -1.4099832412739488E-13 (up%-> -1.3662117760153685E-11) . o: 1.0320385653432458 -> a: 1.0320385653431048	 returnMoney: o:0.2827556715489719 a: 0.14137783577447546 (probReturnRate: 0.4999999999999629	 totalSpendMoney: o: 0.2739778154074409 a: 0.13698890770372898 (probTotalSpendRate: 0.5000000000000312

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.3196551051725747 -> a: 1.3196551051725747	 returnMoney: o:9.33912E7 a: 4.66956E7 (timeReturnRate: 0.5	 totalSpendMoney: o: 7.07694E7 a: 3.53847E7 (timeTotalSpendRate: 0.5

[[Per_Prob_ROI diff: -1.0852430065710905E-14 (up%-> -1.3670185939933303E-11) . o: 0.07938758194948045 -> a: 0.0793875819494696	 per returnMoney: o:0.021750436272997838 a: 0.010875218136498112	 per totalSpendMoney: o: 0.021075216569803143 a: 0.010537608284902229

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.004388928070925557
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.004388928070784559
 probRunR/probTalSR= 0.9999999999998634 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Five5, 	playerStartValue=3	@@@ 

net money diff:  -0.009247318837343366 , up % -> -50.000000000083745 .  o: 0.018494637674655756 -> a: 0.00924731883731239 (anet/onet: 0.4999999999991626

[ProbMatrix: total: o: 4.5662969234578423E-4  -> a: 4.566296923457834E-4
org->adv	$w:51.143527492569675->51.14352749256965  	$d:4.4633593311059085->4.46335933110591  	$l:44.39311317632442->44.39311317632443
	 improve value x$w(high is good):-2.1316282072803006E-14  	x$d:1.7763568394002505E-15  	 x$l(negative is good):7.105427357601002E-15
	 	 $w-$l: 6.750414316245257 -> 6.750414316245223  _ @double@	 lift : -3.3306690738754696E-14 : bad	 :| stand

[TimeMatrix: total:  o: 71149.0 -> a: 71149.0
org->adv	$w:64.35086930244978->64.35086930244978  	$d:3.2382746068110584->3.2382746068110584  	$l:32.41085609073915->32.41085609073915
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 31.94001321171063 -> 31.94001321171063  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: -1.163513729807164E-13 (up%-> -1.0899383737847224E-11) . o: 1.0675041431626608 -> a: 1.0675041431625445	 returnMoney: o:0.2924724530820784 a: 0.14623622654103072 (probReturnRate: 0.49999999999997097	 totalSpendMoney: o: 0.27397781540742266 a: 0.13698890770371833 (probTotalSpendRate: 0.5000000000000255

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.3194001321171063 -> a: 1.3194001321171063	 returnMoney: o:5.63244E7 a: 2.81622E7 (timeReturnRate: 0.5	 totalSpendMoney: o: 4.26894E7 a: 2.13447E7 (timeTotalSpendRate: 0.5

[[Per_Prob_ROI diff: -8.965050923848139E-15 (up%-> -1.0917584044661377E-11) . o: 0.08211570332020468 -> a: 0.08211570332019572	 per returnMoney: o:0.022497881006313725 a: 0.011248940503156208	 per totalSpendMoney: o: 0.021075216569801745 a: 0.01053760828490141

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.009247318837459717
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.009247318837343366
 probRunR/probTalSR= 0.9999999999998909 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Six6, 	playerStartValue=3	@@@ 

net money diff:  -0.012394113142484703 , up % -> -50.00000000003807 .  o: 0.024788226284950532 -> a: 0.012394113142465829 (anet/onet: 0.4999999999996193

[ProbMatrix: total: o: 4.5662969234576927E-4  -> a: 4.566296923457676E-4
org->adv	$w:52.31633056799129->52.31633056799121  	$d:4.414869317553665->4.41486931755367  	$l:43.26880011445504->43.26880011445512
	 improve value x$w(high is good):-7.815970093361102E-14  	x$d:5.329070518200751E-15  	 x$l(negative is good):7.815970093361102E-14
	 	 $w-$l: 9.047530453536245 -> 9.04753045353609  _ @double@	 lift : -1.5543122344752192E-13 : bad	 :| stand

[TimeMatrix: total:  o: 40417.0 -> a: 40417.0
org->adv	$w:64.33926318133459->64.33926318133459  	$d:3.2387361753717494->3.2387361753717494  	$l:32.422000643293664->32.422000643293664
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 31.91726253804092 -> 31.91726253804092  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: -7.172040739078511E-14 (up%-> -6.576985933793069E-12) . o: 1.0904753045354718 -> a: 1.0904753045354	 returnMoney: o:0.298766041692381 a: 0.14938302084618527 (probReturnRate: 0.49999999999998246	 totalSpendMoney: o: 0.2739778154074305 a: 0.13698890770371944 (probTotalSpendRate: 0.5000000000000153

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.3191726253804092 -> a: 1.3191726253804092	 returnMoney: o:3.19902E7 a: 1.59951E7 (timeReturnRate: 0.5	 totalSpendMoney: o: 2.42502E7 a: 1.21251E7 (timeTotalSpendRate: 0.5

[[Per_Prob_ROI diff: -5.509481759702339E-15 (up%-> -6.568077477613396E-12) . o: 0.08388271573349783 -> a: 0.08388271573349232	 per returnMoney: o:0.022982003207106232 a: 0.011491001603552712	 per totalSpendMoney: o: 0.021075216569802345 a: 0.010537608284901495

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.012394113142556423
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.012394113142484703
 probRunR/probTalSR= 0.9999999999999343 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Seven7, 	playerStartValue=3	@@@ 

net money diff:  -0.033951618226214925 , up % -> -376.04101675491785 .  o: 0.009028700783548477 -> a: -0.024922917442666448 (anet/onet: -2.7604101675491783

[ProbMatrix: total: o: 4.566296923455011E-4  -> a: 4.5662969234576287E-4
org->adv	$w:48.19251647157821->42.65418059753736  	$d:10.205793230252409->5.594947014161844  	$l:41.60169029816937->51.75087238830079
	 improve value x$w(high is good):-5.538335874040847  	x$d:-4.610846216090565  	 x$l(negative is good):10.149182090131418
	 	 $w-$l: 6.590826173408837 -> -9.096691790763433  _ #Surrender#	 lift : -15.68751796417227 : bad	 :| stand

[TimeMatrix: total:  o: 3413617.0 -> a: 24973.0
org->adv	$w:31.07741729666802->64.26140231449966  	$d:3.5161531009483484->3.247507307892524  	$l:65.40642960238362->32.49109037760782
	 improve value x$w(high is good):33.183985017831645  	x$d:-0.26864579305582437  	 x$l(negative is good):-32.915339224775806
	 	 $w-$l: -34.32901230571561 -> 31.770311936891844  _ @double@	 lift : 66.09932424260745 : good	 :) hit 

[Prob_ROI diff: -0.15687517964123765 (up%-> -14.717512310682967) . o: 1.0659082617336562 -> a: 0.9090330820924185	 returnMoney: o:0.14601760848732973 a: 0.2490548979647662 (probReturnRate: 1.7056497537855324	 totalSpendMoney: o: 0.13698890770378125 a: 0.27397781540743266 (probTotalSpendRate: 1.999999999999052

[Time_ROI diff: 0.6609932424260745 (up%-> 100.65224624048153) . o: 0.6567098769428439 -> a: 1.3177031193689184	 returnMoney: o:6.725268E8 a: 1.97442E7 (timeReturnRate: 0.02935823524058818	 totalSpendMoney: o: 1.0240851E9 a: 1.49838E7 (timeTotalSpendRate: 0.014631401238041642

[[Per_Prob_ROI diff: 0.06932578587401801 (up%-> 11557.460047993567) . o: 5.998358253987935E-4 -> a: 0.06992562169941681	 per returnMoney: o:8.217085452297677E-5 a: 0.019158069074212785	 per totalSpendMoney: o: 7.708998745288758E-5 a: 0.02107521656980251

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.19082679786745257
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.033951618226214925
 probRunR/probTalSR= 0.8528248768931704 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Eight8, 	playerStartValue=3	@@@ 

net money diff:  -0.04117470042867827 , up % -> -2295.250392723092 .  o: -0.001793908871956601 -> a: -0.04296860930063487 (anet/onet: 23.952503927230918

[ProbMatrix: total: o: 4.5662969234589194E-4  -> a: 4.5662969234575056E-4
org->adv	$w:44.065852582940856->39.25153437708824  	$d:10.558766273058207->5.813687244209912  	$l:45.37538114400094->54.93477837870186
	 improve value x$w(high is good):-4.814318205852615  	x$d:-4.745079028848296  	 x$l(negative is good):9.559397234700917
	 	 $w-$l: -1.3095285610600804 -> -15.68324400161361  _ #Surrender#	 lift : -14.37371544055353 : bad	 :| stand

[TimeMatrix: total:  o: 2048881.0 -> a: 14989.0
org->adv	$w:31.068080576665995->64.24044299152712  	$d:3.517822655390918->3.249049302822069  	$l:65.4140967679431->32.51050770565081
	 improve value x$w(high is good):33.17236241486113  	x$d:-0.26877335256884916  	 x$l(negative is good):-32.90358906229228
	 	 $w-$l: -34.34601619127709 -> 31.729935285876316  _ @double@	 lift : 66.07595147715341 : good	 :) hit 

[Prob_ROI diff: -0.14373715440486456 (up%-> -14.564440954554609) . o: 0.986904714388745 -> a: 0.8431675599838805	 returnMoney: o:0.13519499883195799 a: 0.23100920610680556 (probReturnRate: 1.7087111809064832	 totalSpendMoney: o: 0.1369889077039146 a: 0.27397781540744043 (probTotalSpendRate: 1.9999999999971623

[Time_ROI diff: 0.660759514771534 (up%-> 100.64271449187284) . o: 0.656539838087229 -> a: 1.317299352858763	 returnMoney: o:4.035516E8 a: 1.1847E7 (timeReturnRate: 0.029356840612204237	 totalSpendMoney: o: 6.146643E8 a: 8993400.0 (timeTotalSpendRate: 0.014631401238041642

[[Per_Prob_ROI diff: 0.06430366619645479 (up%-> 11578.383724904344) . o: 5.553768792283315E-4 -> a: 0.06485904307568312	 per returnMoney: o:7.608047204949802E-5 a: 0.017769938931292736	 per totalSpendMoney: o: 7.708998745296263E-5 a: 0.021075216569803108

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.18491185483354283
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.04117470042867827
 probRunR/probTalSR= 0.8543555904544539 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Nine9, 	playerStartValue=3	@@@ 

net money diff:  -0.04735619613226846 , up % -> -327.5962733032755 .  o: -0.014455657768862346 -> a: -0.06181185390113081 (anet/onet: 4.275962733032754

[ProbMatrix: total: o: 4.5662969234580537E-4  -> a: 4.56629692345747E-4
org->adv	$w:39.33590959491823->35.75537633503663  	$d:10.775751411877609->5.92834990499862  	$l:49.888338993204165->58.31627375996475
	 improve value x$w(high is good):-3.580533259881598  	x$d:-4.847401506878989  	 x$l(negative is good):8.427934766760586
	 	 $w-$l: -10.552429398285934 -> -22.56089742492813  _ #Surrender#	 lift : -12.008468026642195 : bad	 :| stand

[TimeMatrix: total:  o: 1366513.0 -> a: 9997.0
org->adv	$w:31.04017305360432->64.19925977793338  	$d:3.519907970140057->3.2509752925877766  	$l:65.43991897625561->32.54976492947884
	 improve value x$w(high is good):33.15908672432906  	x$d:-0.26893267755228045  	 x$l(negative is good):-32.89015404677677
	 	 $w-$l: -34.3997459226513 -> 31.64949484845454  _ @double@	 lift : 66.04924077110583 : good	 :) hit 

[Prob_ROI diff: -0.1200846802668778 (up%-> -13.425147207353499) . o: 0.8944757060176035 -> a: 0.7743910257507257	 returnMoney: o:0.12253324993492987 a: 0.21216596150631473 (probReturnRate: 1.7314970558520522	 totalSpendMoney: o: 0.1369889077037922 a: 0.27397781540744554 (probTotalSpendRate: 1.9999999999989861

[Time_ROI diff: 0.6604924077110584 (up%-> 100.68442828472547) . o: 0.656002540773487 -> a: 1.3164949484845454	 returnMoney: o:2.689308E8 a: 7896600.0 (timeReturnRate: 0.029362943924608115	 totalSpendMoney: o: 4.099539E8 a: 5998200.0 (timeTotalSpendRate: 0.014631401238041642

[[Per_Prob_ROI diff: 0.05906517763650104 (up%-> 11734.116416348676) . o: 5.033628058624669E-4 -> a: 0.05956854044236351	 per returnMoney: o:6.895512095381534E-5 a: 0.016320458577408825	 per totalSpendMoney: o: 7.708998745289376E-5 a: 0.021075216569803504

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.16744087639914626
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.04735619613226846
 probRunR/probTalSR= 0.865748527926465 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Ten, 	playerStartValue=3	@@@ 

net money diff:  -0.05451519335315473 , up % -> -186.00812959956167 .  o: -0.029307962759754128 -> a: -0.08382315611290886 (anet/onet: 2.860081295995617

[ProbMatrix: total: o: 4.5662969234573994E-4  -> a: 4.566296923457459E-4
org->adv	$w:33.791189221781146->31.672116103425207  	$d:11.023215796790172->6.060897917187931  	$l:55.185594981428686->62.26698597938686
	 improve value x$w(high is good):-2.1190731183559386  	x$d:-4.962317879602241  	 x$l(negative is good):7.081390997958174
	 	 $w-$l: -21.39440575964754 -> -30.59486987596165  _ #Surrender#	 lift : -9.20046411631411 : bad	 :| stand

[TimeMatrix: total:  o: 684145.0 -> a: 5005.0
org->adv	$w:30.99986114054769->64.11588411588411  	$d:3.526153081583582->3.2567432567432566  	$l:65.47398577786872->32.62737262737262
	 improve value x$w(high is good):33.11602297533642  	x$d:-0.2694098248403254  	 x$l(negative is good):-32.8466131504961
	 	 $w-$l: -34.47412463732103 -> 31.488511488511488  _ @double@	 lift : 65.96263612583253 : good	 :) hit 

[Prob_ROI diff: -0.09200464116378826 (up%-> -11.704592027176718) . o: 0.7860559424041782 -> a: 0.6940513012403899	 returnMoney: o:0.1076809449439693 a: 0.1901546592945375 (probReturnRate: 1.7659081594564625	 totalSpendMoney: o: 0.13698890770372343 a: 0.27397781540744637 (probTotalSpendRate: 1.9999999999999964

[Time_ROI diff: 0.6596263612583252 (up%-> 100.66654701022478) . o: 0.6552587536267896 -> a: 1.3148851148851148	 returnMoney: o:1.344876E8 a: 3948600.0 (timeReturnRate: 0.029360327643589448	 totalSpendMoney: o: 2.052435E8 a: 3003000.0 (timeTotalSpendRate: 0.014631401238041642

[[Per_Prob_ROI diff: 0.052946211638150664 (up%-> 11969.303074438998) . o: 4.423499957254801E-4 -> a: 0.05338856163387615	 per returnMoney: o:6.059704273718025E-5 a: 0.014627281484195193	 per totalSpendMoney: o: 7.708998745285506E-5 a: 0.021075216569803566

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.146519834516943
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.05451519335315473
 probRunR/probTalSR= 0.8829540797282328 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=One1, 	playerStartValue=4	@@@ 

net money diff:  -0.08569219196224498 , up % -> -166.4549091151065 .  o: -0.051480723769454784 -> a: -0.13717291573169976 (anet/onet: 2.664549091151065

[ProbMatrix: total: o: 4.5662969234617535E-4  -> a: 4.5662969234562295E-4
org->adv	$w:25.264918243689056->21.563507098126326  	$d:11.889950170214163->6.805824151403211  	$l:62.84513158609677->71.63066875047046
	 improve value x$w(high is good):-3.70141114556273  	x$d:-5.084126018810952  	 x$l(negative is good):8.785537164373693
	 	 $w-$l: -37.58021334240772 -> -50.06716165234414  _ #Surrender#	 lift : -12.486948309936425 : bad	 :| stand

[TimeMatrix: total:  o: 1.2290785E7 -> a: 184717.0
org->adv	$w:31.20581801731948->64.72495763790013  	$d:3.469721421373818->3.2065267409063596  	$l:65.32446056130671->32.0685156211935
	 improve value x$w(high is good):33.51913962058065  	x$d:-0.2631946804674583  	 x$l(negative is good):-33.25594494011321
	 	 $w-$l: -34.11864254398723 -> 32.65644201670664  _ @double@	 lift : 66.77508456069387 : good	 :) hit 

[Prob_ROI diff: -0.12486948310706208 (up%-> -20.004791716212576) . o: 0.6241978665834523 -> a: 0.49932838347639025	 returnMoney: o:0.08550818393424997 a: 0.13680489967583936 (probReturnRate: 1.5999041656765054	 totalSpendMoney: o: 0.13698890770370475 a: 0.2739778154075391 (probTotalSpendRate: 2.0000000000009464

[Time_ROI diff: 0.6677508456069385 (up%-> 101.35657056744435) . o: 0.6588135745601278 -> a: 1.3265644201670663	 returnMoney: o:2.4292008E9 a: 1.470234E8 (timeReturnRate: 0.06052336225148617	 totalSpendMoney: o: 3.6872355E9 a: 1.108302E8 (timeTotalSpendRate: 0.03005780346820809

[[Per_Prob_ROI diff: 0.0376882596212977 (up%-> 5222.758089652009) . o: 7.216160307323148E-4 -> a: 0.038409875652030016	 per returnMoney: o:9.885339183150286E-5 a: 0.010523453821218413	 per totalSpendMoney: o: 1.5836867942624827E-4 a: 0.021075216569810703

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=true]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.21056167506930706
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.08569219196224498
 probRunR/probTalSR= 0.7999520828378742 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Two2, 	playerStartValue=4	@@@ 

net money diff:  -0.005429814830619578 , up % -> -117.1258746179134 .  o: -0.00463587985859884 -> a: -0.010065694689218418 (anet/onet: 2.171258746179134

[ProbMatrix: total: o: 4.5662969234560967E-4  -> a: 4.5662969234580553E-4
org->adv	$w:45.633595383274226->45.68145028051858  	$d:5.348681323931475->4.963190778060364  	$l:49.017723292794294->49.35535894142106
	 improve value x$w(high is good):0.04785489724435621  	x$d:-0.38549054587111176  	 x$l(negative is good):0.3376356486267653
	 	 $w-$l: -3.3841279095200685 -> -3.6739086609024807  _ #Surrender#	 lift : -0.28978075138241244 : bad	 :| stand

[TimeMatrix: total:  o: 667225.0 -> a: 346957.0
org->adv	$w:55.386563752856986->64.40250520957929  	$d:3.36318333395781->3.233830128805587  	$l:41.25025291318521->32.363664661615125
	 improve value x$w(high is good):9.015941456722302  	x$d:-0.12935320515222326  	 x$l(negative is good):-8.886588251570082
	 	 $w-$l: 14.13631083967178 -> 32.038840547964156  _ @double@	 lift : 17.90252970829238 : good	 :) hit 

[Prob_ROI diff: -0.0028978075135046577 (up%-> -0.2999307930266282) . o: 0.9661587209044545 -> a: 0.9632609133909499	 returnMoney: o:0.13235302784521952 a: 0.2639121207183888 (probReturnRate: 1.994001384139253	 totalSpendMoney: o: 0.13698890770381836 a: 0.27397781540760724 (probTotalSpendRate: 1.9999999999997848

[Time_ROI diff: 0.1790252970829238 (up%-> 15.685218469554544) . o: 1.1413631083967177 -> a: 1.3203884054796415	 returnMoney: o:2.284638E8 a: 2.748708E8 (timeReturnRate: 1.2031262720833673	 totalSpendMoney: o: 2.001675E8 a: 2.081742E8 (timeTotalSpendRate: 1.04

[[Per_Prob_ROI diff: 0.035450644501587206 (up%-> 91.73090232110268) . o: 0.03864634883617818 -> a: 0.07409699333776538	 per returnMoney: o:0.005294121113808781 a: 0.020300932362952988	 per totalSpendMoney: o: 0.005479556308152734 a: 0.021075216569815942

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.008327622344124236
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.005429814830619578
 probRunR/probTalSR= 0.9970006920697337 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Three3, 	playerStartValue=4	@@@ 

net money diff:  -7.133296563902047E-4 , up % -> -190.00470167951937 .  o: -3.7542737105178414E-4 -> a: -0.0010887570274419889 (anet/onet: 2.900047016795194

[ProbMatrix: total: o: 4.5662969234570893E-4  -> a: 4.5662969234580873E-4
org->adv	$w:47.274110298538616->47.39902890423131  	$d:5.177722636351746->4.804553437334366  	$l:47.54816706510963->47.79641765843432
	 improve value x$w(high is good):0.12491860569269164  	x$d:-0.3731691990173793  	 x$l(negative is good):0.24825059332469124
	 	 $w-$l: -0.2740567665710125 -> -0.3973887542030097  _ #Surrender#	 lift : -0.12333198763199715 : bad	 :| stand

[TimeMatrix: total:  o: 388825.0 -> a: 202189.0
org->adv	$w:55.36963929788465->64.38184075295887  	$d:3.365009965922973->3.2355865056951663  	$l:41.265350736192374->32.38257274134597
	 improve value x$w(high is good):9.012201455074212  	x$d:-0.1294234602278066  	 x$l(negative is good):-8.882777994846407
	 	 $w-$l: 14.104288561692279 -> 31.999268011612898  _ @double@	 lift : 17.894979449920616 : good	 :) hit 

[Prob_ROI diff: -0.0012333198760486885 (up%-> -0.12367091611880698) . o: 0.9972594323340135 -> a: 0.9960261124579648	 returnMoney: o:0.1366134803327249 a: 0.2728890583800865 (probReturnRate: 1.9975265816774423	 totalSpendMoney: o: 0.1369889077037767 a: 0.27397781540752847 (probTotalSpendRate: 1.9999999999998181

[Time_ROI diff: 0.17894979449920623 (up%-> 15.683003395832419) . o: 1.1410428856169228 -> a: 1.319992680116129	 returnMoney: o:1.330998E8 a: 1.601328E8 (timeReturnRate: 1.203103235316657	 totalSpendMoney: o: 1.166475E8 a: 1.213134E8 (timeTotalSpendRate: 1.04

[[Per_Prob_ROI diff: 0.036727015972636765 (up%-> 92.06986362284849) . o: 0.039890377293360535 -> a: 0.0766173932659973	 per returnMoney: o:0.005464539213308996 a: 0.020991466029237422	 per totalSpendMoney: o: 0.005479556308151068 a: 0.02107521656980988

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.0019466495324388933
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -7.133296563902047E-4
 probRunR/probTalSR= 0.998763290838812 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Four4, 	playerStartValue=4	@@@ 

net money diff:  -0.004168000172964953 , up % -> -49.99999999978524 .  o: 0.00833600034596571 -> a: 0.004168000173000758 (anet/onet: 0.5000000000021476

[ProbMatrix: total: o: 4.566296923458023E-4  -> a: 4.566296923458162E-4
org->adv	$w:49.20203137641621->49.20203137641791  	$d:4.638519484548589->4.638519484548457  	$l:46.159449139035196->46.15944913903364
	 improve value x$w(high is good):1.6981971384666394E-12  	x$d:-1.3233858453531866E-13  	 x$l(negative is good):-1.5560885913146194E-12
	 	 $w-$l: 3.0425822373810085 -> 3.0425822373842726  _ #Surrender#	 lift : 3.2640556923979602E-12 : good	 :| stand

[TimeMatrix: total:  o: 117949.0 -> a: 117949.0
org->adv	$w:64.36425912894556->64.36425912894556  	$d:3.2369922593663363->3.2369922593663363  	$l:32.398748611688106->32.398748611688106
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 31.96551051725745 -> 31.96551051725745  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: 1.3278267374516872E-13 (up%-> 1.2886194315207323E-11) . o: 1.0304258223738605 -> a: 1.0304258223739933	 returnMoney: o:0.2823138157534264 a: 0.14115690787672097 (probReturnRate: 0.5000000000000275	 totalSpendMoney: o: 0.2739778154074607 a: 0.13698890770372021 (probTotalSpendRate: 0.49999999999996303

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.3196551051725747 -> a: 1.3196551051725747	 returnMoney: o:9.33912E7 a: 4.66956E7 (timeReturnRate: 0.5	 totalSpendMoney: o: 7.07694E7 a: 3.53847E7 (timeTotalSpendRate: 0.5

[[Per_Prob_ROI diff: 1.0241807402167069E-14 (up%-> 1.2921211147585607E-11) . o: 0.07926352479798925 -> a: 0.07926352479799949	 per returnMoney: o:0.021716447365648185 a: 0.01085822368282469	 per totalSpendMoney: o: 0.02107521656980467 a: 0.010537608284901554

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.00416800017283217
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.004168000172964953
 probRunR/probTalSR= 1.000000000000129 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Five5, 	playerStartValue=4	@@@ 

net money diff:  -0.009033309869125983 , up % -> -49.99999999991873 .  o: 0.01806661973828133 -> a: 0.009033309869155348 (anet/onet: 0.5000000000008127

[ProbMatrix: total: o: 4.5662969234577875E-4  -> a: 4.566296923457897E-4
org->adv	$w:51.06472730529181->51.064727305293324  	$d:4.464736131248492->4.464736131248405  	$l:44.4705365634597->44.47053656345826
	 improve value x$w(high is good):1.5134560271690134E-12  	x$d:-8.704148513061227E-14  	 x$l(negative is good):-1.4424017535930034E-12
	 	 $w-$l: 6.594190741832112 -> 6.59419074183506  _ @double@	 lift : 2.9476421303797906E-12 : good	 :| stand

[TimeMatrix: total:  o: 71149.0 -> a: 71149.0
org->adv	$w:64.35086930244978->64.35086930244978  	$d:3.2382746068110584->3.2382746068110584  	$l:32.41085609073915->32.41085609073915
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 31.94001321171063 -> 31.94001321171063  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: 1.1191048088221578E-13 (up%-> 1.0498741076167622E-11) . o: 1.0659419074183578 -> a: 1.0659419074184697	 returnMoney: o:0.2920444351457209 a: 0.14602221757286568 (probReturnRate: 0.5000000000000179	 totalSpendMoney: o: 0.2739778154074396 a: 0.13698890770371033 (probTotalSpendRate: 0.49999999999996547

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.3194001321171063 -> a: 1.3194001321171063	 returnMoney: o:5.63244E7 a: 2.81622E7 (timeReturnRate: 0.5	 totalSpendMoney: o: 4.26894E7 a: 2.13447E7 (timeTotalSpendRate: 0.5

[[Per_Prob_ROI diff: 8.590350653037149E-15 (up%-> 1.0476608313482247E-11) . o: 0.0819955313398737 -> a: 0.08199553133988229	 per returnMoney: o:0.02246495654967084 a: 0.011232478274835821	 per totalSpendMoney: o: 0.021075216569803046 a: 0.010537608284900794

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.009033309869014072
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.009033309869125983
 probRunR/probTalSR= 1.0000000000001048 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Six6, 	playerStartValue=4	@@@ 

net money diff:  -0.012180001274872593 , up % -> -49.9999999999673 .  o: 0.024360002549761117 -> a: 0.012180001274888524 (anet/onet: 0.500000000000327

[ProbMatrix: total: o: 4.566296923457657E-4  -> a: 4.566296923457729E-4
org->adv	$w:52.22862067923821->52.22862067923882  	$d:4.433990405502166->4.433990405502127  	$l:43.33738891525962->43.33738891525906
	 improve value x$w(high is good):6.110667527536862E-13  	x$d:-3.907985046680551E-14  	 x$l(negative is good):-5.613287612504791E-13
	 	 $w-$l: 8.891231763978592 -> 8.891231763979762  _ @double@	 lift : 1.1712852909795402E-12 : good	 :| stand

[TimeMatrix: total:  o: 40417.0 -> a: 40417.0
org->adv	$w:64.33926318133459->64.33926318133459  	$d:3.2387361753717494->3.2387361753717494  	$l:32.422000643293664->32.422000643293664
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 31.91726253804092 -> 31.91726253804092  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: 6.17284001691587E-14 (up%-> 5.668812738105011E-12) . o: 1.0889123176397864 -> a: 1.088912317639848	 returnMoney: o:0.298337817957202 a: 0.14916890897860322 (probReturnRate: 0.5000000000000074	 totalSpendMoney: o: 0.2739778154074409 a: 0.1369889077037147 (probTotalSpendRate: 0.499999999999979

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.3191726253804092 -> a: 1.3191726253804092	 returnMoney: o:3.19902E7 a: 1.59951E7 (timeReturnRate: 0.5	 totalSpendMoney: o: 2.42502E7 a: 1.21251E7 (timeTotalSpendRate: 0.5

[[Per_Prob_ROI diff: 4.746203430272544E-15 (up%-> 5.666263811514136E-12) . o: 0.08376248597229126 -> a: 0.083762485972296	 per returnMoney: o:0.02294906291978477 a: 0.011474531459892554	 per totalSpendMoney: o: 0.021075216569803143 a: 0.01053760828490113

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.012180001274810864
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.012180001274872593
 probRunR/probTalSR= 1.0000000000000568 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Seven7, 	playerStartValue=4	@@@ 

net money diff:  -0.028412049278927598 , up % -> -997.017270144805 .  o: 0.0028497048275604175 -> a: -0.02556234445136718 (anet/onet: -8.97017270144805

[ProbMatrix: total: o: 4.566296923456611E-4  -> a: 4.566296923457578E-4
org->adv	$w:46.08457386625464->42.49058738529081  	$d:9.911097212468409->5.688747020945628  	$l:44.00432892127696->51.82066559376357
	 improve value x$w(high is good):-3.593986480963828  	x$d:-4.222350191522781  	 x$l(negative is good):7.816336672486614
	 	 $w-$l: 2.080244944977677 -> -9.330078208472765  _ #Surrender#	 lift : -11.410323153450442 : bad	 :| stand

[TimeMatrix: total:  o: 1661665.0 -> a: 24973.0
org->adv	$w:31.05896796285653->64.26140231449966  	$d:3.514065711199309->3.247507307892524  	$l:65.42696632594416->32.49109037760782
	 improve value x$w(high is good):33.202434351643134  	x$d:-0.26655840330678515  	 x$l(negative is good):-32.935875948336346
	 	 $w-$l: -34.36799836308763 -> 31.770311936891844  _ @double@	 lift : 66.13831029997948 : good	 :) hit 

[Prob_ROI diff: -0.11410323153350987 (up%-> -11.17779758415735) . o: 1.0208024494488255 -> a: 0.9066992179153156	 returnMoney: o:0.13983861253147073 a: 0.24841547095606992 (probReturnRate: 1.7764440483143662	 totalSpendMoney: o: 0.1369889077039103 a: 0.2739778154074371 (probTotalSpendRate: 1.9999999999972002

[Time_ROI diff: 0.6613831029997946 (up%-> 100.77143565705657) . o: 0.6563200163691237 -> a: 1.3177031193689184	 returnMoney: o:3.271752E8 a: 1.97442E7 (timeReturnRate: 0.060347483550097926	 totalSpendMoney: o: 4.984995E8 a: 1.49838E7 (timeTotalSpendRate: 0.03005780346820809

[[Per_Prob_ROI diff: 0.06856597524712434 (up%-> 5810.092699207989) . o: 0.0011801184386691626 -> a: 0.0697460936857935	 per returnMoney: o:1.6166313587453264E-4 a: 0.019108882381236147	 per totalSpendMoney: o: 1.583686794264859E-4 a: 0.021075216569802855

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.14251528081243747
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.028412049278927598
 probRunR/probTalSR= 0.8882220241584265 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Eight8, 	playerStartValue=4	@@@ 

net money diff:  -0.036137647289553376 , up % -> -469.6286812426746 .  o: -0.007694940435479858 -> a: -0.043832587725033234 (anet/onet: 5.696286812426746

[ProbMatrix: total: o: 4.566296923459029E-4  -> a: 4.5662969234574845E-4
org->adv	$w:42.113458735322396->39.093826342892754  	$d:10.15588288566589->5.813757187545292  	$l:47.73065837901172->55.092416469561954
	 improve value x$w(high is good):-3.019632392429642  	x$d:-4.342125698120597  	 x$l(negative is good):7.361758090550232
	 	 $w-$l: -5.617199643689324 -> -15.9985901266692  _ #Surrender#	 lift : -10.381390482979874 : bad	 :| stand

[TimeMatrix: total:  o: 997345.0 -> a: 14989.0
org->adv	$w:31.04963678566594->64.24044299152712  	$d:3.515734274498794->3.249049302822069  	$l:65.43462893983526->32.51050770565081
	 improve value x$w(high is good):33.19080620586118  	x$d:-0.266684971676725  	 x$l(negative is good):-32.924121234184454
	 	 $w-$l: -34.38499215416932 -> 31.729935285876316  _ @double@	 lift : 66.11492744004563 : good	 :) hit 

[Prob_ROI diff: -0.10381390482946595 (up%-> -10.999239738340636) . o: 0.9438280035627945 -> a: 0.8400140987333286	 returnMoney: o:0.12929396726841513 a: 0.23014522768240808 (probReturnRate: 1.7800152052309222	 totalSpendMoney: o: 0.136988907703895 a: 0.2739778154074413 (probTotalSpendRate: 1.9999999999974547

[Time_ROI diff: 0.6611492744004563 (up%-> 100.76189824649502) . o: 0.6561500784583068 -> a: 1.317299352858763	 returnMoney: o:1.963224E8 a: 1.1847E7 (timeReturnRate: 0.06034461681397538	 totalSpendMoney: o: 2.992035E8 a: 8993400.0 (timeTotalSpendRate: 0.03005780346820809

[[Per_Prob_ROI diff: 0.06352533849337598 (up%-> 5821.973663564257) . o: 0.001091130639956988 -> a: 0.06461646913333297	 per returnMoney: o:1.494727945299597E-4 a: 0.017703479052492928	 per totalSpendMoney: o: 1.583686794264682E-4 a: 0.021075216569803178

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.13995155211901933
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.036137647289553376
 probRunR/probTalSR= 0.8900076026165937 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Nine9, 	playerStartValue=4	@@@ 

net money diff:  -0.04270755933741316 , up % -> -216.470781963148 .  o: -0.01972901790722209 -> a: -0.06243657724463525 (anet/onet: 3.16470781963148

[ProbMatrix: total: o: 4.5662969234588484E-4  -> a: 4.566296923457463E-4
org->adv	$w:37.670495345823305->35.67871235725172  	$d:10.257100250221809->5.85365817854534  	$l:52.072404403954884->58.46762946420294
	 improve value x$w(high is good):-1.991782988571586  	x$d:-4.403442071676469  	 x$l(negative is good):6.395225060248059
	 	 $w-$l: -14.40190905813158 -> -22.788917106951224  _ #Surrender#	 lift : -8.387008048819645 : bad	 :| stand

[TimeMatrix: total:  o: 665185.0 -> a: 9997.0
org->adv	$w:31.02174583010741->64.19925977793338  	$d:3.5178183512857326->3.2509752925877766  	$l:65.46043581860685->32.54976492947884
	 improve value x$w(high is good):33.17751394782597  	x$d:-0.266843058697956  	 x$l(negative is good):-32.91067088912801
	 	 $w-$l: -34.43868998849944 -> 31.64949484845454  _ @double@	 lift : 66.08818483695399 : good	 :) hit 

[Prob_ROI diff: -0.08387008048823907 (up%-> -9.798125117672516) . o: 0.8559809094187388 -> a: 0.7721108289304998	 returnMoney: o:0.11725988979658131 a: 0.21154123816281 (probReturnRate: 1.804037497645486	 totalSpendMoney: o: 0.1369889077038034 a: 0.27397781540744526 (probTotalSpendRate: 1.9999999999988207

[Time_ROI diff: 0.6608818483695398 (up%-> 100.80363681775273) . o: 0.6556131001150056 -> a: 1.3164949484845454	 returnMoney: o:1.308312E8 a: 7896600.0 (timeReturnRate: 0.06035716251169446	 totalSpendMoney: o: 1.995555E8 a: 5998200.0 (timeTotalSpendRate: 0.03005780346820809

[[Per_Prob_ROI diff: 0.05840356738127511 (up%-> 5901.893982554866) . o: 9.895733056864034E-4 -> a: 0.05939314068696151	 per returnMoney: o:1.3556056623882233E-4 a: 0.01627240293560077	 per totalSpendMoney: o: 1.583686794263623E-4 a: 0.021075216569803483

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.12657763982565223
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.04270755933741316
 probRunR/probTalSR= 0.9020187488232749 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Ten, 	playerStartValue=4	@@@ 

net money diff:  -0.05037191884365426 , up % -> -148.82473835785214 .  o: -0.0338464689402201 -> a: -0.08421838778387436 (anet/onet: 2.4882473835785217

[ProbMatrix: total: o: 4.5662969234576623E-4  -> a: 4.566296923457453E-4
org->adv	$w:32.354862132282925->31.59999263080724  	$d:10.582823498909372->6.060888047185358  	$l:57.0623143688077->62.339119322007406
	 improve value x$w(high is good):-0.7548695014756852  	x$d:-4.521935451724014  	 x$l(negative is good):5.276804953199708
	 	 $w-$l: -24.707452236524773 -> -30.73912669120017  _ #Surrender#	 lift : -6.031674454675395 : bad	 :| stand

[TimeMatrix: total:  o: 333025.0 -> a: 5005.0
org->adv	$w:30.98145784850987->64.11588411588411  	$d:3.524059755273628->3.2567432567432566  	$l:65.4944823962165->32.62737262737262
	 improve value x$w(high is good):33.134426267374245  	x$d:-0.2673164985303713  	 x$l(negative is good):-32.867109768843875
	 	 $w-$l: -34.513024547706635 -> 31.488511488511488  _ @double@	 lift : 66.00153603621813 : good	 :) hit 

[Prob_ROI diff: -0.06031674454687308 (up%-> -8.010984664291383) . o: 0.7529254776348825 -> a: 0.6926087330880094	 returnMoney: o:0.10314243876351735 a: 0.18975942762357173 (probReturnRate: 1.8397803067139789	 totalSpendMoney: o: 0.13698890770373745 a: 0.2739778154074461 (probTotalSpendRate: 1.9999999999997897

[Time_ROI diff: 0.6600153603621811 (up%-> 100.78574492159834) . o: 0.6548697545229337 -> a: 1.3148851148851148	 returnMoney: o:6.54264E7 a: 3948600.0 (timeReturnRate: 0.06035178460071164	 totalSpendMoney: o: 9.99075E7 a: 3003000.0 (timeTotalSpendRate: 0.03005780346820809

[[Per_Prob_ROI diff: 0.052407160774733175 (up%-> 6020.807558875997) . o: 8.704340781906154E-4 -> a: 0.05327759485292379	 per returnMoney: o:1.1923981359944202E-4 a: 0.014596879047967056	 per totalSpendMoney: o: 1.5836867942628608E-4 a: 0.021075216569803545

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.11068866339052734
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.05037191884365426
 probRunR/probTalSR= 0.9198901533570861 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=One1, 	playerStartValue=5	@@@ 

net money diff:  -0.08267061917642311 , up % -> -149.53773488428678 .  o: -0.05528411891513145 -> a: -0.13795473809155456 (anet/onet: 2.495377348842868

[ProbMatrix: total: o: 4.566296923452228E-4  -> a: 4.5662969234559216E-4
org->adv	$w:24.169431581995802->21.479151084945386  	$d:11.304497862433628->6.689176445732642  	$l:64.52607055557057->71.83167246932197
	 improve value x$w(high is good):-2.6902804970504164  	x$d:-4.615321416700986  	 x$l(negative is good):7.305601913751403
	 	 $w-$l: -40.35663897357477 -> -50.35252138437658  _ #Surrender#	 lift : -9.995882410801816 : bad	 :| stand

[TimeMatrix: total:  o: 5981989.0 -> a: 184717.0
org->adv	$w:31.16772698846487->64.72495763790013  	$d:3.4654861451600794->3.2065267409063596  	$l:65.36678686637505->32.0685156211935
	 improve value x$w(high is good):33.55723064943526  	x$d:-0.25895940425371977  	 x$l(negative is good):-33.29827124518155
	 	 $w-$l: -34.19905987791017 -> 32.65644201670664  _ @double@	 lift : 66.85550189461682 : good	 :) hit 

[Prob_ROI diff: -0.09995882411196294 (up%-> -16.7594217346388) . o: 0.5964336102681007 -> a: 0.49647478615613777	 returnMoney: o:0.08170478878815442 a: 0.136023077315983 (probReturnRate: 1.664811565313093	 totalSpendMoney: o: 0.13698890770328587 a: 0.2739778154075376 (probTotalSpendRate: 2.0000000000070504

[Time_ROI diff: 0.6685550189461681 (up%-> 101.60265456780755) . o: 0.6580094012208982 -> a: 1.3265644201670663	 returnMoney: o:1.1808615E9 a: 1.470234E8 (timeReturnRate: 0.1245052023459144	 totalSpendMoney: o: 1.7945967E9 a: 1.108302E8 (timeTotalSpendRate: 0.06175771971496437

[[Per_Prob_ROI diff: 0.036773661253105924 (up%-> 2595.714111516698) . o: 0.001416706912750833 -> a: 0.038190368165856754	 per returnMoney: o:1.9407313251343093E-4 a: 0.010463313639691	 per totalSpendMoney: o: 3.253893294614866E-4 a: 0.02107521656981058

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=true]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.18262944328838604
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.08267061917642311
 probRunR/probTalSR= 0.8324057826536121 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Two2, 	playerStartValue=5	@@@ 

net money diff:  -0.0057152007365388335 , up % -> -116.33517524526506 .  o: -0.004912702219676629 -> a: -0.010627902956215463 (anet/onet: 2.163351752452651

[ProbMatrix: total: o: 4.5662969234553643E-4  -> a: 4.5662969234584717E-4
org->adv	$w:45.55501454898972->45.59950236509007  	$d:5.303766513645666->4.921884495737701  	$l:49.14121893736462->49.47861313917223
	 improve value x$w(high is good):0.04448781610035013  	x$d:-0.38188201790796494  	 x$l(negative is good):0.33739420180761215
	 	 $w-$l: -3.586204388374897 -> -3.879110774082167  _ #Surrender#	 lift : -0.29290638570727 : bad	 :| stand

[TimeMatrix: total:  o: 667225.0 -> a: 346957.0
org->adv	$w:55.386563752856986->64.40250520957929  	$d:3.36318333395781->3.233830128805587  	$l:41.25025291318521->32.363664661615125
	 improve value x$w(high is good):9.015941456722302  	x$d:-0.12935320515222326  	 x$l(negative is good):-8.886588251570082
	 	 $w-$l: 14.13631083967178 -> 32.038840547964156  _ @double@	 lift : 17.90252970829238 : good	 :) hit 

[Prob_ROI diff: -0.0029290638574670513 (up%-> -0.30380132209153277) . o: 0.9641379561161189 -> a: 0.9612088922586518	 returnMoney: o:0.13207620548406773 a: 0.26334991245138534 (probReturnRate: 1.993923973558985	 totalSpendMoney: o: 0.13698890770374436 a: 0.2739778154076008 (probTotalSpendRate: 2.000000000000818

[Time_ROI diff: 0.1790252970829238 (up%-> 15.685218469554544) . o: 1.1413631083967177 -> a: 1.3203884054796415	 returnMoney: o:2.284638E8 a: 2.748708E8 (timeReturnRate: 1.2031262720833673	 totalSpendMoney: o: 2.001675E8 a: 2.081742E8 (timeTotalSpendRate: 1.04

[[Per_Prob_ROI diff: 0.035373627313713074 (up%-> 91.72345899597781) . o: 0.038565518244644756 -> a: 0.07393914555835783	 per returnMoney: o:0.00528304821936271 a: 0.020257685573183488	 per totalSpendMoney: o: 0.005479556308149775 a: 0.021075216569815446

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.008644264594005885
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.0057152007365388335
 probRunR/probTalSR= 0.9969619867790848 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Three3, 	playerStartValue=5	@@@ 

net money diff:  -9.897463071860402E-4 , up % -> -153.80533802968236 .  o: -6.435058235722824E-4 -> a: -0.0016332521307583225 (anet/onet: 2.5380533802968235

[ProbMatrix: total: o: 4.566296923457258E-4  -> a: 4.5662969234583453E-4
org->adv	$w:47.19801207822453->47.319660058842786  	$d:5.134225529934152->4.764554196634361  	$l:47.667762391841315->47.91578574452286
	 improve value x$w(high is good):0.12164798061825621  	x$d:-0.3696713332997916  	 x$l(negative is good):0.24802335268154252
	 	 $w-$l: -0.4697503136167791 -> -0.5961256856800712  _ #Surrender#	 lift : -0.12637537206329208 : bad	 :| stand

[TimeMatrix: total:  o: 388825.0 -> a: 202189.0
org->adv	$w:55.36963929788465->64.38184075295887  	$d:3.365009965922973->3.2355865056951663  	$l:41.265350736192374->32.38257274134597
	 improve value x$w(high is good):9.012201455074212  	x$d:-0.1294234602278066  	 x$l(negative is good):-8.882777994846407
	 	 $w-$l: 14.104288561692279 -> 31.999268011612898  _ @double@	 lift : 17.894979449920616 : good	 :) hit 

[Prob_ROI diff: -0.0012637537207115246 (up%-> -0.1269718226060621) . o: 0.9953024968637321 -> a: 0.9940387431430205	 returnMoney: o:0.13634540188017624 a: 0.272344563276762 (probReturnRate: 1.9974605635480485	 totalSpendMoney: o: 0.13698890770374852 a: 0.2739778154075203 (probTotalSpendRate: 2.0000000000001696

[Time_ROI diff: 0.17894979449920623 (up%-> 15.683003395832419) . o: 1.1410428856169228 -> a: 1.319992680116129	 returnMoney: o:1.330998E8 a: 1.601328E8 (timeReturnRate: 1.203103235316657	 totalSpendMoney: o: 1.166475E8 a: 1.213134E8 (timeTotalSpendRate: 1.04

[[Per_Prob_ROI diff: 0.03665241882875998 (up%-> 92.06351572575755) . o: 0.039812099874549284 -> a: 0.07646451870330927	 per returnMoney: o:0.00545381607520705 a: 0.02094958179052015	 per totalSpendMoney: o: 0.005479556308149941 a: 0.021075216569809256

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.0022535000278975648
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -9.897463071860402E-4
 probRunR/probTalSR= 0.9987302817739395 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Four4, 	playerStartValue=5	@@@ 

net money diff:  -0.0039043741931175657 , up % -> -50.00000000014786 .  o: 0.007808748386212039 -> a: 0.003904374193094473 (anet/onet: 0.49999999999852135

[ProbMatrix: total: o: 4.566296923458126E-4  -> a: 4.566296923458101E-4
org->adv	$w:49.1253500082629->49.12535000826282  	$d:4.599438917019302->4.599438917019362  	$l:46.275211074717795->46.27521107471783
	 improve value x$w(high is good):-7.815970093361102E-14  	x$d:5.950795411990839E-14  	 x$l(negative is good):3.552713678800501E-14
	 	 $w-$l: 2.8501389335451046 -> 2.850138933544988  _ #Surrender#	 lift : -1.1657341758564144E-13 : bad	 :| stand

[TimeMatrix: total:  o: 117949.0 -> a: 117949.0
org->adv	$w:64.36425912894556->64.36425912894556  	$d:3.2369922593663363->3.2369922593663363  	$l:32.398748611688106->32.398748611688106
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 31.96551051725745 -> 31.96551051725745  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: -8.415490526658687E-14 (up%-> -8.182284062927697E-12) . o: 1.0285013893354793 -> a: 1.0285013893353951	 returnMoney: o:0.28178656379367 a: 0.14089328189682326 (probReturnRate: 0.4999999999999583	 totalSpendMoney: o: 0.27397781540745797 a: 0.1369889077037288 (probTotalSpendRate: 0.4999999999999993

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.3196551051725747 -> a: 1.3196551051725747	 returnMoney: o:9.33912E7 a: 4.66956E7 (timeReturnRate: 0.5	 totalSpendMoney: o: 7.07694E7 a: 3.53847E7 (timeTotalSpendRate: 0.5

[[Per_Prob_ROI diff: -6.480926906249351E-15 (up%-> -8.191729311681076E-12) . o: 0.07911549148734456 -> a: 0.07911549148733808	 per returnMoney: o:0.02167588952259 a: 0.010837944761294098	 per totalSpendMoney: o: 0.021075216569804458 a: 0.010537608284902215

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.0039043741932017206
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.0039043741931175657
 probRunR/probTalSR= 0.9999999999999181 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Five5, 	playerStartValue=5	@@@ 

net money diff:  -0.008781007296368437 , up % -> -50.00000000005011 .  o: 0.017562014592719277 -> a: 0.00878100729635084 (anet/onet: 0.499999999999499

[ProbMatrix: total: o: 4.566296923457844E-4  -> a: 4.5662969234578406E-4
org->adv	$w:50.99073753058166->50.99073753058211  	$d:4.428538306737524->4.428538306737541  	$l:44.580724162680816->44.58072416268035
	 improve value x$w(high is good):4.476419235288631E-13  	x$d:1.687538997430238E-14  	 x$l(negative is good):-4.689582056016661E-13
	 	 $w-$l: 6.410013367900847 -> 6.410013367901763  _ @double@	 lift : 9.159339953157541E-13 : good	 :| stand

[TimeMatrix: total:  o: 71149.0 -> a: 71149.0
org->adv	$w:64.35086930244978->64.35086930244978  	$d:3.2382746068110584->3.2382746068110584  	$l:32.41085609073915->32.41085609073915
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 31.94001321171063 -> 31.94001321171063  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: -6.372680161348399E-14 (up%-> -5.988797444574251E-12) . o: 1.064100133679081 -> a: 1.0641001336790172	 returnMoney: o:0.29153983000015593 a: 0.14576991500006822 (probReturnRate: 0.4999999999999666	 totalSpendMoney: o: 0.27397781540743665 a: 0.13698890770371738 (probTotalSpendRate: 0.49999999999999656

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.3194001321171063 -> a: 1.3194001321171063	 returnMoney: o:5.63244E7 a: 2.81622E7 (timeReturnRate: 0.5	 totalSpendMoney: o: 4.26894E7 a: 2.13447E7 (timeTotalSpendRate: 0.5

[[Per_Prob_ROI diff: -4.898859096158503E-15 (up%-> -5.9848849026897295E-12) . o: 0.08185385643685238 -> a: 0.08185385643684748	 per returnMoney: o:0.022426140769242764 a: 0.011213070384620633	 per totalSpendMoney: o: 0.02107521656980282 a: 0.010537608284901337

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.008781007296432164
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.008781007296368437
 probRunR/probTalSR= 0.99999999999994 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Six6, 	playerStartValue=5	@@@ 

net money diff:  -0.011927006945786606 , up % -> -50.00000000002467 .  o: 0.023854013891561443 -> a: 0.011927006945774837 (anet/onet: 0.4999999999997533

[ProbMatrix: total: o: 4.5662969234576867E-4  -> a: 4.5662969234576824E-4
org->adv	$w:52.16152965962293->52.16152965962293  	$d:4.383490098296907->4.383490098296929  	$l:43.45498024208017->43.45498024208013
	 improve value x$w(high is good):0.0  	x$d:2.220446049250313E-14  	 x$l(negative is good):-3.552713678800501E-14
	 	 $w-$l: 8.706549417542764 -> 8.706549417542798  _ @double@	 lift : 3.3306690738754696E-14 : good	 :| stand

[TimeMatrix: total:  o: 40417.0 -> a: 40417.0
org->adv	$w:64.33926318133459->64.33926318133459  	$d:3.2387361753717494->3.2387361753717494  	$l:32.422000643293664->32.422000643293664
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 31.91726253804092 -> 31.91726253804092  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: -4.263256414560601E-14 (up%-> -3.9218027224700815E-12) . o: 1.0870654941754594 -> a: 1.0870654941754168	 returnMoney: o:0.2978318292990003 a: 0.1489159146494937 (probReturnRate: 0.4999999999999783	 totalSpendMoney: o: 0.2739778154074389 a: 0.13698890770371885 (probTotalSpendRate: 0.4999999999999979

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.3191726253804092 -> a: 1.3191726253804092	 returnMoney: o:3.19902E7 a: 1.59951E7 (timeReturnRate: 0.5	 totalSpendMoney: o: 2.42502E7 a: 1.21251E7 (timeTotalSpendRate: 0.5

[[Per_Prob_ROI diff: -3.2751579226442118E-15 (up%-> -3.916696208508532E-12) . o: 0.08362042262888149 -> a: 0.08362042262887821	 per returnMoney: o:0.02291014071530772 a: 0.011455070357653361	 per totalSpendMoney: o: 0.02107521656980299 a: 0.01053760828490145

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.011927006945829238
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.011927006945786606
 probRunR/probTalSR= 0.9999999999999608 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Seven7, 	playerStartValue=5	@@@ 

net money diff:  -0.02315672306104588 , up % -> -770.4634432048401 .  o: -0.003005557663413927 -> a: -0.026162280724459808 (anet/onet: 8.704634432048401

[ProbMatrix: total: o: 4.5662969234564485E-4  -> a: 4.5662969234576607E-4
org->adv	$w:44.19647249387482->42.43990687222487  	$d:9.413039661849146->5.571135473625629  	$l:46.39048784427604->51.9889576541495
	 improve value x$w(high is good):-1.7565656216499548  	x$d:-3.8419041882235163  	 x$l(negative is good):5.598469809873464
	 	 $w-$l: -2.1940153504012185 -> -9.549050781924635  _ #Surrender#	 lift : -7.355035431523415 : bad	 :| stand

[TimeMatrix: total:  o: 808741.0 -> a: 24973.0
org->adv	$w:31.021056184860175->64.26140231449966  	$d:3.5097763066296874->3.247507307892524  	$l:65.46916750851014->32.49109037760782
	 improve value x$w(high is good):33.24034612963949  	x$d:-0.26226899873716336  	 x$l(negative is good):-32.97807713090232
	 	 $w-$l: -34.44811132364997 -> 31.770311936891844  _ @double@	 lift : 66.21842326054181 : good	 :) hit 

[Prob_ROI diff: -0.07355035431487988 (up%-> -7.520025955304071) . o: 0.978059846495648 -> a: 0.9045094921807681	 returnMoney: o:0.1339833500403428 a: 0.24781553468297607 (probReturnRate: 1.8495994808933947	 totalSpendMoney: o: 0.13698890770375674 a: 0.2739778154074359 (probTotalSpendRate: 1.9999999999994336

[Time_ROI diff: 0.662184232605418 (up%-> 101.01680454621628) . o: 0.6555188867635003 -> a: 1.3177031193689184	 returnMoney: o:1.590435E8 a: 1.97442E7 (timeReturnRate: 0.12414339473163002	 totalSpendMoney: o: 2.426223E8 a: 1.49838E7 (timeTotalSpendRate: 0.06175771971496437

[[Per_Prob_ROI diff: 0.06725447071143065 (up%-> 2894.9283902166912) . o: 0.0023231825332438194 -> a: 0.06957765324467446	 per returnMoney: o:3.1825023762551736E-4 a: 0.019062733437152004	 per totalSpendMoney: o: 3.253893294626051E-4 a: 0.02107521656980276

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.09670707737592577
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.02315672306104588
 probRunR/probTalSR= 0.9247997404469592 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Eight8, 	playerStartValue=5	@@@ 

net money diff:  -0.031209889146553413 , up % -> -239.4466937340516 .  o: -0.013034170010807325 -> a: -0.04424405915736074 (anet/onet: 3.394466937340516

[ProbMatrix: total: o: 4.5662969234575257E-4  -> a: 4.566296923457528E-4
org->adv	$w:40.367502311468016->39.029974069594445  	$d:9.750232299328845->5.791277518784602  	$l:49.88226538920315->55.17874841162096
	 improve value x$w(high is good):-1.3375282418735708  	x$d:-3.958954780544243  	 x$l(negative is good):5.29648302241781
	 	 $w-$l: -9.514763077735127 -> -16.148774342026517  _ #Surrender#	 lift : -6.63401126429139 : bad	 :| stand

[TimeMatrix: total:  o: 485413.0 -> a: 14989.0
org->adv	$w:31.011736397665494->64.24044299152712  	$d:3.511442833216251->3.249049302822069  	$l:65.47682076911826->32.51050770565081
	 improve value x$w(high is good):33.228706593861624  	x$d:-0.2623935303941818  	 x$l(negative is good):-32.96631306346745
	 	 $w-$l: -34.46508437145276 -> 31.729935285876316  _ @double@	 lift : 66.19501965732908 : good	 :) hit 

[Prob_ROI diff: -0.06634011264278394 (up%-> -7.331595174999154) . o: 0.9048523692225219 -> a: 0.8385122565797379	 returnMoney: o:0.12395473769295208 a: 0.2297337562500802 (probReturnRate: 1.85336809649949	 totalSpendMoney: o: 0.1369889077037594 a: 0.27397781540744093 (probTotalSpendRate: 1.9999999999994316

[Time_ROI diff: 0.6619501965732907 (up%-> 101.00725547969468) . o: 0.6553491562854724 -> a: 1.317299352858763	 returnMoney: o:9.54345E7 a: 1.1847E7 (timeReturnRate: 0.12413749744589221	 totalSpendMoney: o: 1.456239E8 a: 8993400.0 (timeTotalSpendRate: 0.06175771971496437

[[Per_Prob_ROI diff: 0.06235164977529268 (up%-> 2901.0306485634887) . o: 0.002149293038533306 -> a: 0.06450094281382598	 per returnMoney: o:2.944293056839717E-4 a: 0.01767182740385232	 per totalSpendMoney: o: 3.253893294626114E-4 a: 0.02107521656980315

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.09755000178933736
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.031209889146553413
 probRunR/probTalSR= 0.9266840482500084 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Nine9, 	playerStartValue=5	@@@ 

net money diff:  -0.03834790181992967 , up % -> -154.8000400833959 .  o: -0.02477253998078449 -> a: -0.06312044180071416 (anet/onet: 2.548000400833959

[ProbMatrix: total: o: 4.566296923457448E-4  -> a: 4.5662969234574807E-4
org->adv	$w:35.983318539116624->35.52638248642091  	$d:9.949752798845402->5.908712106298909  	$l:54.06692866203796->58.564905407280186
	 improve value x$w(high is good):-0.4569360526957169  	x$d:-4.041040692546494  	 x$l(negative is good):4.497976745242227
	 	 $w-$l: -18.083610122921336 -> -23.038522920859283  _ #Surrender#	 lift : -4.954912797937949 : bad	 :| stand

[TimeMatrix: total:  o: 323749.0 -> a: 9997.0
org->adv	$w:30.983879486886444->64.19925977793338  	$d:3.513524366098428->3.2509752925877766  	$l:65.50259614701513->32.54976492947884
	 improve value x$w(high is good):33.215380291046934  	x$d:-0.26254907351065127  	 x$l(negative is good):-32.952831217536286
	 	 $w-$l: -34.51871666012868 -> 31.64949484845454  _ @double@	 lift : 66.16821150858321 : good	 :) hit 

[Prob_ROI diff: -0.04954912797943212 (up%-> -6.04874409794926) . o: 0.8191638987708381 -> a: 0.7696147707914059	 returnMoney: o:0.11221636772294799 a: 0.2108573736067312 (probReturnRate: 1.8790251180408806	 totalSpendMoney: o: 0.13698890770373248 a: 0.27397781540744537 (probTotalSpendRate: 1.999999999999857

[Time_ROI diff: 0.6616821150858322 (up%-> 101.04904506093213) . o: 0.6548128333987132 -> a: 1.3164949484845454	 returnMoney: o:6.35985E7 a: 7896600.0 (timeReturnRate: 0.12416330573834289	 totalSpendMoney: o: 9.71247E7 a: 5998200.0 (timeTotalSpendRate: 0.06175771971496437

[[Per_Prob_ROI diff: 0.057255378735457885 (up%-> 2942.5752872894896) . o: 0.0019457574792656487 -> a: 0.05920113621472353	 per returnMoney: o:2.665471917409691E-4 a: 0.016219797969748553	 per totalSpendMoney: o: 3.2538932946254745E-4 a: 0.02107521656980349

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.08789702979936179
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.03834790181992967
 probRunR/probTalSR= 0.9395125590205075 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


		 @@@   dealerCard=Ten, 	playerStartValue=5	@@@ 

net money diff:  -0.046636179682978646 , up % -> -121.19577623270379 .  o: -0.03848003712062881 -> a: -0.08511621680360745 (anet/onet: 2.211957762327038

[ProbMatrix: total: o: 4.566296923456946E-4  -> a: 4.566296923457445E-4
org->adv	$w:30.88244598405326->31.454199564677225  	$d:10.145215378787498->6.024772822167575  	$l:58.97233863715924->62.52102761315519
	 improve value x$w(high is good):0.571753580623966  	x$d:-4.120442556619922  	 x$l(negative is good):3.548688975995951
	 	 $w-$l: -28.08989265310598 -> -31.066828048477962  _ #Surrender#	 lift : -2.9769353953719824 : bad	 :| stand

[TimeMatrix: total:  o: 162085.0 -> a: 5005.0
org->adv	$w:30.94364068235802->64.11588411588411  	$d:3.5197581515871303->3.2567432567432566  	$l:65.53660116605485->32.62737262737262
	 improve value x$w(high is good):33.17224343352609  	x$d:-0.26301489484387375  	 x$l(negative is good):-32.90922853868223
	 	 $w-$l: -34.592960483696835 -> 31.488511488511488  _ @double@	 lift : 66.08147197220833 : good	 :) hit 

[Prob_ROI diff: -0.029769353953789657 (up%-> -4.139801072772636) . o: 0.719101073469011 -> a: 0.6893317195152213	 returnMoney: o:0.09850887058309518 a: 0.18886159860383891 (probReturnRate: 1.9172039785445363	 totalSpendMoney: o: 0.136988907703724 a: 0.27397781540744637 (probTotalSpendRate: 1.9999999999999882

[Time_ROI diff: 0.660814719722083 (up%-> 101.03113129854627) . o: 0.6540703951630318 -> a: 1.3148851148851148	 returnMoney: o:3.18045E7 a: 3948600.0 (timeReturnRate: 0.12415224260717823	 totalSpendMoney: o: 4.86255E7 a: 3003000.0 (timeTotalSpendRate: 0.06175771971496437

[[Per_Prob_ROI diff: 0.05131743832647745 (up%-> 3004.395672950979) . o: 0.0017080785593088146 -> a: 0.053025516885786265	 per returnMoney: o:2.3398781611186505E-4 a: 0.014527815277218378	 per totalSpendMoney: o: 3.253893294625273E-4 a: 0.021075216569803566

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.0764055336367683
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.046636179682978646
 probRunR/probTalSR= 0.9586019892722738 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

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
MatrixKey [startValue=Six, dealerCard=Two2, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Six, dealerCard=Three3, situation=Start_With_A] : Double -> Hit
MatrixKey [startValue=Six, dealerCard=Four4, situation=Start_With_A] : Double -> Hit
MatrixKey [startValue=Six, dealerCard=Five5, situation=Start_With_A] : Double -> Hit
MatrixKey [startValue=Six, dealerCard=Six6, situation=Start_With_A] : Double -> Hit
MatrixKey [startValue=Six, dealerCard=Seven7, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Six, dealerCard=Eight8, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Six, dealerCard=Nine9, situation=Start_With_A] : Hit -> Double
MatrixKey [startValue=Six, dealerCard=Ten, situation=Start_With_A] : Hit -> Double


		 @@@   dealerCard=One1, 	playerStartValue=6	@@@ 

net money diff:  -0.07398139980341534 , up % -> -135.28137137385053 .  o: -0.05468705635675994 -> a: -0.12866845616017528 (anet/onet: 2.352813713738505

[ProbMatrix: total: o: 4.5662969234565374E-4  -> a: 4.5662969234560636E-4
org->adv	$w:23.61453960503324->21.605707600106193  	$d:12.850129191837917->9.825491832296644  	$l:63.53533120312884->68.56880056759717
	 improve value x$w(high is good):-2.008832004927047  	x$d:-3.0246373595412734  	 x$l(negative is good):5.033469364468324
	 	 $w-$l: -39.9207915980956 -> -46.96309296749097  _ #Surrender#	 lift : -7.04230136939537 : bad	 :| stand

[TimeMatrix: total:  o: 5470465.0 -> a: 184717.0
org->adv	$w:31.615191761577854->64.72495763790013  	$d:3.5296451032956067->5.129468321811203  	$l:64.85516313512653->30.145574040288658
	 improve value x$w(high is good):33.10976587632228  	x$d:1.599823218515596  	 x$l(negative is good):-34.709589094837874
	 	 $w-$l: -33.239971373548684 -> 34.57938359761148  _ @double@	 lift : 67.81935497116017 : good	 :) hit 

[Prob_ROI diff: -0.07042301369582415 (up%-> -11.721694670895456) . o: 0.6007920840207683 -> a: 0.5303690703249442	 returnMoney: o:0.08230185134717691 a: 0.14530935924734648 (probReturnRate: 1.7655661065798227	 totalSpendMoney: o: 0.13698890770393685 a: 0.27397781540752175 (probTotalSpendRate: 1.999999999997431

[Time_ROI diff: 0.6781935497116016 (up%-> 101.58676736140453) . o: 0.6676002862645132 -> a: 1.3457938359761148	 returnMoney: o:1.0956252E9 a: 1.491546E8 (timeReturnRate: 0.13613651821809136	 totalSpendMoney: o: 1.6411395E9 a: 1.108302E8 (timeTotalSpendRate: 0.06753246753246753

[[Per_Prob_ROI diff: 0.03923712187469201 (up%-> 2514.395965515788) . o: 0.0015604989195344636 -> a: 0.040797620794226476	 per returnMoney: o:2.1377104246019977E-4 a: 0.011177643019026653	 per totalSpendMoney: o: 3.558153446855502E-4 a: 0.021075216569809367

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.1444044134992395

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.07398139980341534     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.8827830532910453 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Two2, 	playerStartValue=6	@@@ 

net money diff:  -8.738378988208118E-4 , up % -> -1224.9025295333845 .  o: -7.133938233874759E-5 -> a: -9.451772811595593E-4 (anet/onet: 13.249025295333844

[ProbMatrix: total: o: 4.566296923455988E-4  -> a: 4.5662969234584635E-4
org->adv	$w:45.68031363434503->45.72480145043926  	$d:8.587295973111479->8.205413955203317  	$l:45.73239039254349->46.06978459435743
	 improve value x$w(high is good):0.04448781609422525  	x$d:-0.38188201790816123  	 x$l(negative is good):0.337394201813936
	 	 $w-$l: -0.05207675819846047 -> -0.3449831439181761  _ #Surrender#	 lift : -0.2929063857197156 : bad	 :| stand

[TimeMatrix: total:  o: 667225.0 -> a: 346957.0
org->adv	$w:55.386563752856986->64.40250520957929  	$d:4.365843605979991->5.162022959617475  	$l:40.247592641163024->30.43547183080324
	 improve value x$w(high is good):9.015941456722302  	x$d:0.7961793536374833  	 x$l(negative is good):-9.812120810359783
	 	 $w-$l: 15.13897111169396 -> 33.967033378776044  _ @double@	 lift : 18.828062267082085 : good	 :) hit 

[Prob_ROI diff: -0.0029290638560948157 (up%-> -0.293059001237181) . o: 0.999479232417175 -> a: 0.9965501685610801	 returnMoney: o:0.1369175683214515 a: 0.27303263812639506 (probReturnRate: 1.9941388199750683	 totalSpendMoney: o: 0.13698890770379024 a: 0.2739778154075546 (probTotalSpendRate: 1.9999999999998113

[Time_ROI diff: 0.1882806226708209 (up%-> 16.35246701033777) . o: 1.1513897111169396 -> a: 1.3396703337877605	 returnMoney: o:2.304708E8 a: 2.788848E8 (timeReturnRate: 1.2100656569075128	 totalSpendMoney: o: 2.001675E8 a: 2.081742E8 (timeTotalSpendRate: 1.04

[[Per_Prob_ROI diff: 0.036678535977242244 (up%-> 91.7441173053131) . o: 0.039979169296687 -> a: 0.07665770527392925	 per returnMoney: o:0.00547670273285806 a: 0.02100251062510731	 per totalSpendMoney: o: 0.005479556308151609 a: 0.021075216569811893

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.0038029017549156274

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -8.738378988208118E-4     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9970694099876283 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Three3, 	playerStartValue=6	@@@ 

net money diff:  -0.003668381905436613 , up % -> -47.746711637040434 .  o: 0.007683004294249229 -> a: 0.0040146223888126165 (anet/onet: 0.5225328836295957

[ProbMatrix: total: o: 4.566296923458316E-4  -> a: 4.566296923457408E-4
org->adv	$w:47.44113820225735->47.319490221648145  	$d:7.921966808657843->8.291638141957607  	$l:44.63689498908481->44.38887163639424
	 improve value x$w(high is good):-0.1216479806092039  	x$d:0.3696713332997641  	 x$l(negative is good):-0.2480233526905664
	 	 $w-$l: 2.8042432131725414 -> 2.930618585253908  _ #Surrender#	 lift : 0.1263753720813665 : good	 :) hit 

[TimeMatrix: total:  o: 202189.0 -> a: 388825.0
org->adv	$w:64.38184075295887->55.36963929788465  	$d:5.164474823061591->4.368031890953514  	$l:30.453684423979542->40.26232881116184
	 improve value x$w(high is good):-9.012201455074212  	x$d:-0.7964429321080768  	 x$l(negative is good):9.808644387182294
	 	 $w-$l: 33.92815632897932 -> 15.107310486722819  _ @double@	 lift : -18.8208458422565 : bad	 :| stand

[Prob_ROI diff: 0.0012637537198361137 (up%-> 0.12292816719784931) . o: 1.0280424321320425 -> a: 1.0293061858518786	 returnMoney: o:0.2816608197017185 a: 0.14100353009258526 (probReturnRate: 0.5006146408361282	 totalSpendMoney: o: 0.2739778154074693 a: 0.13698890770377264 (probTotalSpendRate: 0.5000000000001387

[Time_ROI diff: -0.18820845842256495 (up%-> -14.052941784717191) . o: 1.3392815632897932 -> a: 1.1510731048672282	 returnMoney: o:1.624728E8 a: 1.342698E8 (timeReturnRate: 0.8264140213007962	 totalSpendMoney: o: 1.213134E8 a: 1.166475E8 (timeTotalSpendRate: 0.9615384615384616

[[Per_Prob_ROI diff: -0.03790793965300504 (up%-> -47.936077353057115) . o: 0.07908018708708019 -> a: 0.041172247434075146	 per returnMoney: o:0.021666216900132193 a: 0.0056401412037034105	 per totalSpendMoney: o: 0.02107521656980533 a: 0.005479556308150906

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.002404628185600499

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.003668381905436613     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 1.0012292816719786 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Four4, 	playerStartValue=6	@@@ 

net money diff:  -0.008430275311777008 , up % -> -49.99999999999984 .  o: 0.01686055062355407 -> a: 0.008430275311777063 (anet/onet: 0.5000000000000017

[ProbMatrix: total: o: 4.5662969234580884E-4  -> a: 4.5662969234580944E-4
org->adv	$w:49.24205122037777->49.24205122037829  	$d:7.669881449664127->7.669881449664031  	$l:43.08806732995811->43.088067329957674
	 improve value x$w(high is good):5.258016244624741E-13  	x$d:-9.681144774731365E-14  	 x$l(negative is good):-4.334310688136611E-13
	 	 $w-$l: 6.153983890419662 -> 6.153983890420623  _ @double@	 lift : 9.603429163007604E-13 : good	 :| stand

[TimeMatrix: total:  o: 117949.0 -> a: 117949.0
org->adv	$w:64.36425912894556->64.36425912894556  	$d:5.164944170785678->5.164944170785678  	$l:30.47079670026876->30.47079670026876
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 33.8934624286768 -> 33.8934624286768  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: -2.886579864025407E-15 (up%-> -2.7192383726310177E-13) . o: 1.061539838904405 -> a: 1.0615398389044022	 returnMoney: o:0.29083836603098423 a: 0.14541918301549886 (probReturnRate: 0.5000000000000232	 totalSpendMoney: o: 0.27397781540743016 a: 0.1369889077037218 (probTotalSpendRate: 0.5000000000000245

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.338934624286768 -> a: 1.338934624286768	 returnMoney: o:9.47556E7 a: 4.73778E7 (timeReturnRate: 0.5	 totalSpendMoney: o: 7.07694E7 a: 3.53847E7 (timeTotalSpendRate: 0.5

[[Per_Prob_ROI diff: -2.220446049250313E-16 (up%-> -2.7192383726310177E-13) . o: 0.08165691068495423 -> a: 0.08165691068495401	 per returnMoney: o:0.022372182002383403 a: 0.01118609100119222	 per totalSpendMoney: o: 0.02107521656980232 a: 0.010537608284901677

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.008430275311779895

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.008430275311777008     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9999999999999973 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Five5, 	playerStartValue=6	@@@ 

net money diff:  -0.013016037659516283 , up % -> -50.00000000003039 .  o: 0.026032075319016745 -> a: 0.013016037659500462 (anet/onet: 0.49999999999969613

[ProbMatrix: total: o: 4.566296923457831E-4  -> a: 4.566296923457832E-4
org->adv	$w:51.104223151122305->51.10422315112295  	$d:7.293080410875831->7.293080410875801  	$l:41.60269643800184->41.60269643800126
	 improve value x$w(high is good):6.465938895416912E-13  	x$d:-3.019806626980426E-14  	 x$l(negative is good):-5.826450433232822E-13
	 	 $w-$l: 9.501526713120462 -> 9.501526713121693  _ @double@	 lift : 1.2323475573339238E-12 : good	 :| stand

[TimeMatrix: total:  o: 71149.0 -> a: 71149.0
org->adv	$w:64.35086930244978->64.35086930244978  	$d:5.169433161393695->5.169433161393695  	$l:30.479697536156518->30.479697536156518
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 33.871171766293266 -> 33.871171766293266  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: -6.106226635438361E-14 (up%-> -5.5763849315404554E-12) . o: 1.0950152671314135 -> a: 1.0950152671313524	 returnMoney: o:0.30000989072643297 a: 0.15000494536321327 (probReturnRate: 0.4999999999999893	 totalSpendMoney: o: 0.2739778154074162 a: 0.1369889077037128 (probTotalSpendRate: 0.5000000000000171

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.3387117176629326 -> a: 1.3387117176629326	 returnMoney: o:5.71488E7 a: 2.85744E7 (timeReturnRate: 0.5	 totalSpendMoney: o: 4.26894E7 a: 2.13447E7 (timeTotalSpendRate: 0.5

[[Per_Prob_ROI diff: -4.676814491233472E-15 (up%-> -5.552305087517896E-12) . o: 0.08423194362549333 -> a: 0.08423194362548865	 per returnMoney: o:0.023077683902033304 a: 0.011538841951016406	 per totalSpendMoney: o: 0.02107521656980125 a: 0.010537608284900985

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.013016037659577345

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.013016037659516283     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9999999999999444 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Six6, 	playerStartValue=6	@@@ 

net money diff:  -0.01754621086921787 , up % -> -50.00000000002436 .  o: 0.035092421738418644 -> a: 0.017546210869200773 (anet/onet: 0.4999999999997564

[ProbMatrix: total: o: 4.566296923457675E-4  -> a: 4.566296923457679E-4
org->adv	$w:52.26287682254167->52.26287682254171  	$d:8.2827365920538->8.282736592053796  	$l:39.454386585404535->39.454386585404485
	 improve value x$w(high is good):4.263256414560601E-14  	x$d:-3.552713678800501E-15  	 x$l(negative is good):-4.973799150320701E-14
	 	 $w-$l: 12.808490237137137 -> 12.808490237137226  _ @double@	 lift : 8.881784197001252E-14 : good	 :| stand

[TimeMatrix: total:  o: 40417.0 -> a: 40417.0
org->adv	$w:64.33926318133459->64.33926318133459  	$d:5.1611945468490985->5.1611945468490985  	$l:30.499542271816317->30.499542271816317
	 improve value x$w(high is good):0.0  	x$d:0.0  	 x$l(negative is good):0.0
	 	 $w-$l: 33.83972090951827 -> 33.83972090951827  _ @double@	 lift : 0.0 : bad	 :| stand

[Prob_ROI diff: -6.59472476627343E-14 (up%-> -5.845947191040079E-12) . o: 1.1280849023715065 -> a: 1.1280849023714405	 returnMoney: o:0.3090702371458434 a: 0.15453511857291702 (probReturnRate: 0.49999999999998485	 totalSpendMoney: o: 0.2739778154074248 a: 0.13698890770371625 (probTotalSpendRate: 0.5000000000000141

[Time_ROI diff: 0.0 (up%-> 0.0) . o: 1.3383972090951828 -> a: 1.3383972090951828	 returnMoney: o:3.24564E7 a: 1.62282E7 (timeReturnRate: 0.5	 totalSpendMoney: o: 2.42502E7 a: 1.21251E7 (timeTotalSpendRate: 0.5

[[Per_Prob_ROI diff: -5.065392549852277E-15 (up%-> -5.837335736844524E-12) . o: 0.08677576172088511 -> a: 0.08677576172088004	 per returnMoney: o:0.02377463362660334 a: 0.011887316813301308	 per totalSpendMoney: o: 0.021075216569801904 a: 0.010537608284901249

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.017546210869283818

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.01754621086921787     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9999999999999415 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Seven7, 	playerStartValue=6	@@@ 

net money diff:  -0.009075919405499094 , up % -> -126.07521308095792 .  o: 0.007198813457226588 -> a: -0.001877105948272506 (anet/onet: -0.26075213080957915

[ProbMatrix: total: o: 4.56629692345698E-4  -> a: 4.5662969234576227E-4
org->adv	$w:44.243717217897455->42.53508123132377  	$d:16.76759940448502->14.24470690168334  	$l:38.98868337761753->43.22021186699289
	 improve value x$w(high is good):-1.7086359865736824  	x$d:-2.522892502801678  	 x$l(negative is good):4.231528489375364
	 	 $w-$l: 5.255033840279927 -> -0.6851306356691178  _ #Surrender#	 lift : -5.940164475949045 : bad	 :| stand

[TimeMatrix: total:  o: 739585.0 -> a: 24973.0
org->adv	$w:31.46440233374122->64.26140231449966  	$d:3.5751130701677294->5.205622071837585  	$l:64.96048459609105->30.532975613662757
	 improve value x$w(high is good):32.79699998075844  	x$d:1.6305090016698554  	 x$l(negative is good):-34.42750898242829
	 	 $w-$l: -33.49608226234983 -> 33.728426700836906  _ @double@	 lift : 67.22450896318674 : good	 :) hit 

[Prob_ROI diff: -0.059401644759137895 (up%-> -5.643591816168431) . o: 1.0525503384025225 -> a: 0.9931486936433847	 returnMoney: o:0.1441877211610263 a: 0.2721007094591569 (probReturnRate: 1.8871281636754604	 totalSpendMoney: o: 0.1369889077037997 a: 0.2739778154074294 (probTotalSpendRate: 1.9999999999987588

[Time_ROI diff: 0.6722450896318675 (up%-> 101.08353199337704) . o: 0.6650391773765016 -> a: 1.337284267008369	 returnMoney: o:1.475559E8 a: 2.00376E7 (timeReturnRate: 0.13579667095656628	 totalSpendMoney: o: 2.218755E8 a: 1.49838E7 (timeTotalSpendRate: 0.06753246753246753

[[Per_Prob_ROI diff: 0.07366215637431973 (up%-> 2694.4013192903967) . o: 0.0027338969828636945 -> a: 0.07639605335718343	 per returnMoney: o:3.7451356145721116E-4 a: 0.020930823804550528	 per totalSpendMoney: o: 3.5581534468519406E-4 a: 0.02107521656980226

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.06847756416463699

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.009075919405499094     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9435640818383159 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Eight8, 	playerStartValue=6	@@@ 

net money diff:  -0.02497131208647918 , up % -> -244.23082548349635 .  o: -0.0102244718851702 -> a: -0.03519578397164938 (anet/onet: 3.4423082548349635

[ProbMatrix: total: o: 4.566296923457529E-4  -> a: 4.5662969234575333E-4
org->adv	$w:40.60498827885437->39.20994083123637  	$d:11.326300972703095->8.73390160303858  	$l:48.068710748442534->52.056157565725044
	 improve value x$w(high is good):-1.3950474476179977  	x$d:-2.5923993696645145  	 x$l(negative is good):3.9874468172825104
	 	 $w-$l: -7.463722469588163 -> -12.846216734488674  _ #Surrender#	 lift : -5.382494264900512 : bad	 :| stand

[TimeMatrix: total:  o: 443905.0 -> a: 14989.0
org->adv	$w:31.45492841936901->64.24044299152712  	$d:3.5755398114461427->5.17045833611315  	$l:64.96953176918485->30.589098672359732
	 improve value x$w(high is good):32.78551457215811  	x$d:1.594918524667007  	 x$l(negative is good):-34.38043309682512
	 	 $w-$l: -33.51460334981584 -> 33.65134431916739  _ @double@	 lift : 67.16594766898322 : good	 :) hit 

[Prob_ROI diff: -0.05382494264870086 (up%-> -5.816631496877267) . o: 0.9253627753038416 -> a: 0.8715378326551407	 returnMoney: o:0.1267644358186348 a: 0.23878203143578955 (probReturnRate: 1.8836673700612785	 totalSpendMoney: o: 0.136988907703805 a: 0.27397781540743893 (probTotalSpendRate: 1.999999999998751

[Time_ROI diff: 0.6716594766898323 (up%-> 101.02360977460933) . o: 0.6648539665018416 -> a: 1.3365134431916739	 returnMoney: o:8.85396E7 a: 1.20198E7 (timeReturnRate: 0.13575620400363228	 totalSpendMoney: o: 1.331715E8 a: 8993400.0 (timeTotalSpendRate: 0.06753246753246753

[[Per_Prob_ROI diff: 0.06463783206658927 (up%-> 2689.276682592482) . o: 0.0024035396761138738 -> a: 0.06704137174270314	 per returnMoney: o:3.292582748535969E-4 a: 0.01836784857198381	 per totalSpendMoney: o: 3.5581534468520783E-4 a: 0.021075216569802994

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.07879625473518004

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.02497131208647918     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9418336850312274 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Nine9, 	playerStartValue=6	@@@ 

net money diff:  -0.03297754561159019 , up % -> -154.1827678798642 .  o: -0.02138860656418204 -> a: -0.05436615217577223 (anet/onet: 2.5418276787986422

[ProbMatrix: total: o: 4.5662969234576075E-4  -> a: 4.5662969234574997E-4
org->adv	$w:36.51281042919979->35.716566704463496  	$d:11.360993413734416->8.723598589639062  	$l:52.126196157065806->55.55983470589744
	 improve value x$w(high is good):-0.7962437247362928  	x$d:-2.637394824095354  	 x$l(negative is good):3.433638548831631
	 	 $w-$l: -15.613385727866019 -> -19.843268001433938  _ #Surrender#	 lift : -4.22988227356792 : bad	 :| stand

[TimeMatrix: total:  o: 296065.0 -> a: 9997.0
org->adv	$w:31.426882610237616->64.19925977793338  	$d:3.577592758346985->5.171551465439632  	$l:64.9955246314154->30.62918875662699
	 improve value x$w(high is good):32.772377167695765  	x$d:1.5939587070926469  	 x$l(negative is good):-34.36633587478842
	 	 $w-$l: -33.56864202117779 -> 33.57007102130639  _ @double@	 lift : 67.13871304248417 : good	 :) hit 

[Prob_ROI diff: -0.04229882273565855 (up%-> -5.0125038313839845) . o: 0.8438661427213227 -> a: 0.8015673199856641	 returnMoney: o:0.11560030113958611 a: 0.2196116632316723 (probReturnRate: 1.899749923371684	 totalSpendMoney: o: 0.13698890770376815 a: 0.27397781540744454 (probTotalSpendRate: 1.99999999999933

[Time_ROI diff: 0.6713871304248419 (up%-> 101.06479091378422) . o: 0.6643135797882221 -> a: 1.335700710213064	 returnMoney: o:5.9004E7 a: 8011800.0 (timeReturnRate: 0.13578401464307505	 totalSpendMoney: o: 8.88195E7 a: 5998200.0 (timeTotalSpendRate: 0.06753246753246753

[[Per_Prob_ROI diff: 0.05946716450331737 (up%-> 2713.091232685935) . o: 0.0021918601109644745 -> a: 0.06165902461428185	 per returnMoney: o:3.002605224404834E-4 a: 0.016893204863974793	 per totalSpendMoney: o: 3.558153446851121E-4 a: 0.021075216569803427

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.07527636834724874

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.03297754561159019     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9498749616861601 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.


		 @@@   dealerCard=Ten, 	playerStartValue=6	@@@ 

net money diff:  -0.042382205672185924 , up % -> -122.78623375894165 .  o: -0.034517066266070345 -> a: -0.07689927193825627 (anet/onet: 2.2278623375894164

[ProbMatrix: total: o: 4.5662969234571934E-4  -> a: 4.566296923457459E-4
org->adv	$w:31.722103468652342->31.63601481017747  	$d:11.35881409216347->8.660270144903201  	$l:56.9190824391842->59.703715044919335
	 improve value x$w(high is good):-0.08608865847487124  	x$d:-2.6985439472602692  	 x$l(negative is good):2.7846326057351334
	 	 $w-$l: -25.19697897053186 -> -28.067700234741867  _ #Surrender#	 lift : -2.8707212642100077 : bad	 :| stand

[TimeMatrix: total:  o: 148225.0 -> a: 5005.0
org->adv	$w:31.38606847697757->64.11588411588411  	$d:3.5837409343902853->5.174825174825175  	$l:65.03019058863214->30.70929070929071
	 improve value x$w(high is good):32.729815638906544  	x$d:1.5910842404348897  	 x$l(negative is good):-34.320899879341425
	 	 $w-$l: -33.644122111654575 -> 33.4065934065934  _ @double@	 lift : 67.05071551824797 : good	 :) hit 

[Prob_ROI diff: -0.028707212642113178 (up%-> -3.8377076549894467) . o: 0.7480302102946953 -> a: 0.7193229976525821	 returnMoney: o:0.10247184143766802 a: 0.1970785434691902 (probReturnRate: 1.9232458468999987	 totalSpendMoney: o: 0.13698890770373837 a: 0.2739778154074465 (probTotalSpendRate: 1.999999999999779

[Time_ROI diff: 0.6705071551824798 (up%-> 101.04713802607169) . o: 0.6635587788834542 -> a: 1.334065934065934	 returnMoney: o:2.95068E7 a: 4006200.0 (timeReturnRate: 0.13577209321241204	 totalSpendMoney: o: 4.44675E7 a: 3003000.0 (timeTotalSpendRate: 0.06753246753246753

[[Per_Prob_ROI diff: 0.053389602669812804 (up%-> 2747.8832732945434) . o: 0.0019429356111550528 -> a: 0.055332538280967854	 per returnMoney: o:2.6616062711082604E-4 a: 0.015159887959168478	 per totalSpendMoney: o: 3.5581534468503474E-4 a: 0.021075216569803577

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.0710894183142991

 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.042382205672185924     $$$最重要的指标,决定性的! 只有收益变高才是正事$$$
 probRunR/probTalSR= 0.9616229234501056 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好. ) 每$的收益比固然重要,但有钱赚更重要.<1就是挣钱效率没有那么高了,但只要赚钱才重要.

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
MatrixKey [startValue=Seven, dealerCard=Two2, situation=Start_With_A] : Stand -> Hit
MatrixKey [startValue=Seven, dealerCard=Three3, situation=Start_With_A] : Stand -> Hit
MatrixKey [startValue=Seven, dealerCard=Four4, situation=Start_With_A] : Stand -> Hit
MatrixKey [startValue=Seven, dealerCard=Five5, situation=Start_With_A] : Stand -> Hit
MatrixKey [startValue=Seven, dealerCard=Six6, situation=Start_With_A] : Stand -> Hit
MatrixKey [startValue=Seven, dealerCard=Seven7, situation=Start_With_A] : Stand -> Hit
MatrixKey [startValue=Seven, dealerCard=Eight8, situation=Start_With_A] : Stand -> Hit
MatrixKey [startValue=Seven, dealerCard=Nine9, situation=Start_With_A] : Hit -> Stand
MatrixKey [startValue=Seven, dealerCard=Ten, situation=Start_With_A] : Hit -> Stand


		 @@@   dealerCard=One1, 	playerStartValue=7	@@@ 

net money diff:  -0.005384678958866407 , up % -> -11.598806362140325 .  o: -0.04642442326171202 -> a: -0.051809102220578426 (anet/onet: 1.1159880636214032

[ProbMatrix: total: o: 4.5662969234578374E-4  -> a: 4.5662969234575235E-4
org->adv	$w:26.613468588434735->24.548959667640265  	$d:12.883878625524378->13.082155614562312  	$l:60.502652786040876->62.36888471779742
	 improve value x$w(high is good):-2.06450892079447  	x$d:0.19827698903793411  	 x$l(negative is good):1.8662319317565448
	 	 $w-$l: -33.88918419760614 -> -37.81992505015716  _ #Surrender#	 lift : -3.930740852551018 : bad	 :| stand

[TimeMatrix: total:  o: 5470465.0 -> a: 14209.0
org->adv	$w:31.6801222565175->66.64789921880498  	$d:3.5296451032956067->8.332746850587656  	$l:64.7902326401869->25.019353930607362
	 improve value x$w(high is good):34.96777696228748  	x$d:4.8031017472920485  	 x$l(negative is good):-39.770878709579534
	 	 $w-$l: -33.110110383669394 -> 41.62854528819762  _ @double@	 lift : 74.73865567186702 : good	 :) hit 

[Prob_ROI diff: -0.03930740852785786 (up%-> -5.945684991274089) . o: 0.6611081580262925 -> a: 0.6218007494984347	 returnMoney: o:0.09056448444210284 a: 0.08517980548315059 (probReturnRate: 0.9405431500866696	 totalSpendMoney: o: 0.13698890770381486 a: 0.136988907703729 (probTotalSpendRate: 0.9999999999993733

[Time_ROI diff: 0.7473865567186702 (up%-> 111.73386008043316) . o: 0.668898896163306 -> a: 1.4162854528819762	 returnMoney: o:1.0977564E9 a: 6037200.0 (timeReturnRate: 0.005499580781309952	 totalSpendMoney: o: 1.6411395E9 a: 4262700.0 (timeTotalSpendRate: 0.0025974025974025974

[[Per_Prob_ROI diff: 0.6200835854516131 (up%-> 36110.911278359476) . o: 0.001717164046821539 -> a: 0.6218007494984347	 per returnMoney: o:2.3523242712234505E-4 a: 0.08517980548315059	 per totalSpendMoney: o: 3.558153446852334E-4 a: 0.136988907703729

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.04469208748672426
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.005384678958866407
 probRunR/probTalSR= 0.940543150087259 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Two2, 	playerStartValue=7	@@@ 

net money diff:  -0.00800900508297317 , up % -> -48.434419131879295 .  o: 0.016535771929391596 -> a: 0.008526766846418427 (anet/onet: 0.5156558086812071

[ProbMatrix: total: o: 4.5662969234576325E-4  -> a: 4.566296923454396E-4
org->adv	$w:49.316010585211195->48.87722790624818  	$d:13.438862674531759->8.469965558019442  	$l:37.24512674025704->42.65280653573238
	 improve value x$w(high is good):-0.43878267896301537  	x$d:-4.968897116512316  	 x$l(negative is good):5.407679795475339
	 	 $w-$l: 12.07088384495415 -> 6.224421370515803  _ @double@	 lift : -5.846462474438346 : bad	 :| stand

[TimeMatrix: total:  o: 26689.0 -> a: 667225.0
org->adv	$w:66.31571059237888->56.389224024879155  	$d:8.370489714863801->4.367642099741467  	$l:25.313799692757318->39.24313387537937
	 improve value x$w(high is good):-9.926486567499722  	x$d:-4.0028476151223344  	 x$l(negative is good):13.929334182622053
	 	 $w-$l: 41.00191089962157 -> 17.146090149499788  _ @double@	 lift : -23.85582075012178 : bad	 :| stand

[Prob_ROI diff: -0.058464624743858495 (up%-> -5.216754141489689) . o: 1.1207088384495616 -> a: 1.062244213705703	 returnMoney: o:0.15352467963312277 a: 0.1455156745500941 (probReturnRate: 0.947832458584719	 totalSpendMoney: o: 0.13698890770373118 a: 0.13698890770367567 (probTotalSpendRate: 0.9999999999995948

[Time_ROI diff: -0.2385582075012178 (up%-> -16.918792517006807) . o: 1.4100191089962157 -> a: 1.171460901494998	 returnMoney: o:1.12896E7 a: 2.344884E8 (timeReturnRate: 20.7703018707483	 totalSpendMoney: o: 8006700.0 a: 2.001675E8 (timeTotalSpendRate: 25.0

[[Per_Prob_ROI diff: -1.0782190699013334 (up%-> -96.20867016565958) . o: 1.1207088384495616 -> a: 0.04248976854822813	 per returnMoney: o:0.15352467963312277 a: 0.005820626982003764	 per totalSpendMoney: o: 0.13698890770373118 a: 0.005479556308147027

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.06647362982683166
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.00800900508297317
 probRunR/probTalSR= 0.9478324585851031 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Three3, 	playerStartValue=7	@@@ 

net money diff:  -0.007884787684308309 , up % -> -39.01737410890647 .  o: 0.02020840167844215 -> a: 0.012323613994133842 (anet/onet: 0.6098262589109352

[ProbMatrix: total: o: 4.566296923457612E-4  -> a: 4.5662969234564296E-4
org->adv	$w:50.84898508266378->50.39323748011879  	$d:13.053882387688171->8.209592094138264  	$l:36.09713252964805->41.39717042574294
	 improve value x$w(high is good):-0.4557476025449887  	x$d:-4.844290293549907  	 x$l(negative is good):5.300037896094892
	 	 $w-$l: 14.751852553015727 -> 8.99606705437585  _ @double@	 lift : -5.7557854986398755 : bad	 :| stand

[TimeMatrix: total:  o: 15553.0 -> a: 388825.0
org->adv	$w:66.295891467884->56.37266122291519  	$d:8.371375297370284->4.369575001607407  	$l:25.332733234745707->39.2577637754774
	 improve value x$w(high is good):-9.923230244968813  	x$d:-4.001800295762877  	 x$l(negative is good):13.925030540731694
	 	 $w-$l: 40.963158233138294 -> 17.114897447437787  _ @double@	 lift : -23.84826078570051 : bad	 :| stand

[Prob_ROI diff: -0.05755785498602872 (up%-> -5.015854097818271) . o: 1.1475185255301679 -> a: 1.0899606705441391	 returnMoney: o:0.15719730938216986 a: 0.1493125216978316 (probReturnRate: 0.9498414590216098	 totalSpendMoney: o: 0.1369889077037277 a: 0.13698890770369776 (probTotalSpendRate: 0.9999999999997814

[Time_ROI diff: -0.23848260785700504 (up%-> -16.91808064221857) . o: 1.409631582331383 -> a: 1.171148974474378	 returnMoney: o:6577200.0 a: 1.366116E8 (timeReturnRate: 20.770479839445358	 totalSpendMoney: o: 4665900.0 a: 1.166475E8 (timeTotalSpendRate: 25.0

[[Per_Prob_ROI diff: -1.1039200987084024 (up%-> -96.20063416391274) . o: 1.1475185255301679 -> a: 0.043598426821765575	 per returnMoney: o:0.15719730938216986 a: 0.005972500867913264	 per totalSpendMoney: o: 0.1369889077037277 a: 0.00547955630814791

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.06544264267033703
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.007884787684308309
 probRunR/probTalSR= 0.9498414590218174 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Four4, 	playerStartValue=7	@@@ 

net money diff:  -0.0077943193865129545 , up % -> -32.18494651277962 .  o: 0.02421728239758944 -> a: 0.016422963011076486 (anet/onet: 0.6781505348722038

[ProbMatrix: total: o: 4.56629692345755E-4  -> a: 4.566296923458144E-4
org->adv	$w:52.636064085514974->52.23429332579642  	$d:12.40615162806455->7.519948249775742  	$l:34.957784286420484->40.24575842442784
	 improve value x$w(high is good):-0.40177075971855203  	x$d:-4.8862033782888075  	 x$l(negative is good):5.287974138007357
	 	 $w-$l: 17.678279799094494 -> 11.988534901368581  _ @double@	 lift : -5.689744897725912 : bad	 :| stand

[TimeMatrix: total:  o: 9073.0 -> a: 117949.0
org->adv	$w:66.27355891105478->66.2922110403649  	$d:8.376501708365481->5.170031115142986  	$l:25.349939380579745->28.537757844492113
	 improve value x$w(high is good):0.018652129310126497  	x$d:-3.2064705932224955  	 x$l(negative is good):3.187818463912368
	 	 $w-$l: 40.92361953047503 -> 37.75445319587279  _ @double@	 lift : -3.1691663346022416 : bad	 :| stand

[Prob_ROI diff: -0.056897448977182075 (up%-> -4.835000059001483) . o: 1.176782797990957 -> a: 1.119885349013775	 returnMoney: o:0.1612061901013143 a: 0.15341187071479828 (probReturnRate: 0.951649999409964	 totalSpendMoney: o: 0.13698890770372485 a: 0.1369889077037218 (probTotalSpendRate: 0.9999999999999777

[Time_ROI diff: -0.03169166334602247 (up%-> -2.2488539147384787) . o: 1.4092361953047503 -> a: 1.3775445319587278	 returnMoney: o:3835800.0 a: 4.8744E7 (timeReturnRate: 12.707648991083998	 totalSpendMoney: o: 2721900.0 a: 3.53847E7 (timeTotalSpendRate: 13.0

[[Per_Prob_ROI diff: -1.0906377711437436 (up%-> -92.67961538915395) . o: 1.176782797990957 -> a: 0.08614502684721347	 per returnMoney: o:0.1612061901013143 a: 0.011800913131907561	 per totalSpendMoney: o: 0.13698890770372485 a: 0.010537608284901677

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.06469176836369503
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.0077943193865129545
 probRunR/probTalSR= 0.9516499994099852 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Five5, 	playerStartValue=7	@@@ 

net money diff:  -0.007117773166400221 , up % -> -25.60352775618923 .  o: 0.02779997051257757 -> a: 0.02068219734617735 (anet/onet: 0.7439647224381076

[ProbMatrix: total: o: 4.5662969234575154E-4  -> a: 4.566296923457832E-4
org->adv	$w:54.024940077968395->53.894639889446935  	$d:12.243712207542554->7.308437031064492  	$l:33.73134771448903->38.79692307948858
	 improve value x$w(high is good):-0.13030018852145986  	x$d:-4.935275176478062  	 x$l(negative is good):5.065575364999546
	 	 $w-$l: 20.293592363479362 -> 15.097716809958362  _ @double@	 lift : -5.195875553521001 : bad	 :| stand

[TimeMatrix: total:  o: 5473.0 -> a: 71149.0
org->adv	$w:66.270783847981->66.28202785703242  	$d:8.368353736524758->5.169433161393695  	$l:25.360862415494246->28.548538981573877
	 improve value x$w(high is good):0.011244009051424086  	x$d:-3.198920575131064  	 x$l(negative is good):3.187676566079631
	 	 $w-$l: 40.909921432486755 -> 37.73348887545854  _ @double@	 lift : -3.176432557028208 : bad	 :| stand

[Prob_ROI diff: -0.05195875553510132 (up%-> -4.319328612126108) . o: 1.2029359236347985 -> a: 1.1509771680996972	 returnMoney: o:0.1647888782163024 a: 0.15767110504989015 (probReturnRate: 0.9568067138786549	 totalSpendMoney: o: 0.13698890770372482 a: 0.1369889077037128 (probTotalSpendRate: 0.9999999999999123

[Time_ROI diff: -0.03176432557028197 (up%-> -2.2542291733163022) . o: 1.4090992143248675 -> a: 1.3773348887545855	 returnMoney: o:2313600.0 a: 2.93988E7 (timeReturnRate: 12.70695020746888	 totalSpendMoney: o: 1641900.0 a: 2.13447E7 (timeTotalSpendRate: 13.0

[[Per_Prob_ROI diff: -1.1143992183963602 (up%-> -92.63994835477894) . o: 1.2029359236347985 -> a: 0.08853670523843825	 per returnMoney: o:0.1647888782163024 a: 0.012128546542299242	 per totalSpendMoney: o: 0.13698890770372482 a: 0.010537608284900985

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.05907652870150154
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.007117773166400221
 probRunR/probTalSR= 0.9568067138787388 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Six6, 	playerStartValue=7	@@@ 

net money diff:  -0.012704397943175905 , up % -> -32.736836834005615 .  o: 0.03880765269898992 -> a: 0.026103254755814015 (anet/onet: 0.6726316316599439

[ProbMatrix: total: o: 4.566296923457472E-4  -> a: 4.5662969234576227E-4
org->adv	$w:58.85482152551164->56.07729035159218  	$d:10.619404424062507->6.9004327233488425  	$l:30.525774050425845->37.022276925058975
	 improve value x$w(high is good):-2.7775311739194564  	x$d:-3.7189717007136647  	 x$l(negative is good):6.49650287463313
	 	 $w-$l: 28.32904747508579 -> 19.055013426533208  _ @double@	 lift : -9.274034048552583 : bad	 :| stand

[TimeMatrix: total:  o: 3109.0 -> a: 40417.0
org->adv	$w:66.22708266323578->66.26172155281193  	$d:8.394982309424252->5.176039785238885  	$l:25.37793502733998->28.56223866194918
	 improve value x$w(high is good):0.034638889576157794  	x$d:-3.2189425241853673  	 x$l(negative is good):3.1843036346092006
	 	 $w-$l: 40.84914763589579 -> 37.699482890862754  _ @double@	 lift : -3.1496647450330317 : bad	 :| stand

[Prob_ROI diff: -0.09274034048545898 (up%-> -7.226761384904973) . o: 1.2832904747508618 -> a: 1.1905501342654028	 returnMoney: o:0.17579656040271377 a: 0.16309216245953026 (probReturnRate: 0.9277323861508988	 totalSpendMoney: o: 0.13698890770372385 a: 0.13698890770371625 (probTotalSpendRate: 0.9999999999999445

[Time_ROI diff: -0.031496647450330206 (up%-> -2.236197235055415) . o: 1.4084914763589578 -> a: 1.3769948289086276	 returnMoney: o:1313700.0 a: 1.66962E7 (timeReturnRate: 12.709294359442795	 totalSpendMoney: o: 932700.0 a: 1.21251E7 (timeTotalSpendRate: 13.0

[[Per_Prob_ROI diff: -1.1917096951919846 (up%-> -92.86359702960806) . o: 1.2832904747508618 -> a: 0.09158077955887715	 per returnMoney: o:0.17579656040271377 a: 0.012545550958425404	 per totalSpendMoney: o: 0.13698890770372385 a: 0.010537608284901249

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=true, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.10544473842863489
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.012704397943175905
 probRunR/probTalSR= 0.9277323861509503 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Seven7, 	playerStartValue=7	@@@ 

net money diff:  -0.031467661160133 , up % -> -57.396058640030034 .  o: 0.05482547391884213 -> a: 0.02335781275870913 (anet/onet: 0.4260394135996997

[ProbMatrix: total: o: 4.566296923457458E-4  -> a: 4.566296923456107E-4
org->adv	$w:63.114371112874124->52.811698729437275  	$d:13.793092270091028->11.42748144101315  	$l:23.09253661703485->35.76081982954957
	 improve value x$w(high is good):-10.30267238343685  	x$d:-2.3656108290778786  	 x$l(negative is good):12.66828321251472
	 	 $w-$l: 40.02183449583928 -> 17.050878899887707  _ @double@	 lift : -22.97095559595157 : bad	 :| stand

[TimeMatrix: total:  o: 1921.0 -> a: 739585.0
org->adv	$w:66.26756897449245->31.530520494601706  	$d:8.328995314940135->3.5738961715015853  	$l:25.40343571056741->64.89558333389671
	 improve value x$w(high is good):-34.737048479890746  	x$d:-4.7550991434385494  	 x$l(negative is good):39.4921476233293
	 	 $w-$l: 40.86413326392504 -> -33.36506283929501  _ #Surrender#	 lift : -74.22919610322005 : bad	 :| stand

[Prob_ROI diff: -0.22970955596065123 (up%-> -16.405266849112547) . o: 1.400218344958391 -> a: 1.1705087889977397	 returnMoney: o:0.191814381622566 a: 0.16034672046257403 (probReturnRate: 0.8359473315097351	 totalSpendMoney: o: 0.13698890770372388 a: 0.1369889077038649 (probTotalSpendRate: 1.0000000000010294

[Time_ROI diff: -0.7422919610322005 (up%-> -52.69559708584099) . o: 1.4086413326392504 -> a: 0.6663493716070499	 returnMoney: o:811800.0 a: 1.478466E8 (timeReturnRate: 182.1219512195122	 totalSpendMoney: o: 576300.0 a: 2.218755E8 (timeTotalSpendRate: 385.0

[[Per_Prob_ROI diff: -1.3971780623895655 (up%-> -99.78287082298469) . o: 1.400218344958391 -> a: 0.0030402825688252977	 per returnMoney: o:0.191814381622566 a: 4.1648498821447803E-4	 per totalSpendMoney: o: 0.13698890770372388 a: 3.5581534468536336E-4

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.26117721712078423
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.031467661160133
 probRunR/probTalSR= 0.8359473315088746 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Eight8, 	playerStartValue=7	@@@ 

net money diff:  -0.009192054802727195 , up % -> -63.7714130230815 .  o: 0.014414067945146852 -> a: 0.005222013142419657 (anet/onet: 0.36228586976918503

[ProbMatrix: total: o: 4.566296923457454E-4  -> a: 4.566296923457241E-4
org->adv	$w:37.263289009055406->43.518828704894005  	$d:35.995491386458006->16.774339656271657  	$l:26.741219604486588->39.706831638834345
	 improve value x$w(high is good):6.2555396958386  	x$d:-19.22115173018635  	 x$l(negative is good):12.965612034347757
	 	 $w-$l: 10.522069404568818 -> 3.8119970660596634  _ #Surrender#	 lift : -6.710072338509154 : bad	 :| stand

[TimeMatrix: total:  o: 1153.0 -> a: 443905.0
org->adv	$w:66.08846487424111->31.519807165947668  	$d:8.586296617519515->3.5775672722767258  	$l:25.32523850823938->64.90262556177561
	 improve value x$w(high is good):-34.56865770829344  	x$d:-5.00872934524279  	 x$l(negative is good):39.57738705353623
	 	 $w-$l: 40.76322636600174 -> -33.38281839582794  _ #Surrender#	 lift : -74.14604476182967 : bad	 :| stand

[Prob_ROI diff: -0.06710072338565887 (up%-> -6.071251085612126) . o: 1.1052206940456908 -> a: 1.038119970660032	 returnMoney: o:0.15140297564887026 a: 0.1422109208462457 (probReturnRate: 0.9392874891445825	 totalSpendMoney: o: 0.1369889077037234 a: 0.13698890770382605 (probTotalSpendRate: 1.0000000000007492

[Time_ROI diff: -0.7414604476182968 (up%-> -52.67430043770155) . o: 1.4076322636600174 -> a: 0.6661718160417206	 returnMoney: o:486900.0 a: 8.87151E7 (timeReturnRate: 182.20394331484906	 totalSpendMoney: o: 345900.0 a: 1.331715E8 (timeTotalSpendRate: 385.0

[[Per_Prob_ROI diff: -1.102524278537483 (up%-> -99.75602922359899) . o: 1.1052206940456908 -> a: 0.0026964155082078744	 per returnMoney: o:0.15140297564887026 a: 3.6937901518505376E-4	 per totalSpendMoney: o: 0.1369889077037234 a: 3.558153446852625E-4

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.07629277818838606
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.009192054802727195
 probRunR/probTalSR= 0.9392874891438788 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Nine9, 	playerStartValue=7	@@@ 

net money diff:  -0.011205543896956521 , up % -> -80.3927537546814 .  o: -0.01393849989409525 -> a: -0.02514404379105177 (anet/onet: 1.803927537546814

[ProbMatrix: total: o: 4.566296923457661E-4  -> a: 4.5662969234574514E-4
org->adv	$w:39.29852752596944->34.955174809922354  	$d:11.228033615659363->11.734847635517617  	$l:49.473438858371196->53.30997755456003
	 improve value x$w(high is good):-4.343352716047086  	x$d:0.506814019858254  	 x$l(negative is good):3.836538696188832
	 	 $w-$l: -10.174911332401754 -> -18.35480274463767  _ #Surrender#	 lift : -8.179891412235918 : bad	 :| stand

[TimeMatrix: total:  o: 296065.0 -> a: 769.0
org->adv	$w:31.491733234255992->66.05981794538361  	$d:3.577592758346985->8.322496749024708  	$l:64.93067400739703->25.617685305591674
	 improve value x$w(high is good):34.568084711127625  	x$d:4.744903990677724  	 x$l(negative is good):-39.31298870180535
	 	 $w-$l: -33.438940773141034 -> 40.442132639791936  _ @double@	 lift : 73.88107341293298 : good	 :) hit 

[Prob_ROI diff: -0.08179891412227491 (up%-> -9.10646628192963) . o: 0.8982508866759016 -> a: 0.8164519725536267	 returnMoney: o:0.12305040780967373 a: 0.11184486391267186 (probReturnRate: 0.9089353371804028	 totalSpendMoney: o: 0.13698890770376898 a: 0.13698890770372363 (probTotalSpendRate: 0.9999999999996689

[Time_ROI diff: 0.7388107341293296 (up%-> 110.99744245524296) . o: 0.6656105922685897 -> a: 1.4044213263979193	 returnMoney: o:5.91192E7 a: 324000.0 (timeReturnRate: 0.005480453050785532	 totalSpendMoney: o: 8.88195E7 a: 230700.0 (timeTotalSpendRate: 0.0025974025974025974

[[Per_Prob_ROI diff: 0.8141188533674555 (up%-> 34894.01048145708) . o: 0.0023331191861711733 -> a: 0.8164519725536267	 per returnMoney: o:3.196114488562954E-4 a: 0.11184486391267186	 per totalSpendMoney: o: 3.558153446851142E-4 a: 0.13698890770372363

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.09300445801923143
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.011205543896956521
 probRunR/probTalSR= 0.9089353371807036 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Ten, 	playerStartValue=7	@@@ 

net money diff:  -0.005406111786402573 , up % -> -19.72231895278629 .  o: -0.027411136587661866 -> a: -0.03281724837406444 (anet/onet: 1.1972231895278629

[ProbMatrix: total: o: 4.566296923457398E-4  -> a: 4.566296923457448E-4
org->adv	$w:34.317539895689336->32.438494438672834  	$d:11.35517120985165->11.166875604703382  	$l:54.327288894459016->56.394629956623774
	 improve value x$w(high is good):-1.8790454570165025  	x$d:-0.1882956051482676  	 x$l(negative is good):2.0673410621647577
	 	 $w-$l: -20.009748998769677 -> -23.956135517950944  _ #Surrender#	 lift : -3.9463865191812664 : bad	 :| stand

[TimeMatrix: total:  o: 148225.0 -> a: 385.0
org->adv	$w:31.450834879406308->65.97402597402598  	$d:3.5837409343902853->8.311688311688311  	$l:64.9654241862034->25.71428571428571
	 improve value x$w(high is good):34.52319109461967  	x$d:4.727947377298026  	 x$l(negative is good):-39.2511384719177
	 	 $w-$l: -33.51458930679709 -> 40.25974025974026  _ @double@	 lift : 73.77432956653736 : good	 :) hit 

[Prob_ROI diff: -0.03946386519189293 (up%-> -4.9335843678352616) . o: 0.7999025100123854 -> a: 0.7604386448204925	 returnMoney: o:0.10957777111607062 a: 0.10417165932965894 (probReturnRate: 0.9506641563215843	 totalSpendMoney: o: 0.13698890770373248 a: 0.13698890770372338 (probTotalSpendRate: 0.9999999999999335

[Time_ROI diff: 0.7377432956653736 (up%-> 110.96318545277428) . o: 0.6648541069320291 -> a: 1.4025974025974026	 returnMoney: o:2.95644E7 a: 162000.0 (timeReturnRate: 0.005479563258513617	 totalSpendMoney: o: 4.44675E7 a: 115500.0 (timeTotalSpendRate: 0.0025974025974025974

[[Per_Prob_ROI diff: 0.7583609759633175 (up%-> 36500.570018383434) . o: 0.0020776688571750267 -> a: 0.7604386448204925	 per returnMoney: o:2.846175873144691E-4 a: 0.10417165932965894	 per totalSpendMoney: o: 3.5581534468501945E-4 a: 0.13698890770372338

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.044869976978295506
 按net净收益值(代表少输多赢) :  !Not Change!  Value: -0.005406111786402573
 probRunR/probTalSR= 0.9506641563216475 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

		 */
	}
	
	public static void test22vsAll() {
		StrategyMatrix8012 o = new BestInMyth2019();
		StrategyMatrix8012 t = new MirBestInMyth2019();
		
		System.out.println(t.diffWith(o));
		
		for(Card playerCard : Card.values()) {
			if(playerCard.getValue() == 2) {
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
MatrixKey [startValue=Two, dealerCard=One1, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Two, dealerCard=One1, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Two, dealerCard=Two2, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Two, dealerCard=Two2, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Two, dealerCard=Three3, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Two, dealerCard=Three3, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Two, dealerCard=Four4, situation=Splited_Pair_And_Can_Split] : Hit -> Split
MatrixKey [startValue=Two, dealerCard=Four4, situation=Start_With_Pair] : Hit -> Split
MatrixKey [startValue=Two, dealerCard=Five5, situation=Splited_Pair_And_Can_Split] : Hit -> Split
MatrixKey [startValue=Two, dealerCard=Five5, situation=Start_With_Pair] : Hit -> Split
MatrixKey [startValue=Two, dealerCard=Six6, situation=Splited_Pair_And_Can_Split] : Hit -> Split
MatrixKey [startValue=Two, dealerCard=Six6, situation=Start_With_Pair] : Hit -> Split
MatrixKey [startValue=Two, dealerCard=Seven7, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Two, dealerCard=Seven7, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Two, dealerCard=Eight8, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Two, dealerCard=Eight8, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Two, dealerCard=Nine9, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Two, dealerCard=Nine9, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Two, dealerCard=Ten, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Two, dealerCard=Ten, situation=Start_With_Pair] : Split -> Hit


		 @@@   dealerCard=One1, 	playerStartValue=2	@@@ 

net money diff:  3.9655199185732277 , up % -> 98.52939696358942 .  o: -4.024707387622241 -> a: -0.05918746904901369 (anet/onet: 0.014706030364105819

[ProbMatrix: total: o: 0.03240646915678342  -> a: 4.3760345515222814E-4
org->adv	$w:23.698845428525082->22.210525501245552  	$d:11.20412030240084->10.494395570261513  	$l:65.09703426907407->67.29507892849294
	 improve value x$w(high is good):-1.4883199272795302  	x$d:-0.7097247321393265  	 x$l(negative is good):2.198044659418869
	 	 $w-$l: -41.39818884054899 -> -45.084553427247386  _ #Surrender#	 lift : -3.6863645866983985 : bad	 :| stand

[TimeMatrix: total:  o: 2.017507492E9 -> a: 1.28918257E8
org->adv	$w:31.54476394876258->31.583756209176794  	$d:3.5044237644892973->3.5082913043107613  	$l:64.95081228674813->64.90795248651244
	 improve value x$w(high is good):0.038992260414214996  	x$d:0.003867539821464039  	 x$l(negative is good):-0.04285980023568925
	 	 $w-$l: -33.40604833798555 -> -33.32419627733565  _ #Surrender#	 lift : 0.0818520606499007 : good	 :| stand

[Prob_ROI diff: -0.03686364589686819 (up%-> -6.29053013240467) . o: 0.5860181116845933 -> a: 0.5491544657877251	 returnMoney: o:5.697233357176419 a: 0.07209356748698541 (probReturnRate: 0.012654136309191903	 totalSpendMoney: o: 9.72194074479866 a: 0.1312810365359991 (probTotalSpendRate: 0.013503583284668323

[Time_ROI diff: 8.185206064990069E-4 (up%-> 0.12291215434297399) . o: 0.6659395166201445 -> a: 0.6667580372266435	 returnMoney: o:4.030613892E11 a: 2.57871852E10 (timeReturnRate: 0.06397830675665224	 totalSpendMoney: o: 6.052522476E11 a: 3.86754771E10 (timeTotalSpendRate: 0.06389976617742345

[[Per_Prob_ROI diff: 4.729932097221694E-5 (up%-> 357.5992574103177) . o: 1.3226906933406913E-5 -> a: 6.052622790562385E-5	 per returnMoney: o:1.2859120544354857E-4 a: 7.945945937064412E-6	 per totalSpendMoney: o: 2.1943213508178897E-4 a: 1.4469418773944571E-5

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 3.9286562726763594
 按net净收益值(代表少输多赢) :  $Change$  Value: 3.9655199185732277
 probRunR/probTalSR= 0.9370946986759534 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Two2, 	playerStartValue=2	@@@ 

net money diff:  0.6738024045756826 , up % -> 97.37752791781237 .  o: -0.6919485624490065 -> a: -0.018146157873323854 (anet/onet: 0.026224720821876327

[ProbMatrix: total: o: 0.03240646916490661  -> a: 4.376034551643172E-4
org->adv	$w:42.02860847895912->41.20997730666696  	$d:5.475731456337717->3.757669853924292  	$l:52.495660064703166->55.03235283940876
	 improve value x$w(high is good):-0.8186311722921644  	x$d:-1.7180616024134245  	 x$l(negative is good):2.5366927747055925
	 	 $w-$l: -10.467051585744041 -> -13.822375532741804  _ #Surrender#	 lift : -3.3553239469977623 : bad	 :| stand

[TimeMatrix: total:  o: 1.86502732E8 -> a: 1.3477945E7
org->adv	$w:56.9896488165117->57.10990065622021  	$d:4.134120673363649->4.131431015633318  	$l:38.87623051012464->38.75866832814647
	 improve value x$w(high is good):0.12025183970850861  	x$d:-0.002689657730330808  	 x$l(negative is good):-0.11756218197817248
	 	 $w-$l: 18.113418306387064 -> 18.351232328073745  _ @double@	 lift : 0.23781402168668309 : good	 :) hit 

[Prob_ROI diff: -0.07681581537806026 (up%-> -8.18415354726581) . o: 0.938592060063721 -> a: 0.8617762446856607	 returnMoney: o:10.576114869853381 a: 0.11313487867540153 (probReturnRate: 0.010697205927470222	 totalSpendMoney: o: 11.268063432302387 a: 0.1312810365487254 (probTotalSpendRate: 0.011650718629465588

[Time_ROI diff: -0.004045434722914187 (up%-> -0.3406516184707327) . o: 1.1875577580036518 -> a: 1.1835123232807376	 returnMoney: o:6.79281432E10 a: 4.7853942E9 (timeReturnRate: 0.07044788764371819	 totalSpendMoney: o: 5.71998648E10 a: 4.0433835E9 (timeTotalSpendRate: 0.07068868980963046

[[Per_Prob_ROI diff: 0.001272155331858219 (up%-> 292.89909739476946) . o: 4.343322813807131E-4 -> a: 0.001706487613238932	 per returnMoney: o:0.004894083697294485 a: 2.240294627235674E-4	 per totalSpendMoney: o: 0.0052142820140223915 a: 2.599624486113374E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.5969865891976224
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.6738024045756826
 probRunR/probTalSR= 0.918158464527342 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Three3, 	playerStartValue=2	@@@ 

net money diff:  0.3495268541753379 , up % -> 96.22553616243813 .  o: -0.36323710744027693 -> a: -0.013710253264939049 (anet/onet: 0.03774463837561881

[ProbMatrix: total: o: 0.03240646916543177  -> a: 4.3760345516449025E-4
org->adv	$w:43.3941410457297->42.960231507069835  	$d:5.22542734509634->3.63609928428861  	$l:51.38043160917395->53.40366920864156
	 improve value x$w(high is good):-0.4339095386598615  	x$d:-1.5893280608077296  	 x$l(negative is good):2.0232375994676133
	 	 $w-$l: -7.986290563444253 -> -10.443437701571723  _ #Surrender#	 lift : -2.457147138127469 : bad	 :| stand

[TimeMatrix: total:  o: 1.05324916E8 -> a: 7854265.0
org->adv	$w:57.041678533121264->57.09385919624561  	$d:4.1340379516656816->4.133805009125615  	$l:38.82428351521306->38.77233579462877
	 improve value x$w(high is good):0.05218066312434644  	x$d:-2.3294254006689386E-4  	 x$l(negative is good):-0.05194772058428754
	 	 $w-$l: 18.217395017908206 -> 18.321523401616837  _ @double@	 lift : 0.10412838370862931 : good	 :) hit 

[Prob_ROI diff: -0.07426800017254997 (up%-> -7.657808349661934) . o: 0.9698336231648922 -> a: 0.8955656229923422	 returnMoney: o:11.677887666203034 a: 0.11757078328429729 (probReturnRate: 0.010067812488431346	 totalSpendMoney: o: 12.041124773643311 a: 0.13128103654923634 (probTotalSpendRate: 0.010902722047743911

[Time_ROI diff: -0.007440444662057288 (up%-> -0.6249031349111019) . o: 1.1906556786782256 -> a: 1.1832152340161683	 returnMoney: o:3.89216952E10 a: 2.7879858E9 (timeReturnRate: 0.0716306364785468	 totalSpendMoney: o: 3.26892954E10 a: 2.3562795E9 (timeTotalSpendRate: 0.07208107336568656

[[Per_Prob_ROI diff: 0.0013091399141497732 (up%-> 281.98581852981437) . o: 4.642573591023897E-4 -> a: 0.001773397273252163	 per returnMoney: o:0.005590180788034004 a: 2.3281343224613326E-4	 per totalSpendMoney: o: 0.005764061643677985 a: 2.599624486123492E-4

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.27525885400278793
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.3495268541753379
 probRunR/probTalSR= 0.9234219165033808 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Four4, 	playerStartValue=2	@@@ 

net money diff:  0.004074579889025737 , up % -> 45.48946320256725 .  o: -0.008957194924199025 -> a: -0.004882615035173288 (anet/onet: 0.5451053679743275

[ProbMatrix: total: o: 4.37603455164407E-4  -> a: 0.03240646916583721
org->adv	$w:45.105345123119434->45.82935970538983  	$d:2.966393695202135->3.377985211916067  	$l:51.92826118167844->50.7926550826941
	 improve value x$w(high is good):0.7240145822703923  	x$d:0.4115915167139321  	 x$l(negative is good):-1.13560609898434
	 	 $w-$l: -6.822916058559003 -> -4.9632953773042665  _ #Surrender#	 lift : 1.8596206812547367 : good	 :) hit 

[TimeMatrix: total:  o: 2295469.0 -> a: 3.0739324E7
org->adv	$w:68.51902595940089->68.44654098444065  	$d:4.762338328245774->4.764515966584041  	$l:26.718635712353333->26.788943048975312
	 improve value x$w(high is good):-0.07248497496024697  	x$d:0.002177638338266341  	 x$l(negative is good):0.07030733662197974
	 	 $w-$l: 41.80039024704756 -> 41.65759793546534  _ @double@	 lift : -0.14279231158221828 : bad	 :| stand

[Prob_ROI diff: 0.06782366565374842 (up%-> 7.279007110392795) . o: 0.9317708394172521 -> a: 0.9995945050710006	 returnMoney: o:0.12232384162520724 a: 12.036242158635757 (probReturnRate: 98.39653495770732	 totalSpendMoney: o: 0.13128103654940626 a: 12.04112477367093 (probTotalSpendRate: 91.72021405497797

[Time_ROI diff: -1.854992774774633E-4 (up%-> -0.013081718403897383) . o: 1.4180039024704756 -> a: 1.4178184031929981	 returnMoney: o:9.764952E8 a: 1.39778772E10 (timeReturnRate: 14.31433272790281	 totalSpendMoney: o: 6.886407E8 a: 9.8587218E9 (timeTotalSpendRate: 14.316205533596838

[[Per_Prob_ROI diff: -0.0027263389277306406 (up%-> -74.0271877522207) . o: 0.003682888693348823 -> a: 9.565497656181824E-4	 per returnMoney: o:4.8349344515892186E-4 a: 0.011517935080034217	 per totalSpendMoney: o: 5.188973776656374E-4 a: 0.01152260743891955

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.07189824554277416
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.004074579889025737
 probRunR/probTalSR= 1.072790071103928 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Five5, 	playerStartValue=2	@@@ 

net money diff:  0.44164610908757373 , up % -> 11681.149837743109 .  o: -0.0037808444821122444 -> a: 0.4378652646054615 (anet/onet: -115.81149837743109

[ProbMatrix: total: o: 4.376034551646907E-4  -> a: 0.032406469165924504
org->adv	$w:47.133428058588464->47.82670181654309  	$d:2.853181489435314->3.249054582978149  	$l:50.01339045197623->48.924243600478775
	 improve value x$w(high is good):0.6932737579546284  	x$d:0.3958730935428352  	 x$l(negative is good):-1.0891468514974534
	 	 $w-$l: -2.879962393387764 -> -1.0975417839356794  _ #Surrender#	 lift : 1.7824206094520845 : good	 :) hit 

[TimeMatrix: total:  o: 1384669.0 -> a: 1.8542524E7
org->adv	$w:68.50741946270192->68.43491209718806  	$d:4.764171076264436->4.766362982730938  	$l:26.728409461033646->26.798724920080996
	 improve value x$w(high is good):-0.07250736551385728  	x$d:0.00219190646650258  	 x$l(negative is good):0.07031545904735026
	 	 $w-$l: 41.77901000166827 -> 41.63618717710706  _ @double@	 lift : -0.14282282456120066 : bad	 :| stand

[Prob_ROI diff: 0.06516377369732695 (up%-> 6.709611662342314) . o: 0.9712003760673444 -> a: 1.0363641497646714	 returnMoney: o:0.1275001920672986 a: 12.478990038292796 (probReturnRate: 97.87428423406605	 totalSpendMoney: o: 0.13128103654941084 a: 12.041124773687335 (probTotalSpendRate: 91.72021405509973

[Time_ROI diff: -1.8550063956879193E-4 (up%-> -0.013083787195763972) . o: 1.4177901000166826 -> a: 1.4176045993771138	 returnMoney: o:5.88951E8 a: 8.4304404E9 (timeReturnRate: 14.314332431730314	 totalSpendMoney: o: 4.154007E8 a: 5.9469618E9 (timeTotalSpendRate: 14.316205533596838

[[Per_Prob_ROI diff: -0.002847000635814865 (up%-> -74.16504138701185) . o: 0.003838736664297804 -> a: 9.91736028482939E-4	 per returnMoney: o:5.039533283292435E-4 a: 0.011941617261524207	 per totalSpendMoney: o: 5.188973776656555E-4 a: 0.011522607438935248

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.5068098827849007
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.44164610908757373
 probRunR/probTalSR= 1.0670961166234234 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Six6, 	playerStartValue=2	@@@ 

net money diff:  0.6981392530453552 , up % -> 51515.805188520564 .  o: -0.001355194295208112 -> a: 0.696784058750147 (anet/onet: -514.1580518852056

[ProbMatrix: total: o: 4.3760345516469695E-4  -> a: 0.03240646916601712
org->adv	$w:48.044061082459265->48.80396073693846  	$d:2.8795929515254723->3.2807536784115907  	$l:49.07634596601526->47.91528558464995
	 improve value x$w(high is good):0.7598996544791916  	x$d:0.40116072688611837  	 x$l(negative is good):-1.16106038136531
	 	 $w-$l: -1.032284883555995 -> 0.8886751522885095  _ #Surrender#	 lift : 1.9209600358445045 : good	 :) hit 

[TimeMatrix: total:  o: 786577.0 -> a: 1.0533292E7
org->adv	$w:68.49348506249228->68.42096468986144  	$d:4.76583983513375->4.767930102004198  	$l:26.740675102373956->26.81110520813436
	 improve value x$w(high is good):-0.07252037263084787  	x$d:0.0020902668704474436  	 x$l(negative is good):0.07043010576040487
	 	 $w-$l: 41.752809960118334 -> 41.60985948172708  _ @double@	 lift : -0.14295047839125163 : bad	 :| stand

[Prob_ROI diff: 0.06818987304131074 (up%-> 6.890112898033867) . o: 0.9896771511649557 -> a: 1.0578670242062664	 returnMoney: o:0.12992584225426304 a: 12.737908832446271 (probReturnRate: 98.03984035384094	 totalSpendMoney: o: 0.13128103654947115 a: 12.041124773696124 (probTotalSpendRate: 91.72021405512456

[Time_ROI diff: -1.8716159661225085E-4 (up%-> -0.013203378237433748) . o: 1.4175280996011834 -> a: 1.4173409380045712	 returnMoney: o:3.344985E8 a: 4.788117E9 (timeReturnRate: 14.31431531083099	 totalSpendMoney: o: 2.359731E8 a: 3.3782394E9 (timeTotalSpendRate: 14.316205533596838

[[Per_Prob_ROI diff: -0.002899454454084737 (up%-> -74.12134108784443) . o: 0.003911767395908915 -> a: 0.0010123129418241781	 per returnMoney: o:5.13540878475348E-4 a: 0.012189386442532316	 per totalSpendMoney: o: 5.188973776658939E-4 a: 0.01152260743894366

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=true, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.7663291260866659
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.6981392530453552
 probRunR/probTalSR= 1.0689011289803385 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Seven7, 	playerStartValue=2	@@@ 

net money diff:  0.004999618737683717 , up % -> 29.908521598261068 .  o: -0.016716368681942484 -> a: -0.011716749944258767 (anet/onet: 0.7009147840173893

[ProbMatrix: total: o: 0.03240646916469638  -> a: 4.3760345516300397E-4
org->adv	$w:43.434341605301675->40.93110124992979  	$d:9.48445447624941->9.212860393026254  	$l:47.08120391844891->49.85603835704396
	 improve value x$w(high is good):-2.5032403553718865  	x$d:-0.2715940832231549  	 x$l(negative is good):2.7748344385950503
	 	 $w-$l: -3.6468623131472313 -> -8.924937107114172  _ #Surrender#	 lift : -5.278074793966941 : bad	 :| stand

[TimeMatrix: total:  o: 2.64183604E8 -> a: 1.7429233E7
org->adv	$w:31.43171140931214->31.435577228211937  	$d:3.55030208460628->3.553214303807861  	$l:65.01798650608158->65.01120846798021
	 improve value x$w(high is good):0.003865818899797091  	x$d:0.0029122192015811343  	 x$l(negative is good):-0.00677803810137334
	 	 $w-$l: -33.58627509676944 -> -33.57563123976827  _ #Surrender#	 lift : 0.0106438570011691 : good	 :| stand

[Prob_ROI diff: -0.08776585361593714 (up%-> -8.78962492351015) . o: 0.9985164825541578 -> a: 0.9107506289382207	 returnMoney: o:11.251347063125122 a: 0.11956428660386793 (probReturnRate: 0.010626664161460709	 totalSpendMoney: o: 11.268063431807064 a: 0.1312810365481267 (probTotalSpendRate: 0.011650718629924601

[Time_ROI diff: -8.103604267301057E-4 (up%-> -0.12184880749642647) . o: 0.6650540480290474 -> a: 0.6642436876023173	 returnMoney: o:5.27687028E10 a: 3.4731774E9 (timeReturnRate: 0.06581888914654162	 totalSpendMoney: o: 7.9344984E10 a: 5.2287699E9 (timeTotalSpendRate: 0.06589918651946543

[[Per_Prob_ROI diff: 7.705975689158654E-5 (up%-> 330.43697009258966) . o: 2.3320561518886375E-5 -> a: 1.0038031841047291E-4	 per returnMoney: o:2.6277756646017055E-4 a: 1.317803224995789E-5	 per totalSpendMoney: o: 2.631679807508014E-4 a: 1.446941877528124E-5

 按prb差值百分比 (不太重要) : !Not Change!  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): !Not Change!  Value: -0.08276623487825342
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.004999618737683717
 probRunR/probTalSR= 0.9121037507648986 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Eight8, 	playerStartValue=2	@@@ 

net money diff:  0.834658684136047 , up % -> 97.51164740928755 .  o: -0.8559579356020084 -> a: -0.021299251465961386 (anet/onet: 0.024883525907124508

[ProbMatrix: total: o: 0.03240646916540962  -> a: 4.3760345516371385E-4
org->adv	$w:39.50622616244205->37.219735332759335  	$d:9.588104491587245->9.336364727999026  	$l:50.90566934597071->53.44389993924163
	 improve value x$w(high is good):-2.2864908296827124  	x$d:-0.25173976358821903  	 x$l(negative is good):2.5382305932709244
	 	 $w-$l: -11.399443183528657 -> -16.2241646064823  _ #Surrender#	 lift : -4.824721422953643 : bad	 :| stand

[TimeMatrix: total:  o: 1.58565172E8 -> a: 1.0461169E7
org->adv	$w:31.422368084714087->31.42623926637644  	$d:3.551972938925075->3.5548990748548275  	$l:65.02565897636083->65.01886165876873
	 improve value x$w(high is good):0.0038711816623546724  	x$d:0.002926135929752327  	 x$l(negative is good):-0.006797317592102559
	 	 $w-$l: -33.60329089164675 -> -33.59262239239228  _ #Surrender#	 lift : 0.010668499254468111 : good	 :| stand

[Prob_ROI diff: -0.0862784656278035 (up%-> -9.337124214166316) . o: 0.9240368195691508 -> a: 0.8377583539413473	 returnMoney: o:10.41210549653937 a: 0.1099817850828259 (probReturnRate: 0.010562876559345284	 totalSpendMoney: o: 11.268063432141378 a: 0.13128103654878728 (probTotalSpendRate: 0.011650718629637558

[Time_ROI diff: -8.100149387475497E-4 (up%-> -0.1218280472007309) . o: 0.6648837910148248 -> a: 0.6640737760760772	 returnMoney: o:3.16641012E10 a: 2.0840964E9 (timeReturnRate: 0.06581890282740759	 totalSpendMoney: o: 4.7623512E10 a: 3.1383507E9 (timeTotalSpendRate: 0.06589918651946543

[[Per_Prob_ROI diff: 7.07542461176283E-5 (up%-> 327.85322963981497) . o: 2.158107339536051E-5 -> a: 9.233531951298881E-5	 per returnMoney: o:2.4317690395262093E-4 a: 1.2121876455728634E-5	 per totalSpendMoney: o: 2.631679807586094E-4 a: 1.4469418775354048E-5

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 0.7483802185082435
 按net净收益值(代表少输多赢) :  $Change$  Value: 0.834658684136047
 probRunR/probTalSR= 0.9066287578583369 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Nine9, 	playerStartValue=2	@@@ 

net money diff:  1.7562605609944326 , up % -> 98.20961565594446 .  o: -1.7882776032309309 -> a: -0.03201704223649826 (anet/onet: 0.017903843440555414

[ProbMatrix: total: o: 0.03240646916566996  -> a: 4.376034551638452E-4
org->adv	$w:35.19673111079843->33.103216287322915  	$d:9.647829220350257->9.405397527687901  	$l:55.15543966885132->57.49138618498918
	 improve value x$w(high is good):-2.093514823475516  	x$d:-0.24243169266235576  	 x$l(negative is good):2.3359465161378594
	 	 $w-$l: -19.95870855805289 -> -24.388169897666263  _ #Surrender#	 lift : -4.429461339613372 : bad	 :| stand

[TimeMatrix: total:  o: 1.05755956E8 -> a: 6977137.0
org->adv	$w:31.394199679874298->31.398064850955343  	$d:3.5541525434274357->3.5570750581506423  	$l:65.05164777669827->65.04486009089402
	 improve value x$w(high is good):0.0038651710810455597  	x$d:0.002922514723206593  	 x$l(negative is good):-0.006787685804255261
	 	 $w-$l: -33.65744809682398 -> -33.646795239938676  _ #Surrender#	 lift : 0.010652856885301487 : good	 :| stand

[Prob_ROI diff: -0.08517850973435415 (up%-> -10.124668089168063) . o: 0.8412968107614598 -> a: 0.7561183010271056	 returnMoney: o:9.479785828960372 a: 0.09926399431252428 (probReturnRate: 0.010471122038356255	 totalSpendMoney: o: 11.268063432191303 a: 0.13128103654902254 (probTotalSpendRate: 0.011650718629606817

[Time_ROI diff: -8.099104196807039E-4 (up%-> -0.12191167664529225) . o: 0.6643419580202939 -> a: 0.6635320476006132	 returnMoney: o:2.11013448E10 a: 1.3888662E9 (timeReturnRate: 0.06581884771628393	 totalSpendMoney: o: 3.1762776E10 a: 2.0931411E9 (timeTotalSpendRate: 0.06589918651946543

[[Per_Prob_ROI diff: 6.368852420650549E-5 (up%-> 324.1366787640352) . o: 1.9648663165599172E-5 -> a: 8.333718737210467E-5	 per returnMoney: o:2.2140238290773226E-4 a: 1.0940592341290011E-5	 per totalSpendMoney: o: 2.631679807597754E-4 a: 1.4469418775379977E-5

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 1.6710820512600786
 按net净收益值(代表少输多赢) :  $Change$  Value: 1.7562605609944326
 probRunR/probTalSR= 0.8987533191083192 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)

--------------------------------


		 @@@   dealerCard=Ten, 	playerStartValue=2	@@@ 

net money diff:  2.7877581984045516 , up % -> 98.44052585109321 .  o: -2.831921278662687 -> a: -0.044163080258135354 (anet/onet: 0.015594741489067946

[ProbMatrix: total: o: 0.032406469165942975  -> a: 4.376034551641211E-4
org->adv	$w:30.36541427439755->28.461717408386626  	$d:9.867878313267996->9.43645887451807  	$l:59.766707412334455->62.10182371709531
	 improve value x$w(high is good):-1.9036968660109252  	x$d:-0.4314194387499253  	 x$l(negative is good):2.3351163047608523
	 	 $w-$l: -29.4012931379369 -> -33.64010630870868  _ #Surrender#	 lift : -4.238813170771777 : bad	 :| stand

[TimeMatrix: total:  o: 5.380606E7 -> a: 3493105.0
org->adv	$w:31.3359164376652->31.357545793785185  	$d:3.559959603063298->3.5634199372764344  	$l:65.1041239592715->65.07903426893839
	 improve value x$w(high is good):0.021629356119984067  	x$d:0.0034603342131362957  	 x$l(negative is good):-0.025089690333118142
	 	 $w-$l: -33.7682075216063 -> -33.7214884751532  _ #Surrender#	 lift : 0.046719046453097546 : good	 :| stand

[Prob_ROI diff: -0.06656583541316763 (up%-> -9.116549844080518) . o: 0.7301647723276542 -> a: 0.6635989369144866	 returnMoney: o:7.66308081239645 a: 0.0871179562911132 (probReturnRate: 0.011368528979908943	 totalSpendMoney: o: 10.495002091059137 a: 0.13128103654924855 (probTotalSpendRate: 0.012508909994509577

[Time_ROI diff: 4.887338157288923E-6 (up%-> 7.373995106489947E-4) . o: 0.6627802279103108 -> a: 0.6627851152484681	 returnMoney: o:1.07044488E10 a: 6.945534E8 (timeReturnRate: 0.06488455528882534	 totalSpendMoney: o: 1.6150827E10 a: 1.0479315E9 (timeTotalSpendRate: 0.06488407683396026

[[Per_Prob_ROI diff: 5.6378076915845635E-5 (up%-> 336.3467400244691) . o: 1.676189188328216E-5 -> a: 7.31399687991278E-5	 per returnMoney: o:1.7591609036515346E-4 a: 9.601890917129196E-6	 per totalSpendMoney: o: 2.4092656484146684E-4 a: 1.4469418775404888E-5

 按prb差值百分比 (不太重要) : $Change$  [isDouble()=false, isHit()=false, isSurrender()=false]	deckStatus=0	 ! DeckSet.resetValue= 0
 按prb+net净差值 (两维度综合): $Change$  Value: 2.721192362991384
 按net净收益值(代表少输多赢) :  $Change$  Value: 2.7877581984045516
 probRunR/probTalSR= 0.9088345015591949 ( > 1 代表Change后,花费单位$增长的收益率大于原本的方案; < 1  则说明原方案收益比更好.)


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
		testA6vsAll();
//		testA7vsAll();

//		test22vsAll();
//		test33vsAll();
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
