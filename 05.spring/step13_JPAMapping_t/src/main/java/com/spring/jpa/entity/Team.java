package com.spring.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	// v2
	// 서로 참조하게하려면 mappedBy / team이 부모클래스이기 떄문에 참조되고있는 "team"매개변수속성 지정
	// 서로 참조시키면 stackOverflow 발생
//	@OneToMany(mappedBy = "team")
//	private List<Member> members = new ArrayList<Member>();
}