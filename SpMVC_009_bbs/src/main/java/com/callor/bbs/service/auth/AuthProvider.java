package com.callor.bbs.service.auth;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/*
 * AuthenticationProvider 를 구현한 클래스에서 
 * authenticate() method 가 수행하는 주요 역할은
 * 정상적인 사용자 일 경우 session Token 을 발행하는 것이다
 * 여기에서 필요한 정보들은 사용자의 id, password, 와 ROLE 정보이다
 */

@Slf4j
@Service("authProvider")
public class AuthProvider implements AuthenticationProvider{

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		
		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		
		log.debug("로그인 사용자 {}", username);
		log.debug("로그인 비밀번호 {}", password);
		
		// Token 생성하는 클래스
		UsernamePasswordAuthenticationToken token
			= new UsernamePasswordAuthenticationToken(username, password);
		return token;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
