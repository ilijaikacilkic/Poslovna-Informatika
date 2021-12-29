package com.poslovnaInformatika.banka.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "racun")
@Getter
@Setter
public class Racun {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "brojRacuna")
	private String brojRacuna;
	@Column(name = "stanjeRacuna")
	private double stanjeRacuna;
	@Column(name = "rezevisanIznos")
	private double rezevisanIznos;
	@Column(name = "datumKreiranja")
	private Date datumKreiranja;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Banka banka;
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Klijent klijent;
	
	public Racun() {
		super();
	}	
	
	
}
