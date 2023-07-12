package com.callor.bbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.bbs.models.BBsDto;

public interface BBsDao {
	
	@Select("SELECT * FROM tbl_bbs ORDER BY b_date DESC, b_time DESC ")
	public List<BBsDto> selectAll();	
	
	public List<BBsDto> findUserSelectLimit();
	
	@Select(" SELECT * "
			+ " FROM tbl_bbs,tbl_user "
			+ " WHERE b_username = username AND b_seq = #{seq}")
	public BBsDto findById(String seq);

}



