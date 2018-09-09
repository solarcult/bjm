package org.shil.bjm.meta;

import java.util.Collection;

public class WinRateUtil {
	
	public static int IgnoreReturn = -7;

	public static double calcWDLValue(PlayerCardsPathValue playerCardsPathValue,DealerCardsPathValue dealerCardsPathValue) {
		if(playerCardsPathValue.getValue() > BlackJackInfo.BlackJack){
			return -1;
		}else if(playerCardsPathValue.getAction() == PlayerAction.Giveup){
			return -0.5;
		}else if(playerCardsPathValue.getAction() == PlayerAction.SplitAbandon){
			//这里会造成外层统计有稍微的误差,但总数在15亿中,可以忽略
			return IgnoreReturn;
		}else if(playerCardsPathValue.getAction() == PlayerAction.Init 
				|| playerCardsPathValue.getAction() == PlayerAction.Hit 
				|| playerCardsPathValue.getAction() == PlayerAction.Double
				|| playerCardsPathValue.getAction() == PlayerAction.Split){
			throw new RuntimeException("what is wrong in here? status not done: " + playerCardsPathValue.getAction());
		}
		if(dealerCardsPathValue.getValue()>BlackJackInfo.BlackJack) {
			return 1;
		}
		if(playerCardsPathValue.getValue()>dealerCardsPathValue.getValue()) {
			return 1;
		}
		if(playerCardsPathValue.getValue()==dealerCardsPathValue.getValue()) {
			return 0;
		}
		if(playerCardsPathValue.getValue()<dealerCardsPathValue.getValue()) {
			return -1;
		}
		throw new RuntimeException("WRONG iS HERER 99999999999"+playerCardsPathValue.getValue()+dealerCardsPathValue.getValue());
	}
	
	public static double calcWDLValueWithDStimes(PlayerCardsPathValue playerCardsPathValue,DealerCardsPathValue dealerCardsPathValue) {
		int value = 1;
		if(playerCardsPathValue.getDsTimes()>0) {
			value *= playerCardsPathValue.getDsTimes();
		}
		if(playerCardsPathValue.getValue() > BlackJackInfo.BlackJack){
			return -1*value;
		}else if(playerCardsPathValue.getAction() == PlayerAction.Giveup){
			if(value>1) throw new RuntimeException("this should not happened");
			return -0.5*value;
		}else if(playerCardsPathValue.getAction() == PlayerAction.SplitAbandon){
			//这里会造成外层统计有稍微的误差,但总数在15亿中,可以忽略
			//no upper logic should handle this 
			return IgnoreReturn;
		}else if(playerCardsPathValue.getAction() == PlayerAction.Init 
				|| playerCardsPathValue.getAction() == PlayerAction.Hit 
				|| playerCardsPathValue.getAction() == PlayerAction.Double
				|| playerCardsPathValue.getAction() == PlayerAction.Split){
			throw new RuntimeException("what is wrong in here? status not done: " + playerCardsPathValue.getAction());
		}
		if(dealerCardsPathValue.getValue()>BlackJackInfo.BlackJack) {
			return 1*value;
		}
		if(playerCardsPathValue.getValue()>dealerCardsPathValue.getValue()) {
			return 1*value;
		}
		if(playerCardsPathValue.getValue()==dealerCardsPathValue.getValue()) {
			//这里会产生误差,因为dstimes的次数无法传到上层,造成win or lose a little bit bigger than real, upper logic should hand this case
			return 0;
		}
		if(playerCardsPathValue.getValue()<dealerCardsPathValue.getValue()) {
			return -1*value;
		}
		throw new RuntimeException("WRONG iS HERER 99999999999"+playerCardsPathValue.getValue()+dealerCardsPathValue.getValue());
	}
	//TODO speed up
	public Double[] calcWDLPlayerCardVSDealerCardWithDStimes(PlayerCardsPathValue playerCardsPathValue, Card dealerCard) {
		double win = 0;
		double draw = 0;
		double lose = 0;
		
		int value = 1;
		if(playerCardsPathValue.getDsTimes()>0) {
			value *= playerCardsPathValue.getDsTimes();
		}
		
		if(playerCardsPathValue.getAction() == PlayerAction.Giveup){
			if(playerCardsPathValue.getBetMutiV()>1 || playerCardsPathValue.getSplitTimes()>0||playerCardsPathValue.getDsTimes()>0){
				throw new RuntimeException("should not here if split or double :" + playerCardsPathValue);
			}
			
			double daCardProb = (double)1/13;
			//用户放弃损失一半
			lose += 0.5 * value * playerCardsPathValue.prob() * daCardProb;
		}else if(playerCardsPathValue.getAction() == PlayerAction.SplitAbandon){
			//这里会造成外层统计有稍微的误差,但总数在15亿中,可以忽略
			//no upper logic should handle this 
			return null;
		}else if(playerCardsPathValue.getAction() == PlayerAction.Init 
				|| playerCardsPathValue.getAction() == PlayerAction.Hit 
				|| playerCardsPathValue.getAction() == PlayerAction.Double
				|| playerCardsPathValue.getAction() == PlayerAction.Split){
			throw new RuntimeException("what is wrong in here? status not done: " + playerCardsPathValue.getAction());
		}
		return null;
	}
	
	
	public static Double[] calcWDLValueWithDStimes(Collection<PlayerCardsPathValue> playerCardsPathValues,Collection<DealerCardsPathValue> dealerCardsPathValues) {
		double win = 0;
		double draw = 0;
		double lose = 0;
		for(PlayerCardsPathValue playerCardsPathValue : playerCardsPathValues) {
			for(DealerCardsPathValue dealerCardsPathValue : dealerCardsPathValues) {
				double result = calcWDLValueWithDStimes(playerCardsPathValue, dealerCardsPathValue);
				if(result == WinRateUtil.IgnoreReturn) continue;
				if(result > 0) {
					win += result;
				}else if(result < 0) {
					lose += Math.abs(result);
				}else {
					//draw
					if(playerCardsPathValue.getDsTimes()>0) {
						draw += playerCardsPathValue.getDsTimes();
					}
				}
			}
		}
		double total = win+draw+lose;
		
		return new Double[] {win/total,draw/total,lose/total};
	}
	
