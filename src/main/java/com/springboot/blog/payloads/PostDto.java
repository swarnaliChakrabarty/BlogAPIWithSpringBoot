package com.springboot.blog.payloads;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.springboot.blog.entities.Category;
import com.springboot.blog.entities.Comment;
import com.springboot.blog.entities.User;

public class PostDto {
	private String title;
	
	private String content;
	
	private Date date;
	
	private CategoryDto category;
	
	private UserDto user;
	
	List<Comment> comment = new ArrayList<>();

	
	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	

	public PostDto(String title, String content, Date date, CategoryDto category, UserDto user, List<Comment> comment) {
		super();
		this.title = title;
		this.content = content;
		this.date = date;
		this.category = category;
		this.user = user;
		this.comment = comment;
	}

	public PostDto() {

	}

}
