package com.poslovnaInformatika.banka.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	
	@OneToMany(mappedBy = "valuta")
	private Set<Racun> racuni = new HashSet<Racun>();
	
	@OneToMany(mappedBy = "valuta")
	private Set<Transakcija> transakcije = new HashSet<Transakcija>();
	
	
	public Valuta() {
		super();
	}
	
	
}
