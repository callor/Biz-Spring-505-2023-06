package com.callor.car.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.callor.car.model.UserDto;
import com.callor.car.service.UserService;

import lombok.extern.slf4j.Slf4j;

/*
 * class scope @RequestMapping 과
 * 		type scope @RequestMapping
 * method scope @RequestMapping 은 분리되어 있으나
 * 실제 호출될때는 두개가 연결 Mapping 으로 사용된다
 * 
 */
@SessionAttributes("USER")
@Slf4j
@Controller
@RequestMapping(value = "/user")
public class UserController {

	protected final UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}

	
	// localhost:8080/rootPath/user/login 으로 Request 되었을때
	// 호출되는 method
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(
			@RequestParam(name = "ERROR",required = false) String error,
			@ModelAttribute("USER")
			UserDto userDto,Model model) {
		
		model.addAttribute("ERROR",error);
		return "user/login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(
			@ModelAttribute("USER")
			UserDto userDto,
			HttpSession httpSession,
			SessionStatus sessionStatus
			) {
		
		try {
			UserDto resultDto = userService.login(userDto);
			httpSession.setAttribute("LOGINUSER", resultDto);
		} catch (Exception e) {
			// new Exception(message) 라고 보낸 Exception 에서
			// message 에 해당하는 부분 getter 하기
			String message = e.getMessage();
			return "redirect:/user/login?ERROR=" + message;
		}
		// 현재 SessionAttributes 에 저장된 USER 정보 제거(DROP)
		sessionStatus.setComplete();
		return "redirect:/";
		
	}
	
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join(@ModelAttribute UserDto userDto) {
		return "user/join";
	}
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(
			@ModelAttribute("USER") 
			UserDto userDto,Model model,SessionStatus sessionStatus) {
		log.debug("회원가입 정보 : {}",userDto);
		
		int result = userService.join(userDto);
		sessionStatus.setComplete();
		return "redirect:/user/login";
	
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		httpSession.removeAttribute("LOGINUSER");
		return "redirect:/";
	}
	
	@ModelAttribute("USER")
	public UserDto userDto() {
//		return UserDto.builder().build();
		return new UserDto();
	}
	
	

}
