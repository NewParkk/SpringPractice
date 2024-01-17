package com.spring.pagination.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.pagination.dto.Notice;


@Mapper
public interface NoticeMapper {

	// insertNotice
	public Integer insertNotice(Notice notice);
	
	// searchKeyword
	public List<Notice> getNoticeBySearchKeyword(String searchKeyword);
	
}
