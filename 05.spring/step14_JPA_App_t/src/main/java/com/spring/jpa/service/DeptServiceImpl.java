package com.spring.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.jpa.entity.Dept;
import com.spring.jpa.repository.DeptRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DeptServiceImpl implements DeptServie{

	private final DeptRepository deptRepository;
	
	
	@Override
	public List<Dept> getDeptList() {
		List<Dept> deptList = new ArrayList<Dept>();
		
		deptList = deptRepository.findAll();
		
		
		return deptList;
	}

	@Override
	public List<Dept> getDeptByLocContaining(String loc) {
		
		List<Dept> deptList = deptRepository.findByLocContains(loc);
		
		return deptList;
	}


	@Override
	public List<Dept> getDeptByDeptnoGTE(Integer deptno) {
		
		List<Dept> deptList = deptRepository.findByDeptnoGreaterThanEqual(deptno);
		
		return deptList;
	}

	@Override
	public List<Dept> getDeptByDeptnoList(List<Integer> deptno) {
		return null;
	}

	@Override
	public List<Dept> getDeptByDnameLike(String dname) {
		List<Dept> deptList = deptRepository.findByDnameLike(dname);
		return deptList;
	}
	
}
