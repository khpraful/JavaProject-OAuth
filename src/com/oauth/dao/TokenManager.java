package com.oauth.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Random;

import com.oauth.dao.TokenManager;
import com.mysql.jdbc.PreparedStatement;

public class TokenManager {

	private static final String charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	public static String getToken(int id) {

		Connection conn = DBConnectionManager.getDBConnection();
		String token = null;
		try {
			Statement stmt = conn.createStatement();
			String sql1 = "SELECT userid FROM user_details WHERE userid=" + id;
			System.out.println(sql1);
			ResultSet rs1 = stmt.executeQuery(sql1);
			if (rs1.next()) {

				String userid = rs1.getString("userid");
				String sql2 = "SELECT token, expiry FROM token WHERE userid ="
						+ id + " AND expiry >=" + "'" + LocalDate.now() + "'";
				System.out.println(sql2);
				ResultSet rs2 = stmt.executeQuery(sql2);
				if (rs2.next()) {
					token = rs2.getString("token");
					System.out.println(token);
				} else {
					token = generateToken();
					System.out.println(token);
					LocalDate expiry = LocalDate.now().plusDays(1);
					String sql3 = "INSERT INTO token (userid, token, expiry) VALUES ("
							+ userid
							+ ","
							+ "'"
							+ token
							+ "'"
							+ ","
							+ "'"
							+ expiry + "'" + ")";
					System.out.println(sql3);
					PreparedStatement preparedStmt = (PreparedStatement) conn
							.prepareStatement(sql3);
					preparedStmt.execute();
				}
			}
		} catch (Exception e) {
			return null;
		}
		return token;

	}

	public static String generateToken() {

		Random random = new Random();
		StringBuilder builder = new StringBuilder(50);

		for (int i = 0; i < 10; i++) {
			builder.append(charset.charAt(random.nextInt(charset.length())));

		}
		return builder.toString();

	}

	public static boolean isValidToken(String token) {
		Connection conn = DBConnectionManager.getDBConnection();

		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT token, expiry FROM token WHERE token = "
					+ "'" + token + "'" + " AND expiry >=" + "'" + LocalDate.now() + "'";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
}
