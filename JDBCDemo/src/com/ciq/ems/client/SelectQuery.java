package com.ciq.ems.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectQuery {
	// 1. Registering the driver
	// 2. create a connection
	// 3. create a statement
	// 4. execute query
	// 5. extract the results form restult set interface
	// 6. close all the apis

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms_db", "createiq", "root");
//			System.out.println(connection);
			statement = connection.createStatement();
			rs = statement.executeQuery("select * from employee");
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getDouble(3));
				System.out.println(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
