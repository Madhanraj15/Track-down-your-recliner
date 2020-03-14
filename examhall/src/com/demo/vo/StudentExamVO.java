package com.demo.vo;

public class StudentExamVO {
	private int student_exam_id;

	public int getStudent_exam_id() {
		return student_exam_id;
	}
	public void setStudent_exam_id(int student_exam_id) {
		this.student_exam_id = student_exam_id;
	}
	@Override
	public String toString() {
		return "StudentExamVO [student_exam_id=" + student_exam_id + ", student_id=" + student_id + ", exam_id="
				+ exam_id + ", getStudent_exam_id()=" + getStudent_exam_id() + ", getStudent_id()=" + getStudent_id()
				+ ", getExam_id()=" + getExam_id() + "]";
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public int getExam_id() {
		return exam_id;
	}
	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
	}
	private int student_id;
	private int exam_id;


}
