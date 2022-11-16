package kr.co.exam04;

import java.util.Arrays;
import java.util.Scanner;

public class Run {
	
	private Scanner sc = new Scanner(System.in);
	private Student student;
	
	
	public Run() {
		this.student = new Student("홍길동");
		this.student.addSubject("국어", 67.9);
		this.student.addSubject("영어", 77.7);
		this.student.addSubject("수학", 84.5);
	}
	
	private String initMenu() {
		String menu = "";
		
		menu += "1. 성적표 출력\n";
		menu += "2. 과목 성적 출력\n";
		menu += "3. 과목 성적 추가\n";
		menu += "4. 과목 성적 수정\n";
		menu += "5. 과목 성적 삭제\n";
		menu += "6. 프로그램 종료\n";
		
		return menu;
	}
	
	private void select(int number) {
		switch(number) {
			case 1:
				this.printAll(); break;
			case 2:
				this.print(); break;
			case 3:
				this.add(); break;
			case 4:
				this.update(); break;
			case 5:
				this.remove(); break;
			case 6:
				System.out.println("프로그램을 종료 합니다.");
				System.exit(0);
		}
	}
	
	private void printAll() {
		String s = this.student.getGradeTable();
		System.out.println(s);
	}
	
	private void print() {
		while(true) {
			System.out.print("과목 입력 : ");
			String name = sc.nextLine();
			System.out.println();
			
			if(name.equals("exit")) {
				break;
			}
			
			Subject subject = this.student.getSubject(name);
			if(subject != null) {
				System.out.printf("\t%s\n", subject.getName());
				System.out.printf("점수\t%.1f\n", subject.getScore());
				System.out.printf("등급\t%c\n", subject.getGrade());
			} else {
				System.out.println("출력 할 과목 정보가 없습니다.");
			}
			
			System.out.println();
		}
	}
	
	private void add() {
		while(true) {
			System.out.print("추가 할 과목 입력 : ");
			String name = sc.nextLine();
			System.out.println();
			
			if(name.equals("exit")) {
				break;
			}
			
			double score = -1;
			while(!(score >=0 && score <= 100)) {
				System.out.print("성적 입력(0 ~ 100) : ");
				if(sc.hasNextDouble()) {
					score = sc.nextDouble();
				}
				sc.nextLine();
				System.out.println();
			}
			
			boolean result = this.student.addSubject(name, score);
			if(result) {
				System.out.println("과목 추가 완료되었습니다.");
			} else {
				System.out.println("이미 존재하는 과목 정보 입니다.");
			}
			System.out.println();
		}
	}
	
	private void update() {
		while(true) {
			System.out.print("수정 할 과목 입력 : ");
			String name = sc.nextLine();
			System.out.println();
			
			if(name.equals("exit")) {
				break;
			}
			
			double score = -1;
			while(!(score >=0 && score <= 100)) {
				System.out.print("성적 입력(0 ~ 100) : ");
				if(sc.hasNextDouble()) {
					score = sc.nextDouble();
				}
				sc.nextLine();
				System.out.println();
			}
			
			boolean result = this.student.updateSubject(name, score);
			if(result) {
				System.out.println("과목 수정 완료되었습니다.");
			} else {
				System.out.println("수정 할 과목이 존재하지 않습니다.");
			}
			System.out.println();
		}
	}
	
	private void remove() {
		while(true) {
			System.out.print("삭제 할 과목 입력 : ");
			String name = sc.nextLine();
			System.out.println();
			
			if(name.equals("exit")) {
				break;
			}
			
			boolean result = this.student.removeSubject(name);
			if(result) {
				System.out.println("과목 삭제 완료되었습니다.");
			} else {
				System.out.println("삭제 할 과목이 존재하지 않습니다.");
			}
			System.out.println();
		}
	}
	
	private void clear() {
		String cls = "";
		for(int i = 0; i < 25; i++) {
			cls += "\n";
		}
		System.out.println(cls);
	}

	public void start() {
		int number = 0;
		while(true) {
			System.out.println(this.initMenu());
			System.out.print("메뉴 번호 입력 : ");
			
			if(sc.hasNextInt()) {
				number = sc.nextInt();
				sc.nextLine();
			} else {
				sc.nextLine();
				continue;
			}
			this.select(number);
			
			System.out.print("초기 메뉴로 돌아가려면 Enter 입력!");
			sc.nextLine();
			this.clear();
		}
	}

}
