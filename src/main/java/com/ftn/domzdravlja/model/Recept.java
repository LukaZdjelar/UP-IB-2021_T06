package com.ftn.domzdravlja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "recept")
public class Recept {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="recept_id", unique=true, nullable=false)
	private Integer id;
	
	@Column(name = "text", unique = false, nullable = false)
	private String text;
	
	@Column(name = "overen", unique = false, nullable = false)
	private boolean overen;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "pregled_id", nullable = false)
	@JsonIgnore
	private Pregled pregled;

	public Recept(Integer id, String text, boolean overen) {
		super();
		this.text = text;
		this.overen = overen;
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

	public Pregled getPregled() {
		return pregled;
	}

	public void setPregled(Pregled pregled) {
		this.pregled = pregled;
	}

	@Override
	public String toString() {
		return "Recept [id=" + id + ", text=" + text + ", overen=" + overen + ", pregled=" + pregled + "]";
	}
	
	
}
