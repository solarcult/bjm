package org.shil.bjm.anaylze;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.core.DealerCards;
import org.shil.bjm.core.DealerCardsAnalyzeStatus;
import org.shil.bjm.meta.BlackJackInfo;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.DealerCardsPathValue;
import org.shil.bjm.meta.DeckSet;
import org.shil.bjm.meta.PlayerCardsPathValue;
import org.shil.bjm.strategy.one.OneStrategy;

/**
 * simply and old fashion way to calc prob
 * @author LiangJingJing
 * @date 2017年06月24日 上午00:33:29
 */
public class PlayersVSDealersResultChanceProb {

	public static double[] oldFashionWayCalcPlayerdVSDealerProbs(Collection<PlayerCardsPathValue> players , Collection<DealerCardsPathValue> dealers){
		double winrate = 0;
		double drawrate = 0;
		double loserate = 0;
		DeckSet deckset = DeckSet.buildCasionDeckSet();
		for(PlayerCardsPathValue player : players){
			for(DealerCardsPathValue dealer : dealers){
				deckset.reset();
				double combineRate = player.prob(deckset)*dealer.prob(deckset);
				
				if(player.getValue() > BlackJackInfo.BlackJack){
					//player boost first
					loserate += combineRate;
				}else if(dealer.getValue()>BlackJackInfo.BlackJack){
					//dealer boost
					winrate += combineRate;
				}else if(player.getValue() > dealer.getValue()){
					winrate += combineRate;
				}else if(player.getValue() == dealer.getValue()){
					drawrate += combineRate;
				}else if(player.getValue() < dealer.getValue()){
					loserate += combineRate;
				}
			}
		}
		
		double totalrate = winrate + drawrate + loserate;
		
		return new double[]{winrate/totalrate,drawrate/totalrate,loserate/totalrate};
	}

	public static double[] oldFashionWayCalcPlayerVSDealerProbs(PlayerCardsPathValue playerCardsPathValue, Card dealerCard){
		Collection<PlayerCardsPathValue> players = new HashSet<PlayerCardsPathValue>();
		players.add(playerCardsPathValue);
		return oldFashionWayCalcPlayerdVSDealerProbs(players, DealerCards.fetchDealerCards(dealerCard));
	}
	
	public static double[] calcPlayerVSDealerAnaylzeStatus(PlayerCardsPathValue playerCardsPathValue, Card dealerCard){
		Collection<PlayerCardsPathValue> players = new HashSet<PlayerCardsPathValue>();
		players.add(playerCardsPathValue);
		Map<Integer,AnalyzeStatus> playermap = AnalyzeCardsPathValue.analyzePlayerCardsPathValue(players);
		return calcPlayerVSDealerAnaylzeStatus(playermap, DealerCardsAnalyzeStatus.fetchDealerAnalyzeStatusMap(dealerCard));
	}
	
	/**
	 * 计算现在玩家所有出牌可能与庄家的出牌可能概率
	 * @param players
	 * @param dealerCard 此处DealerCard必须是原始第一张牌,否则出现问题
	 * @return
	 */
	public static double[] calcPlayerVSDealerAnaylzeStatus(Collection<PlayerCardsPathValue> players, Card dealerCard){
		Map<Integer,AnalyzeStatus> playermap = AnalyzeCardsPathValue.analyzePlayerCardsPathValue(players);
		return calcPlayerVSDealerAnaylzeStatus(playermap, DealerCardsAnalyzeStatus.fetchDealerAnalyzeStatusMap(dealerCard));
	}
	
	public static double[] calcPlayerVSDealerAnaylzeStatus(Map<Integer,AnalyzeStatus> playermap,Map<Integer,AnalyzeStatus> dealermap){
		double winrate = 0;
		double drawrate = 0;
		double loserate = 0;
		
		for(Entry<Integer,AnalyzeStatus> pe : playermap.entrySet()){
			for(Entry<Integer,AnalyzeStatus> de : dealermap.entrySet()){
				AnalyzeStatus pa = pe.getValue();
				AnalyzeStatus da = de.getValue();
				if(pa.getValue() > BlackJackInfo.BlackJack){
					loserate += pa.getPrecent() * da.getPrecent();
				}else if(da.getValue() > BlackJackInfo.BlackJack){
					winrate += pa.getPrecent() * da.getPrecent();
				}else if(pa.getValue() > da.getValue()){
					winrate += pa.getPrecent() * da.getPrecent();
				}else if(pa.getValue() < da.getValue()){
					loserate += pa.getPrecent() * da.getPrecent();
				}else if(pa.getValue() == da.getValue()){
					drawrate += pa.getPrecent() * da.getPrecent();
				}
			}
		}
		
		double totalrate = winrate + drawrate + loserate;
		
		return new double[]{winrate/totalrate,drawrate/totalrate,loserate/totalrate};
	}
	
	public static void main(String[] args){
//		HelloWorld.printDoubleWDL(calcPlayerVSDealerAnaylzeStatus(GenerateCardsUtil.hitPlayerOneMoreCard(new PlayerCardsPathValue(Card.Four4,Card.Six6)), Card.Six6));
		HelloWorld.printDoubleWDL(calcPlayerVSDealerAnaylzeStatus(OneStrategy.SELF.generatePlayerCardsPaths(new PlayerCardsPathValue(Card.Two2,Card.Six6), Card.Six6) ,Card.Six6));
	}
}
