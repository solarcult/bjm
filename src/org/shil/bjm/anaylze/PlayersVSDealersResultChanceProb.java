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
 * 核心类，计算玩家牌s和庄家牌s胜率的类，希望没有bug
 * 旧的方式是一个一个比，比较耗资源
 * 新的方式是先统计，然后再比较，貌似结果基本一致
 * simply and old fashion way to calc prob
 * @author LiangJingJing
 * @date 2017年06月24日 上午00:33:29
 * 
 * @since 2019-Mar-23 自从开启了StrategyMatrix8012系列后，这个类已经不用了，1是因为之前的计算统计好像有些问题，2是每次都分开计算太浪费时间了，3已经在那个类里用getEverythingInOneLoop()重写了。
 * @deprecated
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
	
	public static double[] calcPlayerVSDealerAnaylzeStatusPureProb(PlayerCardsPathValue playerCardsPathValue, Card dealerCard){
		Collection<PlayerCardsPathValue> players = new HashSet<PlayerCardsPathValue>();
		players.add(playerCardsPathValue);
		Map<Integer,AnalyzeStatus> playermap = AnalyzeCardsPathValue.analyzePlayerCardsPathValue(players);
		return calcPlayerVSDealerAnaylzeStatusPureProb(playermap, DealerCardsAnalyzeStatus.fetchDealerAnalyzeStatusMap(dealerCard));
	}

	public static double[] calcPlayerVSDealerAnaylzeStatusPrecent(PlayerCardsPathValue playerCardsPathValue, Card dealerCard){
		Collection<PlayerCardsPathValue> players = new HashSet<PlayerCardsPathValue>();
		players.add(playerCardsPathValue);
		Map<Integer,AnalyzeStatus> playermap = AnalyzeCardsPathValue.analyzePlayerCardsPathValue(players);
		return calcPlayerVSDealerAnaylzeStatusPrecent(playermap, DealerCardsAnalyzeStatus.fetchDealerAnalyzeStatusMap(dealerCard));
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

//	@Deprecated
//	public static double[] calcPlayerVSDealerAnaylzeStatusProb(Collection<PlayerCardsPathValue> players, Card dealerCard){
//		Map<Integer,AnalyzeStatus> playermap = AnalyzeCardsPathValue.analyzePlayerCardsPathValue(players);
//		return calcPlayerVSDealerAnaylzeStatusProb(playermap, DealerCardsAnalyzeStatus.fetchDealerAnalyzeStatusMap(dealerCard));
//	}

	public static double[] calcPlayerVSDealerAnaylzeStatusPrecent(Collection<PlayerCardsPathValue> players, Card dealerCard){
		Map<Integer,AnalyzeStatus> playermap = AnalyzeCardsPathValue.analyzePlayerCardsPathValue(players);
		return calcPlayerVSDealerAnaylzeStatusPrecent(playermap, DealerCardsAnalyzeStatus.fetchDealerAnalyzeStatusMap(dealerCard));
	}
	
	/*
	//why use precent? i this should use prob()
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
	*/
	
	/**
	 * 返回原始的胜负平数值概率
	 * 你还别觉得不对，用 加起来，转换成 除以all 算出来的更离谱
	 * @param playermap
	 * @param dealermap
	 * @return
	 */
	public static double[] calcPlayerVSDealerAnaylzeStatusPureProb(Map<Integer,AnalyzeStatus> playermap, Map<Integer,AnalyzeStatus> dealermap){
		double winrate = 0;
		double drawrate = 0;
		double loserate = 0;
		
		for(Entry<Integer,AnalyzeStatus> pe : playermap.entrySet()){
			for(Entry<Integer,AnalyzeStatus> de : dealermap.entrySet()){
				AnalyzeStatus pa = pe.getValue();
				AnalyzeStatus da = de.getValue();
				if(pa.getValue() > BlackJackInfo.BlackJack){
					loserate += pa.getProb() * da.getProb();
				}else if(da.getValue() > BlackJackInfo.BlackJack){
					winrate += pa.getProb() * da.getProb();
				}else if(pa.getValue() > da.getValue()){
					winrate += pa.getProb() * da.getProb();
				}else if(pa.getValue() < da.getValue()){
					loserate += pa.getProb() * da.getProb();
				}else if(pa.getValue() == da.getValue()){
					drawrate += pa.getProb() * da.getProb();
				}
			}
		}
				
		return new double[]{winrate,drawrate,loserate};
	}

	
	/**
	 * 如果上层结果直接展示这个百分比结论是没问题的，但拿来再进一步处理就没有原始的好，请使用calcPlayerVSDealerAnaylzeStatusProb
	 * @param playermap
	 * @param dealermap
	 * @return
	 */
	public static double[] calcPlayerVSDealerAnaylzeStatus(Map<Integer,AnalyzeStatus> playermap,Map<Integer,AnalyzeStatus> dealermap){
		double winrate = 0;
		double drawrate = 0;
		double loserate = 0;
		
		for(Entry<Integer,AnalyzeStatus> pe : playermap.entrySet()){
			for(Entry<Integer,AnalyzeStatus> de : dealermap.entrySet()){
				AnalyzeStatus pa = pe.getValue();
				AnalyzeStatus da = de.getValue();
				if(pa.getValue() > BlackJackInfo.BlackJack){
					loserate += pa.getProb() * da.getProb();
				}else if(da.getValue() > BlackJackInfo.BlackJack){
					winrate += pa.getProb() * da.getProb();
				}else if(pa.getValue() > da.getValue()){
					winrate += pa.getProb() * da.getProb();
				}else if(pa.getValue() < da.getValue()){
					loserate += pa.getProb() * da.getProb();
				}else if(pa.getValue() == da.getValue()){
					drawrate += pa.getProb() * da.getProb();
				}
			}
		}
		
		//由于这里返回的是比率，上层拿这个处理结果再进行预测有一些隔着靴子挠痒痒的感觉，原始数据更有意义些。 如果上层结果直接展示这个结论是没问题的，但拿来再进一步处理就没有原始的好
		double totalrate = winrate + drawrate + loserate;
		
		return new double[]{winrate/totalrate,drawrate/totalrate,loserate/totalrate};
	}

	public static double[] calcPlayerVSDealerAnaylzeStatusPrecent(Map<Integer,AnalyzeStatus> playermap,Map<Integer,AnalyzeStatus> dealermap){
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

		//由于这里返回的是比率，上层拿这个处理结果再进行预测有一些隔着靴子挠痒痒的感觉，原始数据更有意义些。 如果上层结果直接展示这个结论是没问题的，但拿来再进一步处理就没有原始的好
		//其实这个方法和上面的是一个计算结果
		double totalrate = winrate + drawrate + loserate;

		return new double[]{winrate/totalrate,drawrate/totalrate,loserate/totalrate};
	}
	
	public static void main(String[] args){
//		HelloWorld.printDoubleWDL(calcPlayerVSDealerAnaylzeStatus(GenerateCardsUtil.hitPlayerOneMoreCard(new PlayerCardsPathValue(Card.Four4,Card.Six6)), Card.Six6));
		HelloWorld.printDoubleWDL(calcPlayerVSDealerAnaylzeStatus(OneStrategy.SELF.generatePlayerCardsPaths(new PlayerCardsPathValue(Card.Two2,Card.Six6), Card.Eight8) ,Card.Eight8));
		HelloWorld.printDoubleWDL(calcPlayerVSDealerAnaylzeStatusPrecent(OneStrategy.SELF.generatePlayerCardsPaths(new PlayerCardsPathValue(Card.Two2,Card.Six6), Card.Eight8) ,Card.Eight8));
	}
}
