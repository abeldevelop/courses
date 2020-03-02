package com.abeldevelop.courses.users.service;

import java.util.List;

import com.abeldevelop.courses.users.dto.UserResource;

public interface UserService {

	public UserResource save(UserResource userResource);
	
	public UserResource update(Long id, UserResource userResource);
	
	public void deleteById(Long id);
	
	public UserResource findByUsername(String username);
	
	public UserResource findById(Long id);
	
	public List<UserResource> findAll();
	
}
