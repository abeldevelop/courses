package com.abeldevelop.courses.clients.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.abeldevelop.courses.clients.domain.PaginationIn;
import com.abeldevelop.courses.clients.dto.ClientResource;
import com.abeldevelop.courses.clients.dto.ClientWithPaginationResource;
import com.abeldevelop.courses.clients.dto.PaginationResponseResource;
import com.abeldevelop.courses.clients.dto.RegionResource;
import com.abeldevelop.courses.clients.exception.BadRequestException;
import com.abeldevelop.courses.clients.exception.InternalServerErrorException;
import com.abeldevelop.courses.clients.exception.NotFoundException;
import com.abeldevelop.courses.clients.mapper.ClientMapper;
import com.abeldevelop.courses.clients.mapper.RegionMapper;
import com.abeldevelop.courses.clients.model.ClientEntity;
import com.abeldevelop.courses.clients.model.RegionEntity;
import com.abeldevelop.courses.clients.repository.ClientRepository;
import com.abeldevelop.courses.clients.repository.RegionRepository;
import com.abeldevelop.courses.clients.service.ClientService;
import com.abeldevelop.courses.clients.service.FileService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {
	
	private final ClientRepository clientRepository;
	private final RegionRepository regionRepository;
	private final FileService fileService;
	private final ClientMapper clientMapper;
	private final RegionMapper regionMapper;
	
	@Override
	@Transactional
	public ClientResource save(ClientResource clientResource) {
		validateClient(clientResource);
		checkIfEmailExist(clientResource.getEmail());
		RegionEntity regionEntity = regionRepository.findById(clientResource.getRegion().getId())
				.orElseThrow(() -> new NotFoundException("No existe una region con el ID: " + clientResource.getRegion().getId()));
		ClientEntity clientEntity = clientMapper.mapResourceToEntity(clientResource);
		clientEntity.setRegion(regionEntity);
		return clientMapper.mapEntityToResource(clientRepository.save(clientEntity));
	}

	@Override
	@Transactional
	public ClientResource update(Long id, ClientResource clientResource) {
		validateClient(clientResource);
		ClientEntity clientEntity = clientRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("No existe un cliente con el ID: " + id));
		if(!clientEntity.getEmail().equals(clientResource.getEmail())) {
			checkIfEmailExist(clientResource.getEmail());
		}
		clientMapper.mapResourceToEntity(clientResource, clientEntity);
		
		RegionEntity regionEntity = regionRepository.findById(clientResource.getRegion().getId())
			.orElseThrow(() -> new NotFoundException("No existe una region con el ID: " + id));
		
		clientEntity.setRegion(regionEntity);
		return clientMapper.mapEntityToResource(clientRepository.save(clientEntity));
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		ClientEntity clientEntity = findClientById(id);
		fileService.delete(clientEntity.getProfileImage());
		clientRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public ClientResource findById(Long id) {
		return clientMapper.mapEntityToResource(findClientById(id));
	}

	private ClientEntity findClientById(Long id) {
		return clientRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("No existe un cliente con el ID: " + id));
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<ClientResource> findAll() {
		return clientRepository.findAll().stream().map(clientMapper::mapEntityToResource).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public ClientWithPaginationResource findAll(PaginationIn paginationIn) {
		Page<ClientEntity> pageResult = clientRepository.findAll(PageRequest.of(paginationIn.getPage()-1, paginationIn.getSize()));
		
		return ClientWithPaginationResource.builder()
				.pagination(PaginationResponseResource.builder()
						.page(paginationIn.getPage())
						.size(paginationIn.getSize())
						.numberOfElements(pageResult.getNumberOfElements())
						.totalPages(pageResult.getTotalPages())
						.totalElements(pageResult.getTotalElements())
						.first(pageResult.isFirst())
						.last(pageResult.isLast())
						.build())
				.clients(pageResult.getContent().stream().map(clientMapper::mapEntityToResource).collect(Collectors.toList()))
				.build();
	}
	
	@Override
	@Transactional
	public void uploadProfileImage(Long id, MultipartFile file) {
		ClientEntity clientEntity = findClientById(id);
		String imageName = null;
		try {
			imageName = fileService.upload(file);
		} catch (IOException e) {
			e.printStackTrace();
			throw new InternalServerErrorException("Ha ocurrido un error al subir la imagen");
		}
		fileService.delete(clientEntity.getProfileImage());
		clientEntity.setProfileImage(imageName);
		clientRepository.save(clientEntity);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Resource downloadProfileImage(Long id) {
		ClientEntity clientEntity = findClientById(id);
		try {
			return fileService.download(clientEntity.getProfileImage());
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new InternalServerErrorException("Ha ocurrido un error al cargar la imagen");
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<RegionResource> findAllRegions() {
		return regionRepository.findAll()
				.stream()
				.map(regionMapper::mapEntityToResource)
				.collect(Collectors.toList());
	}
	
	private void validateClient(ClientResource clientResource) {
		if(StringUtils.isEmpty(clientResource.getName())) {
			throw new BadRequestException("El nombre del cliente es obligatorio");
		}
		if(StringUtils.isEmpty(clientResource.getEmail())) {
			throw new BadRequestException("El email del cliente es obligatorio");
		}
		if(clientResource.getRegion() == null) {
			throw new BadRequestException("La region es obligatoria");
		}
		if(StringUtils.isEmpty(clientResource.getRegion().getId())) {
			throw new BadRequestException("El ID de la region es obligatorio");
		}
	}
	
	private void checkIfEmailExist(String email) {
		if(clientRepository.findByEmail(email).isPresent()) {
			throw new BadRequestException("Ya existe un cliente con el email: " + email);
		}
	}
}
