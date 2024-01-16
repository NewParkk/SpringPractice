package com.company.controller;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.company.dto.AttachmentFile;
import com.company.dto.Dept;
import com.company.service.AttachmentFileService;
import com.company.service.DeptService;

@Controller
public class DeptController {
	
	private static final Logger logger = LoggerFactory.getLogger(DeptController.class);
	
	@Autowired
	private DeptService service;
	
	@Autowired
	private AttachmentFileService fileService;
	
	// /dept/10
	@RequestMapping(value = "/dept/{deptno}", method = RequestMethod.GET)
	public String getDeptByDeptno(@PathVariable int deptno, Model model) {
		Dept dept = null;
		AttachmentFile file = null;
		try {
			dept = service.getDeptByDeptno(deptno);
			file = fileService.getAttachmentFileByDeptno(deptno);
			System.out.println(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("dept", dept);
		model.addAttribute("file", file);
		return "deptDetail";
	}
	
	// /dept
	@RequestMapping(value = "/dept", method = RequestMethod.GET)
	public String insertDeptForm() {
		return "registerDept";
	}
	
	// /dept
	@RequestMapping(value = "/dept", method = RequestMethod.POST)
	// v2
	public String insertDept(@ModelAttribute Dept newDept, 
								MultipartFile file) {
		// file != null : insert dept, file
		// file == null : insert dept
		String view = "error";
		
		boolean deptResult = false;
		boolean fileResult = false;
		try {
			
			deptResult = service.insertDept(newDept);
			
			if(file != null) {
				fileResult = fileService.insertAttachmentFile(file, newDept.getDeptno());
			}
			
			if(deptResult || fileResult) {
				view = "redirect:/main";
				return view;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return view;
		}
		
		return view;
	}
	// v1(without file)
//	public String insertDept(@ModelAttribute Dept newDept) {
//		String view = "error";
//		boolean result = false;
//		try {
//			result = service.insertDept(newDept);
//			System.out.println(result);
//			// page 전환?!
//			// result : true -> main, false -> error
//			
//			if(result) {
//				view = "redirect:/main";
//				return view;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return view;
//		}
//		
//		return view;
//	}
	
	// /modify/dept/10
	@RequestMapping(value = "/modify/dept/{deptno}", method = RequestMethod.GET)
	public String updateDeptForm(@PathVariable int deptno, Model model) throws Exception {
		
		Dept dept = service.getDeptByDeptno(deptno);
		AttachmentFile file = fileService.getAttachmentFileByDeptno(deptno);
		model.addAttribute("dept", dept);
		model.addAttribute("file", file);
		
		
		return "updateDept";
	}
	
	// /dept/10
	@RequestMapping(value = "/dept/{deptno}", method = RequestMethod.POST)
	public String updateDeptDnameAndLoc(@PathVariable int deptno,
										@ModelAttribute Dept newDept) {
		String view = "error";
		
		// 정상 수정 -> /dept/10 GET
		System.out.println(deptno);
		System.out.println(newDept.getDeptno());
		System.out.println(newDept.getDname());
		System.out.println(newDept.getLoc());
		
		
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
	@RequestMapping(value = "/dept/{deptno}", method = RequestMethod.PUT)
	public String updateDept(@PathVariable int deptno,
							@ModelAttribute Dept newDept) throws Exception {
		String view = "error";
		
		System.out.println("PUT");
		
		// 정상 수정 -> /dept/10 GET
		
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
	public String deleteDept(@PathVariable int deptno) throws SQLException, Exception {
		String view = "error";
		boolean result = false;
		
		result = service.deleteDeptByDeptno(deptno);
		
		if(result) {
			view = "redirect:/main";
			return view;
		}
		return view;
	}
	
}
