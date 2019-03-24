package com.oauth.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String dburl = "jdbc:mysql://localhost:3306/test";
	private static String dbuser = "mysql";
	private static String dbpass = "mysql";
	private static Connection conn;

	public static Connection getDBConnection() {

		try {
			Class.forName(driver);

			try {
				conn = DriverManager.getConnection(dburl, dbuser, dbpass);
			} catch (SQLException e) {
				System.out.println("DB connection failed!");
			}
		} catch (ClassNotFoundException ex) {
			System.out.println("Driver not found.");
		}

		return conn;

	}

}
