package com.abeldevelop.courses.clients.controller;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.abeldevelop.courses.clients.domain.PaginationIn;
import com.abeldevelop.courses.clients.dto.ClientResource;
import com.abeldevelop.courses.clients.dto.ClientWithPaginationResource;
import com.abeldevelop.courses.clients.dto.RegionResource;
import com.abeldevelop.courses.clients.service.ClientService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = {"http://localhost:4200", "*"})
@RequestMapping("/api/client")
public class ClientController {

	private final ClientService clientService;
	
	
	@Secured("ROLE_ADMIN")
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ClientResource findById(@RequestBody ClientResource clientResource) {
		return clientService.save(clientResource);
	}
	
	@Secured("ROLE_ADMIN")
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ClientResource update(@PathVariable("id") Long id, @RequestBody ClientResource clientResource) {
		return clientService.update(id, clientResource);
	}
	
	@Secured("ROLE_ADMIN")
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		clientService.delete(id);
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ClientResource findById(@PathVariable("id") Long id) {
		return clientService.findById(id);
	}
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<ClientResource> findAll() {
		return clientService.findAll();
	}
	
	@GetMapping("/page/{page}")
	@ResponseStatus(code = HttpStatus.OK)
	public ClientWithPaginationResource findAllWithPagination(@PathVariable("page") Integer page) {
		return clientService.findAll(PaginationIn.builder().page(page).size(4).build());
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@PostMapping("/{id}/profile-image")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void uploadProfileImage(@PathVariable("id") Long id, @RequestParam("file") MultipartFile file) {
		clientService.uploadProfileImage(id, file);
	}
	
	@GetMapping("/{id}/profile-image")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Resource> downloadProfileImage(@PathVariable("id") Long id) {
		Resource resource = clientService.downloadProfileImage(id);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		return new ResponseEntity<>(resource, headers, HttpStatus.OK);
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/region")
	@ResponseStatus(code = HttpStatus.OK)
	public List<RegionResource> findAllRegions() {
		return clientService.findAllRegions();
	}
}
