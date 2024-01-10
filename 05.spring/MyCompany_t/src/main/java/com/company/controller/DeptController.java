package com.company.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.dto.Dept;
import com.company.service.DeptService;

@Controller
public class DeptController {
	
	private static final Logger logger = LoggerFactory.getLogger(DeptController.class);
	
	@Autowired
	private DeptService service;
	
	// /dept/10
	@RequestMapping(value = "/dept/{deptno}", method = RequestMethod.GET)
	public String getDeptByDeptno(@PathVariable int deptno, Model model) throws Exception {
		System.out.println(deptno);
		Dept dept = service.getDeptByDeptno(deptno);
		model.addAttribute("dept", dept);
		System.out.println(dept);
		return "deptDetail";
	}
	
	// /dept
	@RequestMapping(value = "/dept", method = RequestMethod.GET)
	public String insertDeptForm() {
		return "registerDept";
	}
	
	// /dept
	@RequestMapping(value = "/dept", method = RequestMethod.POST)
	public String insertDept() {
		String view = "error";
		return view;
	}
	
	// /modify/dept/10
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String updateDeptForm() throws Exception {
		
		return "updateDept";
	}
	
	// /dept/10
	@RequestMapping(value = "/dept", method = RequestMethod.PUT)
	public String updateDept() throws Exception {
		String view = "error";
		// dname, loc 확인 O
		// deptno로 기존 dept 객체 확인 -> 위에서 확인한 dname, loc 해당 객체 setter
		// 제대로 update가 되었다고 한다면 -> dept/{deptno} detail 페이지로 이동
		
		return view;
	}
	
	// /dept/10
	@RequestMapping(value = "/dept", method = RequestMethod.DELETE)
	public String deleteDept() {
		String view = "error";
		
		return view;
	}
	
}
