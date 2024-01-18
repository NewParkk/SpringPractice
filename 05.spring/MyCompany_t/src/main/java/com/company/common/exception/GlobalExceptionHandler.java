package com.company.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//비동기 처리시 @RestControllAdvice

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler (NullPointerException.class)
	public String catchNPE(Exception e) {
		
		return "error";
	}	
}
