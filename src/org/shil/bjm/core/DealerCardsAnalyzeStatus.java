package org.shil.bjm.core;

import java.util.Map;
import java.util.Map.Entry;

import org.shil.bjm.anaylze.AnalyzeCardsPathValue;
import org.shil.bjm.anaylze.AnalyzeStatus;
import org.shil.bjm.meta.Card;

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
	
	public static void main(String[] args) {
		double daProb = 0;
		for(Entry<Integer, AnalyzeStatus> e : ASMNine.entrySet()) {
			daProb += e.getValue().getProb();
		}
		System.out.println(daProb);
	}
}
