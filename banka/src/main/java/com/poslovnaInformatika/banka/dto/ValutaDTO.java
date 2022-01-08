package com.poslovnaInformatika.banka.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.poslovnaInformatika.banka.entity.Racun;
import com.poslovnaInformatika.banka.entity.Transakcija;
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

	private List<RacunDTO> racuni = new ArrayList<RacunDTO>();
	private List<TransakcijaDTO> transakcije = new ArrayList<TransakcijaDTO>();

	public ValutaDTO() {

	}

	public ValutaDTO(Valuta obj) {

		this.id = obj.getId();
		this.naziv = obj.getNaziv();
		this.skraceniNaziv = obj.getSkraceniNaziv();
		this.drzava = obj.getDrzava();
	}

	public void setRacuniListFromSet(Set<Racun> racuni) {
		List<Racun> racun = new ArrayList<Racun>(racuni);
		for (Racun obj : racun)
			this.racuni.add(new RacunDTO(obj));
	}

	public void setTransakcijeListFromSet(Set<Transakcija> transakcije) {
		List<Transakcija> transakcija = new ArrayList<Transakcija>(transakcije);
		for (Transakcija obj : transakcija)
			this.transakcije.add(new TransakcijaDTO(obj));
	}

}
