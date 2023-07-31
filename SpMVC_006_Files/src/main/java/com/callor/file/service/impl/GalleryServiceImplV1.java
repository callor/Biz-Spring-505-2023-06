package com.callor.file.service.impl;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.callor.file.dao.FileDao;
import com.callor.file.model.FileDto;
import com.callor.file.service.GalleryService;

@Service
public class GalleryServiceImplV1 implements GalleryService{

	protected final FileDao fileDao;
	public GalleryServiceImplV1(FileDao fileDao) {
		this.fileDao = fileDao;
	}

	@Override
	public List<FileDto> findListByBSeq(Long b_seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(List<FileDto> files, Long b_seq) {
		return fileDao.insert(files, b_seq);
	}
	
	@Bean
	public void create_file_table() {
		try {
			fileDao.create_file_table(null);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
