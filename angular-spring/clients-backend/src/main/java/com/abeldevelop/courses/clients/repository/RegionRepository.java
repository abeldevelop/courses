package com.abeldevelop.courses.clients.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abeldevelop.courses.clients.model.RegionEntity;

public interface RegionRepository extends JpaRepository<RegionEntity, Long> {

}
