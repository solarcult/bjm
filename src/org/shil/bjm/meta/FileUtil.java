package org.shil.bjm.meta;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.math3.stat.Frequency;
import org.shil.bjm.strategy8102.Result;
import org.shil.bjm.strategy8102.Standard2018;
import org.shil.bjm.strategy8102.StrategyMatrix8012;

public class FileUtil {
	
	public static void writeToDisk(int generation, List<StrategyMatrix8012> evos){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
		String fileName=generation+"_"+ sdf.format(Calendar.getInstance().getTime())+"_blackjack.txt";
		try {
			BufferedWriter out=new BufferedWriter(new FileWriter(fileName,true));
			out.write(Calendar.getInstance().getTime().toString());
			out.newLine();
			out.write(analyzeEvos(evos).toString());
			out.newLine();
			out.newLine();
//			for(StrategyMatrix8012 e : evos) {
//				out.write(e.toString());
//				out.newLine();
//			}
			out.write("lift:");
			out.newLine();
			out.write(new Standard2018().diffWith(evos.get(0)));
			out.newLine();
			out.write(evos.get(0).toString());
			out.flush();
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Frequency analyzeEvos(List<StrategyMatrix8012> evos) {
		Frequency frequency = new Frequency();
		for(StrategyMatrix8012 e : evos) {
			for(Result r : e.getChangeMatrxByList()) {
				frequency.addValue(r.toString());
			}
		}
		return frequency;
	}
}
