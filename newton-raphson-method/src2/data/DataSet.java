package src2.data;

import java.util.Calendar;
import java.util.List;

public class DataSet {
    public static final int GOAL_SEEK_OK = 1;
	public static final int GOAL_SEEK_ERROR = 0;
    
	private List<Double> values;
	private List<Calendar> dates;

    private int arrSize;

	public List<Double> getValues() {
		return this.values;
	}

	public void setValues(List<Double> values) {
		this.values = values;
	}

    public List<Calendar> getDates() {
        return this.dates;
    }

    public void setDates(List<Calendar> dates) {
        this.dates = dates;
    }

    public int getArrSize() {
        return this.arrSize;
    }

    public void setArrSize(int arrSize) {
        this.arrSize = arrSize;
    }
}
