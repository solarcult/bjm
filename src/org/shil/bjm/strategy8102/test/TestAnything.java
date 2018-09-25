package org.shil.bjm.strategy8102.test;

import java.util.Collection;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerCardsPathValue;
import org.shil.bjm.meta.ProfitUtil;
import org.shil.bjm.meta.WinRateUtil;
import org.shil.bjm.strategy8102.Strategy8012;
import org.shil.bjm.strategy8102.strategy.Finally2047;
import org.shil.bjm.strategy8102.strategy.StrategyMatrix8012;

public class TestAnything {

	public static void main(String[] args) {
		test16vs789TA();
	}
	
	public static void test16vs789TA() {
		Card dealerCard = Card.Eight8;
			System.out.println(dealerCard);
			PlayerCardsPathValue eight2 = new PlayerCardsPathValue(Card.Six6,Card.Ten);
			Collection<PlayerCardsPathValue> eight2r = Strategy8012.generatePlayerCardsPaths(new Finally2047(), eight2, dealerCard); 
			System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight2r, dealerCard));
			HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight2r, dealerCard));
			System.out.println(new Finally2047().getSimpleDesc());
			PlayerCardsPathValue eight22 = new PlayerCardsPathValue(Card.Six6,Card.Ten);
			Collection<PlayerCardsPathValue> eight22r = Strategy8012.generatePlayerCardsPaths(new TestAnything2048(), eight22, dealerCard); 
			System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight22r, dealerCard));
			HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight22r, dealerCard));
			System.out.println(new TestAnything2048().getSimpleDesc());
			System.out.println(new Finally2047().diffWith(new TestAnything2048()));
			System.out.println();
