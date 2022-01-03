package com.poslovnaInformatika.banka.dto;

import java.util.Date;

import com.poslovnaInformatika.banka.entity.Racun;

import lombok.Data;

@Data
public class RacunDTO {

	private long id;
	private String brojRacuna;
	private double stanjeRacuna;
	private double rezevisanIznos;
	private Date datumKreiranja;

	private BankaDTO banka;

	private KlijentDTO klijent;

	public RacunDTO() {
	}

	public RacunDTO(Racun obj) {

		this.id = obj.getId();
		this.brojRacuna = obj.getBrojRacuna();
		this.stanjeRacuna = obj.getStanjeRacuna();
		this.rezevisanIznos = obj.getRezevisanIznos();
		this.datumKreiranja = obj.getDatumKreiranja();
		if (obj.getBanka() != null)
			this.banka = new BankaDTO(obj.getBanka());
		if (obj.getKlijent() != null)
			this.klijent = new KlijentDTO(obj.getKlijent());
	}

}
