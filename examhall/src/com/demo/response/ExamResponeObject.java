package com.demo.response;

import java.util.List;

import com.demo.vo.ExamVO;

public class ExamResponeObject {
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
public List<ExamVO> getExamVOList() {
	return examVOList;
}
public void setExamVOList(List<ExamVO> examVOList) {
	this.examVOList = examVOList;
}
public ExamVO getExamVO() {
	return examVO;
}
public void setExamVO(ExamVO examVO) {
	this.examVO = examVO;
}
String failureMessage;

List<ExamVO> examVOList;
ExamVO examVO;
}
