package com.ftn.domzdravlja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.domzdravlja.model.Termin;

public interface TerminRepository extends JpaRepository<Termin, Integer> {
	
	public List<Termin> findAll();
	
	Termin findTerminById(Integer id);

}
