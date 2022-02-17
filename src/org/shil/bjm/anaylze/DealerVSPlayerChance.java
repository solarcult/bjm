package org.shil.bjm.anaylze;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.meta.Card;

/**
 * 记录庄家牌与玩家起始牌 当前的概率org和再来一张的概率adv
 * @author vanis
 *
 */
public class DealerVSPlayerChance implements Comparable<DealerVSPlayerChance>{

	private Card dealerCard;
	private int playerStartValue;
	private double[] origin;
	private double[] advanced;
	
	public static double Double_Limit = 0.0905;
	public static double Surrender_Limit = -0.454;
	public static double Hit_Limit = 0.0125;
	
	private int deckStatus;
	
	public DealerVSPlayerChance(Card dealerCard,int playerStartValue,double[] origin, double[] advanced){
		this.dealerCard = dealerCard;
		this.playerStartValue = playerStartValue;
		this.origin = origin;
		this.advanced = advanced;
	}

	@Override
	public String toString() {
		return "DealerVSPlayerChance [ \t"
				+"deckStatus="+ deckStatus
				+ "\tdealerCard=" + dealerCard + ", \tplayerStartValue=" + playerStartValue +"\t"
				+"[isDouble()=" + isDouble() + ", isHit()=" + isHit() + ", isSurrender()=" + isSurrender() + "]"
				+ HelloWorld.builder2DoubleWDL(advanced, origin)
				;
	}
	
	public boolean isDouble() {
		return (advanced[0]-advanced[2]) > Double_Limit;
	}
	
	public boolean isHit() {
		return (((advanced[0]-advanced[2]) - (origin[0]-origin[2])) > Hit_Limit);
	}
	
	public boolean isSurrender() {
		if(playerStartValue < 17) {
			return (advanced[0] - advanced[2]) < Surrender_Limit;
		}else{
			return (origin[0] - origin[2]) < Surrender_Limit ;
		}
	}

	@Override
	public int compareTo(DealerVSPlayerChance o) {

		if (playerStartValue < o.playerStartValue) {
			return -1;
		} else if (playerStartValue > o.playerStartValue) {
			return 1;
		} else {
			if (dealerCard.getValue() < o.dealerCard.getValue()) {
				return -1;
			} else if (dealerCard.getValue() > o.dealerCard.getValue()) {
				return 1;
			} else {
				if (deckStatus < o.deckStatus) {
					return -1;
				} else if (deckStatus > o.deckStatus) {
					return 1;
				} else {
					return 0;
				}
			}
		}
	}

	public void setDeckStatus(int deckStatus) {
		this.deckStatus = deckStatus;
	}
	
}