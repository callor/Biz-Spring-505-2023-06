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
public class UserDto {
	private String username;//	VARCHAR(15)
	private String password;//	VARCHAR(255)
	private String u_name;//	VARCHAR(20)
	private String u_nickname;//	VARCHAR(20)
	private String u_tel;//	VARCHAR(15)
	private String u_role;//	VARCHAR(15)
}




