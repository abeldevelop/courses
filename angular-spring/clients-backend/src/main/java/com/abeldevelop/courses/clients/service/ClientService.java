package com.abeldevelop.courses.clients.service;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.abeldevelop.courses.clients.domain.PaginationIn;
import com.abeldevelop.courses.clients.dto.ClientResource;
import com.abeldevelop.courses.clients.dto.ClientWithPaginationResource;
import com.abeldevelop.courses.clients.dto.RegionResource;

public interface ClientService {

	public ClientResource save(ClientResource clientResource);
	
	public ClientResource update(Long id, ClientResource clientResource);
	
	public void delete(Long id);
	
	public ClientResource findById(Long id);

	public List<ClientResource> findAll();
	
	public ClientWithPaginationResource findAll(PaginationIn paginationIn);
	
	public void uploadProfileImage(Long id, MultipartFile file);

	public Resource downloadProfileImage(Long id);
	
	public List<RegionResource> findAllRegions();
	
}
