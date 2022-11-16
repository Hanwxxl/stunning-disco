package kr.co.exam02;

public class Triangle {
	double width;
	double height;
	double round;
	double area;
	
	public Triangle(double width) {
		this.width = width;
		this.height = width;
		this.round = width + (Math.sqrt((width / 2) * (width / 2) + (width * width))) * 2;
		this.area = width * width / 2;
	}
	
	public Triangle(double width, double height) {
		this.width = width;
		this.height = height;
		this.round = Math.sqrt((width * width) + (height * height)) + width + height;
		this.area = width * height / 2;
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public double getRound() {
		return this.round;
	}
	
	public double getArea() {
		return this.area;
	}
}
