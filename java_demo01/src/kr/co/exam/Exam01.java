package kr.co.exam;

public class Exam01 {

	public static void main(String[] args) {
		// 1. 문자열 변수 name 에 자신의 이름을 저장
		String name = "홍길동";
		
		// 2. 정수 변수 age 에 자신의 나이를 저장
		short age = 30;
		
		// 3. 실수 변수 tall 에 자신의 키를 저장
		double tall = 175.7;
		
		// 4. 변수에 저장된 모든 값을 .println() 함수로 출력 하세요.
		System.out.println(name);
		System.out.println(age);
		System.out.println(tall);
		
		// 5. 변수에 저장된 값을 활용하여 다음 형식에 맞추어 출력하세요.
		//    형식에 맞추어 출력 할 때 .print() / .printf() / .println() 중
		//    자신이 사용하기 편한 함수 하나를 선택하여 출력하세요.
		//     형식 : 저의 이름은 홍길동 입니다. 올해 30세 이며, 내년에는 31세가 됩니다.
		System.out.print("저의 이름은 " + name + " 입니다. 올해 ");
		System.out.print(age + "세 이며, 내년에는 " + (age + 1) + "세가 됩니다.\n");
		
		System.out.println("저의 이름은 " + name + " 입니다. 올해 " + age + "세 이며, 내년에는 " + (age + 1) + "세가 됩니다.");
		
		System.out.printf("저의 이름은 %s 입니다. 올해 %d세 이며, 내년에는 %d세가 됩니다.", name, age, age + 1);
	}

}
