package com.ftn.domzdravlja.service;

import com.ftn.domzdravlja.model.Korisnik;

public interface KorisnikService {
	
	Korisnik findKorisnik (String email);
	
}
