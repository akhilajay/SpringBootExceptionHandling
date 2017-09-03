/**
 * 
 */
package com.akhil.Exceptionhandling.exception;

import javax.persistence.EntityNotFoundException;
import javax.persistence.NonUniqueResultException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.akhil.Exceptionhandling.error.CustomException;

/**
 * @author akhilajay
 *
 */
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		//return handleExceptionInternal(ex, null, headers, status, request);
		
		ServletWebRequest servletWebRequest = (ServletWebRequest) request;
		System.out.println("HTTP Method :"+servletWebRequest.getHttpMethod());
		System.out.println("API is ::"+servletWebRequest.getRequest().getServletPath());
		final String message= "Mal Formed Json";
		return handleException(new CustomException(HttpStatus.BAD_REQUEST, message) );
	}
	
	private ResponseEntity<Object> handleException(CustomException error){
		return new ResponseEntity<>(error,error.getStatus());
	}
	
	@ExceptionHandler(NonUniqueResultException.class)
	protected ResponseEntity<Object> customNonUniqueResultException(NonUniqueResultException ex){
		String message="More than one result found";
		return handleException(new CustomException(HttpStatus.CONFLICT, message) );
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	protected ResponseEntity<Object> customEntityNotFoundException(EntityNotFoundException ex){
		String message="Item not found";
		return handleException(new CustomException(HttpStatus.NOT_FOUND, message) );
	}
	

}
