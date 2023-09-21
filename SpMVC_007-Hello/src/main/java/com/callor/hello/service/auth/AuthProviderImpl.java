package com.callor.hello.service.auth;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("authProviderImpl")
public class AuthProviderImpl implements AuthenticationProvider{

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = (String)authentication.getPrincipal();
		String password = (String)authentication.getCredentials();
		
		if(!username.equalsIgnoreCase("callor")) {
			throw new UsernameNotFoundException(username + " 이 없음");
		}
		
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