/*
One1 Hit
-0.02922955270540397
w:14.570273120647546 $d:6.847951231899625 $l:78.58177564745283
StrategyMatrix8012 [roi= 3.7619278631218464E-6,	 pureReturn= 5.520252946344997,	 totalSpead= 1467400.0,	 WdlRateWithDSWithProbRate= w:45.578978070916705 $d:8.18648241743105 $l:46.23453951165224
-0.03511729225780109
w:11.547296587963189 $d:0.0 $l:88.45270341203681
StrategyMatrix8012 [roi= 3.671832939286577E-6,	 pureReturn= 5.388047655109123,	 totalSpead= 1467400.0,	 WdlRateWithDSWithProbRate= w:45.55657551446926 $d:8.138670254946593 $l:46.30475423058415
MatrixKey [startValue=Sixteen, dealerCard=One1, situation=Splited_Pair_And_Can_NOT_Split] : Hit -> Stand
MatrixKey [startValue=Sixteen, dealerCard=One1, situation=Three_More_Cards] : Hit -> Stand
MatrixKey [startValue=Sixteen, dealerCard=One1, situation=Start_Hand_WithoutA_WithoutPair] : Hit -> Stand

Seven7 Hit
-0.021741447817359497
w:26.193567586820887 $d:0.0 $l:73.8064324131791
StrategyMatrix8012 [roi= 3.7619278631218485E-6,	 pureReturn= 5.520252946345001,	 totalSpead= 1467400.0,	 WdlRateWithDSWithProbRate= w:45.57897807091667 $d:8.186482417431055 $l:46.23453951165228
-0.01876101290963869
w:26.60005852819368 $d:5.714046380375156 $l:67.68589509143116
StrategyMatrix8012 [roi= 3.5575383515079798E-6,	 pureReturn= 5.625891149074719,	 totalSpead= 1581400.0,	 WdlRateWithDSWithProbRate= w:45.58510552852026 $d:8.23459059238171 $l:46.180303879098034
MatrixKey [startValue=Sixteen, dealerCard=Seven7, situation=Three_More_Cards] : Stand -> Hit
MatrixKey [startValue=Sixteen, dealerCard=Seven7, situation=Splited_Pair_And_Can_NOT_Split] : Stand -> Hit
MatrixKey [startValue=Sixteen, dealerCard=Seven7, situation=Start_Hand_WithoutA_WithoutPair] : Stand -> Hit

Eight8 Hit
-0.02340748663099084
w:24.36928979503651 $d:0.0 $l:75.63071020496349
StrategyMatrix8012 [roi= 3.5538959965458812E-6,	 pureReturn= 5.620131128937657,	 totalSpead= 1581400.0,	 WdlRateWithDSWithProbRate= w:45.59014137510547 $d:8.221440607918165 $l:46.188418016976364
-0.020782899115010668
w:24.315518051097367 $d:5.85528079006169 $l:69.82920115884095
StrategyMatrix8012 [roi= 3.477520242885359E-6,	 pureReturn= 5.699655678089104,	 totalSpead= 1639000.0,	 WdlRateWithDSWithProbRate= w:45.59223212914815 $d:8.265754957941368 $l:46.14201291291048
MatrixKey [startValue=Sixteen, dealerCard=Eight8, situation=Three_More_Cards] : Stand -> Hit
MatrixKey [startValue=Sixteen, dealerCard=Eight8, situation=Splited_Pair_And_Can_NOT_Split] : Stand -> Hit
MatrixKey [startValue=Sixteen, dealerCard=Eight8, situation=Start_Hand_WithoutA_WithoutPair] : Stand -> Hit

 */
			
	}
	
	public static void test55vs6() {
//		Double
		Card dealerCard = Card.Six6;
		PlayerCardsPathValue eight2 = new PlayerCardsPathValue(Card.Five5,Card.Five5);
		Collection<PlayerCardsPathValue> eight2r = Strategy8012.generatePlayerCardsPaths(new Finally2047(), eight2, dealerCard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight2r, dealerCard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight2r, dealerCard));
		System.out.println(new Finally2047().getSimpleDesc());
		
		PlayerCardsPathValue eight22 = new PlayerCardsPathValue(Card.Five5,Card.Five5);
		Collection<PlayerCardsPathValue> eight22r = Strategy8012.generatePlayerCardsPaths(new TestAnything2048(), eight22, dealerCard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight22r, dealerCard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight22r, dealerCard));
		System.out.println(new TestAnything2048().getSimpleDesc());
		
		System.out.println(new Finally2047().diffWith(new TestAnything2048()));
		
		/*
0.050821012380811936
w:61.103393898254424 $d:6.826925135263908 $l:32.06968096648167
0.13017849843510026
w:48.54846661058604 $d:2.925256293439361 $l:48.5262770959746
MatrixKey [startValue=Five, dealerCard=Six6, situation=Start_With_Pair]=Double -> Split
MatrixKey [startValue=Five, dealerCard=Six6, situation=Splited_Pair_And_Can_Split]=Double -> Split

		 */
	}
	
	public static void testTTvsXSplit() {
		for(Card dealerCard : Card.values()) {
			System.out.println(dealerCard);
			PlayerCardsPathValue eight2 = new PlayerCardsPathValue(Card.Ten,Card.Ten);
			Collection<PlayerCardsPathValue> eight2r = Strategy8012.generatePlayerCardsPaths(new Finally2047(), eight2, dealerCard); 
			System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight2r, dealerCard));
			HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight2r, dealerCard));
			System.out.println(new Finally2047().getSimpleDesc());
			System.out.println();
			PlayerCardsPathValue eight22 = new PlayerCardsPathValue(Card.Ten,Card.Ten);
			Collection<PlayerCardsPathValue> eight22r = Strategy8012.generatePlayerCardsPaths(new TestAnything2048(), eight22, dealerCard); 
			System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight22r, dealerCard));
			HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight22r, dealerCard));
			System.out.println(new Finally2047().diffWith(new TestAnything2048()));
			System.out.println(new TestAnything2048().getSimpleDesc());
			System.out.println();
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
		Card dealerCard = Card.Six6;
		
		PlayerCardsPathValue eight2 = new PlayerCardsPathValue(Card.Three3,Card.Three3);
		Collection<PlayerCardsPathValue> eight2r = Strategy8012.generatePlayerCardsPaths(new Finally2047(), eight2, dealerCard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight2r, dealerCard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight2r, dealerCard));
		System.out.println(new Finally2047().getSimpleDesc());
		
		PlayerCardsPathValue eight22 = new PlayerCardsPathValue(Card.Three3,Card.Three3);
		Collection<PlayerCardsPathValue> eight22r = Strategy8012.generatePlayerCardsPaths(new TestAnything2048(), eight22, dealerCard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight22r, dealerCard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight22r, dealerCard));
		System.out.println(new TestAnything2048().getSimpleDesc());
		
		System.out.println(new Finally2047().diffWith(new TestAnything2048()));
		/*
//4 Hit
-0.0035879406316779057
w:44.30320794396832 $d:3.1945157790042575 $l:52.50227627702743
StrategyMatrix8012 [roi= 3.7557794147425436E-6,	 pureReturn= 5.538272324979355,	 totalSpead= 1474600.0,	 WdlRateWithDSWithProbRate= w:45.567642171235114 $d:8.22009840855742 $l:46.212259420207474
-0.03625005159514788
w:46.97729487341562 $d:3.680673661584146 $l:49.34203146500022
StrategyMatrix8012 [roi= 3.4587323872445552E-6,	 pureReturn= 5.505610214015883,	 totalSpead= 1591800.0,	 WdlRateWithDSWithProbRate= w:45.58635152278822 $d:8.162603272493534 $l:46.25104520471823
MatrixKey [startValue=Three, dealerCard=Four4, situation=Start_With_Pair] : Hit -> Split
MatrixKey [startValue=Three, dealerCard=Four4, situation=Splited_Pair_And_Can_Split] : Hit -> Split

//5 Split
0.11277406435484856
w:48.93097167144218 $d:3.5424445000235374 $l:47.526583828534285
StrategyMatrix8012 [roi= 3.7557794147425436E-6,	 pureReturn= 5.538272324979355,	 totalSpead= 1474600.0,	 WdlRateWithDSWithProbRate= w:45.56764217123506 $d:8.220098408557407 $l:46.21225942020753
-0.0018448473618887572
w:46.3660721711608 $d:3.0520585927431068 $l:50.58186923609609
StrategyMatrix8012 [roi= 4.213908100219748E-6,	 pureReturn= 5.226088825892532,	 totalSpead= 1240200.0,	 WdlRateWithDSWithProbRate= w:45.46360842274023 $d:8.343610045971134 $l:46.192781531288645
MatrixKey [startValue=Three, dealerCard=Five5, situation=Splited_Pair_And_Can_Split] : Split -> Hit
MatrixKey [startValue=Three, dealerCard=Five5, situation=Start_With_Pair] : Split -> Hit

//6 Split
0.19655901391056316
w:49.95807387446407 $d:3.52472317729322 $l:46.51720294824271
StrategyMatrix8012 [roi= 3.7557794147425364E-6,	 pureReturn= 5.538272324979344,	 totalSpead= 1474600.0,	 WdlRateWithDSWithProbRate= w:45.567642171235114 $d:8.22009840855742 $l:46.21225942020748
-0.0010055734595255646
w:47.196299617762755 $d:3.3094905271177555 $l:49.49420985511948
StrategyMatrix8012 [roi= 4.213908100219739E-6,	 pureReturn= 5.2260888258925196,	 totalSpead= 1240200.0,	 WdlRateWithDSWithProbRate= w:45.463608422740286 $d:8.343610045971152 $l:46.192781531288574
MatrixKey [startValue=Three, dealerCard=Six6, situation=Start_With_Pair] : Split -> Hit
MatrixKey [startValue=Three, dealerCard=Six6, situation=Splited_Pair_And_Can_Split] : Split -> Hit
		 */
	}
	
	public static void test99vs7() {
//		Split
		Card dealerCard = Card.Seven7;
		
		PlayerCardsPathValue eight2 = new PlayerCardsPathValue(Card.Nine9,Card.Nine9);
		Collection<PlayerCardsPathValue> eight2r = Strategy8012.generatePlayerCardsPaths(new Finally2047(), eight2, dealerCard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight2r, dealerCard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight2r, dealerCard));
		System.out.println(new Finally2047().getSimpleDesc());
		
		PlayerCardsPathValue eight22 = new PlayerCardsPathValue(Card.Nine9,Card.Nine9);
		Collection<PlayerCardsPathValue> eight22r = Strategy8012.generatePlayerCardsPaths(new TestAnything2048(), eight22, dealerCard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight22r, dealerCard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight22r, dealerCard));
		System.out.println(new TestAnything2048().getSimpleDesc());
		
		System.out.println(new Finally2047().diffWith(new TestAnything2048()));
		
		/*
0.5550094202171099
w:53.241253069640806 $d:9.209247466834023 $l:37.54949946352518
StrategyMatrix8012 [roi= 3.7557794147425423E-6,	 pureReturn= 5.538272324979353,	 totalSpead= 1474600.0,	 WdlRateWithDSWithProbRate= w:45.567642171235114 $d:8.22009840855742 $l:46.212259420207474

0.017513693057407825
w:63.11437111287399 $d:13.793092270091051 $l:23.092536617034966
StrategyMatrix8012 [roi= 3.545141498525202E-6,	 pureReturn= 5.00077659781965,	 totalSpead= 1410600.0,	 WdlRateWithDSWithProbRate= w:45.480250944485995 $d:8.209860503193715 $l:46.309888552320295

MatrixKey [startValue=Nine, dealerCard=Seven7, situation=Splited_Pair_And_Can_Split] : Split -> Stand
MatrixKey [startValue=Nine, dealerCard=Seven7, situation=Start_With_Pair] : Split -> Stand


		 */
	}
	
	public static void test77vs456() {
		Card dealerCard = Card.Six6;
		
		PlayerCardsPathValue eight2 = new PlayerCardsPathValue(Card.Seven7,Card.Seven7);
		Collection<PlayerCardsPathValue> eight2r = Strategy8012.generatePlayerCardsPaths(new Finally2047(), eight2, dealerCard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight2r, dealerCard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight2r, dealerCard));
		System.out.println(new Finally2047().getSimpleDesc());
		
		PlayerCardsPathValue eight22 = new PlayerCardsPathValue(Card.Seven7,Card.Seven7);
		Collection<PlayerCardsPathValue> eight22r = Strategy8012.generatePlayerCardsPaths(new TestAnything2048(), eight22, dealerCard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight22r, dealerCard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight22r, dealerCard));
		System.out.println(new TestAnything2048().getSimpleDesc());
		
		System.out.println(new Finally2047().diffWith(new TestAnything2048()));
		
		/*
4 Split
0.03783730864712627
w:46.37782838908742 $d:6.856136603072145 $l:46.76603500784044
StrategyMatrix8012 [roi= 3.7557794147425177E-6,	 pureReturn= 5.538272324979316,	 totalSpead= 1474600.0,	 WdlRateWithDSWithProbRate= w:45.56764217123504 $d:8.220098408557385 $l:46.212259420207566
-0.009119225575840238
w:39.58049180346552 $d:0.0 $l:60.41950819653448
StrategyMatrix8012 [roi= 3.709634175176356E-6,	 pureReturn= 5.304034943667154,	 totalSpead= 1429800.0,	 WdlRateWithDSWithProbRate= w:45.516135467032264 $d:8.256373558965327 $l:46.22749097400241
MatrixKey [startValue=Seven, dealerCard=Four4, situation=Splited_Pair_And_Can_Split] : Split -> Stand
MatrixKey [startValue=Seven, dealerCard=Four4, situation=Start_With_Pair] : Split -> Stand

5 Split
0.1801396787747078
w:48.34218043272191 $d:6.517386420438062 $l:45.14043314684003
StrategyMatrix8012 [roi= 3.755779414742531E-6,	 pureReturn= 5.538272324979336,	 totalSpead= 1474600.0,	 WdlRateWithDSWithProbRate= w:45.567642171235086 $d:8.220098408557414 $l:46.2122594202075
-0.007141168314500873
w:41.84059422952499 $d:0.0 $l:58.15940577047501
StrategyMatrix8012 [roi= 3.709634175176374E-6,	 pureReturn= 5.30403494366718,	 totalSpead= 1429800.0,	 WdlRateWithDSWithProbRate= w:45.516135467032335 $d:8.256373558965354 $l:46.22749097400231
MatrixKey [startValue=Seven, dealerCard=Five5, situation=Start_With_Pair] : Split -> Stand
MatrixKey [startValue=Seven, dealerCard=Five5, situation=Splited_Pair_And_Can_Split] : Split -> Stand


6 Split
0.30918740351900603
w:49.46307580837332 $d:7.517988475202597 $l:43.01893571642408
StrategyMatrix8012 [roi= 3.755779414742526E-6,	 pureReturn= 5.538272324979329,	 totalSpead= 1474600.0,	 WdlRateWithDSWithProbRate= w:45.567642171235065 $d:8.220098408557389 $l:46.212259420207545
-0.006752956105223619
w:42.28416043620766 $d:0.0 $l:57.715839563792336
StrategyMatrix8012 [roi= 3.59615202131601E-6,	 pureReturn= 5.22233196535511,	 totalSpead= 1452200.0,	 WdlRateWithDSWithProbRate= w:45.51465893959221 $d:8.226911436347219 $l:46.25842962406057
MatrixKey [startValue=Seven, dealerCard=Six6, situation=Splited_Pair_And_Can_Split] : Split -> Stand
MatrixKey [startValue=Seven, dealerCard=Six6, situation=Start_With_Pair] : Split -> Stand

		 */
	}
	
	public static void test66vs456() {
		Card dealerCard = Card.Four4;
		
		PlayerCardsPathValue eight2 = new PlayerCardsPathValue(Card.Six6,Card.Six6);
		Collection<PlayerCardsPathValue> eight2r = Strategy8012.generatePlayerCardsPaths(new Finally2047(), eight2, dealerCard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight2r, dealerCard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight2r, dealerCard));
		System.out.println("ROI: " + new Finally2047().getPureReturn());
		
		PlayerCardsPathValue eight22 = new PlayerCardsPathValue(Card.Six6,Card.Six6);
		Collection<PlayerCardsPathValue> eight22r = Strategy8012.generatePlayerCardsPaths(new TestAnything2048(), eight22, dealerCard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight22r, dealerCard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight22r, dealerCard));
		System.out.println("ROI: " + new TestAnything2048().getPureReturn());
		
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
		Card dealerCard = Card.Six6;
		
		PlayerCardsPathValue eight2 = new PlayerCardsPathValue(Card.Four4,Card.Four4);
		Collection<PlayerCardsPathValue> eight2r = Strategy8012.generatePlayerCardsPaths(new Finally2047(), eight2, dealerCard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight2r, dealerCard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight2r, dealerCard));
		System.out.println("ROI: " + new Finally2047().getPureReturn());
		
		PlayerCardsPathValue eight22 = new PlayerCardsPathValue(Card.Four4,Card.Four4);
		Collection<PlayerCardsPathValue> eight22r = Strategy8012.generatePlayerCardsPaths(new TestAnything2048(), eight22, dealerCard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight22r, dealerCard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight22r, dealerCard));
		System.out.println("ROI: " + new TestAnything2048().getPureReturn());
		
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
0.010242455235565764
w:52.62732579515021 $d:6.448244164614793 $l:40.92443004023499
ROI: 11.07654464995862
0.29675641859737517
w:49.44552225730223 $d:3.2654144758261956 $l:47.28906326687158
ROI: 11.36305861332044
MatrixKey [startValue=Four, dealerCard=Six6, situation=Start_With_Pair] : Hit -> Split
MatrixKey [startValue=Four, dealerCard=Six6, situation=Splited_Pair_And_Can_Split] : Hit -> Split

		 */
	}
	
	public static void test14vs10() {
		Card dealerCard = Card.Ten;
		
		PlayerCardsPathValue eight2 = new PlayerCardsPathValue(Card.Eight8,Card.Six6);
		Collection<PlayerCardsPathValue> eight2r = Strategy8012.generatePlayerCardsPaths(new Finally2047(), eight2, dealerCard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight2r, dealerCard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight2r, dealerCard));
		System.out.println("ROI: " + new Finally2047().getPureReturn());
		
		PlayerCardsPathValue eight22 = new PlayerCardsPathValue(Card.Eight8,Card.Six6);
		Collection<PlayerCardsPathValue> eight22r = Strategy8012.generatePlayerCardsPaths(new TestAnything2048(), eight22, dealerCard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight22r, dealerCard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight22r, dealerCard));
		System.out.println("ROI: " + new TestAnything2048().getPureReturn());
		
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
		Card dealerCard = Card.Three3;
		
		PlayerCardsPathValue eight2 = new PlayerCardsPathValue(Card.One1,Card.Six6);
		Collection<PlayerCardsPathValue> eight2r = Strategy8012.generatePlayerCardsPaths(new Finally2047(), eight2, dealerCard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight2r, dealerCard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight2r, dealerCard));
		System.out.println("ROI: " + new Finally2047().getPureReturn());
		
		PlayerCardsPathValue eight22 = new PlayerCardsPathValue(Card.One1,Card.Six6);
		Collection<PlayerCardsPathValue> eight22r = Strategy8012.generatePlayerCardsPaths(new TestAnything2048(), eight22, dealerCard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight22r, dealerCard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight22r, dealerCard));
		System.out.println("ROI: " + new TestAnything2048().getPureReturn());
		
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
		Card dealerCard = Card.Four4;
		for(Card playercard : Card.values()) {
			if(playercard.getValue()>=2 && playercard.getValue()<=6) {
				System.out.println(playercard);
				PlayerCardsPathValue eight2 = new PlayerCardsPathValue(Card.One1,playercard);
				Collection<PlayerCardsPathValue> eight2r = Strategy8012.generatePlayerCardsPaths(new Finally2047(), eight2, dealerCard); 
				System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight2r, dealerCard));
				HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight2r, dealerCard));
				System.out.println("ROI: " + new Finally2047().getPureReturn());
				
				PlayerCardsPathValue eight22 = new PlayerCardsPathValue(Card.One1,playercard);
				Collection<PlayerCardsPathValue> eight22r = Strategy8012.generatePlayerCardsPaths(new TestAnything2048(), eight22, dealerCard); 
				System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight22r, dealerCard));
				HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight22r, dealerCard));
				System.out.println("ROI: " + new TestAnything2048().getPureReturn());
				
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
		Card dealerCard = Card.Two2;
		PlayerCardsPathValue eight2 = new PlayerCardsPathValue(Card.Five5,Card.Seven7);
		Collection<PlayerCardsPathValue> eight2r = Strategy8012.generatePlayerCardsPaths(new Finally2047(), eight2, dealerCard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight2r, dealerCard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight2r, dealerCard));
		System.out.println(new Finally2047().getSimpleDesc());
		
		PlayerCardsPathValue eight22 = new PlayerCardsPathValue(Card.Five5,Card.Seven7);
		Collection<PlayerCardsPathValue> eight22r = Strategy8012.generatePlayerCardsPaths(new TestAnything2048(), eight22, dealerCard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight22r, dealerCard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight22r, dealerCard));
		System.out.println(new TestAnything2048().getSimpleDesc());
		
		System.out.println(new Finally2047().diffWith(new TestAnything2048()));
		
		/*
//2 Hit
-0.011695830818608425
w:34.73423875358933 $d:4.9181403263530346 $l:60.34762092005764
StrategyMatrix8012 [roi= 3.7619278631218303E-6,	 pureReturn= 5.520252946344974,	 totalSpead= 1467400.0,	 WdlRateWithDSWithProbRate= w:45.57897807091672 $d:8.186482417431039 $l:46.23453951165224
-0.013378911572263227
w:35.3503705556962 $d:0.0 $l:64.6496294443038
StrategyMatrix8012 [roi= 3.749167480488614E-6,	 pureReturn= 5.4745343550094745,	 totalSpead= 1460200.0,	 WdlRateWithDSWithProbRate= w:45.583485368655815 $d:8.150968071303408 $l:46.26554656004077
MatrixKey [startValue=Twelve, dealerCard=Two2, situation=Start_Hand_WithoutA_WithoutPair] : Hit -> Stand
MatrixKey [startValue=Twelve, dealerCard=Two2, situation=Three_More_Cards] : Hit -> Stand
MatrixKey [startValue=Twelve, dealerCard=Two2, situation=Splited_Pair_And_Can_NOT_Split] : Hit -> Stand 
		 
//3 Stand
-0.01078404190426339
w:35.81108266913141 $d:4.76123222647977 $l:59.42768510438883
StrategyMatrix8012 [roi= 3.755779414742534E-6,	 pureReturn= 5.53827232497934,	 totalSpead= 1474600.0,	 WdlRateWithDSWithProbRate= w:45.567642171235036 $d:8.220098408557417 $l:46.21225942020754
-0.011489342140456184
w:37.4194097174951 $d:0.0 $l:62.580590282504915
StrategyMatrix8012 [roi= 3.761927863121847E-6,	 pureReturn= 5.520252946344998,	 totalSpead= 1467400.0,	 WdlRateWithDSWithProbRate= w:45.57897807091666 $d:8.186482417431057 $l:46.23453951165229
MatrixKey [startValue=Twelve, dealerCard=Three3, situation=Splited_Pair_And_Can_NOT_Split] : Hit -> Stand
MatrixKey [startValue=Twelve, dealerCard=Three3, situation=Three_More_Cards] : Hit -> Stand
MatrixKey [startValue=Twelve, dealerCard=Three3, situation=Start_Hand_WithoutA_WithoutPair] : Hit -> Stand

		 */
	}
	
	public static void testA7vsX() {
		for(Card dealerCard : Card.values()) {
			System.out.println(dealerCard);
			PlayerCardsPathValue eight2 = new PlayerCardsPathValue(Card.One1,Card.Seven7);
			Collection<PlayerCardsPathValue> eight2r = Strategy8012.generatePlayerCardsPaths(new Finally2047(), eight2, dealerCard); 
			System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight2r, dealerCard));
			HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight2r, dealerCard));
			System.out.println(new Finally2047().getSimpleDesc());
			
			PlayerCardsPathValue eight22 = new PlayerCardsPathValue(Card.One1,Card.Seven7);
			Collection<PlayerCardsPathValue> eight22r = Strategy8012.generatePlayerCardsPaths(new TestAnything2048(), eight22, dealerCard); 
			System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight22r, dealerCard));
			HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight22r, dealerCard));
			System.out.println(new TestAnything2048().getSimpleDesc());
			
			System.out.println(new Finally2047().diffWith(new TestAnything2048()));
		}
		/*
One1 Hit
-0.015474807753973419
w:26.61346858846068 $d:12.883878625533232 $l:60.50265278600608
StrategyMatrix8012 [roi= 3.7619278631218494E-6,	 pureReturn= 5.520252946345002,	 totalSpead= 1467400.0,	 WdlRateWithDSWithProbRate= w:45.57897807091674 $d:8.186482417431053 $l:46.23453951165221
-0.017269700740191848
w:24.548959667640755 $d:13.082155614562529 $l:62.36888471779671
StrategyMatrix8012 [roi= 3.7365287427584507E-6,	 pureReturn= 5.521842176048438,	 totalSpead= 1477800.0,	 WdlRateWithDSWithProbRate= w:45.566952638597265 $d:8.176449231452205 $l:46.256598129950525
MatrixKey [startValue=Seven, dealerCard=One1, situation=Start_With_A] : Hit -> Stand

Three3 Stand
0.00673613389281244
w:50.84898508266252 $d:13.053882387688626 $l:36.097132529648846
StrategyMatrix8012 [roi= 3.7619278631218494E-6,	 pureReturn= 5.520252946345002,	 totalSpead= 1467400.0,	 WdlRateWithDSWithProbRate= w:45.57897807091674 $d:8.186482417431053 $l:46.23453951165221
0.008103108567589582
w:50.518156085813935 $d:7.836422895120894 $l:41.64542101906518
StrategyMatrix8012 [roi= 3.7365287427584507E-6,	 pureReturn= 5.521842176048438,	 totalSpead= 1477800.0,	 WdlRateWithDSWithProbRate= w:45.566952638597265 $d:8.176449231452205 $l:46.256598129950525
MatrixKey [startValue=Seven, dealerCard=Three3, situation=Start_With_A] : Stand -> Double

Four4 Stand
0.008072427465861932
w:52.63606408551419 $d:12.406151628064801 $l:34.95778428642101
StrategyMatrix8012 [roi= 3.7619278631218494E-6,	 pureReturn= 5.520252946345002,	 totalSpead= 1467400.0,	 WdlRateWithDSWithProbRate= w:45.57897807091674 $d:8.186482417431053 $l:46.23453951165221
0.010948642007368257
w:52.23429332579127 $d:7.519948249777195 $l:40.245758424431536
StrategyMatrix8012 [roi= 3.7365287427584507E-6,	 pureReturn= 5.521842176048438,	 totalSpead= 1477800.0,	 WdlRateWithDSWithProbRate= w:45.566952638597265 $d:8.176449231452205 $l:46.256598129950525
MatrixKey [startValue=Seven, dealerCard=Four4, situation=Start_With_A] : Stand -> Double

Five5 Stand
0.009266656837525013
w:54.024940077967734 $d:12.24371220754273 $l:33.73134771448955
StrategyMatrix8012 [roi= 3.7619278631218494E-6,	 pureReturn= 5.520252946345002,	 totalSpead= 1467400.0,	 WdlRateWithDSWithProbRate= w:45.57897807091674 $d:8.186482417431053 $l:46.23453951165221
0.01378813156410353
w:53.894639889443596 $d:7.308437031065224 $l:38.79692307949119
StrategyMatrix8012 [roi= 3.7365287427584507E-6,	 pureReturn= 5.521842176048438,	 totalSpead= 1477800.0,	 WdlRateWithDSWithProbRate= w:45.566952638597265 $d:8.176449231452205 $l:46.256598129950525
MatrixKey [startValue=Seven, dealerCard=Five5, situation=Start_With_A] : Stand -> Double

Six6 Stand
0.012935884232996298
w:58.85482152551146 $d:10.619404424062582 $l:30.52577405042597
StrategyMatrix8012 [roi= 3.7619278631218494E-6,	 pureReturn= 5.520252946345002,	 totalSpead= 1467400.0,	 WdlRateWithDSWithProbRate= w:45.57897807091674 $d:8.186482417431053 $l:46.23453951165221
0.017402169837202427
w:56.077290351591245 $d:6.900432723349188 $l:37.02227692505957
StrategyMatrix8012 [roi= 3.7365287427584507E-6,	 pureReturn= 5.521842176048438,	 totalSpead= 1477800.0,	 WdlRateWithDSWithProbRate= w:45.566952638597265 $d:8.176449231452205 $l:46.256598129950525
MatrixKey [startValue=Seven, dealerCard=Six6, situation=Start_With_A] : Stand -> Double

Nine9 Hit
-0.004805415899414909
w:39.43122738021257 $d:10.613884645518715 $l:49.95488797426872
StrategyMatrix8012 [roi= 3.7619278631218494E-6,	 pureReturn= 5.520252946345002,	 totalSpead= 1467400.0,	 WdlRateWithDSWithProbRate= w:45.57897807091674 $d:8.186482417431053 $l:46.23453951165221
-0.008381347930350717
w:34.95517480992237 $d:11.734847635517637 $l:53.30997755456001
StrategyMatrix8012 [roi= 3.7365287427584507E-6,	 pureReturn= 5.521842176048438,	 totalSpead= 1477800.0,	 WdlRateWithDSWithProbRate= w:45.566952638597265 $d:8.176449231452205 $l:46.256598129950525
MatrixKey [startValue=Seven, dealerCard=Nine9, situation=Start_With_A] : Hit -> Stand

Ten Hit
-0.009172705371805482
w:34.592224157241446 $d:10.727709117320277 $l:54.68006672543828
StrategyMatrix8012 [roi= 3.7619278631218494E-6,	 pureReturn= 5.520252946345002,	 totalSpead= 1467400.0,	 WdlRateWithDSWithProbRate= w:45.57897807091674 $d:8.186482417431053 $l:46.23453951165221
-0.010939082791354932
w:32.43849443867282 $d:11.166875604703383 $l:56.394629956623795
StrategyMatrix8012 [roi= 3.7365287427584507E-6,	 pureReturn= 5.521842176048438,	 totalSpead= 1477800.0,	 WdlRateWithDSWithProbRate= w:45.566952638597265 $d:8.176449231452205 $l:46.256598129950525
MatrixKey [startValue=Seven, dealerCard=Ten, situation=Start_With_A] : Hit -> Stand

		 */
	}
	
	public static void testPair88vs2() {
		Card dealerCard = Card.Two2;
		
		PlayerCardsPathValue eight2 = new PlayerCardsPathValue(Card.Eight8,Card.Eight8);
		Collection<PlayerCardsPathValue> eight2r = Strategy8012.generatePlayerCardsPaths(new Finally2047(), eight2, dealerCard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight2r, dealerCard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight2r, dealerCard));
		System.out.println(new Finally2047().getSimpleDesc());
		
		PlayerCardsPathValue eight22 = new PlayerCardsPathValue(Card.Eight8,Card.Eight8);
		Collection<PlayerCardsPathValue> eight22r = Strategy8012.generatePlayerCardsPaths(new TestAnything2048(), eight22, dealerCard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight22r, dealerCard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight22r, dealerCard));
		System.out.println(new TestAnything2048().getSimpleDesc());
		
		System.out.println(new Finally2047().diffWith(new TestAnything2048()));
		/*
//Split
0.0613250409583747
w:46.3556755040821 $d:8.014703284167197 $l:45.629621211750695
StrategyMatrix8012 [roi= 3.7619278631218634E-6,	 pureReturn= 5.520252946345022,	 totalSpead= 1467400.0,	 WdlRateWithDSWithProbRate= w:45.5789780709167 $d:8.186482417431042 $l:46.23453951165226
-0.012821456923418923
w:35.3503705556962 $d:0.0 $l:64.6496294443038
StrategyMatrix8012 [roi= 3.762162509300379E-6,	 pureReturn= 5.446106448463229,	 totalSpead= 1447600.0,	 WdlRateWithDSWithProbRate= w:45.56592513268549 $d:8.18612632272055 $l:46.24794854459397
MatrixKey [startValue=Eight, dealerCard=Two2, situation=Start_With_Pair] : Split -> Stand
MatrixKey [startValue=Eight, dealerCard=Two2, situation=Splited_Pair_And_Can_Split] : Split -> Stand

		 */
	}
	
	public static void test11vs10() {
		Card dealerCard = Card.Ten;
		
		PlayerCardsPathValue eight2 = new PlayerCardsPathValue(Card.Eight8,Card.Three3);
		Collection<PlayerCardsPathValue> eight2r = Strategy8012.generatePlayerCardsPaths(new Finally2047(), eight2, dealerCard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight2r, dealerCard));
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight2r, dealerCard));
		System.out.println("ROI: " + new Finally2047().getPureReturn());
		
		PlayerCardsPathValue eight22 = new PlayerCardsPathValue(Card.Eight8,Card.Three3);
		Collection<PlayerCardsPathValue> eight22r = Strategy8012.generatePlayerCardsPaths(new TestAnything2048(), eight22, dealerCard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight22r, dealerCard)*8);
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight22r, dealerCard));
		System.out.println("ROI: " + new TestAnything2048().getPureReturn());
		
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
