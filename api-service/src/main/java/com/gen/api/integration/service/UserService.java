package com.gen.api.integration.service;

import com.gen.api.integration.domain.AppUser;

public interface UserService {

	AppUser saveUser(AppUser appUser);

	AppUser getUser(Long id);

	Boolean deleteUser(Long id);

}
