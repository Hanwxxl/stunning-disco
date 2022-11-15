package kr.co.demo;

import java.util.Random;

public class Demo02 {

	public static void main(String[] args) {
		/*
		 * Random 클래스
		 *     난수값을 생성하기 위한 클래스
		 */
		Random random = new Random();
		int lotto[] = new int[6];
		
		for(int i = 0; i < 6; i++) {
			int num = random.nextInt(45) + 1;
			lotto[i] = num;
		}
		
		for(int i = 0; i < 6; i++) {
			System.out.printf("%d\t", lotto[i]);
		}
		System.out.println();
	}

}
