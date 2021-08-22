package com.ftn.domzdravlja.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.domzdravlja.model.Korisnik;
import com.ftn.domzdravlja.repository.KorisnikRepository;
import com.ftn.domzdravlja.service.KorisnikService;

@Service
public class KorisnikServiceImpl implements KorisnikService {

	@Autowired
	KorisnikRepository korisnikRepository;

	@Override
	public Korisnik findKorisnik(String email) {
		Korisnik korisnik = korisnikRepository.findByEmail(email);
		return korisnik;
	}

	@Override
	public Korisnik findById(Integer id) {
		if (korisnikRepository.findById(id).isPresent()){
			return korisnikRepository.findById(id).get();
		}else {
			return null;
		}

	}

}
