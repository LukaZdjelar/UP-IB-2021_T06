package com.ftn.domzdravlja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.domzdravlja.model.Osoblje;

public interface OsobljeRepository extends JpaRepository<Osoblje, Integer> {
	
	Osoblje findOsobljeById(Integer id);
	
	List<Osoblje> findAllByKlinika_Id(Integer klinikaId);

}
