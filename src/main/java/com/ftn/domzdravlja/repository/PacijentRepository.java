package com.ftn.domzdravlja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.domzdravlja.model.Pacijent;

public interface PacijentRepository extends JpaRepository<Pacijent, Integer>{
	
	Pacijent findPacijentById(Integer id);

}
