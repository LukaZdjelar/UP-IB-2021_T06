package com.ftn.domzdravlja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ftn.domzdravlja.dto.KorisnikDTO;
import com.ftn.domzdravlja.model.Korisnik;
import com.ftn.domzdravlja.service.KorisnikService;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/index")
public class KorisnikController {

	@Autowired
	KorisnikService korisnikService;

	

}
