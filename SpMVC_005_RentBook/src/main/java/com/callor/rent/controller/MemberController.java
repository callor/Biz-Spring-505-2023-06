package com.callor.rent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	@RequestMapping(value= {"/",""} ,method=RequestMethod.GET)
	public String home() {
		return "member/home";
	}

}
