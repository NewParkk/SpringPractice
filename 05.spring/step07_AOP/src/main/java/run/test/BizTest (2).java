package run.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.biz.BizCar;

public class BizTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");
		
		BizCar biz = context.getBean("bizCar", BizCar.class);
		
		biz.buy();
	}
}
