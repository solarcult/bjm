package org.shil.bjm.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.math3.stat.Frequency;
import org.shil.bjm.HelloWorld;
import org.shil.bjm.anaylze.AnalyzeCardsPathValue;
import org.shil.bjm.anaylze.AnalyzeStatus;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.DealerCardsPathValue;

/**
 * 预先计算庄家牌组合的分布
 * @author vanis
 *
 */
public class DealerCardsAnalyzeStatus {

	public static Map<Integer,AnalyzeStatus> ASMOne = AnalyzeCardsPathValue.analyzeDealerCardsPathValue(DealerCards.StartOne);
	public static Map<Integer,AnalyzeStatus> ASMTwo = AnalyzeCardsPathValue.analyzeDealerCardsPathValue(DealerCards.StartTwo);
	public static Map<Integer,AnalyzeStatus> ASMThree = AnalyzeCardsPathValue.analyzeDealerCardsPathValue(DealerCards.StartThree);
	public static Map<Integer,AnalyzeStatus> ASMFour = AnalyzeCardsPathValue.analyzeDealerCardsPathValue(DealerCards.StartFour);
	public static Map<Integer,AnalyzeStatus> ASMFive = AnalyzeCardsPathValue.analyzeDealerCardsPathValue(DealerCards.StartFive);
	public static Map<Integer,AnalyzeStatus> ASMSix = AnalyzeCardsPathValue.analyzeDealerCardsPathValue(DealerCards.StartSix);
	public static Map<Integer,AnalyzeStatus> ASMSeven = AnalyzeCardsPathValue.analyzeDealerCardsPathValue(DealerCards.StartSeven);
	public static Map<Integer,AnalyzeStatus> ASMEight = AnalyzeCardsPathValue.analyzeDealerCardsPathValue(DealerCards.StartEight);
	public static Map<Integer,AnalyzeStatus> ASMNine = AnalyzeCardsPathValue.analyzeDealerCardsPathValue(DealerCards.StartNine);
	public static Map<Integer,AnalyzeStatus> ASMTen = AnalyzeCardsPathValue.analyzeDealerCardsPathValue(DealerCards.StartTen);
	public static Map<Integer,AnalyzeStatus> ASMJ = AnalyzeCardsPathValue.analyzeDealerCardsPathValue(DealerCards.StartJ);
	public static Map<Integer,AnalyzeStatus> ASMQ = AnalyzeCardsPathValue.analyzeDealerCardsPathValue(DealerCards.StartQ);
	public static Map<Integer,AnalyzeStatus> ASMK = AnalyzeCardsPathValue.analyzeDealerCardsPathValue(DealerCards.StartK);
	
	public static boolean refreshDeck = false;
	public static Map<Integer,AnalyzeStatus> fetchDealerAnalyzeStatusMap(Card card){
		switch(card){
			case One1:
				if(refreshDeck) {
					return AnalyzeCardsPathValue.analyzeDealerCardsPathValue(DealerCards.StartOne);
				}else {
					return ASMOne;
				}
			case Two2:
				if(refreshDeck) {
					return AnalyzeCardsPathValue.analyzeDealerCardsPathValue(DealerCards.StartTwo);
				}else {
					return ASMTwo;
				}
			case Three3:
				if(refreshDeck) {
					return AnalyzeCardsPathValue.analyzeDealerCardsPathValue(DealerCards.StartThree);
				}else {
					return ASMThree;
				}
			case Four4:
				if(refreshDeck) {
					return AnalyzeCardsPathValue.analyzeDealerCardsPathValue(DealerCards.StartFour);
				}else {
					return ASMFour;
				}
			case Five5:
				if(refreshDeck) {
					return AnalyzeCardsPathValue.analyzeDealerCardsPathValue(DealerCards.StartFive);
				}else {
					return ASMFive;
				}
			case Six6:
				if(refreshDeck) {
					return AnalyzeCardsPathValue.analyzeDealerCardsPathValue(DealerCards.StartSix);
				}else {
					return ASMSix;
				}
			case Seven7:
				if(refreshDeck) {
					return AnalyzeCardsPathValue.analyzeDealerCardsPathValue(DealerCards.StartSeven);
				}else {
					return ASMSeven;
				}
			case Eight8:
				if(refreshDeck) {
					return AnalyzeCardsPathValue.analyzeDealerCardsPathValue(DealerCards.StartEight);
				}else {
					return ASMEight;
				}
			case Nine9: 
				if(refreshDeck) {
					return AnalyzeCardsPathValue.analyzeDealerCardsPathValue(DealerCards.StartNine);
				}else {
					return ASMNine;
				}
			case Ten:
				if(refreshDeck) {
					return AnalyzeCardsPathValue.analyzeDealerCardsPathValue(DealerCards.StartTen);
				}else {
					return ASMTen;
				}
			case JJJ:
				if(refreshDeck) {
					return AnalyzeCardsPathValue.analyzeDealerCardsPathValue(DealerCards.StartJ);
				}else {
					return ASMJ;
				}
			case QQQ:
				if(refreshDeck) {
					return AnalyzeCardsPathValue.analyzeDealerCardsPathValue(DealerCards.StartQ);
				}else {
					return ASMQ;
				}
			case KKK:
				if(refreshDeck) {
					return AnalyzeCardsPathValue.analyzeDealerCardsPathValue(DealerCards.StartK);
				}else {
					return ASMK;
				}
			default:
				return null;
		}
	}
	
	public static void analyzeTimes(Card dealerCard) {
		System.out.println(dealerCard.getValue());
		Map<Integer, Integer>  m = new HashMap<>();
		Frequency frequency = new Frequency();
		Collection<DealerCardsPathValue> dealers = DealerCards.fetchDealerCards(dealerCard);
		for(DealerCardsPathValue dealerCardsPathValue : dealers) {
			frequency.addValue(dealerCardsPathValue.getValue());
			Integer v = m.get(dealerCardsPathValue.getValue());
			if(v==null) {
				m.putIfAbsent(dealerCardsPathValue.getValue(), 1);
			}else {
				v++;
				m.put(dealerCardsPathValue.getValue(), v);
			}
			if(dealerCardsPathValue.getValue()==26) {
//				System.out.println(dealerCardsPathValue);
			}
		}
		System.out.println(frequency);
		HelloWorld.printMap(m);
		System.out.println();
	}
	
	public static void main(String[] args) {
		
//		analyzeTimes(Card.Seven7);
		/** 庄家如果是7,则它不爆牌的胜率竟然是42%,大部分时间都爆牌,此刻我们什么牌都不应该要啊.
		 * 这是根据次数来计算的结果,如果根据概率,则不是这样说的.
		 * 好奇怪,要仔细考虑.综合两者来分析吗?
Value 	 Freq. 	 Pct. 	 Cum Pct. 
17	163	8%	8%
18	160	8%	17%
19	162	8%	25%
20	162	8%	34%
21	164	9%	42%
22	170	9%	51%
23	180	9%	60%
24	200	10%	71%
25	240	12%	83%
26	320	17%	100%
		 */
		analyzeTimes(Card.One1);
		HelloWorld.printMap(AnalyzeCardsPathValue.analyzeDealerCardsPathValue(DealerCards.StartOne));
//		analyzeTimes(Card.Six6);
//		analyzeTimes(Card.Five5);
//		double daProb = 0;
//		for(Entry<Integer, AnalyzeStatus> e : ASMNine.entrySet()) {
//			daProb += e.getValue().getProb();
//		}
//		System.out.println(daProb);
	}
}
