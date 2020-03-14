package com.demo.bo;


	

	import java.util.List;

import com.demo.dao.StudentDAO;
import com.demo.exception.StudentManagementException;
import com.demo.exception.StudentNotFoundException;
import com.demo.vo.StudentVO;

	public class StudentBO {

	StudentDAO dao = new StudentDAO();


	public boolean addStudentDetails(StudentVO vo) throws StudentManagementException {
	boolean flag;
	try {
	flag = dao.addStudentDetails(vo);

	} catch (StudentManagementException e) {
	throw new StudentManagementException("Error when adding student details" + e.getMessage());
	}
	return flag;
	}

	public StudentVO fetchStudentById(int student_id) throws StudentNotFoundException {
	StudentVO vo = new StudentVO();
	vo = dao.fetchStudentById(student_id);
	return vo;
	}

	public List<StudentVO> fetchStudentByStudent_name(String Student_name) throws StudentNotFoundException {
	List<StudentVO> list;
	list = dao.fetchStudentByName(Student_name);

	return list;
	}

	public boolean updatestudentDetalis(StudentVO vo) throws StudentManagementException {
	boolean flag;
	flag = dao.updatestudentDetalis(vo);
	return flag;

	}
	}



