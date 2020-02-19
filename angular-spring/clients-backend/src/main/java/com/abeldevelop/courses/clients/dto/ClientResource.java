package com.abeldevelop.courses.clients.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ClientResource {

	private Long id;
	private String name;
	private String surname;
	private String email;
	private LocalDate createAt;
	private String profileImage;
	private RegionResource region;
	
}
