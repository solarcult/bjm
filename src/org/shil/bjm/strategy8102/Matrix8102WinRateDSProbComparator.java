package org.shil.bjm.strategy8102;

import java.util.Comparator;

public class Matrix8102WinRateDSProbComparator implements Comparator<StrategyMatrix8012> {

	@Override
	public int compare(StrategyMatrix8012 arg0, StrategyMatrix8012 arg1) {
		if(arg0.getWdlRateWithDSWithProb()[0] > arg1.getWdlRateWithDSWithProb()[0]) {
			return -1;
		}else if(arg0.getWdlRateWithDSWithProb()[0] < arg1.getWdlRateWithDSWithProb()[0]) {
			return 1;
		}
		return 0;
	}

}
