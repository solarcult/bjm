package org.shil.bjm.strategy8102.comparator;

import java.util.Comparator;

import org.shil.bjm.strategy8102.strategy.StrategyMatrix8012;

public class WdlRateWithDSWithProbRateComparator implements Comparator<StrategyMatrix8012> {

	@Override
	public int compare(StrategyMatrix8012 arg0, StrategyMatrix8012 arg1) {
		if(arg0.getProbRate()[0] > arg1.getProbRate()[0]) {
			return -1;
		}else if(arg0.getProbRate()[0] < arg1.getProbRate()[0]) {
			return 1;
		}
		return 0;
	}

}
