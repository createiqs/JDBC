package com.ciq.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ciq.ems.model.Employee;
import com.ciq.ems.queries.DBQueriesConstants;
import com.ciq.ems.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDAO {
	Connection connection = null;
	PreparedStatement ps = null;

	@Override
	public Employee save(Employee employee) {

		PreparedStatement ps = null;
		try {
			connection = ConnectionUtil.getConnection();
			ps = connection.prepareStatement(DBQueriesConstants.INSERT_QUERY);
			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getName());
			ps.setDouble(3, employee.getSalary());
			ps.setString(4, employee.getEmail());
			int result = ps.executeUpdate();
			System.out.println("row " + result + " inserted...!");
		} catch (SQLException e) {
			System.out.println(e.getSQLState() + " " + e.getMessage());
		}
		ConnectionUtil.closeConnection(connection, ps);

		return employee;
	}

	@Override
	public Employee update(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllEmps() {

		List<Employee> employees = new ArrayList<>();
		try {
			connection = ConnectionUtil.getConnection();
			ps = connection.prepareStatement(DBQueriesConstants.SELECT_ALL_EMPS);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setSalary(rs.getDouble(3));
				employee.setEmail(rs.getString(4));
				employees.add(employee);
			}
			return employees;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
