package com.poslovnaInformatika.banka.dto;

import com.poslovnaInformatika.banka.entity.Delatnost;
import com.poslovnaInformatika.banka.entity.Klijent;
import com.poslovnaInformatika.banka.enums.TipKlijenta;

import lombok.Getter;
import lombok.Setter;

import com.poslovnaInformatika.banka.entity.Korisnik;

@Getter
@Setter
public class RegistracijaDTO {
	
	private long id;
	private String ime;
	private String prezime;
	private String email;
	private String adresa;
	private String telefon;
	private String jmbg;
	private TipKlijenta fizickoLice;
	private Delatnost delatnost;
	private String username;
	private String password;
	
	public RegistracijaDTO() {}
	
	public RegistracijaDTO(Klijent klijent, Korisnik korisnik) {
		super();
		this.id = klijent.getId();
		this.ime = klijent.getIme();
		this.prezime = klijent.getPrezime();
		this.email = klijent.getEmail();
		this.adresa = klijent.getAdresa();
		this.telefon = klijent.getTelefon();
		this.jmbg = klijent.getJmbg();
		this.fizickoLice = klijent.getFizickoLice();
		this.delatnost = klijent.getDelatnost();
		this.username = korisnik.getUsername();
		this.password = korisnik.getPassword();
	}



}
