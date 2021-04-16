package com.ftn.domzdravlja.model;

public class Pacijent extends Korisnik {

	private String LBO;
	
	public Pacijent() {
		super();
	}

	public Pacijent(String id, String ime, String prezime, String email, String lozinka, Adresa adresa,
			String brojTelefona, String lBO) {
		super(id, ime, prezime, email, lozinka, adresa, brojTelefona);
		this.LBO = lBO;
	}

	public String getLBO() {
		return LBO;
	}

	public void setLBO(String lBO) {
		this.LBO = lBO;
	}

	@Override
	public String toString() {
		return "Pacijent [LBO=" + LBO + "]";
	}
	
}
