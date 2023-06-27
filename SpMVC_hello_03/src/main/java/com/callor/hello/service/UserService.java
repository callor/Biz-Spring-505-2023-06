package com.callor.hello.service;

import java.util.List;

public interface UserService {
	
	public List<String> selectAll();
	public String findByName(String name);


}
