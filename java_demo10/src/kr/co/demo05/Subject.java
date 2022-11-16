package kr.co.demo05;

public class Subject implements Comparable<Subject> {

	private String name;
	private double score;
	private char grade;
	
	public Subject(String name, double score) {
		this.name = name;
		this.score = score;
		this.setGrade();
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getScore() {
		return score;
	}
	
	public void setScore(double score) {
		this.score = score;
	}
	
	public char getGrade() {
		return grade;
	}
	
	public void setGrade() {
		switch((int)this.score / 10) {
			case 10:
			case 9:
				this.grade = 'A'; break;
			case 8:
				this.grade = 'B'; break;
			case 7:
				this.grade = 'C'; break;
			case 6:
				this.grade = 'D'; break;
			case 5:
				this.grade = 'E'; break;
			default:
				this.grade = 'F';
		}
	}
	
	public void setGrade(char grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "Subject [name=" + name + ", score=" + score + ", grade=" + grade + "]";
	}

	@Override
	public int compareTo(Subject o) {
		if(this.score > o.score) {
			return 1;
		} else if(this.score < o.score) {
			return -1;
		}
		return 0;
	}
	
}
