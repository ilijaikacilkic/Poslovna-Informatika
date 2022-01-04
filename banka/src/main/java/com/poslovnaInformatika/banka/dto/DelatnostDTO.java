package com.poslovnaInformatika.banka.dto;

import com.poslovnaInformatika.banka.entity.Delatnost;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DelatnostDTO {
	
	private long id;
	private String sifra;
	private String naziv;
	
	public DelatnostDTO() {
		
	}
	
	public DelatnostDTO(Delatnost obj) {

		this.id = obj.getId();
		this.sifra = obj.getSifra();
		this.naziv = obj.getNaziv();
		
	}

}

