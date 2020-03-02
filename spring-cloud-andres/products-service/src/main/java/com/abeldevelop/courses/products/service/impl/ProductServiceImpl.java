package com.abeldevelop.courses.products.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abeldevelop.courses.products.dto.ProductResource;
import com.abeldevelop.courses.products.entity.ProductEntity;
import com.abeldevelop.courses.products.mapper.ProductMapper;
import com.abeldevelop.courses.products.repository.ProductRepository;
import com.abeldevelop.courses.products.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	private final ProductMapper productMapper;
	
	@Override
	@Transactional(readOnly = true)
	public ProductResource findById(Long id) {
		return productMapper.map(findProductByIdInDatabase(id));
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductResource> findAll() {
		return productRepository.findAll().stream()
				.map(productMapper::map)
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public ProductResource save(ProductResource productResource) {
		ProductEntity productEntity = productMapper.map(productResource);
		productEntity.setCreateAt(LocalDate.now());
		return productMapper.map(productRepository.save(productEntity));
	}

	
	@Override
	@Transactional
	public ProductResource update(Long id, ProductResource productResource) {
		ProductEntity productEntity = findProductByIdInDatabase(id);
		productMapper.map(productEntity, productResource);
		return productMapper.map(productRepository.save(productEntity));
	}
	
	@Override
	@Transactional
	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}

	private ProductEntity findProductByIdInDatabase(Long id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("No exist product with ID: " + id));
	}
}
