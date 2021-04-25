package com.ftn.domzdravlja.service;

import com.ftn.domzdravlja.model.Pacijent;

public interface PacijentService {
	
	Pacijent findPacijentById(Integer id);
	
	Pacijent save(Pacijent pacijent);
}
