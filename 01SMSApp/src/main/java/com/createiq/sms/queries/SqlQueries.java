package com.createiq.sms.queries;

public interface SqlQueries {
	static String INSERT_SQL = "INSERT INTO STUDENT VALUES(102,'RAJU', 16000.00,'RAJU@GMAIL.COM')";
	static String SELECT_ALL = "SELECT * FROM STUDENT";
	static String UPDATE_SQL = "UPDATE STUDENT SET NAME='BALAJI' WHERE SID=100";
	static String DELETE_SQL = "DELETE FROM STUDENT WHERE SID=102";

}
