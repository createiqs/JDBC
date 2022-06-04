package com.createiq.ems.queries;

public interface EmployeeQueries {

	final String SELECT_QUERY = "SELECT * FROM EMPLOYEES";
	final String INSERT_QUERY = "INSERT INTO EMPLOYEES VALUES (?,?,?,?,?)";
	final String UPDATE_QUERY = "UPDATE EMPLOYEES SET ENAME=?,  ESAL=?, EMAIL=?, DOJ=? WHERE EID=?";
	final String DELETE_QUERY = "DELETE FROM EMPLOYEES WHERE EID=?";
	final String SELECT_BY_ID_QUERY = "SELECT * FROM EMPLOYEES WHERE EID=?";
	final String SELECT_BY_NAME_QUERY = "SELECT * FROM EMPLOYEES WHERE ENAME=?";
}
