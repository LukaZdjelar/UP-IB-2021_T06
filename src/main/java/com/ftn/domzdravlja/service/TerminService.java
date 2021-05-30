package com.ftn.domzdravlja.service;

import java.util.List;

import com.ftn.domzdravlja.model.Termin;

public interface TerminService {

	Termin saveTermin(Termin termin);
	
	List<Termin> findAll();
	
	Termin findTerminById(Integer id);
}
