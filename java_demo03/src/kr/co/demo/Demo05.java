package kr.co.demo;

public class Demo05 {

	public static void main(String[] args) {
		/*
		 * while 반복문
		 * 
		 * while(조건식) {
		 *     실행 코드;
		 * }
		 * 
		 * 조건식의 값이 참일 때 반복을 수행하며, 거짓이 되면
		 * 반복을 중단한다.
		 * 
		 * break, continue 사용으로 반복문을 제어할 수 있다.
		 */
		
		int i = 1;
		while(i <= 5) {
			System.out.printf("%d\n", i);
			i++;
		}
		
		// 무한 반복
		while(true) {
			System.out.printf("%d\n", i);
			if(i >= 10) {
				break;
			}
			i++;
		}
		
		// 초기값을 0 부터 시작하여 총 10번 반복
		i = 0;
		while(i < 10) {
			System.out.printf("%d\n", i++);
		}
		
		// 1 ~ n 까지의 범위에서 m의 배수에 해당하는 값만 출력
		int n = 100;
		int m = 7;
		i = 1;
		while(i <= n) {
			if(i % m == 0) {
				System.out.printf("%d\n", i);
			}
			i++;
		}
		
		i = 1;
		while(i <= 9) {
			int j = 1;
			while(j <= 9) {
				System.out.printf("%d X %d = %d\t", j, i, j * i);
				j++;
			}
			System.out.print("\n");
			i++;
		}
		
		/*
		 * do ~ while
		 *     일단 1회 반복은 수행한다.
		 * 
		 * do {
		 *     반복 실행 코드;
		 * } while(조건식);
		 */
		
	}

}
