package com.ftn.domzdravlja.service;

import java.util.Date;
import java.util.List;

import com.ftn.domzdravlja.model.Termin;

public interface TerminService {

	Termin saveTermin(Termin termin);
	
	List<Termin> findAll();
	
	Termin findTerminById(Integer id);
	
	Termin findAllTermini(Date pocetni, Date krajnji);
}
