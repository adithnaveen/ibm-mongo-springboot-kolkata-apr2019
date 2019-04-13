package com.training.ibm;

import com.mongodb.BasicDBObject;

public class Employee extends BasicDBObject {
	private int empId;
	private String empName;
	private double empSal;
	private String empEmail;

	public Employee(int empId, String empName, double empSal, String empEmail) {
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
		this.empEmail = empEmail;
		
		this.put("empid", empId);
		this.put("empname", empName); 
		this.put("empsal", empSal); 
		this.put("empemail", empEmail); 
		
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	
}
