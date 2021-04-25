package com.ftn.domzdravlja.dto;

import java.io.Serializable;

import com.ftn.domzdravlja.model.Adresa;
import com.ftn.domzdravlja.model.Klinika;

public class KlinikaDTO implements Serializable{
	
	private Integer id;
	private String naziv;
//	private Adresa adresa;
	private String opis;

	public KlinikaDTO(Klinika klinika) {
		id=klinika.getId();
		naziv=klinika.getNaziv();
		opis=klinika.getOpis();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
	
}
