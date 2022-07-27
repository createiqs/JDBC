package com.ciq.ems.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionUtil {

	private static Connection connection = null;
	private static Statement st = null;
	private static ResultSet rs = null;
	private static Properties properties = null;
	static {

		try {
			properties = new Properties();
			properties.load(ConnectionUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			Class.forName(properties.getProperty("driver"));
			connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("un"),
					properties.getProperty("pw"));
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closeConnection(Connection connection, Statement cs) {
		if (cs != null) {
			try {
				closeConnection(connection);
				cs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void closeConnection(Connection connection, Statement st, ResultSet rs) {
		if (rs != null) {
			try {
				closeConnection(connection, st);
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(getConnection());
	}

}
