package com.ftn.domzdravlja.model;

public class Osoblje extends Korisnik {

	private Boolean lekar;
	private Klinika klinika;
	
	public Osoblje() {
		super();
	}

	public Osoblje(String id, String ime, String prezime, String email, String lozinka, Adresa adresa,
			String brojTelefona, Boolean lekar, Klinika klinika) {
		super(id, ime, prezime, email, lozinka, adresa, brojTelefona);
		this.lekar = lekar;
		this.klinika = klinika;
	}

	public Boolean getLekar() {
		return lekar;
	}

	public void setLekar(Boolean lekar) {
		this.lekar = lekar;
	}

	public Klinika getKlinika() {
		return klinika;
	}

	public void setKlinika(Klinika klinika) {
		this.klinika = klinika;
	}

	@Override
	public String toString() {
		return "Osoblje [lekar=" + lekar + ", klinika=" + klinika + "]";
	}
	
}
