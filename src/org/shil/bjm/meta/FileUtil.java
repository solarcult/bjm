package org.shil.bjm.meta;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.math3.stat.Frequency;
import org.shil.bjm.anaylze.DealerVSPlayerChance;
import org.shil.bjm.strategy8102.strategy.Finally2047;
import org.shil.bjm.strategy8102.strategy.Result;
import org.shil.bjm.strategy8102.strategy.StrategyMatrix8012;

public class FileUtil {
	
	public static void writeToDisk(List<DealerVSPlayerChance> dealerVSPlayerChances) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
		String fileName="researchG_"+ sdf.format(Calendar.getInstance().getTime())+"_researchG.txt";
		try {
			BufferedWriter out=new BufferedWriter(new FileWriter(fileName,true));
			for(DealerVSPlayerChance dealerCardsPathValue : dealerVSPlayerChances) {
				out.write(dealerCardsPathValue.toString());
				out.newLine();
			}
			out.flush();
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 将计算的代数和结果统计写入文件中 good luck
	 * @param generation
	 * @param evos
	 */
	public static void writeToDisk(int generation, List<StrategyMatrix8012> evos,String something){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
		String fileName=generation+"_"+ sdf.format(Calendar.getInstance().getTime())+"_blackjack.txt";
		try {
			BufferedWriter out=new BufferedWriter(new FileWriter(fileName,true));
			out.write(Calendar.getInstance().getTime().toString());
			out.newLine();
			out.write(analyzeEvos(evos).toString());
			out.newLine();
			out.newLine();
			out.write("lift diff with Finally2047 :");
			out.newLine();
			out.write(new Finally2047().diffWith(evos.get(0)));
			out.newLine();
			out.write(evos.get(0).toString());
			out.newLine();
			out.write(something);
			out.newLine();
			out.newLine();
			if(evos.size()>=2) {
				out.write(evos.get(1).toString());
				out.newLine();
				out.newLine();
			}
			if(evos.size()>=3) {
				out.write(evos.get(2).toString());
				out.newLine();
			}
			out.flush();
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 将打牌的规则进行整合统计,次数，百分比
	 * @param evos
	 * @return
	 */
	public static Frequency analyzeEvos(List<StrategyMatrix8012> evos) {
		Frequency frequency = new Frequency();
		for(StrategyMatrix8012 e : evos) {
			for(Result r : e.getChangeMatrxByList()) {
				frequency.addValue(r.toString());
			}
		}
		return frequency;
	}
	
	public static void writeROIsToDisk(String player, String dealer, List<Double> rois) {
		String fileName=player+"_vs_"+ dealer;
		try {
			BufferedWriter out =new BufferedWriter(new FileWriter(fileName,true));
			for(Double roi : rois) {
				if(roi>=0) continue;
				out.write(roi.toString());
				out.newLine();
			}
			out.flush();
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
