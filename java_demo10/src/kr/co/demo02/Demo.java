package kr.co.demo02;

import java.util.ArrayList;
import java.util.HashSet;

public class Demo {

	public static void main(String[] args) {
		/*
		 * Set 계열 컬렉션
		 *     - 저장 순서를 유지하지 않는다.
		 *     - 중복을 허용하지 않는다.
		 *     - 구현 클래스로 HashSet, LinkedHashSet, TreeSet 등이 있다.
		 *     
		 * HashSet
		 *     - 객체를 저장할 때 hash 함수를 사용하여 처리 속도가 빠르다.
		 *     - 동일 객체 뿐 아니라 동등 객체도 중복하여 저장하지 않는다.
		 *     
		 * LinkedHashSet
		 *     - HashSet 과 동일하지만 Set 에 추가되는 데이터들의 순서가 유지 된다.
		 *     
		 * TreeSet
		 *     - 검색 기능을 강화한 컬렉션으로 계층 구조를 활용해 이진 트리 자료구조로
		 *       구성되어 있다.(기본적으로 자료들이 정렬되어 저장된다.)
		 */
		
		HashSet<Integer> aSet = new HashSet<Integer>();
		
		// 데이터 추가
		aSet.add(Integer.valueOf(10)); aSet.add(Integer.valueOf(20));
		aSet.add(Integer.valueOf(30)); aSet.add(Integer.valueOf(40));
		aSet.add(Integer.valueOf(50)); aSet.add(Integer.valueOf(60));
		
		System.out.println(aSet);
		
		// 데이터 검색
		boolean isExists = aSet.contains(Integer.valueOf(20));
		System.out.println("정수 20이 있습니까? -> " + isExists);
		
		// 데이터 삭제
		aSet.remove(Integer.valueOf(20));
		System.out.println(aSet);
		
		// 크기 확인
		int size = aSet.size();
		System.out.println("컬렉션에 저장된 데이터 수: " + size);
		
		// Set 을 List 로 변경
		ArrayList<Integer> aList = new ArrayList<Integer>(aSet);
		System.out.println(aList);
		
		// List 를 Set 으로 변경
		HashSet<Integer> bSet = new HashSet<Integer>(aList);
		System.out.println(bSet);
	}

}
