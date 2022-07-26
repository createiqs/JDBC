package com.ciq.ems.service;

import java.util.List;

import com.ciq.ems.model.Employee;

public interface EmployeeService {

	Employee save(Employee employee);

	Employee update(Employee employee);

	List<Employee> getAllEmps();

	int delete(int id);
}
