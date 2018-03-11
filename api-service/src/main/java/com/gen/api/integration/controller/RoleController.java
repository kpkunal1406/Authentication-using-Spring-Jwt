package com.gen.api.integration.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gen.api.integration.service.GenericService;

@RestController
public class RoleController {
	
	@Autowired
	private GenericService genericService;
	
	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	public List<String> getRoles() {
		List<String> userRoles = new ArrayList<>();
		genericService.getRoles().forEach(userRole -> {
			userRoles.add(userRole.getRoleName());
		});
		return userRoles;
	}
	
	

}
