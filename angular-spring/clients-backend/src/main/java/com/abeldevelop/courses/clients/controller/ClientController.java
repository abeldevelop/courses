package com.abeldevelop.courses.clients.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.abeldevelop.courses.clients.dto.ClientResource;
import com.abeldevelop.courses.clients.service.ClientService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/api/clients")
public class ClientController {

	private final ClientService clientService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ClientResource findById(@RequestBody ClientResource clientResource) {
		return clientService.save(clientResource);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ClientResource findById(@PathVariable("id") Long id, @RequestBody ClientResource clientResource) {
		return clientService.update(id, clientResource);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		clientService.delete(id);
	}
	
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
	
}
