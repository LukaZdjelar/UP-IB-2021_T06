package com.ftn.domzdravlja.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.domzdravlja.dto.ReceptDTO;
import com.ftn.domzdravlja.model.Recept;
import com.ftn.domzdravlja.service.ReceptService;

@RestController
@CrossOrigin(origins = "https://localhost:3000")
@RequestMapping(value = "domZdravlja/recept")
public class ReceptController {

	@Autowired
	ReceptService receptService;
	
	@GetMapping
	@PreAuthorize("hasAnyRole('ROLE_NURSE','ROLE_ADMIN')")
	public ResponseEntity<List<ReceptDTO>> findAll() {
		
		List<Recept> recepti = receptService.findAll();
		
		List<ReceptDTO> dtoList = new ArrayList<ReceptDTO>();
		
		for ( Recept recept : recepti ) {
			dtoList.add(new ReceptDTO(recept));
		}
		
		return new ResponseEntity<>(dtoList, HttpStatus.OK);
	}
	
	@PostMapping
	@PreAuthorize("hasAnyRole('ROLE_NURSE','ROLE_ADMIN')")
	public ResponseEntity<ReceptDTO> create(Recept recept) {
		receptService.save(recept);
		return new ResponseEntity<ReceptDTO>(new ReceptDTO(recept), HttpStatus.OK);
	}
	@PreAuthorize("hasRole('ROLE_NURSE')")
	@PutMapping(value = "/overi/{id}")
	public ResponseEntity<Recept> overi(@PathVariable("id") Integer id) {
		Recept recept = receptService.findReceptById(id);
		recept.setOveren(true);
		receptService.save(recept);
		return new ResponseEntity<>(recept, HttpStatus.OK);
	}
	
}
