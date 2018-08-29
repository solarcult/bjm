package org.shil.bjm.strategy8102;

import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.StartValue;

public class MatrixKey {
	private StartValue startValue;
	private Card dealerCard;
	private Situation situation;
	
	public MatrixKey(StartValue startValue,Card dealerCard,Situation situation) {
		this.startValue = startValue;
		this.dealerCard = dealerCard;
		this.situation = situation;
	}
	
	public StartValue getStartValue() {
		return startValue;
	}
	public void setStartValue(StartValue startValue) {
		this.startValue = startValue;
	}
	public Card getDealerCard() {
		return dealerCard;
	}
	public void setDealerCard(Card dealerCard) {
		this.dealerCard = dealerCard;
	}
	public Situation getSituation() {
		return situation;
	}
	public void setSituation(Situation situation) {
		this.situation = situation;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dealerCard == null) ? 0 : dealerCard.hashCode());
		result = prime * result + ((situation == null) ? 0 : situation.hashCode());
		result = prime * result + ((startValue == null) ? 0 : startValue.hashCode());
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
		MatrixKey other = (MatrixKey) obj;
		if (dealerCard != other.dealerCard)
			return false;
		if (situation != other.situation)
			return false;
		if (startValue != other.startValue)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MatrixKey [startValue=" + startValue + ", dealerCard=" + dealerCard + ", situation=" + situation + "]";
	}
	
}
