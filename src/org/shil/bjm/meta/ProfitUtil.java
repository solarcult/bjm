package org.shil.bjm.meta;

import java.util.Collection;

import org.shil.bjm.anaylze.PlayersVSDealersResultChanceProb;

/**
 * 计算收益率的类，看最后能赚多少钱
 * @author vanis
 *
 */
public class ProfitUtil {
	
	public static double baseMoney = 100d;

	//计算用户的本次组合与庄家起手牌的最终概率组合值,看看回报率是如何
	public static double moneyCalcOneHandInReturn(PlayerCardsPathValue playerCardsPathValue,Card dealerCard){
		double ROI = 0d;
		double onePot = baseMoney * playerCardsPathValue.getBetMutiV();
//		double onePot = playerCardsPathValue.prob() * playerCardsPathValue.getBetMutiV();
		
//		自己爆了
//		if(playerCardsPathValue.getValue() > BlackJackInfo.BlackJack){
//			ROI -= baseMoney * onePot;
//			return ROI;
//		}else 
		
		
		
		if(playerCardsPathValue.getAction() == PlayerAction.Giveup){
			if(playerCardsPathValue.getBetMutiV()>1 || playerCardsPathValue.getSplitTimes()>0){
				throw new RuntimeException("should not here if split or double :" + playerCardsPathValue);
			}
			
			double daCardProb = 1/13;
			//用户放弃损失一半
			ROI -= 0.5 * onePot * playerCardsPathValue.prob() * daCardProb;
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
//		double onePot = playerCardsPathValue.prob() * playerCardsPathValue.getBetMutiV();
		
//		自己爆了
//		if(playerCardsPathValue.getValue() > BlackJackInfo.BlackJack){
//			ROI -= baseMoney * onePot;
//			return ROI;
//		}else 
		
		
		if(playerCardsPathValue.getAction() == PlayerAction.Giveup){
			if(playerCardsPathValue.getBetMutiV()>1 || playerCardsPathValue.getSplitTimes()>0){
				throw new RuntimeException("should not here if split or double :" + playerCardsPathValue);
			}
			
			double daCardProb = 1/13;
			//用户放弃损失一半
			ROI -= 0.5 * onePot * playerCardsPathValue.prob() * daCardProb;
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
			//用户放弃损失一半
			ROI -= baseMoney * 0.5 * onePot;
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
	
}
