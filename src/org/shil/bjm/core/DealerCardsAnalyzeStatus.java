package org.shil.bjm.core;

import java.util.Map;

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
	
	public static Map<Integer,AnalyzeStatus> fetchDealerAnalyzeStatusMap(Card card){
		switch(card){
			case One1:
				return ASMOne;
			case Two2:
				return ASMTwo;
			case Three3:
				return ASMThree;
			case Four4:
				return ASMFour;
			case Five5:
				return ASMFive;
			case Six6:
				return ASMSix;
			case Seven7:
				return ASMSeven;
			case Eight8:
				return ASMEight;
			case Nine9: 
				return ASMNine;
			case Ten:
				return ASMTen;
			case JJJ:
				return ASMJ;
			case QQQ:
				return ASMQ;
			case KKK:
				return ASMK;
			default:
				return null;
		}
	}
}
