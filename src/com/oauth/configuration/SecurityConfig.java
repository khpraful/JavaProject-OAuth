package com.oauth.configuration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.oauth.utility.DBConnectionManager;

public class SecurityConfig {

	public static int authenticateUser(String username, String password) {

		Connection conn = DBConnectionManager.getDBConnection();
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT id, username, passwd FROM user_credentials WHERE username='"
					+ username + "'" + " AND passwd='" + password + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				int id = rs.getInt("id");
				return id;
			} else {
				return 0;
			}
		} catch (Exception e) {
			return 0;
		}
	}

	public static String configureUser() {
		return "admin";
	}

	public static String configurePassword() {
		return "admin";
	}

	public static String configureRole() {
		return "admin";
	}
}
