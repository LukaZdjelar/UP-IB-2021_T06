package com.ftn.domzdravlja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="klinika")
public class Klinika {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="klinika_id", unique=true, nullable=false)
	private Integer id;
	
	@Column(name="naziv", unique=false, nullable=false)
	private String naziv;
	
	@ManyToOne
	@JoinColumn(name="adresa_id", referencedColumnName="adresa_id", nullable=false)
	private Adresa adresa;
	
	@Column(name="opis", unique=false, nullable=false)
	private String opis;
	
	public Klinika() {
		
	}

	public Klinika(Integer id, String naziv, Adresa adresa, String opis) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.opis = opis;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	@Override
	public String toString() {
		return "Klinika [id=" + id + ", naziv=" + naziv + ", adresa=" + adresa + ", opis=" + opis + "]";
	}
	
}
