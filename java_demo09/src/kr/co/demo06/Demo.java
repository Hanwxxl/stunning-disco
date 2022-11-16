package kr.co.demo06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;

public class Demo {
	
	// 바이트 기반 스트림 + 문자 보조 스트림
	public static void charSubStream() {
		File f = new File("D:\\입출력테스트.txt");
		
		StringBuilder sb = new StringBuilder(1024);
		try(InputStreamReader isr = new InputStreamReader(new FileInputStream(f))) {
			char buf[] = new char[16];
			while(true) {
				int readCount = isr.read(buf);
				if(readCount == -1) {
					break;
				}
				sb.append(buf, 0, readCount);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(sb.toString());
		
		try(OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(f, true))) {
			osw.write("\r\n문자열을 작성하여 파일로 저장.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 문자 기반 스트림 + 버퍼 보조 스트림
	public static void bufferSubStream() {
		File f = new File("D:\\입출력테스트.txt");
		
		StringBuilder sb = new StringBuilder(1024);
		try(BufferedReader br = new BufferedReader(new FileReader(f), 4096)) {
			while(br.ready()) {
				sb.append(br.readLine() + "\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(sb.toString());
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(f, true), 4096)) {
			bw.write("보조 스트림으로 데이터 쓰기.");
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 바이트 기반 스트림 + 데이터 보조 스트림
	public static void dataSubStream() {
		File f = new File("D:\\입출력테스트.txt");
		
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(f))) {
			dos.writeInt(150);
			dos.writeDouble(12.5);
			dos.writeBoolean(false);
			dos.writeChars("Hello");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try(DataInputStream dis = new DataInputStream(new FileInputStream(f))) {
			int i = dis.readInt();
			double d = dis.readDouble();
			boolean b = dis.readBoolean();
			
			String s = "" + dis.readChar();
			s += "" + dis.readChar();
			s += "" + dis.readChar();
			s += "" + dis.readChar();
			s += "" + dis.readChar();
			
			System.out.println(i + "/" + d + "/" + b + "/" + s);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 바이트 기반 스트림 + 객체 보조 스트림
	public static void objectSubStream() {
		File f = new File("D:\\입출력테스트.txt");
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
			Subject s1 = new Subject("홍길동", 23);
			Subject s2 = new Subject("김철수");
			oos.writeObject(s1);
			oos.writeObject(s2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
			Subject s1 = (Subject)ois.readObject();
			Subject s2 = (Subject)ois.readObject();
			System.out.println(s1);
			System.out.println(s2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		/*
		 * 보조스트림
		 *     - 입/출력에 사용하는 기반 스트림을 보조하는 역할을 수행
		 *     - 기반 스트림과 같이 사용해야 하며, 보조 스트림 단독으로 사용할 수 없다.
		 *     - 기반 스트림의 성능을 향상하기 위한 기능 또는 객체나 데이터를 다룰 때
		 *       필요한 추가 기능을 제공
		 *       
		 * 문자 보조 스트림
		 *     - InputStreamReader / OutputStreamWriter
		 *     - 바이트 기반 스트림에 사용하는 보조 스트림으로 바이트 데이터를 문자 데이터로 변환하는
		 *       기능을 가진다.
		 * 
		 * 입출력 버퍼 보조 스트림
		 *     - BufferedInputStream / BufferedOutputStream 은 바이트 기반 스트림에 적용하여 사용
		 *     - BufferedReader / BufferedWriter 은 문자 기반 스트림에 적용하여 사용
		 *     - 입출력에 중간 버퍼를 생성하여 하드디스크와 프로그램 사이의 데이터 스트림의 병목현상을 완화
		 *       하기 위해 사용된다.
		 * 
		 * 기본 데이터 타입 보조 스트림
		 *     - DataInputStream / DataOutputStream 은 바이트 기반 스트림에 적용하여 사용
		 *     - 프로그램에서 사용하는 기본 데이터 타입을 읽고 쓸 수 있도록 기능 제공
		 * 
		 * 객체 타입 보조 스트림
		 *     - ObjectInputStream / ObjectOutputStream 은 바이트 기반 스트림에 적용하여 사용
		 *     - 프로그램에서 사용하는 객체 타입을 읽고 쓸 수 있도록 기능 제공
		 */
		
	}

}
