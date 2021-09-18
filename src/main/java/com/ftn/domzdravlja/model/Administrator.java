package com.ftn.domzdravlja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="administrator")
public class Administrator extends Korisnik {

	@Column(name="adminKlinickogCentra", unique=false, nullable=false)
	private Boolean adminKlinickogCentra;
	
	@ManyToOne
	@JoinColumn(name="klinika_id", referencedColumnName="klinika_id", nullable=false)
	private Klinika klinika;
	
	public Administrator() {
		super();
	}

	

	public Administrator(Integer id, String ime, String prezime, String email, String lozinka, Adresa adresa,
			String brojTelefona, boolean approved, Boolean adminKlinickogCentra, Klinika klinika) {
		super(id, ime, prezime, email, lozinka, adresa, brojTelefona, approved);
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
