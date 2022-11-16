package kr.co.exam01;

public class DayRangeException extends RuntimeException {
	
	public DayRangeException() {
		super("날짜에 사용할 일자 범위가 잘못되었습니다.");
	}
	
	public DayRangeException(String message) {
		super(message);
	}
	
}
