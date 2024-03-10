package com.in.pradip.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Global Exception Handler
@RestControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<ErrorInfo> handleUserNotFoundException(Exception e){
		  String exMsg = e.getMessage();
		  
		  ErrorInfo info = new ErrorInfo();
		  info.setMsg(exMsg);
		  info.setCode("SBIEX0001");
		  info.setWhen(LocalDateTime.now());
		  
		  return new ResponseEntity<ErrorInfo>(info,HttpStatus.BAD_REQUEST);  
	}
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorInfo> handleException(Exception e){
		  String exMsg = e.getMessage();
		  
		  ErrorInfo info = new ErrorInfo();
		  info.setMsg(exMsg);
		  info.setCode("SBIEX0003");
		  info.setWhen(LocalDateTime.now());
		  
		  return new ResponseEntity<ErrorInfo>(info,HttpStatus.INTERNAL_SERVER_ERROR);  
	}
}
