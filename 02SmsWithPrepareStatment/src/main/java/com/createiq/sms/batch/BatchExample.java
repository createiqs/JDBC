package com.createiq.sms.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

import com.createiq.sms.queries.SqlQueries;
import com.createiq.sms.util.ConnectionUtil;

public class BatchExample {
	public static void main(String[] args) {
		Connection connection = ConnectionUtil.openConnection();
		PreparedStatement psInsert = null;
		PreparedStatement psUpdate = null;
		PreparedStatement psDelete = null;
		try {
			psInsert = connection.prepareStatement(SqlQueries.INSERT_SQL);
			psInsert.setInt(1, 1001);
			psInsert.setString(2, "ravi");
			psInsert.setDouble(3, 22000.00);
			psInsert.setString(4, "ravi@gmail.com");
			psInsert.addBatch();
			int[] insert = psInsert.executeBatch();
			System.out.println(Arrays.toString(insert) + " inserted");
			psUpdate = connection.prepareStatement(SqlQueries.UPDATE_SQL);
			psUpdate.setString(1, "hari g");
			psUpdate.setString(2, "hari@createiq.com");
			psUpdate.setInt(3, 201);
			psUpdate.addBatch();
			int[] update = psUpdate.executeBatch();
			System.out.println(Arrays.toString(update) + " updated");
			psDelete = connection.prepareStatement(SqlQueries.DELETE_SQL);
			psDelete.setInt(1, 102);
			psDelete.addBatch();
			int[] delete = psDelete.executeBatch();
			System.out.println(Arrays.toString(delete) + " delete");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection(connection, psInsert);
			ConnectionUtil.closeConnection(connection, psUpdate);
			ConnectionUtil.closeConnection(connection, psDelete);
		}

	}

}
