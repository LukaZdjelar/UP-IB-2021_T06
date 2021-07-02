package com.ftn.domzdravlja.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ftn.domzdravlja.dto.KlinikaDTO;
import com.ftn.domzdravlja.dto.TerminDTO;
import com.ftn.domzdravlja.model.Klinika;
import com.ftn.domzdravlja.model.Termin;
import com.ftn.domzdravlja.service.TerminService;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/termin")
public class TerminController {

	@Autowired
	private TerminService terminService;

	@PostMapping("/create")
	public ResponseEntity<TerminDTO> create(Termin termin, String DIVString) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime datumIVreme = LocalDateTime.parse(DIVString, formatter);

		// TEMPORARY
		termin.setDatumIVreme(datumIVreme);
		Termin save = terminService.saveTermin(termin);

		return new ResponseEntity<TerminDTO>(new TerminDTO(save), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<TerminDTO>> findAll() {
		List<Termin> termini = terminService.findAll();

		List<TerminDTO> dtoList = new ArrayList<TerminDTO>();

		for (Termin termin : termini) {
			dtoList.add(new TerminDTO(termin));
		}

		return new ResponseEntity<>(dtoList, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<TerminDTO> get(@PathVariable("id") Integer id) {
		Termin termin = terminService.findTerminById(id);
		return new ResponseEntity<TerminDTO>(new TerminDTO(termin), HttpStatus.OK);
	}
	
	@GetMapping(value="/date")
	public ResponseEntity<List<TerminDTO>> date(Date pocetni, Date krajnji){
		
		List<Termin> termin = (List<Termin>) terminService.findAllTermini(pocetni, krajnji);
		
		List<TerminDTO> terminList = new ArrayList<TerminDTO>();
		
		for (Termin ter : termin) {
			terminList.add(new TerminDTO(ter));
		}
		
		return new ResponseEntity<>(terminList, HttpStatus.OK);
	}

}
