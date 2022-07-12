package com.ftn.domzdravlja.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "klinika")
public class Klinika {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "klinika_id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "naziv", unique = false, nullable = false)
	private String naziv;

	@Column(name = "ocena", unique = false, nullable = false)
	private Double ocena;

	@ManyToOne
	@JoinColumn(name = "adresa_id", referencedColumnName = "adresa_id", nullable = false)
	private Adresa adresa;

	@Column(name = "opis", unique = false, nullable = false)
	private String opis;

	@OneToMany(mappedBy = "klinika", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Termin> termini;

	public Klinika() {

	}

	public Klinika(Integer id, String naziv, Adresa adresa, String opis, Double ocena) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.opis = opis;
		this.ocena = ocena;
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

	public Set<Termin> getTermini() {
		return termini;
	}

	public void setTermini(Set<Termin> termini) {
		this.termini = termini;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Double getOcena() {
		return ocena;
	}

	public void setOcena(Double ocena) {
		this.ocena = ocena;
	}

	@Override
	public String toString() {
		return "Klinika [id=" + id + ", naziv=" + naziv + ", adresa=" + adresa + ", opis=" + opis + "]";
	}

}
