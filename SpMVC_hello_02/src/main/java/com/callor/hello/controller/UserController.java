package com.callor.hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.models.UserDto;
import com.callor.hello.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {

	@Autowired
	protected UserService userService;

//	public UserController() {
//		userService = new UserServiceImplV1();
//	}
	
	@RequestMapping(value="/user/list",method=RequestMethod.GET)
	public String userList(Model model) {
		List<UserDto> userList = userService.selectAll();
		model.addAttribute("USERS",userList);
		return "user/list";
	}
	
	@RequestMapping(value="/user/input",method=RequestMethod.GET)
	public String userInput() {
		return "user/input";
	}
	
	@RequestMapping(value="/user/input",method=RequestMethod.POST)
	public String userInput(UserDto userDto) {
		log.debug(userDto.toString());
		return null;
	}
	
	
}






