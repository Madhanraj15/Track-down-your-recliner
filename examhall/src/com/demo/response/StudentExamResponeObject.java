package com.demo.response;

import java.util.List;

import com.demo.vo.StudentExamVO;

public class StudentExamResponeObject {
String successMessage;
public String getSuccessMessage() {
	return successMessage;
}
public void setSuccessMessage(String successMessage) {
	this.successMessage = successMessage;
}
public String getFailureMessage() {
	return failureMessage;
}
public void setFailureMessage(String failureMessage) {
	this.failureMessage = failureMessage;
}
public List<StudentExamVO> getStudentexamVOList() {
	return studentexamVOList;
}
public void setStudentexamVOList(List<StudentExamVO> studentexamVOList) {
	this.studentexamVOList = studentexamVOList;
}
public StudentExamVO getStudentexamVO() {
	return studentexamVO;
}
public void setStudentexamVO(StudentExamVO studentexamVO) {
	this.studentexamVO = studentexamVO;
}
String failureMessage;
List<StudentExamVO> studentexamVOList;
StudentExamVO studentexamVO;
}
