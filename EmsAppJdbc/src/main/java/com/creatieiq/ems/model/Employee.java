package com.creatieiq.ems.model;

import java.util.Date;

public class Employee {

	private int id;
	private String ename;
	private Double salary;
	private String email;
	private Date doj;

	public Employee() {

	}

	public Employee(int id, String ename, Double salary, String email, Date doj) {
		super();
		this.id = id;
		this.ename = ename;
		this.salary = salary;
		this.email = email;
		this.doj = doj;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", ename=" + ename + ", salary=" + salary + ", email=" + email + ", doj=" + doj
				+ "]";
	}

}
