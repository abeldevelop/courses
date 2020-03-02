package com.abeldevelop.courses.users.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.abeldevelop.courses.users.dto.UserResource;
import com.abeldevelop.courses.users.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserController {

	private final UserService userService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserResource save(@RequestBody UserResource userResource) {
		return userService.save(userResource);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public UserResource update(@PathVariable("id") Long id, @RequestBody UserResource userResource) {
		return userService.update(id, userResource);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable("id") Long id) {
		userService.deleteById(id);
	}
	
	@GetMapping("/username/{username}")
	@ResponseStatus(HttpStatus.OK)
	public UserResource findByUsername(@PathVariable("username") String username) {
		return userService.findByUsername(username);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public UserResource findById(@PathVariable("id") Long id) {
		return userService.findById(id);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<UserResource> findAll(){
		return userService.findAll();
	}
	
}
