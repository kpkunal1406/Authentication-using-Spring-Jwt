package com.gen.api.integration.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gen.api.integration.domain.AppUser;
import com.gen.api.integration.service.GenericService;
import com.gen.api.integration.service.UserService;
import com.gen.api.vo.AppUserVO;

@RestController
public class UserController {
	@Autowired
	private GenericService genericService;

	@Autowired
	private UserService userService;    
	
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("isAuthenticated() and hasAuthority('ADMIN')")
	public List<AppUserVO> getUsers() {
		ArrayList<AppUserVO> appUserVOs = new ArrayList<>();
		genericService.findAllUsers().forEach(appUser -> {
			final AppUserVO appUserVO = new AppUserVO();
			BeanUtils.copyProperties(appUser, appUserVO, new String[] { "serialVersionUID", "password" });
			appUserVOs.add(appUserVO);
		});
		return appUserVOs;
	}

	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('DISTRIBUTOR')")
	public AppUserVO addUser(@RequestBody AppUserVO appUserVO) {
		AppUser appUser = new AppUser();
		BeanUtils.copyProperties(appUserVO, appUser, new String[] {});
		userService.saveUser(appUser);
		BeanUtils.copyProperties(appUser, appUserVO, new String[] { "serialVersionUID", "password" });
		return appUserVO;
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasAuthority('ADMIN')")
	public Boolean deleteUser(@PathVariable Long id) {
		return userService.deleteUser(id);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('DISTRIBUTOR')")
	public AppUserVO getUser(@PathVariable Long id) {
		AppUserVO appUserVO = new AppUserVO();
		BeanUtils.copyProperties(userService.getUser(id), appUserVO, new String[] { "serialVersionUID", "password" });
		return appUserVO;
	}
}
