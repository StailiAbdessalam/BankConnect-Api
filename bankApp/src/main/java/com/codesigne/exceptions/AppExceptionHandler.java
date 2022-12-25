package com.codesigne.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.codesigne.responses.ErrorMessage;

@ControllerAdvice
public class AppExceptionHandler {
	
	@ExceptionHandler(value = {UserException.class})
	public ResponseEntity<Object> handlerUserException(UserException ex,WebRequest request){
		ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage());
		return new ResponseEntity<>(errorMessage , new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handlerOthersException(Exception ex,WebRequest request){
		ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage());
		return new ResponseEntity<>(errorMessage , new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
