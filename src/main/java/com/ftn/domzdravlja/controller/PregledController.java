package com.ftn.domzdravlja.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ftn.domzdravlja.dto.PregledDTO;
import com.ftn.domzdravlja.model.Pregled;
import com.ftn.domzdravlja.service.PregledService;


@Controller
@RequestMapping(value="/pregled")
public class PregledController {
	
	@Autowired
	PregledService pregledService;
	
	@GetMapping("/{id}")
	public ResponseEntity<List<PregledDTO>> search(Integer id){
		
		List<Pregled> p = pregledService.findPregledByPacient(id);
		
		List<PregledDTO> dtoList = new ArrayList<PregledDTO>();
		
		for (Pregled pregled : p) {
			dtoList.add(new PregledDTO(pregled));
		}
		
		return new ResponseEntity<>(dtoList, HttpStatus.OK);
	}

}