package com.poslovnaInformatika.banka.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "gasenje_racuna")
@Getter
@Setter
public class Gasenje_racuna {
	
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "obrazlozenje")
	private String obrazlozenje;
	
	@Column(name = "datum")
	private Date datum ; 
	
	@Column(name = "zavrseno")
	private boolean zavrseno ;
	
	@OneToOne
	private Racun racun;
	
	@OneToOne
	private Racun racunPremestanje;
	
	public Gasenje_racuna() {
		
	}

}
