package org.shil.bjm.simulation;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.DeckSet;

public class Casion6Deck {
	
	public static Card[] casion6Deck = new Card[DeckSet.CasionDeckNumber*DeckSet.DeckCards];
	static {
		int p = 0;
		for(int i= 0 ;i < DeckSet.CasionDeckNumber * 4;i++) {
			for(Card o : Card.values()) {
				casion6Deck[p++] = o;
			}
		}
	}
	
	private Set<Integer> thisTurn;
	private Set<Integer> lastTurn;
	
	protected Casion6Deck() {
		thisTurn = new HashSet<>();
		lastTurn = new HashSet<>();
	}
	
	public static Casion6Deck buildCasion6Deck() {
		return new Casion6Deck();
	}
	
	public Card fetchOne() {
		Card card = null;
		
		int showup = randomPosition();
		while(this.thisTurn.contains(showup)||this.lastTurn.contains(showup)) {
			showup = randomPosition();
			if((thisTurn.size()+lastTurn.size())==casion6Deck.length) {
				return null;
			}
		}

		this.thisTurn.add(showup);
		card = casion6Deck[showup];
		return card;
	}
	
	protected int randomPosition() {
		SecureRandom sr = null;
		try {
			sr =SecureRandom.getInstanceStrong();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return sr.nextInt(casion6Deck.length);
	}
	
	public void resetButKeepLastTurnUsed() {
		this.lastTurn = this.thisTurn;
		this.thisTurn = new HashSet<>();
		
	}
	
	public int getCount() {
		int count = 0;
		for(int pos : this.lastTurn) {
			int c = casion6Deck[pos].getValue();
			if(c>=2&&c<=6) count++;
			if(c==1||c==10) count--;
		}
		for(int pos : this.thisTurn) {
			int c = casion6Deck[pos].getValue();
			if(c>=2&&c<=6) count++;
			if(c==1||c==10) count--;
		}
		return count;
	}

	public static void main(String[] args) {
		Casion6Deck cd = new Casion6Deck();

		for(int i=0;i<=casion6Deck.length;i++) {
			System.out.println(cd.fetchOne());
		}
	}

}
