package com.createiq.sms.client;

import com.createiq.sms.dao.StudentDaoImpl;

public class StudentTest {
	public static void main(String[] args) {
		StudentDaoImpl dao = new StudentDaoImpl();
		dao.save();
//		System.out.println(dao.findAll());

	}

}
