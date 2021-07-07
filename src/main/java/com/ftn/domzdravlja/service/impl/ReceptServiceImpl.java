package com.ftn.domzdravlja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.domzdravlja.model.Recept;
import com.ftn.domzdravlja.repository.ReceptRepository;
import com.ftn.domzdravlja.service.ReceptService;

@Service
public class ReceptServiceImpl implements ReceptService {

	@Autowired
	ReceptRepository receptRepository;
	
	public Recept findReceptById(Integer id) {
		Recept recept = receptRepository.findReceptById(id);
		return recept;
	}
	
	@Override
	public Recept save(Recept recept) {
		return receptRepository.save(recept);
	}
	
	@Override
	public void delete(Recept recept) {
		receptRepository.delete(recept);
	}
	
	public List<Recept> findAll() {
		return receptRepository.findAll();
	}
	
}
