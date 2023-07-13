package com.callor.bbs.controller;

import java.util.List;
import java.util.Locale;

import javax.swing.plaf.multi.MultiFileChooserUI;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.callor.bbs.config.QualifierConfig;
import com.callor.bbs.dao.BBsDao;
import com.callor.bbs.models.BBsDto;
import com.callor.bbs.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	/*
	 * @Qualifier(QualifierConfig.SERVICE.FILE_V2)
	 *  
	 * 2개의 이상의 Component 들이 
	 * 같은 Service interface 를 상속받아 생성된 경우
	 * 이 Component 를 주입받아 사용하는 곳에서는 어떤 Component 를
	 * 주입받아 사용해야 하는지 알수가 없다
	 * 
	 * 이때는 @Component("이름") 에 이름을 부여하고
	 * 사용할 곳에서 주입받을때  @Qualifier() 를 통해 명시적으로
	 * 어떤 Component 를 주입받을지 지정해 주어야 한다
	 */
	
	protected final FileService fileService;
	
	private final BBsDao bbsDao;
	public HomeController(
			@Qualifier(QualifierConfig.SERVICE.FILE_V2) 
			FileService fileService,
			
			BBsDao bbsDao) {
		this.fileService = fileService;
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
	
	/*
	 * @RequestParam(value="b_username") String username
	 * Client(Browser)에서 b_username 이라는 변수에 값이 담겨서
	 * 전달되어 오면 username 이라는 변수에 값을 저장하여
	 * method 내부로 전달하라
	 * Client 와 Server 간에 변수 이름이 다를때 사용하는 선택사항
	 */

	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(
			
		@RequestParam(value="b_username") String username,
		@RequestParam(value="b_file") MultipartFile b_file,
		Model model
		) {
		
		log.debug("사용자이름 : {}",username);
		log.debug(b_file.getOriginalFilename());
		
		String fileName = "";
		try {
			fileName = fileService.fileUp(b_file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("FILE_NAME",fileName);
		return "input";
		
	}

	
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String detail(String seq,Model model) {
		
		BBsDto bbsDto = bbsDao.findById(seq);
		model.addAttribute("BBS",bbsDto);
		return "detail";
		
	}
	
	
	
	
}
