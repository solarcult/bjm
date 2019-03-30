package org.shil.bjm.meta;

import java.util.HashMap;
import java.util.Map;

public class DeckSet {
	
	public static int CasionDeckNumber = 6;
	
	public static int OneSameCardInOneDeck = 4;
	public static int DeckCards = 52;
	
	/**
	 * 很重要,用完一定要复位,变成0,对概率影响很大.
	 */
	public static int resetValue = 0;
	
	private int ndeck;
	private int totalCards;
	private int totalOneSameCardsN;
	private Map<Card,Integer> cardsLeftNumberMap;
	
	private DeckSet(int ndeck){
		this.ndeck = ndeck;
		
		totalOneSameCardsN = ndeck * OneSameCardInOneDeck;
		cardsLeftNumberMap = new HashMap<Card, Integer>();
		reset();
	}
	
	/**
	 * 重新设置牌的使用情况，可根据具体情况来设置
	 */
	public void reset(){
		totalCards = ndeck * DeckCards;
		for(Card card : Card.values()){
			cardsLeftNumberMap.put(card, totalOneSameCardsN);
		}
		
		switch(resetValue) {
		case -10:
			usedCards(Card.Ten,1);
			usedCards(Card.JJJ,1);
			usedCards(Card.QQQ,1);
			usedCards(Card.KKK,1);
			usedCards(Card.One1,1);
			usedCards(Card.Ten,1);
			usedCards(Card.JJJ,1);
			usedCards(Card.QQQ,1);
			usedCards(Card.KKK,1);
			usedCards(Card.One1,1);
			break;
		case -9:
			usedCards(Card.Ten,1);
			usedCards(Card.JJJ,1);
			usedCards(Card.QQQ,1);
			usedCards(Card.KKK,1);
			usedCards(Card.One1,1);
			usedCards(Card.Ten,1);
			usedCards(Card.QQQ,1);
			usedCards(Card.KKK,1);
			usedCards(Card.One1,1);
			break;
		case -8:
			usedCards(Card.Ten,1);
			usedCards(Card.JJJ,1);
			usedCards(Card.QQQ,1);
			usedCards(Card.KKK,1);
			usedCards(Card.One1,1);
			usedCards(Card.Ten,1);
			usedCards(Card.KKK,1);
			usedCards(Card.One1,1);
			break;
		case -7:
			usedCards(Card.Ten,1);
			usedCards(Card.JJJ,1);
			usedCards(Card.QQQ,1);
			usedCards(Card.KKK,1);
			usedCards(Card.One1,1);
			usedCards(Card.Ten,1);
			usedCards(Card.KKK,1);
			break;
		case -6:
			usedCards(Card.Ten,1);
			usedCards(Card.JJJ,1);
			usedCards(Card.QQQ,1);
			usedCards(Card.KKK,1);
			usedCards(Card.One1,1);
			usedCards(Card.Ten,1);
			break;
		case -5:
			usedCards(Card.Ten,1);
			usedCards(Card.JJJ,1);
			usedCards(Card.QQQ,1);
			usedCards(Card.KKK,1);
			usedCards(Card.One1,1);
			break;
		case -4:
			usedCards(Card.Ten,1);
			usedCards(Card.JJJ,1);
			usedCards(Card.KKK,1);
			usedCards(Card.One1,1);
			break;
		case -3:
			usedCards(Card.Ten,1);
			usedCards(Card.JJJ,1);
			usedCards(Card.One1,1);
			break;
		case -2:
			usedCards(Card.Ten,1);
			usedCards(Card.JJJ,1);
			break;
		case -1:
			usedCards(Card.Ten,1);
			break;
		case 0:
			break;
		case 1:
			usedCards(Card.Four4,1);
			break;
		case 2:
			usedCards(Card.Three3,1);
			usedCards(Card.Five5,1);
			break;
		case 3:
			usedCards(Card.Three3,1);
			usedCards(Card.Four4,1);
			usedCards(Card.Five5,1);
			break;
		case 4:
			usedCards(Card.Two2,1);
			usedCards(Card.Three3,1);
			usedCards(Card.Five5,1);
			usedCards(Card.Six6,1);
			break;
		case 5:
			usedCards(Card.Two2,1);
			usedCards(Card.Three3,1);
			usedCards(Card.Four4,1);
			usedCards(Card.Five5,1);
			usedCards(Card.Six6,1);
			break;
		case 6:
			usedCards(Card.Two2,1);
			usedCards(Card.Three3,1);
			usedCards(Card.Four4,1);
			usedCards(Card.Five5,1);
			usedCards(Card.Six6,1);
			usedCards(Card.Four4,1);
			break;
		case 7:
			usedCards(Card.Two2,1);
			usedCards(Card.Three3,1);
			usedCards(Card.Four4,1);
			usedCards(Card.Five5,1);
			usedCards(Card.Six6,1);
			usedCards(Card.Three3,1);
			usedCards(Card.Five5,1);
			break;
		case 8:
			usedCards(Card.Two2,1);
			usedCards(Card.Three3,1);
			usedCards(Card.Four4,1);
			usedCards(Card.Five5,1);
			usedCards(Card.Six6,1);
			usedCards(Card.Two2,1);
			usedCards(Card.Four4,1);
			usedCards(Card.Six6,1);
			break;
		case 9:
			usedCards(Card.Two2,1);
			usedCards(Card.Three3,1);
			usedCards(Card.Four4,1);
			usedCards(Card.Five5,1);
			usedCards(Card.Six6,1);
			usedCards(Card.Two2,1);
			usedCards(Card.Three3,1);
			usedCards(Card.Five5,1);
			usedCards(Card.Six6,1);
			break;
		case 10:
			usedCards(Card.Two2,1);
			usedCards(Card.Three3,1);
			usedCards(Card.Four4,1);
			usedCards(Card.Five5,1);
			usedCards(Card.Six6,1);
			usedCards(Card.Two2,1);
			usedCards(Card.Three3,1);
			usedCards(Card.Four4,1);
			usedCards(Card.Five5,1);
			usedCards(Card.Six6,1);
			break;
		default:
			break;
		}
		
		//for test situation
		
//		used15SmallCard();
//		usedCards(Card.Three3,usedtime);
//		usedCards(Card.Four4,usedtime);
//		usedCards(Card.Five5,usedtime);
		
//		used15BigCard();
//		usedCards(Card.Ten,usedtime);
//		usedCards(Card.JJJ,usedtime);
//		usedCards(Card.QQQ,usedtime);
//		usedCards(Card.KKK,usedtime);
	}
	
