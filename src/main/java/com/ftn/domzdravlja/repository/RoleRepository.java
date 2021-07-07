package com.ftn.domzdravlja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.domzdravlja.model.Role;

public interface RoleRepository extends JpaRepository<Role, String> {
	
	Role findUserByRole (String name);

}
