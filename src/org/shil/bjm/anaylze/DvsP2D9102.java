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
	
	//per prob rates
	private Double[] perProbRates;
	private double totalPlayTimes;
	
	//赢来的钱，包含自己本金
	double probReturnMoney = 0;
	//总共投入的钱
	double probTotalSpendMoney = 0;
	//roi
	double probRoi = 0;
	
	//基于probRoi/牌的分裂数量的比率，用来衡量 double于Hit的选择,因为很多时候，Hit的得到的probRoi效果更好，是由于分裂了更多的牌，现实中，却只有有限次数，所有获得有限次数的最大收益，是我们追求的目标。
	double perProbReturnMoney = 0;
	double perProbTotalSpendMoney = 0;
	double perProbRoi = 0;
	
	//赢来的钱，包含自己本金
	double timeReturnMoney = 0;
	//总共投入的钱
	double timeTotalSpendMoney = 0;
	//roi
	double timeRoi = 0;
	
	
	public DvsP2D9102(Double[] probRates,double totalProbs,Double[] timeRates,double totalTimes,double probReturnMoney,double probTotalSpendMoney,double timeReturnMoney,double timeTotalSpendMoney,double totalPlayTimes) {
		this.probRates = probRates;
		this.totalProbs = totalProbs;
		this.timeRates = timeRates;
		this.totalTimes = totalTimes;
		this.probReturnMoney = probReturnMoney;
		this.probTotalSpendMoney = probTotalSpendMoney;
		this.probRoi = probReturnMoney/probTotalSpendMoney;
		this.timeReturnMoney = timeReturnMoney;
		this.timeTotalSpendMoney = timeTotalSpendMoney;
		this.timeRoi = timeReturnMoney/timeTotalSpendMoney;
		this.totalPlayTimes = totalPlayTimes;
		this.perProbReturnMoney = probReturnMoney/totalPlayTimes;
		this.perProbTotalSpendMoney = probTotalSpendMoney/totalPlayTimes;
		this.perProbRoi = (perProbReturnMoney/perProbTotalSpendMoney)/totalPlayTimes;
		this.perProbRates = new Double[] {probRates[0]/totalPlayTimes,probRates[1]/totalPlayTimes,probRates[2]/totalPlayTimes};
	}

	public Double[] getProbRates() {
		return probRates;
	}

	public Double[] getTimeRates() {
		return timeRates;
	}

	public double getTotalProbs() {
		return totalProbs;
	}

	public double getTotalTimes() {
		return totalTimes;
	}

	public double getProbReturnMoney() {
		return probReturnMoney;
	}

	public double getProbTotalSpendMoney() {
		return probTotalSpendMoney;
	}

	public double getProbRoi() {
		return probRoi;
	}

	public double getTimeReturnMoney() {
		return timeReturnMoney;
	}

	public double getTimeTotalSpendMoney() {
		return timeTotalSpendMoney;
	}

	public double getTimeRoi() {
		return timeRoi;
	}

	public double getPerProbReturnMoney() {
		return perProbReturnMoney;
	}

	public double getPerProbTotalSpendMoney() {
		return perProbTotalSpendMoney;
	}

	public double getPerProbRoi() {
		return perProbRoi;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(perProbRates);
		long temp;
		temp = Double.doubleToLongBits(perProbReturnMoney);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(perProbRoi);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(perProbTotalSpendMoney);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Arrays.hashCode(probRates);
		temp = Double.doubleToLongBits(probReturnMoney);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(probRoi);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(probTotalSpendMoney);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Arrays.hashCode(timeRates);
		temp = Double.doubleToLongBits(timeReturnMoney);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(timeRoi);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(timeTotalSpendMoney);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalPlayTimes);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalProbs);
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
		if (!Arrays.equals(perProbRates, other.perProbRates))
			return false;
		if (Double.doubleToLongBits(perProbReturnMoney) != Double.doubleToLongBits(other.perProbReturnMoney))
			return false;
		if (Double.doubleToLongBits(perProbRoi) != Double.doubleToLongBits(other.perProbRoi))
			return false;
		if (Double.doubleToLongBits(perProbTotalSpendMoney) != Double.doubleToLongBits(other.perProbTotalSpendMoney))
			return false;
		if (!Arrays.equals(probRates, other.probRates))
			return false;
		if (Double.doubleToLongBits(probReturnMoney) != Double.doubleToLongBits(other.probReturnMoney))
			return false;
		if (Double.doubleToLongBits(probRoi) != Double.doubleToLongBits(other.probRoi))
			return false;
		if (Double.doubleToLongBits(probTotalSpendMoney) != Double.doubleToLongBits(other.probTotalSpendMoney))
			return false;
		if (!Arrays.equals(timeRates, other.timeRates))
			return false;
		if (Double.doubleToLongBits(timeReturnMoney) != Double.doubleToLongBits(other.timeReturnMoney))
			return false;
		if (Double.doubleToLongBits(timeRoi) != Double.doubleToLongBits(other.timeRoi))
			return false;
		if (Double.doubleToLongBits(timeTotalSpendMoney) != Double.doubleToLongBits(other.timeTotalSpendMoney))
			return false;
		if (Double.doubleToLongBits(totalPlayTimes) != Double.doubleToLongBits(other.totalPlayTimes))
			return false;
		if (Double.doubleToLongBits(totalProbs) != Double.doubleToLongBits(other.totalProbs))
			return false;
		if (Double.doubleToLongBits(totalTimes) != Double.doubleToLongBits(other.totalTimes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DvsP2D9102 [probRates=" + Arrays.toString(probRates) + ", totalProbs=" + totalProbs + ", timeRates="
				+ Arrays.toString(timeRates) + ", totalTimes=" + totalTimes + ", perProbRates="
				+ Arrays.toString(perProbRates) + ", totalPlayTimes=" + totalPlayTimes + ", probReturnMoney="
				+ probReturnMoney + ", probTotalSpendMoney=" + probTotalSpendMoney + ", probRoi=" + probRoi
				+ ", perProbReturnMoney=" + perProbReturnMoney + ", perProbTotalSpendMoney=" + perProbTotalSpendMoney
				+ ", perProbRoi=" + perProbRoi + ", timeReturnMoney=" + timeReturnMoney + ", timeTotalSpendMoney="
				+ timeTotalSpendMoney + ", timeRoi=" + timeRoi + "]";
	}

	public Double[] getPerProbRates() {
		return perProbRates;
	}

	public double getTotalPlayTimes() {
		return totalPlayTimes;
	}
	
}
