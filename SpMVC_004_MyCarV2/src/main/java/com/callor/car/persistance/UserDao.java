package com.callor.car.persistance;

import org.apache.ibatis.annotations.Select;

import com.callor.car.model.UserDto;

public interface UserDao {
	
	@Select(" SELECT COUNT(*) FROM tbl_users ")
	public int userCount() ;
	
	@Select(" SELECT * FROM tbl_users WHERE username = #{username} ")
	public UserDto findById(String username);
	
	public int insert(UserDto userDto);
	
	public void create_user_table() ;

}
