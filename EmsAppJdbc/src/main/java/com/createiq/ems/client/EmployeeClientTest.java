package com.createiq.ems.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.creatieiq.ems.dao.EmployeeDaoImpl;
import com.creatieiq.ems.model.Employee;

public class EmployeeClientTest {

	public static void main(String[] args) throws ParseException {
//		String dateFormat = "2016/08/25";
//		Date doj = new SimpleDateFormat("yyyy/dd/mm").parse(dateFormat);
//		Employee employee = new Employee(1000, "Mithali Raj", 26000.00, "MithaliRaj@gmail.com", doj);
		EmployeeDaoImpl dao = new EmployeeDaoImpl();
//		dao.save(employee);
//		List<Employee> emps=dao.findAll();
//		for(Employee employee: emps) {
//			System.out.println(employee);
//		}
//		dao.update(employee);
//		Employee employee = dao.getById(1000);
//		System.out.println(employee);

		Employee byName = dao.getByName("virat");
		System.out.println(byName);
	}

}
