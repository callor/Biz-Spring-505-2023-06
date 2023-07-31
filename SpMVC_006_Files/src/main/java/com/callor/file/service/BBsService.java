package com.callor.file.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.file.model.BBsDto;

public interface BBsService {
	public List<BBsDto> selectAll();

	public void insert(BBsDto bbsDto, 
			MultipartFile b_file, 
			MultipartHttpServletRequest b_files);

	public BBsDto findById(long b_seq);

	public int update(BBsDto bbsDto, MultipartFile b_file, MultipartHttpServletRequest b_files);


}
