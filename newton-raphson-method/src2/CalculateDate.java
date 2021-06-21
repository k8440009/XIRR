package src2;

import java.util.Calendar;

public class CalculateDate {
    public double getDaysBetween(Calendar d1, Calendar d2) {
		// d1 > d2 이면 swap
		if (d1.after(d2)) {
			Calendar swap = d1;
			d1 = d2;
			d2 = swap;
		}

        // 하루는 86400초 (24 * 60 * 60)
        long diffDate = (d2.getTimeInMillis() - d1.getTimeInMillis()) / ( 24 * 60 * 60 * 1000);
        System.out.println("diff : " + diffDate);
        return (double)diffDate;
	}
}
