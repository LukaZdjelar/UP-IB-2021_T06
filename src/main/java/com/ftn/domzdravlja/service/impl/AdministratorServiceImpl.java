package com.ftn.domzdravlja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.domzdravlja.model.Administrator;
import com.ftn.domzdravlja.model.Klinika;
import com.ftn.domzdravlja.model.Osoblje;
import com.ftn.domzdravlja.repository.AdministratorRepository;
import com.ftn.domzdravlja.service.AdministratorService;

@Service
public class AdministratorServiceImpl implements AdministratorService {

	@Autowired
	AdministratorRepository administratorRepository;

	@Override
	public Administrator findAdministratorById(Integer id) {
		Administrator administrator = administratorRepository.findAdministratorById(id);
		// System.out.println(administrator.getIme());
		return administrator;
	}

	@Override
	public Administrator save(Administrator administrator) {

		return administratorRepository.save(administrator);
	}

	@Override
	public List<Administrator> findAll() {
		return administratorRepository.findAll();
	}

}
