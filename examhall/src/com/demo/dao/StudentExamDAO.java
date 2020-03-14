package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.exception.StudentExamManagementException;
import com.demo.exception.StudentExamNotFoundException;
import com.demo.vo.StudentExamVO;

public class StudentExamDAO {
	public boolean addStudentExamDetails(StudentExamVO vo) throws StudentExamManagementException
	{
		boolean flag = false;
		String userName="root";
		String password="root123";
		String url="jdbc:mysql://localhost:3306/projectfinals";
		Connection connection=null;
		PreparedStatement ps=null;
		try 
		{
			connection = DriverManager.getConnection(url, userName, password);
			String query="INSERT INTO student_exams(Student_exam_id,Student_id,exam_id)VALUES (?,?,?)";
			ps=connection.prepareStatement(query);
			ps.setInt(1, vo.getStudent_exam_id());
			ps.setInt(2, vo.getStudent_id());
			ps.setInt(3, vo.getExam_id());
			
			
			int i=ps.executeUpdate();
			flag=true;
		}
		catch(SQLException e)
		{
			throw new StudentExamManagementException("error when adding StudentExam details"+e.getMessage());
		}
		finally{
			try{
				ps.close();
				connection.close();
			}
			catch(SQLException e)
			{
				throw new StudentExamManagementException("error when adding StudentExam details"+e.getMessage());
			}
			}
		return flag;
		}

public StudentExamVO fetchStudentExamByid(int student_exam_id) throws StudentExamNotFoundException
{
	String userName="root";
	String password="root123";
	String url="jdbc:mysql://localhost:3306/projectfinals";
	Connection connection=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	StudentExamVO vo=new StudentExamVO();
	
	try 
	{
		connection = DriverManager.getConnection(url, userName, password);
		String query="select * from Student_exam where student_exam_id=?";
		ps = connection.prepareStatement(query);
		rs = ps.executeQuery();
		while(rs.next()){
			int student_exam_id1 = rs.getInt("student_exam_id");
			int student_id= rs.getInt("student_name");
			int exam_id = rs.getInt("exam_id");
			
			
			Integer studentExamid1=vo.getStudent_exam_id();
           
			System.out.println(student_exam_id1 + "  "+ student_id +" "+ exam_id +" ");
		
		}
	}
	catch(SQLException e)
	{
		throw new StudentExamNotFoundException("Error when add the Student Exam Details" + e.getMessage());
	}
	finally{
		try{
			ps.close();
			connection.close();
		}
		catch(SQLException e)
		{
			throw new StudentExamNotFoundException("Error when add the StudentExam Details" + e.getMessage());
		}
		}
	return vo;
	}

public boolean updateStudentExamDetalis(int student_exam_id)throws StudentExamManagementException
{
	boolean flag = false;
	String userName="root";
	String password="root123";
	String url="jdbc:mysql://localhost:3306/projectfinals";
	Connection connection=null;
	PreparedStatement stmt=null;
	try 
	{
		connection = DriverManager.getConnection(url, userName, password);
		String query="UPDATE Student Exam set student_exam_id=1, WHERE student_exam_id="+ student_exam_id;
		stmt= connection.prepareStatement(query);
		int i=stmt.executeUpdate();
		System.out.println("Updated the Student exam Details Successfully...");
	}
	catch(SQLException e)
	{
		throw new StudentExamManagementException("error when updating StudentExam details"+e.getMessage());
	}
	finally{
		try{
			stmt.close();
			connection.close();
		}
		catch(SQLException e)
		{
			throw new StudentExamManagementException("error when updating Student Exam details"+e.getMessage());
}
}
	return flag;
}
}
