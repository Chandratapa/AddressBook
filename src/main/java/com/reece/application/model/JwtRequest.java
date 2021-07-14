package com.reece.application.model;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class JwtRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	
	@NotEmpty(message="Username must not be empty")
	private String username;
	@NotEmpty(message="Password must not be empty")
	private String password;
	
	//need default constructor for JSON Parsing
	public JwtRequest()
	{
		
	}

	public JwtRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}