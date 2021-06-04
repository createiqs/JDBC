package com.createiq.sms.model;

public class Student {

	private int sid;
	private String name;
	private double fee;
	private String email;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int sid, String name, double fee, String email) {
		super();
		this.sid = sid;
		this.name = name;
		this.fee = fee;
		this.email = email;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", fee=" + fee + ", email=" + email + "]";
	}

}
