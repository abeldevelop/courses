package com.abeldevelop.courses.clients.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@GetMapping
	public List<ClientResource> findAll() {
		return clientService.findAll();
	}
	
}
