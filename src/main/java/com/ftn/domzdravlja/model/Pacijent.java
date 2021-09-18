package com.ftn.domzdravlja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="pacijent")
public class Pacijent extends Korisnik {

	@Column(name="lbo", unique=true, nullable=false)
	private String LBO;
	
	public Pacijent() {
		super();
	}

	

	public Pacijent(Integer id, String ime, String prezime, String email, String lozinka, Adresa adresa,
			String brojTelefona, boolean approved, String lBO) {
		super(id, ime, prezime, email, lozinka, adresa, brojTelefona, approved);
		LBO = lBO;
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
