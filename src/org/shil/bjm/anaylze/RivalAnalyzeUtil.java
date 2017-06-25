package org.shil.bjm.anaylze;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.core.GenerateCardsUtil;
import org.shil.bjm.core.PlayerCards;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerCardsPathValue;

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
	
	public static void main(String[] args){
		List<DealerVSPlayerChance> ao = makePlayerOneMoreVSNowDealerChangeWithA();
		HelloWorld.print(ao);
	}
}
