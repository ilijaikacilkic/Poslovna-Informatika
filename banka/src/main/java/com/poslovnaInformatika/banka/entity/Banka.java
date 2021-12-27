package com.poslovnaInformatika.banka.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Banka {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int sifraBanke;
	private String nazivBanke;
	private String adresa;
	private String telefon;
	private String fax;
	private String swiftKod;
	
	@OneToMany(mappedBy = "banka", cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Set<Racun> racuni = new HashSet<Racun>();
	
	public Banka() {
		super();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getSifraBanke() {
		return sifraBanke;
	}


	public void setSifraBanke(int sifraBanke) {
		this.sifraBanke = sifraBanke;
	}


	public String getNazivBanke() {
		return nazivBanke;
	}


	public void setNazivBanke(String nazivBanke) {
		this.nazivBanke = nazivBanke;
	}


	public String getAdresa() {
		return adresa;
	}


	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}


	public String getTelefon() {
		return telefon;
	}


	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}


	public String getFax() {
		return fax;
	}


	public void setFax(String fax) {
		this.fax = fax;
	}


	public String getSwiftKod() {
		return swiftKod;
	}


	public void setSwiftKod(String swiftKod) {
		this.swiftKod = swiftKod;
	}


	public Set<Racun> getRacuni() {
		return racuni;
	}


	public void setRacuni(Set<Racun> racuni) {
		this.racuni = racuni;
	}
	
	


}
