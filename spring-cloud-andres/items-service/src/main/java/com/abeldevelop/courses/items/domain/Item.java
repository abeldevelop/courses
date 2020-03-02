package com.abeldevelop.courses.items.domain;

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
public class Item {

	private Product product;
	private Integer amount;
	
	public Double getTotal() {
		return product.getPrice() * amount;
	}
}
