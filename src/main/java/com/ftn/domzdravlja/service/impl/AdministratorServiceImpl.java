package com.ftn.domzdravlja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	PasswordEncoder passwordEncoder;
	@Override
	public Administrator findAdministratorById(Integer id) {
		Administrator administrator = administratorRepository.findAdministratorById(id);
		// System.out.println(administrator.getIme());
		return administrator;
	}

	@Override
	public Administrator save(Administrator administrator) {
		String endcoderPassword = this.passwordEncoder.encode(administrator.getLozinka());
		administrator.setLozinka(endcoderPassword);
		return administratorRepository.save(administrator);
	}

	@Override
	public List<Administrator> findAll() {
		return administratorRepository.findAll();
	}

}
