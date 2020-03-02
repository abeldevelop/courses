package com.abeldevelop.courses.products.mapper;

import org.springframework.stereotype.Component;

import com.abeldevelop.courses.products.dto.ProductResource;
import com.abeldevelop.courses.products.entity.ProductEntity;

@Component
public class ProductMapper {

	public ProductResource map(ProductEntity productEntity) {
		return ProductResource.builder()
			.id(productEntity.getId())
			.name(productEntity.getName())
			.price(productEntity.getPrice())
			.createAt(productEntity.getCreateAt())
			.build();
	}
	
	public ProductEntity map(ProductResource productResource) {
		return ProductEntity.builder()
			.name(productResource.getName())
			.price(productResource.getPrice())
			.build();
	}
	
	public ProductEntity map(ProductEntity productEntity, ProductResource productResource) {
		productEntity.setName(productResource.getName());
		productEntity.setPrice(productResource.getPrice());
		return productEntity;
	}
}
