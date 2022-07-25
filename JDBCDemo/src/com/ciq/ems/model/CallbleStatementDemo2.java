package com.ciq.ems.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallbleStatementDemo2 {
//	static {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}

	public static void main(String[] args) {
		Connection connection = null;
		CallableStatement cs = null;
		try {
//			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms_db", "createiq", "root");
			connection = ConnectionUtil.getConnection();
			cs = connection.prepareCall("{call emp_update_procedure(?, ?, ?)}");
			cs.setInt(1, 100);
//			cs.setString(2, "balu");
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.DECIMAL);
			cs.setDouble(3, 75000.00);
//			cs.registerOutParameter(2, sqlType);
			cs.execute();
			System.out.println(cs.getString(2));
			System.out.println(cs.getDouble(3));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection(connection, cs);

		}
	}
//	if (connection != null && cs != null) {
//
//		try {
//			cs.close();
//			connection.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}
}
