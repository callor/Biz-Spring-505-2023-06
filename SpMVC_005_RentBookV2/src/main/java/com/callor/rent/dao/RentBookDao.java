package com.callor.rent.dao;

import java.util.List;

import com.callor.rent.models.RentBookVO;

public interface RentBookDao {
	
	public List<RentBookVO> selectAll();
	public RentBookVO findById(long id);
	
	public List<RentBookVO> fineByBCode(String bcode);
	public List<RentBookVO> fineByMCode(String mcode);

	public int insert(RentBookVO dto);
	public int update(RentBookVO dto);
	
	public void create_rent_table(String dumy);
	
	
}
