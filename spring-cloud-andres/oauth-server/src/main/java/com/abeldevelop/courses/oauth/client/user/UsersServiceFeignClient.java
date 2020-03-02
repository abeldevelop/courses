package com.abeldevelop.courses.oauth.client.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.abeldevelop.courses.oauth.client.user.dto.UserResource;

@FeignClient(name = "users-service")
public interface UsersServiceFeignClient {

	@GetMapping("/username/{username}")
	@ResponseStatus(HttpStatus.OK)
	public UserResource findByUsername(@PathVariable("username") String username);
	
}
