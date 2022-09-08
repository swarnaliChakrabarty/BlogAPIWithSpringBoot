package com.springboot.blog.payloads;

public class CategoryDto {
	private int cId;
	private String categoryTitle;
	private String categoryDesc;

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

	public CategoryDto(int cId, String categoryTitle, String categoryDesc) {
		super();
		this.cId = cId;
		this.categoryTitle = categoryTitle;
		this.categoryDesc = categoryDesc;
	}

	public CategoryDto() {
		
	}
}
