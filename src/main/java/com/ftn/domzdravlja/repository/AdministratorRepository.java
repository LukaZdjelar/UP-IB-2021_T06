package com.ftn.domzdravlja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.domzdravlja.model.Administrator;

public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {
	
	Administrator findAdministratorById(Integer id);

}
