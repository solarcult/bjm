package org.shil.bjm.meta;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class CardsPathValue {
	private List<Card> cards;
	
	public CardsPathValue(Card ... _cards){
		cards = new ArrayList<Card>();
		for(Card card : _cards){
			addCard(card);
		}
	}
	
	public CardsPathValue(CardsPathValue cardsPathValue){
		cards = new ArrayList<Card>(cardsPathValue.getCards());
	}
	
	public void addCard(Card card){
		cards.add(card);
	}
	
	public int getValue(){
		int value = 0;
		for(Card card : this.getCards()){
			value += card.getValue();
		}
		
		if(value < BlackJackInfo.BlackJack){
			if(cards.contains(Card.One1)){
				int enhanceV = value + 10;
				if(enhanceV <= BlackJackInfo.BlackJack){
					return enhanceV;
				}
			}
		}
		return value;
	}
	
	public List<Card> getCards(){
		return cards;
	}

	public Map<Card,Integer> getCardsMap(){
		return ProbUtil.convertList2Map(cards);
	}

	public double prob(){
		return ProbUtil.calcProb(cards);
	}
	
	public boolean outOfCards(){
		boolean outOfCards = false;
		Map<Card,Integer> cardsMap = getCardsMap();
		for(Integer cards : cardsMap.values()){
			if(cards > ProbUtil.IN_USED_DECKSET.getTotalOneSameCardsN()){
				outOfCards = true;
				System.out.println("this is it, out of cards: "+ cards);
				break;
			}
		}
		return outOfCards;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cards == null) ? 0 : cards.hashCode());
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
		CardsPathValue other = (CardsPathValue) obj;
		if (cards == null) {
			if (other.cards != null)
				return false;
		} else if (!cards.equals(other.cards))
			return false;
		return true;
	}
	
}
