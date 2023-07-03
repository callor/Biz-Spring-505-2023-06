package com.callor.address.service;

import com.callor.address.models.UserDto;

public interface UserService {
	
	public UserDto findById(String id);
	
	public String userLogin(UserDto userDto);

	public int userJoin(UserDto userDto);
	

}
