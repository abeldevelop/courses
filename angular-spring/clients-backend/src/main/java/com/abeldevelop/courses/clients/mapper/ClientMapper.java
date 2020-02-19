package com.abeldevelop.courses.clients.mapper;

import org.springframework.stereotype.Component;

import com.abeldevelop.courses.clients.dto.ClientResource;
import com.abeldevelop.courses.clients.model.ClientEntity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ClientMapper {

	private final RegionMapper regionMapper;
	
	public ClientResource mapEntityToResource(ClientEntity clientEntity) {
		return ClientResource.builder()
				.id(clientEntity.getId())
				.name(clientEntity.getName())
				.surname(clientEntity.getSurname())
				.email(clientEntity.getEmail())
				.createAt(clientEntity.getCreateAt())
				.profileImage(clientEntity.getProfileImage())
				.region(regionMapper.mapEntityToResource(clientEntity.getRegion()))
				.build();
	}
	
	public ClientEntity mapResourceToEntity(ClientResource clientResource) {
		return ClientEntity.builder()
				.id(clientResource.getId())
				.name(clientResource.getName())
				.surname(clientResource.getSurname())
				.email(clientResource.getEmail())
				.createAt(clientResource.getCreateAt())
				.build();
	}
	
	public ClientEntity mapResourceToEntity(ClientResource clientResource, ClientEntity clientEntity) {
		clientEntity.setName(clientResource.getName());
		clientEntity.setSurname(clientResource.getSurname());
		clientEntity.setEmail(clientResource.getEmail());
		clientEntity.setCreateAt(clientResource.getCreateAt());
		return clientEntity;
	}
}
