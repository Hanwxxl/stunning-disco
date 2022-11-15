package kr.co.demo;

import java.util.Scanner;

public class Demo02 {

	public static void main(String[] args) {
		// 사용자 입력 -> Scanner 클래스
		Scanner sc = new Scanner(System.in);
		
		// 정수값을 입력 받아서 변수 x1 에 저장
		System.out.print("정수값 입력 : ");
		int x1 = sc.nextInt();	sc.nextLine();
		
		System.out.println("정수값 " + x1 + "을 변수 x1 에 저장하였습니다.");
		System.out.println("x1 + 10 의 결과 입니다. -> " + (x1 + 10));
		
		// 실수값을 입력 받아서 변수 y1 에 저장
		System.out.print("실수값 입력 : ");
		double y1 = sc.nextDouble();	sc.nextLine();
		
		System.out.println("실수값 " + y1 + "을 변수 y1 에 저장하였습니다.");
		System.out.println("y1 + 10 의 결과 입니다. -> " + (y1 + 10));
		
		// 문자열을 입력 받아서 변수 str1 에 저장
		System.out.print("문자열 입력 : ");
		String str1 = sc.nextLine();
		
		System.out.println("문자열 '" + str1 + "' 을 변수 str1 에 저장하였습니다.");
	}

}
