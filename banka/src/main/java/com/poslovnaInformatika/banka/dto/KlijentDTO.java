package com.poslovnaInformatika.banka.dto;

import java.util.ArrayList;
import java.util.List;

import com.poslovnaInformatika.banka.entity.Klijent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
