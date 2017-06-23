package org.shil.bjm.meta;

import java.util.HashMap;
import java.util.Map;

public class DeckSet {
	
	public static int OneSameCardInOneDeck = 4;
	public static int DeckCards = 52;
	
	private int ndeck;
	private int totalCards;
	private int totalOneSameCardsN;
	private Map<Card,Integer> cardsLeftNumberMap;
	
	private DeckSet(int ndeck){
		this.ndeck = ndeck;
		totalCards = ndeck * DeckCards;
		totalOneSameCardsN = ndeck * OneSameCardInOneDeck;
		cardsLeftNumberMap = new HashMap<Card, Integer>();
		for(Card card : Card.values()){
			cardsLeftNumberMap.put(card, totalOneSameCardsN);
		}
	}
	
	public void reset(){
		for(Card card : Card.values()){
			cardsLeftNumberMap.put(card, totalOneSameCardsN);
		}
	}
	
	public static DeckSet buildXDeckSet(int x){
		return new DeckSet(x);
	}
	
	public static DeckSet build6DeckSet(){
		return buildXDeckSet(6);
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
		return (double) 1000 * cardsLeftNumberMap.get(card) / totalCards;
	}
	
	public int getTotalOneSameCardsN() {
		return totalOneSameCardsN;
	}

	public static void main(String[] args){
		DeckSet decks = DeckSet.build6DeckSet();
		decks.usedCards(Card.Eight8, 2);
		System.out.println(decks.getOneCardProb(Card.Eight8));
		System.out.println((double)(4*6-2)/(52*6-2));
	}
}
