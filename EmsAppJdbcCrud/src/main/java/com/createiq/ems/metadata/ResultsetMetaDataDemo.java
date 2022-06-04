package com.createiq.ems.metadata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.createiq.ems.queries.EmployeeQueries;
import com.createiq.ems.util.ConnectionUtil;

public class ResultsetMetaDataDemo {

	public static void main(String[] args) {
		Connection connection = ConnectionUtil.getConnection();
//		System.out.println(connection);

		try (Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(EmployeeQueries.SELECT_QUERY);) {
			ResultSetMetaData metaData = rs.getMetaData();
			int count = metaData.getColumnCount();
			for (int i = 1; i <= count; i++) {
				System.out.println("column no :" + i);
				System.out.println("column name :" + metaData.getColumnName(i));
				System.out.println("column type :" + metaData.getColumnTypeName(i));
				System.out.println("column size :" + metaData.getColumnDisplaySize(i));
				System.out.println(metaData.getTableName(i));
				System.out.println("-----------");
			}

		} catch (SQLException e) {
			System.out.println(e.getSQLState() + " " + e.getMessage());
		}
	}

}
