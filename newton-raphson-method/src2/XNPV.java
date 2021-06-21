package src2;

import java.util.Calendar;
import java.util.List;

import src2.data.DataSet;
import src2.data.NewtonStatus;
// import src2.CalculateDate;

public class XNPV {
    public NewtonStatus xnpv(double rate, DataSet dataSet){
        CalculateDate dateFunc = new CalculateDate();
        DataSet data;
        List<Double> values;
        List<Calendar> dates;
        double sum;
        //double digits = Math.pow(10, 9);
        
        int arrSize;

        data = dataSet;
        values = data.getValues();
        dates = data.getDates();
        sum = 0;
        arrSize = data.getArrSize();

        for (int i = 0; i < arrSize; i++){
            double diff = dateFunc.getDaysBetween(dates.get(i), dates.get(0));
            
            if (diff < 0){
                return new NewtonStatus(NewtonStatus.GOAL_SEEK_ERROR, null);
            }
            sum += values.get(i) / Math.pow( 1 + rate, diff / 365.0);
        }
        //sum = sum * digits/ digits;
        sum = Double.parseDouble(String.format("%.8f", sum));
        return new NewtonStatus(NewtonStatus.GOAL_SEEK_OK, sum);
    }
}