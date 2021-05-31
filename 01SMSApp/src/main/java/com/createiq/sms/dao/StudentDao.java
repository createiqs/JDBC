package com.createiq.sms.dao;

import java.util.List;

import com.createiq.sms.model.Student;

public interface StudentDao {
 
	public void save();
	
	List<Student> findAll();

}
