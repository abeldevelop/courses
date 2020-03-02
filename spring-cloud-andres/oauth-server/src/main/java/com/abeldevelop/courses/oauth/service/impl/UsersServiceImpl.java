package com.abeldevelop.courses.oauth.service.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.abeldevelop.courses.oauth.client.user.UsersServiceFeignClient;
import com.abeldevelop.courses.oauth.client.user.dto.UserResource;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UserDetailsService {

	private final UsersServiceFeignClient usersServiceFeignClient;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserResource user = usersServiceFeignClient.findByUsername(username);
		
		
		return null;
	}

}
