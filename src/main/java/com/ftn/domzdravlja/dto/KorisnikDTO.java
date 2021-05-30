package com.ftn.domzdravlja.dto;

import java.io.Serializable;

public class KorisnikDTO implements Serializable {

	private Integer id;
	private String email;
	private String password;
	private String ime;

	public KorisnikDTO(Integer id, String email, String password, String ime) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.ime = ime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

}
