package com.demo.bo;

import com.demo.dao.StudentExamDAO;

import com.demo.exception.StudentExamManagementException;
import com.demo.exception.StudentExamNotFoundException;

import com.demo.vo.StudentExamVO;

public class StudentExamBO {
	StudentExamDAO dao = new StudentExamDAO();

	public boolean addStudentExam(StudentExamVO vo) throws StudentExamManagementException {
		try {
			boolean flag;
			flag = dao.addStudentExamDetails(vo);
			return flag;
		} catch (StudentExamManagementException e) {
			throw new StudentExamManagementException("Error When Adding The Student Exam Details" + e.getMessage());

		}

	}

	
	public StudentExamVO fetchStudentExamByid(int Student_exam_id) throws StudentExamNotFoundException{
		try {
			StudentExamVO vo = new StudentExamVO();
			vo = dao.fetchStudentExamByid(Student_exam_id);
			return vo;
		} catch (StudentExamNotFoundException e) {
			throw new StudentExamNotFoundException("Error while fetching " + e.getMessage());
		}

	}
}
