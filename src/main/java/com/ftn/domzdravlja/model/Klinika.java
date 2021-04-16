package com.ftn.domzdravlja.model;

public class Klinika {

	private int id;
	private String naziv;
	private Adresa adresa;
	private String opis;
	
	public Klinika() {
		
	}

	public Klinika(int id, String naziv, Adresa adresa, String opis) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.opis = opis;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
