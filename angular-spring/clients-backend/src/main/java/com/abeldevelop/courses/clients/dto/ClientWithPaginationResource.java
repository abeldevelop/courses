package com.abeldevelop.courses.clients.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ClientWithPaginationResource {

	private PaginationResponseResource pagination;
	private List<ClientResource> clients;
	
}
