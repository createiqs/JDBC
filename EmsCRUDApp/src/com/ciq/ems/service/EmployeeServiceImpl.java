package com.ciq.ems.service;

import java.util.List;

import com.ciq.ems.dao.EmployeeDaoImpl;
import com.ciq.ems.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	private static EmployeeDaoImpl dao=new EmployeeDaoImpl();

	@Override
	public Employee save(Employee employee) {
		return dao.save(employee);
	}

	@Override
	public Employee update(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllEmps() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
