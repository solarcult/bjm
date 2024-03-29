package org.shil.bjm.meta;

import java.util.Collection;

import org.shil.bjm.anaylze.PlayersVSDealersResultChanceProb;

/**
 * 计算收益率的类，看最后能赚多少钱
 * @author vanis
 *
 */
public class ProfitUtil {
	
	public static double BaseMoney = 50000d;

	//计算用户的本次组合与庄家起手牌的最终概率组合值,看看回报率是如何
	/**
	 * 经过反复思考，这个方法里面使用的 PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatus 返回的是胜负平的比率，造成某些结果会极大影响最终统一的效果，换为新的带prob的方法，将原始的胜平负概率返回到前面，计算的更加合情合理，通过新的函数，遗传算法分析出来的结果，更加符合现实情况，根据这个研究结果，将这个方法废掉。
	 * @param playerCardsPathValue
	 * @param dealerCard
	 * @return
	 * @deprecated by moneyCalcOneHandInReturnProb
	 */
	public static double moneyCalcOneHandInReturn(PlayerCardsPathValue playerCardsPathValue,Card dealerCard){
		double pureReturn = 0d;
		double onePot = BaseMoney * playerCardsPathValue.getBetMutiV();
		
		if(playerCardsPathValue.getAction() == PlayerAction.Giveup){
			if(playerCardsPathValue.getBetMutiV()>1 || playerCardsPathValue.getSplitTimes()>0){
				throw new RuntimeException("should not here if split or double :" + playerCardsPathValue);
			}
			
			double daCardProb = (double) 1/13;
			//用户放弃损失一半,BetMutiV 包含了0.5,此处不用乘
			pureReturn -= onePot * playerCardsPathValue.prob() * daCardProb;
			return pureReturn;
		}else if(playerCardsPathValue.getAction() == PlayerAction.SplitAbandon){
			return pureReturn;
		}else if(playerCardsPathValue.getAction() == PlayerAction.Init 
				|| playerCardsPathValue.getAction() == PlayerAction.Hit 
				|| playerCardsPathValue.getAction() == PlayerAction.Double
				|| playerCardsPathValue.getAction() == PlayerAction.Split){
			throw new RuntimeException("what is wrong in here? status not done: "+playerCardsPathValue.getAction() + " : " + playerCardsPathValue);
		}
		
		//最终计算投资收益率
		double[] playerchance = PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatus(playerCardsPathValue, dealerCard);
		pureReturn += playerchance[WinDrawLose.win] * onePot;
		pureReturn -= playerchance[WinDrawLose.lose] * onePot;
		
		return pureReturn;
	}
	
	public static double moneyCalcOneHandInReturnPureProb(PlayerCardsPathValue playerCardsPathValue, Card dealerCard){
		double pureReturn = 0d;
		double onePot = BaseMoney * playerCardsPathValue.getBetMutiV();
		
		if(playerCardsPathValue.getAction() == PlayerAction.Giveup){
			if(playerCardsPathValue.getBetMutiV()>1 || playerCardsPathValue.getSplitTimes()>0 || playerCardsPathValue.getDsTimes()>0){
				throw new RuntimeException("should not here if split or double :" + playerCardsPathValue);
			}
			
			double daCardProb = (double)1/13;
			//用户放弃损失一半,BetMutiV 包含了0.5,此处不用乘
			pureReturn -= onePot * playerCardsPathValue.prob() * daCardProb;
			return pureReturn;
		}else if(playerCardsPathValue.getAction() == PlayerAction.SplitAbandon){
			return pureReturn;
		}else if(playerCardsPathValue.getAction() == PlayerAction.Init 
//				|| playerCardsPathValue.getAction() == PlayerAction.Hit
				|| playerCardsPathValue.getAction() == PlayerAction.Double
				|| playerCardsPathValue.getAction() == PlayerAction.Split){
			throw new RuntimeException("what is wrong in here? status not done: " + playerCardsPathValue.getAction());
		}
		
		//最终计算投资收益率
		double[] playerchance = PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatusPureProb(playerCardsPathValue, dealerCard);
		pureReturn += playerchance[WinDrawLose.win] * onePot;
		pureReturn -= playerchance[WinDrawLose.lose] * onePot;
		
		return pureReturn;
	}
	
