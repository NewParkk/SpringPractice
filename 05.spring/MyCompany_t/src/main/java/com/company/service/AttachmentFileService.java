package com.company.service;

import java.io.File;
import java.sql.SQLException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.company.dto.AttachmentFile;
import com.company.mapper.AttachmentFileMapper;

@Service
public class AttachmentFileService {
	
	@Autowired
	AttachmentFileMapper attachmentFileMapper;
	
	// 객체
	public AttachmentFile getAttachmentFileByFileNo(int fileNo) throws SQLException, Exception { 
		AttachmentFile attachmentFile = null;
		
		
		return attachmentFile;
	}
	
	// insert - 
	public boolean insertAttachmentFile(MultipartFile file, int deptno) {
		boolean result = false;
		System.out.println(file);
		try {
		if(file.isEmpty()) {
			return false;
		}
		
		/* 파일을 저장하는 의미
		   1. DB 파일 정보 저장 - attFile 객체 생성 -> mapper -> db 저장
		   2. server에 파일이 실제로 저장  - multipartFile transferTo()
		   3. 파일 저장이 성공 - true / 아니면 - false
		 */
		
		String filePath = "C:\\multi\\00.spring";
		String attachmentOriginalFileName = file.getOriginalFilename();
		UUID uuid = UUID.randomUUID();
		String attachmentFileName = uuid.toString() + "_" + attachmentOriginalFileName;
		Long attachmentFileSize = file.getSize();
		
		AttachmentFile attachmentFile = AttachmentFile.builder()
													.attachmentOriginalFileName(attachmentOriginalFileName)
													.attachmentFileName(attachmentFileName)
													.attachmentFileSize(attachmentFileSize)
													.filePath(filePath)
													.deptno(deptno)
													.build();
													
		int res = attachmentFileMapper.insertAttachmentFile(attachmentFile);
		
		if(res != 0) {
			file.transferTo(new File(filePath + "\\" + attachmentFileName));
			result = true;
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	// 부서번호로 파일 출력
	public AttachmentFile getAttachmentFileByDeptno(int deptno) {
		AttachmentFile attachmentFile = null;
		
		attachmentFile = attachmentFileMapper.getAttachmentFileByDeptno(deptno);
		
		return attachmentFile;
	}

	public AttachmentFile getAttachmentFileByFileNo(long fileNo) {
		AttachmentFile attachmentFile = null;
		
		attachmentFile = attachmentFileMapper.getAttachmentFileByFileNo(fileNo);
		
		return attachmentFile;
	}
}