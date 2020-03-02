package com.abeldevelop.courses.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abeldevelop.courses.products.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
