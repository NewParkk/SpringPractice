package com.company.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.company.dto.Emp;
import com.company.service.EmpService;

@Controller
@SessionAttributes(value = {"emp"})
public class LoginController {
	
	@Autowired
	private EmpService service;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(int empno, String ename,
						HttpSession session) {
		String view = "error";
		Emp emp = null;
		try {
			emp = service.getEmpByEmpnoAndEname(empno, ename);
//			System.out.println(emp);
			
			// 세션: setAttribute("key", value);
			if (emp != null) {
				session.setAttribute("userId", emp.getEmpno());
				session.setAttribute("userName", emp.getEname());
				
				view = "redirect:/main";
				return view;
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return view;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		
		if (session != null) {
			session.invalidate();
		}
		return "redirect:/main";
	}
	
}
