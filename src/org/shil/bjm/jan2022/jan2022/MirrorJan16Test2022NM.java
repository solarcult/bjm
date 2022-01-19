package org.shil.bjm.jan2022.jan2022;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.anaylze.PlayersVSDealersResultChanceProb;
import org.shil.bjm.core.PlayerCards;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerAction;
import org.shil.bjm.meta.PlayerCardsPathValue;
import org.shil.bjm.meta.StartValue;
import org.shil.bjm.strategy.PlayerStrategy;
import org.shil.bjm.strategy.PlayerStrategyMatrix;
import org.shil.bjm.strategy.one.OneStrategy;

import java.util.Collection;

public class MirrorJan16Test2022NM extends PlayerStrategyMatrix {
    public static PlayerStrategyMatrix SELF = new MirrorJan16Test2022NM();

    public MirrorJan16Test2022NM() {
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
                        PlayerStrategy playerStrategy = new PlayerStrategy(startValue, dealerCard, PlayerAction.Hit,PlayerAction.Hit);
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
//        testAllWDL();
        MirrorJan16Test2022NM.SELF.printStrategyMatrix();
    }

    public static void testAllWDL(){
//      Collection<PlayerCardsPathValue> playerCards = PlayerCards.generateTwoStartCards();
//		Collection<PlayerCardsPathValue> playerCards = PlayerCards.generatePairs();
//		Collection<PlayerCardsPathValue> playerCards = PlayerCards.sortedOneValueStartCardsWithA();
        Collection<PlayerCardsPathValue> playerCards = PlayerCards.generateTwoStartCardsWithoutPairWithoutA();
        OneStrategy beforeOneStrategy = new OneStrategy(MirrorJan16Test2022NM.SELF,null,null);

        double[] all = new double[3];
        for(PlayerCardsPathValue pcpv : playerCards){
            System.out.println("Player: " +pcpv.getCards());
            for(Card dealerCard : Card.values()) {
                PlayerCardsPathValue oneCalc = new PlayerCardsPathValue(pcpv);
                Collection<PlayerCardsPathValue> oneList = beforeOneStrategy.generatePlayerCardsPaths(oneCalc, dealerCard);
                double[] wdl = PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatus(oneList, dealerCard);
                all[0] += wdl[0];
                all[1] += wdl[1];
                all[2] += wdl[2];
            }
        }

        HelloWorld.printDoubleWDL(all);
    }
}
