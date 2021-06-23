package com.ust.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class GlobalExceptionHandler {
	@Autowired
	 private ExceptionResponse exp;

	 @ExceptionHandler(value = EmployeeNotFoundException.class)
	 public ResponseEntity<Object> employeeNotFoundException(EmployeeNotFoundException ex) {
	  exp.setMessage(ex.getMessage());
	  exp.setError("Internal Server Error");
	  
	  return new ResponseEntity<>(exp, HttpStatus.NOT_FOUND);
	 }
	 
	}
