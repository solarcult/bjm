package org.shil.bjm.jan2022.jan2022;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.anaylze.AnalyzeStatus;
import org.shil.bjm.anaylze.Jan172022AnalyzeUtil;
import org.shil.bjm.anaylze.PlayersVSDealersResultChanceProb;
import org.shil.bjm.core.DealerCards;
import org.shil.bjm.core.DealerCardsAnalyzeStatus;
import org.shil.bjm.core.PlayerCards;
import org.shil.bjm.jan2022.Jan2022Strategy;
import org.shil.bjm.meta.*;
import org.shil.bjm.strategy.PlayerStrategy;
import org.shil.bjm.strategy.PlayerStrategyMatrix;
import org.shil.bjm.strategy.Strategy;
import org.shil.bjm.strategy.one.OneStrategy;

import java.util.Collection;
import java.util.Map;

/**
 * 投降：
 * 14 vs T
 * 15 vs 9,T
 * 16 vs 8,9,T
 * 17 vs T
 *
 * Hit
 * 12 vs 2
 * 16 vs 7,8,9
 */
public class Jan16Test2022NM extends PlayerStrategyMatrix {
    public static PlayerStrategyMatrix SELF = new Jan16Test2022NM();

    public Jan16Test2022NM() {
        super();

        //普通牌用户策略,没有考虑到Ax的情况 和 split的情况
        for(StartValue startValue : StartValue.values()){
            if(startValue== StartValue.One) continue;
                //startvalue 2~9 hit
            else if(startValue.getValue() >=2 && startValue.getValue()<=8){
                for(Card dealerCard : Card.values()){
                    PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
                    strategyMatrix.put(playerStrategy,playerStrategy);
                }
            }
            else if(startValue == StartValue.Nine){     //test ok
                for(Card dealerCard : Card.values()){
                    if(dealerCard == Card.Five5 || dealerCard == Card.Six6){
                        PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Double,PlayerAction.Hit);
                        strategyMatrix.put(playerStrategy,playerStrategy);
                    }else{
                        PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
                        strategyMatrix.put(playerStrategy,playerStrategy);
                    }
                }
            }
            else if(startValue == StartValue.Ten) {     //test ok
                for(Card dealerCard : Card.values()){
                    if(dealerCard.getValue() >=2 && dealerCard.getValue() <=8){
                        PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Double,PlayerAction.Hit);
                        strategyMatrix.put(playerStrategy,playerStrategy);
                    }else{
                        PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
                        strategyMatrix.put(playerStrategy,playerStrategy);
                    }
                }
            }
            else if(startValue == StartValue.Eleven){   //test ok
                for(Card dealerCard : Card.values()){
                    if(dealerCard.getValue() >=2 && dealerCard.getValue() <=9){
                        PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Double,PlayerAction.Hit);
                        strategyMatrix.put(playerStrategy,playerStrategy);
                    }else{
                        PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
                        strategyMatrix.put(playerStrategy,playerStrategy);
                    }
                }
            }
            else if(startValue == StartValue.Twelve){
                for(Card dealerCard : Card.values()){
                    if(dealerCard.getValue() == 2 ){
                        PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
                        strategyMatrix.put(playerStrategy,playerStrategy);
                    }else if(dealerCard.getValue() == 3 ){
                        PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Stand,PlayerAction.Stand);
                        strategyMatrix.put(playerStrategy,playerStrategy);
                    }else if(dealerCard.getValue() >3 && dealerCard.getValue() <=6){
                        PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Stand,PlayerAction.Stand);
                        strategyMatrix.put(playerStrategy,playerStrategy);
                    }else{
                        PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
                        strategyMatrix.put(playerStrategy,playerStrategy);
                    }
                }
            }else if(startValue==StartValue.Thirteen){
                for(Card dealerCard : Card.values()){
                    if(dealerCard.getValue() >=2 && dealerCard.getValue() <=6){
                        PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Stand,PlayerAction.Stand);
                        strategyMatrix.put(playerStrategy,playerStrategy);
                    }else if(dealerCard.getValue() == 7 || dealerCard.getValue() == 8){
                        PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
                        strategyMatrix.put(playerStrategy,playerStrategy);
                    }else{
                        //9,T,A
                        //same result if the cards give to dealer
                        PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
                        strategyMatrix.put(playerStrategy,playerStrategy);
                    }
                }
            }else if(startValue==StartValue.Fourteen){
                //very hard choose
                for(Card dealerCard : Card.values()){
                    if(dealerCard.getValue() >=2 && dealerCard.getValue() <=6){
                        PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Stand,PlayerAction.Stand);
                        strategyMatrix.put(playerStrategy,playerStrategy);
                    }else if(dealerCard.getValue() == 7){
                        PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
                        strategyMatrix.put(playerStrategy,playerStrategy);
                    }else if(dealerCard.getValue() == 8){
                        PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
                        strategyMatrix.put(playerStrategy,playerStrategy);
                    }else if(dealerCard.getValue() == 9){
                        PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
                        strategyMatrix.put(playerStrategy,playerStrategy);
                    }else if(dealerCard.getValue() == 10){
                        //T,J,Q,K
                        //same result if the cards give to dealer
                        PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Giveup,PlayerAction.Hit);
                        strategyMatrix.put(playerStrategy,playerStrategy);
                    }
                    else{
                        //A
                        PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
                        strategyMatrix.put(playerStrategy,playerStrategy);
                    }
                }
            }else if(startValue == StartValue.Fifteen){
                //very hard choose
                for(Card dealerCard : Card.values()){
                    if(dealerCard.getValue() >=2 && dealerCard.getValue() <=6){
                        PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Stand,PlayerAction.Stand);
                        strategyMatrix.put(playerStrategy,playerStrategy);
                    }else if(dealerCard.getValue() == 7 ){
                        PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
                        strategyMatrix.put(playerStrategy,playerStrategy);
                    }else if(dealerCard.getValue() == 8 ){
                        PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
                        strategyMatrix.put(playerStrategy,playerStrategy);
                    }else if(dealerCard.getValue() == 9 ){
                        PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Giveup,PlayerAction.Hit);
                        strategyMatrix.put(playerStrategy,playerStrategy);
                    }else if(dealerCard.getValue() == 10 ){
                        PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Giveup,PlayerAction.Hit);
                        strategyMatrix.put(playerStrategy,playerStrategy);
                    }
                    else{
                        //A
                        //same result if the cards give to dealer
                        PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
                        strategyMatrix.put(playerStrategy,playerStrategy);
                    }
                }
            }else if(startValue == StartValue.Sixteen){     //test ok
                //very hard choose
                for(Card dealerCard : Card.values()){
                    if(dealerCard.getValue() >=2 && dealerCard.getValue() <=6){
                        PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Stand,PlayerAction.Stand);
                        strategyMatrix.put(playerStrategy,playerStrategy);
                    }else if(dealerCard.getValue() == 7 ){
                        PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
                        strategyMatrix.put(playerStrategy,playerStrategy);
                    }else if(dealerCard.getValue() ==8 ){
                        PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Giveup,PlayerAction.Hit);
                        strategyMatrix.put(playerStrategy,playerStrategy);
                    }else if(dealerCard.getValue() ==9 ){
                        PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Giveup,PlayerAction.Hit);
                        strategyMatrix.put(playerStrategy,playerStrategy);
                    }else if(dealerCard.getValue() ==10 ){
                        PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Giveup,PlayerAction.Stand);
                        strategyMatrix.put(playerStrategy,playerStrategy);
                    }
                    else{
                        //A
                        PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
                        strategyMatrix.put(playerStrategy,playerStrategy);
                    }
                }
            }else if(startValue == StartValue.Seventeen){       //test ok
                for(Card dealerCard : Card.values()){
                   if(dealerCard.getValue() == 10){
                       // i am fine, thank you
                        PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Giveup,PlayerAction.Stand);
                        strategyMatrix.put(playerStrategy,playerStrategy);
                    }
                    else{
                        PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Stand,PlayerAction.Stand);
                        strategyMatrix.put(playerStrategy,playerStrategy);
                    }
                }
            }else{
                // start >= 18 just wait , watch and pray
                for(Card dealerCard : Card.values()){
                    PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Stand,PlayerAction.Stand);
                    strategyMatrix.put(playerStrategy,playerStrategy);
                }
            }
        }

    }

    public static void main(String[] args){

//        compareEarn();

        compareWAWP();
    }

    public static void compareWAWP(){
        PlayerCardsPathValue oc = new PlayerCardsPathValue(Card.Six6,Card.Three3);
        Card dealerCard = Card.Five5;

        System.out.println("\n                  --- " + oc.getCards().get(0)+" "+ oc.getCards().get(1) +" vs "+ dealerCard + " ---");
        System.out.println();

        Jan2022Strategy jan2022Strategy = new Jan2022Strategy(Jan16Test2022NM.SELF,null,null);
        Collection<PlayerCardsPathValue> nowlist = jan2022Strategy.generate2End(oc, dealerCard);
        HelloWorld.print(nowlist);

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

        oc.reset();

        System.out.println("before:");
        Jan2022Strategy beforeOneStrategy =  new Jan2022Strategy(MirrorJan16Test2022NM.SELF,null,null);
        Collection<PlayerCardsPathValue> beforelist = beforeOneStrategy.generate2End(oc, dealerCard);
        HelloWorld.print(beforelist);

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
        System.out.println(totalBMatch + " : Before Money: " + beforeM);

        System.out.println(HelloWorld.builder2DoubleWDL(wdl,bwdl));
    }

    public static void compareEarn(){

        Collection<PlayerCardsPathValue> wawps = PlayerCards.generateTwoStartCardsWithoutPairWithoutA();
        Jan2022Strategy newStrategy = new Jan2022Strategy(Jan16Test2022NM.SELF,null,null);
        double totalE = 0d;
        for(PlayerCardsPathValue pcpv : wawps){
            for(Card dealerCard : Card.values()){
                PlayerCardsPathValue p = new PlayerCardsPathValue(pcpv);
                Collection<PlayerCardsPathValue> nowlist = newStrategy.generate2End(p, dealerCard);
//                HelloWorld.print(nowlist);

                Map<Integer, AnalyzeStatus> playerMap = Jan172022AnalyzeUtil.analyzePlayerCardsPathValuePercent(nowlist);
//                HelloWorld.printMap(playerMap);
//                System.out.println("now:");
                double [] wdl = PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatusPrecent(playerMap, DealerCards.analyzeDealerCardValuePrecent(dealerCard));
//                HelloWorld.printDoubleWDL(wdl);

                for(PlayerCardsPathValue o : nowlist){
                    PlayerCardsPathValue one = new PlayerCardsPathValue(o);
                    double t = Jan172022AnalyzeUtil.moneyCalcOneHandInReturnPureProb(one,dealerCard);
                    totalE += t;
                }
            }
        }
        System.out.println("new: " + totalE);


        Collection<PlayerCardsPathValue> wawps2 = PlayerCards.generateTwoStartCardsWithoutPairWithoutA();
        Jan2022Strategy oldStrategy = new Jan2022Strategy(BeforeJan16Test2022NM.SELF,null,null);
        double oldE = 0d;
        for(PlayerCardsPathValue pcpv : wawps2){
            for(Card dealerCard : Card.values()){
                PlayerCardsPathValue p = new PlayerCardsPathValue(pcpv);
                Collection<PlayerCardsPathValue> nowlist = oldStrategy.generate2End(p, dealerCard);
//                HelloWorld.print(nowlist);

                Map<Integer, AnalyzeStatus> playerMap = Jan172022AnalyzeUtil.analyzePlayerCardsPathValuePercent(nowlist);
//                HelloWorld.printMap(playerMap);
//                System.out.println("now:");
                double [] wdl = PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatusPrecent(playerMap, DealerCards.analyzeDealerCardValuePrecent(dealerCard));
//                HelloWorld.printDoubleWDL(wdl);

                for(PlayerCardsPathValue o : nowlist){
                    PlayerCardsPathValue one = new PlayerCardsPathValue(o);
                    double t = Jan172022AnalyzeUtil.moneyCalcOneHandInReturnPureProb(one,dealerCard);
                    oldE += t;
                }
            }
        }
        System.out.println("old: " + oldE);
    }
}
