package com.callor.rent.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MemberDto {

	private String m_code;//	varchar(6)
	private String m_name;//	varchar(125)
	private String m_tel;//		varchar(15)
	private String m_addr;//	varchar(125)

	
}
