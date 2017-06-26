package org.shil.bjm.meta;

public class WinDrawLose {

	public static int win = 0;
	public static int draw = 1;
	public static int lose = 2;
	public static int better = 3;
	public static int normal = 4;
	public static int worse = 5;
	
	public static double[] addMatrix(double[] result, double[] add){
		if(result.length < add.length) throw new RuntimeException("result must lengther than add");
		for(int i=0;i<add.length;i++){
			result[i] += add[i];
		}
		return result;
	}
}
