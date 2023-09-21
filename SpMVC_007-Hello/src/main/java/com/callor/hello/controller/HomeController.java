package com.callor.hello.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
//	@ResponseBody
//	@RequestMapping(value="/home",method=RequestMethod.GET)
//	public String home() {
//		return "Hello Home";
//	}
	
	
	
	
	
	
	
}
