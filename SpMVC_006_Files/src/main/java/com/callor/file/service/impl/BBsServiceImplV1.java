package com.callor.file.service.impl;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.file.dao.BBsDao;
import com.callor.file.model.BBsDto;
import com.callor.file.service.BBsService;
import com.callor.file.service.FileService;

@Service
public class BBsServiceImplV1 implements BBsService{

	protected final FileService fileService;
	protected final BBsDao bbsDao;

	public BBsServiceImplV1(FileService fileService, BBsDao bbsDao) {
		this.fileService = fileService;
		this.bbsDao = bbsDao;
	}

	@Override
	public List<BBsDto> selectAll() {
			return bbsDao.selectAll();
	}
	
	/*
	 * @Bean : Component 설정 Annotation
	 * @Bean : 객체를 생성하여 컨테이너에 보관해 달라 라는 요청
	 * 원래 @Bean 의 역할과 달리 TABLE 을 생성하기 위한 코드로 변형
	 */
	@Bean
	public void create_table() {
		try {
			bbsDao.create_bbs_table(null);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void insert(BBsDto bbsDto, MultipartFile b_file, MultipartHttpServletRequest b_files) {
		
		try {
			String fileName = fileService.fileUp(b_file);
			if(!fileName.isBlank()) {
				bbsDto.setB_image(fileName);
				bbsDto.setB_origin_image(b_file.getOriginalFilename());
				bbsDao.insert(bbsDto);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public BBsDto findById(long b_seq) {
		return bbsDao.findById(b_seq);
	}

	/*
	 * 파일포함한 Update 
	 * 1. 새롭게 업로드된 대표 파일과 원래 Table 에 저장된 파일이름 비교
	 * 2. 업로드된 파일과 Table 에 저장된 파일이 서로 다르면
	 * 		업로드된 파일 삭제
	 * 3. 새로운 파일 업로드
	 * 4. 업로드된 새로운 파일정보 Table 저장
	 */
	@Override
	public int update(BBsDto bbsDto, MultipartFile b_file, MultipartHttpServletRequest b_files) {

		String upload_name = b_file.getOriginalFilename();
		long b_seq = bbsDto.getB_seq();
		
		bbsDto = bbsDao.findById(b_seq);
		String old_name = bbsDto.getB_origin_image();
		
		if( !upload_name.isBlank() && !upload_name.equals(old_name)) {
			fileService.delete(bbsDto.getB_image());
			try {
				upload_name = fileService.fileUp(b_file);
				bbsDto.setB_image(upload_name);
				bbsDto.setB_origin_image(b_file.getOriginalFilename());
				bbsDao.update(bbsDto);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			bbsDao.update(bbsDto);
		}
		
		
		return 0;
	}
	
}





