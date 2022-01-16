package com.ftn.domzdravlja.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ftn.domzdravlja.dto.KlinikaDTO;
import com.ftn.domzdravlja.model.Adresa;
import com.ftn.domzdravlja.model.Klinika;
import com.ftn.domzdravlja.service.KlinikaService;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping(value="domZdravlja/klinika")
public class KlinikaController {
	
	@Autowired
	KlinikaService klinikaService;

	@PutMapping("/edit")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<KlinikaDTO> update(Klinika klinika){
		
		Klinika nadji = klinikaService.findKlinikaById(klinika.getId());
		klinika.setAdresa(nadji.getAdresa());
		
		Klinika k = klinikaService.save(klinika);
		
		return new ResponseEntity<KlinikaDTO>(new KlinikaDTO(k), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<KlinikaDTO> > search(@RequestParam(name = "pocetniDatum", required = false)  String pocetniDatum,@RequestParam(name ="krajnjiDatum", required = false)  String krajnjiDatum,
			@RequestParam(name ="lokacija", required = false) String lokacija, @RequestParam(name ="ocena", required = false) Double ocena){
		
		List<Klinika> k = klinikaService.findAll();
		if(pocetniDatum != null) {
			ZoneOffset contractualOffset = ZoneOffset.UTC;
			LocalDateTime pocetniDate = OffsetDateTime
		            .parse(pocetniDatum, DateTimeFormatter.RFC_1123_DATE_TIME)
		            .withOffsetSameInstant(contractualOffset)
		            .toLocalDateTime();
			k=k.stream().filter(x->x.getTermini().stream().anyMatch(t->t.getDatumIVreme().isAfter(pocetniDate))).collect(Collectors.toList());
		}
		if(krajnjiDatum != null) {
			ZoneOffset contractualOffset = ZoneOffset.UTC;
			LocalDateTime krajnjiDate = OffsetDateTime
		            .parse(krajnjiDatum, DateTimeFormatter.RFC_1123_DATE_TIME)
		            .withOffsetSameInstant(contractualOffset)
		            .toLocalDateTime();
			k=k.stream().filter(x->x.getTermini().stream().anyMatch(t->t.getDatumIVreme().isBefore(krajnjiDate))).collect(Collectors.toList());
		}
		if(lokacija != null) {
			k=k.stream().filter(x->x.getAdresa().getUlica().equals(lokacija)).collect(Collectors.toList());
		}
		if(ocena != null) {
			k=k.stream().filter(x->x.getOcena().equals(ocena)).collect(Collectors.toList());
		}
		List<KlinikaDTO> dtoList = new ArrayList<KlinikaDTO>();
		for (Klinika klinika : k) {
			dtoList.add(new KlinikaDTO(klinika));
		}
		
		
		return new ResponseEntity<>(dtoList, HttpStatus.OK);
	}
	
}
