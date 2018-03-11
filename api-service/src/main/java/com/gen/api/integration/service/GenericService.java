package com.gen.api.integration.service;

import java.util.List;

import com.gen.api.integration.domain.AppUser;
import com.gen.api.integration.domain.UserRole;

public interface GenericService {
	AppUser findByUsername(String username);

	List<AppUser> findAllUsers();
	
	List<UserRole> getRoles();
}
