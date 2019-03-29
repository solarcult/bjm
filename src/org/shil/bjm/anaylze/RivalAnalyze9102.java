package org.shil.bjm.anaylze;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.core.DealerCards;
import org.shil.bjm.core.GenerateCardsUtil;
import org.shil.bjm.core.PlayerCards;
import org.shil.bjm.meta.BlackJackInfo;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.DealerCardsPathValue;
import org.shil.bjm.meta.FileUtil;
import org.shil.bjm.meta.PlayerAction;
import org.shil.bjm.meta.PlayerCardsPathValue;
import org.shil.bjm.meta.ProfitUtil;

/**
 * 2019Mar23 23:03 准备重新写一个分析，把概率和次数同时统计，找到一种最激进最优的打法，下次去试试。 太保守像Finally2047那种，把好的优势都浪费了。准备找一个激进的打法，下次去试试。
 * @author vanis
 *
 */
public class RivalAnalyze9102 {
	
	public static double totalProbs = 0;
	public static double totalTimes = 0;
	
	public static List<DealerVSPlayerResult9102> makePlayerWithoutAOneMoreVSDealer(){
		List<DealerVSPlayerResult9102> diff = new ArrayList<DealerVSPlayerResult9102>();
		for (PlayerCardsPathValue playerCardsPathValue : PlayerCards.sortedOneValueStartCardsWithoutA()) {
			if (playerCardsPathValue.getValue() < 8) continue;
			for (Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue; 
				DealerVSPlayerResult9102 dealerVSPlayerChance = analyzeResearchPair(new ResearchPDair(playerCardsPathValue, dealerCard));
				diff.add(dealerVSPlayerChance);
			}
		}
		return diff;
	}
	
	public static DealerVSPlayerResult9102 analyzeResearchPair(ResearchPDair researchPair) {
		
		Collection<DealerCardsPathValue> dealerCardsPathValues = DealerCards.fetchDealerCards(researchPair.getDealerCard());
		List<PlayerCardsPathValue> origin = new ArrayList<>();
		origin.add(researchPair.getPlayerCardsPathValue());
		Collection<PlayerCardsPathValue> advPlayerOneMoreCards = GenerateCardsUtil.hitPlayerOneMoreCard(researchPair.getPlayerCardsPathValue());
		DvsP2D9102 originDvP = anaylze(dealerCardsPathValues, origin);
		DvsP2D9102 advancedDvP = anaylze(dealerCardsPathValues, advPlayerOneMoreCards);
		
		return new DealerVSPlayerResult9102(researchPair.getDealerCard(), researchPair.getPlayerCardsPathValue().getStartValue().getValue(), originDvP, advancedDvP); 
	}

