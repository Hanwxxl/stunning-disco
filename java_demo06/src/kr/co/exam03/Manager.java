package kr.co.exam03;

public class Manager extends Senior {

	public Manager() {
		role = "과장";
	}
	
	public Manager(String name, int age) {
		this();
		setName(name);
		setAge(age);
	}
	
	public void meeting() {
		String message = String.format("%s %s이(가) 업체와 미팅을 합니다.", role, getName());
		System.out.println(message);
	}
	
	public void workOut() {
		String message = String.format("%s %s이(가) 외부 출장을 갑니다.", role, getName());
		System.out.println(message);
	}
	
	@Override
	public Employee degrement() {
		return new Senior(getName(), getAge());
	}
	
}
