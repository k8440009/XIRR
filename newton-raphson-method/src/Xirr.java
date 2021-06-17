package src;

public class Xirr {

	public static double caclulate(DataSet dataSet){
		NewtonData data = new NewtonData();
		NewtonStatus status;
		double result;
		double rate;

		Newton.initialize(data);

		data.setXmin(-1);
		data.setXmax(Math.min(1000, data.getXmax()));
		rate = dataSet.getGuessRate();

		status = Newton.newtonRaphsonMethod(new XNPV(), null, data, dataSet, rate);

		if (status.getSeekStatus() == NewtonStatus.GOAL_SEEK_OK){
			result = ((Double)status.getReturnData()).doubleValue();
		}
		else{
			result = Double.NaN;
		}

		Util.log("XIRR result - " + result);
		return (Double.isNaN(result)) ? (result - 1) : result;
	}
}
