package com.company.mapper;

import java.sql.SQLException;

import com.company.dto.AttachmentFile;

public interface AttachmentFileMapper {

	int insertAttachmentFile(AttachmentFile attachmentFile) throws SQLException;

	AttachmentFile getAttachmentFileByDeptno(int deptno) throws SQLException;
	
	AttachmentFile getAttachmentFileByFileNo(long fileNo) throws SQLException;

	int deleteAttachmentFileByFileNo(long fileNo) throws SQLException;
	
}
