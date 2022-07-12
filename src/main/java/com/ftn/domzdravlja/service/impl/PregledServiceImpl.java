package com.ftn.domzdravlja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.domzdravlja.model.Pregled;
import com.ftn.domzdravlja.repository.PregledRepository;
import com.ftn.domzdravlja.service.PregledService;

@Service
public class PregledServiceImpl implements PregledService{
	
	@Autowired
	PregledRepository pregledRepository;

	@Override
	public List<Pregled> findPregledByPacient(Integer id) {
		return pregledRepository.findPregledById(id);
	}
	
	@Override
	public List<Pregled> findAll() {
		return pregledRepository.findAll();	
	}

	@Override
	public Pregled save(Pregled pregled) {
		return pregledRepository.save(pregled);
	}
}
