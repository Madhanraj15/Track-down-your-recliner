package com.demo.bo;

import java.util.ArrayList;
import java.util.List;

import com.demo.dao.ExamDAO;
import com.demo.exception.ExamManagementException;
import com.demo.exception.ExamNotFoundException;
import com.demo.exception.InvigilatorNotFoundException;
import com.demo.vo.ExamVO;
;

public class ExamBO {
	ExamDAO dao = new ExamDAO();

	public boolean addExam(ExamVO vo) throws ExamManagementException {
		try {
			boolean flag;
			flag = dao.addExamDetails(vo);
			return flag;
		} catch (ExamManagementException e) {
			throw new ExamManagementException("Error When Adding The Exam Details" + e.getMessage());

		}

	}

	public boolean updateExam(ExamVO vo) throws ExamManagementException {
		try {
			boolean flag;
			flag = dao.updateExamDetalis(vo);
			return flag;
		} catch (ExamManagementException e) {
			throw new ExamManagementException("Error When Updating The Exam Details" + e.getMessage());

		}

	}

	public ExamVO fetchExamByid(int exam_id) throws ExamNotFoundException{
		try {
			ExamVO vo = new ExamVO();
			vo = dao.fetchExamByid(exam_id);
			return vo;
		} catch (ExamNotFoundException e) {
			throw new ExamNotFoundException("Error while fetching " + e.getMessage());
		}
	}

	public List< ExamVO> fetchExamByName(String exam_name) throws ExamNotFoundException  {
		try
		{List<ExamVO> list = new ArrayList< ExamVO>();
		list = dao.fetchExamByName(exam_name);
		return list;
		}
		catch(ExamNotFoundException e)
		{
			throw new ExamNotFoundException("Error while fetching " + e.getMessage());
		}
	
	}
}