	public static Double[] calcWDLValueWithDStimesbyRaw(Collection<PlayerCardsPathValue> playerCardsPathValues,Collection<DealerCardsPathValue> dealerCardsPathValues) {
		double win = 0;
		double draw = 0;
		double lose = 0;
		for(PlayerCardsPathValue playerCardsPathValue : playerCardsPathValues) {
			for(DealerCardsPathValue dealerCardsPathValue : dealerCardsPathValues) {
				double result = calcWDLValueWithDStimes(playerCardsPathValue, dealerCardsPathValue);
				if(result == WinRateUtil.IgnoreReturn) continue;
				if(result > 0) {
					win += result;
				}else if(result < 0) {
					lose += Math.abs(result);
				}else {
					//draw
					if(playerCardsPathValue.getDsTimes()>0) {
						draw += playerCardsPathValue.getDsTimes();
					}
				}
			}
		}
		
		return new Double[] {win,draw,lose};
	}
	
	public static Double[] calcWDLValueWithDStimesWithProb(Collection<PlayerCardsPathValue> playerCardsPathValues,Collection<DealerCardsPathValue> dealerCardsPathValues) {
		double win = 0;
		double draw = 0;
		double lose = 0;
		for(PlayerCardsPathValue playerCardsPathValue : playerCardsPathValues) {
			for(DealerCardsPathValue dealerCardsPathValue : dealerCardsPathValues) {
				double prob = playerCardsPathValue.prob() * dealerCardsPathValue.prob();
				double result = calcWDLValueWithDStimes(playerCardsPathValue, dealerCardsPathValue);
				if(result == WinRateUtil.IgnoreReturn) continue;
				result *= prob;
				if(result > 0) {
					win += result;
				}else if(result < 0) {
					lose += Math.abs(result);
				}else {
					//draw
					if(playerCardsPathValue.getDsTimes()>0) {
						draw += playerCardsPathValue.getDsTimes() * prob;
					}else {
						draw += prob;
					}
				}
			}
		}
		double total = win+draw+lose;
		
		return new Double[] {win/total,draw/total,lose/total};
	}
}
