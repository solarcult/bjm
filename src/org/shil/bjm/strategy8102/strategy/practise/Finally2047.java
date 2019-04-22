package org.shil.bjm.strategy8102.strategy.practise;

import java.util.HashMap;
import java.util.Map;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerAction;
import org.shil.bjm.meta.StartValue;
import org.shil.bjm.strategy8102.EvolutionOneWayTest;
import org.shil.bjm.strategy8102.strategy.MatrixKey;
import org.shil.bjm.strategy8102.strategy.Seven8012;
import org.shil.bjm.strategy8102.strategy.Situation;
import org.shil.bjm.strategy8102.strategy.StrategyMatrix8012;

/**
 * will use this next time
 * 2018-Sep-10 23:00
 * I guess but I will imporve it now,casue the realmatch test is terrible, Sep-23th
 * 2019-Feb-01 上个星期去澳门用的就是这套算法,打了3天.以后就用这个.
 */
public class Finally2047 extends Seven8012 {

	public Finally2047() {
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
			if(dealerCard == Card.Three3) {
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(9), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Double);
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(9), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Double);
			}else if(dealerCard == Card.Four4 || dealerCard == Card.Five5 || dealerCard == Card.Six6 ){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(9), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Double);
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(9), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Double);
			}else{
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(9), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(9), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
			}
		}
		//10
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard.getValue() >=2 && dealerCard.getValue() <=9){
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
				//Done, not double, just hit
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(11), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(11), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
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
				//hit is better move win 1.6 and lose 3.2 to draw
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Stand);
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Stand);
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Three_More_Cards);
				notChangesMatrix.put(Three_More_Cards, PlayerAction.Stand);
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
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Stand);
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(13), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Stand);
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(13), dealerCard, Situation.Three_More_Cards);
				notChangesMatrix.put(Three_More_Cards, PlayerAction.Stand);
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
				//save a little bit more money in ROI research
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Giveup);
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Three_More_Cards);
				notChangesMatrix.put(Three_More_Cards, PlayerAction.Hit);
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
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Three_More_Cards);
				notChangesMatrix.put(Three_More_Cards, PlayerAction.Hit);
			}else if(dealerCard.getValue() == 8 ){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Three_More_Cards);
				notChangesMatrix.put(Three_More_Cards, PlayerAction.Hit);
			}else if(dealerCard.getValue() == 9 ){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Giveup);
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Three_More_Cards);
				notChangesMatrix.put(Three_More_Cards, PlayerAction.Hit);
			}else if(dealerCard.getValue() == 10 ){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Giveup);
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Stand);
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Three_More_Cards);
				notChangesMatrix.put(Three_More_Cards, PlayerAction.Stand);
			}
			else{
				//A
				//same result if the cards give to dealer
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Three_More_Cards);
				notChangesMatrix.put(Three_More_Cards, PlayerAction.Hit);
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
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Three_More_Cards);
				notChangesMatrix.put(Three_More_Cards, PlayerAction.Hit);
			}else if(dealerCard.getValue() ==8 ){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Giveup);
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Three_More_Cards);
				notChangesMatrix.put(Three_More_Cards, PlayerAction.Hit);
			}else if(dealerCard.getValue() ==9 ){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Giveup);
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Stand);
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Three_More_Cards);
				notChangesMatrix.put(Three_More_Cards, PlayerAction.Stand);
			}else if(dealerCard.getValue() ==10 ){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Giveup);
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Stand);
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Three_More_Cards);
				notChangesMatrix.put(Three_More_Cards, PlayerAction.Stand);
			}
			else{
				//A
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Three_More_Cards);
				notChangesMatrix.put(Three_More_Cards, PlayerAction.Hit);
			}
		}
		
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
					//no w-l = 3 < 5.5 double decide
					MatrixKey start_With_A = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_A);
					notChangesMatrix.put(start_With_A, PlayerAction.Hit);
				}else{
					MatrixKey start_With_A = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_A);
					notChangesMatrix.put(start_With_A, PlayerAction.Hit);
				}
			}
		}
		//6
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard.getValue() >=4 && dealerCard.getValue() <=6){
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(6), dealerCard, Situation.Start_With_A);
				notChangesMatrix.put(start_With_A, PlayerAction.Double);
			}else if(dealerCard.getValue() == 3){
				//no w-l = 3 < 5.5 double decide
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(6), dealerCard, Situation.Start_With_A);
				notChangesMatrix.put(start_With_A, PlayerAction.Hit);
			}else{
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(6), dealerCard, Situation.Start_With_A);
				notChangesMatrix.put(start_With_A, PlayerAction.Hit);
			}
		}
		//7
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			//after test stand
			if(dealerCard.getValue() >=3 && dealerCard.getValue() <=6){
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.Start_With_A);
				notChangesMatrix.put(start_With_A, PlayerAction.Stand);
			}else if(dealerCard.getValue() >=9 && dealerCard.getValue() <=10){
				//after test hit
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.Start_With_A);
				notChangesMatrix.put(start_With_A, PlayerAction.Hit);
			}else if(dealerCard == Card.One1){
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.Start_With_A);
				notChangesMatrix.put(start_With_A, PlayerAction.Hit);
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
		for(int start = 2; start <= 9; start++) {
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
						notChangesMatrix.put(start_With_Pair, PlayerAction.Split);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Split);
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
						notChangesMatrix.put(start_With_Pair, PlayerAction.Split);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Split);
					}else {
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						notChangesMatrix.put(start_With_Pair, PlayerAction.Hit);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
					}
				}else if(start == 4) {
					if((dealerCard==Card.Five5)){
						//after test no split just hit
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						notChangesMatrix.put(start_With_Pair, PlayerAction.Hit);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
					}else if((dealerCard==Card.Six6)){
						//after test split , just balance with 5 and more ROI get
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						notChangesMatrix.put(start_With_Pair, PlayerAction.Hit);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
					}else {
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						notChangesMatrix.put(start_With_Pair, PlayerAction.Hit);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
					}
				}else if(start == 5) {
					if(dealerCard == Card.Six6) {
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						notChangesMatrix.put(start_With_Pair, PlayerAction.Double);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Double);
					}else if(dealerCard.getValue() >=2 && dealerCard.getValue() <=9){
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						notChangesMatrix.put(start_With_Pair, PlayerAction.Double);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Double);
					}else{
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						notChangesMatrix.put(start_With_Pair, PlayerAction.Hit);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
					}
				}else if(start == 6) {
					if(dealerCard.getValue() == 2 ){
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						notChangesMatrix.put(start_With_Pair, PlayerAction.Hit);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
					}else if(dealerCard.getValue() == 3 ){
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						notChangesMatrix.put(start_With_Pair, PlayerAction.Hit);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
					}else if(dealerCard.getValue() ==4){
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						notChangesMatrix.put(start_With_Pair, PlayerAction.Stand);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Stand);
					}else if(dealerCard.getValue() >=5 && dealerCard.getValue() <=6){
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						notChangesMatrix.put(start_With_Pair, PlayerAction.Split);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Split);
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
							notChangesMatrix.put(start_With_Pair, PlayerAction.Split);
							MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
							notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Split);
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
							notChangesMatrix.put(start_With_Pair, PlayerAction.Giveup);
							MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
							notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
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
						notChangesMatrix.put(start_With_Pair, PlayerAction.Split);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Split);
					}else if(dealerCard == Card.Two2){
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						notChangesMatrix.put(start_With_Pair, PlayerAction.Split);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Split);
					}else if(dealerCard == Card.One1) {
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						notChangesMatrix.put(start_With_Pair, PlayerAction.Hit);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
					}else if(dealerCard == Card.Eight8) {
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						notChangesMatrix.put(start_With_Pair, PlayerAction.Giveup);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
					}else if(dealerCard == Card.Nine9) {
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						notChangesMatrix.put(start_With_Pair, PlayerAction.Giveup);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Stand);
					}else {
						// 88 vs 10
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						notChangesMatrix.put(start_With_Pair, PlayerAction.Giveup);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Stand);
					}
				}else if(start == 9) {
					if((dealerCard==Card.Two2) ||(dealerCard==Card.Three3) || (dealerCard==Card.Four4)||(dealerCard==Card.Five5) || (dealerCard==Card.Six6)||(dealerCard==Card.Eight8)) {
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						notChangesMatrix.put(start_With_Pair, PlayerAction.Split);	
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Split);	
					}else if(dealerCard==Card.Seven7) {
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						notChangesMatrix.put(start_With_Pair, PlayerAction.Stand);	
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Stand);	
					}else {
						// 9, 10, A
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						notChangesMatrix.put(start_With_Pair, PlayerAction.Stand);	
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Stand);	
					}
				}
			}
		}
		
		/*
		 * Situation.Start_With_Pair 10
		 * VS
		 * DealerCard (One ~ K)
		 */
		for(Card dealerCard : Card.values()) {
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			MatrixKey start_With_Pair = new MatrixKey(StartValue.Ten, dealerCard, Situation.Start_With_Pair);
			notChangesMatrix.put(start_With_Pair, PlayerAction.Stand);
			MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.Ten, dealerCard, Situation.Splited_Pair_And_Can_Split);
			notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Stand);	
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
		one.putAll(changesMatrix);
		one.putAll(notChangesMatrix);
	}
	/*
	public PlayerAction fetchPlayAction(MatrixKey matrixKey, int count) {
		MatrixKey eightV6W = new MatrixKey(StartValue.Eight, Card.Six6, Situation.Start_Hand_WithoutA_WithoutPair);
		MatrixKey eightV6S = new MatrixKey(StartValue.Eight, Card.Six6, Situation.Splited_Pair_And_Can_NOT_Split);
		
		MatrixKey nineV3W = new MatrixKey(StartValue.Nine, Card.Three3, Situation.Start_Hand_WithoutA_WithoutPair);
		MatrixKey nineV3S = new MatrixKey(StartValue.Nine, Card.Three3, Situation.Splited_Pair_And_Can_NOT_Split);
		
		MatrixKey nineV7W = new MatrixKey(StartValue.Nine, Card.Seven7, Situation.Start_Hand_WithoutA_WithoutPair);
		MatrixKey nineV7S = new MatrixKey(StartValue.Nine, Card.Seven7, Situation.Splited_Pair_And_Can_NOT_Split);
		
		MatrixKey twV2W = new MatrixKey(StartValue.getOne(12), Card.Two2, Situation.Start_Hand_WithoutA_WithoutPair);
		MatrixKey twV2S = new MatrixKey(StartValue.getOne(12), Card.Two2, Situation.Splited_Pair_And_Can_NOT_Split);
		MatrixKey twV2C = new MatrixKey(StartValue.getOne(12), Card.Two2, Situation.Three_More_Cards);
		MatrixKey sixV2P = new MatrixKey(StartValue.Six, Card.Two2, Situation.Start_With_Pair);
		MatrixKey sixV2S = new MatrixKey(StartValue.Six, Card.Two2, Situation.Splited_Pair_And_Can_Split);
		
		
		MatrixKey twV3W = new MatrixKey(StartValue.getOne(12), Card.Three3, Situation.Start_Hand_WithoutA_WithoutPair);
		MatrixKey twV3S = new MatrixKey(StartValue.getOne(12), Card.Three3, Situation.Splited_Pair_And_Can_NOT_Split);
		MatrixKey twV3C = new MatrixKey(StartValue.getOne(12), Card.Three3, Situation.Three_More_Cards);
		MatrixKey sixV3P = new MatrixKey(StartValue.Six, Card.Three3, Situation.Start_With_Pair);
		MatrixKey sixV3S = new MatrixKey(StartValue.Six, Card.Three3, Situation.Splited_Pair_And_Can_Split);
		
		MatrixKey fifVTS = new MatrixKey(StartValue.getOne(15), Card.Ten, Situation.Splited_Pair_And_Can_NOT_Split);
		MatrixKey fifVTC = new MatrixKey(StartValue.getOne(15), Card.Ten, Situation.Three_More_Cards);
		
		MatrixKey sixtVTS = new MatrixKey(StartValue.getOne(16), Card.Nine9, Situation.Splited_Pair_And_Can_NOT_Split);
		MatrixKey sixtVTC = new MatrixKey(StartValue.getOne(16), Card.Nine9, Situation.Three_More_Cards);
		MatrixKey eigV9P = new MatrixKey(StartValue.Eight, Card.Nine9, Situation.Start_With_Pair);
		MatrixKey eigV9S = new MatrixKey(StartValue.Eight, Card.Nine9, Situation.Splited_Pair_And_Can_Split);
		
		if(eightV6W.equals(matrixKey)||eightV6S.equals(matrixKey)) {
			if(count >= 2) {
				return PlayerAction.Double;
			}
		}else if(nineV3W.equals(matrixKey)||nineV3S.equals(matrixKey)) {
			if(count <= -5) {
				return PlayerAction.Hit;
			}
		}else if(nineV7W.equals(matrixKey)||nineV7S.equals(matrixKey)) {
			if(count >= -2) {
				return PlayerAction.Double;
			}
		}else if(twV2W.equals(matrixKey)||twV2S.equals(matrixKey)||twV2C.equals(matrixKey)||sixV2P.equals(matrixKey)||sixV2S.equals(matrixKey)) {
			if(count >= 7) {
				return PlayerAction.Stand;
			}
		}else if(twV3W.equals(matrixKey)||twV3S.equals(matrixKey)||twV3C.equals(matrixKey)||sixV3P.equals(matrixKey)||sixV3S.equals(matrixKey)) {
			if(count <= -5) {
				return PlayerAction.Hit;
			}
		}else if(fifVTC.equals(matrixKey)||fifVTS.equals(matrixKey)) {
			if(count <=5 ) {
				return PlayerAction.Hit;
			}
		}else if(sixtVTC.equals(matrixKey)||sixtVTS.equals(matrixKey)||eigV9P.equals(matrixKey)||eigV9S.equals(matrixKey)) {
			if(count <=0 ) {
				return PlayerAction.Hit;
			}
		}
			
		return one.get(matrixKey);
	}
	*/
	public static void main(String[] args) {
		EvolutionOneWayTest.debug = true;
		StrategyMatrix8012 one = new Finally2047();
		StrategyMatrix8012 two = new Finally2046();
		StrategyMatrix8012 three = new Standard2017();
//		HelloWorld.printStrategyMatrix8012(one, two,three);
		System.out.println(one.diffWith(two));
		System.out.println();
		System.out.println(one.diffWith(three));
	}

}
