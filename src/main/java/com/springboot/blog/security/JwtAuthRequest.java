package com.springboot.blog.security;

import java.util.Objects;

public class JwtAuthRequest {
	
	private String Username;
	private String password;
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Username, password);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JwtAuthRequest other = (JwtAuthRequest) obj;
		return Objects.equals(Username, other.Username) && Objects.equals(password, other.password);
	}
	public JwtAuthRequest(String username, String password) {
		super();
		Username = username;
		this.password = password;
	}
	public JwtAuthRequest() {
		
	}
	@Override
	public String toString() {
		return "JwtAuthRequest [Username=" + Username + ", password=" + password + "]";
	}
	
	
}
