package com.poslovnaInformatika.banka.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "dnevnostanje")
public class DnevnoStanje {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long id;
	@Column(name = "datum")
	private Date datum ;
	
	@Column(name = "predhodnoStanje")
	private double predhodnoStanje ;
	
	@Column(name = "stanjeUkorist")
	private double stanjeUkorist;
	
	@Column(name = "stanjeTereta")
	private double stanjeTereta ;
	
	@Column(name = "novoStanje")
	private double novoStanje;
	
	
	public DnevnoStanje() {
		
		
	}
	
	
	
}


//idDnevnoStanje,datum,prethodnostanje,stanje u korist ,stanje tereta , novo stanje
