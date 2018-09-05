package org.shil.bjm.strategy8102;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerAction;
import org.shil.bjm.meta.StartValue;

public class Standard2017 extends Seven8012 {

	public Standard2017() {
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
			if(dealerCard == Card.Three3 || dealerCard == Card.Four4 || dealerCard == Card.Five5 || dealerCard == Card.Six6 ){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(9), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Double);
			}else{
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(9), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
			}
		}
		//10
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard.getValue() >=2 && dealerCard.getValue() <=9){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(10), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Double);
			}else{
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(10), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
			}
		}
		//11
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard.getValue() >=2 && dealerCard.getValue() <=9){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(11), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Double);
			}else{
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(11), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
			}
		}
		//12
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard.getValue() == 2 ){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
			}else if(dealerCard.getValue() == 3 ){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Stand);
			}else if(dealerCard.getValue() >3 && dealerCard.getValue() <=6){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Stand);
			}else{
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
			}
		}
		//13
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard.getValue() >=2 && dealerCard.getValue() <=6){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(13), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Stand);
			}else if(dealerCard.getValue() == 7 || dealerCard.getValue() == 8){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(13), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
			}else{
				//9,T,A
				//same result if the cards give to dealer
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(13), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
			}
		}
		//14
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard.getValue() >=2 && dealerCard.getValue() <=6){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Stand);
			}else if(dealerCard.getValue() == 7){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
			}else if(dealerCard.getValue() == 8){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
			}else if(dealerCard.getValue() == 9){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
			}else if(dealerCard.getValue() == 10){
				//T,J,Q,K
				//same result if the cards give to dealer
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Giveup);
			}
			else{
				//A
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
			}
		}
		//15
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard.getValue() >=2 && dealerCard.getValue() <=6){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Stand);
			}else if(dealerCard.getValue() == 7 ){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Stand);
			}else if(dealerCard.getValue() == 8 ){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Stand);
			}else if(dealerCard.getValue() == 9 ){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Giveup);
			}else if(dealerCard.getValue() == 10 ){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Giveup);
			}
			else{
				//A
				//same result if the cards give to dealer
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
			}
		}
		//16
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard.getValue() >=2 && dealerCard.getValue() <=6){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Stand);
			}else if(dealerCard.getValue() == 7 ){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Stand);
			}else if(dealerCard.getValue() ==8 ){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Giveup);
			}else if(dealerCard.getValue() ==9 ){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Giveup);
			}else if(dealerCard.getValue() ==10 ){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Giveup);
			}
			else{
				//A
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
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
					changesMatrix.put(start_With_A, PlayerAction.Double);
				}else{
					MatrixKey start_With_A = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_A);
					changesMatrix.put(start_With_A, PlayerAction.Hit);
				}
			}
		}
		//6
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard.getValue() >=4 && dealerCard.getValue() <=6){
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(6), dealerCard, Situation.Start_With_A);
				changesMatrix.put(start_With_A, PlayerAction.Double);
			}else{
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(6), dealerCard, Situation.Start_With_A);
				changesMatrix.put(start_With_A, PlayerAction.Hit);
			}
		}
		//7
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			MatrixKey start_With_A = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.Start_With_A);
			changesMatrix.put(start_With_A, PlayerAction.Stand);
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
					}else {
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.Hit);
					}
				}else if(start == 3) {
					if((dealerCard==Card.Five5) || (dealerCard==Card.Six6)){
						//33 vs 5 or 6
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						notChangesMatrix.put(start_With_Pair, PlayerAction.Split);
					}else {
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.Hit);
					}
				}else if(start == 4) {
					MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
					changesMatrix.put(start_With_Pair, PlayerAction.Hit);
				}else if(start == 5) {
					if(dealerCard.getValue() >=2 && dealerCard.getValue() <=9){
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						notChangesMatrix.put(start_With_Pair, PlayerAction.Double);
					}else{
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.Hit);
					}
				}else if(start == 6) {
					if(dealerCard.getValue() == 2 ){
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.Hit);
					}else if(dealerCard.getValue() == 3 ){
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.Stand);
					}else if(dealerCard.getValue() >=4 && dealerCard.getValue() <=6){
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						notChangesMatrix.put(start_With_Pair, PlayerAction.Stand);
					}else{
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.Hit);
					}
				}else if(start == 7) {
					if(dealerCard==Card.Six6){
						//77 vs 6
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						notChangesMatrix.put(start_With_Pair, PlayerAction.Split);
					}else {
						if(dealerCard.getValue() >=2 && dealerCard.getValue() <6){
							MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
							changesMatrix.put(start_With_Pair, PlayerAction.Stand);
						}else if(dealerCard.getValue() == 7){
							MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
							changesMatrix.put(start_With_Pair, PlayerAction.Hit);
						}else if(dealerCard.getValue() == 8){
							MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
							changesMatrix.put(start_With_Pair, PlayerAction.Hit);
						}else if(dealerCard.getValue() == 9){
							MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
							changesMatrix.put(start_With_Pair, PlayerAction.Hit);
						}else if(dealerCard.getValue() == 10){
							//T,J,Q,K
							//same result if the cards give to dealer
							MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
							changesMatrix.put(start_With_Pair, PlayerAction.Giveup);
						}
						else{
							//A
							MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
							changesMatrix.put(start_With_Pair, PlayerAction.Hit);
						}
					}
				}else if(start == 8) {
					if((dealerCard==Card.Three3) || (dealerCard==Card.Four4)||(dealerCard==Card.Five5) || (dealerCard==Card.Six6)||(dealerCard==Card.Seven7)){
						//88 vs 3,4,5,6,7
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						notChangesMatrix.put(start_With_Pair, PlayerAction.Split);
					}else if(dealerCard == Card.Two2){
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.Stand);
					}else if(dealerCard == Card.One1) {
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.Hit);
					}else {
						// 88 vs 8 9 10
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.Giveup);
					}
				}else if(start == 9) {
					if((dealerCard==Card.Two2) ||(dealerCard==Card.Three3) || (dealerCard==Card.Four4)||(dealerCard==Card.Five5) || (dealerCard==Card.Six6)||(dealerCard==Card.Eight8)) {
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						notChangesMatrix.put(start_With_Pair, PlayerAction.Split);	
					}else {
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.Stand);	
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
			MatrixKey start_With_A = new MatrixKey(StartValue.One, dealerCard, Situation.Start_With_Pair);
			changesMatrix.put(start_With_A, PlayerAction.Split);
		}
		
		
