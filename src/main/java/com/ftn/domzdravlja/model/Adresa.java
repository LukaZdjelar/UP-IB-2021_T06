package com.ftn.domzdravlja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="adresa")
public class Adresa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="adresa_id", unique=true, nullable=false)
	private Integer id;
	
	@Column(name="ulica", unique=false, nullable=false)
	private String ulica;
	
	@Column(name="broj", unique=false, nullable=false)
	private String broj;
	
	@Column(name="grad", unique=false, nullable=false)
	private String grad;
	
	@Column(name="drzava", unique=false, nullable=false)
	private String drzava;
	
	public Adresa() {
		
	}

	public Adresa(Integer id, String ulica, String broj, String grad, String drzava) {
		super();
		this.id = id;
		this.ulica = ulica;
		this.broj = broj;
		this.grad = grad;
		this.drzava = drzava;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getBroj() {
		return broj;
	}

	public void setBroj(String broj) {
		this.broj = broj;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	@Override
	public String toString() {
		return "Adresa [ulica=" + ulica + ", broj=" + broj + ", grad=" + grad + ", drzava=" + drzava + "]";
	}
	
}
