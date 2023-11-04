package com.api.validation;

import java.util.List;

public class ValidationResponse {

	private String message ;
	private List<String > list;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	
	public ValidationResponse(String message, List<String> list) {
		super();
		this.message = message;
		this.list = list;
	}
	
}
