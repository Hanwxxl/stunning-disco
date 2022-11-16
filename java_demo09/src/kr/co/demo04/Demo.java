package kr.co.demo04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo {

	public static void main(String[] args) {
		/*
		 * FileOutputStream 클래스
		 */
		File f = new File("D:\\입출력테스트.txt");
		try(FileOutputStream fos = new FileOutputStream(f, true)) {
			
			fos.write(65);
			fos.write(66);
			fos.write(67);
			fos.write(68);
			
			fos.write("\r\n한글문자열".getBytes());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
