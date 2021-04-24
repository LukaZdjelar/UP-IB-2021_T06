package com.ftn.domzdravlja.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.ftn.domzdravlja.model.Termin;

public class TerminDTO implements Serializable {
	
	private Integer id;
	private Integer lekar;
	private Integer klinika;
	private Float cena;
	private Integer trajanje;
	private String datumIVreme;
	
	public TerminDTO(Termin termin) {
		id = termin.getId();
		lekar = termin.getLekar().getId();
		klinika = termin.getKlinika().getId();
		cena = termin.getCena();
		trajanje = termin.getTrajanje();
		datumIVreme = termin.getDatumIVreme().toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLekar() {
		return lekar;
	}

	public void setLekar(Integer lekar) {
		this.lekar = lekar;
	}

	public Integer getKlinika() {
		return klinika;
	}

	public void setKlinika(Integer klinika) {
		this.klinika = klinika;
	}

	public Float getCena() {
		return cena;
	}

	public void setCena(Float cena) {
		this.cena = cena;
	}

	public Integer getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(Integer trajanje) {
		this.trajanje = trajanje;
	}

	public String getDatumIVreme() {
		return datumIVreme;
	}

	public void setDatumIVreme(String datumIVreme) {
		this.datumIVreme = datumIVreme;
	}
	
}
