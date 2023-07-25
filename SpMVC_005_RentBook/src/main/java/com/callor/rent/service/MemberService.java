package com.callor.rent.service;

import java.util.List;

import com.callor.rent.models.MemberDto;

public interface MemberService {
	
	public int insert(MemberDto memberDto) throws Exception;
	public String getNewCode();
	public List<MemberDto> selectAll();

}
