package com.createiq.sms.service;

import java.util.List;

import com.createiq.sms.dao.StudentDaoImpl;
import com.createiq.sms.model.Student;

public class StudentServiceImpl implements StudentService {

	// tight-coupling
	private static StudentDaoImpl dao = new StudentDaoImpl();

	public void createStudent(Student student) {
		dao.save(student);

	}

	public List<Student> getAllStudents() {
		return dao.findAll();
	}

	public void updateStudent(Student student) {
		dao.update(student);

	}

}
