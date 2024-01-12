package com.spring.interceptor;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class FirstFilter implements Filter {
    public FirstFilter() {
        System.out.println("FirstFilter : FirstFilter()");
    }
    
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("FirstFilter : init()");
	}
    
	public void destroy() {
		System.out.println("FirstFilter : destroy()");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("FirstFilter : pre-doFilter()");
		
		chain.doFilter(request, response);
		
		System.out.println("FirstFilter : post-doFilter()");
	}
}