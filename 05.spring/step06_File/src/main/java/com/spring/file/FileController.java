package com.spring.file;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	
	@RequestMapping(value = "/file-test", method = RequestMethod.GET)
	public String fileTestView() {
		return "fileTest";
	}
	
	@PostMapping(value = "/file-upload")
	public void uploadFile(MultipartFile file) {
		System.out.println("uploadFile");
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		
		// 파일 정보
		// 파일 저장 위치 설정 : savePath - C:\multi\00.spring
		String savePath = "C:\\multi\\00.spring";
		
		// 폴더 생성-> 파일저장
		
		try {
			if (!new File(savePath).exists()) {
				new File(savePath).mkdir();
			}
			file.transferTo(new File(savePath + "\\" + file.getOriginalFilename()));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@GetMapping(value = "/file-download")
	public ResponseEntity<Resource> downloadFile(){
		// 지정 경로의 특정 파일 선택 -> resource로 변경 -> Http Header 컨텐츠의 타입 지정 후 전달 
		// data, headers, status
		return new ResponseEntity<Resource>(null, null, null);
	}
}
