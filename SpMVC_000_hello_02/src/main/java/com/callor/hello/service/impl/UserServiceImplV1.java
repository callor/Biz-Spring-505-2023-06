package com.callor.hello.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.hello.models.UserDto;
import com.callor.hello.service.UserService;

@Service
public class UserServiceImplV1 implements UserService{

	/*
	 * List<UserDto> userList 객체를 생성하고
	 * 임의로 생성한 3명의 User 정보를 add 하기
	 * userList 를 return 하기 
	 */
	@Override
	public List<UserDto> selectAll() {

		List<UserDto> userList = new ArrayList<>();
		
		UserDto dto = new UserDto();
		dto.setUsername("aaa");
		dto.setPassword("12345");
		dto.setName("홍길동");
		dto.setTel("010-111-1111");
		dto.setAddr("서울특별시");
		dto.setAge(33);
		userList.add(dto);
		
		dto = new UserDto();
		dto.setUsername("bbb");
		dto.setPassword("12345");
		dto.setName("이몽룡");
		dto.setTel("010-222-2222");
		dto.setAddr("전북 익산시");
		dto.setAge(20);
		userList.add(dto);

		// setter 를 사용하여 데이터 추가하기
		dto = new UserDto();
		dto.setUsername("ccc");
		dto.setPassword("12345");
		dto.setName("성춘향");
		dto.setTel("010-333-3333");
		dto.setAddr("전북 남원시");
		dto.setAge(16);
		userList.add(dto);

		// field 생성자를 사용하여 데이터 추가하기
		// field 생성자를 사용하는 경우 원하는 변수에 값이
		// 정확히 저장되는지 확인하기 어렵다
		dto = new UserDto("ddd","12345",
				"임꺽정","010-444-44444", "함경도",20);
		userList.add(dto);
		return userList;
	}

	@Override
	public UserDto findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int input(UserDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
