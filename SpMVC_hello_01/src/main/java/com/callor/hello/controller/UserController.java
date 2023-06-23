package com.callor.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * class 를 만들고 @Controller 라는 Annotation 을 부착하면
 * Spring Framework 에서 자동으로 
 * 이 클래스에 Controller 기능을 부여한다
 * 
 * Controller class 는 Web Application 에서 Request 를 가장 먼저
 * 수신하는 객체이다
 * 
 * 이 클래스에 method 를 선언하고 method 에 @Request Annotation 을 
 * 부착하면 Web 의 URL(URI)를 처리하는 method 가 된다
 */
@Controller
public class UserController {
	
	// http://localhost:8080/hello/user/login 으로 Request 를 하면
	// 처리할 method 이다 라는 선언
	
	// method=GET
	// Browser 의 주소창에 URL 을 입력하여 요청
	// 또는 a tag 의 href 에 주소를 연결하여 요청
	// 일반적인 (결과)화면을 요청하거나 할때
	@RequestMapping(value="/user/login",method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	// method=POST
	// form 으로 감싼 input data 를 보낼때 주로 사용
	// form tag의 method 속성을 반드시 POST 로 지정해야 한다
	// 데이터를 서버로 보낼때 사용하는 Request
	
	// client(web)에서 보낸 username 변수, password 변수에
	// 담긴 데이터를 받을때는 method의 매개변수를 설정해 주면된다
	@RequestMapping(value="/user/login",method=RequestMethod.POST)
	public String login(String username, String password, Model model) {
		model.addAttribute("name", username);
		model.addAttribute("password", password);
		return "login_ok";
	}
	
	
	@RequestMapping(value="/user/join",method=RequestMethod.GET)
	public String join() {
		
		/*
		 *  method 에서 String 값을 return 하면
		 *  views 폴더에서 해당 String 의 jsp 파일을 찾아
		 *  rendering 을 실행한다
		 *  
		 *  method 에서 null 값을 return 하면
		 *  views 폴더에서 RequestMapping 과 같은 path 위치에서
		 *  jsp 파일을 찾는다
		 *  /views/user/join.jsp 를 찾는다
		 */
		//  
		// 
		return null;
	}
	

}





