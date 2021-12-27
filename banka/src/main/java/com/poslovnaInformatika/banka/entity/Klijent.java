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
public class Klijent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@OneToMany(mappedBy = "klijent", cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Set<Racun> racuni = new HashSet<Racun>();
	
	public Klijent() {
		super();
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

	public Set<Racun> getRacuni() {
		return racuni;
	}

	public void setRacuni(Set<Racun> racuni) {
		this.racuni = racuni;
	}
	
	
	
	
}
