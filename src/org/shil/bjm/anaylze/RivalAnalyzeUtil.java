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
import org.shil.bjm.strategy.ProfitUtil;
import org.shil.bjm.strategy.one.OneStrategy;
import org.shil.bjm.strategy.one.OneWithAMatrix;

public class RivalAnalyzeUtil {

	public static List<DealerVSPlayerChance> makePlayerOneMoreVSNowDealerChangeWithoutA(){
		List<DealerVSPlayerChance> diff = new ArrayList<DealerVSPlayerChance>();
		for (PlayerCardsPathValue playerCardsPathValue : PlayerCards.sortedOneValueStartCardsWithoutA()) {
			if (playerCardsPathValue.getValue() < 8) continue;
			for (Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue; 
				Collection<PlayerCardsPathValue> playerOneMoreCards = GenerateCardsUtil.hitPlayerOneMoreCard(playerCardsPathValue);
				if(playerOneMoreCards.size()!=13) throw new RuntimeException("wtf 13");
				double[] playerOneMore = PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatus(playerOneMoreCards, dealerCard);
				double[] playerNow = PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatus(playerCardsPathValue,dealerCard);
				DealerVSPlayerChance dealerVSPlayerChance = new DealerVSPlayerChance(dealerCard, playerCardsPathValue.getValue(), playerNow,playerOneMore);
				diff.add(dealerVSPlayerChance);
			}
		}
		return diff;
	}
	
	public static List<DealerVSPlayerChance> makePlayerOneMoreVSNowDealerChangeWithA(){
		List<DealerVSPlayerChance> diff = new ArrayList<DealerVSPlayerChance>();
		for (PlayerCardsPathValue playerCardsPathValue : PlayerCards.sortedOneValueStartCardsWithA()) {
			for (Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue; 
				Collection<PlayerCardsPathValue> playerOneMoreCards = GenerateCardsUtil.hitPlayerOneMoreCard(playerCardsPathValue);
				if(playerOneMoreCards.size()!=13) throw new RuntimeException("wtf 13");
				double[] playerOneMore = PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatus(playerOneMoreCards, dealerCard);
				double[] playerNow = PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatus(playerCardsPathValue,dealerCard);
				DealerVSPlayerChance dealerVSPlayerChance = new DealerVSPlayerChance(dealerCard, OneWithAMatrix.findFirstTwoCardsWithOutA(playerCardsPathValue).getValue(), playerNow,playerOneMore);
				diff.add(dealerVSPlayerChance);
			}
		}
		return diff;
	}
	
	public static void makePlayerOneMoreVSNowDealerChangeWithPair(){
		for (PlayerCardsPathValue playerCardsPathValue : PlayerCards.generatePairs()) {
			
			System.out.println("\t\t"+playerCardsPathValue.getCards().get(0));
			for (Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				PlayerCardsPathValue ontsplit = new PlayerCardsPathValue(playerCardsPathValue);
				double nowROI = ProfitUtil.moneyCalcOneHandInReturn(OneStrategy.SELF.generatePlayerCardsPaths(ontsplit, dealerCard),dealerCard);
				
				PlayerCardsPathValue split = new PlayerCardsPathValue(playerCardsPathValue);
				split.setAction(PlayerAction.Split);
				double splitROI = ProfitUtil.moneyCalcOneHandInReturn(OneStrategy.SELF.generatePlayerCardsPaths(split, dealerCard),dealerCard);
				
				System.out.println("Dealer: " + dealerCard +" \tPlayerValue: " + playerCardsPathValue.getValue() +"\n org: "+ nowROI +" -> " + splitROI + " \t result: " + ((nowROI<splitROI)?"good":"bad"));
				System.out.println("not split:");
				PlayerCardsPathValue notsplitShow = new PlayerCardsPathValue(playerCardsPathValue);
				testPlayerCardsPathValueVSDealerCard(notsplitShow,dealerCard);
				System.out.println("split:");
				PlayerCardsPathValue splitShow = new PlayerCardsPathValue(playerCardsPathValue);
				splitShow.setAction(PlayerAction.Split);
				testPlayerCardsPathValueVSDealerCard(splitShow,dealerCard);
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
	
	public static void testPair(){
		PlayerCardsPathValue orgin = new PlayerCardsPathValue(Card.Four4,Card.Four4);
		Card dealerCard = Card.Seven7;
		
		PlayerCardsPathValue pair = new PlayerCardsPathValue(orgin);
		pair.setAction(PlayerAction.Split);
		testPlayerCardsPathValueVSDealerCard(new PlayerCardsPathValue(pair),dealerCard);
		
		PlayerCardsPathValue one = new PlayerCardsPathValue(orgin);
		testPlayerCardsPathValueVSDealerCard(new PlayerCardsPathValue(one),dealerCard);

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
//		List<DealerVSPlayerChance> ao = makePlayerOneMoreVSNowDealerChangeWithA();
//		List<DealerVSPlayerChance> ao = makePlayerOneMoreVSNowDealerChangeWithPair();
//		HelloWorld.print(ao);
		
		makePlayerOneMoreVSNowDealerChangeWithPair();
//		RivalAnalyzeUtil.testPlayerCardsPathValueVSDealerCard(new PlayerCardsPathValue(Card.Two2,Card.Seven7),Card.Seven7);
//		testVS();
	}
}
