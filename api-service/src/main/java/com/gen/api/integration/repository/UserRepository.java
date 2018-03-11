package com.gen.api.integration.repository;

import org.springframework.data.repository.CrudRepository;

import com.gen.api.integration.domain.AppUser;

public interface UserRepository extends CrudRepository<AppUser, Long> {
	AppUser findByUsername(String username);
}
