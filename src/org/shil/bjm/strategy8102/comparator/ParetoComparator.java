package org.shil.bjm.strategy8102.comparator;

import java.util.Comparator;

import org.shil.bjm.strategy8102.strategy.StrategyMatrix8012;

public class ParetoComparator implements Comparator<StrategyMatrix8012>{

	@Override
	public int compare(StrategyMatrix8012 arg0, StrategyMatrix8012 arg1) {
		
		double arg0p = arg0.getROI()+arg0.getProbRate()[0]+arg0.getTimeRates()[0];
		double arg1p = arg1.getROI()+arg1.getProbRate()[0]+arg1.getTimeRates()[0];
		
		if(arg0p > arg1p) {
			return -1;
		}else if(arg0p < arg1p) {
			return 1;
		}
		return 0;
	}

}
