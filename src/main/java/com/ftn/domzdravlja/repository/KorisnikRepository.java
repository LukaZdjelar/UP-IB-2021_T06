package com.ftn.domzdravlja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.domzdravlja.model.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, String> {

	Korisnik findByEmail (String email);
}
