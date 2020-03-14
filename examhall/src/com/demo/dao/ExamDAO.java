package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.exception.ExamManagementException;
import com.demo.exception.ExamNotFoundException;
import com.demo.exception.InvigilatorNotFoundException;
import com.demo.vo.ExamVO;



public class ExamDAO {
	public boolean addExamDetails(ExamVO vo) throws ExamManagementException{
	boolean flag = false;
	String userName = "root";
	String password = "root123";
	String url = "jdbc:mysql://localhost:3306/projectfinals";
	Connection connection = null;
	PreparedStatement ps = null;
	try {
		connection = DriverManager.getConnection(url, userName, password);
			String query="INSERT INTO exam(exam_id,exam_name,hall_id)VALUES (?,?,?)";
			ps=connection.prepareStatement(query);
			ps.setInt(1, vo.getExam_id());
			ps.setString(2, vo.getExam_name());
			ps.setInt(3, vo.getHall_id());
			
			
			int i=ps.executeUpdate();
			flag=true;
		}
		catch(SQLException e)
		{
			throw new ExamManagementException("error when adding Exam details"+e.getMessage());
		}
		finally{
			try{
				ps.close();
				connection.close();
			}
			catch(SQLException e)
			{
				throw new ExamManagementException("error when adding Exam details"+e.getMessage());
			}
			}
		return flag;
		}

public ExamVO fetchExamByid(int exam_id) throws ExamNotFoundException
{
	String userName="root";
	String password="root123";
	String url="jdbc:mysql://localhost:3306/projectfinals";
	Connection connection=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	ExamVO vo=new ExamVO();
	
	try 
	{
		connection = DriverManager.getConnection(url, userName, password);
		String query="select * from exam where exam_id=?";
		ps = connection.prepareStatement(query);
		ps.setInt(1, exam_id);
		rs = ps.executeQuery();
		while(rs.next()){
			vo.setExam_id(rs.getInt("exam_id"));
			vo.setExam_name(rs.getString("exam_name"));
			vo.setHall_id(rs.getInt("hall_id"));
			
			
			
         
	}
	} catch(SQLException e)
	{
		throw new ExamNotFoundException("Error when add the Exam Details" + e.getMessage());
	}
	finally{
		try{
			ps.close();
			connection.close();
		}
		catch(SQLException e)
		{
			throw new ExamNotFoundException("Error when add the Exam Details" + e.getMessage());
		}
		}
	return vo;
	}
public List<ExamVO> fetchExamByName(String Exam_Name) throws ExamNotFoundException
{
	String userName="root";
	String password="root123";
	String url="jdbc:mysql://localhost:3306/projectfinals";
	Connection connection=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	ExamVO vo=new ExamVO();
	List<ExamVO> list = new ArrayList<ExamVO>();
	
	try 
	{
		connection = DriverManager.getConnection(url, userName, password);
		String query="select * from exam where exam_name=?" ;
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, Exam_Name);
		rs=ps.executeQuery();
		while(rs.next()){
			vo.setExam_id(rs.getInt("exam_id"));
			vo.setExam_name(rs.getString("exam_name"));
			vo.setHall_id(rs.getInt("hall_id"));
			
			
			list.add(vo);
           
		
		
		}
	}
	catch(SQLException e)
	{
		throw new ExamNotFoundException("Error when add the Exam Details" + e.getMessage());
	}
	finally{
		try{
			
			rs.close();
			connection.close();
		}
		catch(SQLException e)
		{
			throw new ExamNotFoundException("Error when add the Exam Details" + e.getMessage());
		}
		}
	return list ;
	}

public boolean updateExamDetalis(ExamVO vo)throws ExamManagementException
{
	boolean flag = false;
	String userName = "root";
	String password = "root123";
	String url = "jdbc:mysql://localhost:3306/projectfinals";
	Connection connection = null;
	PreparedStatement stmt = null;
	try {
		connection = DriverManager.getConnection(url, userName, password);
		String query = "UPDATE Exam set Exam_name=?,Hall_id=? where exam_id=?";
		stmt = connection.prepareStatement(query);
stmt.setInt(1, vo.getExam_id());
		stmt.setString(2, vo.getExam_name());
		stmt.setInt(3, vo.getHall_id());
		
		int i = stmt.executeUpdate();
	}
	catch(SQLException e)
	{
		throw new ExamManagementException("error when updating Exam details"+e.getMessage());
	}
	finally{
		try{
			stmt.close();
			connection.close();
		}
		catch(SQLException e)
		{
			throw new ExamManagementException("error when updating Exam details"+e.getMessage());
}
}
	return flag;
}
}
