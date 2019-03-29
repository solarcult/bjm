package org.shil.bjm.anaylze;

import java.util.Arrays;

/**
 * 2019Mar28 23:50
 * @author vanis
 *
 */
public class DvsP2D9102 {
	//prob rates
	private Double[] probRates;
	private double totalProbs;
	//time rates
	private Double[] timeRates;
	private double totalTimes;
	//赢来的钱，包含自己本金
	double returnMoney = 0;
	//总共投入的钱
	double totalSpendMoney = 0;
	//roi
	double roi = 0;
	
	public DvsP2D9102(Double[] probRates,double totalProbs,Double[] timeRates,double totalTimes,double returnMoney,double totalSpendMoney) {
		this.probRates = probRates;
		this.totalProbs = totalProbs;
		this.timeRates = timeRates;
		this.totalTimes = totalTimes;
		this.returnMoney = returnMoney;
		this.totalSpendMoney = totalSpendMoney;
		this.roi = returnMoney / totalSpendMoney;
	}

	public Double[] getProbRates() {
		return probRates;
	}

	public Double[] getTimeRates() {
		return timeRates;
	}

	public double getReturnMoney() {
		return returnMoney;
	}

	public double getTotalSpendMoney() {
		return totalSpendMoney;
	}

	public double getRoi() {
		return roi;
	}

	public double getTotalProbs() {
		return totalProbs;
	}

	public double getTotalTimes() {
		return totalTimes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(probRates);
		long temp;
		temp = Double.doubleToLongBits(returnMoney);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(roi);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Arrays.hashCode(timeRates);
		temp = Double.doubleToLongBits(totalProbs);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalSpendMoney);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalTimes);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DvsP2D9102 other = (DvsP2D9102) obj;
		if (!Arrays.equals(probRates, other.probRates))
			return false;
		if (Double.doubleToLongBits(returnMoney) != Double.doubleToLongBits(other.returnMoney))
			return false;
		if (Double.doubleToLongBits(roi) != Double.doubleToLongBits(other.roi))
			return false;
		if (!Arrays.equals(timeRates, other.timeRates))
			return false;
		if (Double.doubleToLongBits(totalProbs) != Double.doubleToLongBits(other.totalProbs))
			return false;
		if (Double.doubleToLongBits(totalSpendMoney) != Double.doubleToLongBits(other.totalSpendMoney))
			return false;
		if (Double.doubleToLongBits(totalTimes) != Double.doubleToLongBits(other.totalTimes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DvsP2D9102 [probRates=" + Arrays.toString(probRates) + ", totalProbs=" + totalProbs + ", timeRates="
				+ Arrays.toString(timeRates) + ", totalTimes=" + totalTimes + ", returnMoney=" + returnMoney
				+ ", totalSpendMoney=" + totalSpendMoney + ", roi=" + roi + "]";
	}
	
	
}
