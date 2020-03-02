package com.abeldevelop.courses.items.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.abeldevelop.courses.items.client.ProductsServiceFeignClient;
import com.abeldevelop.courses.items.domain.Item;
import com.abeldevelop.courses.items.domain.Product;
import com.abeldevelop.courses.items.service.ItemService;

import lombok.RequiredArgsConstructor;

@Primary
@RequiredArgsConstructor
@Service
public class ItemServiceFeignClient implements ItemService {

	private final ProductsServiceFeignClient productsServiceFeignClient;
	
	@Override
	public List<Item> findAll() {
		List<Product> products = productsServiceFeignClient.findAll();
		
		return products.stream()
				.map(p -> new Item(p, 1))
				.collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer amount) {
		Product product = productsServiceFeignClient.findById(id);
		return new Item(product, amount);
	}

	@Override
	public Product save(Product product) {
		return productsServiceFeignClient.save(product);
	}

	@Override
	public Product update(Long id, Product product) {
		return productsServiceFeignClient.update(id, product);
	}

	@Override
	public void deleteById(Long id) {
		productsServiceFeignClient.deleteById(id);
	}

}
