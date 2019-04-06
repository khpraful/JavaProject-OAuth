package com.oauth.services;

import javax.servlet.http.HttpServletRequest;

import com.oauth.dao.UserManager;

public class LoginServices {

	public static boolean registerUser() {
		return true;
	}

	public static String authenticateUser(HttpServletRequest request) {

		String username = "admin";
		String password = "admin";
		return UserManager.validateUser(username, password);

	}

	public static boolean resetPassword() {
		return true;
	}
}
