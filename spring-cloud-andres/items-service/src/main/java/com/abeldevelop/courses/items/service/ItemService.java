package com.abeldevelop.courses.items.service;

import java.util.List;

import com.abeldevelop.courses.items.domain.Item;
import com.abeldevelop.courses.items.domain.Product;

public interface ItemService {

	public List<Item> findAll();
	
	public Item findById(Long id, Integer amount);

	public Product save(Product product);
	
	public Product update(Long id, Product product);
	
	public void deleteById(Long id);
	
}
