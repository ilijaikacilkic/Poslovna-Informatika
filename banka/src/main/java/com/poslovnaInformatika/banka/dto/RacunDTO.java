package com.poslovnaInformatika.banka.dto;

import java.util.Date;

import com.poslovnaInformatika.banka.entity.Racun;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RacunDTO {

	private long id;
	private String brojRacuna;
	private double stanjeRacuna;
	private double rezevisanIznos;
	private Date datumKreiranja;
	private Boolean odobren;
	private Boolean aktivan;

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
		this.odobren = obj.getOdobren();
		this.aktivan = obj.getAktivan();
		if (obj.getBanka() != null)
			this.banka = new BankaDTO(obj.getBanka());
		if (obj.getKlijent() != null)
			this.klijent = new KlijentDTO(obj.getKlijent());
	}

}
