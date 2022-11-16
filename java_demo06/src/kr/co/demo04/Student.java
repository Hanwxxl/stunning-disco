package kr.co.demo04;

public class Student extends Person {

	@Override
	public String getFirstName() {
		return getName().substring(0, 1);
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return getName().substring(1);
	}

}
