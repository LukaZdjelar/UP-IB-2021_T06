package com.ftn.domzdravlja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.domzdravlja.model.Klinika;

public interface KlinikaRepository extends JpaRepository<Klinika, Integer> {
	
	Klinika findKlinikaById(Integer id);

}
