package com.poslovnaInformatika.banka.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DnevnoStanje {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long id;
	private Date datum ;
	private double predhodnoStanje ;
	private double stanjeUkorist;
	private double stanjeTereta ; 
	private double novoStanje;
	
	
	public DnevnoStanje() {
		
	}
	
	
	
}


//idDnevnoStanje,datum,prethodnostanje,stanje u korist ,stanje tereta , novo stanje
