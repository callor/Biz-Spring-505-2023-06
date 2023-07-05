package com.callor.address.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * 
 * VO class
 * Value Object class
 * Dto class 와 유사한 기능을 수행하지만
 * 개발자 입장에서는 Read Only 객체 
 * 
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HobbyByAidVO {
	private long ah_seq; 
	private String ah_aid; 
	private String ah_hbcode; 
	private String hb_name;
	private String hb_descrip;
}
