package com.sridhar.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sridhar.employee.helper.ResponseStructure;

@RestControllerAdvice
public class MainExceptionHandler {
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> exceptionHandle(DataNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("There is an Exception");
		structure.setData(exception.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
}
