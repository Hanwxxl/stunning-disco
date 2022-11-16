package kr.co.demo02;

public class Circle {
	// 멤버 변수/상수 : final 키워드가 사용되면 상수
	private final double PI1 = 3.14;
	
	// 클래스 변수/상수 : static 키워드가 사용되면 클래스 공유 자원
	public static final double PI2 = 3.14;
	private double radius;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public double getArea() {
		// return this.radius * this.radius * this.PI1;
		return this.radius * this.radius * Circle.PI2;
	}
}
