package com.ftn.domzdravlja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.domzdravlja.model.Osoblje;
import com.ftn.domzdravlja.repository.OsobljeRepository;
import com.ftn.domzdravlja.service.OsobljeService;

@Service
public class OsobljeServiceImpl implements OsobljeService {

	@Autowired
	OsobljeRepository osobljeRepository;

	@Override
	public Osoblje findOsobljeById(Integer id) {
		Osoblje osoblje = osobljeRepository.findOsobljeById(id);
		return osoblje;
	}

	@Override
	public Osoblje save(Osoblje osoblje) {
		return osobljeRepository.save(osoblje);
	}

	@Override
	public List<Osoblje> getOsobljeByKlinika(Integer klinikaId) {
		return osobljeRepository.findAllByKlinika_Id(klinikaId);
	}
}
