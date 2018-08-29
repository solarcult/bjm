package org.shil.bjm.strategy8102;

import java.util.List;

import org.shil.bjm.meta.BlackJackInfo;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.StartValue;

public class PlayerCardsNow {
	private List<Card> cards;

	public PlayerCardsNow(List<Card> cards) {
		if (cards.size() < 2)
			throw new RuntimeException("PlayerCardsNow Init should have 2 cards at least");
		this.cards = cards;
	}

	public boolean isStartWithA() {
		if (this.getCards().get(0) == Card.One1) {
			return true;
		}
		if (this.getCards().get(1) == Card.One1) {
			return true;
		}
		return false;
	}
	
	public Card findFirstTwoCardsWithOutA(){
		Card withoutA = null;
		
		if(getCards().get(0).equals(Card.One1)){
			withoutA = getCards().get(1);
		}else if(getCards().get(1).equals(Card.One1)){
			withoutA = getCards().get(0);
		}else{
			throw new RuntimeException("this could not happend with A , no A in first two cards");
		}
		
		return withoutA;
	}

	public boolean isStartWithPairs() {
		return this.getCards().get(0) == this.getCards().get(1);
	}
	
	public Card findPairCardFromFirstTwoCards() {
		return this.getCards().get(0);
	}

	public boolean isStartTwoCards() {
		return this.getCards().size() == 2;
	}

	public List<Card> getCards() {
		return cards;
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
	
	public StartValue getAnaylzeValue() {
		if(isStartTwoCards()) {
			if(isStartWithA()) {
				return StartValue.getOne(findFirstTwoCardsWithOutA().getValue());
			}
			if(isStartWithPairs()) {
				return StartValue.getOne(findPairCardFromFirstTwoCards().getValue());
			}
		}
		
		return StartValue.getOne(getValue());
	}
	
}
