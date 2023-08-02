package com.callor.file.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.callor.file.dao.BBsDao;
import com.callor.file.model.BBsDto;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value="/bbs")
public class BbsController {

	private final BBsDao bbsDao;
	public BbsController(BBsDao bbsDao) {
		this.bbsDao = bbsDao;
	}
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<BBsDto> list() {
		List<BBsDto> bbsList = bbsDao.selectAll();
		return bbsList;
	}
	
}
