package org.shil.bjm.anaylze;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.core.DealerCards;
import org.shil.bjm.core.DealerCardsAnalyzeStatus;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.CardsPathValue;
import org.shil.bjm.meta.DealerCardsPathValue;
import org.shil.bjm.meta.PlayerCardsPathValue;

/**
 * 分析牌s分布情况的类
 * @author vanis
 *
 */
public class AnalyzeCardsPathValue {
	
	public static Map<Integer,AnalyzeStatus> analyzeDealerCardsPathValue(Collection<DealerCardsPathValue> dealerCardsPathValues){
		return analyzeCardsPathValue(new ArrayList<CardsPathValue>(dealerCardsPathValues));
	}
	
	public static Map<Integer,AnalyzeStatus> analyzePlayerCardsPathValue(Collection<PlayerCardsPathValue> playerCardsPathValues){
		return analyzeCardsPathValue(new ArrayList<CardsPathValue>(playerCardsPathValues));
	}
	
	public static Map<Integer,AnalyzeStatus> analyzeCardsPathValue(Collection<CardsPathValue> cardsPathValues){
		double totalProb = 0;
		Map<Integer,AnalyzeStatus> valueMap = new TreeMap<>();
		for(CardsPathValue cpv : cardsPathValues){
			totalProb += cpv.prob();
			AnalyzeStatus as = valueMap.getOrDefault(cpv.getValue(), new AnalyzeStatus(cpv.getValue(),0d,0d,0d,0d,0d));
			as.setProb(as.getProb()+cpv.prob());
			valueMap.put(cpv.getValue(), as);
		}
		
		double totalPct = 0d;
		double tillProb = 0d;
		for(Entry<Integer, AnalyzeStatus> e : valueMap.entrySet()){
			AnalyzeStatus as = e.getValue();
			tillProb += as.getProb();
			as.setTillProb(tillProb);
			as.setPrecent(as.getProb()/totalProb);
			totalPct+=as.getPrecent();
			as.setTillPct(totalPct);
			as.setTotalProb(totalProb);
		}
		
		return valueMap;
	}

	/**
	 * 按次数分析,次数和概率的不同,是因为有些小概率组合多,但现实中,是按照概率prob来出现的,所以这个类没啥用,就是看一下差距
	 * @param dealerCardsPathValues
	 * @return
	 */
	public static Map<Integer,AnalyzeStatus> analyzeDealerCardsPathValueTimes(Collection<DealerCardsPathValue> dealerCardsPathValues){
		return analyzeCardsPathValueTimes(new ArrayList<CardsPathValue>(dealerCardsPathValues));
	}
	public static Map<Integer,AnalyzeStatus> analyzeCardsPathValueTimes(Collection<CardsPathValue> cardsPathValues){
		double totalProb = 0;
		Map<Integer,AnalyzeStatus> valueMap = new TreeMap<>();
		for(CardsPathValue cpv : cardsPathValues){
			totalProb += 1;
			AnalyzeStatus as = valueMap.getOrDefault(cpv.getValue(), new AnalyzeStatus(cpv.getValue(),0d,0d,0d,0d,0d));
			as.setProb(as.getProb()+1);
			valueMap.put(cpv.getValue(), as);
		}

		double totalPct = 0d;
		double tillProb = 0d;
		for(Entry<Integer, AnalyzeStatus> e : valueMap.entrySet()){
			AnalyzeStatus as = e.getValue();
			tillProb += as.getProb();
			as.setTillProb(tillProb);
			as.setPrecent(as.getProb()/totalProb);
			totalPct+=as.getPrecent();
			as.setTillPct(totalPct);
			as.setTotalProb(totalProb);
		}

		return valueMap;
	}

	public static void main(String[] args){
		HelloWorld.printMap(AnalyzeCardsPathValue.analyzeDealerCardsPathValue(DealerCards.StartSeven));
		System.out.println();
		HelloWorld.printMap(AnalyzeCardsPathValue.analyzeDealerCardsPathValueTimes(DealerCards.StartSeven));
	}
}
