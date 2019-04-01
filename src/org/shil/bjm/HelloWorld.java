package org.shil.bjm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;

import org.shil.bjm.anaylze.DealerVSPlayerChance;
import org.shil.bjm.anaylze.DealerVSPlayerResult9102;
import org.shil.bjm.core.DealerCards;
import org.shil.bjm.strategy8102.strategy.StrategyMatrix8012;

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
	
	public static void printDoubleMatrix(Double[] result){
		System.out.println(builderDoubleWDL(result));
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
	
	public static String builderDoubleWDL(Double[] result){
		if(result!=null) {
			return "w:"+result[0]*100+" $d:"+result[1]*100+" $l:"+result[2]*100;
		}else {
			return "null not yet.";
		}
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
			sb.append(advanced[0]-advanced[2]>DealerVSPlayerChance.Double_Limit?"@double@":(advanced[0]-advanced[2]<DealerVSPlayerChance.Surrender_Limit)?"#Surrender#":" _ ");
			sb.append("\t lift : "+((advanced[0]-advanced[2]) - (origin[0]-origin[2]))*100 +" : ");
			sb.append( ((origin[0]-origin[2]) < (advanced[0]-advanced[2]))?"good\t":"bad\t");
			sb.append((((advanced[0]-advanced[2]) - (origin[0]-origin[2])) > DealerVSPlayerChance.Hit_Limit)?" :) hit ":" :| stand" );
		}else{
			sb.append(builderDoubleWDL(origin));
		}
		sb.append("\n");
		return sb.toString();
	}
	
	public static String builder2DoubleWDL(Double[] advanced , Double[] origin){
		
		StringBuilder sb = new StringBuilder();
		if(advanced!=null){
			sb.append("\r\norg->adv\t$w:"+origin[0]*100 + "->" + advanced[0]*100+"  \t$d:"+origin[1]*100 + "->" + advanced[1]*100+"  \t$l:"+origin[2]*100 + "->" + advanced[2]*100);
			sb.append("\r\n\t improve value x$w(high is good):"+(advanced[0]*100 - origin[0]*100)+"  \tx$d:"+(advanced[1]*100 - origin[1]*100)+"  \t x$l(negative is good):"+(advanced[2]*100 - origin[2]*100));
			sb.append("\r\n\t \t $w-$l: "+ (origin[0]-origin[2])*100 +" -> "+ (advanced[0]-advanced[2])*100+"  _ ");
			sb.append(advanced[0]-advanced[2]>DealerVSPlayerResult9102.Double_Limit?"@double@":(advanced[0]-advanced[2]<DealerVSPlayerResult9102.ROI_Surrender)?"#Surrender#":" _ ");
			sb.append("\t lift : "+((advanced[0]-advanced[2]) - (origin[0]-origin[2]))*100 +" : ");
			sb.append( ((origin[0]-origin[2]) < (advanced[0]-advanced[2]))?"good\t":"bad\t");
			sb.append((((advanced[0]-advanced[2]) - (origin[0]-origin[2])) > DealerVSPlayerResult9102.ROI_Hit)?" :) hit ":" :| stand" );
		}else{
			sb.append(builderDoubleWDL(origin));
		}
		sb.append("\n");
		return sb.toString();
	}
	
	public static <K,V> void printMap(Map<K,V> map){
		for(Entry<K,V> e : map.entrySet()){
			System.out.println(e.getKey() +" : " + e.getValue());
		}
	}
	
	public static <K,V> String convertMap2String(Map<K,V> map){
		StringBuilder sb = new StringBuilder();
		for(Entry<K,V> e : map.entrySet()){
			sb.append(e.getKey() +" : " + e.getValue());
		}
		return sb.toString();
	}
	
	public static void printStrategyMatrix8012(StrategyMatrix8012 ...xs ) {
		List<CompletableFuture<Void>> guess = new ArrayList<>();
		for(StrategyMatrix8012 x : xs) {
			CompletableFuture<Void> i = CompletableFuture.runAsync(()->{
				System.out.println(x.getClass().getName() + " " + x.getCalcResult());
			});
			guess.add(i);
		}
		
		CompletableFuture<Void> ra = CompletableFuture.allOf(guess.toArray(new CompletableFuture[guess.size()]));
		ra.join();
	}
	
}
