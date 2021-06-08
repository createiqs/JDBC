package com.createiq.sms.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

import com.createiq.sms.queries.SqlQueries;
import com.createiq.sms.util.ConnectionUtil;

public class BatchExample2 {
	public static void main(String[] args) {

		try (Connection connection = ConnectionUtil.openConnection();
				PreparedStatement psInsert = connection.prepareStatement(SqlQueries.INSERT_SQL);
				PreparedStatement psUpdate = connection.prepareStatement(SqlQueries.UPDATE_SQL);
				PreparedStatement psDelete = connection.prepareStatement(SqlQueries.DELETE_SQL);) {

			psInsert.setInt(1, 1001);
			psInsert.setString(2, "ravi");
			psInsert.setDouble(3, 22000.00);
			psInsert.setString(4, "ravi@gmail.com");
			psInsert.addBatch();
			int[] insert = psInsert.executeBatch();
			System.out.println(Arrays.toString(insert) + " inserted");

			psUpdate.setString(1, "hari g");
			psUpdate.setString(2, "hari@createiq.com");
			psUpdate.setInt(3, 201);
			psUpdate.addBatch();
			int[] update = psUpdate.executeBatch();
			System.out.println(Arrays.toString(update) + " updated");

			psDelete.setInt(1, 102);
			psDelete.addBatch();
			int[] delete = psDelete.executeBatch();
			System.out.println(Arrays.toString(delete) + " delete");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
