package com.abeldevelop.courses.clients.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abeldevelop.courses.clients.dto.ClientResource;
import com.abeldevelop.courses.clients.mapper.ClientMapper;
import com.abeldevelop.courses.clients.repository.ClientRepository;
import com.abeldevelop.courses.clients.service.ClientService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {
	
	private final ClientRepository clientRepository;
	private final ClientMapper clientMapper;
	
	@Override
	@Transactional(readOnly = true)
	public List<ClientResource> findAll() {
		return clientRepository.findAll().stream().map(clientMapper::mapEntityToResource).collect(Collectors.toList());
	}

}
