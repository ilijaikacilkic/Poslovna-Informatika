package com.poslovnaInformatika.banka.dto;

import java.util.Date;

import com.poslovnaInformatika.banka.entity.Racun;

public class RacunDTO {
	
	private long id;
	private String brojRacuna;
	private double stanjeRacuna;
	private double rezevisanIznos;
	private Date datumKreiranja;
	
	private BankaDTO banka;
	
	private KlijentDTO klijent;

	public RacunDTO() {}

	public RacunDTO(Racun obj) {

		this.id = obj.getId();
		this.brojRacuna = obj.getBrojRacuna();
		this.stanjeRacuna = obj.getStanjeRacuna();
		this.rezevisanIznos = obj.getRezevisanIznos();
		this.datumKreiranja = obj.getDatumKreiranja();
		if(obj.getBanka() != null)
			this.banka = new BankaDTO(obj.getBanka());
		if(obj.getKlijent() != null)
			this.klijent = new KlijentDTO(obj.getKlijent());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(String brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public double getStanjeRacuna() {
		return stanjeRacuna;
	}

	public void setStanjeRacuna(double stanjeRacuna) {
		this.stanjeRacuna = stanjeRacuna;
	}

	public double getRezevisanIznos() {
		return rezevisanIznos;
	}

	public void setRezevisanIznos(double rezevisanIznos) {
		this.rezevisanIznos = rezevisanIznos;
	}

	public Date getDatumKreiranja() {
		return datumKreiranja;
	}

	public void setDatumKreiranja(Date datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
	}

	public BankaDTO getBanka() {
		return banka;
	}

	public void setBanka(BankaDTO banka) {
		this.banka = banka;
	}

	public KlijentDTO getKlijent() {
		return klijent;
	}

	public void setKlijent(KlijentDTO klijent) {
		this.klijent = klijent;
	}
	
	
	
	

}
