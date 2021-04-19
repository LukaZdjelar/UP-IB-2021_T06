package com.ftn.domzdravlja.service;

import com.ftn.domzdravlja.model.Administrator;

public interface AdministratorService {

	Administrator findAdministratorById(Integer id);
	
	Administrator save(Administrator administrator);
}
