package com.abeldevelop.courses.products.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductResource {

	private Long id;
	private String name;
	private Double price;
	private LocalDate createAt;
	
}
