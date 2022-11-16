package kr.co.demo05;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Demo {

	public static void main(String[] args) {
		/*
		 * FileWriter
		 */
		
		File f = new File("D:\\입출력테스트.txt");
		
		try(FileWriter fw = new FileWriter(f, true)) {
			
			fw.write(65);
			fw.write("문자열");
			fw.append("append 로 출력");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
