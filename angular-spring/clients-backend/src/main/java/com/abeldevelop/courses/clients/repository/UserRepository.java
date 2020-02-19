package com.abeldevelop.courses.clients.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abeldevelop.courses.clients.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	public Optional<UserEntity> findByUsername(String username);
	
}
