package kr.co.demo05;

public class MemberUser extends Person implements Member {

	public void write() {
		System.out.println("write 동작");
	}

	public void view() {
		System.out.println("view 동작");
	}

	public void update() {
		System.out.println("update 동작");
	}

	public void remove() {
		System.out.println("remove 동작");
	}

}
