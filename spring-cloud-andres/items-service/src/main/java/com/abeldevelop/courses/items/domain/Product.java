package com.abeldevelop.courses.items.domain;

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
public class Product {

	private Long id;
	private String name;
	private Double price;
	private LocalDate createAt;
	
}
