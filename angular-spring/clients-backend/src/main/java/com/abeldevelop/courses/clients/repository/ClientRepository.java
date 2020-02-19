package com.abeldevelop.courses.clients.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abeldevelop.courses.clients.model.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

	public Optional<ClientEntity> findByEmail(String email);
	
}
