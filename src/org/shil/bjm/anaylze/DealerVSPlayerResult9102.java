package org.shil.bjm.anaylze;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.DeckSet;

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
	public static double Surrender_Limit = -0.478;
	public static double Hit_Limit = 0.03;
	
	public static double ROI_Hit = 0.04;
	public static double ROI_Surrender = 0.5;
	
	private int deckStatus;
	
	public DealerVSPlayerResult9102(Card dealerCard,int playerStartValue,DvsP2D9102 orign,DvsP2D9102 advanced){
		this.dealerCard = dealerCard;
		this.playerStartValue = playerStartValue;
		this.origin = orign;
		this.advanced = advanced;
	}

	@Override
	public String toString() {
		double onet = origin.getProbReturnMoney() - origin.getProbTotalSpendMoney();
		double anet = advanced.getProbReturnMoney() - advanced.getProbTotalSpendMoney();
		return  "\n\t\t @@@   dealerCard=" + dealerCard + ", \tplayerStartValue=" + playerStartValue +"\t@@@ \n"
				+ "\nnet money diff:  " + (anet - onet)+" , up % -> "+ 100 * ((anet - onet)/Math.abs(onet))  +" .  o: "+onet +" -> a: " +anet
				+"\n\n[ProbMatrix: total: o: "+origin.getTotalProbs() +  "  -> a: "+advanced.getTotalProbs()
				+ HelloWorld.builder2DoubleWDL(advanced.getProbRates(), origin.getProbRates())
				+"\n[TimeMatrix: total:  o: "+origin.getTotalTimes() + " -> a: " + advanced.getTotalTimes()
				+ HelloWorld.builder2DoubleWDL(advanced.getTimeRates(), origin.getTimeRates())
				+"\n[Prob_ROI diff: "+ (advanced.getProbRoi()-origin.getProbRoi()) +" (up%-> "+ 100 * (advanced.getProbRoi()-origin.getProbRoi())/origin.getProbRoi() +") . o: "+ origin.getProbRoi() + " -> a: "+advanced.getProbRoi()+"\t returnMoney: o:" + origin.getProbReturnMoney() +" a: "+ advanced.getProbReturnMoney() +"\t totalSpendMoney: o: "+ origin.getProbTotalSpendMoney() +" a: "+advanced.getProbTotalSpendMoney()+"\n"
				+"\n[Time_ROI diff: "+ (advanced.getTimeRoi()-origin.getTimeRoi()) +" (up%-> "+ 100 * (advanced.getTimeRoi()-origin.getTimeRoi())/origin.getTimeRoi() +") . o: "+ origin.getTimeRoi() + " -> a: "+advanced.getTimeRoi()+"\t returnMoney: o:" + origin.getTimeReturnMoney() +" a: "+ advanced.getTimeReturnMoney() +"\t totalSpendMoney: o: "+ origin.getTimeTotalSpendMoney() +" a: "+advanced.getTimeTotalSpendMoney()+"\n"
				+"\n[[Per_Prob_ROI diff: "+ (advanced.getPerProbRoi()-origin.getPerProbRoi()) +" (up%-> "+ 100 * (advanced.getPerProbRoi()-origin.getPerProbRoi())/origin.getPerProbRoi() +") . o: "+ origin.getPerProbRoi() + " -> a: "+advanced.getPerProbRoi()+"\t per returnMoney: o:" + origin.getPerProbReturnMoney() +" a: "+ advanced.getPerProbReturnMoney() +"\t per totalSpendMoney: o: "+ origin.getPerProbTotalSpendMoney() +" a: "+advanced.getPerProbTotalSpendMoney()+"\n"
				+"\n\t Decide:"+ ((((anet - onet)/Math.abs(onet) + (advanced.getProbRoi()-origin.getProbRoi())/origin.getProbRoi())>0)?" $Change$ ":" !Not Change! ") +" [isDouble()=" + isDouble() + ", isHit()=" + isHit() + ", isSurrender()=" + isSurrender() + "]" +"\tdeckStatus="+ deckStatus +"\t ! DeckSet.resetValue= "+ DeckSet.resetValue;
		
	}
	
	public boolean isDouble() {
		return ((advanced.getProbRates()[0]-advanced.getProbRates()[2]) > Double_Limit)
				&& ((advanced.getTimeRates()[0]-advanced.getTimeRates()[2]) > Double_Limit);
	}
	
	public boolean isHit() {
//		return (((advanced.getProbRates()[0]-advanced.getProbRates()[2]) - (origin.getProbRates()[0]-origin.getProbRates()[2])) > Hit_Limit)
//				&& (((advanced.getTimeRates()[0]-advanced.getTimeRates()[2]) - (origin.getTimeRates()[0]-origin.getTimeRates()[2])) > Hit_Limit);
		return (advanced.getProbRoi()-origin.getProbRoi())/origin.getProbRoi() > ROI_Hit;
	}
	
	public boolean isSurrender() {
//		return ((advanced.getProbRates()[0]-advanced.getProbRates()[2]) < Surrender_Limit)
//				&& ((advanced.getTimeRates()[0]-advanced.getTimeRates()[2]) < Surrender_Limit);
		return advanced.getProbRoi() <= ROI_Surrender;
	}


	public void setDeckStatus(int deckStatus) {
		this.deckStatus = deckStatus;
	}
	
}