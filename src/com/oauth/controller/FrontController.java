package com.oauth.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oauth.configuration.AuthServerConfig;
import com.oauth.model.Employee;
import com.oauth.utility.TokenManager;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String token = request.getParameter("token");

		System.out.println("Token received: " + token);

		if (TokenManager.isValidToken(token)
				&& AuthServerConfig.getScope().equals("read")) {

			List<Employee> empList = EmployeeController.getEmpList();
			for (int i = 0; i < empList.size(); i++) {
				System.out.println(empList.get(i).getId() + " | "
						+ empList.get(i).getName() + " | "
						+ empList.get(i).getDept() + " | "
						+ empList.get(i).getSalary());
			}

		} else {
			System.out
					.println("You are not authorized to view this information");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
