package kr.co.demo06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Demo {

	public static void main(String[] args) {
		/*
		 * 
		 */
		Properties prop = new Properties();
		
		File f = new File("C:\\Users\\user1\\eclipse\\jee-2022-09\\eclipse\\configuration\\config.ini");
		
		try {
			prop.load(new BufferedReader(new FileReader(f)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String value = prop.get("osgi.bundles").toString();
		System.out.println(value);
		
		f = new File("C:\\Users\\user1\\eclipse\\jee-2022-09\\eclipse\\configuration\\config.ini.bak");
		
		try {
			prop.store(new BufferedWriter(new FileWriter(f)), "Comment");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
