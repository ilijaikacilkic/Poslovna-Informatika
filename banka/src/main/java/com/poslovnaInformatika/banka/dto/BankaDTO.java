package com.poslovnaInformatika.banka.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.poslovnaInformatika.banka.entity.Banka;
import com.poslovnaInformatika.banka.entity.Racun;

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
	
	List<RacunDTO> racuni = new ArrayList<RacunDTO>();

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
	}


	public void setRacuniListFromSet(Set<Racun> racuni) {
		List<Racun> listaRacuna = new ArrayList<Racun>(racuni);
		for(Racun obj : listaRacuna) {
			this.racuni.add(new RacunDTO(obj));
		}
	}
	
	
	
	
}
