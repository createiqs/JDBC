package com.createiq.account.queries;

public interface AccountSqlQueries {

	static String INSERT_SQL = "INSERT INTO ACCOUNT VALUES(?,?,?,?)";
	static String UPDATE_SQL = "UPDATE ACCOUNT SET ACCOUNT_HOLDERNAME = ? WHERE ACCOUNT_NO=?";
	static String SELECT_ALL = "SELECT * FROM ACCOUNT";

}
