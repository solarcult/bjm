package org.shil.bjm.strategy;

import org.shil.bjm.anaylze.PlayersVSDealersResultChanceProb;
import org.shil.bjm.meta.BlackJackInfo;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerAction;
import org.shil.bjm.meta.PlayerCardsPathValue;

public class ProfitUtil {
	
	public static double baseMoney = 1d;

	//计算用户的本次组合与庄家起手牌的最终概率组合值,看看回报率是如何
	public static double moneyCalcOneHandInReturn(PlayerCardsPathValue playerCardsPathValue,Card dealerCard){
		double ROI = 0d;
		//自己爆了
		if(playerCardsPathValue.getValue() > BlackJackInfo.BlackJack){
			ROI -= baseMoney * playerCardsPathValue.prob();
			return ROI;
		}else if(playerCardsPathValue.getAction() == PlayerAction.Giveup){
			//用户放弃损失一半
			ROI -= baseMoney * 0.5 * playerCardsPathValue.prob();
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
		ROI += baseMoney * playerchance[0] * playerCardsPathValue.getBetMutiV() * playerCardsPathValue.prob();
		ROI -= baseMoney * playerchance[1] * playerCardsPathValue.getBetMutiV() * playerCardsPathValue.prob();
		
		return ROI;
	}
}
