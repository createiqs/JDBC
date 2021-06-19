package com.createiq.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.createiq.sms.exception.StudentNotFoundException;
import com.createiq.sms.model.Student;
import com.createiq.sms.queries.SqlQueries;
import com.createiq.sms.util.ConnectionUtil;

public class StudentDaoImpl implements StudentDao {
	private static Connection connection = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;

	public void save(Student student) {

		try {
			connection = ConnectionUtil.openConnection();
			ps = connection.prepareStatement(SqlQueries.INSERT_SQL);
			ps.setInt(1, student.getSid());
			ps.setString(2, student.getName());
			ps.setDouble(3, student.getFee());
			ps.setString(4, student.getEmail());
			int result = ps.executeUpdate();
			System.out.println(result + " inserted....");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection(connection, ps);
		}

	}

	public void update(Student student) {
		try {
			connection = ConnectionUtil.openConnection();
			ps = connection.prepareStatement(SqlQueries.UPDATE_SQL);
			ps.setString(1, student.getName());
			ps.setString(2, student.getEmail());
			ps.setInt(3, student.getSid());
			int result = ps.executeUpdate();
			System.out.println(result + " updated....");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection(connection, ps);
		}

	}

	public void delete(int id) {
		if (id == 0) {
			try {
				throw new StudentNotFoundException();
			} catch (StudentNotFoundException e) {
				System.out.println("no " + id);
			}
		}

	}

	public List<Student> findAll() {
		List<Student> students = new ArrayList<Student>();
		try {

			connection = ConnectionUtil.openConnection();
			ps = connection.prepareStatement(SqlQueries.SELECT_ALL);
			rs = ps.executeQuery();
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
			ConnectionUtil.closeConnection(connection, ps, rs);
		}

		return students;

	}

	public Student findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Student findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
