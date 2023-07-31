package com.callor.file.service;

import java.util.List;

import com.callor.file.model.FileDto;

public interface GalleryService {
	
	public List<FileDto> findListByBSeq(Long b_seq);
	public int insert(List<FileDto> files, Long b_seq);
	public int imgDelete(long f_seq);

}
