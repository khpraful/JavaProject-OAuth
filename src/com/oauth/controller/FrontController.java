package com.oauth.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oauth.services.EmployeeServices;
import com.oauth.services.LoginServices;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontController() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String path = request.getServletPath();
		System.out.println("Path: " + path);

		if (path.equalsIgnoreCase("/employees")) {
			EmployeeServices.getEmployees(request);

		} else if (path.equalsIgnoreCase("/employee")) {
			EmployeeServices.getEmployee(request);

		} else if (path.equalsIgnoreCase("/login")) {
			LoginServices.authenticateUser(request);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
