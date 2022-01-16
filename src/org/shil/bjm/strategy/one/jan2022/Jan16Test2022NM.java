package org.shil.bjm.strategy.one.jan2022;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.anaylze.PlayersVSDealersResultChanceProb;
import org.shil.bjm.core.PlayerCards;
import org.shil.bjm.meta.*;
import org.shil.bjm.strategy.PlayerStrategy;
import org.shil.bjm.strategy.PlayerStrategyMatrix;
import org.shil.bjm.strategy.Strategy;
import org.shil.bjm.strategy.one.OneStrategy;

import java.util.Collection;

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
            else if(startValue == StartValue.Nine){
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
            else if(startValue == StartValue.Ten) {
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
            else if(startValue == StartValue.Eleven){
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
            }else if(startValue == StartValue.Sixteen){
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
            }else if(startValue == StartValue.Seventeen){
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
//        compare();

        PlayerCardsPathValue oc = new PlayerCardsPathValue(Card.Ten,Card.Seven7);
        Card dealerCard = Card.Ten;

        Strategy oneStrategy = new OneStrategy(Jan16Test2022NM.SELF,null,null);
        Collection<PlayerCardsPathValue> nowlist = oneStrategy.generatePlayerCardsPaths(oc, dealerCard);
        HelloWorld.print(nowlist);

        System.out.println("now:");
        double[] all = new double[3];
        double nowM = 0d;
        for(PlayerCardsPathValue pcpv : nowlist){
            double t = 0;
            PlayerCardsPathValue one = new PlayerCardsPathValue(pcpv);
            Collection<PlayerCardsPathValue> oneList = oneStrategy.generatePlayerCardsPaths(one, dealerCard);
            double[] wdl = PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatus(oneList, dealerCard);
            all[0] += wdl[0];
            all[1] += wdl[1];
            all[2] += wdl[2];

            t = ProfitUtil.moneyCalcOneHandInReturnProb(oneList,dealerCard);
            nowM += t;
            System.out.println( pcpv.getValue() + " : " + t);
        }
        HelloWorld.printDoubleWDL(all);
        double tall = all[0]+all[1]+all[2];
        double[] nows = new double[]{all[0]/tall,all[1]/tall,all[2]/tall};
        HelloWorld.printDoubleWDL(nows);
        System.out.println("now Money: " + nowM);

        System.out.println();

        oc.reset();

        System.out.println("before:");
        Strategy beforeOneStrategy =  new OneStrategy(MirrorJan16Test2022NM.SELF,null,null);
        Collection<PlayerCardsPathValue> beforelist = beforeOneStrategy.generatePlayerCardsPaths(oc, dealerCard);
        HelloWorld.print(beforelist);
        double[] beforeAll = new double[3];
        double beforeM = 0d;
        for(PlayerCardsPathValue pcpv : beforelist){
//            System.out.println("Player: " +pcpv.getCards());
            double t = 0;
            PlayerCardsPathValue oneCalc = new PlayerCardsPathValue(pcpv);
            Collection<PlayerCardsPathValue> oneList = beforeOneStrategy.generatePlayerCardsPaths(oneCalc, dealerCard);
            double[] wdl = PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatus(oneList, dealerCard);
            beforeAll[0] += wdl[0];
            beforeAll[1] += wdl[1];
            beforeAll[2] += wdl[2];

            t = ProfitUtil.moneyCalcOneHandInReturnProb(oneList,dealerCard);
            beforeM += t;
            System.out.println( pcpv.getValue() + " : " + t);
        }
        HelloWorld.printDoubleWDL(beforeAll);
        double btall = beforeAll[0]+beforeAll[1]+beforeAll[2];
        double[] befores = new double[]{beforeAll[0]/btall,beforeAll[1]/btall,beforeAll[2]/btall};
        HelloWorld.printDoubleWDL(befores);
        System.out.println("before Money: " + beforeM);

        System.out.println();

        System.out.println(HelloWorld.builder2DoubleWDL(nows,befores));
    }

    public static void compare(){
        Collection<PlayerCardsPathValue> playerCards = PlayerCards.generateTwoStartCardsWithoutPairWithoutA();
        OneStrategy oneStrategy = new OneStrategy(Jan16Test2022NM.SELF,null,null);

        System.out.println("now:");
        double[] all = new double[3];
        double nowM = 0d;
        for(PlayerCardsPathValue pcpv : playerCards){
//            System.out.println("Player: " +pcpv.getCards());
            double t = 0;
            for(Card dealerCard : Card.values()) {
                PlayerCardsPathValue oneCalc = new PlayerCardsPathValue(pcpv);
                Collection<PlayerCardsPathValue> oneList = oneStrategy.generatePlayerCardsPaths(oneCalc, dealerCard);
                double[] wdl = PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatus(oneList, dealerCard);
                all[0] += wdl[0];
                all[1] += wdl[1];
                all[2] += wdl[2];

                nowM += ProfitUtil.moneyCalcOneHandInReturnProb(oneList,dealerCard);
                t = ProfitUtil.moneyCalcOneHandInReturnProb(oneList,dealerCard);
                nowM += t;
            }
            System.out.println( pcpv.getValue() + " : " + t);
        }
        HelloWorld.printDoubleWDL(all);
        System.out.println("now Money: " + nowM);

        System.out.println();

        System.out.println("before:");
        OneStrategy beforeOneStrategy = new OneStrategy(MirrorJan16Test2022NM.SELF,null,null);
        double[] beforeAll = new double[3];
        double beforeM = 0d;
        for(PlayerCardsPathValue pcpv : playerCards){
//            System.out.println("Player: " +pcpv.getCards());
            double t = 0;
            for(Card dealerCard : Card.values()) {
                PlayerCardsPathValue oneCalc = new PlayerCardsPathValue(pcpv);
                Collection<PlayerCardsPathValue> oneList = beforeOneStrategy.generatePlayerCardsPaths(oneCalc, dealerCard);
                double[] wdl = PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatus(oneList, dealerCard);
                beforeAll[0] += wdl[0];
                beforeAll[1] += wdl[1];
                beforeAll[2] += wdl[2];

                t = ProfitUtil.moneyCalcOneHandInReturnProb(oneList,dealerCard);
                beforeM += t;
            }
            System.out.println( pcpv.getValue() + " : " + t);
        }

        HelloWorld.printDoubleWDL(beforeAll);
        System.out.println("before Money: " + beforeM);

    }

    public static void testAllWDL(){
//      Collection<PlayerCardsPathValue> playerCards = PlayerCards.generateTwoStartCards();
//		Collection<PlayerCardsPathValue> playerCards = PlayerCards.generatePairs();
//		Collection<PlayerCardsPathValue> playerCards = PlayerCards.sortedOneValueStartCardsWithA();
        Collection<PlayerCardsPathValue> playerCards = PlayerCards.generateTwoStartCardsWithoutPairWithoutA();
        OneStrategy oneStrategy = new OneStrategy(Jan16Test2022NM.SELF,null,null);

        double[] all = new double[3];
        for(PlayerCardsPathValue pcpv : playerCards){
            System.out.println("Player: " +pcpv.getCards());
            for(Card dealerCard : Card.values()) {
                PlayerCardsPathValue oneCalc = new PlayerCardsPathValue(pcpv);
                Collection<PlayerCardsPathValue> oneList = oneStrategy.generatePlayerCardsPaths(oneCalc, dealerCard);
                double[] wdl = PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatus(oneList, dealerCard);
                all[0] += wdl[0];
                all[1] += wdl[1];
                all[2] += wdl[2];
            }
        }

        HelloWorld.printDoubleWDL(all);
    }

}
