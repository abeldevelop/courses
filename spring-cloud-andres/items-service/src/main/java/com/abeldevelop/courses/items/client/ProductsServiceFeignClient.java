package com.abeldevelop.courses.items.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.abeldevelop.courses.items.domain.Product;

@FeignClient("products-service")
public interface ProductsServiceFeignClient {

	@GetMapping
	public List<Product> findAll();
	
	@GetMapping("/{id}")
	public Product findById(@PathVariable("id") Long id);

	@PostMapping
	public Product save(@RequestBody Product product);
	
	@PutMapping("/{id}")
	public Product update(@PathVariable("id") Long id, @RequestBody Product product);
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Long id);
	
}
