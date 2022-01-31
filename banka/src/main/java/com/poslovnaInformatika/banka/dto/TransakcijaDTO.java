package com.poslovnaInformatika.banka.dto;

import java.util.Date;

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
	private RacunDTO racunDuznika;
	private String modelDuznika;
	private String pozivNaBrojDuznika;
	private RacunDTO racunPrimaoca;
	private String modelPrimaoca;
	private String pozivNaBrojPrimaoca;
	private Boolean hitno;
	private Date datum;
	private ValutaDTO valuta;

	public TransakcijaDTO() {

	}

	public TransakcijaDTO(Transakcija obj) {

		this.id = obj.getId();
		this.duznik = obj.getDuznik();
		this.svrhaPlacanja = obj.getSvrhaPlacanja();
		this.primalac = obj.getPrimalac();
		this.iznos = obj.getIznos();
		this.sifraPlacanja = obj.getSifraPlacanja();
		if (obj.getRacunDuznika() != null)
			this.racunDuznika = new RacunDTO(obj.getRacunDuznika());
		this.modelDuznika = obj.getModelDuznika();
		this.pozivNaBrojDuznika = obj.getPozivNaBrojDuznika();
		if (obj.getRacunPrimaoca() != null)
			this.racunPrimaoca = new RacunDTO(obj.getRacunPrimaoca());
		this.modelPrimaoca = obj.getModelPrimaoca();
		this.pozivNaBrojPrimaoca = obj.getPozivNaBrojPrimaoca();
		this.hitno = obj.getHitno();
		this.datum = obj.getDatum();
		if (obj.getValuta() != null)
			this.valuta = new ValutaDTO(obj.getValuta());
	}

}
