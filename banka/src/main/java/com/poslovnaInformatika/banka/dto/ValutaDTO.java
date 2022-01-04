package com.poslovnaInformatika.banka.dto;

import com.poslovnaInformatika.banka.entity.Valuta;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValutaDTO {
	
	private long id;
	private String naziv;
	private String skraceniNaziv;
	private String drzava;
	
	public ValutaDTO() {
		
	}
	
	public ValutaDTO(Valuta obj) {

		this.id = obj.getId();
		this.naziv = obj.getNaziv();
		this.skraceniNaziv = obj.getSkraceniNaziv();
		this.drzava = obj.getDrzava();
	}
}
