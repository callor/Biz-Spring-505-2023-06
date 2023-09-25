package com.callor.hello.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.hello.dao.BBsDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	private final BBsDao bbsDao;
	public HomeController(BBsDao bbsDao) {
		this.bbsDao = bbsDao;
	}
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
	
		log.debug(bbsDao.selectAll().toString());
		return "home";

	}
	
	
	
//	@ResponseBody
//	@RequestMapping(value="/home",method=RequestMethod.GET)
//	public String home() {
//		return "Hello Home";
//	}
	
	
	
	
	
	
	
}
