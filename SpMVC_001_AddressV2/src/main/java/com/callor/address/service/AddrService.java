package com.callor.address.service;

import java.util.List;

import com.callor.address.models.AddrDto;

/*
 * Service Spring Project 에서 비즈니스 로직을 담당하는 부분
 * Controller 에서 데이터를 받고, 
 * 		비즈니스로직(일부 데이터를 가공)하여 Dao 로 전달
 * Dao 에서 return 데이터를 받고, 
 * 		비즈니스로직(일부 데이터를 가공)하여 Controller 로 전달
 */
public interface AddrService {

	public List<AddrDto> selectAll();
	public AddrDto findById(String id);
	
	public String idCheck(String id);
	
	public List<AddrDto> findByName(String name);
	public List<AddrDto> findByTel(String Tel);
	
	public int insert(AddrDto addrDto);
	public int update(AddrDto addrDto);
	public int delete(String id);
	
}
