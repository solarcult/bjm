package org.shil.bjm.meta;

import java.util.Collection;

import org.shil.bjm.anaylze.PlayersVSDealersResultChanceProb;

/**
 * 计算收益率的类，看最后能赚多少钱
 * @author vanis
 *
 */
public class ProfitUtil {
	
	public static double baseMoney = 200d;

	//计算用户的本次组合与庄家起手牌的最终概率组合值,看看回报率是如何
	/**
	 * 经过反复思考，这个方法里面使用的 PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatus 返回的是胜负平的比率，造成某些结果会极大影响最终统一的效果，换为新的带prob的方法，将原始的胜平负概率返回到前面，计算的更加合情合理，通过新的函数，遗传算法分析出来的结果，更加符合现实情况，根据这个研究结果，将这个方法废掉。
	 * @param playerCardsPathValue
	 * @param dealerCard
	 * @return
	 * @deprecated by moneyCalcOneHandInReturnProb
	 */
	public static double moneyCalcOneHandInReturn(PlayerCardsPathValue playerCardsPathValue,Card dealerCard){
		double ROI = 0d;
		double onePot = baseMoney * playerCardsPathValue.getBetMutiV();
		
		if(playerCardsPathValue.getAction() == PlayerAction.Giveup){
			if(playerCardsPathValue.getBetMutiV()>1 || playerCardsPathValue.getSplitTimes()>0){
				throw new RuntimeException("should not here if split or double :" + playerCardsPathValue);
			}
			
			double daCardProb = (double) 1/13;
			//用户放弃损失一半,BetMutiV 包含了0.5,此处不用乘
			ROI -= onePot * playerCardsPathValue.prob() * daCardProb;
			return ROI;
		}else if(playerCardsPathValue.getAction() == PlayerAction.SplitAbandon){
			return ROI;
		}else if(playerCardsPathValue.getAction() == PlayerAction.Init 
				|| playerCardsPathValue.getAction() == PlayerAction.Hit 
				|| playerCardsPathValue.getAction() == PlayerAction.Double
				|| playerCardsPathValue.getAction() == PlayerAction.Split){
			throw new RuntimeException("what is wrong in here? status not done: " + playerCardsPathValue.getAction());
		}
		
		//最终计算投资收益率
		double[] playerchance = PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatus(playerCardsPathValue, dealerCard);
		ROI += playerchance[WinDrawLose.win] * onePot;
		ROI -= playerchance[WinDrawLose.lose] * onePot;
		
		return ROI;
	}
	
	public static double moneyCalcOneHandInReturnProb(PlayerCardsPathValue playerCardsPathValue,Card dealerCard){
		double ROI = 0d;
		double onePot = baseMoney * playerCardsPathValue.getBetMutiV();
		
		if(playerCardsPathValue.getAction() == PlayerAction.Giveup){
			if(playerCardsPathValue.getBetMutiV()>1 || playerCardsPathValue.getSplitTimes()>0 || playerCardsPathValue.getDsTimes()>0){
				throw new RuntimeException("should not here if split or double :" + playerCardsPathValue);
			}
			
			double daCardProb = (double)1/13;
			//用户放弃损失一半,BetMutiV 包含了0.5,此处不用乘
			ROI -= onePot * playerCardsPathValue.prob() * daCardProb;
			return ROI;
		}else if(playerCardsPathValue.getAction() == PlayerAction.SplitAbandon){
			return ROI;
		}else if(playerCardsPathValue.getAction() == PlayerAction.Init 
				|| playerCardsPathValue.getAction() == PlayerAction.Hit 
				|| playerCardsPathValue.getAction() == PlayerAction.Double
				|| playerCardsPathValue.getAction() == PlayerAction.Split){
			throw new RuntimeException("what is wrong in here? status not done: " + playerCardsPathValue.getAction());
		}
		
		//最终计算投资收益率
		double[] playerchance = PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatusProb(playerCardsPathValue, dealerCard);
		ROI += playerchance[WinDrawLose.win] * onePot;
		ROI -= playerchance[WinDrawLose.lose] * onePot;
		
		return ROI;
	}
	
	@Deprecated
	public static double moneyCalcOneHandInReturn(Collection<PlayerCardsPathValue> playerCardsPathValues,Card dealerCard){
		double ROI = 0;
		for(PlayerCardsPathValue playerCardsPathValue : playerCardsPathValues){
			ROI += moneyCalcOneHandInReturn(playerCardsPathValue,dealerCard);
		}
		return ROI;
	}
	
	public static double moneyCalcOneHandInReturnProb(Collection<PlayerCardsPathValue> playerCardsPathValues,Card dealerCard){
		double ROI = 0;
		for(PlayerCardsPathValue playerCardsPathValue : playerCardsPathValues){
			ROI += moneyCalcOneHandInReturnProb(playerCardsPathValue,dealerCard);
		}
		return ROI;
	}
	
	/**
	 * old fashion way has more detail and preciously rate , but too slowly
	 * 计算用户的本次组合与庄家起手牌的最终概率组合值,看看回报率是如何
	 * @param playerCardsPathValue
	 * @param dealerCard
	 * @return
	 */
	public static double oldFashionWayMoneyCalcOneHandInReturn(PlayerCardsPathValue playerCardsPathValue,Card dealerCard){
		double ROI = 0d;
		double onePot = playerCardsPathValue.prob() * playerCardsPathValue.getBetMutiV();
		//自己爆了
		if(playerCardsPathValue.getValue() > BlackJackInfo.BlackJack){
			ROI -= baseMoney * onePot;
			return ROI;
		}else if(playerCardsPathValue.getAction() == PlayerAction.Giveup){
			//用户放弃损失一半,BetMutiV 包含了0.5,此处不用乘
			ROI -= baseMoney * onePot;
			return ROI;
		}else if(playerCardsPathValue.getAction() == PlayerAction.SplitAbandon){
			return ROI;
		}else if(playerCardsPathValue.getAction() == PlayerAction.Init 
				|| playerCardsPathValue.getAction() == PlayerAction.Hit 
				|| playerCardsPathValue.getAction() == PlayerAction.Double
				|| playerCardsPathValue.getAction() == PlayerAction.Split){
			throw new RuntimeException("what is wrong in here? status not done: " + playerCardsPathValue.getAction());
		}
		
		//最终计算投资收益率
		double[] playerchance = PlayersVSDealersResultChanceProb.oldFashionWayCalcPlayerVSDealerProbs(playerCardsPathValue, dealerCard);
		ROI += baseMoney * playerchance[WinDrawLose.win] * onePot;
		ROI -= baseMoney * playerchance[WinDrawLose.lose] * onePot;
		
		return ROI;
	}
	
	public static double calcROI(PlayerCardsPathValue playerCardsPathValue, DealerCardsPathValue dealerCardsPathValue,double baseMoney) {
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
	
}
