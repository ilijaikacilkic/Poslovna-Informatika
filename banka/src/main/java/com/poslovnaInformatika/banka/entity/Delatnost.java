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
@Table(name = "delatnost")
@Getter
@Setter
public class Delatnost {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	@Column(name = "sifra")
	private String sifra;
	@Column(name = "naziv")
	private String naziv;	
	
	@OneToMany(mappedBy = "delatnost")
	private Set<Klijent> klijenti = new HashSet<Klijent>();
	
	
	public Delatnost() {
		super();
	}
	
	

}
