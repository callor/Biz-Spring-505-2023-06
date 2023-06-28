package com.callor.hello.service;

import java.util.List;

import com.callor.hello.models.UserDto;

public interface UserService {
	
	public List<UserDto> selectAll();
	public UserDto findById(String id);
	public int input(UserDto dto);

}
