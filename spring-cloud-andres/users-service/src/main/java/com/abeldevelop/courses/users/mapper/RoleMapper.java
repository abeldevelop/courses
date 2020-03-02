package com.abeldevelop.courses.users.mapper;

import org.springframework.stereotype.Component;

import com.abeldevelop.courses.users.dto.RoleResource;
import com.abeldevelop.courses.users.entity.RoleEntity;

@Component
public class RoleMapper {

	public RoleResource map(RoleEntity roleEntity) {
		return RoleResource.builder()
				.id(roleEntity.getId())
				.name(roleEntity.getName())
				.build();
	}
	
	public RoleEntity map(RoleResource roleResource) {
		return RoleEntity.builder()
				.id(roleResource.getId())
				.name(roleResource.getName())
				.build();
	}
}
