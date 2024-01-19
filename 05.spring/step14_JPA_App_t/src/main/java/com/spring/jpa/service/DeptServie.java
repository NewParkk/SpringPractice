package com.spring.jpa.service;

import java.util.List;

import com.spring.jpa.entity.Dept;

public interface DeptServie {
	List<Dept> getDeptList();
	
	List<Dept> getDeptByLocContaining(String loc);
	
	List<Dept> getDeptByDeptnoList(List<Integer> deptno);
	
	List<Dept> getDeptByDeptnoGTE(Integer deptno);
	
	List<Dept> getDeptByDnameLike(String dname);
}
