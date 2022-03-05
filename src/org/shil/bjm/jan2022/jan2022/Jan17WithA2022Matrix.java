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
 * 建一个mirror比较着不同打法的收益方案.
 */
public class Jan17WithA2022Matrix extends PlayerStrategyMatrix {

	public static PlayerStrategyMatrix SELF = new Jan17WithA2022Matrix();

	public Jan17WithA2022Matrix(){
		super();
		
		for(StartValue startValue : StartValue.values()){
			if(startValue== StartValue.One){
				//should not happened because pairs AA handle this;
				continue;
			}
			//startvalue 2~3 hit
			else if(startValue.getValue() >=2 && startValue.getValue()<=3){
				for(Card dealerCard : Card.values()){
					if(dealerCard.getValue() >=5 && dealerCard.getValue() <=6){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy, playerStrategy);
					}else{
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy, playerStrategy);
					}
				}
			}
			//4~5
			else if(startValue.getValue() >=4 && startValue.getValue()<=5){
				for(Card dealerCard : Card.values()){
					if(dealerCard.getValue() >=4 && dealerCard.getValue() <=6){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy, playerStrategy);
					}else{
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy, playerStrategy);
					}
				}
			}
			else if(startValue.getValue() == 6){
				for(Card dealerCard : Card.values()){
					if(dealerCard.getValue() >=5 && dealerCard.getValue() <=6){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Double,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy, playerStrategy);
					}else{
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy, playerStrategy);
					}
				}
			}
			//7
			else if(startValue.getValue() == 7){
				for(Card dealerCard : Card.values()){
					if(dealerCard.getValue() == 1 || dealerCard.getValue() == 9 || dealerCard.getValue() == 10){
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Stand,PlayerAction.Hit);
						strategyMatrix.put(playerStrategy, playerStrategy);
					}else{
						PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Stand,PlayerAction.Stand);
						strategyMatrix.put(playerStrategy, playerStrategy);
					}
				}
			}else{
				// A+8~T stand
				for(Card dealerCard : Card.values()){
					PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Stand,PlayerAction.Stand);
					strategyMatrix.put(playerStrategy, playerStrategy);
				}
			}
		}
	}
	
	
	public static Card findFirstTwoCardsWithOutA(PlayerCardsPathValue playerCardsPathValue){
		Card withoutA = null;
		if(!playerCardsPathValue.isStartWithA()) return withoutA;
		if(playerCardsPathValue.getCards().size()<2) return withoutA;
		if(playerCardsPathValue.getCards().get(0).equals(Card.One1)){
			withoutA = playerCardsPathValue.getCards().get(1);
		}else if(playerCardsPathValue.getCards().get(1).equals(Card.One1)){
			withoutA = playerCardsPathValue.getCards().get(0);
		}else{
			throw new RuntimeException("this could not happend with A , no A in first two cards");
		}
		
		return withoutA;
	}

	public static void main(String[] args){

		PlayerCardsPathValue playerCardsPathValue = new PlayerCardsPathValue(Card.Six6,Card.One1);
		for(Card dealerCard : Card.values()){
			PlayerCardsPathValue o = new PlayerCardsPathValue(playerCardsPathValue);
			compareWA(o,dealerCard);
		}

	}

	public static void compareWA(PlayerCardsPathValue playerCardsPathValue,Card dealerCard){


		System.out.println("\n                  --- " + playerCardsPathValue.getCards().get(0)+" "+ playerCardsPathValue.getCards().get(1) +" vs "+ dealerCard + " ---");
		System.out.println();

		Jan2022Strategy oneStrategy = new Jan2022Strategy(Jan16Test2022NM.SELF,null,Jan17WithA2022Matrix.SELF);
		Collection<PlayerCardsPathValue> nowlist = oneStrategy.generate2End(playerCardsPathValue, dealerCard);
//		HelloWorld.print(nowlist);

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
		System.out.println(totalMatch +" : now Money: " + nowM +" ,effect: "+ nowM/totalMatch);
		System.out.println();

		playerCardsPathValue.reset();

		System.out.println("before:");
		Jan2022Strategy beforeOneStrategy =  new Jan2022Strategy(Jan16Test2022NM.SELF,null,MirrorJan17WithA2022Matrix.SELF);
		Collection<PlayerCardsPathValue> beforelist = beforeOneStrategy.generate2End(playerCardsPathValue, dealerCard);
//		HelloWorld.print(beforelist);

		Map<Integer, AnalyzeStatus> beofrePlayerMap = Jan172022AnalyzeUtil.analyzePlayerCardsPathValuePercent(beforelist);
		HelloWorld.printMap(beofrePlayerMap);

		System.out.println("now:");
		double [] bwdl = PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatusPrecent(beofrePlayerMap, DealerCards.analyzeDealerCardValuePrecent(dealerCard));
		HelloWorld.printDoubleWDL(bwdl);

		double beforeM = 0d;
		for(PlayerCardsPathValue pcpv : beforelist){
			PlayerCardsPathValue one = new PlayerCardsPathValue(pcpv);
			double t = Jan172022AnalyzeUtil.moneyCalcOneHandInReturnPureProb(one,dealerCard);
			beforeM += t;
		}

		int totalBMatch = beforelist.size() * DealerCards.fetchDealerCards(dealerCard).size();
		System.out.println(totalBMatch + " : Before Money: " + beforeM +" ,effect: "+ beforeM/totalBMatch);

		System.out.println(HelloWorld.builder2DoubleWDL(wdl,bwdl));
	}
}
