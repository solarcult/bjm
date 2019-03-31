package org.shil.bjm.strategy8102.strategy.test;

import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerAction;
import org.shil.bjm.meta.StartValue;
import org.shil.bjm.strategy8102.strategy.BestInMyth2019;
import org.shil.bjm.strategy8102.strategy.Finally2047;
import org.shil.bjm.strategy8102.strategy.MatrixKey;
import org.shil.bjm.strategy8102.strategy.Situation;
import org.shil.bjm.strategy8102.strategy.StrategyMatrix8012;

public class MirBestInMyth2019 extends BestInMyth2019 {

	public MirBestInMyth2019() {
		super();
		
//		MatrixKey start_Hand_WithoutA_WithoutPair86 = new MatrixKey(StartValue.getOne(8), Card.Six6, Situation.Start_Hand_WithoutA_WithoutPair);
//		this.getOne().put(start_Hand_WithoutA_WithoutPair86, PlayerAction.Double);
		
//		MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(9), Card.Two2, Situation.Start_Hand_WithoutA_WithoutPair);
//		this.getOne().put(start_Hand_WithoutA_WithoutPair, PlayerAction.Double);
		
//		MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(9), Card.Three3, Situation.Start_Hand_WithoutA_WithoutPair);
//		this.getOne().put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
		
//		MatrixKey start_Hand_WithoutA_WithoutPair94 = new MatrixKey(StartValue.getOne(9), Card.Four4, Situation.Start_Hand_WithoutA_WithoutPair);
//		this.getOne().put(start_Hand_WithoutA_WithoutPair94, PlayerAction.Hit);
//		
//		MatrixKey start_Hand_WithoutA_WithoutPair95 = new MatrixKey(StartValue.getOne(9), Card.Five5, Situation.Start_Hand_WithoutA_WithoutPair);
//		this.getOne().put(start_Hand_WithoutA_WithoutPair95, PlayerAction.Hit);
//		
//		
//		MatrixKey start_Hand_WithoutA_WithoutPair96 = new MatrixKey(StartValue.getOne(9), Card.Six6, Situation.Start_Hand_WithoutA_WithoutPair);
//		this.getOne().put(start_Hand_WithoutA_WithoutPair96, PlayerAction.Hit);
		
//		MatrixKey start_Hand_WithoutA_WithoutPair97 = new MatrixKey(StartValue.getOne(9), Card.Seven7, Situation.Start_Hand_WithoutA_WithoutPair);
//		this.getOne().put(start_Hand_WithoutA_WithoutPair97, PlayerAction.Double);
		
//		MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(11), Card.Ten, Situation.Start_Hand_WithoutA_WithoutPair);
//		this.getOne().put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
		
//		MatrixKey start_Hand_WithoutA_WithoutPair122 = new MatrixKey(StartValue.getOne(12), Card.Two2, Situation.Start_Hand_WithoutA_WithoutPair);
//		this.getOne().put(start_Hand_WithoutA_WithoutPair122, PlayerAction.Stand);
		
//		MatrixKey start_Hand_WithoutA_WithoutPair123 = new MatrixKey(StartValue.getOne(12), Card.Three3, Situation.Start_Hand_WithoutA_WithoutPair);
//		this.getOne().put(start_Hand_WithoutA_WithoutPair123, PlayerAction.Hit);
		
//		MatrixKey start_Hand_WithoutA_WithoutPair122 = new MatrixKey(StartValue.getOne(13), Card.Two2, Situation.Start_Hand_WithoutA_WithoutPair);
//		this.getOne().put(start_Hand_WithoutA_WithoutPair122, PlayerAction.Hit);

//		MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(14), Card.Ten, Situation.Start_Hand_WithoutA_WithoutPair);
//		this.getOne().put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
		
//		MatrixKey start_Hand_WithoutA_WithoutPair159 = new MatrixKey(StartValue.getOne(15), Card.Nine9, Situation.Start_Hand_WithoutA_WithoutPair);
//		this.getOne().put(start_Hand_WithoutA_WithoutPair159, PlayerAction.Stand);
		
//		MatrixKey start_Hand_WithoutA_WithoutPair1510 = new MatrixKey(StartValue.getOne(15), Card.Ten, Situation.Start_Hand_WithoutA_WithoutPair);
//		this.getOne().put(start_Hand_WithoutA_WithoutPair1510, PlayerAction.Stand);
		
//		MatrixKey start_Hand_WithoutA_WithoutPair167 = new MatrixKey(StartValue.getOne(16), Card.Seven7, Situation.Start_Hand_WithoutA_WithoutPair);
//		this.getOne().put(start_Hand_WithoutA_WithoutPair167, PlayerAction.Stand);
		
//		MatrixKey start_Hand_WithoutA_WithoutPair168 = new MatrixKey(StartValue.getOne(16), Card.Eight8, Situation.Start_Hand_WithoutA_WithoutPair);
//		this.getOne().put(start_Hand_WithoutA_WithoutPair168, PlayerAction.Stand);

//		MatrixKey start_Hand_WithoutA_WithoutPair169 = new MatrixKey(StartValue.getOne(16), Card.Nine9, Situation.Start_Hand_WithoutA_WithoutPair);
//		this.getOne().put(start_Hand_WithoutA_WithoutPair169, PlayerAction.Hit);
		
//		MatrixKey start_Hand_WithoutA_WithoutPair1610 = new MatrixKey(StartValue.getOne(16), Card.Ten, Situation.Start_Hand_WithoutA_WithoutPair);
//		this.getOne().put(start_Hand_WithoutA_WithoutPair1610, PlayerAction.Hit);
		
		
		/*
		 * Situation.Start_With_A [2~7]
		 */
//		for(int start = 2; start <= 5; start++) {
//			for(Card dealerCard : Card.values()){
//				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
//				if(dealerCard.getValue() >=5 && dealerCard.getValue() <=6){
//					MatrixKey start_With_A = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_A);
//					this.getOne().put(start_With_A, PlayerAction.Hit);
//				}else if(dealerCard.getValue() == 4 ){
//					MatrixKey start_With_A = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_A);
//					this.getOne().put(start_With_A, PlayerAction.Double);
//				}else{
//					MatrixKey start_With_A = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_A);
//					this.getOne().put(start_With_A, PlayerAction.Double);
//				}
//			}
//		}
		//6
//		for(Card dealerCard : Card.values()){
//			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
//			if(dealerCard.getValue() >=4 && dealerCard.getValue() <=6){
//				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(6), dealerCard, Situation.Start_With_A);
//				this.getOne().put(start_With_A, PlayerAction.Hit);
//			}else if(dealerCard.getValue() == 3){
//				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(6), dealerCard, Situation.Start_With_A);
//				this.getOne().put(start_With_A, PlayerAction.Double);
//			}else{
//				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(6), dealerCard, Situation.Start_With_A);
//				this.getOne().put(start_With_A, PlayerAction.Double);
//			}
//		}
		//7
//		for(Card dealerCard : Card.values()){
//			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
//			//after test stand
//			if(dealerCard.getValue() >=3 && dealerCard.getValue() <=6){
//				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.Start_With_A);
//				this.getOne().put(start_With_A, PlayerAction.Hit);
//			}else if(dealerCard.getValue() >=9 && dealerCard.getValue() <=10){
//				//after test hit
//				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.Start_With_A);
//				this.getOne().put(start_With_A, PlayerAction.Stand);
//			}else if(dealerCard == Card.One1){
//				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.Start_With_A);
//				this.getOne().put(start_With_A, PlayerAction.Stand);
//			}else {
//				//2,7,8
//				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.Start_With_A);
//				this.getOne().put(start_With_A, PlayerAction.Hit);
//			}
//		}
		
	}
	
	public static void main(String[] args) {
		StrategyMatrix8012 one = new MirBestInMyth2019();
		StrategyMatrix8012 two = new BestInMyth2019();
		System.out.println(two.diffWith(one));
//		System.out.println(one.getCalcResult());
		StrategyMatrix8012 three = new Finally2047();
		System.out.println(three.diffWith(one));
	}
	
}
