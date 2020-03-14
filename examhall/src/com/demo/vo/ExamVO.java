package com.demo.vo;

public class ExamVO {
private int exam_id;
 public int getExam_id() {
	return exam_id;
}
public void setExam_id(int exam_id) {
	this.exam_id = exam_id;
}
public String getExam_name() {
	return exam_name;
}
@Override
public String toString() {
	return "ExamVO [exam_id=" + exam_id + ", exam_name=" + exam_name + ", hall_id=" + hall_id + ", getExam_id()="
			+ getExam_id() + ", getExam_name()=" + getExam_name() + ", getHall_id()=" + getHall_id() + "]";
}
public void setExam_name(String exam_name) {
	this.exam_name = exam_name;
}
public int getHall_id() {
	return hall_id;
}
public void setHall_id(int hall_id) {
	this.hall_id = hall_id;
}
private String exam_name ; 
 private int hall_id;
}
