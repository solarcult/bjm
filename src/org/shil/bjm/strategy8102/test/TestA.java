package org.shil.bjm.strategy8102.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.apache.commons.math3.stat.Frequency;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerAction;
import org.shil.bjm.meta.PlayerCardsPathValue;
import org.shil.bjm.meta.ProfitUtil;
import org.shil.bjm.meta.StartValue;
import org.shil.bjm.strategy8102.EvolutionOneWayTest;
import org.shil.bjm.strategy8102.strategy.MatrixKey;
import org.shil.bjm.strategy8102.strategy.RandomGenMatrix;
import org.shil.bjm.strategy8102.strategy.Result;
import org.shil.bjm.strategy8102.strategy.Situation;
import org.shil.bjm.strategy8102.strategy.StrategyMatrix8012;
import org.shil.bjm.strategy8102.strategy.practise.Standard2017;

public class TestA {
	
	public static void main(String[] args) {
		System.out.println(Situation.Splited_Pair_And_Can_NOT_Split.name());
	}
	
	public static void testPureReturnByRandom() {
		for(int i = 1; i <= 20; i++) 
		{
			StrategyMatrix8012 origin = new RandomGenMatrix();
			System.out.println(origin.getTimeMoneyReturn());
		}
	}
	
	public static void testE() {
		PlayerCardsPathValue sixteen  = new PlayerCardsPathValue(Card.Seven7,Card.Nine9);
		sixteen.setAction(PlayerAction.Giveup);
//		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(sixteen, Card.Ten));
		
		List<PlayerCardsPathValue> ss = new ArrayList<>();
		
		for(Card c : Card.values()) {
			PlayerCardsPathValue oneMore = new PlayerCardsPathValue(sixteen);
			oneMore.addCard(c);
			oneMore.setAction(PlayerAction.Stand);
			ss.add(oneMore);
		}
		
		System.out.println(ProfitUtil.moneyCalcOneHandInReturnProb(ss, Card.Ten));
		
	}
	
	
	
	public static void testD() {
		StrategyMatrix8012 a = new Standard2017();
		EvolutionOneWayTest.debug = true;
		a.getTimeRates();
		a.getProbRates();
	}
	
	public static void testC() {
		Standard2017 s = new Standard2017();
		System.out.println(s.getTimeMoneyReturn());
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
