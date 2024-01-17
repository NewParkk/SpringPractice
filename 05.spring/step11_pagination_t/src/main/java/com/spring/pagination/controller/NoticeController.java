package com.spring.pagination.controller;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.pagination.dto.Notice;
import com.spring.pagination.mapper.NoticeMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class NoticeController {
	
	final NoticeMapper noticeMapper;
	
	@GetMapping("/notice-data")
	public void insertNotice() {
		
		IntStream.rangeClosed(1, 200)
					.forEach(i -> {
						Notice notice = Notice.builder()
												.no(i)
												.userId("userId : " + i)
												.userName("userName : " + i)
												.title("title : " + i)
												.content("content : " + i)
												.hit(i)
												.build();
						
						noticeMapper.insertNotice(notice);
					});
		
	}
	
	@GetMapping("/search")
	public String moveSearch() {
		return "search";
	}
	
	@GetMapping("/search/keyword")
	public String searchKeyword(String searchKeyword,
								Model model) {
		
		
		return "search";
	}
	
}
