package kr.co.demo06;

import java.io.Serializable;

public class Subject implements Serializable {
	
	private String name;
	private int age;
	private char gender;
	
	public Subject(String name) {
		this.name = name;
	}

	public Subject(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public char getGender() {
		return gender;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Subject [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
}
