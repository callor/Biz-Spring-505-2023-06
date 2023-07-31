package com.callor.file.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.callor.file.model.FileDto;

public interface FileDao  extends GenericDao<FileDto, Long>{

	// BBS Table 과 연계될 SELECT 문
	@Select("SELECT * FROM tbl_files WHERE f_bseq = #{seq}")
	public List<FileDto> findByBSeq(long seq);
	
	public void create_file_table(String dumy);

	public int insert(
			@Param("list") List<FileDto> files, 
			@Param("b_seq") Long b_seq);
	
}
