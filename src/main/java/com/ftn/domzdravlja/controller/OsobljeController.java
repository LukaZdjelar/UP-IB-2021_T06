package com.ftn.domzdravlja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ftn.domzdravlja.dto.OsobljeDTO;
import com.ftn.domzdravlja.model.Osoblje;
import com.ftn.domzdravlja.service.OsobljeService;

@Controller
@RequestMapping("/osoblje")
@PreAuthorize("hasRole('STAFF')")
public class OsobljeController {

	@Autowired
	OsobljeService osobljeService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<OsobljeDTO> get(@PathVariable("id") Integer id) {
		
		Osoblje o = osobljeService.findOsobljeById(id);
		
		return new ResponseEntity<OsobljeDTO>(new OsobljeDTO(o), HttpStatus.OK);
		
	}
	
	@PutMapping(value="/edit")
	public ResponseEntity<OsobljeDTO> update(Osoblje osoblje) {
		
		Osoblje nadji = osobljeService.findOsobljeById(osoblje.getId());
		osoblje.setAdresa(nadji.getAdresa());
		osoblje.setKlinika(nadji.getKlinika());
		osoblje.setLekar(nadji.getLekar());
		Osoblje o = osobljeService.save(osoblje);
		
		return new ResponseEntity<OsobljeDTO>(new OsobljeDTO(o), HttpStatus.OK);
	}
}
