package com.callor.file.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BBsDto {
	
	private long b_seq;
	private String b_title;// varchar(125)
	private String b_content;// varchar(1000)
	private String b_nickname;// varchar(125)
	private String b_password;// varchar(125)
	private String b_ccode;// varchar(6)
	private String b_date;// varchar(10)
	private long b_viewcount;// long

	// 대표이미지 
	private String b_image;
	private String b_origin_image;
	
}