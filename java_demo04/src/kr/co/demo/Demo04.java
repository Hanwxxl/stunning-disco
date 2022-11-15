package kr.co.demo;

import java.util.Arrays;
import java.util.Scanner;

public class Demo04 {

	public static void main(String[] args) {
		/*
		 * 동적 배열
		 *     System.arraycopy 를 이용한 깊은 복사
		 */
		Scanner sc = new Scanner(System.in);
		int arr1[] = new int[3];
		arr1[0] = 1; arr1[1] = 2; arr1[2] = 3;
		
		int tmp[];
		
		for(int i = 0; i < 5; i++) {
			System.out.print("정수값을 입력하세요 : ");
			int num = sc.nextInt();
			
			tmp = new int[arr1.length + 1];
			
			System.arraycopy(arr1, 0, tmp, 1, arr1.length);
			
			tmp[0] = num;
			
			arr1 = tmp;
			
			System.out.printf("arr1 배열의 크기가 %d 가 되었습니다.\n", arr1.length);
		}
		
		System.out.println(Arrays.toString(arr1));
	}

}
