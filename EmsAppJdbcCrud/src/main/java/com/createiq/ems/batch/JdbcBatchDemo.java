package com.createiq.ems.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;

import com.createiq.ems.queries.EmployeeQueries;
import com.createiq.ems.util.ConnectionUtil;
import com.creatieiq.ems.model.Employee;

public class JdbcBatchDemo {
	public static void main(String[] args) {
		Connection connection = ConnectionUtil.getConnection();

		try {
			connection.setAutoCommit(false);
			PreparedStatement psInsert = connection.prepareStatement(EmployeeQueries.INSERT_QUERY);
			PreparedStatement psUpdate = connection.prepareStatement(EmployeeQueries.UPDATE_QUERY);

			psUpdate.setInt(5, 300);
			psUpdate.setString(1, "456");
			psUpdate.setDouble(2, 42000.00);
			psUpdate.setString(3, "4567000@gmail.com");
			Date date4 = new Date();
			java.sql.Date sqlDate4 = new java.sql.Date(date4.getTime());
			psUpdate.setDate(4, sqlDate4);
			psUpdate.addBatch();

			psUpdate.setInt(5, 3002);
			psUpdate.setString(1, "789");
			psUpdate.setDouble(2, 7891230.00);
			psUpdate.setString(3, "789010@gmail.com");
			Date date5 = new Date();
			java.sql.Date sqlDate5 = new java.sql.Date(date5.getTime());
			psUpdate.setDate(4, sqlDate5);
			psUpdate.addBatch();

			psInsert.setInt(1, 100);
			psInsert.setString(2, "abc");
			psInsert.setDouble(3, 2000.00);
			psInsert.setString(4, "abc2@gmail.com");
			Date date = new Date();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			psInsert.setDate(5, sqlDate);
			psInsert.addBatch();

			psInsert.setInt(1, 1002);
			psInsert.setString(2, "def");
			psInsert.setDouble(3, 3000.00);
			psInsert.setString(4, "dwf@gmail.com");
			Date date2 = new Date();
			java.sql.Date sqlDate2 = new java.sql.Date(date2.getTime());
			psInsert.setDate(5, sqlDate2);
			psInsert.addBatch();

//		psInsert.setInt(1, 300);
//		psInsert.setString(2, "ghi");
//		psInsert.setDouble(3, 4000.00);
//		psInsert.setString(4, "123@gmail.com");
//		Date date3 = new Date();
//		java.sql.Date sqlDate3 = new java.sql.Date(date3.getTime());
//		psInsert.setDate(5, sqlDate3);
//		psInsert.addBatch();

			int[] rows2 = psUpdate.executeBatch();
			int[] rows = psInsert.executeBatch();
			connection.commit();
			System.out.println(Arrays.toString(rows2));
			System.out.println(Arrays.toString(rows));

		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(e.getMessage() + " " + e.getSQLState());
		}

	}

}
