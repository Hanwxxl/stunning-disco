package kr.co.exam01;

public class MonthRangeException extends RuntimeException {

	public MonthRangeException() {
		super("날짜에 사용할 월 범위가 잘못되었습니다.");
	}
	
	public MonthRangeException(String message) {
		super(message);
	}
	
}
