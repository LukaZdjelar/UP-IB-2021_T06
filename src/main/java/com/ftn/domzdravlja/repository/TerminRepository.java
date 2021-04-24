package com.ftn.domzdravlja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.domzdravlja.model.Termin;

public interface TerminRepository extends JpaRepository<Termin, Integer> {
	
	

}
