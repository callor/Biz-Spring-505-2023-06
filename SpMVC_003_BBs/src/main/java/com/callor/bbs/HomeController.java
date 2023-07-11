package com.callor.bbs;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.bbs.dao.BBsDao;
import com.callor.bbs.models.BBsDto;

@Controller
public class HomeController {

	private final BBsDao bbsDao;
	public HomeController(BBsDao bbsDao) {
		this.bbsDao = bbsDao;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		List<BBsDto> bbsList = bbsDao.selectAll();
		model.addAttribute("BBS_LIST", bbsList);
		return "home";
	}
	
}
