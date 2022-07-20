package com.ciq.ems.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertEmployee {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		String insertQuery = "insert into employee values(100, 'balu', 32000.00, 'balu@gmail.com')";

		// registering the driver class
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
//		Class.forName("com.mysql.cj.jdbc.Driver");
		// establish the connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms_db", "createiq", "root");
		System.out.println(connection);

		// create a statement
		Statement statement = connection.createStatement();
		// execute query
		int result = statement.executeUpdate(insertQuery);
		System.out.println("inserted " + result + " row successfully...!");
		statement.close();
		connection.close();

	}

}
