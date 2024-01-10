package com.company.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.company.dto.Dept;

@Mapper
public interface DeptMapper {
	
	// List
	public List<Dept> getAllDeptList();

	// 객체 - Dept
	public Dept getDeptByDeptno(int deptno);
	
	// insert - Dept
	public int insertDept(Dept dept) throws SQLException;
	
	// update - Dept
	public int updateDnameAndLoc(Dept dept) throws SQLException; 

	// delete - dept
	public int deleteDeptByDeptno(int deptno) throws SQLException;
	
	
	public List<Dept> getDeptList();
	
}
