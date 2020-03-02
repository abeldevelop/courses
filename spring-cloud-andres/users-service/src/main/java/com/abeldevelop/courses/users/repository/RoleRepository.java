package com.abeldevelop.courses.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abeldevelop.courses.users.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

	
}
