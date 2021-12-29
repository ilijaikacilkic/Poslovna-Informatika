package com.poslovnaInformatika.banka.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "valuta")
@Getter
@Setter
public class Valuta {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "naziv")
	private String naziv;
	@Column(name = "skraceniNaziv")
	private String skraceniNaziv;
	@Column(name = "drzava")
	private String drzava;	
	
	
	public Valuta() {
		super();
	}
	
	
}
