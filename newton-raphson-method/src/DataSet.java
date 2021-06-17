package src;

import java.util.List;

public class DataSet {
	private int arrSize;
	private double guessRate;
	private List<Double> values;
	private List<Double> dates;

	/**
	 *  Default Constructor.
	 */
	public DataSet(){

	}

	/**
	 * 
	 */
	public DataSet(int arrSize, double guessRate, List<Double> values, List<Double> dates){
		this.arrSize = arrSize;
		this.guessRate = guessRate;
		this.values = values;
		this.dates = dates;
	}

	public int getArrSize() {
		return this.arrSize;
	}

	public void setArrSize(int arrSize) {
		this.arrSize = arrSize;
	}

	public double getGuessRate() {
		return this.guessRate;
	}

	public void setGuessRate(double guessRate) {
		this.guessRate = guessRate;
	}

	public List<Double> getValues() {
		return this.values;
	}

	public void setValues(List<Double> values) {
		this.values = values;
	}

	public List<Double> getDates() {
		return this.dates;
	}

	public void setDates(List<Double> dates) {
		this.dates = dates;
	}
}
