package com.createiq.sms.dao;

import java.util.List;

import com.createiq.sms.model.Student;

public interface StudentDao {

	// hiding the internal implementation

	void save();

	void update();

	void delete();

	List<Student> findAll();

}
