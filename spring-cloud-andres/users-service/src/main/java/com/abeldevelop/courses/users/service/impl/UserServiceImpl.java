package com.abeldevelop.courses.users.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abeldevelop.courses.users.dto.UserResource;
import com.abeldevelop.courses.users.entity.UserEntity;
import com.abeldevelop.courses.users.mapper.UserMapper;
import com.abeldevelop.courses.users.repository.RoleRepository;
import com.abeldevelop.courses.users.repository.UserRepository;
import com.abeldevelop.courses.users.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final UserMapper userMapper;
	
	@Override
	@Transactional
	public UserResource save(UserResource userResource) {
		UserEntity userEntity = userMapper.map(userResource);
		userEntity.setRoles(userResource.getRoles().stream().map(role -> roleRepository.findById(role.getId()).orElse(null)).filter(Objects::nonNull).collect(Collectors.toList()));
		return userMapper.map(userRepository.save(userEntity));
	}

	@Override
	@Transactional
	public UserResource update(Long id, UserResource userResource) {
		UserEntity userEntity = findByIdInDatabase(id);
		userMapper.map(userEntity, userResource);
		return userMapper.map(userRepository.save(userEntity));
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public UserResource findById(Long id) {
		return userMapper.map(findByIdInDatabase(id));
	}
	
	@Override
	@Transactional(readOnly = true)
	public UserResource findByUsername(String username) {
		return userMapper.map(findByUsernameInDatabase(username));
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserResource> findAll() {
		return userRepository.findAll().stream().map(userMapper::map).collect(Collectors.toList());
	}

	private UserEntity findByIdInDatabase(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new RuntimeException("No exist user with id: " + id));
	}
	
	private UserEntity findByUsernameInDatabase(String username) {
		return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("No exist user with username: " + username));
	}
}
