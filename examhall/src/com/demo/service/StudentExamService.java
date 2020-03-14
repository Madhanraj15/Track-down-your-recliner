package com.demo.service;

import com.demo.bo.StudentExamBO;
import com.demo.exception.ExamManagementException;
import com.demo.exception.StudentExamManagementException;
import com.demo.exception.StudentExamNotFoundException;
import com.demo.response.ExamResponeObject;
import com.demo.response.StudentExamResponeObject;

import com.demo.vo.StudentExamVO;

public class StudentExamService {
	StudentExamBO bo = new StudentExamBO();
	StudentExamResponeObject obj = new  StudentExamResponeObject();

	public  StudentExamResponeObject addStudentExam(StudentExamVO vo) throws StudentExamManagementException {
		boolean flag;
		try {
			flag = bo.addStudentExam(vo);
			if (flag)
				obj.setSuccessMessage("StudentExamAdded Successfully");
			else
				obj.setFailureMessage("Error When Adding Student Exam Details, Reach out Administrator");

		} catch (StudentExamManagementException e) {
			obj.setFailureMessage("Error When Adding The Student Exam  Details" + e.getMessage());
		}

		return obj;

	}



	public  StudentExamResponeObject fetchStudentExamById(int student_exam_id) throws StudentExamNotFoundException {

		

			try {
				StudentExamVO vo;
				vo = bo.fetchStudentExamByid(student_exam_id);
				obj.setStudentexamVO(vo);
			} catch (StudentExamNotFoundException e) {
				obj.setFailureMessage("Fetch StudentExam is not in the List" + e.getMessage());
			}

			return obj;

		}
}