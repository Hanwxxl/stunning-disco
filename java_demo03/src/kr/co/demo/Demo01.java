package kr.co.demo;

public class Demo01 {

	public static void main(String[] args) {
		/*
		 *  if 조건문
		 *      프로그램 수행 흐름을 바꾸기 위한 역할을 수행하는 제어문중 하나.
		 *      조건에 따라 다른 코드가 실행되도록 한다.
		 *     
		 *  if(조건식) {
		 *      실행 코드
		 *  }
		 *  
		 *  if(조건식) {
		 *      실행 코드 A
		 *  } else {
		 *      실행 코드 B
		 *  }
		 *  
		 *  if(조건식A) {
		 *      실행 코드 1
		 *  } else if(조건식B) {
		 *      실행 코드 2
		 *  } else if(조건식C) {
		 *      실행 코드 3
		 *  }
		 *  
		 *  if(조건식A) {
		 *      if(조건식B) {
		 *          실행 코드 1
		 *      }
		 *  }
		 *  
		 */
		
		/*
		int x = 2;
		
		if(x == 1) {
			System.out.println("변수 x 에는 정수 1 이 저장되어 있습니다.");
		}
		
		System.out.println("프로그램이 종료 됩니다.");
		*/
		
		/*
		int x2 = 13;
		
		if(x2 % 2 == 0) {
			System.out.println("변수 x2 에는 짝수값이 저장되어 있습니다.");
		} else {
			System.out.println("변수 x2 에는 홀수값이 저장되어 있습니다.");
		}
		
		System.out.println("프로그램이 종료 됩니다.");
		*/
		
		/*
		int x3 = 5;
		
		if(x3 < 10) {
			System.out.println("변수 x3 에 저장된 값은 10 보다 작습니다.");
		} else if(x3 < 20) {
			System.out.println("변수 x3 에 저장된 값은 10 이상이지만 20 보다는 작습니다.");
		} else if(x3 < 30) {
			System.out.println("변수 x3 에 저장된 값은 20 이상이지만 30 보다는 작습니다.");
		}
		
		System.out.println("프로그램이 종료 됩니다.");
		*/
		
		/*
		int x4 = 5;
		
		if(x4 < 10) {
			System.out.println("변수 x4 에 저장된 값은 10 보다 작습니다.");
		}
		
		if(x4 < 20) {
			System.out.println("변수 x4 에 저장된 값은 10 이상이지만 20 보다는 작습니다.");
		}
		
		if(x4 < 30) {
			System.out.println("변수 x4 에 저장된 값은 20 이상이지만 30 보다는 작습니다.");
		}
		
		System.out.println("프로그램이 종료 됩니다.");
		*/
		
		int x5 = 6;
		
		if(x5 > 10) {
			if(x5 % 2 == 0) {
				System.out.println("변수 x5 에 저장된 값은 10 보다 크가 짝수 입니다.");
			} else {
				System.out.println("변수 x5 에 저장된 값은 10 보다 크가 홀수 입니다.");
			}
		} else {
			if(x5 % 2 == 0) {
				System.out.println("변수 x5 에 저장된 값은 10 미만이고 짝수 입니다.");
			}
		}
		
		System.out.println("프로그램이 종료 됩니다.");
	}

}
