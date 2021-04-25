package com.ftn.domzdravlja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.domzdravlja.model.Klinika;

public interface KlinikaRepository extends JpaRepository<Klinika, Integer> {
	
	Klinika findKlinikaById(Integer id);
	
	List<Klinika> findAll();

}
