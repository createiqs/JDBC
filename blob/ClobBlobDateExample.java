package com.createiq.ems.blob;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.createiq.ems.util.ConnectionUtil;

public class ClobBlobDateExample {
	public static void main(String[] args) throws SQLException, FileNotFoundException, ParseException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement("insert into createiq_docs values (?, ?, ?, ?, ?, ?)");
		ps.setInt(1, 100);
		ps.setString(2, "mysql doc");
		FileReader fr = new FileReader("F:\\test.txt");
		ps.setClob(3, fr);
		FileInputStream io = new FileInputStream("F:\\sb1.png");
		ps.setBlob(4, io);
		SimpleDateFormat simple = new SimpleDateFormat("yyyy/mm/dd");
		java.util.Date date = simple.parse("2021/05/22");
		Date sql = new Date(date.getDate());
		// OR
//	CreateIQ ciq=new CreateIQ();
//	java.sql.Date doj = new java.sql.Date(ciq.getCreation_date().getTime());
		// OR
//	String dateFormat = "2016/08/25";
//	Date doj = new SimpleDateFormat("yyyy/dd/mm").parse(dateFormat);
		ps.setDate(5, sql);
		ps.setString(6, "mysql documentation ");

		int result = ps.executeUpdate();
		System.out.println(result);
		ConnectionUtil.closeConnection(ps);

	}
}
