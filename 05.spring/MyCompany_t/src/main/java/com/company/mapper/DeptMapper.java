package com.company.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.company.dto.Dept;

@Mapper
public interface DeptMapper {
	
	// List
	public List<Dept> getAllDeptList();

	// 객체 - Dept
	public Dept getDeptByDeptno(int deptno) throws SQLException;
	
	// insert - Dept
	public int insertDept(Dept dept) throws SQLException;
	
	// update - Dept
	public int updateDnameAndLoc(Dept dept) throws SQLException; 

	// delete - dept
	public int deleteDeptByDeptno(int deptno) throws SQLException;
	
	
	public List<Dept> getDeptList();

	
	public List<Dept> getDynamicDeptno(Map<String, Integer> map1) throws SQLException;

	
	public List<Dept> getDynamicChoose(Map<String, String> map2);
	
	
	public List<Dept> getDynamicWhereTrim(Map<String, String> map3);
	
	
	public int updateDynamicSet(Map<String, Object> map4);
	
	// dynamic - getDynamicForeachDeptno
	public List<Dept> getDynamicForeachDeptno(List<Integer> list5);

	public int insertDynamicForeachDeptList(List<Dept> list6);
	
}
