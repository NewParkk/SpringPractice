package com.spring.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.spring.dto.Dept;
import com.spring.dto.Emp;

@Mapper
public interface DeptMapper {
	
	// getDeptList()
	List<Dept> getDeptList();
	
	// getDeptBydeptno()
	Dept getDeptByDeptno(int deptno);
	
	// getDnameByDeptno()
	String getDnameByDeptno(int deptno);
	
	//
	String getDnameByDeptnoAndLoc(@Param("deptno") int deptno,@Param("loc") String loc);
	
	//
	String getDnameByDeptnoAndLocUsingMap(Map<String, Object> hashmap);
	
	//
	List<HashMap<String, Object>> getDeptListMap();
	
	//
	HashMap<String, Object> getDeptEmpMap(int empno);

	//
	int insertDept(Dept dept);

	//
	int updateLoc(@Param("deptno") int deptno, @Param("loc") String loc);
	
	//
	int deleteLoc(int deptno);
	
	//
	Emp getEmpBydeptno(int deptno);
	
}