	@Deprecated
	public static double moneyCalcOneHandInReturn(Collection<PlayerCardsPathValue> playerCardsPathValues,Card dealerCard){
		double pureReturn = 0;
		for(PlayerCardsPathValue playerCardsPathValue : playerCardsPathValues){
			pureReturn += moneyCalcOneHandInReturn(playerCardsPathValue,dealerCard);
		}
		return pureReturn;
	}
	
	public static double moneyCalcOneHandInReturnProb(Collection<PlayerCardsPathValue> playerCardsPathValues,Card dealerCard){
		double pureReturn = 0;
		for(PlayerCardsPathValue playerCardsPathValue : playerCardsPathValues){
			pureReturn += moneyCalcOneHandInReturnPureProb(playerCardsPathValue,dealerCard);
		}
		return pureReturn;
	}
	
	/**
	 * old fashion way has more detail and preciously rate , but too slowly
	 * 计算用户的本次组合与庄家起手牌的最终概率组合值,看看回报率是如何
	 * @param playerCardsPathValue
	 * @param dealerCard
	 * @return
	 */
	public static double oldFashionWayMoneyCalcOneHandInReturn(PlayerCardsPathValue playerCardsPathValue,Card dealerCard){
		double pureReturn = 0d;
		double onePot = playerCardsPathValue.prob() * playerCardsPathValue.getBetMutiV();
		//自己爆了
		if(playerCardsPathValue.getValue() > BlackJackInfo.BlackJack){
			pureReturn -= BaseMoney * onePot;
			return pureReturn;
		}else if(playerCardsPathValue.getAction() == PlayerAction.Giveup){
			//用户放弃损失一半,BetMutiV 包含了0.5,此处不用乘
			pureReturn -= BaseMoney * onePot;
			return pureReturn;
		}else if(playerCardsPathValue.getAction() == PlayerAction.SplitAbandon){
			return pureReturn;
		}else if(playerCardsPathValue.getAction() == PlayerAction.Init 
				|| playerCardsPathValue.getAction() == PlayerAction.Hit 
				|| playerCardsPathValue.getAction() == PlayerAction.Double
				|| playerCardsPathValue.getAction() == PlayerAction.Split){
			throw new RuntimeException("what is wrong in here? status not done: " + playerCardsPathValue.getAction());
		}
		
		//最终计算投资收益率
		double[] playerchance = PlayersVSDealersResultChanceProb.oldFashionWayCalcPlayerVSDealerProbs(playerCardsPathValue, dealerCard);
		pureReturn += BaseMoney * playerchance[WinDrawLose.win] * onePot;
		pureReturn -= BaseMoney * playerchance[WinDrawLose.lose] * onePot;
		
		return pureReturn;
	}
	
