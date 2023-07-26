package com.callor.rent.models;

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
public class RentBookDto {
	private long rent_seq;//	bigint
	private String rent_date;//	varchar(10)
	private String rent_return_date;//	varchar(10)
	private String rent_bcode;//	varchar(13)
	private String rent_mcode;//	varchar(6)
	private String rent_return_yn;//	varchar(1)
	private int rent_point;//	int
	private int rent_price;//	int
}
