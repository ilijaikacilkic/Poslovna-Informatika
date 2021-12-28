package com.poslovnaInformatika.banka.dto;

import java.util.ArrayList;
import java.util.List;

import com.poslovnaInformatika.banka.entity.Klijent;

public class KlijentDTO {
	
	private long id;
	private String naziv;
	private String ime;
	private String prezime;
	private String email;
	private String adresa;
	private String telefon;
	private String jmbg;
	private String pib;
	private boolean fizickoLice;
	
	private List<RacunDTO> racuni = new ArrayList<RacunDTO>();
	
	public KlijentDTO() {}

	public KlijentDTO(Klijent obj) {
		super();
		this.id = obj.getId();
		this.naziv = obj.getNaziv();
		this.ime = obj.getIme();
		this.prezime = obj.getPrezime();
		this.email = obj.getEmail();
		this.adresa = obj.getAdresa();
		this.telefon = obj.getTelefon();
		this.jmbg = obj.getJmbg();
		this.pib = obj.getPib();
		this.fizickoLice = obj.isFizickoLice();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public boolean isFizickoLice() {
		return fizickoLice;
	}

	public void setFizickoLice(boolean fizickoLice) {
		this.fizickoLice = fizickoLice;
	}

	public List<RacunDTO> getRacuni() {
		return racuni;
	}

	public void setRacuni(List<RacunDTO> racuni) {
		this.racuni = racuni;
	}
	
	
	
	

}
