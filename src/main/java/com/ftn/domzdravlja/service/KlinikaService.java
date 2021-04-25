package com.ftn.domzdravlja.service;

import java.util.List;

import com.ftn.domzdravlja.model.Klinika;

public interface KlinikaService {
	
	List<Klinika> findAll();

	Klinika findKlinikaById(Integer id);
	
	Klinika save(Klinika klinika);
}
