package com.ciq.ems.queries;

public interface DBQueriesConstants {

	static final String INSERT_QUERY = "INSERT INTO EMPLOYEES VALUES(?,?, ?, ?)";
	static final String SELECT_ALL_EMPS = "SELECT * FROM EMPLOYEES";
	static final String UPDATE_QUERY = "UPDATE EMPLOYEES SET ENAME=?, SALARY=?, EMAIL=? WHERE EID=?";
	

}
