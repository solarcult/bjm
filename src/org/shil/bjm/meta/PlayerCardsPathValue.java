package org.shil.bjm.meta;

import java.util.Collection;
import java.util.HashSet;

public class PlayerCardsPathValue extends CardsPathValue{

	private PlayerAction action;
	private int betMutiV ;
	
	public PlayerCardsPathValue(Card ... _cards){
		super(_cards);
		if(_cards.length<2) throw new RuntimeException("PlayerCards Init should have 2 cards least");
		action = PlayerAction.Init;
		betMutiV = 1;
	}
	
	public PlayerCardsPathValue(PlayerCardsPathValue playerCardsPathValue){
		super(playerCardsPathValue);
		action = playerCardsPathValue.getAction();
		betMutiV = playerCardsPathValue.getBetMutiV();
	}

	public boolean isStartWithA(){
		if(this.getCards().get(0) == Card.One1){
			return true;
		}
		if(this.getCards().get(1) == Card.One1){
			return true;
		}
		return false;
	}
	
	public boolean isStartWithPairs(){
		return this.getCards().get(0) == this.getCards().get(1);
	}
	
	public StartValue getStartValue(){
		return StartValue.getOne(this.getCards().get(0).getValue() + this.getCards().get(1).getValue());
	}
	
	public PlayerAction getAction() {
		return action;
	}

	public void setAction(PlayerAction action) {
		this.action = action;
		if(action == PlayerAction.Double || action == PlayerAction.Split){
			this.betMutiV = 2 * betMutiV;
		}
	}

	public int getBetMutiV() {
		return betMutiV;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		result = prime * result + betMutiV;
		result = prime * result + ((getCards() == null) ? 0 : getCards().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerCardsPathValue other = (PlayerCardsPathValue) obj;
		if (action != other.action)
			return false;
		if (betMutiV != other.betMutiV)
			return false;
		if (getCards() == null) {
			if (other.getCards() != null)
				return false;
		} else if (!getCards().equals(other.getCards()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PlayerCardsPathValue [getStartValue()=" + getStartValue() + ", getCards()=" + getCards()
				+ ", getValue()=" + getValue() + ", prob()=" + prob() + ", outOfCards()=" + outOfCards() 
				+ ", action=" + action + ", betMutiV=" + betMutiV 
				+ ", isStartWithA()=" + isStartWithA() + ", isStartWithPairs()="
				+ isStartWithPairs() + "]";
	}
	
	public static void main(String[] args){
		PlayerCardsPathValue cardsPathValue = new PlayerCardsPathValue(Card.One1,Card.One1);
		cardsPathValue.addCard(Card.Eight8);
//		cardsPathValue.setAction(PlayerAction.Double);
//		cardsPathValue.setBetMutiV(2);
		
		PlayerCardsPathValue cardsPathValue2 = new PlayerCardsPathValue(Card.One1,Card.One1);
		cardsPathValue2.addCard(Card.Eight8);
		
		PlayerCardsPathValue cardsPathValue3 = new PlayerCardsPathValue(Card.One1,Card.Eight8);
		cardsPathValue3.addCard(Card.One1);
		
		Collection<PlayerCardsPathValue> a = new HashSet<PlayerCardsPathValue>();
		a.add(cardsPathValue);
		a.add(cardsPathValue2);
		a.add(cardsPathValue3);
		System.out.println(a.size());
		System.out.println(cardsPathValue.equals(cardsPathValue2));
		System.out.println(cardsPathValue.hashCode());
		System.out.println(cardsPathValue2.hashCode());
		System.out.println(cardsPathValue3.hashCode());
		
		System.out.println(cardsPathValue);
		System.out.println(cardsPathValue3);
	}
}
