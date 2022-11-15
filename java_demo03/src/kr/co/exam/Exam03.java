package kr.co.exam;

import java.util.Scanner;

public class Exam03 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력과 if 문을 활용하여 사용자로부터 정수값
		 * 2개를 입력 받아 나누기 계산을 수행하고 그 결과를
		 * 출력하세요. 만약 사용자 입력값 중에 0 이 있어서
		 * 산술에러가 발생하는 경우 이를 처리하기 위한 if 문을
		 * 추가로 작성하세요.
		 */
		Scanner sc = new Scanner(System.in);
		
		int x, y;
		
		System.out.print("첫번째 정수값 입력 : ");
		x = sc.nextInt();
		
		System.out.print("두번째 정수값 입력 : ");
		y = sc.nextInt();
		
		if(y == 0) {
			System.out.println("0 으로 나누기 계산을 수행할 수 없습니다.");
			System.out.println("대신 1로 대체하여 수행 합니다.");
			y = 1;
		}
		
		System.out.printf("입력한 정수값에 대한 나누기 계산 결과 -> %d", x / y);
	}

}
