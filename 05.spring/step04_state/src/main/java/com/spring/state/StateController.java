package com.spring.state;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.spring.status.dto.User;

@Controller
@SessionAttributes(value = {"grade"})
public class StateController {

	@GetMapping(value = "/cookie-test")
	public String cookieTest(@CookieValue("id") String id) {
		System.out.println(id);
		
		// 쿠키 삭제 : 1)같은 name, null -> 2) setMaxAge(0) -> 3) response에 담아 사용
		
		return "cookieView";
	}
	
	
	// controller 외부에서 생성된 session 접근시
	// @SessionAttribute를 매개변수로
	@GetMapping(value = "/session-test1")
	public String sessionTest(HttpSession session) {
		session.setAttribute("grade", "junior");
		
		return "sessionView";
	}
	
	@GetMapping(value = "/grade-delete")
	public String sessiondelete(SessionStatus status) {
		
		// v1
//		매개변수로 HttpSession session
//		System.out.println(session.getAttribute("grade"));
//		session.removeAttribute("grade");
		
		// v2
//		매개변수로 SessionStatus status
//		@SessionAttribues annotation 사용
		status.setComplete();
		System.out.println(status.isComplete());
		
		return "sessionView";
	}
	
	
	@GetMapping(value = "/session-test2")
	public String sessionTest2(@ModelAttribute User user, Model model) {
		model.addAttribute("user", user);
		System.out.println(user);
		return "userView";
	}
	
	@GetMapping(value = "/user-delete")
	public String usersessiondelete(SessionStatus status) {
		status.setComplete();
		
		return "userView";
	}
	
	
}
