package com.callor.address.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.address.models.UserDto;
import com.callor.address.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	protected final UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@RequestMapping(value= {"/", ""},method=RequestMethod.GET) 
	public String home() {
		return null;
	}
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(String error, Model model) {
		model.addAttribute("ERROR", error);
		model.addAttribute("BODY","LOGIN");
		return "home";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(UserDto userDto, HttpSession httpSession) {
		
		String result = userService.userLogin(userDto);
		if(result.equals("OK")) {
			httpSession.setAttribute("USER", userDto);
			return "redirect:/";
		} else {
			return "redirect:/user/login?error=" + result;
		}
		
	}
	
	
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join() {
		return null;
	}
	@RequestMapping(value="/mypage",method=RequestMethod.GET)
	public String mypage() {
		return null;
	}
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout() {
		
		/*
		 * Controller.method() 에서 response 결과인
		 * view 이름을 문자열로 return 하면 /WEB-INF/views/ 폴더에서
		 * 파일을 찾아 rendering 한 후 응답을 한다.
		 * 
		 * 그런데, 문자열이 아니고 null 을 return 하면
		 * 이 method 가 호출된 requestMapping 주소가
		 * view 파일 이름을 대신하게 된다
		 */
		return null;
	}
	


}


