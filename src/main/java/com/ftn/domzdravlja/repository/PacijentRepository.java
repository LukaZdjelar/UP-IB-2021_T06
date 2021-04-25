package com.ftn.domzdravlja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.domzdravlja.model.Pacijent;

public interface PacijentRepository extends JpaRepository<Pacijent, Integer>{
	
	Pacijent findPacijentById(Integer id);
	
	List<Pacijent> findAll();

}
