package com.creatieiq.ems.dao;

import java.util.List;

import com.creatieiq.ems.model.Employee;

public interface EmployeeDao {

	Employee save(Employee employee);

	Employee update(Employee employee);

	List<Employee> findAll();

	void delete(int id);

	Employee getById(int eid);

	Employee getByName(String name);
}