//		对牌一次
		
		/*
		 * Situation.Splited_Pair_And_Can_Split [2~9]
		 * VS
		 * DealerCard (One ~ K)
		 */
		for(int start = 2; start <= 9; start++) {
			for(Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				if(start == 2) {
					if((dealerCard==Card.Five5) || (dealerCard==Card.Six6)){
						//22 vs 5 or 6
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Split);
					}else {
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
					}
				}else if(start == 3) {
					if((dealerCard==Card.Five5) || (dealerCard==Card.Six6)){
						//33 vs 5 or 6
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Split);
					}else {
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
					}
				}else if(start == 4) {
					MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
					changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
				}else if(start == 5) {
					if(dealerCard.getValue() >=2 && dealerCard.getValue() <=9){
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Double);
					}else{
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
					}
				}else if(start == 6) {
					if(dealerCard.getValue() == 2 ){
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
					}else if(dealerCard.getValue() == 3 ){
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Stand);
					}else if(dealerCard.getValue() >3 && dealerCard.getValue() <=6){
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Stand);
					}else{
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
					}
				}else if(start == 7) {
					if(dealerCard==Card.Six6){
						//77 vs 6
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Split);
					}else {
						if(dealerCard.getValue() >=2 && dealerCard.getValue() <6){
							MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
							changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Stand);
						}else if(dealerCard.getValue() == 7){
							MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
							changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
						}else if(dealerCard.getValue() == 8){
							MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
							changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
						}else if(dealerCard.getValue() == 9){
							MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
							changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
						}else if(dealerCard.getValue() == 10){
							//T,J,Q,K
							//same result if the cards give to dealer
							MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
							changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
						}
						else{
							//A
							MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
							changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
						}
					}
				}else if(start == 8) {
					if((dealerCard==Card.Three3) || (dealerCard==Card.Four4)||(dealerCard==Card.Five5) || (dealerCard==Card.Six6)||(dealerCard==Card.Seven7)){
						//88 vs 3,4,5,6,7
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Split);
					}else if(dealerCard == Card.Two2){
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Stand);
					}else if(dealerCard == Card.One1) {
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Hit);
					}else {
						// 88 vs 8 9 10
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Stand);
					}
				}else if(start == 9) {
					if((dealerCard==Card.Two2) ||(dealerCard==Card.Three3) || (dealerCard==Card.Four4)||(dealerCard==Card.Five5) || (dealerCard==Card.Six6)||(dealerCard==Card.Eight8)) {
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Split);	
					}else {
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Stand);	
					}
				}
			}
		}
		
