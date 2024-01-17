package com.spring.advice;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	// v3
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public String bizExceptionHandler(Exception e, Model model) {
		String view = "errors/error";
		// exception 객체를 error.jsp에서 활용하려면?
		model.addAttribute("exception", e);
		
		return view;
	}
}
