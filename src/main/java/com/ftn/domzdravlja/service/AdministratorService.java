package com.ftn.domzdravlja.service;

import java.util.List;

import com.ftn.domzdravlja.model.Administrator;
import com.ftn.domzdravlja.model.Klinika;
import com.ftn.domzdravlja.model.Osoblje;

public interface AdministratorService {
	
	List<Administrator> findAll();

	Administrator findAdministratorById(Integer id);
	
	Administrator save(Administrator administrator);
	
}
