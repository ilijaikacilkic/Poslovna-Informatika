package com.poslovnaInformatika.banka.dto;

import com.poslovnaInformatika.banka.entity.Klijent;
import com.poslovnaInformatika.banka.enums.TipKlijenta;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KlijentDTO {
	
	private Long id;
	private String ime;
	private String prezime;
	private String email;
	private String adresa;
	private String telefon;
	private String jmbg;

	private TipKlijenta fizickoLice;
	
	
	public KlijentDTO() {}

	public KlijentDTO(Klijent obj) {
		
		this.id = obj.getId();
		this.ime = obj.getIme();
		this.prezime = obj.getPrezime();
		this.email = obj.getEmail();
		this.adresa = obj.getAdresa();
		this.telefon = obj.getTelefon();
		this.jmbg = obj.getJmbg();
		this.fizickoLice = obj.getFizickoLice();
	}


}
