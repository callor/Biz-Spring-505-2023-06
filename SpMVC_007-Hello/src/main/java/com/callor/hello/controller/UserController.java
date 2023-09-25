package com.callor.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	// GET: http://localhost:8080/hello/user/login
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {

		 return null;
		// return "user/login";
		// views/user/login.jsp 파일을 rendering 하여 Response 하라
	}

}
