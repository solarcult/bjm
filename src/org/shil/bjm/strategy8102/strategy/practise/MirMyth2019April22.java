package org.shil.bjm.strategy8102.strategy.practise;

import java.util.HashMap;
import java.util.Map;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerAction;
import org.shil.bjm.meta.StartValue;
import org.shil.bjm.strategy8102.strategy.MatrixKey;
import org.shil.bjm.strategy8102.strategy.Myth2019April22;
import org.shil.bjm.strategy8102.strategy.Seven8012;
import org.shil.bjm.strategy8102.strategy.Situation;
import org.shil.bjm.strategy8102.strategy.StrategyMatrix8012;

/**
 * Test Mirror
 * @author shil
 */
public class MirMyth2019April22 extends Myth2019April22 {

	public MirMyth2019April22() {

		super();
		Map<MatrixKey,PlayerAction> changesMatrix = new HashMap<>();
		/*
		 * Situation.Start_Hand_WithoutA_WithoutPair [9~16] 
		 * VS
		 * DealerCard  (One ~ K)
		 */
		
//		//8
//		for(Card dealerCard : Card.values()){
//			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
//			if(dealerCard == Card.Two2) {
//				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(8), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
//				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
//				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(8), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
//				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
//			}else if(dealerCard == Card.Three3) {
//				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(8), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
//				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Double);
//				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(8), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
//				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Double);
//			}else if(dealerCard == Card.Four4 || dealerCard == Card.Five5 || dealerCard == Card.Six6 ){
//				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(8), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
//				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Double);
//				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(8), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
//				notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Double);
//			}else if(dealerCard == Card.Seven7 ){
//				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(8), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
//				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
//				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(8), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
//				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
//			}else{
//				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(8), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
//				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
//				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(8), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
//				notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
//			}
//		}
		
		//9
		for(Card dealerCard : Card.values()){
			//9 不应该有Splited_Pair_And_Can_NOT_Split的情况,因为9不是偶数
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard == Card.Two2) {
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(9), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(9), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
			}else if(dealerCard == Card.Three3) {
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(9), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Double);
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(9), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Double);
			}else if(dealerCard == Card.Four4 || dealerCard == Card.Five5 || dealerCard == Card.Six6 ){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(9), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Double);
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(9), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Double);
			}else if(dealerCard == Card.Seven7 ){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(9), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(9), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
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
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Double);
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(11), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Double);
			}else if(dealerCard.getValue()==10){
				//Done, not double, just hit
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(11), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(11), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
			}else{
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(11), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(11), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
			}
		}
		//12
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard.getValue() == 2 ){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.Hit);
			}else if(dealerCard.getValue() == 3 ){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.Hit);
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
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.Hit);
			}else if(dealerCard.getValue() == 10){
				//T,J,Q,K
				//same result if the cards give to dealer
				//save a little bit more money in ROI research
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
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Three_More_Cards);
				notChangesMatrix.put(Three_More_Cards, PlayerAction.Hit);
			}else if(dealerCard.getValue() == 8 ){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.Hit);
			}else if(dealerCard.getValue() == 9 ){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
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
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
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
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.Hit);
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
		
		/*
		 * Situation.Start_With_A [2~7]
		 */
		//2
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard.getValue() >=4 && dealerCard.getValue() <=6){
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(2), dealerCard, Situation.Start_With_A);
				changesMatrix.put(start_With_A, PlayerAction.Hit);
				MatrixKey splited_With_A = new MatrixKey(StartValue.getOne(2), dealerCard, Situation.Splited_With_A);
				changesMatrix.put(splited_With_A, PlayerAction.Hit);
				MatrixKey start_With_A_Three_More = new MatrixKey(StartValue.getOne(2), dealerCard, Situation.A_Three_More_Cards);
				changesMatrix.put(start_With_A_Three_More, PlayerAction.Hit);
			}else if(dealerCard.getValue() == 3){
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(2), dealerCard, Situation.Start_With_A);
				changesMatrix.put(start_With_A, PlayerAction.Hit);
				MatrixKey splited_With_A = new MatrixKey(StartValue.getOne(2), dealerCard, Situation.Splited_With_A);
				changesMatrix.put(splited_With_A, PlayerAction.Hit);
				MatrixKey start_With_A_Three_More = new MatrixKey(StartValue.getOne(2), dealerCard, Situation.A_Three_More_Cards);
				changesMatrix.put(start_With_A_Three_More, PlayerAction.Hit);
			}else{
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(2), dealerCard, Situation.Start_With_A);
				changesMatrix.put(start_With_A, PlayerAction.Hit);
				MatrixKey splited_With_A = new MatrixKey(StartValue.getOne(2), dealerCard, Situation.Splited_With_A);
				changesMatrix.put(splited_With_A, PlayerAction.Hit);
				MatrixKey start_With_A_Three_More = new MatrixKey(StartValue.getOne(2), dealerCard, Situation.A_Three_More_Cards);
				changesMatrix.put(start_With_A_Three_More, PlayerAction.Hit);
			}
		}
		//3
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard.getValue() >=3 && dealerCard.getValue() <=5){
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(3), dealerCard, Situation.Start_With_A);
				changesMatrix.put(start_With_A, PlayerAction.Hit);
				MatrixKey splited_With_A = new MatrixKey(StartValue.getOne(3), dealerCard, Situation.Splited_With_A);
				changesMatrix.put(splited_With_A, PlayerAction.Hit);
				MatrixKey start_With_A_Three_More = new MatrixKey(StartValue.getOne(3), dealerCard, Situation.A_Three_More_Cards);
				changesMatrix.put(start_With_A_Three_More, PlayerAction.Hit);
			}else if(dealerCard.getValue() == 6){
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(3), dealerCard, Situation.Start_With_A);
				changesMatrix.put(start_With_A, PlayerAction.Double);
				MatrixKey splited_With_A = new MatrixKey(StartValue.getOne(3), dealerCard, Situation.Splited_With_A);
				changesMatrix.put(splited_With_A, PlayerAction.Double);
				MatrixKey start_With_A_Three_More = new MatrixKey(StartValue.getOne(3), dealerCard, Situation.A_Three_More_Cards);
				changesMatrix.put(start_With_A_Three_More, PlayerAction.Hit);
			}else{
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(3), dealerCard, Situation.Start_With_A);
				changesMatrix.put(start_With_A, PlayerAction.Hit);
				MatrixKey splited_With_A = new MatrixKey(StartValue.getOne(3), dealerCard, Situation.Splited_With_A);
				changesMatrix.put(splited_With_A, PlayerAction.Hit);
				MatrixKey start_With_A_Three_More = new MatrixKey(StartValue.getOne(3), dealerCard, Situation.A_Three_More_Cards);
				changesMatrix.put(start_With_A_Three_More, PlayerAction.Hit);
			}
		}
		//4
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard.getValue() >=5 && dealerCard.getValue() <=6){
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(4), dealerCard, Situation.Start_With_A);
				changesMatrix.put(start_With_A, PlayerAction.Double);
				MatrixKey splited_With_A = new MatrixKey(StartValue.getOne(4), dealerCard, Situation.Splited_With_A);
				changesMatrix.put(splited_With_A, PlayerAction.Double);
				MatrixKey start_With_A_Three_More = new MatrixKey(StartValue.getOne(4), dealerCard, Situation.A_Three_More_Cards);
				changesMatrix.put(start_With_A_Three_More, PlayerAction.Hit);
			}else if(dealerCard.getValue() == 4){
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(4), dealerCard, Situation.Start_With_A);
				changesMatrix.put(start_With_A, PlayerAction.Hit);
				MatrixKey splited_With_A = new MatrixKey(StartValue.getOne(4), dealerCard, Situation.Splited_With_A);
				changesMatrix.put(splited_With_A, PlayerAction.Hit);
				MatrixKey start_With_A_Three_More = new MatrixKey(StartValue.getOne(4), dealerCard, Situation.A_Three_More_Cards);
				changesMatrix.put(start_With_A_Three_More, PlayerAction.Hit);
			}else{
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(4), dealerCard, Situation.Start_With_A);
				changesMatrix.put(start_With_A, PlayerAction.Hit);
				MatrixKey splited_With_A = new MatrixKey(StartValue.getOne(4), dealerCard, Situation.Splited_With_A);
				changesMatrix.put(splited_With_A, PlayerAction.Hit);
				MatrixKey start_With_A_Three_More = new MatrixKey(StartValue.getOne(4), dealerCard, Situation.A_Three_More_Cards);
				changesMatrix.put(start_With_A_Three_More, PlayerAction.Hit);
			}
		}
		//5
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard.getValue() >=4 && dealerCard.getValue() <=6){
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(5), dealerCard, Situation.Start_With_A);
				changesMatrix.put(start_With_A, PlayerAction.Double);
				MatrixKey splited_With_A = new MatrixKey(StartValue.getOne(5), dealerCard, Situation.Splited_With_A);
				changesMatrix.put(splited_With_A, PlayerAction.Double);
				MatrixKey start_With_A_Three_More = new MatrixKey(StartValue.getOne(5), dealerCard, Situation.A_Three_More_Cards);
				changesMatrix.put(start_With_A_Three_More, PlayerAction.Hit);
			}else if(dealerCard.getValue() == 3){
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(5), dealerCard, Situation.Start_With_A);
				changesMatrix.put(start_With_A, PlayerAction.Hit);
				MatrixKey splited_With_A = new MatrixKey(StartValue.getOne(5), dealerCard, Situation.Splited_With_A);
				changesMatrix.put(splited_With_A, PlayerAction.Hit);
				MatrixKey start_With_A_Three_More = new MatrixKey(StartValue.getOne(5), dealerCard, Situation.A_Three_More_Cards);
				changesMatrix.put(start_With_A_Three_More, PlayerAction.Hit);
			}else{
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(5), dealerCard, Situation.Start_With_A);
				changesMatrix.put(start_With_A, PlayerAction.Hit);
				MatrixKey splited_With_A = new MatrixKey(StartValue.getOne(5), dealerCard, Situation.Splited_With_A);
				changesMatrix.put(splited_With_A, PlayerAction.Hit);
				MatrixKey start_With_A_Three_More = new MatrixKey(StartValue.getOne(5), dealerCard, Situation.A_Three_More_Cards);
				changesMatrix.put(start_With_A_Three_More, PlayerAction.Hit);
			}
		}
		//6
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard.getValue() >=4 && dealerCard.getValue() <=6){
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(6), dealerCard, Situation.Start_With_A);
				changesMatrix.put(start_With_A, PlayerAction.Double);
				MatrixKey splited_With_A = new MatrixKey(StartValue.getOne(6), dealerCard, Situation.Splited_With_A);
				changesMatrix.put(splited_With_A, PlayerAction.Double);
				MatrixKey start_With_A_Three_More = new MatrixKey(StartValue.getOne(6), dealerCard, Situation.A_Three_More_Cards);
				changesMatrix.put(start_With_A_Three_More, PlayerAction.Hit);
			}else if(dealerCard.getValue() == 3){
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(6), dealerCard, Situation.Start_With_A);
				changesMatrix.put(start_With_A, PlayerAction.Double);
				MatrixKey splited_With_A = new MatrixKey(StartValue.getOne(6), dealerCard, Situation.Splited_With_A);
				changesMatrix.put(splited_With_A, PlayerAction.Double);
				MatrixKey start_With_A_Three_More = new MatrixKey(StartValue.getOne(6), dealerCard, Situation.A_Three_More_Cards);
				changesMatrix.put(start_With_A_Three_More, PlayerAction.Hit);
			}else{
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(6), dealerCard, Situation.Start_With_A);
				changesMatrix.put(start_With_A, PlayerAction.Hit);
				MatrixKey splited_With_A = new MatrixKey(StartValue.getOne(6), dealerCard, Situation.Splited_With_A);
				changesMatrix.put(splited_With_A, PlayerAction.Hit);
				MatrixKey start_With_A_Three_More = new MatrixKey(StartValue.getOne(6), dealerCard, Situation.A_Three_More_Cards);
				changesMatrix.put(start_With_A_Three_More, PlayerAction.Hit);
			}
		}
		//7
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			//after test stand
			if(dealerCard.getValue() == 4 || dealerCard.getValue() == 5){
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.Start_With_A);
				changesMatrix.put(start_With_A, PlayerAction.Double);
				MatrixKey splited_With_A = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.Splited_With_A);
				changesMatrix.put(splited_With_A, PlayerAction.Double);
				MatrixKey start_With_A_Three_More = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.A_Three_More_Cards);
				changesMatrix.put(start_With_A_Three_More, PlayerAction.Stand);
			}else if(dealerCard.getValue() ==6){
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.Start_With_A);
				changesMatrix.put(start_With_A, PlayerAction.Double);
				MatrixKey splited_With_A = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.Splited_With_A);
				changesMatrix.put(splited_With_A, PlayerAction.Double);
				MatrixKey start_With_A_Three_More = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.A_Three_More_Cards);
				changesMatrix.put(start_With_A_Three_More, PlayerAction.Stand);
			}
			else if(dealerCard.getValue() >=9 && dealerCard.getValue() <=10){
				//after test hit
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.Start_With_A);
				changesMatrix.put(start_With_A, PlayerAction.Hit);
				MatrixKey splited_With_A = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.Splited_With_A);
				changesMatrix.put(splited_With_A, PlayerAction.Hit);
				MatrixKey start_With_A_Three_More = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.A_Three_More_Cards);
				changesMatrix.put(start_With_A_Three_More, PlayerAction.Hit);
			}else if(dealerCard == Card.One1){
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.Start_With_A);
				changesMatrix.put(start_With_A, PlayerAction.Hit);
				MatrixKey splited_With_A = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.Splited_With_A);
				changesMatrix.put(splited_With_A, PlayerAction.Hit);
				MatrixKey start_With_A_Three_More = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.A_Three_More_Cards);
				changesMatrix.put(start_With_A_Three_More, PlayerAction.Hit);
			}else {
				//2,7,8
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.Start_With_A);
				changesMatrix.put(start_With_A, PlayerAction.Stand);
				MatrixKey splited_With_A = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.Splited_With_A);
				changesMatrix.put(splited_With_A, PlayerAction.Stand);
				MatrixKey start_With_A_Three_More = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.A_Three_More_Cards);
				changesMatrix.put(start_With_A_Three_More, PlayerAction.Stand);
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
						changesMatrix.put(start_With_Pair, PlayerAction.Split);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Split);
					}else if(dealerCard==Card.Four4 || dealerCard == Card.Seven7){
						//22 vs 4
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.Split);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Split);
					}else {
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.Hit);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
					}
				}else if(start == 3) {
					if((dealerCard==Card.Five5) || (dealerCard==Card.Six6)|| (dealerCard==Card.Four4)){
						//33 vs 5 or 6
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.Split);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Split);
					}else {
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.Hit);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
					}
				}else if(start == 4) {
					if((dealerCard==Card.Five5)){
						//after test no split just hit
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.Split);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Split);
					}else if((dealerCard==Card.Six6)){
						//after test split , just balance with 5 and more ROI get
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.Split);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Split);
					}else {
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.Hit);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
					}
				}else if(start == 5) {
					if(dealerCard == Card.Six6 || dealerCard == Card.Five5) {
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
						changesMatrix.put(start_With_Pair, PlayerAction.Hit);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
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
						changesMatrix.put(start_With_Pair, PlayerAction.Stand);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Stand);
					}else if(dealerCard.getValue() >=5 && dealerCard.getValue() <=6){
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.Split);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Split);
					}else{
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.Hit);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
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
							changesMatrix.put(start_With_Pair, PlayerAction.Stand);
							MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
							changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Stand);
						}else if(dealerCard.getValue() >=4 && dealerCard.getValue() <=5){
							MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
							notChangesMatrix.put(start_With_Pair, PlayerAction.Split);
							MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
							notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Split);
						}else if(dealerCard.getValue() == 7){
							MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
							changesMatrix.put(start_With_Pair, PlayerAction.Hit);
							MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
							changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
						}else if(dealerCard.getValue() == 8){
							MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
							changesMatrix.put(start_With_Pair, PlayerAction.Hit);
							MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
							changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
						}else if(dealerCard.getValue() == 9){
							MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
							changesMatrix.put(start_With_Pair, PlayerAction.Hit);
							MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
							changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
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
						notChangesMatrix.put(start_With_Pair, PlayerAction.Split);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Split);
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
						changesMatrix.put(start_With_Pair, PlayerAction.Hit);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
					}else if(dealerCard == Card.Nine9) {
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.Giveup);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
					}else {
						// 88 vs 10
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.Giveup);
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
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
						changesMatrix.put(start_With_Pair, PlayerAction.Stand);	
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Stand);	
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
			changesMatrix.put(start_With_Pair, PlayerAction.Stand);
			MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.Ten, dealerCard, Situation.Splited_Pair_And_Can_Split);
			changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Stand);	
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
				changesMatrix.put(start_With_A, PlayerAction.Hit);
			}else {
				MatrixKey start_With_A = new MatrixKey(StartValue.One, dealerCard, Situation.Start_With_Pair);
				changesMatrix.put(start_With_A, PlayerAction.Split);
			}
		}
		

		this.changesMatrix = changesMatrix;
		one.putAll(notChangesMatrix);
		one.putAll(changesMatrix);
	}
	
	public static void main(String[] args) {
		StrategyMatrix8012 one = new MirMyth2019April22();
		StrategyMatrix8012 two = new Myth2019April22();
		System.out.println(two.diffWith(one));
		
		HelloWorld.printStrategyMatrix8012(one,two);
		
		/**
MatrixKey [startValue=Two, dealerCard=Seven7, situation=Splited_Pair_And_Can_Split] : Hit -> Split
MatrixKey [startValue=Two, dealerCard=Seven7, situation=Start_With_Pair] : Hit -> Split
MatrixKey [startValue=Sixteen, dealerCard=Seven7, situation=Three_More_Cards] : Stand -> Hit
MatrixKey [startValue=Sixteen, dealerCard=Seven7, situation=Start_Hand_WithoutA_WithoutPair] : Stand -> Hit
MatrixKey [startValue=Sixteen, dealerCard=Seven7, situation=Splited_Pair_And_Can_NOT_Split] : Stand -> Hit
MatrixKey [startValue=Sixteen, dealerCard=Eight8, situation=Splited_Pair_And_Can_NOT_Split] : Stand -> Hit
MatrixKey [startValue=Sixteen, dealerCard=Eight8, situation=Start_Hand_WithoutA_WithoutPair] : Giveup -> Hit
MatrixKey [startValue=Sixteen, dealerCard=Eight8, situation=Three_More_Cards] : Stand -> Hit
MatrixKey [startValue=Sixteen, dealerCard=Nine9, situation=Splited_Pair_And_Can_NOT_Split] : Stand -> Hit
MatrixKey [startValue=Sixteen, dealerCard=Nine9, situation=Three_More_Cards] : Stand -> Hit
MatrixKey [startValue=Sixteen, dealerCard=Ten, situation=Splited_Pair_And_Can_NOT_Split] : Stand -> Hit
MatrixKey [startValue=Sixteen, dealerCard=Ten, situation=Three_More_Cards] : Stand -> Hit

org.shil.bjm.strategy8102.strategy.Myth2019April22 StrategyMatrix8012 [ParetoFrontValue= 1.0285301495009005 ,ParetotYPE= 4,	 roiFactor()= 1.0285301495009005,	 probRateFactor()= 0.0,	 timeRateFactor()= 0.0,	 timeRoi= 0.7896190141273972,	 probRoi= 1.0285301495009005,	 totalTimes: 2.575873744E9,	 getTimeRates= w:37.00351409770028 $d:3.6575102805194013 $l:59.33897562178032,	 totalProbs: 1.9305026834673789,	 getProbRate= w:45.54402457213763 $d:7.4423853973961025 $l:47.01359003046626,	 timeMoneyReturn= 4.148267881E11,	 timeTotalSpead= 5.25350556E11,	 probMoneyReturn= 447.5081507650286,	 probTotalSpead= 435.094830212011
org.shil.bjm.strategy8102.strategy.practise.MirMyth2019April22 StrategyMatrix8012 [ParetoFrontValue= 1.0288135852253528 ,ParetotYPE= 4,	 roiFactor()= 1.0288135852253528,	 probRateFactor()= 0.0,	 timeRateFactor()= 0.0,	 timeRoi= 0.7604395314757735,	 probRoi= 1.0288135852253528,	 totalTimes: 3.109304431E9,	 getTimeRates= w:35.638874275286426 $d:3.636983914232874 $l:60.7241418104807,	 totalProbs: 1.9624715489759899,	 getProbRate= w:45.54575139636914 $d:7.607754463245225 $l:46.84649414038563,	 timeMoneyReturn= 4.806712641E11,	 timeTotalSpead= 6.320966286E11,	 probMoneyReturn= 455.2699210348125,	 probTotalSpead= 442.5193519728742

		 */
	}
	
/*

 */
}