	public static DvsP2D9102 anaylze(Collection<DealerCardsPathValue> dealerCardsPathValues, Collection<PlayerCardsPathValue> playerCardsPathValues) {

		//纯的胜平负计数
		double winTimes = 0;
		double drawTimes = 0;
		double loseTimes = 0;
		
		//根据概率的胜平负计数
		double winProbs = 0;
		double drawProbs = 0;
		double loseProbs = 0;
		
		//赢来的钱，包含自己本金
		double returnMoney = 0;
		//总共投入的钱
		double totalSpendMoney = 0;
		
		for(PlayerCardsPathValue playerCardsPathValue : playerCardsPathValues) {
			for(DealerCardsPathValue dealerCardsPathValue : dealerCardsPathValues) {
				//playtime的含义时分牌的次数
				double playtimes = Math.pow(2, playerCardsPathValue.getSplitTimes());
				if(playtimes!=1) throw new RuntimeException("playtimes!=1 what is wrong in here? status not done: " + playerCardsPathValue.getAction());
				double multiProb =  playerCardsPathValue.prob() * dealerCardsPathValue.prob();
				
				if(playerCardsPathValue.getAction() == PlayerAction.Giveup) {
					if(playerCardsPathValue.getValue()>BlackJackInfo.BlackJack) throw new RuntimeException("should not give up but value > 21.");
					if(playerCardsPathValue.getDsTimes() > 0) throw new RuntimeException("playerCardsPathValue.getDsTimes() > 0 can't give up should not happened");
					
					loseTimes += playtimes; //这里只跟玩牌的次数有关
					loseProbs += multiProb * playtimes; //这里只跟出现的概率有关，所以乘以玩的次数
					if(playerCardsPathValue.getBetMutiV()!=0.5) throw new RuntimeException("playerCardsPathValue.getBetMutiV()!=0.5 in give up ! ");
					returnMoney += ProfitUtil.BaseMoney * playerCardsPathValue.getBetMutiV(); //这里的playerCardsPathValue.getBetMutiV()只能是0.5，如果不是0.5就说明代码有Bug。
					totalSpendMoney += ProfitUtil.BaseMoney;
					throw new RuntimeException("what is wrong in here? status not done: " + playerCardsPathValue.getAction());
				}else if(playerCardsPathValue.getAction() == PlayerAction.SplitAbandon){
					throw new RuntimeException("what is wrong in here? status not done: " + playerCardsPathValue.getAction());
				}else if(//playerCardsPathValue.getAction() == PlayerAction.Init ||
						playerCardsPathValue.getAction() == PlayerAction.Hit 
						|| playerCardsPathValue.getAction() == PlayerAction.Double
						|| playerCardsPathValue.getAction() == PlayerAction.Split){
					throw new RuntimeException("what is wrong in here? status not done: " + playerCardsPathValue.getAction());
				}
				
				if(playerCardsPathValue.getValue() > BlackJackInfo.BlackJack){
					loseTimes += playtimes;
					loseProbs += multiProb * playtimes;
					totalSpendMoney += ProfitUtil.BaseMoney * playerCardsPathValue.getBetMutiV();
					continue;
				}
				if(dealerCardsPathValue.getValue() > BlackJackInfo.BlackJack) {
					winTimes += playtimes;
					winProbs += multiProb * playtimes;
					returnMoney += 2 * ProfitUtil.BaseMoney * playerCardsPathValue.getBetMutiV();
					totalSpendMoney += ProfitUtil.BaseMoney * playerCardsPathValue.getBetMutiV();
					continue;
				}
				if(playerCardsPathValue.getValue() > dealerCardsPathValue.getValue()) {
					winTimes += playtimes;
					winProbs += multiProb * playtimes;
					returnMoney += 2 * ProfitUtil.BaseMoney * playerCardsPathValue.getBetMutiV();
					totalSpendMoney += ProfitUtil.BaseMoney * playerCardsPathValue.getBetMutiV();
					continue;
				}
				if(playerCardsPathValue.getValue() == dealerCardsPathValue.getValue()) {
					drawTimes += playtimes;
					drawProbs += multiProb * playtimes;
					continue;
				}
				if(playerCardsPathValue.getValue() < dealerCardsPathValue.getValue()) {
					loseTimes += playtimes;
					loseProbs += multiProb * playtimes;
					totalSpendMoney += ProfitUtil.BaseMoney * playerCardsPathValue.getBetMutiV();
					continue;
				}
			}
		}
		
		double totalProbs = winProbs + drawProbs + loseProbs;
		Double[] probRates = new Double[] {winProbs/totalProbs,drawProbs/totalProbs,loseProbs/totalProbs};
		
		double totalTimes = winTimes + drawTimes + loseTimes;
		Double[] timeRates  = new Double[] {winTimes/totalTimes,drawTimes/totalTimes,loseTimes/totalTimes};
		
		RivalAnalyze9102.totalProbs += totalProbs;
		RivalAnalyze9102.totalTimes += totalTimes;
		
		return new DvsP2D9102(probRates,totalProbs,timeRates,totalTimes,returnMoney,totalSpendMoney);
	}


	public static void main(String[] args) {
//		List<DealerVSPlayerChance> ao = makePlayerWithAOneMoreVSDealer();
		List<DealerVSPlayerResult9102> dealerVSPlayerResult9102s = makePlayerWithoutAOneMoreVSDealer();
//		List<DealerVSPlayerChance> ao = makePlayerAAVSDealer();
//		HelloWorld.print(ao);
		FileUtil.writeToDisk9102(dealerVSPlayerResult9102s);
	}

}
