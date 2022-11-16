package kr.co.exam03;

import java.util.Scanner;

public class Exam {

	public static void main(String[] args) {
		/*
		 * 다음의 객체를 클래스로 만들 때 멤버 변수/상수, 클래스 변수/상수
		 * 생성자, 메서드를 활용하여 만들어보세요.
		 * 
		 * 시계 클래스를 만들어 보세요. 해당 클래스는 현재 시간을 시, 분, 초
		 * 정수 단위로 입력하면 이에 적합한 시:분:초 형식의 문자열로 출력할 수
		 * 있는 getTimeString() 메서드를 제공합니다.
		 */
		Clock clock = new Clock(12, 30, 30);
		System.out.println(clock.getTimeString());
		
		Speaker speaker1 = new Speaker();
		Speaker speaker2 = new Speaker(50);
		Speaker speaker3 = new Speaker(50, true);
		Speaker speaker4 = new Speaker(50, true, true);
		
		speaker1.togglePower();
		// speaker1.toggleMute();
		speaker1.volumeUp();
		speaker1.volumeUp();
		speaker1.volumeUp();
		speaker1.volumeUp();
		speaker1.volumeUp();
		System.out.println(speaker1.getState());
		
		Elevator el1 = new Elevator(10);
		Elevator el2 = new Elevator(-5, 10);
		
		el2.move(5);
		el2.move(-2);
		el2.move(0);
		
		FoodMenu food = new FoodMenu();
		food.add("만두", 4500);
		food.add("김밥", 4000);
		food.add("라면", 3500);
		System.out.print(food.show());
		
		String menuName = "돈까스";
		if(food.find(menuName) != -1) {
			System.out.println(menuName + " 메뉴의 가격은 " + food.find(menuName) + " 원 입니다."); 
		} else {
			System.out.println("해당하는 메뉴가 없습니다.");
		}
		
		menuName = "김밥";
		int price = 4500;
		
		boolean result = food.update(menuName, price);
		if(result) {
			System.out.println("수정되었습니다.");
		} else {
			System.out.println("해당하는 메뉴가 없습니다.");
		}
		System.out.print(food.show());
		
		
		
		menuName = "김밥";
		result = food.remove(menuName);
		if(result) {
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("해당하는 메뉴가 없습니다.");
		}
		System.out.print(food.show());
	}

}
