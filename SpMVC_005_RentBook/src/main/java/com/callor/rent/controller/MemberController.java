package com.callor.rent.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.rent.models.MemberDto;
import com.callor.rent.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/member")
public class MemberController {

	// Spring Container 야 내가 MemberService 객체가 필요하니
	// 나에게 주입해달라(Dependency Inject)
	protected final MemberService memberService;
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping(value= {"/",""} ,method=RequestMethod.GET)
	public String home(Model model) {
		List<MemberDto> memberList = memberService.selectAll();
		model.addAttribute("MEMBERS",memberList);
		return "member/home";
	}
	
	/*
	 * @ModelAttribute("MEMBER")
	 * 	MEMBER 객체를 새로 생성하여(new 객체)
	 * 	input.jsp 에게 전달하기
	 */
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert(@ModelAttribute("MEMBER") MemberDto memberDto) {
		return "member/input";
	}

	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(@ModelAttribute("MEMBER") MemberDto memberDto,Model model) {
		
		log.debug("회원정보 확인 {}", memberDto);
		try {
			int result = memberService.insert(memberDto);
		} catch (Exception e) {
			// Service throw 로 전달한 message getter
			String message = e.getMessage();
			model.addAttribute("MESSAGE",message);
			return "member/input";
		}
		return "redirect:/member";
		
	}

	
	/*
	 * 
	 * @ModelAttribute 를 생성하면
	 * 객체, 변수가 작용하는 범위(scope)가 Request 전체 영역에 대하여
	 * 사용가능한 상태가 된다.
	 * 
	 */
	@ModelAttribute("MEMBER")
	public MemberDto newMember() {
		return MemberDto.builder().build();
	}
	
	

}
