package com.abeldevelop.courses.users.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abeldevelop.courses.users.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findByUsername(String username);
	
}
