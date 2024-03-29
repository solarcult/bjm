package org.shil.bjm.strategy8102.strategy;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.core.DealerCards;
import org.shil.bjm.core.PlayerCards;
import org.shil.bjm.meta.*;
import org.shil.bjm.simulation.Casion6Deck;
import org.shil.bjm.strategy8102.EvolutionOneWayTest;
import org.shil.bjm.strategy8102.Strategy8012;
import org.shil.bjm.strategy8102.strategy.MatrixKey;
import org.shil.bjm.strategy8102.strategy.Seven8012;
import org.shil.bjm.strategy8102.strategy.Situation;

import java.util.*;

/**
 * 2022.01.15每次去我double都会输好多次好多钱,回来怀疑自我了都,我重新用RivalAnalyzeUtil分析了概率,提高了double的阈值+10%,降低了Surrender的阈值-45%,因为在没有大量资本的情况下,降低冒险double和增加投降的次数,可以保证资金存续.
 */
public class StrategyMatrix2022Jan16 extends Seven8012 {

    protected StrategyMatrix2022Jan16(){
        super();
        Map<MatrixKey,PlayerAction> changesMatrix = new HashMap<>();
        /*
         * Situation.Start_Hand_WithoutA_WithoutPair [9~16]
         * VS
         * DealerCard  (One ~ K)
         */

        //9
        for(Card dealerCard : Card.values()){
            if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
            if(dealerCard == Card.Five5 || dealerCard == Card.Six6 ){
                MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(9), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
                notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Double);
                MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(9), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
                notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Double);
            }else{
                MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(9), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
                changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
                MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(9), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
                changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
            }
        }
        //10
        for(Card dealerCard : Card.values()){
            if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
            if(dealerCard.getValue() >=2 && dealerCard.getValue() <=8){
                MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(10), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
                notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Double);
                MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(10), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
                notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Double);
            }else{
                MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(10), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
                notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
                MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(10), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
                notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
            }
        }
        //11
        for(Card dealerCard : Card.values()){
            if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
            if(dealerCard.getValue() >=2 && dealerCard.getValue() <=9){
                MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(11), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
                notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Double);
                MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(11), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
                notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Double);
            }else if(dealerCard.getValue()==10){
                MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(11), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
                changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
                MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(11), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
                changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
            }else{
                MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(11), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
                notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
                MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(11), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
                notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
            }
        }
        //12
        for(Card dealerCard : Card.values()){
            if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
            if(dealerCard.getValue() == 2 ){
                MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
                notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
                MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
                notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
                MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Three_More_Cards);
                notChangesMatrix.put(Three_More_Cards, PlayerAction.Hit);
            }else if(dealerCard.getValue() == 3 ){
                MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
                changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Stand);
                MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
                changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Stand);
                MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Three_More_Cards);
                changesMatrix.put(Three_More_Cards, PlayerAction.Stand);
            }else if(dealerCard.getValue() >=4 && dealerCard.getValue() <=6){
                MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
                notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Stand);
                MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
                notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Stand);
                MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Three_More_Cards);
                notChangesMatrix.put(Three_More_Cards, PlayerAction.Stand);
            }else{
                MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
                notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
                MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
                notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
                MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Three_More_Cards);
                notChangesMatrix.put(Three_More_Cards, PlayerAction.Hit);
            }
        }
        //13
        for(Card dealerCard : Card.values()){
            if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
            if(dealerCard.getValue() >=3 && dealerCard.getValue() <=6){
                MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(13), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
                notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Stand);
                MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(13), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
                notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Stand);
                MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(13), dealerCard, Situation.Three_More_Cards);
                notChangesMatrix.put(Three_More_Cards, PlayerAction.Stand);
            }else if(dealerCard.getValue() == 2) {
                MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(13), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
                changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Stand);
                MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(13), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
                changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Stand);
                MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(13), dealerCard, Situation.Three_More_Cards);
                changesMatrix.put(Three_More_Cards, PlayerAction.Stand);
            }else if(dealerCard.getValue() == 7 || dealerCard.getValue() == 8){
                MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(13), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
                notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
                MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(13), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
                notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
                MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(13), dealerCard, Situation.Three_More_Cards);
                notChangesMatrix.put(Three_More_Cards, PlayerAction.Hit);
            }else{
                //9,T,A
                //same result if the cards give to dealer
                MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(13), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
                notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
                MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(13), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
                notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
                MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(13), dealerCard, Situation.Three_More_Cards);
                notChangesMatrix.put(Three_More_Cards, PlayerAction.Hit);
            }
        }
        //14
        for(Card dealerCard : Card.values()){
            if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
            if(dealerCard.getValue() >=2 && dealerCard.getValue() <=6){
                MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
                notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Stand);
                MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
                notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Stand);
                MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Three_More_Cards);
                notChangesMatrix.put(Three_More_Cards, PlayerAction.Stand);
            }else if(dealerCard.getValue() == 7){
                MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
                notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
                MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
                notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
                MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Three_More_Cards);
                notChangesMatrix.put(Three_More_Cards, PlayerAction.Hit);
            }else if(dealerCard.getValue() == 8){
                MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
                notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
                MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
                notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
                MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Three_More_Cards);
                notChangesMatrix.put(Three_More_Cards, PlayerAction.Hit);
            }else if(dealerCard.getValue() == 9){
                MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
                notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
                MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
                notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
                MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Three_More_Cards);
                notChangesMatrix.put(Three_More_Cards, PlayerAction.Hit);
            }else if(dealerCard.getValue() == 10){
                //T,J,Q,K
                //same result if the cards give to dealer
                MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
                changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Giveup);
                MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
                changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
                MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Three_More_Cards);
                changesMatrix.put(Three_More_Cards, PlayerAction.Hit);
            }
            else{
                //A
                MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
                notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
                MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
                notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
                MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Three_More_Cards);
                notChangesMatrix.put(Three_More_Cards, PlayerAction.Hit);
            }
        }
        //15
        for(Card dealerCard : Card.values()){
            if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
            if(dealerCard.getValue() >=2 && dealerCard.getValue() <=6){
                MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
                notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Stand);
                MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
                notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Stand);
                MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Three_More_Cards);
                notChangesMatrix.put(Three_More_Cards, PlayerAction.Stand);
            }else if(dealerCard.getValue() == 7 ){
                MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
                changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
                MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
                changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
                MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Three_More_Cards);
                changesMatrix.put(Three_More_Cards, PlayerAction.Hit);
            }else if(dealerCard.getValue() == 8 ){
                MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
                changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
                MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
                changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
                MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Three_More_Cards);
                changesMatrix.put(Three_More_Cards, PlayerAction.Hit);
            }else if(dealerCard.getValue() == 9 ){
                MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
                changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Giveup);
                MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
                changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
                MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Three_More_Cards);
                changesMatrix.put(Three_More_Cards, PlayerAction.Hit);
            }else if(dealerCard.getValue() == 10 ){
                MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
                changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Giveup);
                MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
                changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
                MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Three_More_Cards);
                changesMatrix.put(Three_More_Cards, PlayerAction.Hit);
            }
            else{
                //A
                //same result if the cards give to dealer
                MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
                changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
                MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
                changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
                MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Three_More_Cards);
                changesMatrix.put(Three_More_Cards, PlayerAction.Hit);
            }
        }
        //16
        for(Card dealerCard : Card.values()){
            if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
            if(dealerCard.getValue() >=2 && dealerCard.getValue() <=6){
                MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
                notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Stand);
                MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
                notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Stand);
                MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Three_More_Cards);
                notChangesMatrix.put(Three_More_Cards, PlayerAction.Stand);
            }else if(dealerCard.getValue() == 7 ){
                MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
                changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
                MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
                changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
                MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Three_More_Cards);
                changesMatrix.put(Three_More_Cards, PlayerAction.Hit);
            }else if(dealerCard.getValue() ==8 ){
                MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
                changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Giveup);
                MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
                changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
                MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Three_More_Cards);
                changesMatrix.put(Three_More_Cards, PlayerAction.Hit);
            }else if(dealerCard.getValue() ==9 ){
                MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
                changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Giveup);
                MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
                changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
                MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Three_More_Cards);
                changesMatrix.put(Three_More_Cards, PlayerAction.Hit);
            }else if(dealerCard.getValue() ==10 ){
                MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
                changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Giveup);
                MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
                changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Stand);
                MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Three_More_Cards);
                changesMatrix.put(Three_More_Cards, PlayerAction.Stand);
            }
            else{
                //A
                MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
                changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
                MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
                changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
                MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Three_More_Cards);
                changesMatrix.put(Three_More_Cards, PlayerAction.Hit);
            }
        }

        //17 vs T 投降了，哈哈哈
        MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(17), Card.Ten, Situation.Start_Hand_WithoutA_WithoutPair);
        notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Giveup);

        /*
         * Situation.Start_With_A [2~7]
         */
        for(int start = 2; start <= 5; start++) {
            for(Card dealerCard : Card.values()){
                if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
                if(dealerCard.getValue() >=5 && dealerCard.getValue() <=6){
                    MatrixKey start_With_A = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_A);
                    notChangesMatrix.put(start_With_A, PlayerAction.Double);
                }else if(dealerCard.getValue() == 4 ){
                    //TODO ?
                    MatrixKey start_With_A = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_A);
                    changesMatrix.put(start_With_A, PlayerAction.Hit);
                }else{
                    MatrixKey start_With_A = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_A);
                    notChangesMatrix.put(start_With_A, PlayerAction.Hit);
                }
            }
        }
        //6
        for(Card dealerCard : Card.values()){
            if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
            if(dealerCard.getValue() >=6 && dealerCard.getValue() <=6){
                MatrixKey start_With_A = new MatrixKey(StartValue.getOne(6), dealerCard, Situation.Start_With_A);
                notChangesMatrix.put(start_With_A, PlayerAction.Double);
            }else if(dealerCard.getValue() == 3){
                MatrixKey start_With_A = new MatrixKey(StartValue.getOne(6), dealerCard, Situation.Start_With_A);
                changesMatrix.put(start_With_A, PlayerAction.Hit);
            }else{
                MatrixKey start_With_A = new MatrixKey(StartValue.getOne(6), dealerCard, Situation.Start_With_A);
                notChangesMatrix.put(start_With_A, PlayerAction.Hit);
            }
        }
        //7
        for(Card dealerCard : Card.values()){
            if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
            if(dealerCard.getValue() >=3 && dealerCard.getValue() <=6){
                MatrixKey start_With_A = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.Start_With_A);
                changesMatrix.put(start_With_A, PlayerAction.Stand);
            }else if(dealerCard == Card.Nine9){
                MatrixKey start_With_A = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.Start_With_A);
                changesMatrix.put(start_With_A, PlayerAction.Hit);
            }else if(dealerCard == Card.Ten){
                MatrixKey start_With_A = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.Start_With_A);
                changesMatrix.put(start_With_A, PlayerAction.Hit);
            }else if(dealerCard == Card.One1){
                MatrixKey start_With_A = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.Start_With_A);
                changesMatrix.put(start_With_A, PlayerAction.Hit);
            }else {
                //2,7,8
                MatrixKey start_With_A = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.Start_With_A);
                notChangesMatrix.put(start_With_A, PlayerAction.Stand);
            }
        }

        /*
         * Situation.Start_With_Pair [2~9]
         * VS
         * DealerCard (One ~ K)
         */
        for(int start = 2; start <= 10; start++) {
            for(Card dealerCard : Card.values()) {
                if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
                if(start == 2) {
                    if((dealerCard==Card.Five5) || (dealerCard==Card.Six6)){
                        //22 vs 5 or 6
                        MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                        notChangesMatrix.put(start_With_Pair, PlayerAction.Split);
                        MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                        notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Split);
                    }else if((dealerCard==Card.Four4)){
                        //22 vs 4
                        MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                        changesMatrix.put(start_With_Pair, PlayerAction.Split);
                        MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                        changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Split);
                    }else {
                        MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                        notChangesMatrix.put(start_With_Pair, PlayerAction.Hit);
                        MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                        notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
                    }
                }else if(start == 3) {
                    if((dealerCard==Card.Five5) || (dealerCard==Card.Six6)){
                        //33 vs 5 or 6
                        MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                        changesMatrix.put(start_With_Pair, PlayerAction.Split);
                        MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                        changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Split);
                    }else if(dealerCard == Card.Four4){
                        MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                        changesMatrix.put(start_With_Pair, PlayerAction.Hit);
                        MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                        changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
                    }
                    else {
                        MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                        notChangesMatrix.put(start_With_Pair, PlayerAction.Hit);
                        MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                        notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
                    }
                }else if(start == 4) {
                    if((dealerCard==Card.Five5)){
                        //after test no split just hit
                        MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                        changesMatrix.put(start_With_Pair, PlayerAction.Hit);
                        MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                        changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
                    }else if((dealerCard==Card.Six6)){
                        //after test split , just balance with 5 and more ROI get
                        MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                        changesMatrix.put(start_With_Pair, PlayerAction.Hit);
                        MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                        changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
                    }else {
                        MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                        notChangesMatrix.put(start_With_Pair, PlayerAction.Hit);
                        MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                        notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
                    }
                }else if(start == 5) {
                    if(dealerCard == Card.Six6) {
                        MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                        changesMatrix.put(start_With_Pair, PlayerAction.Double);
                        MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                        changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Double);
                    }else if(dealerCard.getValue() >=2 && dealerCard.getValue() <=9){
                        MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                        changesMatrix.put(start_With_Pair, PlayerAction.Double);
                        MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                        changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Double);
                    }else{
                        MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                        notChangesMatrix.put(start_With_Pair, PlayerAction.Hit);
                        MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                        notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
                    }
                }else if(start == 6) {
                    if(dealerCard.getValue() == 2 ){
                        MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                        changesMatrix.put(start_With_Pair, PlayerAction.Hit);
                        MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                        changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
                    }else if(dealerCard.getValue() == 3 ){
                        MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                        changesMatrix.put(start_With_Pair, PlayerAction.Hit);
                        MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                        changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
                    }else if(dealerCard.getValue() ==4){
                        MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                        notChangesMatrix.put(start_With_Pair, PlayerAction.Stand);
                        MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                        notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Stand);
                    }else if(dealerCard.getValue() >=5 && dealerCard.getValue() <=6){
                        MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                        changesMatrix.put(start_With_Pair, PlayerAction.Split);
                        MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                        changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Split);
                    }else{
                        MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                        notChangesMatrix.put(start_With_Pair, PlayerAction.Hit);
                        MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                        notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
                    }
                }else if(start == 7) {
                    if(dealerCard==Card.Six6){
                        //77 vs 6
                        MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                        notChangesMatrix.put(start_With_Pair, PlayerAction.Split);
                        MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                        notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Split);
                    }else {
                        if(dealerCard.getValue() >=2 && dealerCard.getValue() <=3){
                            MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                            notChangesMatrix.put(start_With_Pair, PlayerAction.Stand);
                            MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                            notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Stand);
                        }else if(dealerCard.getValue() >=4 && dealerCard.getValue() <=5){
                            MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                            changesMatrix.put(start_With_Pair, PlayerAction.Split);
                            MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                            changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Split);
                        }else if(dealerCard.getValue() == 7){
                            MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                            notChangesMatrix.put(start_With_Pair, PlayerAction.Hit);
                            MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                            notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
                        }else if(dealerCard.getValue() == 8){
                            MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                            notChangesMatrix.put(start_With_Pair, PlayerAction.Hit);
                            MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                            notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
                        }else if(dealerCard.getValue() == 9){
                            MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                            notChangesMatrix.put(start_With_Pair, PlayerAction.Hit);
                            MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                            notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
                        }else if(dealerCard.getValue() == 10){
                            //T,J,Q,K
                            //same result if the cards give to dealer
                            MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                            changesMatrix.put(start_With_Pair, PlayerAction.Giveup);
                            MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                            changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
                        }
                        else{
                            //A
                            MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                            notChangesMatrix.put(start_With_Pair, PlayerAction.Hit);
                            MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                            notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
                        }
                    }
                }else if(start == 8) {
                    if((dealerCard==Card.Three3) || (dealerCard==Card.Four4)||(dealerCard==Card.Five5) || (dealerCard==Card.Six6)||(dealerCard==Card.Seven7)){
                        //88 vs 3,4,5,6,7
                        MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                        changesMatrix.put(start_With_Pair, PlayerAction.Split);
                        MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                        changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Split);
                    }else if(dealerCard == Card.Two2){
                        MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                        changesMatrix.put(start_With_Pair, PlayerAction.Split);
                        MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                        changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Split);
                    }else if(dealerCard == Card.One1) {
                        MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                        changesMatrix.put(start_With_Pair, PlayerAction.Hit);
                        MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                        changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
                    }else if(dealerCard == Card.Eight8) {
                        MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                        changesMatrix.put(start_With_Pair, PlayerAction.Giveup);
                        MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                        changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
                    }else {
                        // 88 vs 9 10
                        MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                        notChangesMatrix.put(start_With_Pair, PlayerAction.Giveup);
                        MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                        notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Stand);
                    }
                }else if(start == 9) {
                    if((dealerCard==Card.Two2) ||(dealerCard==Card.Three3) || (dealerCard==Card.Four4)||(dealerCard==Card.Five5) || (dealerCard==Card.Six6)||(dealerCard==Card.Eight8)) {
                        MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                        changesMatrix.put(start_With_Pair, PlayerAction.Split);
                        MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                        changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Split);
                    }else if(dealerCard==Card.Seven7) {
                        MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                        changesMatrix.put(start_With_Pair, PlayerAction.Stand);
                        MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                        changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Stand);
                    }else {
                        // 9, 10, A
                        MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                        notChangesMatrix.put(start_With_Pair, PlayerAction.Stand);
                        MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                        changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Stand);
                    }
                }else if(start == 10) {
                    if((dealerCard==Card.Two2) ||(dealerCard==Card.Three3) || (dealerCard==Card.Four4)||(dealerCard==Card.Five5) || (dealerCard==Card.Six6)||(dealerCard==Card.Eight8)) {
                        MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                        changesMatrix.put(start_With_Pair, PlayerAction.Stand);
                        MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                        changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Stand);
                    }else if(dealerCard==Card.Seven7) {
                        MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                        changesMatrix.put(start_With_Pair, PlayerAction.Stand);
                        MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                        changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Stand);
                    }else {
                        // 9, 10, A
                        MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
                        notChangesMatrix.put(start_With_Pair, PlayerAction.Stand);
                        MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
                        changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Stand);
                    }
                }
            }
        }

        /*
         * Situation.Start_With_Pair 11 or 1
         * VS
         * DealerCard (One ~ K)
         */
        for(Card dealerCard : Card.values()) {
            if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
            if(dealerCard == Card.One1) {
                MatrixKey start_With_A = new MatrixKey(StartValue.One, dealerCard, Situation.Start_With_Pair);
                notChangesMatrix.put(start_With_A, PlayerAction.Hit);
            }else if(dealerCard == Card.Ten) {
                MatrixKey start_With_A = new MatrixKey(StartValue.One, dealerCard, Situation.Start_With_Pair);
                notChangesMatrix.put(start_With_A, PlayerAction.Split);
            }else {
                MatrixKey start_With_A = new MatrixKey(StartValue.One, dealerCard, Situation.Start_With_Pair);
                notChangesMatrix.put(start_With_A, PlayerAction.Split);
            }
        }


//		对牌一次

        /*
         * Situation.Splited_Pair_And_Can_Split [2~9]
         * VS
         * DealerCard (One ~ K)
         */
		/*

//		对牌2次, 同时给了分牌后的普通牌场景
		/*
		 * Situation.Splited_Pair_And_Can_NOT_Split [9~16]
		 * VS
		 * DealerCard  (One ~ K)
		 */
		/*

		/*
		 * Situation.Three_More_Cards [12~16]
		 * VS
		 * DealerCard  (One ~ K)
		 */

        this.changesMatrix = changesMatrix;
        this.one = new HashMap<>();
        one.putAll(changesMatrix);
        one.putAll(notChangesMatrix);
    }
}
