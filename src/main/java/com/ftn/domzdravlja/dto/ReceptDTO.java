package com.ftn.domzdravlja.dto;

import com.ftn.domzdravlja.model.Recept;

public class ReceptDTO {

	private Integer id;
	private String text;
	private boolean overen;
	
	public ReceptDTO(Recept recept) {
		id = recept.getId();
		text = recept.getText();
		overen = recept.isOveren();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isOveren() {
		return overen;
	}

	public void setOveren(boolean overen) {
		this.overen = overen;
	}
	
	
}
