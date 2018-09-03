package org.shil.bjm.strategy8102;

import java.util.HashMap;
import java.util.Map;

import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerAction;
import org.shil.bjm.meta.StartValue;

public class GenMatrix extends Standard2017 {
	public GenMatrix() {
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
			}else if(dealerCard == Card.One1){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(9), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.randomStartWithoutPairActionVSDealerA());
			}else {
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(9), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.randomStartWithoutPairAction());
			}
		}
		//10
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard.getValue() >=2 && dealerCard.getValue() <=9){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(10), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Double);
			}else if(dealerCard == Card.One1){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(10), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.randomStartWithoutPairActionVSDealerA());
			}else{
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(10), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.randomStartWithoutPairAction());
			}
		}
		//11
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard.getValue() >=2 && dealerCard.getValue() <=9){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(11), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Double);
			}else if(dealerCard == Card.One1){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(11), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.randomStartWithoutPairActionVSDealerA());
			}else{
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(11), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.randomStartWithoutPairAction());
			}
		}
		//12
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard.getValue() == 2 ){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.randomStartWithoutPairAction());
			}else if(dealerCard.getValue() == 3 ){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.randomStartWithoutPairAction());
			}else if(dealerCard.getValue() >3 && dealerCard.getValue() <=6){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Stand);
			}else if(dealerCard == Card.One1){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.randomStartWithoutPairActionVSDealerA());
			}else{
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.randomStartWithoutPairAction());
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
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.randomStartWithoutPairAction());
			}else if(dealerCard == Card.One1){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(13), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.randomStartWithoutPairActionVSDealerA());
			}else{
				//9,T
				//same result if the cards give to dealer
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(13), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.randomStartWithoutPairAction());
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
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.randomStartWithoutPairAction());
			}else if(dealerCard.getValue() == 8){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.randomStartWithoutPairAction());
			}else if(dealerCard.getValue() == 9){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.randomStartWithoutPairAction());
			}else if(dealerCard.getValue() == 10){
				//T,J,Q,K
				//same result if the cards give to dealer
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.randomStartWithoutPairAction());
			}else{
				//A
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.randomStartWithoutPairActionVSDealerA());
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
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.randomStartWithoutPairAction());
			}else if(dealerCard.getValue() == 8 ){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.randomStartWithoutPairAction());
			}else if(dealerCard.getValue() == 9 ){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.randomStartWithoutPairAction());
			}else if(dealerCard.getValue() == 10 ){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.randomStartWithoutPairAction());
			}else{
				//A
				//same result if the cards give to dealer
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.randomStartWithoutPairActionVSDealerA());
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
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.randomStartWithoutPairAction());
			}else if(dealerCard.getValue() ==8 ){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.randomStartWithoutPairAction());
			}else if(dealerCard.getValue() ==9 ){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.randomStartWithoutPairAction());
			}else if(dealerCard.getValue() ==10 ){
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.randomStartWithoutPairAction());
			}else{
				//A
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.randomStartWithoutPairActionVSDealerA());
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
					changesMatrix.put(start_With_A, PlayerAction.randomStartWithoutPairAction());
				}else if(dealerCard == Card.One1){
					MatrixKey start_With_A = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_A);
					changesMatrix.put(start_With_A, PlayerAction.randomStartWithoutPairActionVSDealerA());
				}else{
					MatrixKey start_With_A = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_A);
					changesMatrix.put(start_With_A, PlayerAction.randomStartWithoutPairAction());
				}
			}
		}
		//6
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard.getValue() >=4 && dealerCard.getValue() <=6){
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(6), dealerCard, Situation.Start_With_A);
				changesMatrix.put(start_With_A, PlayerAction.randomStartWithoutPairAction());
			}else if(dealerCard == Card.One1){
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(6), dealerCard, Situation.Start_With_A);
				changesMatrix.put(start_With_A, PlayerAction.randomStartWithoutPairActionVSDealerA());
			}else{
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(6), dealerCard, Situation.Start_With_A);
				changesMatrix.put(start_With_A, PlayerAction.randomStartWithoutPairAction());
			}
		}
		//7
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard == Card.One1){
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.Start_With_A);
				changesMatrix.put(start_With_A, PlayerAction.randomStartWithoutPairActionVSDealerA());
			}else {
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.Start_With_A);
				changesMatrix.put(start_With_A, PlayerAction.randomStartWithoutPairAction());
			}
		}
		
		/*
		 * Situation.Start_With_A 11 or 1
		 * VS
		 * DealerCard (One ~ K)
		 */
		for(Card dealerCard : Card.values()) {
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard == Card.One1){
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.Start_With_A);
				changesMatrix.put(start_With_A, PlayerAction.randomStartWithoutPairActionVSDealerA());
			}else {
				MatrixKey start_With_A = new MatrixKey(StartValue.One, dealerCard, Situation.Start_With_A);
				changesMatrix.put(start_With_A, PlayerAction.randomStartWithoutPairAction());
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
					}else if(dealerCard==Card.One1) {
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.randomStartWithPairActionVSDealerA());
					}else {
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.randomStartWithPairAction());
					}
				}else if(start == 3) {
					if((dealerCard==Card.Five5) || (dealerCard==Card.Six6)){
						//33 vs 5 or 6
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						notChangesMatrix.put(start_With_Pair, PlayerAction.Split);
					}else if(dealerCard==Card.One1) {
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.randomStartWithPairActionVSDealerA());
					}else {
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.randomStartWithPairAction());
					}
				}else if(start == 4) {
					if(dealerCard==Card.One1) {
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.randomStartWithPairActionVSDealerA());
					}else {
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.randomStartWithPairAction());
					}
				}else if(start == 5) {
					if(dealerCard.getValue() >=2 && dealerCard.getValue() <=9){
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						notChangesMatrix.put(start_With_Pair, PlayerAction.Double);
					}else if(dealerCard==Card.One1) {
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.randomStartWithPairActionVSDealerA());
					}else{
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.randomStartWithPairAction());
					}
				}else if(start == 6) {
					if(dealerCard.getValue() == 2 ){
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.randomStartWithPairAction());
					}else if(dealerCard.getValue() == 3 ){
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.randomStartWithPairAction());
					}else if(dealerCard.getValue() >=4 && dealerCard.getValue() <=6){
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						notChangesMatrix.put(start_With_Pair, PlayerAction.Stand);
					}else if(dealerCard==Card.One1) {
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.randomStartWithPairActionVSDealerA());
					}else{
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.randomStartWithPairAction());
					}
				}else if(start == 7) {
					if(dealerCard==Card.Six6){
						//77 vs 6
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						notChangesMatrix.put(start_With_Pair, PlayerAction.Split);
					}else {
						if(dealerCard.getValue() >=2 && dealerCard.getValue() <=5){
							MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
							changesMatrix.put(start_With_Pair, PlayerAction.randomStartWithPairAction());
						}else if(dealerCard.getValue() == 7){
							MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
							changesMatrix.put(start_With_Pair, PlayerAction.randomStartWithPairAction());
						}else if(dealerCard.getValue() == 8){
							MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
							changesMatrix.put(start_With_Pair, PlayerAction.randomStartWithPairAction());
						}else if(dealerCard.getValue() == 9){
							MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
							changesMatrix.put(start_With_Pair, PlayerAction.randomStartWithPairAction());
						}else if(dealerCard.getValue() == 10){
							//T,J,Q,K
							//same result if the cards give to dealer
							MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
							changesMatrix.put(start_With_Pair, PlayerAction.randomStartWithPairAction());
						}else{
							//A
							MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
							changesMatrix.put(start_With_Pair, PlayerAction.randomStartWithPairActionVSDealerA());
						}
					}
				}else if(start == 8) {
					if((dealerCard==Card.Three3) || (dealerCard==Card.Four4)||(dealerCard==Card.Five5) || (dealerCard==Card.Six6)||(dealerCard==Card.Seven7)){
						//88 vs 3,4,5,6,7
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						notChangesMatrix.put(start_With_Pair, PlayerAction.Split);
					}else if(dealerCard == Card.Two2){
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.randomStartWithPairAction());
					}else if(dealerCard == Card.One1) {
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.randomStartWithPairActionVSDealerA());
					}else {
						// 88 vs 8 9 10
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.randomStartWithPairAction());
					}
				}else if(start == 9) {
					if((dealerCard==Card.Two2) ||(dealerCard==Card.Three3) || (dealerCard==Card.Four4)||(dealerCard==Card.Five5) || (dealerCard==Card.Six6)|| (dealerCard==Card.Seven7)||(dealerCard==Card.Eight8)) {
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						notChangesMatrix.put(start_With_Pair, PlayerAction.Split);	
					}else if(dealerCard==Card.One1) {
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.randomStartWithPairActionVSDealerA());
					}else {
						MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
						changesMatrix.put(start_With_Pair, PlayerAction.randomStartWithPairAction());	
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
			if(dealerCard==Card.One1) {
				MatrixKey start_With_Pair = new MatrixKey(StartValue.One, dealerCard, Situation.Start_With_Pair);
				changesMatrix.put(start_With_Pair, PlayerAction.randomStartWithPairActionVSDealerA());
			}else {
				MatrixKey start_With_A = new MatrixKey(StartValue.One, dealerCard, Situation.Start_With_Pair);
				changesMatrix.put(start_With_A, PlayerAction.randomStartWithPairAction());
			}
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
					}else{
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.randomSplitedPairAndCanSplitAction());
					}
				}else if(start == 3) {
					if((dealerCard==Card.Five5) || (dealerCard==Card.Six6)){
						//33 vs 5 or 6
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Split);
					}else {
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.randomSplitedPairAndCanSplitAction());
					}
				}else if(start == 4) {
					MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
					changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.randomSplitedPairAndCanSplitAction());
				}else if(start == 5) {
					if(dealerCard.getValue() >=2 && dealerCard.getValue() <=9){
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Double);
					}else{
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.randomSplitedPairAndCanSplitAction());
					}
				}else if(start == 6) {
					if(dealerCard.getValue() == 2 ){
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.randomSplitedPairAndCanSplitAction());
					}else if(dealerCard.getValue() == 3 ){
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.randomSplitedPairAndCanSplitAction());
					}else if(dealerCard.getValue() >3 && dealerCard.getValue() <=6){
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Stand);
					}else{
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.randomSplitedPairAndCanSplitAction());
					}
				}else if(start == 7) {
					if(dealerCard==Card.Six6){
						//77 vs 6
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Split);
					}else {
						if(dealerCard.getValue() >=2 && dealerCard.getValue() <6){
							MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
							changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.randomSplitedPairAndCanSplitAction());
						}else if(dealerCard.getValue() == 7){
							MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
							changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.randomSplitedPairAndCanSplitAction());
						}else if(dealerCard.getValue() == 8){
							MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
							changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.randomSplitedPairAndCanSplitAction());
						}else if(dealerCard.getValue() == 9){
							MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
							changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.randomSplitedPairAndCanSplitAction());
						}else if(dealerCard.getValue() == 10){
							//T,J,Q,K
							//same result if the cards give to dealer
							MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
							changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.randomSplitedPairAndCanSplitAction());
						}
						else{
							//A
							MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
							changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.randomSplitedPairAndCanSplitAction());
						}
					}
				}else if(start == 8) {
					if((dealerCard==Card.Three3) || (dealerCard==Card.Four4)||(dealerCard==Card.Five5) || (dealerCard==Card.Six6)||(dealerCard==Card.Seven7)){
						//88 vs 3,4,5,6,7
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Split);
					}else if(dealerCard == Card.Two2){
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.randomSplitedPairAndCanSplitAction());
					}else if(dealerCard == Card.One1) {
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.randomSplitedPairAndCanSplitAction());
					}else {
						// 88 vs 8 9 10
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.randomSplitedPairAndCanSplitAction());
					}
				}else if(start == 9) {
					if((dealerCard==Card.Two2) ||(dealerCard==Card.Three3) || (dealerCard==Card.Four4)||(dealerCard==Card.Five5) || (dealerCard==Card.Six6)|| (dealerCard==Card.Seven7)||(dealerCard==Card.Eight8)) {
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						notChangesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.Split);	
					}else {
						MatrixKey Splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
						changesMatrix.put(Splited_Pair_And_Can_Split, PlayerAction.randomSplitedPairAndCanSplitAction());	
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
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.randomSplitedPairAndCanNotSplittAction());
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
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.randomSplitedPairAndCanNotSplittAction());
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
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.randomSplitedPairAndCanNotSplittAction());
			}
		}
		//12
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			if(dealerCard.getValue() == 2 ){
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.randomSplitedPairAndCanNotSplittAction());
			}else if(dealerCard.getValue() == 3 ){
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.randomSplitedPairAndCanNotSplittAction());
			}else if(dealerCard.getValue() >3 && dealerCard.getValue() <=6){
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				notChangesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Stand);
			}else{
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.randomSplitedPairAndCanNotSplittAction());
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
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.randomSplitedPairAndCanNotSplittAction());
			}else{
				//9,T,A
				//same result if the cards give to dealer
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(13), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.randomSplitedPairAndCanNotSplittAction());
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
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.randomSplitedPairAndCanNotSplittAction());
			}else if(dealerCard.getValue() == 8){
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.randomSplitedPairAndCanNotSplittAction());
			}else if(dealerCard.getValue() == 9){
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.randomSplitedPairAndCanNotSplittAction());
			}else if(dealerCard.getValue() == 10){
				//T,J,Q,K
				//same result if the cards give to dealer
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.randomSplitedPairAndCanNotSplittAction());
			}
			else{
				//A
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.randomSplitedPairAndCanNotSplittAction());
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
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.randomSplitedPairAndCanNotSplittAction());
			}else if(dealerCard.getValue() == 8 ){
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.randomSplitedPairAndCanNotSplittAction());
			}else if(dealerCard.getValue() == 9 ){
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.randomSplitedPairAndCanNotSplittAction());
			}else if(dealerCard.getValue() == 10 ){
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.randomSplitedPairAndCanNotSplittAction());
			}
			else{
				//A
				//same result if the cards give to dealer
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.randomSplitedPairAndCanNotSplittAction());
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
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.randomSplitedPairAndCanNotSplittAction());
			}else if(dealerCard.getValue() ==8 ){
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.randomSplitedPairAndCanNotSplittAction());
			}else if(dealerCard.getValue() ==9 ){
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.randomSplitedPairAndCanNotSplittAction());
			}else if(dealerCard.getValue() ==10 ){
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.randomSplitedPairAndCanNotSplittAction());
			}
			else{
				//A
				MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(Splited_Pair_And_Can_NOT_Split, PlayerAction.randomSplitedPairAndCanNotSplittAction());
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
				changesMatrix.put(Three_More_Cards, PlayerAction.randomThreeCardsAction());
			}else if(dealerCard.getValue() == 3 ){
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.randomThreeCardsAction());
			}else if(dealerCard.getValue() >3 && dealerCard.getValue() <=6){
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Three_More_Cards);
				notChangesMatrix.put(Three_More_Cards, PlayerAction.Stand);
			}else{
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(12), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.randomThreeCardsAction());
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
				changesMatrix.put(Three_More_Cards, PlayerAction.randomThreeCardsAction());
			}else{
				//9,T,A
				//same result if the cards give to dealer
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(13), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.randomThreeCardsAction());
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
				changesMatrix.put(Three_More_Cards, PlayerAction.randomThreeCardsAction());
			}else if(dealerCard.getValue() == 8){
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.randomThreeCardsAction());
			}else if(dealerCard.getValue() == 9){
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.randomThreeCardsAction());
			}else if(dealerCard.getValue() == 10){
				//T,J,Q,K
				//same result if the cards give to dealer
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.randomThreeCardsAction());
			}
			else{
				//A
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(14), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.randomThreeCardsAction());
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
				changesMatrix.put(Three_More_Cards, PlayerAction.randomThreeCardsAction());
			}else if(dealerCard.getValue() == 8 ){
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.randomThreeCardsAction());
			}else if(dealerCard.getValue() == 9 ){
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.randomThreeCardsAction());
			}else if(dealerCard.getValue() == 10 ){
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.randomThreeCardsAction());
			}
			else{
				//A
				//same result if the cards give to dealer
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(15), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.randomThreeCardsAction());
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
				changesMatrix.put(Three_More_Cards, PlayerAction.randomThreeCardsAction());
			}else if(dealerCard.getValue() ==8 ){
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.randomThreeCardsAction());
			}else if(dealerCard.getValue() ==9 ){
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.randomThreeCardsAction());
			}else if(dealerCard.getValue() ==10 ){
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.randomThreeCardsAction());
			}
			else{
				//A
				MatrixKey Three_More_Cards = new MatrixKey(StartValue.getOne(16), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(Three_More_Cards, PlayerAction.randomThreeCardsAction());
			}
		}
		
		this.changesMatrix = changesMatrix;
		this.one = new HashMap<>();
		one.putAll(changesMatrix);
		one.putAll(notChangesMatrix);
	}
}
