package com.spring.jpa.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.entity.Dept;
import com.spring.jpa.service.DeptServiceImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class DeptApiController {
	
	private final DeptServiceImpl deptservice;
	
	
	@GetMapping(value = "/api-test")
	public String apiTest() {
		return "test";
	}
	
	@GetMapping(value = "/dept")
	public List<Dept> getDeptList() {
		List<Dept> deptList = new ArrayList<Dept>();
		
		deptList = deptservice.getDeptList();
		
		return deptList;
	}
	
	@GetMapping(value = "/search")
	public List<Dept> getDeptByLocContaining(@RequestParam(required = false) String loc) {
		
		List<Dept> deptList = new ArrayList<Dept>();
		
//		deptList = deptservice.getDeptByLocContaining(loc);
		
		// 부서번호 10, 15, 20, 25, 30 검색하는 쿼리메소드
//		List<Integer> deptno = Arrays.asList(10, 15, 20, 25, 30);
//		deptList = deptservice.getDeptByDeptnoList(deptno);
		
//		Integer deptno = 35;
//		deptList = deptservice.getDeptByDeptnoGTE(deptno);
		
		String dname = "%E%";
		deptList = deptservice.getDeptByDnameLike(dname);
		
		return deptList;
	}
	
	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
