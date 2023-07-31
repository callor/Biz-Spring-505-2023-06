package com.callor.file.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.file.model.FileDto;
import com.callor.file.service.FileService;

@Service
public class FileSServiceImplV1 implements FileService{

	protected final String fileUpPath;
	
	public FileSServiceImplV1() {
		this.fileUpPath = "/app/upload";
	}

	@Override
	public String fileUp(MultipartFile file) throws Exception {

		if(file.getOriginalFilename().isEmpty()) {
			return null;
		}
		
		// 파일 업로드할 path 를 File 객체로 생성
		File path = new File(fileUpPath);
		// 업로드할 path 가 없으면
		if(!path.exists()) {
			// 폴더를 생성하라
			path.mkdirs();
		}
		
		String fileName = file.getOriginalFilename();
		String uuid = UUID.randomUUID().toString();
		
		// 업로드할 파일이름에 UUID 를 부착하여 injection 공격 방지
		fileName = String.format("%s-%s", uuid, fileName);
		
		File uploadFile = new File(fileUpPath, fileName);
		// file 에 담긴 파일을 uploadFile 로 서버에 전송
		file.transferTo(uploadFile);
		
		// 새로 생성된 이름을 return
		return fileName;

	}

	@Override
	public List<FileDto> filesUp(MultipartHttpServletRequest files) throws Exception {

		//  form 에서 전달된 멀티파일을 개별 파일로 분해하여 List 에 담기
		List<MultipartFile> fileList = files.getFiles("b_files");
		List<FileDto> resultFile = new ArrayList<>();
		
		// List 에 담긴 개별파일을 서버에 업로드
		for(MultipartFile file : fileList) {
			String resultName = this.fileUp(file) ;
			String originName = file.getOriginalFilename();
			
			FileDto fileDto = FileDto.builder().
							f_origin_image(originName).
							f_image(resultName).build();
			resultFile.add(fileDto);
		}
		return resultFile;
	}

	@Override
	public String delete(String fileName) {

		if(fileName == null || fileName.isBlank()) {
			return null;
		}
		File delFile = new File(fileUpPath, fileName);
		// 파일이 있는지 확인
		if(delFile.exists()) {
			// 파일 삭제
			if(delFile.delete()) {
				return "OK";
			}
		}
		return null;
	}

}