	/**
	 * 只计算baseMoney的整数结果，没有中间概率的参与
	 * @param playerCardsPathValue
	 * @param dealerCardsPathValue
	 * @param baseMoney
	 * @return
	 */
	public static double calcPureReturn(PlayerCardsPathValue playerCardsPathValue, DealerCardsPathValue dealerCardsPathValue,double baseMoney) {
		double onePot = playerCardsPathValue.getBetMutiV() * baseMoney;
		if(playerCardsPathValue.getValue() > BlackJackInfo.BlackJack){
			return -onePot;
		}else if(playerCardsPathValue.getAction() == PlayerAction.Giveup){
			//用户放弃损失一半,BetMutiV 包含了0.5,此处不用乘
			return -onePot;
		}else if(playerCardsPathValue.getAction() == PlayerAction.SplitAbandon){
			throw new RuntimeException("what is wrong in here? status not done: " + playerCardsPathValue.getAction());
		}else if(playerCardsPathValue.getAction() == PlayerAction.Init 
				|| playerCardsPathValue.getAction() == PlayerAction.Hit 
				|| playerCardsPathValue.getAction() == PlayerAction.Double
				|| playerCardsPathValue.getAction() == PlayerAction.Split){
			throw new RuntimeException("what is wrong in here? status not done: " + playerCardsPathValue.getAction());
		}
		
		if(dealerCardsPathValue.getValue() > BlackJackInfo.BlackJack) {
			return onePot;
		}
		
		if(playerCardsPathValue.getValue() > dealerCardsPathValue.getValue()) {
			return onePot;
		}else if(playerCardsPathValue.getValue() < dealerCardsPathValue.getValue()) {
			return -onePot;
		}
		
		return 0;
	}
	
	
	public static double calcPureReturnAfterPareto(PlayerCardsPathValue playerCardsPathValue, DealerCardsPathValue dealerCardsPathValue,double baseMoney) {

		if(playerCardsPathValue.getAction() == PlayerAction.Giveup) {
			if(playerCardsPathValue.getValue()>BlackJackInfo.BlackJack) throw new RuntimeException("should not give up but value > 21.");
			if(playerCardsPathValue.getDsTimes() > 0) throw new RuntimeException("playerCardsPathValue.getDsTimes() > 0 can't give up should not happened");
			if(playerCardsPathValue.getBetMutiV()!=0.5) throw new RuntimeException("playerCardsPathValue.getBetMutiV()!=0.5 in give up ! ");
			return baseMoney * playerCardsPathValue.getBetMutiV() * -1; //这里的playerCardsPathValue.getBetMutiV()只能是0.5，如果不是0.5就说明代码有Bug。
		}else if(playerCardsPathValue.getAction() == PlayerAction.SplitAbandon){
			return 0;
		}else if(playerCardsPathValue.getAction() == PlayerAction.Init 
				|| playerCardsPathValue.getAction() == PlayerAction.Hit 
				|| playerCardsPathValue.getAction() == PlayerAction.Double
				|| playerCardsPathValue.getAction() == PlayerAction.Split){
			throw new RuntimeException("what is wrong in here? status not done: " + playerCardsPathValue.getAction());
		}
		
		if(playerCardsPathValue.getValue() > BlackJackInfo.BlackJack){
			return baseMoney * playerCardsPathValue.getBetMutiV() * -1;
		}
		if(dealerCardsPathValue.getValue() > BlackJackInfo.BlackJack) {
			return baseMoney * playerCardsPathValue.getBetMutiV();
		}
		if(playerCardsPathValue.getValue() > dealerCardsPathValue.getValue()) {
			return baseMoney * playerCardsPathValue.getBetMutiV();
		}
		if(playerCardsPathValue.getValue() == dealerCardsPathValue.getValue()) {
			return 0;
		}
		if(playerCardsPathValue.getValue() < dealerCardsPathValue.getValue()) {
			return baseMoney * playerCardsPathValue.getBetMutiV() * -1;
		}
	
		return 0;
	}
	
	/**
	 * 只计算baseMoney的概率结果，非整数结果
	 * @param playerCardsPathValue
	 * @param dealerCardsPathValue
	 * @param baseMoney
	 * @return 
	 */
	public static double calcPureReturnProb(PlayerCardsPathValue playerCardsPathValue, DealerCardsPathValue dealerCardsPathValue,double baseMoney) {
		double onePot = playerCardsPathValue.prob()  * dealerCardsPathValue.prob() * playerCardsPathValue.getBetMutiV() * baseMoney;
		if(playerCardsPathValue.getValue() > BlackJackInfo.BlackJack){
			return -onePot;
		}else if(playerCardsPathValue.getAction() == PlayerAction.Giveup){
			//用户放弃损失一半,BetMutiV 包含了0.5,此处不用乘
			return -onePot;
		}else if(playerCardsPathValue.getAction() == PlayerAction.SplitAbandon){
			throw new RuntimeException("what is wrong in here? status not done: " + playerCardsPathValue.getAction());
		}else if(playerCardsPathValue.getAction() == PlayerAction.Init 
				|| playerCardsPathValue.getAction() == PlayerAction.Hit 
				|| playerCardsPathValue.getAction() == PlayerAction.Double
				|| playerCardsPathValue.getAction() == PlayerAction.Split){
			throw new RuntimeException("what is wrong in here? status not done: " + playerCardsPathValue.getAction());
		}
		
		if(dealerCardsPathValue.getValue() > BlackJackInfo.BlackJack) {
			return onePot;
		}
		
		if(playerCardsPathValue.getValue() > dealerCardsPathValue.getValue()) {
			return onePot;
		}else if(playerCardsPathValue.getValue() < dealerCardsPathValue.getValue()) {
			return -onePot;
		}
		
		return 0;
	}
}
