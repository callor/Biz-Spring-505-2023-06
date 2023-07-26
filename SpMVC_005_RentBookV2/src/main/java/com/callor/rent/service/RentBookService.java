package com.callor.rent.service;

import java.util.List;

import com.callor.rent.models.RentBookVO;

public interface RentBookService {

	public int insert(RentBookVO rentBookVO);

	public List<RentBookVO> selectAll();

}
