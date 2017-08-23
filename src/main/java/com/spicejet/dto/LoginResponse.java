package com.spicejet.dto;

public class LoginResponse {

	
	private String token;
	private String status;
	private String message;
	private String username;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "LoginResponse [token=" + token + ", status=" + status + ", message=" + message + ", username="
				+ username + "]";
	}
	
	
	
}
