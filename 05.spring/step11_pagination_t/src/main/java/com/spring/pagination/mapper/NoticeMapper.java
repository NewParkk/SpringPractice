package com.spring.pagination.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.pagination.dto.Notice;
import com.spring.pagination.dto.PageRequestDTO;


@Mapper
public interface NoticeMapper {

	// insertNotice
	public Integer insertNotice(Notice notice);
	
	// searchKeyword
	public List<Notice> getNoticeBySearchKeyword(String searchKeyword);
	
	
	// pagination
	public List<Notice> getNoticeByPage(PageRequestDTO pageRequest);
	
	
	// getTotalCount(without keyword) -> getTotalCount(with keyword) 
		public int getTotalCount(PageRequestDTO pageRequest);
		
	// searchKeyword + pagination
	public List<Notice> getNoticeBySearchWithPage(PageRequestDTO pageRequest);
	
}
