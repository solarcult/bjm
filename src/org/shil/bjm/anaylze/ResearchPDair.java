package org.shil.bjm.anaylze;

import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerCardsPathValue;

public class ResearchPDair implements Comparable<ResearchPDair>{

	private PlayerCardsPathValue playerCardsPathValue;
	
	private Card dealerCard;

	public ResearchPDair(PlayerCardsPathValue playerCardsPathValue,Card dealerCard){
		this.playerCardsPathValue = playerCardsPathValue;
		this.dealerCard = dealerCard;
	}
	
	public PlayerCardsPathValue getPlayerCardsPathValue() {
		return playerCardsPathValue;
	}

	public void setPlayerCardsPathValue(PlayerCardsPathValue playerCardsPathValue) {
		this.playerCardsPathValue = playerCardsPathValue;
	}

	public Card getDealerCard() {
		return dealerCard;
	}

	public void setDealerCard(Card dealerCard) {
		this.dealerCard = dealerCard;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dealerCard == null) ? 0 : dealerCard.hashCode());
		result = prime * result + ((playerCardsPathValue == null) ? 0 : playerCardsPathValue.hashCode());
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
		ResearchPDair other = (ResearchPDair) obj;
		if (dealerCard != other.dealerCard)
			return false;
		if (playerCardsPathValue == null) {
			if (other.playerCardsPathValue != null)
				return false;
		} else if (!playerCardsPathValue.equals(other.playerCardsPathValue))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ResearchPair [playerCardsPathValue=" + playerCardsPathValue + ", dealerCard=" + dealerCard + "]";
	}

	@Override
	public int compareTo(ResearchPDair o) {
		if(playerCardsPathValue.getValue() < o.getPlayerCardsPathValue().getValue()) {
			return -1;
		}else if(playerCardsPathValue.getValue() > o.getPlayerCardsPathValue().getValue()) {
			return 1;
		}else {
			if(dealerCard.getValue() < o.getDealerCard().getValue()) {
				return -1;
			}else if(dealerCard.getValue() > o.getDealerCard().getValue()) {
				return 1;
			}else {
				return 0;
			}
		}
	}
}
