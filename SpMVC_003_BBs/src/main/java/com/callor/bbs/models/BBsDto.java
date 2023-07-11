package com.callor.bbs.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BBsDto {
	private long b_seq; //	bigint
	private long b_pseq; //	bigint
	private String b_date;//	varchar(10)
	private String b_time;//	varchar(10)
	private String b_username;//	varchar(125)
	
	// tbl_user table 에서 가져온 데이터
	private String nickname;
	private String b_subject;//	varchar(125)
	private String b_content;//	text
	private int b_count;//	int
	// b_update;//	datetime

}
