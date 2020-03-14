package com.demo.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.demo.exception.ExamManagementException;
import com.demo.exception.ExamNotFoundException;
import com.demo.exception.HallNotFoundException;
import com.demo.response.ExamResponeObject;
import com.demo.service.ExamService;
import com.demo.vo.ExamVO;



public class ExamMain {

	public static void main(String[] args) 
		throws ExamManagementException, ExamNotFoundException, SQLException , HallNotFoundException {
			System.out.println("Please select one of the below options");
			System.out.println("1. Add Exam");
			System.out.println("2. Fetch Exam by exam_id");
			System.out.println("3. Fetch exam name by exam_name");
			System.out.println("4. Update exam Details");
			System.out.println("5. Exit");
			Scanner s = new Scanner(System.in);
			int menuSelected = s.nextInt();

			switch (menuSelected) {
			case 1:
				addExam();
				break;
			case 2:
				fetchExamById();
				break;
			case 3:
				fetchExamByName();
				break;
			case 4:
				updateExam();
				break;
			default:
				System.exit(0);}
			
		}

			private static void fetchExamById() throws ExamNotFoundException {
			// TODO Auto-generated method stub
			Scanner s = new Scanner(System.in);
			ExamService examService = new ExamService();
			System.out.println("Please Enter The Exam ID:");
			Integer exam_id = Integer.parseInt(s.nextLine());

			ExamResponeObject obj = null;
			obj =  examService.fetchExamById(exam_id);
			ExamVO vo;
			vo = obj.getExamVO();
			if (vo != null) {
				System.out.println(
						"================================================================================================");
				System.out.println("ExamId" + '\t' + "Exam_name" + '\t' + "hall_id");
				System.out.println(
						"================================================================================================");
				System.out.println(vo.getExam_id() + "\t\t" + vo.getExam_name() + "\t\t"
						+ vo.getHall_id() );
			} else {
				System.out.println(obj.getFailureMessage());
			}

		}

			private static void addExam() throws ExamManagementException {
			ExamService examService = new ExamService();
			Scanner s = new Scanner(System.in);

			System.out.println("Please Enter The Exam_ID:");
			Integer exam_id = Integer.parseInt(s.nextLine());
			System.out.println("Please Enter The Exam_name:");
			String exam_name = s.nextLine();
			System.out.println("Please Enter The Hall_id:");
			Integer hall_id = Integer.parseInt(s.nextLine());
			

			ExamVO vo = new ExamVO();
			vo.setExam_id(exam_id);
			vo.setExam_name(exam_name);
			vo.setHall_id(hall_id);
			
			ExamResponeObject obj = examService.addExam(vo);
			if (obj.getSuccessMessage() != null) {
				System.out.println(obj.getSuccessMessage());
			} else {
				System.out.println(obj.getFailureMessage());
			}

		}

		private static void updateExam()  throws ExamManagementException {
			// TODO Auto-generated method stub
			ExamService examservice = new ExamService();
			Scanner s = new Scanner(System.in);

			System.out.println("Please Enter The Exam_ID:");
			Integer exam_id = Integer.parseInt(s.nextLine());
			System.out.println("Please Enter The Exam_name:");
			String exam_name = s.nextLine();
			System.out.println("Please Enter The Hall_id:");
			Integer hall_id = Integer.parseInt(s.nextLine());
			ExamVO vo = new ExamVO();
			vo.setExam_id(exam_id);
			vo.setExam_name(exam_name);
			vo.setHall_id(hall_id);
			ExamResponeObject obj = examservice.updateExam(vo);
			if (obj.getSuccessMessage() != null) {
				System.out.println(obj.getSuccessMessage());
			} else {
				System.out.println(obj.getFailureMessage());
			}

		}

		private static void fetchExamByName() throws ExamNotFoundException {
			Scanner s = new Scanner(System.in);
			System.out.println("Please Enter The Exam Name:");
			String exam_name = s.nextLine();

			ExamService examService = new ExamService();

			ExamResponeObject obj = null;
			obj = examService.fetchExamByName(exam_name);

			List<ExamVO> list = new ArrayList<ExamVO>();

			list = obj.getExamVOList();
			if (list!=null) {
				System.out.println("No such list in the exam");
				for (ExamVO vo : list) {
					System.out.println(
							"======================================================================================================================================================");
					System.out.println("ExamId" + '\t' + "Exam_name" + '\t' + "hall_id");
					System.out.println(
							"======================================================================================================================================================");

					System.out.println(list);


				}
			}else  {
				System.out.println(obj.getFailureMessage());

			}

		}
	


	

	


	

}
