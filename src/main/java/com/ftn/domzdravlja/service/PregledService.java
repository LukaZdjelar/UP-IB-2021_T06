package com.ftn.domzdravlja.service;

import java.util.List;

import com.ftn.domzdravlja.model.Pacijent;
import com.ftn.domzdravlja.model.Pregled;

public interface PregledService {

	List<Pregled> findPregledByPacient(Integer id);
	
}
