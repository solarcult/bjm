package org.shil.bjm.strategy;

import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerAction;
import org.shil.bjm.meta.StartValue;

/**
 * 用户的策略,开始牌可以double或giveup或split,当摸了一张以后就没有机会这么做了
 * @author LiangJingJing
 * @date 2016年7月20日 上午12:49:21
 */
public class PlayerStrategy implements Comparable<PlayerStrategy>{


	private StartValue startValue;
	private Card dealercard;
	private PlayerAction startAction;
	private PlayerAction threeCardAction;
	//normally card is 1 , but double and splite is 2.
	private int betMutiV = 1;
	
	public PlayerStrategy(StartValue startValue,Card dealerCard,PlayerAction startAction,PlayerAction threeCardAction,int betMutiV){
		this.startValue = startValue;
		this.dealercard = dealerCard;
		this.startAction = startAction;
		this.threeCardAction = threeCardAction;
		this.betMutiV = betMutiV;
	}
	
	public PlayerStrategy(StartValue startValue,Card dealerCard,PlayerAction startAction,PlayerAction threeCardAction){
		this.startValue = startValue;
		this.dealercard = dealerCard;
		this.startAction = startAction;
		this.threeCardAction = threeCardAction;
	}
	
	protected PlayerStrategy(StartValue startValue,Card dealerCard){
		this.startValue = startValue;
		this.dealercard = dealerCard;
	}
	
	public static PlayerStrategy builderOne(StartValue startValue,Card dealerCard){
		return new PlayerStrategy(startValue, dealerCard);
	}

	public StartValue getStartValue() {
		return startValue;
	}

	public Card getDealercard() {
		return dealercard;
	}
	
	public int getBetMutiV() {
		return betMutiV;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dealercard == null) ? 0 : dealercard.hashCode());
		result = prime * result
				+ ((startValue == null) ? 0 : startValue.hashCode());
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
		PlayerStrategy other = (PlayerStrategy) obj;
		if (dealercard != other.dealercard)
			return false;
		if (startValue != other.startValue)
			return false;
		return true;
	}

	@Override
	public int compareTo(PlayerStrategy o) {
		if(this.startValue.getValue() < o.startValue.getValue()) 
			return -1;
		else if(this.startValue.getValue() > o.startValue.getValue()){
			return 1;
		}
		else{
			if(this.dealercard.getValue() < o.dealercard.getValue())
				return -1;
			else if(this.dealercard.getValue() > o.dealercard.getValue())
				return 1;
			return 0;
		}
	}

	public PlayerAction getStartAction() {
		return startAction;
	}

	public PlayerAction getThreeCardAction() {
		return threeCardAction;
	}

	@Override
	public String toString() {
		return "PlayerStrategy [startValue=" + startValue + ", dealercard="
				+ dealercard + ", startAction=" + startAction
				+ ", threeCardAction=" + threeCardAction + "]";
	}
	
}
