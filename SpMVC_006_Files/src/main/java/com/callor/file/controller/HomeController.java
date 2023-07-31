package com.callor.file.controller;

import java.util.List;

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
import com.callor.file.service.GalleryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	protected final GalleryService galleryService;
	protected final BBsService bbsService;

	public HomeController(GalleryService galleryService, BBsService bbsService) {
		this.galleryService = galleryService;
		this.bbsService = bbsService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Model model) {
		List<BBsDto> bbsList = bbsService.selectAll();
		model.addAttribute("BBS_LIST",bbsList);
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

		bbsService.insert(bbsDto, b_file, b_files);
	
		return "redirect:/";
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String detail(
			@ModelAttribute("BBS") BBsDto bbsDto,
			@RequestParam(value="b_seq", 
					required = false, 
					defaultValue = "0") 
			long b_seq, Model model) {
			bbsDto = bbsService.findById(b_seq);
			model.addAttribute("BBS",bbsDto);
		
		return "detail";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(
			@RequestParam(value="b_seq",required = false, defaultValue = "0") 
			long b_seq,
			@ModelAttribute("BBS") BBsDto bbsDto,Model model) {
		
		bbsDto = bbsService.findById(b_seq);
		model.addAttribute("BBS",bbsDto);
		return "input";
		
	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(
			@ModelAttribute("BBS") BBsDto bbsDto,
			@RequestParam("b_file") MultipartFile b_file,
			MultipartHttpServletRequest b_files
			) {

		long b_seq = bbsDto.getB_seq();
		int result = bbsService.update(bbsDto, b_file, b_files);
		
		return "redirect:/detail?b_seq=" + b_seq;
		
	}

	@RequestMapping(value="/img_delete",method=RequestMethod.GET)
	public String img_delete(
			@RequestParam(value="b_seq", 
				required = false, defaultValue = "0" ) long b_seq,
			@RequestParam(value="f_seq", 
				required = false, defaultValue = "0" )
			long f_seq) {
		int result = galleryService.imgDelete(f_seq);
		return "redirect:/detail?b_seq=" + b_seq;
	}
	
	@ModelAttribute("BBS")
	public BBsDto newBBsDto() {
		return BBsDto.builder().build();
	}
	
	
}
