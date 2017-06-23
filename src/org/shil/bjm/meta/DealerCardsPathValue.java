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
	
	/**
	 * if A represent 11, reach 17 must stop
	 * @return
	 */
	@Override
	public boolean isAbe11Stop(){
		//规定,庄家如果�?17点必须停�?,�?以当A�?11�?,庄家必须停止.
		boolean isAbe11Stop = false;
		int tempValue = 0;
		for(Card card : this.getCards()){
			tempValue += card.getValue();
		}
		
		//check if One1 become 11 ,if reach the DealerStop ,if yes, should ignore because we have A is Eleven version. 
		if(this.getCards().contains(Card.One1)){
			tempValue += 10;
			if(tempValue >= BlackJackInfo.DealerStop && tempValue <= BlackJackInfo.BlackJack){
				isAbe11Stop = true;
			}
		}
			
		return isAbe11Stop;
	}

	@Override
	public String toString() {
		return "DealerCardsPathValue [isAbe11Continue()=" + isAbe11Stop() + ", getCards()=" + getCards()
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
}
