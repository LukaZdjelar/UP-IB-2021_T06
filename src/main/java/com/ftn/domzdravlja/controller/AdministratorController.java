package com.ftn.domzdravlja.controller;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ftn.domzdravlja.dto.AdministratorDTO;
import com.ftn.domzdravlja.dto.KlinikaDTO;
import com.ftn.domzdravlja.dto.OsobljeDTO;
import com.ftn.domzdravlja.dto.PacijentDTO;
import com.ftn.domzdravlja.model.Administrator;
import com.ftn.domzdravlja.model.Klinika;
import com.ftn.domzdravlja.model.Korisnik;
import com.ftn.domzdravlja.model.Osoblje;
import com.ftn.domzdravlja.model.Pacijent;
import com.ftn.domzdravlja.service.AdministratorService;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("domZdravlja/admin")
public class AdministratorController {
	
	@Autowired
	AdministratorService administratorService;
	
	@GetMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<List<AdministratorDTO>> findAll(){
		
		List<Administrator> administratori = administratorService.findAll();
		List<AdministratorDTO> dtoList = new ArrayList<AdministratorDTO>();
		
		for(Administrator administrator:administratori) {
			dtoList.add(new AdministratorDTO(administrator));
		}
		
		return new ResponseEntity<>(dtoList, HttpStatus.OK);
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value="/{id}")
	public ResponseEntity<AdministratorDTO> get(@PathVariable("id") Integer id) {
		
		Administrator a = administratorService.findAdministratorById(id);
		
		return new ResponseEntity<AdministratorDTO>(new AdministratorDTO(a), HttpStatus.OK);
		
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping(value="/edit")
	public ResponseEntity<AdministratorDTO> update(Administrator administrator){
		
		Administrator nadji = administratorService.findAdministratorById(administrator.getId());
		administrator.setAdresa(nadji.getAdresa());
		Administrator a = administratorService.save(administrator);
		
		return new ResponseEntity<AdministratorDTO>(new AdministratorDTO(a), HttpStatus.OK);
	}
}
