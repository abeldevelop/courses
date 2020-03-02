package com.abeldevelop.courses.users.mapper;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.abeldevelop.courses.users.dto.UserResource;
import com.abeldevelop.courses.users.entity.UserEntity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class UserMapper {

	private final RoleMapper roleMapper;
	
	public UserResource map(UserEntity userEntity) {
		return UserResource.builder()
				.id(userEntity.getId())
				.username(userEntity.getUsername())
				.enabled(userEntity.getEnabled())
				.name(userEntity.getName())
				.surname(userEntity.getSurname())
				.email(userEntity.getEmail())
				.roles(userEntity.getRoles().stream().map(roleMapper::map).collect(Collectors.toList()))
				.build();
	}
	
	public UserEntity map(UserResource userResource) {
		return UserEntity.builder()
				.username(userResource.getUsername())
				.password(userResource.getPassword())
				.enabled(userResource.getEnabled())
				.name(userResource.getName())
				.surname(userResource.getSurname())
				.email(userResource.getEmail())
				.build();
	}
	
	public UserEntity map(UserEntity userEntity, UserResource userResource) {
		userEntity.setPassword(userResource.getPassword());
		userEntity.setEnabled(userResource.getEnabled());
		userEntity.setName(userResource.getName());
		userEntity.setSurname(userResource.getSurname());
		userEntity.setEmail(userResource.getEmail());
		return userEntity;
	}
}
