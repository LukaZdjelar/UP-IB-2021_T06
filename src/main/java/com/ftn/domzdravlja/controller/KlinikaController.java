package com.ftn.domzdravlja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ftn.domzdravlja.dto.KlinikaDTO;
import com.ftn.domzdravlja.model.Klinika;
import com.ftn.domzdravlja.service.KlinikaService;

@Controller
@RequestMapping(value="/klinika")
public class KlinikaController {
	
	@Autowired
	KlinikaService klinikaService;

	@PutMapping("/edit")
	public ResponseEntity<KlinikaDTO> update(Klinika klinika){
		
		Klinika nadji = klinikaService.findKlinikaById(klinika.getId());
		klinika.setAdresa(nadji.getAdresa());
		
		Klinika k = klinikaService.save(klinika);
		
		return new ResponseEntity<KlinikaDTO>(new KlinikaDTO(k), HttpStatus.OK);
	}
}
