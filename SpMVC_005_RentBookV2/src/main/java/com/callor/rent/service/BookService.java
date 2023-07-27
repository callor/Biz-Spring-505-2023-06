package com.callor.rent.service;

import java.util.List;

import org.springframework.ui.Model;

import com.callor.rent.models.BookDto;

public interface BookService {

	public List<BookDto> selectAll();
	public List<BookDto> selectPage(String page);
	public void selectPage(String page, Model model);
	
	
	public int insert(BookDto bookDto);
	public BookDto findById(String bcode);
	public int update(BookDto bookDto);
	public List<BookDto> findByBName(String bname);
	

}
