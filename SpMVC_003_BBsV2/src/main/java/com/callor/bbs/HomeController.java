package com.callor.bbs;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.callor.bbs.dao.BBsDao;
import com.callor.bbs.models.BBsDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	private final BBsDao bbsDao;
	public HomeController(BBsDao bbsDao) {
		this.bbsDao = bbsDao;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
//		List<BBsDto> bbsList = bbsDao.selectAll();
		List<BBsDto> bbsList = bbsDao.findUserSelectLimit();
		model.addAttribute("BBS_LIST", bbsList);
		return "home";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert() {
		return "input";
	}

	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(BBsDto bbsDto,String b_file) {
		log.debug(bbsDto.toString());
		log.debug(b_file);
		return "input";
	}

	
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String detail(String seq,Model model) {
		
		BBsDto bbsDto = bbsDao.findById(seq);
		model.addAttribute("BBS",bbsDto);
		return "detail";
		
	}
	
	
	
	
}
