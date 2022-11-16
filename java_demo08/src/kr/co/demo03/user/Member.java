package kr.co.demo03.user;

import kr.co.demo03.user.exception.UserException;

public class Member {

	private String name;
	
	public Member() {}
	
	public Member(String name) {
		try {
			this.setName(name);
		} catch (UserException e) {
			this.name = "";
		}
	}
	
	public void setName(String name) throws UserException {
		if(name != null) {
			this.name = name;
		} else {
			throw new UserException("잘못된 사용자 이름");
		}
	}
	
	public String getName() {
		return this.name;
	}
}
