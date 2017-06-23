package org.shil.bjm.anaylze;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.meta.Card;

public class DealerVSPlayerChance{

	private Card dealerCard;
	private int playerStartValue;
	private double[] origin;
	private double[] advanced;
	
	public DealerVSPlayerChance(Card dealerCard,int playerStartValue,double[] origin, double[] advanced){
		this.dealerCard = dealerCard;
		this.playerStartValue = playerStartValue;
		this.origin = origin;
		this.advanced = advanced;
	}

	@Override
	public String toString() {
		return "\nDealerVSPlayerChance [ \tdealerCard="
				+ dealerCard + ", \tplayerStartValue=" + playerStartValue +"\t"
				+ HelloWorld.builder2DoubleWDL(advanced, origin);
	}
}