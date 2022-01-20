package com.ftn.domzdravlja.service;

import java.util.List;

import com.ftn.domzdravlja.model.Osoblje;

public interface OsobljeService {

	Osoblje findOsobljeById(Integer id);
	
	Osoblje save(Osoblje osoblje);
	
	List<Osoblje> getOsobljeByKlinika(Integer klinikaId);
}
