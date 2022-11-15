package kr.co.exam;

import java.util.Scanner;

public class Exam03 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력을 활용하여 다음의 데이터를 입력 받고 출력하시오.
		 * 
		 * 카카오의 더치페이와 같이 총 금액과 인원 수를 입력 받고
		 * 인원 수 당 얼마의 금액을 입금하면 되는지 계산하여 출력
		 * 하세요.
		 * 
		 * 출력 형식은 다음과 같습니다.
		 *     총 금액 50000 원을 5 명이 나누어 인당 10000 원을
		 *     다음의 계좌에 입금해 주세요. 나머지 금액 0 원은 제가
		 *     부담할께요.
		 *     입금 계좌 : 0000-00-000-0000000
		 * 
		 * 입금 계좌 정보도 추가로 입력 받아야 합니다.
		 */
		Scanner sc = new Scanner(System.in);
		
		int totalAmount, count, perAmount, leftAmount;
		String bankNumber;
		
		System.out.print("입금 계좌 번호 : ");
		bankNumber = sc.nextLine();
		
		System.out.print("총 금액 : ");
		totalAmount = sc.nextInt();
		
		System.out.print("인원 수 : ");
		count = sc.nextInt();
		
		perAmount = totalAmount / count;
		leftAmount = totalAmount % count;
		
		String message = "총 금액 %,d 원을 %,d 명이 나누어 인당 %,d 원을\n"
				+ "다음의 계좌에 입금해 주세요. 나머지 금액 %,d 원은 제가\n"
				+ "부담할께요.\n"
				+ "입금 계좌 : %s";
		
		System.out.printf(message, totalAmount, count, perAmount,
				leftAmount, bankNumber);
	}

}
