package com.abeldevelop.courses.clients.service;

import com.abeldevelop.courses.clients.model.UserEntity;

public interface UserService {

	public UserEntity findByUsername(String username);
	
}
