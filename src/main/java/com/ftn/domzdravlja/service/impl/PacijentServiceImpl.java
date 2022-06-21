package com.ftn.domzdravlja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ftn.domzdravlja.model.Korisnik;
import com.ftn.domzdravlja.model.Pacijent;
import com.ftn.domzdravlja.repository.PacijentRepository;
import com.ftn.domzdravlja.service.PacijentService;

@Service
public class PacijentServiceImpl implements PacijentService{
	
	
	@Autowired
	PacijentRepository pacijentRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public Pacijent findPacijentById(Integer id) {
		Pacijent pacijent = pacijentRepository.findPacijentById(id);
		return pacijent;
	}

	@Override
	public Pacijent save(Pacijent pacijent) {
		String endcoderPassword = this.passwordEncoder.encode(pacijent.getLozinka());
		pacijent.setLozinka(endcoderPassword);
		return pacijentRepository.save(pacijent);
	}
	
	@Override
	public List<Pacijent> findAll() {
		return pacijentRepository.findAll();
	}

}
