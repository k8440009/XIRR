package src;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Util {
	public static final boolean DEBUG_GOAL_SEEK = true;

	/**
	 * 인스턴스화 하지 않고 사용
	 */
	private Util() {
	}

	public static void log(String message) {
		System.out.println(message);
	}

	/**
	 * Returns the same value as Excel's DataValue method.
	 *
	 * @param date
	 * @return
	 */
	public static int getExcelDateValue(Calendar date) {
		GregorianCalendar dateStart = new GregorianCalendar(1900, 1, 1);
		return getDaysBetween(dateStart, date);
	}

	/**
	 * Calculates the number of days between two calendar days in a manner which is
	 * independent of the Calendar type used.
	 *
	 * @param d1 The first date.
	 * @param d2 The second date.
	 *
	 * @return The number of days between the two dates. Zero is returned if the
	 *         dates are the same, one if the dates are adjacent, etc. The order of
	 *         the dates does not matter, the value returned is always >= 0. If
	 *         Calendar types of d1 and d2 are different, the result may not be
	 *         accurate.
	 */
	public static int getDaysBetween(Calendar d1, Calendar d2) {
		// d1 > d2 이면 swap
		if (d1.after(d2)) {
			Calendar swap = d1;
			d1 = d2;
			d2 = swap;
		}

		int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);
		int y2 = d2.get(Calendar.YEAR);

		if (d1.get(Calendar.YEAR) != y2) {
			d1 = (Calendar) d1.clone();
			do {
				days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);
				d1.add(Calendar.YEAR, 1);
			} while (d1.get(Calendar.YEAR) != y2);
		}

		return days;
	}

}
