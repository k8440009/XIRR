package src;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class ExecuteXIRR {

	public static void main(String[] args) {
		GregorianCalendar dateEnd = new GregorianCalendar(2021, 6, 16);
		int daysBetween = Util.getExcelDateValue(dateEnd);

		Util.log( "Days Between = " + daysBetween ) ;

		List<Double> values = new ArrayList<>();
		List<Double> dates = new ArrayList<>();
		/*
		values.add(-6000.0);
		values.add(2134.0);
		values.add(1422.0);
		values.add(1933.0);
		values.add(1422.0);


		dates.add((double)Util.getExcelDateValue( new GregorianCalendar(1999, 1, 15)));
		dates.add((double)Util.getExcelDateValue( new GregorianCalendar(1999, 3, 4)));
		dates.add((double)Util.getExcelDateValue( new GregorianCalendar(2000, 2, 12)));
		dates.add((double)Util.getExcelDateValue( new GregorianCalendar(2000, 4, 1)));
		*/
		/*
			values[0]           = -5000000 ;
			values[1]           = 1300000 ;
			values[2]           = 1200000 ;
			values[3]           = 2500000 ;
			values[4]           = 1900000 ;
			dates[0]            = XIRRData.getExcelDateValue( new GregorianCalendar(2016, 1, 30) ) ;
			dates[1]            = XIRRData.getExcelDateValue( new GregorianCalendar(2016, 3, 20) ) ;
			dates[2]            = XIRRData.getExcelDateValue( new GregorianCalendar(2016, 4, 30) ) ;
			dates[3]            = XIRRData.getExcelDateValue( new GregorianCalendar(2016, 7, 25) ) ;
			dates[4]            = XIRRData.getExcelDateValue( new GregorianCalendar(2016, 10, 30) ) ;
		*/
		values.add(-5000000.0);
		values.add(1300000.0);
		values.add(1200000.0);
		values.add(2500000.0);
		values.add(1900000.0);

		dates.add((double)Util.getExcelDateValue( new GregorianCalendar(2016, 1, 30)));
		dates.add((double)Util.getExcelDateValue( new GregorianCalendar(2016, 3, 20)));
		dates.add((double)Util.getExcelDateValue( new GregorianCalendar(2016, 4, 30)));
		dates.add((double)Util.getExcelDateValue( new GregorianCalendar(2016, 7, 25)));
		dates.add((double)Util.getExcelDateValue( new GregorianCalendar(2016, 10, 30)));

		DataSet data       = new DataSet( 5, 0.1, values, dates ) ;
		
		// Util.log("getArrSize() : " + data.getArrSize());
		Util.log("getDates() : " + data.getDates());
		// Util.log("getGuessRate() : " + data.getGuessRate());
		// Util.log("getValues() : " + data.getValues());
		double caclulate = Xirr.caclulate(data);
		Util.log("XIRR data : " + caclulate);
	}
}
