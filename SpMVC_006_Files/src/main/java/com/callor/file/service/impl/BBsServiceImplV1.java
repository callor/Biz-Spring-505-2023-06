package com.callor.file.service.impl;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.callor.file.dao.BBsDao;
import com.callor.file.model.BBsDto;
import com.callor.file.service.BBsService;

@Service
public class BBsServiceImplV1 implements BBsService{

	protected final BBsDao bbsDao;
	public BBsServiceImplV1(BBsDao bbsDao) {
		this.bbsDao = bbsDao;
	}

	@Override
	public List<BBsDto> selectAll() {
			return null;
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
	
}
