package com.ftn.domzdravlja.service.impl;

import java.util.Date;
import java.util.List;

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
	
	@Override
	public List<Termin> findAll() {
		return terminRepository.findAll();
	}
	
	@Override
	public Termin findTerminById(Integer id) {
		Termin termin = terminRepository.findTerminById(id);
		return termin;
	}

	@Override
	public Termin findAllTermini(Date pocetni, Date krajnji) {
		Termin termin = ((TerminService) terminRepository).findAllTermini(pocetni,krajnji);
		return termin;
	}

}
