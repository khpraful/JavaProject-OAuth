package com.oauth.model;

public class Employee {
	private int empId;
	private String empName;
	private String empDept;
	private double empSalary;

	public Employee(int empId, String empName, String empDept, double empSalary) {
		this.empId = empId;
		this.empName = empName;
		this.empDept = empDept;
		this.empSalary = empSalary;
	}

	public int getId() {
		return this.empId;
	}

	public void setId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return this.empName;
	}

	public void setName(String empName) {
		this.empName = empName;
	}

	public String getDept() {
		return this.empDept;
	}

	public void setDept(String empDept) {
		this.empDept = empDept;
	}

	public double getSalary() {
		return this.empSalary;
	}

	public void setSalary(double empSalary) {
		this.empSalary = empSalary;
	}

}
