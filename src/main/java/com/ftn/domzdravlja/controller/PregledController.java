package com.ftn.domzdravlja.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ftn.domzdravlja.dto.PregledDTO;
import com.ftn.domzdravlja.dto.TerminDTO;
import com.ftn.domzdravlja.model.Korisnik;
import com.ftn.domzdravlja.model.Pregled;
import com.ftn.domzdravlja.model.Termin;
import com.ftn.domzdravlja.service.PregledService;

@CrossOrigin(origins = "https://localhost:3000")
@Controller
@RequestMapping(value="domZdravlja/pregled")
public class PregledController {
	
	@Autowired
	PregledService pregledService;
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_STAFF')")
	public ResponseEntity<List<PregledDTO>> search(Integer id){
		
		
		List<Pregled> p = pregledService.findPregledByPacient(id);
		
		List<PregledDTO> dtoList = new ArrayList<PregledDTO>();
		
		for (Pregled pregled : p) {
				dtoList.add(new PregledDTO(pregled));
		}
		
		return new ResponseEntity<>(dtoList, HttpStatus.OK);
	}
	@PreAuthorize("hasRole('ROLE_STAFF')")
	@GetMapping
	public ResponseEntity<List<PregledDTO>> findAll() {
		List<Pregled> pregledi = pregledService.findAll();
		
		List<PregledDTO> dtoList = new ArrayList<PregledDTO>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Korisnik ulogovan = (Korisnik) authentication.getPrincipal();
		
		for (Pregled pregled : pregledi) {
			if( ulogovan.getId().equals(pregled.getTermin().getLekar().getId())) {
				dtoList.add(new PregledDTO(pregled));
				System.out.println(pregled.getId());
			}
		}
		return new ResponseEntity<>(dtoList, HttpStatus.OK);
	}

}
