package com.createiq.sms.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.createiq.sms.util.ConnectionUtil;

public class TransactionManagement {

	public static void main(String[] args) {
		try (Connection conn = ConnectionUtil.openConnection();
//             Statement statement = conn.createStatement();
				PreparedStatement psInsert = conn.prepareStatement("insert into student values(?,?,?,?)");
				PreparedStatement psUpdate = conn.prepareStatement("UPDATE STUDENT SET NAME=?, EMAIL=? WHERE SID=?");) {

			// start transaction block
			conn.setAutoCommit(false); // default true

			// Run list of insert commands

			psInsert.setInt(1, 1009);
			psInsert.setString(2, "create");
			psInsert.setDouble(3, 22000.00);
			psInsert.setString(4, "create@gmail.com");
			psInsert.execute();

			psInsert.setInt(1, 1010);
			psInsert.setString(2, "create");
			psInsert.setDouble(3, 22000.00);
			psInsert.setString(4, "create@gmail.com");
			psInsert.execute();

			conn.commit();
			System.out.println("transaction successfull");
//			conn.setAutoCommit(true);

		} catch (Exception e) {

			System.out.println("transaction failed");
		}

	}

}
