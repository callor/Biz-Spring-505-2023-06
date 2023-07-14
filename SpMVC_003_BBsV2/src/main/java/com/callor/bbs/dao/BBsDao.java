package com.callor.bbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.bbs.models.BBsDto;

public interface BBsDao {
	
	@Select("SELECT * FROM tbl_bbs ORDER BY b_date DESC, b_time DESC ")
	public List<BBsDto> selectAll();	
	
	public List<BBsDto> findUserSelectLimit();
	
	@Select(" SELECT * "
			+ " FROM tbl_bbs"
			+ "  LEFT JOIN tbl_user "
			+ " 	ON b_username = username "
			+ " WHERE b_seq = #{seq}")
	public BBsDto findById(String seq);

	public int insert(BBsDto bbsDto);

}



