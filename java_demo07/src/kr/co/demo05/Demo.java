package kr.co.demo05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Demo {

	public static void main(String[] args) throws ParseException {
		/*
		 * 날짜 관련 클래스
		 *     - Date : 시스템으로 부터 현재 날짜, 시간 정보를 가져와서 사용할 수 있게 만들어진 클래스
		 *     - Calendar : new 연산자로 객체 생성을 할 수 없음. 대신 getInstance() 메서드를 사용하여
		 *           날짜, 시간 정보를 생성해야 한다.
		 *     - GregorianCalendar : Calendar 클래스를 상속한 하위 클래스로 년, 월, 일, 시, 분, 초
		 *           정보를 다룰 수 있게 되어 있다.
		 *     - SimpleDateFormat : 날짜 및 시간 정보를 정해진 형식에 맞추어 문자열로 만들어 주는 기능
		 *           을 제공한다. 또는 문자열로 만들어진 날짜 및 시간 형식을 Date 클래스 객체로 만들어 준다. 
		 */
		
		/*
		 * Date 클래스
		 */
		Date date = new Date();
		System.out.println("date 기본 출력 : " + date);
		
		System.out.println("data.getTime() 출력 : " + date.getTime());
		
		int year = Integer.parseInt(String.format("%tY", date));
		int month = Integer.parseInt(String.format("%tm", date));
		int day = Integer.parseInt(String.format("%td", date));
		String strDay = String.format("%tA", date);
		System.out.println(year + "년 " + month + "월 " + day + "일 " + strDay);
		
		int hour = Integer.parseInt(String.format("%tH", date));
		int minute = Integer.parseInt(String.format("%tM", date));
		int second = Integer.parseInt(String.format("%tS", date));
		int ms = Integer.parseInt(String.format("%tL", date));
		System.out.println(hour + "시 " + minute + "분 " + second + "초 ." + ms);
		
		
		/*
		 * Calendar 클래스
		 */
		Calendar c = Calendar.getInstance();
		
		c.add(Calendar.DATE, 5);
		
		int cYear = c.get(Calendar.YEAR);
		int cMonth = c.get(Calendar.MONTH) + 1;
		int cDate = c.get(Calendar.DATE);
		int cDay = c.get(Calendar.DAY_OF_WEEK);
		switch(cDay) {
			case Calendar.SUNDAY:
				strDay = "일요일"; break;
			case Calendar.MONDAY:
				strDay = "월요일"; break;
			case Calendar.TUESDAY:
				strDay = "화요일"; break;
			case Calendar.WEDNESDAY:
				strDay = "수요일"; break;
			case Calendar.THURSDAY:
				strDay = "목요일"; break;
			case Calendar.FRIDAY:
				strDay = "금요일"; break;
			case Calendar.SATURDAY:
				strDay = "토요일"; break;
		}
		System.out.println(cYear + "년 " + cMonth + "월 " + cDate + "일 " + strDay);
		
		
		/*
		 * GregorianCalendar
		 */
		GregorianCalendar gc = new GregorianCalendar();
		gc = new GregorianCalendar(2022, 0, 1);
		gc = new GregorianCalendar(2022, 0, 1, 12, 30, 30);
		
		gc.add(Calendar.DATE, 5);
		
		cYear = gc.get(Calendar.YEAR);
		cMonth = gc.get(Calendar.MONTH) + 1;
		cDate = gc.get(Calendar.DATE);
		cDay = gc.get(Calendar.DAY_OF_WEEK);
		switch(cDay) {
			case Calendar.SUNDAY:
				strDay = "일요일"; break;
			case Calendar.MONDAY:
				strDay = "월요일"; break;
			case Calendar.TUESDAY:
				strDay = "화요일"; break;
			case Calendar.WEDNESDAY:
				strDay = "수요일"; break;
			case Calendar.THURSDAY:
				strDay = "목요일"; break;
			case Calendar.FRIDAY:
				strDay = "금요일"; break;
			case Calendar.SATURDAY:
				strDay = "토요일"; break;
		}
		System.out.println(cYear + "년 " + cMonth + "월 " + cDate + "일 " + strDay);
		
		
		/*
		 * SimpleDateFormat
		 */
		SimpleDateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일 EEEE HH시 mm분 ss초 .SSS");
		String fDate = df.format(new Date());
		System.out.println(fDate);
		
		// df.applyPattern("yyyy-MM-dd");
		date = df.parse("2022년 01월 01일 토요일 00시 00분 00초 .000");
		System.out.println(date);
	}

}
