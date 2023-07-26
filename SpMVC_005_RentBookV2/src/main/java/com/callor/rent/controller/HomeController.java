package com.callor.rent.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	/*
	 * localhost:8080/rent 또는 localhost:8080/rent/ 요청을 하는 것
	 * views/home.jsp 파일의 내용을 보여달라 라는 의미
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
}
