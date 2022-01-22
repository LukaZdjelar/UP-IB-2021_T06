package com.ftn.domzdravlja.dto;

import java.io.Serializable;

import com.ftn.domzdravlja.model.Osoblje;
import com.ftn.domzdravlja.model.Pacijent;
import com.ftn.domzdravlja.model.Pregled;
import com.ftn.domzdravlja.model.Termin;

public class PregledDTO implements Serializable{
	
	private TerminDTO termin;
	private PacijentDTO pacijent;
	private String opis;
	
	
	public PregledDTO(Pregled pregled) {
		termin= new TerminDTO(pregled.getTermin());
		pacijent=new PacijentDTO(pregled.getPacijent());
		opis=pregled.getOpis();
	}




	public TerminDTO getTermin() {
		return termin;
	}




	public void setTermin(TerminDTO termin) {
		this.termin = termin;
	}




	public PacijentDTO getPacijent() {
		return pacijent;
	}




	public void setPacijent(PacijentDTO pacijent) {
		this.pacijent = pacijent;
	}




	public String getOpis() {
		return opis;
	}


	public void setOpis(String opis) {
		this.opis = opis;
	}

}
