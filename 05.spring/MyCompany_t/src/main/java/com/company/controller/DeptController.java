package com.company.controller;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
//		System.out.println(deptno);
		Dept dept = service.getDeptByDeptno(deptno);
		model.addAttribute("dept", dept);
		if (dept == null || dept.equals("")) {
			String view = "error";
			return view;
		}
//		System.out.println(dept);
		return "deptDetail";
	}
	
	// /dept
	@RequestMapping(value = "/dept", method = RequestMethod.GET)
	public String insertDeptForm() {
		return "registerDept";
	}
	
	// /dept
	@RequestMapping(value = "/dept", method = RequestMethod.POST)
	public String insertDept(@ModelAttribute Dept newDept) {
		String view = "error";
		boolean result  = false;
//		System.out.println(newDept);
		try {
			result = service.insertDept(newDept);
			System.out.println(result);
			if (result) {
				view = "redirect:/main";
				return view;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return view;
	}
	
	// /modify/dept/10
	@RequestMapping(value = "/modify/dept/{deptno}", method = RequestMethod.GET)
	public String updateDeptForm(@PathVariable int deptno, Model model) throws Exception {
		
		Dept dept = service.getDeptByDeptno(deptno);
		model.addAttribute("dept", dept);
		
		return "updateDept";
	}
	
	// /dept/10
	@RequestMapping(value= "/dept/{deptno}", method = RequestMethod.POST)
	public String updateDeptDnameAndLoc(@PathVariable int deptno,
										@ModelAttribute("dname") String dname,
										@ModelAttribute("loc") String loc) {
		String view ="error";
		
		// 정상 수정 -> /dept/10 GET
		System.out.println(dname);
		System.out.println(loc);
		
		
		Dept dept = null;
		boolean result = false; 
		try {
			dept = service.getDeptByDeptno(deptno);
			
			dept.setDname(dname);
			dept.setLoc(loc);
			
			result = service.updateDnameAndLoc(dept);
			System.out.println(result);
			System.out.println(deptno);
			if (result) {
				view = "redirect:/dept/" + deptno;
				return view;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return view;
		}
		return view;
	}
//	@RequestMapping(value = "/dept/{deptno}", method = RequestMethod.POST)
//	public String updateDeptDnameAndLoc(@PathVariable int deptno,
//										@ModelAttribute Dept newDept) {
//		String view = "error";
//		
//		// 정상 수정 -> /dept/10 GET
//		System.out.println(deptno);
//		System.out.println(newDept.getDeptno());
//		System.out.println(newDept.getDname());
//		System.out.println(newDept.getLoc());
//		
//		
//		Dept dept = null;
//		boolean result = false;
//		try {
//			dept = service.getDeptByDeptno(deptno);
//			
//			dept.setDname(newDept.getDname());
//			dept.setLoc(newDept.getLoc());
//			
//			result = service.updateDnameAndLoc(dept);
//			
//			if(result) {
//				view = "redirect:/dept/" + deptno;
//				return view;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return view;
//		}
//		return view;
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	// /dept/10
	@RequestMapping(value = "/dept/{deptno}", method = RequestMethod.PUT)
	public String updateDept(@PathVariable int deptno,
							 @ModelAttribute Dept newDept) throws Exception {
		String view = "error";
		// dname, loc 확인 O
		// deptno로 기존 dept 객체 확인 -> 위에서 확인한 dname, loc 해당 객체 setter
		// 제대로 update가 되었다고 한다면 -> dept/{deptno} detail 페이지로 이동
		Dept dept = null;
		boolean result = false;
		try {
			dept = service.getDeptByDeptno(deptno);
			
			dept.setDname(newDept.getDname());
			dept.setLoc(newDept.getLoc());
			
			result = service.updateDnameAndLoc(dept);
			
			if(result) {
				view = "redirect:/dept/" + deptno;
				return view;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return view;
		}
		return view;
	}
	
	// /dept/10
	@RequestMapping(value = "/dept/{deptno}", method = RequestMethod.DELETE)
	public String deleteDept(@PathVariable int deptno,
			 				 @ModelAttribute Dept newDept) {
		String view = "error";
		Dept dept =  null;
		boolean result = false;
		
		try {	
			dept = service.getDeptByDeptno(deptno);
			
			result = service.deleteDeptByDeptno(deptno);
			if(result) {
				view = "redirect:/main";
				return view;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return view;
		}
			return view;
		}
		
}
