package com.company.mapper;

import com.company.dto.AttachmentFile;

public interface AttachmentFileMapper {

	int insertAttachmentFile(AttachmentFile attachmentFile);

	AttachmentFile getAttachmentFileByDeptno(int deptno);
	
	AttachmentFile getAttachmentFileByFileNo(long fileNo);
	
}
