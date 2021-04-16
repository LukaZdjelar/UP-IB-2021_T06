package com.ftn.domzdravlja.model;

public class Administrator extends Korisnik {

	private Boolean adminKlinickogCentra;
	private Klinika klinika;
	
	public Administrator() {
		super();
	}

	public Administrator(String id, String ime, String prezime, String email, String lozinka, Adresa adresa,
			String brojTelefona, Boolean adminKlinickogCentra, Klinika klinika) {
		super(id, ime, prezime, email, lozinka, adresa, brojTelefona);
		this.adminKlinickogCentra = adminKlinickogCentra;
		this.klinika = klinika;
	}

	public Boolean getAdminKlinickogCentra() {
		return adminKlinickogCentra;
	}

	public void setAdminKlinickogCentra(Boolean adminKlinickogCentra) {
		this.adminKlinickogCentra = adminKlinickogCentra;
	}

	public Klinika getKlinika() {
		return klinika;
	}

	public void setKlinika(Klinika klinika) {
		this.klinika = klinika;
	}

	@Override
	public String toString() {
		return "Administrator [adminKlinickogCentra=" + adminKlinickogCentra + ", klinika=" + klinika + "]";
	}
}
