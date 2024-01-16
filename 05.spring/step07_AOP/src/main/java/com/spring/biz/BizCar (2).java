package com.spring.biz;

// 자동차 클래스의 핵심 기능!!!
public class BizCar {
	
	// 
//	public void noticeBuy() {
//		System.out.println("자동차를 구매할건가요?");
//	}
	
	// buy : 구매 메소드
	public void buy() {
		System.out.println("자동차 구매");
	}
	
	// buyMoney : 얼마 주고 구입 했는지 금액 확인 메소드
	public void buyMoney(int money) {
		System.out.println("자동차 구매 금액 : " + money);
	}
		
	// buyReturn : 구매 성공시 동작하는 메소드
	public String buyReturn() {
		return "구매 성공";
	}
	
	// sellMoney : 판매 금액이 1000 이하면 예외 발생
	public void sellMoney(int money) throws Exception {
		if(money <= 1000) {
			throw new Exception("1000 이하로는 판매 금지  : 예외");
		}
	}
	
}
