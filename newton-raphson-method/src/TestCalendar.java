// package math;

// import java.util.Calendar;
// import java.util.GregorianCalendar;

// public class TestCalendar {
// 	public static void main(String[] args) {
// 		Calendar cal1 = Calendar.getInstance(); // Calendar 객체 얻어오기 (시스템의 현재날짜와 시간정보)
// 		log("\ntoday : " + cal1);

// 		Calendar cal2 = new GregorianCalendar(); // 그레고리력 달력생성
// 		log("\nGregorianCalendar : " + cal2);

// 		int year = cal1.get(Calendar.YEAR);
// 		int month = cal1.get(Calendar.MONTH);
// 		int day = cal1.get(Calendar.DATE);
// 		int dayOfWeek = cal1.get(Calendar.DAY_OF_WEEK);
// 		int lastDay = cal1.getActualMaximum(Calendar.DATE);

// 		log("\nyear : " + year);
// 		log("month : " + month);             // 달이 0에서부터 시작
// 		log("day : " + day);                 // 오늘 날짜
// 		log("dayOfWeek : " + dayOfWeek);     // 일요일은 1 ~ 토요일은 7
// 		log("lastDay: " + lastDay);          // 마지막 달 날짜 갯수

// 		// 2021-01-01
// 		Calendar cal3 = new GregorianCalendar(); // 그레고리력 달력 생성
// 		cal3.set(Calendar.YEAR, 2021);	// 각 필드에 다른 값 세팅
// 		cal3.set(Calendar.MONTH, 0 + 1);
// 		cal3.set(Calendar.DATE, 1);

// 		log("\nyear : " + cal3.get(Calendar.YEAR));
// 		log("month : " + cal3.get(Calendar.MONTH));
// 		log("day : " + cal3.get(Calendar.DATE));
// 	}

// 	public static void log(String message) {
// 		System.out.println(message);
// 	}
// }
