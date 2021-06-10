package com.createiq.sms.callabale.ex;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.createiq.sms.util.ConnectionUtil;

public class CallbaleStatementDemo {
	public static void main(String[] args) {
		Connection connection = null;
		CallableStatement cl = null;

		try {

			connection = ConnectionUtil.openConnection();
			cl = connection.prepareCall("{call add_two_numbers(?,?,?)}");
//			cl = connection.prepareCall("{call get_by_StudenId(?)}");
//			cl.setInt(1, 2000);
//			cl.registerOutParameter(parameterIndex, sqlType);

			// in numOne
			cl.setInt(1, 100);
			// in numTwo
			cl.setInt(2, 200);
			cl.registerOutParameter(3, Types.INTEGER);
			cl.executeUpdate();

			// read the OUT parameter now
			int total = cl.getInt(3);
			System.out.println(total);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection(connection, cl);

		}
	}

}
