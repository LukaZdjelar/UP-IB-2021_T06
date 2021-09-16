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

import com.ftn.domzdravlja.dto.PacijentDTO;
import com.ftn.domzdravlja.model.Pacijent;
import com.ftn.domzdravlja.service.PacijentService;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/pacijent")
@PreAuthorize("hasRole('PATIENT')")
public class PacijentController {
	
	@Autowired
	PacijentService pacijentService;

	
	@GetMapping(value="/{id}")
	public ResponseEntity<PacijentDTO> get(@PathVariable("id") Integer id) {
		
		Pacijent p = pacijentService.findPacijentById(id);
		
		return new ResponseEntity<PacijentDTO>(new PacijentDTO(p), HttpStatus.OK);
		
	}
	@PutMapping(value="/edit")
	public ResponseEntity<PacijentDTO> update(Pacijent pacijent) {
		
		Pacijent nadji = pacijentService.findPacijentById(pacijent.getId());
		
		pacijent.setAdresa(nadji.getAdresa());
		pacijent.setLBO(nadji.getLBO());
		
		Pacijent p = pacijentService.save(pacijent);
		
		return new ResponseEntity<PacijentDTO>(new PacijentDTO(p), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<PacijentDTO>> search(){
		
		List<Pacijent> pacijenti = pacijentService.findAll();
		
		List<PacijentDTO> dtoList = new ArrayList<PacijentDTO>();
		
		for (Pacijent pacijent : pacijenti) {
			dtoList.add(new PacijentDTO(pacijent));
		}
		
		return new ResponseEntity<>(dtoList, HttpStatus.OK);
	}
}
