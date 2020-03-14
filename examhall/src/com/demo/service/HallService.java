package com.demo.service;

import java.util.List;

import com.demo.bo.HallBO;
import com.demo.exception.HallManagementException;
import com.demo.exception.HallNotFoundException;
import com.demo.exception.InvigilatorNotFoundException;
import com.demo.response.HallResponseObject;
import com.demo.vo.HallVO;

public class HallService {
	HallBO bo = new HallBO();
	HallResponseObject obj = new HallResponseObject();

	public HallResponseObject addHall(HallVO vo) throws HallManagementException {
		boolean flag;
		try {
			flag = bo.addHall(vo);
			if (flag)
				obj.setSuccessMessage("Hall Added Successfully");
			else
				obj.setFailureMessage("Error When Adding hall Details, Reach out Administrator");

		} catch (HallManagementException e) {
			obj.setFailureMessage("Error When Adding The Hall  Details" + e.getMessage());
		}

		return obj;

	}

	public HallResponseObject updateHall(HallVO vo) throws HallManagementException {
		boolean flag;
		try {
			flag = bo.updateHall(vo);
			if (flag)
				obj.setSuccessMessage("Hall Updated Successfully");
			else
				obj.setFailureMessage("Error When Updating Hall Details, Reach out Administrator");

		} catch (HallManagementException e) {
			obj.setFailureMessage("Error When Updating The Hall Details" + e.getMessage());
		}

		return obj;

	}

	public HallResponseObject fetchHallById(int hall_id) throws HallNotFoundException {

		

			try {
				HallVO vo;
				vo = bo.fetchHallByid(hall_id);
				obj.setHallVO(vo);
			} catch (HallNotFoundException e) {
				obj.setFailureMessage("Fetch Doctor is not in the List" + e.getMessage());
			}

			return obj;

		}
	public HallResponseObject fetcInvigilaterByName(String hall_invigilater_name) throws InvigilatorNotFoundException {

		try {
			List< HallVO> list;
			list = bo.fetchInvigilaterByName(hall_invigilater_name);
			obj.setHallvoList(list);

		} catch (InvigilatorNotFoundException e) {
			obj.setFailureMessage("Error When Fetching The Hall Details" + e.getMessage());
		}

		return obj;}}

