/**
 * 
 */
package com.akhil.Exceptionhandling.error;

import org.springframework.http.HttpStatus;

/**
 * @author akhil
 * Simple class to handle exception message
 */
public class CustomException {

	public CustomException(HttpStatus badRequest, String message) {
		super();
		this.status = badRequest;
		this.message = message;
	}

	private HttpStatus status;
	private String message;
	

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
