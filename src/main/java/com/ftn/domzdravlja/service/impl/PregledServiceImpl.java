package com.ftn.domzdravlja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ftn.domzdravlja.model.Pregled;
import com.ftn.domzdravlja.repository.PregledRepository;
import com.ftn.domzdravlja.service.PregledService;

public class PregledServiceImpl implements PregledService{
	
	@Autowired
	PregledRepository pregledRepository;

	@Override
	public List<Pregled> findPregledByPacient(Integer id) {
		return pregledRepository.findByPacijentById(id);
	}

}
