package com.ftn.domzdravlja.model;

public class Pregled {

	private Termin termin;
	private Pacijent pacijent;
	private String opis;
	
	public Pregled() {
		super();
	}

	public Pregled(Termin termin, Pacijent pacijent, String opis) {
		super();
		this.termin = termin;
		this.pacijent = pacijent;
		this.opis = opis;
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

	@Override
	public String toString() {
		return "Pregled [termin=" + termin + ", pacijent=" + pacijent + ", opis=" + opis + "]";
	}
}
