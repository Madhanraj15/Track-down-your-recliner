package com.demo.response;

import java.util.List;

import com.demo.vo.StudentVO;

public class StudentResponseObject {

	
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
		
		public StudentVO getStudentVO() {
			return studentVo;
		}
		public void setStudentVO(StudentVO studentVO) {
			this.studentVo = studentVO;
		}
		String failureMessage;
		List <StudentVO> studentList;
		public List<StudentVO> getStudentList() {
			return studentList;
		}
		public void setStudentList(List<StudentVO> studentList) {
			this.studentList = studentList;
		}
		public StudentVO getStudentVo() {
			return studentVo;
		}
		public void setStudentVo(StudentVO studentVo) {
			this.studentVo = studentVo;
		}
		StudentVO studentVo;

	
}

