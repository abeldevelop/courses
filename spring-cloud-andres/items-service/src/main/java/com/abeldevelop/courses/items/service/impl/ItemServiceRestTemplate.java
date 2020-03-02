package com.abeldevelop.courses.items.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.abeldevelop.courses.items.domain.Item;
import com.abeldevelop.courses.items.domain.Product;
import com.abeldevelop.courses.items.service.ItemService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ItemServiceRestTemplate implements ItemService {

	private final RestTemplate restTemplate;
	
	@Override
	public List<Item> findAll() {
		List<Product> products = Arrays.asList(restTemplate.getForObject("http://products-service", Product[].class));
		
		return products.stream()
				.map(p -> new Item(p, 1))
				.collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer amount) {
		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("id", id.toString());
		Product product = restTemplate.getForObject("http://products-service/{id}", Product.class, pathVariables);
		return new Item(product, amount);
	}

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product update(Long id, Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
