package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.exception.HallManagementException;
import com.demo.exception.HallNotFoundException;
import com.demo.exception.InvigilatorNotFoundException;
import com.demo.vo.HallVO;

public class HallDAO {
	public boolean addHallDetails(HallVO vo) throws HallManagementException {
		boolean flag = false;
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/projectfinals";
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "INSERT INTO hall(hall_id,hall_invigilater_name,invigilater_gender,invigilater_college)VALUES (?,?,?,?)";
			ps = connection.prepareStatement(query);
			ps.setInt(1, vo.getHall_id());
			ps.setString(2, vo.getHall_invigilater_name());
			ps.setString(3, vo.getInvigilater_college());
			ps.setString(4, vo.getInvigilater_gender());

			int i = ps.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			throw new HallManagementException("error when adding Hall details" + e.getMessage());
		} finally {
			try {
				ps.close();
				connection.close();
			} catch (SQLException e) {
				throw new HallManagementException("error when adding Hall details" + e.getMessage());
			}
		}
		return flag;
	}

	public HallVO fetchHallByid(int hall_id) throws HallNotFoundException {
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/projectfinals";
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		HallVO vo = new HallVO();

		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select * from hall where hall_id=?";
			ps = connection.prepareStatement(query);
			ps.setInt(1, hall_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				vo.setHall_id(rs.getInt("hall_id"));
				vo.setHall_invigilater_name(rs.getString("hall_invigilater_name"));
				vo.setInvigilater_gender(rs.getString("invigilater_gender"));
				vo.setInvigilater_college(rs.getString("invigilater_college"));

			}
		} catch (SQLException e) {
			throw new HallNotFoundException("Error when add the Hall Details" + e.getMessage());
		} finally {
			try {
				ps.close();
				connection.close();
			} catch (SQLException e) {
				throw new HallNotFoundException("Error when add the Hall Details" + e.getMessage());
			}
		}
		return vo;
	}

	public List<HallVO> fetchInvigilaterByName(String invigilater_Name) throws InvigilatorNotFoundException {
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/projectfinals";
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		HallVO vo = new HallVO();
		List<HallVO> list = new ArrayList<HallVO>();

		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select*from hall where hall_invigilater_name=?";
			ps=connection.prepareStatement(query);
			ps.setString(1, invigilater_Name);
			rs = ps.executeQuery();
			while (rs.next()) {
				vo.setHall_id(rs.getInt("hall_id"));
				vo.setHall_invigilater_name(rs.getString("hall_invigilater_name"));
				vo.setInvigilater_gender(rs.getString("invigilater_gender"));
				vo.setInvigilater_college(rs.getString("invigilater_college"));
				list.add(vo);

			}
		} catch (SQLException e) {
			throw new InvigilatorNotFoundException("Error when add the Hall Details" + e.getMessage());
		} finally {
			try {
				ps.close();
				connection.close();
			} catch (SQLException e) {
				throw new InvigilatorNotFoundException("Error when add the Hall Details" + e.getMessage());
			}
		}
		return list;
	}

	public boolean updateHallDetalis(HallVO vo) throws HallManagementException {
		boolean flag = false;
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/projectfinals";
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "UPDATE Hall set hall_invigilater_name=?,invigilater_gender=?,invigilater_college=? where hall_id=?";
			stmt = connection.prepareStatement(query);

			stmt.setString(1, vo.getHall_invigilater_name());
			stmt.setString(2, vo.getInvigilater_college());
			stmt.setString(3, vo.getInvigilater_gender());
			stmt.setInt(4, vo.getHall_id());
			int i = stmt.executeUpdate();

		} catch (SQLException e) {
			throw new HallManagementException("error when updating Hall details" + e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new HallManagementException("error when updating Hall details" + e.getMessage());
			}
		}
		return flag;
	}

}
