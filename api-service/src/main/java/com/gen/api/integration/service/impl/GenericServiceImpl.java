package com.gen.api.integration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gen.api.integration.domain.AppUser;
import com.gen.api.integration.domain.UserRole;
import com.gen.api.integration.repository.RoleRepository;
import com.gen.api.integration.repository.UserRepository;
import com.gen.api.integration.service.GenericService;

@Service
public class GenericServiceImpl implements GenericService {
	@Autowired
	private UserRepository userRepository;

	private RoleRepository roleRepository;

	@Override
	public AppUser findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public List<AppUser> findAllUsers() {
		return (List<AppUser>) userRepository.findAll();
	}

	@Override
	public List<UserRole> getRoles() {
		return (List<UserRole>) roleRepository.findAll();
	}

}
