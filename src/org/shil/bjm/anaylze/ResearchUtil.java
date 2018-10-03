package org.shil.bjm.anaylze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.DeckSet;
import org.shil.bjm.meta.PlayerCardsPathValue;

public class ResearchUtil {
	
	public static List<ResearchPair> listResearchPairs() {
		List<ResearchPair> researchPairs = new ArrayList<>();
		//8
		researchPairs.add(new ResearchPair(new PlayerCardsPathValue(Card.Three3,Card.Five5), Card.Six6));
		//9
		researchPairs.add(new ResearchPair(new PlayerCardsPathValue(Card.Three3,Card.Six6), Card.Three3));
		researchPairs.add(new ResearchPair(new PlayerCardsPathValue(Card.Three3,Card.Six6), Card.Seven7));
		//12
		researchPairs.add(new ResearchPair(new PlayerCardsPathValue(Card.Ten,Card.Two2), Card.Two2));
		researchPairs.add(new ResearchPair(new PlayerCardsPathValue(Card.Ten,Card.Two2), Card.Three3));
		//15
		researchPairs.add(new ResearchPair(new PlayerCardsPathValue(Card.Seven7,Card.Eight8), Card.Seven7));
		researchPairs.add(new ResearchPair(new PlayerCardsPathValue(Card.Seven7,Card.Eight8), Card.Eight8));
		researchPairs.add(new ResearchPair(new PlayerCardsPathValue(Card.Seven7,Card.Eight8), Card.Nine9));
		researchPairs.add(new ResearchPair(new PlayerCardsPathValue(Card.Seven7,Card.Eight8), Card.Ten));
		//16
		researchPairs.add(new ResearchPair(new PlayerCardsPathValue(Card.Seven7,Card.Nine9), Card.Seven7));
		researchPairs.add(new ResearchPair(new PlayerCardsPathValue(Card.Seven7,Card.Nine9), Card.Eight8));
		researchPairs.add(new ResearchPair(new PlayerCardsPathValue(Card.Seven7,Card.Nine9), Card.Nine9));
		researchPairs.add(new ResearchPair(new PlayerCardsPathValue(Card.Seven7,Card.Nine9), Card.Ten));
		//Ax vs 456
		researchPairs.add(new ResearchPair(new PlayerCardsPathValue(Card.One1,Card.Two2), Card.Four4));
		researchPairs.add(new ResearchPair(new PlayerCardsPathValue(Card.One1,Card.Two2), Card.Five5));
		researchPairs.add(new ResearchPair(new PlayerCardsPathValue(Card.One1,Card.Two2), Card.Six6));
		
		researchPairs.add(new ResearchPair(new PlayerCardsPathValue(Card.One1,Card.Three3), Card.Four4));
		researchPairs.add(new ResearchPair(new PlayerCardsPathValue(Card.One1,Card.Three3), Card.Five5));
		researchPairs.add(new ResearchPair(new PlayerCardsPathValue(Card.One1,Card.Three3), Card.Six6));
		
		researchPairs.add(new ResearchPair(new PlayerCardsPathValue(Card.One1,Card.Four4), Card.Four4));
		researchPairs.add(new ResearchPair(new PlayerCardsPathValue(Card.One1,Card.Four4), Card.Five5));
		researchPairs.add(new ResearchPair(new PlayerCardsPathValue(Card.One1,Card.Four4), Card.Six6));
		
		researchPairs.add(new ResearchPair(new PlayerCardsPathValue(Card.One1,Card.Five5), Card.Four4));
		researchPairs.add(new ResearchPair(new PlayerCardsPathValue(Card.One1,Card.Five5), Card.Five5));
		researchPairs.add(new ResearchPair(new PlayerCardsPathValue(Card.One1,Card.Five5), Card.Six6));
		
		researchPairs.add(new ResearchPair(new PlayerCardsPathValue(Card.One1,Card.Six6), Card.Four4));
		researchPairs.add(new ResearchPair(new PlayerCardsPathValue(Card.One1,Card.Six6), Card.Five5));
		researchPairs.add(new ResearchPair(new PlayerCardsPathValue(Card.One1,Card.Six6), Card.Six6));

		Collections.sort(researchPairs);
		
		return researchPairs;
	}
	
	
	public static void testDeckMinusTen2Ten() {
		List<DealerVSPlayerChance> dealerVSPlayerChances = new ArrayList<>();

		for(int i=-10;i<=10;i++) {
			DeckSet.resetValue = i;
			List<ResearchPair> researchPairs = listResearchPairs();
			for(ResearchPair researchPair : researchPairs) {
				DealerVSPlayerChance dealerVSPlayerChance = RivalAnalyzeUtil.analyzeResearchPair(researchPair);
				dealerVSPlayerChance.setDeckStatus(DeckSet.resetValue);
				dealerVSPlayerChances.add(dealerVSPlayerChance);
			}
		}
		Collections.sort(dealerVSPlayerChances);
		HelloWorld.print(dealerVSPlayerChances);

	}
	

	public static void main(String[] args) {
		testDeckMinusTen2Ten();
	}

}
