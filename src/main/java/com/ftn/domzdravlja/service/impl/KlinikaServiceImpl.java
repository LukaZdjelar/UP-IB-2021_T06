package com.ftn.domzdravlja.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.domzdravlja.model.Klinika;
import com.ftn.domzdravlja.repository.KlinikaRepository;
import com.ftn.domzdravlja.service.KlinikaService;

@Service
public class KlinikaServiceImpl implements KlinikaService {
	
	@Autowired
	KlinikaRepository klinikaRepository;

	@Override
	public Klinika findKlinikaById(Integer id) {
		return klinikaRepository.findKlinikaById(id);
	}

	@Override
	public Klinika save(Klinika klinika) {
		return klinikaRepository.save(klinika);
	}

}
