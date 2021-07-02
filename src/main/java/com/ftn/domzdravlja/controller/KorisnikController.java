package com.ftn.domzdravlja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ftn.domzdravlja.service.KorisnikService;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/index")
public class KorisnikController {

	@Autowired
	KorisnikService korisnikService;

}
