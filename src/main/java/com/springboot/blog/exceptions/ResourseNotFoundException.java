package com.springboot.blog.exceptions;

public class ResourseNotFoundException extends RuntimeException {

	private String resourseName;
	private String fieldName;
	private long fieldvalue;
	private String value;
	
	
	
	
	public ResourseNotFoundException(String resourseName, String fieldName, String value) {
		super();
		this.resourseName = resourseName;
		this.fieldName = fieldName;
		this.value = value;
	}


	public String getResourseName() {
		return resourseName;
	}


	public void setResourseName(String resourseName) {
		this.resourseName = resourseName;
	}


	public String getFieldName() {
		return fieldName;
	}


	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}


	public long getFieldvalue() {
		return fieldvalue;
	}


	public void setFieldvalue(long fieldvalue) {
		this.fieldvalue = fieldvalue;
	}


	public ResourseNotFoundException(String resourseName, String fieldName, long fieldvalue) {
		super(String.format("%s not found with %s : %s " , resourseName,fieldName,fieldvalue));
		this.resourseName = resourseName;
		this.fieldName = fieldName;
		this.fieldvalue = fieldvalue;
	}
	
	
	
}
