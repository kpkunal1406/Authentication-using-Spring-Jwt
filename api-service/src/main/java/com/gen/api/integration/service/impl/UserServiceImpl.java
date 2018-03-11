package com.gen.api.integration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gen.api.integration.domain.AppUser;
import com.gen.api.integration.repository.UserRepository;
import com.gen.api.integration.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public AppUser saveUser(AppUser appUser) {
		return userRepository.save(appUser);
	}

	@Override
	public Boolean deleteUser(Long id) {
		try {
			userRepository.delete(id);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}

	}

	@Override
	public AppUser getUser(Long id) {
		return userRepository.findOne(id);
	}

}
