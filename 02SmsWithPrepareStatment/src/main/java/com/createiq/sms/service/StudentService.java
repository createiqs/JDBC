package com.createiq.sms.service;

import java.util.List;

import com.createiq.sms.model.Student;

public interface StudentService {
	void createStudent(Student student);
	
	List<Student> getAllStudents();
	
	void updateStudent(Student student);
}
