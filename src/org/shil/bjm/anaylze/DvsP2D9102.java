package org.shil.bjm.anaylze;

/**
 * 2019Mar28 23:50
 * @author vanis
 *
 */
public class DvsP2D9102 {
	private Double[] probRates;
	private Double[] timeRates;
	//赢来的钱，包含自己本金
	double returnMoney = 0;
	//总共投入的钱
	double totalSpendMoney = 0;
	
	double roi = 0;
	
	public DvsP2D9102(Double[] probRates,Double[] timeRates,double returnMoney,double totalSpendMoney) {
		this.probRates = probRates;
		this.timeRates = timeRates;
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

}
