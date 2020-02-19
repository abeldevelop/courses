package com.abeldevelop.courses.clients.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abeldevelop.courses.clients.exception.BadRequestException;
import com.abeldevelop.courses.clients.model.UserEntity;
import com.abeldevelop.courses.clients.repository.UserRepository;
import com.abeldevelop.courses.clients.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	private final UserRepository userRepository;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Error en el login: No existe el usuario en el sistema"));
		
		List<GrantedAuthority> authorities = userEntity.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName()))
				.collect(Collectors.toList());
		return new User(username, userEntity.getPassword(), userEntity.getEnabled(), true, true, true, authorities);
	}

	@Override
	@Transactional(readOnly = true)
	public UserEntity findByUsername(String username) {
		return userRepository.findByUsername(username).orElseThrow(() -> new BadRequestException("Usuario no encontrado"));
	}

}