//		对牌2次, 同时给了分牌后的普通牌场景
		/*
		 * Situation.Splited_Pair_And_Can_NOT_Split [9~16] 
		 * VS
		 * DealerCard  (One ~ K)
		 */
		//9
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard == Card.Three3 || dealerCard == Card.Four4 || dealerCard == Card.Five5 || dealerCard == Card.Six6 ){
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(9), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Double);
			}else{
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(9), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
			}
		}
		//10
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard.getValue() >=2 && dealerCard.getValue() <=9){
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(10), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Double);
			}else{
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(10), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
			}
		}
		//11
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard.getValue() >=2 && dealerCard.getValue() <=9){
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(11), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Double);
			}else{
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(11), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
			}
		}
		//12
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard.getValue() == 2 ){
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
			}else if(dealerCard.getValue() == 3 ){
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Stand);
			}else if(dealerCard.getValue() >3 && dealerCard.getValue() <=6){
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Stand);
			}else{
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
			}
		}
		//13
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard.getValue() >=2 && dealerCard.getValue() <=6){
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(13), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Stand);
			}else if(dealerCard.getValue() == 7 || dealerCard.getValue() == 8){
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(13), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
			}else{
				//9,T,A
				//same result if the cards give to dealer
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(13), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
			}
		}		
		//14
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard.getValue() >=2 && dealerCard.getValue() <=6){
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Stand);
			}else if(dealerCard.getValue() == 7){
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
			}else if(dealerCard.getValue() == 8){
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
			}else if(dealerCard.getValue() == 9){
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
			}else if(dealerCard.getValue() == 10){
				//T,J,Q,K
				//same result if the cards give to dealer
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
			}
			else{
				//A
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
			}
		}		
		//15
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard.getValue() >=2 && dealerCard.getValue() <=6){
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Stand);
			}else if(dealerCard.getValue() == 7 ){
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Stand);
			}else if(dealerCard.getValue() == 8 ){
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Stand);
			}else if(dealerCard.getValue() == 9 ){
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Stand);
			}else if(dealerCard.getValue() == 10 ){
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
			}
			else{
				//A
				//same result if the cards give to dealer
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
			}
		}		
		//16
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard.getValue() >=2 && dealerCard.getValue() <=6){
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Stand);
			}else if(dealerCard.getValue() == 7 ){
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Stand);
			}else if(dealerCard.getValue() ==8 ){
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Stand);
			}else if(dealerCard.getValue() ==9 ){
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Stand);
			}else if(dealerCard.getValue() ==10 ){
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Stand);
			}
			else{
				//A
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
			}
		}		
		
		/*
		 * Situation.Three_More_Cards [12~16] 
		 * VS
		 * DealerCard  (One ~ K)
		 */
		//12
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard.getValue() == 2 ){
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.Hit);
			}else if(dealerCard.getValue() == 3 ){
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.Stand);
			}else if(dealerCard.getValue() >3 && dealerCard.getValue() <=6){
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Three_More_Cards);
				notChangesMatrix.put(Three_More_Cards, PlayerAction.Stand);
			}else{
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.Hit);
			}
		}
		//13
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard.getValue() >=2 && dealerCard.getValue() <=6){
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(13), dealerCard, Situation.Three_More_Cards);
				notChangesMatrix.put(Three_More_Cards, PlayerAction.Stand);
			}else if(dealerCard.getValue() == 7 || dealerCard.getValue() == 8){
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(13), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.Hit);
			}else{
				//9,T,A
				//same result if the cards give to dealer
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(13), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.Hit);
			}
		}

		//14
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard.getValue() >=2 && dealerCard.getValue() <=6){
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Three_More_Cards);
				notChangesMatrix.put(Three_More_Cards, PlayerAction.Stand);
			}else if(dealerCard.getValue() == 7){
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.Hit);
			}else if(dealerCard.getValue() == 8){
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.Hit);
			}else if(dealerCard.getValue() == 9){
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.Hit);
			}else if(dealerCard.getValue() == 10){
				//T,J,Q,K
				//same result if the cards give to dealer
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.Hit);
			}
			else{
				//A
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.Hit);
			}
		}				
		//15
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard.getValue() >=2 && dealerCard.getValue() <=6){
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Three_More_Cards);
				notChangesMatrix.put(Three_More_Cards, PlayerAction.Stand);
			}else if(dealerCard.getValue() == 7 ){
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.Stand);
			}else if(dealerCard.getValue() == 8 ){
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.Stand);
			}else if(dealerCard.getValue() == 9 ){
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.Stand);
			}else if(dealerCard.getValue() == 10 ){
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.Hit);
			}
			else{
				//A
				//same result if the cards give to dealer
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.Hit);
			}
		}
		//16
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard.getValue() >=2 && dealerCard.getValue() <=6){
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Three_More_Cards);
				notChangesMatrix.put(Three_More_Cards, PlayerAction.Stand);
			}else if(dealerCard.getValue() == 7 ){
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.Stand);
			}else if(dealerCard.getValue() ==8 ){
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.Stand);
			}else if(dealerCard.getValue() ==9 ){
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.Stand);
			}else if(dealerCard.getValue() ==10 ){
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.Stand);
			}
			else{
				//A
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.Hit);
			}
		}
		
		this.changesMatrix = changesMatrix;
		this.one = new HashMap<>();
		one.putAll(changesMatrix);
		one.putAll(notChangesMatrix);
	}
	
	public static void main(String[] args) {
		List<StrategyMatrix8012> s = new ArrayList<>();
		StrategyMatrix8012 one = new Standard2017();
		one.wdlRateDS = new Double[] { 10d,20d,30d};
		long start = System.currentTimeMillis();
		System.out.println(one.getCalcResult());
		System.out.println(System.currentTimeMillis() - start);
		
		StrategyMatrix8012 two = one.evolve();
		System.out.println(one.getChangesMatrix().size());
		System.out.println(two.getNotChangesMatrix().size());
		System.out.println(two.getOne().size());
		two.wdlRateDS =  new Double[] { 30d,20d,10d};
		System.out.println(one.getROI());
		s.add(one);
		s.add(two);
		Collections.sort(s,new Matrix8102WinRateDSComparator());
		
		int count = 0 ;
		for(Entry<MatrixKey,PlayerAction> e: one.getOne().entrySet()) {
			if(e.getValue() != two.getOne().get(e.getKey())) {
				count++;
			}
		}
		
		System.out.println(count);
		
//		two.winRateWithProb();
	}

}
