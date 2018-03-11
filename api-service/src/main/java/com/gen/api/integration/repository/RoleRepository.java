package com.gen.api.integration.repository;

import org.springframework.data.repository.CrudRepository;

import com.gen.api.integration.domain.UserRole;

public interface RoleRepository extends CrudRepository<UserRole, Long> {
}
