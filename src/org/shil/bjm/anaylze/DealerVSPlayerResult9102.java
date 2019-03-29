package org.shil.bjm.anaylze;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.meta.Card;

/**
 * 记录庄家牌与玩家起始牌 当前的概率org和再来一张的概率adv
 * @author vanis
 *
 */
public class DealerVSPlayerResult9102 {

	private Card dealerCard;
	private int playerStartValue;
	private DvsP2D9102 origin;
	private DvsP2D9102 advanced;
	
	
	public static double Double_Limit = 0.0405;
	public static double Surrender_Limit = -0.48;
	public static double Hit_Limit = 0.03;
	
	private int deckStatus;
	
	public DealerVSPlayerResult9102(Card dealerCard,int playerStartValue,DvsP2D9102 orign,DvsP2D9102 advanced){
		this.dealerCard = dealerCard;
		this.playerStartValue = playerStartValue;
		this.origin = orign;
		this.advanced = advanced;
	}

	@Override
	public String toString() {
		return  "\n\t\t @@@ dealerCard=" + dealerCard + ", \tplayerStartValue=" + playerStartValue +"\t@@@ \n"
				+"ProbMatrix: total: a: "+advanced.getTotalProbs() +" o: "+origin.getTotalProbs()
				+ HelloWorld.builder2DoubleWDL(advanced.getProbRates(), origin.getProbRates())
				+ "TimeMatrix: total: a: " + advanced.getTotalTimes() + " o: "+origin.getTotalTimes()
				+ HelloWorld.builder2DoubleWDL(advanced.getTimeRates(), origin.getProbRates())
				+"RoI diff: "+ (advanced.getRoi()-origin.getRoi()) + " a: "+advanced.getRoi() +" o: "+ origin.getRoi() +"\t returnMoney: a:" + advanced.getReturnMoney() +" o: "+origin.getReturnMoney() +"\t totalSpendMoney: a: "+ advanced.getTotalSpendMoney() +" o: "+origin.getTotalSpendMoney()
				+"\tdeckStatus="+ deckStatus
				+"\n\t [isDouble()=" + isDouble() + ", isHit()=" + isHit() + ", isSurrender()=" + isSurrender() + "]";
	}
	
	public boolean isDouble() {
		return ((advanced.getProbRates()[0]-advanced.getProbRates()[2]) > Double_Limit)
				&& ((advanced.getTimeRates()[0]-advanced.getTimeRates()[2]) > Double_Limit
				&& advanced.getRoi() > origin.getRoi());
	}
	
	public boolean isHit() {
		return (((advanced.getProbRates()[0]-advanced.getProbRates()[2]) - (origin.getProbRates()[0]-origin.getProbRates()[2])) > Hit_Limit)
				&& (((advanced.getTimeRates()[0]-advanced.getTimeRates()[2]) - (origin.getProbRates()[0]-origin.getProbRates()[2])) > Hit_Limit);
	}
	
	public boolean isSurrender() {
		return ((advanced.getProbRates()[0]-advanced.getProbRates()[2]) < Surrender_Limit)
				&& ((advanced.getTimeRates()[0]-advanced.getTimeRates()[2]) < Surrender_Limit);
	}


	public void setDeckStatus(int deckStatus) {
		this.deckStatus = deckStatus;
	}
	
}