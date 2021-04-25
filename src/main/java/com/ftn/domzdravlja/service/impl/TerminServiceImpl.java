package com.ftn.domzdravlja.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.domzdravlja.model.Termin;
import com.ftn.domzdravlja.repository.TerminRepository;
import com.ftn.domzdravlja.service.TerminService;

@Service
public class TerminServiceImpl implements TerminService {
	
	@Autowired
	TerminRepository terminRepository;

	@Override
	public Termin saveTermin(Termin termin) {
		return terminRepository.save(termin);
	}

}
