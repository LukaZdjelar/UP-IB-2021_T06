package com.ftn.domzdravlja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="osoblje")
public class Osoblje extends Korisnik {

	@Column(name="lekar", unique=false, nullable=false)
	private Boolean lekar;
	
	@ManyToOne
	@JoinColumn(name="klinika_id", referencedColumnName="klinika_id", nullable=false)
	private Klinika klinika;
	
	public Osoblje() {
		super();
	}

	public Osoblje(Integer id, String ime, String prezime, String email, String lozinka, Adresa adresa,
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
