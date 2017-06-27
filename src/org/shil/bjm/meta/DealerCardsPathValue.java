package org.shil.bjm.meta;

import java.util.Collection;
import java.util.HashSet;

public class DealerCardsPathValue extends CardsPathValue{
	
	public DealerCardsPathValue(Card card){
		super(card);
	}
	
	public DealerCardsPathValue(DealerCardsPathValue cardsPathValue){
		super(cardsPathValue);
	}
	
	@Override
	public String toString() {
		return "DealerCardsPathValue [getCards()=" + getCards()
				+ ", getValue()=" + getValue() + ", prob()=" + prob() + ", outOfCards()=" + outOfCards() + "]";
	}
	
	public static void main(String args){
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
	}

	@Override
	public double prob() {
		return ProbUtil.calcProb(getCards());
	}

	@Override
	public double prob(DeckSet deckset) {
		return ProbUtil.calcProb(getCards(),deckset);
	}
}
