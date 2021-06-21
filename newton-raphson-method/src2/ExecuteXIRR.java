package src2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.crypto.Data;

import src2.data.DataSet;

public class ExecuteXIRR {
	public static void main(String[] args) {
		// 데이터 받음
		DataSet dataSet = new DataSet();
		List<Double> values = new ArrayList<>();
		List<Calendar> dates = new ArrayList<>();
        XIRR xirr = new XIRR();

		values.add(-5000000.0);
		values.add(1300000.0);
		values.add(1200000.0);
		values.add(2500000.0);
		values.add(1900000.0);

        dates.add(new GregorianCalendar(2016, Calendar.JANUARY, 30));
        dates.add(new GregorianCalendar(2016, Calendar.MARCH, 20));
        dates.add(new GregorianCalendar(2016, Calendar.APRIL, 30));
        dates.add(new GregorianCalendar(2016, Calendar.JULY, 25));
        dates.add(new GregorianCalendar(2016, Calendar.OCTOBER, 30));

        dataSet.setValues(values);
        dataSet.setDates(dates);
        dataSet.setArrSize(2);

        System.out.println("XNPV size 2: " + xirr.calculate(dataSet));

        DataSet dataSet1 = new DataSet();
        dataSet1 = dataSet;
        dataSet1.setArrSize(3);
        System.out.println("XNPV size 3: " + xirr.calculate(dataSet1));

        DataSet dataSet2 = new DataSet();
        dataSet2 = dataSet;
        dataSet2.setArrSize(4);
        System.out.println("XNPV size 4: " + xirr.calculate(dataSet2));

        DataSet dataSet3 = new DataSet();
        dataSet3 = dataSet;
        dataSet3.setArrSize(5);
        System.out.println("XNPV size 5: " + xirr.calculate(dataSet3));
	}
}
