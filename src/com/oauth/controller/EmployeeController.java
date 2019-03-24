package com.oauth.controller;

import java.util.ArrayList;
import java.util.List;

import com.oauth.model.Employee;

public class EmployeeController {

	public static List<Employee> getEmpList(){
		List<Employee> empList = new ArrayList<>();
		Employee emp1 = new Employee(1, "Praful", "Digital", 1000);
		Employee emp2 = new Employee(2, "Deepak", "Digital", 2000);
		empList.add(emp1);
		empList.add(emp2);
		return empList;		
		
	}
}
