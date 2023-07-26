package com.callor.rent.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.callor.rent.models.RentBookVO;
import com.callor.rent.service.RentBookService;

import lombok.extern.slf4j.Slf4j;


/*
 * localhost:8080/rent/rent 또는 localhost:8080/rent/rent/* 로 요청이 들어왔을때
 * 		Browser 에 주소를 입력하거나 nav 항목을 클릭 했을때
 * 
 * 서비스를 제공할 시작점이다
 */
@Controller
@Slf4j
@RequestMapping(value="/rent")

/*
 * Spring 에서 사용할수 있는 Session 은 2가지 종류가 있다
 * HttpSession : Servlet 차원에서 Http Protocol 상에 구현하는 Session
 * 		로그인과 관련된 Session 은 이 클래스를 사용한다
 * SessionAttributes : Spring Framework 차원에서 구현하는 Session
 * 		일반적인 객체등을 Session 에 저장하여
 * 		다양한 기능을 구현하는 목적
 * 
 * Session Server 의 메모리 영역을 일정부분 차지한다
 * 접속자가 많아지면 접속자 만큼 메모리 소모가 일어난다
 * 때문에 Session 는 꼭 필요한 요소에서만 제한적으로 사용하는 것이 좋다
 * Session 을 남발하면, 메모리 누수(leak)와 보안에 치명적인 문제를
 * 		야기할수 있다
 * 
 */
// 지금부터 별도 지시가 있을때까지 RENT_WORK 객체는 지우지 마라
// 서버의 Session 영역에 영구 보관하라
@SessionAttributes("RENT_WORK")
public class RentController {
	
	protected final RentBookService rentService;
	public RentController(RentBookService rentService) {
		this.rentService = rentService;
	}

	/*
	 * GET /context/rent/
	 * GET /context/rent
	 */
	@RequestMapping(value={"/",""},method=RequestMethod.GET)
	public String home(Model model) {
		List<RentBookVO> rBooks = rentService.selectAll();
		model.addAttribute("RBOOKS",rBooks);
		return "rent/home";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String work_book(
			@ModelAttribute("RENT_WORK") RentBookVO rentBookVO ){
		return "rent/work_book";
	}
	
	@RequestMapping(value="/go/member",method=RequestMethod.POST)
	public String work_member(
			@ModelAttribute("RENT_WORK") RentBookVO rentBookVO,Model model) {
		/*
		 * @ModelAttribute 를 사용하지 않을때는 데이터객체를 Model 객체에 담아서
		 * view 로 전달을 해야한다.
		 * 하지만 @ModelAttribute 를 사용하면 자동으로 Model 객체에
		 * 필요한 Attribute 를 자동으로 담아준다
		 */
		//	model.addAttribute("RENT_WORK",rentBookVO);
		return "rent/work_member";
	}

	@RequestMapping(value="/go/complete",method=RequestMethod.POST)
	public String work_complete(
			@ModelAttribute("RENT_WORK") RentBookVO rentBookVO) {
		return "rent/work_complete";
	}

	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String work_insert(
			@ModelAttribute("RENT_WORK") 
			RentBookVO rentBookVO,
			
			SessionStatus session) {
		
		log.debug("전달된 데이터 {}",rentBookVO);
		
		int result = rentService.insert(rentBookVO);

	
		/*
		 * SessionAttributes 에 보관중인 객체(데이터)를 모두 사용한 후에는
		 * 반드시 데이터를 Clear 시키는 절차가 필요하다
		 * 이때 SessionStatus.setComplete() method 를 호출해 주면된다
		 */
		session.setComplete();
		return "redirect:/rent";
	}
	
	/*
	 * method 에 @ModelAttribute("객체") 가 부착되면
	 * 어딘선가 객체가 필요로 할때 자동으로 method 가 실행되고
	 * 객체가 생성되어 주입된다.
	 */
	@ModelAttribute("RENT_WORK")
	public RentBookVO newRentBook() {
		
		// Java 1.8 이후의 날짜, 시간 관련 클래스
		// Java 1.8 이후에서는 Date, Calendar 클래스 보다는 Local** 클래스를
		// Java는 1.8 을 기준으로 이전과 이후를 다른 세대로 구분한다
		// 1.7 이하는 1.x 로 표기 1.8 부터는 8, 9, 10 등으로 표기한다
		// Java 1.2 가 탄생했을때도 1.1과 1.2를 다른세대로 구분하여 Java2 라고
		// 불렀었다
		// 적극 사용하기를 권장
		// LocalDate, LocalTime, LocalDateTime
		
		LocalDateTime localDateTime = LocalDateTime.now();
		LocalDateTime returnDate = localDateTime.plusDays(10);
		
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		// DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		return RentBookVO.builder()
				.rent_date(localDateTime.format(dateFormat))
				.rent_return_date(returnDate.format(dateFormat)).build();
	
	}
	

}
