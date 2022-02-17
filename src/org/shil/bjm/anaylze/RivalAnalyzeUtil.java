package org.shil.bjm.anaylze;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.core.GenerateCardsUtil;
import org.shil.bjm.core.PlayerCards;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerAction;
import org.shil.bjm.meta.PlayerCardsPathValue;
import org.shil.bjm.meta.ProfitUtil;
import org.shil.bjm.strategy.StrategyAATest;
import org.shil.bjm.strategy.TestPairStrategy;
import org.shil.bjm.strategy.one.Combat2017Oct16Bot;
import org.shil.bjm.strategy.one.Combat2017Oct21;
import org.shil.bjm.strategy.one.OneStrategy;
import org.shil.bjm.strategy.one.OneWithAMatrix;

/**
 * 核心数据类，记录再来一张的概率，希望没有bug. 这个类是一切研究的起点
 * @author vanis
 *
 */
public class RivalAnalyzeUtil {

	/**
	 * 对非带A的普通起手牌进行分析
	 * @return
	 */
	public static List<DealerVSPlayerChance> makePlayerWithoutAOneMoreVSDealer(){
		List<DealerVSPlayerChance> diff = new ArrayList<DealerVSPlayerChance>();
		for (PlayerCardsPathValue playerCardsPathValue : PlayerCards.sortedOneValueStartCardsWithoutA()) {
			if (playerCardsPathValue.getValue() < 3) continue;
			for (Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue; 
				DealerVSPlayerChance dealerVSPlayerChance = analyzeResearchPair(new ResearchPDair(playerCardsPathValue, dealerCard));
				diff.add(dealerVSPlayerChance);
			}
		}
		return diff;
	}
	
	/**
	 * 分析具体要一张牌与不要的概率分布
	 */
	public static DealerVSPlayerChance analyzeResearchPair(ResearchPDair researchPair) {
		Collection<PlayerCardsPathValue> playerOneMoreCards = GenerateCardsUtil.hitPlayerOneMoreCard(researchPair.getPlayerCardsPathValue());
		if(playerOneMoreCards.size()!=13) throw new RuntimeException("wtf 13");
		double[] playerOneMore = PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatus(playerOneMoreCards, researchPair.getDealerCard());
		//这里用OK的，因为是直接展示百分比
		double[] playerNow = PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatus(researchPair.getPlayerCardsPathValue(),researchPair.getDealerCard());
		return new DealerVSPlayerChance(researchPair.getDealerCard(), researchPair.getPlayerCardsPathValue().getValue(), playerNow,playerOneMore);
	}
	
	/**
	 * 对Ax的牌进行分析
	 * @return
	 */
	public static List<DealerVSPlayerChance> makePlayerWithAOneMoreVSDealer(){
		List<DealerVSPlayerChance> diff = new ArrayList<DealerVSPlayerChance>();
		for (PlayerCardsPathValue playerCardsPathValue : PlayerCards.sortedOneValueStartCardsWithA()) {
			for (Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue; 
				Collection<PlayerCardsPathValue> playerOneMoreCards = GenerateCardsUtil.hitPlayerOneMoreCard(playerCardsPathValue);
				if(playerOneMoreCards.size()!=13) throw new RuntimeException("wtf 13");
				double[] playerOneMore = PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatus(playerOneMoreCards, dealerCard);
				//这里用OK的，因为是直接展示百分比
				double[] playerNow = PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatus(playerCardsPathValue,dealerCard);
				DealerVSPlayerChance dealerVSPlayerChance = new DealerVSPlayerChance(dealerCard, OneWithAMatrix.findFirstTwoCardsWithOutA(playerCardsPathValue).getValue(), playerNow,playerOneMore);
				diff.add(dealerVSPlayerChance);
			}
		}
		return diff;
	}
	
	static StrategyAATest strategyAATest = new StrategyAATest(Combat2017Oct21.SELF);
	
	public static List<DealerVSPlayerChance> makePlayerAAVSDealer(){

		List<DealerVSPlayerChance> diff = new ArrayList<DealerVSPlayerChance>();
		for(Card dealerCard : Card.values()) {
			PlayerCardsPathValue AAs = new PlayerCardsPathValue(Card.One1,Card.One1);
			PlayerCardsPathValue AAss = new PlayerCardsPathValue(Card.One1,Card.One1);
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue; 
			Collection<PlayerCardsPathValue> normalStrategy = strategyAATest.generatePlayerCardsPaths(AAs, dealerCard);
			Collection<PlayerCardsPathValue> spliteStrategy = OneStrategy.SELF.generatePlayerCardsPaths(AAss, dealerCard);
			double[] normal = PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatus(normalStrategy,dealerCard);

			double[] splits = PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatus(spliteStrategy,dealerCard);
			DealerVSPlayerChance dealerVSPlayerChance = new DealerVSPlayerChance(dealerCard, OneWithAMatrix.findFirstTwoCardsWithOutA(AAs).getValue(), normal,splits);
			diff.add(dealerVSPlayerChance);
			System.out.println(dealerCard);
			System.out.println(ProfitUtil.moneyCalcOneHandInReturn(normalStrategy, dealerCard));
			System.out.println(ProfitUtil.moneyCalcOneHandInReturn(spliteStrategy, dealerCard));
		}
		
		return diff;
	}
	
	
	static TestPairStrategy testPairStrategy = new TestPairStrategy(Combat2017Oct16Bot.SELF,OneWithAMatrix.SELF);
	
