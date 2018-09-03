package org.shil.bjm.strategy8102;

import java.util.Comparator;

public class Matrix8102ROIComparator implements Comparator<StrategyMatrix8012> {

	@Override
	public int compare(StrategyMatrix8012 arg0, StrategyMatrix8012 arg1) {
		if(arg0.getROI() > arg1.getROI()) {
			return -1;
		}else if(arg0.getROI() < arg1.getROI()) {
			return 1;
		}
		return 0;
	}

}
