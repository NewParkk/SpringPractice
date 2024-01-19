package com.spring.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.jpa.entity.Dept;

@Repository
public interface DeptRepository extends JpaRepository<Dept, Integer> {
	
	// loc LIKE %L%
	List<Dept> findByLocContains(String loc);

	List<Dept> findByDeptnoGreaterThanEqual(Integer deptno);
	
	// 부서명 E 들어간 부서를 반환 쿼리메소드?
	List<Dept> findByDnameLike(String dname); 
	
}
