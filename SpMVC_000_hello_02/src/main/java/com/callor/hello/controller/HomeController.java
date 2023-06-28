package com.callor.hello.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

/*
 * lombok 에서 지원하는 log 객체
 */
@Slf4j
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		/*
		 * Web Application 에서는 Console 에 메시지를 표현할때
		 * System.out.print() 등을 사용하지 않는다
		 * 대신 logger 를 이용하여 메시지를 표현한다
		 */
		log.info("Welcome home! The client locale is {}.", locale);
		return "home";
	}
	
}
