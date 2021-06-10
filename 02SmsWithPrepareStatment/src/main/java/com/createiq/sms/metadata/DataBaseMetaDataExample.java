package com.createiq.sms.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.createiq.sms.util.ConnectionUtil;

public class DataBaseMetaDataExample {

	public static void main(String[] args) throws SQLException {
		Connection connection = ConnectionUtil.openConnection();
		PreparedStatement stmt = connection.prepareStatement("select * from student");
		DatabaseMetaData dbmd = connection.getMetaData();
		System.out.println("database server name:" + dbmd.getDatabaseProductName());
		System.out.println("database server version:" + dbmd.getDatabaseProductVersion());
		System.out.println("driver server version:" + dbmd.getDriverVersion());
		System.out.println("driver server name:" + dbmd.getDriverName());
		System.out.println("max columns:" + dbmd.getMaxColumnsInTable());

	}

}
