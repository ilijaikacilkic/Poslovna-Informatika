package com.poslovnaInformatika.banka.dto;

import java.util.Date;

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

	public RacunDTO() {}

	
}
