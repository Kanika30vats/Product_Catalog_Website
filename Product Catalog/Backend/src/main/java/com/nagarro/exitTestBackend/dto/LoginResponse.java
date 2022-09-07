package com.nagarro.exitTestBackend.dto;

/**
 * 
 * @author kanikasharma02
 *
 */
public class LoginResponse {

	String token;

	public LoginResponse() {

	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LoginResponse(String token) {
		this.token = token;
	}
}