	private static int usedtime =1;
	private void used15SmallCard(){
		usedCards(Card.Two2,usedtime);
		usedCards(Card.Three3,usedtime);
		usedCards(Card.Four4,usedtime);
		usedCards(Card.Five5,usedtime);
		usedCards(Card.Six6,usedtime);
	}
	
	private void used15BigCard(){
		usedCards(Card.Ten,usedtime);
		usedCards(Card.JJJ,usedtime);
		usedCards(Card.QQQ,usedtime);
		usedCards(Card.KKK,usedtime);
		usedCards(Card.One1,usedtime);
	}
	
	private static DeckSet buildXDeckSet(int x){
		return new DeckSet(x);
	}
	
	public static DeckSet buildCasionDeckSet(){
		return buildXDeckSet(CasionDeckNumber);
	}

	public int getNdeck() {
		return ndeck;
	}

	public int getTotalCards() {
		return totalCards;
	}

	public Map<Card, Integer> getCardsLeftNumberMap() {
		return cardsLeftNumberMap;
	}
	
	public void usedCards(Card card,int times){
		int leftCardNumber = this.cardsLeftNumberMap.get(card) - times;
		if(leftCardNumber < 0) throw new RuntimeException(card +" Out of Cards in Decks");
		this.cardsLeftNumberMap.put(card, leftCardNumber);
		totalCards -= times;
	}
	
	public double getOneCardProb(Card card){
		return (double) cardsLeftNumberMap.get(card) / totalCards;
	}
	
	public int getTotalOneSameCardsN() {
		return totalOneSameCardsN;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardsLeftNumberMap == null) ? 0 : cardsLeftNumberMap.hashCode());
		result = prime * result + ndeck;
		result = prime * result + totalCards;
		result = prime * result + totalOneSameCardsN;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeckSet other = (DeckSet) obj;
		if (cardsLeftNumberMap == null) {
			if (other.cardsLeftNumberMap != null)
				return false;
		} else if (!cardsLeftNumberMap.equals(other.cardsLeftNumberMap))
			return false;
		if (ndeck != other.ndeck)
			return false;
		if (totalCards != other.totalCards)
			return false;
		if (totalOneSameCardsN != other.totalOneSameCardsN)
			return false;
		return true;
	}
	
	

	@Override
	public String toString() {
		return "DeckSet [ndeck=" + ndeck + ", totalCards=" + totalCards + ", totalOneSameCardsN=" + totalOneSameCardsN
				+ ", cardsLeftNumberMap=" + cardsLeftNumberMap 
				+ ", resetValue=" + resetValue
				+ "]";
	}

	public static void main(String[] args){
		for(int i=-10;i<=10;i++) {
			DeckSet.resetValue = i;
			System.out.println(i);
			DeckSet decks = DeckSet.buildCasionDeckSet();
			decks.usedCards(Card.Three3, 5);
			System.out.println(decks.getOneCardProb(Card.Three3));
			System.out.println((double)(4*6-5)/(52*6-5));
			System.out.println();
		}
		
	}
}
