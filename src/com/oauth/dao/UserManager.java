package com.oauth.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserManager {

	public static String validateUser(String username, String password) {

		Connection conn = DBConnectionManager.getDBConnection();
		String token = null;
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT id, username, passwd FROM user_credentials WHERE username='"
					+ username + "'" + " AND passwd='" + password + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				int id = rs.getInt("id");
				token = TokenManager.getToken(id);
				return token;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}

	}
}
