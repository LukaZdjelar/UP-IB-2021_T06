package com.ftn.domzdravlja.model;

import java.time.LocalDateTime;

public class Termin {

	private Osoblje lekar;
	private Klinika klinika;
	private LocalDateTime datumIVreme;
	private float cena;
	private int trajanje;
	
	public Termin() {
		super();
	}

	public Termin(Osoblje lekar, Klinika klinika, LocalDateTime datumIVreme, float cena, int trajanje) {
		super();
		this.lekar = lekar;
		this.klinika = klinika;
		this.datumIVreme = datumIVreme;
		this.cena = cena;
		this.trajanje = trajanje;
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

	public float getCena() {
		return cena;
	}

	public void setCena(float cena) {
		this.cena = cena;
	}

	public int getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(int trajanje) {
		this.trajanje = trajanje;
	}

	@Override
	public String toString() {
		return "Termin [lekar=" + lekar + ", klinika=" + klinika + ", datumIVreme=" + datumIVreme + ", cena=" + cena
				+ ", trajanje=" + trajanje + "]";
	}
}
