package org.shil.bjm.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerCardsPathValue;
import org.shil.bjm.strategy.one.OneWithAMatrix;

/**
 * 生成玩家的所有起手牌类，共13*13种组合
 * @author vanis
 *
 */
public class PlayerCards {

	/**
	 * 基本生成2张牌组合
	 * @return
	 */
	public static Collection<PlayerCardsPathValue> generateTwoStartCards(){
		Collection<PlayerCardsPathValue> allCombination = new HashSet<PlayerCardsPathValue>();
		for(Card one: Card.values()){
			for(Card two : Card.values()){
				PlayerCardsPathValue cardsPathValue = new PlayerCardsPathValue(one,two);
				allCombination.add(cardsPathValue);
			}
		}
		return allCombination;
	}
	
	/**
	 * without Pair without A
	 * @return
	 */
	public static Collection<PlayerCardsPathValue> generateTwoStartCardsWithoutPairWithoutA(){
		Collection<PlayerCardsPathValue> allCombination = new HashSet<PlayerCardsPathValue>();
		for(Card one: Card.values()){
			for(Card two : Card.values()){
				PlayerCardsPathValue cardsPathValue = new PlayerCardsPathValue(one,two);
				if(cardsPathValue.isStartWithA()) continue;
				if(cardsPathValue.isStartWithPairs()) continue;
				allCombination.add(cardsPathValue);
			}
		}
		return allCombination;
	}
	
	/**
	 * 玩家生成起手对牌
	 * @return
	 */
	public static List<PlayerCardsPathValue> generatePairs(){
		List<PlayerCardsPathValue> pairs =  new ArrayList<>();
		for(PlayerCardsPathValue c : generateTwoStartCards()){
			if(c.isStartWithPairs()) pairs.add(c);
		}
		Collections.sort(pairs, new Comparator<PlayerCardsPathValue>(){
			@Override
			public int compare(PlayerCardsPathValue arg0, PlayerCardsPathValue arg1) {
				if(arg0.getValue() > arg1.getValue()){
					return 1;
				}else if(arg0.getValue() < arg1.getValue()){
					return -1;
				}else return 0;
			}
		});
		return pairs;
	}
	
	/**
	 * 玩家生成没有A的起手2张牌
	 * @return
	 */
	public static List<PlayerCardsPathValue> sortedOneValueStartCardsWithoutA(){
		List<PlayerCardsPathValue> countNotSamePCPV =  new ArrayList<>();
		List<Integer> start2sCount = new ArrayList<>();
		for(PlayerCardsPathValue c : generateTwoStartCards()){
			if(c.isStartWithA()) continue;
			if(c.isStartWithPairs()) continue;
			if(!start2sCount.contains(c.getValue())) {
				start2sCount.add(c.getValue());
				countNotSamePCPV.add(c);
			}
		}
		Collections.sort(countNotSamePCPV, new Comparator<PlayerCardsPathValue>(){
			@Override
			public int compare(PlayerCardsPathValue arg0, PlayerCardsPathValue arg1) {
				if(arg0.getValue() > arg1.getValue()){
					return 1;
				}else if(arg0.getValue() < arg1.getValue()){
					return -1;
				}else return 0;
			}
		});
		
		return countNotSamePCPV;
	}
	
	/**
	 * 玩家生成起手两张牌有一张有A
	 * @return
	 */
	public static List<PlayerCardsPathValue> sortedOneValueStartCardsWithA(){
		List<PlayerCardsPathValue> withoutAPCPVs =  new ArrayList<>();
		List<Card> withoutAs = new ArrayList<>();
		for(PlayerCardsPathValue c : generateTwoStartCards()){
			if(!c.isStartWithA()) continue;
			Card withoutA = OneWithAMatrix.findFirstTwoCardsWithOutA(c);
			if(!withoutAs.contains(withoutA)) {
				withoutAs.add(withoutA);
				withoutAPCPVs.add(c);
			}
		}
		Collections.sort(withoutAPCPVs, new Comparator<PlayerCardsPathValue>(){
			@Override
			public int compare(PlayerCardsPathValue arg0, PlayerCardsPathValue arg1) {
				if(arg0.getValue() > arg1.getValue()){
					return 1;
				}else if(arg0.getValue() < arg1.getValue()){
					return -1;
				}else return 0;
			}
		});
		
		return withoutAPCPVs;
	}
	
	public static void main(String[] args){
		HelloWorld.print(generateTwoStartCards());
//		HelloWorld.print(sortedOneValueStartCardsWithoutA());
//		System.out.println(sortedOneValueStartCardsWithoutA().size());
//		System.out.println(generateTwoStartCards().size());
//		HelloWorld.print(sortedOneValueStartCardsWithA());
		double x = 0;
		for(PlayerCardsPathValue p : generateTwoStartCards()){
			x+=p.prob();
		}
		System.out.println(x);
	}
}
