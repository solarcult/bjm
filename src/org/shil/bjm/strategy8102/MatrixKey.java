package org.shil.bjm.strategy8102;

import java.util.HashMap;
import java.util.Map;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerAction;
import org.shil.bjm.meta.StartValue;

public class MatrixKey implements Comparable<MatrixKey>{
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

	@Override
	public int compareTo(MatrixKey o) {
		if(this.startValue.getValue() < o.startValue.getValue()) 
			return -1;
		else if(this.startValue.getValue() > o.startValue.getValue()){
			return 1;
		}
		else{
			if(this.dealerCard.getValue() < o.dealerCard.getValue())
				return -1;
			else if(this.dealerCard.getValue() > o.dealerCard.getValue())
				return 1;
			return 0;
		}
	}
	
	public static void main(String[] args) {
		MatrixKey a = new MatrixKey(StartValue.getOne(8), Card.Four4, Situation.Start_Hand_WithoutA_WithoutPair);
		MatrixKey b = new MatrixKey(StartValue.getOne(8), Card.Four4, Situation.Three_More_Cards);
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		System.out.println(a.equals(b));
		
		Map<MatrixKey,PlayerAction> m = new HashMap<>(); // TreeMap<>();
		
		for(int start = 3; start <= 8 ; start++) {
			for(Card dealerCard : Card.values()) {
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				m.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
			}
		}
		System.out.println(m.size());
		
		for(int start = 3; start <= 8 ; start++) {
			for(Card dealerCard : Card.values()) {
				MatrixKey three_More_Cards = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Three_More_Cards);
				m.put(three_More_Cards, PlayerAction.Hit);
			}
		}
		System.out.println(m.size());
		
		HelloWorld.printMap(m);
		
		System.out.println(Math.pow(3, 240));
	}
}
