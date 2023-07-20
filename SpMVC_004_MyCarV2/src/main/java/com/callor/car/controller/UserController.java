package com.callor.car.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.car.model.UserDto;

/*
 * class scope @RequestMapping 과
 * 		type scope @RequestMapping
 * method scope @RequestMapping 은 분리되어 있으나
 * 실제 호출될때는 두개가 연결 Mapping 으로 사용된다
 * 
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

	// localhost:8080/rootPath/user/login 으로 Request 되었을때
	// 호출되는 method
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(
			@ModelAttribute("USER")
			UserDto userDto) {
		return "user/login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(
			@ModelAttribute("USER")
			UserDto userDto,HttpSession httpSession
			) {
		return "redirect:/";
	}
	
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join(@ModelAttribute UserDto userDto) {
		return "user/join";
	}
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(@ModelAttribute UserDto userDto,Model model) {
		return "user/join";
	}
	
	
	@ModelAttribute("USER")
	public UserDto userDto() {
//		return UserDto.builder().build();
		return new UserDto();
	}
	
	

}
