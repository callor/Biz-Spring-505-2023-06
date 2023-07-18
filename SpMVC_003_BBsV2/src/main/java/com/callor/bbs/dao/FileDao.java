package com.callor.bbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.callor.bbs.models.FileDto;

public interface FileDao {
	
	public int insert(
			@Param("list") List<FileDto> files,
			@Param("b_seq") long b_seq 
			);
	
	public List<FileDto> selectAll();
	
	@Select("SELECT * FROM tbl_images WHERE i_seq = #{id}")
	public FileDto findByid(long id);
	
	// 게시판과 연결할때 사용할 method
	@Select("SELECT * FROM tbl_images WHERE i_bseq = #{b_seq}")
	public List<FileDto> findByBSeq(long b_seq);

	@Delete("DELETE FROM tbl_images WHERE i_seq = #{seqNum}")
	public int delete(long seqNum);

}
