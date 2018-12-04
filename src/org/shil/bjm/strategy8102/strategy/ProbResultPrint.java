package org.shil.bjm.strategy8102.strategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.shil.bjm.core.DealerCards;
import org.shil.bjm.core.PlayerCards;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.DealerCardsPathValue;
import org.shil.bjm.meta.FileUtil;
import org.shil.bjm.meta.PlayerCardsPathValue;
import org.shil.bjm.meta.ProfitUtil;
import org.shil.bjm.simulation.Casion6Deck;
import org.shil.bjm.strategy8102.Strategy8012;

/**
 * 为了概率论分析写的程序
 * @author vanis
 *
 */
public class ProbResultPrint {

	public static void main(String[] args) {
		testOne(new PlayerCardsPathValue(Card.Five5,Card.Seven7),Card.Nine9);
	}

	public static void all() {
		StrategyMatrix8012 finally2047 = new Finally2047();
		Collection<PlayerCardsPathValue> playerCards = PlayerCards.generateTwoStartCards();
		for(PlayerCardsPathValue pcpv : playerCards){
			for(Card dealerCard : Card.values()){
				Collection<DealerCardsPathValue> dvs = DealerCards.fetchDealerCards(dealerCard);
				PlayerCardsPathValue oneCalc = new PlayerCardsPathValue(pcpv);
				Collection<PlayerCardsPathValue> oneSet = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(), finally2047, oneCalc, dealerCard);
				List<Double> rois = new ArrayList<>(15553);
				for(PlayerCardsPathValue one : oneSet) {
					for(DealerCardsPathValue dv : dvs) {
						double roi = ProfitUtil.calcPureReturnProb(one, dv, 1000000);
						rois.add(roi);
					}
				}
				FileUtil.writeROIsToDisk(pcpv.getCards().get(0).getValue()+"+"+pcpv.getCards().get(1).getValue(),String.valueOf(dealerCard.getValue()), rois);
			}
		}
	}
	
	/**
	 * 获得指定数据
	 * @param pcpv
	 * @param dealerCard
	 */
	public static void testOne(PlayerCardsPathValue pcpv,Card dealerCard) {
		Collection<DealerCardsPathValue> dvs = DealerCards.fetchDealerCards(dealerCard);
		PlayerCardsPathValue oneCalc = new PlayerCardsPathValue(pcpv);
		Collection<PlayerCardsPathValue> oneSet = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(), new Finally2047(), oneCalc, dealerCard);
		List<Double> rois = new ArrayList<>(15553);
		for(PlayerCardsPathValue one : oneSet) {
			for(DealerCardsPathValue dv : dvs) {
				double roi = ProfitUtil.calcPureReturnProb(one, dv, 1000000000);
				rois.add(roi);
			}
		}
		FileUtil.writeROIsToDisk(pcpv.getCards().get(0).getValue()+"+"+pcpv.getCards().get(1).getValue(),String.valueOf(dealerCard.getValue()), rois);
	}
	
}
