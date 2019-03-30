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
		MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(9), Card.Six6, Situation.Start_Hand_WithoutA_WithoutPair);
		this.getOne().put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
		MatrixKey Splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(9), Card.Six6, Situation.Splited_Pair_And_Can_NOT_Split);
		this.getOne().put(Splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
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
