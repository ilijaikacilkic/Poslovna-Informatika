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

import com.poslovnaInformatika.banka.enums.TipPoruke;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "poruka")
@Getter
@Setter
public class Poruka {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private TipPoruke tipPoruke;
	private String SwiftDuznikaBanke;
	private String SwiftPrimaocaBanke;
	private String ObracunskiRacunBankeDuznika;
	private String ObracunskiRacunBankePrimaoca;
	private Date datumPoruke;
	@OneToOne
	private Poruka porukaMT;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Transakcija transakcija;
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Banka banka;

	public Poruka() {
		super();
	}
	
	
	
	

}
