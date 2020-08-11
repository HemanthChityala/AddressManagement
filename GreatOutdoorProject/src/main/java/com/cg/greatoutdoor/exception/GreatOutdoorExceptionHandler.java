package com.cg.greatoutdoor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GreatOutdoorExceptionHandler {
	@ExceptionHandler(value=AddressNotFoundException.class)
	public ResponseEntity<Object> handleException(AddressNotFoundException exception){
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(value=IdNotFoundException.class)
	public ResponseEntity<Object> handleException1(IdNotFoundException exception){
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(value=AddressServiceException.class)
	public ResponseEntity<Object> handleException3(AddressServiceException exception){
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	

}