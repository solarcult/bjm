package org.shil.bjm.strategy8102;

import java.util.Collection;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerCardsPathValue;
import org.shil.bjm.meta.ProfitUtil;
import org.shil.bjm.meta.WinRateUtil;

public class TestAnything {

	public static void main(String[] args) {
		testTTvsX();
	}
	
	public static void testTTvsX() {
		for(Card dealercard : Card.values()) {
			System.out.println(dealercard);
			PlayerCardsPathValue eight2 = new PlayerCardsPathValue(Card.Ten,Card.Ten);
			Collection<PlayerCardsPathValue> eight2r = Strategy8012.generatePlayerCardsPaths(new Finally2047(), eight2, dealercard); 
			System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight2r, dealercard));
			HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight2r, dealercard));
			
			PlayerCardsPathValue eight22 = new PlayerCardsPathValue(Card.Ten,Card.Ten);
			Collection<PlayerCardsPathValue> eight22r = Strategy8012.generatePlayerCardsPaths(new TestAnything2048(), eight22, dealercard); 
			System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight22r, dealercard));
			HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight22r, dealercard));
			System.out.println(new Finally2047().diffWith(new TestAnything2048()));
			/*
One1
0.006332992653769586
w:50.69051023665474 $d:13.090969130580746 $l:36.2185206327645
-0.7410681108759323
w:32.11685480512105 $d:12.898383766650468 $l:54.98476142822849
MatrixKey [startValue=Ten, dealerCard=Two2, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Five5, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Eight8, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Ten, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Nine9, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Three3, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Seven7, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=One1, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Six6, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Four4, situation=Start_With_Pair]=Stand -> Split

Two2
0.027969672419496737
w:75.75683872407858 $d:12.401888321248329 $l:11.841272954673093
0.5412654917203525
w:54.31062118491028 $d:8.08114779016244 $l:37.608231024927285
MatrixKey [startValue=Ten, dealerCard=Two2, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Five5, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Eight8, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Ten, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Nine9, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Three3, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Seven7, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=One1, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Six6, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Four4, situation=Start_With_Pair]=Stand -> Split

Three3
0.0284147643415633
w:76.4254686765728 $d:12.081740865472726 $l:11.492790457954468
0.6202444495258392
w:55.65064158900892 $d:7.838242524272339 $l:36.511115886718734
MatrixKey [startValue=Ten, dealerCard=Two2, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Five5, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Eight8, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Ten, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Nine9, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Three3, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Seven7, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=One1, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Six6, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Four4, situation=Start_With_Pair]=Stand -> Split

Four4
0.028874306539630946
w:77.16937222014178 $d:11.64406762130161 $l:11.18656015855661
0.7026421582221426
w:57.24636751436149 $d:7.189422154765223 $l:35.5642103308733
MatrixKey [startValue=Ten, dealerCard=Two2, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Five5, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Eight8, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Ten, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Nine9, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Three3, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Seven7, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=One1, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Six6, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Four4, situation=Start_With_Pair]=Stand -> Split

Five5
0.02942081219806749
w:78.02619008976835 $d:11.1792923560384 $l:10.794517554193263
0.7949106633161752
w:58.80743797413093 $d:6.914506109401664 $l:34.27805591646741
MatrixKey [startValue=Ten, dealerCard=Two2, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Five5, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Eight8, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Ten, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Nine9, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Three3, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Seven7, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=One1, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Six6, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Four4, situation=Start_With_Pair]=Stand -> Split

Six6
0.030802816102304648
w:80.11734977484774 $d:10.155092255566611 $l:9.727557969585652
0.886135434111893
w:60.337474699796815 $d:6.669449941440855 $l:32.993075358762326
MatrixKey [startValue=Ten, dealerCard=Two2, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Five5, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Eight8, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Ten, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Nine9, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Three3, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Seven7, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=One1, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Six6, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Four4, situation=Start_With_Pair]=Stand -> Split

Seven7
0.03385680485770967
w:84.75026480605464 $d:7.868157627732522 $l:7.381577566212825
0.7612745854714191
w:56.984514194421685 $d:9.522410359652032 $l:33.49307544592627
MatrixKey [startValue=Ten, dealerCard=Two2, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Five5, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Eight8, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Ten, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Nine9, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Three3, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Seven7, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=One1, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Six6, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Four4, situation=Start_With_Pair]=Stand -> Split

Eight8
0.034651228005782506
w:86.13109717557217 $d:6.921887942591434 $l:6.947014881836397
0.5621327344541238
w:53.91344373355028 $d:9.519424825429128 $l:36.56713144102058
MatrixKey [startValue=Ten, dealerCard=Two2, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Five5, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Eight8, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Ten, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Nine9, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Three3, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Seven7, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=One1, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Six6, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Four4, situation=Start_With_Pair]=Stand -> Split

Nine9
0.033164970549592145
w:81.87544312368965 $d:12.036839279403882 $l:6.087717596906468
0.300435161026119
w:49.271553402820544 $d:10.727732281636444 $l:40.00071431554302
MatrixKey [startValue=Ten, dealerCard=Two2, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Five5, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Eight8, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Ten, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Nine9, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Three3, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Seven7, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=One1, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Six6, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Four4, situation=Start_With_Pair]=Stand -> Split

Ten
0.019079970651596712
w:54.79983065097889 $d:34.00138989270622 $l:11.1987794563149
-0.1931185358711543
w:39.319524920818274 $d:15.401691379473489 $l:45.27878369970823
MatrixKey [startValue=Ten, dealerCard=Two2, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Five5, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Eight8, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Ten, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Nine9, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Three3, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Seven7, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=One1, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Six6, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Four4, situation=Start_With_Pair]=Stand -> Split

JJJ
0.019079970651596716
w:54.79983065097889 $d:34.001389892706214 $l:11.198779456314899
-0.19311853587115435
w:39.319524920818274 $d:15.401691379473489 $l:45.27878369970823
MatrixKey [startValue=Ten, dealerCard=Two2, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Five5, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Eight8, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Ten, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Nine9, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Three3, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Seven7, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=One1, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Six6, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Four4, situation=Start_With_Pair]=Stand -> Split

QQQ
0.019079970651596716
w:54.79983065097889 $d:34.00138989270622 $l:11.198779456314895
-0.19311853587115424
w:39.319524920818274 $d:15.401691379473489 $l:45.27878369970823
MatrixKey [startValue=Ten, dealerCard=Two2, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Five5, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Eight8, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Ten, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Nine9, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Three3, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Seven7, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=One1, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Six6, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Four4, situation=Start_With_Pair]=Stand -> Split

KKK
0.019079970651596716
w:54.7998306509789 $d:34.00138989270622 $l:11.198779456314895
-0.19311853587115435
w:39.319524920818274 $d:15.401691379473489 $l:45.27878369970822
MatrixKey [startValue=Ten, dealerCard=Two2, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Five5, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Eight8, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Ten, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Nine9, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Three3, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Seven7, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=One1, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Six6, situation=Start_With_Pair]=Stand -> Split
MatrixKey [startValue=Ten, dealerCard=Four4, situation=Start_With_Pair]=Stand -> Split
			 */
		}
	}
	
	public static void test33vs4() {
		Card dealercard = Card.Four4;
		
		PlayerCardsPathValue eight2 = new PlayerCardsPathValue(Card.Three3,Card.Three3);
		Collection<PlayerCardsPathValue> eight2r = Strategy8012.generatePlayerCardsPaths(new Finally2047(), eight2, dealercard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight2r, dealercard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight2r, dealercard));
		System.out.println("ROI: " + new Finally2047().getROI());
		
		PlayerCardsPathValue eight22 = new PlayerCardsPathValue(Card.Three3,Card.Three3);
		Collection<PlayerCardsPathValue> eight22r = Strategy8012.generatePlayerCardsPaths(new TestAnything2048(), eight22, dealercard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight22r, dealercard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight22r, dealercard));
		System.out.println("ROI: " + new TestAnything2048().getROI());
		
		System.out.println(new Finally2047().diffWith(new TestAnything2048()));
	}
	
	public static void test99vs7() {
		Card dealercard = Card.Seven7;
		
		PlayerCardsPathValue eight2 = new PlayerCardsPathValue(Card.Nine9,Card.Nine9);
		Collection<PlayerCardsPathValue> eight2r = Strategy8012.generatePlayerCardsPaths(new Finally2047(), eight2, dealercard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight2r, dealercard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight2r, dealercard));
		System.out.println("ROI: " + new Finally2047().getROI());
		
		PlayerCardsPathValue eight22 = new PlayerCardsPathValue(Card.Nine9,Card.Nine9);
		Collection<PlayerCardsPathValue> eight22r = Strategy8012.generatePlayerCardsPaths(new TestAnything2048(), eight22, dealercard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight22r, dealercard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight22r, dealercard));
		System.out.println("ROI: " + new TestAnything2048().getROI());
		
		System.out.println(new Finally2047().diffWith(new TestAnything2048()));
		
		/*
0.5550094202171082
w:53.24125306964081 $d:9.209247466834022 $l:37.54949946352515
ROI: 5.683492534433242
0.01751369305740782
w:63.11437111287398 $d:13.793092270091051 $l:23.09253661703497
ROI: 5.145996807273559
MatrixKey [startValue=Nine, dealerCard=Seven7, situation=Start_With_Pair]=Split -> Stand
MatrixKey [startValue=Nine, dealerCard=Seven7, situation=Splited_Pair_And_Can_Split]=Split -> Stand


		 */
	}
	
	public static void test77vs456() {
		Card dealercard = Card.Five5;
		
		PlayerCardsPathValue eight2 = new PlayerCardsPathValue(Card.Seven7,Card.Seven7);
		Collection<PlayerCardsPathValue> eight2r = Strategy8012.generatePlayerCardsPaths(new Finally2047(), eight2, dealercard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight2r, dealercard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight2r, dealercard));
		System.out.println("ROI: " + new Finally2047().getROI());
		
		PlayerCardsPathValue eight22 = new PlayerCardsPathValue(Card.Seven7,Card.Seven7);
		Collection<PlayerCardsPathValue> eight22r = Strategy8012.generatePlayerCardsPaths(new TestAnything2048(), eight22, dealercard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight22r, dealercard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight22r, dealercard));
		System.out.println("ROI: " + new TestAnything2048().getROI());
		
		System.out.println(new Finally2047().diffWith(new TestAnything2048()));
		
		/*
4

0.03783730864712822
w:46.37782838908741 $d:6.856136603072151 $l:46.76603500784043
ROI: 5.683492534433242
-0.009119225575840217
w:39.58049180346555 $d:0.0 $l:60.41950819653445
ROI: 5.449255153121071
MatrixKey [startValue=Seven, dealerCard=Four4, situation=Splited_Pair_And_Can_Split]=Split -> Stand
MatrixKey [startValue=Seven, dealerCard=Five5, situation=Start_With_Pair]=Split -> Stand
MatrixKey [startValue=Seven, dealerCard=Five5, situation=Splited_Pair_And_Can_Split]=Split -> Stand
MatrixKey [startValue=Seven, dealerCard=Four4, situation=Start_With_Pair]=Split -> Stand

5

0.18013967877470752
w:48.342180432721925 $d:6.517386420438067 $l:45.14043314684001
ROI: 5.683492534433242
-0.007141168314500873
w:41.84059422952498 $d:0.0 $l:58.15940577047501
ROI: 5.449255153121071
MatrixKey [startValue=Seven, dealerCard=Four4, situation=Splited_Pair_And_Can_Split]=Split -> Stand
MatrixKey [startValue=Seven, dealerCard=Five5, situation=Start_With_Pair]=Split -> Stand
MatrixKey [startValue=Seven, dealerCard=Five5, situation=Splited_Pair_And_Can_Split]=Split -> Stand
MatrixKey [startValue=Seven, dealerCard=Four4, situation=Start_With_Pair]=Split -> Stand


6

0.3091874035190065
w:49.463075808373326 $d:7.517988475202595 $l:43.01893571642407
ROI: 5.683492534433242
-0.0067529561052236155
w:42.284160436207664 $d:0.0 $l:57.715839563792336
ROI: 5.367552174809019
MatrixKey [startValue=Seven, dealerCard=Six6, situation=Start_With_Pair]=Split -> Stand
MatrixKey [startValue=Seven, dealerCard=Six6, situation=Splited_Pair_And_Can_Split]=Split -> Stand

		 */
	}
	
	public static void test66vs456() {
		Card dealercard = Card.Four4;
		
		PlayerCardsPathValue eight2 = new PlayerCardsPathValue(Card.Six6,Card.Six6);
		Collection<PlayerCardsPathValue> eight2r = Strategy8012.generatePlayerCardsPaths(new Finally2047(), eight2, dealercard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight2r, dealercard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight2r, dealercard));
		System.out.println("ROI: " + new Finally2047().getROI());
		
		PlayerCardsPathValue eight22 = new PlayerCardsPathValue(Card.Six6,Card.Six6);
		Collection<PlayerCardsPathValue> eight22r = Strategy8012.generatePlayerCardsPaths(new TestAnything2048(), eight22, dealercard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight22r, dealercard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight22r, dealercard));
		System.out.println("ROI: " + new TestAnything2048().getROI());
		
		System.out.println(new Finally2047().diffWith(new TestAnything2048()));
		
		/*
4
-0.009119225575840217
w:39.58049180346555 $d:0.0 $l:60.41950819653445
ROI: 5.68349253443325
-0.0958841915744296
w:46.1187811767404 $d:3.808688325608984 $l:50.07253049765061
ROI: 5.596727568434663
MatrixKey [startValue=Six, dealerCard=Four4, situation=Splited_Pair_And_Can_Split]=Stand -> Split
MatrixKey [startValue=Six, dealerCard=Four4, situation=Start_With_Pair]=Stand -> Split


5
0.05505885657560851
w:48.10966676886074 $d:3.6471372980081447 $l:48.243195933131105
ROI: 5.683492534433242
-0.007141168314500873
w:41.84059422952498 $d:0.0 $l:58.15940577047501
ROI: 5.474277911092785
MatrixKey [startValue=Six, dealerCard=Six6, situation=Splited_Pair_And_Can_Split]=Split -> Stand
MatrixKey [startValue=Six, dealerCard=Six6, situation=Start_With_Pair]=Split -> Stand
MatrixKey [startValue=Six, dealerCard=Five5, situation=Start_With_Pair]=Split -> Stand
MatrixKey [startValue=Six, dealerCard=Five5, situation=Splited_Pair_And_Can_Split]=Split -> Stand

6
0.1402616423451273
w:49.052902342913505 $d:3.8351841521381367 $l:47.11191350494836
ROI: 5.683492534433242
-0.0067529561052236155
w:42.284160436207664 $d:0.0 $l:57.715839563792336
ROI: 5.474277911092785
MatrixKey [startValue=Six, dealerCard=Six6, situation=Splited_Pair_And_Can_Split]=Split -> Stand
MatrixKey [startValue=Six, dealerCard=Six6, situation=Start_With_Pair]=Split -> Stand
MatrixKey [startValue=Six, dealerCard=Five5, situation=Start_With_Pair]=Split -> Stand
MatrixKey [startValue=Six, dealerCard=Five5, situation=Splited_Pair_And_Can_Split]=Split -> Stand
		 */
	}
	
	public static void test44vs56() {
		Card dealercard = Card.Five5;
		
		PlayerCardsPathValue eight2 = new PlayerCardsPathValue(Card.Four4,Card.Four4);
		Collection<PlayerCardsPathValue> eight2r = Strategy8012.generatePlayerCardsPaths(new Finally2047(), eight2, dealercard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight2r, dealercard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight2r, dealercard));
		System.out.println("ROI: " + new Finally2047().getROI());
		
		PlayerCardsPathValue eight22 = new PlayerCardsPathValue(Card.Four4,Card.Four4);
		Collection<PlayerCardsPathValue> eight22r = Strategy8012.generatePlayerCardsPaths(new TestAnything2048(), eight22, dealercard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight22r, dealercard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight22r, dealercard));
		System.out.println("ROI: " + new TestAnything2048().getROI());
		
		System.out.println(new Finally2047().diffWith(new TestAnything2048()));
		
		/*
5
0.003350151639625946
w:50.45733707564344 $d:6.741004980326158 $l:42.80165794403041
ROI: 5.68349253443325
0.069084353276982
w:48.48690916542311 $d:3.265744284383829 $l:48.247346550193065
ROI: 5.749226736070603
MatrixKey [startValue=Four, dealerCard=Five5, situation=Start_With_Pair]=Hit -> Split
MatrixKey [startValue=Four, dealerCard=Five5, situation=Splited_Pair_And_Can_Split]=Hit -> Split

6
0.14837820929868784
w:49.44552225730228 $d:3.265414475826193 $l:47.289063266871516
ROI: 5.683492534433242
0.005121227617782882
w:52.62732579515021 $d:6.448244164614788 $l:40.92443004023499
ROI: 5.540235552752337
MatrixKey [startValue=Four, dealerCard=Six6, situation=Start_With_Pair]=Split -> Hit
MatrixKey [startValue=Four, dealerCard=Six6, situation=Splited_Pair_And_Can_Split]=Split -> Hit


		 */
	}
	
	public static void test14vs10() {
		Card dealercard = Card.Ten;
		
		PlayerCardsPathValue eight2 = new PlayerCardsPathValue(Card.Eight8,Card.Six6);
		Collection<PlayerCardsPathValue> eight2r = Strategy8012.generatePlayerCardsPaths(new Finally2047(), eight2, dealercard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight2r, dealercard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight2r, dealercard));
		System.out.println("ROI: " + new Finally2047().getROI());
		
		PlayerCardsPathValue eight22 = new PlayerCardsPathValue(Card.Eight8,Card.Six6);
		Collection<PlayerCardsPathValue> eight22r = Strategy8012.generatePlayerCardsPaths(new TestAnything2048(), eight22, dealercard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight22r, dealercard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight22r, dealercard));
		System.out.println("ROI: " + new TestAnything2048().getROI());
		
		System.out.println(new Finally2047().diffWith(new TestAnything2048()));
		/*
-0.022926820392291127
w:21.666576906699763 $d:6.458064811665926 $l:71.8753582816343
ROI: 5.748739893790822
-0.022831484617287245
w:0.0 $d:0.0 $l:100.0
ROI: 5.749226736070603
MatrixKey [startValue=Fourteen, dealerCard=Ten, situation=Start_Hand_WithoutA_WithoutPair]=Hit -> Giveup


		 */
	}
	
	public static void testA6vs3() {
		Card dealercard = Card.Three3;
		
		PlayerCardsPathValue eight2 = new PlayerCardsPathValue(Card.One1,Card.Six6);
		Collection<PlayerCardsPathValue> eight2r = Strategy8012.generatePlayerCardsPaths(new Finally2047(), eight2, dealercard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight2r, dealercard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight2r, dealercard));
		System.out.println("ROI: " + new Finally2047().getROI());
		
		PlayerCardsPathValue eight22 = new PlayerCardsPathValue(Card.One1,Card.Six6);
		Collection<PlayerCardsPathValue> eight22r = Strategy8012.generatePlayerCardsPaths(new TestAnything2048(), eight22, dealercard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight22r, dealercard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight22r, dealercard));
		System.out.println("ROI: " + new TestAnything2048().getROI());
		
		System.out.println(new Finally2047().diffWith(new TestAnything2048()));
		/*
0.0013382074629623409
w:47.319490221642596 $d:8.291638141958035 $l:44.388871636399365
ROI: 5.748739893790822
0.0025610014313780897
w:47.441138202251445 $d:7.921966808659629 $l:44.63689498908893
ROI: 5.751185481727654
MatrixKey [startValue=Six, dealerCard=Three3, situation=Start_With_A]=Hit -> Double

		 */
	}
	
	public static void testAXvs4() {
		Card dealercard = Card.Four4;
		for(Card playercard : Card.values()) {
			if(playercard.getValue()>=2 && playercard.getValue()<=6) {
				System.out.println(playercard);
				PlayerCardsPathValue eight2 = new PlayerCardsPathValue(Card.One1,playercard);
				Collection<PlayerCardsPathValue> eight2r = Strategy8012.generatePlayerCardsPaths(new Finally2047(), eight2, dealercard); 
				System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight2r, dealercard));
				HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight2r, dealercard));
				System.out.println("ROI: " + new Finally2047().getROI());
				
				PlayerCardsPathValue eight22 = new PlayerCardsPathValue(Card.One1,playercard);
				Collection<PlayerCardsPathValue> eight22r = Strategy8012.generatePlayerCardsPaths(new TestAnything2048(), eight22, dealercard); 
				System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight22r, dealercard));
				HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight22r, dealercard));
				System.out.println("ROI: " + new TestAnything2048().getROI());
				
				System.out.println(new Finally2047().diffWith(new TestAnything2048()));
			}
		}
		/*
Two2
0.001482206868588448
w:49.28416596967066 $d:4.6776393442478295 $l:46.0381946860815
ROI: 5.751185481727654
0.0029644137371768954
w:49.28416596967066 $d:4.6776393442478295 $l:46.0381946860815
ROI: 5.76245743042268
MatrixKey [startValue=Three, dealerCard=Four4, situation=Start_With_A]=Hit -> Double
MatrixKey [startValue=Two, dealerCard=Four4, situation=Start_With_A]=Hit -> Double
MatrixKey [startValue=Five, dealerCard=Four4, situation=Start_With_A]=Hit -> Double
MatrixKey [startValue=Four, dealerCard=Four4, situation=Start_With_A]=Hit -> Double

Three3
0.0014629760235737711
w:49.28416596967066 $d:4.635524594950898 $l:46.08030943537844
ROI: 5.751185481727654
0.0029259520471475436
w:49.28416596967066 $d:4.635524594950898 $l:46.08030943537844
ROI: 5.76245743042268
MatrixKey [startValue=Three, dealerCard=Four4, situation=Start_With_A]=Hit -> Double
MatrixKey [startValue=Two, dealerCard=Four4, situation=Start_With_A]=Hit -> Double
MatrixKey [startValue=Five, dealerCard=Four4, situation=Start_With_A]=Hit -> Double
MatrixKey [startValue=Four, dealerCard=Four4, situation=Start_With_A]=Hit -> Double

Four4
0.0013893333909885902
w:49.20203137641223 $d:4.6385194845492395 $l:46.159449139038536
ROI: 5.751185481727654
0.002778666781977182
w:49.202031376412236 $d:4.6385194845492395 $l:46.15944913903852
ROI: 5.76245743042268
MatrixKey [startValue=Three, dealerCard=Four4, situation=Start_With_A]=Hit -> Double
MatrixKey [startValue=Two, dealerCard=Four4, situation=Start_With_A]=Hit -> Double
MatrixKey [startValue=Five, dealerCard=Four4, situation=Start_With_A]=Hit -> Double
MatrixKey [startValue=Four, dealerCard=Four4, situation=Start_With_A]=Hit -> Double

Five5
0.0013014580643630595
w:49.12535000825783 $d:4.59943891702007 $l:46.2752110747221
ROI: 5.751185481727654
0.002602916128726119
w:49.12535000825783 $d:4.59943891702007 $l:46.2752110747221
ROI: 5.76245743042268
MatrixKey [startValue=Three, dealerCard=Four4, situation=Start_With_A]=Hit -> Double
MatrixKey [startValue=Two, dealerCard=Four4, situation=Start_With_A]=Hit -> Double
MatrixKey [startValue=Five, dealerCard=Four4, situation=Start_With_A]=Hit -> Double
MatrixKey [startValue=Four, dealerCard=Four4, situation=Start_With_A]=Hit -> Double

Six6
0.0056201835411598
w:49.24205122037374 $d:7.669881449665378 $l:43.088067329960886
ROI: 5.751185481727654
0.0056201835411598
w:49.24205122037374 $d:7.669881449665378 $l:43.088067329960886
ROI: 5.76245743042268
MatrixKey [startValue=Three, dealerCard=Four4, situation=Start_With_A]=Hit -> Double
MatrixKey [startValue=Two, dealerCard=Four4, situation=Start_With_A]=Hit -> Double
MatrixKey [startValue=Five, dealerCard=Four4, situation=Start_With_A]=Hit -> Double
MatrixKey [startValue=Four, dealerCard=Four4, situation=Start_With_A]=Hit -> Double
		 */
	}
	
	public static void test12vs3() {
		Card dealercard = Card.Three3;
		PlayerCardsPathValue eight2 = new PlayerCardsPathValue(Card.Five5,Card.Seven7);
		Collection<PlayerCardsPathValue> eight2r = Strategy8012.generatePlayerCardsPaths(new Finally2047(), eight2, dealercard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight2r, dealercard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight2r, dealercard));
		System.out.println("ROI: " + new Finally2047().getROI());
		
		PlayerCardsPathValue eight22 = new PlayerCardsPathValue(Card.Five5,Card.Seven7);
		Collection<PlayerCardsPathValue> eight22r = Strategy8012.generatePlayerCardsPaths(new TestAnything2048(), eight22, dealercard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight22r, dealercard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight22r, dealercard));
		System.out.println("ROI: " + new TestAnything2048().getROI());
		
		System.out.println(new Finally2047().diffWith(new TestAnything2048()));
		
		/*
-0.010784041904263407
w:35.81108266913138 $d:4.761232226479771 $l:59.427685104388836
ROI: 5.751185481727654
-0.011489342140456212
w:37.41940971749507 $d:0.0 $l:62.58059028250492
ROI: 5.733281516587858
MatrixKey [startValue=Twelve, dealerCard=Three3, situation=Three_More_Cards]=Hit -> Stand
MatrixKey [startValue=Twelve, dealerCard=Three3, situation=Splited_Pair_And_Can_NOT_Split]=Hit -> Stand
MatrixKey [startValue=Twelve, dealerCard=Three3, situation=Start_Hand_WithoutA_WithoutPair]=Hit -> Stand


		 */
	}
	
	public static void testA7vsX() {
		for(Card dealercard : Card.values()) {
			System.out.println(dealercard);
			PlayerCardsPathValue eight2 = new PlayerCardsPathValue(Card.One1,Card.Seven7);
			Collection<PlayerCardsPathValue> eight2r = Strategy8012.generatePlayerCardsPaths(new Finally2047(), eight2, dealercard); 
			System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight2r, dealercard));
			HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight2r, dealercard));
			
			PlayerCardsPathValue eight22 = new PlayerCardsPathValue(Card.One1,Card.Seven7);
			Collection<PlayerCardsPathValue> eight22r = Strategy8012.generatePlayerCardsPaths(new TestAnything2048(), eight22, dealercard); 
			System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight22r, dealercard));
			HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight22r, dealercard));
			System.out.println(new Finally2047().diffWith(new TestAnything2048()));
		}
		/*
One1
-0.01726970074019185
w:24.54895966764076 $d:13.082155614562533 $l:62.36888471779671
-0.01547480775397342
w:26.613468588460677 $d:12.883878625533235 $l:60.50265278600608
MatrixKey [startValue=Seven, dealerCard=Nine9, situation=Start_With_A]=Stand -> Hit
MatrixKey [startValue=Seven, dealerCard=Four4, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=Three3, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=Ten, situation=Start_With_A]=Stand -> Hit
MatrixKey [startValue=Seven, dealerCard=Five5, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=Six6, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=One1, situation=Start_With_A]=Stand -> Hit

Two2
0.005511923976461771
w:49.31601058520999 $d:13.438862674532274 $l:37.24512674025775
0.005511923976461771
w:49.31601058520999 $d:13.438862674532274 $l:37.24512674025775
MatrixKey [startValue=Seven, dealerCard=Nine9, situation=Start_With_A]=Stand -> Hit
MatrixKey [startValue=Seven, dealerCard=Four4, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=Three3, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=Ten, situation=Start_With_A]=Stand -> Hit
MatrixKey [startValue=Seven, dealerCard=Five5, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=Six6, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=One1, situation=Start_With_A]=Stand -> Hit

Three3
0.006736133892812433
w:50.84898508266252 $d:13.053882387688626 $l:36.09713252964886
0.008103108567589565
w:50.518156085813914 $d:7.836422895120894 $l:41.64542101906519
MatrixKey [startValue=Seven, dealerCard=Nine9, situation=Start_With_A]=Stand -> Hit
MatrixKey [startValue=Seven, dealerCard=Four4, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=Three3, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=Ten, situation=Start_With_A]=Stand -> Hit
MatrixKey [startValue=Seven, dealerCard=Five5, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=Six6, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=One1, situation=Start_With_A]=Stand -> Hit

Four4
0.00807242746586196
w:52.63606408551422 $d:12.406151628064796 $l:34.95778428642098
0.010948642007368298
w:52.234293325791285 $d:7.519948249777193 $l:40.24575842443153
MatrixKey [startValue=Seven, dealerCard=Nine9, situation=Start_With_A]=Stand -> Hit
MatrixKey [startValue=Seven, dealerCard=Four4, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=Three3, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=Ten, situation=Start_With_A]=Stand -> Hit
MatrixKey [startValue=Seven, dealerCard=Five5, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=Six6, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=One1, situation=Start_With_A]=Stand -> Hit

Five5
0.009266656837525016
w:54.02494007796774 $d:12.243712207542721 $l:33.731347714489544
0.013788131564103535
w:53.89463988944361 $d:7.308437031065222 $l:38.79692307949117
MatrixKey [startValue=Seven, dealerCard=Nine9, situation=Start_With_A]=Stand -> Hit
MatrixKey [startValue=Seven, dealerCard=Four4, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=Three3, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=Ten, situation=Start_With_A]=Stand -> Hit
MatrixKey [startValue=Seven, dealerCard=Five5, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=Six6, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=One1, situation=Start_With_A]=Stand -> Hit

Six6
0.012935884232996294
w:58.85482152551145 $d:10.61940442406257 $l:30.525774050425987
0.017402169837202427
w:56.077290351591245 $d:6.900432723349185 $l:37.02227692505957
MatrixKey [startValue=Seven, dealerCard=Nine9, situation=Start_With_A]=Stand -> Hit
MatrixKey [startValue=Seven, dealerCard=Four4, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=Three3, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=Ten, situation=Start_With_A]=Stand -> Hit
MatrixKey [startValue=Seven, dealerCard=Five5, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=Six6, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=One1, situation=Start_With_A]=Stand -> Hit

Seven7
0.018275157972947296
w:63.11437111287398 $d:13.793092270091051 $l:23.092536617034966
0.018275157972947296
w:63.11437111287398 $d:13.793092270091051 $l:23.092536617034966
MatrixKey [startValue=Seven, dealerCard=Nine9, situation=Start_With_A]=Stand -> Hit
MatrixKey [startValue=Seven, dealerCard=Four4, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=Three3, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=Ten, situation=Start_With_A]=Stand -> Hit
MatrixKey [startValue=Seven, dealerCard=Five5, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=Six6, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=One1, situation=Start_With_A]=Stand -> Hit

Eight8
0.004804689315048759
w:37.26328900905532 $d:35.995491386458006 $l:26.74121960448667
0.004804689315048759
w:37.26328900905532 $d:35.995491386458006 $l:26.74121960448667
MatrixKey [startValue=Seven, dealerCard=Nine9, situation=Start_With_A]=Stand -> Hit
MatrixKey [startValue=Seven, dealerCard=Four4, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=Three3, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=Ten, situation=Start_With_A]=Stand -> Hit
MatrixKey [startValue=Seven, dealerCard=Five5, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=Six6, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=One1, situation=Start_With_A]=Stand -> Hit

Nine9
-0.008381347930350724
w:34.95517480992236 $d:11.73484763551763 $l:53.30997755456001
-0.0048054158994149075
w:39.431227380212576 $d:10.613884645518707 $l:49.95488797426872
MatrixKey [startValue=Seven, dealerCard=Nine9, situation=Start_With_A]=Stand -> Hit
MatrixKey [startValue=Seven, dealerCard=Four4, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=Three3, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=Ten, situation=Start_With_A]=Stand -> Hit
MatrixKey [startValue=Seven, dealerCard=Five5, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=Six6, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=One1, situation=Start_With_A]=Stand -> Hit

Ten
-0.010939082791354929
w:32.43849443867282 $d:11.166875604703383 $l:56.39462995662381
-0.009172705371805468
w:34.59222415724145 $d:10.72770911732027 $l:54.68006672543827
MatrixKey [startValue=Seven, dealerCard=Nine9, situation=Start_With_A]=Stand -> Hit
MatrixKey [startValue=Seven, dealerCard=Four4, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=Three3, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=Ten, situation=Start_With_A]=Stand -> Hit
MatrixKey [startValue=Seven, dealerCard=Five5, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=Six6, situation=Start_With_A]=Stand -> Double
MatrixKey [startValue=Seven, dealerCard=One1, situation=Start_With_A]=Stand -> Hit
		 */
	}
	
	public static void testPair88vs2() {
		Card dealercard = Card.Two2;
		
		PlayerCardsPathValue eight2 = new PlayerCardsPathValue(Card.Eight8,Card.Eight8);
		Collection<PlayerCardsPathValue> eight2r = Strategy8012.generatePlayerCardsPaths(new Finally2047(), eight2, dealercard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight2r, dealercard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight2r, dealercard));
		
		PlayerCardsPathValue eight22 = new PlayerCardsPathValue(Card.Eight8,Card.Eight8);
		Collection<PlayerCardsPathValue> eight22r = Strategy8012.generatePlayerCardsPaths(new TestAnything2048(), eight22, dealercard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight22r, dealercard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight22r, dealercard));
		System.out.println(new Finally2047().diffWith(new TestAnything2048()));
		/*
0.0613250409583747
w:46.3556755040821 $d:8.014703284167197 $l:45.629621211750695
-0.012821456923418923
w:35.3503705556962 $d:0.0 $l:64.6496294443038
MatrixKey [startValue=Eight, dealerCard=Two2, situation=Start_With_Pair]=Split -> Stand
		 */
	}
	
	public static void test11vs10() {
		Card dealercard = Card.Ten;
		
		PlayerCardsPathValue eight2 = new PlayerCardsPathValue(Card.Eight8,Card.Three3);
		Collection<PlayerCardsPathValue> eight2r = Strategy8012.generatePlayerCardsPaths(new Finally2047(), eight2, dealercard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight2r, dealercard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight2r, dealercard));
		System.out.println("ROI: " + new Finally2047().getROI());
		
		PlayerCardsPathValue eight22 = new PlayerCardsPathValue(Card.Eight8,Card.Three3);
		Collection<PlayerCardsPathValue> eight22r = Strategy8012.generatePlayerCardsPaths(new TestAnything2048(), eight22, dealercard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight22r, dealercard)*8);
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight22r, dealercard));
		System.out.println("ROI: " + new TestAnything2048().getROI());
		
		System.out.println(new Finally2047().diffWith(new TestAnything2048()));
		
		/*
0.00279551600701774
w:47.6919797007653 $d:10.738104174004622 $l:41.56991612523008
ROI: 5.751185481727654
0.023685285189974127
w:47.28998342064774 $d:8.661894888652052 $l:44.04812169070022
ROI: 5.757018513225002
MatrixKey [startValue=Eleven, dealerCard=Ten, situation=Start_Hand_WithoutA_WithoutPair]=Hit -> Double
MatrixKey [startValue=Eleven, dealerCard=Ten, situation=Splited_Pair_And_Can_NOT_Split]=Hit -> Double
		 */
	}

}
