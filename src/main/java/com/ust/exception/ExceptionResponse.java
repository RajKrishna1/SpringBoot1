package com.ust.exception;

import org.springframework.stereotype.Component;

@Component
public class ExceptionResponse {
	
	String message;
	 String error;
	 public String getMessage() {
	  return message;
	 }
	 public void setMessage(String message) {
	  this.message = message;
	 }
	 public String getError() {
	  return error;
	 }
	 public void setError(String error) {
	  this.error = error;
	 }
}
