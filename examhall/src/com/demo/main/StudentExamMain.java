package com.demo.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.demo.exception.ExamNotFoundException;
import com.demo.exception.StudentExamManagementException;
import com.demo.exception.StudentExamNotFoundException;
import com.demo.response.StudentExamResponeObject;
import com.demo.service.StudentExamService;
import com.demo.vo.StudentExamVO;

public class StudentExamMain {

	
		public static void main(String[] args) 
			throws StudentExamManagementException, StudentExamNotFoundException, SQLException , ExamNotFoundException  {
					System.out.println("Please select one of the below options");
					System.out.println("1. Add Exam");
					System.out.println("2. Fetch Exam by exam_id");
                    System.out.println("3. Exit");
					Scanner s = new Scanner(System.in);
					int menuSelected = s.nextInt();

					switch (menuSelected) {
					case 1:
						addStudentExam();
						break;
					case 2:
						fetchStudentExamById();
						break;
					
					default:
						System.exit(0);}
					
				}

					private static void fetchStudentExamById() throws StudentExamNotFoundException {
					// TODO Auto-generated method stub
					Scanner s = new Scanner(System.in);
					StudentExamService studentexamService = new StudentExamService();
					System.out.println("Please Enter The Student Exam ID:");
					Integer student_exam_id = Integer.parseInt(s.nextLine());

					StudentExamResponeObject obj = null;
					obj =  studentexamService.fetchStudentExamById(student_exam_id);
					StudentExamVO vo;
					vo = obj.getStudentexamVO();
					if (vo != null) {
						System.out.println(
								"================================================================================================");
						System.out.println("StudentExamId" + '\t' + "Student_id" + '\t' + "exam_id");
						System.out.println(
								"================================================================================================");
						System.out.println(vo.getStudent_exam_id() + "\t\t" + vo.getStudent_id() + "\t\t"
								+ vo.getExam_id() );
					} else {
						System.out.println(obj.getFailureMessage());
					}

				}

					private static void addStudentExam() throws StudentExamManagementException {
						StudentExamService studentexamService = new StudentExamService();
					Scanner s = new Scanner(System.in);

					System.out.println("Please Enter The Student_Exam_ID:");
					Integer student_exam_id = Integer.parseInt(s.nextLine());
					System.out.println("Please Enter The Student_ID:");
					Integer student_id = Integer.parseInt(s.nextLine());
					System.out.println("Please Enter The Exam_ID:");
					Integer exam_id = Integer.parseInt(s.nextLine());
					

					StudentExamVO vo = new StudentExamVO();
					vo.setStudent_exam_id(student_exam_id);
					vo.setStudent_id(student_id);
					vo.setExam_id(exam_id);
					
					StudentExamResponeObject obj = studentexamService.addStudentExam(vo);
					if (obj.getSuccessMessage() != null) {
						System.out.println(obj.getSuccessMessage());
					} else {
						System.out.println(obj.getFailureMessage());
					}

				}

		

}
