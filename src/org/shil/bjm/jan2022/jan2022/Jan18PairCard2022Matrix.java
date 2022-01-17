package org.shil.bjm.jan2022.jan2022;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.anaylze.AnalyzeStatus;
import org.shil.bjm.anaylze.Jan172022AnalyzeUtil;
import org.shil.bjm.anaylze.PlayersVSDealersResultChanceProb;
import org.shil.bjm.core.DealerCards;
import org.shil.bjm.jan2022.Jan2022Strategy;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerAction;
import org.shil.bjm.meta.PlayerCardsPathValue;
import org.shil.bjm.meta.StartValue;
import org.shil.bjm.strategy.PlayerStrategy;
import org.shil.bjm.strategy.PlayerStrategyMatrix;

import java.util.Collection;
import java.util.Map;

/**
 * Jan 17 Pair 2022 Matrix
 */
public class Jan18PairCard2022Matrix extends PlayerStrategyMatrix {

	public static PlayerStrategyMatrix SELF = new Jan18PairCard2022Matrix();

	public Jan18PairCard2022Matrix(){
		super();
		
		for(StartValue startValue : StartValue.values()){
			if(startValue== StartValue.One){
				for(Card dealerCard : Card.values()){					
					PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Split,PlayerAction.Split);
					strategyMatrix.put(playerStrategy, playerStrategy);
				}
			}else if(startValue.getValue() == 6){
				for(Card dealerCard : Card.values()){
					if(dealerCard.getValue() >= 2 && dealerCard.getValue() <= 6){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Split,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy, playerStrategy);
					}else{
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy, playerStrategy);
					}
				}
			}else if(startValue.getValue() == 7){
				for(Card dealerCard : Card.values()){
					if(dealerCard.getValue() >= 2 && dealerCard.getValue() <= 7){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Split,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy, playerStrategy);
					}else{
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy, playerStrategy);
					}
				}
			}else if(startValue.getValue() == 8){
				for(Card dealerCard : Card.values()){
					PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Split,PlayerAction.Hit);
					strategyMatrix.put(playerStrategy, playerStrategy);
				}
			}else if(startValue.getValue() == 9){
				for(Card dealerCard : Card.values()){
					if(dealerCard.getValue() != 7){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Split,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy, playerStrategy);
					}else{
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy, playerStrategy);
					}
				}
			}
			
		}

		PlayerStrategy playerStrategy22vs2 = new PlayerStrategy(StartValue.getOne(2), Card.Two2, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy22vs2,playerStrategy22vs2);
		PlayerStrategy playerStrategy22vs3 = new PlayerStrategy(StartValue.getOne(2), Card.Three3, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy22vs3,playerStrategy22vs3);
		PlayerStrategy playerStrategy22vs4 = new PlayerStrategy(StartValue.getOne(2), Card.Four4, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy22vs4,playerStrategy22vs4);
		PlayerStrategy playerStrategy22vs5 = new PlayerStrategy(StartValue.getOne(2), Card.Five5, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy22vs5,playerStrategy22vs5);
		PlayerStrategy playerStrategy22vs6 = new PlayerStrategy(StartValue.getOne(2), Card.Six6, PlayerAction.Split,PlayerAction.Hit);  //ok
		strategyMatrix.put(playerStrategy22vs6,playerStrategy22vs6);
		PlayerStrategy playerStrategy22vs7 = new PlayerStrategy(StartValue.getOne(2), Card.Seven7, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy22vs7,playerStrategy22vs7);
		
		PlayerStrategy playerStrategy33vs2 = new PlayerStrategy(StartValue.getOne(3), Card.Two2, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy33vs2,playerStrategy33vs2);
		PlayerStrategy playerStrategy33vs3 = new PlayerStrategy(StartValue.getOne(3), Card.Three3, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy33vs3,playerStrategy33vs3);
		PlayerStrategy playerStrategy33vs4 = new PlayerStrategy(StartValue.getOne(3), Card.Four4, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy33vs4,playerStrategy33vs4);
		PlayerStrategy playerStrategy33vs5 = new PlayerStrategy(StartValue.getOne(3), Card.Five5, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy33vs5,playerStrategy33vs5);
		PlayerStrategy playerStrategy33vs6 = new PlayerStrategy(StartValue.getOne(3), Card.Six6, PlayerAction.Split,PlayerAction.Hit);	// ok
		strategyMatrix.put(playerStrategy33vs6,playerStrategy33vs6);
		PlayerStrategy playerStrategy33vs7 = new PlayerStrategy(StartValue.getOne(3), Card.Seven7, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy33vs7,playerStrategy33vs7);

		PlayerStrategy playerStrategy44vs5 = new PlayerStrategy(StartValue.getOne(4), Card.Five5, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy44vs5,playerStrategy44vs5);
		PlayerStrategy playerStrategy44vs6 = new PlayerStrategy(StartValue.getOne(4), Card.Six6, PlayerAction.Split,PlayerAction.Hit);
		strategyMatrix.put(playerStrategy44vs6,playerStrategy44vs6);
		
	
	}

	public static void main(String[] args){
		comparePair();
	}

	public static void comparePair(){
		{
			PlayerCardsPathValue oc = new PlayerCardsPathValue(Card.Four4,Card.Four4);
			Card dealerCard = Card.Five5;

			System.out.println("\n                  --- " + oc.getCards().get(0)+" "+ oc.getCards().get(1) +" vs "+ dealerCard + " ---");
			System.out.println();

			Jan2022Strategy oneStrategy = new Jan2022Strategy(Jan16Test2022NM.SELF, Jan18PairCard2022Matrix.SELF,Jan17WithA2022Matrix.SELF);

			Collection<PlayerCardsPathValue> nowlist = oneStrategy.generate2End(oc, dealerCard);
//			HelloWorld.print(nowlist);

			Map<Integer, AnalyzeStatus> playerMap = Jan172022AnalyzeUtil.analyzePlayerCardsPathValuePercent(nowlist);
			HelloWorld.printMap(playerMap);

			System.out.println("now:");
			double [] wdl = PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatusPrecent(playerMap, DealerCards.analyzeDealerCardValuePrecent(dealerCard));
			HelloWorld.printDoubleWDL(wdl);

			double nowM = 0d;
			for(PlayerCardsPathValue pcpv : nowlist){
				PlayerCardsPathValue one = new PlayerCardsPathValue(pcpv);
				double t = Jan172022AnalyzeUtil.moneyCalcOneHandInReturnPureProb(one,dealerCard);
				nowM += t;
			}
			int totalMatch = nowlist.size() * DealerCards.fetchDealerCards(dealerCard).size();
			System.out.println(totalMatch +" : now Money: " + nowM);
			System.out.println();

			oc = new PlayerCardsPathValue(Card.Four4,Card.Four4);

			System.out.println("before:");
			Jan2022Strategy beforeOneStrategy =  new Jan2022Strategy(Jan16Test2022NM.SELF,MirrorJan16Test2022NM.SELF,Jan17WithA2022Matrix.SELF);
			Collection<PlayerCardsPathValue> beforelist = beforeOneStrategy.generate2End(oc, dealerCard);
//			HelloWorld.print(beforelist);

			Map<Integer, AnalyzeStatus> beofrePlayerMap = Jan172022AnalyzeUtil.analyzePlayerCardsPathValuePercent(beforelist);
			HelloWorld.printMap(beofrePlayerMap);

			double [] bwdl = PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatusPrecent(beofrePlayerMap, DealerCards.analyzeDealerCardValuePrecent(dealerCard));
			HelloWorld.printDoubleWDL(bwdl);

			double beforeM = 0d;
			for(PlayerCardsPathValue pcpv : beforelist){
				PlayerCardsPathValue one = new PlayerCardsPathValue(pcpv);
				double t = Jan172022AnalyzeUtil.moneyCalcOneHandInReturnPureProb(one,dealerCard);
				beforeM += t;
			}

			int totalBMatch = beforelist.size() * DealerCards.fetchDealerCards(dealerCard).size();
			System.out.println(totalBMatch + " : Before Money: " + beforeM);

			System.out.println(HelloWorld.builder2DoubleWDL(wdl,bwdl));
		}
	}
}
