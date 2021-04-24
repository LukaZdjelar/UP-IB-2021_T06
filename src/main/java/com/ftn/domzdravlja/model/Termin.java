package com.ftn.domzdravlja.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="termin")
public class Termin {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="termin_id", unique=true, nullable=false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="lekar", referencedColumnName="korisnik_id", nullable=false)
	private Osoblje lekar;
	
	@ManyToOne
	@JoinColumn(name="klinika_id", referencedColumnName="klinika_id", nullable=false)
	private Klinika klinika;
	
	@Column(name="datumivreme", unique=false, nullable=false)
	private LocalDateTime datumIVreme;
	
	@Column(name="cena", unique=false, nullable=false)
	private Float cena;
	
	@Column(name="trajanje", unique=false, nullable=false)
	private Integer trajanje;
	
	public Termin() {
		super();
	}

	public Termin(Integer id, Osoblje lekar, Klinika klinika, LocalDateTime datumIVreme, Float cena, Integer trajanje) {
		super();
		this.id = id;
		this.lekar = lekar;
		this.klinika = klinika;
		this.datumIVreme = datumIVreme;
		this.cena = cena;
		this.trajanje = trajanje;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Osoblje getLekar() {
		return lekar;
	}

	public void setLekar(Osoblje lekar) {
		this.lekar = lekar;
	}

	public Klinika getKlinika() {
		return klinika;
	}

	public void setKlinika(Klinika klinika) {
		this.klinika = klinika;
	}

	public LocalDateTime getDatumIVreme() {
		return datumIVreme;
	}

	public void setDatumIVreme(LocalDateTime datumIVreme) {
		this.datumIVreme = datumIVreme;
	}

	public Float getCena() {
		return cena;
	}

	public void setCena(Float cena) {
		this.cena = cena;
	}

	public Integer getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(Integer trajanje) {
		this.trajanje = trajanje;
	}

	@Override
	public String toString() {
		return "Termin [id=" + id + ", lekar=" + lekar + ", klinika=" + klinika + ", datumIVreme=" + datumIVreme
				+ ", cena=" + cena + ", trajanje=" + trajanje + "]";
	}
}
