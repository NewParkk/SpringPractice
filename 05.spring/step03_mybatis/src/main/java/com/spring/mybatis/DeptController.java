package com.spring.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.dto.Dept;
import com.spring.dto.Emp;
import com.spring.service.DeptService;

@Controller
public class DeptController {
	
	@Autowired
	DeptService deptService;
	
	@GetMapping(value ="/dept-test")
	public void deptTest() {
		// 1. ArrayList<Dept> getDeptList();
//		List<Dept> deptList;
//		deptList = deptService.getDeptList();
//		System.out.println(deptList);
		
		// 2. getDeptByDeptno();
//		Dept dept = deptService.getDeptByDeptno(30);
//		System.out.println(dept);
		
		// 3. String getDnameByDeptno(30) ??
//		String dname = deptService.getDnameByDeptno(30);
//		System.out.println(dname);
		
		// 4. String getDnameByDeptnoAndLoc(30, "CHICAGO")
//		String dname = deptService.getDnameByDeptnoAndLoc(30, "CHICAGO");
//		System.out.println(dname);
		
		// 5. String getDnameByDeptnoAndLocUsingMap(HashMap<String, Object> hashmap)
//		Map<String, Object> hashmap = new HashMap<String, Object>();
//		hashmap.put("deptno", 30);
//		hashmap.put("loc", "CHICAGO");
//		
//		String dname = deptService.getDnameByDeptnoAndLocUsingMap(hashmap);
//		System.out.println(dname);
		
		// 6. getDeptListMap();
//		System.out.println(deptService.getDeptListMap());
//		List<HashMap<String, Object>> deptListMap = deptService.getDeptListMap();
//		System.out.println(deptListMap);
//		for(HashMap<String, Object> data : deptListMap) {
//			System.out.println(data.get("DEPTNO"));
//		}
		
		
		// 7. getDeptEmpMap(int empno);
//		HashMap<String, Object> deptEmptMap = deptService.getDeptEmpMap(7369);
//		
//		System.out.println(deptEmptMap);
		
		// 8. insertDept(Dept(77, "DEV", "TECH"))
//		int result = deptService.insertDept(new Dept(77, "DEV", "TECH"));
//		System.out.println(result);
		
		// 9. updateLoc(77, "SEOUL")
//		int result = deptService.updateLoc(77, "SEOUL");
//		System.out.println(result);
		
		
		
		// 10. deleteLoc(77)
//		int result = deptService.deleteLoc(77);
//		System.out.println(result);
		
		
		// 11. getEmpBydeptno
		Emp emp = deptService.getEmpBydeptno(30);
		System.out.println(emp);
		
		
		
	}	
}
