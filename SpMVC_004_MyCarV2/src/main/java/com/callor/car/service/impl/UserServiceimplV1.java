package com.callor.car.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.car.persistance.UserDao;
import com.callor.car.service.UserService;

@Service
public class UserServiceimplV1 implements UserService{

	protected final UserDao userDao;
	public UserServiceimplV1(UserDao userDao) {
		this.userDao = userDao;
	}

	@Autowired
	public void create_table() {
		try {
			userDao.create_user_table();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}





