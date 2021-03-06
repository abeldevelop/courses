package com.abeldevelop.courses.users.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResource {

	private Long id;
	private String username;
	private String password;
	private Boolean enabled;
	private String name;
	private String surname;
	private String email;
	@Singular
	private List<RoleResource> roles;
	
}
