package org.shil.bjm.meta;

import java.util.HashMap;
import java.util.Map;

/**
 * 玩家的起始牌组合值
 * @author vanis
 *
 */
public enum StartValue {

	One(1),Two(2),Three(3),Four(4),Five(5),Six(6),Seven(7),Eight(8),Nine(9),Ten(10),Eleven(11),Twelve(12),Thirteen(13),Fourteen(14),Fifteen(15),Sixteen(16),Seventeen(17),Eighteen(18),Nineteen(19),Twenty(20),TwentyOne(21);
	
	private int value;
	StartValue(int _value){
		value = _value;
	}
	
	public int getValue(){
		return value;
	}
	
	private static Map<Integer, StartValue> maps = new HashMap<Integer, StartValue>();
	static{
		for(StartValue s : StartValue.values())
			maps.put(s.value, s);
	}
	
	public static StartValue getOne(int value){
		return maps.get(value);
	}
}
