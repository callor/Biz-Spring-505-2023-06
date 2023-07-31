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
	
}





