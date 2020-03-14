package com.demo.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.demo.exception.HallManagementException;
import com.demo.exception.HallNotFoundException;
import com.demo.exception.InvigilatorNotFoundException;
import com.demo.response.HallResponseObject;
import com.demo.service.HallService;
import com.demo.vo.HallVO;

public class HallMain {

	public static void main(String[] args)
			throws HallManagementException, HallNotFoundException, SQLException, InvigilatorNotFoundException {
		System.out.println("Please select one of the below options");
		System.out.println("1. Add Hall");
		System.out.println("2. Fetch Hall by hall_id");
		System.out.println("3. Fetch  Invigilater name by Hall_invigilater_name");
		System.out.println("4. Update Hall Details");
		System.out.println("5. Exit");
		Scanner s = new Scanner(System.in);
		int menuSelected = s.nextInt();

		switch (menuSelected) {
		case 1:
			addHall();
			break;
		case 2:
			fetchHallById();
			break;
		case 3:
			fetchInvigilaterByName();
			break;
		case 4:
			updateHall();
			break;
		default:
			System.exit(0);
		}
	}

	private static void fetchHallById() throws HallNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		HallService hallService = new HallService();
		System.out.println("Please Enter The student ID:");
		Integer hall_id = Integer.parseInt(s.nextLine());

		HallResponseObject obj = null;
		obj = hallService.fetchHallById(hall_id);
		HallVO vo;
		vo = obj.getHallVO();
		if (vo != null) {
			System.out.println(
					"================================================================================================");
			System.out.println("HallId" + '\t' + "Hall_invigilater_name" + '\t' + "invigilater_gender" + '\t'
					+ " invigilater_college");
			System.out.println(
					"================================================================================================");
			System.out.println(vo.getHall_id() + "\t\t" + vo.getHall_invigilater_name() + "\t\t"
					+ vo.getInvigilater_gender() + "\t\t" + vo.getInvigilater_college());
		} else {
			System.out.println(obj.getFailureMessage());
		}

	}

	private static void addHall() throws HallManagementException {
		HallService hallService = new HallService();
		Scanner s = new Scanner(System.in);

		System.out.println("Please Enter The Hall_ID:");
		Integer hall_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Hall_invigilater_name:");
		String hall_invigilater_name = s.nextLine();
		System.out.println("Please Enter The Invigilater_gender:");
		String invigilater_gender = s.nextLine();
		System.out.println("Please Enter The Invigilater_college:");
		String invigilater_college = s.nextLine();

		HallVO vo = new HallVO();
		vo.setHall_id(hall_id);
		vo.setHall_invigilater_name(hall_invigilater_name);
		vo.setInvigilater_college(invigilater_college);
		vo.setInvigilater_gender(invigilater_gender);

		HallResponseObject obj = hallService.addHall(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}

	}

	private static void updateHall() throws HallManagementException {
		// TODO Auto-generated method stub
		HallService hallservice = new HallService();
		Scanner s = new Scanner(System.in);

		System.out.println("Please Enter The Hall_ID:");
		Integer hall_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Hall_invigilater_name:");
		String Hall_invigilater_name = s.nextLine();
		System.out.println("Please Enter The Invigilater_gender:");
		String Invigilater_gender = s.nextLine();
		System.out.println("Please Enter The Invigilater_college:");
		String Invigilater_college = s.nextLine();

		HallVO vo = new HallVO();
		vo.setHall_id(hall_id);
		vo.setHall_invigilater_name(Hall_invigilater_name);
		vo.setInvigilater_gender(Invigilater_gender);
		vo.setInvigilater_college(Invigilater_college);
		HallResponseObject obj = hallservice.updateHall(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}

	}

	private static void fetchInvigilaterByName() throws HallNotFoundException, InvigilatorNotFoundException {
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The invigilater Name:");
		String invigilater_name = s.nextLine();

		HallService hallService = new HallService();

		HallResponseObject obj = null;
		obj = hallService.fetcInvigilaterByName(invigilater_name);

		List<HallVO> list = new ArrayList<HallVO>();

		list = obj.getHallvoList();
		if (list.isEmpty() && obj.getFailureMessage() == null) {
			System.out.println("No such list in the hall");
		} else if (!list.isEmpty()) {

			for (HallVO vo : list) {
				System.out.println(
						"======================================================================================================================================================");
				System.out.println("HallId" + '\t' + "Hall_invigilater_name" + '\t' + "invigilater_gender" + '\t'
						+ " invigilater_college");
				System.out.println(
						"======================================================================================================================================================");

				System.out.println(list);

			}
		} else if (list.isEmpty()) {
			System.out.println(obj.getFailureMessage());

		}

	}
}
