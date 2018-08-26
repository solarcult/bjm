package org.shil.bjm.meta;

public class WinRateUtil {

	public static double win(PlayerCardsPathValue playerCardsPathValue,DealerCardsPathValue dealerCardsPathValue) {
		if(playerCardsPathValue.getValue() > BlackJackInfo.BlackJack){
			return -1;
		}else if(playerCardsPathValue.getAction() == PlayerAction.Giveup){
			return -0.5;
		}else if(playerCardsPathValue.getAction() == PlayerAction.SplitAbandon){
			//这里会造成外层统计有稍微的误差,但总数在15亿中,可以忽略
			return 0;
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
//		System.out.println("WRONG iS HERER 99999999999"+playerCardsPathValue.getValue()+dealerCardsPathValue.getValue());
		throw new RuntimeException("WRONG iS HERER 99999999999"+playerCardsPathValue.getValue()+dealerCardsPathValue.getValue());
//		return 999999999;
	}
}
