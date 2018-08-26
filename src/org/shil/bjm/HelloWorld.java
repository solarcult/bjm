package org.shil.bjm;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.shil.bjm.core.DealerCards;

public class HelloWorld {

	public static void main(String[] args){
//		for(CardsPathValue cardsPathValue : DealerCards.StartTwo)
//		{
//			System.out.println(cardsPathValue);
//		}
		System.out.println(DealerCards.StartEight.size());
	}
	
	public static <T> void print(Collection<T> cs){
		for(T o : cs){
			System.out.println(o);
		}
		System.out.println(cs.size());
	}
	
	public static <T> void print(List<T> cs){
		for(T o : cs){
			System.out.println(o);
		}
		System.out.println(cs.size());
	}
	
	public static void printDoubleWDL(double[] result){
		System.out.println("w:"+result[0]*100+"  $d:"+result[1]*100+"  $l:"+result[2]*100);
	}
	
	public static void printDoubleMatrix(double[] result){
		System.out.println(builderDoubleMatrix(result));
	}
	
	public static String builderDoubleMatrix(double[] result){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<result.length;i++){
			sb.append(i).append(" : "+result[i] +" , ");
		}
		
		return sb.substring(0, sb.length()-2);
	}
	
	public static String builderDoubleWDL(double[] result){
		return "w:"+result[0]*100+"  $d:"+result[1]*100+"  $l:"+result[2]*100;
	}
	
	public static void print2DoubleWDL(double[] advanced , double[] origin){
		System.out.println("org->adv $w:"+origin[0]*100 + "->" + advanced[0]*100+"  \t$d:"+origin[1]*100 + "->" + advanced[1]*100+"  \t$l:"+origin[2]*100 + "->" + advanced[2]*100);
		System.out.println(" \timprove value x$w(high is good):"+(advanced[0]*100 - origin[0]*100)+"  \tx$d:"+(advanced[1]*100 - origin[1]*100)+"  \t x$l(negative is good):"+(advanced[2]*100 - origin[2]*100));

	}
	
	public static String builder2DoubleWDL(double[] advanced , double[] origin){
		
		StringBuilder sb = new StringBuilder();
		if(advanced!=null){
			sb.append("\r\norg->adv\t$w:"+origin[0]*100 + "->" + advanced[0]*100+"  \t$d:"+origin[1]*100 + "->" + advanced[1]*100+"  \t$l:"+origin[2]*100 + "->" + advanced[2]*100);
			sb.append("\r\n\t improve value x$w(high is good):"+(advanced[0]*100 - origin[0]*100)+"  \tx$d:"+(advanced[1]*100 - origin[1]*100)+"  \t x$l(negative is good):"+(advanced[2]*100 - origin[2]*100));
			sb.append("\r\n\t \t $w-$l: "+ (origin[0]-origin[2])*100 +" -> "+ (advanced[0]-advanced[2])*100+"  _ ");
			sb.append(advanced[0]-advanced[2]>0.055?"@double@":"noD");
			sb.append("\t lift : "+((advanced[0]-advanced[2]) - (origin[0]-origin[2]))*100 +" : ");
			sb.append( ((origin[0]-origin[2]) < (advanced[0]-advanced[2]))?"good":"bad");
		}else{
			sb.append(builderDoubleWDL(origin));
		}
		return sb.toString();
	}
	
	public static <K,V> void printMap(Map<K,V> map){
		for(Entry<K,V> e : map.entrySet()){
			System.out.println(e.getKey() +" : " + e.getValue());
		}
	}	
}
