package kr.co.exam;

import java.util.Scanner;

public class Exam06 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력을 받아서 다음의 기능을 수행하는 코드를 작성
		 * 		1. 입력한 횟수 만큼 정수 값을 입력 받아서 배열에 저장 한다.
		 * 		2. 배열에 저장된 모든 정수의 합과 평균을 구하여 출력
		 * 		3. -1 입력이 들어오면 더 이상 사용자 입력을 받지 않는 것으로 한다.
		 * 
		 * 예제
		 * 		1 번째 정수값 입력 : 7
		 * 		2 번째 정수값 입력 : 12
		 * 		3 번째 정수값 입력 : 24
		 * 		4 번째 정수값 입력 : -1
		 * 
		 * 		총 합 : 43
		 * 		평 균 : 14.3
		 */
		Scanner sc = new Scanner(System.in);
		
		int arr[] = new int[0];
		
		int num = 0;
		int count = 0;
		int sum = 0;
		double avg;
		
		while(true) {
			System.out.printf("%d 번째 정수값 입력 : ", ++count);
			num = sc.nextInt();
			
			if(num == -1) {
				break;
			}
			
			int tmp[] = new int[arr.length + 1];
			
			for(int j = 0; j < arr.length; j++) {
				tmp[j] = arr[j];
			}
			
			tmp[tmp.length - 1] = num;
			
			arr = tmp;
			
			sum += num;
		}
		
		avg = (double)sum / arr.length;
		
		System.out.println();
		System.out.printf("총합 : %d\n", sum);
		System.out.printf("평균 : %.2f\n", avg);
		
//		for(int i = 0; i < arr.length; i++) {
//			System.out.printf("%d\t", arr[i]);
//		}
	}

}
