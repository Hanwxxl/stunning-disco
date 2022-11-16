package kr.co.exam02;

public class Teacher extends Person {
	
	public String getSubject() {
		if(this.subject.length == 1) {
			return this.subject[0];
		}
		return null;
	}

	@Override
	public void setSubject(String subject) {
		if(this.subject.length == 0) {
			this.subject = new String[1];
			this.subject[0] = subject;
		}
	}
	
}
