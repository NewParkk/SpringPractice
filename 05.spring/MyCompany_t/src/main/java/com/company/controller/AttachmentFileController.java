package com.company.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.company.dto.AttachmentFile;
import com.company.service.AttachmentFileService;


@Controller
public class AttachmentFileController {

	@Autowired
	private AttachmentFileService fileService;
	
	@GetMapping(value = "/download/file/{fileNo}")
	public ResponseEntity<Resource> downloadFile(@PathVariable long fileNo) {
		
		AttachmentFile attachmentFile = null;
		Resource resource = null;
		try {
			attachmentFile = fileService.getAttachmentFileByFileNo(fileNo);
			System.out.println(attachmentFile);
			Path path = Paths.get(attachmentFile.getFilePath() + "\\" + attachmentFile.getAttachmentFileName());
			resource = new InputStreamResource(Files.newInputStream(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDisposition(ContentDisposition
											.builder("attachment")
											.filename(attachmentFile.getAttachmentOriginalFileName())
											.build());
		
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
}
