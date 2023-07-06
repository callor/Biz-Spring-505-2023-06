package com.callor.todo.models;

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
public class TodoDto {
	private long to_seq;		//	bigint
	private String to_sdate;	//	varchar(10)
	private String to_stime;	//	varchar(10)
	private String to_content;	//	varchar(400)
	private String to_edate;	//	varchar(10)
	private String to_etime;	//	varchar(10)
}
