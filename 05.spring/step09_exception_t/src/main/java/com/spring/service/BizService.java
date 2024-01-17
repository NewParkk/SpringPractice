package com.spring.service;

import org.springframework.stereotype.Service;

@Service
public class BizService {
	
	public String bizMethod() throws Exception {
		// 비즈니스 로직 : service <--> mapper <--> db 반환 가정
		// 예외 발생
		String result = null;
		
		if(result == null) {
			throw new Exception("해당 결과가 존재하지 않습니다.");
		}
		
		return result;
	}
	
}
