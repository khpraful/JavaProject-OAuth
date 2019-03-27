package com.oauth.controller;

import java.util.ArrayList;
import java.util.List;

import com.oauth.model.Employee;

public class EmployeeController {

	public static List<Employee> getEmpList(){
		List<Employee> empList = new ArrayList<>();
		Employee emp1 = new Employee(1, "Ralph", "Digital", 1000);
		Employee emp2 = new Employee(2, "Fredric", "Digital", 2000);
		empList.add(emp1);
		empList.add(emp2);
		return empList;		
		
	}
}
