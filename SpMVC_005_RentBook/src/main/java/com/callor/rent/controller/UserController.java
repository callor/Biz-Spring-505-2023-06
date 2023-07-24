package com.callor.rent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return "user/login";
	}

}





