package com.abeldevelop.courses.clients.mapper;

import org.springframework.stereotype.Component;

import com.abeldevelop.courses.clients.dto.ClientResource;
import com.abeldevelop.courses.clients.model.ClientEntity;

@Component
public class ClientMapper {

	public ClientResource mapEntityToResource(ClientEntity clientEntity) {
		return ClientResource.builder()
				.id(clientEntity.getId())
				.name(clientEntity.getName())
				.surname(clientEntity.getSurname())
				.email(clientEntity.getEmail())
				.createAt(clientEntity.getCreateAt())
				.build();
	}
}
