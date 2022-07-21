package com.ciq.ems.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class EmployeeClient {

	public static void main(String[] args) {
		Employee employee = new Employee(2000, "anil", 52000.00, "anil@gmail.com");
		Connection connection = null;
		PreparedStatement ps = null;
		String insertEmployee = "insert into employee values(?, ?, ?, ?)";
//		ResultSet rs = null;
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms_db", "createiq", "root");
//			System.out.println(connection);
			ps = connection.prepareStatement(insertEmployee);
			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getName());
			ps.setDouble(3, employee.getSalary());
			ps.setString(4, employee.getEmail());
			int row = ps.executeUpdate();
			System.out.println(" inserted " + row + " row successfully....!");

		} catch (SQLException e) {
			// TODO: handle exception
		}

		finally {
			try {
//				rs.close();
				ps.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
