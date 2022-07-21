package com.ciq.ems.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class SelectQueryEmployeee {
	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String selectAll = "select * from employee";

		try {
			List<Employee> employees = new ArrayList<>();
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms_db", "createiq", "root");
//			System.out.println(connection);
			ps = connection.prepareStatement(selectAll);
			rs = ps.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setSalary(rs.getDouble(3));
				employee.setEmail(rs.getString(4));
				employees.add(employee);
			}

			for (Employee employee : employees) {
				System.out.println(employee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null && ps != null && connection != null) {
					rs.close();
					ps.close();
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
