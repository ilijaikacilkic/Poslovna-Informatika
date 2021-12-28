package com.poslovnaInformatika.banka.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Transakcija {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String duznik;
	private String svrhaPlacanja;
	private String primalac;
	private double iznos;
	private String sifraPlacanja;
	@OneToOne
	private Racun racunDuznika;
	private String modelDuznika;
	private String pozivNaBrojDuznika;
	@OneToOne
	private Racun racunPrimaoca;
	private String modelPrimaoca;
	private String pozivNaBrojPrimaoca;
	private Boolean hitno;
	private Date datum;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDuznik() {
		return duznik;
	}
	public void setDuznik(String duznik) {
		this.duznik = duznik;
	}
	public String getSvrhaPlacanja() {
		return svrhaPlacanja;
	}
	public void setSvrhaPlacanja(String svrhaPlacanja) {
		this.svrhaPlacanja = svrhaPlacanja;
	}
	public String getPrimalac() {
		return primalac;
	}
	public void setPrimalac(String primalac) {
		this.primalac = primalac;
	}
	public double getIznos() {
		return iznos;
	}
	public void setIznos(double iznos) {
		this.iznos = iznos;
	}
	public String getSifraPlacanja() {
		return sifraPlacanja;
	}
	public void setSifraPlacanja(String sifraPlacanja) {
		this.sifraPlacanja = sifraPlacanja;
	}
	public Racun getRacunDuznika() {
		return racunDuznika;
	}
	public void setRacunDuznika(Racun racunDuznika) {
		this.racunDuznika = racunDuznika;
	}
	public String getModelDuznika() {
		return modelDuznika;
	}
	public void setModelDuznika(String modelDuznika) {
		this.modelDuznika = modelDuznika;
	}
	public String getPozivNaBrojDuznika() {
		return pozivNaBrojDuznika;
	}
	public void setPozivNaBrojDuznika(String pozivNaBrojDuznika) {
		this.pozivNaBrojDuznika = pozivNaBrojDuznika;
	}
	public Racun getRacunPrimaoca() {
		return racunPrimaoca;
	}
	public void setRacunPrimaoca(Racun racunPrimaoca) {
		this.racunPrimaoca = racunPrimaoca;
	}
	public String getModelPrimaoca() {
		return modelPrimaoca;
	}
	public void setModelPrimaoca(String modelPrimaoca) {
		this.modelPrimaoca = modelPrimaoca;
	}
	public String getPozivNaBrojPrimaoca() {
		return pozivNaBrojPrimaoca;
	}
	public void setPozivNaBrojPrimaoca(String pozivNaBrojPrimaoca) {
		this.pozivNaBrojPrimaoca = pozivNaBrojPrimaoca;
	}
	public Boolean getHitno() {
		return hitno;
	}
	public void setHitno(Boolean hitno) {
		this.hitno = hitno;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	
	public Transakcija() {
		super();
	}
	

}
