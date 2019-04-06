package com.oauth.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.oauth.configuration.AuthServerConfig;
import com.oauth.dao.TokenManager;
import com.oauth.model.Employee;

public class EmployeeServices {

	public static void getEmployees(HttpServletRequest request) {

		if (serveRequest(request)) {

			List<Employee> empList = new ArrayList<>();
			Employee emp1 = new Employee(1, "Ralph", "Digital", 1000);
			Employee emp2 = new Employee(2, "Fredric", "Digital", 2000);
			empList.add(emp1);
			empList.add(emp2);
			for (int i = 0; i < empList.size(); i++) {
				System.out.println(empList.get(i).getId() + " | "
						+ empList.get(i).getName() + " | "
						+ empList.get(i).getDept() + " | "
						+ empList.get(i).getSalary());
			}

		}
	}

	public static void getEmployee(HttpServletRequest request) {

		if (serveRequest(request)) {
			Employee emp = new Employee(10, "Ralph", "Digital", 1000);
			System.out.println(emp.getId() + " | " + emp.getName() + " | "
					+ emp.getDept() + " | " + emp.getSalary());
		}
	}

	public static boolean createEmployee() {
		return true;
	}

	public static boolean updateEmployee() {
		return true;
	}

	public static boolean deleteEmployee() {
		return true;
	}

	public static boolean serveRequest(HttpServletRequest request) {
		String token = request.getParameter("token");
		System.out.println("Received Token: " + token);

		if (token != null && TokenManager.isValidToken(token)
				&& AuthServerConfig.getScope().equals("read")) {
			return true;
		} else {
			return false;
		}

	}
}
