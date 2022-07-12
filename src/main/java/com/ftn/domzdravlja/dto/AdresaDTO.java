package com.ftn.domzdravlja.dto;

import javax.persistence.Column;

import com.ftn.domzdravlja.model.Adresa;

public class AdresaDTO {
     
	private Integer id;
	
	private String ulica;

	private String broj;
	
	private String grad;
	
	private String drzava;
	
	public AdresaDTO() {
		
	}

	public AdresaDTO(Adresa adresa) {
		super();
		this.id = adresa.getId();
		this.ulica = adresa.getUlica();
		this.broj = adresa.getBroj();
		this.grad = adresa.getGrad();
		this.drzava = adresa.getDrzava();
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
	
	

}
