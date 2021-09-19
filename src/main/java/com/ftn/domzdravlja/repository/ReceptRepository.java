package com.ftn.domzdravlja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.domzdravlja.model.Recept;

public interface ReceptRepository extends JpaRepository<Recept, Integer>{

	List<Recept> findAll();
	
	Recept findReceptById(Integer id);
	
}
