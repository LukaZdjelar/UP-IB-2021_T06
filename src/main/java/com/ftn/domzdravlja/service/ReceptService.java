package com.ftn.domzdravlja.service;

import java.util.List;

import com.ftn.domzdravlja.model.Recept;

public interface ReceptService {

	Recept findReceptById(Integer id);
	
	List<Recept> findAll();
	
	void delete(Recept recept);
	
	Recept save(Recept recept);
	
}
