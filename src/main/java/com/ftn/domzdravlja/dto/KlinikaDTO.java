package com.ftn.domzdravlja.dto;

import java.io.Serializable;

import com.ftn.domzdravlja.model.Adresa;
import com.ftn.domzdravlja.model.Klinika;

public class KlinikaDTO implements Serializable {

	private Integer id;
	private String naziv;
	private AdresaDTO adresa;
	private String opis;
	private Double ocena;

	public KlinikaDTO(Klinika klinika) {
		id=klinika.getId();
		naziv=klinika.getNaziv();
		opis=klinika.getOpis();
		ocena=klinika.getOcena();
		adresa = new AdresaDTO(klinika.getAdresa());
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

	public Double getOcena() {
		return ocena;
	}

	public void setOcena(Double ocena) {
		this.ocena = ocena;
	}

	public AdresaDTO getAdresa() {
		return adresa;
	}

	public void setAdresa(AdresaDTO adresa) {
		this.adresa = adresa;
	}
	
	

}
