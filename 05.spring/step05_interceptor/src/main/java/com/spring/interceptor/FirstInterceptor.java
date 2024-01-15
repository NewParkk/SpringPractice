package com.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class FirstInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("FirstInterceptor : preHandle()");
		System.out.println("URI : " + request.getRequestURI());
		
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		System.out.println("Method : " + handlerMethod.getMethod());
		System.out.println("Bean : " + handlerMethod.getBean());
		System.out.println("ReturnType : " + handlerMethod.getReturnType());
		
		// false : prehandle 내용을 컨트롤러 전달해서 실행하지 않음 
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("FirstInterceptor : postCompletion()");
		
		System.out.println("ViewName : " + modelAndView.getViewName());
		System.out.println("Model : " + modelAndView.getModel());
		System.out.println("Keyset : " + modelAndView.getModel().keySet());
		System.out.println("Values : " + modelAndView.getModel().values());
		System.out.println("Object(\"key\") : " + modelAndView.getModel().get("serverTime"));
		
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("FirstInterceptor : afterCompletion()");
	}
	
}
