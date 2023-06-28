package com.callor.address;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/*
 * Controller class
 * @Controller Annotation 이 부착된 class
 * Client 로 부터 Request(요청)이 다다르면, 어디로 요청을 전달할지
 * Routing 역할을 하는 class
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	/*
	 * localhost:8080/address/insert 로 요청이 오면
	 * addr/input.jsp 파일을 열어서 Response 하도록 method 생성
	 */
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert(Model model) {
		model.addAttribute("BODY","INPUT");
		return "home";
	}

	
	@RequestMapping(value="/insert/test",method=RequestMethod.GET)
	public String insert() {
		return "addr/input";
	}
	
	
	
	
	
	
	
}
