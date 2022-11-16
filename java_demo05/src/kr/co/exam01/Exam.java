package kr.co.exam01;

public class Exam {

	public static void main(String[] args) {
		/*
		 * 펜(Pen) 객체를 클래스로 만들어 보시오.
		 */
		Pen pen = new Pen();
		pen.color = "black";
		pen.ballSize = .5;
		pen.type = "ink";
		
		/*
		 * 신발(Shoes) 객체를 클래스로 만들어 보시오.
		 */
		Shoes shoes = new Shoes();
		shoes.brand = "Nike";
		shoes.size = 270;
		shoes.type = "운동화";
		shoes.color = "white";
	}

}
