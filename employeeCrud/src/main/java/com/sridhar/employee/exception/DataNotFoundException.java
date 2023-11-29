package com.sridhar.employee.exception;

public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	String message = "Data Not Found";

	public DataNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public DataNotFoundException(String message) {
		this.message = message;
	}

}
