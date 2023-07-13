package com.callor.bbs.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.bbs.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FileServiceImplV1 implements FileService {

	// 서버의 폴더 등 자원(Resource)에 접근할때 사용할 객체
	protected final ResourceLoader resourceLoader;
	protected final String filePath;
	public FileServiceImplV1(ResourceLoader resource) {
		this.resourceLoader = resource;
		this.filePath = "/files";
	}

	@Override
	public String fileUp(MultipartFile file) throws Exception {

		// filePath : /files
		// /webapp/files 폴더에 대한 정보를 가지고 있는 객체가 된다
		// /webapp 폴더는 단순한 방법으로 정보를 가져올수 없다
		// 그래서 ResourceLoader 라는 객체를 사용하여
		// 관련 정보를 가져온다
		Resource  res = resourceLoader.getResource(filePath);
		
		// Tomcat / Project 서버의 files 라는 폴더 정보
		// 파일을 업로드할 폴더이름을 savePath 변수에 저장하기
		String savePath = res.getURI().getPath();
		
		// 업로드할 파일 이름
		String originalFileName = file.getOriginalFilename();

		// Tomcat / Project 서버의 files 폴더와 파일이름을 사용하여
		// File(upLoadFile) 이라는 객체를 생성한다
		File upLoadFile = new File(savePath, originalFileName); 
		
		log.debug(upLoadFile.getAbsolutePath());
		
		// MultipartFile 아 upLoadFile 정보를 참조하여
		// 서버로 파일을 전송(복사)하라
		file.transferTo(upLoadFile);
		
		return originalFileName;

	}

	@Override
	public List<String> filesUp(MultipartHttpServletRequest files) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

}
