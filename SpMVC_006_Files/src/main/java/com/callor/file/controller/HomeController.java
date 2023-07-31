package com.callor.file.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.file.model.BBsDto;
import com.callor.file.service.BBsService;
import com.callor.file.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	
	protected final BBsService bbsService;
	public HomeController(BBsService bbsService) {
		this.bbsService = bbsService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	// @RequestMapping(value="/insert",method=RequestMethod.GET)
	// Spring 4.3 이후에 생성된 새로운 Mapping
	@GetMapping(value="/insert")
	public String insert(@ModelAttribute("BBS") BBsDto bbsDto) {
		return "input";
	}

	@PostMapping(value="/insert")
	public String insert(
			@RequestParam(value = "b_file") MultipartFile b_file,
			MultipartHttpServletRequest b_files,
			@ModelAttribute("BBS") BBsDto bbsDto,Model model) {

		log.debug("파일 {}", b_file);
		log.debug("파일들 {}", b_files);
		
		try {
//			String resultName = fileService.fileUp(b_file);
			bbsDto.setB_image(resultName);
			bbsService.insert(bbsDto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return "redirect:/";
	}
	
	@ModelAttribute("BBS")
	public BBsDto newBBsDto() {
		return BBsDto.builder().build();
	}
	
	
}
