package com.ftn.domzdravlja.controller;

import java.util.ArrayList; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ftn.domzdravlja.dto.KlinikaDTO;
import com.ftn.domzdravlja.model.Klinika;
import com.ftn.domzdravlja.service.KlinikaService;

@CrossOrigin(origins = "http://localhost:3000")
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
	
	@GetMapping
	public ResponseEntity<List<KlinikaDTO>> search(){
		
		List<Klinika> k = klinikaService.findAll();
		
		List<KlinikaDTO> dtoList = new ArrayList<KlinikaDTO>();
		
		for (Klinika klinika : k) {
			dtoList.add(new KlinikaDTO(klinika));
		}
		
		return new ResponseEntity<>(dtoList, HttpStatus.OK);
	}
}
