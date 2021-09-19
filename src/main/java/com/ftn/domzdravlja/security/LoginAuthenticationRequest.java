package com.ftn.domzdravlja.security;

public class LoginAuthenticationRequest {
	private String email;
	private String password;

	public LoginAuthenticationRequest() {
		super();
	}

	public LoginAuthenticationRequest(String email, String password) {
		this.setEmail(email);
		this.setPassword(password);
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
