package com.ftn.domzdravlja.controller;

import java.util.ArrayList; 
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ftn.domzdravlja.dto.PacijentDTO;
import com.ftn.domzdravlja.model.Pacijent;
import com.ftn.domzdravlja.service.PacijentService;

@CrossOrigin(origins = "https://localhost:3000")
@Controller
@RequestMapping("domZdravlja/pacijent")
public class PacijentController {
	
	@Autowired
	PacijentService pacijentService;
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PATIENT', 'ROLE_STAFF')")
	@GetMapping(value="/{id}")
	public ResponseEntity<PacijentDTO> get(@PathVariable("id") Integer id) {
		
		Pacijent p = pacijentService.findPacijentById(id);
		
		return new ResponseEntity<PacijentDTO>(new PacijentDTO(p), HttpStatus.OK);
		
	}
	@PutMapping(value="/edit")
	public ResponseEntity<PacijentDTO> update(@RequestBody PacijentDTO pacijent) {
		
		Pacijent nadji = pacijentService.findPacijentById(pacijent.getId());
		
		nadji.setIme(pacijent.getIme());
		nadji.setPrezime(pacijent.getPrezime());
		nadji.setBrojTelefona(pacijent.getBrojTelefona());
		
		pacijentService.save(nadji);
		
		return new ResponseEntity<PacijentDTO>(new PacijentDTO(nadji), HttpStatus.OK);
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value="/waitingapproval")
	public ResponseEntity<List<PacijentDTO>> getAll() {
		List<Pacijent> pacijenti = pacijentService.findAll();
		
		List<PacijentDTO> dtoList = new ArrayList<PacijentDTO>();
		
		for (Pacijent pacijent : pacijenti) {
			if(pacijent.isApproved() == false )
				dtoList.add(new PacijentDTO(pacijent));
		}
		
		return new ResponseEntity<>(dtoList, HttpStatus.OK);
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping(value="/approve/{id}")
	public ResponseEntity<Pacijent> approve(@PathVariable ("id") Integer id) {
		Pacijent pacijent = pacijentService.findPacijentById(id);
		System.out.println(pacijent);
		pacijent.setApproved(true);
		pacijentService.save(pacijent);
		return new ResponseEntity<>(pacijent, HttpStatus.OK);
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
