package com.spring.pagination.controller;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.pagination.dto.Notice;
import com.spring.pagination.dto.PageRequestDTO;
import com.spring.pagination.dto.PageResponseDTO;
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
		
		
		List<Notice> noticeList = noticeMapper.getNoticeBySearchKeyword(searchKeyword);
		
		model.addAttribute("noticeList",noticeList);
		
		return "search";
	}
	
//	@GetMapping("/page")
//	public String basicPagination(PageRequestDTO pageRequest, 
//									Model model) {
//		System.out.println(pageRequest);
//		
//		List<Notice> noticeList = noticeMapper.getNoticeByPage(pageRequest);
//		
//		// "pageInfo" : pageResponse
//		
//		int totalCount = noticeMapper.getTotalCount();
//		
//		PageResponseDTO pageResponse = new PageResponseDTO().builder()
//														.total(totalCount)
//														.pageAmount(pageRequest.getAmount())
//														.pageRequest(pageRequest)
//														.build();
//		
////		System.out.println(pageResponse);
//		
//		model.addAttribute("noticeList",noticeList);
//		model.addAttribute("pageInfo",pageResponse);
//		
//		
//		
//		return "pagination";
//	}
	
	
	@GetMapping(value = "/main")
	public String searchWithPage(PageRequestDTO pageRequest,
									Model model) {
		System.out.println(pageRequest);
		
		List<Notice> noticeList = noticeMapper.getNoticeBySearchWithPage(pageRequest);
		
		int totalCount = noticeMapper.getTotalCount(pageRequest);
		
		PageResponseDTO pageResponse = new PageResponseDTO().builder()
									.total(totalCount)
									.pageAmount(pageRequest.getAmount())
									.pageRequest(pageRequest)
									.build();
		
		
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("pageInfo", pageResponse);
		
		return "main";
	}
}
