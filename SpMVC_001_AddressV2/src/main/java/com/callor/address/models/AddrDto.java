package com.callor.address.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * Spring Project 에서 DB 와 연동되는 경우
 * Dto(VO)변수는 snake case 로 설정한다
 * DB에서 각 칼럼명(속성명)은 대소문자 구분이 없다
 * 그래서 Camel Case 이름을 명명하면 구분이 애매 해 진다
 * DB 에서 칼럼명은 보통 snake case 로 붙이는데
 * Dto 의 변수도 같은 형식으로 만든다
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddrDto {
	
	private String a_id;
	private String a_name;
	private String a_tel;
	private String a_addr;
	
	// 취미리스트
	private List<HobbyByAidVO> hobbyList;
	

}
