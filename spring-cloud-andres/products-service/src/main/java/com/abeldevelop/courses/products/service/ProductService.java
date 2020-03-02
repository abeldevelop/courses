package com.abeldevelop.courses.products.service;

import java.util.List;

import com.abeldevelop.courses.products.dto.ProductResource;

public interface ProductService {

	public ProductResource findById(Long id);
	
	public List<ProductResource> findAll();
	
	public ProductResource save(ProductResource productResource);
	
	public ProductResource update(Long id, ProductResource productResource);
	
	public void deleteById(Long id);
}
