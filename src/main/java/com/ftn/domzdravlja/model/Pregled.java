package com.ftn.domzdravlja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pregled")
public class Pregled {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pregled_id", unique=true, nullable=false)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="termin_id", referencedColumnName="termin_id", nullable=false)
	private Termin termin;
	
	@ManyToOne
	@JoinColumn(name="pacijent", referencedColumnName="korisnik_id", nullable=false)
	private Pacijent pacijent;
	
	@Column(name="opis", unique=false, nullable=false)
	private String opis;
	
	public Pregled() {
		super();
	}

	public Pregled(Integer id, Termin termin, Pacijent pacijent, String opis) {
		super();
		this.termin = termin;
		this.pacijent = pacijent;
		this.opis = opis;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return "Pregled [id=" + id + ", termin=" + termin + ", pacijent=" + pacijent + ", opis=" + opis + "]";
	}
}
