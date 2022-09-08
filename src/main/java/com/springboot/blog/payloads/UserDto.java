package com.springboot.blog.payloads;



import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class UserDto {

	private int id;
	
	@NotEmpty
	@Size(min=4,message="Username must be 4 character")
	private String name;
	@Email(message="Email address is not valid!!")
	private String email;
	@NotEmpty
	@Size(min=4,max=10,message="password must be 4 character and max 10 characters")
	private String password;
	@NotEmpty(message="About can not be empty")
	private String about;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public UserDto(int id, String name, String email, String password, String about) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
	}
	public UserDto() {
	}
	
	
}