	/**
	 * 使用策略对Pair进行分析
	 */
	public static void makePlayerOneMoreVSNowDealerChangeWithPair(){
		
		for (PlayerCardsPathValue playerCardsPathValue : PlayerCards.generatePairs()) {
			if(playerCardsPathValue.getCards().get(0).getValue()==1) continue;
			System.out.println("\t\t"+playerCardsPathValue.getCards().get(0));
			for (Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				PlayerCardsPathValue notsplit = new PlayerCardsPathValue(playerCardsPathValue);
				double nowROI = ProfitUtil.moneyCalcOneHandInReturn(testPairStrategy.generatePlayerCardsPaths(notsplit, dealerCard),dealerCard);
				
				PlayerCardsPathValue split = new PlayerCardsPathValue(playerCardsPathValue);
				split.setAction(PlayerAction.Split);
				double splitROI = ProfitUtil.moneyCalcOneHandInReturn(testPairStrategy.generatePlayerCardsPaths(split, dealerCard),dealerCard);
				
				System.out.println("Dealer: " + dealerCard +" \tPlayerValue: " + playerCardsPathValue.getValue() +"\n org: "+ nowROI +" -> " + splitROI + " \t result: " + ((nowROI<splitROI)?"good":"bad"));
				System.out.println("not split:");
				PlayerCardsPathValue notsplitShow = new PlayerCardsPathValue(playerCardsPathValue);
				testPairPlayerCardsPathValueVSDealerCard(notsplitShow,dealerCard);
				System.out.println("split:");
				PlayerCardsPathValue splitShow = new PlayerCardsPathValue(playerCardsPathValue);
				splitShow.setAction(PlayerAction.Split);
				testPairPlayerCardsPathValueVSDealerCard(splitShow,dealerCard);
				System.out.println();
			}
			System.out.println();
		}
		
	}
	
	public static void testPlayerCardsPathValueVSDealerCard(PlayerCardsPathValue playerCardsPathValue, Card dealerCard){
		Collection<PlayerCardsPathValue> cs = OneStrategy.SELF.generatePlayerCardsPaths(playerCardsPathValue, dealerCard);
//		HelloWorld.print(cs);
		System.out.println("ROI: " +ProfitUtil.moneyCalcOneHandInReturn(cs, dealerCard) + " cssize() "+ cs.size());
		HelloWorld.printDoubleWDL(PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatus(cs, dealerCard));
	}
	
	public static void testPairPlayerCardsPathValueVSDealerCard(PlayerCardsPathValue playerCardsPathValue, Card dealerCard){
		Collection<PlayerCardsPathValue> cs = testPairStrategy.generatePlayerCardsPaths(playerCardsPathValue, dealerCard);
//		HelloWorld.print(cs);
		System.out.println("ROI: " +ProfitUtil.moneyCalcOneHandInReturn(cs, dealerCard) + " cssize() "+ cs.size());
		HelloWorld.printDoubleWDL(PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatus(cs, dealerCard));
	}
	
	public static void testPair(){
		PlayerCardsPathValue orgin = new PlayerCardsPathValue(Card.Ten,Card.Ten);
		Card dealerCard = Card.Six6;
		
		PlayerCardsPathValue pair = new PlayerCardsPathValue(orgin);
		pair.setAction(PlayerAction.Split);
		testPairPlayerCardsPathValueVSDealerCard(new PlayerCardsPathValue(pair),dealerCard);
		
		PlayerCardsPathValue one = new PlayerCardsPathValue(orgin);
		testPairPlayerCardsPathValueVSDealerCard(new PlayerCardsPathValue(one),dealerCard);

	}
	
	public static void testVS(){
		PlayerCardsPathValue orgin = new PlayerCardsPathValue(Card.Five5,Card.Four4);
		Card dealerCard = Card.Seven7;
		
		PlayerCardsPathValue doub = new PlayerCardsPathValue(orgin);
		doub.setAction(PlayerAction.Double);
		testPlayerCardsPathValueVSDealerCard(new PlayerCardsPathValue(doub),dealerCard);
		
		PlayerCardsPathValue one = new PlayerCardsPathValue(orgin);
		one.setAction(PlayerAction.Hit);
		testPlayerCardsPathValueVSDealerCard(new PlayerCardsPathValue(one),dealerCard);
	}
	
	public static void main(String[] args){
//		List<DealerVSPlayerChance> ao = makePlayerWithAOneMoreVSDealer();
		List<DealerVSPlayerChance> ao = makePlayerWithoutAOneMoreVSDealer();
//		List<DealerVSPlayerChance> ao = makePlayerAAVSDealer();
		HelloWorld.print(ao);
		
//		testPair();
//		makePlayerOneMoreVSNowDealerChangeWithPair();
//		RivalAnalyzeUtil.testPlayerCardsPathValueVSDealerCard(new PlayerCardsPathValue(Card.Ten,Card.Ten),Card.Six6);
//		testVS();
	}
}
