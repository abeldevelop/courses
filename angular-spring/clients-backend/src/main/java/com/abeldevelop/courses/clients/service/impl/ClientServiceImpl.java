package com.abeldevelop.courses.clients.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abeldevelop.courses.clients.dto.ClientResource;
import com.abeldevelop.courses.clients.mapper.ClientMapper;
import com.abeldevelop.courses.clients.model.ClientEntity;
import com.abeldevelop.courses.clients.repository.ClientRepository;
import com.abeldevelop.courses.clients.service.ClientService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {
	
	private final ClientRepository clientRepository;
	private final ClientMapper clientMapper;
	
	@Override
	@Transactional
	public ClientResource save(ClientResource clientResource) {
		return clientMapper.mapEntityToResource(clientRepository.save(clientMapper.mapResourceToEntity(clientResource)));
	}

	@Override
	@Transactional
	public ClientResource update(Long id, ClientResource clientResource) {
		ClientEntity clientEntity = clientRepository.findById(id).orElse(null);
		clientMapper.mapResourceToEntity(clientResource, clientEntity);
		return clientMapper.mapEntityToResource(clientRepository.save(clientEntity));
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		clientRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public ClientResource findById(Long id) {
		return clientRepository.findById(id)
				.map(clientMapper::mapEntityToResource)
				.orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ClientResource> findAll() {
		return clientRepository.findAll().stream().map(clientMapper::mapEntityToResource).collect(Collectors.toList());
	}
	
}
