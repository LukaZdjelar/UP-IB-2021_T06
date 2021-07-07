package com.ftn.domzdravlja.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ftn.domzdravlja.model.Role;
import com.ftn.domzdravlja.repository.RoleRepository;
import com.ftn.domzdravlja.service.RoleService;

public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRep;
	
	@Override
	public Role findUserByRole(String name) {
		Role role = roleRep.findUserByRole(name);
		return role;
	}

}
