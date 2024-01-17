package com.company.controller;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.dto.Dept;
import com.company.mapper.DeptMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class DynamicController {
	
	private final DeptMapper deptmapper;
	
	@GetMapping("/api/test")
	public String test() {
		return "test";
	}
	
	@GetMapping("/api/dynamic-sql")
	public Object getAPIDynamicSQL() throws SQLException {
		Object result = null;
		
		// getDynamicDeptno
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		map1.put("deptno", null);
		
		List<Dept> result1 = deptmapper.getDynamicDeptno(map1);
		result = result1;
		
		
		// getDynamicChoose
		// SELECT * FROM dept WHERE dname = "SALES" OR loc = "DALLAS" 
		// Choose : 첫번째 혹은 두번째중에서 첫번째로 만족하는 결과만 가져오는 동적 SQL
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("dname", "SALES");
		map2.put("loc", "DALLAS");
		
		List<Dept> result2 = deptmapper.getDynamicChoose(map2);
		result = result2;
		
		// getDynamicWhereTrim
		Map<String, String> map3 = new HashMap<String, String>();
		map3.put("dname", "SALES");
		map3.put("loc", "DALLAS");
		List<Dept> result3 = deptmapper.getDynamicWhereTrim(map3);
		result = result3;
		
		
		// set
		// UPDATE dept SET dname="DEV", loc = "LA" WHERE deptno = 40
		// updateDynamicSet
		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("deptno", 40);
		map4.put("dname", "DEV");
		map4.put("loc", "LA");
		
		result = deptmapper.updateDynamicSet(map4);
		
		// foreach : SELECT, UPDATE, DELETE
		// SELECT * FROM dept WHERE deptno IN (10, 20, 30)
		// getDynamicForeachDeptno 
		List<Integer> list5 = Arrays.asList(10, 20, 30);
		result = deptmapper.getDynamicForeachDeptno(list5);
		
		
		
		// foreach : INSERT
		/*
		 INSERT INTO dept (deptno, dname, loc) VALUES (deptno, dname, loc),
		 											(deptno, dname, loc)
		 */
		// insertDynamicForeachDeptList
		List<Dept> list6 = Arrays.asList(
										new Dept(14, "IT", "SEOUL"),
										new Dept(15, "DEV", "BUSAN"));
		result = deptmapper.insertDynamicForeachDeptList(list6);
		
		
		return result;
	}
}
