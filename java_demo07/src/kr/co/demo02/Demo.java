package kr.co.demo02;

public class Demo {

	public static void main(String[] args) {
		/*
		 * StringBuilder / StringBuffer
		 */
		StringBuilder sb = new StringBuilder(128);
		sb.append("문자열");
		sb.append("추가");
		System.out.println(sb.toString());
		
		int capacity = sb.capacity();
		System.out.println(capacity);
		
		// delete() : 문자열 삭제
		sb.delete(0, 3);
		System.out.println(sb.toString());
		
		// insert() : 지정한 위치에 문자열 추가
		sb.insert(0, "문자열");
		System.out.println(sb.toString());
		
		sb.insert(3, " insert() ");
		System.out.println(sb.toString());
		
		// length() : 문자열 길이
		int length = sb.length();
		System.out.println(length);
		
		// reverse() : 문자열을 역순으로 나열
		sb.reverse();
		System.out.println(sb.toString());
		
		// setLength() : 
		sb.setLength(20);
		sb.reverse();
		System.out.println(sb.toString());
		
		// trimToSize()
		sb.trimToSize();
		System.out.println(sb.capacity());
		
		// sb.indexOf(), sb.replace(), sb.chatAt(), sb.compareTo(), sb.substring()
		// 위 메서드는 기존 String 클래스에서 사용한 메서드와 동일한 기능을 수행
	}

}
