package com.spring.schedule;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
public class PrintTask {
	
	@Scheduled(cron = "0/5 * * * * *")
	public void printMethod() {
		System.out.println("scheduled print method");
	}
	
	// x -> db + 파일서버 -!!> file : deptno -> null
	// dept del
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
