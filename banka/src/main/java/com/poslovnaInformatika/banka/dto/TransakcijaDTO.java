package com.poslovnaInformatika.banka.dto;

import java.util.Date;

import com.poslovnaInformatika.banka.entity.Racun;
import com.poslovnaInformatika.banka.entity.Transakcija;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransakcijaDTO {
	
	
	private long id;	
	private String duznik;
	private String svrhaPlacanja;
	private String primalac;
	private double iznos;
	private String sifraPlacanja;
	private Racun racunDuznika;
	private String modelDuznika;
	private String pozivNaBrojDuznika;
	private Racun racunPrimaoca;
	private String modelPrimaoca;
	private String pozivNaBrojPrimaoca;
	private Boolean hitno;
	private Date datum;
	
	public TransakcijaDTO() {
		
	}
	
	public TransakcijaDTO(Transakcija obj) {

		this.id = obj.getId();
		this.duznik = obj.getDuznik();
		this.svrhaPlacanja = obj.getSvrhaPlacanja();
		this.primalac = obj.getPrimalac();
		this.iznos = obj.getIznos();
		this.sifraPlacanja = obj.getSifraPlacanja();
		this.racunDuznika = obj.getRacunDuznika();
		this.modelDuznika = obj.getModelDuznika();
		this.pozivNaBrojDuznika = obj.getPozivNaBrojDuznika();
		this.racunPrimaoca = obj.getRacunPrimaoca();
		this.modelPrimaoca = obj.getModelPrimaoca();
		this.pozivNaBrojPrimaoca = obj.getPozivNaBrojPrimaoca();
		this.hitno = obj.getHitno();
		this.datum = obj.getDatum();
	}
}
