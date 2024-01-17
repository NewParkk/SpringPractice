package com.spring.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.service.BizService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BizController {
	
	private final BizService bizService;
	
	@GetMapping(value = "/biz")
	public String bizMethod(Model model) throws Exception {
		String view = "errors/error";
		
		String result;
		// v1
//		try {	
//			result = bizService.bizMethod();
//			model.addAttribute("result", result);
//			view = "result";
//		} catch (Exception e) {
//			model.addAttribute("exception", e);
//		}
		
	
		result = bizService.bizMethod();
		model.addAttribute("result", result);
		view = "result";
		
		return view;
	}
	
	// v2
//	@ExceptionHandler(Exception.class)
//	public String bizExceptionHandler(Exception e, Model model) {
//		String view = "errors/error";
//		// exception 객체를 error.jsp에서 활용하려면?
//		model.addAttribute("exception", e);
//		
//		return view;
//	}
	
	
	
	
	
	
	
}
