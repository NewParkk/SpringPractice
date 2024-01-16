package com.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// BizCar 수행시, 공통 사용하는 기능 클래스
@Aspect
@Component
public class NoticeAspect {
//	@Before("execution(* com.spring.biz.BizCar.buy())")
	public void noticeBuyStart() {
		System.out.println("자동차를 구매 예정이신가요?");
	}
	
//	@After("execution(* com.spring.biz.BizCar.buy())")
	public void noticeBuyEnd() {
		System.out.println("자동차 구매를 완료했습니다.");
	}
	
//	@AfterReturning(pointcut = "execution(* com.spring.biz.BizCar.buyReturn())"
//								, returning = "value")
	public void noticeReturnValue(String value) {
		if(value != null) {
			System.out.println(value);
		}
	}
	
//	@AfterThrowing(pointcut = "execution(* com.spring.biz.BizCar.sellMoney(..))"
//								, throwing = "e")
	public void noticeException(Exception e) {
		System.out.println("문제 발생 : " + e.getMessage());
	}
	
}
