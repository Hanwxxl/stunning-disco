package kr.co.demo01;

public class Student extends Person {
	private int year;
	private int classRoom;

	public Student(String name) {
		super(name);
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}
	
}
