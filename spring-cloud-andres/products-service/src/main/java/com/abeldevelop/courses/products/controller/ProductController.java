package com.abeldevelop.courses.products.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.abeldevelop.courses.products.dto.ProductResource;
import com.abeldevelop.courses.products.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ProductController {

	private final ProductService productService;
	
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ProductResource findById(@PathVariable("id") Long id) throws InterruptedException {
		log.info("findById Data IN => ID: {}", id);
		return productService.findById(id);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ProductResource> findAll() {
		log.info("findAll Data IN => NO DATA");
		return productService.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProductResource save(@RequestBody ProductResource productResource) {
		return productService.save(productResource);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ProductResource update(@PathVariable("id") Long id, @RequestBody ProductResource productResource) {
		return productService.update(id, productResource);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable("id") Long id) {
		productService.deleteById(id);
	}
}
