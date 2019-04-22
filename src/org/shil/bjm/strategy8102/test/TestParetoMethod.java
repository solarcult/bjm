package org.shil.bjm.strategy8102.test;

import java.util.ArrayList;
import java.util.List;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.strategy8102.EvolutionOneWayTest;
import org.shil.bjm.strategy8102.EvolutionParetoFrontTest;
import org.shil.bjm.strategy8102.strategy.StrategyMatrix8012;
import org.shil.bjm.strategy8102.strategy.practise.Finally2046;
import org.shil.bjm.strategy8102.strategy.practise.Finally2047;
import org.shil.bjm.strategy8102.strategy.practise.Standard2017;
import org.shil.bjm.strategy8102.strategy.practise.Standard2018;

public class TestParetoMethod {

	public static void main(String[] args) {
		EvolutionOneWayTest.debug = true;
		StrategyMatrix8012 one = new Finally2047();
		StrategyMatrix8012 two = new Finally2046();
		StrategyMatrix8012 three = new Standard2017();
		StrategyMatrix8012 four = new Standard2018();
		HelloWorld.printStrategyMatrix8012(one, two,three,four);
		List<StrategyMatrix8012> all = new ArrayList<>();
		all.add(one);
		all.add(two);
		all.add(three);
		all.add(four);
		List<StrategyMatrix8012> xs = EvolutionParetoFrontTest.findParetoFront(all);
		for(StrategyMatrix8012 x : xs) {
			System.out.println(x.getClass().getName() + " " + x.getCalcResult());
		}
	}

}
