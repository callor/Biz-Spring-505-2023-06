package com.callor.address.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.address.models.AddrDto;

public interface AddrDao {
	
	@Select("SELECT * FROM tbl_address ORDER BY a_id")
	public List<AddrDto> selectAll();
	
	/*
	 * Dto return 할 때와 List return 할 때
	 * 만약 찾는 값이 없으면
	 * 		Dto return 할때는 null 값
	 *  	List return 할때는 empty 값
	 *  값이 있는 없는지 검사할때
	 *  	Dto return if(dto == null)
	 *  	List return if(list.isEmpty())
	 */
	
	@Select("SELECT * FROM tbl_address WHERE a_id = #{id}")
	public AddrDto findById(String id);
	
	@Select("SELECT * FROM tbl_address "
			+ " WHERE a_name LIKE '%' || #{name} || '%' ")
	public List<AddrDto> findByName(String name);

	
}




