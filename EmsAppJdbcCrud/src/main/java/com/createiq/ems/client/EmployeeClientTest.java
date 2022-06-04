package com.createiq.ems.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.creatieiq.ems.dao.EmployeeDaoImpl;
import com.creatieiq.ems.model.Employee;

public class EmployeeClientTest {
//	private static Logger LOGGER = Logger.getLogger(EmployeeClientTest.class);
	public static void main(String[] args) throws ParseException {
		EmployeeDaoImpl dao = new EmployeeDaoImpl();
//		String dateFormat = "2016/08/25";
//		Date doj = new SimpleDateFormat("yyyy/dd/mm").parse(dateFormat);
//		Employee employee = new Employee(1003, "Roshan", 26000.00, "roshan@gmail.com", doj);

//		dao.save(employee);
//		List<Employee> emps=dao.findAll();
//		for(Employee employee: emps) {
//			System.out.println(employee);
//		}
//		dao.update(employee);
//		Employee employee = dao.getById(1003);
//		System.out.println(employee);
//		LOGGER.info("employee details "+ employee);

		Employee byName = dao.getByName("virat");
		System.out.println(byName);
//		String dateFormat = "2018/08/25";
//		Date doj = new SimpleDateFormat("yyyy/dd/mm").parse(dateFormat);
//		EmployeeDaoImpl dao = new EmployeeDaoImpl();
//		Employee employee = new Employee(1003, "karthik", 18000.00, "karthik@gmail.com", doj);
//		dao.save(employee);

//		String formateDate="2022/05/05";
//		Date date= new SimpleDateFormat("yyyy/mm/dd").parse(formateDate);
//		System.out.println(date);
//		
//		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
//		System.out.println(sqlDate);
	}

}
