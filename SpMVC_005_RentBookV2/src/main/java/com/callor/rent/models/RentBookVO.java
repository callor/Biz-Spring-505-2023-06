package com.callor.rent.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * Data Class : Dto(Data Transfer Object), VO(Value Object)
 * Dto : CRUD 를 위한 Data Class 이다 : getter, Setter 
 * 		실제 Data 가 저장되는 Table 과 1:1 로 칼럼이 매칭
 * 
 * VO : SELECT 를 위한 Data Class 이다 : getter 만 있는 상태
 * 		한번 저장된 데이터를 변경할 수 없다. 읽기전용이다
 * 		JOIN 되는 SELECT 문의 결과를 DB 로 부터 가져와서 
 * 		데이터를 저장하는 클래스
 * 
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RentBookVO {

	private long rent_seq;

	private String rent_bcode; // <th>도서코드</th>
	private String b_name; 		//<th>도서명</th>
	private String b_comp;		//<th>출판사</th>

	private String rent_mcode; 	//<th>회원코드</th>
	private String m_name; 		//<th>회원명</th>
	private String m_tel; 		//<th>전화번호</th>
	
	private String rent_date; //<th>대출일</th>
	private String rent_return_date; //<th>반납일</th>
	private String rent_return_yn;//<th>도서반납여부</th>
	private int rent_price;//<th>대여금액</th>
	
	private int rent_point;// <th>포인트</th>

	
}
