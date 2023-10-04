package com.callor.bbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.callor.bbs.models.UserDto;

public interface UserRepository extends JpaRepository<UserDto, Long>{

}
