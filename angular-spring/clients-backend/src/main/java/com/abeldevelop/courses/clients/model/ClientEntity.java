package com.abeldevelop.courses.clients.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "clients")
public class ClientEntity implements Serializable {

	private static final long serialVersionUID = 4575972337708967892L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	@NotNull
	private String name;
	
	@Column(name = "surname")
	@NotNull
	private String surname;
	
	@Column(name = "email", nullable = false, unique = true)
	@NotNull
	@Email
	private String email;
	
	@Column(name = "create_at")
	@NotNull
	private LocalDate createAt;

	@Column(name = "profile_image")
	private String profileImage;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "region_id")
	private RegionEntity region;
	
}
