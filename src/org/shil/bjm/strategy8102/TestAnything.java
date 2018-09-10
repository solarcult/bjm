package org.shil.bjm.strategy8102;

import java.util.Collection;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerCardsPathValue;
import org.shil.bjm.meta.ProfitUtil;
import org.shil.bjm.meta.WinRateUtil;

public class TestAnything {

	public static void main(String[] args) {
		testPair88vs2();

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
		
		PlayerCardsPathValue eight22 = new PlayerCardsPathValue(Card.Eight8,Card.Three3);
		Collection<PlayerCardsPathValue> eight22r = Strategy8012.generatePlayerCardsPaths(new TestAnything2048(), eight22, dealercard); 
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(eight22r, dealercard)*8);
		HelloWorld.printDoubleMatrix(WinRateUtil.calcWDLwDsByRawByProbPrecent(eight22r, dealercard));
		System.out.println(new Finally2047().diffWith(new TestAnything2048()));
		/*
0.002795516007017736
w:47.6919797007653 $d:10.738104174004622 $l:41.56991612523007
0.02368528518997407
w:47.28998342064774 $d:8.661894888652052 $l:44.04812169070022
MatrixKey [startValue=Eleven, dealerCard=Ten, situation=Splited_Pair_And_Can_NOT_Split]=Hit -> Double
MatrixKey [startValue=Eleven, dealerCard=Ten, situation=Start_Hand_WithoutA_WithoutPair]=Hit -> Double

		 */
	}

}
