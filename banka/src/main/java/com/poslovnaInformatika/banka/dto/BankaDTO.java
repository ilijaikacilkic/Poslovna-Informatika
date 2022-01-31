package com.poslovnaInformatika.banka.dto;

import com.poslovnaInformatika.banka.entity.Banka;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BankaDTO {

	private long id;
	private int sifraBanke;
	private String nazivBanke;
	private String adresa;
	private String telefon;
	private String fax;
	private String swiftKod;
	private String obracunskiRacun;
	private String web;
	

	public BankaDTO() {
	}

	public BankaDTO(Banka obj) {

		this.id = obj.getId();
		this.sifraBanke = obj.getSifraBanke();
		this.nazivBanke = obj.getNazivBanke();
		this.adresa = obj.getAdresa();
		this.telefon = obj.getTelefon();
		this.fax = obj.getFax();
		this.swiftKod = obj.getSwiftKod();
		this.obracunskiRacun = obj.getObracunskiRacun();
		this.web = obj.getObracunskiRacun();
	}


	
	
	
}
