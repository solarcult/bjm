package org.shil.bjm.strategy8102;

import java.util.concurrent.CompletableFuture;

import org.apache.commons.math3.stat.Frequency;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerAction;
import org.shil.bjm.meta.StartValue;

public class TestA {
	
	public static void main(String[] args) {
		StrategyMatrix8012 a = new Standard2017();
		EvolutionTest.debug = true;
		a.getWdlRateWithDS();
		a.getWdlRateWithDSbyRaw();
	}
	
	public static void testC() {
		Standard2017 s = new Standard2017();
		System.out.println(s.getROI());
		CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
			System.out.println(s.getCalcResult());
		});
		CompletableFuture<Void> completableFuture2 = CompletableFuture.runAsync(()->{
			System.out.println(s.evolve().getCalcResult());
		});
		CompletableFuture<Void> all = CompletableFuture.allOf(completableFuture,completableFuture2);
		all.join();
	}
	
	public static void testB() {
		MatrixKey matrixKey1 =  new MatrixKey(StartValue.Eight, Card.Five5, Situation.Start_Hand_WithoutA_WithoutPair);
		MatrixKey matrixKey2 =  new MatrixKey(StartValue.Eight, Card.Five5, Situation.Splited_Pair_And_Can_Split);
		Result r1 = new Result(matrixKey1, PlayerAction.Double);
		Result r11 = new Result(matrixKey1, PlayerAction.Hit);
		Result r2 = new Result(matrixKey2, PlayerAction.Split);
		Result r22 = new Result(matrixKey2, PlayerAction.Giveup);
		
		Frequency frequency = new Frequency();
		System.out.println(r1.hashCode());
		frequency.addValue(r1);
		System.out.println(r11.hashCode());
		frequency.addValue(r11);
		System.out.println(r2.hashCode());
		frequency.addValue(r2);
		System.out.println(r22.hashCode());
		frequency.addValue(r22);
		System.out.println(r1.equals(r2));
		System.out.println(frequency);
	}
	
}
