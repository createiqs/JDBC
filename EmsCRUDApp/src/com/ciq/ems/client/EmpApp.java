package com.ciq.ems.client;

import com.ciq.ems.model.Employee;
import com.ciq.ems.service.EmployeeServiceImpl;

public class EmpApp {

	public static void main(String[] args) {
		Employee employee = new Employee(101, "madhu", 44000.00, "madhu@gmail.com");
		EmployeeServiceImpl service = new EmployeeServiceImpl();
		service.save(employee);
	}

}
