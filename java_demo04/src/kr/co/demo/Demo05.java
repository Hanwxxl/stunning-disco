package kr.co.demo;

import java.util.Arrays;

public class Demo05 {

	public static void main(String[] args) {
		/*
		 * 동적 배열
		 *     Arrays.copyOf 를 이용한 깊은 복사
		 *     배열 크기를 늘리거나 축소하거나 동일한 크기의
		 *     새로운 배열을 복사하는 작업에서는 편함
		 */
		int arr1[] = new int[3];
		arr1[0] = 1; arr1[1] = 2; arr1[2] = 3;
		
		arr1 = Arrays.copyOf(arr1, arr1.length + 5);
		
		for(int i = 5; i > 0; i--) {
			arr1[arr1.length - i] = 4;
		}
		
		System.out.println(Arrays.toString(arr1));
		
		// 깃 연결 테스트
	}

}
