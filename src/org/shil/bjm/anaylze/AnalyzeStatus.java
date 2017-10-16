package org.shil.bjm.anaylze;

public class AnalyzeStatus {
	
	/**
	 * 数值
	 */
	private int value;
	/**
	 * 本数值所占百分比
	 */
	private double precent;
	/**
	 * 直到现在数值之前所有的百分比
	 */
	private double tillPct;
	/**
	 * 本数值的概率
	 */
	private double prob;
	/**
	 * 直到现在数值之前的所有的概率和
	 */
	private double tillProb;
	private double totalProb;
	
	public AnalyzeStatus(int value,double precent,double tillPct,double prob,double tillProb,double totalProb){
		this.value = value;
		this.precent = precent;
		this.tillPct = tillPct;
		this.prob = prob;
		this.tillProb = tillProb;
		this.totalProb = totalProb;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public double getPrecent() {
		return precent;
	}

	public void setPrecent(double precent) {
		this.precent = precent;
	}

	public double getTillPct() {
		return tillPct;
	}

	public void setTillPct(double tillPct) {
		this.tillPct = tillPct;
	}

	public double getProb() {
		return prob;
	}

	public void setProb(double prob) {
		this.prob = prob;
	}

	public double getTillProb() {
		return tillProb;
	}

	public void setTillProb(double tillProb) {
		this.tillProb = tillProb;
	}

	public double getTotalProb() {
		return totalProb;
	}

	public void setTotalProb(double totalProb) {
		this.totalProb = totalProb;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(precent);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(prob);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(tillPct);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(tillProb);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalProb);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + value;
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
		AnalyzeStatus other = (AnalyzeStatus) obj;
		if (Double.doubleToLongBits(precent) != Double
				.doubleToLongBits(other.precent))
			return false;
		if (Double.doubleToLongBits(prob) != Double
				.doubleToLongBits(other.prob))
			return false;
		if (Double.doubleToLongBits(tillPct) != Double
				.doubleToLongBits(other.tillPct))
			return false;
		if (Double.doubleToLongBits(tillProb) != Double
				.doubleToLongBits(other.tillProb))
			return false;
		if (Double.doubleToLongBits(totalProb) != Double
				.doubleToLongBits(other.totalProb))
			return false;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AnalyzeStatus [value=" + value + ", \tprecent= " + precent
				+ ", \ttillPct= " + tillPct + ", \tprob= " + prob + ", \ttillProb= "
				+ tillProb + ", \ttotalProb=" + totalProb + "]";
	}
	
	
}
