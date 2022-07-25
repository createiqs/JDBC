package com.ciq.ems.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class SelectByID {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Connection connection = null;
		CallableStatement cs = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms_db", "createiq", "root");
			cs = connection.prepareCall("{call emp_select_by_id(?)}");
			cs.setInt(1, 100);
//			cs.registerOutParameter(1, Types.INTEGER);
//			int result=cs.getInt(1);
//			System.out.println(result);
			ResultSet rs=cs.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getDouble(3));
				System.out.println(rs.getString(4));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null && cs != null) {

				try {
					cs.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
