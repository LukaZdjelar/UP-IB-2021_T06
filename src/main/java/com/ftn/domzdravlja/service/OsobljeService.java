package com.ftn.domzdravlja.service;

import com.ftn.domzdravlja.model.Osoblje;

public interface OsobljeService {

	Osoblje findOsobljeById(Integer id);
	
	Osoblje save(Osoblje osoblje);
}
