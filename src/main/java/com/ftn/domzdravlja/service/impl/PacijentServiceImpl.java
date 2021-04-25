package com.ftn.domzdravlja.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.domzdravlja.model.Pacijent;
import com.ftn.domzdravlja.repository.PacijentRepository;
import com.ftn.domzdravlja.service.PacijentService;

@Service
public class PacijentServiceImpl implements PacijentService{
	
	
	@Autowired
	PacijentRepository pacijentRepository;

	@Override
	public Pacijent findPacijentById(Integer id) {
		Pacijent pacijent = pacijentRepository.findPacijentById(id);
		return pacijent;
	}

	@Override
	public Pacijent save(Pacijent pacijent) {
		return pacijentRepository.save(pacijent);
	}

}
