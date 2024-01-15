package com.spring.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		System.out.println(file);
		
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		
		// 파일 정보
		// 파일 저장 위치 설정 : savePath - C:\multi\00.spring
		String savePath = "C:\\multi\\00.spring";
		
		String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		
		//uuid로 파일식별할 난수생성
//		System.out.println(UUID.randomUUID().toString());
		
		try {
			// 폴더 생성-> 파일저장
			if (!new File(savePath).exists()) {
				new File(savePath).mkdir();
			}
			file.transferTo(new File(savePath + "\\" + fileName));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@GetMapping(value = "/file-download")
	public ResponseEntity<Resource> downloadFile(){
		System.out.println("file.download");
		
		// data
		// 1. 서버에서 해당 파일 선택 -> 2. inputStream -> 3. return
		Path path = Paths.get("C:\\multi\\00.spring\\test.txt");
		Resource resource = null;
		try {
			resource = new InputStreamResource(Files.newInputStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// header : content-type : MediaType.APPLICATION_OCTET_STREAM
		//CONTENT_DISPOSITION
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDisposition(ContentDisposition
											.builder("attachment")
											.filename("test2.txt")
											.build());
		
		
		// status : HttpStatus.OK 
		
		// 지정 경로의 특정 파일 선택 -> resource로 변경 -> Http Header 컨텐츠의 타입 지정 후 전달 
		// data, headers, status
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
}
