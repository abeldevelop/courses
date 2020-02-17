package com.abeldevelop.courses.clients.service;

import java.util.List;

import com.abeldevelop.courses.clients.dto.ClientResource;

public interface ClientService {

	public ClientResource save(ClientResource clientResource);
	
	public ClientResource update(Long id, ClientResource clientResource);
	
	public void delete(Long id);
	
	public ClientResource findById(Long id);

	public List<ClientResource> findAll();
}
