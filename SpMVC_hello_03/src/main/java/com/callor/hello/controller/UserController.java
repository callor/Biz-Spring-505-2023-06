package com.callor.hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.service.UserService;
import com.callor.hello.service.impl.UserServiceImplV1;

/*
 * client 의 요청을 제일먼저 수신하여 처리하는 클래스
 */
@Controller
@RequestMapping(value="/user")
public class UserController {
	/*
	 * Spring project 에서는 Service 객체를 생성할때
	 * Service 클래스의 생성자를 사용하지 않는다
	 * Service 클래스에 @Service Annotation 을 부착하고
	 * 사용할 Service 객체에 @Autowired Annotation 을 부착한다
	 */
	@Autowired
	protected UserService userService;
//	public UserController() {
//		userService = new UserServiceImplV1();
//	}

	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list() {
		List<String> strList = userService.selectAll();
		return strList.get(0);
	}
	
	// RequestMethod.GET : 데이터나 화면을 보여주는 용도
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join() {
		// views/user/join.jsp 파일을 client 로 보내라
		return "user/join";
	}
	
	// RequestMethod.POST : client 에서 데이터를 보내는 용도
	// client 에서 보낸 데이터를 받는 용도
	// CRUD 에서 Create(Insert)를 하기 위한 데이터를 받는 용도
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(Model model) {
		return null;
	}
	
	
	

}
