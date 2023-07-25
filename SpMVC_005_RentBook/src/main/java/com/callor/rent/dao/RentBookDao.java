package com.callor.rent.dao;

import java.util.List;

import com.callor.rent.models.RentBookDto;

public interface RentBookDao {
	
	public List<RentBookDto> selectAll();
	public RentBookDto findById(long id);
	
	public List<RentBookDto> fineByBCode(String bcode);
	public List<RentBookDto> fineByMCode(String mcode);

	public int insert(RentBookDto dto);
	public int update(RentBookDto dto);
	
}
