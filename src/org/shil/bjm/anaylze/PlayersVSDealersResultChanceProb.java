package org.shil.bjm.anaylze;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.core.DealerCards;
import org.shil.bjm.core.GenerateCardsUtil;
import org.shil.bjm.meta.BlackJackInfo;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.DealerCardsPathValue;
import org.shil.bjm.meta.PlayerCardsPathValue;

/**
 * simply way to calc prob
 * @author LiangJingJing
 * @date 2017年06月24日 上午00:33:29
 */
public class PlayersVSDealersResultChanceProb {

	
	public static double[] calcPlayerVSDealerAnaylzeStatus(PlayerCardsPathValue playerCardsPathValue, Card dealerCard){
		Collection<PlayerCardsPathValue> players = new HashSet<PlayerCardsPathValue>();
		players.add(playerCardsPathValue);
		Collection<DealerCardsPathValue> dealers = DealerCards.fetchDealerCards(dealerCard);
		Map<Integer,AnalyzeStatus> playermap = AnalyzeCardsPathValue.analyzePlayerCardsPathValue(players);
		Map<Integer,AnalyzeStatus> dealermap = AnalyzeCardsPathValue.analyzeDealerCardsPathValue(dealers);
		return calcPlayerVSDealerAnaylzeStatus(playermap, dealermap);
	}
	
	/**
	 * 计算现在玩家所有出牌可能与庄家的出牌可能概率
	 * @param players
	 * @param dealerCard 此处DealerCard必须是原始第一张牌,否则出现问题
	 * @return
	 */
	public static double[] calcPlayerVSDealerAnaylzeStatus(Collection<PlayerCardsPathValue> players, Card dealerCard){
		Collection<DealerCardsPathValue> dealers = DealerCards.fetchDealerCards(dealerCard);
		Map<Integer,AnalyzeStatus> playermap = AnalyzeCardsPathValue.analyzePlayerCardsPathValue(players);
		Map<Integer,AnalyzeStatus> dealermap = AnalyzeCardsPathValue.analyzeDealerCardsPathValue(dealers);
		return calcPlayerVSDealerAnaylzeStatus(playermap, dealermap);
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
	
	/*
	public static double[] hitPlayerOneMore(PlayerCardsPathValue originPlayerCards, PlayerCardsPathValue hitPlayerCards, DealerCardsPathValue hitDealerCards){
		double win = 0;
		double draw = 0;
		double lose =0;
		double better = 0;
		double normal = 0;
		double worse = 0;
		
		if(hitPlayerCards.getValue() > BlackJackInfo.BlackJack){
			//player bust first
			lose ++;
			if(hitDealerCards.getValue() >= BlackJackInfo.DealerStop && hitDealerCards.getValue() <= BlackJackInfo.BlackJack){
				//如果我加了以后爆了,庄家成牌了,则算好牌,因为对结局没有影响.
				normal++;
				System.out.println(hitPlayerCards.getCards().get(hitPlayerCards.getCards().size()-1).getValue() +" normal (i bust and dealer make 17+) : " + hitPlayerCards.getValue()  + " dealer: " + hitDealerCards.getValue());
			}else if(hitDealerCards.getValue() > BlackJackInfo.BlackJack){
				//如果我加以后爆了,庄家也爆了,不算好牌,应该留给庄家.
				worse++;
				System.out.println(hitPlayerCards.getCards().get(hitPlayerCards.getCards().size()-1).getValue() +" worse (i bust dealer bust either, SHOULD NEVER HAPPEN): " + originPlayerCards.getValue() +"->" + hitPlayerCards.getValue() + " dealer: " +hitDealerCards.getValue());
			}else if(hitDealerCards.getValue() < BlackJackInfo.DealerStop){
				//如果我加了以后爆了,庄家没爆,应该留给庄家,让他有更多爆的几率
				worse++;
				System.out.println(hitPlayerCards.getCards().get(hitPlayerCards.getCards().size()-1).getValue() +" worse (i bust, dealer near bust): " + originPlayerCards.getValue() +"->"+ hitPlayerCards.getValue() + " dealer: " +hitDealerCards.getValue());

			}
		}else if(hitPlayerCards.getValue() >= BlackJackInfo.DealerStop){
			//player not bust
			if(hitDealerCards.getValue()>= BlackJackInfo.DealerStop){
				//如果玩家成了,对方也成了,这是一步好棋
				better++;
				System.out.println(hitPlayerCards.getCards().get(hitPlayerCards.getCards().size()-1).getValue() +" better (i make 17+, dealer either 17+): " + hitPlayerCards.getValue() + " dealer: " +hitDealerCards.getValue());
			}else{
				//如果玩家成了,对方没有成,算是一步good?
				better++;
				System.out.println(hitPlayerCards.getCards().get(hitPlayerCards.getCards().size()-1).getValue() +" better (i make 17+ , dealer near): " + hitPlayerCards.getValue() + " dealer: " +hitDealerCards.getValue());
			}
		}else{
			//not bust is good either
			if(hitDealerCards.getValue() >= BlackJackInfo.DealerStop && hitDealerCards.getValue() <= BlackJackInfo.BlackJack){
				better++;
				System.out.println(hitPlayerCards.getCards().get(hitPlayerCards.getCards().size()-1).getValue() +" better (i lived , dealer make 17+): " + hitPlayerCards.getValue() + " dealer: " +hitDealerCards.getValue());
			}else{
				normal++;
				System.out.println(hitPlayerCards.getCards().get(hitPlayerCards.getCards().size()-1).getValue() +" normal (i live here, nice): " + hitPlayerCards.getValue() + " dealer: " +hitDealerCards.getValue());
			}
		}
		
		if(hitDealerCards.getValue() >= BlackJackInfo.DealerStop){
			draw++;
		}
		
		return new double[]{win,draw,lose,better,normal,worse};
	}
	
	*/
	
	public static void main(String[] args){
//		HelloWorld.printDoubleWDL(calcPlayerdVSDealerProbs(new PlayerCardsPathValue(Card.Four4,Card.Six6), Card.Six6));
		HelloWorld.printDoubleWDL(calcPlayerVSDealerAnaylzeStatus(GenerateCardsUtil.hitPlayerOneMoreCard(new PlayerCardsPathValue(Card.Four4,Card.Six6)), Card.Six6));
	}
}
