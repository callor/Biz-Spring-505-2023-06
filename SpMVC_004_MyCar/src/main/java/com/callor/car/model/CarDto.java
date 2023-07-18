package com.callor.car.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarDto {
	private long c_seq;			//	BIGINT
	private String c_carnum;	//	VARCHAR(15)
	private String c_qty;		//	VARCHAR(10)
	private String c_username;	//	VARCHAR(20)
	private String c_sdate;		//	VARCHAR(10)
	private String c_stime;		//	VARCHAR(10)
	private String c_goal;		//	VARCHAR(30)
	private String c_edate;		//	VARCHAR(10)
	private String c_etime;		//	VARCHAR(10)
	private int c_skm;		//	INT
	private int c_ekm;		//	INT
	private int c_cost;		//	INT
}
