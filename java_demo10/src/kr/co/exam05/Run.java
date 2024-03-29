package kr.co.exam05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Run {
	
	private Scanner sc = new Scanner(System.in);
	private HashMap<Student, ArrayList<Subject>> datas = new HashMap<Student, ArrayList<Subject>>();

	public void printMenu() {
		String menu = "<< 학생 성적 관리 프로그램 >>\n"
				+ "[1] 전체 학생 목록 \n"
				+ "[2] 성적 검색\n"
				+ "[3] 성적 수정\n"
				+ "[4] 프로그램 종료\n";
		
		System.out.print(menu);
	}
	
	public void load() {
		File f = new File("D:\\학생성적관리정보.info");
		
		try(BufferedReader br = new BufferedReader(new FileReader(f))) {
			while(br.ready()) {
				this.parse(br.readLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void parse(String rowData) {
		// HashMap<Student, ArrayList<Subject>> datas = new HashMap<Student, ArrayList<Subject>>();
		// rowData = "홍길동,1,2,25:영어=78.5,수학=84.7,국어=96.5"
		
		String sArr[] = rowData.split(":");
		String studentData[] = sArr[0].split(",");
		String subjectData[] = sArr[1].split(",");
		
		Student student = new Student(studentData[0],
				Integer.parseInt(studentData[1]),
				Integer.parseInt(studentData[2]),
				Integer.parseInt(studentData[3]));
		
		ArrayList<Subject> subjectList = new ArrayList<Subject>();
		
		for(int i = 0; i < subjectData.length; i++) {
			String tmp[] = subjectData[i].split("=");
			Subject subject = new Subject(tmp[0], Double.parseDouble(tmp[1]));
			subjectList.add(subject);
		}
		
		this.datas.put(student, subjectList);
	}
	
	public void save() {
		// HashMap<Student, ArrayList<Subject>> datas = new HashMap<Student, ArrayList<Subject>>();
		// "홍길동,1,2,25:영어=78.5,수학=84.7,국어=96.5"
		StringBuilder sb = new StringBuilder();
		
		for(Entry<Student, ArrayList<Subject>> e: datas.entrySet()) {
			Student student = e.getKey();
			sb.append(student.getName() + ",");
			sb.append(student.getClassYear() + ",");
			sb.append(student.getClassRoom() + ",");
			sb.append(student.getClassNumber() + ":");
			
			for(Subject s: e.getValue()) {
				sb.append(s.getName() + "=");
				sb.append(s.getScore() + ",");
			}
			
			sb.replace(sb.length() - 1, sb.length(), "\r\n");
		}
		
		File f = new File("D:\\학생성적관리정보.info");
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
			bw.write(sb.toString());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void start() {
		load();
		while(true) {
			this.printMenu();
			
			System.out.print("선택 : ");
			int menuNumber = sc.nextInt();	sc.nextLine();
			
			switch(menuNumber) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					save();
					System.exit(0);
			}
		}
	}
}
