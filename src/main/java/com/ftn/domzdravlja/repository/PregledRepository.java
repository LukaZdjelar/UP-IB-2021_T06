package com.ftn.domzdravlja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.domzdravlja.model.Pregled;

public interface PregledRepository extends JpaRepository<Pregled, Integer>{

	public List<Pregled> findPregledById(Integer id);
}
