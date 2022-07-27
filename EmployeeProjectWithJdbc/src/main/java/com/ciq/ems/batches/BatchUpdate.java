package com.ciq.ems.batches;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

import com.ciq.ems.queries.DBQueriesConstants;
import com.ciq.ems.util.ConnectionUtil;

public class BatchUpdate {
	public static void main(String[] args) {

		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement psInsert = null;
		PreparedStatement psUpdate = null;

		try {
			connection.setAutoCommit(false);

			psUpdate = connection.prepareStatement(DBQueriesConstants.UPDATE_QUERY);
			psUpdate.setString(1, "eswar g");
			psUpdate.setDouble(2, 55000.00);
			psUpdate.setString(3, "eswar@gmail.com");
			psUpdate.setInt(4, 101);
			psUpdate.addBatch();

			int[] executeBatch = psUpdate.executeBatch();
			System.out.println(Arrays.toString(executeBatch));

			psInsert = connection.prepareStatement(DBQueriesConstants.INSERT_QUERY);
			psInsert.setInt(1, 106);
			psInsert.setString(2, "balu");
			psInsert.setDouble(3, 25000.00);
			psInsert.setString(4, "balu@gmail.com");
			psInsert.addBatch();

//			psInsert.setInt(1, 104);
//			psInsert.setString(2, "rama");
//			psInsert.setDouble(3, 28000.00);
//			psInsert.setString(4, "rama@gmail.com");
//			psInsert.addBatch();
//
//			psInsert.setInt(1, 105);
//			psInsert.setString(2, "sunil");
//			psInsert.setDouble(3, 27000.00);
//			psInsert.setString(4, "sunil@gmail.com");
//			psInsert.addBatch();

			int[] results = psInsert.executeBatch();

			System.out.println(Arrays.toString(results));
			connection.commit();

		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println(e.getMessage() + e.getSQLState());
		}

		ConnectionUtil.closeConnection(connection, psInsert);
		ConnectionUtil.closeConnection(connection, psUpdate);

	}

}
