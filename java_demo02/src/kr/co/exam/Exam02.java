package kr.co.exam;

import java.util.Scanner;

public class Exam02 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력을 활용하여 다음의 데이터를 입력 받고 출력하시오.
		 * 
		 * 시, 분, 초 정보를 입력 받아 각각 hour, minute, second
		 * 변수에 저장을 하고 초단위로 환산 후 출력하세요.
		 * 
		 * 예시
		 *     시 : 0
		 *     분 : 10
		 *     초 : 20
		 *     
		 *     총 620 초 입니다.
		 */
		Scanner sc = new Scanner(System.in);
		
		int hour, minute, second, total;
		
		System.out.print("시 : ");
		hour = sc.nextInt();
		
		System.out.print("분 : ");
		minute = sc.nextInt();
		
		System.out.print("초 : ");
		second = sc.nextInt();
		
		total = second;
		total = total + minute * 60; // total += minute * 60;
		total = total + hour * 360;  // total += hour * 360;
		
		System.out.printf("총 %d 초 입니다.", total);
	}

}
