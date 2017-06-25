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

public class PlayerCards {

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
	
	public static List<PlayerCardsPathValue> sortedOneValueStartCardsWithoutA(){
		List<PlayerCardsPathValue> countNotSamePCPV =  new ArrayList<>();
		List<Integer> start2sCount = new ArrayList<>();
		for(PlayerCardsPathValue c : generateTwoStartCards()){
			if(c.isStartWithA()) continue;
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
//		HelloWorld.print(generateTwoStartCards());
//		HelloWorld.print(sortedOneValueStartCardsWithoutA());
//		System.out.println(sortedOneValueStartCardsWithoutA().size());
//		System.out.println(generateTwoStartCards().size());
		HelloWorld.print(sortedOneValueStartCardsWithA());
	}
}
