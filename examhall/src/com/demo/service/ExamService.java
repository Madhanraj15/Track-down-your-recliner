package com.demo.service;

import java.util.List;

import com.demo.bo.ExamBO;
import com.demo.exception.ExamManagementException;
import com.demo.exception.ExamNotFoundException;
import com.demo.response.ExamResponeObject;
import com.demo.vo.ExamVO;

public class ExamService {
	ExamBO bo = new ExamBO();
	 ExamResponeObject obj = new  ExamResponeObject();

	public  ExamResponeObject addExam(ExamVO vo) throws ExamManagementException {
		boolean flag;
		try {
			flag = bo.addExam(vo);
			if (flag)
				obj.setSuccessMessage("ExamAdded Successfully");
			else
				obj.setFailureMessage("Error When Adding Exam Details, Reach out Administrator");

		} catch (ExamManagementException e) {
			obj.setFailureMessage("Error When Adding The Exam  Details" + e.getMessage());
		}

		return obj;

	}

	public ExamResponeObject updateExam(ExamVO vo) throws ExamManagementException {
		boolean flag;
		try {
			flag = bo.updateExam(vo);
			if (flag)
				obj.setSuccessMessage("Exam Updated Successfully");
			else
				obj.setFailureMessage("Error When Updating ExamDetails, Reach out Administrator");

		} catch (ExamManagementException e) {
			obj.setFailureMessage("Error When Updating TheExam Details" + e.getMessage());
		}

		return obj;

	}

	public  ExamResponeObject fetchExamById(int exam_id) throws ExamNotFoundException {

		

			try {
				ExamVO vo;
				vo = bo.fetchExamByid(exam_id);
				obj.setExamVO(vo);
			} catch (ExamNotFoundException e) {
				obj.setFailureMessage("Fetch Exam is not in the List" + e.getMessage());
			}

			return obj;

		}
	public  ExamResponeObject fetchExamByName(String exam_name) throws ExamNotFoundException {

		try {
			List<ExamVO> list;
			list = bo.fetchExamByName(exam_name);
			obj.setExamVOList(list);

		} catch (ExamNotFoundException e) {
			obj.setFailureMessage("Error When Fetching The Exam Details" + e.getMessage());
		}

		return obj;}}



