package com.callor.car.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.car.model.CarDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(
			@ModelAttribute("CAR")
			CarDto carDto) {
		log.debug("나는 홈 콘트롤러 입니다");
		return "home";
	}

	@ModelAttribute("CAR")
	public CarDto carDto() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		
		String strDate = dateFormat.format(date);
		String strTime = timeFormat.format(date);
		CarDto carDto = CarDto.builder()
					.c_sdate(strDate)
					.c_stime(strTime)
					.c_username("callor")
					.c_qty("시작")
					.c_carnum("111가1234")
					.build();
		return carDto;
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
