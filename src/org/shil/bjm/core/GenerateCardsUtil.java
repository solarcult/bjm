package org.shil.bjm.core;

import java.util.Collection;
import java.util.HashSet;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.meta.BlackJackInfo;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.DealerCardsPathValue;
import org.shil.bjm.meta.PlayerCardsPathValue;

public class GenerateCardsUtil {
	
	/**
	 * 产生Dealer的所有可能牌的组合
	 * @param dealerCardsPathValue
	 * @return Collection<CardsPathValue> 未过滤,有重复cards数据,但顺序不同
	 */
	public static Collection<DealerCardsPathValue> generateDealerCards(DealerCardsPathValue dealerCardsPathValue){
		Collection<DealerCardsPathValue> dealerCardsPathValues = new HashSet<DealerCardsPathValue>();
		
		//牌是否已经用完,出口之一
		if(dealerCardsPathValue.outOfCards()) return dealerCardsPathValues;
		
		//如果达到了Deal停止要牌的点数,返回,这是递归的出口之一
		if(dealerCardsPathValue.getValue() >= BlackJackInfo.DealerStop){
			dealerCardsPathValues.add(dealerCardsPathValue);
			return dealerCardsPathValues;
		}
		//如果没有达到点数,则再发一张牌,所有13中组合,继续递归
		if(dealerCardsPathValue.getValue() < BlackJackInfo.DealerStop ){
			for(Card card : Card.values()){
				//这里要深拷贝一个副本,因为要产生不同的13条链路,不能用同一个实例
				DealerCardsPathValue aNewPath = new DealerCardsPathValue(dealerCardsPathValue);
				aNewPath.addCard(card);
				dealerCardsPathValues.addAll(generateDealerCards(aNewPath));
			}
		}
		
		return dealerCardsPathValues;
	}
	
	//生成所有A代表1和代表11的组合,将重复的数据过滤掉,如果A在相同位置,并且值相同,则过滤掉比如说11,8,1代表20点,则1,8,11也是相同的组合,则过滤掉
	public static Collection<DealerCardsPathValue> generateDealerACards(){
		Collection<DealerCardsPathValue> cardsPathValues = new HashSet<DealerCardsPathValue>();
		cardsPathValues.addAll(GenerateCardsUtil.generateDealerCards(new DealerCardsPathValue(Card.One1)));
		return cardsPathValues;
	}
	
	/**
	 * 再发一张牌,用户会面临的所有牌
	 * @param playerCardsPathValue
	 * @return
	 */
	public static Collection<PlayerCardsPathValue> hitPlayerOneMoreCard(PlayerCardsPathValue playerCardsPathValue){
		Collection<PlayerCardsPathValue> playerCardsPathValues = new HashSet<PlayerCardsPathValue>();
		
		if(playerCardsPathValue.outOfCards()) return playerCardsPathValues;
		
		//Boss, give me one more cards
		for (Card card : Card.values()) {
			PlayerCardsPathValue aNewPath = new PlayerCardsPathValue(playerCardsPathValue);
			aNewPath.addCard(card);
			if(!aNewPath.outOfCards()) playerCardsPathValues.add(aNewPath);
		}
		
		return playerCardsPathValues;
	}
	
	public static void main(String[] args){
		
		HelloWorld.print(hitPlayerOneMoreCard(new PlayerCardsPathValue(Card.One1,Card.Five5)));
		
//		PlayerCardsPathValue x = new PlayerCardsPathValue(Card.Seven7,Card.Seven7);
//		Collection<PlayerCardsPathValue> xs = PlayerStrategyTwo.getInstance().generatePlayerCardsPaths(x, Card.Six6);
//		HelloWorld.print(xs);
//		HelloWorld.printMap(AnalyzeCardsPathValue.analyzePlayerCardsPathValue(xs));
//		System.out.println();
//		
//		PlayerCardsPathValue y = new PlayerCardsPathValue(Card.Seven7);
//		Collection<PlayerCardsPathValue> ys = PlayerStrategyTwo.getInstance().generatePlayerCardsPaths(y, Card.Six6);
//		HelloWorld.printMap(AnalyzeCardsPathValue.analyzePlayerCardsPathValue(ys));
//		HelloWorld.print(ys);
	}
	
}
