package kr.co.exam05;

public class Exam {

	public static void main(String[] args) {
		/*
		 * 학생들의 성적을 관리하기 위한 프로그램을 컬렉션을 활용하여 만들어 본다.
		 * 
		 * Student 클래스에는 학생의 정보를 담기 위한 클래스로 사용한다.
		 *     멤버 필드 : 이름, 학년, 반, 번호
		 *     멤버 메서드 : 반드시 hashCode(), equals() 구현할 것
		 *                 Getter/Setter, toString() 구현할 것
		 *     
		 * Subject 클래스에는 과목 정보를 담기 위한 클래스로 사용한다.
		 *     멤버 필드 : 과목명, 점수, 등급
		 *     멤버 메서드 : Getter/Setter, toString() 구현할 것
		 *     
		 * HashMap 을 기본으로 Key 에는 Student 클래스를 사용하고 Value 에는
		 * ArrayList 를 사용하도록 한다. 그리고 ArrayList 에 Subject 클래스를
		 * 담아 사용하도록 한다.
		 * 
		 * 성적 관리 프로그램으로 관리하는 모든 정보는 파일에 저장하여 다음번에 다시
		 * 프로그램을 실행 했을 때 이전 상태가 저장되어 있어야 한다.
		 * 파일명은 "학생성적관리정보.info" 로 한다.
		 */
		Run r = new Run();
		r.start();
	}

}
