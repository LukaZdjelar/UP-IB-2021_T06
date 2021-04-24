package com.ftn.domzdravlja.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ftn.domzdravlja.dto.TerminDTO;
import com.ftn.domzdravlja.model.Termin;
import com.ftn.domzdravlja.service.KlinikaService;
import com.ftn.domzdravlja.service.OsobljeService;
import com.ftn.domzdravlja.service.TerminService;

@Controller
@RequestMapping("/termin")
public class TerminController {
	
	@Autowired
	private TerminService terminService;
	
	@Autowired
	private OsobljeService osobljeService;
	
	@Autowired
	private KlinikaService klinikaService;
	
	@PostMapping("/create")
	public ResponseEntity<TerminDTO> create(Termin termin) {
		
		//TEMPORARY
		termin.setDatumIVreme(LocalDateTime.now());
		Termin save = terminService.saveTermin(termin);
		
		return new ResponseEntity<TerminDTO>(new TerminDTO(save), HttpStatus.OK);
	}

}
