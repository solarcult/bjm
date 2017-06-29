package org.shil.bjm.meta;

import java.util.HashMap;
import java.util.Map;

public class DeckSet {
	
	public static int CasionDeckNumber = 6;
	
	public static int OneSameCardInOneDeck = 4;
	public static int DeckCards = 52;
	
	private int ndeck;
	private int totalCards;
	private int totalOneSameCardsN;
	private Map<Card,Integer> cardsLeftNumberMap;
	
	private DeckSet(int ndeck){
		this.ndeck = ndeck;
		
		totalOneSameCardsN = ndeck * OneSameCardInOneDeck;
		cardsLeftNumberMap = new HashMap<Card, Integer>();
		/*
		totalCards = ndeck * DeckCards;
		for(Card card : Card.values()){
			cardsLeftNumberMap.put(card, totalOneSameCardsN);
		}
		*/
		reset();
	}
	
	public void reset(){
		totalCards = ndeck * DeckCards;
		for(Card card : Card.values()){
			cardsLeftNumberMap.put(card, totalOneSameCardsN);
		}
//		used15SmallCard();
//		used15BigCard();
	}
	
	private static int usedtime = 1;
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
	
	public static DeckSet buildXDeckSet(int x){
		return new DeckSet(x);
	}
	
	public static DeckSet build6DeckSet(){
		return buildXDeckSet(6);
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

	public static void main(String[] args){
		DeckSet decks = DeckSet.buildCasionDeckSet();
		decks.usedCards(Card.Eight8, 2);
		System.out.println(decks.getOneCardProb(Card.Eight8));
		System.out.println((double)(4*6-2)/(52*6-2));
	}
}
