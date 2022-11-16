package kr.co.exam04;

public class Subject {

	private double score;
	private char grade;
	
	public Subject(double score, char grade) {
		this.score = score;
		this.grade = grade;
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
	
	public void setGrade(char grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "Subject [score=" + score + ", grade=" + grade + "]";
	}
	
}
