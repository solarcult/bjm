package org.shil.bjm.core;

import java.util.Collection;
import java.util.Map;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.anaylze.AnalyzeStatus;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.DealerCardsPathValue;

/**
 * 预先计算庄家爱的所有牌组合
 * @author vanis
 *
 */
public class DealerCards {
	
	public static Collection<DealerCardsPathValue> StartOne = GenerateCardsUtil.generateDealerCards(new DealerCardsPathValue(Card.One1));
	public static Collection<DealerCardsPathValue> StartTwo = GenerateCardsUtil.generateDealerCards(new DealerCardsPathValue(Card.Two2));
	public static Collection<DealerCardsPathValue> StartThree = GenerateCardsUtil.generateDealerCards(new DealerCardsPathValue(Card.Three3));
	public static Collection<DealerCardsPathValue> StartFour = GenerateCardsUtil.generateDealerCards(new DealerCardsPathValue(Card.Four4));
	public static Collection<DealerCardsPathValue> StartFive = GenerateCardsUtil.generateDealerCards(new DealerCardsPathValue(Card.Five5));
	public static Collection<DealerCardsPathValue> StartSix = GenerateCardsUtil.generateDealerCards(new DealerCardsPathValue(Card.Six6));
	public static Collection<DealerCardsPathValue> StartSeven = GenerateCardsUtil.generateDealerCards(new DealerCardsPathValue(Card.Seven7));
	public static Collection<DealerCardsPathValue> StartEight = GenerateCardsUtil.generateDealerCards(new DealerCardsPathValue(Card.Eight8));
	public static Collection<DealerCardsPathValue> StartNine = GenerateCardsUtil.generateDealerCards(new DealerCardsPathValue(Card.Nine9));
	public static Collection<DealerCardsPathValue> StartTen = GenerateCardsUtil.generateDealerCards(new DealerCardsPathValue(Card.Ten));
	public static Collection<DealerCardsPathValue> StartJ = GenerateCardsUtil.generateDealerCards(new DealerCardsPathValue(Card.JJJ));
	public static Collection<DealerCardsPathValue> StartQ = GenerateCardsUtil.generateDealerCards(new DealerCardsPathValue(Card.QQQ));
	public static Collection<DealerCardsPathValue> StartK = GenerateCardsUtil.generateDealerCards(new DealerCardsPathValue(Card.KKK));
	
	public static Collection<DealerCardsPathValue> fetchDealerCards(Card card){
		switch(card){
			case One1:
				return StartOne;
			case Two2:
				return StartTwo;
			case Three3:
				return StartThree;
			case Four4:
				return StartFour;
			case Five5:
				return StartFive;
			case Six6:
				return StartSix;
			case Seven7:
				return StartSeven;
			case Eight8:
				return StartEight;
			case Nine9: 
				return StartNine;
			case Ten:
				return StartTen;
			case JJJ:
				return StartJ;
			case QQQ:
				return StartQ;
			case KKK:
				return StartK;
			default:
				return null;
		}
	}

	
	public static Map<Integer,AnalyzeStatus> analyzeDealerCardValuePrecent(Card card){
		return DealerCardsAnalyzeStatus.fetchDealerAnalyzeStatusMap(card);
	}
	
	public static void main(String[] args){
		
		System.out.println(StartOne.size());
		HelloWorld.print(DealerCards.StartOne);
		HelloWorld.printMap(analyzeDealerCardValuePrecent(Card.One1));
		System.out.println(StartTwo.size());
		HelloWorld.printMap(analyzeDealerCardValuePrecent(Card.Two2));
		System.out.println(StartThree.size());
		HelloWorld.printMap(analyzeDealerCardValuePrecent(Card.Three3));
		System.out.println(StartFour.size());
		HelloWorld.printMap(analyzeDealerCardValuePrecent(Card.Four4));
		System.out.println(StartFive.size());
		HelloWorld.printMap(analyzeDealerCardValuePrecent(Card.Five5));
		System.out.println(StartSix.size());
		HelloWorld.printMap(analyzeDealerCardValuePrecent(Card.Six6));
		System.out.println(StartSeven.size());
		HelloWorld.printMap(analyzeDealerCardValuePrecent(Card.Seven7));
		System.out.println(StartEight.size());
		HelloWorld.printMap(analyzeDealerCardValuePrecent(Card.Eight8));
		System.out.println(StartNine.size());
		HelloWorld.printMap(analyzeDealerCardValuePrecent(Card.Nine9));
		System.out.println(StartTen.size());
		HelloWorld.printMap(analyzeDealerCardValuePrecent(Card.Ten));
		System.out.println(StartJ.size());
		HelloWorld.printMap(analyzeDealerCardValuePrecent(Card.JJJ));
		System.out.println(StartQ.size());
		HelloWorld.printMap(analyzeDealerCardValuePrecent(Card.QQQ));
		System.out.println(StartK.size());
		HelloWorld.printMap(analyzeDealerCardValuePrecent(Card.KKK));
	}
	
}
