package com.ftn.domzdravlja.service;

import java.util.List;

import com.ftn.domzdravlja.model.Pacijent;

public interface PacijentService {
	
	Pacijent findPacijentById(Integer id);
	
	Pacijent save(Pacijent pacijent);
	
	List<Pacijent> findAll();
}
