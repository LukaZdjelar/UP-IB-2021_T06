package com.ftn.domzdravlja.dto;

import java.io.Serializable;

import com.ftn.domzdravlja.model.Osoblje;

public class OsobljeDTO implements Serializable {

	private Integer id;
	private String ime;
	private String prezime;
	private String email;
	private String brojTelefona;
	
	public OsobljeDTO(Osoblje osoblje) {
		id=osoblje.getId();
		ime=osoblje.getIme();
		prezime=osoblje.getPrezime();
		email=osoblje.getEmail();
		brojTelefona=osoblje.getBrojTelefona();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBrojTelefona() {
		return brojTelefona;
	}
	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

}
