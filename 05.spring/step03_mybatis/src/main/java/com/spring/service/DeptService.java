package com.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.Dept;
import com.spring.dto.Emp;
import com.spring.mapper.DeptMapper;

@Service
public class DeptService {
	
	@Autowired
	DeptMapper deptMapper;
	
	public List<Dept> getDeptList() {
		
		return deptMapper.getDeptList();
	}

	public Dept getDeptByDeptno(int deptno) {
		return deptMapper.getDeptByDeptno(deptno);
	}

	public String getDnameByDeptno(int deptno) {
		return deptMapper.getDnameByDeptno(deptno);
	}

	public String getDnameByDeptnoAndLoc(int deptno, String loc) {
		return deptMapper.getDnameByDeptnoAndLoc(deptno,loc);
	}

	public String getDnameByDeptnoAndLocUsingMap(Map<String, Object> hashmap) {
		return deptMapper.getDnameByDeptnoAndLocUsingMap(hashmap);
	}

	public List<HashMap<String, Object>> getDeptListMap() {
		return deptMapper.getDeptListMap();
	}

	public HashMap<String, Object> getDeptEmpMap(int empno) {
		return deptMapper.getDeptEmpMap(empno);
	}

	public int insertDept(Dept newDept) {
		return deptMapper.insertDept(newDept);
	}

	public int updateLoc(int deptno, String loc) {
		return deptMapper.updateLoc(deptno,loc);
	}

	public int deleteLoc(int deptno) {
		return deptMapper.deleteLoc(deptno);
	}

	public Emp getEmpBydeptno(int deptno) {
		return deptMapper.getEmpBydeptno(deptno);
	}

	
	
	
	
	
	
}