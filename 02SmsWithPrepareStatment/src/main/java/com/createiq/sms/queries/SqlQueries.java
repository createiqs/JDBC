package com.createiq.sms.queries;

public interface SqlQueries {
	// encapsulation
	static String INSERT_SQL = "INSERT INTO STUDENT VALUES(?,?,?,?)";
	static String SELECT_ALL = "SELECT * FROM STUDENT";
	static String UPDATE_SQL = "UPDATE STUDENT SET NAME=?, EMAIL=? WHERE SID=?";
	static String DELETE_SQL = "DELETE FROM STUDENT WHERE SID=?";

}
