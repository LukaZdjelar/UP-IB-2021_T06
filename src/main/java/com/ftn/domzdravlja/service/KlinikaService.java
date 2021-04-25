package com.ftn.domzdravlja.service;

import com.ftn.domzdravlja.model.Klinika;

public interface KlinikaService {

	Klinika findKlinikaById(Integer id);
	
	Klinika save(Klinika klinika);
}
