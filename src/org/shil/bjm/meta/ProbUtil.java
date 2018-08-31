package org.shil.bjm.meta;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * 核心类，计算概率工具 ，希望没有bug
 * @author vanis
 *
 */
public class ProbUtil {

	//only used for one cpu calculation
	public static DeckSet IN_USED_DECKSET = DeckSet.buildCasionDeckSet();
	
	/**
	 * 用默认牌数,计算出现这副牌组合的概率
	 * @param cards
	 * @return
	 */
	public static double calcProb(List<Card> cards){
		
		//for mutli cpu thread
		DeckSet IN_USED_DECKSET = DeckSet.buildCasionDeckSet();
		
		//这里重置是为了每次计算当作独立事件,其实也可以根据已经出现的牌来进行计算,但是现场可能没有机会输入,所以这里先重置
		IN_USED_DECKSET.reset();
		
		return calcProb(cards,IN_USED_DECKSET);
	}
	
	/**
	 * 用指定牌的数据,计算出现这副牌组合的概率. 一般用于实际实时计算,加入其他玩家消耗的牌的情况
	 * @param cards
	 * @param deckset
	 * @return
	 */
	public static double calcProb(List<Card> cards,DeckSet deckset){
		double prob = 1;
		for(Card card : cards){
			prob *= deckset.getOneCardProb(card);
			//每使用一张,消耗一张计数
			deckset.usedCards(card, 1);
		}
		return prob;
	}
	
	/**
	 * 使用默认牌数,计算出现这副牌组合的概率,场景是分牌时候的概率,第一张牌是分牌的牌
	 * @param cards
	 * @param splitTimes
	 * @return
	 */
	public static double calcProb(List<Card> cards,int splitTimes){
		
		//for mutli cpu thread
		DeckSet IN_USED_DECKSET = DeckSet.buildCasionDeckSet();
		
		IN_USED_DECKSET.reset();
		
		//分牌的牌,当作先消耗掉一张,因为PlayerCardsPathValue.setAction()中分牌时,会remove掉第一张.
		IN_USED_DECKSET.usedCards(cards.get(0),splitTimes);
		
		return calcProb(cards,IN_USED_DECKSET);
	}
	
	public static double calcProb(List<Card> cards,int splitTimes,DeckSet deckset){
		
		//分牌的牌,当作先消耗掉一张,因为PlayerCardsPathValue.setAction()中分牌时,会remove掉第一张.
		deckset.usedCards(cards.get(0),splitTimes);
		
		return calcProb(cards, deckset);
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
		
		cardsPathValue3.addCard(Card.Four4);
		cardsPathValue3.addCard(Card.Five5);
		cardsPathValue3.addCard(Card.Six6);
		cardsPathValue3.addCard(Card.JJJ);
		cardsPathValue3.addCard(Card.JJJ);
		cardsPathValue3.addCard(Card.JJJ);
		cardsPathValue3.addCard(Card.Six6);
		cardsPathValue3.addCard(Card.Seven7);
		
		System.out.println(cardsPathValue3.prob());
	}
	
}
