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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transakcija")
@Getter
@Setter
public class Transakcija {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "duznik")
	private String duznik;
	@Column(name = "svrhaPlacanja")
	private String svrhaPlacanja;
	@Column(name = "primalac")
	private String primalac;
	@Column(name = "iznos")
	private double iznos;
	@Column(name = "sifraPlacanja")
	private String sifraPlacanja;
	@OneToOne	
	@JsonBackReference
	private Racun racunDuznika;
	@Column(name = "modelDuznika")
	private String modelDuznika;
	@Column(name = "pozivNaBrojDuznika")
	private String pozivNaBrojDuznika;
	@OneToOne
	@JsonBackReference
	private Racun racunPrimaoca;
	@Column(name = "modelPrimaoca")
	private String modelPrimaoca;
	@Column(name = "pozivNaBrojPrimaoca")
	private String pozivNaBrojPrimaoca;
	@Column(name = "hitno")
	private Boolean hitno;
	@Column(name = "datum")
	private Date datum;	
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Valuta valuta;
	

	
	public Transakcija() {
		super();
	}
	

}
