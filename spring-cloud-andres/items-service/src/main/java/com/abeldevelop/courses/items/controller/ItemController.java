package com.abeldevelop.courses.items.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.abeldevelop.courses.items.domain.Item;
import com.abeldevelop.courses.items.domain.Product;
import com.abeldevelop.courses.items.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ItemController {

	private final ItemService itemService;

	@Value("${text.config}")
	private String textConfig;
	
	@GetMapping
	public List<Item> findAll() {
		log.info("findAll Data IN => NO DATA");
		return itemService.findAll();
	}

	@HystrixCommand(fallbackMethod = "fallbackMethod")
	@GetMapping("/{id}/amount/{amount}")
	public Item findById(@PathVariable("id") Long id, @PathVariable("amount") Integer amount) {
		log.info("findAll Data IN => id: {}, amount: {}", id, amount);
		return itemService.findById(id, amount);
	}
	
	public Item fallbackMethod(Long id, Integer amount) {
		return new Item(Product.builder().id(1L).name("name").price(0.0).createAt(LocalDate.now()).build(), 1);
	}
	
	@GetMapping("/config")
	public Map<String, String> getConfig(@Value("${server.port}") Integer port) {
		Map<String, String> config = new HashMap<>();
		config.put("textConfig", textConfig);
		config.put("port", port.toString());
		return config;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Product save(@RequestBody Product product) {
		return itemService.save(product);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Product update(@PathVariable("id") Long id, @RequestBody Product productResource) {
		return itemService.update(id, productResource);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable("id") Long id) {
		itemService.deleteById(id);
	}
}
