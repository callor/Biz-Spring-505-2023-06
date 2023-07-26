package com.callor.rent.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.callor.rent.models.RentBookVO;

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

// 지금부터 별도 지시가 있을때까지 RENT_WORK 객체는 지우지 마라
// 서버의 Session 영역에 영구 보관하라
@SessionAttributes("RENT_WORK")
public class RentController {
	
	/*
	 * GET /context/rent/
	 * GET /context/rent
	 */
	@RequestMapping(value={"/",""},method=RequestMethod.GET)
	public String home() {
		return "rent/home";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String work_book(
			@ModelAttribute("RENT_WORK") RentBookVO rentBookVO ){
		return "rent/work_book";
	}
	
	@RequestMapping(value="/go/member",method=RequestMethod.POST)
	public String work_member(@ModelAttribute("RENT_WORK") RentBookVO rentBookVO,Model model) {
		model.addAttribute("RENT_WORK",rentBookVO);
		return "rent/work_member";
	}

	@RequestMapping(value="/go/complete",method=RequestMethod.POST)
	public String work_complete(@ModelAttribute("RENT_WORK") RentBookVO rentBookVO) {
		return "rent/work_complete";
	}

	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String work_insert(@ModelAttribute("RENT_WORK") RentBookVO rentBookVO) {
		log.debug("전달된 데이터 {}",rentBookVO);
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
