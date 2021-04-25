package com.ftn.domzdravlja.dto;

import java.io.Serializable;

import com.ftn.domzdravlja.model.Osoblje;
import com.ftn.domzdravlja.model.Pacijent;
import com.ftn.domzdravlja.model.Pregled;
import com.ftn.domzdravlja.model.Termin;

public class PregledDTO implements Serializable{
	
	private Termin termin;
	private Pacijent pacijent;
	private String opis;
	
	
	public PregledDTO(Pregled pregled) {
		termin=pregled.getTermin();
		pacijent=pregled.getPacijent();
		opis=pregled.getOpis();
	}


	public Termin getTermin() {
		return termin;
	}


	public void setTermin(Termin termin) {
		this.termin = termin;
	}


	public Pacijent getPacijent() {
		return pacijent;
	}


	public void setPacijent(Pacijent pacijent) {
		this.pacijent = pacijent;
	}


	public String getOpis() {
		return opis;
	}


	public void setOpis(String opis) {
		this.opis = opis;
	}

}
