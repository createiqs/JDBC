package com.createiq.sms.metadata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.createiq.sms.util.ConnectionUtil;

public class ResultsetMetaDataExample {
	public static void main(String[] args) throws SQLException {
		Connection connection = ConnectionUtil.openConnection();
		PreparedStatement stmt = connection.prepareStatement("select * from student");
		ResultSet rs = stmt.executeQuery("select * from student");
		ResultSetMetaData rsmd = rs.getMetaData();
		// find the no of columns
		int count = rsmd.getColumnCount();
		for (int i = 1; i <= count; i++) {
			System.out.println("column no :" + i);
			System.out.println("column name :" + rsmd.getColumnName(i));
			System.out.println("column type :" + rsmd.getColumnTypeName(i));
			System.out.println("column size :" + rsmd.getColumnDisplaySize(i));
			System.out.println("-----------");
		}
	}

}
