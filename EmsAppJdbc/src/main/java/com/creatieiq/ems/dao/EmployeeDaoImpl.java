package com.creatieiq.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.createiq.ems.queries.EmployeeQueries;
import com.createiq.ems.util.ConnectionUtil;
import com.creatieiq.ems.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	private static Connection connection = null;
	private static PreparedStatement ps = null;
	private static ResultSet resultSet = null;

	public List<Employee> findAll() {

		try {
			connection = ConnectionUtil.getConnection();
			ps = connection.prepareStatement(EmployeeQueries.SELECT_QUERY);
			resultSet = ps.executeQuery();
			List<Employee> employees = new ArrayList<>();
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setId(resultSet.getInt(1));
				employee.setEname(resultSet.getString(2));
				employee.setSalary(resultSet.getDouble(3));
				employee.setEmail(resultSet.getString(4));
				employee.setDoj(resultSet.getDate(5));
				employees.add(employee);
			}
			return employees;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConnectionUtil.closeConnection(resultSet, ps);
		return null;
	}

	public Employee save(Employee employee) {
		try {
			connection = ConnectionUtil.getConnection();
			ps = connection.prepareStatement(EmployeeQueries.INSERT_QUERY);
			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getEname());
			ps.setDouble(3, employee.getSalary());
			ps.setString(4, employee.getEmail());
			java.sql.Date doj = new java.sql.Date(employee.getDoj().getTime());
			ps.setDate(5, doj);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectionUtil.closeConnection(ps);
		return employee;
	}

	public Employee update(Employee employee) {
		try {
			connection = ConnectionUtil.getConnection();
			ps = connection.prepareStatement(EmployeeQueries.UPDATE_QUERY);
			ps.setInt(5, employee.getId());
			ps.setString(1, employee.getEname());
			ps.setString(3, employee.getEmail());
			ps.setDouble(2, employee.getSalary());
			java.sql.Date doj = new java.sql.Date(employee.getDoj().getTime());
			ps.setDate(4, doj);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectionUtil.closeConnection(ps);
		return employee;
	}

	public void delete(int id) {
		try {
			connection = ConnectionUtil.getConnection();
			ps = connection.prepareStatement(EmployeeQueries.DELETE_QUERY);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Employee getById(int eid) {

		try {
			Connection connection = ConnectionUtil.getConnection();
			ps = connection.prepareStatement(EmployeeQueries.SELECT_BY_ID_QUERY);
			ps.setInt(1, eid);
			resultSet = ps.executeQuery();
			Employee employee = new Employee();
			if (resultSet.next()) {
				employee.setId(resultSet.getInt(1));
				employee.setEname(resultSet.getString(2));
				employee.setEmail(resultSet.getString(4));
				employee.setSalary(resultSet.getDouble(3));
				employee.setDoj(resultSet.getDate(5));
			}
			return employee;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection(resultSet, ps);
		}
		return null;

	}

	@Override
	public Employee getByName(String name) {
		try {
			Connection connection = ConnectionUtil.getConnection();
			ps = connection.prepareStatement(EmployeeQueries.SELECT_BY_NAME_QUERY);
			ps.setString(1, name);
			resultSet = ps.executeQuery();
			Employee employee = new Employee();
			if (resultSet.next()) {
				employee.setId(resultSet.getInt(1));
				employee.setEname(resultSet.getString(2));
				employee.setSalary(resultSet.getDouble(3));
				employee.setEmail(resultSet.getString(4));
				employee.setDoj(resultSet.getDate(5));
			}
			return employee;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection(resultSet, ps);
		}
		return null;
	}

}
