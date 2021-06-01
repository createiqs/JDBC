package com.createiq.sms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.createiq.sms.model.Student;
import com.createiq.sms.queries.SqlQueries;
import com.createiq.sms.util.ConnectionUtil;

public class StudentDaoImpl implements StudentDao {
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet rs = null;

	public void save() {
		// update
		// delete
		// find by id or find by name

		try {
			connection = ConnectionUtil.openConnection();
			statement = connection.createStatement();
			int result = statement.executeUpdate(SqlQueries.INSERT_SQL);
			System.out.println(result + " inserted....");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection(connection, statement);
		}

	}

	public List<Student> findAll() {
		List<Student> students = new ArrayList<Student>();
		try {

			connection = ConnectionUtil.openConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(SqlQueries.SELECT_ALL);
			while (rs.next()) {
				Student student = new Student();
				student.setSid(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setFee(rs.getDouble(3));
				student.setEmail(rs.getString(4));
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection(connection, statement, rs);
		}

		return students;

	}

	public void update() {

		try {
			connection = ConnectionUtil.openConnection();
			statement = connection.createStatement();
			int result = statement.executeUpdate(SqlQueries.UPDATE_SQL);
			System.out.println(result + " updated....");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection(connection, statement);
		}

	}

	public void delete() {

		try {
			connection = ConnectionUtil.openConnection();
			statement = connection.createStatement();
			int result = statement.executeUpdate(SqlQueries.DELETE_SQL);
			System.out.println(result + " deleted....");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection(connection, statement);
		}

	}

}
