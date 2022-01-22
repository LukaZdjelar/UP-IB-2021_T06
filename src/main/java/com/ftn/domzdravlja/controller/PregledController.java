package com.ftn.domzdravlja.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ftn.domzdravlja.dto.PregledDTO;
import com.ftn.domzdravlja.dto.TerminDTO;
import com.ftn.domzdravlja.model.Korisnik;
import com.ftn.domzdravlja.model.Pacijent;
import com.ftn.domzdravlja.model.Pregled;
import com.ftn.domzdravlja.model.Termin;
import com.ftn.domzdravlja.service.PacijentService;
import com.ftn.domzdravlja.service.PregledService;
import com.ftn.domzdravlja.service.TerminService;

@CrossOrigin(origins = "https://localhost:3000")
@Controller
@RequestMapping(value="domZdravlja/pregled")
public class PregledController {
	
	@Autowired
	PregledService pregledService;
	
	@Autowired
	TerminService terminService;
	
	@Autowired
	PacijentService pacijentService;
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAnyRole('ROLE_STAFF','ROLE_PATIENT')")
	public ResponseEntity<List<PregledDTO>> search(Integer id){
		
		
		List<Pregled> p = pregledService.findPregledByPacient(id);
		
		List<PregledDTO> dtoList = new ArrayList<PregledDTO>();
		
		for (Pregled pregled : p) {
				dtoList.add(new PregledDTO(pregled));
		}
		
		return new ResponseEntity<>(dtoList, HttpStatus.OK);
	}
	@PreAuthorize("hasAnyRole('ROLE_STAFF','ROLE_PATIENT')")
	@GetMapping
	public ResponseEntity<List<PregledDTO>> findAll() {
		List<Pregled> pregledi = pregledService.findAll();
		
		List<PregledDTO> dtoList = new ArrayList<PregledDTO>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Korisnik ulogovan = (Korisnik) authentication.getPrincipal();
		
		for (Pregled pregled : pregledi) {
			if( ulogovan.getId().equals(pregled.getPacijent().getId())) {
				dtoList.add(new PregledDTO(pregled));
				System.out.println(pregled.getId());
			}
		}
		return new ResponseEntity<>(dtoList, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_STAFF','ROLE_PATIENT')")
	@PostMapping(value = "/{id}")
	public ResponseEntity<PregledDTO> update(@PathVariable ("id") Integer id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Korisnik ulogovan = (Korisnik) authentication.getPrincipal();
		Termin termin = terminService.findTerminById(id);
		Pacijent pacijent = pacijentService.findPacijentById(ulogovan.getId());
		Pregled newPregled = new Pregled();
		newPregled.setTermin(termin);
		newPregled.setPacijent(pacijent);
		newPregled.setOpis("MOJ super pregled");
		pregledService.save(newPregled);
		
		return new ResponseEntity<>(new PregledDTO(newPregled), HttpStatus.OK);

	
	}

}
