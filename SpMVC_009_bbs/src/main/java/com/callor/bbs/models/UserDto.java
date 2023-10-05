package com.callor.bbs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

@Entity
@Table(name="tbl_users",schema = "jpaDB")
public class UserDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 		// 	bigint
	
	@Column(name="username", columnDefinition = "VARCHAR(20)")
	private String username; //	varchar(255)
	
	@Column(name="password", columnDefinition = "VARCHAR(125)")
	private String password;//	varchar(255)
	
	@Column(name="email", columnDefinition = "VARCHAR(125)")
	private String email;	//	varchar(255)
	private String nickname;//	varchar(255)
	
	@Column(nullable = true)
	private int age;		//	int
}
