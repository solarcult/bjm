package org.shil.bjm.meta;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ProbUtil {

	public static DeckSet IN_USED_DECKSET = DeckSet.build6DeckSet();
	
	//计算出现这副牌组合的概率
	public static double calcProb(List<Card> cards){
		double prob = 1, usedcard = 0;
		Map<Card,Integer> cardsMap = convertList2Map(cards);
		for(Entry<Card,Integer> entry : cardsMap.entrySet()){
			for(int i=0;i<entry.getValue();i++){
				prob *= (double) (IN_USED_DECKSET.getTotalOneSameCardsN()-i)/(IN_USED_DECKSET.getTotalCards()-usedcard);
				usedcard++;
			}
		}
		return prob;
	}
	
	//将cards映射成map
	public static Map<Card,Integer> convertList2Map(List<Card> cards){
		Map<Card,Integer> cardsMap = new HashMap<Card, Integer>();
		for(Card card : cards){
			Integer count = cardsMap.getOrDefault(card,0);
			cardsMap.put(card, ++count);
		}
		return cardsMap;
	}
	
	public static void main(String[] args){
		DealerCardsPathValue cardsPathValue = new DealerCardsPathValue(Card.One1);
		cardsPathValue.addCard(Card.One1);
		cardsPathValue.addCard(Card.Eight8);
		
		DealerCardsPathValue cardsPathValue2 = new DealerCardsPathValue(Card.One1);
		cardsPathValue2.addCard(Card.One1);
		cardsPathValue2.addCard(Card.Eight8);
		
		DealerCardsPathValue cardsPathValue3 = new DealerCardsPathValue(Card.One1);
		cardsPathValue3.addCard(Card.Eight8);
		cardsPathValue3.addCard(Card.One1);
		
		Collection<DealerCardsPathValue> a = new HashSet<DealerCardsPathValue>();
		a.add(cardsPathValue);
		a.add(cardsPathValue2);
		a.add(cardsPathValue3);
		System.out.println(a.size());
		System.out.println(cardsPathValue.equals(cardsPathValue2));
		System.out.println(cardsPathValue.hashCode());
		System.out.println(cardsPathValue2.hashCode());
		System.out.println(cardsPathValue3.hashCode());

		
		System.out.println(calcProb(cardsPathValue.getCards()));
		System.out.println(calcProb(cardsPathValue2.getCards()));
		System.out.println(calcProb(cardsPathValue3.getCards()));
		
	}
	
}
