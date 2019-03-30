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
