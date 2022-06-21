package com.ftn.domzdravlja.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ftn.domzdravlja.dto.OsobljeDTO;
import com.ftn.domzdravlja.model.Klinika;
import com.ftn.domzdravlja.model.Osoblje;
import com.ftn.domzdravlja.service.OsobljeService;

@CrossOrigin(origins = "https://localhost:3000")
@Controller
@RequestMapping("domZdravlja/osoblje")
@PreAuthorize("hasAnyRole('ROLE_STAFF','ROLE_PATIENT')")
public class OsobljeController {

	@Autowired
	OsobljeService osobljeService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<OsobljeDTO> get(@PathVariable("id") Integer id) {
		
		Osoblje o = osobljeService.findOsobljeById(id);
		
		return new ResponseEntity<OsobljeDTO>(new OsobljeDTO(o), HttpStatus.OK);
		
	}
	
	@GetMapping(value="/klinika/{id}")
	public ResponseEntity<List<OsobljeDTO>> getByKlinika(@PathVariable("id") Integer id) {
		
		List<Osoblje> osobljeList = osobljeService.getOsobljeByKlinika(id);
		List<OsobljeDTO> dtoList = new ArrayList<OsobljeDTO>();
		for(Osoblje o: osobljeList) {
			dtoList.add(new OsobljeDTO(o));
		}
		
		return new ResponseEntity<List<OsobljeDTO>>(dtoList, HttpStatus.OK);
		
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
