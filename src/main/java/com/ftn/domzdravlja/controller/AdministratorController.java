package com.ftn.domzdravlja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ftn.domzdravlja.dto.AdministratorDTO;
import com.ftn.domzdravlja.model.Administrator;
import com.ftn.domzdravlja.model.Korisnik;
import com.ftn.domzdravlja.service.AdministratorService;

@Controller
@RequestMapping("/admin")
public class AdministratorController {
	
	@Autowired
	AdministratorService administratorService;

	@GetMapping(value="/{id}")
	public ResponseEntity<AdministratorDTO> get(@PathVariable("id") Integer id) {
		
		Administrator a = administratorService.findAdministratorById(id);
		
		return new ResponseEntity<AdministratorDTO>(new AdministratorDTO(a), HttpStatus.OK);
		
	}
	
	@PutMapping(value="/edit")
	public ResponseEntity<AdministratorDTO> update(Administrator administrator){
		
		Administrator nadji = administratorService.findAdministratorById(administrator.getId());
		administrator.setAdresa(nadji.getAdresa());
		Administrator a = administratorService.save(administrator);
		
		return new ResponseEntity<AdministratorDTO>(new AdministratorDTO(a), HttpStatus.OK);
	}
}
