package com.createiq.sms.dao;

import java.util.List;

import com.createiq.sms.model.Student;

public interface StudentDao {

	// hiding the internal implementation

	void save(Student student);

	void update(Student student);

	void delete(int id);

	List<Student> findAll();

	Student findByName(String name);

	Student findById(int id);

}
