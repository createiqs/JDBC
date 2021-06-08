package com.createiq.sms.controller;

import java.util.List;

import com.createiq.sms.dao.StudentDaoImpl;
import com.createiq.sms.model.Student;
import com.createiq.sms.service.StudentServiceImpl;

public class StudentController {

	//jsp servlets,theymleaf, spring mvc, angulor
	public static void main(String[] args) {
		// tight coupling
		StudentServiceImpl service = new StudentServiceImpl();
		Student student = new Student(200, "balaji", 22000.00d, "balaji@gmail.com");
		service.createStudent(student);
//		Student student = new Student();
//		student.setName("laxmi t");
//		student.setEmail("laxmi@gmail.com");
//		student.setSid(101);
//		service.updateStudent(student);

//		List<Student> listOfStudents = service.getAllStudents();
//		for (Student student : listOfStudents) {
//			System.out.println(student);
//		}
	}

}
