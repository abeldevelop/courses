package com.abeldevelop.courses.clients.mapper;

import org.springframework.stereotype.Component;

import com.abeldevelop.courses.clients.dto.RegionResource;
import com.abeldevelop.courses.clients.model.RegionEntity;

@Component
public class RegionMapper {

	public RegionResource mapEntityToResource(RegionEntity regionEntity) {
		return RegionResource.builder()
				.id(regionEntity.getId())
				.name(regionEntity.getName())
				.build();
	}
}
