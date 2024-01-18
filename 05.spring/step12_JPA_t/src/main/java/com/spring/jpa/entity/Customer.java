package com.spring.jpa.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
//@Entity
public class Customer {
	@Id
	private String id;
	
	@Column(length = 100)
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date registrationDate;
	
	private String grade;
	
}