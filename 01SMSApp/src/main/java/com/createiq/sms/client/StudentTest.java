package com.createiq.sms.client;

import com.createiq.sms.dao.StudentDao;

public class StudentTest {
	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
		dao.save();
//		System.out.println(dao.findAll());

	}

}
