package org.shil.bjm.meta;

import java.util.HashMap;
import java.util.Map;

public enum Card {
	
	One1(1),Two2(2),Three3(3),Four4(4),Five5(5),Six6(6),Seven7(7),Eight8(8),Nine9(9),Ten(10),JJJ(10),QQQ(10),KKK(10);
	
	private int value;
	Card(int _value){
		value = _value;
	}
	
	public int getValue(){
		return value;
	}
	
	private static Map<Integer, Card> maps = new HashMap<Integer, Card>();
	static{
		for(Card c : Card.values())
			maps.put(c.value, c);
	}
	
	public static Card getOne(int value){
		return maps.get(value);
	}
}
