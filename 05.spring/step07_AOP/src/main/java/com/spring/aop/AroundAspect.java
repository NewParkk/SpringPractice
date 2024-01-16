package com.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundAspect {
	
	@Around("execution(* com.spring.biz.BizCar.*(..))")
	public void aroundAspect(JoinPoint joinPoint) {
		// 파라미터
		Object[] parameters = joinPoint.getArgs();
		if (parameters.length >= 1) {
			for (Object parameter : parameters) {
				// 파라미터 타입
				System.out.println(parameter.getClass().getSimpleName());
				// 파라미터 데이터
				System.out.println(parameter);
			}
		}
		
		System.out.println("getTarget() : " + joinPoint.getTarget());
		// Signature : 핵심 타겟 대상
		// 메서드 정보 반환
		Signature signature = joinPoint.getSignature();
		System.out.println("signature : " + signature);
		System.out.println("signature.getName() : " + signature.getName());
		System.out.println("signature.toLongString() : " + signature.toLongString());
		// 
		//Signature.getName() : 호출 메소드명 반환
		//Signature.toLongString() : 호출 메소드의 리턴, 메소드명, 파라미터, 패키지 반환
		
		// ProceedingJoinPoint : 어드바이스/타겟 호출
		ProceedingJoinPoint proceedingJoinPoint = (ProceedingJoinPoint) joinPoint;
		
		try {
			// before
			System.out.println("around : 자동차 구매예정?");
			
			Object returnValue = proceedingJoinPoint.proceed();
			
			// after
			System.out.println("around : 자동차 구매완료");
			
			// return
			System.out.println("around : returnValue - " + returnValue);
			
		} catch (Throwable e) {
//			e.printStackTrace();
			
			// throwing
			System.out.println("around : exception - " + e.getMessage());
		}
	}
		
		
}
	

