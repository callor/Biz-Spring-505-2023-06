package com.callor.address.dao;

import java.util.List;

import com.callor.address.models.HobbyByAidVO;

public interface HobbyDao {
	public List<HobbyByAidVO> findHobbyByAID(String aid);
}
