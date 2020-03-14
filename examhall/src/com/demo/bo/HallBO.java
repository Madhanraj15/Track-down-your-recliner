package com.demo.bo;

import java.util.ArrayList;
import java.util.List;

import com.demo.dao.HallDAO;
import com.demo.exception.HallManagementException;
import com.demo.exception.HallNotFoundException;
import com.demo.exception.InvigilatorNotFoundException;
import com.demo.vo.HallVO;

public class HallBO {
	HallDAO dao = new HallDAO();

	public boolean addHall(HallVO vo) throws HallManagementException {
		try {
			boolean flag;
			flag = dao.addHallDetails(vo);
			return flag;
		} catch (HallManagementException e) {
			throw new HallManagementException("Error When Adding The Hall Details" + e.getMessage());

		}

	}

	public boolean updateHall(HallVO vo) throws HallManagementException {
		try {
			boolean flag;
			flag = dao.updateHallDetalis(vo);
			return flag;
		} catch (HallManagementException e) {
			throw new HallManagementException("Error When Updating The Hall Details" + e.getMessage());

		}

	}

	public HallVO fetchHallByid(int hall_id) throws HallNotFoundException {
		try {
			HallVO vo = new HallVO();
			vo = dao.fetchHallByid(hall_id);
			return vo;
		} catch (HallNotFoundException e) {
			throw new HallNotFoundException("Error while fetching " + e.getMessage());
		}
	}

	public List< HallVO> fetchInvigilaterByName(String hall_invigilater_name) throws InvigilatorNotFoundException  {
		try
		{List<HallVO> list = new ArrayList< HallVO>();
		list = dao.fetchInvigilaterByName(hall_invigilater_name);
		return list;
		}
		catch(InvigilatorNotFoundException e)
		{
			throw new InvigilatorNotFoundException("Error while fetching " + e.getMessage());
		}
	}


}



