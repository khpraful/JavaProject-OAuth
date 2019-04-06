package com.oauth.model;

public class Login {
	private String user;
	private String password;

	public Login() {

	}

	public String getUsername() {
		return this.user;
	}

	public void setUsername(String user) {
		this.user = user;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
